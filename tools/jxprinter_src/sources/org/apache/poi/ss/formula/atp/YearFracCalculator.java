package org.apache.poi.ss.formula.atp;

import androidx.collection.a;
import java.util.Calendar;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.util.Internal;
import org.apache.poi.util.LocaleUtil;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Internal
final class YearFracCalculator {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int DAYS_PER_LEAP_YEAR = 366;
    private static final int DAYS_PER_NORMAL_YEAR = 365;
    private static final int LONG_FEB_LEN = 29;
    private static final int LONG_MONTH_LEN = 31;
    private static final int MS_PER_DAY = 86400000;
    private static final int MS_PER_HOUR = 3600000;
    private static final int SHORT_FEB_LEN = 28;
    private static final int SHORT_MONTH_LEN = 30;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class SimpleDate {
        public static final int FEBRUARY = 2;
        public static final int JANUARY = 1;
        public final int day;
        public final int month;
        public final long tsMilliseconds;
        public final int year;

        public SimpleDate(Calendar calendar) {
            this.year = calendar.get(1);
            this.month = calendar.get(2) + 1;
            this.day = calendar.get(5);
            this.tsMilliseconds = calendar.getTimeInMillis();
        }
    }

    private YearFracCalculator() {
    }

    private static double averageYearLength(int i5, int i6) {
        int i7 = 0;
        for (int i8 = i5; i8 <= i6; i8++) {
            i7 += isLeapYear(i8) ? 366 : 365;
        }
        return ((double) i7) / (((double) (i6 - i5)) + 1.0d);
    }

    /* JADX WARN: Code duplicated, block: B:5:0x0014  */
    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    private static double basis0(int i5, int i6) {
        SimpleDate simpleDateCreateDate = createDate(i5);
        SimpleDate simpleDateCreateDate2 = createDate(i6);
        int i7 = simpleDateCreateDate.day;
        int i8 = simpleDateCreateDate2.day;
        if (i7 == 31 && i8 == 31) {
            i7 = 30;
            i8 = 30;
        } else if (i7 == 31) {
            i7 = 30;
        } else if (i7 == 30 && i8 == 31) {
            i8 = 30;
        } else if (simpleDateCreateDate.month == 2 && isLastDayOfMonth(simpleDateCreateDate)) {
            if (simpleDateCreateDate2.month == 2 && isLastDayOfMonth(simpleDateCreateDate2)) {
                i7 = 30;
                i8 = 30;
            } else {
                i7 = 30;
            }
        }
        return calculateAdjusted(simpleDateCreateDate, simpleDateCreateDate2, i7, i8);
    }

    private static double basis1(int i5, int i6) {
        double dAverageYearLength;
        SimpleDate simpleDateCreateDate = createDate(i5);
        SimpleDate simpleDateCreateDate2 = createDate(i6);
        if (isGreaterThanOneYear(simpleDateCreateDate, simpleDateCreateDate2)) {
            dAverageYearLength = averageYearLength(simpleDateCreateDate.year, simpleDateCreateDate2.year);
        } else {
            dAverageYearLength = shouldCountFeb29(simpleDateCreateDate, simpleDateCreateDate2) ? 366.0d : 365.0d;
        }
        return ((double) dateDiff(simpleDateCreateDate.tsMilliseconds, simpleDateCreateDate2.tsMilliseconds)) / dAverageYearLength;
    }

    private static double basis2(int i5, int i6) {
        return ((double) (i6 - i5)) / 360.0d;
    }

    private static double basis3(double d, double d6) {
        return (d6 - d) / 365.0d;
    }

    private static double basis4(int i5, int i6) {
        SimpleDate simpleDateCreateDate = createDate(i5);
        SimpleDate simpleDateCreateDate2 = createDate(i6);
        int i7 = simpleDateCreateDate.day;
        int i8 = simpleDateCreateDate2.day;
        if (i7 == 31) {
            i7 = 30;
        }
        if (i8 == 31) {
            i8 = 30;
        }
        return calculateAdjusted(simpleDateCreateDate, simpleDateCreateDate2, i7, i8);
    }

    public static double calculate(double d, double d6, int i5) throws EvaluationException {
        if (i5 < 0 || i5 >= 5) {
            throw new EvaluationException(ErrorEval.NUM_ERROR);
        }
        int iFloor = (int) Math.floor(d);
        int iFloor2 = (int) Math.floor(d6);
        if (iFloor == iFloor2) {
            return 0.0d;
        }
        if (iFloor > iFloor2) {
            iFloor2 = iFloor;
            iFloor = iFloor2;
        }
        if (i5 == 0) {
            return basis0(iFloor, iFloor2);
        }
        if (i5 == 1) {
            return basis1(iFloor, iFloor2);
        }
        if (i5 == 2) {
            return basis2(iFloor, iFloor2);
        }
        if (i5 == 3) {
            return basis3(iFloor, iFloor2);
        }
        if (i5 == 4) {
            return basis4(iFloor, iFloor2);
        }
        throw new IllegalStateException("cannot happen");
    }

    private static double calculateAdjusted(SimpleDate simpleDate, SimpleDate simpleDate2, int i5, int i6) {
        return a.D(i6 - i5, 1.0d, (((double) (simpleDate2.month - simpleDate.month)) * 30.0d) + (((double) (simpleDate2.year - simpleDate.year)) * 360.0d), 360.0d);
    }

    private static SimpleDate createDate(int i5) {
        Calendar localeCalendar = LocaleUtil.getLocaleCalendar(LocaleUtil.TIMEZONE_UTC);
        DateUtil.setCalendar(localeCalendar, i5, 0, false, false);
        return new SimpleDate(localeCalendar);
    }

    private static int dateDiff(long j6, long j7) {
        long j8 = j7 - j6;
        if (((int) ((j8 % DateUtil.DAY_MILLISECONDS) / 3600000)) == 0) {
            return (int) ((j8 / 8.64E7d) + 0.5d);
        }
        StringBuilder sbT = a.t("Unexpected date diff between ", j6, " and ");
        sbT.append(j7);
        throw new RuntimeException(sbT.toString());
    }

    private static int getLastDayOfMonth(SimpleDate simpleDate) {
        switch (simpleDate.month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 2:
            default:
                return isLeapYear(simpleDate.year) ? 29 : 28;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
        }
    }

    private static boolean isGreaterThanOneYear(SimpleDate simpleDate, SimpleDate simpleDate2) {
        int i5 = simpleDate.year;
        int i6 = simpleDate2.year;
        if (i5 == i6) {
            return false;
        }
        if (i5 + 1 != i6) {
            return true;
        }
        int i7 = simpleDate.month;
        int i8 = simpleDate2.month;
        if (i7 > i8) {
            return false;
        }
        return i7 < i8 || simpleDate.day < simpleDate2.day;
    }

    private static boolean isLastDayOfMonth(SimpleDate simpleDate) {
        int i5 = simpleDate.day;
        return i5 >= 28 && i5 == getLastDayOfMonth(simpleDate);
    }

    private static boolean isLeapYear(int i5) {
        if (i5 % 4 != 0) {
            return false;
        }
        return i5 % 400 == 0 || i5 % 100 != 0;
    }

    private static boolean shouldCountFeb29(SimpleDate simpleDate, SimpleDate simpleDate2) {
        int i5;
        int i6;
        if (isLeapYear(simpleDate.year)) {
            return simpleDate.year == simpleDate2.year || (i6 = simpleDate.month) == 1 || i6 == 2;
        }
        return isLeapYear(simpleDate2.year) && (i5 = simpleDate2.month) != 1 && (i5 != 2 || simpleDate2.day == 29);
    }
}
