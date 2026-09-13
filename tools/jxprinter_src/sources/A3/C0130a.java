package A3;

import W3.InterfaceC0233q;
import androidx.webkit.ProxyConfig;
import com.google.android.gms.tasks.CancellationTokenSource;
import java.util.Collection;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractC1131g;
import p072m4.C1241a;
import p084o4.C1345y0;
import p084o4.G0;
import p084o4.Y0;
import p147z3.AbstractC1926f;
import p147z3.C1937q;

/* JADX INFO: renamed from: A3.a, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C0130a implements O3.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f35a;
    public final /* synthetic */ Object b;

    public /* synthetic */ C0130a(Object obj, int i5) {
        this.f35a = i5;
        this.b = obj;
    }

    @Override // O3.l
    public final Object invoke(Object it) throws Throwable {
        String strValueOf;
        switch (this.f35a) {
            case 0:
                return it == ((AbstractC0132b) this.b) ? "(this Collection)" : String.valueOf(it);
            case 1:
                byte[] bArr = (byte[]) this.b;
                U2.f updateRequest = (U2.f) it;
                kotlin.jvm.internal.E.f(updateRequest, "$this$updateRequest");
                return U2.f.a(updateRequest, bArr, null, 47);
            case 2:
                Exception exc = (Exception) this.b;
                U2.f updateRequest2 = (U2.f) it;
                kotlin.jvm.internal.E.f(updateRequest2, "$this$updateRequest");
                return U2.f.a(updateRequest2, null, exc.toString(), 15);
            case 3:
                O3.a aVar = (O3.a) this.b;
                kotlin.jvm.internal.E.f(it, "it");
                return aVar.invoke();
            case 4:
                return Boolean.valueOf(((Class) this.b).isInstance(it));
            case 5:
                InterfaceC0233q interfaceC0233q = (InterfaceC0233q) this.b;
                if (it != null) {
                    return it;
                }
                throw new IllegalArgumentException("null element found in " + interfaceC0233q + '.');
            case 6:
                O3.p pVar = (O3.p) this.b;
                C0133b0 it2 = (C0133b0) it;
                kotlin.jvm.internal.E.f(it2, "it");
                Boolean bool = (Boolean) pVar.invoke(Integer.valueOf(it2.f36a), it2.b);
                bool.booleanValue();
                return bool;
            case 7:
                return Boolean.valueOf(C.contains((Object[]) this.b, it));
            case 8:
                return Boolean.valueOf(((Collection) this.b).contains(it));
            case 9:
                return Boolean.valueOf(((List) this.b).contains(it));
            case 10:
                return ((X3.B) this.b).get(((Integer) it).intValue());
            case 11:
                p018c4.F.cancelConsumed((p018c4.B0) this.b, (Throwable) it);
                return p147z3.Q.INSTANCE;
            case 12:
                Throwable th = (Throwable) it;
                Throwable th2 = null;
                for (p018c4.B0 b1 : (p018c4.B0[]) this.b) {
                    try {
                        p018c4.F.cancelConsumed(b1, th);
                    } catch (Throwable th3) {
                        if (th2 == null) {
                            th2 = th3;
                        } else {
                            AbstractC1926f.addSuppressed(th2, th3);
                        }
                    }
                }
                if (th2 == null) {
                    return p147z3.Q.INSTANCE;
                }
                throw th2;
            case 13:
                ((CancellationTokenSource) this.b).cancel();
                return p147z3.Q.INSTANCE;
            case 14:
                return p060k4.e.a((p060k4.e) this.b, (C1241a) it);
            case 15:
                kotlin.jvm.internal.d0 d0Var = (kotlin.jvm.internal.d0) this.b;
                V3.t it3 = (V3.t) it;
                kotlin.jvm.internal.E.f(it3, "it");
                d0Var.getClass();
                if (it3.getVariance() == null) {
                    return ProxyConfig.MATCH_ALL_SCHEMES;
                }
                V3.p type = it3.getType();
                kotlin.jvm.internal.d0 d0Var2 = type instanceof kotlin.jvm.internal.d0 ? (kotlin.jvm.internal.d0) type : null;
                if (d0Var2 == null || (strValueOf = d0Var2.a(true)) == null) {
                    strValueOf = String.valueOf(it3.getType());
                }
                V3.u variance = it3.getVariance();
                int i5 = variance == null ? -1 : kotlin.jvm.internal.c0.f5695a[variance.ordinal()];
                if (i5 == 1) {
                    return strValueOf;
                }
                if (i5 == 2) {
                    return "in ".concat(strValueOf);
                }
                if (i5 == 3) {
                    return "out ".concat(strValueOf);
                }
                throw new C1937q();
            case 16:
                AbstractC1131g abstractC1131g = (AbstractC1131g) this.b;
                p089p4.m node = (p089p4.m) it;
                kotlin.jvm.internal.E.f(node, "node");
                abstractC1131g.putElement((String) abstractC1131g.i(), node);
                return p147z3.Q.INSTANCE;
            case 17:
                p072m4.s sVar = (p072m4.s) this.b;
                int iIntValue = ((Integer) it).intValue();
                return sVar.getElementName(iIntValue) + ": " + sVar.getElementDescriptor(iIntValue).getSerialName();
            case 18:
                return C1345y0.a((C1345y0) this.b, (C1241a) it);
            case 19:
                G0 g1 = (G0) this.b;
                int iIntValue2 = ((Integer) it).intValue();
                return g1.getElementName(iIntValue2) + ": " + g1.getElementDescriptor(iIntValue2).getSerialName();
            case 20:
                return Y0.a((Y0) this.b, (C1241a) it);
            default:
                p060k4.b bVar = (p060k4.b) this.b;
                kotlin.jvm.internal.E.f((List) it, "it");
                return bVar;
        }
    }
}
