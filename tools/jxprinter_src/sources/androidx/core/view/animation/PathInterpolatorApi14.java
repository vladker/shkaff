package androidx.core.view.animation;

import A3.AbstractC0157z;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.view.animation.Interpolator;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
class PathInterpolatorApi14 implements Interpolator {
    private static final float PRECISION = 0.002f;
    private final float[] mX;
    private final float[] mY;

    public PathInterpolatorApi14(Path path) {
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float length = pathMeasure.getLength();
        int i5 = (int) (length / 0.002f);
        int i6 = i5 + 1;
        this.mX = new float[i6];
        this.mY = new float[i6];
        float[] fArr = new float[2];
        for (int i7 = 0; i7 < i6; i7++) {
            pathMeasure.getPosTan((i7 * length) / i5, fArr, null);
            this.mX[i7] = fArr[0];
            this.mY[i7] = fArr[1];
        }
    }

    private static Path createCubic(float f6, float f7, float f8, float f9) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.cubicTo(f6, f7, f8, f9, 1.0f, 1.0f);
        return path;
    }

    private static Path createQuad(float f6, float f7) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.quadTo(f6, f7, 1.0f, 1.0f);
        return path;
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f6) {
        if (f6 <= 0.0f) {
            return 0.0f;
        }
        if (f6 >= 1.0f) {
            return 1.0f;
        }
        int length = this.mX.length - 1;
        int i5 = 0;
        while (length - i5 > 1) {
            int i6 = (i5 + length) / 2;
            if (f6 < this.mX[i6]) {
                length = i6;
            } else {
                i5 = i6;
            }
        }
        float[] fArr = this.mX;
        float f7 = fArr[length];
        float f8 = fArr[i5];
        float f9 = f7 - f8;
        if (f9 == 0.0f) {
            return this.mY[i5];
        }
        float f10 = (f6 - f8) / f9;
        float[] fArr2 = this.mY;
        float f11 = fArr2[i5];
        return AbstractC0157z.a(fArr2[length], f11, f10, f11);
    }

    public PathInterpolatorApi14(float f6, float f7) {
        this(createQuad(f6, f7));
    }

    public PathInterpolatorApi14(float f6, float f7, float f8, float f9) {
        this(createCubic(f6, f7, f8, f9));
    }
}
