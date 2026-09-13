package org.apache.poi.ss.formula.ptg;

import A3.AbstractC0157z;
import java.lang.reflect.Array;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.commons.math3.geometry.VectorFormat;
import org.apache.poi.ss.formula.constant.ConstantValueParser;
import org.apache.poi.ss.formula.constant.ErrorConstant;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class ArrayPtg extends Ptg {
    public static final int PLAIN_TOKEN_SIZE = 8;
    private static final int RESERVED_FIELD_LEN = 7;
    public static final byte sid = 32;
    private final Object[] _arrayValues;
    private final int _nColumns;
    private final int _nRows;
    private final int _reserved0Int;
    private final int _reserved1Short;
    private final int _reserved2Byte;

    public ArrayPtg(int i5, int i6, int i7, int i8, int i9, Object[] objArr) {
        this._reserved0Int = i5;
        this._reserved1Short = i6;
        this._reserved2Byte = i7;
        this._nColumns = i8;
        this._nRows = i9;
        this._arrayValues = (Object[]) objArr.clone();
    }

    private static String getConstantText(Object obj) {
        if (obj == null) {
            throw new RuntimeException("Array item cannot be null");
        }
        if (obj instanceof String) {
            return "\"" + obj + "\"";
        }
        if (obj instanceof Double) {
            return NumberToTextConverter.toText(((Double) obj).doubleValue());
        }
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue() ? "TRUE" : "FALSE";
        }
        if (obj instanceof ErrorConstant) {
            return ((ErrorConstant) obj).getText();
        }
        throw new IllegalArgumentException("Unexpected constant class (" + obj.getClass().getName() + ")");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$0() {
        return Integer.valueOf(this._reserved0Int);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$1() {
        return Integer.valueOf(this._reserved1Short);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$2() {
        return Integer.valueOf(this._reserved2Byte);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$3() {
        return this._arrayValues == null ? "#values#uninitialised#" : toFormulaString();
    }

    public int getColumnCount() {
        return this._nColumns;
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public byte getDefaultOperandClass() {
        return (byte) 64;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        final int i5 = 0;
        Supplier supplier = new Supplier(this) { // from class: org.apache.poi.ss.formula.ptg.g
            public final /* synthetic */ ArrayPtg b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i5) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    case 1:
                        return this.b.lambda$getGenericProperties$1();
                    case 2:
                        return this.b.lambda$getGenericProperties$2();
                    case 3:
                        return Integer.valueOf(this.b.getColumnCount());
                    case 4:
                        return Integer.valueOf(this.b.getRowCount());
                    default:
                        return this.b.lambda$getGenericProperties$3();
                }
            }
        };
        final int i6 = 1;
        Supplier supplier2 = new Supplier(this) { // from class: org.apache.poi.ss.formula.ptg.g
            public final /* synthetic */ ArrayPtg b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i6) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    case 1:
                        return this.b.lambda$getGenericProperties$1();
                    case 2:
                        return this.b.lambda$getGenericProperties$2();
                    case 3:
                        return Integer.valueOf(this.b.getColumnCount());
                    case 4:
                        return Integer.valueOf(this.b.getRowCount());
                    default:
                        return this.b.lambda$getGenericProperties$3();
                }
            }
        };
        final int i7 = 2;
        Supplier supplier3 = new Supplier(this) { // from class: org.apache.poi.ss.formula.ptg.g
            public final /* synthetic */ ArrayPtg b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i7) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    case 1:
                        return this.b.lambda$getGenericProperties$1();
                    case 2:
                        return this.b.lambda$getGenericProperties$2();
                    case 3:
                        return Integer.valueOf(this.b.getColumnCount());
                    case 4:
                        return Integer.valueOf(this.b.getRowCount());
                    default:
                        return this.b.lambda$getGenericProperties$3();
                }
            }
        };
        final int i8 = 3;
        Supplier supplier4 = new Supplier(this) { // from class: org.apache.poi.ss.formula.ptg.g
            public final /* synthetic */ ArrayPtg b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i8) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    case 1:
                        return this.b.lambda$getGenericProperties$1();
                    case 2:
                        return this.b.lambda$getGenericProperties$2();
                    case 3:
                        return Integer.valueOf(this.b.getColumnCount());
                    case 4:
                        return Integer.valueOf(this.b.getRowCount());
                    default:
                        return this.b.lambda$getGenericProperties$3();
                }
            }
        };
        final int i9 = 4;
        Supplier supplier5 = new Supplier(this) { // from class: org.apache.poi.ss.formula.ptg.g
            public final /* synthetic */ ArrayPtg b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i9) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    case 1:
                        return this.b.lambda$getGenericProperties$1();
                    case 2:
                        return this.b.lambda$getGenericProperties$2();
                    case 3:
                        return Integer.valueOf(this.b.getColumnCount());
                    case 4:
                        return Integer.valueOf(this.b.getRowCount());
                    default:
                        return this.b.lambda$getGenericProperties$3();
                }
            }
        };
        final int i10 = 5;
        return GenericRecordUtil.getGenericProperties("reserved0", supplier, "reserved1", supplier2, "reserved2", supplier3, "columnCount", supplier4, "rowCount", supplier5, "arrayValues", new Supplier(this) { // from class: org.apache.poi.ss.formula.ptg.g
            public final /* synthetic */ ArrayPtg b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i10) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    case 1:
                        return this.b.lambda$getGenericProperties$1();
                    case 2:
                        return this.b.lambda$getGenericProperties$2();
                    case 3:
                        return Integer.valueOf(this.b.getColumnCount());
                    case 4:
                        return Integer.valueOf(this.b.getRowCount());
                    default:
                        return this.b.lambda$getGenericProperties$3();
                }
            }
        });
    }

    public int getRowCount() {
        return this._nRows;
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public byte getSid() {
        return (byte) 32;
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public int getSize() {
        return ConstantValueParser.getEncodedSize(this._arrayValues) + 11;
    }

    public Object[][] getTokenArrayValues() {
        if (this._arrayValues == null) {
            throw new IllegalStateException("array values not read yet");
        }
        Object[][] objArr = (Object[][]) Array.newInstance((Class<?>) Object.class, this._nRows, this._nColumns);
        for (int i5 = 0; i5 < this._nRows; i5++) {
            Object[] objArr2 = objArr[i5];
            for (int i6 = 0; i6 < this._nColumns; i6++) {
                objArr2[i6] = this._arrayValues[getValueIndex(i6, i5)];
            }
        }
        return objArr;
    }

    public int getValueIndex(int i5, int i6) {
        int i7;
        if (i5 < 0 || i5 >= (i7 = this._nColumns)) {
            StringBuilder sbT = AbstractC0157z.t(i5, "Specified colIx (", ") is outside the allowed range (0..");
            sbT.append(this._nColumns - 1);
            sbT.append(")");
            throw new IllegalArgumentException(sbT.toString());
        }
        if (i6 >= 0 && i6 < this._nRows) {
            return (i6 * i7) + i5;
        }
        StringBuilder sbT2 = AbstractC0157z.t(i6, "Specified rowIx (", ") is outside the allowed range (0..");
        sbT2.append(this._nRows - 1);
        sbT2.append(")");
        throw new IllegalArgumentException(sbT2.toString());
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public boolean isBaseToken() {
        return false;
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public String toFormulaString() {
        StringBuilder sb = new StringBuilder(VectorFormat.DEFAULT_PREFIX);
        for (int i5 = 0; i5 < this._nRows; i5++) {
            if (i5 > 0) {
                sb.append(";");
            }
            for (int i6 = 0; i6 < this._nColumns; i6++) {
                if (i6 > 0) {
                    sb.append(",");
                }
                sb.append(getConstantText(this._arrayValues[getValueIndex(i6, i5)]));
            }
        }
        sb.append(VectorFormat.DEFAULT_SUFFIX);
        return sb.toString();
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public void write(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeByte(getPtgClass() + 32);
        littleEndianOutput.writeInt(this._reserved0Int);
        littleEndianOutput.writeShort(this._reserved1Short);
        littleEndianOutput.writeByte(this._reserved2Byte);
    }

    public int writeTokenValueBytes(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeByte(this._nColumns - 1);
        littleEndianOutput.writeShort(this._nRows - 1);
        ConstantValueParser.encode(littleEndianOutput, this._arrayValues);
        return ConstantValueParser.getEncodedSize(this._arrayValues) + 3;
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg, org.apache.poi.common.Duplicatable
    public ArrayPtg copy() {
        return new ArrayPtg(this);
    }

    public ArrayPtg(ArrayPtg arrayPtg) {
        this._reserved0Int = arrayPtg._reserved0Int;
        this._reserved1Short = arrayPtg._reserved1Short;
        this._reserved2Byte = arrayPtg._reserved2Byte;
        this._nColumns = arrayPtg._nColumns;
        this._nRows = arrayPtg._nRows;
        Object[] objArr = arrayPtg._arrayValues;
        this._arrayValues = objArr == null ? null : (Object[]) objArr.clone();
    }

    public ArrayPtg(Object[][] objArr) {
        int length = objArr[0].length;
        int length2 = objArr.length;
        short s6 = (short) length;
        this._nColumns = s6;
        short s7 = (short) length2;
        this._nRows = s7;
        Object[] objArr2 = new Object[s6 * s7];
        for (int i5 = 0; i5 < length2; i5++) {
            Object[] objArr3 = objArr[i5];
            for (int i6 = 0; i6 < length; i6++) {
                objArr2[getValueIndex(i6, i5)] = objArr3[i6];
            }
        }
        this._arrayValues = objArr2;
        this._reserved0Int = 0;
        this._reserved1Short = 0;
        this._reserved2Byte = 0;
    }
}
