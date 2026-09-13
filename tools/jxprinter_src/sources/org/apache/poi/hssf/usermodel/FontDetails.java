package org.apache.poi.hssf.usermodel;

import A3.AbstractC0157z;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.StringTokenizer;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class FontDetails {
    private String _fontName;
    private int _height;
    private final Map<Character, Integer> charWidths = new HashMap();

    public FontDetails(String str, int i5) {
        this._fontName = str;
        this._height = i5;
    }

    public static String buildFontCharactersProperty(String str) {
        return AbstractC0157z.o("font.", str, ".characters");
    }

    public static String buildFontHeightProperty(String str) {
        return AbstractC0157z.o("font.", str, ".height");
    }

    public static String buildFontWidthsProperty(String str) {
        return AbstractC0157z.o("font.", str, ".widths");
    }

    public static FontDetails create(String str, Properties properties) {
        String property = properties.getProperty(buildFontHeightProperty(str));
        String property2 = properties.getProperty(buildFontWidthsProperty(str));
        String property3 = properties.getProperty(buildFontCharactersProperty(str));
        if (property == null || property2 == null || property3 == null) {
            throw new IllegalArgumentException(AbstractC0157z.o("The supplied FontMetrics doesn't know about the font '", str, "', so we can't use it. Please add it to your font metrics file (see StaticFontMetrics.getFontDetails"));
        }
        FontDetails fontDetails = new FontDetails(str, Integer.parseInt(property));
        String[] strArrSplit = split(property3, ",", -1);
        String[] strArrSplit2 = split(property2, ",", -1);
        if (strArrSplit.length != strArrSplit2.length) {
            throw new RuntimeException(AbstractC0157z.n("Number of characters does not number of widths for font ", str));
        }
        for (int i5 = 0; i5 < strArrSplit2.length; i5++) {
            if (strArrSplit[i5].length() != 0) {
                fontDetails.addChar(strArrSplit[i5].charAt(0), Integer.parseInt(strArrSplit2[i5]));
            }
        }
        return fontDetails;
    }

    private static String[] split(String str, String str2, int i5) {
        StringTokenizer stringTokenizer = new StringTokenizer(str, str2);
        int iCountTokens = stringTokenizer.countTokens();
        if (i5 != -1 && iCountTokens > i5) {
            iCountTokens = i5;
        }
        String[] strArr = new String[iCountTokens];
        int i6 = 0;
        while (stringTokenizer.hasMoreTokens()) {
            if (i5 != -1 && i6 == iCountTokens - 1) {
                StringBuilder sb = new StringBuilder(((iCountTokens - i6) * str.length()) / iCountTokens);
                while (stringTokenizer.hasMoreTokens()) {
                    sb.append(stringTokenizer.nextToken());
                    if (stringTokenizer.hasMoreTokens()) {
                        sb.append(str2);
                    }
                }
                strArr[i6] = sb.toString().trim();
                return strArr;
            }
            strArr[i6] = stringTokenizer.nextToken().trim();
            i6++;
        }
        return strArr;
    }

    public void addChar(char c, int i5) {
        this.charWidths.put(Character.valueOf(c), Integer.valueOf(i5));
    }

    public void addChars(char[] cArr, int[] iArr) {
        for (int i5 = 0; i5 < cArr.length; i5++) {
            this.charWidths.put(Character.valueOf(cArr[i5]), Integer.valueOf(iArr[i5]));
        }
    }

    public int getCharWidth(char c) {
        Integer num = this.charWidths.get(Character.valueOf(c));
        if (num != null) {
            return num.intValue();
        }
        if ('W' == c) {
            return 0;
        }
        return getCharWidth('W');
    }

    public String getFontName() {
        return this._fontName;
    }

    public int getHeight() {
        return this._height;
    }

    public int getStringWidth(String str) {
        int charWidth = 0;
        for (int i5 = 0; i5 < str.length(); i5++) {
            charWidth += getCharWidth(str.charAt(i5));
        }
        return charWidth;
    }
}
