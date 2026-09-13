package org.opencv.ml;

import java.util.List;
import org.opencv.core.Mat;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class TrainData {
    protected final long nativeObj;

    public TrainData(long j6) {
        this.nativeObj = j6;
    }

    public static TrainData __fromPtr__(long j6) {
        return new TrainData(j6);
    }

    public static TrainData create(Mat mat, int i5, Mat mat2, Mat mat3, Mat mat4, Mat mat5, Mat mat6) {
        return __fromPtr__(create_0(mat.nativeObj, i5, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, mat5.nativeObj, mat6.nativeObj));
    }

    private static native long create_0(long j6, int i5, long j7, long j8, long j9, long j10, long j11);

    private static native long create_1(long j6, int i5, long j7, long j8, long j9, long j10);

    private static native long create_2(long j6, int i5, long j7, long j8, long j9);

    private static native long create_3(long j6, int i5, long j7, long j8);

    private static native long create_4(long j6, int i5, long j7);

    private static native void delete(long j6);

    private static native int getCatCount_0(long j6, int i5);

    private static native long getCatMap_0(long j6);

    private static native long getCatOfs_0(long j6);

    private static native long getClassLabels_0(long j6);

    private static native long getDefaultSubstValues_0(long j6);

    private static native int getLayout_0(long j6);

    private static native long getMissing_0(long j6);

    private static native int getNAllVars_0(long j6);

    private static native int getNSamples_0(long j6);

    private static native int getNTestSamples_0(long j6);

    private static native int getNTrainSamples_0(long j6);

    private static native int getNVars_0(long j6);

    private static native void getNames_0(long j6, List<String> list);

    private static native long getNormCatResponses_0(long j6);

    private static native int getResponseType_0(long j6);

    private static native long getResponses_0(long j6);

    private static native long getSampleWeights_0(long j6);

    private static native void getSample_0(long j6, long j7, int i5, float f6);

    private static native long getSamples_0(long j6);

    public static Mat getSubMatrix(Mat mat, Mat mat2, int i5) {
        return new Mat(getSubMatrix_0(mat.nativeObj, mat2.nativeObj, i5));
    }

    private static native long getSubMatrix_0(long j6, long j7, int i5);

    public static Mat getSubVector(Mat mat, Mat mat2) {
        return new Mat(getSubVector_0(mat.nativeObj, mat2.nativeObj));
    }

    private static native long getSubVector_0(long j6, long j7);

    private static native long getTestNormCatResponses_0(long j6);

    private static native long getTestResponses_0(long j6);

    private static native long getTestSampleIdx_0(long j6);

    private static native long getTestSampleWeights_0(long j6);

    private static native long getTestSamples_0(long j6);

    private static native long getTrainNormCatResponses_0(long j6);

    private static native long getTrainResponses_0(long j6);

    private static native long getTrainSampleIdx_0(long j6);

    private static native long getTrainSampleWeights_0(long j6);

    private static native long getTrainSamples_0(long j6, int i5, boolean z6, boolean z7);

    private static native long getTrainSamples_1(long j6, int i5, boolean z6);

    private static native long getTrainSamples_2(long j6, int i5);

    private static native long getTrainSamples_3(long j6);

    private static native void getValues_0(long j6, int i5, long j7, float f6);

    private static native long getVarIdx_0(long j6);

    private static native long getVarSymbolFlags_0(long j6);

    private static native long getVarType_0(long j6);

    private static native void setTrainTestSplitRatio_0(long j6, double d, boolean z6);

    private static native void setTrainTestSplitRatio_1(long j6, double d);

    private static native void setTrainTestSplit_0(long j6, int i5, boolean z6);

    private static native void setTrainTestSplit_1(long j6, int i5);

    private static native void shuffleTrainTest_0(long j6);

    public void finalize() {
        delete(this.nativeObj);
    }

    public int getCatCount(int i5) {
        return getCatCount_0(this.nativeObj, i5);
    }

    public Mat getCatMap() {
        return new Mat(getCatMap_0(this.nativeObj));
    }

    public Mat getCatOfs() {
        return new Mat(getCatOfs_0(this.nativeObj));
    }

    public Mat getClassLabels() {
        return new Mat(getClassLabels_0(this.nativeObj));
    }

    public Mat getDefaultSubstValues() {
        return new Mat(getDefaultSubstValues_0(this.nativeObj));
    }

    public int getLayout() {
        return getLayout_0(this.nativeObj);
    }

    public Mat getMissing() {
        return new Mat(getMissing_0(this.nativeObj));
    }

    public int getNAllVars() {
        return getNAllVars_0(this.nativeObj);
    }

    public int getNSamples() {
        return getNSamples_0(this.nativeObj);
    }

    public int getNTestSamples() {
        return getNTestSamples_0(this.nativeObj);
    }

    public int getNTrainSamples() {
        return getNTrainSamples_0(this.nativeObj);
    }

    public int getNVars() {
        return getNVars_0(this.nativeObj);
    }

    public void getNames(List<String> list) {
        getNames_0(this.nativeObj, list);
    }

    public long getNativeObjAddr() {
        return this.nativeObj;
    }

    public Mat getNormCatResponses() {
        return new Mat(getNormCatResponses_0(this.nativeObj));
    }

    public int getResponseType() {
        return getResponseType_0(this.nativeObj);
    }

    public Mat getResponses() {
        return new Mat(getResponses_0(this.nativeObj));
    }

    public void getSample(Mat mat, int i5, float f6) {
        getSample_0(this.nativeObj, mat.nativeObj, i5, f6);
    }

    public Mat getSampleWeights() {
        return new Mat(getSampleWeights_0(this.nativeObj));
    }

    public Mat getSamples() {
        return new Mat(getSamples_0(this.nativeObj));
    }

    public Mat getTestNormCatResponses() {
        return new Mat(getTestNormCatResponses_0(this.nativeObj));
    }

    public Mat getTestResponses() {
        return new Mat(getTestResponses_0(this.nativeObj));
    }

    public Mat getTestSampleIdx() {
        return new Mat(getTestSampleIdx_0(this.nativeObj));
    }

    public Mat getTestSampleWeights() {
        return new Mat(getTestSampleWeights_0(this.nativeObj));
    }

    public Mat getTestSamples() {
        return new Mat(getTestSamples_0(this.nativeObj));
    }

    public Mat getTrainNormCatResponses() {
        return new Mat(getTrainNormCatResponses_0(this.nativeObj));
    }

    public Mat getTrainResponses() {
        return new Mat(getTrainResponses_0(this.nativeObj));
    }

    public Mat getTrainSampleIdx() {
        return new Mat(getTrainSampleIdx_0(this.nativeObj));
    }

    public Mat getTrainSampleWeights() {
        return new Mat(getTrainSampleWeights_0(this.nativeObj));
    }

    public Mat getTrainSamples(int i5, boolean z6, boolean z7) {
        return new Mat(getTrainSamples_0(this.nativeObj, i5, z6, z7));
    }

    public void getValues(int i5, Mat mat, float f6) {
        getValues_0(this.nativeObj, i5, mat.nativeObj, f6);
    }

    public Mat getVarIdx() {
        return new Mat(getVarIdx_0(this.nativeObj));
    }

    public Mat getVarSymbolFlags() {
        return new Mat(getVarSymbolFlags_0(this.nativeObj));
    }

    public Mat getVarType() {
        return new Mat(getVarType_0(this.nativeObj));
    }

    public void setTrainTestSplit(int i5, boolean z6) {
        setTrainTestSplit_0(this.nativeObj, i5, z6);
    }

    public void setTrainTestSplitRatio(double d, boolean z6) {
        setTrainTestSplitRatio_0(this.nativeObj, d, z6);
    }

    public void shuffleTrainTest() {
        shuffleTrainTest_0(this.nativeObj);
    }

    public static TrainData create(Mat mat, int i5, Mat mat2, Mat mat3, Mat mat4, Mat mat5) {
        return __fromPtr__(create_1(mat.nativeObj, i5, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, mat5.nativeObj));
    }

    public Mat getTrainSamples(int i5, boolean z6) {
        return new Mat(getTrainSamples_1(this.nativeObj, i5, z6));
    }

    public void setTrainTestSplit(int i5) {
        setTrainTestSplit_1(this.nativeObj, i5);
    }

    public void setTrainTestSplitRatio(double d) {
        setTrainTestSplitRatio_1(this.nativeObj, d);
    }

    public static TrainData create(Mat mat, int i5, Mat mat2, Mat mat3, Mat mat4) {
        return __fromPtr__(create_2(mat.nativeObj, i5, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj));
    }

    public Mat getTrainSamples(int i5) {
        return new Mat(getTrainSamples_2(this.nativeObj, i5));
    }

    public static TrainData create(Mat mat, int i5, Mat mat2, Mat mat3) {
        return __fromPtr__(create_3(mat.nativeObj, i5, mat2.nativeObj, mat3.nativeObj));
    }

    public Mat getTrainSamples() {
        return new Mat(getTrainSamples_3(this.nativeObj));
    }

    public static TrainData create(Mat mat, int i5, Mat mat2) {
        return __fromPtr__(create_4(mat.nativeObj, i5, mat2.nativeObj));
    }
}
