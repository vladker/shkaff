package org.apache.poi.xssf.usermodel.helpers;

import java.util.ArrayList;
import java.util.Iterator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.util.Unbox;
import org.apache.poi.ss.formula.FormulaParseException;
import org.apache.poi.ss.formula.FormulaParser;
import org.apache.poi.ss.formula.FormulaRenderer;
import org.apache.poi.ss.formula.FormulaShifter;
import org.apache.poi.ss.formula.FormulaType;
import org.apache.poi.ss.formula.ptg.Ptg;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Hyperlink;
import org.apache.poi.ss.usermodel.Name;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.helpers.BaseRowColShifter;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.util.Internal;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFEvaluationWorkbook;
import org.apache.poi.xssf.usermodel.XSSFHyperlink;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCell;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCellFormula;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTConditionalFormatting;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STCellFormulaType;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Internal
final class XSSFRowColShifter {
    private static final Logger LOG = LogManager.getLogger((Class<?>) XSSFRowColShifter.class);

    private XSSFRowColShifter() {
    }

    public static String shiftFormula(Row row, String str, FormulaShifter formulaShifter) {
        Sheet sheet = row.getSheet();
        Workbook workbook = sheet.getWorkbook();
        int sheetIndex = workbook.getSheetIndex(sheet);
        int rowNum = row.getRowNum();
        XSSFEvaluationWorkbook xSSFEvaluationWorkbookCreate = XSSFEvaluationWorkbook.create((XSSFWorkbook) workbook);
        try {
            Ptg[] ptgArr = FormulaParser.parse(str, xSSFEvaluationWorkbookCreate, FormulaType.CELL, sheetIndex, rowNum);
            if (formulaShifter.adjustFormula(ptgArr, sheetIndex)) {
                return FormulaRenderer.toFormulaString(xSSFEvaluationWorkbookCreate, ptgArr);
            }
            return null;
        } catch (FormulaParseException e) {
            LOG.atWarn().withThrowable(e).log("Error shifting formula on row {}", Unbox.box(row.getRowNum()));
            return str;
        }
    }

