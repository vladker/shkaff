package org.apache.poi.xssf.usermodel;

import org.apache.poi.hssf.util.HSSFColor;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class DefaultIndexedColorMap implements IndexedColorMap {
    public static byte[] getDefaultRGB(int i5) {
        HSSFColor hSSFColor = HSSFColor.getIndexHash().get(Integer.valueOf(i5));
        if (hSSFColor == null) {
            return null;
        }
        short[] triplet = hSSFColor.getTriplet();
        return new byte[]{(byte) triplet[0], (byte) triplet[1], (byte) triplet[2]};
    }

    @Override // org.apache.poi.xssf.usermodel.IndexedColorMap
    public byte[] getRGB(int i5) {
        return getDefaultRGB(i5);
    }
}
