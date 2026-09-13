package io.reactivex.internal.operators.observable;

/* JADX INFO: renamed from: io.reactivex.internal.operators.observable.h, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0873h extends AbstractC0838a {
    public final /* synthetic */ int b;
    public final p027e3.q c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0873h(io.reactivex.B b, p027e3.q qVar, int i5) {
        super(b);
        this.b = i5;
        this.c = qVar;
    }

    @Override // io.reactivex.B
    public final void b(io.reactivex.I i5) {
        switch (this.b) {
            case 0:
                this.f5141a.subscribe(new C0868g(i5, this.c, 0));
                break;
            case 1:
                this.f5141a.subscribe(new C0868g(i5, this.c, 1));
                break;
            case 2:
                this.f5141a.subscribe(new D0(i5, this.c));
                break;
            case 3:
                this.f5141a.subscribe(new C0868g(i5, this.c, 2));
                break;
            case 4:
                this.f5141a.subscribe(new C0868g(i5, this.c, 3));
                break;
            default:
                this.f5141a.subscribe(new C0868g(i5, this.c, 4));
                break;
        }
    }
}
