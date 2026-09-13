package org.apache.poi.sl.usermodel;

import A3.AbstractC0157z;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import com.alibaba.android.arouter.utils.Consts;
import java.util.Locale;
import org.apache.logging.log4j.util.ProcessIdUtil;
import org.opencv.videoio.Videoio;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public enum AutoNumberingScheme {
    alphaLcParenBoth(8, 1),
    alphaUcParenBoth(10, 2),
    alphaLcParenRight(9, 3),
    alphaUcParenRight(11, 4),
    alphaLcPeriod(0, 5),
    alphaUcPeriod(1, 6),
    arabicParenBoth(12, 7),
    arabicParenRight(2, 8),
    arabicPeriod(3, 9),
    arabicPlain(13, 10),
    romanLcParenBoth(4, 11),
    romanUcParenBoth(14, 12),
    romanLcParenRight(5, 13),
    romanUcParenRight(15, 14),
    romanLcPeriod(6, 15),
    romanUcPeriod(7, 16),
    circleNumDbPlain(18, 17),
    circleNumWdBlackPlain(20, 18),
    circleNumWdWhitePlain(19, 19),
    arabicDbPeriod(29, 20),
    arabicDbPlain(28, 21),
    ea1ChsPeriod(17, 22),
    ea1ChsPlain(16, 23),
    ea1ChtPeriod(21, 24),
    ea1ChtPlain(20, 25),
    ea1JpnChsDbPeriod(38, 26),
    ea1JpnKorPlain(26, 27),
    ea1JpnKorPeriod(27, 28),
    arabic1Minus(23, 29),
    arabic2Minus(24, 30),
    hebrew2Minus(25, 31),
    thaiAlphaPeriod(30, 32),
    thaiAlphaParenRight(31, 33),
    thaiAlphaParenBoth(32, 34),
    thaiNumPeriod(33, 35),
    thaiNumParenRight(34, 36),
    thaiNumParenBoth(35, 37),
    hindiAlphaPeriod(36, 38),
    hindiNumPeriod(37, 39),
    hindiNumParenRight(39, 40),
    hindiAlpha1Period(39, 41);

    private static final String ALPHA_LIST = "abcdefghijklmnopqrstuvwxyz";
    private static final String ARABIC_LIST = "0123456789";
    private static final String CIRCLE_DB_LIST = "❶❷❸❹❺❻❼❽❾";
    private static final String WINGDINGS_BLACK_LIST = "\u008b\u008c\u008d\u008e\u008f\u0090\u0091\u0092\u0093\u0094";
    private static final String WINGDINGS_WHITE_LIST = "\u0080\u0081\u0082\u0083\u0084\u0085\u0086\u0087\u0088\u0089";
    public final int nativeId;
    public final int ooxmlId;

    /* JADX INFO: renamed from: org.apache.poi.sl.usermodel.AutoNumberingScheme$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$sl$usermodel$AutoNumberingScheme;

        static {
            int[] iArr = new int[AutoNumberingScheme.values().length];
            $SwitchMap$org$apache$poi$sl$usermodel$AutoNumberingScheme = iArr;
            try {
                iArr[AutoNumberingScheme.alphaLcPeriod.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$AutoNumberingScheme[AutoNumberingScheme.alphaUcPeriod.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$AutoNumberingScheme[AutoNumberingScheme.arabicParenRight.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$AutoNumberingScheme[AutoNumberingScheme.arabicPeriod.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$AutoNumberingScheme[AutoNumberingScheme.romanLcParenBoth.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$AutoNumberingScheme[AutoNumberingScheme.romanLcParenRight.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$AutoNumberingScheme[AutoNumberingScheme.romanLcPeriod.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$AutoNumberingScheme[AutoNumberingScheme.romanUcPeriod.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$AutoNumberingScheme[AutoNumberingScheme.alphaLcParenBoth.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$AutoNumberingScheme[AutoNumberingScheme.alphaLcParenRight.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$AutoNumberingScheme[AutoNumberingScheme.alphaUcParenBoth.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$AutoNumberingScheme[AutoNumberingScheme.alphaUcParenRight.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$AutoNumberingScheme[AutoNumberingScheme.arabicParenBoth.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$AutoNumberingScheme[AutoNumberingScheme.arabicPlain.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$AutoNumberingScheme[AutoNumberingScheme.romanUcParenBoth.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$AutoNumberingScheme[AutoNumberingScheme.romanUcParenRight.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$AutoNumberingScheme[AutoNumberingScheme.ea1ChsPlain.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$AutoNumberingScheme[AutoNumberingScheme.ea1ChsPeriod.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$AutoNumberingScheme[AutoNumberingScheme.circleNumDbPlain.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$AutoNumberingScheme[AutoNumberingScheme.circleNumWdWhitePlain.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$AutoNumberingScheme[AutoNumberingScheme.circleNumWdBlackPlain.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$AutoNumberingScheme[AutoNumberingScheme.ea1ChtPlain.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$AutoNumberingScheme[AutoNumberingScheme.ea1ChtPeriod.ordinal()] = 23;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$AutoNumberingScheme[AutoNumberingScheme.arabic1Minus.ordinal()] = 24;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$AutoNumberingScheme[AutoNumberingScheme.arabic2Minus.ordinal()] = 25;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$AutoNumberingScheme[AutoNumberingScheme.hebrew2Minus.ordinal()] = 26;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$AutoNumberingScheme[AutoNumberingScheme.ea1JpnKorPlain.ordinal()] = 27;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$AutoNumberingScheme[AutoNumberingScheme.ea1JpnKorPeriod.ordinal()] = 28;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$AutoNumberingScheme[AutoNumberingScheme.arabicDbPlain.ordinal()] = 29;
            } catch (NoSuchFieldError unused29) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$AutoNumberingScheme[AutoNumberingScheme.arabicDbPeriod.ordinal()] = 30;
            } catch (NoSuchFieldError unused30) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$AutoNumberingScheme[AutoNumberingScheme.thaiAlphaPeriod.ordinal()] = 31;
            } catch (NoSuchFieldError unused31) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$AutoNumberingScheme[AutoNumberingScheme.thaiAlphaParenRight.ordinal()] = 32;
            } catch (NoSuchFieldError unused32) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$AutoNumberingScheme[AutoNumberingScheme.thaiAlphaParenBoth.ordinal()] = 33;
            } catch (NoSuchFieldError unused33) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$AutoNumberingScheme[AutoNumberingScheme.thaiNumPeriod.ordinal()] = 34;
            } catch (NoSuchFieldError unused34) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$AutoNumberingScheme[AutoNumberingScheme.thaiNumParenRight.ordinal()] = 35;
            } catch (NoSuchFieldError unused35) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$AutoNumberingScheme[AutoNumberingScheme.thaiNumParenBoth.ordinal()] = 36;
            } catch (NoSuchFieldError unused36) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$AutoNumberingScheme[AutoNumberingScheme.hindiAlphaPeriod.ordinal()] = 37;
            } catch (NoSuchFieldError unused37) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$AutoNumberingScheme[AutoNumberingScheme.hindiNumPeriod.ordinal()] = 38;
            } catch (NoSuchFieldError unused38) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$AutoNumberingScheme[AutoNumberingScheme.ea1JpnChsDbPeriod.ordinal()] = 39;
            } catch (NoSuchFieldError unused39) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$AutoNumberingScheme[AutoNumberingScheme.hindiNumParenRight.ordinal()] = 40;
            } catch (NoSuchFieldError unused40) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$AutoNumberingScheme[AutoNumberingScheme.hindiAlpha1Period.ordinal()] = 41;
            } catch (NoSuchFieldError unused41) {
            }
        }
    }

    AutoNumberingScheme(int i5, int i6) {
        this.nativeId = i5;
        this.ooxmlId = i6;
    }

    private static void addIndexedChar(int i5, String str, boolean z6, StringBuilder sb) {
        if (z6) {
            i5--;
        }
        int length = str.length();
        if (i5 >= length) {
            addIndexedChar(i5 / length, str, z6, sb);
        }
        sb.append(str.charAt(i5 % length));
    }

    public static AutoNumberingScheme forNativeID(int i5) {
        for (AutoNumberingScheme autoNumberingScheme : values()) {
            if (autoNumberingScheme.nativeId == i5) {
                return autoNumberingScheme;
            }
        }
        return null;
    }

    public static AutoNumberingScheme forOoxmlID(int i5) {
        for (AutoNumberingScheme autoNumberingScheme : values()) {
            if (autoNumberingScheme.ooxmlId == i5) {
                return autoNumberingScheme;
            }
        }
        return null;
    }

    private String formatCase(String str) {
        String strName = name();
        Locale locale = Locale.ROOT;
        String lowerCase = strName.toLowerCase(locale);
        if (lowerCase.contains("lc")) {
            return str.toLowerCase(locale);
        }
        return lowerCase.contains("uc") ? str.toUpperCase(locale) : str;
    }

    private String formatIndex(int i5) {
        String lowerCase = name().toLowerCase(Locale.ROOT);
        if (lowerCase.startsWith("roman")) {
            return formatRomanIndex(i5);
        }
        if (lowerCase.startsWith("arabic") && !lowerCase.contains("db")) {
            return getIndexedList(i5, ARABIC_LIST, false);
        }
        if (lowerCase.startsWith("alpha")) {
            return getIndexedList(i5, ALPHA_LIST, true);
        }
        if (lowerCase.contains("wdwhite")) {
            return i5 == 10 ? "\u008a" : getIndexedList(i5, WINGDINGS_WHITE_LIST, false);
        }
        if (lowerCase.contains("wdblack")) {
            return i5 == 10 ? "\u0095" : getIndexedList(i5, WINGDINGS_BLACK_LIST, false);
        }
        if (lowerCase.contains("numdb")) {
            return i5 == 10 ? "❿" : getIndexedList(i5, CIRCLE_DB_LIST, true);
        }
        return "?";
    }

    private String formatRomanIndex(int i5) {
        int[] iArr = {1000, 900, Videoio.CAP_QT, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] strArr = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "IV", "I"};
        String[][] strArr2 = {new String[]{"XLV", "VL"}, new String[]{"XCV", "VC"}, new String[]{"CDL", "LD"}, new String[]{"CML", "LM"}, new String[]{"CMVC", "LMVL"}, new String[]{"CDXC", "LDXL"}, new String[]{"CDVC", "LDVL"}, new String[]{"CMXC", "LMXL"}, new String[]{"XCIX", "VCIV"}, new String[]{"XLIX", "VLIV"}, new String[]{"XLIX", "IL"}, new String[]{"XCIX", "IC"}, new String[]{"CDXC", "XD"}, new String[]{"CDVC", "XDV"}, new String[]{"CDIC", "XDIX"}, new String[]{"LMVL", "XMV"}, new String[]{"CMIC", "XMIX"}, new String[]{"CMXC", "XM"}, new String[]{"XDV", "VD"}, new String[]{"XDIX", "VDIV"}, new String[]{"XMV", "VM"}, new String[]{"XMIX", "VMIV"}, new String[]{"VDIV", "ID"}, new String[]{"VMIV", "IM"}};
        StringBuilder sb = new StringBuilder();
        int i6 = i5;
        for (int i7 = 0; i7 < 13; i7++) {
            while (true) {
                int i8 = iArr[i7];
                if (i6 >= i8) {
                    i6 -= i8;
                    sb.append(strArr[i7]);
                }
            }
        }
        String string = sb.toString();
        for (int i9 = 0; i9 < 24; i9++) {
            String[] strArr3 = strArr2[i9];
            string = string.replace(strArr3[0], strArr3[1]);
        }
        return string;
    }

    private String formatSeperator(String str) {
        String lowerCase = name().toLowerCase(Locale.ROOT);
        if (lowerCase.contains("plain")) {
            return str;
        }
        if (lowerCase.contains("parenright")) {
            return androidx.collection.a.n(str, ")");
        }
        if (lowerCase.contains("parenboth")) {
            return AbstractC0157z.o("(", str, ")");
        }
        if (lowerCase.contains(TypedValues.CycleType.S_WAVE_PERIOD)) {
            return androidx.collection.a.n(str, Consts.DOT);
        }
        return lowerCase.contains("minus") ? androidx.collection.a.n(str, ProcessIdUtil.DEFAULT_PROCESSID) : str;
    }

    private static String getIndexedList(int i5, String str, boolean z6) {
        StringBuilder sb = new StringBuilder();
        addIndexedChar(i5, str, z6, sb);
        return sb.toString();
    }

    public String format(int i5) {
        return formatSeperator(formatCase(formatIndex(i5)));
    }

    public String getDescription() {
        switch (AnonymousClass1.$SwitchMap$org$apache$poi$sl$usermodel$AutoNumberingScheme[ordinal()]) {
            case 1:
                return "Lowercase Latin character followed by a period. Example: a., b., c., ...";
            case 2:
                return "Uppercase Latin character followed by a period. Example: A., B., C., ...";
            case 3:
                return "Arabic numeral followed by a closing parenthesis. Example: 1), 2), 3), ...";
            case 4:
                return "Arabic numeral followed by a period. Example: 1., 2., 3., ...";
            case 5:
                return "Lowercase Roman numeral enclosed in parentheses. Example: (i), (ii), (iii), ...";
            case 6:
                return "Lowercase Roman numeral followed by a closing parenthesis. Example: i), ii), iii), ...";
            case 7:
                return "Lowercase Roman numeral followed by a period. Example: i., ii., iii., ...";
            case 8:
                return "Uppercase Roman numeral followed by a period. Example: I., II., III., ...";
            case 9:
                return "Lowercase alphabetic character enclosed in parentheses. Example: (a), (b), (c), ...";
            case 10:
                return "Lowercase alphabetic character followed by a closing parenthesis. Example: a), b), c), ...";
            case 11:
                return "Uppercase alphabetic character enclosed in parentheses. Example: (A), (B), (C), ...";
            case 12:
                return "Uppercase alphabetic character followed by a closing parenthesis. Example: A), B), C), ...";
            case 13:
                return "Arabic numeral enclosed in parentheses. Example: (1), (2), (3), ...";
            case 14:
                return "Arabic numeral. Example: 1, 2, 3, ...";
            case 15:
                return "Uppercase Roman numeral enclosed in parentheses. Example: (I), (II), (III), ...";
            case 16:
                return "Uppercase Roman numeral followed by a closing parenthesis. Example: I), II), III), ...";
            case 17:
                return "Simplified Chinese.";
            case 18:
                return "Simplified Chinese with single-byte period.";
            case 19:
                return "Double byte circle numbers.";
            case 20:
                return "Wingdings white circle numbers.";
            case 21:
                return "Wingdings black circle numbers.";
            case 22:
                return "Traditional Chinese.";
            case 23:
                return "Traditional Chinese with single-byte period.";
            case 24:
                return "Bidi Arabic 1 (AraAlpha) with ANSI minus symbol.";
            case 25:
                return "Bidi Arabic 2 (AraAbjad) with ANSI minus symbol.";
            case 26:
                return "Bidi Hebrew 2 with ANSI minus symbol.";
            case 27:
                return "Japanese/Korean.";
            case 28:
                return "Japanese/Korean with single-byte period.";
            case 29:
                return "Double-byte Arabic numbers.";
            case 30:
                return "Double-byte Arabic numbers with double-byte period.";
            case 31:
                return "Thai alphabetic character followed by a period.";
            case 32:
                return "Thai alphabetic character followed by a closing parenthesis.";
            case 33:
                return "Thai alphabetic character enclosed by parentheses.";
            case 34:
                return "Thai numeral followed by a period.";
            case 35:
                return "Thai numeral followed by a closing parenthesis.";
            case 36:
                return "Thai numeral enclosed in parentheses.";
            case 37:
                return "Hindi alphabetic character followed by a period.";
            case 38:
                return "Hindi numeric character followed by a period.";
            case 39:
                return "Japanese with double-byte period.";
            case 40:
                return "Hindi numeric character followed by a closing parenthesis.";
            case 41:
                return "Hindi alphabetic character followed by a period.";
            default:
                return "Unknown Numbered Scheme";
        }
    }
}
