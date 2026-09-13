package io.reactivex.internal.operators.flowable;

import io.reactivex.InterfaceC0984q;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class T extends p094q3.f implements InterfaceC0984q {
    private static final long serialVersionUID = -8158322871608889516L;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final t5.c f4432i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final t5.b[] f4433j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f4434k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final AtomicInteger f4435l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f4436m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ArrayList f4437n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f4438o;

    public T(t5.b[] bVarArr, boolean z6, t5.c cVar) {
        super(false);
        this.f4432i = cVar;
        this.f4433j = bVarArr;
        this.f4434k = z6;
        this.f4435l = new AtomicInteger();
    }

    @Override // t5.c
    public final void onComplete() {
        AtomicInteger atomicInteger = this.f4435l;
        if (atomicInteger.getAndIncrement() != 0) {
            return;
        }
        t5.b[] bVarArr = this.f4433j;
        int length = bVarArr.length;
        int i5 = this.f4436m;
        while (true) {
            t5.c cVar = this.f4432i;
            if (i5 == length) {
                ArrayList arrayList = this.f4437n;
                if (arrayList == null) {
                    cVar.onComplete();
                    return;
                } else if (arrayList.size() == 1) {
                    cVar.onError((Throwable) arrayList.get(0));
                    return;
                } else {
                    cVar.onError(new p017c3.c(arrayList));
                    return;
                }
            }
            t5.b bVar = bVarArr[i5];
            if (bVar == null) {
                NullPointerException nullPointerException = new NullPointerException("A Publisher entry is null");
                if (!this.f4434k) {
                    cVar.onError(nullPointerException);
                    return;
                }
                ArrayList arrayList2 = this.f4437n;
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList((length - i5) + 1);
                    this.f4437n = arrayList2;
                }
                arrayList2.add(nullPointerException);
                i5++;
            } else {
                long j6 = this.f4438o;
                if (j6 != 0) {
                    this.f4438o = 0L;
                    d(j6);
                }
                bVar.subscribe(this);
                i5++;
                this.f4436m = i5;
                if (atomicInteger.decrementAndGet() == 0) {
                    return;
                }
            }
        }
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        if (!this.f4434k) {
            this.f4432i.onError(th);
            return;
        }
        ArrayList arrayList = this.f4437n;
        if (arrayList == null) {
            arrayList = new ArrayList((this.f4433j.length - this.f4436m) + 1);
            this.f4437n = arrayList;
        }
        arrayList.add(th);
        onComplete();
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        this.f4438o++;
        this.f4432i.onNext(obj);
    }
}
