package ru.vldkr.shkaff.data.catalog

import org.json.JSONArray

/**
 * Чистый Kotlin-справочник атрибутов для карточек вещей и хранилищ.
 *
 * Справочник намеренно «избыточный»: он покрывает основные категории,
 * используемые в маркетплейсах, и разбивает атрибуты на три уровня:
 *  - min  — обязательные атрибуты категории;
 *  - rec  — рекомендуемые атрибуты;
 *  - free — свободные/дополнительные атрибуты.
 */
data class Spec(
    val scope: String,
    val key: String,
    val label: String,
    val type: String = "text",
    val options: List<String> = emptyList(),
    val sort_order: Int = 0,
    val tier: String = "free",
    val category: String = "*"
)

object AttributeCatalog {

    val itemCategories: List<String> = listOf(
        "Электроника",
        "Компьютеры и периферия",
        "Телефоны и планшеты",
        "Инструменты",
        "Ручной инструмент",
        "Электромонтаж",
        "Автозапчасти",
        "Мото и транспорт",
        "Канцелярия",
        "Бумага и картон",
        "Одежда",
        "Обувь",
        "Детские товары",
        "Спорт и отдых",
        "Туризм и походы",
        "Дом и сад",
        "Посуда и кухня",
        "Текстиль и постель",
        "Химия и уход",
        "Аптечка и медицина",
        "Еда и напитки",
        "Продукты с сроком",
        "Семена и рассада",
        "Животные",
        "Игрушки и игры",
        "Музыкальные инструменты",
        "Фото и видео",
        "Игры и консоли",
        "Книги и журналы",
        "Документы",
        "Коллекция и хобби",
        "Ключи и мелочи",
        "Дары и подарки",
        "Материалы и расходники",
        "Органайзеры и хранение"
    )

    val storageCategories: List<String> = listOf(
        "Город / регион",
        "Склад",
        "Комната",
        "Шкаф",
        "Полка",
        "Ящик",
        "Пакет",
        "Паллет",
        "Внешний объект",
        "Временное хранение"
    )

    fun categoriesFor(scope: String): List<String> =
        if (scope == "storage") storageCategories else itemCategories

    fun optionsJson(options: List<String>): String = JSONArray(options).toString()

    fun itemCategoriesJson(): String = JSONArray(itemCategories).toString()

    fun storageCategoriesJson(): String = JSONArray(storageCategories).toString()

    fun tierLabel(tier: String): String = when (tier) {
        "min" -> "Минимум"
        "rec" -> "Рекомендуемые"
        else -> "Свободные"
    }

