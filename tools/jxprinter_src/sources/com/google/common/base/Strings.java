package com.google.common.base;

import androidx.exifinterface.media.a;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlinx.serialization.json.internal.AbstractC1127c;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
@GwtCompatible
@ElementTypesAreNonnullByDefault
public final class Strings {
    private Strings() {
    }

    public static String commonPrefix(CharSequence charSequence, CharSequence charSequence2) {
        Preconditions.checkNotNull(charSequence);
        Preconditions.checkNotNull(charSequence2);
        int iMin = Math.min(charSequence.length(), charSequence2.length());
        int i5 = 0;
        while (i5 < iMin && charSequence.charAt(i5) == charSequence2.charAt(i5)) {
            i5++;
        }
        int i6 = i5 - 1;
        if (validSurrogatePairAt(charSequence, i6) || validSurrogatePairAt(charSequence2, i6)) {
            i5--;
        }
        return charSequence.subSequence(0, i5).toString();
    }

    public static String commonSuffix(CharSequence charSequence, CharSequence charSequence2) {
        Preconditions.checkNotNull(charSequence);
        Preconditions.checkNotNull(charSequence2);
        int iMin = Math.min(charSequence.length(), charSequence2.length());
        int i5 = 0;
        while (i5 < iMin && charSequence.charAt((charSequence.length() - i5) - 1) == charSequence2.charAt((charSequence2.length() - i5) - 1)) {
            i5++;
        }
        if (validSurrogatePairAt(charSequence, (charSequence.length() - i5) - 1) || validSurrogatePairAt(charSequence2, (charSequence2.length() - i5) - 1)) {
            i5--;
        }
        return charSequence.subSequence(charSequence.length() - i5, charSequence.length()).toString();
    }

    public static String emptyToNull(String str) {
        return Platform.emptyToNull(str);
    }

    public static boolean isNullOrEmpty(String str) {
        return Platform.stringIsNullOrEmpty(str);
    }

    public static String lenientFormat(String str, Object... objArr) {
        int iIndexOf;
        String strValueOf = String.valueOf(str);
        int i5 = 0;
        if (objArr == null) {
            objArr = new Object[]{"(Object[])null"};
        } else {
            for (int i6 = 0; i6 < objArr.length; i6++) {
                objArr[i6] = lenientToString(objArr[i6]);
            }
        }
        StringBuilder sb = new StringBuilder((objArr.length * 16) + strValueOf.length());
        int i7 = 0;
        while (i5 < objArr.length && (iIndexOf = strValueOf.indexOf("%s", i7)) != -1) {
            sb.append((CharSequence) strValueOf, i7, iIndexOf);
            sb.append(objArr[i5]);
            i7 = iIndexOf + 2;
            i5++;
        }
        sb.append((CharSequence) strValueOf, i7, strValueOf.length());
        if (i5 < objArr.length) {
            sb.append(" [");
            sb.append(objArr[i5]);
            for (int i8 = i5 + 1; i8 < objArr.length; i8++) {
                sb.append(", ");
                sb.append(objArr[i8]);
            }
            sb.append(']');
        }
        return sb.toString();
    }

    private static String lenientToString(Object obj) {
        if (obj == null) {
            return AbstractC1127c.NULL;
        }
        try {
            return obj.toString();
        } catch (Exception e) {
            String name = obj.getClass().getName();
            String hexString = Integer.toHexString(System.identityHashCode(obj));
            StringBuilder sb = new StringBuilder(a.b(name.length() + 1, hexString));
            sb.append(name);
            sb.append('@');
            sb.append(hexString);
            String string = sb.toString();
            Logger logger = Logger.getLogger("com.google.common.base.Strings");
            Level level = Level.WARNING;
            String strValueOf = String.valueOf(string);
            logger.log(level, strValueOf.length() != 0 ? "Exception during lenientFormat for ".concat(strValueOf) : new String("Exception during lenientFormat for "), (Throwable) e);
            String name2 = e.getClass().getName();
            StringBuilder sbU = a.u(name2.length() + a.b(9, string), "<", string, " threw ", name2);
            sbU.append(">");
            return sbU.toString();
        }
    }

    public static String nullToEmpty(String str) {
        return Platform.nullToEmpty(str);
    }

    public static String padEnd(String str, int i5, char c) {
        Preconditions.checkNotNull(str);
        if (str.length() >= i5) {
            return str;
        }
        StringBuilder sb = new StringBuilder(i5);
        sb.append(str);
        for (int length = str.length(); length < i5; length++) {
            sb.append(c);
        }
        return sb.toString();
    }

    public static String padStart(String str, int i5, char c) {
        Preconditions.checkNotNull(str);
        if (str.length() >= i5) {
            return str;
        }
        StringBuilder sb = new StringBuilder(i5);
        for (int length = str.length(); length < i5; length++) {
            sb.append(c);
        }
        sb.append(str);
        return sb.toString();
    }

    public static String repeat(String str, int i5) {
        Preconditions.checkNotNull(str);
        if (i5 <= 1) {
            Preconditions.checkArgument(i5 >= 0, "invalid count: %s", i5);
            return i5 == 0 ? "" : str;
        }
        int length = str.length();
        long j6 = ((long) length) * ((long) i5);
        int i6 = (int) j6;
        if (i6 != j6) {
            StringBuilder sb = new StringBuilder(51);
            sb.append("Required array size too large: ");
            sb.append(j6);
            throw new ArrayIndexOutOfBoundsException(sb.toString());
        }
        char[] cArr = new char[i6];
        str.getChars(0, length, cArr, 0);
        while (true) {
            int i7 = i6 - length;
            if (length >= i7) {
                System.arraycopy(cArr, 0, cArr, length, i7);
                return new String(cArr);
            }
            System.arraycopy(cArr, 0, cArr, length, length);
            length <<= 1;
        }
    }

    @VisibleForTesting
    public static boolean validSurrogatePairAt(CharSequence charSequence, int i5) {
        return i5 >= 0 && i5 <= charSequence.length() + (-2) && Character.isHighSurrogate(charSequence.charAt(i5)) && Character.isLowSurrogate(charSequence.charAt(i5 + 1));
    }
}
