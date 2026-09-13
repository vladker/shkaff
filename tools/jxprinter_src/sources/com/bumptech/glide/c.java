package com.bumptech.glide;

import android.app.Activity;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.util.Log;
import android.view.View;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.load.resource.bitmap.C0524t;
import com.bumptech.glide.load.resource.bitmap.C0530z;
import com.bumptech.glide.manager.InterfaceC0535e;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractC1125a;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class c implements ComponentCallbacks2 {

    @GuardedBy("Glide.class")
    private static volatile c glide;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static volatile boolean f2865j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bumptech.glide.load.engine.x f2866a;
    public final com.bumptech.glide.load.engine.bitmap_recycle.c b;

    @Nullable
    @GuardedBy("this")
    private com.bumptech.glide.load.engine.prefill.c bitmapPreFiller;
    public final com.bumptech.glide.load.engine.cache.h c;
    public final j d;
    public final com.bumptech.glide.load.engine.bitmap_recycle.a e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.bumptech.glide.manager.v f2867f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final InterfaceC0535e f2868g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final InterfaceC0484b f2869h;

    @GuardedBy("managers")
    private final List<A> managers = new ArrayList();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public m f2870i = m.NORMAL;

    public c(@NonNull Context context, @NonNull com.bumptech.glide.load.engine.x xVar, @NonNull com.bumptech.glide.load.engine.cache.h hVar, @NonNull com.bumptech.glide.load.engine.bitmap_recycle.c cVar, @NonNull com.bumptech.glide.load.engine.bitmap_recycle.a aVar, @NonNull com.bumptech.glide.manager.v vVar, @NonNull InterfaceC0535e interfaceC0535e, int i5, @NonNull InterfaceC0484b interfaceC0484b, @NonNull Map<Class<?>, B> map, @NonNull List<I0.i> list, @NonNull List<Object> list2, @Nullable G0.a aVar2, @NonNull l lVar) {
        this.f2866a = xVar;
        this.b = cVar;
        this.e = aVar;
        this.c = hVar;
        this.f2867f = vVar;
        this.f2868g = interfaceC0535e;
        this.f2869h = interfaceC0484b;
        this.d = new j(context, aVar, x.lazilyCreateAndInitializeRegistry(this, list2, aVar2), new com.bumptech.glide.request.target.h(), interfaceC0484b, map, list, xVar, lVar, i5);
    }

    @GuardedBy("Glide.class")
    @VisibleForTesting
    public static void checkAndInitializeGlide(@NonNull Context context, @Nullable GeneratedAppGlideModule generatedAppGlideModule) {
        if (f2865j) {
            throw new IllegalStateException("Glide has been called recursively, this is probably an internal library error!");
        }
        f2865j = true;
        try {
            initializeGlide(context, generatedAppGlideModule);
        } finally {
            f2865j = false;
        }
    }

    @VisibleForTesting
    public static void enableHardwareBitmaps() {
        C0530z c0530zA = C0530z.a();
        c0530zA.getClass();
        L0.s.a();
        c0530zA.d.set(true);
    }

    @NonNull
    public static c get(@NonNull Context context) {
        if (glide == null) {
            GeneratedAppGlideModule annotationGeneratedGlideModules = getAnnotationGeneratedGlideModules(context.getApplicationContext());
            synchronized (c.class) {
                try {
                    if (glide == null) {
                        checkAndInitializeGlide(context, annotationGeneratedGlideModules);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return glide;
    }

    @Nullable
    private static GeneratedAppGlideModule getAnnotationGeneratedGlideModules(Context context) {
        try {
            return (GeneratedAppGlideModule) Class.forName("com.bumptech.glide.GeneratedAppGlideModuleImpl").getDeclaredConstructor(Context.class).newInstance(context.getApplicationContext());
        } catch (ClassNotFoundException unused) {
            if (!Log.isLoggable("Glide", 5)) {
                return null;
            }
            Log.w("Glide", "Failed to find GeneratedAppGlideModule. You should include an annotationProcessor compile dependency on com.github.bumptech.glide:compiler in your application and a @GlideModule annotated AppGlideModule implementation or LibraryGlideModules will be silently ignored");
            return null;
        } catch (IllegalAccessException e) {
            throw new IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", e);
        } catch (InstantiationException e6) {
            throw new IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", e6);
        } catch (NoSuchMethodException e7) {
            throw new IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", e7);
        } catch (InvocationTargetException e8) {
            throw new IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", e8);
        }
    }

    @Nullable
    public static File getPhotoCacheDir(@NonNull Context context) {
        return getPhotoCacheDir(context, "image_manager_disk_cache");
    }

    @NonNull
    private static com.bumptech.glide.manager.v getRetriever(@Nullable Context context) {
        L0.q.checkNotNull(context, "You cannot start a load on a not yet attached View or a Fragment where getActivity() returns null (which usually occurs when getActivity() is called before the Fragment is attached or after the Fragment is destroyed).");
        return get(context).getRequestManagerRetriever();
    }

    @VisibleForTesting
    @Deprecated
    public static synchronized void init(c cVar) {
        try {
            if (glide != null) {
                tearDown();
            }
            glide = cVar;
        } catch (Throwable th) {
            throw th;
        }
    }

    @GuardedBy("Glide.class")
    private static void initializeGlide(@NonNull Context context, @Nullable GeneratedAppGlideModule generatedAppGlideModule) {
        initializeGlide(context, new i(), generatedAppGlideModule);
    }

    @VisibleForTesting
    public static void tearDown() {
        synchronized (c.class) {
            try {
                if (glide != null) {
                    glide.getContext().getApplicationContext().unregisterComponentCallbacks(glide);
                    glide.f2866a.shutdown();
                }
                glide = null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @NonNull
    public static A with(@NonNull Context context) {
        return getRetriever(context).get(context);
    }

    public final void a(A a6) {
        synchronized (this.managers) {
            try {
                if (this.managers.contains(a6)) {
                    throw new IllegalStateException("Cannot register already registered manager");
                }
                this.managers.add(a6);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void b(A a6) {
        synchronized (this.managers) {
            try {
                if (!this.managers.contains(a6)) {
                    throw new IllegalStateException("Cannot unregister not yet registered manager");
                }
                this.managers.remove(a6);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @NonNull
    public com.bumptech.glide.load.engine.bitmap_recycle.a getArrayPool() {
        return this.e;
    }

    @NonNull
    public com.bumptech.glide.load.engine.bitmap_recycle.c getBitmapPool() {
        return this.b;
    }

    @NonNull
    public Context getContext() {
        return this.d.getBaseContext();
    }

    @NonNull
    public j getGlideContext() {
        return this.d;
    }

    @NonNull
    public v getRegistry() {
        return this.d.getRegistry();
    }

    @NonNull
    public com.bumptech.glide.manager.v getRequestManagerRetriever() {
        return this.f2867f;
    }

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
        L0.s.a();
        ((L0.n) this.c).a(0L);
        this.b.c();
        com.bumptech.glide.load.engine.bitmap_recycle.j jVar = (com.bumptech.glide.load.engine.bitmap_recycle.j) this.e;
        synchronized (jVar) {
            jVar.b(0);
        }
    }

    @Override // android.content.ComponentCallbacks2
    public final void onTrimMemory(int i5) {
        L0.s.a();
        synchronized (this.managers) {
            try {
                Iterator<A> it = this.managers.iterator();
                while (it.hasNext()) {
                    it.next().getClass();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        ((com.bumptech.glide.load.engine.cache.f) this.c).trimMemory(i5);
        this.b.trimMemory(i5);
        com.bumptech.glide.load.engine.bitmap_recycle.j jVar = (com.bumptech.glide.load.engine.bitmap_recycle.j) this.e;
        synchronized (jVar) {
            if (i5 >= 40) {
                synchronized (jVar) {
                    jVar.b(0);
                }
            } else if (i5 >= 20 || i5 == 15) {
                jVar.b(jVar.e / 2);
            }
        }
    }

    public synchronized void preFillBitmapPool(@NonNull com.bumptech.glide.load.engine.prefill.e... eVarArr) {
        try {
            if (this.bitmapPreFiller == null) {
                this.bitmapPreFiller = new com.bumptech.glide.load.engine.prefill.c(this.c, this.b, (p126w0.b) this.f2869h.build().getOptions().get(C0524t.f3119f));
            }
            this.bitmapPreFiller.a(eVarArr);
        } catch (Throwable th) {
            throw th;
        }
    }

    public boolean removeFromManagers(@NonNull com.bumptech.glide.request.target.k kVar) {
        synchronized (this.managers) {
            try {
                Iterator<A> it = this.managers.iterator();
                while (it.hasNext()) {
                    if (it.next().untrack(kVar)) {
                        return true;
                    }
                }
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @NonNull
    public m setMemoryCategory(@NonNull m mVar) {
        L0.s.a();
        Object obj = this.c;
        float f6 = mVar.f3161a;
        L0.n nVar = (L0.n) obj;
        synchronized (nVar) {
            try {
                if (f6 < 0.0f) {
                    throw new IllegalArgumentException("Multiplier must be >= 0");
                }
                long jRound = Math.round(nVar.b * f6);
                nVar.c = jRound;
                nVar.a(jRound);
            } catch (Throwable th) {
                throw th;
            }
        }
        this.b.a(mVar.f3161a);
        m mVar2 = this.f2870i;
        this.f2870i = mVar;
        return mVar2;
    }

    @Nullable
    public static File getPhotoCacheDir(@NonNull Context context, @NonNull String str) {
        File cacheDir = context.getCacheDir();
        if (cacheDir == null) {
            if (Log.isLoggable("Glide", 6)) {
                Log.e("Glide", "default disk cache dir is null");
            }
            return null;
        }
        File file = new File(cacheDir, str);
        if (file.isDirectory() || file.mkdirs()) {
            return file;
        }
        return null;
    }

    @GuardedBy("Glide.class")
    private static void initializeGlide(@NonNull Context context, @NonNull i iVar, @Nullable GeneratedAppGlideModule generatedAppGlideModule) {
        Context applicationContext = context.getApplicationContext();
        List list = Collections.EMPTY_LIST;
        ArrayList arrayListA = new G0.d(applicationContext).a();
        if (generatedAppGlideModule != null && !generatedAppGlideModule.getExcludedModuleClasses().isEmpty()) {
            generatedAppGlideModule.getExcludedModuleClasses();
            Iterator it = arrayListA.iterator();
            if (it.hasNext()) {
                throw AbstractC1125a.g(it);
            }
        }
        if (Log.isLoggable("Glide", 3)) {
            Iterator it2 = arrayListA.iterator();
            if (it2.hasNext()) {
                throw AbstractC1125a.g(it2);
            }
        }
        iVar.setRequestManagerFactory(generatedAppGlideModule != null ? generatedAppGlideModule.getRequestManagerFactory() : null);
        Iterator it3 = arrayListA.iterator();
        if (it3.hasNext()) {
            throw AbstractC1125a.g(it3);
        }
        if (generatedAppGlideModule != null) {
            generatedAppGlideModule.applyOptions(applicationContext, iVar);
        }
        c cVarBuild = iVar.build(applicationContext, arrayListA, generatedAppGlideModule);
        applicationContext.registerComponentCallbacks(cVarBuild);
        glide = cVarBuild;
    }

    @NonNull
    @Deprecated
    public static A with(@NonNull Activity activity) {
        return getRetriever(activity).get(activity);
    }

    @NonNull
    public static A with(@NonNull FragmentActivity fragmentActivity) {
        return getRetriever(fragmentActivity).get(fragmentActivity);
    }

    @NonNull
    public static A with(@NonNull Fragment fragment) {
        return getRetriever(fragment.getContext()).get(fragment);
    }

    @VisibleForTesting
    public static void init(@NonNull Context context, @NonNull i iVar) {
        GeneratedAppGlideModule annotationGeneratedGlideModules = getAnnotationGeneratedGlideModules(context);
        synchronized (c.class) {
            try {
                if (glide != null) {
                    tearDown();
                }
                initializeGlide(context, iVar, annotationGeneratedGlideModules);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @NonNull
    @Deprecated
    public static A with(@NonNull android.app.Fragment fragment) {
        return getRetriever(fragment.getActivity()).get(fragment);
    }

    @NonNull
    public static A with(@NonNull View view) {
        return getRetriever(view.getContext()).get(view);
    }

    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
    }
}
