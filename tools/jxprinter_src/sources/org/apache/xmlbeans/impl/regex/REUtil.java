package org.apache.xmlbeans.impl.regex;

import androidx.exifinterface.media.a;
import java.text.CharacterIterator;
import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.message.StructuredDataId;
import org.apache.logging.log4j.util.ProcessIdUtil;
import org.apache.poi.ss.formula.functions.Complex;
import org.apache.poi.ss.util.IEEEDouble;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final class REUtil {
    static final int CACHESIZE = 20;
    static final RegularExpression[] regexCache = new RegularExpression[20];

    private REUtil() {
    }

    public static final int composeFromSurrogates(int i5, int i6) {
        return ((((i5 - 55296) << 10) + 65536) + i6) - 56320;
    }

    public static final String createOptionString(int i5) {
        StringBuilder sb = new StringBuilder(9);
        if ((i5 & 256) != 0) {
            sb.append('F');
        }
        if ((i5 & 128) != 0) {
            sb.append('H');
        }
        if ((i5 & 512) != 0) {
            sb.append('X');
        }
        if ((i5 & 2) != 0) {
            sb.append('i');
        }
        if ((i5 & 8) != 0) {
            sb.append('m');
        }
        if ((i5 & 4) != 0) {
            sb.append('s');
        }
        if ((i5 & 32) != 0) {
            sb.append('u');
        }
        if ((i5 & 64) != 0) {
            sb.append('w');
        }
        if ((i5 & 16) != 0) {
            sb.append('x');
        }
        if ((i5 & 1024) != 0) {
            sb.append(',');
        }
        return sb.toString().intern();
    }

    public static RegularExpression createRegex(String str, String str2) {
        RegularExpression regularExpression;
        int options = parseOptions(str2);
        synchronized (regexCache) {
            int i5 = 0;
            while (true) {
                regularExpression = null;
                if (i5 >= 20) {
                    break;
                }
                try {
                    RegularExpression regularExpression2 = regexCache[i5];
                    if (regularExpression2 == null) {
                        i5 = -1;
                        break;
                    }
                    if (regularExpression2.equals(str, options)) {
                        regularExpression = regularExpression2;
                        break;
                    }
                    i5++;
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (regularExpression == null) {
                regularExpression = new RegularExpression(str, str2);
                RegularExpression[] regularExpressionArr = regexCache;
                System.arraycopy(regularExpressionArr, 0, regularExpressionArr, 1, 19);
                regularExpressionArr[0] = regularExpression;
            } else if (i5 != 0) {
                RegularExpression[] regularExpressionArr2 = regexCache;
                System.arraycopy(regularExpressionArr2, 0, regularExpressionArr2, 1, i5);
                regularExpressionArr2[0] = regularExpression;
            }
        }
        return regularExpression;
    }

    public static final String decomposeToSurrogates(int i5) {
        int i6 = i5 - 65536;
        return new String(new char[]{(char) ((i6 >> 10) + 55296), (char) ((i6 & IEEEDouble.EXPONENT_BIAS) + 56320)});
    }

    public static void dumpString(String str) {
        for (int i5 = 0; i5 < str.length(); i5++) {
            System.out.print(Integer.toHexString(str.charAt(i5)));
            System.out.print(" ");
        }
        System.out.println();
    }

    public static final int getOptionValue(int i5) {
        if (i5 == 44) {
            return 1024;
        }
        if (i5 == 70) {
            return 256;
        }
        if (i5 == 72) {
            return 128;
        }
        if (i5 == 88) {
            return 512;
        }
        if (i5 == 105) {
            return 2;
        }
        if (i5 == 109) {
            return 8;
        }
        if (i5 == 115) {
            return 4;
        }
        if (i5 == 117) {
            return 32;
        }
        if (i5 != 119) {
            return i5 != 120 ? 0 : 16;
        }
        return 64;
    }

    public static final boolean isHighSurrogate(int i5) {
        return (i5 & 64512) == 55296;
    }

    public static final boolean isLowSurrogate(int i5) {
        return (i5 & 64512) == 56320;
    }

    public static void main(String[] strArr) {
        String str = null;
        try {
            if (strArr.length == 0) {
                System.out.println("Error:Usage: java REUtil -i|-m|-s|-u|-w|-X regularExpression String");
                System.exit(0);
            }
            String str2 = "";
            String str3 = null;
            for (int i5 = 0; i5 < strArr.length; i5++) {
                if (strArr[i5].length() == 0 || strArr[i5].charAt(0) != '-') {
                    if (str == null) {
                        str = strArr[i5];
                    } else if (str3 == null) {
                        str3 = strArr[i5];
                    } else {
                        System.err.println("Unnecessary: " + strArr[i5]);
                    }
                } else if (strArr[i5].equals("-i")) {
                    str2 = str2 + Complex.DEFAULT_SUFFIX;
                } else if (strArr[i5].equals("-m")) {
                    str2 = str2 + "m";
                } else if (strArr[i5].equals("-s")) {
                    str2 = str2 + "s";
                } else if (strArr[i5].equals("-u")) {
                    str2 = str2 + "u";
                } else if (strArr[i5].equals("-w")) {
                    str2 = str2 + "w";
                } else if (strArr[i5].equals("-X")) {
                    str2 = str2 + "X";
                } else {
                    System.err.println("Unknown option: " + strArr[i5]);
                }
            }
            RegularExpression regularExpression = new RegularExpression(str, str2);
            System.out.println("RegularExpression: " + regularExpression);
            Match match = new Match();
            regularExpression.matches(str3, match);
            for (int i6 = 0; i6 < match.getNumberOfGroups(); i6++) {
                if (i6 == 0) {
                    System.out.print("Matched range for the whole pattern: ");
                } else {
                    System.out.print("[" + i6 + "]: ");
                }
                if (match.getBeginning(i6) < 0) {
                    System.out.println(StructuredDataId.RESERVED);
                } else {
                    System.out.print(match.getBeginning(i6) + ", " + match.getEnd(i6) + ", ");
                    System.out.println("\"" + match.getCapturedText(i6) + "\"");
                }
            }
        } catch (ParseException e) {
            if (str == null) {
                e.printStackTrace();
                return;
            }
            System.err.println("org.apache.xerces.utils.regex.ParseException: " + e.getMessage());
            System.err.println("        ".concat(str));
            int location = e.getLocation();
            if (location >= 0) {
                System.err.print("        ");
                for (int i7 = 0; i7 < location; i7++) {
                    System.err.print(ProcessIdUtil.DEFAULT_PROCESSID);
                }
                System.err.println("^");
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    public static boolean matches(String str, String str2) {
        return createRegex(str, null).matches(str2);
    }

    public static final int parseOptions(String str) {
        if (str == null) {
            return 0;
        }
        int i5 = 0;
        for (int i6 = 0; i6 < str.length(); i6++) {
            int optionValue = getOptionValue(str.charAt(i6));
            if (optionValue == 0) {
                throw new ParseException(a.j(str, i6, new StringBuilder("Unknown Option: ")), -1);
            }
            i5 |= optionValue;
        }
        return i5;
    }

    public static String quoteMeta(String str) {
        int length = str.length();
        StringBuilder sb = null;
        for (int i5 = 0; i5 < length; i5++) {
            char cCharAt = str.charAt(i5);
            if (".*+?{[()|\\^$".indexOf(cCharAt) >= 0) {
                if (sb == null) {
                    sb = new StringBuilder(((length - i5) * 2) + i5);
                    if (i5 > 0) {
                        sb.append(str.substring(0, i5));
                    }
                }
                sb.append(IOUtils.DIR_SEPARATOR_WINDOWS);
                sb.append(cCharAt);
            } else if (sb != null) {
                sb.append(cCharAt);
            }
        }
        return sb != null ? sb.toString() : str;
    }

    public static String stripExtendedComment(String str) {
        int length = str.length();
        StringBuilder sb = new StringBuilder(length);
        int i5 = 0;
        while (i5 < length) {
            int i6 = i5 + 1;
            char cCharAt = str.charAt(i5);
            if (cCharAt != '\t' && cCharAt != '\n' && cCharAt != '\f' && cCharAt != '\r' && cCharAt != ' ') {
                if (cCharAt == '#') {
                    while (true) {
                        i5 = i6;
                        if (i5 >= length) {
                            break;
                        }
                        i6 = i5 + 1;
                        char cCharAt2 = str.charAt(i5);
                        if (cCharAt2 == '\r' || cCharAt2 == '\n') {
                        }
                    }
                } else if (cCharAt != '\\' || i6 >= length) {
                    sb.append(cCharAt);
                } else {
                    char cCharAt3 = str.charAt(i6);
                    if (cCharAt3 == '#' || cCharAt3 == '\t' || cCharAt3 == '\n' || cCharAt3 == '\f' || cCharAt3 == '\r' || cCharAt3 == ' ') {
                        sb.append(cCharAt3);
                    } else {
                        sb.append(IOUtils.DIR_SEPARATOR_WINDOWS);
                        sb.append(cCharAt3);
                    }
                    i5 += 2;
                }
            }
            i5 = i6;
        }
        return sb.toString();
    }

    public static final String substring(CharacterIterator characterIterator, int i5, int i6) {
        int i7 = i6 - i5;
        char[] cArr = new char[i7];
        for (int i8 = 0; i8 < i7; i8++) {
            cArr[i8] = characterIterator.setIndex(i8 + i5);
        }
        return new String(cArr);
    }

    public static boolean matches(String str, String str2, String str3) {
        return createRegex(str, str2).matches(str3);
    }
}
