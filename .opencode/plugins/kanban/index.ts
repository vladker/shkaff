import { Plugin } from "@opencode/plugin"
import { existsSync, readdirSync, readFileSync, writeFileSync } from "node:fs"
import { join } from "node:path"

// Kanban-борд .pi/kanban (см. AGENTS.md): карточки — markdown-файлы tasks/T-NNNN.md
// со YAML-frontmatter (id/title/status/rev/created/updated/history/assignee) и телом.
// kanban.db пуст, источник истины — именно .md. Плагин правит их line-based, чтобы
// сохранять неизвестные поля и тело байт-в-байт (EOL сохраняется).

interface Card {
  path: string
  id: string
  title: string
  status: string
  assignee?: string
  rev: number
  lines: string[] // весь файл построчно
  fmStart: number // индекс строки "---" в начале
  fmEnd: number // индекс закрывающего "---"
  eol: string
}

function boardDir(dir: string): string {
  const p = join(dir, ".pi", "kanban")
  if (!existsSync(join(p, "tasks"))) throw new Error(`Борд не найден: ${join(p, "tasks")} (cwd: ${dir})`)
  return p
}

function normId(id: string): string {
  const m = id.trim().toUpperCase().match(/^T-?0*(\d+)$/)
  if (!m) throw new Error(`Некорректный id карточки: ${id} (ожидается T-NNNN)`)
  return `T-${m[1].padStart(4, "0")}`
}

function parseCard(dir: string, id: string): Card {
  const path = join(dir, "tasks", `${normId(id)}.md`)
  if (!existsSync(path)) throw new Error(`Карточка ${normId(id)} не найдена: ${path}`)
  const raw = readFileSync(path, "utf8")
  const eol = raw.includes("\r\n") ? "\r\n" : "\n"
  const lines = raw.split(/\r?\n/)
  if (lines[0]?.trim() !== "---") throw new Error(`Нет YAML-frontmatter: ${path}`)
  const fmEnd = lines.findIndex((l, i) => i > 0 && l.trim() === "---")
  if (fmEnd < 0) throw new Error(`Frontmatter не закрыт: ${path}`)
  const get = (field: string): string | undefined => {
    const l = lines.find((x) => new RegExp(`^${field}:`).test(x))
    return l?.slice(field.length + 1).trim().replace(/^"(.*)"$/, "$1")
  }
  const card: Card = {
    path,
    id: get("id") ?? normId(id),
    title: get("title") ?? "",
    status: get("status") ?? "?",
    assignee: get("assignee"),
    rev: Number(get("rev") ?? 0),
    lines,
    fmStart: 0,
    fmEnd,
    eol,
  }
  return card
}

function saveCard(c: Card): void {
  writeFileSync(c.path, c.lines.join(c.eol), "utf8")
}

// Значение YAML: безопасные скаляры — без кавычек, остальные — двойные (JSON-escape
// совместим с YAML double-quoted).
function yamlVal(v: string | number | boolean): string {
  const s = String(v)
  if (typeof v !== "string" || /^[A-Za-z0-9_.:/\-]+$/.test(s)) return s
  return JSON.stringify(s)
}

function entryLines(e: Record<string, string | number | boolean>): string[] {
  const out = [`  - at: ${e.at}`]
  for (const k of ["action", "by", "from", "to", "assignee", "forced", "reason"]) {
    if (e[k] !== undefined) out.push(`    ${k}: ${yamlVal(e[k])}`)
  }
  return out
}

