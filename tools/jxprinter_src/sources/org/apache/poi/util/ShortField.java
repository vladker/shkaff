package org.apache.poi.util;

import A3.AbstractC0157z;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class ShortField implements FixedField {
    private final int _offset;
    private short _value;

    public ShortField(int i5) {
        if (i5 < 0) {
            throw new ArrayIndexOutOfBoundsException(AbstractC0157z.k(i5, "Illegal offset: "));
        }
        this._offset = i5;
    }

    public short get() {
        return this._value;
    }

    @Override // org.apache.poi.util.FixedField
    public void readFromBytes(byte[] bArr) {
        this._value = LittleEndian.getShort(bArr, this._offset);
    }

    @Override // org.apache.poi.util.FixedField
    public void readFromStream(InputStream inputStream) {
        this._value = LittleEndian.readShort(inputStream);
    }

    public void set(short s6) {
        this._value = s6;
    }

    @Override // org.apache.poi.util.FixedField
    public String toString() {
        return String.valueOf((int) this._value);
    }

    @Override // org.apache.poi.util.FixedField
    public void writeToBytes(byte[] bArr) {
        LittleEndian.putShort(bArr, this._offset, this._value);
    }

    public void set(short s6, byte[] bArr) {
        this._value = s6;
        writeToBytes(bArr);
    }

    public ShortField(int i5, short s6) {
        this(i5);
        set(s6);
    }

    public ShortField(int i5, byte[] bArr) {
        this(i5);
        readFromBytes(bArr);
    }

    public ShortField(int i5, short s6, byte[] bArr) {
        this(i5);
        set(s6, bArr);
    }
}
