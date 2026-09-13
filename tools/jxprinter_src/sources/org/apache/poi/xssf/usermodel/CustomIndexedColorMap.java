package org.apache.poi.xssf.usermodel;

import java.lang.reflect.Array;
import java.util.List;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTColors;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRgbColor;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class CustomIndexedColorMap implements IndexedColorMap {
    private final byte[][] colorIndex;

    private CustomIndexedColorMap(byte[][] bArr) {
        this.colorIndex = bArr;
    }

    public static CustomIndexedColorMap fromColors(CTColors cTColors) {
        if (cTColors == null || !cTColors.isSetIndexedColors()) {
            return null;
        }
        List<CTRgbColor> rgbColorList = cTColors.getIndexedColors().getRgbColorList();
        byte[][] bArr = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, rgbColorList.size(), 3);
        for (int i5 = 0; i5 < rgbColorList.size(); i5++) {
            bArr[i5] = rgbColorList.get(i5).getRgb();
        }
        return new CustomIndexedColorMap(bArr);
    }

    @Override // org.apache.poi.xssf.usermodel.IndexedColorMap
    public byte[] getRGB(int i5) {
        byte[][] bArr = this.colorIndex;
        if (bArr == null || i5 < 0 || i5 >= bArr.length) {
            return null;
        }
        return bArr[i5];
    }
}
