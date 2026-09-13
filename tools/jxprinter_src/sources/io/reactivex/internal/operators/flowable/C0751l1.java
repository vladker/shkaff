package io.reactivex.internal.operators.flowable;

import io.reactivex.AbstractC0979l;
import io.reactivex.InterfaceC0984q;

/* JADX INFO: renamed from: io.reactivex.internal.operators.flowable.l1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0751l1 extends AbstractC0683a {
    public final /* synthetic */ int c;
    public final Object d;
    public final boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f4694f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0751l1(AbstractC0979l abstractC0979l, Object obj, boolean z6, int i5, int i6) {
        super(abstractC0979l);
        this.c = i6;
        this.d = obj;
        this.e = z6;
        this.f4694f = i5;
    }

    @Override // io.reactivex.AbstractC0979l
    public final void b(t5.c cVar) {
        switch (this.c) {
            case 0:
                this.b.subscribe((InterfaceC0984q) new C0745k1(this.f4694f, (p027e3.o) this.d, cVar, this.e));
                break;
            case 1:
                this.b.subscribe((InterfaceC0984q) new C0781q1(this.f4694f, (p027e3.o) this.d, cVar, this.e));
                break;
            case 2:
                this.b.subscribe((InterfaceC0984q) new C0798t1(this.f4694f, (p027e3.o) this.d, cVar, this.e));
                break;
            case 3:
                p027e3.o oVar = (p027e3.o) this.d;
                AbstractC0979l abstractC0979l = this.b;
                if (!p002a.c.c(oVar, abstractC0979l, cVar)) {
                    abstractC0979l.subscribe((InterfaceC0984q) new C0801t4(this.f4694f, oVar, cVar, this.e));
                    break;
                }
                break;
            default:
                io.reactivex.M mCreateWorker = ((io.reactivex.N) this.d).createWorker();
                boolean z6 = cVar instanceof p043h3.a;
                int i5 = this.f4694f;
                boolean z7 = this.e;
                AbstractC0979l abstractC0979l2 = this.b;
                if (!z6) {
                    abstractC0979l2.subscribe((InterfaceC0984q) new M2(cVar, mCreateWorker, z7, i5));
                } else {
                    abstractC0979l2.subscribe((InterfaceC0984q) new L2((p043h3.a) cVar, mCreateWorker, z7, i5));
                }
                break;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0751l1(int i5, p027e3.o oVar, AbstractC0979l abstractC0979l, boolean z6) {
        super(abstractC0979l);
        this.c = 3;
        this.d = oVar;
        this.f4694f = i5;
        this.e = z6;
    }
}
