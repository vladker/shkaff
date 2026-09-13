package org.apache.poi.ss.formula.constant;

import A3.AbstractC0157z;
import androidx.collection.a;
import org.apache.poi.util.LittleEndianInput;
import org.apache.poi.util.LittleEndianOutput;
import org.apache.poi.util.StringUtil;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class ConstantValueParser {
    private static final Object EMPTY_REPRESENTATION = null;
    private static final int FALSE_ENCODING = 0;
    private static final int TRUE_ENCODING = 1;
    private static final int TYPE_BOOLEAN = 4;
    private static final int TYPE_EMPTY = 0;
    private static final int TYPE_ERROR_CODE = 16;
    private static final int TYPE_NUMBER = 1;
    private static final int TYPE_STRING = 2;

    private ConstantValueParser() {
    }

    public static void encode(LittleEndianOutput littleEndianOutput, Object[] objArr) {
        for (Object obj : objArr) {
            encodeSingleValue(littleEndianOutput, obj);
        }
    }

    private static void encodeSingleValue(LittleEndianOutput littleEndianOutput, Object obj) {
        if (obj == EMPTY_REPRESENTATION) {
            littleEndianOutput.writeByte(0);
            littleEndianOutput.writeLong(0L);
            return;
        }
        if (obj instanceof Boolean) {
            littleEndianOutput.writeByte(4);
            littleEndianOutput.writeLong(((Boolean) obj).booleanValue() ? 1L : 0L);
            return;
        }
        if (obj instanceof Double) {
            littleEndianOutput.writeByte(1);
            littleEndianOutput.writeDouble(((Double) obj).doubleValue());
            return;
        }
        if (obj instanceof String) {
            littleEndianOutput.writeByte(2);
            StringUtil.writeUnicodeString(littleEndianOutput, (String) obj);
        } else if (obj instanceof ErrorConstant) {
            littleEndianOutput.writeByte(16);
            littleEndianOutput.writeLong(((ErrorConstant) obj).getErrorCode());
        } else {
            throw new IllegalStateException("Unexpected value type (" + obj.getClass().getName() + "'");
        }
    }

    public static int getEncodedSize(Object[] objArr) {
        int length = objArr.length;
        for (Object obj : objArr) {
            length += getEncodedSize(obj);
        }
        return length;
    }

    public static Object[] parse(LittleEndianInput littleEndianInput, int i5) {
        if (i5 < 0) {
            throw new IllegalArgumentException(AbstractC0157z.k(i5, "Invalid number of values to parse: "));
        }
        Object[] objArr = new Object[i5];
        for (int i6 = 0; i6 < i5; i6++) {
            objArr[i6] = readAConstantValue(littleEndianInput);
        }
        return objArr;
    }

    private static Object readAConstantValue(LittleEndianInput littleEndianInput) {
        byte b = littleEndianInput.readByte();
        if (b == 0) {
            littleEndianInput.readLong();
            return EMPTY_REPRESENTATION;
        }
        if (b == 1) {
            return Double.valueOf(littleEndianInput.readDouble());
        }
        if (b == 2) {
            return StringUtil.readUnicodeString(littleEndianInput);
        }
        if (b == 4) {
            return readBoolean(littleEndianInput);
        }
        if (b != 16) {
            throw new IllegalArgumentException(a.i(b, "Unknown grbit value (", ")"));
        }
        int uShort = littleEndianInput.readUShort();
        littleEndianInput.readUShort();
        littleEndianInput.readInt();
        return ErrorConstant.valueOf(uShort);
    }

    private static Object readBoolean(LittleEndianInput littleEndianInput) {
        byte b = (byte) littleEndianInput.readLong();
        if (b == 0) {
            return Boolean.FALSE;
        }
        if (b == 1) {
            return Boolean.TRUE;
        }
        throw new IllegalArgumentException(a.i(b, "unexpected boolean encoding (", ")"));
    }

    private static int getEncodedSize(Object obj) {
        Class<?> cls;
        if (obj == EMPTY_REPRESENTATION || (cls = obj.getClass()) == Boolean.class || cls == Double.class || cls == ErrorConstant.class) {
            return 8;
        }
        return StringUtil.getEncodedSize((String) obj);
    }
}
