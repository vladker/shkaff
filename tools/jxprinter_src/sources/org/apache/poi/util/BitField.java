package org.apache.poi.util;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Internal(since = "POI 3.15 beta 3")
public class BitField {
    private final int _mask;
    private final int _shift_count;

    public BitField(int i5) {
        this._mask = i5;
        int i6 = 0;
        if (i5 != 0) {
            while ((i5 & 1) == 0) {
                i6++;
                i5 >>= 1;
            }
        }
        this._shift_count = i6;
    }

    public int clear(int i5) {
        return i5 & (~this._mask);
    }

    public byte clearByte(byte b) {
        return (byte) clear(b);
    }

    public short clearShort(short s6) {
        return (short) clear(s6);
    }

    public int getMask() {
        return this._mask;
    }

    public int getRawValue(int i5) {
        return i5 & this._mask;
    }

    public short getShortRawValue(short s6) {
        return (short) getRawValue(s6);
    }

    public short getShortValue(short s6) {
        return (short) getValue(s6);
    }

    public int getValue(int i5) {
        return getRawValue(i5) >>> this._shift_count;
    }

    public boolean isAllSet(int i5) {
        int i6 = this._mask;
        return (i5 & i6) == i6;
    }

    public boolean isSet(int i5) {
        return (i5 & this._mask) != 0;
    }

    public int set(int i5) {
        return i5 | this._mask;
    }

    public int setBoolean(int i5, boolean z6) {
        return z6 ? set(i5) : clear(i5);
    }

    public byte setByte(byte b) {
        return (byte) set(b);
    }

    public byte setByteBoolean(byte b, boolean z6) {
        return z6 ? setByte(b) : clearByte(b);
    }

    public short setShort(short s6) {
        return (short) set(s6);
    }

    public short setShortBoolean(short s6, boolean z6) {
        return z6 ? setShort(s6) : clearShort(s6);
    }

    public short setShortValue(short s6, short s7) {
        return (short) setValue(s6, s7);
    }

    public int setValue(int i5, int i6) {
        int i7 = this._mask;
        return (i5 & (~i7)) | ((i6 << this._shift_count) & i7);
    }
}
