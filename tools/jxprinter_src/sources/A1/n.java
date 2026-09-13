package A1;

import android.graphics.Paint;
import io.flutter.plugins.firebase.crashlytics.Constants;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class n extends e implements g {
    private final List<o> paths;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(Map<?, ?> map) {
        super(map);
        E.f(map, "map");
        ArrayList arrayList = new ArrayList();
        Object obj = map.get("parts");
        E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<*>");
        for (Object obj2 : (List) obj) {
            if (obj2 instanceof Map) {
                Map map2 = (Map) obj2;
                Object obj3 = map2.get(Constants.KEY);
                Object obj4 = map2.get("value");
                E.d(obj4, "null cannot be cast to non-null type kotlin.collections.Map<*, *>");
                Map map3 = (Map) obj4;
                i lVar = E.a(obj3, "move") ? new l(map3) : E.a(obj3, "lineTo") ? new k(map3) : E.a(obj3, "bezier") ? new b(map3) : E.a(obj3, "arcTo") ? new a(map3) : null;
                if (lVar != null) {
                    arrayList.add(lVar);
                }
            }
        }
        this.paths = arrayList;
    }

    @Override // A1.g
    public Paint getPaint() {
        return f.getPaint(this);
    }

    public final List<o> getPaths() {
        return this.paths;
    }
}
