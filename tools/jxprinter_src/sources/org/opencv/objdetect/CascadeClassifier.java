package org.opencv.objdetect;

import org.opencv.core.Mat;
import org.opencv.core.MatOfDouble;
import org.opencv.core.MatOfInt;
import org.opencv.core.MatOfRect;
import org.opencv.core.Size;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class CascadeClassifier {
    protected final long nativeObj;

    public CascadeClassifier(long j6) {
        this.nativeObj = j6;
    }

    private static native long CascadeClassifier_0();

    private static native long CascadeClassifier_1(String str);

    public static CascadeClassifier __fromPtr__(long j6) {
        return new CascadeClassifier(j6);
    }

    public static boolean convert(String str, String str2) {
        return convert_0(str, str2);
    }

    private static native boolean convert_0(String str, String str2);

    private static native void delete(long j6);

    private static native void detectMultiScale2_0(long j6, long j7, long j8, long j9, double d, int i5, int i6, double d6, double d7, double d8, double d9);

    private static native void detectMultiScale2_1(long j6, long j7, long j8, long j9, double d, int i5, int i6, double d6, double d7);

    private static native void detectMultiScale2_2(long j6, long j7, long j8, long j9, double d, int i5, int i6);

    private static native void detectMultiScale2_3(long j6, long j7, long j8, long j9, double d, int i5);

    private static native void detectMultiScale2_4(long j6, long j7, long j8, long j9, double d);

    private static native void detectMultiScale2_5(long j6, long j7, long j8, long j9);

    private static native void detectMultiScale3_0(long j6, long j7, long j8, long j9, long j10, double d, int i5, int i6, double d6, double d7, double d8, double d9, boolean z6);

    private static native void detectMultiScale3_1(long j6, long j7, long j8, long j9, long j10, double d, int i5, int i6, double d6, double d7, double d8, double d9);

    private static native void detectMultiScale3_2(long j6, long j7, long j8, long j9, long j10, double d, int i5, int i6, double d6, double d7);

    private static native void detectMultiScale3_3(long j6, long j7, long j8, long j9, long j10, double d, int i5, int i6);

    private static native void detectMultiScale3_4(long j6, long j7, long j8, long j9, long j10, double d, int i5);

    private static native void detectMultiScale3_5(long j6, long j7, long j8, long j9, long j10, double d);

    private static native void detectMultiScale3_6(long j6, long j7, long j8, long j9, long j10);

    private static native void detectMultiScale_0(long j6, long j7, long j8, double d, int i5, int i6, double d6, double d7, double d8, double d9);

    private static native void detectMultiScale_1(long j6, long j7, long j8, double d, int i5, int i6, double d6, double d7);

    private static native void detectMultiScale_2(long j6, long j7, long j8, double d, int i5, int i6);

    private static native void detectMultiScale_3(long j6, long j7, long j8, double d, int i5);

    private static native void detectMultiScale_4(long j6, long j7, long j8, double d);

    private static native void detectMultiScale_5(long j6, long j7, long j8);

    private static native boolean empty_0(long j6);

    private static native int getFeatureType_0(long j6);

    private static native double[] getOriginalWindowSize_0(long j6);

    private static native boolean isOldFormatCascade_0(long j6);

    private static native boolean load_0(long j6, String str);

    public void detectMultiScale(Mat mat, MatOfRect matOfRect, double d, int i5, int i6, Size size, Size size2) {
        detectMultiScale_0(this.nativeObj, mat.nativeObj, matOfRect.nativeObj, d, i5, i6, size.width, size.height, size2.width, size2.height);
    }

    public void detectMultiScale2(Mat mat, MatOfRect matOfRect, MatOfInt matOfInt, double d, int i5, int i6, Size size, Size size2) {
        detectMultiScale2_0(this.nativeObj, mat.nativeObj, matOfRect.nativeObj, matOfInt.nativeObj, d, i5, i6, size.width, size.height, size2.width, size2.height);
    }

    public void detectMultiScale3(Mat mat, MatOfRect matOfRect, MatOfInt matOfInt, MatOfDouble matOfDouble, double d, int i5, int i6, Size size, Size size2, boolean z6) {
        detectMultiScale3_0(this.nativeObj, mat.nativeObj, matOfRect.nativeObj, matOfInt.nativeObj, matOfDouble.nativeObj, d, i5, i6, size.width, size.height, size2.width, size2.height, z6);
    }

    public boolean empty() {
        return empty_0(this.nativeObj);
    }

    public void finalize() {
        delete(this.nativeObj);
    }

    public int getFeatureType() {
        return getFeatureType_0(this.nativeObj);
    }

    public long getNativeObjAddr() {
        return this.nativeObj;
    }

    public Size getOriginalWindowSize() {
        return new Size(getOriginalWindowSize_0(this.nativeObj));
    }

    public boolean isOldFormatCascade() {
        return isOldFormatCascade_0(this.nativeObj);
    }

    public boolean load(String str) {
        return load_0(this.nativeObj, str);
    }

    public CascadeClassifier() {
        this.nativeObj = CascadeClassifier_0();
    }

    public void detectMultiScale(Mat mat, MatOfRect matOfRect, double d, int i5, int i6, Size size) {
        detectMultiScale_1(this.nativeObj, mat.nativeObj, matOfRect.nativeObj, d, i5, i6, size.width, size.height);
    }

    public void detectMultiScale2(Mat mat, MatOfRect matOfRect, MatOfInt matOfInt, double d, int i5, int i6, Size size) {
        detectMultiScale2_1(this.nativeObj, mat.nativeObj, matOfRect.nativeObj, matOfInt.nativeObj, d, i5, i6, size.width, size.height);
    }

    public void detectMultiScale3(Mat mat, MatOfRect matOfRect, MatOfInt matOfInt, MatOfDouble matOfDouble, double d, int i5, int i6, Size size, Size size2) {
        detectMultiScale3_1(this.nativeObj, mat.nativeObj, matOfRect.nativeObj, matOfInt.nativeObj, matOfDouble.nativeObj, d, i5, i6, size.width, size.height, size2.width, size2.height);
    }

    public void detectMultiScale(Mat mat, MatOfRect matOfRect, double d, int i5, int i6) {
        detectMultiScale_2(this.nativeObj, mat.nativeObj, matOfRect.nativeObj, d, i5, i6);
    }

    public void detectMultiScale2(Mat mat, MatOfRect matOfRect, MatOfInt matOfInt, double d, int i5, int i6) {
        detectMultiScale2_2(this.nativeObj, mat.nativeObj, matOfRect.nativeObj, matOfInt.nativeObj, d, i5, i6);
    }

    public void detectMultiScale3(Mat mat, MatOfRect matOfRect, MatOfInt matOfInt, MatOfDouble matOfDouble, double d, int i5, int i6, Size size) {
        detectMultiScale3_2(this.nativeObj, mat.nativeObj, matOfRect.nativeObj, matOfInt.nativeObj, matOfDouble.nativeObj, d, i5, i6, size.width, size.height);
    }

    public CascadeClassifier(String str) {
        this.nativeObj = CascadeClassifier_1(str);
    }

    public void detectMultiScale(Mat mat, MatOfRect matOfRect, double d, int i5) {
        detectMultiScale_3(this.nativeObj, mat.nativeObj, matOfRect.nativeObj, d, i5);
    }

    public void detectMultiScale2(Mat mat, MatOfRect matOfRect, MatOfInt matOfInt, double d, int i5) {
        detectMultiScale2_3(this.nativeObj, mat.nativeObj, matOfRect.nativeObj, matOfInt.nativeObj, d, i5);
    }

    public void detectMultiScale3(Mat mat, MatOfRect matOfRect, MatOfInt matOfInt, MatOfDouble matOfDouble, double d, int i5, int i6) {
        detectMultiScale3_3(this.nativeObj, mat.nativeObj, matOfRect.nativeObj, matOfInt.nativeObj, matOfDouble.nativeObj, d, i5, i6);
    }

    public void detectMultiScale(Mat mat, MatOfRect matOfRect, double d) {
        detectMultiScale_4(this.nativeObj, mat.nativeObj, matOfRect.nativeObj, d);
    }

    public void detectMultiScale2(Mat mat, MatOfRect matOfRect, MatOfInt matOfInt, double d) {
        detectMultiScale2_4(this.nativeObj, mat.nativeObj, matOfRect.nativeObj, matOfInt.nativeObj, d);
    }

    public void detectMultiScale3(Mat mat, MatOfRect matOfRect, MatOfInt matOfInt, MatOfDouble matOfDouble, double d, int i5) {
        detectMultiScale3_4(this.nativeObj, mat.nativeObj, matOfRect.nativeObj, matOfInt.nativeObj, matOfDouble.nativeObj, d, i5);
    }

    public void detectMultiScale(Mat mat, MatOfRect matOfRect) {
        detectMultiScale_5(this.nativeObj, mat.nativeObj, matOfRect.nativeObj);
    }

    public void detectMultiScale2(Mat mat, MatOfRect matOfRect, MatOfInt matOfInt) {
        detectMultiScale2_5(this.nativeObj, mat.nativeObj, matOfRect.nativeObj, matOfInt.nativeObj);
    }

    public void detectMultiScale3(Mat mat, MatOfRect matOfRect, MatOfInt matOfInt, MatOfDouble matOfDouble, double d) {
        detectMultiScale3_5(this.nativeObj, mat.nativeObj, matOfRect.nativeObj, matOfInt.nativeObj, matOfDouble.nativeObj, d);
    }

    public void detectMultiScale3(Mat mat, MatOfRect matOfRect, MatOfInt matOfInt, MatOfDouble matOfDouble) {
        detectMultiScale3_6(this.nativeObj, mat.nativeObj, matOfRect.nativeObj, matOfInt.nativeObj, matOfDouble.nativeObj);
    }
}
