package org.apache.commons.codec.net;

import A3.AbstractC0157z;
import org.apache.commons.codec.DecoderException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
class Utils {
    private static final int RADIX = 16;

    public static int digit16(byte b) throws DecoderException {
        int iDigit = Character.digit((char) b, 16);
        if (iDigit != -1) {
            return iDigit;
        }
        throw new DecoderException(AbstractC0157z.k(b, "Invalid URL encoding: not a valid digit (radix 16): "));
    }

    public static char hexDigit(int i5) {
        return Character.toUpperCase(Character.forDigit(i5 & 15, 16));
    }
}
