package org.apache.poi.hssf.record;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.LittleEndianInput;
import org.apache.poi.util.LittleEndianOutput;
import org.apache.poi.util.RecordFormatException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class FtPioGrbitSubRecord extends SubRecord {
    public static final int AUTO_LOAD_BIT = 512;
    public static final int AUTO_PICT_BIT = 1;
    public static final int CAMERA_BIT = 128;
    public static final int CTL_BIT = 16;
    public static final int DDE_BIT = 2;
    public static final int DEFAULT_SIZE_BIT = 256;
    public static final int ICON_BIT = 8;
    public static final int PRINT_CALC_BIT = 4;
    public static final int PRSTM_BIT = 32;
    public static final short length = 2;
    public static final short sid = 8;
    private short flags;

    public FtPioGrbitSubRecord() {
    }

    @Override // org.apache.poi.hssf.record.SubRecord
    public int getDataSize() {
        return 2;
    }

    public boolean getFlagByBit(int i5) {
        return (i5 & this.flags) != 0;
    }

    public short getFlags() {
        return this.flags;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("flags", GenericRecordUtil.getBitsAsString(new C1381b(this, 16), new int[]{1, 2, 4, 8, 16, 32, 128, 256, 512}, new String[]{"AUTO_PICT", "DDE", "PRINT_CALC", "ICON", "CTL", "PRSTM", "CAMERA", "DEFAULT_SIZE", "AUTO_LOAD"}));
    }

    public short getSid() {
        return (short) 8;
    }

    @Override // org.apache.poi.hssf.record.SubRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(8);
        littleEndianOutput.writeShort(2);
        littleEndianOutput.writeShort(this.flags);
    }

    public void setFlagByBit(int i5, boolean z6) {
        if (z6) {
            this.flags = (short) (i5 | this.flags);
        } else {
            this.flags = (short) ((i5 ^ 65535) & this.flags);
        }
    }

    public void setFlags(short s6) {
        this.flags = s6;
    }

    public FtPioGrbitSubRecord(FtPioGrbitSubRecord ftPioGrbitSubRecord) {
        super(ftPioGrbitSubRecord);
        this.flags = ftPioGrbitSubRecord.flags;
    }

    @Override // org.apache.poi.hssf.record.SubRecord, org.apache.poi.common.usermodel.GenericRecord
    public SubRecord.SubRecordTypes getGenericRecordType() {
        return SubRecord.SubRecordTypes.FT_PIO_GRBIT;
    }

    @Override // org.apache.poi.hssf.record.SubRecord, org.apache.poi.common.Duplicatable
    public FtPioGrbitSubRecord copy() {
        return new FtPioGrbitSubRecord(this);
    }

    public FtPioGrbitSubRecord(LittleEndianInput littleEndianInput, int i5) {
        this(littleEndianInput, i5, -1);
    }

    public FtPioGrbitSubRecord(LittleEndianInput littleEndianInput, int i5, int i6) {
        if (i5 == 2) {
            this.flags = littleEndianInput.readShort();
            return;
        }
        throw new RecordFormatException(androidx.collection.a.i(i5, "Unexpected size (", ")"));
    }
}
