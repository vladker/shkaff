package com.google.android.material.internal;

import android.animation.TypeEvaluator;
import android.graphics.Rect;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class RectEvaluator implements TypeEvaluator<Rect> {
    private final Rect rect;

    public RectEvaluator(@NonNull Rect rect) {
        this.rect = rect;
    }

    @Override // android.animation.TypeEvaluator
    public Rect evaluate(float f6, @NonNull Rect rect, @NonNull Rect rect2) {
        int i5 = rect.left;
        int i6 = i5 + ((int) ((rect2.left - i5) * f6));
        int i7 = rect.top;
        int i8 = i7 + ((int) ((rect2.top - i7) * f6));
        int i9 = rect.right;
        int i10 = i9 + ((int) ((rect2.right - i9) * f6));
        int i11 = rect.bottom;
        this.rect.set(i6, i8, i10, i11 + ((int) ((rect2.bottom - i11) * f6)));
        return this.rect;
    }
}
