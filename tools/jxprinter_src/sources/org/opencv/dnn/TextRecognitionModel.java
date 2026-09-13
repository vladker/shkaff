package org.opencv.dnn;

import java.util.List;
import org.opencv.core.Mat;
import org.opencv.utils.Converters;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class TextRecognitionModel extends Model {
    public TextRecognitionModel(long j6) {
        super(j6);
    }

    private static native long TextRecognitionModel_0(long j6);

    private static native long TextRecognitionModel_1(String str, String str2);

    private static native long TextRecognitionModel_2(String str);

    public static TextRecognitionModel __fromPtr__(long j6) {
        return new TextRecognitionModel(j6);
    }

    private static native void delete(long j6);

    private static native String getDecodeType_0(long j6);

    private static native List<String> getVocabulary_0(long j6);

    private static native String recognize_0(long j6, long j7);

    private static native void recognize_1(long j6, long j7, long j8, List<String> list);

    private static native long setDecodeOptsCTCPrefixBeamSearch_0(long j6, int i5, int i6);

    private static native long setDecodeOptsCTCPrefixBeamSearch_1(long j6, int i5);

    private static native long setDecodeType_0(long j6, String str);

    private static native long setVocabulary_0(long j6, List<String> list);

    @Override // org.opencv.dnn.Model
    public void finalize() {
        delete(this.nativeObj);
    }

    public String getDecodeType() {
        return getDecodeType_0(this.nativeObj);
    }

    public List<String> getVocabulary() {
        return getVocabulary_0(this.nativeObj);
    }

    public String recognize(Mat mat) {
        return recognize_0(this.nativeObj, mat.nativeObj);
    }

    public TextRecognitionModel setDecodeOptsCTCPrefixBeamSearch(int i5, int i6) {
        return new TextRecognitionModel(setDecodeOptsCTCPrefixBeamSearch_0(this.nativeObj, i5, i6));
    }

    public TextRecognitionModel setDecodeType(String str) {
        return new TextRecognitionModel(setDecodeType_0(this.nativeObj, str));
    }

    public TextRecognitionModel setVocabulary(List<String> list) {
        return new TextRecognitionModel(setVocabulary_0(this.nativeObj, list));
    }

    public TextRecognitionModel(Net net) {
        super(TextRecognitionModel_0(net.nativeObj));
    }

    public void recognize(Mat mat, List<Mat> list, List<String> list2) {
        recognize_1(this.nativeObj, mat.nativeObj, Converters.vector_Mat_to_Mat(list).nativeObj, list2);
    }

    public TextRecognitionModel setDecodeOptsCTCPrefixBeamSearch(int i5) {
        return new TextRecognitionModel(setDecodeOptsCTCPrefixBeamSearch_1(this.nativeObj, i5));
    }

    public TextRecognitionModel(String str, String str2) {
        super(TextRecognitionModel_1(str, str2));
    }

    public TextRecognitionModel(String str) {
        super(TextRecognitionModel_2(str));
    }
}
