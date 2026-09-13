package org.apache.poi.hssf.record;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.ss.formula.Formula;
import org.apache.poi.ss.formula.constant.ConstantValueParser;
import org.apache.poi.ss.formula.ptg.Ptg;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.LittleEndianOutput;
import org.apache.poi.util.StringUtil;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class ExternalNameRecord extends StandardRecord {
    private static final int[] OPTION_FLAGS = {1, 2, 4, 8, 16, 32768};
    private static final String[] OPTION_NAMES = {"BUILTIN_NAME", "AUTOMATIC_LINK", "PICTURE_LINK", "STD_DOCUMENT_NAME", "OLE_LINK", "ICONIFIED_PICTURE_LINK"};
    private static final int OPT_AUTOMATIC_LINK = 2;
    private static final int OPT_BUILTIN_NAME = 1;
    private static final int OPT_ICONIFIED_PICTURE_LINK = 32768;
    private static final int OPT_OLE_LINK = 16;
    private static final int OPT_PICTURE_LINK = 4;
    private static final int OPT_STD_DOCUMENT_NAME = 8;
    public static final short sid = 35;
    private Object[] _ddeValues;
    private int _nColumns;
    private int _nRows;
    private short field_1_option_flag;
    private short field_2_ixals;
    private short field_3_not_used;
    private String field_4_name;
    private Formula field_5_name_definition;

    public ExternalNameRecord() {
        this.field_2_ixals = (short) 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Number lambda$getGenericProperties$0() {
        return Short.valueOf(this.field_1_option_flag);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$getGenericProperties$1() {
        return null;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        int encodedSize = StringUtil.getEncodedSize(this.field_4_name);
        int i5 = encodedSize + 5;
        if (!isOLELink() && !isStdDocumentNameIdentifier()) {
            if (!isAutomaticLink()) {
                return this.field_5_name_definition.getEncodedSize() + i5;
            }
            Object[] objArr = this._ddeValues;
            if (objArr != null) {
                return ConstantValueParser.getEncodedSize(objArr) + encodedSize + 8;
            }
        }
        return i5;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        final int i5 = 0;
        Supplier<GenericRecordUtil.AnnotatedFlag> bitsAsString = GenericRecordUtil.getBitsAsString((Supplier<Number>) new Supplier(this) { // from class: org.apache.poi.hssf.record.J
            public final /* synthetic */ ExternalNameRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i5) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    case 1:
                        return Short.valueOf(this.b.getIx());
                    default:
                        return this.b.getText();
                }
            }
        }, OPTION_FLAGS, OPTION_NAMES);
        final int i6 = 1;
        Supplier supplier = new Supplier(this) { // from class: org.apache.poi.hssf.record.J
            public final /* synthetic */ ExternalNameRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i6) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    case 1:
                        return Short.valueOf(this.b.getIx());
                    default:
                        return this.b.getText();
                }
            }
        };
        final int i7 = 2;
        Supplier supplier2 = new Supplier(this) { // from class: org.apache.poi.hssf.record.J
            public final /* synthetic */ ExternalNameRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i7) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    case 1:
                        return Short.valueOf(this.b.getIx());
                    default:
                        return this.b.getText();
                }
            }
        };
        Formula formula = this.field_5_name_definition;
        return GenericRecordUtil.getGenericProperties("options", bitsAsString, "ix", supplier, "name", supplier2, "nameDefinition", formula == null ? new K(0) : new C1381b(formula, 12));
    }

    public short getIx() {
        return this.field_2_ixals;
    }

    public Ptg[] getParsedExpression() {
        return Formula.getTokens(this.field_5_name_definition);
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return (short) 35;
    }

    public String getText() {
        return this.field_4_name;
    }

    public boolean isAutomaticLink() {
        return (this.field_1_option_flag & 2) != 0;
    }

    public boolean isBuiltInName() {
        return (this.field_1_option_flag & 1) != 0;
    }

    public boolean isIconifiedPictureLink() {
        return (this.field_1_option_flag & Short.MIN_VALUE) != 0;
    }

    public boolean isOLELink() {
        return (this.field_1_option_flag & 16) != 0;
    }

    public boolean isPicureLink() {
        return (this.field_1_option_flag & 4) != 0;
    }

    public boolean isStdDocumentNameIdentifier() {
        return (this.field_1_option_flag & 8) != 0;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(this.field_1_option_flag);
        littleEndianOutput.writeShort(this.field_2_ixals);
        littleEndianOutput.writeShort(this.field_3_not_used);
        littleEndianOutput.writeByte(this.field_4_name.length());
        StringUtil.writeUnicodeStringFlagAndData(littleEndianOutput, this.field_4_name);
        if (isOLELink() || isStdDocumentNameIdentifier()) {
            return;
        }
        if (!isAutomaticLink()) {
            this.field_5_name_definition.serialize(littleEndianOutput);
        } else if (this._ddeValues != null) {
            littleEndianOutput.writeByte(this._nColumns - 1);
            littleEndianOutput.writeShort(this._nRows - 1);
            ConstantValueParser.encode(littleEndianOutput, this._ddeValues);
        }
    }

    public void setIx(short s6) {
        this.field_2_ixals = s6;
    }

    public void setParsedExpression(Ptg[] ptgArr) {
        this.field_5_name_definition = Formula.create(ptgArr);
    }

    public void setText(String str) {
        this.field_4_name = str;
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.EXTERNAL_NAME;
    }

    public ExternalNameRecord(ExternalNameRecord externalNameRecord) {
        super(externalNameRecord);
        this.field_1_option_flag = externalNameRecord.field_1_option_flag;
        this.field_2_ixals = externalNameRecord.field_2_ixals;
        this.field_3_not_used = externalNameRecord.field_3_not_used;
        this.field_4_name = externalNameRecord.field_4_name;
        Formula formula = externalNameRecord.field_5_name_definition;
        this.field_5_name_definition = formula == null ? null : formula.copy();
        Object[] objArr = externalNameRecord._ddeValues;
        this._ddeValues = objArr != null ? (Object[]) objArr.clone() : null;
        this._nColumns = externalNameRecord._nColumns;
        this._nRows = externalNameRecord._nRows;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord, org.apache.poi.hssf.record.Record, org.apache.poi.common.Duplicatable
    public ExternalNameRecord copy() {
        return new ExternalNameRecord(this);
    }

    public ExternalNameRecord(RecordInputStream recordInputStream) {
        this.field_1_option_flag = recordInputStream.readShort();
        this.field_2_ixals = recordInputStream.readShort();
        this.field_3_not_used = recordInputStream.readShort();
        this.field_4_name = StringUtil.readUnicodeString(recordInputStream, recordInputStream.readUByte());
        if (isOLELink() || isStdDocumentNameIdentifier()) {
            return;
        }
        if (isAutomaticLink()) {
            if (recordInputStream.available() > 0) {
                int uByte = recordInputStream.readUByte() + 1;
                int i5 = recordInputStream.readShort() + 1;
                this._ddeValues = ConstantValueParser.parse(recordInputStream, i5 * uByte);
                this._nColumns = uByte;
                this._nRows = i5;
                return;
            }
            return;
        }
        this.field_5_name_definition = Formula.read(recordInputStream.readUShort(), recordInputStream);
    }
}
