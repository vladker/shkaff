package io.reactivex.internal.operators.flowable;

import io.reactivex.AbstractC0979l;
import io.reactivex.InterfaceC0984q;
import java.util.concurrent.Callable;

/* JADX INFO: renamed from: io.reactivex.internal.operators.flowable.w, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0814w extends AbstractC0683a {
    public final /* synthetic */ int c = 0;
    public final int d;
    public final int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Object f4814f;

    public C0814w(AbstractC0979l abstractC0979l, int i5, int i6, Callable callable) {
        super(abstractC0979l);
        this.d = i5;
        this.e = i6;
        this.f4814f = callable;
    }

    public static V g(t5.c cVar, p027e3.o oVar, int i5, int i6) {
        int iB = p050j.n.b(i6);
        if (iB != 1) {
            return iB != 2 ? new X(cVar, oVar, i5) : new W(i5, oVar, cVar, true);
        }
        return new W(i5, oVar, cVar, false);
    }

    @Override // io.reactivex.AbstractC0979l
    public final void b(t5.c cVar) {
        switch (this.c) {
            case 0:
                Callable callable = (Callable) this.f4814f;
                AbstractC0979l abstractC0979l = this.b;
                int i5 = this.d;
                int i6 = this.e;
                if (i5 == i6) {
                    abstractC0979l.subscribe((InterfaceC0984q) new C0796t(cVar, i5, callable));
                } else if (i6 <= i5) {
                    abstractC0979l.subscribe((InterfaceC0984q) new C0802u(cVar, i5, i6, callable));
                } else {
                    abstractC0979l.subscribe((InterfaceC0984q) new C0808v(cVar, i5, i6, callable));
                }
                break;
            default:
                p027e3.o oVar = (p027e3.o) this.f4814f;
                AbstractC0979l abstractC0979l2 = this.b;
                if (!p002a.c.c(oVar, abstractC0979l2, cVar)) {
                    abstractC0979l2.subscribe((t5.c) g(cVar, oVar, this.d, this.e));
                    break;
                }
                break;
        }
    }

    public C0814w(AbstractC0979l abstractC0979l, p027e3.o oVar, int i5, int i6) {
        super(abstractC0979l);
        this.f4814f = oVar;
        this.d = i5;
        this.e = i6;
    }
}
