package org.apache.poi.util;

import A3.AbstractC0157z;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class LongField implements FixedField {
    private final int _offset;
    private long _value;

    public LongField(int i5) {
        if (i5 < 0) {
            throw new ArrayIndexOutOfBoundsException(AbstractC0157z.k(i5, "Illegal offset: "));
        }
        this._offset = i5;
    }

    public long get() {
        return this._value;
    }

    @Override // org.apache.poi.util.FixedField
    public void readFromBytes(byte[] bArr) {
        this._value = LittleEndian.getLong(bArr, this._offset);
    }

    @Override // org.apache.poi.util.FixedField
    public void readFromStream(InputStream inputStream) {
        this._value = LittleEndian.readLong(inputStream);
    }

    public void set(long j6) {
        this._value = j6;
    }

    @Override // org.apache.poi.util.FixedField
    public String toString() {
        return String.valueOf(this._value);
    }

    @Override // org.apache.poi.util.FixedField
    public void writeToBytes(byte[] bArr) {
        LittleEndian.putLong(bArr, this._offset, this._value);
    }

    public void set(long j6, byte[] bArr) {
        this._value = j6;
        writeToBytes(bArr);
    }

    public LongField(int i5, long j6) {
        this(i5);
        set(j6);
    }

    public LongField(int i5, byte[] bArr) {
        this(i5);
        readFromBytes(bArr);
    }

    public LongField(int i5, long j6, byte[] bArr) {
        this(i5);
        set(j6, bArr);
    }
}
