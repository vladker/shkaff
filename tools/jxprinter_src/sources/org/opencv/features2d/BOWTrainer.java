package org.opencv.features2d;

import java.util.ArrayList;
import java.util.List;
import org.opencv.core.Mat;
import org.opencv.utils.Converters;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class BOWTrainer {
    protected final long nativeObj;

    public BOWTrainer(long j6) {
        this.nativeObj = j6;
    }

    public static BOWTrainer __fromPtr__(long j6) {
        return new BOWTrainer(j6);
    }

    private static native void add_0(long j6, long j7);

    private static native void clear_0(long j6);

    private static native long cluster_0(long j6);

    private static native long cluster_1(long j6, long j7);

    private static native void delete(long j6);

    private static native int descriptorsCount_0(long j6);

    private static native long getDescriptors_0(long j6);

    public void add(Mat mat) {
        add_0(this.nativeObj, mat.nativeObj);
    }

    public void clear() {
        clear_0(this.nativeObj);
    }

    public Mat cluster() {
        return new Mat(cluster_0(this.nativeObj));
    }

    public int descriptorsCount() {
        return descriptorsCount_0(this.nativeObj);
    }

    public void finalize() {
        delete(this.nativeObj);
    }

    public List<Mat> getDescriptors() {
        ArrayList arrayList = new ArrayList();
        Converters.Mat_to_vector_Mat(new Mat(getDescriptors_0(this.nativeObj)), arrayList);
        return arrayList;
    }

    public long getNativeObjAddr() {
        return this.nativeObj;
    }

    public Mat cluster(Mat mat) {
        return new Mat(cluster_1(this.nativeObj, mat.nativeObj));
    }
}
