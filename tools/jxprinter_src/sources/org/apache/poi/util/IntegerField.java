package org.apache.poi.util;

import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class IntegerField implements FixedField {
    private final int _offset;
    private int _value;

    public IntegerField(int i5) {
        if (i5 < 0) {
            throw new ArrayIndexOutOfBoundsException("negative offset");
        }
        this._offset = i5;
    }

    public int get() {
        return this._value;
    }

    @Override // org.apache.poi.util.FixedField
    public void readFromBytes(byte[] bArr) {
        this._value = LittleEndian.getInt(bArr, this._offset);
    }

    @Override // org.apache.poi.util.FixedField
    public void readFromStream(InputStream inputStream) {
        this._value = LittleEndian.readInt(inputStream);
    }

    public void set(int i5) {
        this._value = i5;
    }

    @Override // org.apache.poi.util.FixedField
    public String toString() {
        return String.valueOf(this._value);
    }

    @Override // org.apache.poi.util.FixedField
    public void writeToBytes(byte[] bArr) {
        LittleEndian.putInt(bArr, this._offset, this._value);
    }

    public void set(int i5, byte[] bArr) {
        this._value = i5;
        writeToBytes(bArr);
    }

    public IntegerField(int i5, int i6) {
        this(i5);
        set(i6);
    }

    public IntegerField(int i5, byte[] bArr) {
        this(i5);
        readFromBytes(bArr);
    }

    public IntegerField(int i5, int i6, byte[] bArr) {
        this(i5);
        set(i6, bArr);
    }
}
