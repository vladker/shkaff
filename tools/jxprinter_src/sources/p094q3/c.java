package p094q3;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class c extends a {
    private static final long serialVersionUID = -2151279923272604993L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t5.c f7842a;
    public Object b;

    public c(t5.c cVar) {
        this.f7842a = cVar;
    }

    @Override // p043h3.f
    public final int c(int i5) {
        lazySet(8);
        return 2;
    }

    public void cancel() {
        set(4);
        this.b = null;
    }

    @Override // p043h3.j
    public final void clear() {
        lazySet(32);
        this.b = null;
    }

    public final void e(Object obj) {
        int i5 = get();
        do {
            t5.c cVar = this.f7842a;
            if (i5 == 8) {
                this.b = obj;
                lazySet(16);
                cVar.onNext(obj);
                if (get() != 4) {
                    cVar.onComplete();
                    return;
                }
                return;
            }
            if ((i5 & (-3)) != 0) {
                return;
            }
            if (i5 == 2) {
                lazySet(3);
                cVar.onNext(obj);
                if (get() != 4) {
                    cVar.onComplete();
                    return;
                }
                return;
            }
            this.b = obj;
            if (compareAndSet(0, 1)) {
                return;
            } else {
                i5 = get();
            }
        } while (i5 != 4);
        this.b = null;
    }

    @Override // p043h3.j
    public final boolean isEmpty() {
        return get() != 16;
    }

    public void onSuccess(Object obj) {
        e(obj);
    }

    @Override // p094q3.a, p043h3.g, p043h3.f, p043h3.j
    public final Object poll() {
        if (get() != 16) {
            return null;
        }
        lazySet(32);
        Object obj = this.b;
        this.b = null;
        return obj;
    }

    @Override // t5.d
    public final void request(long j6) {
        Object obj;
        if (g.f(j6)) {
            do {
                int i5 = get();
                if ((i5 & (-2)) != 0) {
                    return;
                }
                if (i5 == 1) {
                    if (!compareAndSet(1, 3) || (obj = this.b) == null) {
                        return;
                    }
                    this.b = null;
                    t5.c cVar = this.f7842a;
                    cVar.onNext(obj);
                    if (get() != 4) {
                        cVar.onComplete();
                        return;
                    }
                    return;
                }
            } while (!compareAndSet(0, 2));
        }
    }
}
