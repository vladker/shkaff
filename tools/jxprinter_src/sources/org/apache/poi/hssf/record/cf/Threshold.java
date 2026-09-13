package org.apache.poi.hssf.record.cf;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.common.usermodel.GenericRecord;
import org.apache.poi.hssf.record.cf.Threshold;
import org.apache.poi.ss.formula.Formula;
import org.apache.poi.ss.formula.ptg.Ptg;
import org.apache.poi.ss.usermodel.ConditionalFormattingThreshold;
import org.apache.poi.util.GenericRecordJsonWriter;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.LittleEndianInput;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class Threshold implements GenericRecord {
    private Formula formula;
    private byte type;
    private Double value;

    public Threshold() {
        this.type = (byte) ConditionalFormattingThreshold.RangeType.NUMBER.id;
        this.formula = Formula.create(null);
        this.value = Double.valueOf(0.0d);
    }

    public abstract Threshold copy();

    public int getDataLength() {
        int encodedSize = this.formula.getEncodedSize();
        return this.value != null ? encodedSize + 9 : encodedSize + 1;
    }

    public Formula getFormula() {
        return this.formula;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        final int i5 = 0;
        Supplier supplier = new Supplier(this) { // from class: H4.i
            public final /* synthetic */ Threshold b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i5) {
                    case 0:
                        return Byte.valueOf(this.b.getType());
                    case 1:
                        return this.b.getFormula();
                    default:
                        return this.b.getValue();
                }
            }
        };
        final int i6 = 1;
        Supplier supplier2 = new Supplier(this) { // from class: H4.i
            public final /* synthetic */ Threshold b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i6) {
                    case 0:
                        return Byte.valueOf(this.b.getType());
                    case 1:
                        return this.b.getFormula();
                    default:
                        return this.b.getValue();
                }
            }
        };
        final int i7 = 2;
        return GenericRecordUtil.getGenericProperties("type", supplier, "formula", supplier2, "value", new Supplier(this) { // from class: H4.i
            public final /* synthetic */ Threshold b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i7) {
                    case 0:
                        return Byte.valueOf(this.b.getType());
                    case 1:
                        return this.b.getFormula();
                    default:
                        return this.b.getValue();
                }
            }
        });
    }

    public Ptg[] getParsedExpression() {
        return this.formula.getTokens();
    }

    public byte getType() {
        return this.type;
    }

    public Double getValue() {
        return this.value;
    }

    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeByte(this.type);
        if (this.formula.getTokens().length == 0) {
            littleEndianOutput.writeShort(0);
        } else {
            this.formula.serialize(littleEndianOutput);
        }
        Double d = this.value;
        if (d != null) {
            littleEndianOutput.writeDouble(d.doubleValue());
        }
    }

    public void setParsedExpression(Ptg[] ptgArr) {
        this.formula = Formula.create(ptgArr);
        if (ptgArr.length > 0) {
            this.value = null;
        }
    }

    public void setType(byte b) {
        this.type = b;
        if (b == ConditionalFormattingThreshold.RangeType.MIN.id || b == ConditionalFormattingThreshold.RangeType.MAX.id || b == ConditionalFormattingThreshold.RangeType.FORMULA.id) {
            this.value = null;
        } else if (this.value == null) {
            this.value = Double.valueOf(0.0d);
        }
    }

    public void setValue(Double d) {
        this.value = d;
    }

    public String toString() {
        return GenericRecordJsonWriter.marshal(this);
    }

    public Threshold(Threshold threshold) {
        this.type = threshold.type;
        this.formula = threshold.formula.copy();
        this.value = threshold.value;
    }

    public void setType(int i5) {
        this.type = (byte) i5;
    }

    public Threshold(LittleEndianInput littleEndianInput) {
        byte b;
        this.type = littleEndianInput.readByte();
        short s6 = littleEndianInput.readShort();
        if (s6 > 0) {
            this.formula = Formula.read(s6, littleEndianInput);
        } else {
            this.formula = Formula.create(null);
        }
        if (s6 != 0 || (b = this.type) == ConditionalFormattingThreshold.RangeType.MIN.id || b == ConditionalFormattingThreshold.RangeType.MAX.id) {
            return;
        }
        this.value = Double.valueOf(littleEndianInput.readDouble());
    }
}
