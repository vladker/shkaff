package org.apache.poi.ss.usermodel;

import A3.AbstractC0157z;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public enum FormulaError {
    _NO_ERROR(-1, "(no error)"),
    NULL(0, "#NULL!"),
    DIV0(7, "#DIV/0!"),
    VALUE(15, "#VALUE!"),
    REF(23, "#REF!"),
    NAME(29, "#NAME?"),
    NUM(36, "#NUM!"),
    NA(42, "#N/A"),
    CIRCULAR_REF(-60, "~CIRCULAR~REF~"),
    FUNCTION_NOT_IMPLEMENTED(-30, "~FUNCTION~NOT~IMPLEMENTED~");

    private final int longType;
    private final String repr;
    private final byte type;
    private static final Map<String, FormulaError> smap = new HashMap();
    private static final Map<Byte, FormulaError> bmap = new HashMap();
    private static final Map<Integer, FormulaError> imap = new HashMap();

    static {
        for (FormulaError formulaError : values()) {
            bmap.put(Byte.valueOf(formulaError.getCode()), formulaError);
            imap.put(Integer.valueOf(formulaError.getLongCode()), formulaError);
            smap.put(formulaError.getString(), formulaError);
        }
    }

    FormulaError(int i5, String str) {
        this.type = (byte) i5;
        this.longType = i5;
        this.repr = str;
    }

    public static FormulaError forInt(byte b) {
        FormulaError formulaError = bmap.get(Byte.valueOf(b));
        if (formulaError != null) {
            return formulaError;
        }
        throw new IllegalArgumentException(AbstractC0157z.k(b, "Unknown error type: "));
    }

    public static FormulaError forString(String str) {
        FormulaError formulaError = smap.get(str);
        if (formulaError != null) {
            return formulaError;
        }
        throw new IllegalArgumentException(AbstractC0157z.n("Unknown error code: ", str));
    }

    public static boolean isValidCode(int i5) {
        for (FormulaError formulaError : values()) {
            if (formulaError.getCode() == i5 || formulaError.getLongCode() == i5) {
                return true;
            }
        }
        return false;
    }

    public byte getCode() {
        return this.type;
    }

    public int getLongCode() {
        return this.longType;
    }

    public String getString() {
        return this.repr;
    }

    public static FormulaError forInt(int i5) {
        FormulaError formulaError = imap.get(Integer.valueOf(i5));
        if (formulaError == null) {
            formulaError = bmap.get(Byte.valueOf((byte) i5));
        }
        if (formulaError != null) {
            return formulaError;
        }
        throw new IllegalArgumentException(AbstractC0157z.k(i5, "Unknown error type: "));
    }
}
