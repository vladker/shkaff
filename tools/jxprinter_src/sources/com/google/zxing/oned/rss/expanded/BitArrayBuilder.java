package com.google.zxing.oned.rss.expanded;

import A3.AbstractC0157z;
import com.google.zxing.common.BitArray;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
final class BitArrayBuilder {
    private BitArrayBuilder() {
    }

    public static BitArray buildBitArray(List<ExpandedPair> list) {
        int size = list.size() << 1;
        int i5 = size - 1;
        if (((ExpandedPair) AbstractC0157z.f(1, list)).getRightChar() == null) {
            i5 = size - 2;
        }
        BitArray bitArray = new BitArray(i5 * 12);
        int i6 = 0;
        int value = list.get(0).getRightChar().getValue();
        for (int i7 = 11; i7 >= 0; i7--) {
            if (((1 << i7) & value) != 0) {
                bitArray.set(i6);
            }
            i6++;
        }
        for (int i8 = 1; i8 < list.size(); i8++) {
            ExpandedPair expandedPair = list.get(i8);
            int value2 = expandedPair.getLeftChar().getValue();
            for (int i9 = 11; i9 >= 0; i9--) {
                if (((1 << i9) & value2) != 0) {
                    bitArray.set(i6);
                }
                i6++;
            }
            if (expandedPair.getRightChar() != null) {
                int value3 = expandedPair.getRightChar().getValue();
                for (int i10 = 11; i10 >= 0; i10--) {
                    if (((1 << i10) & value3) != 0) {
                        bitArray.set(i6);
                    }
                    i6++;
                }
            }
        }
        return bitArray;
    }
}
