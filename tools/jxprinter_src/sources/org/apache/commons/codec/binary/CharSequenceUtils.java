package org.apache.commons.codec.binary;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class CharSequenceUtils {
    public static boolean regionMatches(CharSequence charSequence, boolean z6, int i5, CharSequence charSequence2, int i6, int i7) {
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            return ((String) charSequence).regionMatches(z6, i5, (String) charSequence2, i6, i7);
        }
        while (true) {
            int i8 = i7 - 1;
            if (i7 <= 0) {
                return true;
            }
            int i9 = i5 + 1;
            char cCharAt = charSequence.charAt(i5);
            int i10 = i6 + 1;
            char cCharAt2 = charSequence2.charAt(i6);
            if (cCharAt != cCharAt2) {
                if (!z6) {
                    return false;
                }
                if (Character.toUpperCase(cCharAt) != Character.toUpperCase(cCharAt2) && Character.toLowerCase(cCharAt) != Character.toLowerCase(cCharAt2)) {
                    return false;
                }
            }
            i5 = i9;
            i7 = i8;
            i6 = i10;
        }
    }
}
