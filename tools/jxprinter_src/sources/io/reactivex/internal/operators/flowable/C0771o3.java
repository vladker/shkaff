package io.reactivex.internal.operators.flowable;

import io.reactivex.AbstractC0676c;
import io.reactivex.AbstractC0979l;
import io.reactivex.AbstractC0985s;
import java.util.concurrent.Callable;
import p053j3.C0991b;

/* JADX INFO: renamed from: io.reactivex.internal.operators.flowable.o3, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0771o3 extends io.reactivex.O {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4718a;
    public final Object b;
    public final Object c;
    public final Object d;

    public /* synthetic */ C0771o3(int i5, Object obj, Object obj2, Object obj3, boolean z6) {
        this.f4718a = i5;
        this.b = obj;
        this.d = obj3;
        this.c = obj2;
    }

    @Override // io.reactivex.O
    public final void subscribeActual(io.reactivex.S s6) {
        switch (this.f4718a) {
            case 0:
                ((AbstractC0979l) this.b).subscribe((t5.c) new C0811v2(s6, (p027e3.c) this.c, this.d));
                break;
            case 1:
                try {
                    Object objCall = ((Callable) this.d).call();
                    p039g3.A.b(objCall, "The seedSupplier returned a null value");
                    ((AbstractC0979l) this.b).subscribe((t5.c) new C0811v2(s6, (p027e3.c) this.c, objCall));
                } catch (Throwable th) {
                    p017c3.d.throwIfFatal(th);
                    p033f3.e.f(th, s6);
                    return;
                }
                break;
            case 2:
                ((io.reactivex.B) this.b).subscribe(new p048i3.l(s6, 2, (p027e3.c) this.c, this.d));
                break;
            case 3:
                try {
                    Object objCall2 = ((Callable) this.d).call();
                    p039g3.A.b(objCall2, "The seedSupplier returned a null value");
                    ((io.reactivex.B) this.b).subscribe(new p048i3.l(s6, 2, (p027e3.c) this.c, objCall2));
                } catch (Throwable th2) {
                    p017c3.d.throwIfFatal(th2);
                    p033f3.e.f(th2, s6);
                    return;
                }
                break;
            case 4:
                ((AbstractC0676c) this.b).subscribe(new C0991b(this, s6));
                break;
            case 5:
                p059k3.C c = new p059k3.C(s6, (p027e3.d) this.c);
                s6.onSubscribe(c);
                io.reactivex.y yVar = (io.reactivex.y) this.b;
                io.reactivex.y yVar2 = (io.reactivex.y) this.d;
                ((AbstractC0985s) yVar).subscribe(c.b);
                ((AbstractC0985s) yVar2).subscribe(c.c);
                break;
            case 6:
                ((io.reactivex.O) this.b).subscribe(new p048i3.t(this, s6, 4));
                break;
            default:
                ((io.reactivex.O) this.b).subscribe(new p048i3.t(this, s6, 11));
                break;
        }
    }

    public /* synthetic */ C0771o3(Object obj, int i5, Object obj2, Object obj3) {
        this.f4718a = i5;
        this.b = obj;
        this.d = obj2;
        this.c = obj3;
    }
}
