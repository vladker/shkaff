package org.apache.poi.ss.util;

import java.awt.Rectangle;
import java.awt.font.FontRenderContext;
import java.awt.font.TextAttribute;
import java.awt.font.TextLayout;
import java.awt.geom.AffineTransform;
import java.text.AttributedString;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.util.Internal;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class SheetUtil {
    public static final int DEFAULT_CHAR_WIDTH = 5;
    private static final char defaultChar = '0';
    private static final double fontHeightMultiple = 2.0d;
    private static final FormulaEvaluator dummyEvaluator = new FormulaEvaluator() { // from class: org.apache.poi.ss.util.SheetUtil.1
        @Override // org.apache.poi.ss.usermodel.FormulaEvaluator
        public CellValue evaluate(Cell cell) {
            return null;
        }

        @Override // org.apache.poi.ss.usermodel.FormulaEvaluator
        public CellType evaluateFormulaCell(Cell cell) {
            return cell.getCachedFormulaResultType();
        }

        @Override // org.apache.poi.ss.usermodel.FormulaEvaluator
        public Cell evaluateInCell(Cell cell) {
            return null;
        }

        @Override // org.apache.poi.ss.usermodel.FormulaEvaluator
        public void clearAllCachedResultValues() {
        }

        @Override // org.apache.poi.ss.usermodel.FormulaEvaluator
        public void evaluateAll() {
        }

        @Override // org.apache.poi.ss.usermodel.FormulaEvaluator
        public void notifyDeleteCell(Cell cell) {
        }

        @Override // org.apache.poi.ss.usermodel.FormulaEvaluator
        public void notifySetFormula(Cell cell) {
        }

        @Override // org.apache.poi.ss.usermodel.FormulaEvaluator
        public void notifyUpdateCell(Cell cell) {
        }

        @Override // org.apache.poi.ss.usermodel.FormulaEvaluator
        public void setDebugEvaluationOutputForNextEval(boolean z6) {
        }

        @Override // org.apache.poi.ss.usermodel.FormulaEvaluator
        public void setIgnoreMissingWorkbooks(boolean z6) {
        }

        @Override // org.apache.poi.ss.usermodel.FormulaEvaluator
        public void setupReferencedWorkbooks(Map<String, FormulaEvaluator> map) {
        }
    };
    private static final FontRenderContext fontRenderContext = new FontRenderContext((AffineTransform) null, true, true);
    private static final boolean ignoreMissingFontSystem = Boolean.parseBoolean(System.getProperty("org.apache.poi.ss.ignoreMissingFontSystem"));

    public static boolean canComputeColumnWidth(Font font) {
        AttributedString attributedString = new AttributedString("1w");
        copyAttributes(font, attributedString, 0, 2);
        return new TextLayout(attributedString.getIterator(), fontRenderContext).getBounds().getWidth() > 0.0d;
    }

    private static void copyAttributes(Font font, AttributedString attributedString, int i5, int i6) {
        attributedString.addAttribute(TextAttribute.FAMILY, font.getFontName(), i5, i6);
        attributedString.addAttribute(TextAttribute.SIZE, Float.valueOf(font.getFontHeightInPoints()));
        if (font.getBold()) {
            attributedString.addAttribute(TextAttribute.WEIGHT, TextAttribute.WEIGHT_BOLD, i5, i6);
        }
        if (font.getItalic()) {
            attributedString.addAttribute(TextAttribute.POSTURE, TextAttribute.POSTURE_OBLIQUE, i5, i6);
        }
        if (font.getUnderline() == 1) {
            attributedString.addAttribute(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON, i5, i6);
        }
    }

    public static Cell getCell(Sheet sheet, int i5, int i6) {
        Row row = sheet.getRow(i5);
        if (row != null) {
            return row.getCell(i6);
        }
        return null;
    }

    public static double getCellWidth(Cell cell, int i5, DataFormatter dataFormatter, boolean z6) {
        return getCellWidth(cell, i5, dataFormatter, z6, cell.getSheet().getMergedRegions());
    }

    public static Cell getCellWithMerges(Sheet sheet, int i5, int i6) {
        Row row;
        Cell cell = getCell(sheet, i5, i6);
        if (cell != null) {
            return cell;
        }
        for (CellRangeAddress cellRangeAddress : sheet.getMergedRegions()) {
            if (cellRangeAddress.isInRange(i5, i6) && (row = sheet.getRow(cellRangeAddress.getFirstRow())) != null) {
                return row.getCell(cellRangeAddress.getFirstColumn());
            }
        }
        return null;
    }

    public static double getColumnWidth(Sheet sheet, int i5, boolean z6) {
        return getColumnWidth(sheet, i5, z6, sheet.getFirstRowNum(), sheet.getLastRowNum());
    }

    private static double getColumnWidthForRow(Row row, int i5, int i6, DataFormatter dataFormatter, boolean z6, List<CellRangeAddress> list) {
        Cell cell;
        if (row == null || (cell = row.getCell(i5)) == null) {
            return -1.0d;
        }
        return getCellWidth(cell, i6, dataFormatter, z6, list);
    }

    @Internal
    public static int getDefaultCharWidth(Workbook workbook) {
        Font fontAt = workbook.getFontAt(0);
        AttributedString attributedString = new AttributedString(String.valueOf(defaultChar));
        copyAttributes(fontAt, attributedString, 0, 1);
        try {
            return (int) new TextLayout(attributedString.getIterator(), fontRenderContext).getAdvance();
        } catch (InternalError | NoClassDefFoundError | UnsatisfiedLinkError e) {
            if (ignoreMissingFontSystem) {
                return 5;
            }
            throw e;
        }
    }

    public static double getColumnWidth(Sheet sheet, int i5, boolean z6, int i6, int i7) {
        DataFormatter dataFormatter = new DataFormatter();
        int defaultCharWidth = getDefaultCharWidth(sheet.getWorkbook());
        List<CellRangeAddress> mergedRegions = sheet.getMergedRegions();
        double dMax = -1.0d;
        while (i6 <= i7) {
            Row row = sheet.getRow(i6);
            int i8 = i5;
            boolean z7 = z6;
            if (row != null) {
                dMax = Math.max(dMax, getColumnWidthForRow(row, i8, defaultCharWidth, dataFormatter, z7, mergedRegions));
            }
            i6++;
            i5 = i8;
            z6 = z7;
        }
        return dMax;
    }

    public static double getCellWidth(Cell cell, int i5, DataFormatter dataFormatter, boolean z6, List<CellRangeAddress> list) {
        String strValueOf;
        Workbook workbook = cell.getSheet().getWorkbook();
        Row row = cell.getRow();
        int columnIndex = cell.getColumnIndex();
        int lastColumn = 1;
        for (CellRangeAddress cellRangeAddress : list) {
            if (cellRangeAddress.isInRange(row.getRowNum(), columnIndex)) {
                if (!z6) {
                    return -1.0d;
                }
                cell = row.getCell(cellRangeAddress.getFirstColumn());
                lastColumn = (cellRangeAddress.getLastColumn() + 1) - cellRangeAddress.getFirstColumn();
            }
        }
        CellStyle cellStyle = cell.getCellStyle();
        CellType cellType = cell.getCellType();
        if (cellType == CellType.FORMULA) {
            cellType = cell.getCachedFormulaResultType();
        }
        Font fontAt = workbook.getFontAt(cellStyle.getFontIndex());
        double cellWidth = -1.0d;
        if (cellType == CellType.STRING) {
            RichTextString richStringCellValue = cell.getRichStringCellValue();
            if (richStringCellValue != null && richStringCellValue.getString() != null) {
                for (String str : richStringCellValue.getString().split("\\n")) {
                    String str2 = str + defaultChar;
                    AttributedString attributedString = new AttributedString(str2);
                    copyAttributes(fontAt, attributedString, 0, str2.length());
                    cellWidth = getCellWidth(i5, lastColumn, cellStyle, cellWidth, attributedString);
                }
            }
            return cellWidth;
        }
        if (cellType == CellType.NUMERIC) {
            try {
                strValueOf = dataFormatter.formatCellValue(cell, dummyEvaluator);
            } catch (Exception unused) {
                strValueOf = String.valueOf(cell.getNumericCellValue());
            }
        } else {
            strValueOf = cellType == CellType.BOOLEAN ? String.valueOf(cell.getBooleanCellValue()).toUpperCase(Locale.ROOT) : null;
        }
        if (strValueOf == null) {
            return -1.0d;
        }
        String strConcat = strValueOf.concat("0");
        AttributedString attributedString2 = new AttributedString(strConcat);
        copyAttributes(fontAt, attributedString2, 0, strConcat.length());
        return getCellWidth(i5, lastColumn, cellStyle, -1.0d, attributedString2);
    }

    private static double getCellWidth(int i5, int i6, CellStyle cellStyle, double d, AttributedString attributedString) {
        Rectangle bounds;
        TextLayout textLayout = new TextLayout(attributedString.getIterator(), fontRenderContext);
        if (cellStyle.getRotation() != 0) {
            AffineTransform affineTransform = new AffineTransform();
            affineTransform.concatenate(AffineTransform.getRotateInstance(((((double) cellStyle.getRotation()) * fontHeightMultiple) * 3.141592653589793d) / 360.0d));
            affineTransform.concatenate(AffineTransform.getScaleInstance(1.0d, fontHeightMultiple));
            bounds = textLayout.getOutline(affineTransform).getBounds();
        } else {
            bounds = textLayout.getBounds();
        }
        return Math.max(d, (((bounds.getX() + bounds.getWidth()) / ((double) i6)) / ((double) i5)) + ((double) cellStyle.getIndention()));
    }
}
