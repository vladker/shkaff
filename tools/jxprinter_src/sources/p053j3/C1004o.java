package p053j3;

import io.reactivex.AbstractC0676c;
import io.reactivex.InterfaceC0679f;
import io.reactivex.InterfaceC0682i;
import io.reactivex.plugins.a;
import java.util.concurrent.Callable;
import p011b3.c;
import p017c3.d;
import p033f3.e;
import p039g3.A;

/* JADX INFO: renamed from: j3.o, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C1004o extends AbstractC0676c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5447a;
    public final Callable b;

    public /* synthetic */ C1004o(Callable callable, int i5) {
        this.f5447a = i5;
        this.b = callable;
    }

    @Override // io.reactivex.AbstractC0676c
    public final void d(InterfaceC0679f interfaceC0679f) {
        switch (this.f5447a) {
            case 0:
                try {
                    Object objCall = this.b.call();
                    A.b(objCall, "The completableSupplier returned a null CompletableSource");
                    ((AbstractC0676c) ((InterfaceC0682i) objCall)).subscribe(interfaceC0679f);
                } catch (Throwable th) {
                    d.throwIfFatal(th);
                    interfaceC0679f.onSubscribe(e.f3970a);
                    interfaceC0679f.onError(th);
                    return;
                }
                break;
            case 1:
                try {
                    Object objCall2 = this.b.call();
                    A.b(objCall2, "The error returned is null");
                    th = (Throwable) objCall2;
                } catch (Throwable th2) {
                    th = th2;
                    d.throwIfFatal(th);
                }
                interfaceC0679f.onSubscribe(e.f3970a);
                interfaceC0679f.onError(th);
                break;
            default:
                c cVarEmpty = p011b3.d.empty();
                interfaceC0679f.onSubscribe(cVarEmpty);
                try {
                    this.b.call();
                    if (!cVarEmpty.e()) {
                        interfaceC0679f.onComplete();
                    }
                    break;
                } catch (Throwable th3) {
                    d.throwIfFatal(th3);
                    if (!cVarEmpty.e()) {
                        interfaceC0679f.onError(th3);
                        return;
                    }
                    a.onError(th3);
                }
                break;
        }
    }
}
