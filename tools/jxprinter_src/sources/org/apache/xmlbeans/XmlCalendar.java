package org.apache.xmlbeans;

import java.math.BigDecimal;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import org.apache.poi.xddf.usermodel.Angles;
import org.apache.xmlbeans.impl.util.SuppressForbidden;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class XmlCalendar extends GregorianCalendar {
    private static final int DEFAULT_DEFAULT_YEAR = 0;
    private static final Date _beginningOfTime = new Date(Long.MIN_VALUE);
    private static int defaultYear = Integer.MIN_VALUE;

    public XmlCalendar(String str) {
        this(new GDate(str));
    }

    public static int getDefaultYear() {
        if (defaultYear == Integer.MIN_VALUE) {
            try {
                String property = SystemProperties.getProperty("user.defaultyear");
                if (property != null) {
                    defaultYear = Integer.parseInt(property);
                } else {
                    defaultYear = 0;
                }
            } catch (Throwable unused) {
                defaultYear = 0;
            }
        }
        return defaultYear;
    }

    public static void setDefaultYear(int i5) {
        defaultYear = i5;
    }

    @Override // java.util.GregorianCalendar, java.util.Calendar
    public void computeTime() {
        boolean zIsSet = isSet(1);
        if (!zIsSet) {
            set(1, getDefaultYear());
        }
        try {
            super.computeTime();
        } finally {
            if (!zIsSet) {
                clear(1);
            }
        }
    }

    @Override // java.util.Calendar
    public int get(int i5) {
        return (!isSet(i5) || ((GregorianCalendar) this).isTimeSet) ? super.get(i5) : internalGet(i5);
    }

    @Override // java.util.Calendar
    public String toString() {
        return new GDate(this).toString();
    }

    public XmlCalendar(GDateSpecification gDateSpecification) {
        this(GDate.timeZoneForGDate(gDateSpecification), gDateSpecification);
    }

    @SuppressForbidden("Locale is not known and we don't have a general class to set the default locale")
    private XmlCalendar(TimeZone timeZone, GDateSpecification gDateSpecification) {
        super(timeZone);
        setGregorianChange(_beginningOfTime);
        clear();
        if (gDateSpecification.hasYear()) {
            int year = gDateSpecification.getYear();
            if (year > 0) {
                set(0, 1);
            } else {
                set(0, 0);
                year = -year;
            }
            set(1, year);
        }
        if (gDateSpecification.hasMonth()) {
            set(2, gDateSpecification.getMonth() - 1);
        }
        if (gDateSpecification.hasDay()) {
            set(5, gDateSpecification.getDay());
        }
        if (gDateSpecification.hasTime()) {
            set(11, gDateSpecification.getHour());
            set(12, gDateSpecification.getMinute());
            set(13, gDateSpecification.getSecond());
            if (gDateSpecification.getFraction().scale() > 0) {
                set(14, gDateSpecification.getMillisecond());
            }
        }
        if (gDateSpecification.hasTimeZone()) {
            set(15, (gDateSpecification.getTimeZoneMinute() + (gDateSpecification.getTimeZoneHour() * 60)) * gDateSpecification.getTimeZoneSign() * Angles.OOXML_DEGREE);
            set(16, 0);
        }
    }

    public XmlCalendar(Date date) {
        this(TimeZone.getDefault(), new GDate(date));
        complete();
    }

    public XmlCalendar(int i5, int i6, int i7, int i8, int i9, int i10, BigDecimal bigDecimal) {
        this(TimeZone.getDefault(), new GDate(i5, i6, i7, i8, i9, i10, bigDecimal));
    }

    public XmlCalendar(int i5, int i6, int i7, int i8, int i9, int i10, BigDecimal bigDecimal, int i11, int i12, int i13) {
        this(new GDate(i5, i6, i7, i8, i9, i10, bigDecimal, i11, i12, i13));
    }

    @SuppressForbidden("Locale is not known and we don't have a general class to set the default locale")
    public XmlCalendar() {
        setGregorianChange(_beginningOfTime);
        clear();
    }
}
