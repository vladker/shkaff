package org.opencv.dnn;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class DictValue {
    protected final long nativeObj;

    public DictValue(long j6) {
        this.nativeObj = j6;
    }

    private static native long DictValue_0(int i5);

    private static native long DictValue_1(double d);

    private static native long DictValue_2(String str);

    public static DictValue __fromPtr__(long j6) {
        return new DictValue(j6);
    }

    private static native void delete(long j6);

    private static native int getIntValue_0(long j6, int i5);

    private static native int getIntValue_1(long j6);

    private static native double getRealValue_0(long j6, int i5);

    private static native double getRealValue_1(long j6);

    private static native String getStringValue_0(long j6, int i5);

    private static native String getStringValue_1(long j6);

    private static native boolean isInt_0(long j6);

    private static native boolean isReal_0(long j6);

    private static native boolean isString_0(long j6);

    public void finalize() {
        delete(this.nativeObj);
    }

    public int getIntValue(int i5) {
        return getIntValue_0(this.nativeObj, i5);
    }

    public long getNativeObjAddr() {
        return this.nativeObj;
    }

    public double getRealValue(int i5) {
        return getRealValue_0(this.nativeObj, i5);
    }

    public String getStringValue(int i5) {
        return getStringValue_0(this.nativeObj, i5);
    }

    public boolean isInt() {
        return isInt_0(this.nativeObj);
    }

    public boolean isReal() {
        return isReal_0(this.nativeObj);
    }

    public boolean isString() {
        return isString_0(this.nativeObj);
    }

    public DictValue(int i5) {
        this.nativeObj = DictValue_0(i5);
    }

    public int getIntValue() {
        return getIntValue_1(this.nativeObj);
    }

    public double getRealValue() {
        return getRealValue_1(this.nativeObj);
    }

    public String getStringValue() {
        return getStringValue_1(this.nativeObj);
    }

    public DictValue(double d) {
        this.nativeObj = DictValue_1(d);
    }

    public DictValue(String str) {
        this.nativeObj = DictValue_2(str);
    }
}
