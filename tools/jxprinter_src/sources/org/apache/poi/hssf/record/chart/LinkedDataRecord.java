package org.apache.poi.hssf.record.chart;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.hssf.record.HSSFRecordTypes;
import org.apache.poi.hssf.record.RecordInputStream;
import org.apache.poi.hssf.record.StandardRecord;
import org.apache.poi.ss.formula.Formula;
import org.apache.poi.ss.formula.ptg.Ptg;
import org.apache.poi.util.BitField;
import org.apache.poi.util.BitFieldFactory;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class LinkedDataRecord extends StandardRecord {
    public static final byte LINK_TYPE_CATEGORIES = 2;
    public static final byte LINK_TYPE_SECONDARY_CATEGORIES = 3;
    public static final byte LINK_TYPE_TITLE_OR_TEXT = 0;
    public static final byte LINK_TYPE_VALUES = 1;
    public static final byte REFERENCE_TYPE_DEFAULT_CATEGORIES = 0;
    public static final byte REFERENCE_TYPE_DIRECT = 1;
    public static final byte REFERENCE_TYPE_ERROR_REPORTED = 4;
    public static final byte REFERENCE_TYPE_NOT_USED = 3;
    public static final byte REFERENCE_TYPE_WORKSHEET = 2;
    private static final BitField customNumberFormat = BitFieldFactory.getInstance(1);
    public static final short sid = 4177;
    private byte field_1_linkType;
    private byte field_2_referenceType;
    private short field_3_options;
    private short field_4_indexNumberFmtRecord;
    private Formula field_5_formulaOfLink;

    public LinkedDataRecord() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$0() {
        return this.field_5_formulaOfLink;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return this.field_5_formulaOfLink.getEncodedSize() + 6;
    }

    public Ptg[] getFormulaOfLink() {
        return this.field_5_formulaOfLink.getTokens();
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        final int i5 = 0;
        Supplier<GenericRecordUtil.AnnotatedFlag> enumBitsAsString = GenericRecordUtil.getEnumBitsAsString(new Supplier(this) { // from class: org.apache.poi.hssf.record.chart.A
            public final /* synthetic */ LinkedDataRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i5) {
                    case 0:
                        return Byte.valueOf(this.b.getLinkType());
                    case 1:
                        return Byte.valueOf(this.b.getReferenceType());
                    case 2:
                        return Short.valueOf(this.b.getOptions());
                    case 3:
                        return Boolean.valueOf(this.b.isCustomNumberFormat());
                    case 4:
                        return Short.valueOf(this.b.getIndexNumberFmtRecord());
                    default:
                        return this.b.lambda$getGenericProperties$0();
                }
            }
        }, new int[]{0, 1, 2, 3}, new String[]{"TITLE_OR_TEXT", "VALUES", "CATEGORIES", "SECONDARY_CATEGORIES"});
        final int i6 = 1;
        Supplier<GenericRecordUtil.AnnotatedFlag> enumBitsAsString2 = GenericRecordUtil.getEnumBitsAsString(new Supplier(this) { // from class: org.apache.poi.hssf.record.chart.A
            public final /* synthetic */ LinkedDataRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i6) {
                    case 0:
                        return Byte.valueOf(this.b.getLinkType());
                    case 1:
                        return Byte.valueOf(this.b.getReferenceType());
                    case 2:
                        return Short.valueOf(this.b.getOptions());
                    case 3:
                        return Boolean.valueOf(this.b.isCustomNumberFormat());
                    case 4:
                        return Short.valueOf(this.b.getIndexNumberFmtRecord());
                    default:
                        return this.b.lambda$getGenericProperties$0();
                }
            }
        }, new int[]{0, 1, 2, 3, 4}, new String[]{"DEFAULT_CATEGORIES", "DIRECT", "WORKSHEET", "NOT_USED", "ERROR_REPORTED"});
        final int i7 = 2;
        Supplier supplier = new Supplier(this) { // from class: org.apache.poi.hssf.record.chart.A
            public final /* synthetic */ LinkedDataRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i7) {
                    case 0:
                        return Byte.valueOf(this.b.getLinkType());
                    case 1:
                        return Byte.valueOf(this.b.getReferenceType());
                    case 2:
                        return Short.valueOf(this.b.getOptions());
                    case 3:
                        return Boolean.valueOf(this.b.isCustomNumberFormat());
                    case 4:
                        return Short.valueOf(this.b.getIndexNumberFmtRecord());
                    default:
                        return this.b.lambda$getGenericProperties$0();
                }
            }
        };
        final int i8 = 3;
        final int i9 = 4;
        final int i10 = 5;
        return GenericRecordUtil.getGenericProperties("linkType", enumBitsAsString, "referenceType", enumBitsAsString2, "options", supplier, "customNumberFormat", new Supplier(this) { // from class: org.apache.poi.hssf.record.chart.A
            public final /* synthetic */ LinkedDataRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i8) {
                    case 0:
                        return Byte.valueOf(this.b.getLinkType());
                    case 1:
                        return Byte.valueOf(this.b.getReferenceType());
                    case 2:
                        return Short.valueOf(this.b.getOptions());
                    case 3:
                        return Boolean.valueOf(this.b.isCustomNumberFormat());
                    case 4:
                        return Short.valueOf(this.b.getIndexNumberFmtRecord());
                    default:
                        return this.b.lambda$getGenericProperties$0();
                }
            }
        }, "indexNumberFmtRecord", new Supplier(this) { // from class: org.apache.poi.hssf.record.chart.A
            public final /* synthetic */ LinkedDataRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i9) {
                    case 0:
                        return Byte.valueOf(this.b.getLinkType());
                    case 1:
                        return Byte.valueOf(this.b.getReferenceType());
                    case 2:
                        return Short.valueOf(this.b.getOptions());
                    case 3:
                        return Boolean.valueOf(this.b.isCustomNumberFormat());
                    case 4:
                        return Short.valueOf(this.b.getIndexNumberFmtRecord());
                    default:
                        return this.b.lambda$getGenericProperties$0();
                }
            }
        }, "formulaOfLink", new Supplier(this) { // from class: org.apache.poi.hssf.record.chart.A
            public final /* synthetic */ LinkedDataRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i10) {
                    case 0:
                        return Byte.valueOf(this.b.getLinkType());
                    case 1:
                        return Byte.valueOf(this.b.getReferenceType());
                    case 2:
                        return Short.valueOf(this.b.getOptions());
                    case 3:
                        return Boolean.valueOf(this.b.isCustomNumberFormat());
                    case 4:
                        return Short.valueOf(this.b.getIndexNumberFmtRecord());
                    default:
                        return this.b.lambda$getGenericProperties$0();
                }
            }
        });
    }

    public short getIndexNumberFmtRecord() {
        return this.field_4_indexNumberFmtRecord;
    }

    public byte getLinkType() {
        return this.field_1_linkType;
    }

    public short getOptions() {
        return this.field_3_options;
    }

    public byte getReferenceType() {
        return this.field_2_referenceType;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return sid;
    }

    public boolean isCustomNumberFormat() {
        return customNumberFormat.isSet(this.field_3_options);
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeByte(this.field_1_linkType);
        littleEndianOutput.writeByte(this.field_2_referenceType);
        littleEndianOutput.writeShort(this.field_3_options);
        littleEndianOutput.writeShort(this.field_4_indexNumberFmtRecord);
        this.field_5_formulaOfLink.serialize(littleEndianOutput);
    }

    public void setCustomNumberFormat(boolean z6) {
        this.field_3_options = customNumberFormat.setShortBoolean(this.field_3_options, z6);
    }

    public void setFormulaOfLink(Ptg[] ptgArr) {
        this.field_5_formulaOfLink = Formula.create(ptgArr);
    }

    public void setIndexNumberFmtRecord(short s6) {
        this.field_4_indexNumberFmtRecord = s6;
    }

    public void setLinkType(byte b) {
        this.field_1_linkType = b;
    }

    public void setOptions(short s6) {
        this.field_3_options = s6;
    }

    public void setReferenceType(byte b) {
        this.field_2_referenceType = b;
    }

    public LinkedDataRecord(LinkedDataRecord linkedDataRecord) {
        super(linkedDataRecord);
        this.field_1_linkType = linkedDataRecord.field_1_linkType;
        this.field_2_referenceType = linkedDataRecord.field_2_referenceType;
        this.field_3_options = linkedDataRecord.field_3_options;
        this.field_4_indexNumberFmtRecord = linkedDataRecord.field_4_indexNumberFmtRecord;
        Formula formula = linkedDataRecord.field_5_formulaOfLink;
        this.field_5_formulaOfLink = formula == null ? null : formula.copy();
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.LINKED_DATA;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord, org.apache.poi.hssf.record.Record, org.apache.poi.common.Duplicatable
    public LinkedDataRecord copy() {
        return new LinkedDataRecord(this);
    }

    public LinkedDataRecord(RecordInputStream recordInputStream) {
        this.field_1_linkType = recordInputStream.readByte();
        this.field_2_referenceType = recordInputStream.readByte();
        this.field_3_options = recordInputStream.readShort();
        this.field_4_indexNumberFmtRecord = recordInputStream.readShort();
        this.field_5_formulaOfLink = Formula.read(recordInputStream.readUShort(), recordInputStream);
    }
}
