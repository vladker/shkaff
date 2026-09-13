package org.apache.poi.hssf.record;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.ss.formula.Formula;
import org.apache.poi.ss.formula.ptg.Ptg;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.util.BitField;
import org.apache.poi.util.BitFieldFactory;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.LittleEndianOutput;
import org.apache.poi.util.Removal;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class FormulaRecord extends CellRecord {
    private static final int FIXED_SIZE = 14;
    private static final BitField alwaysCalc = BitFieldFactory.getInstance(1);
    private static final BitField calcOnLoad = BitFieldFactory.getInstance(2);
    private static final BitField sharedFormula = BitFieldFactory.getInstance(8);
    public static final short sid = 6;
    private double field_4_value;
    private short field_5_options;
    private int field_6_zero;
    private Formula field_8_parsed_expr;
    private FormulaSpecialCachedValue specialCachedValue;

    public FormulaRecord() {
        this.field_8_parsed_expr = Formula.create(Ptg.EMPTY_PTG_ARRAY);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$0() {
        return super.getGenericProperties();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$1() {
        return Integer.valueOf(this.field_6_zero);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$2() {
        FormulaSpecialCachedValue formulaSpecialCachedValue = this.specialCachedValue;
        return formulaSpecialCachedValue == null ? Double.valueOf(this.field_4_value) : formulaSpecialCachedValue;
    }

    public boolean getCachedBooleanValue() {
        return this.specialCachedValue.getBooleanValue();
    }

    public int getCachedErrorValue() {
        return this.specialCachedValue.getErrorValue();
    }

    @Removal(version = "6.0.0")
    @Deprecated
    public int getCachedResultType() {
        FormulaSpecialCachedValue formulaSpecialCachedValue = this.specialCachedValue;
        return formulaSpecialCachedValue == null ? CellType.NUMERIC.getCode() : formulaSpecialCachedValue.getValueType();
    }

    public CellType getCachedResultTypeEnum() {
        FormulaSpecialCachedValue formulaSpecialCachedValue = this.specialCachedValue;
        return formulaSpecialCachedValue == null ? CellType.NUMERIC : formulaSpecialCachedValue.getValueTypeEnum();
    }

    public Formula getFormula() {
        return this.field_8_parsed_expr;
    }

    @Override // org.apache.poi.hssf.record.CellRecord, org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        final int i5 = 0;
        Supplier supplier = new Supplier(this) { // from class: org.apache.poi.hssf.record.S
            public final /* synthetic */ FormulaRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i5) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    case 1:
                        return Short.valueOf(this.b.getOptions());
                    case 2:
                        return Boolean.valueOf(this.b.isAlwaysCalc());
                    case 3:
                        return Boolean.valueOf(this.b.isCalcOnLoad());
                    case 4:
                        return Boolean.valueOf(this.b.isSharedFormula());
                    case 5:
                        return this.b.lambda$getGenericProperties$1();
                    case 6:
                        return this.b.lambda$getGenericProperties$2();
                    default:
                        return this.b.getFormula();
                }
            }
        };
        final int i6 = 1;
        Supplier supplier2 = new Supplier(this) { // from class: org.apache.poi.hssf.record.S
            public final /* synthetic */ FormulaRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i6) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    case 1:
                        return Short.valueOf(this.b.getOptions());
                    case 2:
                        return Boolean.valueOf(this.b.isAlwaysCalc());
                    case 3:
                        return Boolean.valueOf(this.b.isCalcOnLoad());
                    case 4:
                        return Boolean.valueOf(this.b.isSharedFormula());
                    case 5:
                        return this.b.lambda$getGenericProperties$1();
                    case 6:
                        return this.b.lambda$getGenericProperties$2();
                    default:
                        return this.b.getFormula();
                }
            }
        };
        final int i7 = 2;
        Supplier supplier3 = new Supplier(this) { // from class: org.apache.poi.hssf.record.S
            public final /* synthetic */ FormulaRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i7) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    case 1:
                        return Short.valueOf(this.b.getOptions());
                    case 2:
                        return Boolean.valueOf(this.b.isAlwaysCalc());
                    case 3:
                        return Boolean.valueOf(this.b.isCalcOnLoad());
                    case 4:
                        return Boolean.valueOf(this.b.isSharedFormula());
                    case 5:
                        return this.b.lambda$getGenericProperties$1();
                    case 6:
                        return this.b.lambda$getGenericProperties$2();
                    default:
                        return this.b.getFormula();
                }
            }
        };
        final int i8 = 3;
        Supplier supplier4 = new Supplier(this) { // from class: org.apache.poi.hssf.record.S
            public final /* synthetic */ FormulaRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i8) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    case 1:
                        return Short.valueOf(this.b.getOptions());
                    case 2:
                        return Boolean.valueOf(this.b.isAlwaysCalc());
                    case 3:
                        return Boolean.valueOf(this.b.isCalcOnLoad());
                    case 4:
                        return Boolean.valueOf(this.b.isSharedFormula());
                    case 5:
                        return this.b.lambda$getGenericProperties$1();
                    case 6:
                        return this.b.lambda$getGenericProperties$2();
                    default:
                        return this.b.getFormula();
                }
            }
        };
        final int i9 = 4;
        Supplier supplier5 = new Supplier(this) { // from class: org.apache.poi.hssf.record.S
            public final /* synthetic */ FormulaRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i9) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    case 1:
                        return Short.valueOf(this.b.getOptions());
                    case 2:
                        return Boolean.valueOf(this.b.isAlwaysCalc());
                    case 3:
                        return Boolean.valueOf(this.b.isCalcOnLoad());
                    case 4:
                        return Boolean.valueOf(this.b.isSharedFormula());
                    case 5:
                        return this.b.lambda$getGenericProperties$1();
                    case 6:
                        return this.b.lambda$getGenericProperties$2();
                    default:
                        return this.b.getFormula();
                }
            }
        };
        final int i10 = 5;
        Supplier supplier6 = new Supplier(this) { // from class: org.apache.poi.hssf.record.S
            public final /* synthetic */ FormulaRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i10) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    case 1:
                        return Short.valueOf(this.b.getOptions());
                    case 2:
                        return Boolean.valueOf(this.b.isAlwaysCalc());
                    case 3:
                        return Boolean.valueOf(this.b.isCalcOnLoad());
                    case 4:
                        return Boolean.valueOf(this.b.isSharedFormula());
                    case 5:
                        return this.b.lambda$getGenericProperties$1();
                    case 6:
                        return this.b.lambda$getGenericProperties$2();
                    default:
                        return this.b.getFormula();
                }
            }
        };
        final int i11 = 6;
        final int i12 = 7;
        return GenericRecordUtil.getGenericProperties("base", supplier, "options", supplier2, "alwaysCalc", supplier3, "calcOnLoad", supplier4, "shared", supplier5, "zero", supplier6, "value", new Supplier(this) { // from class: org.apache.poi.hssf.record.S
            public final /* synthetic */ FormulaRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i11) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    case 1:
                        return Short.valueOf(this.b.getOptions());
                    case 2:
                        return Boolean.valueOf(this.b.isAlwaysCalc());
                    case 3:
                        return Boolean.valueOf(this.b.isCalcOnLoad());
                    case 4:
                        return Boolean.valueOf(this.b.isSharedFormula());
                    case 5:
                        return this.b.lambda$getGenericProperties$1();
                    case 6:
                        return this.b.lambda$getGenericProperties$2();
                    default:
                        return this.b.getFormula();
                }
            }
        }, "formula", new Supplier(this) { // from class: org.apache.poi.hssf.record.S
            public final /* synthetic */ FormulaRecord b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i12) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    case 1:
                        return Short.valueOf(this.b.getOptions());
                    case 2:
                        return Boolean.valueOf(this.b.isAlwaysCalc());
                    case 3:
                        return Boolean.valueOf(this.b.isCalcOnLoad());
                    case 4:
                        return Boolean.valueOf(this.b.isSharedFormula());
                    case 5:
                        return this.b.lambda$getGenericProperties$1();
                    case 6:
                        return this.b.lambda$getGenericProperties$2();
                    default:
                        return this.b.getFormula();
                }
            }
        });
    }

    public short getOptions() {
        return this.field_5_options;
    }

    public Ptg[] getParsedExpression() {
        return this.field_8_parsed_expr.getTokens();
    }

    @Override // org.apache.poi.hssf.record.CellRecord
    public String getRecordName() {
        return "FORMULA";
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return (short) 6;
    }

    public double getValue() {
        return this.field_4_value;
    }

    @Override // org.apache.poi.hssf.record.CellRecord
    public int getValueDataSize() {
        return this.field_8_parsed_expr.getEncodedSize() + 14;
    }

    public boolean hasCachedResultString() {
        FormulaSpecialCachedValue formulaSpecialCachedValue = this.specialCachedValue;
        return formulaSpecialCachedValue != null && formulaSpecialCachedValue.getTypeCode() == 0;
    }

    public boolean isAlwaysCalc() {
        return alwaysCalc.isSet(this.field_5_options);
    }

    public boolean isCalcOnLoad() {
        return calcOnLoad.isSet(this.field_5_options);
    }

    public boolean isSharedFormula() {
        return sharedFormula.isSet(this.field_5_options);
    }

    @Override // org.apache.poi.hssf.record.CellRecord
    public void serializeValue(LittleEndianOutput littleEndianOutput) {
        FormulaSpecialCachedValue formulaSpecialCachedValue = this.specialCachedValue;
        if (formulaSpecialCachedValue == null) {
            littleEndianOutput.writeDouble(this.field_4_value);
        } else {
            formulaSpecialCachedValue.serialize(littleEndianOutput);
        }
        littleEndianOutput.writeShort(getOptions());
        littleEndianOutput.writeInt(this.field_6_zero);
        this.field_8_parsed_expr.serialize(littleEndianOutput);
    }

    public void setAlwaysCalc(boolean z6) {
        this.field_5_options = alwaysCalc.setShortBoolean(this.field_5_options, z6);
    }

    public void setCachedResultBoolean(boolean z6) {
        this.specialCachedValue = FormulaSpecialCachedValue.createCachedBoolean(z6);
    }

    public void setCachedResultErrorCode(int i5) {
        this.specialCachedValue = FormulaSpecialCachedValue.createCachedErrorCode(i5);
    }

    public void setCachedResultTypeEmptyString() {
        this.specialCachedValue = FormulaSpecialCachedValue.createCachedEmptyValue();
    }

    public void setCachedResultTypeString() {
        this.specialCachedValue = FormulaSpecialCachedValue.createForString();
    }

    public void setCalcOnLoad(boolean z6) {
        this.field_5_options = calcOnLoad.setShortBoolean(this.field_5_options, z6);
    }

    public void setOptions(short s6) {
        this.field_5_options = s6;
    }

    public void setParsedExpression(Ptg[] ptgArr) {
        this.field_8_parsed_expr = Formula.create(ptgArr);
    }

    public void setSharedFormula(boolean z6) {
        this.field_5_options = sharedFormula.setShortBoolean(this.field_5_options, z6);
    }

    public void setValue(double d) {
        this.field_4_value = d;
        this.specialCachedValue = null;
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.FORMULA;
    }

    public FormulaRecord(FormulaRecord formulaRecord) {
        super(formulaRecord);
        this.field_4_value = formulaRecord.field_4_value;
        this.field_5_options = formulaRecord.field_5_options;
        this.field_6_zero = formulaRecord.field_6_zero;
        this.field_8_parsed_expr = formulaRecord.field_8_parsed_expr == null ? null : new Formula(formulaRecord.field_8_parsed_expr);
        FormulaSpecialCachedValue formulaSpecialCachedValue = formulaRecord.specialCachedValue;
        this.specialCachedValue = formulaSpecialCachedValue != null ? new FormulaSpecialCachedValue(formulaSpecialCachedValue) : null;
    }

    @Override // org.apache.poi.hssf.record.CellRecord, org.apache.poi.hssf.record.StandardRecord, org.apache.poi.hssf.record.Record, org.apache.poi.common.Duplicatable
    public FormulaRecord copy() {
        return new FormulaRecord(this);
    }

    public FormulaRecord(RecordInputStream recordInputStream) {
        super(recordInputStream);
        long j6 = recordInputStream.readLong();
        this.field_5_options = recordInputStream.readShort();
        FormulaSpecialCachedValue formulaSpecialCachedValueCreate = FormulaSpecialCachedValue.create(j6);
        this.specialCachedValue = formulaSpecialCachedValueCreate;
        if (formulaSpecialCachedValueCreate == null) {
            this.field_4_value = Double.longBitsToDouble(j6);
        }
        this.field_6_zero = recordInputStream.readInt();
        this.field_8_parsed_expr = Formula.read(recordInputStream.readShort(), recordInputStream, recordInputStream.available());
    }
}
