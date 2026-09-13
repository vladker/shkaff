package org.apache.xmlbeans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import org.apache.poi.xddf.usermodel.Angles;
import org.apache.xmlbeans.impl.common.NameUtil;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final class GDate implements GDateSpecification, Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final int MAX_YEAR = 292277265;
    static final int MIN_YEAR = -292275295;
    private static final long serialVersionUID = 1;
    private int _CY;
    private int _D;
    private int _M;
    private int _bits;
    private transient String _canonicalString;
    private BigDecimal _fs;
    private int _h;
    private int _m;
    private int _s;
    private transient String _string;
    private int _tzh;
    private int _tzm;
    private int _tzsign;
    static final BigDecimal _zero = BigDecimal.ZERO;
    static final BigDecimal _one = BigDecimal.ONE;
    private static final char[] _tensDigit = {'0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '4', '4', '4', '4', '4', '4', '4', '4', '4', '4', '5', '5', '5', '5', '5', '5', '5', '5', '5', '5', '6', '6', '6', '6', '6', '6', '6', '6', '6', '6', '7', '7', '7', '7', '7', '7', '7', '7', '7', '7', '8', '8', '8', '8', '8', '8', '8', '8', '8', '8', '9', '9', '9', '9', '9', '9', '9', '9', '9', '9'};
    private static final char[] _onesDigit = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    private static final TimeZone GMTZONE = TimeZone.getTimeZone("GMT");
    private static final TimeZone[] MINUSZONE = {TimeZone.getTimeZone("GMT-00:00"), TimeZone.getTimeZone("GMT-01:00"), TimeZone.getTimeZone("GMT-02:00"), TimeZone.getTimeZone("GMT-03:00"), TimeZone.getTimeZone("GMT-04:00"), TimeZone.getTimeZone("GMT-05:00"), TimeZone.getTimeZone("GMT-06:00"), TimeZone.getTimeZone("GMT-07:00"), TimeZone.getTimeZone("GMT-08:00"), TimeZone.getTimeZone("GMT-09:00"), TimeZone.getTimeZone("GMT-10:00"), TimeZone.getTimeZone("GMT-11:00"), TimeZone.getTimeZone("GMT-12:00"), TimeZone.getTimeZone("GMT-13:00"), TimeZone.getTimeZone("GMT-14:00")};
    private static final TimeZone[] PLUSZONE = {TimeZone.getTimeZone("GMT+00:00"), TimeZone.getTimeZone("GMT+01:00"), TimeZone.getTimeZone("GMT+02:00"), TimeZone.getTimeZone("GMT+03:00"), TimeZone.getTimeZone("GMT+04:00"), TimeZone.getTimeZone("GMT+05:00"), TimeZone.getTimeZone("GMT+06:00"), TimeZone.getTimeZone("GMT+07:00"), TimeZone.getTimeZone("GMT+08:00"), TimeZone.getTimeZone("GMT+09:00"), TimeZone.getTimeZone("GMT+10:00"), TimeZone.getTimeZone("GMT+11:00"), TimeZone.getTimeZone("GMT+12:00"), TimeZone.getTimeZone("GMT+13:00"), TimeZone.getTimeZone("GMT+14:00")};

    public GDate(CharSequence charSequence) {
        int i5;
        int i6;
        boolean z6;
        int iTwoDigit;
        int iTwoDigit2;
        int length = charSequence.length();
        while (length > 0 && isSpace(charSequence.charAt(length - 1))) {
            length--;
        }
        int i7 = 0;
        while (i7 < length && isSpace(charSequence.charAt(i7))) {
            i7++;
        }
        int i8 = length - i7;
        if (i8 >= 1 && charSequence.charAt(length - 1) == 'Z') {
            this._bits |= 1;
            length--;
        } else if (i8 >= 6 && charSequence.charAt(length - 3) == ':') {
            char cCharAt = charSequence.charAt(length - 6);
            if (cCharAt != '+') {
                i5 = cCharAt == '-' ? -1 : i5;
            } else {
                i5 = 1;
            }
            int iTwoDigit3 = twoDigit(charSequence, length - 5);
            int iTwoDigit4 = twoDigit(charSequence, length - 2);
            if (iTwoDigit3 > 14) {
                throw new IllegalArgumentException("time zone hour must be two digits between -14 and +14");
            }
            if (iTwoDigit4 > 59) {
                throw new IllegalArgumentException("time zone minute must be two digits between 00 and 59");
            }
            this._bits |= 1;
            this._tzsign = i5;
            this._tzh = iTwoDigit3;
            this._tzm = iTwoDigit4;
            length -= 6;
        }
        if (i7 < length && ((i6 = i7 + 2) >= length || charSequence.charAt(i6) != ':')) {
            if (charSequence.charAt(i7) == '-') {
                i7++;
                z6 = true;
            } else {
                z6 = false;
            }
            int i9 = -i7;
            boolean z7 = i7 < length && digitVal(charSequence.charAt(i7)) == 0;
            int iDigitVal = 0;
            while (true) {
                char cCharAt2 = i7 < length ? charSequence.charAt(i7) : (char) 0;
                if (!isDigit(cCharAt2)) {
                    int i10 = i9 + i7;
                    if (i10 > 9) {
                        throw new IllegalArgumentException("year too long (up to 9 digits)");
                    }
                    if (i10 >= 4) {
                        this._bits |= 2;
                        iDigitVal = z6 ? -iDigitVal : iDigitVal;
                        this._CY = iDigitVal;
                        if (iDigitVal == 0) {
                            throw new IllegalArgumentException("year must not be zero");
                        }
                    } else if (i10 > 0) {
                        throw new IllegalArgumentException("year must be four digits (may pad with zeroes, e.g., 0560)");
                    }
                    int i11 = this._CY;
                    if (i11 > MAX_YEAR) {
                        throw new IllegalArgumentException("year value not supported: too big, must be less than 292277265");
                    }
                    if (i11 < MIN_YEAR) {
                        throw new IllegalArgumentException("year values not supported: too small, must be bigger than -292275295");
                    }
                    if (cCharAt2 == '-') {
                        int i12 = i7 + 1;
                        if (length - i12 < 2 || (iTwoDigit2 = twoDigit(charSequence, i12)) < 1 || iTwoDigit2 > 12) {
                            i7 = i12;
                        } else {
                            this._bits |= 4;
                            this._M = iTwoDigit2;
                            i7 += 3;
                        }
                        if ((i7 < length ? charSequence.charAt(i7) : (char) 0) == '-') {
                            int i13 = i7 + 1;
                            if (length - i13 < 2 || (iTwoDigit = twoDigit(charSequence, i13)) < 1 || iTwoDigit > 31) {
                                i7 = i13;
                            } else {
                                this._bits |= 8;
                                this._D = iTwoDigit;
                                i7 += 3;
                            }
                            if (hasDay()) {
                                break;
                            }
                            if (hasMonth() && !hasYear()) {
                                if ((i7 < length ? charSequence.charAt(i7) : (char) 0) == '-') {
                                    i7++;
                                    break;
                                }
                            }
                            throw new IllegalArgumentException();
                        }
                        if (!hasMonth()) {
                            throw new IllegalArgumentException();
                        }
                        break;
                    }
                    if (!z6 || hasYear()) {
                        break;
                        break;
                    }
                    throw new IllegalArgumentException();
                }
                if (z7 && i7 + i9 >= 4) {
                    throw new IllegalArgumentException("year value starting with zero must be 4 or less digits: " + ((Object) charSequence));
                }
                iDigitVal = (iDigitVal * 10) + digitVal(cCharAt2);
                i7++;
            }
        }
        if (i7 < length) {
            if (hasYear() || hasMonth() || hasDay()) {
                if (charSequence.charAt(i7) != 'T') {
                    throw new IllegalArgumentException("date and time must be separated by 'T'");
                }
                i7++;
            }
            int i14 = i7 + 8;
            if (length < i14 || charSequence.charAt(i7 + 2) != ':' || charSequence.charAt(i7 + 5) != ':') {
                throw new IllegalArgumentException();
            }
            int iTwoDigit5 = twoDigit(charSequence, i7);
            if (iTwoDigit5 > 24) {
                throw new IllegalArgumentException("hour must be between 00 and 23");
            }
            int iTwoDigit6 = twoDigit(charSequence, i7 + 3);
            if (iTwoDigit6 >= 60) {
                throw new IllegalArgumentException("minute must be between 00 and 59");
            }
            int iTwoDigit7 = twoDigit(charSequence, i7 + 6);
            if (iTwoDigit7 >= 60) {
                throw new IllegalArgumentException("second must be between 00 and 59");
            }
            BigDecimal bigDecimal = _zero;
            if (i14 < length) {
                if (charSequence.charAt(i14) != '.') {
                    throw new IllegalArgumentException();
                }
                int i15 = i7 + 9;
                if (i15 < length) {
                    while (i15 < length) {
                        if (!isDigit(charSequence.charAt(i15))) {
                            throw new IllegalArgumentException();
                        }
                        i15++;
                    }
                    try {
                        bigDecimal = new BigDecimal(charSequence.subSequence(i14, length).toString());
                    } catch (Throwable unused) {
                        throw new IllegalArgumentException();
                    }
                }
            }
            this._bits |= 16;
            this._h = iTwoDigit5;
            this._m = iTwoDigit6;
            this._s = iTwoDigit7;
            this._fs = bigDecimal;
        }
        if (hasTime() && this._h == 24) {
            if (this._m != 0 || this._s != 0 || this._fs.compareTo(_zero) != 0) {
                throw new IllegalArgumentException("if hour is 24, minutes, seconds and fraction must be 0");
            }
            if (hasDate()) {
                GDateBuilder gDateBuilder = new GDateBuilder(this._CY, this._M, this._D, this._h, this._m, this._s, this._fs, this._tzsign, this._tzh, this._tzm);
                gDateBuilder.normalize24h();
                this._D = gDateBuilder.getDay();
                this._M = gDateBuilder.getMonth();
                this._CY = gDateBuilder.getYear();
                this._h = 0;
            } else if (hasDay()) {
                this._D++;
                this._h = 0;
            }
        }
        if (!isValid()) {
            throw new IllegalArgumentException("invalid date");
        }
    }

    private static int _padFourAppend(char[] cArr, int i5) {
        int i6;
        if (i5 < 0) {
            cArr[0] = '-';
            i5 = -i5;
            i6 = 1;
        } else {
            i6 = 0;
        }
        if (i5 >= 10000) {
            String string = Integer.toString(i5);
            string.getChars(0, string.length(), cArr, i6);
            return string.length() + i6;
        }
        int i7 = i5 / 100;
        int i8 = i5 - (i7 * 100);
        char[] cArr2 = _tensDigit;
        cArr[i6] = cArr2[i7];
        char[] cArr3 = _onesDigit;
        cArr[i6 + 1] = cArr3[i7];
        cArr[i6 + 2] = cArr2[i8];
        cArr[i6 + 3] = cArr3[i8];
        return i6 + 4;
    }

    private static int _padTwoAppend(char[] cArr, int i5, int i6) {
        cArr[i5] = _tensDigit[i6];
        cArr[i5 + 1] = _onesDigit[i6];
        return i5 + 2;
    }

    public static int digitVal(char c) {
        return c - '0';
    }

    private void ensureCanonicalString() {
        if (this._canonicalString != null) {
            return;
        }
        boolean z6 = hasTimeZone() && getTimeZoneSign() != 0 && hasTime() && hasDay() == hasMonth() && hasDay() == hasYear();
        if (!z6 && getFraction() != null && getFraction().scale() > 0) {
            z6 = getFraction().unscaledValue().mod(GDateBuilder.TEN).signum() == 0;
        }
        if (!z6) {
            this._canonicalString = toString();
            return;
        }
        GDateBuilder gDateBuilder = new GDateBuilder(this);
        gDateBuilder.normalize();
        this._canonicalString = gDateBuilder.toString();
    }

    public static String formatGDate(GDateSpecification gDateSpecification) {
        int i_padTwoAppend;
        String string;
        int iIndexOf;
        BigDecimal fraction = gDateSpecification.getFraction();
        char[] cArr = new char[(fraction == null ? 0 : fraction.scale()) + 33];
        if (gDateSpecification.hasYear() || gDateSpecification.hasMonth() || gDateSpecification.hasDay()) {
            if (gDateSpecification.hasYear()) {
                i_padTwoAppend = _padFourAppend(cArr, gDateSpecification.getYear());
            } else {
                cArr[0] = '-';
                i_padTwoAppend = 1;
            }
            if (gDateSpecification.hasMonth() || gDateSpecification.hasDay()) {
                int i5 = i_padTwoAppend + 1;
                cArr[i_padTwoAppend] = '-';
                i_padTwoAppend = gDateSpecification.hasMonth() ? _padTwoAppend(cArr, i5, gDateSpecification.getMonth()) : i5;
                if (gDateSpecification.hasDay()) {
                    cArr[i_padTwoAppend] = '-';
                    i_padTwoAppend = _padTwoAppend(cArr, i_padTwoAppend + 1, gDateSpecification.getDay());
                }
            }
            if (gDateSpecification.hasTime()) {
                cArr[i_padTwoAppend] = 'T';
                i_padTwoAppend++;
            }
        } else {
            i_padTwoAppend = 0;
        }
        if (gDateSpecification.hasTime()) {
            int i_padTwoAppend2 = _padTwoAppend(cArr, i_padTwoAppend, gDateSpecification.getHour());
            cArr[i_padTwoAppend2] = NameUtil.COLON;
            int i_padTwoAppend3 = _padTwoAppend(cArr, i_padTwoAppend2 + 1, gDateSpecification.getMinute());
            cArr[i_padTwoAppend3] = NameUtil.COLON;
            i_padTwoAppend = _padTwoAppend(cArr, i_padTwoAppend3 + 1, gDateSpecification.getSecond());
            if (fraction != null && !_zero.equals(fraction) && (iIndexOf = (string = fraction.toString()).indexOf(46)) >= 0) {
                string.getChars(iIndexOf, string.length(), cArr, i_padTwoAppend);
                i_padTwoAppend += string.length() - iIndexOf;
            }
        }
        if (gDateSpecification.hasTimeZone()) {
            if (gDateSpecification.getTimeZoneSign() == 0) {
                cArr[i_padTwoAppend] = 'Z';
                i_padTwoAppend++;
            } else {
                int i6 = i_padTwoAppend + 1;
                cArr[i_padTwoAppend] = gDateSpecification.getTimeZoneSign() > 0 ? '+' : '-';
                int i_padTwoAppend4 = _padTwoAppend(cArr, i6, gDateSpecification.getTimeZoneHour());
                cArr[i_padTwoAppend4] = NameUtil.COLON;
                i_padTwoAppend = _padTwoAppend(cArr, i_padTwoAppend4 + 1, gDateSpecification.getTimeZoneMinute());
            }
        }
        return new String(cArr, 0, i_padTwoAppend);
    }

    public static boolean isDigit(char c) {
        return ((char) (c + 65488)) <= '\t';
    }

    public static boolean isSpace(char c) {
        return c == '\t' || c == '\n' || c == '\r' || c == ' ';
    }

    public static TimeZone timeZoneForGDate(GDateSpecification gDateSpecification) {
        if (!gDateSpecification.hasTimeZone()) {
            return TimeZone.getDefault();
        }
        if (gDateSpecification.getTimeZoneSign() == 0) {
            return GMTZONE;
        }
        if (gDateSpecification.getTimeZoneMinute() == 0 && gDateSpecification.getTimeZoneHour() <= 14 && gDateSpecification.getTimeZoneHour() >= 0) {
            return gDateSpecification.getTimeZoneSign() < 0 ? MINUSZONE[gDateSpecification.getTimeZoneHour()] : PLUSZONE[gDateSpecification.getTimeZoneHour()];
        }
        char[] cArr = new char[9];
        cArr[0] = 'G';
        cArr[1] = 'M';
        cArr[2] = 'T';
        cArr[3] = gDateSpecification.getTimeZoneSign() < 0 ? '-' : '+';
        _padTwoAppend(cArr, 4, gDateSpecification.getTimeZoneHour());
        cArr[6] = NameUtil.COLON;
        _padTwoAppend(cArr, 7, gDateSpecification.getTimeZoneMinute());
        return TimeZone.getTimeZone(new String(cArr));
    }

    private static int twoDigit(CharSequence charSequence, int i5) {
        char cCharAt = charSequence.charAt(i5);
        char cCharAt2 = charSequence.charAt(i5 + 1);
        if (!isDigit(cCharAt) || !isDigit(cCharAt2)) {
            return 100;
        }
        return digitVal(cCharAt2) + (digitVal(cCharAt) * 10);
    }

    public GDate add(GDurationSpecification gDurationSpecification) {
        GDateBuilder gDateBuilder = new GDateBuilder(this);
        gDateBuilder.addGDuration(gDurationSpecification);
        return gDateBuilder.toGDate();
    }

    @Override // org.apache.xmlbeans.GDateSpecification
    public String canonicalString() {
        ensureCanonicalString();
        return this._canonicalString;
    }

    @Override // org.apache.xmlbeans.GDateSpecification
    public int compareToGDate(GDateSpecification gDateSpecification) {
        return GDateBuilder.compareGDate(this, gDateSpecification);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GDate)) {
            return false;
        }
        ensureCanonicalString();
        return this._canonicalString.equals(((GDate) obj).canonicalString());
    }

    @Override // org.apache.xmlbeans.GDateSpecification
    public int getBuiltinTypeCode() {
        return GDateBuilder.btcForFlags(this._bits);
    }

    @Override // org.apache.xmlbeans.GDateSpecification
    public XmlCalendar getCalendar() {
        return new XmlCalendar(this);
    }

    @Override // org.apache.xmlbeans.GDateSpecification
    public Date getDate() {
        return GDateBuilder.dateForGDate(this);
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
    public int getJulianDate() {
        return GDateBuilder.julianDateForGDate(this);
    }

    @Override // org.apache.xmlbeans.GDateSpecification
    public int getMillisecond() {
        BigDecimal bigDecimal = this._fs;
        if (bigDecimal == null) {
            return 0;
        }
        return bigDecimal.setScale(3, RoundingMode.DOWN).unscaledValue().intValue();
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
        return this._CY;
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

    public int hashCode() {
        ensureCanonicalString();
        return this._canonicalString.hashCode();
    }

    @Override // org.apache.xmlbeans.GDateSpecification
    public final boolean isImmutable() {
        return true;
    }

    @Override // org.apache.xmlbeans.GDateSpecification
    public boolean isValid() {
        return GDateBuilder.isValidGDate(this);
    }

    public GDate subtract(GDurationSpecification gDurationSpecification) {
        GDateBuilder gDateBuilder = new GDateBuilder(this);
        gDateBuilder.subtractGDuration(gDurationSpecification);
        return gDateBuilder.toGDate();
    }

    @Override // org.apache.xmlbeans.GDateSpecification
    public String toString() {
        if (this._string == null) {
            this._string = formatGDate(this);
        }
        return this._string;
    }

    public GDate(int i5, int i6, int i7, int i8, int i9, int i10, BigDecimal bigDecimal) {
        this._bits = 30;
        this._CY = i5;
        this._M = i6;
        this._D = i7;
        this._h = i8;
        this._m = i9;
        this._s = i10;
        this._fs = bigDecimal == null ? _zero : bigDecimal;
        if (!isValid()) {
            throw new IllegalArgumentException();
        }
    }

    public GDate(int i5, int i6, int i7, int i8, int i9, int i10, BigDecimal bigDecimal, int i11, int i12, int i13) {
        this._bits = 31;
        this._CY = i5;
        this._M = i6;
        this._D = i7;
        this._h = i8;
        this._m = i9;
        this._s = i10;
        this._fs = bigDecimal == null ? _zero : bigDecimal;
        this._tzsign = i11;
        this._tzh = i12;
        this._tzm = i13;
        if (!isValid()) {
            throw new IllegalArgumentException();
        }
    }

    public GDate(Date date) {
        this(new GDateBuilder(date));
    }

    /* JADX WARN: Code duplicated, block: B:25:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:26:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:28:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:29:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:32:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:34:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:36:0x00da  */
    /* JADX WARN: Code duplicated, block: B:38:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:41:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:54:0x0118 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:55:0x011a  */
    /* JADX WARN: Code duplicated, block: B:58:? A[RETURN, SYNTHETIC] */
    public GDate(Calendar calendar) {
        int i5;
        boolean z6;
        int i6;
        int i7;
        int i8;
        String id;
        boolean zIsSet = calendar.isSet(1);
        boolean zIsSet2 = calendar.isSet(0);
        boolean zIsSet3 = calendar.isSet(2);
        boolean zIsSet4 = calendar.isSet(5);
        boolean zIsSet5 = calendar.isSet(11);
        boolean zIsSet6 = calendar.isSet(10);
        boolean zIsSet7 = calendar.isSet(9);
        boolean zIsSet8 = calendar.isSet(12);
        boolean zIsSet9 = calendar.isSet(13);
        boolean zIsSet10 = calendar.isSet(14);
        boolean zIsSet11 = calendar.isSet(15);
        boolean zIsSet12 = calendar.isSet(16);
        if (zIsSet) {
            int i9 = calendar.get(1);
            if (zIsSet2 && (calendar instanceof GregorianCalendar) && calendar.get(0) == 0) {
                i9 = -i9;
            }
            this._bits |= 2;
            this._CY = i9;
        }
        if (zIsSet3) {
            this._bits |= 4;
            this._M = calendar.get(2) + 1;
        }
        if (zIsSet4) {
            this._bits |= 8;
            this._D = calendar.get(5);
        }
        BigDecimal bigDecimalValueOf = _zero;
        if (!zIsSet5) {
            if (zIsSet6 && zIsSet7) {
                i5 = calendar.get(10) + (calendar.get(9) * 12);
            } else {
                i5 = 0;
                z6 = false;
            }
            if (zIsSet8) {
                i6 = calendar.get(12);
                z6 = true;
            } else {
                i6 = 0;
            }
            if (zIsSet9) {
                i7 = calendar.get(13);
                z6 = true;
            } else {
                i7 = 0;
            }
            if (zIsSet10) {
                bigDecimalValueOf = BigDecimal.valueOf(calendar.get(14), 3);
                z6 = true;
            }
            if (z6) {
                this._bits |= 16;
                this._h = i5;
                this._m = i6;
                this._s = i7;
                this._fs = bigDecimalValueOf;
            }
            if (zIsSet11) {
                i8 = calendar.get(15);
                i8 = zIsSet12 ? i8 + calendar.get(16) : i8;
                this._bits |= 1;
                if (i8 == 0) {
                    this._tzsign = 0;
                    this._tzh = 0;
                    this._tzm = 0;
                    id = calendar.getTimeZone().getID();
                    if (id != null || id.length() <= 3) {
                        return;
                    }
                    char cCharAt = id.charAt(3);
                    if (cCharAt == '+') {
                        this._tzsign = 1;
                        return;
                    } else {
                        if (cCharAt != '-') {
                            return;
                        }
                        this._tzsign = -1;
                        return;
                    }
                }
                int i10 = i8 < 0 ? -1 : 1;
                this._tzsign = i10;
                int i11 = i8 * i10;
                int i12 = i11 / 3600000;
                this._tzh = i12;
                this._tzm = (i11 - (i12 * 3600000)) / Angles.OOXML_DEGREE;
            }
        }
        i5 = calendar.get(11);
        z6 = true;
        if (zIsSet8) {
            i6 = calendar.get(12);
            z6 = true;
        } else {
            i6 = 0;
        }
        if (zIsSet9) {
            i7 = calendar.get(13);
            z6 = true;
        } else {
            i7 = 0;
        }
        if (zIsSet10) {
            bigDecimalValueOf = BigDecimal.valueOf(calendar.get(14), 3);
            z6 = true;
        }
        if (z6) {
            this._bits |= 16;
            this._h = i5;
            this._m = i6;
            this._s = i7;
            this._fs = bigDecimalValueOf;
        }
        if (zIsSet11) {
            i8 = calendar.get(15);
            if (zIsSet12) {
            }
            this._bits |= 1;
            if (i8 == 0) {
                this._tzsign = 0;
                this._tzh = 0;
                this._tzm = 0;
                id = calendar.getTimeZone().getID();
                if (id != null) {
                    return;
                } else {
                    return;
                }
            }
            if (i8 < 0) {
            }
            this._tzsign = i10;
            int i13 = i8 * i10;
            int i14 = i13 / 3600000;
            this._tzh = i14;
            this._tzm = (i13 - (i14 * 3600000)) / Angles.OOXML_DEGREE;
        }
    }

    public GDate(GDateSpecification gDateSpecification) {
        if (gDateSpecification.hasTimeZone()) {
            this._bits |= 1;
            this._tzsign = gDateSpecification.getTimeZoneSign();
            this._tzh = gDateSpecification.getTimeZoneHour();
            this._tzm = gDateSpecification.getTimeZoneMinute();
        }
        if (gDateSpecification.hasTime()) {
            this._bits |= 16;
            this._h = gDateSpecification.getHour();
            this._m = gDateSpecification.getMinute();
            this._s = gDateSpecification.getSecond();
            this._fs = gDateSpecification.getFraction();
        }
        if (gDateSpecification.hasDay()) {
            this._bits |= 8;
            this._D = gDateSpecification.getDay();
        }
        if (gDateSpecification.hasMonth()) {
            this._bits |= 4;
            this._M = gDateSpecification.getMonth();
        }
        if (gDateSpecification.hasYear()) {
            this._bits |= 2;
            this._CY = gDateSpecification.getYear();
        }
    }
}
