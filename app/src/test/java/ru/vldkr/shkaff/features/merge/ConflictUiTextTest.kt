package ru.vldkr.shkaff.features.merge

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import ru.vldkr.shkaff.data.db.BasketEntity
import ru.vldkr.shkaff.data.db.BasketItemEntity
import ru.vldkr.shkaff.data.db.LoanEntity
import ru.vldkr.shkaff.data.db.StackEntity
import ru.vldkr.shkaff.data.db.StackMemberEntity
import ru.vldkr.shkaff.data.db.TagEntity
import ru.vldkr.shkaff.data.db.UserEntity

// T-066: карточки конфликтов 7 таблиц были без полей и с латинским именем таблицы.
@RunWith(RobolectricTestRunner::class)
class ConflictUiTextTest {

    @Test
    fun titlesLocalizedForEveryConflictingTable() {
        val tables = listOf(
            "label_docs", "items", "storages", "locations", "attribute_defs", "annotations",
            "label_templates", "printers", "tags", "users", "loans", "stacks",
            "stack_members", "baskets", "basket_items"
        )
        for (t in tables) {
            val title = tableTitle(t)
            assertTrue("пустой заголовок для $t", title.isNotBlank())
            assertNotEquals("латинское имя таблицы в UI: $t", t, title)
        }
        // зафиксировать формулировки новых таблиц
        assertEquals("Тег", tableTitle("tags"))
        assertEquals("Профиль", tableTitle("users"))
        assertEquals("Выдача", tableTitle("loans"))
        assertEquals("Набор", tableTitle("stacks"))
        assertEquals("Состав набора", tableTitle("stack_members"))
        assertEquals("Корзина", tableTitle("baskets"))
        assertEquals("Позиция корзины", tableTitle("basket_items"))
    }

    @Test
    fun tagConflictCardHasFields() {
        val fields = fieldsOf(
            TagEntity(id = "t1", name = "гараж", created_at = 1000L),
            TagEntity(id = "t1", name = "гаражный", created_at = 1000L),
            emptyMap()
        )
        assertTrue("нет полей у тега", fields.isNotEmpty())
        val text = fields.joinToString(";") { "${it.first}|${it.second}|${it.third}" }
        assertTrue(text.contains("гараж"))
        assertTrue(text.contains("гаражный"))
    }

    @Test
    fun userConflictCardHasFields() {
        val fields = fieldsOf(
            UserEntity(id = "u1", name = "Анна", role = "admin", created_at = 1000L, updated_at = 1000L),
            UserEntity(id = "u1", name = "Пётр", role = "add", created_at = 1000L, updated_at = 1000L),
            emptyMap()
        )
        assertTrue(fields.isNotEmpty())
        val text = fields.joinToString(";") { "${it.first}|${it.second}|${it.third}" }
        assertTrue(text.contains("Анна"))
        assertTrue(text.contains("Пётр"))
        assertTrue(text.contains("admin"))
        assertTrue(text.contains("add"))
    }

    @Test
    fun loanConflictCardHasFields() {
        val fields = fieldsOf(
            LoanEntity(id = "l1", entity_type = "item", entity_id = "i9", borrower = "Анна", note = "", lent_at = 1000L, created_at = 1000L, updated_at = 1000L),
            LoanEntity(id = "l1", entity_type = "item", entity_id = "i9", borrower = "Борис", note = "до пятницы", lent_at = 1000L, created_at = 1000L, updated_at = 1000L),
            emptyMap()
        )
        assertTrue(fields.isNotEmpty())
        val text = fields.joinToString(";") { "${it.first}|${it.second}|${it.third}" }
        assertTrue(text.contains("Анна"))
        assertTrue(text.contains("Борис"))
        assertTrue(text.contains("до пятницы"))
    }

    @Test
    fun stackConflictCardHasFields() {
        val fields = fieldsOf(
            StackEntity(id = "s1", name = "Набор А", code = "AAA", created_at = 1000L, updated_at = 1000L),
            StackEntity(id = "s1", name = "Набор Б", code = "BBB", created_at = 1000L, updated_at = 1000L),
            emptyMap()
        )
        assertTrue(fields.isNotEmpty())
        val text = fields.joinToString(";") { "${it.first}|${it.second}|${it.third}" }
        assertTrue(text.contains("Набор А"))
        assertTrue(text.contains("Набор Б"))
        assertTrue(text.contains("AAA"))
        assertTrue(text.contains("BBB"))
    }

    @Test
    fun stackMemberConflictCardHasFields() {
        val fields = fieldsOf(
            StackMemberEntity(id = "m1", stack_id = "s1", entity_type = "item", entity_id = "i9", sort_order = 1, created_at = 1000L, updated_at = 1000L),
            StackMemberEntity(id = "m1", stack_id = "s1", entity_type = "item", entity_id = "i9", sort_order = 7, created_at = 1000L, updated_at = 1000L),
            emptyMap()
        )
        assertTrue(fields.isNotEmpty())
        val text = fields.joinToString(";") { "${it.first}|${it.second}|${it.third}" }
        assertTrue(text.contains("1"))
        assertTrue(text.contains("7"))
        assertTrue(text.contains("i9"))
    }

    @Test
    fun basketConflictCardHasFields() {
        val fields = fieldsOf(
            BasketEntity(id = "b1", name = "Ремонт", status = "active", created_at = 1000L, updated_at = 1000L),
            BasketEntity(id = "b1", name = "Дача", status = "done", created_at = 1000L, updated_at = 1000L),
            emptyMap()
        )
        assertTrue(fields.isNotEmpty())
        val text = fields.joinToString(";") { "${it.first}|${it.second}|${it.third}" }
        assertTrue(text.contains("Ремонт"))
        assertTrue(text.contains("Дача"))
    }

    @Test
    fun basketItemConflictCardHasFields() {
        val fields = fieldsOf(
            BasketItemEntity(id = "bi1", basket_id = "b1", item_id = "i9", picked_ts = null, created_at = 1000L, updated_at = 1000L),
            BasketItemEntity(id = "bi1", basket_id = "b1", item_id = "i9", picked_ts = 500L, created_at = 1000L, updated_at = 1000L),
            emptyMap()
        )
        assertTrue(fields.isNotEmpty())
        val text = fields.joinToString(";") { "${it.first}|${it.second}|${it.third}" }
        assertTrue(text.contains("i9"))
    }
}
