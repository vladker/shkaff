package p071m3;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.plugins.a;
import java.util.concurrent.atomic.AtomicLong;
import p017c3.e;
import p100r3.c;
import t5.d;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class n extends o {
    private static final long serialVersionUID = 6312374661811000451L;

    @Override // p071m3.o
    public final void c() {
        if (getAndIncrement() != 0) {
            return;
        }
        g();
    }

    @Override // p071m3.o
    public final void d() {
        this.f6151f.decrementAndGet();
        c();
    }

    @Override // p071m3.o
    public final void e(Throwable th) {
        c cVar = this.c;
        if (cVar.compareAndSet(null, th)) {
            a();
            c();
        } else if (th != cVar.get()) {
            a.onError(th);
        }
    }

    @Override // p071m3.o
    public final void f(m mVar, Object obj) {
        if (get() == 0 && compareAndSet(0, 1)) {
            AtomicLong atomicLong = this.d;
            long j6 = atomicLong.get();
            t5.c cVar = this.f6150a;
            if (j6 != 0) {
                cVar.onNext(obj);
                if (atomicLong.get() != LocationRequestCompat.PASSIVE_INTERVAL) {
                    atomicLong.decrementAndGet();
                }
                long j7 = mVar.d + 1;
                if (j7 >= mVar.c) {
                    mVar.d = 0L;
                    ((d) mVar.get()).request(j7);
                } else {
                    mVar.d = j7;
                }
            } else if (!((p083o3.c) mVar.a()).offer(obj)) {
                a();
                e eVar = new e("Queue full?!");
                if (this.c.compareAndSet(null, eVar)) {
                    cVar.onError(eVar);
                    return;
                } else {
                    a.onError(eVar);
                    return;
                }
            }
            if (decrementAndGet() == 0) {
                return;
            }
        } else if (!((p083o3.c) mVar.a()).offer(obj)) {
            a();
            e(new e("Queue full?!"));
            return;
        } else if (getAndIncrement() != 0) {
            return;
        }
        g();
    }

    public final void g() {
        boolean z6;
        long j6;
        boolean z7;
        Object objPoll;
        m[] mVarArr = this.b;
        int length = mVarArr.length;
        t5.c cVar = this.f6150a;
        int i5 = 1;
        while (true) {
            long j7 = this.d.get();
            long j8 = 0;
            do {
                z6 = false;
                if (j8 == j7) {
                    j6 = 0;
                    break;
                }
                if (this.e) {
                    b();
                    return;
                }
                Throwable th = (Throwable) this.c.get();
                if (th != null) {
                    b();
                    cVar.onError(th);
                    return;
                }
                boolean z8 = this.f6151f.get() == 0;
                z7 = true;
                for (m mVar : mVarArr) {
                    j6 = 0;
                    p083o3.c cVar2 = mVar.e;
                    if (cVar2 != null && (objPoll = cVar2.poll()) != null) {
                        cVar.onNext(objPoll);
                        mVar.b();
                        j8++;
                        if (j8 == j7) {
                            break;
                        } else {
                            z7 = false;
                        }
                    }
                }
                j6 = 0;
                if (z8 && z7) {
                    cVar.onComplete();
                    return;
                }
            } while (!z7);
            if (j8 == j7) {
                if (this.e) {
                    b();
                    return;
                }
                Throwable th2 = (Throwable) this.c.get();
                if (th2 != null) {
                    b();
                    cVar.onError(th2);
                    return;
                }
                boolean z9 = this.f6151f.get() == 0;
                int i6 = 0;
                while (true) {
                    if (i6 >= length) {
                        z6 = true;
                        break;
                    }
                    p083o3.c cVar3 = mVarArr[i6].e;
                    if (cVar3 != null && !cVar3.isEmpty()) {
                        break;
                    } else {
                        i6++;
                    }
                }
                if (z9 && z6) {
                    cVar.onComplete();
                    return;
                }
            }
            if (j8 != j6 && j7 != LocationRequestCompat.PASSIVE_INTERVAL) {
                this.d.addAndGet(-j8);
            }
            int iAddAndGet = get();
            if (iAddAndGet == i5 && (iAddAndGet = addAndGet(-i5)) == 0) {
                return;
            } else {
                i5 = iAddAndGet;
            }
        }
    }
}
