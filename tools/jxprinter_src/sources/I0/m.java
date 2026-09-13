package I0;

import A3.AbstractC0157z;
import L0.s;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.Log;
import androidx.annotation.DrawableRes;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.engine.AbstractC0501q;
import com.bumptech.glide.load.engine.J;
import com.bumptech.glide.load.engine.O;
import com.bumptech.glide.load.engine.w;
import com.bumptech.glide.load.engine.x;
import com.bumptech.glide.o;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import org.apache.commons.math3.geometry.VectorFormat;
import p126w0.q;
import p126w0.v;
import p126w0.z;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class m implements d, com.bumptech.glide.request.target.j, k {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final boolean f333o = Log.isLoggable("GlideRequest", 2);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final M0.j f334a;
    public final Object b;
    public final f c;
    public final Context d;
    public final com.bumptech.glide.j e;

    @Nullable
    @GuardedBy("requestLock")
    private Drawable errorDrawable;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Class f335f;

    @Nullable
    @GuardedBy("requestLock")
    private Drawable fallbackDrawable;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final a f336g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f337h;

    @GuardedBy("requestLock")
    private int height;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f338i;

    @GuardedBy("requestLock")
    private boolean isCallingCallbacks;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final o f339j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final com.bumptech.glide.request.target.k f340k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final J0.e f341l;

    @GuardedBy("requestLock")
    private w loadStatus;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Executor f342m;

    @Nullable
    private final Object model;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public volatile x f343n;

    @Nullable
    @GuardedBy("requestLock")
    private Drawable placeholderDrawable;

    @Nullable
    private final List<i> requestListeners;

    @Nullable
    private RuntimeException requestOrigin;

    @GuardedBy("requestLock")
    private O resource;

    @GuardedBy("requestLock")
    private long startTime;

    @GuardedBy("requestLock")
    private l status;

    @Nullable
    private final String tag;

    @Nullable
    private final i targetListener;

    @GuardedBy("requestLock")
    private int width;

    private m(Context context, com.bumptech.glide.j jVar, @NonNull Object obj, @Nullable Object obj2, Class<Object> cls, a aVar, int i5, int i6, o oVar, com.bumptech.glide.request.target.k kVar, @Nullable i iVar, @Nullable List<i> list, f fVar, x xVar, J0.e eVar, Executor executor) {
        this.tag = f333o ? String.valueOf(hashCode()) : null;
        this.f334a = M0.j.newInstance();
        this.b = obj;
        this.d = context;
        this.e = jVar;
        this.model = obj2;
        this.f335f = cls;
        this.f336g = aVar;
        this.f337h = i5;
        this.f338i = i6;
        this.f339j = oVar;
        this.f340k = kVar;
        this.targetListener = iVar;
        this.requestListeners = list;
        this.c = fVar;
        this.f343n = xVar;
        this.f341l = eVar;
        this.f342m = executor;
        this.status = l.f330a;
        if (this.requestOrigin == null && jVar.f2911h.f2913a.containsKey(com.bumptech.glide.g.class)) {
            this.requestOrigin = new RuntimeException("Glide request origin trace");
        }
    }

    @GuardedBy("requestLock")
    private void assertNotCallingCallbacks() {
        if (this.isCallingCallbacks) {
            throw new IllegalStateException("You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");
        }
    }

    @GuardedBy("requestLock")
    private boolean canNotifyCleared() {
        f fVar = this.c;
        return fVar == null || fVar.h(this);
    }

    @GuardedBy("requestLock")
    private boolean canNotifyStatusChanged() {
        f fVar = this.c;
        return fVar == null || fVar.i(this);
    }

    @GuardedBy("requestLock")
    private boolean canSetResource() {
        f fVar = this.c;
        return fVar == null || fVar.c(this);
    }

    @GuardedBy("requestLock")
    private void cancel() {
        assertNotCallingCallbacks();
        this.f334a.a();
        this.f340k.removeCallback(this);
        w wVar = this.loadStatus;
        if (wVar != null) {
            synchronized (wVar.c) {
                wVar.f3076a.g(wVar.b);
            }
            this.loadStatus = null;
        }
    }

    @GuardedBy("requestLock")
    private Drawable getErrorDrawable() {
        int i5;
        if (this.errorDrawable == null) {
            a aVar = this.f336g;
            Drawable errorPlaceholder = aVar.getErrorPlaceholder();
            this.errorDrawable = errorPlaceholder;
            if (errorPlaceholder == null && (i5 = aVar.c) > 0) {
                this.errorDrawable = loadDrawable(i5);
            }
        }
        return this.errorDrawable;
    }

    @GuardedBy("requestLock")
    private Drawable getFallbackDrawable() {
        int i5;
        if (this.fallbackDrawable == null) {
            a aVar = this.f336g;
            Drawable fallbackDrawable = aVar.getFallbackDrawable();
            this.fallbackDrawable = fallbackDrawable;
            if (fallbackDrawable == null && (i5 = aVar.f318j) > 0) {
                this.fallbackDrawable = loadDrawable(i5);
            }
        }
        return this.fallbackDrawable;
    }

    @GuardedBy("requestLock")
    private Drawable getPlaceholderDrawable() {
        int i5;
        if (this.placeholderDrawable == null) {
            a aVar = this.f336g;
            Drawable placeholderDrawable = aVar.getPlaceholderDrawable();
            this.placeholderDrawable = placeholderDrawable;
            if (placeholderDrawable == null && (i5 = aVar.d) > 0) {
                this.placeholderDrawable = loadDrawable(i5);
            }
        }
        return this.placeholderDrawable;
    }

    @GuardedBy("requestLock")
    private boolean isFirstReadyResource() {
        f fVar = this.c;
        return fVar == null || !fVar.getRoot().a();
    }

    @GuardedBy("requestLock")
    private Drawable loadDrawable(@DrawableRes int i5) {
        a aVar = this.f336g;
        Resources.Theme theme = aVar.getTheme();
        Context context = this.d;
        return D0.e.getDrawable(context, i5, theme != null ? aVar.getTheme() : context.getTheme());
    }

    @GuardedBy("requestLock")
    private void notifyRequestCoordinatorLoadFailed() {
        f fVar = this.c;
        if (fVar != null) {
            fVar.f(this);
        }
    }

    @GuardedBy("requestLock")
    private void notifyRequestCoordinatorLoadSucceeded() {
        f fVar = this.c;
        if (fVar != null) {
            fVar.d(this);
        }
    }

    public static <R> m obtain(Context context, com.bumptech.glide.j jVar, Object obj, Object obj2, Class<R> cls, a aVar, int i5, int i6, o oVar, com.bumptech.glide.request.target.k kVar, i iVar, @Nullable List<i> list, f fVar, x xVar, J0.e eVar, Executor executor) {
        return new m(context, jVar, obj, obj2, cls, aVar, i5, i6, oVar, kVar, iVar, list, fVar, xVar, eVar, executor);
    }

    @GuardedBy("requestLock")
    private void onResourceReady(O o6, Object obj, p126w0.a aVar, boolean z6) {
        boolean zOnResourceReady;
        boolean zIsFirstReadyResource = isFirstReadyResource();
        this.status = l.d;
        this.resource = o6;
        if (this.e.f2912i <= 3) {
            Log.d("Glide", "Finished loading " + obj.getClass().getSimpleName() + " from " + aVar + " for " + this.model + " with size [" + this.width + "x" + this.height + "] in " + L0.l.a(this.startTime) + " ms");
        }
        notifyRequestCoordinatorLoadSucceeded();
        boolean z7 = true;
        this.isCallingCallbacks = true;
        try {
            List<i> list = this.requestListeners;
            if (list != null) {
                Iterator<i> it = list.iterator();
                zOnResourceReady = false;
                while (it.hasNext()) {
                    Object obj2 = obj;
                    p126w0.a aVar2 = aVar;
                    zOnResourceReady |= it.next().onResourceReady(obj2, this.model, this.f340k, aVar2, zIsFirstReadyResource);
                    obj = obj2;
                    aVar = aVar2;
                }
            } else {
                zOnResourceReady = false;
            }
            Object obj3 = obj;
            p126w0.a aVar3 = aVar;
            i iVar = this.targetListener;
            if (iVar == null || !iVar.onResourceReady(obj3, this.model, this.f340k, aVar3, zIsFirstReadyResource)) {
                z7 = false;
            }
            if (!(z7 | zOnResourceReady)) {
                this.f340k.onResourceReady(obj3, this.f341l.a(aVar3, zIsFirstReadyResource));
            }
        } finally {
            this.isCallingCallbacks = false;
        }
    }

    @GuardedBy("requestLock")
    private void setErrorPlaceholder() {
        if (canNotifyStatusChanged()) {
            Drawable fallbackDrawable = this.model == null ? getFallbackDrawable() : null;
            if (fallbackDrawable == null) {
                fallbackDrawable = getErrorDrawable();
            }
            if (fallbackDrawable == null) {
                fallbackDrawable = getPlaceholderDrawable();
            }
            this.f340k.onLoadFailed(fallbackDrawable);
        }
    }

    @Override // I0.d
    public final boolean a() {
        boolean z6;
        synchronized (this.b) {
            z6 = this.status == l.d;
        }
        return z6;
    }

    @Override // I0.d
    public final boolean b() {
        boolean z6;
        synchronized (this.b) {
            z6 = this.status == l.f331f;
        }
        return z6;
    }

    public final void c(String str) {
        StringBuilder sbX = AbstractC0157z.x(str, " this: ");
        sbX.append(this.tag);
        Log.v("GlideRequest", sbX.toString());
    }

    @Override // I0.d
    public final void clear() {
        synchronized (this.b) {
            try {
                assertNotCallingCallbacks();
                this.f334a.a();
                l lVar = this.status;
                l lVar2 = l.f331f;
                if (lVar == lVar2) {
                    return;
                }
                cancel();
                O o6 = this.resource;
                if (o6 != null) {
                    this.resource = null;
                } else {
                    o6 = null;
                }
                if (canNotifyCleared()) {
                    this.f340k.onLoadCleared(getPlaceholderDrawable());
                }
                this.status = lVar2;
                if (o6 != null) {
                    this.f343n.getClass();
                    x.e(o6);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void d(J j6, int i5) {
        boolean zOnLoadFailed;
        this.f334a.a();
        synchronized (this.b) {
            try {
                j6.setOrigin(this.requestOrigin);
                int i6 = this.e.f2912i;
                if (i6 <= i5) {
                    Log.w("Glide", "Load failed for [" + this.model + "] with dimensions [" + this.width + "x" + this.height + "]", j6);
                    if (i6 <= 4) {
                        j6.c();
                    }
                }
                this.loadStatus = null;
                this.status = l.e;
                notifyRequestCoordinatorLoadFailed();
                boolean z6 = true;
                this.isCallingCallbacks = true;
                try {
                    List<i> list = this.requestListeners;
                    if (list != null) {
                        Iterator<i> it = list.iterator();
                        zOnLoadFailed = false;
                        while (it.hasNext()) {
                            zOnLoadFailed |= it.next().onLoadFailed(j6, this.model, this.f340k, isFirstReadyResource());
                        }
                    } else {
                        zOnLoadFailed = false;
                    }
                    i iVar = this.targetListener;
                    if (iVar == null || !iVar.onLoadFailed(j6, this.model, this.f340k, isFirstReadyResource())) {
                        z6 = false;
                    }
                    if (!(zOnLoadFailed | z6)) {
                        setErrorPlaceholder();
                    }
                    this.isCallingCallbacks = false;
                } catch (Throwable th) {
                    this.isCallingCallbacks = false;
                    throw th;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // I0.d
    public final void e() {
        synchronized (this.b) {
            try {
                assertNotCallingCallbacks();
                this.f334a.a();
                this.startTime = L0.l.getLogTime();
                if (this.model == null) {
                    if (s.e(this.f337h, this.f338i)) {
                        this.width = this.f337h;
                        this.height = this.f338i;
                    }
                    d(new J("Received null model"), getFallbackDrawable() == null ? 5 : 3);
                    return;
                }
                l lVar = this.status;
                if (lVar == l.b) {
                    throw new IllegalArgumentException("Cannot restart a running request");
                }
                if (lVar == l.d) {
                    f(this.resource, p126w0.a.e, false);
                    return;
                }
                List<i> list = this.requestListeners;
                if (list != null) {
                    for (i iVar : list) {
                    }
                }
                l lVar2 = l.c;
                this.status = lVar2;
                if (s.e(this.f337h, this.f338i)) {
                    h(this.f337h, this.f338i);
                } else {
                    this.f340k.getSize(this);
                }
                l lVar3 = this.status;
                if ((lVar3 == l.b || lVar3 == lVar2) && canNotifyStatusChanged()) {
                    this.f340k.onLoadStarted(getPlaceholderDrawable());
                }
                if (f333o) {
                    c("finished run method in " + L0.l.a(this.startTime));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void f(O o6, p126w0.a aVar, boolean z6) {
        this.f334a.a();
        O o7 = null;
        try {
            synchronized (this.b) {
                try {
                    this.loadStatus = null;
                    if (o6 == null) {
                        d(new J("Expected to receive a Resource<R> with an object of " + this.f335f + " inside, but instead got null."), 5);
                        return;
                    }
                    Object obj = o6.get();
                    try {
                        if (obj == null || !this.f335f.isAssignableFrom(obj.getClass())) {
                            this.resource = null;
                            StringBuilder sb = new StringBuilder("Expected to receive an object of ");
                            sb.append(this.f335f);
                            sb.append(" but instead got ");
                            sb.append(obj != null ? obj.getClass() : "");
                            sb.append(VectorFormat.DEFAULT_PREFIX);
                            sb.append(obj);
                            sb.append("} inside Resource{");
                            sb.append(o6);
                            sb.append("}.");
                            sb.append(obj != null ? "" : " To indicate failure return a null Resource object, rather than a Resource object containing null data.");
                            d(new J(sb.toString()), 5);
                        } else if (canSetResource()) {
                            onResourceReady(o6, obj, aVar, z6);
                            return;
                        } else {
                            this.resource = null;
                            this.status = l.d;
                        }
                        this.f343n.getClass();
                        x.e(o6);
                    } catch (Throwable th) {
                        o7 = o6;
                        th = th;
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        } catch (Throwable th3) {
            if (o7 != null) {
                this.f343n.getClass();
                x.e(o7);
            }
            throw th3;
        }
    }

    @Override // I0.d
    public final boolean g() {
        boolean z6;
        synchronized (this.b) {
            z6 = this.status == l.d;
        }
        return z6;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void h(int i5, int i6) throws Throwable {
        Object obj;
        m mVar = this;
        int iRound = i5;
        mVar.f334a.a();
        Object obj2 = mVar.b;
        synchronized (obj2) {
            try {
                try {
                    boolean z6 = f333o;
                    if (z6) {
                        mVar.c("Got onSizeReady in " + L0.l.a(mVar.startTime));
                    }
                    if (mVar.status == l.c) {
                        l lVar = l.b;
                        mVar.status = lVar;
                        float f6 = mVar.f336g.b;
                        if (iRound != Integer.MIN_VALUE) {
                            iRound = Math.round(iRound * f6);
                        }
                        mVar.width = iRound;
                        mVar.height = i6 == Integer.MIN_VALUE ? i6 : Math.round(f6 * i6);
                        if (z6) {
                            mVar.c("finished setup for calling load in " + L0.l.a(mVar.startTime));
                        }
                        x xVar = mVar.f343n;
                        com.bumptech.glide.j jVar = mVar.e;
                        Object obj3 = mVar.model;
                        q signature = mVar.f336g.getSignature();
                        try {
                            int i7 = mVar.width;
                            int i8 = mVar.height;
                            Class<?> resourceClass = mVar.f336g.getResourceClass();
                            Class cls = mVar.f335f;
                            try {
                                o oVar = mVar.f339j;
                                AbstractC0501q diskCacheStrategy = mVar.f336g.getDiskCacheStrategy();
                                Map<Class<?>, z> transformations = mVar.f336g.getTransformations();
                                a aVar = mVar.f336g;
                                boolean z7 = aVar.f316h;
                                try {
                                    boolean z8 = aVar.f323o;
                                    v options = aVar.getOptions();
                                    a aVar2 = mVar.f336g;
                                    boolean z9 = aVar2.e;
                                    boolean z10 = aVar2.f321m;
                                    boolean z11 = aVar2.f324p;
                                    boolean z12 = aVar2.f322n;
                                    Executor executor = mVar.f342m;
                                    Object obj4 = obj2;
                                    try {
                                        mVar.loadStatus = xVar.a(jVar, obj3, signature, i7, i8, resourceClass, cls, oVar, diskCacheStrategy, transformations, z7, z8, options, z9, z10, z11, z12, mVar, executor);
                                        if (mVar.status != lVar) {
                                            mVar.loadStatus = null;
                                        }
                                        if (z6) {
                                            mVar.c("finished onSizeReady in " + L0.l.a(mVar.startTime));
                                        }
                                    } catch (Throwable th) {
                                        th = th;
                                        obj = obj4;
                                        throw th;
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    obj = obj2;
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                obj = obj2;
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            obj = obj2;
                        }
                    }
                } catch (Throwable th5) {
                    th = th5;
                    obj = mVar;
                }
            } catch (Throwable th6) {
                th = th6;
                obj = obj2;
            }
        }
    }

    @Override // I0.d
    public final boolean isRunning() {
        boolean z6;
        synchronized (this.b) {
            try {
                l lVar = this.status;
                z6 = lVar == l.b || lVar == l.c;
            } catch (Throwable th) {
                throw th;
            }
        }
        return z6;
    }

    @Override // I0.d
    public final boolean j(d dVar) {
        int i5;
        int i6;
        Object obj;
        Class cls;
        a aVar;
        o oVar;
        int size;
        int i7;
        int i8;
        Object obj2;
        Class cls2;
        a aVar2;
        o oVar2;
        int size2;
        if (!(dVar instanceof m)) {
            return false;
        }
        synchronized (this.b) {
            try {
                i5 = this.f337h;
                i6 = this.f338i;
                obj = this.model;
                cls = this.f335f;
                aVar = this.f336g;
                oVar = this.f339j;
                List<i> list = this.requestListeners;
                size = list != null ? list.size() : 0;
            } catch (Throwable th) {
                throw th;
            }
        }
        m mVar = (m) dVar;
        synchronized (mVar.b) {
            try {
                i7 = mVar.f337h;
                i8 = mVar.f338i;
                obj2 = mVar.model;
                cls2 = mVar.f335f;
                aVar2 = mVar.f336g;
                oVar2 = mVar.f339j;
                List<i> list2 = mVar.requestListeners;
                size2 = list2 != null ? list2.size() : 0;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return i5 == i7 && i6 == i8 && s.bothModelsNullEquivalentOrEquals(obj, obj2) && cls.equals(cls2) && aVar.equals(aVar2) && oVar == oVar2 && size == size2;
    }

    @Override // I0.d
    public final void pause() {
        synchronized (this.b) {
            try {
                if (isRunning()) {
                    clear();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final String toString() {
        Object obj;
        Class cls;
        synchronized (this.b) {
            obj = this.model;
            cls = this.f335f;
        }
        return super.toString() + "[model=" + obj + ", transcodeClass=" + cls + "]";
    }
}
