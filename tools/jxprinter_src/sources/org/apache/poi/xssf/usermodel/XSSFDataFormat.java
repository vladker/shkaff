package org.apache.poi.xssf.usermodel;

import org.apache.poi.ss.usermodel.BuiltinFormats;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.xssf.model.StylesTable;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XSSFDataFormat implements DataFormat {
    private final StylesTable stylesSource;

    public XSSFDataFormat(StylesTable stylesTable) {
        this.stylesSource = stylesTable;
    }

    @Override // org.apache.poi.ss.usermodel.DataFormat
    public short getFormat(String str) {
        int builtinFormat = BuiltinFormats.getBuiltinFormat(str);
        if (builtinFormat == -1) {
            builtinFormat = this.stylesSource.putNumberFormat(str);
        }
        return (short) builtinFormat;
    }

    public void putFormat(short s6, String str) {
        this.stylesSource.putNumberFormat(s6, str);
    }

    @Override // org.apache.poi.ss.usermodel.DataFormat
    public String getFormat(short s6) {
        String numberFormatAt = this.stylesSource.getNumberFormatAt(s6);
        return numberFormatAt == null ? BuiltinFormats.getBuiltinFormat(s6) : numberFormatAt;
    }
}
