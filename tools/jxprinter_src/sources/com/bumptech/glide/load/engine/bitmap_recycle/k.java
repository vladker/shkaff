package com.bumptech.glide.load.engine.bitmap_recycle;

import L0.s;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class k implements c {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Bitmap.Config f2989k = Bitmap.Config.ARGB_8888;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q f2990a;
    public final Set b;
    public final long c;
    public final V1.b d;
    public long e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f2991f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f2992g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f2993h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f2994i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f2995j;

    public k(long j6) {
        q qVar = new q();
        Set<Bitmap.Config> defaultAllowedConfigs = getDefaultAllowedConfigs();
        this.c = j6;
        this.e = j6;
        this.f2990a = qVar;
        this.b = defaultAllowedConfigs;
        this.d = new V1.b(10);
    }

    @TargetApi(26)
    private static void assertNotHardwareConfig(Bitmap.Config config) {
        if (config != Bitmap.Config.HARDWARE) {
            return;
        }
        throw new IllegalArgumentException("Cannot create a mutable Bitmap with config: " + config + ". Consider setting Downsampler#ALLOW_HARDWARE_CONFIG to false in your RequestOptions and/or in GlideBuilder.setDefaultRequestOptions");
    }

    @NonNull
    private static Bitmap createBitmap(int i5, int i6, @Nullable Bitmap.Config config) {
        if (config == null) {
            config = f2989k;
        }
        return Bitmap.createBitmap(i5, i6, config);
    }

    @TargetApi(26)
    private static Set<Bitmap.Config> getDefaultAllowedConfigs() {
        HashSet hashSet = new HashSet(Arrays.asList(Bitmap.Config.values()));
        hashSet.add(null);
        hashSet.remove(Bitmap.Config.HARDWARE);
        return Collections.unmodifiableSet(hashSet);
    }

    @Nullable
    private synchronized Bitmap getDirtyOrNull(int i5, int i6, @Nullable Bitmap.Config config) {
        Bitmap bitmap;
        try {
            assertNotHardwareConfig(config);
            bitmap = this.f2990a.get(i5, i6, config != null ? config : f2989k);
            if (bitmap == null) {
                if (Log.isLoggable("LruBitmapPool", 3)) {
                    StringBuilder sb = new StringBuilder("Missing bitmap=");
                    this.f2990a.getClass();
                    sb.append(q.b(s.getBitmapByteSize(i5, i6, config), config));
                    Log.d("LruBitmapPool", sb.toString());
                }
                this.f2993h++;
            } else {
                this.f2992g++;
                long j6 = this.f2991f;
                this.f2990a.getClass();
                this.f2991f = j6 - ((long) s.getBitmapByteSize(bitmap));
                this.d.getClass();
                bitmap.setHasAlpha(true);
                maybeSetPreMultiplied(bitmap);
            }
            if (Log.isLoggable("LruBitmapPool", 2)) {
                StringBuilder sb2 = new StringBuilder("Get bitmap=");
                this.f2990a.getClass();
                sb2.append(q.b(s.getBitmapByteSize(i5, i6, config), config));
                Log.v("LruBitmapPool", sb2.toString());
            }
            if (Log.isLoggable("LruBitmapPool", 2)) {
                d();
            }
        } catch (Throwable th) {
            throw th;
        }
        return bitmap;
    }

    @TargetApi(19)
    private static void maybeSetPreMultiplied(Bitmap bitmap) {
        bitmap.setPremultiplied(true);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.c
    public final synchronized void a(float f6) {
        long jRound = Math.round(this.c * f6);
        this.e = jRound;
        e(jRound);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.c
    public final synchronized void b(Bitmap bitmap) {
        try {
            if (bitmap == null) {
                throw new NullPointerException("Bitmap must not be null");
            }
            if (bitmap.isRecycled()) {
                throw new IllegalStateException("Cannot pool recycled bitmap");
            }
            if (bitmap.isMutable()) {
                this.f2990a.getClass();
                if (s.getBitmapByteSize(bitmap) <= this.e && this.b.contains(bitmap.getConfig())) {
                    this.f2990a.getClass();
                    int bitmapByteSize = s.getBitmapByteSize(bitmap);
                    this.f2990a.d(bitmap);
                    this.d.getClass();
                    this.f2994i++;
                    this.f2991f += (long) bitmapByteSize;
                    if (Log.isLoggable("LruBitmapPool", 2)) {
                        StringBuilder sb = new StringBuilder("Put bitmap in pool=");
                        this.f2990a.getClass();
                        sb.append(q.b(s.getBitmapByteSize(bitmap), bitmap.getConfig()));
                        Log.v("LruBitmapPool", sb.toString());
                    }
                    if (Log.isLoggable("LruBitmapPool", 2)) {
                        d();
                    }
                    e(this.e);
                    return;
                }
            }
            if (Log.isLoggable("LruBitmapPool", 2)) {
                StringBuilder sb2 = new StringBuilder("Reject bitmap from pool, bitmap: ");
                this.f2990a.getClass();
                sb2.append(q.b(s.getBitmapByteSize(bitmap), bitmap.getConfig()));
                sb2.append(", is mutable: ");
                sb2.append(bitmap.isMutable());
                sb2.append(", is allowed config: ");
                sb2.append(this.b.contains(bitmap.getConfig()));
                Log.v("LruBitmapPool", sb2.toString());
            }
            bitmap.recycle();
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.c
    public final void c() {
        if (Log.isLoggable("LruBitmapPool", 3)) {
            Log.d("LruBitmapPool", "clearMemory");
        }
        e(0L);
    }

    public final void d() {
        Log.v("LruBitmapPool", "Hits=" + this.f2992g + ", misses=" + this.f2993h + ", puts=" + this.f2994i + ", evictions=" + this.f2995j + ", currentSize=" + this.f2991f + ", maxSize=" + this.e + "\nStrategy=" + this.f2990a);
    }

    public final synchronized void e(long j6) {
        while (this.f2991f > j6) {
            try {
                Bitmap bitmapRemoveLast = this.f2990a.removeLast();
                if (bitmapRemoveLast == null) {
                    if (Log.isLoggable("LruBitmapPool", 5)) {
                        Log.w("LruBitmapPool", "Size mismatch, resetting");
                        d();
                    }
                    this.f2991f = 0L;
                    return;
                }
                this.d.getClass();
                long j7 = this.f2991f;
                this.f2990a.getClass();
                this.f2991f = j7 - ((long) s.getBitmapByteSize(bitmapRemoveLast));
                this.f2995j++;
                if (Log.isLoggable("LruBitmapPool", 3)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Evicting bitmap=");
                    this.f2990a.getClass();
                    sb.append(q.b(s.getBitmapByteSize(bitmapRemoveLast), bitmapRemoveLast.getConfig()));
                    Log.d("LruBitmapPool", sb.toString());
                }
                if (Log.isLoggable("LruBitmapPool", 2)) {
                    d();
                }
                bitmapRemoveLast.recycle();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.c
    @NonNull
    public Bitmap get(int i5, int i6, Bitmap.Config config) {
        Bitmap dirtyOrNull = getDirtyOrNull(i5, i6, config);
        if (dirtyOrNull == null) {
            return createBitmap(i5, i6, config);
        }
        dirtyOrNull.eraseColor(0);
        return dirtyOrNull;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.c
    @NonNull
    public Bitmap getDirty(int i5, int i6, Bitmap.Config config) {
        Bitmap dirtyOrNull = getDirtyOrNull(i5, i6, config);
        return dirtyOrNull == null ? createBitmap(i5, i6, config) : dirtyOrNull;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.c
    @SuppressLint({"InlinedApi"})
    public void trimMemory(int i5) {
        if (Log.isLoggable("LruBitmapPool", 3)) {
            androidx.exifinterface.media.a.v(i5, "trimMemory, level=", "LruBitmapPool");
        }
        if (i5 >= 40 || i5 >= 20) {
            c();
        } else if (i5 >= 20 || i5 == 15) {
            e(this.e / 2);
        }
    }
}
