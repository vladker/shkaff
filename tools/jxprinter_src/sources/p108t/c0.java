package p108t;

import java.util.List;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class c0 {
    public final d0 fromList(List<? extends Object> pigeonVar_list) {
        long jLongValue;
        E.f(pigeonVar_list, "pigeonVar_list");
        Object obj = pigeonVar_list.get(0);
        E.d(obj, "null cannot be cast to non-null type kotlin.String");
        String str = (String) obj;
        Object obj2 = pigeonVar_list.get(1);
        E.d(obj2, "null cannot be cast to non-null type kotlin.String");
        String str2 = (String) obj2;
        Object obj3 = pigeonVar_list.get(2);
        if (obj3 instanceof Integer) {
            jLongValue = ((Number) obj3).intValue();
        } else {
            E.d(obj3, "null cannot be cast to non-null type kotlin.Long");
            jLongValue = ((Long) obj3).longValue();
        }
        return new d0(str, str2, jLongValue);
    }
}
