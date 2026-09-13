package S2;

import java.util.List;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class b {
    public final c fromList(List<? extends Object> pigeonVar_list) {
        E.f(pigeonVar_list, "pigeonVar_list");
        byte[] bArr = (byte[]) pigeonVar_list.get(0);
        Object obj = pigeonVar_list.get(1);
        E.d(obj, "null cannot be cast to non-null type kotlin.Boolean");
        return new c(bArr, ((Boolean) obj).booleanValue(), (String) pigeonVar_list.get(2));
    }
}
