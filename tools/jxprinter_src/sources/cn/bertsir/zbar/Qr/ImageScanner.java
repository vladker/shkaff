package cn.bertsir.zbar.Qr;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class ImageScanner {
    private long peer = create();

    static {
        System.loadLibrary("zbar");
        init();
    }

    private native long create();

    private native void destroy(long j6);

    private native long getResults(long j6);

    private static native void init();

    public synchronized void destroy() {
        long j6 = this.peer;
        if (j6 != 0) {
            destroy(j6);
            this.peer = 0L;
        }
    }

    public native void enableCache(boolean z6);

    public void finalize() {
        destroy();
    }

    public SymbolSet getResults() {
        return new SymbolSet(getResults(this.peer));
    }

    public native void parseConfig(String str);

    public native int scanImage(Image image);

    public native void setConfig(int i5, int i6, int i7);
}
