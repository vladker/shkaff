package org.apache.poi.ss.usermodel;

import A3.AbstractC0157z;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalQueries;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.util.regex.Pattern;
import org.apache.commons.compress.archivers.tar.TarConstants;
import org.apache.logging.log4j.message.ParameterizedMessage;
import org.apache.poi.ss.formula.ConditionalFormattingEvaluator;
import org.apache.poi.util.LocaleUtil;
import org.apache.xmlbeans.SchemaType;
import org.opencv.videoio.Videoio;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class DateUtil {
    private static final int BAD_DATE = -1;
    public static final long DAY_MILLISECONDS = 86400000;
    public static final int HOURS_PER_DAY = 24;
    public static final int MINUTES_PER_HOUR = 60;
    public static final int SECONDS_PER_DAY = 86400;
    public static final int SECONDS_PER_MINUTE = 60;
    private static final BigDecimal BD_NANOSEC_DAY = BigDecimal.valueOf(8.64E13d);
    private static final BigDecimal BD_MILISEC_RND = BigDecimal.valueOf(500000.0d);
    private static final BigDecimal BD_SECOND_RND = BigDecimal.valueOf(5.0E8d);
    private static final Pattern TIME_SEPARATOR_PATTERN = Pattern.compile(ParameterizedMessage.ERROR_MSG_SEPARATOR);
    private static final Pattern date_ptrn1 = Pattern.compile("^\\[\\$-.*?]");
    private static final Pattern date_ptrn2 = Pattern.compile("^\\[[a-zA-Z]+]");
    private static final Pattern date_ptrn3a = Pattern.compile("[yYmMdDhHsS]");
    private static final Pattern date_ptrn3b = Pattern.compile("^[\\[\\]yYmMdDhHsS\\-T/年月日,. :\"\\\\]+0*[ampAMP/]*$");
    private static final Pattern date_ptrn4 = Pattern.compile("^\\[([hH]+|[mM]+|[sS]+)]");
    private static final Pattern date_ptrn5 = Pattern.compile("^\\[DBNum([123])]");
    private static final DateTimeFormatter dateTimeFormats = new DateTimeFormatterBuilder().appendPattern("[dd MMM[ yyyy]][[ ]h:m[:s][.SSS] a][[ ]H:m[:s][.SSS]]").appendPattern("[[yyyy ]dd-MMM[-yyyy]][[ ]h:m[:s][.SSS] a][[ ]H:m[:s][.SSS]]").appendPattern("[M/dd[/yyyy]][[ ]h:m[:s][.SSS] a][[ ]H:m[:s][.SSS]]").appendPattern("[[yyyy/]M/dd][[ ]h:m[:s][.SSS] a][[ ]H:m[:s][.SSS]]").parseDefaulting(ChronoField.YEAR_OF_ERA, LocaleUtil.getLocaleCalendar().get(1)).toFormatter(LocaleUtil.getUserLocale());
    private static final ThreadLocal<Integer> lastFormatIndex = ThreadLocal.withInitial(new a());
    private static final ThreadLocal<String> lastFormatString = new ThreadLocal<>();
    private static final ThreadLocal<Boolean> lastCachedResult = new ThreadLocal<>();

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class FormatException extends Exception {
        public FormatException(String str) {
            super(str);
        }
    }

    private DateUtil() {
    }

    public static int absoluteDay(Calendar calendar, boolean z6) {
        return absoluteDay(calendar.get(1), calendar.get(6), z6);
    }

    private static void cache(String str, int i5, boolean z6) {
        if (str == null || "".equals(str)) {
            lastFormatString.remove();
        } else {
            lastFormatString.set(str);
        }
        if (i5 == -1) {
            lastFormatIndex.remove();
        } else {
            lastFormatIndex.set(Integer.valueOf(i5));
        }
        lastCachedResult.set(Boolean.valueOf(z6));
    }

    public static double convertTime(String str) {
        try {
            return convertTimeInternal(str);
        } catch (FormatException e) {
            StringBuilder sbY = AbstractC0157z.y("Bad time format '", str, "' expected 'HH:MM' or 'HH:MM:SS' - ");
            sbY.append(e.getMessage());
            throw new IllegalArgumentException(sbY.toString());
        }
    }

    private static double convertTimeInternal(String str) throws FormatException {
        String str2;
        int length = str.length();
        if (length < 4 || length > 8) {
            throw new FormatException("Bad length");
        }
        String[] strArrSplit = TIME_SEPARATOR_PATTERN.split(str);
        int length2 = strArrSplit.length;
        if (length2 == 2) {
            str2 = TarConstants.VERSION_POSIX;
        } else {
            if (length2 != 3) {
                throw new FormatException(AbstractC0157z.l(")", strArrSplit.length, new StringBuilder("Expected 2 or 3 fields but got (")));
            }
            str2 = strArrSplit[2];
        }
        String str3 = strArrSplit[0];
        String str4 = strArrSplit[1];
        int i5 = parseInt(str3, "hour", 24);
        int i6 = parseInt(str4, "minute", 60);
        return ((((((double) i5) * 60.0d) + ((double) i6)) * 60.0d) + ((double) parseInt(str2, "second", 60))) / 86400.0d;
    }

    private static Calendar dayStart(Calendar calendar) {
        calendar.get(11);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        calendar.get(11);
        return calendar;
    }

    public static int daysInPriorYears(int i5, boolean z6) {
        int i6 = Videoio.CAP_FFMPEG;
        if ((!z6 && i5 < 1900) || (z6 && i5 < 1904)) {
            throw new IllegalArgumentException("'year' must be 1900 or greater");
        }
        int i7 = i5 - 1;
        int i8 = ((i7 / 400) + ((i7 / 4) - (i7 / 100))) - 460;
        if (z6) {
            i6 = 1904;
        }
        return ((i5 - i6) * 365) + i8;
    }

    public static double getExcelDate(LocalDate localDate) {
        return getExcelDate(localDate, false);
    }

    public static Calendar getJavaCalendar(double d) {
        return getJavaCalendar(d, false, null, false);
    }

    public static Calendar getJavaCalendarUTC(double d, boolean z6) {
        return getJavaCalendar(d, z6, LocaleUtil.TIMEZONE_UTC, false);
    }

    public static Date getJavaDate(double d, TimeZone timeZone) {
        return getJavaDate(d, false, timeZone, false);
    }

    public static LocalDateTime getLocalDateTime(double d) {
        return getLocalDateTime(d, false, false);
    }

    private static double internalGetExcelDate(int i5, int i6, int i7, int i8, int i9, int i10, boolean z6) {
        if (!z6 && i5 < 1900) {
            return -1.0d;
        }
        if (z6 && i5 < 1904) {
            return -1.0d;
        }
        double dAbsoluteDay = (((((((((double) i7) * 60.0d) + ((double) i8)) * 60.0d) + ((double) i9)) * 1000.0d) + ((double) i10)) / 8.64E7d) + ((double) absoluteDay(i5, i6, z6));
        if (z6 || dAbsoluteDay < 60.0d) {
            return z6 ? dAbsoluteDay - 1.0d : dAbsoluteDay;
        }
        return dAbsoluteDay + 1.0d;
    }

    public static boolean isADateFormat(ExcelNumberFormat excelNumberFormat) {
        if (excelNumberFormat == null) {
            return false;
        }
        return isADateFormat(excelNumberFormat.getIdx(), excelNumberFormat.getFormat());
    }

    private static boolean isCached(String str, int i5) {
        return i5 == lastFormatIndex.get().intValue() && str.equals(lastFormatString.get());
    }

    public static boolean isCellDateFormatted(Cell cell) {
        return isCellDateFormatted(cell, null);
    }

    public static boolean isCellInternalDateFormatted(Cell cell) {
        if (cell != null && isValidExcelDate(cell.getNumericCellValue())) {
            return isInternalDateFormat(cell.getCellStyle().getDataFormat());
        }
        return false;
    }

    public static boolean isInternalDateFormat(int i5) {
        switch (i5) {
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
                return true;
            default:
                switch (i5) {
                    case 45:
                    case 46:
                    case 47:
                        return true;
                    default:
                        return false;
                }
        }
    }

    public static boolean isValidExcelDate(double d) {
        return d > -4.9E-324d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Integer lambda$static$0() {
        return -1;
    }

    public static Double parseDateTime(String str) {
        TemporalAccessor temporalAccessor = dateTimeFormats.parse(str.replaceAll("\\s+", " "));
        LocalTime localTime = (LocalTime) temporalAccessor.query(TemporalQueries.localTime());
        LocalDate localDate = (LocalDate) temporalAccessor.query(TemporalQueries.localDate());
        if (localTime == null && localDate == null) {
            return null;
        }
        double excelDate = localDate != null ? getExcelDate(Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant())) : 0.0d;
        if (localTime != null) {
            excelDate += (((double) localTime.toSecondOfDay()) * 1.0d) / 86400.0d;
        }
        return Double.valueOf(excelDate);
    }

    private static int parseInt(String str, String str2, int i5) {
        return parseInt(str, str2, 0, i5 - 1);
    }

    public static Date parseYYYYMMDDDate(String str) {
        try {
            return parseYYYYMMDDDateInternal(str);
        } catch (FormatException e) {
            StringBuilder sbY = AbstractC0157z.y("Bad time format ", str, " expected 'YYYY/MM/DD' - ");
            sbY.append(e.getMessage());
            throw new IllegalArgumentException(sbY.toString());
        }
    }

    private static Date parseYYYYMMDDDateInternal(String str) throws FormatException {
        if (str.length() != 10) {
            throw new FormatException("Bad length");
        }
        String strSubstring = str.substring(0, 4);
        String strSubstring2 = str.substring(5, 7);
        String strSubstring3 = str.substring(8, 10);
        return LocaleUtil.getLocaleCalendar(parseInt(strSubstring, "year", -32768, 32767), parseInt(strSubstring2, "month", 1, 12) - 1, parseInt(strSubstring3, "day", 1, 31)).getTime();
    }

    public static void setCalendar(Calendar calendar, int i5, int i6, boolean z6, boolean z7) {
        int i7;
        int i8;
        if (z6) {
            i8 = 1;
            i7 = 1904;
        } else {
            i7 = 1900;
            i8 = i5 < 61 ? 0 : -1;
        }
        calendar.set(i7, 0, i5 + i8, 0, 0, 0);
        calendar.set(14, i6);
        if (calendar.get(14) == 0) {
            calendar.clear(14);
        }
        if (z7) {
            calendar.add(14, Videoio.CAP_QT);
            calendar.clear(14);
        }
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [java.time.LocalDateTime] */
    public static LocalDateTime toLocalDateTime(Date date) {
        return date.toInstant().atZone(LocaleUtil.TIMEZONE_UTC.toZoneId()).toLocalDateTime();
    }

    public static int absoluteDay(LocalDateTime localDateTime, boolean z6) {
        return absoluteDay(localDateTime.getYear(), localDateTime.getDayOfYear(), z6);
    }

    public static double getExcelDate(LocalDate localDate, boolean z6) {
        return internalGetExcelDate(localDate.getYear(), localDate.getDayOfYear(), 0, 0, 0, 0, z6);
    }

    public static Calendar getJavaCalendar(double d, boolean z6) {
        return getJavaCalendar(d, z6, null, false);
    }

    public static Date getJavaDate(double d) {
        return getJavaDate(d, false, null, false);
    }

    public static LocalDateTime getLocalDateTime(double d, boolean z6) {
        return getLocalDateTime(d, z6, false);
    }

    /* JADX WARN: Code duplicated, block: B:31:0x005b  */
    public static boolean isADateFormat(int i5, String str) {
        if (isInternalDateFormat(i5)) {
            cache(str, i5, true);
            return true;
        }
        if (str == null || str.length() == 0) {
            return false;
        }
        if (isCached(str, i5)) {
            return lastCachedResult.get().booleanValue();
        }
        int length = str.length();
        StringBuilder sb = new StringBuilder(length);
        int i6 = 0;
        while (i6 < length) {
            char cCharAt = str.charAt(i6);
            if (i6 < length - 1) {
                int i7 = i6 + 1;
                char cCharAt2 = str.charAt(i7);
                if (cCharAt == '\\') {
                    if (cCharAt2 != ' ' && cCharAt2 != '\\') {
                        switch (cCharAt2) {
                            case ',':
                            case '-':
                            case '.':
                                break;
                            default:
                                sb.append(cCharAt);
                                break;
                        }
                    }
                } else if (cCharAt == ';' && cCharAt2 == '@') {
                    i6 = i7;
                } else {
                    sb.append(cCharAt);
                }
            } else {
                sb.append(cCharAt);
            }
            i6++;
        }
        String string = sb.toString();
        if (date_ptrn4.matcher(string).matches()) {
            cache(str, i5, true);
            return true;
        }
        String strReplaceAll = date_ptrn2.matcher(date_ptrn1.matcher(date_ptrn5.matcher(string).replaceAll("")).replaceAll("")).replaceAll("");
        int iIndexOf = strReplaceAll.indexOf(59);
        if (iIndexOf > 0 && iIndexOf < strReplaceAll.length() - 1) {
            strReplaceAll = strReplaceAll.substring(0, iIndexOf);
        }
        if (!date_ptrn3a.matcher(strReplaceAll).find()) {
            return false;
        }
        boolean zMatches = date_ptrn3b.matcher(strReplaceAll).matches();
        cache(str, i5, zMatches);
        return zMatches;
    }

    public static boolean isCellDateFormatted(Cell cell, ConditionalFormattingEvaluator conditionalFormattingEvaluator) {
        ExcelNumberFormat excelNumberFormatFrom;
        if (cell == null || !isValidExcelDate(cell.getNumericCellValue()) || (excelNumberFormatFrom = ExcelNumberFormat.from(cell, conditionalFormattingEvaluator)) == null) {
            return false;
        }
        return isADateFormat(excelNumberFormatFrom);
    }

    private static int parseInt(String str, String str2, int i5, int i6) throws FormatException {
        try {
            int i7 = Integer.parseInt(str);
            if (i7 >= i5 && i7 <= i6) {
                return i7;
            }
            throw new FormatException(str2 + " value (" + i7 + ") is outside the allowable range(0.." + i6 + ")");
        } catch (NumberFormatException unused) {
            throw new FormatException(androidx.collection.a.p("Bad int format '", str, "' for ", str2, " field"));
        }
    }

    private static int absoluteDay(int i5, int i6, boolean z6) {
        return daysInPriorYears(i5, z6) + i6;
    }

    public static Calendar getJavaCalendar(double d, boolean z6, TimeZone timeZone) {
        return getJavaCalendar(d, z6, timeZone, false);
    }

    public static Date getJavaDate(double d, boolean z6, TimeZone timeZone) {
        return getJavaDate(d, z6, timeZone, false);
    }

    public static LocalDateTime getLocalDateTime(double d, boolean z6, boolean z7) {
        int i5;
        int i6;
        if (!isValidExcelDate(d)) {
            return null;
        }
        BigDecimal bigDecimalValueOf = BigDecimal.valueOf(d);
        int iIntValue = bigDecimalValueOf.intValue();
        if (z6) {
            i6 = 1904;
            i5 = 1;
        } else if (iIntValue < 61) {
            i6 = 1900;
            i5 = 0;
        } else {
            i5 = -1;
            i6 = 1900;
        }
        return LocalDateTime.of(i6, 1, 1, 0, 0).plusDays(((long) (i5 + iIntValue)) - 1).plusNanos(bigDecimalValueOf.subtract(BigDecimal.valueOf(iIntValue)).multiply(BD_NANOSEC_DAY).add(z7 ? BD_SECOND_RND : BD_MILISEC_RND).longValue()).truncatedTo(z7 ? ChronoUnit.SECONDS : ChronoUnit.MILLIS);
    }

    public static Calendar getJavaCalendar(double d, boolean z6, TimeZone timeZone, boolean z7) {
        Calendar localeCalendar;
        if (!isValidExcelDate(d)) {
            return null;
        }
        int iFloor = (int) Math.floor(d);
        int iA = (int) androidx.collection.a.a(d, iFloor, 8.64E7d, 0.5d);
        if (timeZone != null) {
            localeCalendar = LocaleUtil.getLocaleCalendar(timeZone);
        } else {
            localeCalendar = LocaleUtil.getLocaleCalendar();
        }
        setCalendar(localeCalendar, iFloor, iA, z6, z7);
        return localeCalendar;
    }

    public static Date getJavaDate(double d, boolean z6, TimeZone timeZone, boolean z7) {
        Calendar javaCalendar = getJavaCalendar(d, z6, timeZone, z7);
        if (javaCalendar == null) {
            return null;
        }
        return javaCalendar.getTime();
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [java.time.LocalDateTime] */
    public static LocalDateTime toLocalDateTime(Calendar calendar) {
        return calendar.toInstant().atZone(LocaleUtil.TIMEZONE_UTC.toZoneId()).toLocalDateTime();
    }

    public static double getExcelDate(LocalDateTime localDateTime) {
        return getExcelDate(localDateTime, false);
    }

    public static double getExcelDate(LocalDateTime localDateTime, boolean z6) {
        return internalGetExcelDate(localDateTime.getYear(), localDateTime.getDayOfYear(), localDateTime.getHour(), localDateTime.getMinute(), localDateTime.getSecond(), localDateTime.getNano() / SchemaType.SIZE_BIG_INTEGER, z6);
    }

    public static Date getJavaDate(double d, boolean z6) {
        return getJavaDate(d, z6, null, false);
    }

    public static double getExcelDate(Date date) {
        return getExcelDate(date, false);
    }

    public static double getExcelDate(Date date, boolean z6) {
        Calendar localeCalendar = LocaleUtil.getLocaleCalendar();
        localeCalendar.setTime(date);
        return internalGetExcelDate(localeCalendar.get(1), localeCalendar.get(6), localeCalendar.get(11), localeCalendar.get(12), localeCalendar.get(13), localeCalendar.get(14), z6);
    }

    public static double getExcelDate(Calendar calendar, boolean z6) {
        return internalGetExcelDate(calendar.get(1), calendar.get(6), calendar.get(11), calendar.get(12), calendar.get(13), calendar.get(14), z6);
    }
}
