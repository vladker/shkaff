package org.apache.poi.hssf.record.cont;

import org.apache.poi.util.DelayableLittleEndianOutput;
import org.apache.poi.util.LittleEndianByteArrayOutputStream;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
final class UnknownLengthRecordOutput implements LittleEndianOutput {
    private static final int MAX_DATA_SIZE = 8224;
    private final byte[] _byteBuffer;
    private final LittleEndianOutput _dataSizeOutput;
    private final LittleEndianOutput _originalOut;
    private LittleEndianOutput _out;
    private int _size;

    public UnknownLengthRecordOutput(LittleEndianOutput littleEndianOutput, int i5) {
        this._originalOut = littleEndianOutput;
        littleEndianOutput.writeShort(i5);
        if (littleEndianOutput instanceof DelayableLittleEndianOutput) {
            this._dataSizeOutput = ((DelayableLittleEndianOutput) littleEndianOutput).createDelayedOutput(2);
            this._byteBuffer = null;
            this._out = littleEndianOutput;
        } else {
            this._dataSizeOutput = littleEndianOutput;
            byte[] bArr = new byte[MAX_DATA_SIZE];
            this._byteBuffer = bArr;
            this._out = new LittleEndianByteArrayOutputStream(bArr, 0);
        }
    }

    public int getAvailableSpace() {
        if (this._out != null) {
            return 8224 - this._size;
        }
        throw new IllegalStateException("Record already terminated");
    }

    public int getTotalSize() {
        return this._size + 4;
    }

    public void terminate() {
        if (this._out == null) {
            throw new IllegalStateException("Record already terminated");
        }
        this._dataSizeOutput.writeShort(this._size);
        byte[] bArr = this._byteBuffer;
        if (bArr == null) {
            this._out = null;
        } else {
            this._originalOut.write(bArr, 0, this._size);
            this._out = null;
        }
    }

    @Override // org.apache.poi.util.LittleEndianOutput
    public void write(byte[] bArr) {
        this._out.write(bArr);
        this._size += bArr.length;
    }

    @Override // org.apache.poi.util.LittleEndianOutput
    public void writeByte(int i5) {
        this._out.writeByte(i5);
        this._size++;
    }

    @Override // org.apache.poi.util.LittleEndianOutput
    public void writeDouble(double d) {
        this._out.writeDouble(d);
        this._size += 8;
    }

    @Override // org.apache.poi.util.LittleEndianOutput
    public void writeInt(int i5) {
        this._out.writeInt(i5);
        this._size += 4;
    }

    @Override // org.apache.poi.util.LittleEndianOutput
    public void writeLong(long j6) {
        this._out.writeLong(j6);
        this._size += 8;
    }

    @Override // org.apache.poi.util.LittleEndianOutput
    public void writeShort(int i5) {
        this._out.writeShort(i5);
        this._size += 2;
    }

    @Override // org.apache.poi.util.LittleEndianOutput
    public void write(byte[] bArr, int i5, int i6) {
        this._out.write(bArr, i5, i6);
        this._size += i6;
    }
}
