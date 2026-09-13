package org.opencv.dnn;

import org.opencv.core.Mat;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class ClassificationModel extends Model {
    public ClassificationModel(long j6) {
        super(j6);
    }

    private static native long ClassificationModel_0(String str, String str2);

    private static native long ClassificationModel_1(String str);

    private static native long ClassificationModel_2(long j6);

    public static ClassificationModel __fromPtr__(long j6) {
        return new ClassificationModel(j6);
    }

    private static native void classify_0(long j6, long j7, double[] dArr, double[] dArr2);

    private static native void delete(long j6);

    private static native boolean getEnableSoftmaxPostProcessing_0(long j6);

    private static native long setEnableSoftmaxPostProcessing_0(long j6, boolean z6);

    public void classify(Mat mat, int[] iArr, float[] fArr) {
        double[] dArr = new double[1];
        double[] dArr2 = new double[1];
        classify_0(this.nativeObj, mat.nativeObj, dArr, dArr2);
        if (iArr != null) {
            iArr[0] = (int) dArr[0];
        }
        if (fArr != null) {
            fArr[0] = (float) dArr2[0];
        }
    }

    @Override // org.opencv.dnn.Model
    public void finalize() {
        delete(this.nativeObj);
    }

    public boolean getEnableSoftmaxPostProcessing() {
        return getEnableSoftmaxPostProcessing_0(this.nativeObj);
    }

    public ClassificationModel setEnableSoftmaxPostProcessing(boolean z6) {
        return new ClassificationModel(setEnableSoftmaxPostProcessing_0(this.nativeObj, z6));
    }

    public ClassificationModel(String str, String str2) {
        super(ClassificationModel_0(str, str2));
    }

    public ClassificationModel(String str) {
        super(ClassificationModel_1(str));
    }

    public ClassificationModel(Net net) {
        super(ClassificationModel_2(net.nativeObj));
    }
}
