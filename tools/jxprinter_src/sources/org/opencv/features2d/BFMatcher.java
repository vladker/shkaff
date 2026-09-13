package org.opencv.features2d;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class BFMatcher extends DescriptorMatcher {
    public BFMatcher(long j6) {
        super(j6);
    }

    private static native long BFMatcher_0(int i5, boolean z6);

    private static native long BFMatcher_1(int i5);

    private static native long BFMatcher_2();

    public static BFMatcher __fromPtr__(long j6) {
        return new BFMatcher(j6);
    }

    public static BFMatcher create(int i5, boolean z6) {
        return __fromPtr__(create_0(i5, z6));
    }

    private static native long create_0(int i5, boolean z6);

    private static native long create_1(int i5);

    private static native long create_2();

    private static native void delete(long j6);

    @Override // org.opencv.features2d.DescriptorMatcher, org.opencv.core.Algorithm
    public void finalize() {
        delete(this.nativeObj);
    }

    public BFMatcher(int i5, boolean z6) {
        super(BFMatcher_0(i5, z6));
    }

    public static BFMatcher create(int i5) {
        return __fromPtr__(create_1(i5));
    }

    public BFMatcher(int i5) {
        super(BFMatcher_1(i5));
    }

    public static BFMatcher create() {
        return __fromPtr__(create_2());
    }

    public BFMatcher() {
        super(BFMatcher_2());
    }
}
