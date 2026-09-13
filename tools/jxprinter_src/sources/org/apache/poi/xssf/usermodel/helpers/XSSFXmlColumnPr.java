package org.apache.poi.xssf.usermodel.helpers;

import org.apache.poi.openxml4j.opc.PackagingURIHelper;
import org.apache.poi.util.Internal;
import org.apache.poi.xssf.usermodel.XSSFTable;
import org.apache.poi.xssf.usermodel.XSSFTableColumn;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTXmlColumnPr;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XSSFXmlColumnPr {
    private CTXmlColumnPr ctXmlColumnPr;
    private XSSFTable table;
    private XSSFTableColumn tableColumn;

    @Internal
    public XSSFXmlColumnPr(XSSFTableColumn xSSFTableColumn, CTXmlColumnPr cTXmlColumnPr) {
        this.table = xSSFTableColumn.getTable();
        this.tableColumn = xSSFTableColumn;
        this.ctXmlColumnPr = cTXmlColumnPr;
    }

    public String getLocalXPath() {
        StringBuilder sb = new StringBuilder();
        String[] strArrSplit = this.ctXmlColumnPr.getXpath().split(PackagingURIHelper.FORWARD_SLASH_STRING);
        for (int length = this.table.getCommonXpath().split(PackagingURIHelper.FORWARD_SLASH_STRING).length - 1; length < strArrSplit.length; length++) {
            sb.append(PackagingURIHelper.FORWARD_SLASH_STRING);
            sb.append(strArrSplit[length]);
        }
        return sb.toString();
    }

    public long getMapId() {
        return this.ctXmlColumnPr.getMapId();
    }

    public XSSFTableColumn getTableColumn() {
        return this.tableColumn;
    }

    public String getXPath() {
        return this.ctXmlColumnPr.getXpath();
    }

    public String getXmlDataType() {
        return this.ctXmlColumnPr.getXmlDataType();
    }
}
