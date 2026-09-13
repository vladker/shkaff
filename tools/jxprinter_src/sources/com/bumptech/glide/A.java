package com.bumptech.glide;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.View;
import androidx.annotation.CheckResult;
import androidx.annotation.DrawableRes;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import com.bumptech.glide.load.engine.AbstractC0501q;
import com.bumptech.glide.manager.C0537g;
import com.bumptech.glide.manager.G;
import com.bumptech.glide.manager.InterfaceC0533c;
import com.bumptech.glide.manager.InterfaceC0534d;
import com.bumptech.glide.manager.InterfaceC0535e;
import java.io.File;
import java.net.URL;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import org.apache.commons.math3.geometry.VectorFormat;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class A implements ComponentCallbacks2, com.bumptech.glide.manager.m, n {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final I0.j f2858g = (I0.j) I0.j.decodeTypeOf(Bitmap.class).lock();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final I0.j f2859h = (I0.j) I0.j.decodeTypeOf(com.bumptech.glide.load.resource.gif.f.class).lock();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final I0.j f2860i = (I0.j) ((I0.j) I0.j.diskCacheStrategyOf(AbstractC0501q.b).priority(o.d)).skipMemoryCache(true);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f2861a;
    public final Context b;
    public final com.bumptech.glide.manager.k c;
    public final H2.c d;
    public final InterfaceC0534d e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final CopyOnWriteArrayList f2862f;

    @GuardedBy("this")
    private I0.j requestOptions;

    @GuardedBy("this")
    private final com.bumptech.glide.manager.x requestTracker;

    @GuardedBy("this")
    private final G targetTracker;

    @GuardedBy("this")
    private final com.bumptech.glide.manager.w treeNode;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class b implements InterfaceC0533c {

        @GuardedBy("RequestManager.this")
        private final com.bumptech.glide.manager.x requestTracker;

        public b(com.bumptech.glide.manager.x xVar) {
            this.requestTracker = xVar;
        }

        @Override // com.bumptech.glide.manager.InterfaceC0533c
        public final void a(boolean z6) {
            if (z6) {
                synchronized (A.this) {
                    com.bumptech.glide.manager.x xVar = this.requestTracker;
                    for (I0.d dVar : L0.s.getSnapshot(xVar.f3181a)) {
                        if (!dVar.g() && !dVar.b()) {
                            dVar.clear();
                            if (xVar.c) {
                                xVar.b.add(dVar);
                            } else {
                                dVar.e();
                            }
                        }
                    }
                }
            }
        }
    }

    public A(@NonNull c cVar, @NonNull com.bumptech.glide.manager.k kVar, @NonNull com.bumptech.glide.manager.w wVar, @NonNull Context context) {
        com.bumptech.glide.manager.x xVar = new com.bumptech.glide.manager.x();
        InterfaceC0535e interfaceC0535e = cVar.f2868g;
        this.targetTracker = new G();
        H2.c cVar2 = new H2.c(this, 10);
        this.d = cVar2;
        this.f2861a = cVar;
        this.c = kVar;
        this.treeNode = wVar;
        this.requestTracker = xVar;
        this.b = context;
        InterfaceC0534d interfaceC0534dBuild = ((C0537g) interfaceC0535e).build(context.getApplicationContext(), new b(xVar));
        this.e = interfaceC0534dBuild;
        cVar.a(this);
        if (L0.s.d()) {
            L0.s.b().post(cVar2);
        } else {
            kVar.addListener(this);
        }
        kVar.addListener(interfaceC0534dBuild);
        this.f2862f = new CopyOnWriteArrayList(cVar.getGlideContext().e);
        setRequestOptions(cVar.getGlideContext().a());
    }

    private void untrackOrDelegate(@NonNull com.bumptech.glide.request.target.k kVar) {
        boolean zUntrack = untrack(kVar);
        I0.d request = kVar.getRequest();
        if (zUntrack || this.f2861a.removeFromManagers(kVar) || request == null) {
            return;
        }
        kVar.setRequest(null);
        request.clear();
    }

    private synchronized void updateRequestOptions(@NonNull I0.j jVar) {
        this.requestOptions = (I0.j) this.requestOptions.apply(jVar);
    }

    public final synchronized I0.j a() {
        return this.requestOptions;
    }

    @NonNull
    public synchronized A applyDefaultRequestOptions(@NonNull I0.j jVar) {
        updateRequestOptions(jVar);
        return this;
    }

    @NonNull
    @CheckResult
    public <ResourceType> z as(@NonNull Class<ResourceType> cls) {
        return new z(this.f2861a, this, cls, this.b);
    }

    @NonNull
    @CheckResult
    public z asBitmap() {
        return as(Bitmap.class).apply((I0.a) f2858g);
    }

    @NonNull
    @CheckResult
    public z asDrawable() {
        return as(Drawable.class);
    }

    @NonNull
    @CheckResult
    public z asFile() {
        return as(File.class).apply((I0.a) I0.j.skipMemoryCacheOf(true));
    }

    @NonNull
    @CheckResult
    public z asGif() {
        return as(com.bumptech.glide.load.resource.gif.f.class).apply((I0.a) f2859h);
    }

    public final synchronized void b() {
        com.bumptech.glide.manager.x xVar = this.requestTracker;
        xVar.c = true;
        for (I0.d dVar : L0.s.getSnapshot(xVar.f3181a)) {
            if (dVar.isRunning()) {
                dVar.pause();
                xVar.b.add(dVar);
            }
        }
    }

    public final synchronized void c() {
        com.bumptech.glide.manager.x xVar = this.requestTracker;
        xVar.c = false;
        for (I0.d dVar : L0.s.getSnapshot(xVar.f3181a)) {
            if (!dVar.g() && !dVar.isRunning()) {
                dVar.e();
            }
        }
        xVar.b.clear();
    }

    public void clear(@NonNull View view) {
        clear(new a(view));
    }

    @NonNull
    @CheckResult
    public z download(@Nullable Object obj) {
        return downloadOnly().load(obj);
    }

    @NonNull
    @CheckResult
    public z downloadOnly() {
        return as(File.class).apply((I0.a) f2860i);
    }

    @NonNull
    public <T> B getDefaultTransitionOptions(Class<T> cls) {
        return this.f2861a.getGlideContext().getDefaultTransitionOptions(cls);
    }

    @Override // com.bumptech.glide.manager.m
    public final synchronized void onDestroy() {
        try {
            this.targetTracker.onDestroy();
            Iterator<com.bumptech.glide.request.target.k> it = this.targetTracker.getAll().iterator();
            while (it.hasNext()) {
                clear(it.next());
            }
            this.targetTracker.f3168a.clear();
            com.bumptech.glide.manager.x xVar = this.requestTracker;
            Iterator it2 = L0.s.getSnapshot(xVar.f3181a).iterator();
            while (it2.hasNext()) {
                xVar.clearAndRemove((I0.d) it2.next());
            }
            xVar.b.clear();
            this.c.removeListener(this);
            this.c.removeListener(this.e);
            L0.s.b().removeCallbacks(this.d);
            this.f2861a.b(this);
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.bumptech.glide.manager.m
    public final synchronized void onStart() {
        c();
        this.targetTracker.onStart();
    }

    @Override // com.bumptech.glide.manager.m
    public final synchronized void onStop() {
        b();
        this.targetTracker.onStop();
    }

    @NonNull
    public synchronized A setDefaultRequestOptions(@NonNull I0.j jVar) {
        setRequestOptions(jVar);
        return this;
    }

    public synchronized void setRequestOptions(@NonNull I0.j jVar) {
        this.requestOptions = (I0.j) ((I0.j) jVar.mo813clone()).autoClone();
    }

    public final synchronized String toString() {
        return super.toString() + "{tracker=" + this.requestTracker + ", treeNode=" + this.treeNode + VectorFormat.DEFAULT_SUFFIX;
    }

    public synchronized void track(@NonNull com.bumptech.glide.request.target.k kVar, @NonNull I0.d dVar) {
        this.targetTracker.track(kVar);
        this.requestTracker.runRequest(dVar);
    }

    public synchronized boolean untrack(@NonNull com.bumptech.glide.request.target.k kVar) {
        I0.d request = kVar.getRequest();
        if (request == null) {
            return true;
        }
        if (!this.requestTracker.clearAndRemove(request)) {
            return false;
        }
        this.targetTracker.untrack(kVar);
        kVar.setRequest(null);
        return true;
    }

    public void clear(@Nullable com.bumptech.glide.request.target.k kVar) {
        if (kVar == null) {
            return;
        }
        untrackOrDelegate(kVar);
    }

    @Override // com.bumptech.glide.n
    @NonNull
    @CheckResult
    public z load(@Nullable Bitmap bitmap) {
        return asDrawable().load(bitmap);
    }

    @Override // com.bumptech.glide.n
    @NonNull
    @CheckResult
    public z load(@Nullable Drawable drawable) {
        return asDrawable().load(drawable);
    }

    @Override // com.bumptech.glide.n
    @NonNull
    @CheckResult
    public z load(@Nullable String str) {
        return asDrawable().load(str);
    }

    @Override // com.bumptech.glide.n
    @NonNull
    @CheckResult
    public z load(@Nullable Uri uri) {
        return asDrawable().load(uri);
    }

    @Override // com.bumptech.glide.n
    @NonNull
    @CheckResult
    public z load(@Nullable File file) {
        return asDrawable().load(file);
    }

    @Override // com.bumptech.glide.n
    @NonNull
    @CheckResult
    public z load(@Nullable @DrawableRes @RawRes Integer num) {
        return asDrawable().load(num);
    }

    @Override // com.bumptech.glide.n
    @CheckResult
    @Deprecated
    public z load(@Nullable URL url) {
        return asDrawable().load(url);
    }

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
    }

    @Override // com.bumptech.glide.n
    @NonNull
    @CheckResult
    public z load(@Nullable byte[] bArr) {
        return asDrawable().load(bArr);
    }

    @Override // com.bumptech.glide.n
    @NonNull
    @CheckResult
    public z load(@Nullable Object obj) {
        return asDrawable().load(obj);
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class a extends com.bumptech.glide.request.target.e {
        public a(@NonNull View view) {
            super(view);
        }

        @Override // com.bumptech.glide.request.target.e, com.bumptech.glide.request.target.k
        public void onLoadFailed(@Nullable Drawable drawable) {
        }

        @Override // com.bumptech.glide.request.target.e
        public void onResourceCleared(@Nullable Drawable drawable) {
        }

        @Override // com.bumptech.glide.request.target.e, com.bumptech.glide.request.target.k
        public void onResourceReady(@NonNull Object obj, @Nullable J0.d dVar) {
        }
    }

    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
    }

    @Override // android.content.ComponentCallbacks2
    public final void onTrimMemory(int i5) {
    }
}
