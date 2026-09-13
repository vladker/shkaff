package org.apache.xmlbeans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class GDurationBuilder implements GDurationSpecification, Serializable {
    private static final GDate[] _compDate = {new GDate(1696, 9, 1, 0, 0, 0, null, 0, 0, 0), new GDate(1697, 2, 1, 0, 0, 0, null, 0, 0, 0), new GDate(1903, 3, 1, 0, 0, 0, null, 0, 0, 0), new GDate(1903, 7, 1, 0, 0, 0, null, 0, 0, 0)};
    private static final long serialVersionUID = 1;
    private int _CY;
    private int _D;
    private int _M;
    private BigDecimal _fs;
    private int _h;
    private int _m;
    private int _s;
    private int _sign;

    public GDurationBuilder() {
        this._sign = 1;
        this._fs = GDate._zero;
    }

    private void _add(GDurationSpecification gDurationSpecification, int i5) {
        this._CY = (gDurationSpecification.getYear() * i5) + this._CY;
        this._M = (gDurationSpecification.getMonth() * i5) + this._M;
        this._D = (gDurationSpecification.getDay() * i5) + this._D;
        this._h = (gDurationSpecification.getHour() * i5) + this._h;
        this._m = (gDurationSpecification.getMinute() * i5) + this._m;
        this._s = (gDurationSpecification.getSecond() * i5) + this._s;
        if (gDurationSpecification.getFraction().signum() == 0) {
            return;
        }
        if (this._fs.signum() == 0 && i5 == 1) {
            this._fs = gDurationSpecification.getFraction();
        } else {
            this._fs = i5 > 0 ? this._fs.add(gDurationSpecification.getFraction()) : this._fs.subtract(gDurationSpecification.getFraction());
        }
    }

    private static long _fQuotient(long j6, int i5) {
        if ((j6 < 0) == (i5 < 0)) {
            return j6 / ((long) i5);
        }
        long j7 = i5;
        return -(((j7 - j6) - 1) / j7);
    }

    private int _getTotalSignSlowly() {
        GDateBuilder gDateBuilder = new GDateBuilder();
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        for (GDate gDate : _compDate) {
            gDateBuilder.setGDate(gDate);
            gDateBuilder.addGDuration(this);
            int iCompareToGDate = gDateBuilder.compareToGDate(gDate);
            if (iCompareToGDate == -1) {
                i6++;
            } else if (iCompareToGDate == 0) {
                i7++;
            } else if (iCompareToGDate == 1) {
                i5++;
            }
        }
        GDate[] gDateArr = _compDate;
        if (i5 == gDateArr.length) {
            return 1;
        }
        if (i6 == gDateArr.length) {
            return -1;
        }
        return i7 == gDateArr.length ? 0 : 2;
    }

    private static int _mod(long j6, int i5, long j7) {
        return (int) (j6 - (j7 * ((long) i5)));
    }

    private void _normalizeImpl(boolean z6) {
        long jIntValue;
        int i5;
        BigDecimal bigDecimal;
        int i6;
        int i7;
        int i8;
        int i9 = this._M;
        if (i9 < 0 || i9 > 11) {
            long j6 = i9;
            long j_fQuotient = _fQuotient(j6, 12);
            this._M = _mod(j6, 12, j_fQuotient);
            this._CY = Math.addExact(this._CY, Math.toIntExact(j_fQuotient));
        }
        BigDecimal bigDecimal2 = this._fs;
        if (bigDecimal2 == null || (bigDecimal2.signum() >= 0 && this._fs.compareTo(GDate._one) < 0)) {
            jIntValue = 0;
        } else {
            BigDecimal scale = this._fs.setScale(0, RoundingMode.FLOOR);
            this._fs = this._fs.subtract(scale);
            jIntValue = scale.intValue();
        }
        if (jIntValue != 0 || (i6 = this._s) < 0 || i6 > 59 || (i7 = this._m) < 0 || i7 > 50 || (i8 = this._h) < 0 || i8 > 23) {
            long j7 = ((long) this._s) + jIntValue;
            long j_fQuotient2 = _fQuotient(j7, 60);
            this._s = _mod(j7, 60, j_fQuotient2);
            long j8 = ((long) this._m) + j_fQuotient2;
            long j_fQuotient3 = _fQuotient(j8, 60);
            this._m = _mod(j8, 60, j_fQuotient3);
            long j9 = ((long) this._h) + j_fQuotient3;
            long j_fQuotient4 = _fQuotient(j9, 24);
            this._h = _mod(j9, 24, j_fQuotient4);
            this._D = Math.addExact(this._D, Math.toIntExact(j_fQuotient4));
        }
        if (this._CY == 0 && this._M == 0 && this._D == 0 && this._h == 0 && this._m == 0 && this._s == 0 && ((bigDecimal = this._fs) == null || bigDecimal.signum() == 0)) {
            this._sign = 1;
        }
        if (z6) {
            int i10 = this._D;
            if (i10 < 0 || this._CY < 0) {
                int i_getTotalSignSlowly = (i10 > 0 || ((i5 = this._CY) >= 0 && !(i5 == 0 && this._M == 0))) ? _getTotalSignSlowly() : -this._sign;
                if (i_getTotalSignSlowly == 2) {
                    i_getTotalSignSlowly = this._CY < 0 ? -this._sign : this._sign;
                }
                int i11 = i_getTotalSignSlowly != 0 ? i_getTotalSignSlowly : 1;
                if (i11 != this._sign) {
                    this._sign = i11;
                    this._CY = -this._CY;
                    this._M = -this._M;
                    this._D = -this._D;
                    this._h = -this._h;
                    this._m = -this._m;
                    this._s = -this._s;
                    BigDecimal bigDecimal3 = this._fs;
                    if (bigDecimal3 != null) {
                        this._fs = bigDecimal3.negate();
                    }
                }
                _normalizeImpl(false);
            }
        }
    }

    public static int compareDurations(GDurationSpecification gDurationSpecification, GDurationSpecification gDurationSpecification2) {
        if (gDurationSpecification.getFraction().signum() == 0 && gDurationSpecification2.getFraction().signum() == 0) {
            int sign = gDurationSpecification.getSign();
            int sign2 = gDurationSpecification2.getSign();
            long j6 = sign;
            long year = ((((long) gDurationSpecification.getYear()) * 12) + ((long) gDurationSpecification.getMonth())) * j6;
            long j7 = sign2;
            long year2 = ((((long) gDurationSpecification2.getYear()) * 12) + ((long) gDurationSpecification2.getMonth())) * j7;
            long day = ((((((((long) gDurationSpecification.getDay()) * 24) + ((long) gDurationSpecification.getHour())) * 60) + ((long) gDurationSpecification.getMinute())) * 60) + ((long) gDurationSpecification.getSecond())) * j6;
            long day2 = ((((((((long) gDurationSpecification2.getDay()) * 24) + ((long) gDurationSpecification2.getHour())) * 60) + ((long) gDurationSpecification2.getMinute())) * 60) + ((long) gDurationSpecification2.getSecond())) * j7;
            if (year == year2) {
                if (day == day2) {
                    return 0;
                }
                return day < day2 ? -1 : 1;
            }
            if (year < year2 && day - day2 < 2419200) {
                return -1;
            }
            if (year > year2 && day2 - day < 2419200) {
                return 1;
            }
        }
        GDurationBuilder gDurationBuilder = new GDurationBuilder(gDurationSpecification);
        gDurationBuilder.subtractGDuration(gDurationSpecification2);
        return gDurationBuilder._getTotalSignSlowly();
    }

    public static String formatDuration(GDurationSpecification gDurationSpecification) {
        StringBuilder sb = new StringBuilder(30);
        if (gDurationSpecification.getSign() < 0) {
            sb.append('-');
        }
        sb.append('P');
        if (gDurationSpecification.getYear() != 0) {
            sb.append(gDurationSpecification.getYear());
            sb.append('Y');
        }
        if (gDurationSpecification.getMonth() != 0) {
            sb.append(gDurationSpecification.getMonth());
            sb.append('M');
        }
        if (gDurationSpecification.getDay() != 0) {
            sb.append(gDurationSpecification.getDay());
            sb.append('D');
        }
        if (gDurationSpecification.getHour() != 0 || gDurationSpecification.getMinute() != 0 || gDurationSpecification.getSecond() != 0 || gDurationSpecification.getFraction().signum() != 0) {
            sb.append('T');
        }
        if (gDurationSpecification.getHour() != 0) {
            sb.append(gDurationSpecification.getHour());
            sb.append('H');
        }
        if (gDurationSpecification.getMinute() != 0) {
            sb.append(gDurationSpecification.getMinute());
            sb.append('M');
        }
        if (gDurationSpecification.getFraction().signum() != 0) {
            BigDecimal fraction = gDurationSpecification.getFraction();
            if (gDurationSpecification.getSecond() != 0) {
                fraction = fraction.add(BigDecimal.valueOf(gDurationSpecification.getSecond()));
            }
            sb.append(stripTrailingZeros(toPlainString(fraction)));
            sb.append('S');
        } else if (gDurationSpecification.getSecond() != 0) {
            sb.append(gDurationSpecification.getSecond());
            sb.append('S');
        } else if (sb.length() <= 2) {
            sb.append("T0S");
        }
        return sb.toString();
    }

    public static boolean isValidDuration(GDurationSpecification gDurationSpecification) {
        return (gDurationSpecification.getSign() == 1 || gDurationSpecification.getSign() == -1) && gDurationSpecification.getYear() >= 0 && gDurationSpecification.getMonth() >= 0 && gDurationSpecification.getDay() >= 0 && gDurationSpecification.getHour() >= 0 && gDurationSpecification.getMinute() >= 0 && gDurationSpecification.getSecond() >= 0 && gDurationSpecification.getFraction().signum() >= 0;
    }

    public static String stripTrailingZeros(String str) {
        int length = str.length() - 1;
        int i5 = length;
        while (length >= 0 && str.charAt(length) == '0') {
            length--;
            i5--;
        }
        while (length >= 0 && str.charAt(length) != 'E') {
            if (str.charAt(length) == '.') {
                return str.substring(0, i5 + 1);
            }
            length--;
        }
        return str;
    }

    public static String toPlainString(BigDecimal bigDecimal) {
        BigInteger bigIntegerUnscaledValue = bigDecimal.unscaledValue();
        int iScale = bigDecimal.scale();
        String string = bigIntegerUnscaledValue.toString();
        if (iScale == 0) {
            return string;
        }
        int i5 = string.charAt(0) == '-' ? 1 : 0;
        int length = (string.length() - iScale) - i5;
        StringBuilder sb = new StringBuilder(string.length() + 2 + (length <= 0 ? (-length) + 1 : 0));
        if (length <= 0) {
            if (i5 != 0) {
                sb.append('-');
            }
            sb.append("0.");
            while (length < 0) {
                sb.append('0');
                length++;
            }
            sb.append(string.substring(i5));
        } else if (length < string.length()) {
            sb.append(string);
            sb.insert(length + i5, '.');
        } else {
            sb.append(string);
            if (!bigIntegerUnscaledValue.equals(BigInteger.ZERO)) {
                for (int length2 = string.length(); length2 < length; length2++) {
                    sb.append('0');
                }
            }
        }
        return sb.toString();
    }

    public void addGDuration(GDurationSpecification gDurationSpecification) {
        _add(gDurationSpecification, gDurationSpecification.getSign() * this._sign);
    }

    public Object clone() {
        return new GDurationBuilder(this);
    }

    @Override // org.apache.xmlbeans.GDurationSpecification
    public final int compareToGDuration(GDurationSpecification gDurationSpecification) {
        return compareDurations(this, gDurationSpecification);
    }

    @Override // org.apache.xmlbeans.GDurationSpecification
    public final int getDay() {
        return this._D;
    }

    @Override // org.apache.xmlbeans.GDurationSpecification
    public BigDecimal getFraction() {
        return this._fs;
    }

    @Override // org.apache.xmlbeans.GDurationSpecification
    public final int getHour() {
        return this._h;
    }

    @Override // org.apache.xmlbeans.GDurationSpecification
    public final int getMinute() {
        return this._m;
    }

    @Override // org.apache.xmlbeans.GDurationSpecification
    public final int getMonth() {
        return this._M;
    }

    @Override // org.apache.xmlbeans.GDurationSpecification
    public final int getSecond() {
        return this._s;
    }

    @Override // org.apache.xmlbeans.GDurationSpecification
    public final int getSign() {
        return this._sign;
    }

    @Override // org.apache.xmlbeans.GDurationSpecification
    public final int getYear() {
        return this._CY;
    }

    @Override // org.apache.xmlbeans.GDurationSpecification
    public final boolean isImmutable() {
        return true;
    }

    @Override // org.apache.xmlbeans.GDurationSpecification
    public boolean isValid() {
        return isValidDuration(this);
    }

    public void normalize() {
        _normalizeImpl(true);
    }

    public void setDay(int i5) {
        this._D = i5;
    }

    public void setFraction(BigDecimal bigDecimal) {
        if (bigDecimal == null) {
            bigDecimal = GDate._zero;
        }
        this._fs = bigDecimal;
    }

    public void setHour(int i5) {
        this._h = i5;
    }

    public void setMinute(int i5) {
        this._m = i5;
    }

    public void setMonth(int i5) {
        this._M = i5;
    }

    public void setSecond(int i5) {
        this._s = i5;
    }

    public final void setSign(int i5) {
        if (i5 != 1 && i5 != -1) {
            throw new IllegalArgumentException();
        }
        this._sign = i5;
    }

    public void setYear(int i5) {
        this._CY = i5;
    }

    public void subtractGDuration(GDurationSpecification gDurationSpecification) {
        _add(gDurationSpecification, gDurationSpecification.getSign() * (-this._sign));
    }

    public GDuration toGDuration() {
        return new GDuration(this);
    }

    public String toString() {
        return formatDuration(this);
    }

    public GDurationBuilder(String str) {
        this(new GDuration(str));
    }

    public GDurationBuilder(int i5, int i6, int i7, int i8, int i9, int i10, int i11, BigDecimal bigDecimal) {
        if (i5 != 1 && i5 != -1) {
            throw new IllegalArgumentException();
        }
        this._sign = i5;
        this._CY = i6;
        this._M = i7;
        this._D = i8;
        this._h = i9;
        this._m = i10;
        this._s = i11;
        this._fs = bigDecimal == null ? GDate._zero : bigDecimal;
    }

    public GDurationBuilder(GDurationSpecification gDurationSpecification) {
        this._sign = gDurationSpecification.getSign();
        this._CY = gDurationSpecification.getYear();
        this._M = gDurationSpecification.getMonth();
        this._D = gDurationSpecification.getDay();
        this._h = gDurationSpecification.getHour();
        this._m = gDurationSpecification.getMinute();
        this._s = gDurationSpecification.getSecond();
        this._fs = gDurationSpecification.getFraction();
    }
}
