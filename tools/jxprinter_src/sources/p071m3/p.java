package p071m3;

import androidx.core.location.LocationRequestCompat;
import com.google.android.gms.auth.api.accounttransfer.a;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import p017c3.e;
import p100r3.c;
import p100r3.g;
import t5.d;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class p extends o {
    private static final long serialVersionUID = -5737965195918321883L;

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
        cVar.getClass();
        g.a(cVar, th);
        this.f6151f.decrementAndGet();
        c();
    }

    @Override // p071m3.o
    public final void f(m mVar, Object obj) {
        int i5 = get();
        AtomicInteger atomicInteger = this.f6151f;
        c cVar = this.c;
        if (i5 == 0 && compareAndSet(0, 1)) {
            AtomicLong atomicLong = this.d;
            if (atomicLong.get() != 0) {
                this.f6150a.onNext(obj);
                if (atomicLong.get() != LocationRequestCompat.PASSIVE_INTERVAL) {
                    atomicLong.decrementAndGet();
                }
                long j6 = mVar.d + 1;
                if (j6 >= mVar.c) {
                    mVar.d = 0L;
                    ((d) mVar.get()).request(j6);
                } else {
                    mVar.d = j6;
                }
            } else if (!((p083o3.c) mVar.a()).offer(obj)) {
                p094q3.g.a(mVar);
                e eVar = new e("Queue full?!");
                cVar.getClass();
                g.a(cVar, eVar);
                atomicInteger.decrementAndGet();
                g();
                return;
            }
            if (decrementAndGet() == 0) {
                return;
            }
        } else {
            if (!((p083o3.c) mVar.a()).offer(obj) && p094q3.g.a(mVar)) {
                e eVar2 = new e("Queue full?!");
                cVar.getClass();
                g.a(cVar, eVar2);
                atomicInteger.decrementAndGet();
            }
            if (getAndIncrement() != 0) {
                return;
            }
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
                    if (((Throwable) this.c.get()) == null) {
                        cVar.onComplete();
                        return;
                    } else {
                        c cVar3 = this.c;
                        a.q(cVar3, cVar3, cVar);
                        return;
                    }
                }
            } while (!z7);
            if (j8 == j7) {
                if (this.e) {
                    b();
                    return;
                }
                boolean z9 = this.f6151f.get() == 0;
                int i6 = 0;
                while (true) {
                    if (i6 >= length) {
                        z6 = true;
                        break;
                    }
                    p083o3.c cVar4 = mVarArr[i6].e;
                    if (cVar4 != null && !cVar4.isEmpty()) {
                        break;
                    } else {
                        i6++;
                    }
                }
                if (z9 && z6) {
                    if (((Throwable) this.c.get()) == null) {
                        cVar.onComplete();
                        return;
                    } else {
                        c cVar5 = this.c;
                        a.q(cVar5, cVar5, cVar);
                        return;
                    }
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
