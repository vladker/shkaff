package p108t;

import java.util.List;
import kotlin.jvm.internal.E;

/* JADX INFO: renamed from: t.a, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class C1769a {
    public final C1770b fromList(List<? extends Object> pigeonVar_list) {
        E.f(pigeonVar_list, "pigeonVar_list");
        Object obj = pigeonVar_list.get(0);
        E.d(obj, "null cannot be cast to non-null type kotlin.String");
        Object obj2 = pigeonVar_list.get(1);
        E.d(obj2, "null cannot be cast to non-null type kotlin.String");
        return new C1770b((String) obj, (String) obj2);
    }
}
