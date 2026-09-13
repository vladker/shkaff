package org.opencv.objdetect;

import org.opencv.core.Mat;
import org.opencv.core.MatOfPoint3f;
import org.opencv.core.Size;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class CharucoBoard extends Board {
    public CharucoBoard(long j6) {
        super(j6);
    }

    private static native long CharucoBoard_0(double d, double d6, float f6, float f7, long j6, long j7);

    private static native long CharucoBoard_1(double d, double d6, float f6, float f7, long j6);

    public static CharucoBoard __fromPtr__(long j6) {
        return new CharucoBoard(j6);
    }

    private static native boolean checkCharucoCornersCollinear_0(long j6, long j7);

    private static native void delete(long j6);

    private static native long getChessboardCorners_0(long j6);

    private static native double[] getChessboardSize_0(long j6);

    private static native boolean getLegacyPattern_0(long j6);

    private static native float getMarkerLength_0(long j6);

    private static native float getSquareLength_0(long j6);

    private static native void setLegacyPattern_0(long j6, boolean z6);

    public boolean checkCharucoCornersCollinear(Mat mat) {
        return checkCharucoCornersCollinear_0(this.nativeObj, mat.nativeObj);
    }

    @Override // org.opencv.objdetect.Board
    public void finalize() {
        delete(this.nativeObj);
    }

    public MatOfPoint3f getChessboardCorners() {
        return MatOfPoint3f.fromNativeAddr(getChessboardCorners_0(this.nativeObj));
    }

    public Size getChessboardSize() {
        return new Size(getChessboardSize_0(this.nativeObj));
    }

    public boolean getLegacyPattern() {
        return getLegacyPattern_0(this.nativeObj);
    }

    public float getMarkerLength() {
        return getMarkerLength_0(this.nativeObj);
    }

    public float getSquareLength() {
        return getSquareLength_0(this.nativeObj);
    }

    public void setLegacyPattern(boolean z6) {
        setLegacyPattern_0(this.nativeObj, z6);
    }

    public CharucoBoard(Size size, float f6, float f7, Dictionary dictionary, Mat mat) {
        super(CharucoBoard_0(size.width, size.height, f6, f7, dictionary.nativeObj, mat.nativeObj));
    }

    public CharucoBoard(Size size, float f6, float f7, Dictionary dictionary) {
        super(CharucoBoard_1(size.width, size.height, f6, f7, dictionary.nativeObj));
    }
}
