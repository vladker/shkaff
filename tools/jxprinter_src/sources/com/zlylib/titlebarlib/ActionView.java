package com.zlylib.titlebarlib;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import androidx.core.content.ContextCompat;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class ActionView extends FrameLayout {
    private int iconColor;
    private int[] iconMargin;
    private int[] iconPadding;
    private int iconRes;
    private ActionIconView iconView;
    private String text;
    private int textColor;
    private int[] textMargin;
    private int[] textPadding;
    private float textSize;
    private ActionTextView textView;

    public ActionView(Context context) {
        this(context, null);
    }

    private ActionIconView createIconView() {
        ActionIconView actionIconView = new ActionIconView(getContext());
        actionIconView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(0, -1);
        int[] iArr = this.iconMargin;
        layoutParams.leftMargin = iArr[0];
        layoutParams.topMargin = iArr[1];
        layoutParams.rightMargin = iArr[2];
        layoutParams.bottomMargin = iArr[3];
        actionIconView.setLayoutParams(layoutParams);
        int[] iArr2 = this.iconPadding;
        actionIconView.setPadding(iArr2[0], iArr2[1], iArr2[2], iArr2[3]);
        actionIconView.setVisibility(8);
        return actionIconView;
    }

    private ActionTextView createTextView() {
        ActionTextView actionTextView = new ActionTextView(getContext());
        actionTextView.setGravity(17);
        actionTextView.setSingleLine(true);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -1);
        int[] iArr = this.textMargin;
        layoutParams.leftMargin = iArr[0];
        layoutParams.topMargin = iArr[1];
        layoutParams.rightMargin = iArr[2];
        layoutParams.bottomMargin = iArr[3];
        actionTextView.setLayoutParams(layoutParams);
        int[] iArr2 = this.textPadding;
        actionTextView.setPadding(iArr2[0], iArr2[1], iArr2[2], iArr2[3]);
        actionTextView.setVisibility(8);
        return actionTextView;
    }

    private void initAttrs(AttributeSet attributeSet) {
        float dimension = getContext().getResources().getDimension(R.dimen.actionbarex_common_title_bar_text_size_def);
        int color = ContextCompat.getColor(getContext(), R.color.actionbarex_common_title_bar_text_color_def);
        float dimension2 = getContext().getResources().getDimension(R.dimen.actionbarex_common_title_bar_text_padding_left_def);
        float dimension3 = getContext().getResources().getDimension(R.dimen.actionbarex_common_title_bar_text_padding_right_def);
        int color2 = ContextCompat.getColor(getContext(), R.color.actionbarex_common_title_bar_icon_color_def);
        float dimension4 = getContext().getResources().getDimension(R.dimen.actionbarex_common_title_bar_icon_padding_def);
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ActionView);
        this.text = typedArrayObtainStyledAttributes.getString(R.styleable.ActionView_av_text);
        int i5 = R.styleable.ActionView_av_textSize;
        this.textSize = typedArrayObtainStyledAttributes.getDimension(i5, dimension);
        this.textColor = typedArrayObtainStyledAttributes.getColor(i5, color);
        int dimension5 = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionView_av_textPadding, -1.0f);
        int[] iArr = this.textPadding;
        int i6 = R.styleable.ActionView_av_textPaddingLeft;
        if (dimension5 >= 0) {
            dimension2 = dimension5;
        }
        iArr[0] = (int) typedArrayObtainStyledAttributes.getDimension(i6, dimension2);
        this.textPadding[1] = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionView_av_textPaddingTop, dimension5 >= 0 ? dimension5 : 0.0f);
        int[] iArr2 = this.textPadding;
        int i7 = R.styleable.ActionView_av_textPaddingRight;
        if (dimension5 >= 0) {
            dimension3 = dimension5;
        }
        iArr2[2] = (int) typedArrayObtainStyledAttributes.getDimension(i7, dimension3);
        this.textPadding[3] = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionView_av_textPaddingBottom, dimension5 >= 0 ? dimension5 : 0.0f);
        int dimension6 = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionView_av_textMargin, -1.0f);
        this.textMargin[0] = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionView_av_textMarginLeft, dimension6 >= 0 ? dimension6 : 0.0f);
        this.textMargin[1] = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionView_av_textMarginTop, dimension6 >= 0 ? dimension6 : 0.0f);
        this.textMargin[2] = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionView_av_textMarginRight, dimension6 >= 0 ? dimension6 : 0.0f);
        this.textMargin[3] = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionView_av_textMarginBottom, dimension6 >= 0 ? dimension6 : 0.0f);
        this.iconRes = typedArrayObtainStyledAttributes.getResourceId(R.styleable.ActionView_av_icon, 0);
        this.iconColor = typedArrayObtainStyledAttributes.getColor(R.styleable.ActionView_av_iconColor, color2);
        int dimension7 = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionView_av_iconPadding, -1.0f);
        this.iconPadding[0] = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionView_av_iconPaddingLeft, dimension7 >= 0 ? dimension7 : dimension4);
        this.iconPadding[1] = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionView_av_iconPaddingTop, dimension7 >= 0 ? dimension7 : dimension4);
        this.iconPadding[2] = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionView_av_iconPaddingRight, dimension7 >= 0 ? dimension7 : dimension4);
        int[] iArr3 = this.iconPadding;
        int i8 = R.styleable.ActionView_av_iconPaddingBottom;
        if (dimension7 >= 0) {
            dimension4 = dimension7;
        }
        iArr3[3] = (int) typedArrayObtainStyledAttributes.getDimension(i8, dimension4);
        int dimension8 = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionView_av_iconMargin, -1.0f);
        this.iconMargin[0] = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionView_av_iconMarginLeft, dimension8 >= 0 ? dimension8 : 0.0f);
        this.iconMargin[1] = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionView_av_iconMarginTop, dimension8 >= 0 ? dimension8 : 0.0f);
        this.iconMargin[2] = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionView_av_iconMarginRight, dimension8 >= 0 ? dimension8 : 0.0f);
        this.iconMargin[3] = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.ActionView_av_iconMarginBottom, dimension8 >= 0 ? dimension8 : 0.0f);
        typedArrayObtainStyledAttributes.recycle();
    }

    private void initView() {
        this.iconView = createIconView();
        this.textView = createTextView();
        addViewInLayout(this.iconView, getChildCount(), this.iconView.getLayoutParams());
        addViewInLayout(this.textView, getChildCount(), this.textView.getLayoutParams());
        setTextColor(this.textColor);
        setTextSizePx(this.textSize);
        setIconColorInt(this.iconColor);
        int i5 = this.iconRes;
        if (i5 > 0) {
            setIcon(i5);
        } else if (TextUtils.isEmpty(this.text)) {
            toggleToGone();
        } else {
            setText(this.text);
        }
    }

    public ActionIconView getIconView() {
        return this.iconView;
    }

    public ActionTextView getTextView() {
        return this.textView;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i5, int i6) {
        super.onMeasure(i5, i6);
    }

    public void setIcon(@DrawableRes int i5) {
        this.iconView.setImageResource(i5);
        toggleToIcon();
    }

    public void setIconColorInt(@ColorInt int i5) {
        this.iconView.setColorFilter(i5);
    }

    public void setIconColorRes(@ColorRes int i5) {
        this.iconView.setColorFilter(ContextCompat.getColor(getContext(), i5));
    }

    public void setIconMargin(int i5, int i6, int i7, int i8) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.iconView.getLayoutParams();
        layoutParams.leftMargin = i5;
        layoutParams.topMargin = i6;
        layoutParams.rightMargin = i7;
        layoutParams.bottomMargin = i8;
        this.iconView.setLayoutParams(layoutParams);
    }

    public void setIconPadding(int i5, int i6, int i7, int i8) {
        this.iconView.setPadding(i5, i6, i7, i8);
    }

    public void setText(@NonNull CharSequence charSequence) {
        this.textView.setText(charSequence);
        toggleToText();
    }

    public void setTextColor(@ColorInt int i5) {
        this.textView.setTextColor(i5);
    }

    public void setTextColorRes(@ColorRes int i5) {
        this.textView.setTextColor(ContextCompat.getColor(getContext(), i5));
    }

    public void setTextMargin(int i5, int i6, int i7, int i8) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.textView.getLayoutParams();
        layoutParams.leftMargin = i5;
        layoutParams.topMargin = i6;
        layoutParams.rightMargin = i7;
        layoutParams.bottomMargin = i8;
        this.textView.setLayoutParams(layoutParams);
    }

    public void setTextPadding(int i5, int i6, int i7, int i8) {
        this.textView.setPadding(i5, i6, i7, i8);
    }

    public void setTextSize(float f6) {
        this.textView.setTextSize(f6);
    }

    public void setTextSizePx(float f6) {
        this.textView.setTextSize(0, f6);
    }

    public void toggleToGone() {
        this.textView.setVisibility(8);
        this.iconView.setVisibility(8);
        setVisibility(8);
    }

    public void toggleToIcon() {
        this.textView.setVisibility(8);
        this.iconView.setVisibility(0);
        setVisibility(0);
    }

    public void toggleToText() {
        this.iconView.setVisibility(8);
        this.textView.setVisibility(0);
        setVisibility(0);
    }

    public ActionView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActionView(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        this.textPadding = new int[]{0, 0, 0, 0};
        this.textMargin = new int[]{0, 0, 0, 0};
        this.iconPadding = new int[]{0, 0, 0, 0};
        this.iconMargin = new int[]{0, 0, 0, 0};
        initAttrs(attributeSet);
        initView();
    }

    public void setIcon(Drawable drawable) {
        this.iconView.setImageDrawable(drawable);
        toggleToIcon();
    }

    public void setText(@StringRes int i5) {
        this.textView.setText(i5);
        toggleToText();
    }

    public void setIcon(Bitmap bitmap) {
        this.iconView.setImageBitmap(bitmap);
        toggleToIcon();
    }
}
