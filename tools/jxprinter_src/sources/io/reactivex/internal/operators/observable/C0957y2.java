package io.reactivex.internal.operators.observable;

import java.util.ArrayList;

/* JADX INFO: renamed from: io.reactivex.internal.operators.observable.y2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0957y2 extends ArrayList implements InterfaceC0925r2 {
    private static final long serialVersionUID = 7063189396499112664L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile int f5313a;

    @Override // io.reactivex.internal.operators.observable.InterfaceC0925r2
    public final void a(Object obj) {
        add(obj);
        this.f5313a++;
    }

    @Override // io.reactivex.internal.operators.observable.InterfaceC0925r2
    public final void complete() {
        add(p100r3.n.f7968a);
        this.f5313a++;
    }

    @Override // io.reactivex.internal.operators.observable.InterfaceC0925r2
    public final void e(C0911o2 c0911o2) {
        if (c0911o2.getAndIncrement() != 0) {
            return;
        }
        io.reactivex.I i5 = c0911o2.b;
        int iAddAndGet = 1;
        while (!c0911o2.d) {
            int i6 = this.f5313a;
            Integer num = (Integer) c0911o2.c;
            int iIntValue = num != null ? num.intValue() : 0;
            while (iIntValue < i6) {
                Object obj = get(iIntValue);
                if (obj == p100r3.n.f7968a) {
                    i5.onComplete();
                    return;
                } else {
                    if (obj instanceof p100r3.l) {
                        i5.onError(((p100r3.l) obj).f7966a);
                        return;
                    }
                    i5.onNext(obj);
                    if (c0911o2.d) {
                        return;
                    } else {
                        iIntValue++;
                    }
                }
            }
            c0911o2.c = Integer.valueOf(iIntValue);
            iAddAndGet = c0911o2.addAndGet(-iAddAndGet);
            if (iAddAndGet == 0) {
                return;
            }
        }
    }

    @Override // io.reactivex.internal.operators.observable.InterfaceC0925r2
    public final void error(Throwable th) {
        add(new p100r3.l(th));
        this.f5313a++;
    }
}
