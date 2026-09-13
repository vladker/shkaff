package com.bumptech.glide;

import android.content.Context;
import android.content.ContextWrapper;
import android.widget.ImageView;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class j extends ContextWrapper {

    @VisibleForTesting
    static final B DEFAULT_TRANSITION_OPTIONS = new C0483a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bumptech.glide.load.engine.bitmap_recycle.a f2908a;
    public final L0.j b;
    public final com.bumptech.glide.request.target.h c;
    public final InterfaceC0484b d;

    @Nullable
    @GuardedBy("this")
    private I0.j defaultRequestOptions;
    public final List e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map f2909f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final com.bumptech.glide.load.engine.x f2910g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final l f2911h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f2912i;

    public j(@NonNull Context context, @NonNull com.bumptech.glide.load.engine.bitmap_recycle.a aVar, @NonNull L0.k kVar, @NonNull com.bumptech.glide.request.target.h hVar, @NonNull InterfaceC0484b interfaceC0484b, @NonNull Map<Class<?>, B> map, @NonNull List<I0.i> list, @NonNull com.bumptech.glide.load.engine.x xVar, @NonNull l lVar, int i5) {
        super(context.getApplicationContext());
        this.f2908a = aVar;
        this.c = hVar;
        this.d = interfaceC0484b;
        this.e = list;
        this.f2909f = map;
        this.f2910g = xVar;
        this.f2911h = lVar;
        this.f2912i = i5;
        this.b = new L0.j(kVar);
    }

    public final synchronized I0.j a() {
        try {
            if (this.defaultRequestOptions == null) {
                this.defaultRequestOptions = (I0.j) this.d.build().lock();
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.defaultRequestOptions;
    }

    @NonNull
    public <X> com.bumptech.glide.request.target.l buildImageViewTarget(@NonNull ImageView imageView, @NonNull Class<X> cls) {
        return this.c.buildTarget(imageView, cls);
    }

    @NonNull
    public com.bumptech.glide.load.engine.bitmap_recycle.a getArrayPool() {
        return this.f2908a;
    }

    @NonNull
    public <T> B getDefaultTransitionOptions(@NonNull Class<T> cls) {
        Map map = this.f2909f;
        B b = (B) map.get(cls);
        if (b == null) {
            for (Map.Entry entry : map.entrySet()) {
                if (((Class) entry.getKey()).isAssignableFrom(cls)) {
                    b = (B) entry.getValue();
                }
            }
        }
        return b == null ? DEFAULT_TRANSITION_OPTIONS : b;
    }

    @NonNull
    public com.bumptech.glide.load.engine.x getEngine() {
        return this.f2910g;
    }

    @NonNull
    public v getRegistry() {
        return (v) this.b.get();
    }
}
