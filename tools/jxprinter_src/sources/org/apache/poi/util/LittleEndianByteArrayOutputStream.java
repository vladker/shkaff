package org.apache.poi.util;

import A3.AbstractC0157z;
import java.io.OutputStream;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class LittleEndianByteArrayOutputStream extends OutputStream implements LittleEndianOutput, DelayableLittleEndianOutput {
    private final byte[] _buf;
    private final int _endIndex;
    private int _writeIndex;

    public LittleEndianByteArrayOutputStream(byte[] bArr, int i5, int i6) {
        if (i5 < 0 || i5 > bArr.length) {
            throw new IllegalArgumentException(AbstractC0157z.l(")", bArr.length, AbstractC0157z.t(i5, "Specified startOffset (", ") is out of allowable range (0..")));
        }
        this._buf = bArr;
        this._writeIndex = i5;
        int i7 = i6 + i5;
        this._endIndex = i7;
        if (i7 < i5 || i7 > bArr.length) {
            StringBuilder sbT = AbstractC0157z.t(i7, "calculated end index (", ") is out of allowable range (");
            sbT.append(this._writeIndex);
            sbT.append("..");
            throw new IllegalArgumentException(AbstractC0157z.l(")", bArr.length, sbT));
        }
    }

    private void checkPosition(int i5) {
        if (i5 > this._endIndex - this._writeIndex) {
            throw new RuntimeException("Buffer overrun");
        }
    }

    @Override // org.apache.poi.util.DelayableLittleEndianOutput
    public LittleEndianOutput createDelayedOutput(int i5) {
        checkPosition(i5);
        LittleEndianByteArrayOutputStream littleEndianByteArrayOutputStream = new LittleEndianByteArrayOutputStream(this._buf, this._writeIndex, i5);
        this._writeIndex += i5;
        return littleEndianByteArrayOutputStream;
    }

    public int getWriteIndex() {
        return this._writeIndex;
    }

    @Override // java.io.OutputStream
    public void write(int i5) {
        writeByte(i5);
    }

    @Override // org.apache.poi.util.LittleEndianOutput
    public void writeByte(int i5) {
        checkPosition(1);
        byte[] bArr = this._buf;
        int i6 = this._writeIndex;
        this._writeIndex = i6 + 1;
        bArr[i6] = (byte) i5;
    }

    @Override // org.apache.poi.util.LittleEndianOutput
    public void writeDouble(double d) {
        writeLong(Double.doubleToLongBits(d));
    }

    @Override // org.apache.poi.util.LittleEndianOutput
    public void writeInt(int i5) {
        checkPosition(4);
        int i6 = this._writeIndex;
        byte[] bArr = this._buf;
        bArr[i6] = (byte) (i5 & 255);
        bArr[i6 + 1] = (byte) ((i5 >>> 8) & 255);
        bArr[i6 + 2] = (byte) ((i5 >>> 16) & 255);
        bArr[i6 + 3] = (byte) ((i5 >>> 24) & 255);
        this._writeIndex = i6 + 4;
    }

    @Override // org.apache.poi.util.LittleEndianOutput
    public void writeLong(long j6) {
        writeInt((int) j6);
        writeInt((int) (j6 >> 32));
    }

    @Override // org.apache.poi.util.LittleEndianOutput
    public void writeShort(int i5) {
        checkPosition(2);
        int i6 = this._writeIndex;
        byte[] bArr = this._buf;
        bArr[i6] = (byte) (i5 & 255);
        bArr[i6 + 1] = (byte) ((i5 >>> 8) & 255);
        this._writeIndex = i6 + 2;
    }

    @Override // java.io.OutputStream, org.apache.poi.util.LittleEndianOutput
    public void write(byte[] bArr) {
        int length = bArr.length;
        checkPosition(length);
        System.arraycopy(bArr, 0, this._buf, this._writeIndex, length);
        this._writeIndex += length;
    }

    @Override // java.io.OutputStream, org.apache.poi.util.LittleEndianOutput
    public void write(byte[] bArr, int i5, int i6) {
        checkPosition(i6);
        System.arraycopy(bArr, i5, this._buf, this._writeIndex, i6);
        this._writeIndex += i6;
    }

    public LittleEndianByteArrayOutputStream(byte[] bArr, int i5) {
        this(bArr, i5, bArr.length - i5);
    }
}
