package p023d4;

import A3.AbstractC0157z;
import E3.q;
import E3.r;
import kotlin.jvm.internal.D;
import kotlinx.coroutines.flow.internal.B;
import kotlinx.coroutines.flow.internal.C1123l;
import p007a4.H0;
import p018c4.EnumC0368b;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class N {
    public static final <T> InterfaceC0612o cancellable(InterfaceC0612o interfaceC0612o) {
        return interfaceC0612o instanceof InterfaceC0582e ? interfaceC0612o : new C0591h(interfaceC0612o);
    }

    public static final <T> InterfaceC0612o conflate(InterfaceC0612o interfaceC0612o) {
        return AbstractC0618q.buffer(interfaceC0612o, -1, EnumC0368b.f1135a);
    }

    public static final <T> InterfaceC0612o flowOn(InterfaceC0612o interfaceC0612o, q qVar) {
        if (qVar.get(H0.Key) != null) {
            throw new IllegalArgumentException(("Flow context cannot contain job in it. Had " + qVar).toString());
        }
        if (qVar.equals(r.INSTANCE)) {
            return interfaceC0612o;
        }
        if (interfaceC0612o instanceof B) {
            return D.a((B) interfaceC0612o, qVar, 0, null, 6);
        }
        return new C1123l(interfaceC0612o, 0, qVar, 12, null);
    }

    public static final <T> InterfaceC0612o buffer(InterfaceC0612o interfaceC0612o, int i5, EnumC0368b enumC0368b) {
        if (i5 < 0 && i5 != -2 && i5 != -1) {
            throw new IllegalArgumentException(AbstractC0157z.k(i5, "Buffer size should be non-negative, BUFFERED, or CONFLATED, but was ").toString());
        }
        if (i5 == -1 && enumC0368b != EnumC0368b.f1135a) {
            throw new IllegalArgumentException("CONFLATED capacity cannot be used with non-default onBufferOverflow");
        }
        if (i5 == -1) {
            enumC0368b = EnumC0368b.b;
            i5 = 0;
        }
        int i6 = i5;
        EnumC0368b enumC0368b2 = enumC0368b;
        return interfaceC0612o instanceof B ? D.a((B) interfaceC0612o, null, i6, enumC0368b2, 1) : new C1123l(interfaceC0612o, i6, null, 2, enumC0368b2);
    }
}
