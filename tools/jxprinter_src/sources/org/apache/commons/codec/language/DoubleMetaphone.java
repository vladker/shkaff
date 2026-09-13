package org.apache.commons.codec.language;

import androidx.exifinterface.media.ExifInterface;
import java.util.Locale;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringEncoder;
import org.apache.commons.codec.binary.StringUtils;
import org.apache.logging.log4j.util.Chars;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class DoubleMetaphone implements StringEncoder {
    private static final String VOWELS = "AEIOUY";
    private int maxCodeLen = 4;
    private static final String[] SILENT_START = {"GN", "KN", "PN", "WR", "PS"};
    private static final String[] L_R_N_M_B_H_F_V_W_SPACE = {"L", "R", "N", "M", "B", "H", "F", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, ExifInterface.LONGITUDE_WEST, " "};
    private static final String[] ES_EP_EB_EL_EY_IB_IL_IN_IE_EI_ER = {"ES", "EP", "EB", "EL", "EY", "IB", "IL", "IN", "IE", "EI", "ER"};
    private static final String[] L_T_K_S_N_M_B_Z = {"L", ExifInterface.GPS_DIRECTION_TRUE, "K", ExifInterface.LATITUDE_SOUTH, "N", "M", "B", "Z"};

    private String cleanInput(String str) {
        if (str == null) {
            return null;
        }
        String strTrim = str.trim();
        if (strTrim.length() == 0) {
            return null;
        }
        return strTrim.toUpperCase(Locale.ENGLISH);
    }

    private boolean conditionC0(String str, int i5) {
        if (contains(str, i5, 4, "CHIA")) {
            return true;
        }
        if (i5 <= 1) {
            return false;
        }
        int i6 = i5 - 2;
        if (isVowel(charAt(str, i6)) || !contains(str, i5 - 1, 3, "ACH")) {
            return false;
        }
        char cCharAt = charAt(str, i5 + 2);
        return !(cCharAt == 'I' || cCharAt == 'E') || contains(str, i6, 6, "BACHER", "MACHER");
    }

    private boolean conditionCH0(String str, int i5) {
        if (i5 != 0) {
            return false;
        }
        int i6 = i5 + 1;
        return (contains(str, i6, 5, "HARAC", "HARIS") || contains(str, i6, 3, "HOR", "HYM", "HIA", "HEM")) && !contains(str, 0, 5, "CHORE");
    }

    private boolean conditionCH1(String str, int i5) {
        if (!contains(str, 0, 4, "VAN ", "VON ") && !contains(str, 0, 3, "SCH") && !contains(str, i5 - 2, 6, "ORCHES", "ARCHIT", "ORCHID")) {
            int i6 = i5 + 2;
            if (!contains(str, i6, 1, ExifInterface.GPS_DIRECTION_TRUE, ExifInterface.LATITUDE_SOUTH) && ((!contains(str, i5 - 1, 1, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "O", "U", ExifInterface.LONGITUDE_EAST) && i5 != 0) || (!contains(str, i6, 1, L_R_N_M_B_H_F_V_W_SPACE) && i5 + 1 != str.length() - 1))) {
                return false;
            }
        }
        return true;
    }

    private boolean conditionL0(String str, int i5) {
        if (i5 == str.length() - 3 && contains(str, i5 - 1, 4, "ILLO", "ILLA", "ALLE")) {
            return true;
        }
        return (contains(str, str.length() - 2, 2, "AS", "OS") || contains(str, str.length() - 1, 1, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "O")) && contains(str, i5 - 1, 4, "ALLE");
    }

    private boolean conditionM0(String str, int i5) {
        int i6 = i5 + 1;
        if (charAt(str, i6) == 'M') {
            return true;
        }
        if (contains(str, i5 - 1, 3, "UMB")) {
            return i6 == str.length() - 1 || contains(str, i5 + 2, 2, "ER");
        }
        return false;
    }

    public static boolean contains(String str, int i5, int i6, String... strArr) {
        int i7;
        if (i5 >= 0 && (i7 = i6 + i5) <= str.length()) {
            String strSubstring = str.substring(i5, i7);
            for (String str2 : strArr) {
                if (strSubstring.equals(str2)) {
                    return true;
                }
            }
        }
        return false;
    }

    private int handleAEIOUY(DoubleMetaphoneResult doubleMetaphoneResult, int i5) {
        if (i5 == 0) {
            doubleMetaphoneResult.append('A');
        }
        return i5 + 1;
    }

    private int handleC(String str, DoubleMetaphoneResult doubleMetaphoneResult, int i5) {
        if (conditionC0(str, i5)) {
            doubleMetaphoneResult.append('K');
            return i5 + 2;
        }
        if (i5 == 0 && contains(str, i5, 6, "CAESAR")) {
            doubleMetaphoneResult.append('S');
            return i5 + 2;
        }
        if (contains(str, i5, 2, "CH")) {
            return handleCH(str, doubleMetaphoneResult, i5);
        }
        if (contains(str, i5, 2, "CZ") && !contains(str, i5 - 2, 4, "WICZ")) {
            doubleMetaphoneResult.append('S', 'X');
            return i5 + 2;
        }
        int i6 = i5 + 1;
        if (contains(str, i6, 3, "CIA")) {
            doubleMetaphoneResult.append('X');
            return i5 + 3;
        }
        if (contains(str, i5, 2, "CC") && (i5 != 1 || charAt(str, 0) != 'M')) {
            return handleCC(str, doubleMetaphoneResult, i5);
        }
        if (contains(str, i5, 2, "CK", "CG", "CQ")) {
            doubleMetaphoneResult.append('K');
            return i5 + 2;
        }
        if (contains(str, i5, 2, "CI", "CE", "CY")) {
            if (contains(str, i5, 3, "CIO", "CIE", "CIA")) {
                doubleMetaphoneResult.append('S', 'X');
            } else {
                doubleMetaphoneResult.append('S');
            }
            return i5 + 2;
        }
        doubleMetaphoneResult.append('K');
        if (contains(str, i6, 2, " C", " Q", " G")) {
            return i5 + 3;
        }
        return (!contains(str, i6, 1, "C", "K", "Q") || contains(str, i6, 2, "CE", "CI")) ? i6 : i5 + 2;
    }

    private int handleCC(String str, DoubleMetaphoneResult doubleMetaphoneResult, int i5) {
        int i6 = i5 + 2;
        if (!contains(str, i6, 1, "I", ExifInterface.LONGITUDE_EAST, "H") || contains(str, i6, 2, "HU")) {
            doubleMetaphoneResult.append('K');
            return i6;
        }
        if ((i5 == 1 && charAt(str, i5 - 1) == 'A') || contains(str, i5 - 1, 5, "UCCEE", "UCCES")) {
            doubleMetaphoneResult.append("KS");
        } else {
            doubleMetaphoneResult.append('X');
        }
        return i5 + 3;
    }

    private int handleCH(String str, DoubleMetaphoneResult doubleMetaphoneResult, int i5) {
        if (i5 > 0 && contains(str, i5, 4, "CHAE")) {
            doubleMetaphoneResult.append('K', 'X');
        } else {
            if (!conditionCH0(str, i5) && !conditionCH1(str, i5)) {
                if (i5 <= 0) {
                    doubleMetaphoneResult.append('X');
                } else if (contains(str, 0, 2, "MC")) {
                    doubleMetaphoneResult.append('K');
                } else {
                    doubleMetaphoneResult.append('X', 'K');
                }
                return i5 + 2;
            }
            doubleMetaphoneResult.append('K');
        }
        return i5 + 2;
    }

    private int handleD(String str, DoubleMetaphoneResult doubleMetaphoneResult, int i5) {
        if (!contains(str, i5, 2, "DG")) {
            if (contains(str, i5, 2, "DT", "DD")) {
                doubleMetaphoneResult.append('T');
                return i5 + 2;
            }
            doubleMetaphoneResult.append('T');
            return i5 + 1;
        }
        int i6 = i5 + 2;
        if (contains(str, i6, 1, "I", ExifInterface.LONGITUDE_EAST, "Y")) {
            doubleMetaphoneResult.append('J');
            return i5 + 3;
        }
        doubleMetaphoneResult.append("TK");
        return i6;
    }

    private int handleG(String str, DoubleMetaphoneResult doubleMetaphoneResult, int i5, boolean z6) {
        int i6 = i5 + 1;
        if (charAt(str, i6) == 'H') {
            return handleGH(str, doubleMetaphoneResult, i5);
        }
        if (charAt(str, i6) == 'N') {
            if (i5 == 1 && isVowel(charAt(str, 0)) && !z6) {
                doubleMetaphoneResult.append("KN", "N");
            } else if (contains(str, i5 + 2, 2, "EY") || charAt(str, i6) == 'Y' || z6) {
                doubleMetaphoneResult.append("KN");
            } else {
                doubleMetaphoneResult.append("N", "KN");
            }
            return i5 + 2;
        }
        if (contains(str, i6, 2, "LI") && !z6) {
            doubleMetaphoneResult.append("KL", "L");
            return i5 + 2;
        }
        if (i5 == 0 && (charAt(str, i6) == 'Y' || contains(str, i6, 2, ES_EP_EB_EL_EY_IB_IL_IN_IE_EI_ER))) {
            doubleMetaphoneResult.append('K', 'J');
            return i5 + 2;
        }
        if ((contains(str, i6, 2, "ER") || charAt(str, i6) == 'Y') && !contains(str, 0, 6, "DANGER", "RANGER", "MANGER")) {
            int i7 = i5 - 1;
            if (!contains(str, i7, 1, ExifInterface.LONGITUDE_EAST, "I") && !contains(str, i7, 3, "RGY", "OGY")) {
                doubleMetaphoneResult.append('K', 'J');
                return i5 + 2;
            }
        }
        if (!contains(str, i6, 1, ExifInterface.LONGITUDE_EAST, "I", "Y") && !contains(str, i5 - 1, 4, "AGGI", "OGGI")) {
            if (charAt(str, i6) != 'G') {
                doubleMetaphoneResult.append('K');
                return i6;
            }
            int i8 = i5 + 2;
            doubleMetaphoneResult.append('K');
            return i8;
        }
        if (contains(str, 0, 4, "VAN ", "VON ") || contains(str, 0, 3, "SCH") || contains(str, i6, 2, "ET")) {
            doubleMetaphoneResult.append('K');
        } else if (contains(str, i6, 3, "IER")) {
            doubleMetaphoneResult.append('J');
        } else {
            doubleMetaphoneResult.append('J', 'K');
        }
        return i5 + 2;
    }

    private int handleGH(String str, DoubleMetaphoneResult doubleMetaphoneResult, int i5) {
        if (i5 > 0 && !isVowel(charAt(str, i5 - 1))) {
            doubleMetaphoneResult.append('K');
            return i5 + 2;
        }
        if (i5 == 0) {
            int i6 = i5 + 2;
            if (charAt(str, i6) == 'I') {
                doubleMetaphoneResult.append('J');
            } else {
                doubleMetaphoneResult.append('K');
            }
            return i6;
        }
        if ((i5 > 1 && contains(str, i5 - 2, 1, "B", "H", "D")) || ((i5 > 2 && contains(str, i5 - 3, 1, "B", "H", "D")) || (i5 > 3 && contains(str, i5 - 4, 1, "B", "H")))) {
            return i5 + 2;
        }
        if (i5 > 2 && charAt(str, i5 - 1) == 'U' && contains(str, i5 - 3, 1, "C", "G", "L", "R", ExifInterface.GPS_DIRECTION_TRUE)) {
            doubleMetaphoneResult.append('F');
        } else if (i5 > 0 && charAt(str, i5 - 1) != 'I') {
            doubleMetaphoneResult.append('K');
        }
        return i5 + 2;
    }

    private int handleH(String str, DoubleMetaphoneResult doubleMetaphoneResult, int i5) {
        if ((i5 != 0 && !isVowel(charAt(str, i5 - 1))) || !isVowel(charAt(str, i5 + 1))) {
            return i5 + 1;
        }
        doubleMetaphoneResult.append('H');
        return i5 + 2;
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0056  */
    /* JADX WARN: Code duplicated, block: B:22:0x005d  */
    /* JADX WARN: Code duplicated, block: B:23:0x0061  */
    private int handleJ(String str, DoubleMetaphoneResult doubleMetaphoneResult, int i5, boolean z6) {
        if (contains(str, i5, 4, "JOSE") || contains(str, 0, 4, "SAN ")) {
            if ((i5 == 0 && charAt(str, i5 + 4) == ' ') || str.length() == 4 || contains(str, 0, 4, "SAN ")) {
                doubleMetaphoneResult.append('H');
            } else {
                doubleMetaphoneResult.append('J', 'H');
            }
            return i5 + 1;
        }
        if (i5 != 0 || contains(str, i5, 4, "JOSE")) {
            int i6 = i5 - 1;
            if (isVowel(charAt(str, i6)) && !z6) {
                int i7 = i5 + 1;
                if (charAt(str, i7) == 'A' || charAt(str, i7) == 'O') {
                    doubleMetaphoneResult.append('J', 'H');
                } else if (i5 == str.length() - 1) {
                    doubleMetaphoneResult.append('J', Chars.SPACE);
                } else if (!contains(str, i5 + 1, 1, L_T_K_S_N_M_B_Z)) {
                    doubleMetaphoneResult.append('J');
                }
            } else if (i5 == str.length() - 1) {
                doubleMetaphoneResult.append('J', Chars.SPACE);
            } else if (!contains(str, i5 + 1, 1, L_T_K_S_N_M_B_Z) && !contains(str, i6, 1, ExifInterface.LATITUDE_SOUTH, "K", "L")) {
                doubleMetaphoneResult.append('J');
            }
        } else {
            doubleMetaphoneResult.append('J', 'A');
        }
        int i8 = i5 + 1;
        return charAt(str, i8) == 'J' ? i5 + 2 : i8;
    }

    private int handleL(String str, DoubleMetaphoneResult doubleMetaphoneResult, int i5) {
        int i6 = i5 + 1;
        if (charAt(str, i6) != 'L') {
            doubleMetaphoneResult.append('L');
            return i6;
        }
        if (conditionL0(str, i5)) {
            doubleMetaphoneResult.appendPrimary('L');
        } else {
            doubleMetaphoneResult.append('L');
        }
        return i5 + 2;
    }

    private int handleP(String str, DoubleMetaphoneResult doubleMetaphoneResult, int i5) {
        int i6 = i5 + 1;
        if (charAt(str, i6) == 'H') {
            doubleMetaphoneResult.append('F');
            return i5 + 2;
        }
        doubleMetaphoneResult.append('P');
        return contains(str, i6, 1, "P", "B") ? i5 + 2 : i6;
    }

    private int handleR(String str, DoubleMetaphoneResult doubleMetaphoneResult, int i5, boolean z6) {
        if (i5 != str.length() - 1 || z6 || !contains(str, i5 - 2, 2, "IE") || contains(str, i5 - 4, 2, "ME", "MA")) {
            doubleMetaphoneResult.append('R');
        } else {
            doubleMetaphoneResult.appendAlternate('R');
        }
        int i6 = i5 + 1;
        return charAt(str, i6) == 'R' ? i5 + 2 : i6;
    }

    private int handleS(String str, DoubleMetaphoneResult doubleMetaphoneResult, int i5, boolean z6) {
        if (contains(str, i5 - 1, 3, "ISL", "YSL")) {
            return i5 + 1;
        }
        if (i5 == 0 && contains(str, i5, 5, "SUGAR")) {
            doubleMetaphoneResult.append('X', 'S');
            return i5 + 1;
        }
        if (contains(str, i5, 2, "SH")) {
            if (contains(str, i5 + 1, 4, "HEIM", "HOEK", "HOLM", "HOLZ")) {
                doubleMetaphoneResult.append('S');
            } else {
                doubleMetaphoneResult.append('X');
            }
            return i5 + 2;
        }
        if (contains(str, i5, 3, "SIO", "SIA") || contains(str, i5, 4, "SIAN")) {
            if (z6) {
                doubleMetaphoneResult.append('S');
            } else {
                doubleMetaphoneResult.append('S', 'X');
            }
            return i5 + 3;
        }
        if (i5 != 0 || !contains(str, i5 + 1, 1, "M", "N", "L", ExifInterface.LONGITUDE_WEST)) {
            int i6 = i5 + 1;
            if (!contains(str, i6, 1, "Z")) {
                if (contains(str, i5, 2, "SC")) {
                    return handleSC(str, doubleMetaphoneResult, i5);
                }
                if (i5 == str.length() - 1 && contains(str, i5 - 2, 2, "AI", "OI")) {
                    doubleMetaphoneResult.appendAlternate('S');
                } else {
                    doubleMetaphoneResult.append('S');
                }
                return contains(str, i6, 1, ExifInterface.LATITUDE_SOUTH, "Z") ? i5 + 2 : i6;
            }
        }
        doubleMetaphoneResult.append('S', 'X');
        int i7 = i5 + 1;
        return contains(str, i7, 1, "Z") ? i5 + 2 : i7;
    }

    private int handleSC(String str, DoubleMetaphoneResult doubleMetaphoneResult, int i5) {
        int i6 = i5 + 2;
        if (charAt(str, i6) == 'H') {
            int i7 = i5 + 3;
            if (contains(str, i7, 2, "OO", "ER", "EN", "UY", "ED", "EM")) {
                if (contains(str, i7, 2, "ER", "EN")) {
                    doubleMetaphoneResult.append("X", "SK");
                } else {
                    doubleMetaphoneResult.append("SK");
                }
            } else if (i5 != 0 || isVowel(charAt(str, 3)) || charAt(str, 3) == 'W') {
                doubleMetaphoneResult.append('X');
            } else {
                doubleMetaphoneResult.append('X', 'S');
            }
        } else if (contains(str, i6, 1, "I", ExifInterface.LONGITUDE_EAST, "Y")) {
            doubleMetaphoneResult.append('S');
        } else {
            doubleMetaphoneResult.append("SK");
        }
        return i5 + 3;
    }

    private int handleT(String str, DoubleMetaphoneResult doubleMetaphoneResult, int i5) {
        if (contains(str, i5, 4, "TION") || contains(str, i5, 3, "TIA", "TCH")) {
            doubleMetaphoneResult.append('X');
            return i5 + 3;
        }
        if (!contains(str, i5, 2, "TH") && !contains(str, i5, 3, "TTH")) {
            doubleMetaphoneResult.append('T');
            int i6 = i5 + 1;
            return contains(str, i6, 1, ExifInterface.GPS_DIRECTION_TRUE, "D") ? i5 + 2 : i6;
        }
        int i7 = i5 + 2;
        if (contains(str, i7, 2, "OM", "AM") || contains(str, 0, 4, "VAN ", "VON ") || contains(str, 0, 3, "SCH")) {
            doubleMetaphoneResult.append('T');
        } else {
            doubleMetaphoneResult.append('0', 'T');
        }
        return i7;
    }

    private int handleW(String str, DoubleMetaphoneResult doubleMetaphoneResult, int i5) {
        if (contains(str, i5, 2, "WR")) {
            doubleMetaphoneResult.append('R');
            return i5 + 2;
        }
        if (i5 == 0) {
            int i6 = i5 + 1;
            if (isVowel(charAt(str, i6)) || contains(str, i5, 2, "WH")) {
                if (isVowel(charAt(str, i6))) {
                    doubleMetaphoneResult.append('A', 'F');
                } else {
                    doubleMetaphoneResult.append('A');
                }
                return i6;
            }
        }
        if ((i5 == str.length() - 1 && isVowel(charAt(str, i5 - 1))) || contains(str, i5 - 1, 5, "EWSKI", "EWSKY", "OWSKI", "OWSKY") || contains(str, 0, 3, "SCH")) {
            doubleMetaphoneResult.appendAlternate('F');
            return i5 + 1;
        }
        if (!contains(str, i5, 4, "WICZ", "WITZ")) {
            return i5 + 1;
        }
        doubleMetaphoneResult.append("TS", "FX");
        return i5 + 4;
    }

    private int handleX(String str, DoubleMetaphoneResult doubleMetaphoneResult, int i5) {
        if (i5 == 0) {
            doubleMetaphoneResult.append('S');
            return i5 + 1;
        }
        if (i5 != str.length() - 1 || (!contains(str, i5 - 3, 3, "IAU", "EAU") && !contains(str, i5 - 2, 2, "AU", "OU"))) {
            doubleMetaphoneResult.append("KS");
        }
        int i6 = i5 + 1;
        return contains(str, i6, 1, "C", "X") ? i5 + 2 : i6;
    }

    private int handleZ(String str, DoubleMetaphoneResult doubleMetaphoneResult, int i5, boolean z6) {
        int i6 = i5 + 1;
        if (charAt(str, i6) == 'H') {
            doubleMetaphoneResult.append('J');
            return i5 + 2;
        }
        if (contains(str, i6, 2, "ZO", "ZI", "ZA") || (z6 && i5 > 0 && charAt(str, i5 - 1) != 'T')) {
            doubleMetaphoneResult.append(ExifInterface.LATITUDE_SOUTH, "TS");
        } else {
            doubleMetaphoneResult.append('S');
        }
        return charAt(str, i6) == 'Z' ? i5 + 2 : i6;
    }

    private boolean isSilentStart(String str) {
        for (String str2 : SILENT_START) {
            if (str.startsWith(str2)) {
                return true;
            }
        }
        return false;
    }

    private boolean isSlavoGermanic(String str) {
        return str.indexOf(87) > -1 || str.indexOf(75) > -1 || str.indexOf("CZ") > -1 || str.indexOf("WITZ") > -1;
    }

    private boolean isVowel(char c) {
        return VOWELS.indexOf(c) != -1;
    }

    public char charAt(String str, int i5) {
        if (i5 < 0 || i5 >= str.length()) {
            return (char) 0;
        }
        return str.charAt(i5);
    }

    public String doubleMetaphone(String str) {
        return doubleMetaphone(str, false);
    }

    @Override // org.apache.commons.codec.Encoder
    public Object encode(Object obj) throws EncoderException {
        if (obj instanceof String) {
            return doubleMetaphone((String) obj);
        }
        throw new EncoderException("DoubleMetaphone encode parameter is not of type String");
    }

    public int getMaxCodeLen() {
        return this.maxCodeLen;
    }

    public boolean isDoubleMetaphoneEqual(String str, String str2) {
        return isDoubleMetaphoneEqual(str, str2, false);
    }

    public void setMaxCodeLen(int i5) {
        this.maxCodeLen = i5;
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class DoubleMetaphoneResult {
        private final StringBuilder alternate;
        private final int maxLength;
        private final StringBuilder primary;

        public DoubleMetaphoneResult(int i5) {
            this.primary = new StringBuilder(DoubleMetaphone.this.getMaxCodeLen());
            this.alternate = new StringBuilder(DoubleMetaphone.this.getMaxCodeLen());
            this.maxLength = i5;
        }

        public void append(char c) {
            appendPrimary(c);
            appendAlternate(c);
        }

        public void appendAlternate(char c) {
            if (this.alternate.length() < this.maxLength) {
                this.alternate.append(c);
            }
        }

        public void appendPrimary(char c) {
            if (this.primary.length() < this.maxLength) {
                this.primary.append(c);
            }
        }

        public String getAlternate() {
            return this.alternate.toString();
        }

        public String getPrimary() {
            return this.primary.toString();
        }

        public boolean isComplete() {
            return this.primary.length() >= this.maxLength && this.alternate.length() >= this.maxLength;
        }

        public void append(char c, char c6) {
            appendPrimary(c);
            appendAlternate(c6);
        }

        public void appendAlternate(String str) {
            int length = this.maxLength - this.alternate.length();
            if (str.length() <= length) {
                this.alternate.append(str);
            } else {
                this.alternate.append(str.substring(0, length));
            }
        }

        public void appendPrimary(String str) {
            int length = this.maxLength - this.primary.length();
            if (str.length() <= length) {
                this.primary.append(str);
            } else {
                this.primary.append(str.substring(0, length));
            }
        }

        public void append(String str) {
            appendPrimary(str);
            appendAlternate(str);
        }

        public void append(String str, String str2) {
            appendPrimary(str);
            appendAlternate(str2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v10, types: [int] */
    /* JADX WARN: Type inference failed for: r1v11, types: [int] */
    /* JADX WARN: Type inference failed for: r1v12, types: [int] */
    /* JADX WARN: Type inference failed for: r1v13, types: [int] */
    /* JADX WARN: Type inference failed for: r1v14, types: [int] */
    /* JADX WARN: Type inference failed for: r1v15, types: [int] */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v17, types: [int] */
    /* JADX WARN: Type inference failed for: r1v18, types: [int] */
    /* JADX WARN: Type inference failed for: r1v19, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v7, types: [int] */
    /* JADX WARN: Type inference failed for: r1v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v9, types: [int] */
    /* JADX WARN: Type inference failed for: r7v0, types: [org.apache.commons.codec.language.DoubleMetaphone] */
    /* JADX WARN: Type inference failed for: r8v1, types: [java.lang.String] */
    public String doubleMetaphone(String str, boolean z6) {
        int i5;
        ?? CleanInput = cleanInput(str);
        if (CleanInput == 0) {
            return null;
        }
        boolean zIsSlavoGermanic = isSlavoGermanic(CleanInput);
        ?? IsSilentStart = isSilentStart(CleanInput);
        DoubleMetaphoneResult doubleMetaphoneResult = new DoubleMetaphoneResult(getMaxCodeLen());
        while (!doubleMetaphoneResult.isComplete() && IsSilentStart <= CleanInput.length() - 1) {
            char cCharAt = CleanInput.charAt(IsSilentStart);
            if (cCharAt == 199) {
                doubleMetaphoneResult.append('S');
            } else if (cCharAt != 209) {
                switch (cCharAt) {
                    case 'A':
                    case 'E':
                    case 'I':
                    case 'O':
                    case 'U':
                    case 'Y':
                        IsSilentStart = handleAEIOUY(doubleMetaphoneResult, IsSilentStart);
                        break;
                    case 'B':
                        doubleMetaphoneResult.append('P');
                        i5 = IsSilentStart + 1;
                        IsSilentStart = charAt(CleanInput, i5) != 'B' ? i5 : IsSilentStart + 2;
                        break;
                    case 'C':
                        IsSilentStart = handleC(CleanInput, doubleMetaphoneResult, IsSilentStart);
                        break;
                    case 'D':
                        IsSilentStart = handleD(CleanInput, doubleMetaphoneResult, IsSilentStart);
                        break;
                    case 'F':
                        doubleMetaphoneResult.append('F');
                        i5 = IsSilentStart + 1;
                        if (charAt(CleanInput, i5) != 'F') {
                        }
                        break;
                    case 'G':
                        IsSilentStart = handleG(CleanInput, doubleMetaphoneResult, IsSilentStart, zIsSlavoGermanic);
                        break;
                    case 'H':
                        IsSilentStart = handleH(CleanInput, doubleMetaphoneResult, IsSilentStart);
                        break;
                    case 'J':
                        IsSilentStart = handleJ(CleanInput, doubleMetaphoneResult, IsSilentStart, zIsSlavoGermanic);
                        break;
                    case 'K':
                        doubleMetaphoneResult.append('K');
                        i5 = IsSilentStart + 1;
                        if (charAt(CleanInput, i5) != 'K') {
                        }
                        break;
                    case 'L':
                        IsSilentStart = handleL(CleanInput, doubleMetaphoneResult, IsSilentStart);
                        break;
                    case 'M':
                        doubleMetaphoneResult.append('M');
                        if (!conditionM0(CleanInput, IsSilentStart)) {
                        }
                        break;
                    case 'N':
                        doubleMetaphoneResult.append('N');
                        i5 = IsSilentStart + 1;
                        if (charAt(CleanInput, i5) != 'N') {
                        }
                        break;
                    case 'P':
                        IsSilentStart = handleP(CleanInput, doubleMetaphoneResult, IsSilentStart);
                        break;
                    case 'Q':
                        doubleMetaphoneResult.append('K');
                        i5 = IsSilentStart + 1;
                        if (charAt(CleanInput, i5) != 'Q') {
                        }
                        break;
                    case 'R':
                        IsSilentStart = handleR(CleanInput, doubleMetaphoneResult, IsSilentStart, zIsSlavoGermanic);
                        break;
                    case 'S':
                        IsSilentStart = handleS(CleanInput, doubleMetaphoneResult, IsSilentStart, zIsSlavoGermanic);
                        break;
                    case 'T':
                        IsSilentStart = handleT(CleanInput, doubleMetaphoneResult, IsSilentStart);
                        break;
                    case 'V':
                        doubleMetaphoneResult.append('F');
                        i5 = IsSilentStart + 1;
                        if (charAt(CleanInput, i5) != 'V') {
                        }
                        break;
                    case 'W':
                        IsSilentStart = handleW(CleanInput, doubleMetaphoneResult, IsSilentStart);
                        break;
                    case 'X':
                        IsSilentStart = handleX(CleanInput, doubleMetaphoneResult, IsSilentStart);
                        break;
                    case 'Z':
                        IsSilentStart = handleZ(CleanInput, doubleMetaphoneResult, IsSilentStart, zIsSlavoGermanic);
                        break;
                    default:
                        break;
                }
            } else {
                doubleMetaphoneResult.append('N');
            }
            IsSilentStart++;
        }
        return z6 ? doubleMetaphoneResult.getAlternate() : doubleMetaphoneResult.getPrimary();
    }

    public boolean isDoubleMetaphoneEqual(String str, String str2, boolean z6) {
        return StringUtils.equals(doubleMetaphone(str, z6), doubleMetaphone(str2, z6));
    }

    @Override // org.apache.commons.codec.StringEncoder
    public String encode(String str) {
        return doubleMetaphone(str);
    }
}
