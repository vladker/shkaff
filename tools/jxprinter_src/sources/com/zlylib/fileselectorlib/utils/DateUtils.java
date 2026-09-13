package com.zlylib.fileselectorlib.utils;

import A3.AbstractC0157z;
import androidx.annotation.NonNull;
import androidx.exifinterface.media.ExifInterface;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import org.apache.poi.ss.usermodel.DateUtil;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class DateUtils extends android.text.format.DateUtils {
    public static final int Day = 3;
    public static final int Hour = 2;
    public static final int Minute = 1;
    public static final int Second = 0;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface DifferenceMode {
    }

    public static int calculateDaysInMonth(int i5) {
        return calculateDaysInMonth(0, i5);
    }

    public static long calculateDifference(long j6, long j7, int i5) {
        return calculateDifference(new Date(j6), new Date(j7), i5);
    }

    public static long calculateDifferentDay(Date date, Date date2) {
        return calculateDifference(date, date2, 3);
    }

    public static long calculateDifferentHour(Date date, Date date2) {
        return calculateDifference(date, date2, 2);
    }

    public static long calculateDifferentMinute(Date date, Date date2) {
        return calculateDifference(date, date2, 1);
    }

    public static long calculateDifferentSecond(Date date, Date date2) {
        return calculateDifference(date, date2, 0);
    }

    @NonNull
    public static String fillZero(int i5) {
        return AbstractC0157z.k(i5, i5 < 10 ? "0" : "");
    }

    public static String formatDate(Date date, String str) {
        return new SimpleDateFormat(str, Locale.PRC).format(date);
    }

    public static String getFileLastModifyTime(long j6) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.CHINA).format(Long.valueOf(j6));
    }

    public static boolean isSameDay(Date date) {
        if (date == null) {
            throw new IllegalArgumentException("date is null");
        }
        Calendar calendar = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(date);
        return calendar.get(0) == calendar2.get(0) && calendar.get(1) == calendar2.get(1) && calendar.get(6) == calendar2.get(6);
    }

    public static Date parseDate(String str, String str2) {
        try {
            return new Date(new SimpleDateFormat(str2, Locale.PRC).parse(str).getTime());
        } catch (ParseException e) {
            LogUtils.warn(e);
            return null;
        }
    }

    public static int trimZero(@NonNull String str) {
        try {
            if (str.startsWith("0")) {
                str = str.substring(1);
            }
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            LogUtils.warn(e);
            return 0;
        }
    }

    public static int calculateDaysInMonth(int i5, int i6) {
        List listAsList = Arrays.asList("1", ExifInterface.GPS_MEASUREMENT_3D, "5", "7", "8", "10", "12");
        List listAsList2 = Arrays.asList("4", "6", "9", "11");
        if (listAsList.contains(String.valueOf(i6))) {
            return 31;
        }
        if (listAsList2.contains(String.valueOf(i6))) {
            return 30;
        }
        if (i5 <= 0) {
            return 29;
        }
        return ((i5 % 4 != 0 || i5 % 100 == 0) && i5 % 400 != 0) ? 28 : 29;
    }

    public static long calculateDifference(Date date, Date date2, int i5) {
        long[] jArrCalculateDifference = calculateDifference(date, date2);
        if (i5 == 1) {
            return jArrCalculateDifference[2];
        }
        if (i5 == 2) {
            return jArrCalculateDifference[1];
        }
        return i5 == 3 ? jArrCalculateDifference[0] : jArrCalculateDifference[3];
    }

    public static long calculateDifferentDay(long j6, long j7) {
        return calculateDifference(j6, j7, 3);
    }

    public static long calculateDifferentHour(long j6, long j7) {
        return calculateDifference(j6, j7, 2);
    }

    public static long calculateDifferentMinute(long j6, long j7) {
        return calculateDifference(j6, j7, 1);
    }

    public static long calculateDifferentSecond(long j6, long j7) {
        return calculateDifference(j6, j7, 0);
    }

    public static String formatDate(String str) {
        return formatDate(Calendar.getInstance(Locale.CHINA).getTime(), str);
    }

    public static Date parseDate(String str) {
        return parseDate(str, "yyyy-MM-dd HH:mm:ss");
    }

    private static long[] calculateDifference(Date date, Date date2) {
        return calculateDifference(date2.getTime() - date.getTime());
    }

    private static long[] calculateDifference(long j6) {
        long j7 = j6 / DateUtil.DAY_MILLISECONDS;
        long j8 = j6 % DateUtil.DAY_MILLISECONDS;
        long j9 = j8 / 3600000;
        long j10 = j8 % 3600000;
        long j11 = j10 / 60000;
        long j12 = j10 % 60000;
        long j13 = j12 / 1000;
        LogUtils.verbose(String.format(Locale.CHINA, "different: %d ms, %d days, %d hours, %d minutes, %d seconds", Long.valueOf(j12), Long.valueOf(j7), Long.valueOf(j9), Long.valueOf(j11), Long.valueOf(j13)));
        return new long[]{j7, j9, j11, j13};
    }
}
