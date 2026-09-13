package I2;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.FloatRange;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.color.utilities.Contrast;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public interface f {
    @NonNull
    ViewGroup getLayout();

    @Nullable
    c getRefreshFooter();

    @Nullable
    d getRefreshHeader();

    @NonNull
    J2.b getState();

    f setDragRate(@FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float f6);

    f setFixedFooterViewId(@IdRes int i5);

    f setFixedHeaderViewId(@IdRes int i5);

    f setFooterMaxDragRate(@FloatRange(from = Contrast.RATIO_MIN, to = 10.0d) float f6);

    f setFooterTranslationViewId(@IdRes int i5);

    f setFooterTriggerRate(@FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float f6);

    f setHeaderMaxDragRate(@FloatRange(from = Contrast.RATIO_MIN, to = 10.0d) float f6);

    f setHeaderTranslationViewId(@IdRes int i5);

    f setHeaderTriggerRate(@FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float f6);

    f setPrimaryColors(@ColorInt int... iArr);

    f setPrimaryColorsId(@ColorRes int... iArr);

    f setReboundInterpolator(@NonNull Interpolator interpolator);

    f setRefreshContent(@NonNull View view);

    f setRefreshContent(@NonNull View view, int i5, int i6);

    f setRefreshFooter(@NonNull c cVar);

    f setRefreshFooter(@NonNull c cVar, int i5, int i6);

    f setRefreshHeader(@NonNull d dVar);

    f setRefreshHeader(@NonNull d dVar, int i5, int i6);
}
