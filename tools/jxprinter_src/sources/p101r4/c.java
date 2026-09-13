package p101r4;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class c extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f7971a;
    public final int b;
    public final int c;
    public int d;
    public int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ColorStateList f7972f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ColorStateList f7973g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Animator f7974h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Animator f7975i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f7976j;

    @Nullable
    private a mIndicatorCreatedListener;

    @TargetApi(21)
    public c(Context context, AttributeSet attributeSet, int i5, int i6) {
        int dimensionPixelSize;
        int dimensionPixelSize2;
        int resourceId;
        int resourceId2;
        int resourceId3;
        int i7;
        int i8;
        Animator animatorLoadAnimator;
        super(context, attributeSet, i5, i6);
        int i9 = -1;
        this.f7971a = -1;
        this.b = -1;
        this.c = -1;
        this.f7976j = -1;
        int resourceId4 = d.scale_with_alpha;
        int i10 = e.white_radius;
        if (attributeSet == null) {
            dimensionPixelSize = -1;
            dimensionPixelSize2 = -1;
            resourceId2 = i10;
            resourceId = 0;
            resourceId3 = 0;
            i7 = 0;
            i8 = 17;
        } else {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f.BaseCircleIndicator);
            int dimensionPixelSize3 = typedArrayObtainStyledAttributes.getDimensionPixelSize(f.BaseCircleIndicator_ci_width, -1);
            dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(f.BaseCircleIndicator_ci_height, -1);
            dimensionPixelSize2 = typedArrayObtainStyledAttributes.getDimensionPixelSize(f.BaseCircleIndicator_ci_margin, -1);
            resourceId4 = typedArrayObtainStyledAttributes.getResourceId(f.BaseCircleIndicator_ci_animator, resourceId4);
            resourceId = typedArrayObtainStyledAttributes.getResourceId(f.BaseCircleIndicator_ci_animator_reverse, 0);
            resourceId2 = typedArrayObtainStyledAttributes.getResourceId(f.BaseCircleIndicator_ci_drawable, i10);
            resourceId3 = typedArrayObtainStyledAttributes.getResourceId(f.BaseCircleIndicator_ci_drawable_unselected, resourceId2);
            i7 = typedArrayObtainStyledAttributes.getInt(f.BaseCircleIndicator_ci_orientation, -1);
            int i11 = typedArrayObtainStyledAttributes.getInt(f.BaseCircleIndicator_ci_gravity, -1);
            typedArrayObtainStyledAttributes.recycle();
            i8 = i11;
            i9 = dimensionPixelSize3;
        }
        int iApplyDimension = (int) (TypedValue.applyDimension(1, 5.0f, getResources().getDisplayMetrics()) + 0.5f);
        this.b = i9 < 0 ? iApplyDimension : i9;
        this.c = dimensionPixelSize < 0 ? iApplyDimension : dimensionPixelSize;
        this.f7971a = dimensionPixelSize2 < 0 ? iApplyDimension : dimensionPixelSize2;
        AnimatorInflater.loadAnimator(getContext(), resourceId4);
        Animator animatorLoadAnimator2 = AnimatorInflater.loadAnimator(getContext(), resourceId4);
        this.f7974h = animatorLoadAnimator2;
        animatorLoadAnimator2.setDuration(0L);
        if (resourceId == 0) {
            AnimatorInflater.loadAnimator(getContext(), resourceId4).setInterpolator(new b());
        } else {
            AnimatorInflater.loadAnimator(getContext(), resourceId);
        }
        if (resourceId == 0) {
            animatorLoadAnimator = AnimatorInflater.loadAnimator(getContext(), resourceId4);
            animatorLoadAnimator.setInterpolator(new b());
        } else {
            animatorLoadAnimator = AnimatorInflater.loadAnimator(getContext(), resourceId);
        }
        this.f7975i = animatorLoadAnimator;
        animatorLoadAnimator.setDuration(0L);
        this.d = resourceId2 != 0 ? resourceId2 : i10;
        this.e = resourceId3 != 0 ? resourceId3 : resourceId2;
        setOrientation(i7 == 1 ? 1 : 0);
        setGravity(i8 >= 0 ? i8 : 17);
        if (isInEditMode()) {
            if (this.f7974h.isRunning()) {
                this.f7974h.end();
                this.f7974h.cancel();
            }
            if (this.f7975i.isRunning()) {
                this.f7975i.end();
                this.f7975i.cancel();
            }
            int childCount = getChildCount();
            if (3 < childCount) {
                removeViews(3, childCount - 3);
            } else if (3 > childCount) {
                int i12 = 3 - childCount;
                int orientation = getOrientation();
                for (int i13 = 0; i13 < i12; i13++) {
                    View view = new View(getContext());
                    LinearLayout.LayoutParams layoutParamsGenerateDefaultLayoutParams = generateDefaultLayoutParams();
                    layoutParamsGenerateDefaultLayoutParams.width = this.b;
                    layoutParamsGenerateDefaultLayoutParams.height = this.c;
                    if (orientation == 0) {
                        int i14 = this.f7971a;
                        layoutParamsGenerateDefaultLayoutParams.leftMargin = i14;
                        layoutParamsGenerateDefaultLayoutParams.rightMargin = i14;
                    } else {
                        int i15 = this.f7971a;
                        layoutParamsGenerateDefaultLayoutParams.topMargin = i15;
                        layoutParamsGenerateDefaultLayoutParams.bottomMargin = i15;
                    }
                    addView(view, layoutParamsGenerateDefaultLayoutParams);
                }
            }
            for (int i16 = 0; i16 < 3; i16++) {
                View childAt = getChildAt(i16);
                if (1 == i16) {
                    bindIndicatorBackground(childAt, this.d, this.f7972f);
                    this.f7974h.setTarget(childAt);
                    this.f7974h.start();
                    this.f7974h.end();
                } else {
                    bindIndicatorBackground(childAt, this.e, this.f7973g);
                    this.f7975i.setTarget(childAt);
                    this.f7975i.start();
                    this.f7975i.end();
                }
            }
            this.f7976j = 1;
        }
    }

    private void bindIndicatorBackground(View view, @DrawableRes int i5, @Nullable ColorStateList colorStateList) {
        if (colorStateList == null) {
            view.setBackgroundResource(i5);
            return;
        }
        Drawable drawableWrap = DrawableCompat.wrap(ContextCompat.getDrawable(getContext(), i5).mutate());
        DrawableCompat.setTintList(drawableWrap, colorStateList);
        ViewCompat.setBackground(view, drawableWrap);
    }

    public final void a() {
        int childCount = getChildCount();
        if (childCount <= 0) {
            return;
        }
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (i5 == this.f7976j) {
                bindIndicatorBackground(childAt, this.d, this.f7972f);
            } else {
                bindIndicatorBackground(childAt, this.e, this.f7973g);
            }
        }
    }

    public void changeIndicatorResource(@DrawableRes int i5) {
        changeIndicatorResource(i5, i5);
    }

    public void tintIndicator(@ColorInt int i5) {
        tintIndicator(i5, i5);
    }

    public void changeIndicatorResource(@DrawableRes int i5, @DrawableRes int i6) {
        this.d = i5;
        this.e = i6;
        a();
    }

    public void tintIndicator(@ColorInt int i5, @ColorInt int i6) {
        this.f7972f = ColorStateList.valueOf(i5);
        this.f7973g = ColorStateList.valueOf(i6);
        a();
    }

    public void setIndicatorCreatedListener(@Nullable a aVar) {
    }
}
