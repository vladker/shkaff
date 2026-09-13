package org.apache.poi.ss.usermodel;

import org.apache.logging.log4j.util.Chars;
import org.apache.poi.ss.formula.eval.ErrorEval;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class CellValue {
    public static final CellValue FALSE;
    public static final CellValue TRUE;
    private final boolean _booleanValue;
    private final CellType _cellType;
    private final int _errorCode;
    private final double _numberValue;
    private final String _textValue;

    /* JADX INFO: renamed from: org.apache.poi.ss.usermodel.CellValue$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$ss$usermodel$CellType;

        static {
            int[] iArr = new int[CellType.values().length];
            $SwitchMap$org$apache$poi$ss$usermodel$CellType = iArr;
            try {
                iArr[CellType.NUMERIC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$CellType[CellType.STRING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$CellType[CellType.BOOLEAN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$CellType[CellType.ERROR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    static {
        CellType cellType = CellType.BOOLEAN;
        TRUE = new CellValue(cellType, 0.0d, true, null, 0);
        FALSE = new CellValue(cellType, 0.0d, false, null, 0);
    }

    private CellValue(CellType cellType, double d, boolean z6, String str, int i5) {
        this._cellType = cellType;
        this._numberValue = d;
        this._booleanValue = z6;
        this._textValue = str;
        this._errorCode = i5;
    }

    public static CellValue getError(int i5) {
        return new CellValue(CellType.ERROR, 0.0d, false, null, i5);
    }

    public static CellValue valueOf(boolean z6) {
        return z6 ? TRUE : FALSE;
    }

    public String formatAsString() {
        int i5 = AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$CellType[this._cellType.ordinal()];
        if (i5 == 1) {
            return String.valueOf(this._numberValue);
        }
        if (i5 == 2) {
            return androidx.collection.a.f(Chars.DQUOTE, this._textValue, new StringBuilder("\""));
        }
        if (i5 == 3) {
            return this._booleanValue ? "TRUE" : "FALSE";
        }
        if (i5 == 4) {
            return ErrorEval.getText(this._errorCode);
        }
        return "<error unexpected cell type " + this._cellType + ">";
    }

    public boolean getBooleanValue() {
        return this._booleanValue;
    }

    public CellType getCellType() {
        return this._cellType;
    }

    public byte getErrorValue() {
        return (byte) this._errorCode;
    }

    public double getNumberValue() {
        return this._numberValue;
    }

    public String getStringValue() {
        return this._textValue;
    }

    public String toString() {
        return CellValue.class.getName() + " [" + formatAsString() + "]";
    }

    public CellValue(double d) {
        this(CellType.NUMERIC, d, false, null, 0);
    }

    public CellValue(String str) {
        this(CellType.STRING, 0.0d, false, str, 0);
    }
}
