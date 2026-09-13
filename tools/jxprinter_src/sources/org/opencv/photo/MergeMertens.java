package org.opencv.photo;

import java.util.List;
import org.opencv.core.Mat;
import org.opencv.utils.Converters;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class MergeMertens extends MergeExposures {
    public MergeMertens(long j6) {
        super(j6);
    }

    public static MergeMertens __fromPtr__(long j6) {
        return new MergeMertens(j6);
    }

    private static native void delete(long j6);

    private static native float getContrastWeight_0(long j6);

    private static native float getExposureWeight_0(long j6);

    private static native float getSaturationWeight_0(long j6);

    private static native void process_0(long j6, long j7, long j8, long j9, long j10);

    private static native void process_1(long j6, long j7, long j8);

    private static native void setContrastWeight_0(long j6, float f6);

    private static native void setExposureWeight_0(long j6, float f6);

    private static native void setSaturationWeight_0(long j6, float f6);

    @Override // org.opencv.photo.MergeExposures, org.opencv.core.Algorithm
    public void finalize() {
        delete(this.nativeObj);
    }

    public float getContrastWeight() {
        return getContrastWeight_0(this.nativeObj);
    }

    public float getExposureWeight() {
        return getExposureWeight_0(this.nativeObj);
    }

    public float getSaturationWeight() {
        return getSaturationWeight_0(this.nativeObj);
    }

    @Override // org.opencv.photo.MergeExposures
    public void process(List<Mat> list, Mat mat, Mat mat2, Mat mat3) {
        process_0(this.nativeObj, Converters.vector_Mat_to_Mat(list).nativeObj, mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }

    public void setContrastWeight(float f6) {
        setContrastWeight_0(this.nativeObj, f6);
    }

    public void setExposureWeight(float f6) {
        setExposureWeight_0(this.nativeObj, f6);
    }

    public void setSaturationWeight(float f6) {
        setSaturationWeight_0(this.nativeObj, f6);
    }

    public void process(List<Mat> list, Mat mat) {
        process_1(this.nativeObj, Converters.vector_Mat_to_Mat(list).nativeObj, mat.nativeObj);
    }
}
