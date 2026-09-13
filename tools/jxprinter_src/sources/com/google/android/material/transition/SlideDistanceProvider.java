package com.google.android.material.transition;

import A3.AbstractC0157z;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class SlideDistanceProvider implements VisibilityAnimatorProvider {
    private static final int DEFAULT_DISTANCE = -1;

    @Px
    private int slideDistance = -1;
    private int slideEdge;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface GravityFlag {
    }

    public SlideDistanceProvider(int i5) {
        this.slideEdge = i5;
    }

    private static Animator createTranslationAppearAnimator(View view, View view2, int i5, @Px int i6) {
        float translationX = view2.getTranslationX();
        float translationY = view2.getTranslationY();
        if (i5 == 3) {
            return createTranslationXAnimator(view2, i6 + translationX, translationX, translationX);
        }
        if (i5 == 5) {
            return createTranslationXAnimator(view2, translationX - i6, translationX, translationX);
        }
        if (i5 == 48) {
            return createTranslationYAnimator(view2, translationY - i6, translationY, translationY);
        }
        if (i5 == 80) {
            return createTranslationYAnimator(view2, i6 + translationY, translationY, translationY);
        }
        if (i5 == 8388611) {
            return createTranslationXAnimator(view2, isRtl(view) ? i6 + translationX : translationX - i6, translationX, translationX);
        }
        if (i5 == 8388613) {
            return createTranslationXAnimator(view2, isRtl(view) ? translationX - i6 : i6 + translationX, translationX, translationX);
        }
        throw new IllegalArgumentException(AbstractC0157z.k(i5, "Invalid slide direction: "));
    }

    private static Animator createTranslationDisappearAnimator(View view, View view2, int i5, @Px int i6) {
        float translationX = view2.getTranslationX();
        float translationY = view2.getTranslationY();
        if (i5 == 3) {
            return createTranslationXAnimator(view2, translationX, translationX - i6, translationX);
        }
        if (i5 == 5) {
            return createTranslationXAnimator(view2, translationX, i6 + translationX, translationX);
        }
        if (i5 == 48) {
            return createTranslationYAnimator(view2, translationY, i6 + translationY, translationY);
        }
        if (i5 == 80) {
            return createTranslationYAnimator(view2, translationY, translationY - i6, translationY);
        }
        if (i5 == 8388611) {
            return createTranslationXAnimator(view2, translationX, isRtl(view) ? translationX - i6 : i6 + translationX, translationX);
        }
        if (i5 == 8388613) {
            return createTranslationXAnimator(view2, translationX, isRtl(view) ? i6 + translationX : translationX - i6, translationX);
        }
        throw new IllegalArgumentException(AbstractC0157z.k(i5, "Invalid slide direction: "));
    }

    private static Animator createTranslationXAnimator(final View view, float f6, float f7, final float f8) {
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat((Property<?, Float>) View.TRANSLATION_X, f6, f7));
        objectAnimatorOfPropertyValuesHolder.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.transition.SlideDistanceProvider.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                view.setTranslationX(f8);
            }
        });
        return objectAnimatorOfPropertyValuesHolder;
    }

    private static Animator createTranslationYAnimator(final View view, float f6, float f7, final float f8) {
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat((Property<?, Float>) View.TRANSLATION_Y, f6, f7));
        objectAnimatorOfPropertyValuesHolder.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.transition.SlideDistanceProvider.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                view.setTranslationY(f8);
            }
        });
        return objectAnimatorOfPropertyValuesHolder;
    }

    private int getSlideDistanceOrDefault(Context context) {
        int i5 = this.slideDistance;
        return i5 != -1 ? i5 : context.getResources().getDimensionPixelSize(R.dimen.mtrl_transition_shared_axis_slide_distance);
    }

    private static boolean isRtl(View view) {
        return ViewCompat.getLayoutDirection(view) == 1;
    }

    @Override // com.google.android.material.transition.VisibilityAnimatorProvider
    @Nullable
    public Animator createAppear(@NonNull ViewGroup viewGroup, @NonNull View view) {
        return createTranslationAppearAnimator(viewGroup, view, this.slideEdge, getSlideDistanceOrDefault(view.getContext()));
    }

    @Override // com.google.android.material.transition.VisibilityAnimatorProvider
    @Nullable
    public Animator createDisappear(@NonNull ViewGroup viewGroup, @NonNull View view) {
        return createTranslationDisappearAnimator(viewGroup, view, this.slideEdge, getSlideDistanceOrDefault(view.getContext()));
    }

    @Px
    public int getSlideDistance() {
        return this.slideDistance;
    }

    public int getSlideEdge() {
        return this.slideEdge;
    }

    public void setSlideDistance(@Px int i5) {
        if (i5 < 0) {
            throw new IllegalArgumentException("Slide distance must be positive. If attempting to reverse the direction of the slide, use setSlideEdge(int) instead.");
        }
        this.slideDistance = i5;
    }

    public void setSlideEdge(int i5) {
        this.slideEdge = i5;
    }
}
