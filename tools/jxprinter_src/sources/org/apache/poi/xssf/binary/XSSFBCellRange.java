package org.apache.poi.xssf.binary;

import org.apache.poi.util.Internal;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Internal
class XSSFBCellRange {
    public static final int length = 16;
    int firstCol;
    int firstRow;
    int lastCol;
    int lastRow;

    public static XSSFBCellRange parse(byte[] bArr, int i5, XSSFBCellRange xSSFBCellRange) {
        if (xSSFBCellRange == null) {
            xSSFBCellRange = new XSSFBCellRange();
        }
        xSSFBCellRange.firstRow = XSSFBUtils.castToInt(LittleEndian.getUInt(bArr, i5));
        xSSFBCellRange.lastRow = XSSFBUtils.castToInt(LittleEndian.getUInt(bArr, i5 + 4));
        xSSFBCellRange.firstCol = XSSFBUtils.castToInt(LittleEndian.getUInt(bArr, i5 + 8));
        xSSFBCellRange.lastCol = XSSFBUtils.castToInt(LittleEndian.getUInt(bArr, i5 + 12));
        return xSSFBCellRange;
    }
}