    /**
     * Полный набор атрибутов, которые сидируются в `attribute_def`.
     *
     * `category = "*"` означает, что атрибут доступен для всех категорий.
     * `category = "<название>"` означает, что атрибут привязан к конкретной категории.
     */
    val specs: List<Spec> = buildList {

        // ────────────────────────────────────────────────
        // Общие атрибуты вещей
        // ────────────────────────────────────────────────
        add(Spec("item", "brand", "Бренд", sort_order = 10, tier = "rec"))
        add(Spec("item", "model", "Модель", sort_order = 11, tier = "rec"))
        add(Spec("item", "color", "Цвет", sort_order = 12, tier = "free"))
        add(Spec("item", "size", "Размер", sort_order = 13, tier = "rec"))
        add(Spec("item", "material", "Материал", sort_order = 14, tier = "rec"))
        add(
            Spec(
                "item",
                "condition",
                "Состояние",
                "select",
                listOf("Новое", "Б/у, рабочее", "Б/у, с дефектом", "На запчасти"),
                sort_order = 15,
                tier = "rec"
            )
        )
        add(Spec("item", "price", "Цена, ₽", "number", sort_order = 16, tier = "rec"))
        add(Spec("item", "avito_price", "Цена Авито, ₽", "number", sort_order = 17, tier = "rec"))
        add(Spec("item", "purchase_date", "Дата покупки", "date", sort_order = 17, tier = "free"))
        add(Spec("item", "warranty_until", "Гарантия до", "date", sort_order = 18, tier = "free"))
        add(Spec("item", "serial_number", "Серийный номер", sort_order = 19, tier = "free"))
        add(Spec("item", "origin_country", "Страна происхождения", sort_order = 20, tier = "free"))
        add(Spec("item", "manufacturer", "Производитель", sort_order = 21, tier = "free"))
        add(Spec("item", "article", "Артикул", sort_order = 22, tier = "free"))
        add(Spec("item", "dimensions_cm", "Габариты, см", sort_order = 23, tier = "free"))
        add(Spec("item", "capacity", "Объём / ёмкость", sort_order = 24, tier = "free"))
        add(Spec("item", "voltage", "Напряжение", sort_order = 25, tier = "free"))
        add(Spec("item", "power_w", "Мощность, Вт", "number", sort_order = 26, tier = "free"))
        add(Spec("item", "battery", "Батарея / АКБ", sort_order = 27, tier = "free"))
        add(Spec("item", "features", "Особенности", sort_order = 28, tier = "free"))

        // ────────────────────────────────────────────────
        // Общие атрибуты хранилищ
        // ────────────────────────────────────────────────
        add(Spec("storage", "owner", "Владелец", sort_order = 10, tier = "free"))
        add(
            Spec(
                "storage",
                "access_level",
                "Доступ",
                "select",
                listOf("Открытый", "Ограниченный", "Закрытый", "Требует код/ключ"),
                sort_order = 11,
                tier = "rec"
            )
        )
        add(Spec("storage", "address", "Адрес", sort_order = 12, tier = "rec"))
        add(
            Spec(
                "storage",
                "security",
                "Охрана",
                "select",
                listOf("Нет", "Видеонаблюдение", "Дверь/замок", "Страховка", "Хранение с контролем"),
                sort_order = 13,
                tier = "free"
            )
        )
        add(Spec("storage", "insurance_value", "Страховая ценность, ₽", "number", sort_order = 14, tier = "free"))
        add(Spec("storage", "fire_rating", "Пожарный класс", sort_order = 15, tier = "free"))
        add(
            Spec(
                "storage",
                "ventilation",
                "Вентиляция",
                "select",
                listOf("Нет", "Естественная", "Принудительная"),
                sort_order = 16,
                tier = "free"
            )
        )
        add(
            Spec(
                "storage",
                "seasonal_access",
                "Сезонный доступ",
                "select",
                listOf("Весь год", "Только лето", "Только зима", "По договорённости"),
                sort_order = 17,
                tier = "free"
            )
        )

        // ────────────────────────────────────────────────
        // Специфичные атрибуты категорий вещей
        // ────────────────────────────────────────────────
        add(
            Spec(
                "item",
                "electronics_device_type",
                "Устройство",
                "select",
                listOf("Аудио", "Видеонаблюдение", "Игровая консоль", "Печать", "Сетевое оборудование", "Фото", "Умный дом", "Другое"),
                category = "Электроника",
                tier = "min"
            )
        )
        add(Spec("item", "electronics_connectivity", "Связь / порты", "select",
            listOf("Wi-Fi", "Bluetooth", "USB-C", "HDMI", "Ethernet", "3.5 mm"),
            category = "Электроника", tier = "rec"))
        add(Spec("item", "electronics_certification", "Сертификация",
            category = "Электроника", tier = "free"))

        add(
            Spec(
                "item",
                "computers_platform",
                "Платформа",
                "select",
                listOf("ПК", "Ноутбук", "Сервер", "Станция", "Встраиваемый"),
                category = "Компьютеры и периферия",
                tier = "min"
            )
        )
        add(Spec("item", "computers_cpu", "Процессор", category = "Компьютеры и периферия", tier = "rec"))
        add(Spec("item", "computers_ram_gb", "ОЗУ, ГБ", "number", category = "Компьютеры и периферия", tier = "rec"))
        add(Spec("item", "computers_storage_gb", "Накопитель, ГБ", "number", category = "Компьютеры и периферия", tier = "rec"))
        add(Spec("item", "computers_gpu", "Видеокарта", category = "Компьютеры и периферия", tier = "free"))
        add(Spec("item", "computers_os", "ОС", category = "Компьютеры и периферия", tier = "free"))

        add(
            Spec(
                "item",
                "phones_device_type",
                "Устройство",
                "select",
                listOf("Смартфон", "Телефон", "Планшет"),
                category = "Телефоны и планшеты",
                tier = "min"
            )
        )
        add(Spec("item", "phones_storage_gb", "Память, ГБ", "number", category = "Телефоны и планшеты", tier = "rec"))
        add(Spec("item", "phones_battery_mah", "Батарея, мА·ч", "number", category = "Телефоны и планшеты", tier = "rec"))
        add(Spec("item", "phones_screen_inch", "Диагональ, дюймы", "number", category = "Телефоны и планшеты", tier = "rec"))
        add(Spec("item", "phones_network", "Сеть / SIM", category = "Телефоны и планшеты", tier = "free"))

        add(
            Spec(
                "item",
                "tools_power_source",
                "Источник питания",
                "select",
                listOf("Сетевой", "Аккумуляторный", "Ручной", "Пневматический", "Бензиновый"),
                category = "Инструменты",
                tier = "min"
            )
        )
        add(Spec("item", "tools_max_torque_nm", "Макс. крутящий момент, Н·м", "number", category = "Инструменты", tier = "rec"))
        add(Spec("item", "tools_accessories", "Комплектация", category = "Инструменты", tier = "free"))
        add(Spec("item", "tools_ip_rating", "Защита IP", category = "Инструменты", tier = "free"))

        add(
            Spec(
                "item",
                "hand_tool_type",
                "Тип инструмента",
                "select",
                listOf("Отвёртка", "Ключ", "Плоскогубцы", "Нож", "Пила", "Молоток", "Напильник", "Штангенциркуль", "Другое"),
                category = "Ручной инструмент",
                tier = "min"
            )
        )
        add(Spec("item", "hand_tool_size_mm", "Размер, мм", "number", category = "Ручной инструмент", tier = "rec"))
        add(Spec("item", "hand_tool_material", "Материал", category = "Ручной инструмент", tier = "rec"))
        add(Spec("item", "hand_tool_set_count", "Количество в комплекте", "number", category = "Ручной инструмент", tier = "free"))

        add(
            Spec(
                "item",
                "electrical_type",
                "Тип изделия",
                "select",
                listOf("Кабель", "Провод", "Розетка", "Выключатель", "Автомат", "УЗО", "Счётчик", "Клемма", "Другое"),
                category = "Электромонтаж",
                tier = "min"
            )
        )
        add(Spec("item", "electrical_current_a", "Ток, А", "number", category = "Электромонтаж", tier = "rec"))
        add(Spec("item", "electrical_voltage_v", "Напряжение, В", "number", category = "Электромонтаж", tier = "rec"))
        add(Spec("item", "electrical_section_mm2", "Сечение, мм²", "number", category = "Электромонтаж", tier = "free"))
        add(Spec("item", "electrical_length_m", "Длина, м", "number", category = "Электромонтаж", tier = "free"))

        add(
            Spec(
                "item",
                "auto_part_type",
                "Тип детали",
                "select",
                listOf("Двигатель", "Трансмиссия", "Тормоза", "Подвеска", "Кузов", "Электрика", "Салон", "Другое"),
                category = "Автозапчасти",
                tier = "min"
            )
        )
        add(Spec("item", "auto_part_number", "Номер детали", category = "Автозапчасти", tier = "rec"))
        add(Spec("item", "auto_oem_number", "OEM / аналог", category = "Автозапчасти", tier = "rec"))
        add(Spec("item", "auto_vehicle", "Автомобиль", category = "Автозапчасти", tier = "rec"))
        add(Spec("item", "auto_position", "Расположение", category = "Автозапчасти", tier = "free"))

        add(
            Spec(
                "item",
                "moto_part_type",
                "Тип детали",
                "select",
                listOf("Двигатель", "Трансмиссия", "Тормоза", "Ходовая", "Кузов", "Электрика"),
                category = "Мото и транспорт",
                tier = "min"
            )
        )
        add(Spec("item", "moto_vehicle", "Транспорт", category = "Мото и транспорт", tier = "rec"))
        add(Spec("item", "moto_year", "Год", "number", category = "Мото и транспорт", tier = "free"))
        add(Spec("item", "moto_position", "Расположение", category = "Мото и транспорт", tier = "free"))

        add(
            Spec(
                "item",
                "office_item_type",
                "Тип изделия",
                "select",
                listOf("Ручка", "Карандаш", "Блокнот", "Папка", "Картридж", "Клей", "Ножницы", "Другое"),
                category = "Канцелярия",
                tier = "min"
            )
        )
        add(Spec("item", "office_count", "Количество", "number", category = "Канцелярия", tier = "rec"))
        add(Spec("item", "office_size", "Формат / размер", category = "Канцелярия", tier = "rec"))
        add(Spec("item", "office_material", "Материал", category = "Канцелярия", tier = "free"))

        add(
            Spec(
                "item",
                "paper_type",
                "Тип бумаги / картона",
                "select",
                listOf("А4", "А3", "Картон", "Саморазрывный", "Чистые", "Наклейки", "Другое"),
                category = "Бумага и картон",
                tier = "min"
            )
        )
        add(Spec("item", "paper_format", "Формат", category = "Бумага и картон", tier = "rec"))
        add(Spec("item", "paper_gsm", "Г/м²", "number", category = "Бумага и картон", tier = "rec"))
        add(Spec("item", "paper_pack_count", "Количество в упаковке", "number", category = "Бумага и картон", tier = "free"))

        add(
            Spec(
                "item",
                "clothing_type",
                "Тип одежды",
                "select",
                listOf("Верх", "Низ", "Платье", "Футболка", "Куртка", "Штаны", "Рубашка", "Другое"),
                category = "Одежда",
                tier = "min"
            )
        )
        add(Spec("item", "clothing_size", "Размер", category = "Одежда", tier = "rec"))
        add(Spec("item", "clothing_material", "Материал", category = "Одежда", tier = "rec"))
        add(Spec("item", "clothing_care", "Уход", category = "Одежда", tier = "free"))
        add(Spec("item", "clothing_season", "Сезон", category = "Одежда", tier = "free"))

        add(
            Spec(
                "item",
                "shoe_type",
                "Тип обуви",
                "select",
                listOf("Кроссовки", "Кеды", "Ботинки", "Сапоги", "Сандалии", "Тапочки", "Другое"),
                category = "Обувь",
                tier = "min"
            )
        )
        add(Spec("item", "shoe_size", "Размер обуви", category = "Обувь", tier = "rec"))
        add(Spec("item", "shoe_material", "Материал", category = "Обувь", tier = "rec"))
        add(Spec("item", "shoe_sole", "Подошва", category = "Обувь", tier = "free"))

        add(
            Spec(
                "item",
                "children_age_range",
                "Возраст",
                "select",
                listOf("0-3", "3-6", "6-12", "12-18"),
                category = "Детские товары",
                tier = "min"
            )
        )
        add(Spec("item", "children_size", "Размер", category = "Детские товары", tier = "rec"))
        add(Spec("item", "children_safety", "Безопасность", category = "Детские товары", tier = "rec"))
        add(Spec("item", "children_gender", "Пол", category = "Детские товары", tier = "free"))

        add(
            Spec(
                "item",
                "sport_type",
                "Вид спорта / активности",
                "select",
                listOf("Бег", "Тренировки", "Велоспорт", "Баскетбол", "Футбол", "Плавание", "Йога", "Другое"),
                category = "Спорт и отдых",
                tier = "min"
            )
        )
        add(Spec("item", "sport_size", "Размер", category = "Спорт и отдых", tier = "rec"))
        add(Spec("item", "sport_weight", "Вес, кг", "number", category = "Спорт и отдых", tier = "rec"))
        add(Spec("item", "sport_material", "Материал", category = "Спорт и отдых", tier = "free"))

        add(
            Spec(
                "item",
                "tourism_type",
                "Тип снаряжения",
                "select",
                listOf("Палатка", "Спальник", "Рюкзак", "Горелка", "Котелок", "Нож", "Фонарь", "Другое"),
                category = "Туризм и походы",
                tier = "min"
            )
        )
        add(Spec("item", "tourism_capacity_l", "Объём, л", "number", category = "Туризм и походы", tier = "rec"))
        add(Spec("item", "tourism_weight_kg", "Вес, кг", "number", category = "Туризм и походы", tier = "rec"))
        add(Spec("item", "tourism_season", "Сезон", category = "Туризм и походы", tier = "free"))

        add(
            Spec(
                "item",
                "home_item_type",
                "Тип изделия",
                "select",
                listOf("Мебель", "Освещение", "Посуда", "Текстиль", "Декор", "Уход", "Другое"),
                category = "Дом и сад",
                tier = "min"
            )
        )
        add(Spec("item", "home_size", "Размер / габариты", category = "Дом и сад", tier = "rec"))
        add(Spec("item", "home_material", "Материал", category = "Дом и сад", tier = "rec"))
        add(Spec("item", "home_color", "Цвет", category = "Дом и сад", tier = "free"))

        add(
            Spec(
                "item",
                "kitchen_item_type",
                "Тип изделия",
                "select",
                listOf("Горшок", "Сковорода", "Кастрюля", "Блюдо", "Стакан", "Кружка", "Кувшин", "Ложки", "Вилки", "Нож"),
                category = "Посуда и кухня",
                tier = "min"
            )
        )
        add(Spec("item", "kitchen_capacity_l", "Объём, л", "number", category = "Посуда и кухня", tier = "rec"))
        add(Spec("item", "kitchen_material", "Материал", category = "Посуда и кухня", tier = "rec"))
        add(Spec("item", "kitchen_dishwasher_safe", "Мойка в посудомойке", "select",
            listOf("Да", "Нет"), category = "Посуда и кухня", tier = "free"))
        add(Spec("item", "kitchen_set_count", "Количество в комплекте", "number", category = "Посуда и кухня", tier = "free"))

        add(
            Spec(
                "item",
                "textile_type",
                "Тип текстиля",
                "select",
                listOf("Постель", "Полотенце", "Штора", "Ковер", "Плед", "Прочее"),
                category = "Текстиль и постель",
                tier = "min"
            )
        )
        add(Spec("item", "textile_dimensions_cm", "Размеры, см", category = "Текстиль и постель", tier = "rec"))
        add(Spec("item", "textile_material", "Состав", category = "Текстиль и постель", tier = "rec"))
        add(Spec("item", "textile_care", "Уход", category = "Текстиль и постель", tier = "free"))
        add(Spec("item", "textile_color", "Цвет", category = "Текстиль и постель", tier = "free"))

        add(
            Spec(
                "item",
                "chemical_type",
                "Тип средства",
                "select",
                listOf("Стирка", "Посуда", "Санитария", "Поверхности", "Автомобиль", "Прочее"),
                category = "Химия и уход",
                tier = "min"
            )
        )
        add(Spec("item", "chemical_volume_ml", "Объём, мл", "number", category = "Химия и уход", tier = "rec"))
        add(Spec("item", "chemical_usage", "Применение", category = "Химия и уход", tier = "rec"))
        add(Spec("item", "chemical_shelf_life", "Срок годности", category = "Химия и уход", tier = "free"))

        add(
            Spec(
                "item",
                "medical_type",
                "Тип изделия",
                "select",
                listOf("Лек", "Бинты", "Маски", "Термометр", "Перчатки", "Другое"),
                category = "Аптечка и медицина",
                tier = "min"
            )
        )
        add(Spec("item", "medical_dosage", "Дозировка", category = "Аптечка и медицина", tier = "rec"))
        add(Spec("item", "medical_storage", "Условия хранения", category = "Аптечка и медицина", tier = "free"))

        add(
            Spec(
                "item",
                "food_type",
                "Тип продукта",
                "select",
                listOf("Напитки", "Кондитерские", "Бакалея", "Молочные", "Мясо", "Рыба", "Овощи", "Фрукты", "Другое"),
                category = "Еда и напитки",
                tier = "min"
            )
        )
        add(Spec("item", "food_volume_ml", "Объём / вес", "number", category = "Еда и напитки", tier = "rec"))
        add(Spec("item", "food_storage", "Хранение", category = "Еда и напитки", tier = "rec"))
        add(Spec("item", "food_ingredients", "Состав", category = "Еда и напитки", tier = "free"))

        add(
            Spec(
                "item",
                "shelf_food_type",
                "Тип продукта",
                "select",
                listOf("Напитки", "Бакалея", "Молочные", "Мясо", "Рыба", "Овощи", "Фрукты", "Другое"),
                category = "Продукты с сроком",
                tier = "min"
            )
        )
        add(Spec("item", "shelf_food_volume_ml", "Объём / вес", "number", category = "Продукты с сроком", tier = "rec"))
        add(Spec("item", "shelf_food_expiry", "Срок годности", "date", category = "Продукты с сроком", tier = "rec"))
        add(Spec("item", "shelf_food_storage", "Хранение", category = "Продукты с сроком", tier = "free"))

        add(
            Spec(
                "item",
                "seed_crop",
                "Культура",
                "select",
                listOf("Овощи", "Зелень", "Цветы", "Ягоды", "Зерновые", "Другое"),
                category = "Семена и рассада",
                tier = "min"
            )
        )
        add(Spec("item", "seed_variety", "Сорт", category = "Семена и рассада", tier = "rec"))
        add(Spec("item", "seed_planting_season", "Сезон посадки", category = "Семена и рассада", tier = "rec"))
        add(Spec("item", "seed_days_to_harvest", "Срок созревания, дней", "number", category = "Семена и рассада", tier = "free"))

        add(
            Spec(
                "item",
                "pet_type",
                "Вид животного",
                "select",
                listOf("Собака", "Кошка", "Птицы", "Грызуны", "Рыбы", "Пресмыкающиеся", "Насекомые"),
                category = "Животные",
                tier = "min"
            )
        )
        add(Spec("item", "pet_size", "Размер / вес", category = "Животные", tier = "rec"))
        add(Spec("item", "pet_food_type", "Тип корма", category = "Животные", tier = "rec"))
        add(Spec("item", "pet_breed", "Порода", category = "Животные", tier = "free"))

        add(
            Spec(
                "item",
                "toy_type",
                "Тип игрушки",
                "select",
                listOf("Конструктор", "Машинка", "Пупсы", "Мяч", "Настольная игра", "Электронная", "Развивающая"),
                category = "Игрушки и игры",
                tier = "min"
            )
        )
        add(Spec("item", "toy_battery", "Батарейки", category = "Игрушки и игры", tier = "rec"))
        add(Spec("item", "toy_size", "Размер", category = "Игрушки и игры", tier = "free"))

        add(
            Spec(
                "item",
                "music_instrument",
                "Инструмент",
                "select",
                listOf("Струнные", "Духовые", "Клавишные", "Ударные", "Гитары", "Баян", "Свистулька", "Прочее"),
                category = "Музыкальные инструменты",
                tier = "min"
            )
        )
        add(Spec("item", "music_size", "Размер", category = "Музыкальные инструменты", tier = "rec"))
        add(Spec("item", "music_material", "Материал", category = "Музыкальные инструменты", tier = "rec"))
        add(Spec("item", "music_strings", "Струны / клавиши", category = "Музыкальные инструменты", tier = "free"))

        add(
            Spec(
                "item",
                "photo_device",
                "Тип устройства",
                "select",
                listOf("Камера", "Объектив", "Свет", "Статив", "Аксессуар"),
                category = "Фото и видео",
                tier = "min"
            )
        )
        add(Spec("item", "photo_sensor", "Матрица / сенсор", category = "Фото и видео", tier = "rec"))
        add(Spec("item", "photo_lens_mount", "Бейонет", category = "Фото и видео", tier = "rec"))
        add(Spec("item", "photo_storage", "Накопитель / карта", category = "Фото и видео", tier = "free"))

        add(
            Spec(
                "item",
                "game_platform",
                "Платформа",
                "select",
                listOf("ПК", "Консоль", "Мобильная", "Настольная", "Карточная"),
                category = "Игры и консоли",
                tier = "min"
            )
        )
        add(Spec("item", "game_genre", "Жанр", category = "Игры и консоли", tier = "rec"))
        add(Spec("item", "game_players", "Количество игроков", "number", category = "Игры и консоли", tier = "rec"))
        add(Spec("item", "game_region", "Регион", category = "Игры и консоли", tier = "free"))

        add(
            Spec(
                "item",
                "book_type",
                "Тип книги",
                "select",
                listOf("Роман", "Детектив", "Фантастика", "Наука", "Деловая", "Учебник", "Комикс", "Прочее"),
                category = "Книги и журналы",
                tier = "min"
            )
        )
        add(Spec("item", "book_author", "Автор", category = "Книги и журналы", tier = "rec"))
        add(Spec("item", "book_pages", "Страницы", "number", category = "Книги и журналы", tier = "rec"))
        add(Spec("item", "book_isbn", "ISBN", category = "Книги и журналы", tier = "free"))
        add(Spec("item", "book_language", "Язык", category = "Книги и журналы", tier = "free"))

        add(
            Spec(
                "item",
                "doc_type",
                "Тип документа",
                "select",
                listOf("Паспорт", "Права", "Аттестат", "Диплом", "Договор", "Счета", "Чек", "Прочее"),
                category = "Документы",
                tier = "min"
            )
        )
        add(Spec("item", "doc_issued_at", "Дата выдачи", "date", category = "Документы", tier = "rec"))
        add(Spec("item", "doc_valid_until", "Срок действия", "date", category = "Документы", tier = "rec"))
        add(Spec("item", "doc_holder", "Владелец", category = "Документы", tier = "free"))

        add(
            Spec(
                "item",
                "collectible_type",
                "Тип коллекционного предмета",
                "select",
                listOf("Монеты", "Медали", "Печати", "Нумизматика", "Филателия", "Антиквариат", "Прочее"),
                category = "Коллекция и хобби",
                tier = "min"
            )
        )
        add(Spec("item", "collectible_era", "Эпоха / период", category = "Коллекция и хобби", tier = "rec"))
        add(Spec("item", "collectible_condition", "Состояние", category = "Коллекция и хобби", tier = "rec"))
        add(Spec("item", "collectible_provenance", "Происхождение", category = "Коллекция и хобби", tier = "free"))

        add(
            Spec(
                "item",
                "key_type",
                "Тип ключа / мелочи",
                "select",
                listOf("Дом", "Авто", "Мото", "Офис", "Склад", "Прочее"),
                category = "Ключи и мелочи",
                tier = "min"
            )
        )
        add(Spec("item", "key_count", "Количество", "number", category = "Ключи и мелочи", tier = "rec"))
        add(Spec("item", "key_material", "Материал", category = "Ключи и мелочи", tier = "free"))

        add(
            Spec(
                "item",
                "gift_occasion",
                "Повод",
                "select",
                listOf("День рождения", "Свадьба", "Корпоратив", "Праздник", "Благодарность"),
                category = "Дары и подарки",
                tier = "min"
            )
        )
        add(Spec("item", "gift_recipient", "Получатель", category = "Дары и подарки", tier = "rec"))
        add(Spec("item", "gift_size", "Размер", category = "Дары и подарки", tier = "free"))

        add(
            Spec(
                "item",
                "material_type",
                "Тип материала",
                "select",
                listOf("Дерево", "Металл", "Пластик", "Стекло", "Бумага", "Ткань", "Прочее"),
                category = "Материалы и расходники",
                tier = "min"
            )
        )
        add(Spec("item", "material_quantity", "Количество", "number", category = "Материалы и расходники", tier = "rec"))
        add(Spec("item", "material_unit", "Единица", category = "Материалы и расходники", tier = "rec"))
        add(Spec("item", "material_thickness", "Толщина", category = "Материалы и расходники", tier = "free"))

        add(
            Spec(
                "item",
                "organizer_type",
                "Тип органайзера",
                "select",
                listOf("Коробка", "Папка", "Стеллаж", "Крючки", "Органайзер", "Прочее"),
                category = "Органайзеры и хранение",
                tier = "min"
            )
        )
        add(Spec("item", "organizer_dimensions_cm", "Размеры, см", category = "Органайзеры и хранение", tier = "rec"))
        add(Spec("item", "organizer_material", "Материал", category = "Органайзеры и хранение", tier = "rec"))
        add(Spec("item", "organizer_color", "Цвет", category = "Органайзеры и хранение", tier = "free"))

        // ────────────────────────────────────────────────
        // Специфичные атрибуты категорий хранилищ
        // ────────────────────────────────────────────────
        add(
            Spec(
                "storage",
                "city_country",
                "Страна / регион",
                category = "Город / регион",
                tier = "min"
            )
        )
        add(Spec("storage", "city_postal_code", "Почтовый индекс", category = "Город / регион", tier = "rec"))
        add(Spec("storage", "city_address", "Адрес", category = "Город / регион", tier = "rec"))

        add(
            Spec(
                "storage",
                "warehouse_type",
                "Тип склада",
                "select",
                listOf("Малый", "Средний", "Крупный", "Холодильный", "Температурный", "Сухой"),
                category = "Склад",
                tier = "min"
            )
        )
        add(Spec("storage", "warehouse_dock_count", "Количество доков", "number", category = "Склад", tier = "rec"))
        add(Spec("storage", "warehouse_forklift_access", "Подъёмник", "select",
            listOf("Да", "Нет"), category = "Склад", tier = "free"))
        add(Spec("storage", "warehouse_loading_capacity_t", "Возможная грузоподъёмность, т", "number", category = "Склад", tier = "free"))

        add(
            Spec(
                "storage",
                "room_type",
                "Тип комнаты",
                "select",
                listOf("Спальня", "Кухня", "Гостиная", "Ванная", "Кладовая", "Гараж", "Другое"),
                category = "Комната",
                tier = "min"
            )
        )
        add(Spec("storage", "room_floor_number", "Этаж", "number", category = "Комната", tier = "rec"))
        add(Spec("storage", "room_heating", "Отопление", "select",
            listOf("Центральное", "Локальное", "Нет"), category = "Комната", tier = "free"))
        add(Spec("storage", "room_lighting", "Освещение", category = "Комната", tier = "free"))

        add(
            Spec(
                "storage",
                "cabinet_type",
                "Тип шкафа",
                "select",
                listOf("Шкаф", "Шкафчик", "Гардероб", "Стеллаж", "Вешалка", "Другое"),
                category = "Шкаф",
                tier = "min"
            )
        )
        add(Spec("storage", "cabinet_height_cm", "Высота, см", "number", category = "Шкаф", tier = "rec"))
        add(Spec("storage", "cabinet_width_cm", "Ширина, см", "number", category = "Шкаф", tier = "rec"))
        add(Spec("storage", "cabinet_doors_count", "Количество дверей", "number", category = "Шкаф", tier = "free"))
        add(Spec("storage", "cabinet_shelves_count", "Количество полок", "number", category = "Шкаф", tier = "free"))

        add(
            Spec(
                "storage",
                "shelf_type",
                "Тип полки",
                "select",
                listOf("Полка", "Стеллаж", "Кронштейн", "Другое"),
                category = "Полка",
                tier = "min"
            )
        )
        add(Spec("storage", "shelf_height_cm", "Высота, см", "number", category = "Полка", tier = "rec"))
        add(Spec("storage", "shelf_width_cm", "Ширина, см", "number", category = "Полка", tier = "rec"))
        add(Spec("storage", "shelf_depth_cm", "Глубина, см", "number", category = "Полка", tier = "free"))
        add(Spec("storage", "shelf_load_kg", "Допустимая нагрузка, кг", "number", category = "Полка", tier = "free"))

        add(
            Spec(
                "storage",
                "box_type",
                "Тип ящика / коробки",
                "select",
                listOf("Коробка", "Ящик", "Бокс", "Контейнер", "Другое"),
                category = "Ящик",
                tier = "min"
            )
        )
        add(Spec("storage", "box_volume_l", "Объём, л", "number", category = "Ящик", tier = "rec"))
        add(Spec("storage", "box_weight_kg", "Вес, кг", "number", category = "Ящик", tier = "rec"))
        add(Spec("storage", "box_color_code", "Цветовая маркировка", category = "Ящик", tier = "free"))
        add(Spec("storage", "box_lid", "Крышка", "select",
            listOf("Да", "Нет"), category = "Ящик", tier = "free"))

        add(
            Spec(
                "storage",
                "bag_type",
                "Тип пакета",
                "select",
                listOf("Пакет", "Плёнка", "Мешок", "Сашет", "Другое"),
                category = "Пакет",
                tier = "min"
            )
        )
        add(Spec("storage", "bag_volume_l", "Объём, л", "number", category = "Пакет", tier = "rec"))
        add(Spec("storage", "bag_material", "Материал", category = "Пакет", tier = "rec"))
        add(Spec("storage", "bag_seal_type", "Тип герметизации", category = "Пакет", tier = "free"))

        add(
            Spec(
                "storage",
                "pallet_size",
                "Размер паллета",
                "select",
                listOf("Стандарт 1200×800", "Европейский 1200×1000", "Квадратный 1000×1000", "Другой"),
                category = "Паллет",
                tier = "min"
            )
        )
        add(Spec("storage", "pallet_max_load_t", "Максимальная нагрузка, т", "number", category = "Паллет", tier = "rec"))
        add(Spec("storage", "pallet_racking_zone", "Зона стеллажа", category = "Паллет", tier = "free"))

        add(
            Spec(
                "storage",
                "outdoor_object_type",
                "Тип внешнего объекта",
                "select",
                listOf("Гараж", "Сарай", "Парковка", "Двор", "Участок", "Другое"),
                category = "Внешний объект",
                tier = "min"
            )
        )
        add(Spec("storage", "outdoor_gps_lat", "Широта", category = "Внешний объект", tier = "rec"))
        add(Spec("storage", "outdoor_gps_lng", "Долгота", category = "Внешний объект", tier = "rec"))
        add(Spec("storage", "outdoor_seasonal_access", "Сезонный доступ", "select",
            listOf("Весь год", "Только лето", "Только зима", "По договорённости"), category = "Внешний объект", tier = "free"))

        add(
            Spec(
                "storage",
                "temp_storage_type",
                "Тип временного хранения",
                "select",
                listOf("Временное", "Буферное", "Карантинное", "Возвратное", "Другое"),
                category = "Временное хранение",
                tier = "min"
            )
        )
        add(Spec("storage", "temp_storage_planned_until", "Планируемый срок", "date", category = "Временное хранение", tier = "rec"))
        add(Spec("storage", "temp_storage_reason", "Причина хранения", category = "Временное хранение", tier = "free"))
    }
}
