package p052j2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import java.util.List;
import kotlin.jvm.internal.Y;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Gson f5401a;

    static {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(JsonObject.class, new a());
        gsonBuilder.registerTypeAdapter(Double.class, new b());
        f5401a = gsonBuilder.disableHtmlEscaping().create();
    }

    public static List a(Class cls, String str) {
        if (Y.f(str)) {
            return null;
        }
        return (List) f5401a.fromJson(str, new d(List.class, new Class[]{cls}));
    }

    public static List b(Object obj, Class cls) {
        d dVar = new d(List.class, new Class[]{cls});
        Gson gson = f5401a;
        return (List) gson.fromJson(gson.toJsonTree(obj), dVar);
    }

    public static Object c(Class cls, String str) {
        if (Y.f(str)) {
            return null;
        }
        return f5401a.fromJson(str, new d(cls, new Class[]{cls}));
    }

    public static Object d(Object obj, Class cls) {
        d dVar = new d(cls, new Class[]{cls});
        Gson gson = f5401a;
        return gson.fromJson(gson.toJsonTree(obj), dVar);
    }

    public static String e(Object obj) {
        if (obj == null) {
            return null;
        }
        return f5401a.toJson(obj);
    }
}
