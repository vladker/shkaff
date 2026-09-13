package androidx.core.graphics;

import android.graphics.Matrix;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class MatrixKt {
    public static final Matrix rotationMatrix(float f6, float f7, float f8) {
        Matrix matrix = new Matrix();
        matrix.setRotate(f6, f7, f8);
        return matrix;
    }

    public static /* synthetic */ Matrix rotationMatrix$default(float f6, float f7, float f8, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            f7 = 0.0f;
        }
        if ((i5 & 4) != 0) {
            f8 = 0.0f;
        }
        return rotationMatrix(f6, f7, f8);
    }

    public static final Matrix scaleMatrix(float f6, float f7) {
        Matrix matrix = new Matrix();
        matrix.setScale(f6, f7);
        return matrix;
    }

    public static /* synthetic */ Matrix scaleMatrix$default(float f6, float f7, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            f6 = 1.0f;
        }
        if ((i5 & 2) != 0) {
            f7 = 1.0f;
        }
        return scaleMatrix(f6, f7);
    }

    public static final Matrix times(Matrix matrix, Matrix matrix2) {
        Matrix matrix3 = new Matrix(matrix);
        matrix3.preConcat(matrix2);
        return matrix3;
    }

    public static final Matrix translationMatrix(float f6, float f7) {
        Matrix matrix = new Matrix();
        matrix.setTranslate(f6, f7);
        return matrix;
    }

    public static /* synthetic */ Matrix translationMatrix$default(float f6, float f7, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            f6 = 0.0f;
        }
        if ((i5 & 2) != 0) {
            f7 = 0.0f;
        }
        return translationMatrix(f6, f7);
    }

    public static final float[] values(Matrix matrix) {
        float[] fArr = new float[9];
        matrix.getValues(fArr);
        return fArr;
    }
}
