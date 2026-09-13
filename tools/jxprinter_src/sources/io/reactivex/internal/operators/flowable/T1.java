package io.reactivex.internal.operators.flowable;

import io.reactivex.AbstractC0979l;
import io.reactivex.InterfaceC0984q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class T1 extends AbstractC0683a {
    public final /* synthetic */ int c;
    public final Object d;
    public final Object e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Object f4439f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Object f4440g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ T1(AbstractC0979l abstractC0979l, Object obj, Object obj2, Object obj3, Object obj4, int i5) {
        super(abstractC0979l);
        this.c = i5;
        this.d = obj;
        this.e = obj2;
        this.f4439f = obj3;
        this.f4440g = obj4;
    }

    @Override // io.reactivex.AbstractC0979l
    public final void b(t5.c cVar) {
        switch (this.c) {
            case 0:
                P1 p1 = new P1(cVar, (p027e3.o) this.e, (p027e3.o) this.f4439f, (p027e3.c) this.f4440g);
                cVar.onSubscribe(p1);
                S1 s6 = new S1(p1, true);
                p011b3.b bVar = p1.d;
                bVar.add(s6);
                S1 s7 = new S1(p1, false);
                bVar.add(s7);
                this.b.subscribe((InterfaceC0984q) s6);
                ((t5.b) this.d).subscribe(s7);
                break;
            case 1:
                C0787r2 c0787r2 = new C0787r2(cVar, (p027e3.o) this.e, (p027e3.o) this.f4439f, (p027e3.c) this.f4440g);
                cVar.onSubscribe(c0787r2);
                S1 s8 = new S1(c0787r2, true);
                p011b3.b bVar2 = c0787r2.d;
                bVar2.add(s8);
                S1 s9 = new S1(c0787r2, false);
                bVar2.add(s9);
                this.b.subscribe((InterfaceC0984q) s8);
                ((t5.b) this.d).subscribe(s9);
                break;
            default:
                boolean z6 = cVar instanceof p043h3.a;
                AbstractC0979l abstractC0979l = this.b;
                if (!z6) {
                    abstractC0979l.subscribe((InterfaceC0984q) new V0(cVar, (p027e3.g) this.d, (p027e3.g) this.e, (p027e3.a) this.f4439f, (p027e3.a) this.f4440g));
                } else {
                    abstractC0979l.subscribe((InterfaceC0984q) new U0((p043h3.a) cVar, (p027e3.g) this.d, (p027e3.g) this.e, (p027e3.a) this.f4439f, (p027e3.a) this.f4440g));
                }
                break;
        }
    }
}
