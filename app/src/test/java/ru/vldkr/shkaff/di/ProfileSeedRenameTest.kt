package ru.vldkr.shkaff.di

import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import ru.vldkr.shkaff.data.db.SchemaMetaEntity
import ru.vldkr.shkaff.domain.access.Role

// П4.4: сидимый профиль «Админ» пугает несведущих — сидим «Я». Старые установки
// чиним однократным переименованием (meta-флаг), кастомные имена не трогаем.
@RunWith(RobolectricTestRunner::class)
class ProfileSeedRenameTest {

    @Test
    fun `seeded profile is named Я, not Админ`() = runBlocking {
        Deps.db.clearAllTables()
        Deps.seedDefaultProfile()
        val u = Deps.users.activeUser()
        assertEquals("сид должен называться «Я»", "Я", u?.name)
        assertEquals("роль сида — администратор", Role.ADMIN.preset, u?.role)
    }

    @Test
    fun `legacy Админ переименовывается в Я один раз`() = runBlocking {
        Deps.db.clearAllTables()
        val legacy = Deps.users.create("Админ", Role.ADMIN)
        Deps.renameLegacyAdminOnce()
        val after = Deps.users.byId(legacy.id)!!
        assertEquals("имя legacy-сида стало «Я»", "Я", after.name)
        assertEquals("роль сохранилась", Role.ADMIN.preset, after.role)
        assertEquals("флаг однократности выставлен", "1", Deps.db.metaDao().get("adminProfileRenamed"))

        // Повторный вызов (например, после нового пира/бэкапа) ничего не делает.
        Deps.users.update(legacy.id, "Маша", Role.ADMIN)
        Deps.renameLegacyAdminOnce()
        assertEquals("повтор не переименовывает снова", "Маша", Deps.users.byId(legacy.id)!!.name)
    }

    @Test
    fun `кастомные имена не трогаем`() = runBlocking {
        Deps.db.clearAllTables()
        val m = Deps.users.create("Маша", Role.VIEW)
        Deps.db.metaDao().upsert(SchemaMetaEntity("adminProfileRenamed", "0"))
        Deps.renameLegacyAdminOnce()
        assertEquals("«Маша» остаётся «Маша»", "Маша", Deps.users.byId(m.id)!!.name)
    }

    @Test
    fun `переименование поднимает updated_at — LWW донесёт его до других устройств`() = runBlocking {
        Deps.db.clearAllTables()
        val legacy = Deps.users.create("Админ", Role.ADMIN)
        Deps.db.metaDao().upsert(SchemaMetaEntity("adminProfileRenamed", "0"))
        Thread.sleep(5)
        Deps.renameLegacyAdminOnce()
        val after = Deps.users.byId(legacy.id)!!
        org.junit.Assert.assertTrue("updated_at обязан вырасти", after.updated_at > legacy.updated_at)
    }
}
