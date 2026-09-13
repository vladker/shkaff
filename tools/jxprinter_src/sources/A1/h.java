package A1;

import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Rect;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.Map;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class h {
    public static Point convertMapToOffset(i iVar, Map<?, ?> map) {
        E.f(map, "map");
        Object obj = map.get("x");
        E.d(obj, "null cannot be cast to non-null type kotlin.Int");
        int iIntValue = ((Integer) obj).intValue();
        Object obj2 = map.get("y");
        E.d(obj2, "null cannot be cast to non-null type kotlin.Int");
        return new Point(iIntValue, ((Integer) obj2).intValue());
    }

    public static int getColor(i iVar, String key) {
        E.f(key, "key");
        Object obj = iVar.getMap().get(TypedValues.Custom.S_COLOR);
        E.d(obj, "null cannot be cast to non-null type kotlin.collections.Map<*, *>");
        Map map = (Map) obj;
        Object obj2 = map.get("r");
        E.d(obj2, "null cannot be cast to non-null type kotlin.Int");
        int iIntValue = ((Integer) obj2).intValue();
        Object obj3 = map.get("g");
        E.d(obj3, "null cannot be cast to non-null type kotlin.Int");
        int iIntValue2 = ((Integer) obj3).intValue();
        Object obj4 = map.get("b");
        E.d(obj4, "null cannot be cast to non-null type kotlin.Int");
        int iIntValue3 = ((Integer) obj4).intValue();
        Object obj5 = map.get("a");
        E.d(obj5, "null cannot be cast to non-null type kotlin.Int");
        return Color.argb(((Integer) obj5).intValue(), iIntValue, iIntValue2, iIntValue3);
    }

    public static Point getOffset(i iVar, String key) {
        E.f(key, "key");
        Object obj = iVar.getMap().get(key);
        E.d(obj, "null cannot be cast to non-null type kotlin.collections.Map<*, *>");
        return iVar.convertMapToOffset((Map) obj);
    }

    public static Rect getRect(i iVar, String key) {
        E.f(key, "key");
        Object obj = iVar.getMap().get(key);
        E.d(obj, "null cannot be cast to non-null type kotlin.collections.Map<*, *>");
        Map map = (Map) obj;
        Object obj2 = map.get("left");
        E.d(obj2, "null cannot be cast to non-null type kotlin.Int");
        int iIntValue = ((Integer) obj2).intValue();
        Object obj3 = map.get("top");
        E.d(obj3, "null cannot be cast to non-null type kotlin.Int");
        int iIntValue2 = ((Integer) obj3).intValue();
        Object obj4 = map.get("width");
        E.d(obj4, "null cannot be cast to non-null type kotlin.Int");
        int iIntValue3 = ((Integer) obj4).intValue() + iIntValue;
        Object obj5 = map.get("height");
        E.d(obj5, "null cannot be cast to non-null type kotlin.Int");
        return new Rect(iIntValue, iIntValue2, iIntValue3, ((Integer) obj5).intValue() + iIntValue2);
    }
}
