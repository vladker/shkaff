package org.opencv.objdetect;

import org.opencv.core.Algorithm;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class BaseCascadeClassifier extends Algorithm {
    public BaseCascadeClassifier(long j6) {
        super(j6);
    }

    public static BaseCascadeClassifier __fromPtr__(long j6) {
        return new BaseCascadeClassifier(j6);
    }

    private static native void delete(long j6);

    @Override // org.opencv.core.Algorithm
    public void finalize() {
        delete(this.nativeObj);
    }
}
