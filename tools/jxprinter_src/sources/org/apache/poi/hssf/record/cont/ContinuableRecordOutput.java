package org.apache.poi.hssf.record.cont;

import org.apache.poi.util.DelayableLittleEndianOutput;
import org.apache.poi.util.LittleEndianOutput;
import org.apache.poi.util.StringUtil;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class ContinuableRecordOutput implements LittleEndianOutput {
    private static final LittleEndianOutput NOPOutput = new DelayableLittleEndianOutput() { // from class: org.apache.poi.hssf.record.cont.ContinuableRecordOutput.1
        @Override // org.apache.poi.util.LittleEndianOutput
        public void write(byte[] bArr) {
        }

        @Override // org.apache.poi.util.LittleEndianOutput
        public void write(byte[] bArr, int i5, int i6) {
        }

        @Override // org.apache.poi.util.DelayableLittleEndianOutput
        public LittleEndianOutput createDelayedOutput(int i5) {
            return this;
        }

        @Override // org.apache.poi.util.LittleEndianOutput
        public void writeByte(int i5) {
        }

        @Override // org.apache.poi.util.LittleEndianOutput
        public void writeDouble(double d) {
        }

        @Override // org.apache.poi.util.LittleEndianOutput
        public void writeInt(int i5) {
        }

        @Override // org.apache.poi.util.LittleEndianOutput
        public void writeLong(long j6) {
        }

        @Override // org.apache.poi.util.LittleEndianOutput
        public void writeShort(int i5) {
        }
    };
    private final LittleEndianOutput _out;
    private int _totalPreviousRecordsSize = 0;
    private UnknownLengthRecordOutput _ulrOutput;

    public ContinuableRecordOutput(LittleEndianOutput littleEndianOutput, int i5) {
        this._ulrOutput = new UnknownLengthRecordOutput(littleEndianOutput, i5);
        this._out = littleEndianOutput;
    }

    public static ContinuableRecordOutput createForCountingOnly() {
        return new ContinuableRecordOutput(NOPOutput, -777);
    }

    private void writeCharacterData(String str, boolean z6) {
        int length = str.length();
        int i5 = 0;
        if (z6) {
            while (true) {
                int iMin = Math.min(length - i5, this._ulrOutput.getAvailableSpace() / 2);
                while (iMin > 0) {
                    this._ulrOutput.writeShort(str.charAt(i5));
                    iMin--;
                    i5++;
                }
                if (i5 >= length) {
                    return;
                }
                writeContinue();
                writeByte(1);
            }
        } else {
            int i6 = 0;
            while (true) {
                int iMin2 = Math.min(length - i6, this._ulrOutput.getAvailableSpace());
                while (iMin2 > 0) {
                    this._ulrOutput.writeByte(str.charAt(i6));
                    iMin2--;
                    i6++;
                }
                if (i6 >= length) {
                    return;
                }
                writeContinue();
                writeByte(0);
            }
        }
    }

    public int getAvailableSpace() {
        return this._ulrOutput.getAvailableSpace();
    }

    public int getTotalSize() {
        return this._totalPreviousRecordsSize + this._ulrOutput.getTotalSize();
    }

    public void terminate() {
        this._ulrOutput.terminate();
    }

    @Override // org.apache.poi.util.LittleEndianOutput
    public void write(byte[] bArr) {
        writeContinueIfRequired(bArr.length);
        this._ulrOutput.write(bArr);
    }

    @Override // org.apache.poi.util.LittleEndianOutput
    public void writeByte(int i5) {
        writeContinueIfRequired(1);
        this._ulrOutput.writeByte(i5);
    }

    public void writeContinue() {
        this._ulrOutput.terminate();
        this._totalPreviousRecordsSize += this._ulrOutput.getTotalSize();
        this._ulrOutput = new UnknownLengthRecordOutput(this._out, 60);
    }

    public void writeContinueIfRequired(int i5) {
        if (this._ulrOutput.getAvailableSpace() < i5) {
            writeContinue();
        }
    }

    @Override // org.apache.poi.util.LittleEndianOutput
    public void writeDouble(double d) {
        writeContinueIfRequired(8);
        this._ulrOutput.writeDouble(d);
    }

    @Override // org.apache.poi.util.LittleEndianOutput
    public void writeInt(int i5) {
        writeContinueIfRequired(4);
        this._ulrOutput.writeInt(i5);
    }

    @Override // org.apache.poi.util.LittleEndianOutput
    public void writeLong(long j6) {
        writeContinueIfRequired(8);
        this._ulrOutput.writeLong(j6);
    }

    @Override // org.apache.poi.util.LittleEndianOutput
    public void writeShort(int i5) {
        writeContinueIfRequired(2);
        this._ulrOutput.writeShort(i5);
    }

    public void writeString(String str, int i5, int i6) {
        int i7;
        int i8;
        boolean zHasMultibyte = StringUtil.hasMultibyte(str);
        if (zHasMultibyte) {
            i8 = 1;
            i7 = 5;
        } else {
            i7 = 4;
            i8 = 0;
        }
        if (i5 > 0) {
            i8 |= 8;
            i7 += 2;
        }
        if (i6 > 0) {
            i8 |= 4;
            i7 += 4;
        }
        writeContinueIfRequired(i7);
        writeShort(str.length());
        writeByte(i8);
        if (i5 > 0) {
            writeShort(i5);
        }
        if (i6 > 0) {
            writeInt(i6);
        }
        writeCharacterData(str, zHasMultibyte);
    }

    public void writeStringData(String str) {
        int i5;
        int i6;
        boolean zHasMultibyte = StringUtil.hasMultibyte(str);
        if (zHasMultibyte) {
            i6 = 1;
            i5 = 3;
        } else {
            i5 = 2;
            i6 = 0;
        }
        writeContinueIfRequired(i5);
        writeByte(i6);
        writeCharacterData(str, zHasMultibyte);
    }

    @Override // org.apache.poi.util.LittleEndianOutput
    public void write(byte[] bArr, int i5, int i6) {
        int i7 = 0;
        while (true) {
            int iMin = Math.min(i6 - i7, this._ulrOutput.getAvailableSpace());
            while (iMin > 0) {
                this._ulrOutput.writeByte(bArr[i7 + i5]);
                iMin--;
                i7++;
            }
            if (i7 >= i6) {
                return;
            } else {
                writeContinue();
            }
        }
    }
}
