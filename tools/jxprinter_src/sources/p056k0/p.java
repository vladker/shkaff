package p056k0;

import java.util.concurrent.CountDownLatch;
import org.opencv.core.Mat;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class p implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f5471a;
    public Mat b;
    public Mat c;
    public CountDownLatch d;

    @Override // java.lang.Runnable
    public final void run() {
        int i5 = this.f5471a;
        Mat mat = this.b;
        int i6 = 0;
        while (i6 < mat.cols()) {
            double d = mat.get(i5, i6)[0];
            double d6 = d >= ((double) 128.0f) ? 255.0d : 0.0d;
            double d7 = d - d6;
            this.c.put(i5, i6, d6);
            int i7 = i6 + 1;
            if (i7 < mat.cols()) {
                double[] dArr = mat.get(i5, i7);
                dArr[0] = ((7.0d * d7) / 16.0d) + dArr[0];
                mat.put(i5, i7, dArr);
            }
            int i8 = i5 + 1;
            if (i8 < mat.rows()) {
                int i9 = i6 - 1;
                if (i9 >= 0) {
                    double[] dArr2 = mat.get(i8, i9);
                    dArr2[0] = ((3.0d * d7) / 16.0d) + dArr2[0];
                    mat.put(i8, i9, dArr2);
                }
                double[] dArr3 = mat.get(i8, i6);
                dArr3[0] = ((5.0d * d7) / 16.0d) + dArr3[0];
                mat.put(i8, i6, dArr3);
                if (i7 < mat.cols()) {
                    double[] dArr4 = mat.get(i8, i7);
                    dArr4[0] = ((d7 * 1.0d) / 16.0d) + dArr4[0];
                    mat.put(i8, i7, dArr4);
                }
            }
            i6 = i7;
        }
        this.d.countDown();
    }
}
