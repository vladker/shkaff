package org.apache.poi.ss.util;

import A3.AbstractC0157z;
import java.text.DateFormatSymbols;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.util.LocaleUtil;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class DateParser {

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public enum Format {
        YMD_DASHES("^(\\d{4})-(\\w+)-(\\d{1,2})( .*)?$", "ymd"),
        DMY_DASHES("^(\\d{1,2})-(\\w+)-(\\d{4})( .*)?$", "dmy"),
        MD_DASHES("^(\\w+)-(\\d{1,2})( .*)?$", "md"),
        MDY_SLASHES("^(\\w+)/(\\d{1,2})/(\\d{4})( .*)?$", "mdy"),
        YMD_SLASHES("^(\\d{4})/(\\w+)/(\\d{1,2})( .*)?$", "ymd"),
        MD_SLASHES("^(\\w+)/(\\d{1,2})( .*)?$", "md");

        private int dayIndex;
        private boolean hasYear;
        private int monthIndex;
        private Pattern pattern;
        private int yearIndex;

        Format(String str, String str2) {
            this.pattern = Pattern.compile(str);
            boolean zContains = str2.contains("y");
            this.hasYear = zContains;
            if (zContains) {
                this.yearIndex = str2.indexOf("y");
            }
            this.monthIndex = str2.indexOf("m");
            this.dayIndex = str2.indexOf("d");
        }
    }

    private static Calendar makeDate(int i5, int i6, int i7) throws EvaluationException {
        if (i6 < 1 || i6 > 12) {
            throw new EvaluationException(ErrorEval.VALUE_INVALID);
        }
        Calendar localeCalendar = LocaleUtil.getLocaleCalendar(i5, i6 - 1, 1, 0, 0, 0);
        if (i7 < 1 || i7 > localeCalendar.getActualMaximum(5)) {
            throw new EvaluationException(ErrorEval.VALUE_INVALID);
        }
        localeCalendar.set(5, i7);
        return localeCalendar;
    }

    public static Calendar parseDate(String str) throws EvaluationException {
        LocalDate localDate = parseLocalDate(str);
        return makeDate(localDate.getYear(), localDate.getMonthValue(), localDate.getDayOfMonth());
    }

    public static LocalDate parseLocalDate(String str) throws EvaluationException {
        for (Format format : Format.values()) {
            Matcher matcher = format.pattern.matcher(str);
            if (matcher.find()) {
                MatchResult matchResult = matcher.toMatchResult();
                ArrayList arrayList = new ArrayList();
                for (int i5 = 1; i5 <= matchResult.groupCount(); i5++) {
                    arrayList.add(matchResult.group(i5));
                }
                try {
                    return LocalDate.of(format.hasYear ? Integer.parseInt((String) arrayList.get(format.yearIndex)) : LocalDate.now(LocaleUtil.getUserTimeZone().toZoneId()).getYear(), parseMonth((String) arrayList.get(format.monthIndex)), Integer.parseInt((String) arrayList.get(format.dayIndex)));
                } catch (DateTimeException unused) {
                    throw new DateTimeException(AbstractC0157z.n("Failed to parse date-string ", str));
                }
            }
        }
        throw new EvaluationException(ErrorEval.VALUE_INVALID);
    }

    private static int parseMonth(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            String[] months = DateFormatSymbols.getInstance(LocaleUtil.getUserLocale()).getMonths();
            for (int i5 = 0; i5 < months.length; i5++) {
                if (months[i5].toLowerCase(LocaleUtil.getUserLocale()).startsWith(str.toLowerCase(LocaleUtil.getUserLocale()))) {
                    return i5 + 1;
                }
            }
            return -1;
        }
    }
}
