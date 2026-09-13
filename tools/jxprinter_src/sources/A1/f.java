package A1;

import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import java.util.Map;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class f {
    public static Point convertMapToOffset(g gVar, Map<?, ?> map) {
        E.f(map, "map");
        return h.convertMapToOffset(gVar, map);
    }

    public static int getColor(g gVar, String key) {
        E.f(key, "key");
        return h.getColor(gVar, key);
    }

    public static Point getOffset(g gVar, String key) {
        E.f(key, "key");
        return h.getOffset(gVar, key);
    }

    public static Paint getPaint(g gVar) {
        Object obj = gVar.getMap().get("paint");
        E.d(obj, "null cannot be cast to non-null type kotlin.collections.Map<*, *>");
        return new d((Map) obj).getPaint();
    }

    public static Rect getRect(g gVar, String key) {
        E.f(key, "key");
        return h.getRect(gVar, key);
    }
}
