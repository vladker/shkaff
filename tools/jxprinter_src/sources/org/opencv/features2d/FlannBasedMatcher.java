package org.opencv.features2d;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class FlannBasedMatcher extends DescriptorMatcher {
    public FlannBasedMatcher(long j6) {
        super(j6);
    }

    private static native long FlannBasedMatcher_0();

    public static FlannBasedMatcher __fromPtr__(long j6) {
        return new FlannBasedMatcher(j6);
    }

    public static FlannBasedMatcher create() {
        return __fromPtr__(create_0());
    }

    private static native long create_0();

    private static native void delete(long j6);

    @Override // org.opencv.features2d.DescriptorMatcher, org.opencv.core.Algorithm
    public void finalize() {
        delete(this.nativeObj);
    }

    public FlannBasedMatcher() {
        super(FlannBasedMatcher_0());
    }
}