function editFrontmatter(c: Card, opts: {
  status?: string
  assignee?: string | null // null — снять assignee
  entries: Record<string, string | number | boolean>[]
}): void {
  const now = new Date().toISOString()
  let out: string[] = []
  for (let i = 1; i < c.fmEnd; i++) {
    const l = c.lines[i]
    if (/^status:/.test(l) && opts.status) { out.push(`status: ${opts.status}`); continue }
    if (/^updated:/.test(l)) { out.push(`updated: ${now}`); continue }
    if (/^rev:/.test(l)) { out.push(`rev: ${c.rev + 1}`); continue }
    if (/^assignee:/.test(l)) {
      if (opts.assignee === null) continue
      if (opts.assignee) { out.push(`assignee: ${yamlVal(opts.assignee)}`); continue }
    }
    out.push(l)
  }
  // history: вставляем записи в конец блока history: (или создаём блок перед "---")
  const hIdx = out.findIndex((l) => l === "history:")
  const insertAt = (() => {
    if (hIdx < 0) return out.length
    let j = hIdx + 1
    while (j < out.length && (/^\s+\S/.test(out[j]) || out[j] === "")) {
      // пустые строки внутри frontmatter не встречаются; страховка от проглатывания assignee
      if (/^[a-z]/.test(out[j])) break
      j++
    }
    while (j > hIdx + 1 && out[j - 1] === "") j--
    return j
  })()
  const entries: string[] = []
  for (const e of opts.entries) {
    entries.push(...entryLines({ at: now, ...e }))
  }
  if (hIdx < 0) entries.unshift("history:")
  out.splice(insertAt, 0, ...entries)
  if (opts.assignee && !out.some((l) => /^assignee:/.test(l))) out.push(`assignee: ${yamlVal(opts.assignee)}`)
  c.lines = [...c.lines.slice(0, 1), ...out, ...c.lines.slice(c.fmEnd)]
}

interface Workflow {
  active: Set<string>
  terminal: Set<string>
  transitions: Map<string, string[]>
}

function loadWorkflow(dir: string): Workflow {
  const wf = { active: new Set<string>(), terminal: new Set<string>(), transitions: new Map<string, string[]>() }
  const raw = readFileSync(join(dir, "workflow.yaml"), "utf8")
  let section = ""
  let curStatus = ""
  for (const line of raw.split(/\r?\n/)) {
    const st = line.match(/^\s+- id: (\w+)/)
    if (section === "statuses:" && st) { curStatus = st[1]; continue }
    if (section === "statuses:" && curStatus && /^\s+active: true/.test(line)) wf.active.add(curStatus)
    if (section === "statuses:" && curStatus && /^\s+terminal: true/.test(line)) wf.terminal.add(curStatus)
    const tr = line.match(/^\s+(\w+): \[([\w, ]*)\]/)
    if (tr) wf.transitions.set(tr[1], tr[2].split(",").map((s) => s.trim()).filter(Boolean))
    if (/^\S/.test(line)) { section = line.trim(); curStatus = "" }
  }
  return wf
}

function json(obj: unknown): { content: string } {
  return { content: JSON.stringify(obj, null, 1) }
}

