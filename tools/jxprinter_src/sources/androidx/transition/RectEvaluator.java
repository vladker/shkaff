package androidx.transition;

import android.animation.TypeEvaluator;
import android.graphics.Rect;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
class RectEvaluator implements TypeEvaluator<Rect> {
    private Rect mRect;

    public RectEvaluator() {
    }

    public RectEvaluator(Rect rect) {
        this.mRect = rect;
    }

    @Override // android.animation.TypeEvaluator
    public Rect evaluate(float f6, Rect rect, Rect rect2) {
        int i5 = rect.left;
        int i6 = i5 + ((int) ((rect2.left - i5) * f6));
        int i7 = rect.top;
        int i8 = i7 + ((int) ((rect2.top - i7) * f6));
        int i9 = rect.right;
        int i10 = i9 + ((int) ((rect2.right - i9) * f6));
        int i11 = rect.bottom;
        int i12 = i11 + ((int) ((rect2.bottom - i11) * f6));
        Rect rect3 = this.mRect;
        if (rect3 == null) {
            return new Rect(i6, i8, i10, i12);
        }
        rect3.set(i6, i8, i10, i12);
        return this.mRect;
    }
}
