package ru.vldkr.shkaff.domain.scan

import org.junit.Assert.assertEquals
import org.junit.Test

// T-058: HID-скан на экранах, которые сами не потребляют ScanBus, обязан
// маршрутизироваться — код открывается в «Вещах» поиском. Экраны-потребители
// (живая подписка или взятие lastCode по кнопке) глобальный подписчик не трогает.
class ScanRoutingTest {

    @Test
    fun `нейтральные экрансы маршрутизируют код в Вещи`() {
        for (route in listOf(
            "dashboard",
            "settings",
            "profiles",
            "storages",
            "storage/{id}",
            "location/{id}",
            "item/{id}",
            "products",
            "agent",
            "backup",
            "stacks",
            "basket",
        )) {
            assertEquals("route=$route", ScanRoute.OpenItems, ScanRouting.routeFor(route))
        }
    }

    @Test
    fun `нет пункта назначения — тоже открываем Вещи`() {
        assertEquals(ScanRoute.OpenItems, ScanRouting.routeFor(null))
    }

    @Test
    fun `Вещи и Поиск потребляют код сами`() {
        // «Вещи» и «Поиск» держат живую подписку на ScanBus.codes.
        assertEquals(ScanRoute.Local, ScanRouting.routeFor("items/{tag}"))
        assertEquals(ScanRoute.Local, ScanRouting.routeFor("items/0"))
        assertEquals(ScanRoute.Local, ScanRouting.routeFor("search"))
    }

    @Test
    fun `формы и сканер берут код по кнопке, не уводим экран`() {
        // ItemForm/LabelsScreen читают lastCode по нажатию, ScannerScreen ведёт
        // свой процесс скана — сводить их на «Вещи» нельзя.
        assertEquals(ScanRoute.Local, ScanRouting.routeFor("item-form/{id}/{locationId}"))
        assertEquals(ScanRoute.Local, ScanRouting.routeFor("scan"))
        assertEquals(ScanRoute.Local, ScanRouting.routeFor("labels/{type}/{id}/{templateId}"))
    }
}
