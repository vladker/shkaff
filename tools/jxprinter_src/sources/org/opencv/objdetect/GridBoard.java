package org.opencv.objdetect;

import org.opencv.core.Mat;
import org.opencv.core.Size;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class GridBoard extends Board {
    public GridBoard(long j6) {
        super(j6);
    }

    private static native long GridBoard_0(double d, double d6, float f6, float f7, long j6, long j7);

    private static native long GridBoard_1(double d, double d6, float f6, float f7, long j6);

    public static GridBoard __fromPtr__(long j6) {
        return new GridBoard(j6);
    }

    private static native void delete(long j6);

    private static native double[] getGridSize_0(long j6);

    private static native float getMarkerLength_0(long j6);

    private static native float getMarkerSeparation_0(long j6);

    @Override // org.opencv.objdetect.Board
    public void finalize() {
        delete(this.nativeObj);
    }

    public Size getGridSize() {
        return new Size(getGridSize_0(this.nativeObj));
    }

    public float getMarkerLength() {
        return getMarkerLength_0(this.nativeObj);
    }

    public float getMarkerSeparation() {
        return getMarkerSeparation_0(this.nativeObj);
    }

    public GridBoard(Size size, float f6, float f7, Dictionary dictionary, Mat mat) {
        super(GridBoard_0(size.width, size.height, f6, f7, dictionary.nativeObj, mat.nativeObj));
    }

    public GridBoard(Size size, float f6, float f7, Dictionary dictionary) {
        super(GridBoard_1(size.width, size.height, f6, f7, dictionary.nativeObj));
    }
}
