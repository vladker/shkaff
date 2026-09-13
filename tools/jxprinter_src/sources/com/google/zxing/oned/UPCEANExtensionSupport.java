package com.google.zxing.oned;

import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import com.google.zxing.common.BitArray;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
final class UPCEANExtensionSupport {
    private static final int[] EXTENSION_START_PATTERN = {1, 1, 2};
    private final UPCEANExtension2Support twoSupport = new UPCEANExtension2Support();
    private final UPCEANExtension5Support fiveSupport = new UPCEANExtension5Support();

    public Result decodeRow(int i5, BitArray bitArray, int i6) {
        int[] iArrFindGuardPattern = UPCEANReader.findGuardPattern(bitArray, i6, false, EXTENSION_START_PATTERN);
        try {
            return this.fiveSupport.decodeRow(i5, bitArray, iArrFindGuardPattern);
        } catch (ReaderException unused) {
            return this.twoSupport.decodeRow(i5, bitArray, iArrFindGuardPattern);
        }
    }
}
