package org.opencv.ml;

import org.opencv.core.Mat;
import org.opencv.core.TermCriteria;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class SVMSGD extends StatModel {
    public static final int ASGD = 1;
    public static final int HARD_MARGIN = 1;
    public static final int SGD = 0;
    public static final int SOFT_MARGIN = 0;

    public SVMSGD(long j6) {
        super(j6);
    }

    public static SVMSGD __fromPtr__(long j6) {
        return new SVMSGD(j6);
    }

    public static SVMSGD create() {
        return __fromPtr__(create_0());
    }

    private static native long create_0();

    private static native void delete(long j6);

    private static native float getInitialStepSize_0(long j6);

    private static native float getMarginRegularization_0(long j6);

    private static native int getMarginType_0(long j6);

    private static native float getShift_0(long j6);

    private static native float getStepDecreasingPower_0(long j6);

    private static native int getSvmsgdType_0(long j6);

    private static native double[] getTermCriteria_0(long j6);

    private static native long getWeights_0(long j6);

    public static SVMSGD load(String str, String str2) {
        return __fromPtr__(load_0(str, str2));
    }

    private static native long load_0(String str, String str2);

    private static native long load_1(String str);

    private static native void setInitialStepSize_0(long j6, float f6);

    private static native void setMarginRegularization_0(long j6, float f6);

    private static native void setMarginType_0(long j6, int i5);

    private static native void setOptimalParameters_0(long j6, int i5, int i6);

    private static native void setOptimalParameters_1(long j6, int i5);

    private static native void setOptimalParameters_2(long j6);

    private static native void setStepDecreasingPower_0(long j6, float f6);

    private static native void setSvmsgdType_0(long j6, int i5);

    private static native void setTermCriteria_0(long j6, int i5, int i6, double d);

    @Override // org.opencv.ml.StatModel, org.opencv.core.Algorithm
    public void finalize() {
        delete(this.nativeObj);
    }

    public float getInitialStepSize() {
        return getInitialStepSize_0(this.nativeObj);
    }

    public float getMarginRegularization() {
        return getMarginRegularization_0(this.nativeObj);
    }

    public int getMarginType() {
        return getMarginType_0(this.nativeObj);
    }

    public float getShift() {
        return getShift_0(this.nativeObj);
    }

    public float getStepDecreasingPower() {
        return getStepDecreasingPower_0(this.nativeObj);
    }

    public int getSvmsgdType() {
        return getSvmsgdType_0(this.nativeObj);
    }

    public TermCriteria getTermCriteria() {
        return new TermCriteria(getTermCriteria_0(this.nativeObj));
    }

    public Mat getWeights() {
        return new Mat(getWeights_0(this.nativeObj));
    }

    public void setInitialStepSize(float f6) {
        setInitialStepSize_0(this.nativeObj, f6);
    }

    public void setMarginRegularization(float f6) {
        setMarginRegularization_0(this.nativeObj, f6);
    }

    public void setMarginType(int i5) {
        setMarginType_0(this.nativeObj, i5);
    }

    public void setOptimalParameters(int i5, int i6) {
        setOptimalParameters_0(this.nativeObj, i5, i6);
    }

    public void setStepDecreasingPower(float f6) {
        setStepDecreasingPower_0(this.nativeObj, f6);
    }

    public void setSvmsgdType(int i5) {
        setSvmsgdType_0(this.nativeObj, i5);
    }

    public void setTermCriteria(TermCriteria termCriteria) {
        setTermCriteria_0(this.nativeObj, termCriteria.type, termCriteria.maxCount, termCriteria.epsilon);
    }

    public static SVMSGD load(String str) {
        return __fromPtr__(load_1(str));
    }

    public void setOptimalParameters(int i5) {
        setOptimalParameters_1(this.nativeObj, i5);
    }

    public void setOptimalParameters() {
        setOptimalParameters_2(this.nativeObj);
    }
}
