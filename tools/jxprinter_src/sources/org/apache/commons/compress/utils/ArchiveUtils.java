package org.apache.commons.compress.utils;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.logging.log4j.util.Chars;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class ArchiveUtils {
    private static final int MAX_SANITIZED_NAME_LENGTH = 255;

    private ArchiveUtils() {
    }

    public static boolean isArrayZero(byte[] bArr, int i5) {
        for (int i6 = 0; i6 < i5; i6++) {
            if (bArr[i6] != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isEqual(byte[] bArr, int i5, int i6, byte[] bArr2, int i7, int i8, boolean z6) {
        int i9 = i6 < i8 ? i6 : i8;
        for (int i10 = 0; i10 < i9; i10++) {
            if (bArr[i5 + i10] != bArr2[i7 + i10]) {
                return false;
            }
        }
        if (i6 == i8) {
            return true;
        }
        if (!z6) {
            return false;
        }
        if (i6 > i8) {
            while (i8 < i6) {
                if (bArr[i5 + i8] != 0) {
                    return false;
                }
                i8++;
            }
        } else {
            while (i6 < i8) {
                if (bArr2[i7 + i6] != 0) {
                    return false;
                }
                i6++;
            }
        }
        return true;
    }

    public static boolean isEqualWithNull(byte[] bArr, int i5, int i6, byte[] bArr2, int i7, int i8) {
        return isEqual(bArr, i5, i6, bArr2, i7, i8, true);
    }

    public static boolean matchAsciiBuffer(String str, byte[] bArr, int i5, int i6) {
        byte[] bytes = str.getBytes(StandardCharsets.US_ASCII);
        return isEqual(bytes, 0, bytes.length, bArr, i5, i6, false);
    }

    public static String sanitize(String str) {
        Character.UnicodeBlock unicodeBlockOf;
        char[] charArray = str.toCharArray();
        char[] cArrCopyOf = charArray.length <= 255 ? charArray : Arrays.copyOf(charArray, 255);
        if (charArray.length > 255) {
            for (int i5 = 252; i5 < 255; i5++) {
                cArrCopyOf[i5] = '.';
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c : cArrCopyOf) {
            if (Character.isISOControl(c) || (unicodeBlockOf = Character.UnicodeBlock.of(c)) == null || unicodeBlockOf == Character.UnicodeBlock.SPECIALS) {
                sb.append('?');
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static byte[] toAsciiBytes(String str) {
        return str.getBytes(StandardCharsets.US_ASCII);
    }

    public static String toAsciiString(byte[] bArr) {
        return new String(bArr, StandardCharsets.US_ASCII);
    }

    public static String toString(ArchiveEntry archiveEntry) {
        StringBuilder sb = new StringBuilder();
        sb.append(archiveEntry.isDirectory() ? 'd' : '-');
        String string = Long.toString(archiveEntry.getSize());
        sb.append(Chars.SPACE);
        for (int i5 = 7; i5 > string.length(); i5--) {
            sb.append(Chars.SPACE);
        }
        sb.append(string);
        sb.append(Chars.SPACE);
        sb.append(archiveEntry.getName());
        return sb.toString();
    }

    public static String toAsciiString(byte[] bArr, int i5, int i6) {
        return new String(bArr, i5, i6, StandardCharsets.US_ASCII);
    }

    public static boolean matchAsciiBuffer(String str, byte[] bArr) {
        return matchAsciiBuffer(str, bArr, 0, bArr.length);
    }

    public static boolean isEqual(byte[] bArr, int i5, int i6, byte[] bArr2, int i7, int i8) {
        return isEqual(bArr, i5, i6, bArr2, i7, i8, false);
    }

    public static boolean isEqual(byte[] bArr, byte[] bArr2) {
        return isEqual(bArr, 0, bArr.length, bArr2, 0, bArr2.length, false);
    }

    public static boolean isEqual(byte[] bArr, byte[] bArr2, boolean z6) {
        return isEqual(bArr, 0, bArr.length, bArr2, 0, bArr2.length, z6);
    }
}
