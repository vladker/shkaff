package org.apache.poi.hssf.record.cont;

import org.apache.poi.hssf.record.RecordInputStream;
import org.apache.poi.util.LittleEndianInput;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class ContinuableRecordInput implements LittleEndianInput {
    private final RecordInputStream _in;

    public ContinuableRecordInput(RecordInputStream recordInputStream) {
        this._in = recordInputStream;
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public int available() {
        return this._in.available();
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public byte readByte() {
        return this._in.readByte();
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public double readDouble() {
        return this._in.readDouble();
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public void readFully(byte[] bArr) {
        this._in.readFully(bArr);
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public int readInt() {
        int uByte = this._in.readUByte();
        int uByte2 = this._in.readUByte();
        return (this._in.readUByte() << 24) + (this._in.readUByte() << 16) + (uByte2 << 8) + uByte;
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public long readLong() {
        int uByte = this._in.readUByte();
        int uByte2 = this._in.readUByte();
        int uByte3 = this._in.readUByte();
        int uByte4 = this._in.readUByte();
        int uByte5 = this._in.readUByte();
        int uByte6 = this._in.readUByte();
        return (((long) this._in.readUByte()) << 56) + (((long) this._in.readUByte()) << 48) + (((long) uByte6) << 40) + (((long) uByte5) << 32) + (((long) uByte4) << 24) + (((long) uByte3) << 16) + (((long) uByte2) << 8) + ((long) uByte);
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public void readPlain(byte[] bArr, int i5, int i6) {
        readFully(bArr, i5, i6);
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public short readShort() {
        return this._in.readShort();
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public int readUByte() {
        return this._in.readUByte();
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public int readUShort() {
        return (readUByte() << 8) + readUByte();
    }

    @Override // org.apache.poi.util.LittleEndianInput
    public void readFully(byte[] bArr, int i5, int i6) {
        this._in.readFully(bArr, i5, i6);
    }
}
