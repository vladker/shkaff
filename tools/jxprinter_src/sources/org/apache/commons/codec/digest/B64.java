package org.apache.commons.codec.digest;

import com.google.common.primitives.UnsignedBytes;
import java.security.SecureRandom;
import java.util.Random;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
class B64 {
    static final String B64T_STRING = "./0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    static final char[] B64T_ARRAY = B64T_STRING.toCharArray();

    public static void b64from24bit(byte b, byte b6, byte b7, int i5, StringBuilder sb) {
        int i6 = ((b << 16) & 16777215) | ((b6 << 8) & 65535) | (b7 & UnsignedBytes.MAX_VALUE);
        while (true) {
            int i7 = i5 - 1;
            if (i5 <= 0) {
                return;
            }
            sb.append(B64T_ARRAY[i6 & 63]);
            i6 >>= 6;
            i5 = i7;
        }
    }

    public static String getRandomSalt(int i5) {
        return getRandomSalt(i5, new SecureRandom());
    }

    public static String getRandomSalt(int i5, Random random) {
        StringBuilder sb = new StringBuilder(i5);
        for (int i6 = 1; i6 <= i5; i6++) {
            sb.append(B64T_STRING.charAt(random.nextInt(64)));
        }
        return sb.toString();
    }
}
