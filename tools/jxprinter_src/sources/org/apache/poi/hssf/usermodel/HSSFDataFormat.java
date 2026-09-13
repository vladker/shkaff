package org.apache.poi.hssf.usermodel;

import java.util.Arrays;
import java.util.List;
import java.util.Vector;
import org.apache.poi.hssf.model.InternalWorkbook;
import org.apache.poi.hssf.record.FormatRecord;
import org.apache.poi.ss.usermodel.BuiltinFormats;
import org.apache.poi.ss.usermodel.DataFormat;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class HSSFDataFormat implements DataFormat {
    private static final String[] _builtinFormats = BuiltinFormats.getAll();
    private final Vector<String> _formats = new Vector<>();
    private boolean _movedBuiltins;
    private final InternalWorkbook _workbook;

    public HSSFDataFormat(InternalWorkbook internalWorkbook) {
        this._workbook = internalWorkbook;
        for (FormatRecord formatRecord : internalWorkbook.getFormats()) {
            ensureFormatsSize(formatRecord.getIndexCode());
            this._formats.set(formatRecord.getIndexCode(), formatRecord.getFormatString());
        }
    }

    private void ensureFormatsSize(int i5) {
        if (this._formats.size() <= i5) {
            this._formats.setSize(i5 + 1);
        }
    }

    public static short getBuiltinFormat(String str) {
        return (short) BuiltinFormats.getBuiltinFormat(str);
    }

    public static List<String> getBuiltinFormats() {
        return Arrays.asList(_builtinFormats);
    }

    public static int getNumberOfBuiltinBuiltinFormats() {
        return _builtinFormats.length;
    }

    @Override // org.apache.poi.ss.usermodel.DataFormat
    public short getFormat(String str) {
        if (str.equalsIgnoreCase("TEXT")) {
            str = "@";
        }
        if (!this._movedBuiltins) {
            int i5 = 0;
            while (true) {
                String[] strArr = _builtinFormats;
                if (i5 >= strArr.length) {
                    break;
                }
                ensureFormatsSize(i5);
                if (this._formats.get(i5) == null) {
                    this._formats.set(i5, strArr[i5]);
                }
                i5++;
            }
            this._movedBuiltins = true;
        }
        for (int i6 = 0; i6 < this._formats.size(); i6++) {
            if (str.equals(this._formats.get(i6))) {
                return (short) i6;
            }
        }
        short format = this._workbook.getFormat(str, true);
        ensureFormatsSize(format);
        this._formats.set(format, str);
        return format;
    }

    public static String getBuiltinFormat(short s6) {
        return BuiltinFormats.getBuiltinFormat(s6);
    }

    @Override // org.apache.poi.ss.usermodel.DataFormat
    public String getFormat(short s6) {
        String str;
        if (this._movedBuiltins) {
            return this._formats.get(s6);
        }
        if (s6 == -1) {
            return null;
        }
        String str2 = this._formats.size() > s6 ? this._formats.get(s6) : null;
        String[] strArr = _builtinFormats;
        return (strArr.length <= s6 || (str = strArr[s6]) == null || str2 != null) ? str2 : str;
    }
}
