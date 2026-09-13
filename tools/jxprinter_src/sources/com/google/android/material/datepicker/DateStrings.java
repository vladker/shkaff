package com.google.android.material.datepicker;

import android.content.Context;
import androidx.annotation.Nullable;
import androidx.core.util.Pair;
import com.google.android.material.R;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
class DateStrings {
    private DateStrings() {
    }

    public static Pair<String, String> getDateRangeString(@Nullable Long l6, @Nullable Long l7) {
        return getDateRangeString(l6, l7, null);
    }

    public static String getDateString(long j6) {
        return getDateString(j6, null);
    }

    public static String getDayContentDescription(Context context, long j6, boolean z6, boolean z7, boolean z8) {
        String optionalYearMonthDayOfWeekDay = getOptionalYearMonthDayOfWeekDay(j6);
        if (z6) {
            optionalYearMonthDayOfWeekDay = String.format(context.getString(R.string.mtrl_picker_today_description), optionalYearMonthDayOfWeekDay);
        }
        if (z7) {
            return String.format(context.getString(R.string.mtrl_picker_start_date_description), optionalYearMonthDayOfWeekDay);
        }
        return z8 ? String.format(context.getString(R.string.mtrl_picker_end_date_description), optionalYearMonthDayOfWeekDay) : optionalYearMonthDayOfWeekDay;
    }

    public static String getMonthDay(long j6) {
        return getMonthDay(j6, Locale.getDefault());
    }

    public static String getMonthDayOfWeekDay(long j6) {
        return getMonthDayOfWeekDay(j6, Locale.getDefault());
    }

    public static String getOptionalYearMonthDayOfWeekDay(long j6) {
        return isDateWithinCurrentYear(j6) ? getMonthDayOfWeekDay(j6) : getYearMonthDayOfWeekDay(j6);
    }

    public static String getYearContentDescription(Context context, int i5) {
        return UtcDates.getTodayCalendar().get(1) == i5 ? String.format(context.getString(R.string.mtrl_picker_navigate_to_current_year_description), Integer.valueOf(i5)) : String.format(context.getString(R.string.mtrl_picker_navigate_to_year_description), Integer.valueOf(i5));
    }

    public static String getYearMonth(long j6) {
        return UtcDates.getYearMonthFormat(Locale.getDefault()).format(new Date(j6));
    }

    public static String getYearMonthDay(long j6) {
        return getYearMonthDay(j6, Locale.getDefault());
    }

    public static String getYearMonthDayOfWeekDay(long j6) {
        return getYearMonthDayOfWeekDay(j6, Locale.getDefault());
    }

    private static boolean isDateWithinCurrentYear(long j6) {
        Calendar todayCalendar = UtcDates.getTodayCalendar();
        Calendar utcCalendar = UtcDates.getUtcCalendar();
        utcCalendar.setTimeInMillis(j6);
        return todayCalendar.get(1) == utcCalendar.get(1);
    }

    public static Pair<String, String> getDateRangeString(@Nullable Long l6, @Nullable Long l7, @Nullable SimpleDateFormat simpleDateFormat) {
        if (l6 == null && l7 == null) {
            return Pair.create(null, null);
        }
        if (l6 == null) {
            return Pair.create(null, getDateString(l7.longValue(), simpleDateFormat));
        }
        if (l7 == null) {
            return Pair.create(getDateString(l6.longValue(), simpleDateFormat), null);
        }
        Calendar todayCalendar = UtcDates.getTodayCalendar();
        Calendar utcCalendar = UtcDates.getUtcCalendar();
        utcCalendar.setTimeInMillis(l6.longValue());
        Calendar utcCalendar2 = UtcDates.getUtcCalendar();
        utcCalendar2.setTimeInMillis(l7.longValue());
        if (simpleDateFormat != null) {
            return Pair.create(simpleDateFormat.format(new Date(l6.longValue())), simpleDateFormat.format(new Date(l7.longValue())));
        }
        if (utcCalendar.get(1) == utcCalendar2.get(1)) {
            return utcCalendar.get(1) == todayCalendar.get(1) ? Pair.create(getMonthDay(l6.longValue(), Locale.getDefault()), getMonthDay(l7.longValue(), Locale.getDefault())) : Pair.create(getMonthDay(l6.longValue(), Locale.getDefault()), getYearMonthDay(l7.longValue(), Locale.getDefault()));
        }
        return Pair.create(getYearMonthDay(l6.longValue(), Locale.getDefault()), getYearMonthDay(l7.longValue(), Locale.getDefault()));
    }

    public static String getDateString(long j6, @Nullable SimpleDateFormat simpleDateFormat) {
        if (simpleDateFormat != null) {
            return simpleDateFormat.format(new Date(j6));
        }
        return isDateWithinCurrentYear(j6) ? getMonthDay(j6) : getYearMonthDay(j6);
    }

    public static String getMonthDay(long j6, Locale locale) {
        return UtcDates.getAbbrMonthDayFormat(locale).format(new Date(j6));
    }

    public static String getMonthDayOfWeekDay(long j6, Locale locale) {
        return UtcDates.getMonthWeekdayDayFormat(locale).format(new Date(j6));
    }

    public static String getYearMonthDay(long j6, Locale locale) {
        return UtcDates.getYearAbbrMonthDayFormat(locale).format(new Date(j6));
    }

    public static String getYearMonthDayOfWeekDay(long j6, Locale locale) {
        return UtcDates.getYearMonthWeekdayDayFormat(locale).format(new Date(j6));
    }
}
