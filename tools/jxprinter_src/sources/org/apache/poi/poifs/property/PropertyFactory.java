package org.apache.poi.poifs.property;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
final class PropertyFactory {
    private PropertyFactory() {
    }

    public static void convertToProperties(byte[] bArr, List<Property> list) {
        int length = bArr.length / 128;
        int i5 = 0;
        for (int i6 = 0; i6 < length; i6++) {
            byte b = bArr[i5 + 66];
            if (b == 1) {
                list.add(new DirectoryProperty(list.size(), bArr, i5));
            } else if (b == 2) {
                list.add(new DocumentProperty(list.size(), bArr, i5));
            } else if (b != 5) {
                list.add(null);
            } else {
                list.add(new RootProperty(list.size(), bArr, i5));
            }
            i5 += 128;
        }
    }
}
