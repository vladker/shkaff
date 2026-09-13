package p134x2;

import A3.T;
import O3.l;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.F;
import p007a4.AbstractC0272e;
import p007a4.C0276f0;
import p007a4.C0315z0;
import p147z3.Q;

/* JADX INFO: renamed from: x2.l, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C1867l extends F implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ M0 f8912a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1867l(M0 m6) {
        super(1);
        this.f8912a = m6;
    }

    @Override // O3.l
    public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((byte[]) obj);
        return Q.INSTANCE;
    }

    public final void invoke(byte[] bArr) {
        List mutableList;
        if (bArr == null) {
            AbstractC0272e.b(C0315z0.INSTANCE, C0276f0.getIO(), 2, new C1865k(this.f8912a, null));
        }
        synchronized (E.eventListeners) {
            mutableList = T.toMutableList((Collection) E.eventListeners);
        }
        Iterator it = mutableList.iterator();
        while (it.hasNext()) {
            ((O0) it.next()).onRecvData(this.f8912a, bArr);
        }
    }
}
