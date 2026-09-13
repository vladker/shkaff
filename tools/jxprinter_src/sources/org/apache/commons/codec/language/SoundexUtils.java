package org.apache.commons.codec.language;

import java.util.Locale;
import org.apache.commons.codec.StringEncoder;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
final class SoundexUtils {
    public static String clean(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        int length = str.length();
        char[] cArr = new char[length];
        int i5 = 0;
        for (int i6 = 0; i6 < length; i6++) {
            if (Character.isLetter(str.charAt(i6))) {
                cArr[i5] = str.charAt(i6);
                i5++;
            }
        }
        return i5 == length ? str.toUpperCase(Locale.ENGLISH) : new String(cArr, 0, i5).toUpperCase(Locale.ENGLISH);
    }

    public static int difference(StringEncoder stringEncoder, String str, String str2) {
        return differenceEncoded(stringEncoder.encode(str), stringEncoder.encode(str2));
    }

    public static int differenceEncoded(String str, String str2) {
        if (str == null || str2 == null) {
            return 0;
        }
        int iMin = Math.min(str.length(), str2.length());
        int i5 = 0;
        for (int i6 = 0; i6 < iMin; i6++) {
            if (str.charAt(i6) == str2.charAt(i6)) {
                i5++;
            }
        }
        return i5;
    }
}
