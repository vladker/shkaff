package ru.vldkr.shkaff.data

import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import ru.vldkr.shkaff.data.db.AttributeDefEntity
import ru.vldkr.shkaff.data.db.ItemEntity
import ru.vldkr.shkaff.di.Deps

// T-014 (US-I2): «Оценка атрибутов по фото». AttributeEstimate.parse отдаёт СЫРЫЕ ключи модели
// («Цвет», «COLOR», …), а ItemRepository.applyAttributes пишет их в attributes как есть.
// Форма рендерит только поля словаря attribute_def, поэтому такие значения невидимы пользователю.
// Контракт (маппинг — на уровне applyAttributes, единственный путь записи предложений ИИ):
// ключ маппится через словарь, неизвестное дописывается в описание (прецедент ItemForm.applySmartField).
@RunWith(RobolectricTestRunner::class)
class AiAttributesMappingTest {
    private fun rid(p: String) = "$p-" + System.nanoTime()

    @Before
    fun setup() {
        // Robolectric-sandbox делит БД между классами — чистим и сажаем свой словарь.
        runBlocking { Deps.db.clearAllTables() }
        runBlocking {
            Deps.db.attributeDao().upsert(
                AttributeDefEntity(
                    id = rid("t014-def"),
                    scope = "item",
                    key = "color",
                    label = "Цвет",
                    type = "text",
                    created_at = 0,
                    updated_at = 0,
                    device_last_modified = Deps.deviceId,
                ),
            )
        }
    }

    private fun item(
        description: String = "",
        attributes: String = "{}",
    ): ItemEntity {
        val e =
            ItemEntity(
                id = rid("t014-item"),
                name = "Куртка",
                code = rid("t014-code"),
                description = description,
                attributes = attributes,
                photo_path = null,
                location_id = null,
                created_at = 0,
                updated_at = 1_000,
                deleted_at = null,
                device_last_modified = Deps.deviceId,
            )
        runBlocking { Deps.db.itemDao().upsert(e) }
        return e
    }

    private fun stored(id: String): ItemEntity = runBlocking { Deps.db.itemDao().byId(id) }!!

    @Test
    fun `сырой ключ по label словаря маппится в ключ словаря`() {
        val it = item()
        runBlocking { Deps.items.applyAttributes(it.id, mapOf("Цвет" to "синий")) }
        assertEquals(
            "в attributes должен быть ровно один ключ словаря",
            mapOf("color" to "синий"),
            AttrJson.toMap(stored(it.id).attributes),
        )
    }

    @Test
    fun `матч по ключу и label игнорируя регистр и пробелы`() {
        for (raw in listOf("COLOR", "цвет", " Цвет ")) {
            val it = item()
            runBlocking { Deps.items.applyAttributes(it.id, mapOf(raw to "синий")) }
            assertEquals(
                "сырой ключ «$raw» должен маппиться в color",
                mapOf("color" to "синий"),
                AttrJson.toMap(stored(it.id).attributes),
            )
        }
    }

    @Test
    fun `неизвестный атрибут не теряется и уходит в описание`() {
        val it = item()
        runBlocking { Deps.items.applyAttributes(it.id, mapOf("влагостойкость" to "да")) }
        val after = stored(it.id)
        assertFalse(
            "неизвестный ключ не должен попадать в attributes: " + AttrJson.toMap(after.attributes),
            AttrJson.toMap(after.attributes).containsKey("влагостойкость"),
        )
        assertTrue(
            "значение должно дописаться в описание, получено «${after.description}»",
            after.description.contains("влагостойкость: да", ignoreCase = true),
        )
    }

    @Test
    fun `неизвестный атрибут не дублируется если label уже в описании`() {
        val it = item(description = "Влагостойкость: нет")
        runBlocking { Deps.items.applyAttributes(it.id, mapOf("влагостойкость" to "да")) }
        val after = stored(it.id)
        assertFalse(
            "неизвестный ключ не должен попадать в attributes",
            AttrJson.toMap(after.attributes).containsKey("влагостойкость"),
        )
        assertEquals(
            "label уже есть в описании — строку нельзя дублировать, получено «${after.description}»",
            1,
            after.description.lines().count { it.contains("влагостойкость", ignoreCase = true) },
        )
    }

    @Test
    fun `ключ равный ключу словаря пишется как есть и updated_at растёт`() {
        val it = item()
        runBlocking { Deps.items.applyAttributes(it.id, mapOf("color" to "синий")) }
        val after = stored(it.id)
        assertEquals(mapOf("color" to "синий"), AttrJson.toMap(after.attributes))
        assertTrue("updated_at обязан вырасти — от него зависит LWW слияния", after.updated_at > it.updated_at)
    }
}
