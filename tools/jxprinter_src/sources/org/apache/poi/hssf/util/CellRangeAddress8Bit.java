package org.apache.poi.hssf.util;

import org.apache.poi.ss.util.CellRangeAddressBase;
import org.apache.poi.util.LittleEndianInput;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class CellRangeAddress8Bit extends CellRangeAddressBase {
    public static final int ENCODED_SIZE = 6;

    public CellRangeAddress8Bit(int i5, int i6, int i7, int i8) {
        super(i5, i6, i7, i8);
    }

    public static int getEncodedSize(int i5) {
        return i5 * 6;
    }

    private static int readUShortAndCheck(LittleEndianInput littleEndianInput) {
        if (littleEndianInput.available() >= 6) {
            return littleEndianInput.readUShort();
        }
        throw new IllegalArgumentException("Ran out of data reading CellRangeAddress, available: " + littleEndianInput.available());
    }

    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(getFirstRow());
        littleEndianOutput.writeShort(getLastRow());
        littleEndianOutput.writeByte(getFirstColumn());
        littleEndianOutput.writeByte(getLastColumn());
    }

    public CellRangeAddress8Bit(LittleEndianInput littleEndianInput) {
        super(readUShortAndCheck(littleEndianInput), littleEndianInput.readUShort(), littleEndianInput.readUByte(), littleEndianInput.readUByte());
    }

    @Override // org.apache.poi.common.Duplicatable
    public CellRangeAddress8Bit copy() {
        return new CellRangeAddress8Bit(getFirstRow(), getLastRow(), getFirstColumn(), getLastColumn());
    }
}
