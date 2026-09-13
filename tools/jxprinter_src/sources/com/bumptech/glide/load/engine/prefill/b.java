package com.bumptech.glide.load.engine.prefill;

import android.os.Handler;
import android.os.SystemClock;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.load.engine.cache.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class b implements Runnable {

    @VisibleForTesting
    static final String TAG = "PreFillRunner";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f3062g = new a();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final long f3063h = TimeUnit.SECONDS.toMillis(1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f3064a;
    public final a b;
    public final Handler d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f3065f;
    public final HashSet c = new HashSet();
    public long e = 40;

    @VisibleForTesting
    public b(com.bumptech.glide.load.engine.bitmap_recycle.c cVar, h hVar, d dVar, a aVar, Handler handler) {
        this.f3064a = dVar;
        this.b = aVar;
        this.d = handler;
    }

    @VisibleForTesting
    public boolean allocate() {
        this.b.getClass();
        long jCurrentThreadTimeMillis = SystemClock.currentThreadTimeMillis();
        d dVar = this.f3064a;
        if (dVar.c == 0 || SystemClock.currentThreadTimeMillis() - jCurrentThreadTimeMillis >= 32) {
            return (this.f3065f || dVar.c == 0) ? false : true;
        }
        ArrayList arrayList = dVar.b;
        if (arrayList.get(dVar.d) != null) {
            throw new ClassCastException();
        }
        HashMap map = dVar.f3067a;
        Integer num = (Integer) map.get(null);
        if (num.intValue() == 1) {
            map.remove(null);
            arrayList.remove(dVar.d);
        } else {
            map.put(null, Integer.valueOf(num.intValue() - 1));
        }
        dVar.c--;
        dVar.d = arrayList.isEmpty() ? 0 : (dVar.d + 1) % arrayList.size();
        HashSet hashSet = this.c;
        if (hashSet.contains(null)) {
            throw null;
        }
        hashSet.add(null);
        throw null;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (allocate()) {
            long j6 = this.e;
            this.e = Math.min(4 * j6, f3063h);
            this.d.postDelayed(this, j6);
        }
    }
}
