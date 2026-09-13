package org.apache.poi.ss.util;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.usermodel.BorderExtent;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class PropertyTemplate {
    private final Map<CellAddress, Map<String, Object>> _propertyTemplate;

    /* JADX INFO: renamed from: org.apache.poi.ss.util.PropertyTemplate$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$ss$usermodel$BorderExtent;

        static {
            int[] iArr = new int[BorderExtent.values().length];
            $SwitchMap$org$apache$poi$ss$usermodel$BorderExtent = iArr;
            try {
                iArr[BorderExtent.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$BorderExtent[BorderExtent.ALL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$BorderExtent[BorderExtent.INSIDE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$BorderExtent[BorderExtent.OUTSIDE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$BorderExtent[BorderExtent.TOP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$BorderExtent[BorderExtent.BOTTOM.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$BorderExtent[BorderExtent.LEFT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$BorderExtent[BorderExtent.RIGHT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$BorderExtent[BorderExtent.HORIZONTAL.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$BorderExtent[BorderExtent.INSIDE_HORIZONTAL.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$BorderExtent[BorderExtent.OUTSIDE_HORIZONTAL.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$BorderExtent[BorderExtent.VERTICAL.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$BorderExtent[BorderExtent.INSIDE_VERTICAL.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$BorderExtent[BorderExtent.OUTSIDE_VERTICAL.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
        }
    }

    public PropertyTemplate() {
        this._propertyTemplate = new HashMap();
    }

    private void addProperty(int i5, int i6, String str, short s6) {
        addProperty(i5, i6, str, Short.valueOf(s6));
    }

    private static Map<String, Object> cloneCellProperties(Map<String, Object> map) {
        return new HashMap(map);
    }

    private void drawBottomBorder(CellRangeAddress cellRangeAddress, BorderStyle borderStyle) {
        int lastRow = cellRangeAddress.getLastRow();
        int lastColumn = cellRangeAddress.getLastColumn();
        for (int firstColumn = cellRangeAddress.getFirstColumn(); firstColumn <= lastColumn; firstColumn++) {
            addProperty(lastRow, firstColumn, CellUtil.BORDER_BOTTOM, borderStyle);
            if (borderStyle == BorderStyle.NONE && lastRow < SpreadsheetVersion.EXCEL2007.getMaxRows() - 1) {
                addProperty(lastRow + 1, firstColumn, CellUtil.BORDER_TOP, borderStyle);
            }
        }
    }

    private void drawBottomBorderColor(CellRangeAddress cellRangeAddress, short s6) {
        int lastRow = cellRangeAddress.getLastRow();
        int lastColumn = cellRangeAddress.getLastColumn();
        for (int firstColumn = cellRangeAddress.getFirstColumn(); firstColumn <= lastColumn; firstColumn++) {
            if (getBorderStyle(lastRow, firstColumn, CellUtil.BORDER_BOTTOM) == BorderStyle.NONE) {
                drawBottomBorder(new CellRangeAddress(lastRow, lastRow, firstColumn, firstColumn), BorderStyle.THIN);
            }
            addProperty(lastRow, firstColumn, CellUtil.BOTTOM_BORDER_COLOR, s6);
        }
    }

    private void drawHorizontalBorderColors(CellRangeAddress cellRangeAddress, short s6, BorderExtent borderExtent) {
        int i5 = AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$BorderExtent[borderExtent.ordinal()];
        if (i5 != 2 && i5 != 3) {
            throw new IllegalArgumentException("Unsupported PropertyTemplate.Extent, valid Extents are ALL and INSIDE");
        }
        int firstRow = cellRangeAddress.getFirstRow();
        int lastRow = cellRangeAddress.getLastRow();
        int firstColumn = cellRangeAddress.getFirstColumn();
        int lastColumn = cellRangeAddress.getLastColumn();
        for (int i6 = firstRow; i6 <= lastRow; i6++) {
            CellRangeAddress cellRangeAddress2 = new CellRangeAddress(i6, i6, firstColumn, lastColumn);
            BorderExtent borderExtent2 = BorderExtent.ALL;
            if (borderExtent == borderExtent2 || i6 > firstRow) {
                drawTopBorderColor(cellRangeAddress2, s6);
            }
            if (borderExtent == borderExtent2 || i6 < lastRow) {
                drawBottomBorderColor(cellRangeAddress2, s6);
            }
        }
    }

    private void drawHorizontalBorders(CellRangeAddress cellRangeAddress, BorderStyle borderStyle, BorderExtent borderExtent) {
        int i5 = AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$BorderExtent[borderExtent.ordinal()];
        if (i5 != 2 && i5 != 3) {
            throw new IllegalArgumentException("Unsupported PropertyTemplate.Extent, valid Extents are ALL and INSIDE");
        }
        int firstRow = cellRangeAddress.getFirstRow();
        int lastRow = cellRangeAddress.getLastRow();
        int firstColumn = cellRangeAddress.getFirstColumn();
        int lastColumn = cellRangeAddress.getLastColumn();
        for (int i6 = firstRow; i6 <= lastRow; i6++) {
            CellRangeAddress cellRangeAddress2 = new CellRangeAddress(i6, i6, firstColumn, lastColumn);
            BorderExtent borderExtent2 = BorderExtent.ALL;
            if (borderExtent == borderExtent2 || i6 > firstRow) {
                drawTopBorder(cellRangeAddress2, borderStyle);
            }
            if (borderExtent == borderExtent2 || i6 < lastRow) {
                drawBottomBorder(cellRangeAddress2, borderStyle);
            }
        }
    }

    private void drawLeftBorder(CellRangeAddress cellRangeAddress, BorderStyle borderStyle) {
        int lastRow = cellRangeAddress.getLastRow();
        int firstColumn = cellRangeAddress.getFirstColumn();
        for (int firstRow = cellRangeAddress.getFirstRow(); firstRow <= lastRow; firstRow++) {
            addProperty(firstRow, firstColumn, CellUtil.BORDER_LEFT, borderStyle);
            if (borderStyle == BorderStyle.NONE && firstColumn > 0) {
                addProperty(firstRow, firstColumn - 1, CellUtil.BORDER_RIGHT, borderStyle);
            }
        }
    }

    private void drawLeftBorderColor(CellRangeAddress cellRangeAddress, short s6) {
        int lastRow = cellRangeAddress.getLastRow();
        int firstColumn = cellRangeAddress.getFirstColumn();
        for (int firstRow = cellRangeAddress.getFirstRow(); firstRow <= lastRow; firstRow++) {
            if (getBorderStyle(firstRow, firstColumn, CellUtil.BORDER_LEFT) == BorderStyle.NONE) {
                drawLeftBorder(new CellRangeAddress(firstRow, firstRow, firstColumn, firstColumn), BorderStyle.THIN);
            }
            addProperty(firstRow, firstColumn, CellUtil.LEFT_BORDER_COLOR, s6);
        }
    }

    private void drawOutsideBorderColors(CellRangeAddress cellRangeAddress, short s6, BorderExtent borderExtent) {
        int i5 = AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$BorderExtent[borderExtent.ordinal()];
        if (i5 != 2 && i5 != 9 && i5 != 12) {
            throw new IllegalArgumentException("Unsupported PropertyTemplate.Extent, valid Extents are ALL, HORIZONTAL, and VERTICAL");
        }
        BorderExtent borderExtent2 = BorderExtent.ALL;
        if (borderExtent == borderExtent2 || borderExtent == BorderExtent.HORIZONTAL) {
            drawTopBorderColor(cellRangeAddress, s6);
            drawBottomBorderColor(cellRangeAddress, s6);
        }
        if (borderExtent == borderExtent2 || borderExtent == BorderExtent.VERTICAL) {
            drawLeftBorderColor(cellRangeAddress, s6);
            drawRightBorderColor(cellRangeAddress, s6);
        }
    }

    private void drawOutsideBorders(CellRangeAddress cellRangeAddress, BorderStyle borderStyle, BorderExtent borderExtent) {
        int i5 = AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$BorderExtent[borderExtent.ordinal()];
        if (i5 != 2 && i5 != 9 && i5 != 12) {
            throw new IllegalArgumentException("Unsupported PropertyTemplate.Extent, valid Extents are ALL, HORIZONTAL, and VERTICAL");
        }
        BorderExtent borderExtent2 = BorderExtent.ALL;
        if (borderExtent == borderExtent2 || borderExtent == BorderExtent.HORIZONTAL) {
            drawTopBorder(cellRangeAddress, borderStyle);
            drawBottomBorder(cellRangeAddress, borderStyle);
        }
        if (borderExtent == borderExtent2 || borderExtent == BorderExtent.VERTICAL) {
            drawLeftBorder(cellRangeAddress, borderStyle);
            drawRightBorder(cellRangeAddress, borderStyle);
        }
    }

    private void drawRightBorder(CellRangeAddress cellRangeAddress, BorderStyle borderStyle) {
        int lastRow = cellRangeAddress.getLastRow();
        int lastColumn = cellRangeAddress.getLastColumn();
        for (int firstRow = cellRangeAddress.getFirstRow(); firstRow <= lastRow; firstRow++) {
            addProperty(firstRow, lastColumn, CellUtil.BORDER_RIGHT, borderStyle);
            if (borderStyle == BorderStyle.NONE && lastColumn < SpreadsheetVersion.EXCEL2007.getMaxColumns() - 1) {
                addProperty(firstRow, lastColumn + 1, CellUtil.BORDER_LEFT, borderStyle);
            }
        }
    }

    private void drawRightBorderColor(CellRangeAddress cellRangeAddress, short s6) {
        int lastRow = cellRangeAddress.getLastRow();
        int lastColumn = cellRangeAddress.getLastColumn();
        for (int firstRow = cellRangeAddress.getFirstRow(); firstRow <= lastRow; firstRow++) {
            if (getBorderStyle(firstRow, lastColumn, CellUtil.BORDER_RIGHT) == BorderStyle.NONE) {
                drawRightBorder(new CellRangeAddress(firstRow, firstRow, lastColumn, lastColumn), BorderStyle.THIN);
            }
            addProperty(firstRow, lastColumn, CellUtil.RIGHT_BORDER_COLOR, s6);
        }
    }

    private void drawTopBorder(CellRangeAddress cellRangeAddress, BorderStyle borderStyle) {
        int firstRow = cellRangeAddress.getFirstRow();
        int lastColumn = cellRangeAddress.getLastColumn();
        for (int firstColumn = cellRangeAddress.getFirstColumn(); firstColumn <= lastColumn; firstColumn++) {
            addProperty(firstRow, firstColumn, CellUtil.BORDER_TOP, borderStyle);
            if (borderStyle == BorderStyle.NONE && firstRow > 0) {
                addProperty(firstRow - 1, firstColumn, CellUtil.BORDER_BOTTOM, borderStyle);
            }
        }
    }

    private void drawTopBorderColor(CellRangeAddress cellRangeAddress, short s6) {
        int firstRow = cellRangeAddress.getFirstRow();
        int lastColumn = cellRangeAddress.getLastColumn();
        for (int firstColumn = cellRangeAddress.getFirstColumn(); firstColumn <= lastColumn; firstColumn++) {
            if (getBorderStyle(firstRow, firstColumn, CellUtil.BORDER_TOP) == BorderStyle.NONE) {
                drawTopBorder(new CellRangeAddress(firstRow, firstRow, firstColumn, firstColumn), BorderStyle.THIN);
            }
            addProperty(firstRow, firstColumn, CellUtil.TOP_BORDER_COLOR, s6);
        }
    }

    private void drawVerticalBorderColors(CellRangeAddress cellRangeAddress, short s6, BorderExtent borderExtent) {
        int i5 = AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$BorderExtent[borderExtent.ordinal()];
        if (i5 != 2 && i5 != 3) {
            throw new IllegalArgumentException("Unsupported PropertyTemplate.Extent, valid Extents are ALL and INSIDE");
        }
        int firstRow = cellRangeAddress.getFirstRow();
        int lastRow = cellRangeAddress.getLastRow();
        int firstColumn = cellRangeAddress.getFirstColumn();
        int lastColumn = cellRangeAddress.getLastColumn();
        for (int i6 = firstColumn; i6 <= lastColumn; i6++) {
            CellRangeAddress cellRangeAddress2 = new CellRangeAddress(firstRow, lastRow, i6, i6);
            BorderExtent borderExtent2 = BorderExtent.ALL;
            if (borderExtent == borderExtent2 || i6 > firstColumn) {
                drawLeftBorderColor(cellRangeAddress2, s6);
            }
            if (borderExtent == borderExtent2 || i6 < lastColumn) {
                drawRightBorderColor(cellRangeAddress2, s6);
            }
        }
    }

    private void drawVerticalBorders(CellRangeAddress cellRangeAddress, BorderStyle borderStyle, BorderExtent borderExtent) {
        int i5 = AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$BorderExtent[borderExtent.ordinal()];
        if (i5 != 2 && i5 != 3) {
            throw new IllegalArgumentException("Unsupported PropertyTemplate.Extent, valid Extents are ALL and INSIDE");
        }
        int firstRow = cellRangeAddress.getFirstRow();
        int lastRow = cellRangeAddress.getLastRow();
        int firstColumn = cellRangeAddress.getFirstColumn();
        int lastColumn = cellRangeAddress.getLastColumn();
        for (int i6 = firstColumn; i6 <= lastColumn; i6++) {
            CellRangeAddress cellRangeAddress2 = new CellRangeAddress(firstRow, lastRow, i6, i6);
            BorderExtent borderExtent2 = BorderExtent.ALL;
            if (borderExtent == borderExtent2 || i6 > firstColumn) {
                drawLeftBorder(cellRangeAddress2, borderStyle);
            }
            if (borderExtent == borderExtent2 || i6 < lastColumn) {
                drawRightBorder(cellRangeAddress2, borderStyle);
            }
        }
    }

    private static short getShort(Object obj) {
        if (obj instanceof Number) {
            return ((Number) obj).shortValue();
        }
        return (short) 0;
    }

    private Map<CellAddress, Map<String, Object>> getTemplate() {
        return this._propertyTemplate;
    }

    private void removeBorderColors(CellRangeAddress cellRangeAddress) {
        HashSet hashSet = new HashSet();
        hashSet.add(CellUtil.TOP_BORDER_COLOR);
        hashSet.add(CellUtil.BOTTOM_BORDER_COLOR);
        hashSet.add(CellUtil.LEFT_BORDER_COLOR);
        hashSet.add(CellUtil.RIGHT_BORDER_COLOR);
        for (int firstRow = cellRangeAddress.getFirstRow(); firstRow <= cellRangeAddress.getLastRow(); firstRow++) {
            for (int firstColumn = cellRangeAddress.getFirstColumn(); firstColumn <= cellRangeAddress.getLastColumn(); firstColumn++) {
                removeProperties(firstRow, firstColumn, hashSet);
            }
        }
    }

    private void removeBorders(CellRangeAddress cellRangeAddress) {
        HashSet hashSet = new HashSet();
        hashSet.add(CellUtil.BORDER_TOP);
        hashSet.add(CellUtil.BORDER_BOTTOM);
        hashSet.add(CellUtil.BORDER_LEFT);
        hashSet.add(CellUtil.BORDER_RIGHT);
        for (int firstRow = cellRangeAddress.getFirstRow(); firstRow <= cellRangeAddress.getLastRow(); firstRow++) {
            for (int firstColumn = cellRangeAddress.getFirstColumn(); firstColumn <= cellRangeAddress.getLastColumn(); firstColumn++) {
                removeProperties(firstRow, firstColumn, hashSet);
            }
        }
        removeBorderColors(cellRangeAddress);
    }

    private void removeProperties(int i5, int i6, Set<String> set) {
        CellAddress cellAddress = new CellAddress(i5, i6);
        Map<String, Object> map = this._propertyTemplate.get(cellAddress);
        if (map != null) {
            map.keySet().removeAll(set);
            if (map.isEmpty()) {
                this._propertyTemplate.remove(cellAddress);
            } else {
                this._propertyTemplate.put(cellAddress, map);
            }
        }
    }

    public void applyBorders(Sheet sheet) {
        Workbook workbook = sheet.getWorkbook();
        for (Map.Entry<CellAddress, Map<String, Object>> entry : this._propertyTemplate.entrySet()) {
            CellAddress key = entry.getKey();
            if (key.getRow() < workbook.getSpreadsheetVersion().getMaxRows() && key.getColumn() < workbook.getSpreadsheetVersion().getMaxColumns()) {
                CellUtil.setCellStyleProperties(CellUtil.getCell(CellUtil.getRow(key.getRow(), sheet), key.getColumn()), entry.getValue());
            }
        }
    }

    public void drawBorderColors(CellRangeAddress cellRangeAddress, short s6, BorderExtent borderExtent) {
        switch (AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$BorderExtent[borderExtent.ordinal()]) {
            case 1:
                removeBorderColors(cellRangeAddress);
                break;
            case 2:
                BorderExtent borderExtent2 = BorderExtent.ALL;
                drawHorizontalBorderColors(cellRangeAddress, s6, borderExtent2);
                drawVerticalBorderColors(cellRangeAddress, s6, borderExtent2);
                break;
            case 3:
                BorderExtent borderExtent3 = BorderExtent.INSIDE;
                drawHorizontalBorderColors(cellRangeAddress, s6, borderExtent3);
                drawVerticalBorderColors(cellRangeAddress, s6, borderExtent3);
                break;
            case 4:
                drawOutsideBorderColors(cellRangeAddress, s6, BorderExtent.ALL);
                break;
            case 5:
                drawTopBorderColor(cellRangeAddress, s6);
                break;
            case 6:
                drawBottomBorderColor(cellRangeAddress, s6);
                break;
            case 7:
                drawLeftBorderColor(cellRangeAddress, s6);
                break;
            case 8:
                drawRightBorderColor(cellRangeAddress, s6);
                break;
            case 9:
                drawHorizontalBorderColors(cellRangeAddress, s6, BorderExtent.ALL);
                break;
            case 10:
                drawHorizontalBorderColors(cellRangeAddress, s6, BorderExtent.INSIDE);
                break;
            case 11:
                drawOutsideBorderColors(cellRangeAddress, s6, BorderExtent.HORIZONTAL);
                break;
            case 12:
                drawVerticalBorderColors(cellRangeAddress, s6, BorderExtent.ALL);
                break;
            case 13:
                drawVerticalBorderColors(cellRangeAddress, s6, BorderExtent.INSIDE);
                break;
            case 14:
                drawOutsideBorderColors(cellRangeAddress, s6, BorderExtent.VERTICAL);
                break;
        }
    }

    public void drawBorders(CellRangeAddress cellRangeAddress, BorderStyle borderStyle, BorderExtent borderExtent) {
        switch (AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$BorderExtent[borderExtent.ordinal()]) {
            case 1:
                removeBorders(cellRangeAddress);
                break;
            case 2:
                BorderExtent borderExtent2 = BorderExtent.ALL;
                drawHorizontalBorders(cellRangeAddress, borderStyle, borderExtent2);
                drawVerticalBorders(cellRangeAddress, borderStyle, borderExtent2);
                break;
            case 3:
                BorderExtent borderExtent3 = BorderExtent.INSIDE;
                drawHorizontalBorders(cellRangeAddress, borderStyle, borderExtent3);
                drawVerticalBorders(cellRangeAddress, borderStyle, borderExtent3);
                break;
            case 4:
                drawOutsideBorders(cellRangeAddress, borderStyle, BorderExtent.ALL);
                break;
            case 5:
                drawTopBorder(cellRangeAddress, borderStyle);
                break;
            case 6:
                drawBottomBorder(cellRangeAddress, borderStyle);
                break;
            case 7:
                drawLeftBorder(cellRangeAddress, borderStyle);
                break;
            case 8:
                drawRightBorder(cellRangeAddress, borderStyle);
                break;
            case 9:
                drawHorizontalBorders(cellRangeAddress, borderStyle, BorderExtent.ALL);
                break;
            case 10:
                drawHorizontalBorders(cellRangeAddress, borderStyle, BorderExtent.INSIDE);
                break;
            case 11:
                drawOutsideBorders(cellRangeAddress, borderStyle, BorderExtent.HORIZONTAL);
                break;
            case 12:
                drawVerticalBorders(cellRangeAddress, borderStyle, BorderExtent.ALL);
                break;
            case 13:
                drawVerticalBorders(cellRangeAddress, borderStyle, BorderExtent.INSIDE);
                break;
            case 14:
                drawOutsideBorders(cellRangeAddress, borderStyle, BorderExtent.VERTICAL);
                break;
        }
    }

    public BorderStyle getBorderStyle(CellAddress cellAddress, String str) {
        BorderStyle borderStyle = BorderStyle.NONE;
        Map<String, Object> map = this._propertyTemplate.get(cellAddress);
        if (map != null) {
            Object obj = map.get(str);
            if (obj instanceof BorderStyle) {
                return (BorderStyle) obj;
            }
        }
        return borderStyle;
    }

    public int getNumBorderColors(CellAddress cellAddress) {
        Map<String, Object> map = this._propertyTemplate.get(cellAddress);
        int i5 = 0;
        if (map == null) {
            return 0;
        }
        for (String str : map.keySet()) {
            if (str.equals(CellUtil.TOP_BORDER_COLOR)) {
                i5++;
            }
            if (str.equals(CellUtil.BOTTOM_BORDER_COLOR)) {
                i5++;
            }
            if (str.equals(CellUtil.LEFT_BORDER_COLOR)) {
                i5++;
            }
            if (str.equals(CellUtil.RIGHT_BORDER_COLOR)) {
                i5++;
            }
        }
        return i5;
    }

    public int getNumBorders(CellAddress cellAddress) {
        Map<String, Object> map = this._propertyTemplate.get(cellAddress);
        int i5 = 0;
        if (map == null) {
            return 0;
        }
        for (String str : map.keySet()) {
            if (str.equals(CellUtil.BORDER_TOP)) {
                i5++;
            }
            if (str.equals(CellUtil.BORDER_BOTTOM)) {
                i5++;
            }
            if (str.equals(CellUtil.BORDER_LEFT)) {
                i5++;
            }
            if (str.equals(CellUtil.BORDER_RIGHT)) {
                i5++;
            }
        }
        return i5;
    }

    public short getTemplateProperty(CellAddress cellAddress, String str) {
        Object obj;
        Map<String, Object> map = this._propertyTemplate.get(cellAddress);
        if (map == null || (obj = map.get(str)) == null) {
            return (short) 0;
        }
        return getShort(obj);
    }

    private void addProperty(int i5, int i6, String str, Object obj) {
        CellAddress cellAddress = new CellAddress(i5, i6);
        Map<String, Object> map = this._propertyTemplate.get(cellAddress);
        if (map == null) {
            map = new HashMap<>();
        }
        map.put(str, obj);
        this._propertyTemplate.put(cellAddress, map);
    }

    public PropertyTemplate(PropertyTemplate propertyTemplate) {
        this();
        for (Map.Entry<CellAddress, Map<String, Object>> entry : propertyTemplate.getTemplate().entrySet()) {
            this._propertyTemplate.put(new CellAddress(entry.getKey()), cloneCellProperties(entry.getValue()));
        }
    }

    public short getTemplateProperty(int i5, int i6, String str) {
        return getTemplateProperty(new CellAddress(i5, i6), str);
    }

    public BorderStyle getBorderStyle(int i5, int i6, String str) {
        return getBorderStyle(new CellAddress(i5, i6), str);
    }

    public int getNumBorderColors(int i5, int i6) {
        return getNumBorderColors(new CellAddress(i5, i6));
    }

    public int getNumBorders(int i5, int i6) {
        return getNumBorders(new CellAddress(i5, i6));
    }

    public void drawBorders(CellRangeAddress cellRangeAddress, BorderStyle borderStyle, short s6, BorderExtent borderExtent) {
        drawBorders(cellRangeAddress, borderStyle, borderExtent);
        if (borderStyle != BorderStyle.NONE) {
            drawBorderColors(cellRangeAddress, s6, borderExtent);
        }
    }
}
