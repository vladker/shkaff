package org.apache.poi.ss.util;

import A3.AbstractC0157z;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.function.Supplier;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.poi.common.usermodel.GenericRecord;
import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.formula.SheetNameFormatter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.StringUtil;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class CellReference implements GenericRecord {
    private static final char ABSOLUTE_REFERENCE_MARKER = '$';
    private static final char SHEET_NAME_DELIMITER = '!';
    private static final char SPECIAL_NAME_DELIMITER = '\'';
    private final int _colIndex;
    private final boolean _isColAbs;
    private final boolean _isRowAbs;
    private final int _rowIndex;
    private final String _sheetName;
    private static final Pattern CELL_REF_PATTERN = Pattern.compile("(\\$?[A-Z]+)?(\\$?[0-9]+)?", 2);
    private static final Pattern STRICTLY_CELL_REF_PATTERN = Pattern.compile("\\$?([A-Z]+)\\$?([0-9]+)", 2);
    private static final Pattern COLUMN_REF_PATTERN = Pattern.compile("\\$?([A-Z]+)", 2);
    private static final Pattern ROW_REF_PATTERN = Pattern.compile("\\$?([0-9]+)");
    private static final Pattern NAMED_RANGE_NAME_PATTERN = Pattern.compile("[_A-Z][_.A-Z0-9]*", 2);

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class CellRefParts {
        final String colRef;
        final String rowRef;
        final String sheetName;

        private CellRefParts(String str, String str2, String str3) {
            this.sheetName = str;
            this.rowRef = str2 == null ? "" : str2;
            this.colRef = str3 == null ? "" : str3;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public enum NameType {
        CELL,
        NAMED_RANGE,
        COLUMN,
        ROW,
        BAD_CELL_OR_NAMED_RANGE
    }

    public CellReference(String str) {
        if (StringUtil.endsWithIgnoreCase(str, "#REF!")) {
            throw new IllegalArgumentException(AbstractC0157z.n("Cell reference invalid: ", str));
        }
        CellRefParts cellRefPartsSeparateRefParts = separateRefParts(str);
        this._sheetName = cellRefPartsSeparateRefParts.sheetName;
        String strSubstring = cellRefPartsSeparateRefParts.colRef;
        boolean z6 = false;
        boolean z7 = strSubstring.length() > 0 && strSubstring.charAt(0) == '$';
        this._isColAbs = z7;
        strSubstring = z7 ? strSubstring.substring(1) : strSubstring;
        if (strSubstring.length() == 0) {
            this._colIndex = -1;
        } else {
            this._colIndex = convertColStringToIndex(strSubstring);
        }
        String strSubstring2 = cellRefPartsSeparateRefParts.rowRef;
        if (strSubstring2.length() > 0 && strSubstring2.charAt(0) == '$') {
            z6 = true;
        }
        this._isRowAbs = z6;
        strSubstring2 = z6 ? strSubstring2.substring(1) : strSubstring2;
        if (strSubstring2.length() == 0) {
            this._rowIndex = -1;
        } else {
            this._rowIndex = Integer.parseInt(strSubstring2) - 1;
        }
    }

    public static boolean cellReferenceIsWithinRange(String str, String str2, SpreadsheetVersion spreadsheetVersion) {
        if (isColumnWithinRange(str, spreadsheetVersion)) {
            return isRowWithinRange(str2, spreadsheetVersion);
        }
        return false;
    }

    public static NameType classifyCellReference(String str, SpreadsheetVersion spreadsheetVersion) {
        int length = str.length();
        if (length < 1) {
            throw new IllegalArgumentException("Empty string not allowed");
        }
        char cCharAt = str.charAt(0);
        if (cCharAt != '$' && cCharAt != '.' && cCharAt != '_' && !Character.isLetter(cCharAt) && !Character.isDigit(cCharAt)) {
            throw new IllegalArgumentException("Invalid first char (" + cCharAt + ") of cell reference or named range.  Letter expected");
        }
        if (!Character.isDigit(str.charAt(length - 1))) {
            return validateNamedRangeName(str, spreadsheetVersion);
        }
        Matcher matcher = STRICTLY_CELL_REF_PATTERN.matcher(str);
        if (!matcher.matches()) {
            return validateNamedRangeName(str, spreadsheetVersion);
        }
        if (cellReferenceIsWithinRange(matcher.group(1), matcher.group(2), spreadsheetVersion)) {
            return NameType.CELL;
        }
        return str.indexOf(36) >= 0 ? NameType.BAD_CELL_OR_NAMED_RANGE : NameType.NAMED_RANGE;
    }

    public static int convertColStringToIndex(String str) {
        char[] charArray = str.toUpperCase(Locale.ROOT).toCharArray();
        int i5 = 0;
        for (int i6 = 0; i6 < charArray.length; i6++) {
            char c = charArray[i6];
            if (c != '$') {
                i5 = (c - '@') + (i5 * 26);
            } else if (i6 != 0) {
                throw new IllegalArgumentException(AbstractC0157z.o("Bad col ref format '", str, "'"));
            }
        }
        return i5 - 1;
    }

    public static String convertNumToColString(int i5) {
        int i6 = i5 + 1;
        StringBuilder sb = new StringBuilder(2);
        while (i6 > 0) {
            int i7 = i6 % 26;
            if (i7 == 0) {
                i7 = 26;
            }
            i6 = (i6 - i7) / 26;
            sb.insert(0, (char) (i7 + 64));
        }
        return sb.toString();
    }

    public static boolean isColumnWithinRange(String str, SpreadsheetVersion spreadsheetVersion) {
        String lastColumnName = spreadsheetVersion.getLastColumnName();
        int length = lastColumnName.length();
        int length2 = str.length();
        if (length2 > length) {
            return false;
        }
        return length2 != length || str.toUpperCase(Locale.ROOT).compareTo(lastColumnName) <= 0;
    }

    public static boolean isPartAbsolute(String str) {
        return str.charAt(0) == '$';
    }

    public static boolean isRowWithinRange(String str, SpreadsheetVersion spreadsheetVersion) {
        long j6 = Long.parseLong(str) - 1;
        if (j6 > 2147483647L) {
            return false;
        }
        return isRowWithinRange(Math.toIntExact(j6), spreadsheetVersion);
    }

    private static String parseSheetName(String str, int i5) {
        if (i5 < 0) {
            return null;
        }
        if (str.charAt(0) != '\'') {
            if (str.contains(" ")) {
                throw new IllegalArgumentException(AbstractC0157z.o("Sheet names containing spaces must be quoted: (", str, ")"));
            }
            return str.substring(0, i5);
        }
        int i6 = i5 - 1;
        if (str.charAt(i6) != '\'') {
            throw new IllegalArgumentException(AbstractC0157z.o("Mismatched quotes: (", str, ")"));
        }
        StringBuilder sb = new StringBuilder(i5);
        int i7 = 1;
        while (i7 < i6) {
            char cCharAt = str.charAt(i7);
            if (cCharAt != '\'') {
                sb.append(cCharAt);
            } else {
                i7++;
                if (i7 >= i6 || str.charAt(i7) != '\'') {
                    throw new IllegalArgumentException(AbstractC0157z.o("Bad sheet name quote escaping: (", str, ")"));
                }
                sb.append(cCharAt);
            }
            i7++;
        }
        return sb.toString();
    }

    private static CellRefParts separateRefParts(String str) {
        int iLastIndexOf = str.lastIndexOf(33);
        String sheetName = parseSheetName(str, iLastIndexOf);
        Matcher matcher = CELL_REF_PATTERN.matcher(str.substring(iLastIndexOf + 1).toUpperCase(Locale.ROOT));
        if (!matcher.matches()) {
            throw new IllegalArgumentException("Invalid CellReference: ".concat(str));
        }
        return new CellRefParts(sheetName, matcher.group(2), matcher.group(1));
    }

    private static NameType validateNamedRangeName(String str, SpreadsheetVersion spreadsheetVersion) {
        Matcher matcher = COLUMN_REF_PATTERN.matcher(str);
        if (matcher.matches() && isColumnWithinRange(matcher.group(1), spreadsheetVersion)) {
            return NameType.COLUMN;
        }
        Matcher matcher2 = ROW_REF_PATTERN.matcher(str);
        if (matcher2.matches() && isRowWithinRange(matcher2.group(1), spreadsheetVersion)) {
            return NameType.ROW;
        }
        return !NAMED_RANGE_NAME_PATTERN.matcher(str).matches() ? NameType.BAD_CELL_OR_NAMED_RANGE : NameType.NAMED_RANGE;
    }

    public void appendCellReference(StringBuilder sb) {
        if (this._colIndex != -1) {
            if (this._isColAbs) {
                sb.append(ABSOLUTE_REFERENCE_MARKER);
            }
            sb.append(convertNumToColString(this._colIndex));
        }
        if (this._rowIndex != -1) {
            if (this._isRowAbs) {
                sb.append(ABSOLUTE_REFERENCE_MARKER);
            }
            sb.append(this._rowIndex + 1);
        }
    }

    public void appendR1C1CellReference(StringBuilder sb) {
        if (this._rowIndex != -1) {
            sb.append('R');
            sb.append(this._rowIndex + 1);
        }
        if (this._colIndex != -1) {
            sb.append('C');
            sb.append(this._colIndex + 1);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CellReference)) {
            return false;
        }
        CellReference cellReference = (CellReference) obj;
        return this._rowIndex == cellReference._rowIndex && this._colIndex == cellReference._colIndex && this._isRowAbs == cellReference._isRowAbs && this._isColAbs == cellReference._isColAbs && Objects.equals(this._sheetName, cellReference._sheetName);
    }

    public String formatAsR1C1String() {
        return formatAsR1C1String(true);
    }

    public String formatAsString() {
        return formatAsString(true);
    }

    public String[] getCellRefParts() {
        return new String[]{this._sheetName, Integer.toString(this._rowIndex + 1), convertNumToColString(this._colIndex)};
    }

    public short getCol() {
        return (short) this._colIndex;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        final int i5 = 0;
        Supplier supplier = new Supplier(this) { // from class: org.apache.poi.ss.util.b
            public final /* synthetic */ CellReference b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i5) {
                    case 0:
                        return this.b.getSheetName();
                    case 1:
                        return Integer.valueOf(this.b.getRow());
                    case 2:
                        return Short.valueOf(this.b.getCol());
                    case 3:
                        return Boolean.valueOf(this.b.isRowAbsolute());
                    case 4:
                        return Boolean.valueOf(this.b.isColAbsolute());
                    default:
                        return this.b.formatAsString();
                }
            }
        };
        final int i6 = 1;
        Supplier supplier2 = new Supplier(this) { // from class: org.apache.poi.ss.util.b
            public final /* synthetic */ CellReference b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i6) {
                    case 0:
                        return this.b.getSheetName();
                    case 1:
                        return Integer.valueOf(this.b.getRow());
                    case 2:
                        return Short.valueOf(this.b.getCol());
                    case 3:
                        return Boolean.valueOf(this.b.isRowAbsolute());
                    case 4:
                        return Boolean.valueOf(this.b.isColAbsolute());
                    default:
                        return this.b.formatAsString();
                }
            }
        };
        final int i7 = 2;
        Supplier supplier3 = new Supplier(this) { // from class: org.apache.poi.ss.util.b
            public final /* synthetic */ CellReference b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i7) {
                    case 0:
                        return this.b.getSheetName();
                    case 1:
                        return Integer.valueOf(this.b.getRow());
                    case 2:
                        return Short.valueOf(this.b.getCol());
                    case 3:
                        return Boolean.valueOf(this.b.isRowAbsolute());
                    case 4:
                        return Boolean.valueOf(this.b.isColAbsolute());
                    default:
                        return this.b.formatAsString();
                }
            }
        };
        final int i8 = 3;
        Supplier supplier4 = new Supplier(this) { // from class: org.apache.poi.ss.util.b
            public final /* synthetic */ CellReference b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i8) {
                    case 0:
                        return this.b.getSheetName();
                    case 1:
                        return Integer.valueOf(this.b.getRow());
                    case 2:
                        return Short.valueOf(this.b.getCol());
                    case 3:
                        return Boolean.valueOf(this.b.isRowAbsolute());
                    case 4:
                        return Boolean.valueOf(this.b.isColAbsolute());
                    default:
                        return this.b.formatAsString();
                }
            }
        };
        final int i9 = 4;
        Supplier supplier5 = new Supplier(this) { // from class: org.apache.poi.ss.util.b
            public final /* synthetic */ CellReference b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i9) {
                    case 0:
                        return this.b.getSheetName();
                    case 1:
                        return Integer.valueOf(this.b.getRow());
                    case 2:
                        return Short.valueOf(this.b.getCol());
                    case 3:
                        return Boolean.valueOf(this.b.isRowAbsolute());
                    case 4:
                        return Boolean.valueOf(this.b.isColAbsolute());
                    default:
                        return this.b.formatAsString();
                }
            }
        };
        final int i10 = 5;
        return GenericRecordUtil.getGenericProperties("sheetName", supplier, "rowIndex", supplier2, "colIndex", supplier3, "rowAbs", supplier4, "colAbs", supplier5, "formatAsString", new Supplier(this) { // from class: org.apache.poi.ss.util.b
            public final /* synthetic */ CellReference b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i10) {
                    case 0:
                        return this.b.getSheetName();
                    case 1:
                        return Integer.valueOf(this.b.getRow());
                    case 2:
                        return Short.valueOf(this.b.getCol());
                    case 3:
                        return Boolean.valueOf(this.b.isRowAbsolute());
                    case 4:
                        return Boolean.valueOf(this.b.isColAbsolute());
                    default:
                        return this.b.formatAsString();
                }
            }
        });
    }

    public int getRow() {
        return this._rowIndex;
    }

    public String getSheetName() {
        return this._sheetName;
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(this._rowIndex), Integer.valueOf(this._colIndex), Boolean.valueOf(this._isRowAbs), Boolean.valueOf(this._isColAbs), this._sheetName);
    }

    public boolean isColAbsolute() {
        return this._isColAbs;
    }

    public boolean isRowAbsolute() {
        return this._isRowAbs;
    }

    public String toString() {
        return getClass().getName() + " [" + formatAsString() + "]";
    }

    public String formatAsR1C1String(boolean z6) {
        String str;
        StringBuilder sb = new StringBuilder(32);
        if (z6 && (str = this._sheetName) != null) {
            SheetNameFormatter.appendFormat(sb, str);
            sb.append(SHEET_NAME_DELIMITER);
        }
        appendR1C1CellReference(sb);
        return sb.toString();
    }

    public String formatAsString(boolean z6) {
        String str;
        StringBuilder sb = new StringBuilder(32);
        if (z6 && (str = this._sheetName) != null) {
            SheetNameFormatter.appendFormat(sb, str);
            sb.append(SHEET_NAME_DELIMITER);
        }
        appendCellReference(sb);
        return sb.toString();
    }

    public static boolean isRowWithinRange(int i5, SpreadsheetVersion spreadsheetVersion) {
        return i5 >= 0 && i5 <= spreadsheetVersion.getLastRowIndex();
    }

    public CellReference(int i5, int i6) {
        this(i5, i6, false, false);
    }

    public CellReference(int i5, short s6) {
        this(i5, s6 & 65535, false, false);
    }

    public CellReference(Cell cell) {
        this(cell.getSheet().getSheetName(), cell.getRowIndex(), cell.getColumnIndex(), false, false);
    }

    public CellReference(int i5, int i6, boolean z6, boolean z7) {
        this(null, i5, i6, z6, z7);
    }

    public CellReference(String str, int i5, int i6, boolean z6, boolean z7) {
        if (i5 < -1) {
            throw new IllegalArgumentException(AbstractC0157z.k(i5, "row index may not be negative, but had "));
        }
        if (i6 >= -1) {
            this._sheetName = str;
            this._rowIndex = i5;
            this._colIndex = i6;
            this._isRowAbs = z6;
            this._isColAbs = z7;
            return;
        }
        throw new IllegalArgumentException(AbstractC0157z.k(i6, "column index may not be negative, but had "));
    }
}
