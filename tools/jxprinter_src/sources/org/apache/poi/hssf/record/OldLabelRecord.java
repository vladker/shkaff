package org.apache.poi.hssf.record;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.util.Unbox;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.HexDump;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.RecordFormatException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class OldLabelRecord extends OldCellRecord {
    private static final Logger LOG = LogManager.getLogger((Class<?>) OldLabelRecord.class);
    public static final short biff2_sid = 4;
    public static final short biff345_sid = 516;
    private CodepageRecord codepage;
    private short field_4_string_len;
    private final byte[] field_5_bytes;

    public OldLabelRecord(RecordInputStream recordInputStream) {
        super(recordInputStream, recordInputStream.getSid() == 4);
        if (isBiff2()) {
            this.field_4_string_len = (short) recordInputStream.readUByte();
        } else {
            this.field_4_string_len = recordInputStream.readShort();
        }
        byte[] bArrSafelyAllocate = IOUtils.safelyAllocate(this.field_4_string_len, HSSFWorkbook.getMaxRecordLength());
        this.field_5_bytes = bArrSafelyAllocate;
        recordInputStream.read(bArrSafelyAllocate, 0, this.field_4_string_len);
        if (recordInputStream.remaining() > 0) {
            LOG.atInfo().log("LabelRecord data remains: {} : {}", Unbox.box(recordInputStream.remaining()), HexDump.toHex(recordInputStream.readRemainder()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$0() {
        return super.getGenericProperties();
    }

    @Override // org.apache.poi.hssf.record.OldCellRecord, org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        final int i5 = 0;
        Supplier supplier = new Supplier(this) { // from class: org.apache.poi.hssf.record.t0
            public final /* synthetic */ OldLabelRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i5) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    case 1:
                        return Short.valueOf(this.b.getStringLength());
                    default:
                        return this.b.getValue();
                }
            }
        };
        final int i6 = 1;
        Supplier supplier2 = new Supplier(this) { // from class: org.apache.poi.hssf.record.t0
            public final /* synthetic */ OldLabelRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i6) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    case 1:
                        return Short.valueOf(this.b.getStringLength());
                    default:
                        return this.b.getValue();
                }
            }
        };
        final int i7 = 2;
        return GenericRecordUtil.getGenericProperties("base", supplier, "stringLength", supplier2, "value", new Supplier(this) { // from class: org.apache.poi.hssf.record.t0
            public final /* synthetic */ OldLabelRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i7) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    case 1:
                        return Short.valueOf(this.b.getStringLength());
                    default:
                        return this.b.getValue();
                }
            }
        });
    }

    public int getRecordSize() {
        throw new RecordFormatException("Old Label Records are supported READ ONLY");
    }

    public short getStringLength() {
        return this.field_4_string_len;
    }

    public String getValue() {
        return OldStringRecord.getString(this.field_5_bytes, this.codepage);
    }

    public int serialize(int i5, byte[] bArr) {
        throw new RecordFormatException("Old Label Records are supported READ ONLY");
    }

    public void setCodePage(CodepageRecord codepageRecord) {
        this.codepage = codepageRecord;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.LABEL;
    }
}
