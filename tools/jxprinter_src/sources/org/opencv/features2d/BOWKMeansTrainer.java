package org.opencv.features2d;

import org.opencv.core.Mat;
import org.opencv.core.TermCriteria;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class BOWKMeansTrainer extends BOWTrainer {
    public BOWKMeansTrainer(long j6) {
        super(j6);
    }

    private static native long BOWKMeansTrainer_0(int i5, int i6, int i7, double d, int i8, int i9);

    private static native long BOWKMeansTrainer_1(int i5, int i6, int i7, double d, int i8);

    private static native long BOWKMeansTrainer_2(int i5, int i6, int i7, double d);

    private static native long BOWKMeansTrainer_3(int i5);

    public static BOWKMeansTrainer __fromPtr__(long j6) {
        return new BOWKMeansTrainer(j6);
    }

    private static native long cluster_0(long j6);

    private static native long cluster_1(long j6, long j7);

    private static native void delete(long j6);

    @Override // org.opencv.features2d.BOWTrainer
    public Mat cluster() {
        return new Mat(cluster_0(this.nativeObj));
    }

    @Override // org.opencv.features2d.BOWTrainer
    public void finalize() {
        delete(this.nativeObj);
    }

    public BOWKMeansTrainer(int i5, TermCriteria termCriteria, int i6, int i7) {
        super(BOWKMeansTrainer_0(i5, termCriteria.type, termCriteria.maxCount, termCriteria.epsilon, i6, i7));
    }

    @Override // org.opencv.features2d.BOWTrainer
    public Mat cluster(Mat mat) {
        return new Mat(cluster_1(this.nativeObj, mat.nativeObj));
    }

    public BOWKMeansTrainer(int i5, TermCriteria termCriteria, int i6) {
        super(BOWKMeansTrainer_1(i5, termCriteria.type, termCriteria.maxCount, termCriteria.epsilon, i6));
    }

    public BOWKMeansTrainer(int i5, TermCriteria termCriteria) {
        super(BOWKMeansTrainer_2(i5, termCriteria.type, termCriteria.maxCount, termCriteria.epsilon));
    }

    public BOWKMeansTrainer(int i5) {
        super(BOWKMeansTrainer_3(i5));
    }
}
