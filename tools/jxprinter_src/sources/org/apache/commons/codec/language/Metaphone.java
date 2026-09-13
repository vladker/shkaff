package org.apache.commons.codec.language;

import java.util.Locale;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringEncoder;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class Metaphone implements StringEncoder {
    private static final String FRONTV = "EIY";
    private static final String VARSON = "CSPTG";
    private static final String VOWELS = "AEIOU";
    private int maxCodeLen = 4;

    private boolean isLastChar(int i5, int i6) {
        return i6 + 1 == i5;
    }

    private boolean isNextChar(StringBuilder sb, int i5, char c) {
        return i5 >= 0 && i5 < sb.length() - 1 && sb.charAt(i5 + 1) == c;
    }

    private boolean isPreviousChar(StringBuilder sb, int i5, char c) {
        return i5 > 0 && i5 < sb.length() && sb.charAt(i5 - 1) == c;
    }

    private boolean isVowel(StringBuilder sb, int i5) {
        return VOWELS.indexOf(sb.charAt(i5)) >= 0;
    }

    private boolean regionMatch(StringBuilder sb, int i5, String str) {
        if (i5 < 0 || (str.length() + i5) - 1 >= sb.length()) {
            return false;
        }
        return sb.substring(i5, str.length() + i5).equals(str);
    }

    @Override // org.apache.commons.codec.Encoder
    public Object encode(Object obj) throws EncoderException {
        if (obj instanceof String) {
            return metaphone((String) obj);
        }
        throw new EncoderException("Parameter supplied to Metaphone encode is not of type java.lang.String");
    }

    public int getMaxCodeLen() {
        return this.maxCodeLen;
    }

    public boolean isMetaphoneEqual(String str, String str2) {
        return metaphone(str).equals(metaphone(str2));
    }

    /* JADX WARN: Code duplicated, block: B:131:0x020f  */
    public String metaphone(String str) {
        int length;
        if (str == null || (length = str.length()) == 0) {
            return "";
        }
        boolean z6 = true;
        if (length == 1) {
            return str.toUpperCase(Locale.ENGLISH);
        }
        char[] charArray = str.toUpperCase(Locale.ENGLISH).toCharArray();
        StringBuilder sb = new StringBuilder(40);
        StringBuilder sb2 = new StringBuilder(10);
        int i5 = 0;
        char c = charArray[0];
        if (c != 'A') {
            if (c == 'G' || c == 'K' || c == 'P') {
                if (charArray[1] == 'N') {
                    sb.append(charArray, 1, charArray.length - 1);
                } else {
                    sb.append(charArray);
                }
            } else if (c == 'W') {
                char c6 = charArray[1];
                if (c6 == 'R') {
                    sb.append(charArray, 1, charArray.length - 1);
                } else if (c6 == 'H') {
                    sb.append(charArray, 1, charArray.length - 1);
                    sb.setCharAt(0, 'W');
                } else {
                    sb.append(charArray);
                }
            } else if (c != 'X') {
                sb.append(charArray);
            } else {
                charArray[0] = 'S';
                sb.append(charArray);
            }
        } else if (charArray[1] == 'E') {
            sb.append(charArray, 1, charArray.length - 1);
        } else {
            sb.append(charArray);
        }
        int length2 = sb.length();
        while (sb2.length() < getMaxCodeLen() && i5 < length2) {
            char cCharAt = sb.charAt(i5);
            if (cCharAt == 'C' || !isPreviousChar(sb, i5, cCharAt)) {
                switch (cCharAt) {
                    case 'A':
                    case 'E':
                    case 'I':
                    case 'O':
                    case 'U':
                        if (i5 == 0) {
                            sb2.append(cCharAt);
                        }
                        break;
                    case 'B':
                        if (!isPreviousChar(sb, i5, 'M') || !isLastChar(length2, i5)) {
                            sb2.append(cCharAt);
                        }
                        break;
                    case 'C':
                        if (!isPreviousChar(sb, i5, 'S') || isLastChar(length2, i5) || FRONTV.indexOf(sb.charAt(i5 + 1)) < 0) {
                            if (regionMatch(sb, i5, "CIA")) {
                                sb2.append('X');
                            } else if (!isLastChar(length2, i5) && FRONTV.indexOf(sb.charAt(i5 + 1)) >= 0) {
                                sb2.append('S');
                            } else if ((isPreviousChar(sb, i5, 'S') && isNextChar(sb, i5, 'H')) || !isNextChar(sb, i5, 'H')) {
                                sb2.append('K');
                            } else if (i5 == 0 && length2 >= 3 && isVowel(sb, 2)) {
                                sb2.append('K');
                            } else {
                                sb2.append('X');
                            }
                        }
                        break;
                    case 'D':
                        if (!isLastChar(length2, i5 + 1) && isNextChar(sb, i5, 'G')) {
                            int i6 = i5 + 2;
                            if (FRONTV.indexOf(sb.charAt(i6)) < 0) {
                                sb2.append('T');
                            } else {
                                sb2.append('J');
                                i5 = i6;
                            }
                        } else {
                            sb2.append('T');
                        }
                        break;
                    case 'F':
                    case 'J':
                    case 'L':
                    case 'M':
                    case 'N':
                    case 'R':
                        sb2.append(cCharAt);
                        break;
                    case 'G':
                        int i7 = i5 + 1;
                        if ((!isLastChar(length2, i7) || !isNextChar(sb, i5, 'H')) && ((isLastChar(length2, i7) || !isNextChar(sb, i5, 'H') || isVowel(sb, i5 + 2)) && (i5 <= 0 || (!regionMatch(sb, i5, "GN") && !regionMatch(sb, i5, "GNED"))))) {
                            boolean zIsPreviousChar = isPreviousChar(sb, i5, 'G');
                            if (isLastChar(length2, i5) || FRONTV.indexOf(sb.charAt(i7)) < 0 || zIsPreviousChar) {
                                sb2.append('K');
                            } else {
                                sb2.append('J');
                            }
                        }
                        break;
                    case 'H':
                        if (!isLastChar(length2, i5) && ((i5 <= 0 || VARSON.indexOf(sb.charAt(i5 - 1)) < 0) && isVowel(sb, i5 + 1))) {
                            sb2.append('H');
                        }
                        break;
                    case 'K':
                        if (i5 <= 0 || !isPreviousChar(sb, i5, 'C')) {
                            sb2.append(cCharAt);
                        }
                        break;
                    case 'P':
                        if (!isNextChar(sb, i5, 'H')) {
                            sb2.append(cCharAt);
                        } else {
                            sb2.append('F');
                        }
                        break;
                    case 'Q':
                        sb2.append('K');
                        break;
                    case 'S':
                        if (regionMatch(sb, i5, "SH") || regionMatch(sb, i5, "SIO") || regionMatch(sb, i5, "SIA")) {
                            sb2.append('X');
                        } else {
                            sb2.append('S');
                        }
                        break;
                    case 'T':
                        if (regionMatch(sb, i5, "TIA") || regionMatch(sb, i5, "TIO")) {
                            sb2.append('X');
                        } else if (!regionMatch(sb, i5, "TCH")) {
                            if (!regionMatch(sb, i5, "TH")) {
                                sb2.append('T');
                            } else {
                                sb2.append('0');
                            }
                        }
                        break;
                    case 'V':
                        sb2.append('F');
                        break;
                    case 'W':
                    case 'Y':
                        if (!isLastChar(length2, i5) && isVowel(sb, i5 + 1)) {
                            sb2.append(cCharAt);
                        }
                        break;
                    case 'X':
                        sb2.append('K');
                        sb2.append('S');
                        break;
                    case 'Z':
                        sb2.append('S');
                        break;
                }
                i5++;
            } else {
                i5++;
            }
            if (sb2.length() > getMaxCodeLen()) {
                sb2.setLength(getMaxCodeLen());
            }
            z6 = z6;
        }
        return sb2.toString();
    }

    public void setMaxCodeLen(int i5) {
        this.maxCodeLen = i5;
    }

    @Override // org.apache.commons.codec.StringEncoder
    public String encode(String str) {
        return metaphone(str);
    }
}
