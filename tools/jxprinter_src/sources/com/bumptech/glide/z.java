package com.bumptech.glide;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import androidx.annotation.CheckResult;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import com.bumptech.glide.load.engine.AbstractC0501q;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class z extends I0.a implements Cloneable, n {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final I0.j f3203y = (I0.j) ((I0.j) ((I0.j) new I0.j().diskCacheStrategy(AbstractC0501q.b)).priority(o.d)).skipMemoryCache(true);

    @Nullable
    private z errorBuilder;

    @Nullable
    private Object model;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Context f3204q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final A f3205r;

    @Nullable
    private List<I0.i> requestListeners;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Class f3206s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final c f3207t;

    @Nullable
    private Float thumbSizeMultiplier;

    @Nullable
    private z thumbnailBuilder;

    @NonNull
    private B transitionOptions;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final j f3208u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f3209v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f3210w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f3211x;

    @SuppressLint({"CheckResult"})
    public z(@NonNull c cVar, A a6, Class<Object> cls, Context context) {
        this.f3209v = true;
        this.f3207t = cVar;
        this.f3205r = a6;
        this.f3206s = cls;
        this.f3204q = context;
        this.transitionOptions = a6.getDefaultTransitionOptions(cls);
        this.f3208u = cVar.getGlideContext();
        initRequestListeners(a6.f2862f);
        apply((I0.a) a6.a());
    }

    private I0.d buildRequest(com.bumptech.glide.request.target.k kVar, @Nullable I0.i iVar, I0.a aVar, Executor executor) {
        return buildRequestRecursive(new Object(), kVar, iVar, null, this.transitionOptions, aVar.getPriority(), aVar.f315g, aVar.f314f, aVar, executor);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private I0.d buildRequestRecursive(Object obj, com.bumptech.glide.request.target.k kVar, @Nullable I0.i iVar, @Nullable I0.f fVar, B b, o oVar, int i5, int i6, I0.a aVar, Executor executor) {
        I0.f fVar2;
        I0.f bVar;
        if (this.errorBuilder != null) {
            bVar = new I0.b(obj, fVar);
            fVar2 = bVar;
        } else {
            fVar2 = null;
            bVar = fVar;
        }
        I0.d dVarBuildThumbnailRequestRecursive = buildThumbnailRequestRecursive(obj, kVar, iVar, bVar, b, oVar, i5, i6, aVar, executor);
        if (fVar2 == null) {
            return dVarBuildThumbnailRequestRecursive;
        }
        z zVar = this.errorBuilder;
        int i7 = zVar.f315g;
        int i8 = zVar.f314f;
        if (L0.s.e(i5, i6)) {
            z zVar2 = this.errorBuilder;
            if (!L0.s.e(zVar2.f315g, zVar2.f314f)) {
                i7 = aVar.f315g;
                i8 = aVar.f314f;
            }
        }
        int i9 = i8;
        z zVar3 = this.errorBuilder;
        I0.b bVar2 = fVar2;
        I0.d dVarBuildRequestRecursive = zVar3.buildRequestRecursive(obj, kVar, iVar, bVar2, zVar3.transitionOptions, zVar3.getPriority(), i7, i9, this.errorBuilder, executor);
        bVar2.b = dVarBuildThumbnailRequestRecursive;
        bVar2.c = dVarBuildRequestRecursive;
        return bVar2;
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
    private I0.d buildThumbnailRequestRecursive(Object obj, com.bumptech.glide.request.target.k kVar, I0.i iVar, @Nullable I0.f fVar, B b, o oVar, int i5, int i6, I0.a aVar, Executor executor) {
        z zVar = this.thumbnailBuilder;
        if (zVar == null) {
            if (this.thumbSizeMultiplier == null) {
                return e(obj, kVar, iVar, fVar, b, oVar, i5, i6, aVar, executor);
            }
            I0.n nVar = new I0.n(obj, fVar);
            I0.m mVarE = e(obj, kVar, iVar, nVar, b, oVar, i5, i6, aVar, executor);
            I0.m mVarE2 = e(obj, kVar, iVar, nVar, b, getThumbnailPriority(oVar), i5, i6, aVar.mo813clone().sizeMultiplier(this.thumbSizeMultiplier.floatValue()), executor);
            nVar.b = mVarE;
            nVar.c = mVarE2;
            return nVar;
        }
        if (this.f3211x) {
            throw new IllegalStateException("You cannot use a request as both the main request and a thumbnail, consider using clone() on the request(s) passed to thumbnail()");
        }
        B b6 = zVar.f3209v ? b : zVar.transitionOptions;
        o priority = I0.a.a(zVar.f313a, 8) ? this.thumbnailBuilder.getPriority() : getThumbnailPriority(oVar);
        z zVar2 = this.thumbnailBuilder;
        int i7 = zVar2.f315g;
        int i8 = zVar2.f314f;
        if (L0.s.e(i5, i6)) {
            z zVar3 = this.thumbnailBuilder;
            if (!L0.s.e(zVar3.f315g, zVar3.f314f)) {
                i7 = aVar.f315g;
                i8 = aVar.f314f;
            }
        }
        int i9 = i7;
        I0.n nVar2 = new I0.n(obj, fVar);
        I0.m mVarE3 = e(obj, kVar, iVar, nVar2, b, oVar, i5, i6, aVar, executor);
        this.f3211x = true;
        z zVar4 = this.thumbnailBuilder;
        I0.d dVarBuildRequestRecursive = zVar4.buildRequestRecursive(obj, kVar, iVar, nVar2, b6, priority, i9, i8, zVar4, executor);
        this.f3211x = false;
        nVar2.b = mVarE3;
        nVar2.c = dVarBuildRequestRecursive;
        return nVar2;
    }

    @NonNull
    private o getThumbnailPriority(@NonNull o oVar) {
        int iOrdinal = oVar.ordinal();
        if (iOrdinal == 0 || iOrdinal == 1) {
            return o.f3184a;
        }
        if (iOrdinal == 2) {
            return o.b;
        }
        if (iOrdinal == 3) {
            return o.c;
        }
        throw new IllegalArgumentException("unknown priority: " + getPriority());
    }

    @SuppressLint({"CheckResult"})
    private void initRequestListeners(List<I0.i> list) {
        Iterator<I0.i> it = list.iterator();
        while (it.hasNext()) {
            addListener(it.next());
        }
    }

    @NonNull
    private z loadGeneric(@Nullable Object obj) {
        if (this.f320l) {
            return mo813clone().loadGeneric(obj);
        }
        this.model = obj;
        this.f3210w = true;
        return (z) selfOrThrowIfLocked();
    }

    private z maybeApplyOptionsResourceUri(@Nullable Uri uri, z zVar) {
        if (uri == null || !"android.resource".equals(uri.getScheme())) {
            return zVar;
        }
        Context context = this.f3204q;
        return (z) ((z) zVar.theme(context.getTheme())).signature(K0.a.obtain(context));
    }

    @NonNull
    @CheckResult
    public z addListener(@Nullable I0.i iVar) {
        if (this.f320l) {
            return mo813clone().addListener(iVar);
        }
        if (iVar != null) {
            if (this.requestListeners == null) {
                this.requestListeners = new ArrayList();
            }
            this.requestListeners.add(iVar);
        }
        return (z) selfOrThrowIfLocked();
    }

    @CheckResult
    @Deprecated
    public <Y extends com.bumptech.glide.request.target.k> Y downloadOnly(@NonNull Y y6) {
        return (Y) getDownloadOnlyRequest().into(y6);
    }

    public final I0.m e(Object obj, com.bumptech.glide.request.target.k kVar, I0.i iVar, I0.f fVar, B b, o oVar, int i5, int i6, I0.a aVar, Executor executor) {
        Object obj2 = this.model;
        List<I0.i> list = this.requestListeners;
        j jVar = this.f3208u;
        return I0.m.obtain(this.f3204q, jVar, obj, obj2, this.f3206s, aVar, i5, i6, oVar, kVar, iVar, list, fVar, jVar.getEngine(), b.f2864a, executor);
    }

    @Override // I0.a
    public final boolean equals(Object obj) {
        if (!(obj instanceof z)) {
            return false;
        }
        z zVar = (z) obj;
        return super.equals(zVar) && Objects.equals(this.f3206s, zVar.f3206s) && this.transitionOptions.equals(zVar.transitionOptions) && Objects.equals(this.model, zVar.model) && Objects.equals(this.requestListeners, zVar.requestListeners) && Objects.equals(this.thumbnailBuilder, zVar.thumbnailBuilder) && Objects.equals(this.errorBuilder, zVar.errorBuilder) && Objects.equals(this.thumbSizeMultiplier, zVar.thumbSizeMultiplier) && this.f3209v == zVar.f3209v && this.f3210w == zVar.f3210w;
    }

    @NonNull
    @CheckResult
    public z error(Object obj) {
        return obj == null ? error((z) null) : error(mo813clone().error((z) null).thumbnail((z) null).load(obj));
    }

    @NonNull
    @CheckResult
    public z getDownloadOnlyRequest() {
        return new z(File.class, this).apply((I0.a) f3203y);
    }

    @Override // I0.a
    public final int hashCode() {
        return L0.s.c(this.f3210w ? 1 : 0, L0.s.c(this.f3209v ? 1 : 0, L0.s.hashCode(this.thumbSizeMultiplier, L0.s.hashCode(this.errorBuilder, L0.s.hashCode(this.thumbnailBuilder, L0.s.hashCode(this.requestListeners, L0.s.hashCode(this.model, L0.s.hashCode(this.transitionOptions, L0.s.hashCode(this.f3206s, super.hashCode())))))))));
    }

    @NonNull
    public <Y extends com.bumptech.glide.request.target.k> Y into(@NonNull Y y6) {
        return (Y) into(y6, null, L0.i.f403a);
    }

    @NonNull
    @CheckResult
    public z listener(@Nullable I0.i iVar) {
        if (this.f320l) {
            return mo813clone().listener(iVar);
        }
        this.requestListeners = null;
        return addListener(iVar);
    }

    @NonNull
    public com.bumptech.glide.request.target.k preload(int i5, int i6) {
        return into(new com.bumptech.glide.request.target.i(this.f3205r, i5, i6));
    }

    @NonNull
    public I0.c submit() {
        return submit(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    @NonNull
    @CheckResult
    public z thumbnail(@Nullable z... zVarArr) {
        return (zVarArr == null || zVarArr.length == 0) ? thumbnail((z) null) : thumbnail(Arrays.asList(zVarArr));
    }

    @NonNull
    @CheckResult
    public z transition(@NonNull B b) {
        if (this.f320l) {
            return mo813clone().transition(b);
        }
        this.transitionOptions = (B) L0.q.checkNotNull(b);
        this.f3209v = false;
        return (z) selfOrThrowIfLocked();
    }

    @Override // I0.a
    @NonNull
    @CheckResult
    public z apply(@NonNull I0.a aVar) {
        L0.q.checkNotNull(aVar);
        return (z) super.apply(aVar);
    }

    @CheckResult
    @Deprecated
    public I0.c downloadOnly(int i5, int i6) {
        return getDownloadOnlyRequest().submit(i5, i6);
    }

    @NonNull
    public <Y extends com.bumptech.glide.request.target.k> Y into(@NonNull Y y6, @Nullable I0.i iVar, Executor executor) {
        return (Y) into(y6, iVar, this, executor);
    }

    @NonNull
    public I0.c submit(int i5, int i6) {
        I0.h hVar = new I0.h(i5, i6);
        return (I0.c) into(hVar, hVar, L0.i.b);
    }

    private <Y extends com.bumptech.glide.request.target.k> Y into(@NonNull Y y6, @Nullable I0.i iVar, I0.a aVar, Executor executor) {
        L0.q.checkNotNull(y6);
        if (this.f3210w) {
            I0.d dVarBuildRequest = buildRequest(y6, iVar, aVar, executor);
            I0.d request = y6.getRequest();
            if (dVarBuildRequest.j(request) && (aVar.e || !request.g())) {
                if (!((I0.d) L0.q.checkNotNull(request)).isRunning()) {
                    request.e();
                }
                return y6;
            }
            A a6 = this.f3205r;
            a6.clear(y6);
            y6.setRequest(dVarBuildRequest);
            a6.track(y6, dVarBuildRequest);
            return y6;
        }
        throw new IllegalArgumentException("You must call #load() before calling #into()");
    }

    @Override // I0.a
    @CheckResult
    /* JADX INFO: renamed from: clone */
    public z mo813clone() {
        z zVar = (z) super.mo813clone();
        zVar.transitionOptions = zVar.transitionOptions.clone();
        if (zVar.requestListeners != null) {
            zVar.requestListeners = new ArrayList(zVar.requestListeners);
        }
        z zVar2 = zVar.thumbnailBuilder;
        if (zVar2 != null) {
            zVar.thumbnailBuilder = zVar2.mo813clone();
        }
        z zVar3 = zVar.errorBuilder;
        if (zVar3 != null) {
            zVar.errorBuilder = zVar3.mo813clone();
        }
        return zVar;
    }

    @NonNull
    public com.bumptech.glide.request.target.k preload() {
        return preload(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    @NonNull
    @CheckResult
    public z thumbnail(@Nullable List<z> list) {
        z zVarThumbnail = null;
        if (list != null && !list.isEmpty()) {
            for (int size = list.size() - 1; size >= 0; size--) {
                z zVar = list.get(size);
                if (zVar != null) {
                    zVarThumbnail = zVarThumbnail == null ? zVar : zVar.thumbnail(zVarThumbnail);
                }
            }
            return thumbnail(zVarThumbnail);
        }
        return thumbnail((z) null);
    }

    @NonNull
    public z error(@Nullable z zVar) {
        if (this.f320l) {
            return mo813clone().error(zVar);
        }
        this.errorBuilder = zVar;
        return (z) selfOrThrowIfLocked();
    }

    @Override // com.bumptech.glide.n
    @NonNull
    @CheckResult
    public z load(@Nullable Object obj) {
        return loadGeneric(obj);
    }

    @NonNull
    @CheckResult
    @Deprecated
    public z thumbnail(float f6) {
        if (this.f320l) {
            return mo813clone().thumbnail(f6);
        }
        if (f6 >= 0.0f && f6 <= 1.0f) {
            this.thumbSizeMultiplier = Float.valueOf(f6);
            return (z) selfOrThrowIfLocked();
        }
        throw new IllegalArgumentException("sizeMultiplier must be between 0 and 1");
    }

    @Override // com.bumptech.glide.n
    @NonNull
    @CheckResult
    public z load(@Nullable Bitmap bitmap) {
        return loadGeneric(bitmap).apply((I0.a) I0.j.diskCacheStrategyOf(AbstractC0501q.f3068a));
    }

    @SuppressLint({"CheckResult"})
    public z(Class<Object> cls, z zVar) {
        this(zVar.f3207t, zVar.f3205r, cls, zVar.f3204q);
        this.model = zVar.model;
        this.f3210w = zVar.f3210w;
        apply((I0.a) zVar);
    }

    @Override // com.bumptech.glide.n
    @NonNull
    @CheckResult
    public z load(@Nullable Drawable drawable) {
        return loadGeneric(drawable).apply((I0.a) I0.j.diskCacheStrategyOf(AbstractC0501q.f3068a));
    }

    @Override // com.bumptech.glide.n
    @NonNull
    @CheckResult
    public z load(@Nullable String str) {
        return loadGeneric(str);
    }

    @Override // com.bumptech.glide.n
    @NonNull
    @CheckResult
    public z load(@Nullable Uri uri) {
        return maybeApplyOptionsResourceUri(uri, loadGeneric(uri));
    }

    @Override // com.bumptech.glide.n
    @NonNull
    @CheckResult
    public z load(@Nullable File file) {
        return loadGeneric(file);
    }

    @NonNull
    @CheckResult
    public z thumbnail(@Nullable z zVar) {
        if (this.f320l) {
            return mo813clone().thumbnail(zVar);
        }
        this.thumbnailBuilder = zVar;
        return (z) selfOrThrowIfLocked();
    }

    @NonNull
    public com.bumptech.glide.request.target.l into(@NonNull ImageView imageView) {
        I0.a aVarOptionalCenterCrop;
        L0.s.a();
        L0.q.checkNotNull(imageView);
        if (!I0.a.a(this.f313a, 2048) && this.f317i && imageView.getScaleType() != null) {
            switch (y.f3202a[imageView.getScaleType().ordinal()]) {
                case 1:
                    aVarOptionalCenterCrop = mo813clone().optionalCenterCrop();
                    break;
                case 2:
                    aVarOptionalCenterCrop = mo813clone().optionalCenterInside();
                    break;
                case 3:
                case 4:
                case 5:
                    aVarOptionalCenterCrop = mo813clone().optionalFitCenter();
                    break;
                case 6:
                    aVarOptionalCenterCrop = mo813clone().optionalCenterInside();
                    break;
                default:
                    aVarOptionalCenterCrop = this;
                    break;
            }
        } else {
            aVarOptionalCenterCrop = this;
        }
        return (com.bumptech.glide.request.target.l) into(this.f3208u.buildImageViewTarget(imageView, this.f3206s), null, aVarOptionalCenterCrop, L0.i.f403a);
    }

    @Override // com.bumptech.glide.n
    @NonNull
    @CheckResult
    public z load(@Nullable @DrawableRes @RawRes Integer num) {
        z zVarLoadGeneric = loadGeneric(num);
        Context context = this.f3204q;
        return (z) ((z) zVarLoadGeneric.theme(context.getTheme())).signature(K0.a.obtain(context));
    }

    @Override // com.bumptech.glide.n
    @CheckResult
    @Deprecated
    public z load(@Nullable URL url) {
        return loadGeneric(url);
    }

    @Override // com.bumptech.glide.n
    @NonNull
    @CheckResult
    public z load(@Nullable byte[] bArr) {
        z zVarLoadGeneric = loadGeneric(bArr);
        if (!I0.a.a(zVarLoadGeneric.f313a, 4)) {
            zVarLoadGeneric = zVarLoadGeneric.apply((I0.a) I0.j.diskCacheStrategyOf(AbstractC0501q.f3068a));
        }
        return !I0.a.a(zVarLoadGeneric.f313a, 256) ? zVarLoadGeneric.apply((I0.a) I0.j.skipMemoryCacheOf(true)) : zVarLoadGeneric;
    }

    @Deprecated
    public I0.c into(int i5, int i6) {
        return submit(i5, i6);
    }
}
