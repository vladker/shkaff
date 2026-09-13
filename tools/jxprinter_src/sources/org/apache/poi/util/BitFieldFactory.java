package org.apache.poi.util;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class BitFieldFactory {
    private static Map<Integer, BitField> instances = new HashMap();

    public static BitField getInstance(int i5) {
        BitField bitField = instances.get(Integer.valueOf(i5));
        if (bitField != null) {
            return bitField;
        }
        BitField bitField2 = new BitField(i5);
        instances.put(Integer.valueOf(i5), bitField2);
        return bitField2;
    }
}
