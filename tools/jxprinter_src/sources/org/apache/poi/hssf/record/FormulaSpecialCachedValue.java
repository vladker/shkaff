package org.apache.poi.hssf.record;

import A3.AbstractC0157z;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.logging.log4j.util.Chars;
import org.apache.poi.common.usermodel.GenericRecord;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.HexDump;
import org.apache.poi.util.Internal;
import org.apache.poi.util.LittleEndianOutput;
import org.apache.poi.util.RecordFormatException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Internal
public final class FormulaSpecialCachedValue implements GenericRecord {
    private static final long BIT_MARKER = -281474976710656L;
    public static final int BOOLEAN = 1;
    private static final int DATA_INDEX = 2;
    public static final int EMPTY = 3;
    public static final int ERROR_CODE = 2;
    public static final int STRING = 0;
    private static final int VARIABLE_DATA_LENGTH = 6;
    private final byte[] _variableData;

    public FormulaSpecialCachedValue(FormulaSpecialCachedValue formulaSpecialCachedValue) {
        byte[] bArr = formulaSpecialCachedValue._variableData;
        this._variableData = bArr == null ? null : (byte[]) bArr.clone();
    }

    public static FormulaSpecialCachedValue create(long j6) {
        if ((j6 & BIT_MARKER) != BIT_MARKER) {
            return null;
        }
        byte[] bArr = new byte[6];
        for (int i5 = 0; i5 < 6; i5++) {
            bArr[i5] = (byte) j6;
            j6 >>= 8;
        }
        byte b = bArr[0];
        if (b == 0 || b == 1 || b == 2 || b == 3) {
            return new FormulaSpecialCachedValue(bArr);
        }
        throw new RecordFormatException(AbstractC0157z.l(")", bArr[0], new StringBuilder("Bad special value code (")));
    }

    public static FormulaSpecialCachedValue createCachedBoolean(boolean z6) {
        return create(1, z6 ? 1 : 0);
    }

    public static FormulaSpecialCachedValue createCachedEmptyValue() {
        return create(3, 0);
    }

    public static FormulaSpecialCachedValue createCachedErrorCode(int i5) {
        return create(2, i5);
    }

    public static FormulaSpecialCachedValue createForString() {
        return create(0, 0);
    }

    private String formatValue() {
        int typeCode = getTypeCode();
        if (typeCode == 0) {
            return "<string>";
        }
        if (typeCode == 1) {
            return getDataValue() == 0 ? "FALSE" : "TRUE";
        }
        if (typeCode != 2) {
            return typeCode != 3 ? androidx.collection.a.i(typeCode, "#error(type=", ")#") : "<empty>";
        }
        return ErrorEval.getText(getDataValue());
    }

    private int getDataValue() {
        return this._variableData[2];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object getGenericValue() {
        int typeCode = getTypeCode();
        if (typeCode == 0) {
            return TypedValues.Custom.S_STRING;
        }
        if (typeCode == 1) {
            return Boolean.valueOf(getBooleanValue());
        }
        if (typeCode == 2) {
            return Integer.valueOf(getErrorValue());
        }
        if (typeCode == 3) {
            return null;
        }
        throw new IllegalStateException(androidx.collection.a.i(typeCode, "Unexpected type id (", ")"));
    }

    public String formatDebugString() {
        return formatValue() + Chars.SPACE + HexDump.toHex(this._variableData);
    }

    public boolean getBooleanValue() {
        if (getTypeCode() == 1) {
            return getDataValue() != 0;
        }
        throw new IllegalStateException("Not a boolean cached value - " + formatValue());
    }

    public int getErrorValue() {
        if (getTypeCode() == 2) {
            return getDataValue();
        }
        throw new IllegalStateException("Not an error cached value - " + formatValue());
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        final int i5 = 0;
        final int i6 = 1;
        return GenericRecordUtil.getGenericProperties("value", new Supplier(this) { // from class: org.apache.poi.hssf.record.T
            public final /* synthetic */ FormulaSpecialCachedValue b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i5) {
                    case 0:
                        return this.b.getGenericValue();
                    default:
                        return Integer.valueOf(this.b.getTypeCode());
                }
            }
        }, "typeCode", GenericRecordUtil.getEnumBitsAsString(new Supplier(this) { // from class: org.apache.poi.hssf.record.T
            public final /* synthetic */ FormulaSpecialCachedValue b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i6) {
                    case 0:
                        return this.b.getGenericValue();
                    default:
                        return Integer.valueOf(this.b.getTypeCode());
                }
            }
        }, new int[]{0, 1, 2, 3}, new String[]{"STRING", "BOOLEAN", "ERROR_CODE", "EMPTY"}));
    }

    public int getTypeCode() {
        return this._variableData[0];
    }

    @Deprecated
    public int getValueType() {
        int typeCode = getTypeCode();
        if (typeCode != 0) {
            if (typeCode == 1) {
                return CellType.BOOLEAN.getCode();
            }
            if (typeCode == 2) {
                return CellType.ERROR.getCode();
            }
            if (typeCode != 3) {
                throw new IllegalStateException(androidx.collection.a.i(typeCode, "Unexpected type id (", ")"));
            }
        }
        return CellType.STRING.getCode();
    }

    public CellType getValueTypeEnum() {
        int typeCode = getTypeCode();
        if (typeCode != 0) {
            if (typeCode == 1) {
                return CellType.BOOLEAN;
            }
            if (typeCode == 2) {
                return CellType.ERROR;
            }
            if (typeCode != 3) {
                throw new IllegalStateException(androidx.collection.a.i(typeCode, "Unexpected type id (", ")"));
            }
        }
        return CellType.STRING;
    }

    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.write(this._variableData);
        littleEndianOutput.writeShort(65535);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(FormulaSpecialCachedValue.class.getName());
        sb.append('[');
        return androidx.collection.a.f(']', formatValue(), sb);
    }

    private FormulaSpecialCachedValue(byte[] bArr) {
        this._variableData = bArr;
    }

    private static FormulaSpecialCachedValue create(int i5, int i6) {
        return new FormulaSpecialCachedValue(new byte[]{(byte) i5, 0, (byte) i6, 0, 0, 0});
    }
}
