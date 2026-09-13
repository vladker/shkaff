package org.opencv.dnn;

import java.util.ArrayList;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractC1125a;
import org.opencv.core.Algorithm;
import org.opencv.core.Mat;
import org.opencv.utils.Converters;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class Layer extends Algorithm {
    public Layer(long j6) {
        super(j6);
    }

    public static Layer __fromPtr__(long j6) {
        return new Layer(j6);
    }

    private static native void delete(long j6);

    private static native void finalize_0(long j6, long j7, long j8);

    private static native long get_blobs_0(long j6);

    private static native String get_name_0(long j6);

    private static native int get_preferableTarget_0(long j6);

    private static native String get_type_0(long j6);

    private static native int outputNameToIndex_0(long j6, String str);

    private static native void run_0(long j6, long j7, long j8, long j9);

    private static native void set_blobs_0(long j6, long j7);

    public void finalize(List<Mat> list, List<Mat> list2) {
        Mat matVector_Mat_to_Mat = Converters.vector_Mat_to_Mat(list);
        Mat mat = new Mat();
        finalize_0(this.nativeObj, matVector_Mat_to_Mat.nativeObj, mat.nativeObj);
        Converters.Mat_to_vector_Mat(mat, list2);
        mat.release();
    }

    public List<Mat> get_blobs() {
        ArrayList arrayList = new ArrayList();
        Converters.Mat_to_vector_Mat(new Mat(get_blobs_0(this.nativeObj)), arrayList);
        return arrayList;
    }

    public String get_name() {
        return get_name_0(this.nativeObj);
    }

    public int get_preferableTarget() {
        return get_preferableTarget_0(this.nativeObj);
    }

    public String get_type() {
        return get_type_0(this.nativeObj);
    }

    public int outputNameToIndex(String str) {
        return outputNameToIndex_0(this.nativeObj, str);
    }

    @Deprecated
    public void run(List<Mat> list, List<Mat> list2, List<Mat> list3) {
        Mat matVector_Mat_to_Mat = Converters.vector_Mat_to_Mat(list);
        Mat mat = new Mat();
        Mat matVector_Mat_to_Mat2 = Converters.vector_Mat_to_Mat(list3);
        run_0(this.nativeObj, matVector_Mat_to_Mat.nativeObj, mat.nativeObj, matVector_Mat_to_Mat2.nativeObj);
        AbstractC1125a.p(mat, list2, matVector_Mat_to_Mat2, list3);
    }

    public void set_blobs(List<Mat> list) {
        set_blobs_0(this.nativeObj, Converters.vector_Mat_to_Mat(list).nativeObj);
    }

    @Override // org.opencv.core.Algorithm
    public void finalize() {
        delete(this.nativeObj);
    }
}
