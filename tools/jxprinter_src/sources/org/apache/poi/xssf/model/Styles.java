package org.apache.poi.xssf.model;

import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.extensions.XSSFCellBorder;
import org.apache.poi.xssf.usermodel.extensions.XSSFCellFill;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public interface Styles {
    XSSFCellBorder getBorderAt(int i5);

    XSSFCellFill getFillAt(int i5);

    XSSFFont getFontAt(int i5);

    int getNumCellStyles();

    int getNumDataFormats();

    String getNumberFormatAt(short s6);

    XSSFCellStyle getStyleAt(int i5);

    int putBorder(XSSFCellBorder xSSFCellBorder);

    int putFill(XSSFCellFill xSSFCellFill);

    int putFont(XSSFFont xSSFFont);

    int putFont(XSSFFont xSSFFont, boolean z6);

    int putNumberFormat(String str);

    void putNumberFormat(short s6, String str);

    int putStyle(XSSFCellStyle xSSFCellStyle);

    boolean removeNumberFormat(String str);

    boolean removeNumberFormat(short s6);
}
