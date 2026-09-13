package org.apache.poi.hssf.record;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.ss.formula.Formula;
import org.apache.poi.ss.formula.ptg.Ptg;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.util.GenericRecordUtil;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class OldFormulaRecord extends OldCellRecord {
    public static final short biff2_sid = 6;
    public static final short biff3_sid = 518;
    public static final short biff4_sid = 1030;
    public static final short biff5_sid = 6;
    private double field_4_value;
    private short field_5_options;
    private Formula field_6_parsed_expr;
    private FormulaSpecialCachedValue specialCachedValue;

    public OldFormulaRecord(RecordInputStream recordInputStream) {
        super(recordInputStream, recordInputStream.getSid() == 6);
        if (isBiff2()) {
            this.field_4_value = recordInputStream.readDouble();
        } else {
            long j6 = recordInputStream.readLong();
            FormulaSpecialCachedValue formulaSpecialCachedValueCreate = FormulaSpecialCachedValue.create(j6);
            this.specialCachedValue = formulaSpecialCachedValueCreate;
            if (formulaSpecialCachedValueCreate == null) {
                this.field_4_value = Double.longBitsToDouble(j6);
            }
        }
        if (isBiff2()) {
            this.field_5_options = (short) recordInputStream.readUByte();
        } else {
            this.field_5_options = recordInputStream.readShort();
        }
        this.field_6_parsed_expr = Formula.read(recordInputStream.readShort(), recordInputStream, recordInputStream.available());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$0() {
        return super.getGenericProperties();
    }

    public boolean getCachedBooleanValue() {
        return this.specialCachedValue.getBooleanValue();
    }

    public int getCachedErrorValue() {
        return this.specialCachedValue.getErrorValue();
    }

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
        return this.field_6_parsed_expr;
    }

    @Override // org.apache.poi.hssf.record.OldCellRecord, org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        final int i5 = 0;
        Supplier supplier = new Supplier(this) { // from class: org.apache.poi.hssf.record.s0
            public final /* synthetic */ OldFormulaRecord b;

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
                        return this.b.getFormula();
                    default:
                        return Double.valueOf(this.b.getValue());
                }
            }
        };
        final int i6 = 1;
        Supplier supplier2 = new Supplier(this) { // from class: org.apache.poi.hssf.record.s0
            public final /* synthetic */ OldFormulaRecord b;

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
                        return this.b.getFormula();
                    default:
                        return Double.valueOf(this.b.getValue());
                }
            }
        };
        final int i7 = 2;
        Supplier supplier3 = new Supplier(this) { // from class: org.apache.poi.hssf.record.s0
            public final /* synthetic */ OldFormulaRecord b;

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
                        return this.b.getFormula();
                    default:
                        return Double.valueOf(this.b.getValue());
                }
            }
        };
        final int i8 = 3;
        return GenericRecordUtil.getGenericProperties("base", supplier, "options", supplier2, "formula", supplier3, "value", new Supplier(this) { // from class: org.apache.poi.hssf.record.s0
            public final /* synthetic */ OldFormulaRecord b;

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
                        return this.b.getFormula();
                    default:
                        return Double.valueOf(this.b.getValue());
                }
            }
        });
    }

    public short getOptions() {
        return this.field_5_options;
    }

    public Ptg[] getParsedExpression() {
        return this.field_6_parsed_expr.getTokens();
    }

    public double getValue() {
        return this.field_4_value;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.FORMULA;
    }
}
