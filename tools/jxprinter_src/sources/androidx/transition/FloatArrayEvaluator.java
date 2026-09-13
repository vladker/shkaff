package androidx.transition;

import A3.AbstractC0157z;
import android.animation.TypeEvaluator;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
class FloatArrayEvaluator implements TypeEvaluator<float[]> {
    private float[] mArray;

    public FloatArrayEvaluator(float[] fArr) {
        this.mArray = fArr;
    }

    @Override // android.animation.TypeEvaluator
    public float[] evaluate(float f6, float[] fArr, float[] fArr2) {
        float[] fArr3 = this.mArray;
        if (fArr3 == null) {
            fArr3 = new float[fArr.length];
        }
        for (int i5 = 0; i5 < fArr3.length; i5++) {
            float f7 = fArr[i5];
            fArr3[i5] = AbstractC0157z.a(fArr2[i5], f7, f6, f7);
        }
        return fArr3;
    }
}
