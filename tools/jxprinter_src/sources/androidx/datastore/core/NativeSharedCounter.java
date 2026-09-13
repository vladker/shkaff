package androidx.datastore.core;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class NativeSharedCounter {
    public final native long nativeCreateSharedCounter(int i5);

    public final native int nativeGetCounterValue(long j6);

    public final native int nativeIncrementAndGetCounterValue(long j6);

    public final native int nativeTruncateFile(int i5);
}
