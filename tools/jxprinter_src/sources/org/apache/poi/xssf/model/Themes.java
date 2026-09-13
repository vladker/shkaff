package org.apache.poi.xssf.model;

import org.apache.poi.xssf.usermodel.XSSFColor;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public interface Themes {
    XSSFColor getThemeColor(int i5);

    void inheritFromThemeAsRequired(XSSFColor xSSFColor);
}
