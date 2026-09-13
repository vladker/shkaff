package E3;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.E;
import kotlin.jvm.internal.Q;
import kotlin.jvm.internal.T;
import p007a4.AbstractC0272e;
import p007a4.C0276f0;
import p007a4.C0315z0;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class c implements O3.p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f227a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Serializable c;

    public /* synthetic */ c(Object obj, Serializable serializable, int i5) {
        this.f227a = i5;
        this.b = obj;
        this.c = serializable;
    }

    @Override // O3.p
    public final Object invoke(Object obj, Object obj2) {
        switch (this.f227a) {
            case 0:
                q[] qVarArr = (q[]) this.b;
                Q q6 = (Q) this.c;
                o element = (o) obj2;
                E.f((p147z3.Q) obj, "<unused var>");
                E.f(element, "element");
                int i5 = q6.f5687a;
                q6.f5687a = i5 + 1;
                qVarArr[i5] = element;
                break;
            default:
                byte[] bArr = (byte[]) this.b;
                String str = (String) this.c;
                ((Integer) obj).getClass();
                Integer num = (Integer) obj2;
                num.getClass();
                T t6 = new T();
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                t6.f5689a = linkedHashMap;
                linkedHashMap.put("total", Integer.valueOf(bArr.length));
                ((Map) t6.f5689a).put("sended", num);
                AbstractC0272e.b(C0315z0.INSTANCE, C0276f0.getMain(), 2, new S2.q(str, t6, null, 6));
                break;
        }
        return p147z3.Q.INSTANCE;
    }
}
