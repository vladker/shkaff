package io.reactivex.internal.operators.flowable;

import androidx.core.location.LocationRequestCompat;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class C1 extends p094q3.b {
    private static final long serialVersionUID = -2252972430506210021L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Iterator f4198a;
    public volatile boolean b;
    public boolean c;

    public C1(Iterator it) {
        this.f4198a = it;
    }

    public abstract void a();

    @Override // p043h3.f
    public final int c(int i5) {
        return 1;
    }

    @Override // t5.d
    public final void cancel() {
        this.b = true;
    }

    @Override // p043h3.j
    public final void clear() {
        this.f4198a = null;
    }

    public abstract void e(long j6);

    @Override // p043h3.j
    public final boolean isEmpty() {
        Iterator it = this.f4198a;
        return it == null || !it.hasNext();
    }

    @Override // p094q3.b, p043h3.g, p043h3.f, p043h3.j
    public final Object poll() {
        Iterator it = this.f4198a;
        if (it == null) {
            return null;
        }
        if (!this.c) {
            this.c = true;
        } else if (!it.hasNext()) {
            return null;
        }
        Object next = this.f4198a.next();
        p039g3.A.b(next, "Iterator.next() returned a null value");
        return next;
    }

    @Override // t5.d
    public final void request(long j6) {
        if (p094q3.g.f(j6) && p122v2.a.a(this, j6) == 0) {
            if (j6 == LocationRequestCompat.PASSIVE_INTERVAL) {
                a();
            } else {
                e(j6);
            }
        }
    }
}
