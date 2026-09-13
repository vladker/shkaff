package org.apache.poi.hssf.record;

import java.io.IOException;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.common.usermodel.GenericRecord;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.util.GenericRecordJsonWriter;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.RecordFormatException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class OldSheetRecord implements GenericRecord {
    public static final short sid = 133;
    private CodepageRecord codepage;
    private final int field_1_position_of_BOF;
    private final int field_2_visibility;
    private final int field_3_type;
    private final byte[] field_5_sheetname;

    public OldSheetRecord(RecordInputStream recordInputStream) {
        this.field_1_position_of_BOF = recordInputStream.readInt();
        this.field_2_visibility = recordInputStream.readUByte();
        this.field_3_type = recordInputStream.readUByte();
        int uByte = recordInputStream.readUByte();
        if (uByte > 0) {
            recordInputStream.mark(1);
            if (recordInputStream.readByte() != 0) {
                try {
                    recordInputStream.reset();
                } catch (IOException e) {
                    throw new RecordFormatException(e);
                }
            }
        }
        byte[] bArrSafelyAllocate = IOUtils.safelyAllocate(uByte, HSSFWorkbook.getMaxRecordLength());
        this.field_5_sheetname = bArrSafelyAllocate;
        recordInputStream.read(bArrSafelyAllocate, 0, uByte);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$0() {
        return Integer.valueOf(this.field_2_visibility);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$1() {
        return Integer.valueOf(this.field_3_type);
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        final int i5 = 0;
        Supplier supplier = new Supplier(this) { // from class: org.apache.poi.hssf.record.u0
            public final /* synthetic */ OldSheetRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i5) {
                    case 0:
                        return Integer.valueOf(this.b.getPositionOfBof());
                    case 1:
                        return this.b.lambda$getGenericProperties$0();
                    case 2:
                        return this.b.lambda$getGenericProperties$1();
                    default:
                        return this.b.getSheetname();
                }
            }
        };
        final int i6 = 1;
        Supplier supplier2 = new Supplier(this) { // from class: org.apache.poi.hssf.record.u0
            public final /* synthetic */ OldSheetRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i6) {
                    case 0:
                        return Integer.valueOf(this.b.getPositionOfBof());
                    case 1:
                        return this.b.lambda$getGenericProperties$0();
                    case 2:
                        return this.b.lambda$getGenericProperties$1();
                    default:
                        return this.b.getSheetname();
                }
            }
        };
        final int i7 = 2;
        Supplier supplier3 = new Supplier(this) { // from class: org.apache.poi.hssf.record.u0
            public final /* synthetic */ OldSheetRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i7) {
                    case 0:
                        return Integer.valueOf(this.b.getPositionOfBof());
                    case 1:
                        return this.b.lambda$getGenericProperties$0();
                    case 2:
                        return this.b.lambda$getGenericProperties$1();
                    default:
                        return this.b.getSheetname();
                }
            }
        };
        final int i8 = 3;
        return GenericRecordUtil.getGenericProperties("bof", supplier, "visibility", supplier2, "type", supplier3, "sheetName", new Supplier(this) { // from class: org.apache.poi.hssf.record.u0
            public final /* synthetic */ OldSheetRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i8) {
                    case 0:
                        return Integer.valueOf(this.b.getPositionOfBof());
                    case 1:
                        return this.b.lambda$getGenericProperties$0();
                    case 2:
                        return this.b.lambda$getGenericProperties$1();
                    default:
                        return this.b.getSheetname();
                }
            }
        });
    }

    public int getPositionOfBof() {
        return this.field_1_position_of_BOF;
    }

    public String getSheetname() {
        return OldStringRecord.getString(this.field_5_sheetname, this.codepage);
    }

    public short getSid() {
        return (short) 133;
    }

    public void setCodePage(CodepageRecord codepageRecord) {
        this.codepage = codepageRecord;
    }

    public String toString() {
        return GenericRecordJsonWriter.marshal(this);
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.BOUND_SHEET;
    }
}
