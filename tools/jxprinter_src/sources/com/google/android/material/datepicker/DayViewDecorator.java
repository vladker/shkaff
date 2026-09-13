package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class DayViewDecorator implements Parcelable {
    @Nullable
    public ColorStateList getBackgroundColor(@NonNull Context context, int i5, int i6, int i7, boolean z6, boolean z7) {
        return null;
    }

    @Nullable
    public Drawable getCompoundDrawableBottom(@NonNull Context context, int i5, int i6, int i7, boolean z6, boolean z7) {
        return null;
    }

    @Nullable
    public Drawable getCompoundDrawableLeft(@NonNull Context context, int i5, int i6, int i7, boolean z6, boolean z7) {
        return null;
    }

    @Nullable
    public Drawable getCompoundDrawableRight(@NonNull Context context, int i5, int i6, int i7, boolean z6, boolean z7) {
        return null;
    }

    @Nullable
    public Drawable getCompoundDrawableTop(@NonNull Context context, int i5, int i6, int i7, boolean z6, boolean z7) {
        return null;
    }

    @Nullable
    public ColorStateList getTextColor(@NonNull Context context, int i5, int i6, int i7, boolean z6, boolean z7) {
        return null;
    }

    public void initialize(@NonNull Context context) {
    }

    @Nullable
    public CharSequence getContentDescription(@NonNull Context context, int i5, int i6, int i7, boolean z6, boolean z7, @Nullable CharSequence charSequence) {
        return charSequence;
    }
}
