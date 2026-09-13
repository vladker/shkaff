package p023d4;

import A3.AbstractC0157z;
import E3.q;
import kotlinx.coroutines.flow.internal.C1123l;
import p018c4.EnumC0368b;
import p028e4.H;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class c2 {
    public static final H NO_VALUE = new H("NO_VALUE");

    public static final <T> U1 MutableSharedFlow(int i5, int i6, EnumC0368b enumC0368b) {
        if (i5 < 0) {
            throw new IllegalArgumentException(AbstractC0157z.k(i5, "replay cannot be negative, but was ").toString());
        }
        if (i6 < 0) {
            throw new IllegalArgumentException(AbstractC0157z.k(i6, "extraBufferCapacity cannot be negative, but was ").toString());
        }
        if (i5 <= 0 && i6 <= 0 && enumC0368b != EnumC0368b.f1135a) {
            throw new IllegalArgumentException(("replay or extraBufferCapacity must be positive with non-default onBufferOverflow strategy " + enumC0368b).toString());
        }
        int i7 = i6 + i5;
        if (i7 < 0) {
            i7 = Integer.MAX_VALUE;
        }
        return new a2(i5, i7, enumC0368b);
    }

    public static final Object a(Object[] objArr, long j6) {
        return objArr[((int) j6) & (objArr.length - 1)];
    }

    public static final void b(Object[] objArr, long j6, Object obj) {
        objArr[((int) j6) & (objArr.length - 1)] = obj;
    }

    public static final <T> InterfaceC0612o fuseSharedFlow(Z1 z6, q qVar, int i5, EnumC0368b enumC0368b) {
        return ((i5 == 0 || i5 == -3) && enumC0368b == EnumC0368b.f1135a) ? z6 : new C1123l(z6, qVar, i5, enumC0368b);
    }
}
