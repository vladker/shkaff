package io.reactivex.internal.operators.flowable;

import io.reactivex.AbstractC0979l;
import io.reactivex.InterfaceC0984q;

/* JADX INFO: renamed from: io.reactivex.internal.operators.flowable.m0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0756m0 extends AbstractC0683a {
    public final /* synthetic */ int c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0756m0(AbstractC0979l abstractC0979l, int i5) {
        super(abstractC0979l);
        this.c = i5;
    }

    @Override // io.reactivex.AbstractC0979l
    public final void b(t5.c cVar) {
        switch (this.c) {
            case 0:
                this.b.subscribe((InterfaceC0984q) new C0750l0(cVar));
                return;
            case 1:
                K0 k6 = new K0();
                k6.b = cVar;
                this.b.subscribe((InterfaceC0984q) k6);
                return;
            case 2:
                this.b.subscribe((InterfaceC0984q) new K0(cVar));
                return;
            case 3:
                this.b.subscribe((InterfaceC0984q) new U1(cVar));
                return;
            case 4:
                try {
                    throw null;
                } catch (NullPointerException e) {
                    throw e;
                } catch (Throwable th) {
                    p017c3.d.throwIfFatal(th);
                    io.reactivex.plugins.a.onError(th);
                    NullPointerException nullPointerException = new NullPointerException("Actually not, but can't throw other exceptions due to RS");
                    nullPointerException.initCause(th);
                    throw nullPointerException;
                }
            case 5:
                this.b.subscribe((InterfaceC0984q) new C2(cVar));
                return;
            case 6:
                this.b.subscribe((InterfaceC0984q) new R2(cVar));
                return;
            case 7:
                this.b.subscribe((InterfaceC0984q) new S2(cVar));
                return;
            case 8:
                this.b.subscribe((InterfaceC0984q) new p135x3.c(cVar));
                return;
            default:
                this.b.subscribe((InterfaceC0984q) new C0819w4(cVar));
                return;
        }
    }
}
