package org.apache.commons.io;

import androidx.webkit.ProxyConfig;
import com.alibaba.android.arouter.utils.Consts;
import java.io.File;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.logging.log4j.message.ParameterizedMessage;
import org.apache.poi.openxml4j.opc.PackagingURIHelper;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class FilenameUtils {
    private static final int BASE_16 = 16;
    private static final String EMPTY_STRING = "";
    public static final char EXTENSION_SEPARATOR = '.';
    private static final int IPV4_MAX_OCTET_VALUE = 255;
    private static final Pattern IPV4_PATTERN;
    private static final int IPV6_MAX_HEX_DIGITS_PER_GROUP = 4;
    private static final int IPV6_MAX_HEX_GROUPS = 8;
    private static final int MAX_UNSIGNED_SHORT = 65535;
    private static final int NOT_FOUND = -1;
    private static final char OTHER_SEPARATOR;
    private static final Pattern REG_NAME_PART_PATTERN;
    private static final char UNIX_SEPARATOR = '/';
    private static final char WINDOWS_SEPARATOR = '\\';
    private static final String[] EMPTY_STRING_ARRAY = new String[0];
    public static final String EXTENSION_SEPARATOR_STR = Character.toString('.');
    private static final char SYSTEM_SEPARATOR = File.separatorChar;

    static {
        if (isSystemWindows()) {
            OTHER_SEPARATOR = '/';
        } else {
            OTHER_SEPARATOR = '\\';
        }
        IPV4_PATTERN = Pattern.compile("^(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})$");
        REG_NAME_PART_PATTERN = Pattern.compile("^[a-zA-Z0-9][a-zA-Z0-9-]*$");
    }

    public static String concat(String str, String str2) {
        int prefixLength = getPrefixLength(str2);
        if (prefixLength < 0) {
            return null;
        }
        if (prefixLength > 0) {
            return normalize(str2);
        }
        if (str == null) {
            return null;
        }
        int length = str.length();
        if (length == 0) {
            return normalize(str2);
        }
        if (isSeparator(str.charAt(length - 1))) {
            return normalize(str + str2);
        }
        return normalize(str + '/' + str2);
    }

    public static boolean directoryContains(String str, String str2) {
        Objects.requireNonNull(str, "canonicalParent");
        if (str2 == null) {
            return false;
        }
        IOCase iOCase = IOCase.SYSTEM;
        if (iOCase.checkEquals(str, str2)) {
            return false;
        }
        return iOCase.checkStartsWith(str2, str);
    }

    private static String doGetFullPath(String str, boolean z6) {
        int prefixLength;
        if (str == null || (prefixLength = getPrefixLength(str)) < 0) {
            return null;
        }
        if (prefixLength >= str.length()) {
            return z6 ? getPrefix(str) : str;
        }
        int iIndexOfLastSeparator = indexOfLastSeparator(str);
        if (iIndexOfLastSeparator < 0) {
            return str.substring(0, prefixLength);
        }
        int i5 = iIndexOfLastSeparator + (z6 ? 1 : 0);
        if (i5 == 0) {
            i5++;
        }
        return str.substring(0, i5);
    }

    private static String doGetPath(String str, int i5) {
        int prefixLength;
        if (str == null || (prefixLength = getPrefixLength(str)) < 0) {
            return null;
        }
        int iIndexOfLastSeparator = indexOfLastSeparator(str);
        int i6 = i5 + iIndexOfLastSeparator;
        if (prefixLength >= str.length() || iIndexOfLastSeparator < 0 || prefixLength >= i6) {
            return "";
        }
        String strSubstring = str.substring(prefixLength, i6);
        requireNonNullChars(strSubstring);
        return strSubstring;
    }

    private static String doNormalize(String str, char c, boolean z6) {
        boolean z7;
        if (str == null) {
            return null;
        }
        requireNonNullChars(str);
        int length = str.length();
        if (length == 0) {
            return str;
        }
        int prefixLength = getPrefixLength(str);
        if (prefixLength < 0) {
            return null;
        }
        int i5 = length + 2;
        char[] cArr = new char[i5];
        str.getChars(0, str.length(), cArr, 0);
        char c6 = SYSTEM_SEPARATOR;
        if (c == c6) {
            c6 = OTHER_SEPARATOR;
        }
        for (int i6 = 0; i6 < i5; i6++) {
            if (cArr[i6] == c6) {
                cArr[i6] = c;
            }
        }
        if (cArr[length - 1] != c) {
            cArr[length] = c;
            length++;
            z7 = false;
        } else {
            z7 = true;
        }
        int i7 = prefixLength != 0 ? prefixLength : 1;
        while (i7 < length) {
            if (cArr[i7] == c) {
                int i8 = i7 - 1;
                if (cArr[i8] == c) {
                    System.arraycopy(cArr, i7, cArr, i8, length - i7);
                    length--;
                    i7--;
                }
            }
            i7++;
        }
        int i9 = prefixLength + 1;
        int i10 = i9;
        while (i10 < length) {
            if (cArr[i10] == c) {
                int i11 = i10 - 1;
                if (cArr[i11] == '.' && (i10 == i9 || cArr[i10 - 2] == c)) {
                    if (i10 == length - 1) {
                        z7 = true;
                    }
                    System.arraycopy(cArr, i10 + 1, cArr, i11, length - i10);
                    length -= 2;
                    i10--;
                }
            }
            i10++;
        }
        int i12 = prefixLength + 2;
        int i13 = i12;
        while (i13 < length) {
            if (cArr[i13] == c && cArr[i13 - 1] == '.' && cArr[i13 - 2] == '.' && (i13 == i12 || cArr[i13 - 3] == c)) {
                if (i13 == i12) {
                    return null;
                }
                if (i13 == length - 1) {
                    z7 = true;
                }
                int i14 = i13 - 4;
                while (true) {
                    if (i14 < prefixLength) {
                        int i15 = i13 + 1;
                        System.arraycopy(cArr, i15, cArr, prefixLength, length - i13);
                        length -= i15 - prefixLength;
                        i13 = i9;
                        break;
                    }
                    if (cArr[i14] == c) {
                        int i16 = i14 + 1;
                        System.arraycopy(cArr, i13 + 1, cArr, i16, length - i13);
                        length -= i13 - i14;
                        i13 = i16;
                        break;
                    }
                    i14--;
                }
            }
            i13++;
        }
        if (length <= 0) {
            return "";
        }
        if (length <= prefixLength) {
            return new String(cArr, 0, length);
        }
        return (z7 && z6) ? new String(cArr, 0, length) : new String(cArr, 0, length - 1);
    }

    public static boolean equals(String str, String str2) {
        return equals(str, str2, false, IOCase.SENSITIVE);
    }

    public static boolean equalsNormalized(String str, String str2) {
        return equals(str, str2, true, IOCase.SENSITIVE);
    }

    public static boolean equalsNormalizedOnSystem(String str, String str2) {
        return equals(str, str2, true, IOCase.SYSTEM);
    }

    public static boolean equalsOnSystem(String str, String str2) {
        return equals(str, str2, false, IOCase.SYSTEM);
    }

    private static int getAdsCriticalOffset(String str) {
        int iLastIndexOf = str.lastIndexOf(SYSTEM_SEPARATOR);
        int iLastIndexOf2 = str.lastIndexOf(OTHER_SEPARATOR);
        if (iLastIndexOf != -1) {
            return iLastIndexOf2 == -1 ? iLastIndexOf + 1 : Math.max(iLastIndexOf, iLastIndexOf2) + 1;
        }
        if (iLastIndexOf2 == -1) {
            return 0;
        }
        return iLastIndexOf2 + 1;
    }

    public static String getBaseName(String str) {
        return removeExtension(getName(str));
    }

    public static String getExtension(String str) {
        if (str == null) {
            return null;
        }
        int iIndexOfExtension = indexOfExtension(str);
        return iIndexOfExtension == -1 ? "" : str.substring(iIndexOfExtension + 1);
    }

    public static String getFullPath(String str) {
        return doGetFullPath(str, true);
    }

    public static String getFullPathNoEndSeparator(String str) {
        return doGetFullPath(str, false);
    }

    public static String getName(String str) {
        if (str == null) {
            return null;
        }
        requireNonNullChars(str);
        return str.substring(indexOfLastSeparator(str) + 1);
    }

    public static String getPath(String str) {
        return doGetPath(str, 1);
    }

    public static String getPathNoEndSeparator(String str) {
        return doGetPath(str, 0);
    }

    public static String getPrefix(String str) {
        int prefixLength;
        if (str == null || (prefixLength = getPrefixLength(str)) < 0) {
            return null;
        }
        if (prefixLength > str.length()) {
            requireNonNullChars(str.concat(PackagingURIHelper.FORWARD_SLASH_STRING));
            return str.concat(PackagingURIHelper.FORWARD_SLASH_STRING);
        }
        String strSubstring = str.substring(0, prefixLength);
        requireNonNullChars(strSubstring);
        return strSubstring;
    }

    public static int getPrefixLength(String str) {
        if (str == null) {
            return -1;
        }
        int length = str.length();
        if (length == 0) {
            return 0;
        }
        char cCharAt = str.charAt(0);
        if (cCharAt == ':') {
            return -1;
        }
        if (length == 1) {
            if (cCharAt == '~') {
                return 2;
            }
            return isSeparator(cCharAt) ? 1 : 0;
        }
        if (cCharAt == '~') {
            int iIndexOf = str.indexOf(47, 1);
            int iIndexOf2 = str.indexOf(92, 1);
            if (iIndexOf == -1 && iIndexOf2 == -1) {
                return length + 1;
            }
            if (iIndexOf == -1) {
                iIndexOf = iIndexOf2;
            }
            if (iIndexOf2 == -1) {
                iIndexOf2 = iIndexOf;
            }
            return Math.min(iIndexOf, iIndexOf2) + 1;
        }
        char cCharAt2 = str.charAt(1);
        if (cCharAt2 == ':') {
            char upperCase = Character.toUpperCase(cCharAt);
            if (upperCase < 'A' || upperCase > 'Z') {
                return upperCase == '/' ? 1 : -1;
            }
            if (length != 2 || FileSystem.getCurrent().supportsDriveLetter()) {
                return (length == 2 || !isSeparator(str.charAt(2))) ? 2 : 3;
            }
            return 0;
        }
        if (!isSeparator(cCharAt) || !isSeparator(cCharAt2)) {
            return isSeparator(cCharAt) ? 1 : 0;
        }
        int iIndexOf3 = str.indexOf(47, 2);
        int iIndexOf4 = str.indexOf(92, 2);
        if ((iIndexOf3 != -1 || iIndexOf4 != -1) && iIndexOf3 != 2 && iIndexOf4 != 2) {
            if (iIndexOf3 == -1) {
                iIndexOf3 = iIndexOf4;
            }
            if (iIndexOf4 == -1) {
                iIndexOf4 = iIndexOf3;
            }
            int iMin = Math.min(iIndexOf3, iIndexOf4);
            int i5 = iMin + 1;
            if (isValidHostName(str.substring(2, iMin))) {
                return i5;
            }
        }
        return -1;
    }

    public static int indexOfExtension(String str) {
        if (str == null) {
            return -1;
        }
        if (isSystemWindows() && str.indexOf(58, getAdsCriticalOffset(str)) != -1) {
            throw new IllegalArgumentException("NTFS ADS separator (':') in file name is forbidden.");
        }
        int iLastIndexOf = str.lastIndexOf(46);
        if (indexOfLastSeparator(str) > iLastIndexOf) {
            return -1;
        }
        return iLastIndexOf;
    }

    public static int indexOfLastSeparator(String str) {
        if (str == null) {
            return -1;
        }
        return Math.max(str.lastIndexOf(47), str.lastIndexOf(92));
    }

    public static boolean isExtension(String str, String str2) {
        if (str == null) {
            return false;
        }
        requireNonNullChars(str);
        if (str2 == null || str2.isEmpty()) {
            return indexOfExtension(str) == -1;
        }
        return getExtension(str).equals(str2);
    }

    private static boolean isIPv4Address(String str) {
        Matcher matcher = IPV4_PATTERN.matcher(str);
        if (!matcher.matches() || matcher.groupCount() != 4) {
            return false;
        }
        for (int i5 = 1; i5 <= 4; i5++) {
            String strGroup = matcher.group(i5);
            if (Integer.parseInt(strGroup) > 255) {
                return false;
            }
            if (strGroup.length() > 1 && strGroup.startsWith("0")) {
                return false;
            }
        }
        return true;
    }

    private static boolean isIPv6Address(String str) {
        boolean zContains = str.contains("::");
        if (zContains && str.indexOf("::") != str.lastIndexOf("::")) {
            return false;
        }
        if ((str.startsWith(ParameterizedMessage.ERROR_MSG_SEPARATOR) && !str.startsWith("::")) || (str.endsWith(ParameterizedMessage.ERROR_MSG_SEPARATOR) && !str.endsWith("::"))) {
            return false;
        }
        String[] strArrSplit = str.split(ParameterizedMessage.ERROR_MSG_SEPARATOR);
        if (zContains) {
            ArrayList arrayList = new ArrayList(Arrays.asList(strArrSplit));
            if (str.endsWith("::")) {
                arrayList.add("");
            } else if (str.startsWith("::") && !arrayList.isEmpty()) {
                arrayList.remove(0);
            }
            strArrSplit = (String[]) arrayList.toArray(EMPTY_STRING_ARRAY);
        }
        if (strArrSplit.length > 8) {
            return false;
        }
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 0; i7 < strArrSplit.length; i7++) {
            String str2 = strArrSplit[i7];
            if (str2.isEmpty()) {
                i6++;
                if (i6 > 1) {
                    return false;
                }
            } else {
                if (i7 == strArrSplit.length - 1 && str2.contains(Consts.DOT)) {
                    if (!isIPv4Address(str2)) {
                        return false;
                    }
                    i5 += 2;
                    i6 = 0;
                } else {
                    if (str2.length() > 4) {
                        return false;
                    }
                    try {
                        int i8 = Integer.parseInt(str2, 16);
                        if (i8 < 0 || i8 > 65535) {
                            return false;
                        }
                        i6 = 0;
                    } catch (NumberFormatException unused) {
                    }
                }
            }
            i5++;
        }
        return i5 <= 8 && (i5 >= 8 || zContains);
    }

    private static boolean isRFC3986HostName(String str) {
        String[] strArrSplit = str.split("\\.", -1);
        int i5 = 0;
        while (i5 < strArrSplit.length) {
            if (strArrSplit[i5].isEmpty()) {
                return i5 == strArrSplit.length - 1;
            }
            if (!REG_NAME_PART_PATTERN.matcher(strArrSplit[i5]).matches()) {
                return false;
            }
            i5++;
        }
        return true;
    }

    private static boolean isSeparator(char c) {
        return c == '/' || c == '\\';
    }

    public static boolean isSystemWindows() {
        return SYSTEM_SEPARATOR == '\\';
    }

    private static boolean isValidHostName(String str) {
        return isIPv6Address(str) || isRFC3986HostName(str);
    }

    public static String normalize(String str) {
        return doNormalize(str, SYSTEM_SEPARATOR, true);
    }

    public static String normalizeNoEndSeparator(String str) {
        return doNormalize(str, SYSTEM_SEPARATOR, false);
    }

    public static String removeExtension(String str) {
        if (str == null) {
            return null;
        }
        requireNonNullChars(str);
        int iIndexOfExtension = indexOfExtension(str);
        return iIndexOfExtension == -1 ? str : str.substring(0, iIndexOfExtension);
    }

    private static void requireNonNullChars(String str) {
        if (str.indexOf(0) >= 0) {
            throw new IllegalArgumentException("Null byte present in file/path name. There are no known legitimate use cases for such data, but several injection attacks may use it");
        }
    }

    public static String separatorsToSystem(String str) {
        if (str == null) {
            return null;
        }
        return isSystemWindows() ? separatorsToWindows(str) : separatorsToUnix(str);
    }

    public static String separatorsToUnix(String str) {
        return (str == null || str.indexOf(92) == -1) ? str : str.replace('\\', '/');
    }

    public static String separatorsToWindows(String str) {
        return (str == null || str.indexOf(47) == -1) ? str : str.replace('/', '\\');
    }

    public static String[] splitOnTokens(String str) {
        if (str.indexOf(63) == -1 && str.indexOf(42) == -1) {
            return new String[]{str};
        }
        char[] charArray = str.toCharArray();
        ArrayList arrayList = new ArrayList();
        StringBuilder sb = new StringBuilder();
        int length = charArray.length;
        int i5 = 0;
        char c = 0;
        while (i5 < length) {
            char c6 = charArray[i5];
            if (c6 == '?' || c6 == '*') {
                if (sb.length() != 0) {
                    arrayList.add(sb.toString());
                    sb.setLength(0);
                }
                if (c6 == '?') {
                    arrayList.add("?");
                } else if (c != '*') {
                    arrayList.add(ProxyConfig.MATCH_ALL_SCHEMES);
                }
            } else {
                sb.append(c6);
            }
            i5++;
            c = c6;
        }
        if (sb.length() != 0) {
            arrayList.add(sb.toString());
        }
        return (String[]) arrayList.toArray(EMPTY_STRING_ARRAY);
    }

    public static boolean wildcardMatch(String str, String str2) {
        return wildcardMatch(str, str2, IOCase.SENSITIVE);
    }

    public static boolean wildcardMatchOnSystem(String str, String str2) {
        return wildcardMatch(str, str2, IOCase.SYSTEM);
    }

    public static boolean equals(String str, String str2, boolean z6, IOCase iOCase) {
        if (str == null || str2 == null) {
            return str == null && str2 == null;
        }
        if (z6 && ((str = normalize(str)) == null || (str2 = normalize(str2)) == null)) {
            return false;
        }
        if (iOCase == null) {
            iOCase = IOCase.SENSITIVE;
        }
        return iOCase.checkEquals(str, str2);
    }

    public static String normalize(String str, boolean z6) {
        return doNormalize(str, z6 ? '/' : '\\', true);
    }

    public static String normalizeNoEndSeparator(String str, boolean z6) {
        return doNormalize(str, z6 ? '/' : '\\', false);
    }

    public static boolean wildcardMatch(String str, String str2, IOCase iOCase) {
        if (str == null && str2 == null) {
            return true;
        }
        if (str != null && str2 != null) {
            if (iOCase == null) {
                iOCase = IOCase.SENSITIVE;
            }
            String[] strArrSplitOnTokens = splitOnTokens(str2);
            ArrayDeque arrayDeque = new ArrayDeque(strArrSplitOnTokens.length);
            boolean z6 = false;
            int length = 0;
            int i5 = 0;
            do {
                if (!arrayDeque.isEmpty()) {
                    int[] iArr = (int[]) arrayDeque.pop();
                    i5 = iArr[0];
                    length = iArr[1];
                    z6 = true;
                }
                while (i5 < strArrSplitOnTokens.length) {
                    if (strArrSplitOnTokens[i5].equals("?")) {
                        length++;
                        if (length > str.length()) {
                            break;
                        }
                        z6 = false;
                        i5++;
                    } else {
                        if (strArrSplitOnTokens[i5].equals(ProxyConfig.MATCH_ALL_SCHEMES)) {
                            if (i5 == strArrSplitOnTokens.length - 1) {
                                length = str.length();
                            }
                            z6 = true;
                        } else if (z6) {
                            length = iOCase.checkIndexOf(str, length, strArrSplitOnTokens[i5]);
                            if (length == -1) {
                                break;
                            }
                            int iCheckIndexOf = iOCase.checkIndexOf(str, length + 1, strArrSplitOnTokens[i5]);
                            if (iCheckIndexOf >= 0) {
                                arrayDeque.push(new int[]{i5, iCheckIndexOf});
                            }
                            length = strArrSplitOnTokens[i5].length() + length;
                            z6 = false;
                        } else {
                            if (!iOCase.checkRegionMatches(str, length, strArrSplitOnTokens[i5])) {
                                break;
                            }
                            length = strArrSplitOnTokens[i5].length() + length;
                            z6 = false;
                        }
                        i5++;
                    }
                }
                if (i5 == strArrSplitOnTokens.length && length == str.length()) {
                    return true;
                }
            } while (!arrayDeque.isEmpty());
        }
        return false;
    }

    public static boolean isExtension(String str, String... strArr) {
        if (str == null) {
            return false;
        }
        requireNonNullChars(str);
        if (strArr == null || strArr.length == 0) {
            return indexOfExtension(str) == -1;
        }
        String extension = getExtension(str);
        for (String str2 : strArr) {
            if (extension.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isExtension(String str, Collection<String> collection) {
        if (str == null) {
            return false;
        }
        requireNonNullChars(str);
        if (collection == null || collection.isEmpty()) {
            return indexOfExtension(str) == -1;
        }
        String extension = getExtension(str);
        Iterator<String> it = collection.iterator();
        while (it.hasNext()) {
            if (extension.equals(it.next())) {
                return true;
            }
        }
        return false;
    }
}
