package p053j3;

import io.reactivex.AbstractC0676c;
import io.reactivex.InterfaceC0679f;
import io.reactivex.InterfaceC0682i;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import p011b3.b;
import p100r3.c;
import p100r3.g;

/* JADX INFO: renamed from: j3.k, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C1000k extends AbstractC0676c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5443a;
    public final InterfaceC0682i[] b;

    public /* synthetic */ C1000k(InterfaceC0682i[] interfaceC0682iArr, int i5) {
        this.f5443a = i5;
        this.b = interfaceC0682iArr;
    }

    @Override // io.reactivex.AbstractC0676c
    public final void d(InterfaceC0679f interfaceC0679f) {
        switch (this.f5443a) {
            case 0:
                C0999j c0999j = new C0999j(interfaceC0679f, this.b);
                interfaceC0679f.onSubscribe(c0999j.d);
                c0999j.a();
                break;
            case 1:
                b bVar = new b();
                D d = new D(interfaceC0679f, new AtomicBoolean(), bVar, this.b.length + 1);
                interfaceC0679f.onSubscribe(bVar);
                for (InterfaceC0682i interfaceC0682i : this.b) {
                    if (!bVar.b) {
                        if (interfaceC0682i == null) {
                            bVar.dispose();
                            d.onError(new NullPointerException("A completable source is null"));
                        } else {
                            ((AbstractC0676c) interfaceC0682i).subscribe(d);
                        }
                    }
                    break;
                }
                d.onComplete();
                break;
            default:
                b bVar2 = new b();
                AtomicInteger atomicInteger = new AtomicInteger(this.b.length + 1);
                c cVar = new c();
                interfaceC0679f.onSubscribe(bVar2);
                for (InterfaceC0682i interfaceC0682i2 : this.b) {
                    if (!bVar2.b) {
                        if (interfaceC0682i2 == null) {
                            g.a(cVar, new NullPointerException("A completable source is null"));
                            atomicInteger.decrementAndGet();
                        } else {
                            ((AbstractC0676c) interfaceC0682i2).subscribe(new C0990a(interfaceC0679f, bVar2, cVar, atomicInteger));
                        }
                    }
                    break;
                }
                if (atomicInteger.decrementAndGet() == 0) {
                    Throwable thB = g.b(cVar);
                    if (thB == null) {
                        interfaceC0679f.onComplete();
                    } else {
                        interfaceC0679f.onError(thB);
                    }
                }
                break;
        }
    }
}
