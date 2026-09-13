package org.opencv.ml;

import org.opencv.core.Mat;
import org.opencv.core.TermCriteria;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class RTrees extends DTrees {
    public RTrees(long j6) {
        super(j6);
    }

    public static RTrees __fromPtr__(long j6) {
        return new RTrees(j6);
    }

    public static RTrees create() {
        return __fromPtr__(create_0());
    }

    private static native long create_0();

    private static native void delete(long j6);

    private static native int getActiveVarCount_0(long j6);

    private static native boolean getCalculateVarImportance_0(long j6);

    private static native double getOOBError_0(long j6);

    private static native double[] getTermCriteria_0(long j6);

    private static native long getVarImportance_0(long j6);

    private static native void getVotes_0(long j6, long j7, long j8, int i5);

    public static RTrees load(String str, String str2) {
        return __fromPtr__(load_0(str, str2));
    }

    private static native long load_0(String str, String str2);

    private static native long load_1(String str);

    private static native void setActiveVarCount_0(long j6, int i5);

    private static native void setCalculateVarImportance_0(long j6, boolean z6);

    private static native void setTermCriteria_0(long j6, int i5, int i6, double d);

    @Override // org.opencv.ml.DTrees, org.opencv.ml.StatModel, org.opencv.core.Algorithm
    public void finalize() {
        delete(this.nativeObj);
    }

    public int getActiveVarCount() {
        return getActiveVarCount_0(this.nativeObj);
    }

    public boolean getCalculateVarImportance() {
        return getCalculateVarImportance_0(this.nativeObj);
    }

    public double getOOBError() {
        return getOOBError_0(this.nativeObj);
    }

    public TermCriteria getTermCriteria() {
        return new TermCriteria(getTermCriteria_0(this.nativeObj));
    }

    public Mat getVarImportance() {
        return new Mat(getVarImportance_0(this.nativeObj));
    }

    public void getVotes(Mat mat, Mat mat2, int i5) {
        getVotes_0(this.nativeObj, mat.nativeObj, mat2.nativeObj, i5);
    }

    public void setActiveVarCount(int i5) {
        setActiveVarCount_0(this.nativeObj, i5);
    }

    public void setCalculateVarImportance(boolean z6) {
        setCalculateVarImportance_0(this.nativeObj, z6);
    }

    public void setTermCriteria(TermCriteria termCriteria) {
        setTermCriteria_0(this.nativeObj, termCriteria.type, termCriteria.maxCount, termCriteria.epsilon);
    }

    public static RTrees load(String str) {
        return __fromPtr__(load_1(str));
    }
}
