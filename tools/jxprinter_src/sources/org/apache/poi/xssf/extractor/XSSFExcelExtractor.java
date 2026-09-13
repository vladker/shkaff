package org.apache.poi.xssf.extractor;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.apache.logging.log4j.util.Chars;
import org.apache.poi.ooxml.extractor.POIXMLTextExtractor;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.extractor.ExcelExtractor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Comment;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.HeaderFooter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFDrawing;
import org.apache.poi.xssf.usermodel.XSSFRelation;
import org.apache.poi.xssf.usermodel.XSSFShape;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFSimpleShape;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XSSFExcelExtractor implements POIXMLTextExtractor, ExcelExtractor {
    public static final List<XSSFRelation> SUPPORTED_TYPES = Collections.unmodifiableList(Arrays.asList(XSSFRelation.WORKBOOK, XSSFRelation.MACRO_TEMPLATE_WORKBOOK, XSSFRelation.MACRO_ADDIN_WORKBOOK, XSSFRelation.TEMPLATE_WORKBOOK, XSSFRelation.MACROS_WORKBOOK));
    private boolean doCloseFilesystem;
    private boolean formulasNotResults;
    private boolean includeCellComments;
    private boolean includeHeadersFooters;
    private boolean includeSheetNames;
    private boolean includeTextBoxes;
    private Locale locale;
    private final XSSFWorkbook workbook;

    public XSSFExcelExtractor(OPCPackage oPCPackage) {
        this(new XSSFWorkbook(oPCPackage));
    }

    private String extractHeaderFooter(HeaderFooter headerFooter) {
        return org.apache.poi.hssf.extractor.ExcelExtractor._extractHeaderFooter(headerFooter);
    }

    private void handleNonStringCell(StringBuilder sb, Cell cell, DataFormatter dataFormatter) {
        CellStyle cellStyle;
        CellType cellType = cell.getCellType();
        if (cellType == CellType.FORMULA) {
            cellType = cell.getCachedFormulaResultType();
        }
        if (cellType == CellType.NUMERIC && (cellStyle = cell.getCellStyle()) != null && cellStyle.getDataFormatString() != null) {
            String rawCellContents = dataFormatter.formatRawCellContents(cell.getNumericCellValue(), cellStyle.getDataFormat(), cellStyle.getDataFormatString());
            checkMaxTextSize(sb, rawCellContents);
            sb.append(rawCellContents);
        } else {
            String rawValue = ((XSSFCell) cell).getRawValue();
            if (rawValue != null) {
                checkMaxTextSize(sb, rawValue);
                sb.append(rawValue);
            }
        }
    }

    private void handleStringCell(StringBuilder sb, Cell cell) {
        String string = cell.getRichStringCellValue().getString();
        checkMaxTextSize(sb, string);
        sb.append(string);
    }

    @Override // org.apache.poi.extractor.POITextExtractor
    public String getText() {
        XSSFDrawing drawingPatriarch;
        DataFormatter dataFormatter = this.locale == null ? new DataFormatter() : new DataFormatter(this.locale);
        StringBuilder sb = new StringBuilder(64);
        for (XSSFSheet xSSFSheet : this.workbook) {
            if (this.includeSheetNames) {
                sb.append(xSSFSheet.getSheetName());
                sb.append("\n");
            }
            if (this.includeHeadersFooters) {
                sb.append(extractHeaderFooter(xSSFSheet.getFirstHeader()));
                sb.append(extractHeaderFooter(xSSFSheet.getOddHeader()));
                sb.append(extractHeaderFooter(xSSFSheet.getEvenHeader()));
            }
            Iterator<Row> it = xSSFSheet.iterator();
            while (it.hasNext()) {
                Iterator<Cell> itCellIterator = it.next().cellIterator();
                while (itCellIterator.hasNext()) {
                    Cell next = itCellIterator.next();
                    if (next.getCellType() == CellType.FORMULA) {
                        if (this.formulasNotResults) {
                            String cellFormula = next.getCellFormula();
                            checkMaxTextSize(sb, cellFormula);
                            sb.append(cellFormula);
                        } else if (next.getCachedFormulaResultType() == CellType.STRING) {
                            handleStringCell(sb, next);
                        } else {
                            handleNonStringCell(sb, next, dataFormatter);
                        }
                    } else if (next.getCellType() == CellType.STRING) {
                        handleStringCell(sb, next);
                    } else {
                        handleNonStringCell(sb, next, dataFormatter);
                    }
                    Comment cellComment = next.getCellComment();
                    if (this.includeCellComments && cellComment != null) {
                        String strReplace = cellComment.getString().getString().replace('\n', Chars.SPACE);
                        checkMaxTextSize(sb, strReplace);
                        sb.append(" Comment by ");
                        sb.append(cellComment.getAuthor());
                        sb.append(": ");
                        sb.append(strReplace);
                    }
                    if (itCellIterator.hasNext()) {
                        sb.append("\t");
                    }
                }
                sb.append("\n");
            }
            if (this.includeTextBoxes && (drawingPatriarch = xSSFSheet.getDrawingPatriarch()) != null) {
                for (XSSFShape xSSFShape : drawingPatriarch.getShapes()) {
                    if (xSSFShape instanceof XSSFSimpleShape) {
                        String text = ((XSSFSimpleShape) xSSFShape).getText();
                        if (text.length() > 0) {
                            sb.append(text);
                            sb.append('\n');
                        }
                    }
                }
            }
            if (this.includeHeadersFooters) {
                sb.append(extractHeaderFooter(xSSFSheet.getFirstFooter()));
                sb.append(extractHeaderFooter(xSSFSheet.getOddFooter()));
                sb.append(extractHeaderFooter(xSSFSheet.getEvenFooter()));
            }
        }
        return sb.toString();
    }

    @Override // org.apache.poi.extractor.POITextExtractor
    public boolean isCloseFilesystem() {
        return this.doCloseFilesystem;
    }

    @Override // org.apache.poi.extractor.POITextExtractor
    public void setCloseFilesystem(boolean z6) {
        this.doCloseFilesystem = z6;
    }

    @Override // org.apache.poi.ss.extractor.ExcelExtractor
    public void setFormulasNotResults(boolean z6) {
        this.formulasNotResults = z6;
    }

    @Override // org.apache.poi.ss.extractor.ExcelExtractor
    public void setIncludeCellComments(boolean z6) {
        this.includeCellComments = z6;
    }

    @Override // org.apache.poi.ss.extractor.ExcelExtractor
    public void setIncludeHeadersFooters(boolean z6) {
        this.includeHeadersFooters = z6;
    }

    @Override // org.apache.poi.ss.extractor.ExcelExtractor
    public void setIncludeSheetNames(boolean z6) {
        this.includeSheetNames = z6;
    }

    public void setIncludeTextBoxes(boolean z6) {
        this.includeTextBoxes = z6;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    public XSSFExcelExtractor(XSSFWorkbook xSSFWorkbook) {
        this.includeSheetNames = true;
        this.includeHeadersFooters = true;
        this.includeTextBoxes = true;
        this.doCloseFilesystem = true;
        this.workbook = xSSFWorkbook;
    }

    @Override // org.apache.poi.extractor.POITextExtractor
    public XSSFWorkbook getFilesystem() {
        return this.workbook;
    }

    @Override // org.apache.poi.ooxml.extractor.POIXMLTextExtractor, org.apache.poi.extractor.POITextExtractor
    public XSSFWorkbook getDocument() {
        return this.workbook;
    }
}
