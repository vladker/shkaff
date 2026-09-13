package p052j2;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class b implements JsonSerializer {
    @Override // com.google.gson.JsonSerializer
    public JsonElement serialize(Object obj, Type type, JsonSerializationContext jsonSerializationContext) {
        Double d = (Double) obj;
        return d.doubleValue() == ((double) d.longValue()) ? new JsonPrimitive(Long.valueOf(d.longValue())) : new JsonPrimitive(d);
    }
}
