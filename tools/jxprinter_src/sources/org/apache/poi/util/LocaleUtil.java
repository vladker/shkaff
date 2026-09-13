package org.apache.poi.util;

import java.nio.charset.Charset;
import java.time.ZoneOffset;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class LocaleUtil {
    public static final TimeZone TIMEZONE_UTC = TimeZone.getTimeZone(ZoneOffset.UTC);
    public static final Charset CHARSET_1252 = Charset.forName("CP1252");
    private static final ThreadLocal<TimeZone> userTimeZone = new ThreadLocal<>();
    private static final ThreadLocal<Locale> userLocale = new ThreadLocal<>();

    private LocaleUtil() {
    }

    public static int getDefaultCodePageFromLCID(int i5) {
        LocaleID localeIDLookupByLcid = LocaleID.lookupByLcid(i5 & 65535);
        if (localeIDLookupByLcid == null) {
            return 0;
        }
        return localeIDLookupByLcid.getDefaultCodepage();
    }

    public static Calendar getLocaleCalendar() {
        return getLocaleCalendar(getUserTimeZone());
    }

    public static String getLocaleFromLCID(int i5) {
        LocaleID localeIDLookupByLcid = LocaleID.lookupByLcid(i5 & 65535);
        return localeIDLookupByLcid == null ? "invalid" : localeIDLookupByLcid.getLanguageTag();
    }

    @SuppressForbidden("implementation around default locales in POI")
    public static Locale getUserLocale() {
        Locale locale = userLocale.get();
        return locale != null ? locale : Locale.getDefault();
    }

    @SuppressForbidden("implementation around default locales in POI")
    public static TimeZone getUserTimeZone() {
        TimeZone timeZone = userTimeZone.get();
        return timeZone != null ? timeZone : TimeZone.getDefault();
    }

    public static void resetUserLocale() {
        userLocale.remove();
    }

    public static void resetUserTimeZone() {
        userTimeZone.remove();
    }

    public static void setUserLocale(Locale locale) {
        userLocale.set(locale);
    }

    public static void setUserTimeZone(TimeZone timeZone) {
        userTimeZone.set(timeZone);
    }

    public static Calendar getLocaleCalendar(int i5, int i6, int i7) {
        return getLocaleCalendar(i5, i6, i7, 0, 0, 0);
    }

    public static Calendar getLocaleCalendar(int i5, int i6, int i7, int i8, int i9, int i10) {
        Calendar localeCalendar = getLocaleCalendar();
        localeCalendar.set(i5, i6, i7, i8, i9, i10);
        localeCalendar.clear(14);
        return localeCalendar;
    }

    public static Calendar getLocaleCalendar(TimeZone timeZone) {
        return Calendar.getInstance(timeZone, getUserLocale());
    }
}
