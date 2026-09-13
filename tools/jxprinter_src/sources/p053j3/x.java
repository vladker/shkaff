package p053j3;

import io.reactivex.AbstractC0676c;
import io.reactivex.G;
import io.reactivex.InterfaceC0679f;
import io.reactivex.InterfaceC0682i;
import io.reactivex.O;
import io.reactivex.V;
import io.reactivex.internal.operators.flowable.V1;
import io.reactivex.internal.operators.observable.C0899m0;
import p011b3.c;
import p011b3.d;
import p027e3.a;
import p033f3.e;
import t5.b;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class x extends AbstractC0676c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5457a;
    public final Object b;

    public /* synthetic */ x(Object obj, int i5) {
        this.f5457a = i5;
        this.b = obj;
    }

    @Override // io.reactivex.AbstractC0676c
    public final void d(InterfaceC0679f interfaceC0679f) {
        switch (this.f5457a) {
            case 0:
                Throwable th = (Throwable) this.b;
                interfaceC0679f.onSubscribe(e.f3970a);
                interfaceC0679f.onError(th);
                break;
            case 1:
                c cVarEmpty = d.empty();
                interfaceC0679f.onSubscribe(cVarEmpty);
                try {
                    ((a) this.b).run();
                    if (!cVarEmpty.e()) {
                        interfaceC0679f.onComplete();
                    }
                    break;
                } catch (Throwable th2) {
                    p017c3.d.throwIfFatal(th2);
                    if (cVarEmpty.e()) {
                        io.reactivex.plugins.a.onError(th2);
                        return;
                    } else {
                        interfaceC0679f.onError(th2);
                        return;
                    }
                }
                break;
            case 2:
                ((G) this.b).subscribe(new C0899m0(interfaceC0679f, 3));
                break;
            case 3:
                ((b) this.b).subscribe(new V1(interfaceC0679f, 1));
                break;
            case 4:
                c cVarEmpty2 = d.empty();
                interfaceC0679f.onSubscribe(cVarEmpty2);
                try {
                    ((Runnable) this.b).run();
                    if (!cVarEmpty2.e()) {
                        interfaceC0679f.onComplete();
                    }
                    break;
                } catch (Throwable th3) {
                    p017c3.d.throwIfFatal(th3);
                    if (cVarEmpty2.e()) {
                        io.reactivex.plugins.a.onError(th3);
                        return;
                    } else {
                        interfaceC0679f.onError(th3);
                        return;
                    }
                }
                break;
            case 5:
                ((O) ((V) this.b)).subscribe(new y(interfaceC0679f));
                break;
            default:
                ((AbstractC0676c) ((InterfaceC0682i) this.b)).subscribe(interfaceC0679f);
                break;
        }
    }
}
