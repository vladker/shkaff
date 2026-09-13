package p108t;

import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.E;

/* JADX INFO: renamed from: t.c, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class C1771c {
    public final C1772d fromList(List<? extends Object> pigeonVar_list) {
        E.f(pigeonVar_list, "pigeonVar_list");
        Object obj = pigeonVar_list.get(0);
        E.d(obj, "null cannot be cast to non-null type kotlin.String");
        return new C1772d((String) obj, (Map) pigeonVar_list.get(1));
    }
}
