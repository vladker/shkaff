package ru.vldkr.shkaff.domain.actions

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test
import ru.vldkr.shkaff.data.db.ItemEntity
import ru.vldkr.shkaff.data.db.LocationEntity
import ru.vldkr.shkaff.domain.links.AppLink

// П3.1: перекладка по скану (WMS scan-как-валидация). Разрешение сканированного
// кода в сущность и текст подтверждения — чистый Kotlin, без Android.
class RelocationTest {

    private val now = 1_700_000_000_000L

    private fun item(
        id: String,
        code: String = "",
        name: String = "Вещь $id",
        ean: String? = null,
        deleted: Boolean = false
    ) = ItemEntity(
        id = id, name = name, code = code, description = "", attributes = "{}",
        photo_path = null, location_id = null,
        created_at = now, updated_at = now, deleted_at = if (deleted) now else null,
        device_last_modified = "dev", ean = ean
    )

    private fun loc(
        id: String,
        label: String = "",
        name: String = "Ящик $id",
        deleted: Boolean = false
    ) = LocationEntity(
        id = id, storage_id = "s1", label = label, name = name,
        created_at = now, updated_at = now, deleted_at = if (deleted) now else null
    )

    // ——— ключ объекта из любого вида кода ———

    @Test
    fun `key from service code is its entity id`() {
        val ulid = "01J5Z3VXQ8K2M9R4TN6WYHBCDE"
        val raw = ActionCode.encode(ActionCode.Verb.ADD, "item", ulid)
        assertEquals(ulid, Relocation.keyOf(raw))
    }

    @Test
    fun `key from deep link is its code`() {
        assertEquals("1234567890123", Relocation.keyOf(AppLink.urlFor("1234567890123")))
    }

    @Test
    fun `plain code is its own key and entity-less service code has no key`() {
        assertEquals("DR-01", Relocation.keyOf("DR-01"))
        assertEquals("", Relocation.keyOf(ActionCode.encode(ActionCode.Verb.MOVE)))
    }

    // ——— разрешение по ключу (id, код, EAN/метка; удалённые невидимы) ———

    @Test
    fun `item resolves by id code or ean, deleted invisible`() {
        val items = listOf(
            item("i1", code = "01J5Z3VXQ8K2M9R4TN6WYHBCDE"),
            item("i2", code = "DR-01", ean = "4600000000001"),
            item("i3", code = "GONE", deleted = true)
        )
        assertEquals("i1", Relocation.resolveItem(Relocation.keyOf(ActionCode.encode(ActionCode.Verb.ADD, "item", "01J5Z3VXQ8K2M9R4TN6WYHBCDE")), items)?.id)
        assertEquals("i2", Relocation.resolveItem("DR-01", items)?.id)
        assertEquals("i2", Relocation.resolveItem("4600000000001", items)?.id)
        assertNull(Relocation.resolveItem("GONE", items))
        assertNull(Relocation.resolveItem("нет-такого", items))
        assertNull(Relocation.resolveItem("", items))
    }

    @Test
    fun `location resolves by id or label, deleted invisible`() {
        val locs = listOf(loc("l1", label = "01J5ABCDEF0123456789ABCD"), loc("l2", label = "Ящик A"), loc("l3", label = "GONE", deleted = true))
        assertEquals("l1", Relocation.resolveLocation(Relocation.keyOf(ActionCode.encode(ActionCode.Verb.ADD, "location", "01J5ABCDEF0123456789ABCD")), locs)?.id)
        assertEquals("l2", Relocation.resolveLocation("Ящик A", locs)?.id)
        assertNull(Relocation.resolveLocation("GONE", locs))
        assertNull(Relocation.resolveLocation("l3", locs))
    }

    // ——— сессия перекладки: вещь → ящик → подтверждение ———

    @Test
    fun `flow walks item then location then confirm`() {
        val items = listOf(item("i1", code = "ITEM-ULID", name = "Гитара"))
        val locs = listOf(loc("l1", label = "Ящик A"))
        val f = RelocationFlow()
        assertEquals(RelocationFlow.STEP_ITEM, f.step)

        assertFalse(f.scanItem("нет-такого", items))
        assertEquals(RelocationFlow.STEP_ITEM, f.step)

        assertTrue(f.scanItem("ITEM-ULID", items))
        assertEquals(RelocationFlow.STEP_LOCATION, f.step)
        assertNull(f.location)

        assertFalse(f.scanLocation("Ящик Б", locs))
        assertEquals(RelocationFlow.STEP_LOCATION, f.step)

        assertTrue(f.scanLocation("Ящик A", locs))
        assertEquals(RelocationFlow.STEP_CONFIRM, f.step)
        assertEquals("l1", f.location?.id)
    }

    @Test
    fun `confirm text names both objects`() {
        val f = RelocationFlow()
        f.scanItem("ITEM-ULID", listOf(item("i1", code = "ITEM-ULID", name = "Гитара")))
        f.scanLocation("Ящик A", listOf(loc("l1", label = "Ящик A")))
        assertEquals("Кладем «Гитара» в «Ящик A»?", f.confirmText())
    }

    @Test
    fun `confirm text falls back to location name when label empty`() {
        val f = RelocationFlow()
        f.scanItem("i1", listOf(item("i1", name = "Гитара")))
        f.scanLocation("l1", listOf(loc("l1", label = "", name = "Стеллаж 3")))
        assertEquals("Кладем «Гитара» в «Стеллаж 3»?", f.confirmText())
    }

    @Test
    fun `rescan of item replaces it and reset clears everything`() {
        val items = listOf(item("i1", code = "A"), item("i2", code = "B"))
        val f = RelocationFlow()
        assertTrue(f.scanItem("A", items))
        assertTrue(f.scanItem("B", items)) // второй скан вещи — уточнили выбор
        f.reset()
        assertEquals(RelocationFlow.STEP_ITEM, f.step)
        assertNull(f.item)
        assertNull(f.location)
    }

    @Test
    fun `clearLocation returns to the box step keeping the item`() {
        // П3.3: «полный» ящик отклонён гейтом — шаг выбора ящика повторяется, вещь помним.
        val f = RelocationFlow()
        f.scanItem("i1", listOf(item("i1")))
        f.scanLocation("l1", listOf(loc("l1", label = "Ящик A")))
        f.clearLocation()
        assertEquals(RelocationFlow.STEP_LOCATION, f.step)
        assertEquals("i1", f.item?.id)
        assertNull(f.location)
    }
}
