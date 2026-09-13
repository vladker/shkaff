package org.apache.poi.xssf.usermodel;

import org.apache.poi.ss.usermodel.TableStyle;
import org.apache.poi.ss.usermodel.TableStyleInfo;
import org.apache.poi.xssf.model.StylesTable;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableStyleInfo;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XSSFTableStyleInfo implements TableStyleInfo {
    private boolean columnStripes;
    private boolean firstColumn;
    private boolean lastColumn;
    private boolean rowStripes;
    private TableStyle style;
    private final CTTableStyleInfo styleInfo;
    private final StylesTable stylesTable;

    public XSSFTableStyleInfo(StylesTable stylesTable, CTTableStyleInfo cTTableStyleInfo) {
        this.columnStripes = cTTableStyleInfo.getShowColumnStripes();
        this.rowStripes = cTTableStyleInfo.getShowRowStripes();
        this.firstColumn = cTTableStyleInfo.getShowFirstColumn();
        this.lastColumn = cTTableStyleInfo.getShowLastColumn();
        this.style = stylesTable.getTableStyle(cTTableStyleInfo.getName());
        this.stylesTable = stylesTable;
        this.styleInfo = cTTableStyleInfo;
    }

    @Override // org.apache.poi.ss.usermodel.TableStyleInfo
    public String getName() {
        return this.style.getName();
    }

    @Override // org.apache.poi.ss.usermodel.TableStyleInfo
    public TableStyle getStyle() {
        return this.style;
    }

    @Override // org.apache.poi.ss.usermodel.TableStyleInfo
    public boolean isShowColumnStripes() {
        return this.columnStripes;
    }

    @Override // org.apache.poi.ss.usermodel.TableStyleInfo
    public boolean isShowFirstColumn() {
        return this.firstColumn;
    }

    @Override // org.apache.poi.ss.usermodel.TableStyleInfo
    public boolean isShowLastColumn() {
        return this.lastColumn;
    }

    @Override // org.apache.poi.ss.usermodel.TableStyleInfo
    public boolean isShowRowStripes() {
        return this.rowStripes;
    }

    public void setFirstColumn(boolean z6) {
        this.firstColumn = z6;
        this.styleInfo.setShowFirstColumn(z6);
    }

    public void setLastColumn(boolean z6) {
        this.lastColumn = z6;
        this.styleInfo.setShowLastColumn(z6);
    }

    public void setName(String str) {
        this.styleInfo.setName(str);
        this.style = this.stylesTable.getTableStyle(str);
    }

    public void setShowColumnStripes(boolean z6) {
        this.columnStripes = z6;
        this.styleInfo.setShowColumnStripes(z6);
    }

    public void setShowRowStripes(boolean z6) {
        this.rowStripes = z6;
        this.styleInfo.setShowRowStripes(z6);
    }
}
