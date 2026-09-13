package org.apache.poi.xssf.binary;

import org.apache.poi.util.Internal;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Internal
class XSSFBCellHeader {
    public static final int length = 8;
    private int colNum;
    private int rowNum;
    private boolean showPhonetic;
    private int styleIdx;

    public static void parse(byte[] bArr, int i5, int i6, XSSFBCellHeader xSSFBCellHeader) {
        xSSFBCellHeader.reset(i6, XSSFBUtils.castToInt(LittleEndian.getUInt(bArr, i5)), XSSFBUtils.get24BitInt(bArr, i5 + 4), false);
    }

    public int getColNum() {
        return this.colNum;
    }

    public int getStyleIdx() {
        return this.styleIdx;
    }

    public void reset(int i5, int i6, int i7, boolean z6) {
        this.rowNum = i5;
        this.colNum = i6;
        this.styleIdx = i7;
        this.showPhonetic = z6;
    }
}
