package io.reactivex.internal.operators.flowable;

import androidx.core.location.LocationRequestCompat;

/* JADX INFO: renamed from: io.reactivex.internal.operators.flowable.y1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC0828y1 extends p094q3.b {
    private static final long serialVersionUID = -2252972430506210021L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object[] f4843a;
    public int b;
    public volatile boolean c;

    public AbstractC0828y1(Object[] objArr) {
        this.f4843a = objArr;
    }

    public abstract void a();

    @Override // p043h3.f
    public final int c(int i5) {
        return 1;
    }

    @Override // t5.d
    public final void cancel() {
        this.c = true;
    }

    @Override // p043h3.j
    public final void clear() {
        this.b = this.f4843a.length;
    }

    public abstract void e(long j6);

    @Override // p043h3.j
    public final boolean isEmpty() {
        return this.b == this.f4843a.length;
    }

    @Override // p094q3.b, p043h3.g, p043h3.f, p043h3.j
    public final Object poll() {
        int i5 = this.b;
        Object[] objArr = this.f4843a;
        if (i5 == objArr.length) {
            return null;
        }
        this.b = i5 + 1;
        Object obj = objArr[i5];
        p039g3.A.b(obj, "array element is null");
        return obj;
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
