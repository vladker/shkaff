package ru.vldkr.shkaff.domain.ean

// US-B1: данные, найденные по оригинальному штрихкоду вещи.
// В карточку попадают только поля, подтверждённые пользователем (см. features/items/ItemForm).
data class EanProduct(
    val name: String = "",
    val brand: String = "",
    val categories: String = "",
    val quantity: String = "",
    val imageUrl: String = "",
    // Незнакомые/прочие атрибуты из источника — на усмотрение UI.
    val extra: Map<String, String> = emptyMap()
)

fun interface EanProvider {
    suspend fun lookup(ean: String): EanProduct?
}

// OpenFoodFacts — открытая база продовольственных и части бытовых товаров по EAN/UPC.
object OpenFoodFactsEan : EanProvider {

    const val FIELDS =
        "product_name,generic_name,brands,categories_tags,brands_tags,quantity,image_front_url,image_front_small_url,ingredients_text"

    override suspend fun lookup(ean: String): EanProduct? {
        val url = "https://world.openfoodfacts.org/api/v2/product/$ean.json?fields=$FIELDS"
        return try {
            HttpJson.get(url)?.let { body ->
                val product = body.optJSONObject("product") ?: return null
                if (!product.has("product_name") && !product.has("generic_name")) return null
                EanProduct(
                    name = product.optString("product_name", "")
                        .takeIf { it.isNotBlank() }
                        ?: product.optString("generic_name", ""),
                    brand = product.optString("brands", ""),
                    categories = product.optString("categories_tags", "")
                        .removePrefix("[").removeSuffix("]")
                        .split(",")
                        .asSequence()
                        .map { it.trim().removePrefix("\"").removeSuffix("\"") }
                        .filter { it.isNotBlank() }
                        .joinToString(" / "),
                    quantity = product.optString("quantity", ""),
                    imageUrl = product.optString("image_front_url", "")
                        .ifBlank { product.optString("image_front_small_url", "") },
                    extra = buildExtra(product)
                )
            }
        } catch (_: Exception) {
            null
        }
    }

    private fun buildExtra(p: org.json.JSONObject): Map<String, String> {
        val m = mutableMapOf<String, String>()
        val generic = p.optString("generic_name", "").takeIf { it.isNotBlank() }
        if (generic != null) m["Общее название"] = generic
        val ingredients = p.optString("ingredients_text", "").takeIf { it.isNotBlank() }
        if (ingredients != null) m["Ингредиенты"] = ingredients
        return m
    }
}

// Фолбэк: если OpenFoodFacts не знает штрихкод, пробуем LLM-агент (если настроен).
class EanLookupFallback(private val llm: EanProvider?) : EanProvider {
    override suspend fun lookup(ean: String): EanProduct? =
        OpenFoodFactsEan.lookup(ean) ?: llm?.lookup(ean)
}

// Простые GET-запросы через HttpURLConnection (без внешних зависимостей).
internal object HttpJson {
    fun get(url: String): org.json.JSONObject? {
        val conn = java.net.URL(url).openConnection() as java.net.HttpURLConnection
        try {
            conn.requestMethod = "GET"
            conn.connectTimeout = 15_000
            conn.readTimeout = 30_000
            conn.setRequestProperty("Accept", "application/json")
            if (conn.responseCode !in 200..299) return null
            val text = conn.inputStream.bufferedReader(Charsets.UTF_8).readText()
            return org.json.JSONObject(text)
        } finally {
            conn.disconnect()
        }
    }
}