package io.reactivex.internal.operators.flowable;

import io.reactivex.AbstractC0979l;
import io.reactivex.InterfaceC0984q;

/* JADX INFO: renamed from: io.reactivex.internal.operators.flowable.l, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0749l extends AbstractC0683a {
    public final /* synthetic */ int c;
    public final p027e3.q d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0749l(AbstractC0979l abstractC0979l, p027e3.q qVar, int i5) {
        super(abstractC0979l);
        this.c = i5;
        this.d = qVar;
    }

    @Override // io.reactivex.AbstractC0979l
    public final void b(t5.c cVar) {
        switch (this.c) {
            case 0:
                this.b.subscribe((InterfaceC0984q) new C0743k(cVar, this.d));
                break;
            case 1:
                this.b.subscribe((InterfaceC0984q) new r(cVar, this.d));
                break;
            case 2:
                boolean z6 = cVar instanceof p043h3.a;
                p027e3.q qVar = this.d;
                AbstractC0979l abstractC0979l = this.b;
                if (!z6) {
                    abstractC0979l.subscribe((InterfaceC0984q) new C0715f1(cVar, qVar));
                } else {
                    abstractC0979l.subscribe((InterfaceC0984q) new C0709e1((p043h3.a) cVar, qVar));
                }
                break;
            case 3:
                this.b.subscribe((InterfaceC0984q) new C0772o4(cVar, this.d, 0));
                break;
            case 4:
                this.b.subscribe((InterfaceC0984q) new C0772o4(cVar, this.d, 1));
                break;
            default:
                this.b.subscribe((InterfaceC0984q) new C0772o4(cVar, this.d, 2));
                break;
        }
    }
}
