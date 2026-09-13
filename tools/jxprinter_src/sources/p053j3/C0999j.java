package p053j3;

import io.reactivex.AbstractC0676c;
import io.reactivex.InterfaceC0679f;
import io.reactivex.InterfaceC0682i;
import java.util.concurrent.atomic.AtomicInteger;
import p011b3.c;
import p033f3.d;
import p033f3.h;

/* JADX INFO: renamed from: j3.j, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0999j extends AtomicInteger implements InterfaceC0679f {
    private static final long serialVersionUID = -7965400327305809232L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC0679f f5442a;
    public final InterfaceC0682i[] b;
    public int c;
    public final h d = new h();

    public C0999j(InterfaceC0679f interfaceC0679f, InterfaceC0682i[] interfaceC0682iArr) {
        this.f5442a = interfaceC0679f;
        this.b = interfaceC0682iArr;
    }

    public final void a() {
        h hVar = this.d;
        if (!hVar.e() && getAndIncrement() == 0) {
            while (!hVar.e()) {
                int i5 = this.c;
                this.c = i5 + 1;
                InterfaceC0682i[] interfaceC0682iArr = this.b;
                if (i5 == interfaceC0682iArr.length) {
                    this.f5442a.onComplete();
                    return;
                } else {
                    ((AbstractC0676c) interfaceC0682iArr[i5]).subscribe(this);
                    if (decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }
    }

    @Override // io.reactivex.InterfaceC0679f, io.reactivex.InterfaceC0988v
    public final void onComplete() {
        a();
    }

    @Override // io.reactivex.InterfaceC0679f
    public final void onError(Throwable th) {
        this.f5442a.onError(th);
    }

    @Override // io.reactivex.InterfaceC0679f
    public final void onSubscribe(c cVar) {
        h hVar = this.d;
        hVar.getClass();
        d.c(hVar, cVar);
    }
}
