package I0;

import L0.s;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.CheckResult;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.engine.AbstractC0501q;
import com.bumptech.glide.load.resource.bitmap.C0508c;
import com.bumptech.glide.load.resource.bitmap.C0514i;
import com.bumptech.glide.load.resource.bitmap.C0515j;
import com.bumptech.glide.load.resource.bitmap.C0516k;
import com.bumptech.glide.load.resource.bitmap.C0524t;
import com.bumptech.glide.load.resource.bitmap.C0527w;
import com.bumptech.glide.load.resource.bitmap.C0529y;
import com.bumptech.glide.load.resource.bitmap.f0;
import com.bumptech.glide.load.resource.bitmap.r;
import com.bumptech.glide.load.resource.gif.p;
import com.bumptech.glide.o;
import com.google.android.material.color.utilities.Contrast;
import java.util.Map;
import p126w0.q;
import p126w0.u;
import p126w0.v;
import p126w0.z;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class a implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f313a;
    public int c;
    public int d;

    @Nullable
    private Drawable errorPlaceholder;

    @Nullable
    private Drawable fallbackDrawable;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f316h;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f318j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f319k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f320l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f321m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f322n;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f324p;

    @Nullable
    private Drawable placeholderDrawable;

    @Nullable
    private Resources.Theme theme;
    public float b = 1.0f;

    @NonNull
    private AbstractC0501q diskCacheStrategy = AbstractC0501q.d;

    @NonNull
    private o priority = o.c;
    public boolean e = true;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f314f = -1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f315g = -1;

    @NonNull
    private q signature = K0.c.obtain();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f317i = true;

    @NonNull
    private v options = new v();

    @NonNull
    private Map<Class<?>, z> transformations = new L0.d();

    @NonNull
    private Class<?> resourceClass = Object.class;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f323o = true;

    public static boolean a(int i5, int i6) {
        return (i5 & i6) != 0;
    }

    @NonNull
    private a optionalScaleOnlyTransform(@NonNull r rVar, @NonNull z zVar) {
        return scaleOnlyTransform(rVar, zVar, false);
    }

    @NonNull
    private a scaleOnlyTransform(@NonNull r rVar, @NonNull z zVar) {
        return scaleOnlyTransform(rVar, zVar, true);
    }

    @NonNull
    @CheckResult
    public a apply(@NonNull a aVar) {
        if (this.f320l) {
            return mo813clone().apply(aVar);
        }
        if (a(aVar.f313a, 2)) {
            this.b = aVar.b;
        }
        if (a(aVar.f313a, 262144)) {
            this.f321m = aVar.f321m;
        }
        if (a(aVar.f313a, 1048576)) {
            this.f324p = aVar.f324p;
        }
        if (a(aVar.f313a, 4)) {
            this.diskCacheStrategy = aVar.diskCacheStrategy;
        }
        if (a(aVar.f313a, 8)) {
            this.priority = aVar.priority;
        }
        if (a(aVar.f313a, 16)) {
            this.errorPlaceholder = aVar.errorPlaceholder;
            this.c = 0;
            this.f313a &= -33;
        }
        if (a(aVar.f313a, 32)) {
            this.c = aVar.c;
            this.errorPlaceholder = null;
            this.f313a &= -17;
        }
        if (a(aVar.f313a, 64)) {
            this.placeholderDrawable = aVar.placeholderDrawable;
            this.d = 0;
            this.f313a &= -129;
        }
        if (a(aVar.f313a, 128)) {
            this.d = aVar.d;
            this.placeholderDrawable = null;
            this.f313a &= -65;
        }
        if (a(aVar.f313a, 256)) {
            this.e = aVar.e;
        }
        if (a(aVar.f313a, 512)) {
            this.f315g = aVar.f315g;
            this.f314f = aVar.f314f;
        }
        if (a(aVar.f313a, 1024)) {
            this.signature = aVar.signature;
        }
        if (a(aVar.f313a, 4096)) {
            this.resourceClass = aVar.resourceClass;
        }
        if (a(aVar.f313a, 8192)) {
            this.fallbackDrawable = aVar.fallbackDrawable;
            this.f318j = 0;
            this.f313a &= -16385;
        }
        if (a(aVar.f313a, 16384)) {
            this.f318j = aVar.f318j;
            this.fallbackDrawable = null;
            this.f313a &= -8193;
        }
        if (a(aVar.f313a, 32768)) {
            this.theme = aVar.theme;
        }
        if (a(aVar.f313a, 65536)) {
            this.f317i = aVar.f317i;
        }
        if (a(aVar.f313a, 131072)) {
            this.f316h = aVar.f316h;
        }
        if (a(aVar.f313a, 2048)) {
            this.transformations.putAll(aVar.transformations);
            this.f323o = aVar.f323o;
        }
        if (a(aVar.f313a, 524288)) {
            this.f322n = aVar.f322n;
        }
        if (!this.f317i) {
            this.transformations.clear();
            int i5 = this.f313a;
            this.f316h = false;
            this.f313a = i5 & (-133121);
            this.f323o = true;
        }
        this.f313a |= aVar.f313a;
        this.options.putAll(aVar.options);
        return selfOrThrowIfLocked();
    }

    @NonNull
    public a autoClone() {
        if (this.f319k && !this.f320l) {
            throw new IllegalStateException("You cannot auto lock an already locked options object, try clone() first");
        }
        this.f320l = true;
        return lock();
    }

    @NonNull
    @CheckResult
    public a centerCrop() {
        return transform(r.c, new C0514i());
    }

    @NonNull
    @CheckResult
    public a centerInside() {
        return scaleOnlyTransform(r.b, new C0515j());
    }

    @NonNull
    @CheckResult
    public a circleCrop() {
        return transform(r.b, new C0516k());
    }

    @NonNull
    @CheckResult
    public a decode(@NonNull Class<?> cls) {
        if (this.f320l) {
            return mo813clone().decode(cls);
        }
        this.resourceClass = (Class) L0.q.checkNotNull(cls);
        this.f313a |= 4096;
        return selfOrThrowIfLocked();
    }

    @NonNull
    @CheckResult
    public a disallowHardwareConfig() {
        return set(C0524t.f3122i, Boolean.FALSE);
    }

    @NonNull
    @CheckResult
    public a diskCacheStrategy(@NonNull AbstractC0501q abstractC0501q) {
        if (this.f320l) {
            return mo813clone().diskCacheStrategy(abstractC0501q);
        }
        this.diskCacheStrategy = (AbstractC0501q) L0.q.checkNotNull(abstractC0501q);
        this.f313a |= 4;
        return selfOrThrowIfLocked();
    }

    @NonNull
    @CheckResult
    public a dontAnimate() {
        return set(p.b, Boolean.TRUE);
    }

    @NonNull
    @CheckResult
    public a dontTransform() {
        if (this.f320l) {
            return mo813clone().dontTransform();
        }
        this.transformations.clear();
        int i5 = this.f313a;
        this.f316h = false;
        this.f317i = false;
        this.f313a = (i5 & (-133121)) | 65536;
        this.f323o = true;
        return selfOrThrowIfLocked();
    }

    @NonNull
    @CheckResult
    public a downsample(@NonNull r rVar) {
        return set(r.f3117f, L0.q.checkNotNull(rVar));
    }

    @NonNull
    @CheckResult
    public a encodeFormat(@NonNull Bitmap.CompressFormat compressFormat) {
        return set(C0508c.b, L0.q.checkNotNull(compressFormat));
    }

    @NonNull
    @CheckResult
    public a encodeQuality(@IntRange(from = 0, to = 100) int i5) {
        return set(C0508c.f3104a, Integer.valueOf(i5));
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return Float.compare(aVar.b, this.b) == 0 && this.c == aVar.c && s.bothNullOrEqual(this.errorPlaceholder, aVar.errorPlaceholder) && this.d == aVar.d && s.bothNullOrEqual(this.placeholderDrawable, aVar.placeholderDrawable) && this.f318j == aVar.f318j && s.bothNullOrEqual(this.fallbackDrawable, aVar.fallbackDrawable) && this.e == aVar.e && this.f314f == aVar.f314f && this.f315g == aVar.f315g && this.f316h == aVar.f316h && this.f317i == aVar.f317i && this.f321m == aVar.f321m && this.f322n == aVar.f322n && this.diskCacheStrategy.equals(aVar.diskCacheStrategy) && this.priority == aVar.priority && this.options.equals(aVar.options) && this.transformations.equals(aVar.transformations) && this.resourceClass.equals(aVar.resourceClass) && s.bothNullOrEqual(this.signature, aVar.signature) && s.bothNullOrEqual(this.theme, aVar.theme);
    }

    @NonNull
    @CheckResult
    public a error(@Nullable Drawable drawable) {
        if (this.f320l) {
            return mo813clone().error(drawable);
        }
        this.errorPlaceholder = drawable;
        int i5 = this.f313a | 16;
        this.c = 0;
        this.f313a = i5 & (-33);
        return selfOrThrowIfLocked();
    }

    @NonNull
    @CheckResult
    public a fallback(@Nullable Drawable drawable) {
        if (this.f320l) {
            return mo813clone().fallback(drawable);
        }
        this.fallbackDrawable = drawable;
        int i5 = this.f313a | 8192;
        this.f318j = 0;
        this.f313a = i5 & (-16385);
        return selfOrThrowIfLocked();
    }

    @NonNull
    @CheckResult
    public a fitCenter() {
        return scaleOnlyTransform(r.f3116a, new C0529y());
    }

    @NonNull
    @CheckResult
    public a format(@NonNull p126w0.b bVar) {
        L0.q.checkNotNull(bVar);
        return set(C0524t.f3119f, bVar).set(p.f3159a, bVar);
    }

    @NonNull
    @CheckResult
    public a frame(@IntRange(from = 0) long j6) {
        return set(f0.d, Long.valueOf(j6));
    }

    @NonNull
    public final AbstractC0501q getDiskCacheStrategy() {
        return this.diskCacheStrategy;
    }

    @Nullable
    public final Drawable getErrorPlaceholder() {
        return this.errorPlaceholder;
    }

    @Nullable
    public final Drawable getFallbackDrawable() {
        return this.fallbackDrawable;
    }

    @NonNull
    public final v getOptions() {
        return this.options;
    }

    @Nullable
    public final Drawable getPlaceholderDrawable() {
        return this.placeholderDrawable;
    }

    @NonNull
    public final o getPriority() {
        return this.priority;
    }

    @NonNull
    public final Class<?> getResourceClass() {
        return this.resourceClass;
    }

    @NonNull
    public final q getSignature() {
        return this.signature;
    }

    @Nullable
    public final Resources.Theme getTheme() {
        return this.theme;
    }

    @NonNull
    public final Map<Class<?>, z> getTransformations() {
        return this.transformations;
    }

    public int hashCode() {
        float f6 = this.b;
        char[] cArr = s.f411a;
        return s.hashCode(this.theme, s.hashCode(this.signature, s.hashCode(this.resourceClass, s.hashCode(this.transformations, s.hashCode(this.options, s.hashCode(this.priority, s.hashCode(this.diskCacheStrategy, s.c(this.f322n ? 1 : 0, s.c(this.f321m ? 1 : 0, s.c(this.f317i ? 1 : 0, s.c(this.f316h ? 1 : 0, s.c(this.f315g, s.c(this.f314f, s.c(this.e ? 1 : 0, s.hashCode(this.fallbackDrawable, s.c(this.f318j, s.hashCode(this.placeholderDrawable, s.c(this.d, s.hashCode(this.errorPlaceholder, s.c(this.c, s.c(Float.floatToIntBits(f6), 17)))))))))))))))))))));
    }

    @NonNull
    public a lock() {
        this.f319k = true;
        return this;
    }

    @NonNull
    @CheckResult
    public a onlyRetrieveFromCache(boolean z6) {
        if (this.f320l) {
            return mo813clone().onlyRetrieveFromCache(z6);
        }
        this.f322n = z6;
        this.f313a |= 524288;
        return selfOrThrowIfLocked();
    }

    @NonNull
    @CheckResult
    public a optionalCenterCrop() {
        return optionalTransform(r.c, new C0514i());
    }

    @NonNull
    @CheckResult
    public a optionalCenterInside() {
        return optionalScaleOnlyTransform(r.b, new C0515j());
    }

    @NonNull
    @CheckResult
    public a optionalCircleCrop() {
        return optionalTransform(r.c, new C0516k());
    }

    @NonNull
    @CheckResult
    public a optionalFitCenter() {
        return optionalScaleOnlyTransform(r.f3116a, new C0529y());
    }

    @NonNull
    public final a optionalTransform(@NonNull r rVar, @NonNull z zVar) {
        if (this.f320l) {
            return mo813clone().optionalTransform(rVar, zVar);
        }
        downsample(rVar);
        return transform(zVar, false);
    }

    @NonNull
    @CheckResult
    public a override(int i5, int i6) {
        if (this.f320l) {
            return mo813clone().override(i5, i6);
        }
        this.f315g = i5;
        this.f314f = i6;
        this.f313a |= 512;
        return selfOrThrowIfLocked();
    }

    @NonNull
    @CheckResult
    public a placeholder(@Nullable Drawable drawable) {
        if (this.f320l) {
            return mo813clone().placeholder(drawable);
        }
        this.placeholderDrawable = drawable;
        int i5 = this.f313a | 64;
        this.d = 0;
        this.f313a = i5 & (-129);
        return selfOrThrowIfLocked();
    }

    @NonNull
    @CheckResult
    public a priority(@NonNull o oVar) {
        if (this.f320l) {
            return mo813clone().priority(oVar);
        }
        this.priority = (o) L0.q.checkNotNull(oVar);
        this.f313a |= 8;
        return selfOrThrowIfLocked();
    }

    public a removeOption(@NonNull u uVar) {
        if (this.f320l) {
            return mo813clone().removeOption(uVar);
        }
        this.options.remove(uVar);
        return selfOrThrowIfLocked();
    }

    @NonNull
    public final a selfOrThrowIfLocked() {
        if (this.f319k) {
            throw new IllegalStateException("You cannot modify locked T, consider clone()");
        }
        return this;
    }

    @NonNull
    @CheckResult
    public <Y> a set(@NonNull u uVar, @NonNull Y y6) {
        if (this.f320l) {
            return mo813clone().set(uVar, y6);
        }
        L0.q.checkNotNull(uVar);
        L0.q.checkNotNull(y6);
        this.options.set(uVar, y6);
        return selfOrThrowIfLocked();
    }

    @NonNull
    @CheckResult
    public a signature(@NonNull q qVar) {
        if (this.f320l) {
            return mo813clone().signature(qVar);
        }
        this.signature = (q) L0.q.checkNotNull(qVar);
        this.f313a |= 1024;
        return selfOrThrowIfLocked();
    }

    @NonNull
    @CheckResult
    public a sizeMultiplier(@FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float f6) {
        if (this.f320l) {
            return mo813clone().sizeMultiplier(f6);
        }
        if (f6 < 0.0f || f6 > 1.0f) {
            throw new IllegalArgumentException("sizeMultiplier must be between 0 and 1");
        }
        this.b = f6;
        this.f313a |= 2;
        return selfOrThrowIfLocked();
    }

    @NonNull
    @CheckResult
    public a skipMemoryCache(boolean z6) {
        if (this.f320l) {
            return mo813clone().skipMemoryCache(true);
        }
        this.e = !z6;
        this.f313a |= 256;
        return selfOrThrowIfLocked();
    }

    @NonNull
    @CheckResult
    public a theme(@Nullable Resources.Theme theme) {
        if (this.f320l) {
            return mo813clone().theme(theme);
        }
        this.theme = theme;
        if (theme != null) {
            this.f313a |= 32768;
            return set(D0.h.b, theme);
        }
        this.f313a &= -32769;
        return removeOption(D0.h.b);
    }

    @NonNull
    @CheckResult
    public a timeout(@IntRange(from = 0) int i5) {
        return set(A0.b.f8a, Integer.valueOf(i5));
    }

    @NonNull
    @CheckResult
    public final a transform(@NonNull r rVar, @NonNull z zVar) {
        if (this.f320l) {
            return mo813clone().transform(rVar, zVar);
        }
        downsample(rVar);
        return transform(zVar);
    }

    @NonNull
    @CheckResult
    @Deprecated
    public a transforms(@NonNull z... zVarArr) {
        return transform((z) new p126w0.r(zVarArr), true);
    }

    @NonNull
    @CheckResult
    public a useAnimationPool(boolean z6) {
        if (this.f320l) {
            return mo813clone().useAnimationPool(z6);
        }
        this.f324p = z6;
        this.f313a |= 1048576;
        return selfOrThrowIfLocked();
    }

    @NonNull
    @CheckResult
    public a useUnlimitedSourceGeneratorsPool(boolean z6) {
        if (this.f320l) {
            return mo813clone().useUnlimitedSourceGeneratorsPool(z6);
        }
        this.f321m = z6;
        this.f313a |= 262144;
        return selfOrThrowIfLocked();
    }

    @NonNull
    private a scaleOnlyTransform(@NonNull r rVar, @NonNull z zVar, boolean z6) {
        a aVarTransform = z6 ? transform(rVar, zVar) : optionalTransform(rVar, zVar);
        aVarTransform.f323o = true;
        return aVarTransform;
    }

    @Override // 
    @CheckResult
    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public a mo813clone() {
        try {
            a aVar = (a) super.clone();
            v vVar = new v();
            aVar.options = vVar;
            vVar.putAll(this.options);
            L0.d dVar = new L0.d();
            aVar.transformations = dVar;
            dVar.putAll(this.transformations);
            aVar.f319k = false;
            aVar.f320l = false;
            return aVar;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @NonNull
    @CheckResult
    public a optionalTransform(@NonNull z zVar) {
        return transform(zVar, false);
    }

    @NonNull
    @CheckResult
    public a transform(@NonNull z zVar) {
        return transform(zVar, true);
    }

    @NonNull
    @CheckResult
    public <Y> a optionalTransform(@NonNull Class<Y> cls, @NonNull z zVar) {
        return transform(cls, zVar, false);
    }

    @NonNull
    @CheckResult
    public a transform(@NonNull z... zVarArr) {
        if (zVarArr.length > 1) {
            return transform((z) new p126w0.r(zVarArr), true);
        }
        if (zVarArr.length == 1) {
            return transform(zVarArr[0]);
        }
        return selfOrThrowIfLocked();
    }

    @NonNull
    @CheckResult
    public a override(int i5) {
        return override(i5, i5);
    }

    @NonNull
    @CheckResult
    public a error(@DrawableRes int i5) {
        if (this.f320l) {
            return mo813clone().error(i5);
        }
        this.c = i5;
        int i6 = this.f313a | 32;
        this.errorPlaceholder = null;
        this.f313a = i6 & (-17);
        return selfOrThrowIfLocked();
    }

    @NonNull
    @CheckResult
    public a fallback(@DrawableRes int i5) {
        if (this.f320l) {
            return mo813clone().fallback(i5);
        }
        this.f318j = i5;
        int i6 = this.f313a | 16384;
        this.fallbackDrawable = null;
        this.f313a = i6 & (-8193);
        return selfOrThrowIfLocked();
    }

    @NonNull
    @CheckResult
    public a placeholder(@DrawableRes int i5) {
        if (this.f320l) {
            return mo813clone().placeholder(i5);
        }
        this.d = i5;
        int i6 = this.f313a | 128;
        this.placeholderDrawable = null;
        this.f313a = i6 & (-65);
        return selfOrThrowIfLocked();
    }

    @NonNull
    public a transform(@NonNull z zVar, boolean z6) {
        if (this.f320l) {
            return mo813clone().transform(zVar, z6);
        }
        C0527w c0527w = new C0527w(zVar, z6);
        transform(Bitmap.class, zVar, z6);
        transform(Drawable.class, c0527w, z6);
        transform(BitmapDrawable.class, c0527w, z6);
        transform(com.bumptech.glide.load.resource.gif.f.class, new com.bumptech.glide.load.resource.gif.i(zVar), z6);
        return selfOrThrowIfLocked();
    }

    @NonNull
    public <Y> a transform(@NonNull Class<Y> cls, @NonNull z zVar, boolean z6) {
        if (this.f320l) {
            return mo813clone().transform(cls, zVar, z6);
        }
        L0.q.checkNotNull(cls);
        L0.q.checkNotNull(zVar);
        this.transformations.put(cls, zVar);
        int i5 = this.f313a;
        this.f317i = true;
        this.f313a = 67584 | i5;
        this.f323o = false;
        if (z6) {
            this.f313a = i5 | 198656;
            this.f316h = true;
        }
        return selfOrThrowIfLocked();
    }

    @NonNull
    @CheckResult
    public <Y> a transform(@NonNull Class<Y> cls, @NonNull z zVar) {
        return transform(cls, zVar, true);
    }
}
