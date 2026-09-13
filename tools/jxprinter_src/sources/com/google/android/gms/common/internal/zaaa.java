package com.google.android.gms.common.internal;

import A3.AbstractC0157z;
import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.Button;
import androidx.annotation.Nullable;
import androidx.core.graphics.drawable.DrawableCompat;
import com.google.android.gms.common.util.DeviceProperties;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class zaaa extends Button {
    public zaaa(Context context, @Nullable AttributeSet attributeSet) {
        super(context, null, R.attr.buttonStyle);
    }

    private static final int zab(int i5, int i6, int i7, int i8) {
        if (i5 == 0) {
            return i6;
        }
        if (i5 == 1) {
            return i7;
        }
        if (i5 == 2) {
            return i8;
        }
        throw new IllegalStateException(AbstractC0157z.k(i5, "Unknown color scheme: "));
    }

    public final void zaa(Resources resources, int i5, int i6) {
        setTypeface(Typeface.DEFAULT_BOLD);
        setTextSize(14.0f);
        int i7 = (int) ((resources.getDisplayMetrics().density * 48.0f) + 0.5f);
        setMinHeight(i7);
        setMinWidth(i7);
        int i8 = com.google.android.gms.base.R.drawable.common_google_signin_btn_icon_dark;
        int i9 = com.google.android.gms.base.R.drawable.common_google_signin_btn_icon_light;
        int iZab = zab(i6, i8, i9, i9);
        int i10 = com.google.android.gms.base.R.drawable.common_google_signin_btn_text_dark;
        int i11 = com.google.android.gms.base.R.drawable.common_google_signin_btn_text_light;
        int iZab2 = zab(i6, i10, i11, i11);
        if (i5 == 0 || i5 == 1) {
            iZab = iZab2;
        } else if (i5 != 2) {
            throw new IllegalStateException(AbstractC0157z.k(i5, "Unknown button size: "));
        }
        Drawable drawableWrap = DrawableCompat.wrap(resources.getDrawable(iZab));
        DrawableCompat.setTintList(drawableWrap, resources.getColorStateList(com.google.android.gms.base.R.color.common_google_signin_btn_tint));
        DrawableCompat.setTintMode(drawableWrap, PorterDuff.Mode.SRC_ATOP);
        setBackgroundDrawable(drawableWrap);
        int i12 = com.google.android.gms.base.R.color.common_google_signin_btn_text_dark;
        int i13 = com.google.android.gms.base.R.color.common_google_signin_btn_text_light;
        setTextColor((ColorStateList) Preconditions.checkNotNull(resources.getColorStateList(zab(i6, i12, i13, i13))));
        if (i5 == 0) {
            setText(resources.getString(com.google.android.gms.base.R.string.common_signin_button_text));
        } else if (i5 == 1) {
            setText(resources.getString(com.google.android.gms.base.R.string.common_signin_button_text_long));
        } else {
            if (i5 != 2) {
                throw new IllegalStateException(AbstractC0157z.k(i5, "Unknown button size: "));
            }
            setText((CharSequence) null);
        }
        setTransformationMethod(null);
        if (DeviceProperties.isWearable(getContext())) {
            setGravity(19);
        }
    }
}
