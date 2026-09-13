package cn.bertsir.zbar.Qr;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class Image {
    private Object data;
    private long peer;

    static {
        System.loadLibrary("zbar");
        init();
    }

    public Image() {
        this.peer = create();
    }

    private native long convert(long j6, String str);

    private native long create();

    private native void destroy(long j6);

    private native long getSymbols(long j6);

    private static native void init();

    public Image convert(String str) {
        long jConvert = convert(this.peer, str);
        if (jConvert == 0) {
            return null;
        }
        return new Image(jConvert);
    }

    public synchronized void destroy() {
        long j6 = this.peer;
        if (j6 != 0) {
            destroy(j6);
            this.peer = 0L;
        }
    }

    public void finalize() {
        destroy();
    }

    public native int[] getCrop();

    public native byte[] getData();

    public native String getFormat();

    public native int getHeight();

    public native int getSequence();

    public native int[] getSize();

    public SymbolSet getSymbols() {
        return new SymbolSet(getSymbols(this.peer));
    }

    public native int getWidth();

    public native void setCrop(int i5, int i6, int i7, int i8);

    public native void setCrop(int[] iArr);

    public native void setData(byte[] bArr);

    public native void setData(int[] iArr);

    public native void setFormat(String str);

    public native void setSequence(int i5);

    public native void setSize(int i5, int i6);

    public native void setSize(int[] iArr);

    public Image(int i5, int i6) {
        this();
        setSize(i5, i6);
    }

    public Image(int i5, int i6, String str) {
        this();
        setSize(i5, i6);
        setFormat(str);
    }

    public Image(String str) {
        this();
        setFormat(str);
    }

    public Image(long j6) {
        this.peer = j6;
    }
}
