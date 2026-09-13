package org.apache.xmlbeans;

import androidx.collection.a;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import org.apache.logging.log4j.message.ParameterizedMessage;
import org.apache.logging.log4j.util.ProcessIdUtil;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xddf.usermodel.Angles;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final class GDateBuilder implements GDateSpecification, Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final BigInteger TEN = BigInteger.valueOf(10);
    private static final long serialVersionUID = 1;
    private int _CY;
    private int _D;
    private int _M;
    private int _bits;
    private BigDecimal _fs;
    private int _h;
    private int _m;
    private int _s;
    private int _tzh;
    private int _tzm;
    private int _tzsign;

    public GDateBuilder() {
    }

    private static long _fQuotient(long j6, int i5) {
        if ((j6 < 0) == (i5 < 0)) {
            return j6 / ((long) i5);
        }
        long j7 = i5;
        return -(((j7 - j6) - 1) / j7);
    }

    private static boolean _isLeapYear(int i5) {
        if (i5 % 4 == 0) {
            return i5 % 100 != 0 || i5 % 400 == 0;
        }
        return false;
    }

    private static int _maxDayInMonth(int i5) {
        if (i5 == 4 || i5 == 6 || i5 == 9 || i5 == 11) {
            return 30;
        }
        return i5 == 2 ? 29 : 31;
    }

    private static int _maxDayInMonthFor(int i5, int i6) {
        if (i6 == 4 || i6 == 6 || i6 == 9 || i6 == 11) {
            return 30;
        }
        if (i6 == 2) {
            return _isLeapYear(i5) ? 29 : 28;
        }
        return 31;
    }

    private static int _mod(long j6, int i5, long j7) {
        return (int) (j6 - (j7 * ((long) i5)));
    }

    private static int _modulo(long j6, int i5, int i6) {
        long j7 = j6 - ((long) i5);
        int i7 = i6 - i5;
        return _mod(j7, i7, _fQuotient(j7, i7)) + i5;
    }

    private void _normalizeDate() {
        int i5;
        int i6 = this._M;
        if (i6 < 1 || i6 > 12 || (i5 = this._D) < 1 || i5 > _maxDayInMonthFor(this._CY, i6)) {
            long j6 = this._M;
            this._M = _modulo(j6, 1, 13);
            this._CY += (int) _fQuotient(j6, 1, 13);
            int i7 = this._D - 1;
            this._D = 1;
            setJulianDate(getJulianDate() + i7);
        }
    }

    private long _normalizeTime() {
        long jLongValue;
        int i5;
        int i6;
        int i7;
        BigDecimal bigDecimal = this._fs;
        if (bigDecimal == null || (bigDecimal.signum() >= 0 && this._fs.compareTo(GDate._one) < 0)) {
            jLongValue = 0;
        } else {
            BigDecimal scale = this._fs.setScale(0, RoundingMode.FLOOR);
            this._fs = this._fs.subtract(scale);
            jLongValue = scale.longValue();
        }
        if (jLongValue == 0 && (i5 = this._s) >= 0 && i5 <= 59 && (i6 = this._m) >= 0 && i6 <= 50 && (i7 = this._h) >= 0 && i7 <= 23) {
            return jLongValue;
        }
        long j6 = ((long) this._s) + jLongValue;
        long j_fQuotient = _fQuotient(j6, 60);
        this._s = _mod(j6, 60, j_fQuotient);
        long j7 = ((long) this._m) + j_fQuotient;
        long j_fQuotient2 = _fQuotient(j7, 60);
        this._m = _mod(j7, 60, j_fQuotient2);
        long j8 = ((long) this._h) + j_fQuotient2;
        long j_fQuotient3 = _fQuotient(j8, 24);
        this._h = _mod(j8, 24, j_fQuotient3);
        return j_fQuotient3;
    }

    private void _normalizeTimeAndDate() {
        long j_normalizeTime = hasTime() ? _normalizeTime() : 0L;
        if (hasDay()) {
            this._D = Math.addExact(this._D, Math.toIntExact(j_normalizeTime));
        }
        if (hasDate()) {
            _normalizeDate();
            return;
        }
        if (hasMonth()) {
            int i5 = this._M;
            if (i5 < 1 || i5 > 12) {
                long j6 = i5;
                this._M = _modulo(j6, 1, 13);
                if (hasYear()) {
                    this._CY += (int) _fQuotient(j6, 1, 13);
                }
            }
        }
    }

    private void _setToFirstMoment() {
        if (!hasYear()) {
            setYear(1584);
        }
        if (!hasMonth()) {
            setMonth(1);
        }
        if (!hasDay()) {
            setDay(1);
        }
        if (hasTime()) {
            return;
        }
        setTime(0, 0, 0, GDate._zero);
    }

    public static int btcForFlags(int i5) {
        int i6 = i5 & 30;
        if (i6 == 2) {
            return 18;
        }
        if (i6 == 4) {
            return 21;
        }
        if (i6 == 6) {
            return 17;
        }
        if (i6 == 8) {
            return 20;
        }
        if (i6 == 12) {
            return 19;
        }
        if (i6 == 14) {
            return 16;
        }
        if (i6 != 16) {
            return i6 != 30 ? 0 : 14;
        }
        return 15;
    }

    public static int compareGDate(GDateSpecification gDateSpecification, GDateSpecification gDateSpecification2) {
        int flags = gDateSpecification.getFlags() ^ gDateSpecification2.getFlags();
        if ((flags & 31) == 0) {
            if (gDateSpecification.hasTimeZone() && (gDateSpecification2.getTimeZoneHour() != gDateSpecification.getTimeZoneHour() || gDateSpecification2.getTimeZoneMinute() != gDateSpecification.getTimeZoneMinute() || gDateSpecification2.getTimeZoneSign() != gDateSpecification.getTimeZoneSign())) {
                GDateBuilder gDateBuilder = new GDateBuilder(gDateSpecification2);
                int flags2 = gDateSpecification.getFlags() & 14;
                if ((flags2 != 0 && flags2 != 14) || !gDateSpecification.hasTime()) {
                    gDateBuilder._setToFirstMoment();
                    GDateBuilder gDateBuilder2 = new GDateBuilder(gDateSpecification);
                    gDateBuilder2._setToFirstMoment();
                    gDateSpecification = gDateBuilder2;
                }
                gDateBuilder.normalizeToTimeZone(gDateSpecification.getTimeZoneSign(), gDateSpecification.getTimeZoneHour(), gDateSpecification.getTimeZoneMinute());
                gDateSpecification2 = gDateBuilder;
            }
            return fieldwiseCompare(gDateSpecification, gDateSpecification2);
        }
        if ((flags & 30) != 0) {
            return 2;
        }
        if (!gDateSpecification.hasTimeZone()) {
            int iCompareGDate = compareGDate(gDateSpecification2, gDateSpecification);
            if (iCompareGDate == 2) {
                return 2;
            }
            return -iCompareGDate;
        }
        GDateBuilder gDateBuilder3 = new GDateBuilder(gDateSpecification);
        if ((gDateSpecification.getFlags() & 14) == 12) {
            if (gDateSpecification.getDay() == 28 && gDateSpecification.getMonth() == 2) {
                if (gDateSpecification2.getDay() == 1 && gDateSpecification2.getMonth() == 3) {
                    gDateBuilder3.setDay(29);
                }
            } else if (gDateSpecification2.getDay() == 28 && gDateSpecification2.getMonth() == 2 && gDateSpecification.getDay() == 1 && gDateSpecification.getMonth() == 3) {
                gDateBuilder3.setMonth(2);
                gDateBuilder3.setDay(29);
            }
        }
        gDateBuilder3._setToFirstMoment();
        GDateBuilder gDateBuilder4 = new GDateBuilder(gDateSpecification2);
        gDateBuilder4._setToFirstMoment();
        gDateBuilder4.setTimeZone(1, 14, 0);
        gDateBuilder4.normalizeToTimeZone(gDateSpecification.getTimeZoneSign(), gDateSpecification.getTimeZoneHour(), gDateSpecification.getTimeZoneMinute());
        if (fieldwiseCompare(gDateBuilder3, gDateBuilder4) == -1) {
            return -1;
        }
        gDateBuilder4.setGDate(gDateSpecification2);
        gDateBuilder4._setToFirstMoment();
        gDateBuilder4.setTimeZone(-1, 14, 0);
        gDateBuilder4.normalizeToTimeZone(gDateSpecification.getTimeZoneSign(), gDateSpecification.getTimeZoneHour(), gDateSpecification.getTimeZoneMinute());
        return fieldwiseCompare(gDateBuilder3, gDateBuilder4) == 1 ? 1 : 2;
    }

    public static Date dateForGDate(GDateSpecification gDateSpecification) {
        long offset;
        long hour = (((long) (gDateSpecification.getHour() * 3600)) * 1000) + (((long) (gDateSpecification.getMinute() * 60)) * 1000) + (((long) gDateSpecification.getSecond()) * 1000) + ((((long) julianDateForGDate(gDateSpecification)) - 2440588) * DateUtil.DAY_MILLISECONDS) + ((long) gDateSpecification.getMillisecond());
        if (gDateSpecification.hasTimeZone()) {
            hour -= ((long) ((gDateSpecification.getTimeZoneSign() * gDateSpecification.getTimeZoneMinute()) * 60)) * 1000;
            offset = ((long) (gDateSpecification.getTimeZoneSign() * gDateSpecification.getTimeZoneHour() * 3600)) * 1000;
        } else {
            offset = TimeZone.getDefault().getOffset(hour);
        }
        return new Date(hour - offset);
    }

    private static int fieldwiseCompare(GDateSpecification gDateSpecification, GDateSpecification gDateSpecification2) {
        if (gDateSpecification.hasYear()) {
            int year = gDateSpecification2.getYear();
            int year2 = gDateSpecification.getYear();
            if (year2 < year) {
                return -1;
            }
            if (year2 > year) {
                return 1;
            }
        }
        if (gDateSpecification.hasMonth()) {
            int month = gDateSpecification2.getMonth();
            int month2 = gDateSpecification.getMonth();
            if (month2 < month) {
                return -1;
            }
            if (month2 > month) {
                return 1;
            }
        }
        if (gDateSpecification.hasDay()) {
            int day = gDateSpecification2.getDay();
            int day2 = gDateSpecification.getDay();
            if (day2 < day) {
                return -1;
            }
            if (day2 > day) {
                return 1;
            }
        }
        if (!gDateSpecification.hasTime()) {
            return 0;
        }
        int hour = gDateSpecification2.getHour();
        int hour2 = gDateSpecification.getHour();
        if (hour2 < hour) {
            return -1;
        }
        if (hour2 > hour) {
            return 1;
        }
        int minute = gDateSpecification2.getMinute();
        int minute2 = gDateSpecification.getMinute();
        if (minute2 < minute) {
            return -1;
        }
        if (minute2 > minute) {
            return 1;
        }
        int second = gDateSpecification2.getSecond();
        int second2 = gDateSpecification.getSecond();
        if (second2 < second) {
            return -1;
        }
        if (second2 > second) {
            return 1;
        }
        BigDecimal fraction = gDateSpecification2.getFraction();
        BigDecimal fraction2 = gDateSpecification.getFraction();
        if (fraction2 == null && fraction == null) {
            return 0;
        }
        if (fraction2 == null) {
            fraction2 = GDate._zero;
        }
        if (fraction == null) {
            fraction = GDate._zero;
        }
        return fraction2.compareTo(fraction);
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0068, code lost:
    
        if (r5.getDay() > _maxDayInMonthFor(r5.getYear() > 0 ? r5.getYear() : r5.getYear() + 1, r5.getMonth())) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0077, code lost:
    
        if (r5.getDay() > _maxDayInMonth(r5.getMonth())) goto L35;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean isValidGDate(org.apache.xmlbeans.GDateSpecification r5) {
        /*
            Method dump skipped, instruction units count: 302
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.xmlbeans.GDateBuilder.isValidGDate(org.apache.xmlbeans.GDateSpecification):boolean");
    }

    public static int julianDateForGDate(GDateSpecification gDateSpecification) {
        if (!gDateSpecification.hasDate()) {
            throw new IllegalStateException("cannot do date math without a complete date");
        }
        int day = gDateSpecification.getDay();
        int month = gDateSpecification.getMonth();
        int year = gDateSpecification.getYear();
        if (year <= 0) {
            year++;
        }
        int i5 = (month - 14) / 12;
        int i6 = (((((month - 2) - (i5 * 12)) * 367) / 12) + (((((year + 4800) + i5) * 1461) / 4) + (day - 32075))) - (((((year + 4900) + i5) / 100) * 3) / 4);
        if (i6 >= 0) {
            return i6;
        }
        throw new IllegalStateException("date too far in the past (year allowed to -4713)");
    }

    public void addDuration(int i5, int i6, int i7, int i8, int i9, int i10, int i11, BigDecimal bigDecimal) {
        int i_maxDayInMonthFor;
        long j_normalizeTime;
        boolean z6 = false;
        boolean z7 = (i9 == 0 && i10 == 0 && i11 == 0 && (bigDecimal == null || bigDecimal.signum() == 0)) ? false : true;
        if (z7 && !hasTime()) {
            throw new IllegalStateException("cannot do time math without a complete time");
        }
        if (hasDay() && (i8 != 0 || z7)) {
            z6 = true;
        }
        if (z6 && !hasDate()) {
            throw new IllegalStateException("cannot do date math without a complete date");
        }
        if (i7 != 0 || i6 != 0) {
            if (hasDay()) {
                _normalizeDate();
            }
            long j6 = (i7 * i5) + this._M;
            this._M = _modulo(j6, 1, 13);
            this._CY = (i6 * i5) + this._CY + ((int) _fQuotient(j6, 1, 13));
            if (hasDay() && this._D > (i_maxDayInMonthFor = _maxDayInMonthFor(this._CY, this._M))) {
                this._D = i_maxDayInMonthFor;
            }
        }
        if (z7) {
            if (bigDecimal != null && bigDecimal.signum() != 0) {
                if (this._fs.signum() == 0 && i5 == 1) {
                    this._fs = bigDecimal;
                } else {
                    BigDecimal bigDecimal2 = this._fs;
                    this._fs = i5 == 1 ? bigDecimal2.add(bigDecimal) : bigDecimal2.subtract(bigDecimal);
                }
            }
            this._s = (i11 * i5) + this._s;
            this._m = (i10 * i5) + this._m;
            this._h = (i9 * i5) + this._h;
            j_normalizeTime = _normalizeTime();
        } else {
            j_normalizeTime = 0;
        }
        if (z6) {
            this._D = Math.addExact(this._D, Math.toIntExact(Math.addExact(Math.multiplyExact(i5, i8), j_normalizeTime)));
            _normalizeDate();
        }
    }

    public void addGDuration(GDurationSpecification gDurationSpecification) {
        addDuration(gDurationSpecification.getSign(), gDurationSpecification.getYear(), gDurationSpecification.getMonth(), gDurationSpecification.getDay(), gDurationSpecification.getHour(), gDurationSpecification.getMinute(), gDurationSpecification.getSecond(), gDurationSpecification.getFraction());
    }

    @Override // org.apache.xmlbeans.GDateSpecification
    public String canonicalString() {
        boolean z6 = hasTimeZone() && getTimeZoneSign() != 0 && hasTime() && hasDay() == hasMonth() && hasDay() == hasYear();
        if (!z6 && getFraction() != null && getFraction().scale() > 0) {
            z6 = getFraction().unscaledValue().mod(TEN).signum() == 0;
        }
        if (!z6) {
            return toString();
        }
        GDateBuilder gDateBuilder = new GDateBuilder(this);
        gDateBuilder.normalize();
        return gDateBuilder.toString();
    }

    public void clearDay() {
        this._bits &= -9;
        this._D = 0;
    }

    public void clearMonth() {
        this._bits &= -5;
        this._M = 0;
    }

    public void clearTime() {
        this._bits &= -17;
        this._h = 0;
        this._m = 0;
        this._s = 0;
        this._fs = null;
    }

    public void clearTimeZone() {
        this._bits &= -2;
        this._tzsign = 0;
        this._tzh = 0;
        this._tzm = 0;
    }

    public void clearYear() {
        this._bits &= -3;
        this._CY = 0;
    }

    public Object clone() {
        return new GDateBuilder(this);
    }

    @Override // org.apache.xmlbeans.GDateSpecification
    public final int compareToGDate(GDateSpecification gDateSpecification) {
        return compareGDate(this, gDateSpecification);
    }

    @Override // org.apache.xmlbeans.GDateSpecification
    public final int getBuiltinTypeCode() {
        return btcForFlags(this._bits);
    }

    @Override // org.apache.xmlbeans.GDateSpecification
    public XmlCalendar getCalendar() {
        return new XmlCalendar(this);
    }

    @Override // org.apache.xmlbeans.GDateSpecification
    public Date getDate() {
        return dateForGDate(this);
    }

    @Override // org.apache.xmlbeans.GDateSpecification
    public final int getDay() {
        return this._D;
    }

    @Override // org.apache.xmlbeans.GDateSpecification
    public int getFlags() {
        return this._bits;
    }

    @Override // org.apache.xmlbeans.GDateSpecification
    public final BigDecimal getFraction() {
        return this._fs;
    }

    @Override // org.apache.xmlbeans.GDateSpecification
    public final int getHour() {
        return this._h;
    }

    @Override // org.apache.xmlbeans.GDateSpecification
    public final int getJulianDate() {
        return julianDateForGDate(this);
    }

    @Override // org.apache.xmlbeans.GDateSpecification
    public final int getMillisecond() {
        BigDecimal bigDecimal = this._fs;
        if (bigDecimal == null || GDate._zero.equals(bigDecimal)) {
            return 0;
        }
        return this._fs.setScale(3, RoundingMode.HALF_UP).unscaledValue().intValue();
    }

    @Override // org.apache.xmlbeans.GDateSpecification
    public final int getMinute() {
        return this._m;
    }

    @Override // org.apache.xmlbeans.GDateSpecification
    public final int getMonth() {
        return this._M;
    }

    @Override // org.apache.xmlbeans.GDateSpecification
    public final int getSecond() {
        return this._s;
    }

    @Override // org.apache.xmlbeans.GDateSpecification
    public final int getTimeZoneHour() {
        return this._tzh;
    }

    @Override // org.apache.xmlbeans.GDateSpecification
    public final int getTimeZoneMinute() {
        return this._tzm;
    }

    @Override // org.apache.xmlbeans.GDateSpecification
    public final int getTimeZoneSign() {
        return this._tzsign;
    }

    @Override // org.apache.xmlbeans.GDateSpecification
    public final int getYear() {
        int i5 = this._CY;
        return i5 > 0 ? i5 : i5 - 1;
    }

    @Override // org.apache.xmlbeans.GDateSpecification
    public final boolean hasDate() {
        return (this._bits & 14) == 14;
    }

    @Override // org.apache.xmlbeans.GDateSpecification
    public final boolean hasDay() {
        return (this._bits & 8) != 0;
    }

    @Override // org.apache.xmlbeans.GDateSpecification
    public final boolean hasMonth() {
        return (this._bits & 4) != 0;
    }

    @Override // org.apache.xmlbeans.GDateSpecification
    public final boolean hasTime() {
        return (this._bits & 16) != 0;
    }

    @Override // org.apache.xmlbeans.GDateSpecification
    public final boolean hasTimeZone() {
        return (this._bits & 1) != 0;
    }

    @Override // org.apache.xmlbeans.GDateSpecification
    public final boolean hasYear() {
        return (this._bits & 2) != 0;
    }

    @Override // org.apache.xmlbeans.GDateSpecification
    public boolean isImmutable() {
        return false;
    }

    @Override // org.apache.xmlbeans.GDateSpecification
    public boolean isValid() {
        return isValidGDate(this);
    }

    public void normalize() {
        BigDecimal bigDecimal;
        if (hasDay() == hasMonth() && hasDay() == hasYear() && hasTimeZone() && hasTime()) {
            normalizeToTimeZone(0, 0, 0);
        } else {
            _normalizeTimeAndDate();
        }
        if (!hasTime() || (bigDecimal = this._fs) == null || bigDecimal.scale() <= 0) {
            return;
        }
        if (this._fs.signum() == 0) {
            this._fs = GDate._zero;
            return;
        }
        String string = this._fs.unscaledValue().toString();
        int length = string.length();
        while (length > 0 && string.charAt(length - 1) == '0') {
            length--;
        }
        if (length < string.length()) {
            BigDecimal bigDecimal2 = this._fs;
            this._fs = bigDecimal2.setScale((bigDecimal2.scale() - string.length()) + length, RoundingMode.UNNECESSARY);
        }
    }

    public void normalize24h() {
        if (hasTime() && getHour() == 24) {
            _normalizeTimeAndDate();
        }
    }

    public void normalizeToTimeZone(int i5, int i6, int i7) {
        if (!(i5 == 0 && i6 == 0 && i7 == 0) && (!(i5 == -1 || i5 == 1) || i6 < 0 || i7 < 0 || (!(i6 == 14 && i7 == 0) && (i6 >= 14 || i7 >= 60)))) {
            throw new IllegalArgumentException("time zone must be between -14:00 and +14:00");
        }
        if (!hasTimeZone() || !hasTime()) {
            throw new IllegalStateException("cannot normalize time zone without both time and timezone");
        }
        if (hasDay() != hasMonth() || hasDay() != hasYear()) {
            throw new IllegalStateException("cannot do date math without a complete date");
        }
        int i8 = this._tzsign;
        int i9 = (i5 * i6) - (this._tzh * i8);
        int i10 = (i5 * i7) - (i8 * this._tzm);
        this._tzsign = i5;
        this._tzh = i6;
        this._tzm = i7;
        addDuration(1, 0, 0, 0, i9, i10, 0, null);
    }

    public void setBuiltinTypeCode(int i5) {
        switch (i5) {
            case 14:
                return;
            case 15:
                clearYear();
                clearMonth();
                clearDay();
                return;
            case 16:
                clearTime();
                return;
            case 17:
                clearDay();
                clearTime();
                return;
            case 18:
                clearMonth();
                clearDay();
                clearTime();
                return;
            case 19:
                clearYear();
                clearTime();
                return;
            case 20:
                clearYear();
                clearMonth();
                clearTime();
                return;
            case 21:
                clearYear();
                clearDay();
                clearTime();
                return;
            default:
                throw new IllegalArgumentException("codeType must be one of SchemaType BTC_  DATE TIME related types.");
        }
    }

    public void setDate(Date date) {
        int i5;
        int offset = TimeZone.getDefault().getOffset(date.getTime());
        if (offset < 0) {
            offset = -offset;
            i5 = -1;
        } else {
            i5 = 1;
        }
        int i6 = offset / Angles.OOXML_DEGREE;
        int i7 = i6 / 60;
        int i8 = i7 * 60;
        int i9 = i6 - i8;
        setTimeZone(i5, i7, i9);
        int i10 = (i9 + i8) * i5 * Angles.OOXML_DEGREE;
        BigDecimal bigDecimal = GDate._zero;
        setTime(0, 0, 0, bigDecimal);
        this._bits |= 14;
        this._CY = 1970;
        this._M = 1;
        this._D = 1;
        addGDuration(new GDuration(1, 0, 0, 0, 0, 0, 0, BigDecimal.valueOf(date.getTime() + ((long) i10), 3)));
        if (this._fs.signum() == 0) {
            this._fs = bigDecimal;
        }
    }

    public void setDay(int i5) {
        if (i5 < 1 || i5 > 31) {
            throw new IllegalArgumentException("day out of range");
        }
        this._bits |= 8;
        this._D = i5;
    }

    public void setGDate(GDateSpecification gDateSpecification) {
        this._bits = gDateSpecification.getFlags() & 31;
        int year = gDateSpecification.getYear();
        if (year <= 0) {
            year++;
        }
        this._CY = year;
        this._M = gDateSpecification.getMonth();
        this._D = gDateSpecification.getDay();
        this._h = gDateSpecification.getHour();
        this._m = gDateSpecification.getMinute();
        this._s = gDateSpecification.getSecond();
        this._fs = gDateSpecification.getFraction();
        this._tzsign = gDateSpecification.getTimeZoneSign();
        this._tzh = gDateSpecification.getTimeZoneHour();
        this._tzm = gDateSpecification.getTimeZoneMinute();
    }

    public void setJulianDate(int i5) {
        if (i5 < 0) {
            throw new IllegalArgumentException("date before year -4713");
        }
        int i6 = i5 + 68569;
        int i7 = (i6 * 4) / 146097;
        int i8 = i6 - (((146097 * i7) + 3) / 4);
        int i9 = ((i8 + 1) * 4000) / 1461001;
        int i10 = (i8 - ((i9 * 1461) / 4)) + 31;
        int i11 = (i10 * 80) / 2447;
        this._D = i10 - ((i11 * 2447) / 80);
        int i12 = i11 / 11;
        this._M = (i11 + 2) - (i12 * 12);
        this._CY = ((i7 - 49) * 100) + i9 + i12;
        this._bits |= 14;
    }

    public void setMonth(int i5) {
        if (i5 < 1 || i5 > 12) {
            throw new IllegalArgumentException("month out of range");
        }
        this._bits |= 4;
        this._M = i5;
    }

    public void setTime(int i5, int i6, int i7, BigDecimal bigDecimal) {
        if (i5 < 0 || i5 > 24) {
            throw new IllegalArgumentException("hour out of range");
        }
        if (i6 < 0 || i6 > 59) {
            throw new IllegalArgumentException("minute out of range");
        }
        if (i7 < 0 || i7 > 59) {
            throw new IllegalArgumentException("second out of range");
        }
        if (bigDecimal != null && (bigDecimal.signum() < 0 || GDate._one.compareTo(bigDecimal) <= 0)) {
            throw new IllegalArgumentException("fraction out of range");
        }
        if (i5 == 24 && (i6 != 0 || i7 != 0 || (bigDecimal != null && GDate._zero.compareTo(bigDecimal) != 0))) {
            throw new IllegalArgumentException("when hour is 24, min sec and fracton must be 0");
        }
        this._bits |= 16;
        this._h = i5;
        this._m = i6;
        this._s = i7;
        if (bigDecimal == null) {
            bigDecimal = GDate._zero;
        }
        this._fs = bigDecimal;
    }

    public void setTimeZone(int i5, int i6, int i7) {
        if ((i5 == 0 && i6 == 0 && i7 == 0) || ((i5 == -1 || i5 == 1) && i6 >= 0 && i7 >= 0 && ((i6 == 14 && i7 == 0) || (i6 < 14 && i7 < 60)))) {
            this._bits = 1 | this._bits;
            this._tzsign = i5;
            this._tzh = i6;
            this._tzm = i7;
            return;
        }
        StringBuilder sb = new StringBuilder("time zone out of range (-14:00 to +14:00). (");
        sb.append(i5 < 0 ? ProcessIdUtil.DEFAULT_PROCESSID : "+");
        sb.append(i6);
        sb.append(ParameterizedMessage.ERROR_MSG_SEPARATOR);
        sb.append(i7);
        sb.append(")");
        throw new IllegalArgumentException(sb.toString());
    }

    public void setYear(int i5) {
        if (i5 < -292275295 || i5 > 292277265) {
            throw new IllegalArgumentException("year out of range");
        }
        if (i5 == 0) {
            throw new IllegalArgumentException("year cannot be 0");
        }
        this._bits |= 2;
        if (i5 <= 0) {
            i5++;
        }
        this._CY = i5;
    }

    public void subtractGDuration(GDurationSpecification gDurationSpecification) {
        addDuration(-gDurationSpecification.getSign(), gDurationSpecification.getYear(), gDurationSpecification.getMonth(), gDurationSpecification.getDay(), gDurationSpecification.getHour(), gDurationSpecification.getMinute(), gDurationSpecification.getSecond(), gDurationSpecification.getFraction());
    }

    public GDate toGDate() {
        return new GDate(this);
    }

    @Override // org.apache.xmlbeans.GDateSpecification
    public final String toString() {
        return GDate.formatGDate(this);
    }

    public GDateBuilder(GDateSpecification gDateSpecification) {
        if (gDateSpecification.hasTimeZone()) {
            setTimeZone(gDateSpecification.getTimeZoneSign(), gDateSpecification.getTimeZoneHour(), gDateSpecification.getTimeZoneMinute());
        }
        if (gDateSpecification.hasTime()) {
            setTime(gDateSpecification.getHour(), gDateSpecification.getMinute(), gDateSpecification.getSecond(), gDateSpecification.getFraction());
        }
        if (gDateSpecification.hasDay()) {
            setDay(gDateSpecification.getDay());
        }
        if (gDateSpecification.hasMonth()) {
            setMonth(gDateSpecification.getMonth());
        }
        if (gDateSpecification.hasYear()) {
            setYear(gDateSpecification.getYear());
        }
    }

    private static long _fQuotient(long j6, int i5, int i6) {
        return _fQuotient(j6 - ((long) i5), i6 - i5);
    }

    public void setTimeZone(int i5) {
        if (i5 >= -840 && i5 <= 840) {
            int iCompare = Integer.compare(i5, 0);
            int i6 = i5 * iCompare;
            int i7 = i6 / 60;
            setTimeZone(iCompare, i7, i6 - (i7 * 60));
            return;
        }
        throw new IllegalArgumentException(a.i(i5, "time zone out of range (-840 to 840 minutes). (", ")"));
    }

    public void normalizeToTimeZone(int i5) {
        if (i5 >= -840 && i5 <= 840) {
            int iCompare = Integer.compare(i5, 0);
            int i6 = i5 * iCompare;
            int i7 = i6 / 60;
            normalizeToTimeZone(iCompare, i7, i6 - (i7 * 60));
            return;
        }
        throw new IllegalArgumentException(a.i(i5, "time zone out of range (-840 to 840 minutes). (", ")"));
    }

    public GDateBuilder(CharSequence charSequence) {
        this(new GDate(charSequence));
    }

    public GDateBuilder(Calendar calendar) {
        this(new GDate(calendar));
    }

    public GDateBuilder(int i5, int i6, int i7, int i8, int i9, int i10, BigDecimal bigDecimal) {
        this._bits = 30;
        if (i5 != 0) {
            this._CY = i5 <= 0 ? i5 + 1 : i5;
            this._M = i6;
            this._D = i7;
            this._h = i8;
            this._m = i9;
            this._s = i10;
            this._fs = bigDecimal == null ? GDate._zero : bigDecimal;
            if (!isValid()) {
                throw new IllegalArgumentException();
            }
            return;
        }
        throw new IllegalArgumentException();
    }

    public GDateBuilder(int i5, int i6, int i7, int i8, int i9, int i10, BigDecimal bigDecimal, int i11, int i12, int i13) {
        this._bits = 31;
        if (i5 != 0) {
            this._CY = i5 <= 0 ? i5 + 1 : i5;
            this._M = i6;
            this._D = i7;
            this._h = i8;
            this._m = i9;
            this._s = i10;
            this._fs = bigDecimal == null ? GDate._zero : bigDecimal;
            this._tzsign = i11;
            this._tzh = i12;
            this._tzm = i13;
            if (!isValid()) {
                throw new IllegalArgumentException();
            }
            return;
        }
        throw new IllegalArgumentException();
    }

    public GDateBuilder(Date date) {
        setDate(date);
    }
}
