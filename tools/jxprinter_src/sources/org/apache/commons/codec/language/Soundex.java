package org.apache.commons.codec.language;

import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringEncoder;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class Soundex implements StringEncoder {
    public static final char SILENT_MARKER = '-';

    @Deprecated
    private int maxLength;
    private final char[] soundexMapping;
    private final boolean specialCaseHW;
    public static final String US_ENGLISH_MAPPING_STRING = "01230120022455012623010202";
    private static final char[] US_ENGLISH_MAPPING = US_ENGLISH_MAPPING_STRING.toCharArray();
    public static final Soundex US_ENGLISH = new Soundex();
    public static final Soundex US_ENGLISH_SIMPLIFIED = new Soundex(US_ENGLISH_MAPPING_STRING, false);
    public static final Soundex US_ENGLISH_GENEALOGY = new Soundex("-123-12--22455-12623-1-2-2");

    public Soundex() {
        this.maxLength = 4;
        this.soundexMapping = US_ENGLISH_MAPPING;
        this.specialCaseHW = true;
    }

    private boolean hasMarker(char[] cArr) {
        for (char c : cArr) {
            if (c == '-') {
                return true;
            }
        }
        return false;
    }

    private char map(char c) {
        int i5 = c - 'A';
        if (i5 >= 0) {
            char[] cArr = this.soundexMapping;
            if (i5 < cArr.length) {
                return cArr[i5];
            }
        }
        throw new IllegalArgumentException("The character is not mapped: " + c + " (index=" + i5 + ")");
    }

    public int difference(String str, String str2) {
        return SoundexUtils.difference(this, str, str2);
    }

    @Override // org.apache.commons.codec.Encoder
    public Object encode(Object obj) throws EncoderException {
        if (obj instanceof String) {
            return soundex((String) obj);
        }
        throw new EncoderException("Parameter supplied to Soundex encode is not of type java.lang.String");
    }

    @Deprecated
    public int getMaxLength() {
        return this.maxLength;
    }

    @Deprecated
    public void setMaxLength(int i5) {
        this.maxLength = i5;
    }

    public String soundex(String str) {
        char map;
        if (str == null) {
            return null;
        }
        String strClean = SoundexUtils.clean(str);
        if (strClean.length() == 0) {
            return strClean;
        }
        char[] cArr = {'0', '0', '0', '0'};
        char cCharAt = strClean.charAt(0);
        cArr[0] = cCharAt;
        char map2 = map(cCharAt);
        int i5 = 1;
        for (int i6 = 1; i6 < strClean.length() && i5 < 4; i6++) {
            char cCharAt2 = strClean.charAt(i6);
            if ((!this.specialCaseHW || (cCharAt2 != 'H' && cCharAt2 != 'W')) && (map = map(cCharAt2)) != '-') {
                if (map != '0' && map != map2) {
                    cArr[i5] = map;
                    i5++;
                }
                map2 = map;
            }
        }
        return new String(cArr);
    }

    @Override // org.apache.commons.codec.StringEncoder
    public String encode(String str) {
        return soundex(str);
    }

    public Soundex(char[] cArr) {
        this.maxLength = 4;
        char[] cArr2 = new char[cArr.length];
        this.soundexMapping = cArr2;
        System.arraycopy(cArr, 0, cArr2, 0, cArr.length);
        this.specialCaseHW = !hasMarker(cArr2);
    }

    public Soundex(String str) {
        this.maxLength = 4;
        char[] charArray = str.toCharArray();
        this.soundexMapping = charArray;
        this.specialCaseHW = !hasMarker(charArray);
    }

    public Soundex(String str, boolean z6) {
        this.maxLength = 4;
        this.soundexMapping = str.toCharArray();
        this.specialCaseHW = z6;
    }
}
