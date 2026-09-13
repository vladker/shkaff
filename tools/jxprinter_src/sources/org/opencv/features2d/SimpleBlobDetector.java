package org.opencv.features2d;

import java.util.ArrayList;
import java.util.List;
import org.opencv.core.Mat;
import org.opencv.core.MatOfPoint;
import org.opencv.utils.Converters;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class SimpleBlobDetector extends Feature2D {
    public SimpleBlobDetector(long j6) {
        super(j6);
    }

    public static SimpleBlobDetector __fromPtr__(long j6) {
        return new SimpleBlobDetector(j6);
    }

    public static SimpleBlobDetector create(SimpleBlobDetector_Params simpleBlobDetector_Params) {
        return __fromPtr__(create_0(simpleBlobDetector_Params.nativeObj));
    }

    private static native long create_0(long j6);

    private static native long create_1();

    private static native void delete(long j6);

    private static native long getBlobContours_0(long j6);

    private static native String getDefaultName_0(long j6);

    private static native long getParams_0(long j6);

    private static native void setParams_0(long j6, long j7);

    @Override // org.opencv.features2d.Feature2D, org.opencv.core.Algorithm
    public void finalize() {
        delete(this.nativeObj);
    }

    public List<MatOfPoint> getBlobContours() {
        ArrayList arrayList = new ArrayList();
        Converters.Mat_to_vector_vector_Point(new Mat(getBlobContours_0(this.nativeObj)), arrayList);
        return arrayList;
    }

    @Override // org.opencv.features2d.Feature2D, org.opencv.core.Algorithm
    public String getDefaultName() {
        return getDefaultName_0(this.nativeObj);
    }

    public SimpleBlobDetector_Params getParams() {
        return new SimpleBlobDetector_Params(getParams_0(this.nativeObj));
    }

    public void setParams(SimpleBlobDetector_Params simpleBlobDetector_Params) {
        setParams_0(this.nativeObj, simpleBlobDetector_Params.nativeObj);
    }

    public static SimpleBlobDetector create() {
        return __fromPtr__(create_1());
    }
}
