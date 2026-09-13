package org.apache.poi.xssf.usermodel;

import java.util.HashMap;
import java.util.Map;
import l5.g2;
import org.apache.poi.common.usermodel.HyperlinkType;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.AreaReference;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.util.Internal;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTColor;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XSSFCreationHelper implements CreationHelper {
    private final Map<String, Workbook> referencedWorkbooks = new HashMap();
    private final XSSFWorkbook workbook;

    @Internal
    public XSSFCreationHelper(XSSFWorkbook xSSFWorkbook) {
        this.workbook = xSSFWorkbook;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$createFormulaEvaluator$0(Map map, String str, Workbook workbook) {
    }

    public void addExternalWorkbook(String str, Workbook workbook) {
        this.referencedWorkbooks.put(str, workbook);
    }

    @Override // org.apache.poi.ss.usermodel.CreationHelper
    public AreaReference createAreaReference(String str) {
        return new AreaReference(str, this.workbook.getSpreadsheetVersion());
    }

    public Map<String, Workbook> getReferencedWorkbooks() {
        return this.referencedWorkbooks;
    }

    @Override // org.apache.poi.ss.usermodel.CreationHelper
    public AreaReference createAreaReference(CellReference cellReference, CellReference cellReference2) {
        return new AreaReference(cellReference, cellReference2, this.workbook.getSpreadsheetVersion());
    }

    @Override // org.apache.poi.ss.usermodel.CreationHelper
    public XSSFClientAnchor createClientAnchor() {
        return new XSSFClientAnchor();
    }

    @Override // org.apache.poi.ss.usermodel.CreationHelper
    public XSSFDataFormat createDataFormat() {
        return this.workbook.createDataFormat();
    }

    @Override // org.apache.poi.ss.usermodel.CreationHelper
    public XSSFColor createExtendedColor() {
        return XSSFColor.from(CTColor.Factory.newInstance(), this.workbook.getStylesSource().getIndexedColors());
    }

    @Override // org.apache.poi.ss.usermodel.CreationHelper
    public XSSFFormulaEvaluator createFormulaEvaluator() {
        XSSFFormulaEvaluator xSSFFormulaEvaluator = new XSSFFormulaEvaluator(this.workbook);
        HashMap map = new HashMap();
        map.put("", xSSFFormulaEvaluator);
        this.referencedWorkbooks.forEach(new g2(map, 4));
        xSSFFormulaEvaluator.setupReferencedWorkbooks(map);
        return xSSFFormulaEvaluator;
    }

    @Override // org.apache.poi.ss.usermodel.CreationHelper
    public XSSFHyperlink createHyperlink(HyperlinkType hyperlinkType) {
        return new XSSFHyperlink(hyperlinkType);
    }

    @Override // org.apache.poi.ss.usermodel.CreationHelper
    public XSSFRichTextString createRichTextString(String str) {
        XSSFRichTextString xSSFRichTextString = new XSSFRichTextString(str);
        xSSFRichTextString.setStylesTableReference(this.workbook.getStylesSource());
        return xSSFRichTextString;
    }
}
