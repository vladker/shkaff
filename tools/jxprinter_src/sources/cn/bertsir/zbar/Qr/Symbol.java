package cn.bertsir.zbar.Qr;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class Symbol {
    public static final int CODABAR = 38;
    public static final int CODE128 = 128;
    public static final int CODE39 = 39;
    public static final int CODE93 = 93;
    public static final int DATABAR = 34;
    public static final int DATABAR_EXP = 35;
    public static final int EAN13 = 13;
    public static final int EAN8 = 8;
    public static final int I25 = 25;
    public static final int ISBN10 = 10;
    public static final int ISBN13 = 14;
    public static final int NONE = 0;
    public static final int PARTIAL = 1;
    public static final int PDF417 = 57;
    public static final int QRCODE = 64;
    public static final int UPCA = 12;
    public static final int UPCE = 9;
    public static int cropHeight = 0;
    public static int cropWidth = 0;
    public static int cropX = 0;
    public static int cropY = 0;
    public static boolean doubleEngine = false;
    public static boolean is_auto_zoom = false;
    public static boolean is_only_scan_center = false;
    public static boolean looperScan = false;
    public static int looperWaitTime;
    public static int scanFormat;
    public static int scanType;
    public static int screenHeight;
    public static int screenWidth;
    private long peer;
    private int type;

    static {
        System.loadLibrary("zbar");
        init();
    }

    public Symbol(long j6) {
        this.peer = j6;
    }

    private native void destroy(long j6);

    private native long getComponents(long j6);

    private native int getLocationSize(long j6);

    private native int getLocationX(long j6, int i5);

    private native int getLocationY(long j6, int i5);

    private native int getType(long j6);

    private static native void init();

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

    public int[] getBounds() {
        int locationSize = getLocationSize(this.peer);
        if (locationSize <= 0) {
            return null;
        }
        int i5 = Integer.MIN_VALUE;
        int i6 = Integer.MAX_VALUE;
        int i7 = Integer.MIN_VALUE;
        int i8 = Integer.MAX_VALUE;
        for (int i9 = 0; i9 < locationSize; i9++) {
            int locationX = getLocationX(this.peer, i9);
            if (i8 > locationX) {
                i8 = locationX;
            }
            if (i5 < locationX) {
                i5 = locationX;
            }
            int locationY = getLocationY(this.peer, i9);
            if (i6 > locationY) {
                i6 = locationY;
            }
            if (i7 < locationY) {
                i7 = locationY;
            }
        }
        return new int[]{i8, i6, i5 - i8, i7 - i6};
    }

    public SymbolSet getComponents() {
        return new SymbolSet(getComponents(this.peer));
    }

    public native int getConfigMask();

    public native int getCount();

    public native String getData();

    public native byte[] getDataBytes();

    public int[] getLocationPoint(int i5) {
        return new int[]{getLocationX(this.peer, i5), getLocationY(this.peer, i5)};
    }

    public native int getModifierMask();

    public native int getOrientation();

    public native int getQuality();

    public int getType() {
        if (this.type == 0) {
            this.type = getType(this.peer);
        }
        return this.type;
    }

    public native long next();
}
