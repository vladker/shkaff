package org.apache.commons.codec.language;

import java.util.regex.Pattern;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringEncoder;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class Nysiis implements StringEncoder {
    private static final char SPACE = ' ';
    private static final int TRUE_LENGTH = 6;
    private final boolean strict;
    private static final char[] CHARS_A = {'A'};
    private static final char[] CHARS_AF = {'A', 'F'};
    private static final char[] CHARS_C = {'C'};
    private static final char[] CHARS_FF = {'F', 'F'};
    private static final char[] CHARS_G = {'G'};
    private static final char[] CHARS_N = {'N'};
    private static final char[] CHARS_NN = {'N', 'N'};
    private static final char[] CHARS_S = {'S'};
    private static final char[] CHARS_SSS = {'S', 'S', 'S'};
    private static final Pattern PAT_MAC = Pattern.compile("^MAC");
    private static final Pattern PAT_KN = Pattern.compile("^KN");
    private static final Pattern PAT_K = Pattern.compile("^K");
    private static final Pattern PAT_PH_PF = Pattern.compile("^(PH|PF)");
    private static final Pattern PAT_SCH = Pattern.compile("^SCH");
    private static final Pattern PAT_EE_IE = Pattern.compile("(EE|IE)$");
    private static final Pattern PAT_DT_ETC = Pattern.compile("(DT|RT|RD|NT|ND)$");

    public Nysiis() {
        this(true);
    }

    private static boolean isVowel(char c) {
        return c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }

    private static char[] transcodeRemaining(char c, char c6, char c7, char c8) {
        if (c6 == 'E' && c7 == 'V') {
            return CHARS_AF;
        }
        if (isVowel(c6)) {
            return CHARS_A;
        }
        if (c6 == 'Q') {
            return CHARS_G;
        }
        if (c6 == 'Z') {
            return CHARS_S;
        }
        if (c6 == 'M') {
            return CHARS_N;
        }
        if (c6 == 'K') {
            return c7 == 'N' ? CHARS_NN : CHARS_C;
        }
        if (c6 == 'S' && c7 == 'C' && c8 == 'H') {
            return CHARS_SSS;
        }
        if (c6 == 'P' && c7 == 'H') {
            return CHARS_FF;
        }
        if (c6 != 'H' || (isVowel(c) && isVowel(c7))) {
            return (c6 == 'W' && isVowel(c)) ? new char[]{c} : new char[]{c6};
        }
        return new char[]{c};
    }

    @Override // org.apache.commons.codec.Encoder
    public Object encode(Object obj) throws EncoderException {
        if (obj instanceof String) {
            return nysiis((String) obj);
        }
        throw new EncoderException("Parameter supplied to Nysiis encode is not of type java.lang.String");
    }

    public boolean isStrict() {
        return this.strict;
    }

    public String nysiis(String str) {
        if (str == null) {
            return null;
        }
        String strClean = SoundexUtils.clean(str);
        if (strClean.length() == 0) {
            return strClean;
        }
        String strReplaceFirst = PAT_DT_ETC.matcher(PAT_EE_IE.matcher(PAT_SCH.matcher(PAT_PH_PF.matcher(PAT_K.matcher(PAT_KN.matcher(PAT_MAC.matcher(strClean).replaceFirst("MCC")).replaceFirst("NN")).replaceFirst("C")).replaceFirst("FF")).replaceFirst("SSS")).replaceFirst("Y")).replaceFirst("D");
        StringBuilder sb = new StringBuilder(strReplaceFirst.length());
        sb.append(strReplaceFirst.charAt(0));
        char[] charArray = strReplaceFirst.toCharArray();
        int length = charArray.length;
        int i5 = 1;
        while (i5 < length) {
            int i6 = i5 - 1;
            char[] cArrTranscodeRemaining = transcodeRemaining(charArray[i6], charArray[i5], i5 < length + (-1) ? charArray[i5 + 1] : ' ', i5 < length + (-2) ? charArray[i5 + 2] : ' ');
            System.arraycopy(cArrTranscodeRemaining, 0, charArray, i5, cArrTranscodeRemaining.length);
            char c = charArray[i5];
            if (c != charArray[i6]) {
                sb.append(c);
            }
            i5++;
        }
        if (sb.length() > 1) {
            char cCharAt = sb.charAt(sb.length() - 1);
            if (cCharAt == 'S') {
                sb.deleteCharAt(sb.length() - 1);
                cCharAt = sb.charAt(sb.length() - 1);
            }
            if (sb.length() > 2 && sb.charAt(sb.length() - 2) == 'A' && cCharAt == 'Y') {
                sb.deleteCharAt(sb.length() - 2);
            }
            if (cCharAt == 'A') {
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        String string = sb.toString();
        return isStrict() ? string.substring(0, Math.min(6, string.length())) : string;
    }

    public Nysiis(boolean z6) {
        this.strict = z6;
    }

    @Override // org.apache.commons.codec.StringEncoder
    public String encode(String str) {
        return nysiis(str);
    }
}
