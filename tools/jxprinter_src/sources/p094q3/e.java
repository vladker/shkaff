package p094q3;

import java.util.concurrent.atomic.AtomicInteger;
import p043h3.g;
import t5.c;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class e extends AtomicInteger implements g {
    private static final long serialVersionUID = -3830916580126663321L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f7844a;
    public final c b;

    public e(Object obj, c cVar) {
        this.b = cVar;
        this.f7844a = obj;
    }

    @Override // p043h3.f
    public final int c(int i5) {
        return 1;
    }

    @Override // t5.d
    public final void cancel() {
        lazySet(2);
    }

    @Override // p043h3.j
    public final void clear() {
        lazySet(1);
    }

    @Override // p043h3.j
    public final boolean isEmpty() {
        return get() != 0;
    }

    @Override // p043h3.g, p043h3.f, p043h3.j
    public final boolean offer(Object obj) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // p043h3.g, p043h3.f, p043h3.j
    public Object poll() {
        if (get() != 0) {
            return null;
        }
        lazySet(1);
        return this.f7844a;
    }

    @Override // t5.d
    public final void request(long j6) {
        if (g.f(j6) && compareAndSet(0, 1)) {
            Object obj = this.f7844a;
            c cVar = this.b;
            cVar.onNext(obj);
            if (get() != 2) {
                cVar.onComplete();
            }
        }
    }

    @Override // p043h3.g, p043h3.f, p043h3.j
    public final boolean offer(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Should not be called!");
    }
}
