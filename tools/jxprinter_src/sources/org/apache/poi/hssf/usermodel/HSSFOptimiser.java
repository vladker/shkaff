package org.apache.poi.hssf.usermodel;

import java.util.HashSet;
import java.util.Iterator;
import org.apache.poi.hssf.record.ExtendedFormatRecord;
import org.apache.poi.hssf.record.FontRecord;
import org.apache.poi.hssf.record.StyleRecord;
import org.apache.poi.hssf.record.common.UnicodeString;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class HSSFOptimiser {
    private static boolean isUserDefined(HSSFWorkbook hSSFWorkbook, int i5) {
        StyleRecord styleRecord = hSSFWorkbook.getWorkbook().getStyleRecord(i5);
        return (styleRecord == null || styleRecord.isBuiltin() || styleRecord.getName() == null) ? false : true;
    }

    public static void optimiseCellStyles(HSSFWorkbook hSSFWorkbook) {
        int numExFormats = hSSFWorkbook.getWorkbook().getNumExFormats();
        short[] sArr = new short[numExFormats];
        boolean[] zArr = new boolean[numExFormats];
        boolean[] zArr2 = new boolean[numExFormats];
        boolean[] zArr3 = new boolean[numExFormats];
        ExtendedFormatRecord[] extendedFormatRecordArr = new ExtendedFormatRecord[numExFormats];
        for (int i5 = 0; i5 < numExFormats; i5++) {
            zArr[i5] = false;
            sArr[i5] = (short) i5;
            zArr2[i5] = false;
            zArr3[i5] = isUserDefined(hSSFWorkbook, i5);
            extendedFormatRecordArr[i5] = hSSFWorkbook.getWorkbook().getExFormatAt(i5);
        }
        int i6 = 21;
        for (int i7 = 21; i7 < numExFormats; i7++) {
            int i8 = 0;
            while (true) {
                if (i8 >= i7) {
                    i8 = -1;
                    break;
                } else if (hSSFWorkbook.getWorkbook().getExFormatAt(i8).equals(extendedFormatRecordArr[i7]) && !zArr3[i8]) {
                    break;
                } else {
                    i8++;
                }
            }
            if (i8 != -1) {
                sArr[i7] = (short) i8;
                zArr2[i7] = true;
            }
        }
        for (int i9 = 0; i9 < hSSFWorkbook.getNumberOfSheets(); i9++) {
            HSSFSheet sheetAt = hSSFWorkbook.getSheetAt(i9);
            for (Row row : sheetAt) {
                Iterator<Cell> it = row.iterator();
                while (it.hasNext()) {
                    short xFIndex = ((HSSFCell) it.next()).getCellValueRecord().getXFIndex();
                    if (xFIndex < numExFormats) {
                        zArr[xFIndex] = true;
                    }
                }
                short xFIndex2 = ((HSSFRow) row).getRowRecord().getXFIndex();
                if (xFIndex2 < numExFormats) {
                    zArr[xFIndex2] = true;
                }
            }
            for (int minColumnIndex = sheetAt.getSheet().getMinColumnIndex(); minColumnIndex <= sheetAt.getSheet().getMaxColumnIndex(); minColumnIndex++) {
                short xFIndexForColAt = sheetAt.getSheet().getXFIndexForColAt((short) minColumnIndex);
                if (xFIndexForColAt < numExFormats) {
                    zArr[xFIndexForColAt] = true;
                }
            }
        }
        for (int i10 = 21; i10 < numExFormats; i10++) {
            if (isUserDefined(hSSFWorkbook, i10)) {
                zArr[i10] = true;
            }
            short s6 = sArr[i10];
            if (s6 != i10 && zArr[i10]) {
                zArr[s6] = true;
            }
        }
        for (int i11 = 21; i11 < numExFormats; i11++) {
            if (!zArr[i11]) {
                zArr2[i11] = true;
                sArr[i11] = 0;
            }
        }
        for (int i12 = 21; i12 < numExFormats; i12++) {
            short s7 = sArr[i12];
            short s8 = s7;
            for (int i13 = 0; i13 < s7; i13++) {
                if (zArr2[i13]) {
                    s8 = (short) (s8 - 1);
                }
            }
            sArr[i12] = s8;
            if (i12 != s8 && s8 != 0) {
                hSSFWorkbook.getWorkbook().updateStyleRecord(i12, s8);
                ExtendedFormatRecord exFormatAt = hSSFWorkbook.getWorkbook().getExFormatAt(i12);
                short parentIndex = exFormatAt.getParentIndex();
                if (parentIndex < numExFormats) {
                    exFormatAt.setParentIndex(sArr[parentIndex]);
                }
            }
        }
        int i14 = numExFormats;
        int i15 = 0;
        while (i6 < i14) {
            if (zArr2[i6 + i15]) {
                hSSFWorkbook.getWorkbook().removeExFormatRecord(i6);
                i6--;
                i14--;
                i15++;
            }
            i6++;
        }
        for (int i16 = 0; i16 < hSSFWorkbook.getNumberOfSheets(); i16++) {
            HSSFSheet sheetAt2 = hSSFWorkbook.getSheetAt(i16);
            for (Row row2 : sheetAt2) {
                for (Cell cell : row2) {
                    short xFIndex3 = ((HSSFCell) cell).getCellValueRecord().getXFIndex();
                    if (xFIndex3 < numExFormats) {
                        cell.setCellStyle(hSSFWorkbook.getCellStyleAt((int) sArr[xFIndex3]));
                    }
                }
                short xFIndex4 = ((HSSFRow) row2).getRowRecord().getXFIndex();
                if (xFIndex4 < numExFormats) {
                    row2.setRowStyle(hSSFWorkbook.getCellStyleAt((int) sArr[xFIndex4]));
                }
            }
            for (int minColumnIndex2 = sheetAt2.getSheet().getMinColumnIndex(); minColumnIndex2 <= sheetAt2.getSheet().getMaxColumnIndex(); minColumnIndex2++) {
                short xFIndexForColAt2 = sheetAt2.getSheet().getXFIndexForColAt((short) minColumnIndex2);
                if (xFIndexForColAt2 < numExFormats) {
                    sheetAt2.setDefaultColumnStyle(minColumnIndex2, hSSFWorkbook.getCellStyleAt((int) sArr[xFIndexForColAt2]));
                }
            }
        }
    }

    public static void optimiseFonts(HSSFWorkbook hSSFWorkbook) {
        int numberOfFontRecords = hSSFWorkbook.getWorkbook().getNumberOfFontRecords() + 1;
        short[] sArr = new short[numberOfFontRecords];
        boolean[] zArr = new boolean[numberOfFontRecords];
        for (int i5 = 0; i5 < numberOfFontRecords; i5++) {
            sArr[i5] = (short) i5;
            zArr[i5] = false;
        }
        FontRecord[] fontRecordArr = new FontRecord[numberOfFontRecords];
        for (int i6 = 0; i6 < numberOfFontRecords; i6++) {
            if (i6 != 4) {
                fontRecordArr[i6] = hSSFWorkbook.getWorkbook().getFontRecordAt(i6);
            }
        }
        for (int i7 = 5; i7 < numberOfFontRecords; i7++) {
            int i8 = -1;
            for (int i9 = 0; i9 < i7 && i8 == -1; i9++) {
                if (i9 != 4 && hSSFWorkbook.getWorkbook().getFontRecordAt(i9).sameProperties(fontRecordArr[i7])) {
                    i8 = i9;
                }
            }
            if (i8 != -1) {
                sArr[i7] = (short) i8;
                zArr[i7] = true;
            }
        }
        for (int i10 = 5; i10 < numberOfFontRecords; i10++) {
            short s6 = sArr[i10];
            short s7 = s6;
            for (int i11 = 0; i11 < s6; i11++) {
                if (zArr[i11]) {
                    s7 = (short) (s7 - 1);
                }
            }
            sArr[i10] = s7;
        }
        for (int i12 = 5; i12 < numberOfFontRecords; i12++) {
            if (zArr[i12]) {
                hSSFWorkbook.getWorkbook().removeFontRecord(fontRecordArr[i12]);
            }
        }
        hSSFWorkbook.resetFontCache();
        for (int i13 = 0; i13 < hSSFWorkbook.getWorkbook().getNumExFormats(); i13++) {
            ExtendedFormatRecord exFormatAt = hSSFWorkbook.getWorkbook().getExFormatAt(i13);
            exFormatAt.setFontIndex(sArr[exFormatAt.getFontIndex()]);
        }
        HashSet hashSet = new HashSet();
        for (int i14 = 0; i14 < hSSFWorkbook.getNumberOfSheets(); i14++) {
            Iterator<Row> it = hSSFWorkbook.getSheetAt(i14).iterator();
            while (it.hasNext()) {
                for (Cell cell : it.next()) {
                    if (cell.getCellType() == CellType.STRING) {
                        UnicodeString rawUnicodeString = ((HSSFRichTextString) cell.getRichStringCellValue()).getRawUnicodeString();
                        if (!hashSet.contains(rawUnicodeString)) {
                            for (short s8 = 5; s8 < numberOfFontRecords; s8 = (short) (s8 + 1)) {
                                short s9 = sArr[s8];
                                if (s8 != s9) {
                                    rawUnicodeString.swapFontUse(s8, s9);
                                }
                            }
                            hashSet.add(rawUnicodeString);
                        }
                    }
                }
            }
        }
    }
}
