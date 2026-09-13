package org.apache.poi.ss.format;

import A3.AbstractC0157z;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Consumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JLabel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.util.Chars;
import org.apache.logging.log4j.util.ProcessIdUtil;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.util.CodepointsUtil;
import org.apache.poi.util.LocaleUtil;
import org.apache.xmlbeans.impl.common.NameUtil;
import org.chromium.support_lib_boundary.WebViewProviderFactoryBoundaryInterface;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class CellFormatPart {
    public static final int COLOR_GROUP;
    public static final Pattern COLOR_PAT;
    public static final int CONDITION_OPERATOR_GROUP;
    public static final Pattern CONDITION_PAT;
    public static final int CONDITION_VALUE_GROUP;
    public static final Pattern CURRENCY_PAT;
    public static final Pattern FORMAT_PAT;
    private static final Logger LOG = LogManager.getLogger((Class<?>) CellFormatPart.class);
    static final Map<String, Color> NAMED_COLORS = new TreeMap(String.CASE_INSENSITIVE_ORDER);
    public static final int SPECIFICATION_GROUP;
    public static final Pattern SPECIFICATION_PAT;
    private final Color color;
    private final CellFormatCondition condition;
    private final CellFormatter format;
    private final CellFormatType type;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public interface PartHandler {
        String handlePart(Matcher matcher, String str, CellFormatType cellFormatType, StringBuffer stringBuffer);
    }

    static {
        for (HSSFColor.HSSFColorPredefined hSSFColorPredefined : HSSFColor.HSSFColorPredefined.values()) {
            String strName = hSSFColorPredefined.name();
            short[] triplet = hSSFColorPredefined.getTriplet();
            Color color = new Color(triplet[0], triplet[1], triplet[2]);
            Map<String, Color> map = NAMED_COLORS;
            map.put(strName, color);
            if (strName.indexOf(95) > 0) {
                map.put(strName.replace(NameUtil.USCORE, Chars.SPACE), color);
            }
            if (strName.indexOf("_PERCENT") > 0) {
                map.put(strName.replace("_PERCENT", "%").replace(NameUtil.USCORE, Chars.SPACE), color);
            }
        }
        COLOR_PAT = Pattern.compile("\\[(black|blue|cyan|green|magenta|red|white|yellow|color [0-9]+)]", 6);
        CONDITION_PAT = Pattern.compile("([<>=]=?|!=|<>)    # The operator\n  \\s*(-?([0-9]+(?:\\.[0-9]*)?)|(\\.[0-9]*))\\s*  # The constant to test against\n", 6);
        SPECIFICATION_PAT = Pattern.compile("\\\\.                     # Quoted single character\n|\"([^\\\\\"]|\\\\.)*\"         # Quoted string of characters (handles escaped quotes like \\\") \n|(\\[\\$.{0,3}(-[0-9a-f]{3,4})?])                   # Currency symbol in a given locale\n|_.                             # Space as wide as a given character\n|\\*.                           # Repeating fill character\n|@                              # Text: cell text\n|([0?\\#][0?\\#,]*)             # Number: digit + other digits and commas\n|e[-+]                          # Number: Scientific: Exponent\n|m{1,5}                         # Date: month or minute spec\n|d{1,4}                         # Date: day/date spec\n|y{2,4}                         # Date: year spec\n|h{1,2}                         # Date: hour spec\n|s{1,2}                         # Date: second spec\n|am?/pm?                        # Date: am/pm spec\n|\\[h{1,2}]                     # Elapsed time: hour spec\n|\\[m{1,2}]                     # Elapsed time: minute spec\n|\\[s{1,2}]                     # Elapsed time: second spec\n|[^;]                           # A character\n", 6);
        CURRENCY_PAT = Pattern.compile("(\\[\\$.{0,3}(-[0-9a-f]{3,4})?])", 6);
        Pattern patternCompile = Pattern.compile("(?:\\[(black|blue|cyan|green|magenta|red|white|yellow|color [0-9]+)])?                 # Text color\n(?:\\[([<>=]=?|!=|<>)    # The operator\n  \\s*(-?([0-9]+(?:\\.[0-9]*)?)|(\\.[0-9]*))\\s*  # The constant to test against\n])?               # Condition\n(?:\\[\\$-[0-9a-fA-F]+])?                # Optional locale id, ignored currently\n((?:\\\\.                     # Quoted single character\n|\"([^\\\\\"]|\\\\.)*\"         # Quoted string of characters (handles escaped quotes like \\\") \n|(\\[\\$.{0,3}(-[0-9a-f]{3,4})?])                   # Currency symbol in a given locale\n|_.                             # Space as wide as a given character\n|\\*.                           # Repeating fill character\n|@                              # Text: cell text\n|([0?\\#][0?\\#,]*)             # Number: digit + other digits and commas\n|e[-+]                          # Number: Scientific: Exponent\n|m{1,5}                         # Date: month or minute spec\n|d{1,4}                         # Date: day/date spec\n|y{2,4}                         # Date: year spec\n|h{1,2}                         # Date: hour spec\n|s{1,2}                         # Date: second spec\n|am?/pm?                        # Date: am/pm spec\n|\\[h{1,2}]                     # Elapsed time: hour spec\n|\\[m{1,2}]                     # Elapsed time: minute spec\n|\\[s{1,2}]                     # Elapsed time: second spec\n|[^;]                           # A character\n)+)                        # Format spec\n", 6);
        FORMAT_PAT = patternCompile;
        COLOR_GROUP = findGroup(patternCompile, "[Blue]@", "Blue");
        CONDITION_OPERATOR_GROUP = findGroup(patternCompile, "[>=1]@", ">=");
        CONDITION_VALUE_GROUP = findGroup(patternCompile, "[>=1]@", "1");
        SPECIFICATION_GROUP = findGroup(patternCompile, "[Blue][>1]\\a ?", "\\a ?");
    }

    public CellFormatPart(String str) {
        this(LocaleUtil.getUserLocale(), str);
    }

    public static String expandChar(String str) {
        final ArrayList arrayList = new ArrayList();
        CodepointsUtil.iteratorFor(str).forEachRemaining(new Consumer() { // from class: org.apache.poi.ss.format.a
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                arrayList.add((String) obj);
            }
        });
        if (arrayList.size() < 2) {
            throw new IllegalArgumentException("Expected part string to have at least 2 chars");
        }
        String str2 = (String) arrayList.get(1);
        return androidx.collection.a.o(str2, str2, str2);
    }

    private static int findGroup(Pattern pattern, String str, String str2) {
        Matcher matcher = pattern.matcher(str);
        if (!matcher.find()) {
            throw new IllegalArgumentException("Pattern \"" + pattern.pattern() + "\" doesn't match \"" + str + "\"");
        }
        for (int i5 = 1; i5 <= matcher.groupCount(); i5++) {
            String strGroup = matcher.group(i5);
            if (strGroup != null && strGroup.equals(str2)) {
                return i5;
            }
        }
        StringBuilder sbY = AbstractC0157z.y("\"", str2, "\" not found in \"");
        sbY.append(pattern.pattern());
        sbY.append("\"");
        throw new IllegalArgumentException(sbY.toString());
    }

    private CellFormatType formatType(String str) {
        String strTrim = str.trim();
        if (strTrim.isEmpty() || strTrim.equalsIgnoreCase("General")) {
            return CellFormatType.GENERAL;
        }
        Matcher matcher = SPECIFICATION_PAT.matcher(strTrim);
        boolean z6 = false;
        boolean z7 = false;
        while (matcher.find()) {
            String strGroup = matcher.group(0);
            Iterator<String> itIteratorFor = CodepointsUtil.iteratorFor(strGroup);
            if (itIteratorFor.hasNext()) {
                String next = itIteratorFor.next();
                String lowerCase = itIteratorFor.hasNext() ? itIteratorFor.next().toLowerCase(Locale.ROOT) : null;
                next.getClass();
                switch (next) {
                    case "#":
                    case "?":
                        return CellFormatType.NUMBER;
                    case "0":
                        z7 = true;
                        break;
                    case "@":
                        return CellFormatType.TEXT;
                    case "D":
                    case "Y":
                    case "d":
                    case "y":
                        return CellFormatType.DATE;
                    case "H":
                    case "M":
                    case "S":
                    case "h":
                    case "m":
                    case "s":
                        z6 = true;
                        break;
                    case "[":
                        if ("h".equals(lowerCase) || "m".equals(lowerCase) || "s".equals(lowerCase)) {
                            return CellFormatType.ELAPSED;
                        }
                        if ("$".equals(lowerCase)) {
                            return CellFormatType.NUMBER;
                        }
                        StringBuilder sbU = androidx.collection.a.u("Unsupported [] format block '", strGroup, "' in '", strTrim, "' with c2: ");
                        sbU.append(lowerCase);
                        throw new IllegalArgumentException(sbU.toString());
                }
            }
        }
        if (z6) {
            return CellFormatType.DATE;
        }
        return z7 ? CellFormatType.NUMBER : CellFormatType.TEXT;
    }

    private CellFormatType getCellFormatType(Matcher matcher) {
        return formatType(matcher.group(SPECIFICATION_GROUP));
    }

    private static Color getColor(Matcher matcher) {
        String strGroup = matcher.group(COLOR_GROUP);
        if (strGroup == null || strGroup.length() == 0) {
            return null;
        }
        Color color = NAMED_COLORS.get(strGroup);
        if (color == null) {
            LOG.warn("Unknown color: " + CellFormatter.quote(strGroup));
        }
        return color;
    }

    private CellFormatCondition getCondition(Matcher matcher) {
        int i5 = CONDITION_OPERATOR_GROUP;
        String strGroup = matcher.group(i5);
        if (strGroup == null || strGroup.length() == 0) {
            return null;
        }
        return CellFormatCondition.getInstance(matcher.group(i5), matcher.group(CONDITION_VALUE_GROUP));
    }

    private CellFormatter getFormatter(Locale locale, Matcher matcher) {
        String strSubstring;
        String strGroup = matcher.group(SPECIFICATION_GROUP);
        Matcher matcher2 = CURRENCY_PAT.matcher(strGroup);
        if (matcher2.find()) {
            String strGroup2 = matcher2.group(1);
            if (strGroup2.startsWith("[$-")) {
                strSubstring = "$";
            } else {
                strSubstring = !strGroup2.contains(ProcessIdUtil.DEFAULT_PROCESSID) ? strGroup2.substring(2, strGroup2.indexOf("]")) : strGroup2.substring(2, strGroup2.lastIndexOf(45));
            }
            strGroup = strGroup.replace(strGroup2, strSubstring);
        }
        return this.type.formatter(locale, strGroup);
    }

    public static String group(Matcher matcher, int i5) {
        String strGroup = matcher.group(i5);
        return strGroup == null ? "" : strGroup;
    }

    public static StringBuffer parseFormat(String str, CellFormatType cellFormatType, PartHandler partHandler) {
        int iIndexOf;
        Matcher matcher = SPECIFICATION_PAT.matcher(str);
        StringBuffer stringBuffer = new StringBuffer();
        while (true) {
            iIndexOf = 0;
            if (!matcher.find()) {
                break;
            }
            String strGroup = group(matcher, 0);
            if (strGroup.length() > 0) {
                String strHandlePart = partHandler.handlePart(matcher, strGroup, cellFormatType, stringBuffer);
                if (strHandlePart == null) {
                    char cCharAt = strGroup.charAt(0);
                    if (cCharAt == '\"') {
                        strGroup = quoteSpecial(strGroup.substring(1, strGroup.length() - 1), cellFormatType);
                    } else if (cCharAt == '*') {
                        strGroup = expandChar(strGroup);
                    } else if (cCharAt == '\\') {
                        strGroup = quoteSpecial(strGroup.substring(1), cellFormatType);
                    } else if (cCharAt == '_') {
                        strGroup = " ";
                    }
                } else {
                    strGroup = strHandlePart;
                }
                matcher.appendReplacement(stringBuffer, Matcher.quoteReplacement(strGroup));
            }
        }
        matcher.appendTail(stringBuffer);
        if (cellFormatType.isSpecial(Chars.QUOTE)) {
            int iIndexOf2 = 0;
            while (true) {
                iIndexOf2 = stringBuffer.indexOf("''", iIndexOf2);
                if (iIndexOf2 < 0) {
                    break;
                }
                stringBuffer.delete(iIndexOf2, iIndexOf2 + 2);
                if (partHandler instanceof CellDateFormatter.DatePartHandler) {
                    ((CellDateFormatter.DatePartHandler) partHandler).updatePositions(iIndexOf2, -2);
                }
            }
            while (true) {
                iIndexOf = stringBuffer.indexOf(WebViewProviderFactoryBoundaryInterface.MULTI_COOKIE_VALUE_SEPARATOR, iIndexOf);
                if (iIndexOf < 0) {
                    break;
                }
                stringBuffer.replace(iIndexOf, iIndexOf + 1, "''");
                if (partHandler instanceof CellDateFormatter.DatePartHandler) {
                    ((CellDateFormatter.DatePartHandler) partHandler).updatePositions(iIndexOf, 1);
                }
            }
        }
        return stringBuffer;
    }

    public static String quoteSpecial(String str, CellFormatType cellFormatType) {
        StringBuilder sb = new StringBuilder();
        Iterator<String> itIteratorFor = CodepointsUtil.iteratorFor(str);
        while (itIteratorFor.hasNext()) {
            String next = itIteratorFor.next();
            if ("'".equals(next) && cellFormatType.isSpecial(Chars.QUOTE)) {
                sb.append((char) 0);
            } else {
                boolean zIsSpecial = cellFormatType.isSpecial(next.charAt(0));
                if (zIsSpecial) {
                    sb.append(Chars.QUOTE);
                }
                sb.append(next);
                if (zIsSpecial) {
                    sb.append(Chars.QUOTE);
                }
            }
        }
        return sb.toString();
    }

    public boolean applies(Object obj) {
        CellFormatCondition cellFormatCondition = this.condition;
        if (cellFormatCondition != null && (obj instanceof Number)) {
            return cellFormatCondition.pass(((Number) obj).doubleValue());
        }
        if (obj != null) {
            return true;
        }
        throw new NullPointerException("valueObject");
    }

    public CellFormatResult apply(Object obj) {
        String strSimpleFormat;
        Color color;
        boolean zApplies = applies(obj);
        if (zApplies) {
            strSimpleFormat = this.format.format(obj);
            color = this.color;
        } else {
            strSimpleFormat = this.format.simpleFormat(obj);
            color = null;
        }
        return new CellFormatResult(zApplies, strSimpleFormat, color);
    }

    public boolean hasCondition() {
        return this.condition != null;
    }

    public String toString() {
        return this.format.format;
    }

    public CellFormatPart(Locale locale, String str) {
        Matcher matcher = FORMAT_PAT.matcher(str);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("Unrecognized format: " + CellFormatter.quote(str));
        }
        this.color = getColor(matcher);
        this.condition = getCondition(matcher);
        this.type = getCellFormatType(matcher);
        this.format = getFormatter(locale, matcher);
    }

    public CellFormatType getCellFormatType() {
        return this.type;
    }

    public CellFormatResult apply(JLabel jLabel, Object obj) {
        CellFormatResult cellFormatResultApply = apply(obj);
        jLabel.setText(cellFormatResultApply.text);
        Color color = cellFormatResultApply.textColor;
        if (color != null) {
            jLabel.setForeground(color);
        }
        return cellFormatResultApply;
    }
}
