package A1;

import io.flutter.plugins.firebase.crashlytics.Constants;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class c extends r implements p145z1.k {
    private final List<e> drawPart;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(Map<?, ?> map) {
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
                i qVar = E.a(obj3, "rect") ? new q(map3) : E.a(obj3, "oval") ? new m(map3) : E.a(obj3, Constants.LINE) ? new j(map3) : E.a(obj3, "point") ? new p(map3) : E.a(obj3, "path") ? new n(map3) : null;
                if (qVar != null) {
                    arrayList.add(qVar);
                }
            }
        }
        this.drawPart = arrayList;
    }

    public final List<e> getDrawPart() {
        return this.drawPart;
    }
}