    /* JADX WARN: Code duplicated, block: B:28:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:31:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:33:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:54:0x00c9 A[SYNTHETIC] */
    public static void updateConditionalFormatting(Sheet sheet, FormulaShifter formulaShifter) {
        int i5;
        String[] formulaArray;
        int i6;
        Ptg[] ptgArr;
        XSSFSheet xSSFSheet = (XSSFSheet) sheet;
        XSSFWorkbook workbook = xSSFSheet.getWorkbook();
        int sheetIndex = workbook.getSheetIndex(sheet);
        XSSFEvaluationWorkbook xSSFEvaluationWorkbookCreate = XSSFEvaluationWorkbook.create(workbook);
        CTWorksheet cTWorksheet = xSSFSheet.getCTWorksheet();
        CTConditionalFormatting[] conditionalFormattingArray = cTWorksheet.getConditionalFormattingArray();
        boolean z6 = true;
        int length = conditionalFormattingArray.length - 1;
        while (length >= 0) {
            CTConditionalFormatting cTConditionalFormatting = conditionalFormattingArray[length];
            ArrayList arrayList = new ArrayList();
            Iterator it = cTConditionalFormatting.getSqref().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                for (String str : it.next().toString().split(" ")) {
                    arrayList.add(CellRangeAddress.valueOf(str));
                }
            }
            ArrayList arrayList2 = new ArrayList();
            int size = arrayList.size();
            boolean z7 = false;
            int i7 = 0;
            while (i7 < size) {
                Object obj = arrayList.get(i7);
                i7++;
                CellRangeAddress cellRangeAddress = (CellRangeAddress) obj;
                CellRangeAddress cellRangeAddressShiftRange = BaseRowColShifter.shiftRange(formulaShifter, cellRangeAddress, sheetIndex);
                if (cellRangeAddressShiftRange != null) {
                    arrayList2.add(cellRangeAddressShiftRange);
                    if (cellRangeAddressShiftRange != cellRangeAddress) {
                    }
                }
                z7 = z6;
            }
            if (!z7) {
                for (CTCfRule cTCfRule : cTConditionalFormatting.getCfRuleArray()) {
                    formulaArray = cTCfRule.getFormulaArray();
                    for (i6 = 0; i6 < formulaArray.length; i6++) {
                        ptgArr = FormulaParser.parse(formulaArray[i6], xSSFEvaluationWorkbookCreate, FormulaType.CELL, sheetIndex, -1);
                        if (formulaShifter.adjustFormula(ptgArr, sheetIndex)) {
                            cTCfRule.setFormulaArray(i6, FormulaRenderer.toFormulaString(xSSFEvaluationWorkbookCreate, ptgArr));
                        }
                    }
                }
            } else if (arrayList2.size() == 0) {
                cTWorksheet.removeConditionalFormatting(length);
            } else {
                ArrayList arrayList3 = new ArrayList();
                int size2 = arrayList2.size();
                int i8 = 0;
                while (i8 < size2) {
                    Object obj2 = arrayList2.get(i8);
                    i8++;
                    arrayList3.add(((CellRangeAddress) obj2).formatAsString());
                }
                cTConditionalFormatting.setSqref(arrayList3);
                while (i5 < r8) {
                    formulaArray = cTCfRule.getFormulaArray();
                    while (i6 < formulaArray.length) {
                        ptgArr = FormulaParser.parse(formulaArray[i6], xSSFEvaluationWorkbookCreate, FormulaType.CELL, sheetIndex, -1);
                        if (formulaShifter.adjustFormula(ptgArr, sheetIndex)) {
                            cTCfRule.setFormulaArray(i6, FormulaRenderer.toFormulaString(xSSFEvaluationWorkbookCreate, ptgArr));
                        }
                    }
                }
            }
            length--;
            z6 = true;
        }
    }

    public static void updateFormulas(Sheet sheet, FormulaShifter formulaShifter) {
        updateSheetFormulas(sheet, formulaShifter);
        for (Sheet sheet2 : sheet.getWorkbook()) {
            if (sheet != sheet2) {
                updateSheetFormulas(sheet2, formulaShifter);
            }
        }
    }

    public static void updateHyperlinks(Sheet sheet, FormulaShifter formulaShifter) {
        int sheetIndex = sheet.getWorkbook().getSheetIndex(sheet);
        Iterator<? extends Hyperlink> it = sheet.getHyperlinkList().iterator();
        while (it.hasNext()) {
            XSSFHyperlink xSSFHyperlink = (XSSFHyperlink) it.next();
            CellRangeAddress cellRangeAddressValueOf = CellRangeAddress.valueOf(xSSFHyperlink.getCellRef());
            CellRangeAddress cellRangeAddressShiftRange = BaseRowColShifter.shiftRange(formulaShifter, cellRangeAddressValueOf, sheetIndex);
            if (cellRangeAddressShiftRange != null && cellRangeAddressShiftRange != cellRangeAddressValueOf) {
                xSSFHyperlink.setCellReference(cellRangeAddressShiftRange.formatAsString());
            }
        }
    }

    public static void updateNamedRanges(Sheet sheet, FormulaShifter formulaShifter) {
        Workbook workbook = sheet.getWorkbook();
        XSSFEvaluationWorkbook xSSFEvaluationWorkbookCreate = XSSFEvaluationWorkbook.create((XSSFWorkbook) workbook);
        for (Name name : workbook.getAllNames()) {
            String refersToFormula = name.getRefersToFormula();
            int sheetIndex = name.getSheetIndex();
            Ptg[] ptgArr = FormulaParser.parse(refersToFormula, xSSFEvaluationWorkbookCreate, FormulaType.NAMEDRANGE, sheetIndex, -1);
            if (formulaShifter.adjustFormula(ptgArr, sheetIndex)) {
                name.setRefersToFormula(FormulaRenderer.toFormulaString(xSSFEvaluationWorkbookCreate, ptgArr));
            }
        }
    }

    public static void updateRefInCTCellFormula(Row row, FormulaShifter formulaShifter, CTCellFormula cTCellFormula) {
        String strShiftFormula;
        if (!cTCellFormula.isSetRef() || (strShiftFormula = shiftFormula(row, cTCellFormula.getRef(), formulaShifter)) == null) {
            return;
        }
        cTCellFormula.setRef(strShiftFormula);
    }

    public static void updateRowFormulas(XSSFRow xSSFRow, FormulaShifter formulaShifter) {
        String strShiftFormula;
        XSSFSheet sheet = xSSFRow.getSheet();
        Iterator<Cell> it = xSSFRow.iterator();
        while (it.hasNext()) {
            CTCell cTCell = ((XSSFCell) it.next()).getCTCell();
            if (cTCell.isSetF()) {
                CTCellFormula f6 = cTCell.getF();
                String stringValue = f6.getStringValue();
                if (stringValue.length() > 0 && (strShiftFormula = shiftFormula(xSSFRow, stringValue, formulaShifter)) != null) {
                    f6.setStringValue(strShiftFormula);
                    if (f6.getT() == STCellFormulaType.SHARED) {
                        CTCellFormula sharedFormula = sheet.getSharedFormula(Math.toIntExact(f6.getSi()));
                        sharedFormula.setStringValue(strShiftFormula);
                        updateRefInCTCellFormula(xSSFRow, formulaShifter, sharedFormula);
                    }
                }
                updateRefInCTCellFormula(xSSFRow, formulaShifter, f6);
            }
        }
    }

    public static void updateSheetFormulas(Sheet sheet, FormulaShifter formulaShifter) {
        Iterator<Row> it = sheet.iterator();
        while (it.hasNext()) {
            updateRowFormulas((XSSFRow) it.next(), formulaShifter);
        }
    }
}
