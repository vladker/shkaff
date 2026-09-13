package com.bumptech.glide.load.resource.gif;

import L0.s;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.bumptech.glide.A;
import com.bumptech.glide.load.engine.AbstractC0501q;
import com.bumptech.glide.z;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bumptech.glide.gifdecoder.b f3146a;
    public final Handler b;
    public final ArrayList c;
    public final A d;
    public final com.bumptech.glide.load.engine.bitmap_recycle.c e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f3147f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f3148g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public z f3149h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public j f3150i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f3151j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public j f3152k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Bitmap f3153l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public j f3154m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f3155n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f3156o;

    @Nullable
    private m onEveryFrameListener;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f3157p;

    public n(com.bumptech.glide.c cVar, com.bumptech.glide.gifdecoder.b bVar, int i5, int i6, p126w0.z zVar, Bitmap bitmap) {
        com.bumptech.glide.load.engine.bitmap_recycle.c bitmapPool = cVar.getBitmapPool();
        A aWith = com.bumptech.glide.c.with(cVar.getContext());
        z zVarApply = com.bumptech.glide.c.with(cVar.getContext()).asBitmap().apply(((I0.j) ((I0.j) I0.j.diskCacheStrategyOf(AbstractC0501q.f3068a).useAnimationPool(true)).skipMemoryCache(true)).override(i5, i6));
        this.c = new ArrayList();
        this.d = aWith;
        Handler handler = new Handler(Looper.getMainLooper(), new l(this));
        this.e = bitmapPool;
        this.b = handler;
        this.f3149h = zVarApply;
        this.f3146a = bVar;
        b(zVar, bitmap);
    }

    public final void a() {
        int i5;
        int i6;
        if (!this.f3147f || this.f3148g) {
            return;
        }
        j jVar = this.f3154m;
        if (jVar != null) {
            this.f3154m = null;
            onFrameReady(jVar);
            return;
        }
        this.f3148g = true;
        com.bumptech.glide.gifdecoder.b bVar = this.f3146a;
        com.bumptech.glide.gifdecoder.f fVar = (com.bumptech.glide.gifdecoder.f) bVar;
        com.bumptech.glide.gifdecoder.d dVar = fVar.f2890j;
        int i7 = dVar.b;
        if (i7 <= 0 || (i6 = fVar.f2889i) < 0) {
            i5 = 0;
        } else {
            i5 = (i6 < 0 || i6 >= i7) ? -1 : ((com.bumptech.glide.gifdecoder.c) dVar.d.get(i6)).f2876i;
        }
        long jUptimeMillis = SystemClock.uptimeMillis() + ((long) i5);
        int i8 = (fVar.f2889i + 1) % fVar.f2890j.b;
        fVar.f2889i = i8;
        this.f3152k = new j(this.b, i8, jUptimeMillis);
        this.f3149h.apply((I0.a) I0.j.signatureOf(new K0.d(Double.valueOf(Math.random())))).load((Object) bVar).into(this.f3152k);
    }

    public final void b(p126w0.z zVar, Bitmap bitmap) {
        this.f3153l = (Bitmap) L0.q.checkNotNull(bitmap);
        this.f3149h = this.f3149h.apply(new I0.j().transform(zVar));
        this.f3155n = s.getBitmapByteSize(bitmap);
        this.f3156o = bitmap.getWidth();
        this.f3157p = bitmap.getHeight();
    }

    @VisibleForTesting
    public void onFrameReady(j jVar) {
        this.f3148g = false;
        boolean z6 = this.f3151j;
        Handler handler = this.b;
        if (z6) {
            handler.obtainMessage(2, jVar).sendToTarget();
            return;
        }
        if (!this.f3147f) {
            this.f3154m = jVar;
            return;
        }
        if (jVar.d != null) {
            Bitmap bitmap = this.f3153l;
            if (bitmap != null) {
                this.e.b(bitmap);
                this.f3153l = null;
            }
            j jVar2 = this.f3150i;
            this.f3150i = jVar;
            ArrayList arrayList = this.c;
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                f fVar = (f) ((k) arrayList.get(size));
                Object callback = fVar.getCallback();
                while (callback instanceof Drawable) {
                    callback = ((Drawable) callback).getCallback();
                }
                if (callback == null) {
                    fVar.stop();
                    fVar.invalidateSelf();
                } else {
                    fVar.invalidateSelf();
                    n nVar = fVar.f3137a.frameLoader;
                    j jVar3 = nVar.f3150i;
                    if ((jVar3 != null ? jVar3.b : -1) == ((com.bumptech.glide.gifdecoder.f) nVar.f3146a).f2890j.b - 1) {
                        fVar.f3138f++;
                    }
                    int i5 = fVar.f3139g;
                    if (i5 != -1 && fVar.f3138f >= i5) {
                        ArrayList arrayList2 = fVar.f3143k;
                        if (arrayList2 != null) {
                            int size2 = arrayList2.size();
                            for (int i6 = 0; i6 < size2; i6++) {
                                ((Animatable2Compat.AnimationCallback) fVar.f3143k.get(i6)).onAnimationEnd(fVar);
                            }
                        }
                        fVar.stop();
                    }
                }
            }
            if (jVar2 != null) {
                handler.obtainMessage(2, jVar2).sendToTarget();
            }
        }
        a();
    }

    @VisibleForTesting
    public void setOnEveryFrameReadyListener(@Nullable m mVar) {
    }
}
