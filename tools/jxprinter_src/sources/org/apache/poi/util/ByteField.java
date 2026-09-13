package org.apache.poi.util;

import java.io.IOException;
import java.io.InputStream;
import java.nio.BufferUnderflowException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class ByteField implements FixedField {
    private static final byte _default_value = 0;
    private final int _offset;
    private byte _value;

    public ByteField(int i5) {
        this(i5, (byte) 0);
    }

    public byte get() {
        return this._value;
    }

    @Override // org.apache.poi.util.FixedField
    public void readFromBytes(byte[] bArr) {
        this._value = bArr[this._offset];
    }

    @Override // org.apache.poi.util.FixedField
    public void readFromStream(InputStream inputStream) throws IOException {
        int i5 = inputStream.read();
        if (i5 < 0) {
            throw new BufferUnderflowException();
        }
        this._value = (byte) i5;
    }

    public void set(byte b) {
        this._value = b;
    }

    @Override // org.apache.poi.util.FixedField
    public String toString() {
        return String.valueOf((int) this._value);
    }

    @Override // org.apache.poi.util.FixedField
    public void writeToBytes(byte[] bArr) {
        bArr[this._offset] = this._value;
    }

    public ByteField(int i5, byte b) {
        if (i5 < 0) {
            throw new ArrayIndexOutOfBoundsException("offset cannot be negative");
        }
        this._offset = i5;
        set(b);
    }

    public void set(byte b, byte[] bArr) {
        set(b);
        writeToBytes(bArr);
    }

    public ByteField(int i5, byte[] bArr) {
        this(i5);
        readFromBytes(bArr);
    }

    public ByteField(int i5, byte b, byte[] bArr) {
        this(i5, b);
        writeToBytes(bArr);
    }
}
