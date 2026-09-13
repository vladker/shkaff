package androidx.core.view.insets;

import A3.AbstractC0157z;
import android.animation.ValueAnimator;
import android.graphics.drawable.Drawable;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import androidx.annotation.FloatRange;
import androidx.core.graphics.Insets;
import com.google.android.material.color.utilities.Contrast;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public abstract class Protection {
    private static final long DEFAULT_DURATION_IN = 333;
    private static final long DEFAULT_DURATION_OUT = 166;
    private final Attributes mAttributes = new Attributes();
    private Object mController;
    private Insets mInsets;
    private Insets mInsetsIgnoringVisibility;
    private final int mSide;
    private float mSystemAlpha;
    private float mSystemInsetAmount;
    private float mUserAlpha;
    private ValueAnimator mUserAlphaAnimator;
    private float mUserInsetAmount;
    private ValueAnimator mUserInsetAmountAnimator;
    private static final Interpolator DEFAULT_INTERPOLATOR_MOVE_IN = new PathInterpolator(0.0f, 0.0f, 0.0f, 1.0f);
    private static final Interpolator DEFAULT_INTERPOLATOR_MOVE_OUT = new PathInterpolator(0.6f, 0.0f, 1.0f, 1.0f);
    private static final Interpolator DEFAULT_INTERPOLATOR_FADE_IN = new PathInterpolator(0.0f, 0.0f, 0.2f, 1.0f);
    private static final Interpolator DEFAULT_INTERPOLATOR_FADE_OUT = new PathInterpolator(0.4f, 0.0f, 1.0f, 1.0f);

    public Protection(int i5) {
        Insets insets = Insets.NONE;
        this.mInsets = insets;
        this.mInsetsIgnoringVisibility = insets;
        this.mSystemAlpha = 1.0f;
        this.mUserAlpha = 1.0f;
        this.mSystemInsetAmount = 1.0f;
        this.mUserInsetAmount = 1.0f;
        this.mController = null;
        this.mUserAlphaAnimator = null;
        this.mUserInsetAmountAnimator = null;
        if (i5 != 1 && i5 != 2 && i5 != 4 && i5 != 8) {
            throw new IllegalArgumentException(AbstractC0157z.k(i5, "Unexpected side: "));
        }
        this.mSide = i5;
    }

    private void cancelUserAlphaAnimation() {
        ValueAnimator valueAnimator = this.mUserAlphaAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.mUserAlphaAnimator = null;
        }
    }

    private void cancelUserInsetsAmountAnimation() {
        ValueAnimator valueAnimator = this.mUserInsetAmountAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.mUserInsetAmountAnimator = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$animateAlpha$0(ValueAnimator valueAnimator) {
        setAlphaInternal(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$animateInsetsAmount$1(ValueAnimator valueAnimator) {
        setAlphaInternal(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    private void setAlphaInternal(float f6) {
        this.mUserAlpha = f6;
        updateAlpha();
    }

    private void setInsetAmountInternal(float f6) {
        this.mUserInsetAmount = f6;
        updateInsetAmount();
    }

    private void updateAlpha() {
        this.mAttributes.setAlpha(this.mSystemAlpha * this.mUserAlpha);
    }

    private void updateInsetAmount() {
        float f6 = this.mUserInsetAmount * this.mSystemInsetAmount;
        int i5 = this.mSide;
        if (i5 == 1) {
            Attributes attributes = this.mAttributes;
            attributes.setTranslationX((-(1.0f - f6)) * attributes.mWidth);
            return;
        }
        if (i5 == 2) {
            Attributes attributes2 = this.mAttributes;
            attributes2.setTranslationY((-(1.0f - f6)) * attributes2.mHeight);
        } else if (i5 == 4) {
            Attributes attributes3 = this.mAttributes;
            attributes3.setTranslationX((1.0f - f6) * attributes3.mWidth);
        } else {
            if (i5 != 8) {
                return;
            }
            Attributes attributes4 = this.mAttributes;
            attributes4.setTranslationY((1.0f - f6) * attributes4.mHeight);
        }
    }

    public void animateAlpha(float f6) {
        cancelUserAlphaAnimation();
        float f7 = this.mUserAlpha;
        if (f6 == f7) {
            return;
        }
        int i5 = 1;
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(f7, f6);
        this.mUserAlphaAnimator = valueAnimatorOfFloat;
        if (this.mUserAlpha < f6) {
            valueAnimatorOfFloat.setDuration(DEFAULT_DURATION_IN);
            this.mUserAlphaAnimator.setInterpolator(DEFAULT_INTERPOLATOR_FADE_IN);
        } else {
            valueAnimatorOfFloat.setDuration(DEFAULT_DURATION_OUT);
            this.mUserAlphaAnimator.setInterpolator(DEFAULT_INTERPOLATOR_FADE_OUT);
        }
        this.mUserAlphaAnimator.addUpdateListener(new a(this, i5));
        this.mUserAlphaAnimator.start();
    }

    public void animateInsetsAmount(float f6) {
        cancelUserInsetsAmountAnimation();
        float f7 = this.mUserInsetAmount;
        if (f6 == f7) {
            return;
        }
        int i5 = 0;
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(f7, f6);
        this.mUserInsetAmountAnimator = valueAnimatorOfFloat;
        if (this.mUserInsetAmount < f6) {
            valueAnimatorOfFloat.setDuration(DEFAULT_DURATION_IN);
            this.mUserInsetAmountAnimator.setInterpolator(DEFAULT_INTERPOLATOR_MOVE_IN);
        } else {
            valueAnimatorOfFloat.setDuration(DEFAULT_DURATION_OUT);
            this.mUserInsetAmountAnimator.setInterpolator(DEFAULT_INTERPOLATOR_MOVE_OUT);
        }
        this.mUserInsetAmountAnimator.addUpdateListener(new a(this, i5));
        this.mUserInsetAmountAnimator.start();
    }

    public Insets dispatchInsets(Insets insets, Insets insets2, Insets insets3) {
        this.mInsets = insets;
        this.mInsetsIgnoringVisibility = insets2;
        this.mAttributes.setMargin(insets3);
        return updateLayout();
    }

    @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN)
    public float getAlpha() {
        return this.mUserAlpha;
    }

    public Attributes getAttributes() {
        return this.mAttributes;
    }

    public Object getController() {
        return this.mController;
    }

    public float getInsetAmount() {
        return this.mUserInsetAmount;
    }

    public int getSide() {
        return this.mSide;
    }

    public boolean occupiesCorners() {
        return false;
    }

    public void setAlpha(@FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float f6) {
        if (f6 < 0.0f || f6 > 1.0f) {
            throw new IllegalArgumentException("Alpha must in a range of [0, 1]. Got: " + f6);
        }
        cancelUserAlphaAnimation();
        setAlphaInternal(f6);
    }

    public void setController(Object obj) {
        this.mController = obj;
    }

    public void setDrawable(Drawable drawable) {
        this.mAttributes.setDrawable(drawable);
    }

    public void setInsetAmount(@FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float f6) {
        if (f6 < 0.0f || f6 > 1.0f) {
            throw new IllegalArgumentException("Inset amount must in a range of [0, 1]. Got: " + f6);
        }
        cancelUserInsetsAmountAnimation();
        setInsetAmountInternal(f6);
    }

    public void setSystemAlpha(@FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float f6) {
        this.mSystemAlpha = f6;
        updateAlpha();
    }

    public void setSystemInsetAmount(@FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float f6) {
        this.mSystemInsetAmount = f6;
        updateInsetAmount();
    }

    public void setSystemVisible(boolean z6) {
        this.mAttributes.setVisible(z6);
    }

    public Insets updateLayout() {
        int i5;
        Insets insetsOf = Insets.NONE;
        int i6 = this.mSide;
        if (i6 == 1) {
            i5 = this.mInsets.left;
            this.mAttributes.setWidth(getThickness(this.mInsetsIgnoringVisibility.left));
            if (occupiesCorners()) {
                insetsOf = Insets.of(getThickness(i5), 0, 0, 0);
            }
        } else if (i6 == 2) {
            i5 = this.mInsets.top;
            this.mAttributes.setHeight(getThickness(this.mInsetsIgnoringVisibility.top));
            if (occupiesCorners()) {
                insetsOf = Insets.of(0, getThickness(i5), 0, 0);
            }
        } else if (i6 == 4) {
            i5 = this.mInsets.right;
            this.mAttributes.setWidth(getThickness(this.mInsetsIgnoringVisibility.right));
            if (occupiesCorners()) {
                insetsOf = Insets.of(0, 0, getThickness(i5), 0);
            }
        } else if (i6 != 8) {
            i5 = 0;
        } else {
            i5 = this.mInsets.bottom;
            this.mAttributes.setHeight(getThickness(this.mInsetsIgnoringVisibility.bottom));
            if (occupiesCorners()) {
                insetsOf = Insets.of(0, 0, 0, getThickness(i5));
            }
        }
        setSystemVisible(i5 > 0);
        setSystemAlpha(i5 > 0 ? 1.0f : 0.0f);
        setSystemInsetAmount(i5 > 0 ? 1.0f : 0.0f);
        return insetsOf;
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class Attributes {
        private static final int UNSPECIFIED = -1;
        private Callback mCallback;
        private int mWidth = -1;
        private int mHeight = -1;
        private Insets mMargin = Insets.NONE;
        private boolean mVisible = false;
        private Drawable mDrawable = null;
        private float mTranslationX = 0.0f;
        private float mTranslationY = 0.0f;
        private float mAlpha = 1.0f;

        /* JADX INFO: Access modifiers changed from: private */
        public void setAlpha(float f6) {
            if (this.mAlpha != f6) {
                this.mAlpha = f6;
                Callback callback = this.mCallback;
                if (callback != null) {
                    callback.onAlphaChanged(f6);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDrawable(Drawable drawable) {
            this.mDrawable = drawable;
            Callback callback = this.mCallback;
            if (callback != null) {
                callback.onDrawableChanged(drawable);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setHeight(int i5) {
            if (this.mHeight != i5) {
                this.mHeight = i5;
                Callback callback = this.mCallback;
                if (callback != null) {
                    callback.onHeightChanged(i5);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMargin(Insets insets) {
            if (this.mMargin.equals(insets)) {
                return;
            }
            this.mMargin = insets;
            Callback callback = this.mCallback;
            if (callback != null) {
                callback.onMarginChanged(insets);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTranslationX(float f6) {
            if (this.mTranslationX != f6) {
                this.mTranslationX = f6;
                Callback callback = this.mCallback;
                if (callback != null) {
                    callback.onTranslationXChanged(f6);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTranslationY(float f6) {
            if (this.mTranslationY != f6) {
                this.mTranslationY = f6;
                Callback callback = this.mCallback;
                if (callback != null) {
                    callback.onTranslationYChanged(f6);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setVisible(boolean z6) {
            if (this.mVisible != z6) {
                this.mVisible = z6;
                Callback callback = this.mCallback;
                if (callback != null) {
                    callback.onVisibilityChanged(z6);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setWidth(int i5) {
            if (this.mWidth != i5) {
                this.mWidth = i5;
                Callback callback = this.mCallback;
                if (callback != null) {
                    callback.onWidthChanged(i5);
                }
            }
        }

        public float getAlpha() {
            return this.mAlpha;
        }

        public Drawable getDrawable() {
            return this.mDrawable;
        }

        public int getHeight() {
            return this.mHeight;
        }

        public Insets getMargin() {
            return this.mMargin;
        }

        public float getTranslationX() {
            return this.mTranslationX;
        }

        public float getTranslationY() {
            return this.mTranslationY;
        }

        public int getWidth() {
            return this.mWidth;
        }

        public boolean isVisible() {
            return this.mVisible;
        }

        public void setCallback(Callback callback) {
            if (this.mCallback != null && callback != null) {
                throw new IllegalStateException("Trying to overwrite the existing callback. Did you send one protection to multiple ProtectionLayouts?");
            }
            this.mCallback = callback;
        }

        /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
        public interface Callback {
            default void onAlphaChanged(float f6) {
            }

            default void onDrawableChanged(Drawable drawable) {
            }

            default void onHeightChanged(int i5) {
            }

            default void onMarginChanged(Insets insets) {
            }

            default void onTranslationXChanged(float f6) {
            }

            default void onTranslationYChanged(float f6) {
            }

            default void onVisibilityChanged(boolean z6) {
            }

            default void onWidthChanged(int i5) {
            }
        }
    }

    public void dispatchColorHint(int i5) {
    }

    public int getThickness(int i5) {
        return i5;
    }
}
