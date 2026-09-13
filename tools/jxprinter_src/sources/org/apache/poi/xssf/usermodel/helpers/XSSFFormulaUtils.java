package org.apache.poi.xssf.usermodel.helpers;

import java.util.Iterator;
import org.apache.poi.ooxml.POIXMLDocumentPart;
import org.apache.poi.ss.formula.FormulaParser;
import org.apache.poi.ss.formula.FormulaRenderer;
import org.apache.poi.ss.formula.FormulaType;
import org.apache.poi.ss.formula.ptg.Ptg;
import org.apache.poi.ss.formula.ptg.Pxg;
import org.apache.poi.ss.formula.ptg.Pxg3D;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFChart;
import org.apache.poi.xssf.usermodel.XSSFDrawing;
import org.apache.poi.xssf.usermodel.XSSFEvaluationWorkbook;
import org.apache.poi.xssf.usermodel.XSSFName;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCellFormula;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class XSSFFormulaUtils {
    private final XSSFEvaluationWorkbook _fpwb;
    private final XSSFWorkbook _wb;

    public XSSFFormulaUtils(XSSFWorkbook xSSFWorkbook) {
        this._wb = xSSFWorkbook;
        this._fpwb = XSSFEvaluationWorkbook.create(xSSFWorkbook);
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0034  */
    private void updateDomSheetReference(Node node, String str, String str2) {
        String nodeValue = node.getNodeValue();
        if (nodeValue != null) {
            if (nodeValue.contains(str + "!")) {
                XSSFName xSSFNameCreateName = this._wb.createName();
                xSSFNameCreateName.setRefersToFormula(nodeValue);
                updateName(xSSFNameCreateName, str, str2);
                node.setNodeValue(xSSFNameCreateName.getRefersToFormula());
                this._wb.removeName(xSSFNameCreateName);
            } else {
                if (nodeValue.contains(str + "'!")) {
                    XSSFName xSSFNameCreateName2 = this._wb.createName();
                    xSSFNameCreateName2.setRefersToFormula(nodeValue);
                    updateName(xSSFNameCreateName2, str, str2);
                    node.setNodeValue(xSSFNameCreateName2.getRefersToFormula());
                    this._wb.removeName(xSSFNameCreateName2);
                }
            }
        }
        NodeList childNodes = node.getChildNodes();
        for (int i5 = 0; i5 < childNodes.getLength(); i5++) {
            updateDomSheetReference(childNodes.item(i5), str, str2);
        }
    }

    private void updateFormula(XSSFCell xSSFCell, String str, String str2) {
        String stringValue;
        CTCellFormula f6 = xSSFCell.getCTCell().getF();
        if (f6 == null || (stringValue = f6.getStringValue()) == null || stringValue.length() <= 0) {
            return;
        }
        Ptg[] ptgArr = FormulaParser.parse(stringValue, this._fpwb, FormulaType.CELL, this._wb.getSheetIndex(xSSFCell.getSheet()), xSSFCell.getRowIndex());
        for (Ptg ptg : ptgArr) {
            updatePtg(ptg, str, str2);
        }
        String formulaString = FormulaRenderer.toFormulaString(this._fpwb, ptgArr);
        if (stringValue.equals(formulaString)) {
            return;
        }
        f6.setStringValue(formulaString);
    }

    private void updateName(XSSFName xSSFName, String str, String str2) {
        String refersToFormula = xSSFName.getRefersToFormula();
        if (refersToFormula != null) {
            Ptg[] ptgArr = FormulaParser.parse(refersToFormula, this._fpwb, FormulaType.NAMEDRANGE, xSSFName.getSheetIndex(), -1);
            for (Ptg ptg : ptgArr) {
                updatePtg(ptg, str, str2);
            }
            String formulaString = FormulaRenderer.toFormulaString(this._fpwb, ptgArr);
            if (refersToFormula.equals(formulaString)) {
                return;
            }
            xSSFName.setRefersToFormula(formulaString);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void updatePtg(Ptg ptg, String str, String str2) {
        if (ptg instanceof Pxg) {
            Pxg pxg = (Pxg) ptg;
            if (pxg.getExternalWorkbookNumber() < 1) {
                if (pxg.getSheetName() != null && pxg.getSheetName().equals(str)) {
                    pxg.setSheetName(str2);
                }
                if (pxg instanceof Pxg3D) {
                    Pxg3D pxg3D = (Pxg3D) pxg;
                    if (pxg3D.getLastSheetName() == null || !pxg3D.getLastSheetName().equals(str)) {
                        return;
                    }
                    pxg3D.setLastSheetName(str2);
                }
            }
        }
    }

    public void updateSheetName(int i5, String str, String str2) {
        for (XSSFName xSSFName : this._wb.getAllNames()) {
            if (xSSFName.getSheetIndex() == -1 || xSSFName.getSheetIndex() == i5) {
                updateName(xSSFName, str, str2);
            }
        }
        Iterator<Sheet> it = this._wb.iterator();
        while (it.hasNext()) {
            Iterator<Row> it2 = it.next().iterator();
            while (it2.hasNext()) {
                for (Cell cell : it2.next()) {
                    if (cell.getCellType() == CellType.FORMULA) {
                        updateFormula((XSSFCell) cell, str, str2);
                    }
                }
            }
        }
        for (POIXMLDocumentPart pOIXMLDocumentPart : this._wb.getSheetAt(i5).getRelations()) {
            if (pOIXMLDocumentPart instanceof XSSFDrawing) {
                Iterator<XSSFChart> it3 = ((XSSFDrawing) pOIXMLDocumentPart).getCharts().iterator();
                while (it3.hasNext()) {
                    updateDomSheetReference(it3.next().getCTChartSpace().getDomNode(), str, str2);
                }
            }
        }
    }
}
