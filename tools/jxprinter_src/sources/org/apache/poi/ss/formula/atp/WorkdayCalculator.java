package org.apache.poi.ss.formula.atp;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.util.LocaleUtil;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class WorkdayCalculator {
    private static final Set<Integer> friSatWeekend;
    private static final Set<Integer> friWeekend;
    public static final WorkdayCalculator instance = new WorkdayCalculator();
    private static final Set<Integer> monTuesWeekend;
    private static final Set<Integer> monWeekend;
    private static final Set<Integer> satWeekend;
    private static final Set<Integer> standardWeekend;
    private static final Set<Integer> sunMonWeekend;
    private static final Set<Integer> sunWeekend;
    private static final Set<Integer> thursFriWeekend;
    private static final Set<Integer> thursWeekend;
    private static final Set<Integer> tuesWedsWeekend;
    private static final Set<Integer> tuesWeekend;
    private static final Set<Integer> wedsThursWeekend;
    private static final Set<Integer> wedsWeekend;
    private static final Map<Integer, Set<Integer>> weekendTypeMap;

    static {
        HashSet hashSet = new HashSet(Arrays.asList(7, 1));
        standardWeekend = hashSet;
        HashSet hashSet2 = new HashSet(Arrays.asList(1, 2));
        sunMonWeekend = hashSet2;
        HashSet hashSet3 = new HashSet(Arrays.asList(2, 3));
        monTuesWeekend = hashSet3;
        HashSet hashSet4 = new HashSet(Arrays.asList(3, 4));
        tuesWedsWeekend = hashSet4;
        HashSet hashSet5 = new HashSet(Arrays.asList(4, 5));
        wedsThursWeekend = hashSet5;
        HashSet hashSet6 = new HashSet(Arrays.asList(5, 6));
        thursFriWeekend = hashSet6;
        HashSet hashSet7 = new HashSet(Arrays.asList(6, 7));
        friSatWeekend = hashSet7;
        Set<Integer> setSingleton = Collections.singleton(2);
        monWeekend = setSingleton;
        Set<Integer> setSingleton2 = Collections.singleton(3);
        tuesWeekend = setSingleton2;
        Set<Integer> setSingleton3 = Collections.singleton(4);
        wedsWeekend = setSingleton3;
        Set<Integer> setSingleton4 = Collections.singleton(5);
        thursWeekend = setSingleton4;
        Set<Integer> setSingleton5 = Collections.singleton(6);
        friWeekend = setSingleton5;
        Set<Integer> setSingleton6 = Collections.singleton(7);
        satWeekend = setSingleton6;
        Set<Integer> setSingleton7 = Collections.singleton(1);
        sunWeekend = setSingleton7;
        HashMap map = new HashMap();
        weekendTypeMap = map;
        map.put(1, hashSet);
        map.put(2, hashSet2);
        map.put(3, hashSet3);
        map.put(4, hashSet4);
        map.put(5, hashSet5);
        map.put(6, hashSet6);
        map.put(7, hashSet7);
        map.put(11, setSingleton7);
        map.put(12, setSingleton);
        map.put(13, setSingleton2);
        map.put(14, setSingleton3);
        map.put(15, setSingleton4);
        map.put(16, setSingleton5);
        map.put(17, setSingleton6);
    }

    private WorkdayCalculator() {
    }

    public int calculateNonWeekendHolidays(double d, double d6, double[] dArr) {
        double dMin = Math.min(d, d6);
        double dMax = Math.max(d6, d);
        int i5 = 0;
        for (double d7 : dArr) {
            if (isInARange(dMin, dMax, d7) && !isWeekend(d7)) {
                i5++;
            }
        }
        return d <= d6 ? i5 : -i5;
    }

    public int calculateWorkdays(double d, double d6, double[] dArr) {
        double d7;
        double d8;
        int iPastDaysOfWeek;
        WorkdayCalculator workdayCalculator;
        Set<Integer> set = standardWeekend;
        Integer[] numArr = (Integer[]) set.toArray(new Integer[set.size()]);
        int iPastDaysOfWeek2 = 0;
        if (numArr.length == 0) {
            d7 = d;
            d8 = d6;
            iPastDaysOfWeek = 0;
        } else {
            d7 = d;
            d8 = d6;
            iPastDaysOfWeek = pastDaysOfWeek(d7, d8, numArr[0].intValue());
        }
        if (numArr.length <= 1) {
            workdayCalculator = this;
        } else {
            workdayCalculator = this;
            iPastDaysOfWeek2 = workdayCalculator.pastDaysOfWeek(d7, d8, numArr[1].intValue());
        }
        return ((((int) ((d8 - d7) + 1.0d)) - iPastDaysOfWeek) - iPastDaysOfWeek2) - workdayCalculator.calculateNonWeekendHolidays(d7, d8, dArr);
    }

    public Set<Integer> getValidWeekendTypes() {
        return weekendTypeMap.keySet();
    }

    public boolean isHoliday(double d, double[] dArr) {
        for (double d6 : dArr) {
            if (Math.round(d6) == Math.round(d)) {
                return true;
            }
        }
        return false;
    }

    public boolean isInARange(double d, double d6, double d7) {
        return d7 >= d && d7 <= d6;
    }

    public boolean isWeekend(double d) {
        Calendar localeCalendar = LocaleUtil.getLocaleCalendar();
        localeCalendar.setTime(DateUtil.getJavaDate(d));
        return isWeekend(localeCalendar);
    }

    public int pastDaysOfWeek(double d, double d6, int i5) {
        int iFloor = (int) Math.floor(Math.max(d6, d));
        int i6 = 0;
        for (int iFloor2 = (int) Math.floor(Math.min(d, d6)); iFloor2 <= iFloor; iFloor2++) {
            Calendar localeCalendar = LocaleUtil.getLocaleCalendar();
            localeCalendar.setTime(DateUtil.getJavaDate(iFloor2));
            if (localeCalendar.get(7) == i5) {
                i6++;
            }
        }
        return d <= d6 ? i6 : -i6;
    }

    private boolean isWeekend(Calendar calendar) {
        return isWeekend(calendar, standardWeekend);
    }

    private boolean isWeekend(Calendar calendar, Set<Integer> set) {
        return set.contains(Integer.valueOf(calendar.get(7)));
    }

    public Date calculateWorkdays(double d, int i5, double[] dArr) {
        return calculateWorkdays(d, i5, 1, dArr);
    }

    public Date calculateWorkdays(double d, int i5, int i6, double[] dArr) {
        Set<Integer> orDefault = weekendTypeMap.getOrDefault(Integer.valueOf(i6), standardWeekend);
        Date javaDate = DateUtil.getJavaDate(d);
        int i7 = i5 < 0 ? -1 : 1;
        Calendar localeCalendar = LocaleUtil.getLocaleCalendar();
        localeCalendar.setTime(javaDate);
        double excelDate = DateUtil.getExcelDate(localeCalendar.getTime());
        while (i5 != 0) {
            localeCalendar.add(6, i7);
            excelDate += (double) i7;
            if (!isWeekend(localeCalendar, orDefault) && !isHoliday(excelDate, dArr)) {
                i5 -= i7;
            }
        }
        return localeCalendar.getTime();
    }
}