export default Plugin.define({
  id: "kanban",
  async setup(ctx) {
    const dir = boardDir(ctx.location.directory)

    await ctx.tool.transform((editor) => {
      editor.add({
        name: "kanban_list",
        description: "Список карточек борда .pi/kanban (фильтры: status, assignee)",
        options: { codemode: false },
        input: {
          type: "object",
          properties: {
            status: { type: "string", description: "new | doing | waiting_device | done (пусто — все)" },
            assignee: { type: "string" },
            limit: { type: "number", description: "максимум карточек, по умолчанию 100" },
          },
          additionalProperties: false,
        },
        execute: async (input: { status?: string; assignee?: string; limit?: number }) => {
          const files = readdirSync(join(dir, "tasks")).filter((f) => f.endsWith(".md")).sort()
          const tasks: { id: string; status: string; assignee?: string; title: string }[] = []
          for (const f of files) {
            const c = parseCard(dir, f.replace(/\.md$/, ""))
            if (input.status && c.status !== input.status) continue
            if (input.assignee && c.assignee !== input.assignee) continue
            tasks.push({ id: c.id, status: c.status, assignee: c.assignee, title: c.title })
            if (tasks.length >= (input.limit ?? 100)) break
          }
          return json({ total: tasks.length, tasks })
        },
      })

      editor.add({
        name: "kanban_get",
        description: "Полное содержимое карточки борда (frontmatter + тело с комментариями)",
        options: { codemode: false },
        input: {
          type: "object",
          properties: { id: { type: "string", description: "T-NNNN" } },
          required: ["id"],
          additionalProperties: false,
        },
        execute: async (input: { id: string }) => json({ card: parseCard(dir, input.id).lines.join("\n") }),
      })

      editor.add({
        name: "kanban_take",
        description: "Захват карточки воркером: new→doing+assign или assign активной; занятой другой — только force:true",
        options: { codemode: false },
        input: {
          type: "object",
          properties: {
            id: { type: "string", description: "T-NNNN" },
            agent: { type: "string", description: "имя воркера (by/assignee)" },
            force: { type: "boolean", description: "перехватить у другого воркера (force-assign)" },
          },
          required: ["id", "agent"],
          additionalProperties: false,
        },
        execute: async (input: { id: string; agent: string; force?: boolean }) => {
          const c = parseCard(dir, input.id)
          const wf = loadWorkflow(dir)
          if (c.assignee === input.agent && wf.active.has(c.status)) {
            return json({ ok: true, unchanged: true, id: c.id, status: c.status, assignee: c.assignee })
          }
          if (c.status === "new") {
            editFrontmatter(c, {
              status: "doing",
              assignee: input.agent,
              entries: [
                { action: "move", by: input.agent, from: "new", to: "doing" },
                { action: "assign", by: input.agent, assignee: input.agent },
              ],
            })
            saveCard(c)
            return json({ ok: true, id: c.id, status: "doing", assignee: input.agent, rev: c.rev + 1 })
          }
          if (!wf.active.has(c.status)) {
            throw new Error(`Карточка ${c.id} в статусе ${c.status} — сначала kanban_move в doing`)
          }
          if (c.assignee && c.assignee !== input.agent && !input.force) {
            throw new Error(`Карточка ${c.id} занята ${c.assignee} (нужен force:true для перехвата)`)
          }
          const forced = Boolean(c.assignee && c.assignee !== input.agent)
          editFrontmatter(c, {
            assignee: input.agent,
            entries: forced
              ? [{ action: "force-assign", by: input.agent, assignee: input.agent, forced: true, reason: input.force ? "Перехват force:true" : undefined }]
              : [{ action: "assign", by: input.agent, assignee: input.agent }],
          })
          saveCard(c)
          return json({ ok: true, id: c.id, status: c.status, assignee: input.agent, forced, rev: c.rev + 1 })
        },
      })

      editor.add({
        name: "kanban_move",
        description: "Переход карточки в другой статус по workflow.yaml (new→doing→waiting_device/done); на done/new — снимает assignee",
        options: { codemode: false },
        input: {
          type: "object",
          properties: {
            id: { type: "string", description: "T-NNNN" },
            to: { type: "string", description: "целевой статус" },
            reason: { type: "string", description: "причина перехода (в историю)" },
            by: { type: "string", description: "кто двигает (по умолчанию opencode-main)" },
          },
          required: ["id", "to"],
          additionalProperties: false,
        },
        execute: async (input: { id: string; to: string; reason?: string; by?: string }) => {
          const c = parseCard(dir, input.id)
          const wf = loadWorkflow(dir)
          const by = input.by ?? "opencode-main"
          const allowed = wf.transitions.get(c.status) ?? []
          if (!allowed.includes(input.to)) {
            throw new Error(`Переход ${c.status} → ${input.to} запрещён workflow.yaml (разрешено: ${allowed.join(", ") || "нет"})`)
          }
          const entries: Record<string, string | number | boolean>[] = [
            { action: "move", by, from: c.status, to: input.to, reason: input.reason },
          ]
          const clearAssignee = wf.terminal.has(input.to) || input.to === "new"
          if (clearAssignee && c.assignee) entries.push({ action: "unassign", by, assignee: c.assignee })
          editFrontmatter(c, {
            status: input.to,
            assignee: clearAssignee ? null : undefined,
            entries,
          })
          saveCard(c)
          return json({ ok: true, id: c.id, from: c.status, to: input.to, rev: c.rev + 1 })
        },
      })

      editor.add({
        name: "kanban_comment",
        description: "Комментарий в тело карточки (<!-- kanban:comment -->); frontmatter не трогает",
        options: { codemode: false },
        input: {
          type: "object",
          properties: {
            id: { type: "string", description: "T-NNNN" },
            text: { type: "string" },
            by: { type: "string", description: "автор (по умолчанию opencode-main)" },
          },
          required: ["id", "text"],
          additionalProperties: false,
        },
        execute: async (input: { id: string; text: string; by?: string }) => {
          const c = parseCard(dir, input.id)
          const at = new Date().toISOString()
          const body = c.lines.slice(c.fmEnd + 1)
          while (body.length && body[body.length - 1] === "") body.pop()
          body.push("", `<!-- kanban:comment at=${at} by=${input.by ?? "opencode-main"} -->`, input.text.replace(/\r/g, ""))
          c.lines = [...c.lines.slice(0, c.fmEnd + 1), ...body]
          saveCard(c)
          return json({ ok: true, id: c.id, at })
        },
      })
    })
  },
})
