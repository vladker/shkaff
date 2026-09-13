package io.reactivex.internal.operators.observable;

/* JADX INFO: renamed from: io.reactivex.internal.operators.observable.h1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0875h1 extends AbstractC0838a {
    public final /* synthetic */ int b;
    public final Object c;
    public final Object d;
    public final Object e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Object f5199f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0875h1(io.reactivex.B b, Object obj, Object obj2, Object obj3, Object obj4, int i5) {
        super(b);
        this.b = i5;
        this.c = obj;
        this.d = obj2;
        this.e = obj3;
        this.f5199f = obj4;
    }

    @Override // io.reactivex.B
    public final void b(io.reactivex.I i5) {
        switch (this.b) {
            case 0:
                C0855d1 c0855d1 = new C0855d1(i5, (p027e3.o) this.d, (p027e3.o) this.e, (p027e3.c) this.f5199f);
                i5.onSubscribe(c0855d1);
                C0870g1 c0870g1 = new C0870g1(c0855d1, true);
                p011b3.b bVar = c0855d1.c;
                bVar.add(c0870g1);
                C0870g1 c0870g2 = new C0870g1(c0855d1, false);
                bVar.add(c0870g2);
                this.f5141a.subscribe(c0870g1);
                ((io.reactivex.G) this.c).subscribe(c0870g2);
                break;
            case 1:
                C1 c6 = new C1(i5, (p027e3.o) this.d, (p027e3.o) this.e, (p027e3.c) this.f5199f);
                i5.onSubscribe(c6);
                C0870g1 c0870g3 = new C0870g1(c6, true);
                p011b3.b bVar2 = c6.c;
                bVar2.add(c0870g3);
                C0870g1 c0870g4 = new C0870g1(c6, false);
                bVar2.add(c0870g4);
                this.f5141a.subscribe(c0870g3);
                ((io.reactivex.G) this.c).subscribe(c0870g4);
                break;
            default:
                this.f5141a.subscribe(new C0943v0(i5, (p027e3.g) this.c, (p027e3.g) this.d, (p027e3.a) this.e, (p027e3.a) this.f5199f));
                break;
        }
    }
}
