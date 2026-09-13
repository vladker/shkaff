package I0;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import androidx.annotation.CheckResult;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.engine.AbstractC0501q;
import com.bumptech.glide.load.resource.bitmap.r;
import com.bumptech.glide.o;
import com.google.android.material.color.utilities.Contrast;
import p126w0.q;
import p126w0.u;
import p126w0.z;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class j extends a {

    @Nullable
    private static j centerCropOptions;

    @Nullable
    private static j centerInsideOptions;

    @Nullable
    private static j circleCropOptions;

    @Nullable
    private static j fitCenterOptions;

    @Nullable
    private static j noAnimationOptions;

    @Nullable
    private static j noTransformOptions;

    @Nullable
    private static j skipMemoryCacheFalseOptions;

    @Nullable
    private static j skipMemoryCacheTrueOptions;

    @NonNull
    @CheckResult
    public static j bitmapTransform(@NonNull z zVar) {
        return (j) new j().transform(zVar);
    }

    @NonNull
    @CheckResult
    public static j centerCropTransform() {
        if (centerCropOptions == null) {
            centerCropOptions = (j) ((j) new j().centerCrop()).autoClone();
        }
        return centerCropOptions;
    }

    @NonNull
    @CheckResult
    public static j centerInsideTransform() {
        if (centerInsideOptions == null) {
            centerInsideOptions = (j) ((j) new j().centerInside()).autoClone();
        }
        return centerInsideOptions;
    }

    @NonNull
    @CheckResult
    public static j circleCropTransform() {
        if (circleCropOptions == null) {
            circleCropOptions = (j) ((j) new j().circleCrop()).autoClone();
        }
        return circleCropOptions;
    }

    @NonNull
    @CheckResult
    public static j decodeTypeOf(@NonNull Class<?> cls) {
        return (j) new j().decode(cls);
    }

    @NonNull
    @CheckResult
    public static j diskCacheStrategyOf(@NonNull AbstractC0501q abstractC0501q) {
        return (j) new j().diskCacheStrategy(abstractC0501q);
    }

    @NonNull
    @CheckResult
    public static j downsampleOf(@NonNull r rVar) {
        return (j) new j().downsample(rVar);
    }

    @NonNull
    @CheckResult
    public static j encodeFormatOf(@NonNull Bitmap.CompressFormat compressFormat) {
        return (j) new j().encodeFormat(compressFormat);
    }

    @NonNull
    @CheckResult
    public static j encodeQualityOf(@IntRange(from = 0, to = 100) int i5) {
        return (j) new j().encodeQuality(i5);
    }

    @NonNull
    @CheckResult
    public static j errorOf(@Nullable Drawable drawable) {
        return (j) new j().error(drawable);
    }

    @NonNull
    @CheckResult
    public static j fitCenterTransform() {
        if (fitCenterOptions == null) {
            fitCenterOptions = (j) ((j) new j().fitCenter()).autoClone();
        }
        return fitCenterOptions;
    }

    @NonNull
    @CheckResult
    public static j formatOf(@NonNull p126w0.b bVar) {
        return (j) new j().format(bVar);
    }

    @NonNull
    @CheckResult
    public static j frameOf(@IntRange(from = 0) long j6) {
        return (j) new j().frame(j6);
    }

    @NonNull
    @CheckResult
    public static j noAnimation() {
        if (noAnimationOptions == null) {
            noAnimationOptions = (j) ((j) new j().dontAnimate()).autoClone();
        }
        return noAnimationOptions;
    }

    @NonNull
    @CheckResult
    public static j noTransformation() {
        if (noTransformOptions == null) {
            noTransformOptions = (j) ((j) new j().dontTransform()).autoClone();
        }
        return noTransformOptions;
    }

    @NonNull
    @CheckResult
    public static <T> j option(@NonNull u uVar, @NonNull T t6) {
        return (j) new j().set(uVar, t6);
    }

    @NonNull
    @CheckResult
    public static j overrideOf(int i5, int i6) {
        return (j) new j().override(i5, i6);
    }

    @NonNull
    @CheckResult
    public static j placeholderOf(@Nullable Drawable drawable) {
        return (j) new j().placeholder(drawable);
    }

    @NonNull
    @CheckResult
    public static j priorityOf(@NonNull o oVar) {
        return (j) new j().priority(oVar);
    }

    @NonNull
    @CheckResult
    public static j signatureOf(@NonNull q qVar) {
        return (j) new j().signature(qVar);
    }

    @NonNull
    @CheckResult
    public static j sizeMultiplierOf(@FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float f6) {
        return (j) new j().sizeMultiplier(f6);
    }

    @NonNull
    @CheckResult
    public static j skipMemoryCacheOf(boolean z6) {
        if (z6) {
            if (skipMemoryCacheTrueOptions == null) {
                skipMemoryCacheTrueOptions = (j) ((j) new j().skipMemoryCache(true)).autoClone();
            }
            return skipMemoryCacheTrueOptions;
        }
        if (skipMemoryCacheFalseOptions == null) {
            skipMemoryCacheFalseOptions = (j) ((j) new j().skipMemoryCache(false)).autoClone();
        }
        return skipMemoryCacheFalseOptions;
    }

    @NonNull
    @CheckResult
    public static j timeoutOf(@IntRange(from = 0) int i5) {
        return (j) new j().timeout(i5);
    }

    @Override // I0.a
    public final boolean equals(Object obj) {
        return (obj instanceof j) && super.equals(obj);
    }

    @NonNull
    @CheckResult
    public static j errorOf(@DrawableRes int i5) {
        return (j) new j().error(i5);
    }

    @NonNull
    @CheckResult
    public static j overrideOf(int i5) {
        return overrideOf(i5, i5);
    }

    @NonNull
    @CheckResult
    public static j placeholderOf(@DrawableRes int i5) {
        return (j) new j().placeholder(i5);
    }
}
