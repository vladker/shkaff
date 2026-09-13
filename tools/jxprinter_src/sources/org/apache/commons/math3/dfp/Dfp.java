package org.apache.commons.math3.dfp;

import androidx.exifinterface.media.ExifInterface;
import java.util.Arrays;
import org.apache.commons.math3.RealFieldElement;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.util.FastMath;
import org.apache.logging.log4j.util.Chars;
import org.apache.logging.log4j.util.ProcessIdUtil;
import org.apache.poi.ss.util.IEEEDouble;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class Dfp implements RealFieldElement<Dfp> {
    private static final String ADD_TRAP = "add";
    private static final String ALIGN_TRAP = "align";
    private static final String DIVIDE_TRAP = "divide";
    public static final int ERR_SCALE = 32760;
    public static final byte FINITE = 0;
    private static final String GREATER_THAN_TRAP = "greaterThan";
    public static final byte INFINITE = 1;
    private static final String LESS_THAN_TRAP = "lessThan";
    public static final int MAX_EXP = 32768;
    public static final int MIN_EXP = -32767;
    private static final String MULTIPLY_TRAP = "multiply";
    private static final String NAN_STRING = "NaN";
    private static final String NEG_INFINITY_STRING = "-Infinity";
    private static final String NEW_INSTANCE_TRAP = "newInstance";
    private static final String NEXT_AFTER_TRAP = "nextAfter";
    private static final String POS_INFINITY_STRING = "Infinity";
    public static final byte QNAN = 3;
    public static final int RADIX = 10000;
    public static final byte SNAN = 2;
    private static final String SQRT_TRAP = "sqrt";
    private static final String TRUNC_TRAP = "trunc";
    protected int exp;
    private final DfpField field;
    protected int[] mant;
    protected byte nans;
    protected byte sign;

    /* JADX INFO: renamed from: org.apache.commons.math3.dfp.Dfp$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$commons$math3$dfp$DfpField$RoundingMode;

        static {
            int[] iArr = new int[DfpField.RoundingMode.values().length];
            $SwitchMap$org$apache$commons$math3$dfp$DfpField$RoundingMode = iArr;
            try {
                iArr[DfpField.RoundingMode.ROUND_FLOOR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$commons$math3$dfp$DfpField$RoundingMode[DfpField.RoundingMode.ROUND_CEIL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$commons$math3$dfp$DfpField$RoundingMode[DfpField.RoundingMode.ROUND_HALF_EVEN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$apache$commons$math3$dfp$DfpField$RoundingMode[DfpField.RoundingMode.ROUND_DOWN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$apache$commons$math3$dfp$DfpField$RoundingMode[DfpField.RoundingMode.ROUND_UP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$org$apache$commons$math3$dfp$DfpField$RoundingMode[DfpField.RoundingMode.ROUND_HALF_UP.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$org$apache$commons$math3$dfp$DfpField$RoundingMode[DfpField.RoundingMode.ROUND_HALF_DOWN.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$org$apache$commons$math3$dfp$DfpField$RoundingMode[DfpField.RoundingMode.ROUND_HALF_ODD.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    public Dfp(DfpField dfpField) {
        this.mant = new int[dfpField.getRadixDigits()];
        this.sign = (byte) 1;
        this.exp = 0;
        this.nans = (byte) 0;
        this.field = dfpField;
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x0054, code lost:
    
        if (r4 > r5) goto L40;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static int compare(org.apache.commons.math3.dfp.Dfp r7, org.apache.commons.math3.dfp.Dfp r8) {
        /*
            int[] r0 = r7.mant
            int r1 = r0.length
            r2 = 1
            int r1 = r1 - r2
            r1 = r0[r1]
            r3 = 0
            if (r1 != 0) goto L1b
            int[] r1 = r8.mant
            int r4 = r1.length
            int r4 = r4 - r2
            r1 = r1[r4]
            if (r1 != 0) goto L1b
            byte r1 = r7.nans
            if (r1 != 0) goto L1b
            byte r1 = r8.nans
            if (r1 != 0) goto L1b
            return r3
        L1b:
            byte r1 = r7.sign
            byte r4 = r8.sign
            if (r1 == r4) goto L26
            r7 = -1
            if (r1 != r7) goto L25
            return r7
        L25:
            return r2
        L26:
            byte r5 = r7.nans
            if (r5 != r2) goto L2f
            byte r6 = r8.nans
            if (r6 != 0) goto L2f
            goto L56
        L2f:
            if (r5 != 0) goto L37
            byte r6 = r8.nans
            if (r6 != r2) goto L37
            int r7 = -r4
            return r7
        L37:
            if (r5 != r2) goto L3e
            byte r4 = r8.nans
            if (r4 != r2) goto L3e
            return r3
        L3e:
            int[] r4 = r8.mant
            int r5 = r4.length
            int r5 = r5 - r2
            r5 = r4[r5]
            if (r5 == 0) goto L57
            int r4 = r4.length
            int r4 = r4 - r2
            r4 = r0[r4]
            if (r4 == 0) goto L57
            int r4 = r7.exp
            int r5 = r8.exp
            if (r4 >= r5) goto L54
            int r7 = -r1
            return r7
        L54:
            if (r4 <= r5) goto L57
        L56:
            return r1
        L57:
            int r0 = r0.length
            int r0 = r0 - r2
        L59:
            if (r0 < 0) goto L71
            int[] r1 = r7.mant
            r1 = r1[r0]
            int[] r2 = r8.mant
            r2 = r2[r0]
            if (r1 <= r2) goto L68
            byte r7 = r7.sign
            return r7
        L68:
            if (r1 >= r2) goto L6e
            byte r7 = r7.sign
            int r7 = -r7
            return r7
        L6e:
            int r0 = r0 + (-1)
            goto L59
        L71:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.math3.dfp.Dfp.compare(org.apache.commons.math3.dfp.Dfp, org.apache.commons.math3.dfp.Dfp):int");
    }

    public static Dfp copysign(Dfp dfp, Dfp dfp2) {
        Dfp dfpNewInstance = dfp.newInstance(dfp);
        dfpNewInstance.sign = dfp2.sign;
        return dfpNewInstance;
    }

    private Dfp multiplyFast(int i5) {
        int i6;
        Dfp dfpNewInstance = newInstance(this);
        if (this.nans != 0) {
            if (isNaN()) {
                return this;
            }
            byte b = this.nans;
            if (b == 1 && i5 != 0) {
                return newInstance(this);
            }
            if (b == 1 && i5 == 0) {
                this.field.setIEEEFlagsBits(1);
                Dfp dfpNewInstance2 = newInstance(getZero());
                dfpNewInstance2.nans = (byte) 3;
                return dotrap(1, MULTIPLY_TRAP, newInstance(getZero()), dfpNewInstance2);
            }
        }
        if (i5 < 0 || i5 >= 10000) {
            this.field.setIEEEFlagsBits(1);
            Dfp dfpNewInstance3 = newInstance(getZero());
            dfpNewInstance3.nans = (byte) 3;
            return dotrap(1, MULTIPLY_TRAP, dfpNewInstance3, dfpNewInstance3);
        }
        int i7 = 0;
        int i8 = 0;
        while (true) {
            int[] iArr = this.mant;
            if (i7 >= iArr.length) {
                break;
            }
            int i9 = (iArr[i7] * i5) + i8;
            i8 = i9 / 10000;
            dfpNewInstance.mant[i7] = i9 - (i8 * 10000);
            i7++;
        }
        if (i8 != 0) {
            i6 = dfpNewInstance.mant[0];
            dfpNewInstance.shiftRight();
            dfpNewInstance.mant[this.mant.length - 1] = i8;
        } else {
            i6 = 0;
        }
        if (dfpNewInstance.mant[this.mant.length - 1] == 0) {
            dfpNewInstance.exp = 0;
        }
        int iRound = dfpNewInstance.round(i6);
        return iRound != 0 ? dotrap(iRound, MULTIPLY_TRAP, dfpNewInstance, dfpNewInstance) : dfpNewInstance;
    }

    public int align(int i5) {
        int i6 = this.exp - i5;
        int i7 = i6 < 0 ? -i6 : i6;
        if (i6 == 0) {
            return 0;
        }
        int[] iArr = this.mant;
        if (i7 > iArr.length + 1) {
            Arrays.fill(iArr, 0);
            this.exp = i5;
            this.field.setIEEEFlagsBits(16);
            dotrap(16, ALIGN_TRAP, this, this);
            return 0;
        }
        boolean z6 = false;
        int i8 = 0;
        for (int i9 = 0; i9 < i7; i9++) {
            if (i6 < 0) {
                if (i8 != 0) {
                    z6 = true;
                }
                i8 = this.mant[0];
                shiftRight();
            } else {
                shiftLeft();
            }
        }
        if (z6) {
            this.field.setIEEEFlagsBits(16);
            dotrap(16, ALIGN_TRAP, this, this);
        }
        return i8;
    }

    public int classify() {
        return this.nans;
    }

    public int complement(int i5) {
        int i6 = 10000 - i5;
        int i7 = 0;
        int i8 = 0;
        while (true) {
            int[] iArr = this.mant;
            if (i8 >= iArr.length) {
                break;
            }
            iArr[i8] = 9999 - iArr[i8];
            i8++;
        }
        int i9 = i6 / 10000;
        int i10 = i6 - (i9 * 10000);
        while (true) {
            int[] iArr2 = this.mant;
            if (i7 >= iArr2.length) {
                return i10;
            }
            int i11 = iArr2[i7] + i9;
            i9 = i11 / 10000;
            iArr2[i7] = i11 - (i9 * 10000);
            i7++;
        }
    }

    public String dfp2sci() {
        int i5;
        int[] iArr = this.mant;
        int length = iArr.length * 4;
        char[] cArr = new char[length];
        char[] cArr2 = new char[(iArr.length * 4) + 20];
        int i6 = 0;
        for (int length2 = iArr.length - 1; length2 >= 0; length2--) {
            int i7 = this.mant[length2];
            cArr[i6] = (char) ((i7 / 1000) + 48);
            cArr[i6 + 1] = (char) (((i7 / 100) % 10) + 48);
            int i8 = i6 + 3;
            cArr[i6 + 2] = (char) (((i7 / 10) % 10) + 48);
            i6 += 4;
            cArr[i8] = (char) ((i7 % 10) + 48);
        }
        int i9 = 0;
        while (i9 < length && cArr[i9] == '0') {
            i9++;
        }
        if (this.sign == -1) {
            cArr2[0] = '-';
            i5 = 1;
        } else {
            i5 = 0;
        }
        if (i9 == length) {
            cArr2[i5] = '0';
            cArr2[i5 + 1] = '.';
            cArr2[i5 + 2] = '0';
            cArr2[i5 + 3] = 'e';
            cArr2[i5 + 4] = '0';
            return new String(cArr2, 0, 5);
        }
        int i10 = i5 + 1;
        cArr2[i5] = cArr[i9];
        int i11 = i5 + 2;
        cArr2[i10] = '.';
        for (int i12 = i9 + 1; i12 < length; i12++) {
            cArr2[i11] = cArr[i12];
            i11++;
        }
        int i13 = i11 + 1;
        cArr2[i11] = 'e';
        int i14 = ((this.exp * 4) - i9) - 1;
        int i15 = i14 < 0 ? -i14 : i14;
        int i16 = 1000000000;
        while (i16 > i15) {
            i16 /= 10;
        }
        if (i14 < 0) {
            cArr2[i13] = '-';
            i13 = i11 + 2;
        }
        while (i16 > 0) {
            cArr2[i13] = (char) ((i15 / i16) + 48);
            i15 %= i16;
            i16 /= 10;
            i13++;
        }
        return new String(cArr2, 0, i13);
    }

    public String dfp2string() {
        boolean z6;
        int i5;
        char c;
        char[] cArr = new char[(this.mant.length * 4) + 20];
        int i6 = this.exp;
        cArr[0] = Chars.SPACE;
        int i7 = 1;
        if (i6 <= 0) {
            cArr[1] = '0';
            cArr[2] = '.';
            i5 = 3;
            z6 = true;
        } else {
            z6 = false;
            i5 = 1;
        }
        while (i6 < 0) {
            cArr[i5] = '0';
            cArr[i5 + 1] = '0';
            int i8 = i5 + 3;
            cArr[i5 + 2] = '0';
            i5 += 4;
            cArr[i8] = '0';
            i6++;
        }
        for (int length = this.mant.length - 1; length >= 0; length--) {
            int i9 = this.mant[length];
            cArr[i5] = (char) ((i9 / 1000) + 48);
            cArr[i5 + 1] = (char) (((i9 / 100) % 10) + 48);
            cArr[i5 + 2] = (char) (((i9 / 10) % 10) + 48);
            int i10 = i5 + 4;
            cArr[i5 + 3] = (char) ((i9 % 10) + 48);
            i6--;
            if (i6 == 0) {
                i5 += 5;
                cArr[i10] = '.';
                z6 = true;
            } else {
                i5 = i10;
            }
        }
        while (i6 > 0) {
            cArr[i5] = '0';
            cArr[i5 + 1] = '0';
            int i11 = i5 + 3;
            cArr[i5 + 2] = '0';
            i5 += 4;
            cArr[i11] = '0';
            i6--;
        }
        if (!z6) {
            cArr[i5] = '.';
            i5++;
        }
        while (true) {
            c = cArr[i7];
            if (c != '0') {
                break;
            }
            i7++;
        }
        if (c == '.') {
            i7--;
        }
        while (cArr[i5 - 1] == '0') {
            i5--;
        }
        if (this.sign < 0) {
            i7--;
            cArr[i7] = '-';
        }
        return new String(cArr, i7, i5 - i7);
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0073  */
    public Dfp dotrap(int i5, String str, Dfp dfp, Dfp dfp2) {
        Dfp dfpNewInstance;
        Dfp dfp3;
        Dfp dfp4;
        Dfp dfpNewInstance2;
        Dfp dfpNewInstance3;
        if (i5 != 1) {
            if (i5 != 2) {
                if (i5 == 4) {
                    dfp2.exp -= 32760;
                    dfpNewInstance3 = newInstance(getZero());
                    dfpNewInstance3.sign = dfp2.sign;
                    dfpNewInstance3.nans = (byte) 1;
                } else if (i5 != 8) {
                    dfp4 = dfp2;
                    dfp3 = dfp4;
                } else {
                    if (dfp2.exp + this.mant.length < -32767) {
                        dfpNewInstance3 = newInstance(getZero());
                        dfpNewInstance3.sign = dfp2.sign;
                    } else {
                        dfpNewInstance3 = newInstance(dfp2);
                    }
                    dfp2.exp += ERR_SCALE;
                }
                dfp3 = dfp2;
                dfp4 = dfpNewInstance3;
            } else {
                if (this.nans == 0) {
                    int[] iArr = this.mant;
                    if (iArr[iArr.length - 1] != 0) {
                        dfpNewInstance2 = newInstance(getZero());
                        dfpNewInstance2.sign = (byte) (this.sign * dfp.sign);
                        dfpNewInstance2.nans = (byte) 1;
                    } else {
                        dfpNewInstance2 = dfp2;
                    }
                } else {
                    dfpNewInstance2 = dfp2;
                }
                if (this.nans == 0) {
                    int[] iArr2 = this.mant;
                    if (iArr2[iArr2.length - 1] == 0) {
                        dfpNewInstance2 = newInstance(getZero());
                        dfpNewInstance2.nans = (byte) 3;
                    }
                }
                byte b = this.nans;
                if (b == 1 || b == 3) {
                    dfpNewInstance2 = newInstance(getZero());
                    dfpNewInstance2.nans = (byte) 3;
                }
                byte b6 = this.nans;
                if (b6 == 1 || b6 == 2) {
                    dfpNewInstance = newInstance(getZero());
                    dfpNewInstance.nans = (byte) 3;
                } else {
                    dfp3 = dfp2;
                    dfp4 = dfpNewInstance2;
                }
            }
            return trap(i5, str, dfp, dfp4, dfp3);
        }
        dfpNewInstance = newInstance(getZero());
        dfpNewInstance.sign = dfp2.sign;
        dfpNewInstance.nans = (byte) 3;
        dfp3 = dfp2;
        dfp4 = dfpNewInstance;
        return trap(i5, str, dfp, dfp4, dfp3);
    }

    public boolean equals(Object obj) {
        if (obj instanceof Dfp) {
            Dfp dfp = (Dfp) obj;
            if (!isNaN() && !dfp.isNaN() && this.field.getRadixDigits() == dfp.field.getRadixDigits() && compare(this, dfp) == 0) {
                return true;
            }
        }
        return false;
    }

    public Dfp getOne() {
        return this.field.getOne();
    }

    public int getRadixDigits() {
        return this.field.getRadixDigits();
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public double getReal() {
        return toDouble();
    }

    public Dfp getTwo() {
        return this.field.getTwo();
    }

    public Dfp getZero() {
        return this.field.getZero();
    }

    public boolean greaterThan(Dfp dfp) {
        if (this.field.getRadixDigits() != dfp.field.getRadixDigits()) {
            this.field.setIEEEFlagsBits(1);
            Dfp dfpNewInstance = newInstance(getZero());
            dfpNewInstance.nans = (byte) 3;
            dotrap(1, GREATER_THAN_TRAP, dfp, dfpNewInstance);
            return false;
        }
        if (!isNaN() && !dfp.isNaN()) {
            return compare(this, dfp) > 0;
        }
        this.field.setIEEEFlagsBits(1);
        dotrap(1, GREATER_THAN_TRAP, dfp, newInstance(getZero()));
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(this.mant) + (isZero() ? 0 : this.sign << 8) + 17 + (this.nans << 16) + this.exp;
    }

    public int intLog10() {
        int[] iArr = this.mant;
        if (iArr[iArr.length - 1] > 1000) {
            return (this.exp * 4) - 1;
        }
        if (iArr[iArr.length - 1] > 100) {
            return (this.exp * 4) - 2;
        }
        return iArr[iArr.length + (-1)] > 10 ? (this.exp * 4) - 3 : (this.exp * 4) - 4;
    }

    public int intValue() {
        Dfp dfpRint = rint();
        if (dfpRint.greaterThan(newInstance(Integer.MAX_VALUE))) {
            return Integer.MAX_VALUE;
        }
        if (dfpRint.lessThan(newInstance(Integer.MIN_VALUE))) {
            return Integer.MIN_VALUE;
        }
        int i5 = 0;
        for (int length = this.mant.length - 1; length >= this.mant.length - dfpRint.exp; length--) {
            i5 = (i5 * 10000) + dfpRint.mant[length];
        }
        return dfpRint.sign == -1 ? -i5 : i5;
    }

    public boolean isInfinite() {
        return this.nans == 1;
    }

    public boolean isNaN() {
        byte b = this.nans;
        return b == 3 || b == 2;
    }

    public boolean isZero() {
        if (!isNaN()) {
            int[] iArr = this.mant;
            return iArr[iArr.length - 1] == 0 && !isInfinite();
        }
        this.field.setIEEEFlagsBits(1);
        dotrap(1, LESS_THAN_TRAP, this, newInstance(getZero()));
        return false;
    }

    public boolean lessThan(Dfp dfp) {
        if (this.field.getRadixDigits() != dfp.field.getRadixDigits()) {
            this.field.setIEEEFlagsBits(1);
            Dfp dfpNewInstance = newInstance(getZero());
            dfpNewInstance.nans = (byte) 3;
            dotrap(1, LESS_THAN_TRAP, dfp, dfpNewInstance);
            return false;
        }
        if (!isNaN() && !dfp.isNaN()) {
            return compare(this, dfp) < 0;
        }
        this.field.setIEEEFlagsBits(1);
        dotrap(1, LESS_THAN_TRAP, dfp, newInstance(getZero()));
        return false;
    }

    @Deprecated
    public int log10() {
        return intLog10();
    }

    public int log10K() {
        return this.exp - 1;
    }

    public boolean negativeOrNull() {
        if (isNaN()) {
            this.field.setIEEEFlagsBits(1);
            dotrap(1, LESS_THAN_TRAP, this, newInstance(getZero()));
            return false;
        }
        if (this.sign >= 0) {
            int[] iArr = this.mant;
            if (iArr[iArr.length - 1] != 0 || isInfinite()) {
                return false;
            }
        }
        return true;
    }

    public Dfp newInstance() {
        return new Dfp(getField());
    }

    public Dfp nextAfter(Dfp dfp) {
        Dfp dfpSubtract;
        if (this.field.getRadixDigits() != dfp.field.getRadixDigits()) {
            this.field.setIEEEFlagsBits(1);
            Dfp dfpNewInstance = newInstance(getZero());
            dfpNewInstance.nans = (byte) 3;
            return dotrap(1, NEXT_AFTER_TRAP, dfp, dfpNewInstance);
        }
        boolean zLessThan = lessThan(dfp);
        if (compare(this, dfp) == 0) {
            return newInstance(dfp);
        }
        if (lessThan(getZero())) {
            zLessThan = !zLessThan;
        }
        if (zLessThan) {
            Dfp dfpNewInstance2 = newInstance(getOne());
            dfpNewInstance2.exp = (this.exp - this.mant.length) + 1;
            dfpNewInstance2.sign = this.sign;
            if (equals(getZero())) {
                dfpNewInstance2.exp = (-32767) - this.mant.length;
            }
            dfpSubtract = add(dfpNewInstance2);
        } else {
            Dfp dfpNewInstance3 = newInstance(getOne());
            dfpNewInstance3.exp = this.exp;
            dfpNewInstance3.sign = this.sign;
            if (equals(dfpNewInstance3)) {
                dfpNewInstance3.exp = this.exp - this.mant.length;
            } else {
                dfpNewInstance3.exp = (this.exp - this.mant.length) + 1;
            }
            if (equals(getZero())) {
                dfpNewInstance3.exp = (-32767) - this.mant.length;
            }
            dfpSubtract = subtract(dfpNewInstance3);
        }
        if (dfpSubtract.classify() == 1 && classify() != 1) {
            this.field.setIEEEFlagsBits(16);
            dfpSubtract = dotrap(16, NEXT_AFTER_TRAP, dfp, dfpSubtract);
        }
        if (!dfpSubtract.equals(getZero()) || equals(getZero())) {
            return dfpSubtract;
        }
        this.field.setIEEEFlagsBits(16);
        return dotrap(16, NEXT_AFTER_TRAP, dfp, dfpSubtract);
    }

    public boolean positiveOrNull() {
        if (isNaN()) {
            this.field.setIEEEFlagsBits(1);
            dotrap(1, LESS_THAN_TRAP, this, newInstance(getZero()));
            return false;
        }
        if (this.sign <= 0) {
            int[] iArr = this.mant;
            if (iArr[iArr.length - 1] != 0 || isInfinite()) {
                return false;
            }
        }
        return true;
    }

    public Dfp power10(int i5) {
        Dfp dfpNewInstance = newInstance(getOne());
        if (i5 >= 0) {
            dfpNewInstance.exp = (i5 / 4) + 1;
        } else {
            dfpNewInstance.exp = (i5 + 1) / 4;
        }
        int i6 = ((i5 % 4) + 4) % 4;
        if (i6 == 0) {
            return dfpNewInstance;
        }
        if (i6 != 1) {
            return i6 != 2 ? dfpNewInstance.multiply(1000) : dfpNewInstance.multiply(100);
        }
        return dfpNewInstance.multiply(10);
    }

    public Dfp power10K(int i5) {
        Dfp dfpNewInstance = newInstance(getOne());
        dfpNewInstance.exp = i5 + 1;
        return dfpNewInstance;
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0044  */
    /* JADX WARN: Code duplicated, block: B:30:0x004b A[LOOP:0: B:28:0x0046->B:30:0x004b, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:32:0x005a  */
    /* JADX WARN: Code duplicated, block: B:45:0x0058 A[SYNTHETIC] */
    public int round(int i5) {
        int i6;
        int i7;
        int[] iArr;
        switch (AnonymousClass1.$SwitchMap$org$apache$commons$math3$dfp$DfpField$RoundingMode[this.field.getRoundingMode().ordinal()]) {
            case 2:
                if (this.sign == 1 && i5 != 0) {
                    i6 = 0;
                    i7 = 1;
                    while (true) {
                        iArr = this.mant;
                        if (i6 < iArr.length) {
                            int i8 = iArr[i6] + i7;
                            i7 = i8 / 10000;
                            iArr[i6] = i8 - (i7 * 10000);
                            i6++;
                        } else if (i7 != 0) {
                            shiftRight();
                            int[] iArr2 = this.mant;
                            iArr2[iArr2.length - 1] = i7;
                        }
                    }
                }
                break;
            case 3:
                if (i5 > 5000 || (i5 == 5000 && (this.mant[0] & 1) == 1)) {
                    i6 = 0;
                    i7 = 1;
                    while (true) {
                        iArr = this.mant;
                        if (i6 < iArr.length) {
                            int i9 = iArr[i6] + i7;
                            i7 = i9 / 10000;
                            iArr[i6] = i9 - (i7 * 10000);
                            i6++;
                        } else if (i7 != 0) {
                            shiftRight();
                            int[] iArr3 = this.mant;
                            iArr3[iArr3.length - 1] = i7;
                        }
                    }
                }
                break;
            case 4:
                break;
            case 5:
                if (i5 != 0) {
                    i6 = 0;
                    i7 = 1;
                    while (true) {
                        iArr = this.mant;
                        if (i6 < iArr.length) {
                            int i10 = iArr[i6] + i7;
                            i7 = i10 / 10000;
                            iArr[i6] = i10 - (i7 * 10000);
                            i6++;
                        } else if (i7 != 0) {
                            shiftRight();
                            int[] iArr4 = this.mant;
                            iArr4[iArr4.length - 1] = i7;
                        }
                    }
                }
                break;
            case 6:
                if (i5 >= 5000) {
                    i6 = 0;
                    i7 = 1;
                    while (true) {
                        iArr = this.mant;
                        if (i6 < iArr.length) {
                            int i11 = iArr[i6] + i7;
                            i7 = i11 / 10000;
                            iArr[i6] = i11 - (i7 * 10000);
                            i6++;
                        } else if (i7 != 0) {
                            shiftRight();
                            int[] iArr5 = this.mant;
                            iArr5[iArr5.length - 1] = i7;
                        }
                    }
                }
                break;
            case 7:
                if (i5 > 5000) {
                    i6 = 0;
                    i7 = 1;
                    while (true) {
                        iArr = this.mant;
                        if (i6 < iArr.length) {
                            int i12 = iArr[i6] + i7;
                            i7 = i12 / 10000;
                            iArr[i6] = i12 - (i7 * 10000);
                            i6++;
                        } else if (i7 != 0) {
                            shiftRight();
                            int[] iArr6 = this.mant;
                            iArr6[iArr6.length - 1] = i7;
                        }
                    }
                }
                break;
            case 8:
                if (i5 > 5000 || (i5 == 5000 && (this.mant[0] & 1) == 0)) {
                    i6 = 0;
                    i7 = 1;
                    while (true) {
                        iArr = this.mant;
                        if (i6 < iArr.length) {
                            int i13 = iArr[i6] + i7;
                            i7 = i13 / 10000;
                            iArr[i6] = i13 - (i7 * 10000);
                            i6++;
                        } else if (i7 != 0) {
                            shiftRight();
                            int[] iArr7 = this.mant;
                            iArr7[iArr7.length - 1] = i7;
                        }
                    }
                }
                break;
            default:
                if (this.sign == -1 && i5 != 0) {
                    i6 = 0;
                    i7 = 1;
                    while (true) {
                        iArr = this.mant;
                        if (i6 < iArr.length) {
                            int i14 = iArr[i6] + i7;
                            i7 = i14 / 10000;
                            iArr[i6] = i14 - (i7 * 10000);
                            i6++;
                        } else if (i7 != 0) {
                            shiftRight();
                            int[] iArr8 = this.mant;
                            iArr8[iArr8.length - 1] = i7;
                        }
                    }
                }
                break;
        }
        int i15 = this.exp;
        if (i15 < -32767) {
            this.field.setIEEEFlagsBits(8);
            return 8;
        }
        if (i15 > 32768) {
            this.field.setIEEEFlagsBits(4);
            return 4;
        }
        if (i5 == 0) {
            return 0;
        }
        this.field.setIEEEFlagsBits(16);
        return 16;
    }

    public void shiftLeft() {
        for (int length = this.mant.length - 1; length > 0; length--) {
            int[] iArr = this.mant;
            iArr[length] = iArr[length - 1];
        }
        this.mant[0] = 0;
        this.exp--;
    }

    public void shiftRight() {
        int i5 = 0;
        while (true) {
            int[] iArr = this.mant;
            if (i5 >= iArr.length - 1) {
                iArr[iArr.length - 1] = 0;
                this.exp++;
                return;
            } else {
                int i6 = i5 + 1;
                iArr[i5] = iArr[i6];
                i5 = i6;
            }
        }
    }

    public boolean strictlyNegative() {
        if (isNaN()) {
            this.field.setIEEEFlagsBits(1);
            dotrap(1, LESS_THAN_TRAP, this, newInstance(getZero()));
            return false;
        }
        if (this.sign < 0) {
            int[] iArr = this.mant;
            if (iArr[iArr.length - 1] != 0 || isInfinite()) {
                return true;
            }
        }
        return false;
    }

    public boolean strictlyPositive() {
        if (isNaN()) {
            this.field.setIEEEFlagsBits(1);
            dotrap(1, LESS_THAN_TRAP, this, newInstance(getZero()));
            return false;
        }
        if (this.sign > 0) {
            int[] iArr = this.mant;
            if (iArr[iArr.length - 1] != 0 || isInfinite()) {
                return true;
            }
        }
        return false;
    }

    public double toDouble() {
        Dfp dfpNegate;
        boolean z6;
        if (isInfinite()) {
            return lessThan(getZero()) ? Double.NEGATIVE_INFINITY : Double.POSITIVE_INFINITY;
        }
        if (isNaN()) {
            return Double.NaN;
        }
        int iCompare = compare(this, getZero());
        if (iCompare == 0) {
            return this.sign < 0 ? -0.0d : 0.0d;
        }
        if (iCompare < 0) {
            dfpNegate = negate();
            z6 = true;
        } else {
            dfpNegate = this;
            z6 = false;
        }
        int iIntLog10 = (int) (((double) dfpNegate.intLog10()) * 3.32d);
        if (iIntLog10 < 0) {
            iIntLog10--;
        }
        Dfp dfpPow = DfpMath.pow(getTwo(), iIntLog10);
        while (true) {
            if (!dfpPow.lessThan(dfpNegate) && !dfpPow.equals(dfpNegate)) {
                break;
            }
            dfpPow = dfpPow.multiply(2);
            iIntLog10++;
        }
        int i5 = iIntLog10 - 1;
        Dfp dfpDivide = dfpNegate.divide(DfpMath.pow(getTwo(), i5));
        if (i5 > -1023) {
            dfpDivide = dfpDivide.subtract(getOne());
        }
        if (i5 < -1074) {
            return 0.0d;
        }
        if (i5 > 1023) {
            return z6 ? Double.NEGATIVE_INFINITY : Double.POSITIVE_INFINITY;
        }
        String string = dfpDivide.multiply(newInstance(IEEEDouble.FRAC_ASSUMED_HIGH_BIT)).rint().toString();
        long j6 = Long.parseLong(string.substring(0, string.length() - 1));
        if (j6 == IEEEDouble.FRAC_ASSUMED_HIGH_BIT) {
            j6 = 0;
        } else {
            iIntLog10 = i5;
        }
        if (iIntLog10 <= -1023) {
            iIntLog10--;
        }
        while (iIntLog10 < -1023) {
            iIntLog10++;
            j6 >>>= 1;
        }
        double dLongBitsToDouble = Double.longBitsToDouble(((((long) iIntLog10) + 1023) << 52) | j6);
        return z6 ? -dLongBitsToDouble : dLongBitsToDouble;
    }

    public double[] toSplitDouble() {
        double dLongBitsToDouble = Double.longBitsToDouble(Double.doubleToLongBits(toDouble()) & (-1073741824));
        return new double[]{dLongBitsToDouble, subtract(newInstance(dLongBitsToDouble)).toDouble()};
    }

    public String toString() {
        byte b = this.nans;
        if (b == 0) {
            int i5 = this.exp;
            return (i5 > this.mant.length || i5 < -1) ? dfp2sci() : dfp2string();
        }
        if (b == 1) {
            return this.sign < 0 ? NEG_INFINITY_STRING : POS_INFINITY_STRING;
        }
        return NAN_STRING;
    }

    public Dfp trunc(DfpField.RoundingMode roundingMode) {
        int i5;
        if (isNaN()) {
            return newInstance(this);
        }
        if (this.nans == 1) {
            return newInstance(this);
        }
        int[] iArr = this.mant;
        if (iArr[iArr.length - 1] == 0) {
            return newInstance(this);
        }
        int i6 = this.exp;
        if (i6 < 0) {
            this.field.setIEEEFlagsBits(16);
            return dotrap(16, TRUNC_TRAP, this, newInstance(getZero()));
        }
        if (i6 >= iArr.length) {
            return newInstance(this);
        }
        Dfp dfpNewInstance = newInstance(this);
        boolean z6 = false;
        for (int i7 = 0; i7 < this.mant.length - dfpNewInstance.exp; i7++) {
            int[] iArr2 = dfpNewInstance.mant;
            z6 |= iArr2[i7] != 0;
            iArr2[i7] = 0;
        }
        if (!z6) {
            return dfpNewInstance;
        }
        int i8 = AnonymousClass1.$SwitchMap$org$apache$commons$math3$dfp$DfpField$RoundingMode[roundingMode.ordinal()];
        if (i8 != 1) {
            if (i8 != 2) {
                Dfp dfpNewInstance2 = newInstance("0.5");
                Dfp dfpSubtract = subtract(dfpNewInstance);
                dfpSubtract.sign = (byte) 1;
                if (dfpSubtract.greaterThan(dfpNewInstance2)) {
                    dfpSubtract = newInstance(getOne());
                    dfpSubtract.sign = this.sign;
                    dfpNewInstance = dfpNewInstance.add(dfpSubtract);
                }
                if (dfpSubtract.equals(dfpNewInstance2) && (i5 = dfpNewInstance.exp) > 0 && (dfpNewInstance.mant[this.mant.length - i5] & 1) != 0) {
                    Dfp dfpNewInstance3 = newInstance(getOne());
                    dfpNewInstance3.sign = this.sign;
                    dfpNewInstance = dfpNewInstance.add(dfpNewInstance3);
                }
            } else if (dfpNewInstance.sign == 1) {
                dfpNewInstance = dfpNewInstance.add(getOne());
            }
        } else if (dfpNewInstance.sign == -1) {
            dfpNewInstance = dfpNewInstance.add(newInstance(-1));
        }
        this.field.setIEEEFlagsBits(16);
        return dotrap(16, TRUNC_TRAP, this, dfpNewInstance);
    }

    public boolean unequal(Dfp dfp) {
        if (isNaN() || dfp.isNaN() || this.field.getRadixDigits() != dfp.field.getRadixDigits()) {
            return false;
        }
        return greaterThan(dfp) || lessThan(dfp);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public Dfp abs() {
        Dfp dfpNewInstance = newInstance(this);
        dfpNewInstance.sign = (byte) 1;
        return dfpNewInstance;
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public Dfp acos() {
        return DfpMath.acos(this);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public Dfp acosh() {
        return multiply(this).subtract(getOne()).sqrt().add(this).log();
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public Dfp asin() {
        return DfpMath.asin(this);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public Dfp asinh() {
        return multiply(this).add(getOne()).sqrt().add(this).log();
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public Dfp atan() {
        return DfpMath.atan(this);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public Dfp atan2(Dfp dfp) {
        Dfp dfpSqrt = dfp.multiply(dfp).add(multiply(this)).sqrt();
        if (dfp.sign >= 0) {
            return getTwo().multiply(divide(dfpSqrt.add(dfp)).atan());
        }
        Dfp dfpMultiply = getTwo().multiply(divide(dfpSqrt.subtract(dfp)).atan());
        return newInstance(dfpMultiply.sign <= 0 ? -3.141592653589793d : 3.141592653589793d).subtract(dfpMultiply);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public Dfp atanh() {
        return getOne().add(this).divide(getOne().subtract(this)).log().divide(2);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public Dfp cbrt() {
        return rootN(3);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public Dfp ceil() {
        return trunc(DfpField.RoundingMode.ROUND_CEIL);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public Dfp cos() {
        return DfpMath.cos(this);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public Dfp cosh() {
        return DfpMath.exp(this).add(DfpMath.exp(negate())).divide(2);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public Dfp exp() {
        return DfpMath.exp(this);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public Dfp expm1() {
        return DfpMath.exp(this).subtract(getOne());
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public Dfp floor() {
        return trunc(DfpField.RoundingMode.ROUND_FLOOR);
    }

    @Override // org.apache.commons.math3.FieldElement
    public DfpField getField() {
        return this.field;
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public Dfp hypot(Dfp dfp) {
        return multiply(this).add(dfp.multiply(dfp)).sqrt();
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public Dfp log() {
        return DfpMath.log(this);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public Dfp log1p() {
        return DfpMath.log(add(getOne()));
    }

    @Override // org.apache.commons.math3.FieldElement
    public Dfp negate() {
        Dfp dfpNewInstance = newInstance(this);
        dfpNewInstance.sign = (byte) (-dfpNewInstance.sign);
        return dfpNewInstance;
    }

    public Dfp newInstance(byte b) {
        return new Dfp(getField(), b);
    }

    @Override // org.apache.commons.math3.RealFieldElement, org.apache.commons.math3.FieldElement
    public Dfp reciprocal() {
        return this.field.getOne().divide(this);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public Dfp rint() {
        return trunc(DfpField.RoundingMode.ROUND_HALF_EVEN);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public Dfp rootN(int i5) {
        return this.sign >= 0 ? DfpMath.pow(this, getOne().divide(i5)) : DfpMath.pow(negate(), getOne().divide(i5)).negate();
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public Dfp scalb(int i5) {
        return multiply(DfpMath.pow(getTwo(), i5));
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public Dfp signum() {
        if (isNaN() || isZero()) {
            return this;
        }
        return newInstance(this.sign > 0 ? 1 : -1);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public Dfp sin() {
        return DfpMath.sin(this);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public Dfp sinh() {
        return DfpMath.exp(this).subtract(DfpMath.exp(negate())).divide(2);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public Dfp sqrt() {
        byte b = this.nans;
        if (b == 0) {
            int[] iArr = this.mant;
            if (iArr[iArr.length - 1] == 0) {
                return newInstance(this);
            }
        }
        if (b != 0) {
            if (b == 1 && this.sign == 1) {
                return newInstance(this);
            }
            if (b == 3) {
                return newInstance(this);
            }
            if (b == 2) {
                this.field.setIEEEFlagsBits(1);
                return dotrap(1, SQRT_TRAP, null, newInstance(this));
            }
        }
        if (this.sign == -1) {
            this.field.setIEEEFlagsBits(1);
            Dfp dfpNewInstance = newInstance(this);
            dfpNewInstance.nans = (byte) 3;
            return dotrap(1, SQRT_TRAP, null, dfpNewInstance);
        }
        Dfp dfpNewInstance2 = newInstance(this);
        int i5 = dfpNewInstance2.exp;
        if (i5 < -1 || i5 > 1) {
            dfpNewInstance2.exp = this.exp / 2;
        }
        int[] iArr2 = dfpNewInstance2.mant;
        int[] iArr3 = this.mant;
        int i6 = iArr2[iArr3.length - 1] / 2000;
        if (i6 == 0) {
            iArr2[iArr3.length - 1] = (iArr2[iArr3.length - 1] / 2) + 1;
        } else if (i6 == 2) {
            iArr2[iArr3.length - 1] = 1500;
        } else if (i6 != 3) {
            iArr2[iArr3.length - 1] = 3000;
        } else {
            iArr2[iArr3.length - 1] = 2200;
        }
        newInstance(dfpNewInstance2);
        Dfp zero = getZero();
        getZero();
        Dfp dfp = dfpNewInstance2;
        Dfp dfp2 = zero;
        while (dfp.unequal(dfp2)) {
            Dfp dfpNewInstance3 = newInstance(dfp);
            dfpNewInstance3.sign = (byte) -1;
            Dfp dfpDivide = dfpNewInstance3.add(divide(dfp)).divide(2);
            Dfp dfpAdd = dfp.add(dfpDivide);
            if (dfpAdd.equals(dfp2) || dfpDivide.mant[this.mant.length - 1] == 0) {
                return dfpAdd;
            }
            dfp2 = dfp;
            dfp = dfpAdd;
        }
        return dfp;
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public Dfp tan() {
        return DfpMath.tan(this);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public Dfp tanh() {
        Dfp dfpExp = DfpMath.exp(this);
        Dfp dfpExp2 = DfpMath.exp(negate());
        return dfpExp.subtract(dfpExp2).divide(dfpExp.add(dfpExp2));
    }

    @Override // org.apache.commons.math3.FieldElement
    public Dfp add(Dfp dfp) {
        int iAlign;
        int iComplement;
        int[] iArr;
        byte b = 1;
        if (this.field.getRadixDigits() != dfp.field.getRadixDigits()) {
            this.field.setIEEEFlagsBits(1);
            Dfp dfpNewInstance = newInstance(getZero());
            dfpNewInstance.nans = (byte) 3;
            return dotrap(1, ADD_TRAP, dfp, dfpNewInstance);
        }
        if (this.nans != 0 || dfp.nans != 0) {
            if (!isNaN()) {
                if (!dfp.isNaN()) {
                    byte b6 = this.nans;
                    if (b6 != 1 || dfp.nans != 0) {
                        byte b7 = dfp.nans;
                        if ((b7 != 1 || b6 != 0) && (b7 != 1 || b6 != 1 || this.sign != dfp.sign)) {
                            if (b7 == 1 && b6 == 1 && this.sign != dfp.sign) {
                                this.field.setIEEEFlagsBits(1);
                                Dfp dfpNewInstance2 = newInstance(getZero());
                                dfpNewInstance2.nans = (byte) 3;
                                return dotrap(1, ADD_TRAP, dfp, dfpNewInstance2);
                            }
                        }
                    }
                }
                return dfp;
            }
            return this;
        }
        Dfp dfpNewInstance3 = newInstance(this);
        Dfp dfpNewInstance4 = newInstance(dfp);
        Dfp dfpNewInstance5 = newInstance(getZero());
        byte b8 = dfpNewInstance3.sign;
        byte b9 = dfpNewInstance4.sign;
        dfpNewInstance3.sign = (byte) 1;
        dfpNewInstance4.sign = (byte) 1;
        byte b10 = compare(dfpNewInstance3, dfpNewInstance4) > 0 ? b8 : b9;
        int[] iArr2 = dfpNewInstance4.mant;
        int[] iArr3 = this.mant;
        if (iArr2[iArr3.length - 1] == 0) {
            dfpNewInstance4.exp = dfpNewInstance3.exp;
        }
        if (dfpNewInstance3.mant[iArr3.length - 1] == 0) {
            dfpNewInstance3.exp = dfpNewInstance4.exp;
        }
        int i5 = dfpNewInstance3.exp;
        int i6 = dfpNewInstance4.exp;
        if (i5 < i6) {
            iComplement = dfpNewInstance3.align(i6);
            iAlign = 0;
        } else {
            iAlign = dfpNewInstance4.align(i5);
            iComplement = 0;
        }
        if (b8 != b9) {
            if (b8 == b10) {
                iAlign = dfpNewInstance4.complement(iAlign);
            } else {
                iComplement = dfpNewInstance3.complement(iComplement);
            }
        }
        int i7 = 0;
        int i8 = 0;
        while (i7 < this.mant.length) {
            int i9 = dfpNewInstance3.mant[i7] + dfpNewInstance4.mant[i7] + i8;
            i8 = i9 / 10000;
            dfpNewInstance5.mant[i7] = i9 - (i8 * 10000);
            i7++;
            b = b;
        }
        byte b11 = b;
        dfpNewInstance5.exp = dfpNewInstance3.exp;
        dfpNewInstance5.sign = b10;
        if (i8 != 0 && b8 == b9) {
            int i10 = dfpNewInstance5.mant[0];
            dfpNewInstance5.shiftRight();
            dfpNewInstance5.mant[this.mant.length - 1] = i8;
            int iRound = dfpNewInstance5.round(i10);
            if (iRound != 0) {
                dfpNewInstance5 = dotrap(iRound, ADD_TRAP, dfp, dfpNewInstance5);
            }
        }
        int i11 = 0;
        while (true) {
            iArr = this.mant;
            if (i11 >= iArr.length || dfpNewInstance5.mant[iArr.length - 1] != 0) {
                break;
            }
            dfpNewInstance5.shiftLeft();
            if (i11 == 0) {
                dfpNewInstance5.mant[0] = iComplement + iAlign;
                iComplement = 0;
                iAlign = 0;
            }
            i11++;
        }
        if (dfpNewInstance5.mant[iArr.length - 1] == 0) {
            dfpNewInstance5.exp = 0;
            if (b8 != b9) {
                dfpNewInstance5.sign = b11;
            }
        }
        int iRound2 = dfpNewInstance5.round(iComplement + iAlign);
        return iRound2 != 0 ? dotrap(iRound2, ADD_TRAP, dfp, dfpNewInstance5) : dfpNewInstance5;
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public Dfp copySign(Dfp dfp) {
        byte b = this.sign;
        return ((b < 0 || dfp.sign < 0) && (b >= 0 || dfp.sign >= 0)) ? negate() : this;
    }

    @Override // org.apache.commons.math3.FieldElement
    public Dfp divide(Dfp dfp) {
        int[] iArr;
        int i5;
        int i6;
        int[] iArr2;
        int i7;
        int iRound;
        int[] iArr3;
        int i8 = 1;
        if (this.field.getRadixDigits() != dfp.field.getRadixDigits()) {
            this.field.setIEEEFlagsBits(1);
            Dfp dfpNewInstance = newInstance(getZero());
            dfpNewInstance.nans = (byte) 3;
            return dotrap(1, DIVIDE_TRAP, dfp, dfpNewInstance);
        }
        Dfp dfpNewInstance2 = newInstance(getZero());
        if (this.nans != 0 || dfp.nans != 0) {
            if (isNaN()) {
                return this;
            }
            if (dfp.isNaN()) {
                return dfp;
            }
            byte b = this.nans;
            if (b == 1 && dfp.nans == 0) {
                Dfp dfpNewInstance3 = newInstance(this);
                dfpNewInstance3.sign = (byte) (this.sign * dfp.sign);
                return dfpNewInstance3;
            }
            byte b6 = dfp.nans;
            if (b6 == 1 && b == 0) {
                Dfp dfpNewInstance4 = newInstance(getZero());
                dfpNewInstance4.sign = (byte) (this.sign * dfp.sign);
                return dfpNewInstance4;
            }
            if (b6 == 1 && b == 1) {
                this.field.setIEEEFlagsBits(1);
                Dfp dfpNewInstance5 = newInstance(getZero());
                dfpNewInstance5.nans = (byte) 3;
                return dotrap(1, DIVIDE_TRAP, dfp, dfpNewInstance5);
            }
        }
        int[] iArr4 = dfp.mant;
        int[] iArr5 = this.mant;
        int i9 = 2;
        if (iArr4[iArr5.length - 1] == 0) {
            this.field.setIEEEFlagsBits(2);
            Dfp dfpNewInstance6 = newInstance(getZero());
            dfpNewInstance6.sign = (byte) (this.sign * dfp.sign);
            dfpNewInstance6.nans = (byte) 1;
            return dotrap(2, DIVIDE_TRAP, dfp, dfpNewInstance6);
        }
        int[] iArr6 = new int[iArr5.length + 1];
        int[] iArr7 = new int[iArr5.length + 2];
        int[] iArr8 = new int[iArr5.length + 1];
        int i10 = 0;
        iArr6[iArr5.length] = 0;
        iArr7[iArr5.length] = 0;
        iArr7[iArr5.length + 1] = 0;
        iArr8[iArr5.length] = 0;
        int i11 = 0;
        while (true) {
            iArr = this.mant;
            if (i11 >= iArr.length) {
                break;
            }
            iArr6[i11] = iArr[i11];
            iArr7[i11] = 0;
            iArr8[i11] = 0;
            i11++;
        }
        int length = iArr.length + 1;
        int i12 = 0;
        int i13 = 0;
        while (true) {
            if (length < 0) {
                i5 = i8;
                i6 = i10;
                break;
            }
            int[] iArr9 = this.mant;
            int i14 = (iArr6[iArr9.length] * 10000) + iArr6[iArr9.length - i8];
            int[] iArr10 = dfp.mant;
            i5 = i8;
            int i15 = i14 / (iArr10[iArr9.length - 1] + 1);
            int i16 = (i14 + 1) / iArr10[iArr9.length - 1];
            int i17 = i10;
            while (i17 == 0) {
                i13 = (i15 + i16) / i9;
                int i18 = i10;
                int i19 = i18;
                i10 = i19;
                while (true) {
                    int[] iArr11 = this.mant;
                    if (i18 >= iArr11.length + 1) {
                        break;
                    }
                    int i20 = ((i18 < iArr11.length ? dfp.mant[i18] : i10) * i13) + i19;
                    int i21 = i20 / 10000;
                    iArr8[i18] = i20 - (i21 * 10000);
                    i18++;
                    iArr6 = iArr6;
                    i19 = i21;
                }
                iArr6 = iArr6;
                int i22 = i5;
                int i23 = i10;
                while (true) {
                    iArr3 = this.mant;
                    if (i23 >= iArr3.length + 1) {
                        break;
                    }
                    int i24 = (9999 - iArr8[i23]) + iArr6[i23] + i22;
                    i22 = i24 / 10000;
                    iArr8[i23] = i24 - (i22 * 10000);
                    i23++;
                }
                if (i22 == 0) {
                    i16 = i13 - 1;
                    i9 = 2;
                } else {
                    int i25 = ((iArr8[iArr3.length] * 10000) + iArr8[iArr3.length - 1]) / (dfp.mant[iArr3.length - 1] + 1);
                    i9 = 2;
                    if (i25 >= 2) {
                        i15 = i13 + i25;
                    } else {
                        int i26 = i10;
                        for (int length2 = iArr3.length - 1; length2 >= 0; length2--) {
                            int i27 = dfp.mant[length2];
                            int i28 = iArr8[length2];
                            if (i27 > i28) {
                                i26 = i5;
                            }
                            if (i27 < i28) {
                                break;
                            }
                        }
                        i17 = iArr8[this.mant.length] != 0 ? i10 : i26;
                        if (i17 == 0) {
                            i15 = i13 + 1;
                        }
                    }
                }
            }
            int[] iArr12 = iArr6;
            i6 = i10;
            iArr7[length] = i13;
            if (i13 != 0 || i12 != 0) {
                i12++;
            }
            if ((this.field.getRoundingMode() == DfpField.RoundingMode.ROUND_DOWN && i12 == this.mant.length) || i12 > this.mant.length) {
                break;
            }
            iArr12[i6] = i6;
            int i29 = i6;
            while (i29 < this.mant.length) {
                int i30 = i29 + 1;
                iArr12[i30] = iArr8[i29];
                i29 = i30;
            }
            length--;
            i8 = i5;
            iArr6 = iArr12;
            i10 = i6;
        }
        int[] iArr13 = this.mant;
        int length3 = iArr13.length;
        for (int length4 = iArr13.length + 1; length4 >= 0; length4--) {
            if (iArr7[length4] != 0) {
                length3 = length4;
                break;
            }
        }
        int i31 = i6;
        while (true) {
            iArr2 = this.mant;
            if (i31 >= iArr2.length) {
                break;
            }
            dfpNewInstance2.mant[(iArr2.length - i31) - 1] = iArr7[length3 - i31];
            i31++;
        }
        dfpNewInstance2.exp = ((this.exp - dfp.exp) + length3) - iArr2.length;
        dfpNewInstance2.sign = (byte) (this.sign == dfp.sign ? i5 : -1);
        if (dfpNewInstance2.mant[iArr2.length - 1] == 0) {
            i7 = i6;
            dfpNewInstance2.exp = i7;
        } else {
            i7 = i6;
        }
        if (length3 > iArr2.length - 1) {
            iRound = dfpNewInstance2.round(iArr7[length3 - iArr2.length]);
        } else {
            iRound = dfpNewInstance2.round(i7);
        }
        return iRound != 0 ? dotrap(iRound, DIVIDE_TRAP, dfp, dfpNewInstance2) : dfpNewInstance2;
    }

    public Dfp newInstance(int i5) {
        return new Dfp(getField(), i5);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public Dfp remainder(Dfp dfp) {
        Dfp dfpSubtract = subtract(divide(dfp).rint().multiply(dfp));
        if (dfpSubtract.mant[this.mant.length - 1] == 0) {
            dfpSubtract.sign = this.sign;
        }
        return dfpSubtract;
    }

    @Override // org.apache.commons.math3.FieldElement
    public Dfp subtract(Dfp dfp) {
        return add(dfp.negate());
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x00a7, code lost:
    
        if (r12.mant[r11.mant.length - 1] == 0) goto L43;
     */
    @Override // org.apache.commons.math3.FieldElement
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public org.apache.commons.math3.dfp.Dfp multiply(org.apache.commons.math3.dfp.Dfp r12) {
        /*
            Method dump skipped, instruction units count: 339
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.math3.dfp.Dfp.multiply(org.apache.commons.math3.dfp.Dfp):org.apache.commons.math3.dfp.Dfp");
    }

    public Dfp newInstance(long j6) {
        return new Dfp(getField(), j6);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public Dfp pow(double d) {
        return DfpMath.pow(this, newInstance(d));
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public Dfp subtract(double d) {
        return subtract(newInstance(d));
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public Dfp copySign(double d) {
        long jDoubleToLongBits = Double.doubleToLongBits(d);
        byte b = this.sign;
        return ((b < 0 || jDoubleToLongBits < 0) && (b >= 0 || jDoubleToLongBits >= 0)) ? negate() : this;
    }

    public Dfp newInstance(double d) {
        return new Dfp(getField(), d);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public Dfp pow(int i5) {
        return DfpMath.pow(this, i5);
    }

    public Dfp newInstance(Dfp dfp) {
        if (this.field.getRadixDigits() != dfp.field.getRadixDigits()) {
            this.field.setIEEEFlagsBits(1);
            Dfp dfpNewInstance = newInstance(getZero());
            dfpNewInstance.nans = (byte) 3;
            return dotrap(1, NEW_INSTANCE_TRAP, dfp, dfpNewInstance);
        }
        return new Dfp(dfp);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public Dfp pow(Dfp dfp) {
        return DfpMath.pow(this, dfp);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public Dfp remainder(double d) {
        return remainder(newInstance(d));
    }

    public Dfp(DfpField dfpField, byte b) {
        this(dfpField, b);
    }

    public Dfp(DfpField dfpField, int i5) {
        this(dfpField, i5);
    }

    public Dfp(DfpField dfpField, long j6) {
        boolean z6;
        this.mant = new int[dfpField.getRadixDigits()];
        int i5 = 0;
        this.nans = (byte) 0;
        this.field = dfpField;
        if (j6 == Long.MIN_VALUE) {
            j6++;
            z6 = true;
        } else {
            z6 = false;
        }
        if (j6 < 0) {
            this.sign = (byte) -1;
            j6 = -j6;
        } else {
            this.sign = (byte) 1;
        }
        this.exp = 0;
        while (j6 != 0) {
            int[] iArr = this.mant;
            int length = iArr.length;
            int i6 = this.exp;
            System.arraycopy(iArr, length - i6, iArr, (iArr.length - 1) - i6, i6);
            int[] iArr2 = this.mant;
            iArr2[iArr2.length - 1] = (int) (j6 % 10000);
            j6 /= 10000;
            this.exp++;
        }
        if (!z6) {
            return;
        }
        while (true) {
            int[] iArr3 = this.mant;
            if (i5 >= iArr3.length - 1) {
                return;
            }
            int i7 = iArr3[i5];
            if (i7 != 0) {
                iArr3[i5] = i7 + 1;
                return;
            }
            i5++;
        }
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public Dfp linearCombination(Dfp[] dfpArr, Dfp[] dfpArr2) {
        if (dfpArr.length == dfpArr2.length) {
            Dfp zero = getZero();
            for (int i5 = 0; i5 < dfpArr.length; i5++) {
                zero = zero.add(dfpArr[i5].multiply(dfpArr2[i5]));
            }
            return zero;
        }
        throw new DimensionMismatchException(dfpArr.length, dfpArr2.length);
    }

    public Dfp newInstance(String str) {
        return new Dfp(this.field, str);
    }

    public Dfp newInstance(byte b, byte b6) {
        return this.field.newDfp(b, b6);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public Dfp linearCombination(double[] dArr, Dfp[] dfpArr) {
        if (dArr.length == dfpArr.length) {
            Dfp zero = getZero();
            for (int i5 = 0; i5 < dArr.length; i5++) {
                zero = zero.add(dfpArr[i5].multiply(dArr[i5]));
            }
            return zero;
        }
        throw new DimensionMismatchException(dArr.length, dfpArr.length);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public long round() {
        return FastMath.round(toDouble());
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public Dfp linearCombination(Dfp dfp, Dfp dfp2, Dfp dfp3, Dfp dfp4) {
        return dfp.multiply(dfp2).add(dfp3.multiply(dfp4));
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public Dfp linearCombination(double d, Dfp dfp, double d6, Dfp dfp2) {
        return dfp.multiply(d).add(dfp2.multiply(d6));
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public Dfp linearCombination(Dfp dfp, Dfp dfp2, Dfp dfp3, Dfp dfp4, Dfp dfp5, Dfp dfp6) {
        return dfp.multiply(dfp2).add(dfp3.multiply(dfp4)).add(dfp5.multiply(dfp6));
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public Dfp linearCombination(double d, Dfp dfp, double d6, Dfp dfp2, double d7, Dfp dfp3) {
        return dfp.multiply(d).add(dfp2.multiply(d6)).add(dfp3.multiply(d7));
    }

    public Dfp(DfpField dfpField, double d) {
        this.mant = new int[dfpField.getRadixDigits()];
        this.sign = (byte) 1;
        this.exp = 0;
        this.nans = (byte) 0;
        this.field = dfpField;
        long jDoubleToLongBits = Double.doubleToLongBits(d);
        long j6 = jDoubleToLongBits & IEEEDouble.FRAC_MASK;
        int i5 = (int) ((9218868437227405312L & jDoubleToLongBits) >> 52);
        int i6 = i5 - 1023;
        if (i6 == -1023) {
            if (d == 0.0d) {
                if ((jDoubleToLongBits & Long.MIN_VALUE) != 0) {
                    this.sign = (byte) -1;
                    return;
                }
                return;
            } else {
                i6 = i5 - 1022;
                while ((j6 & IEEEDouble.FRAC_ASSUMED_HIGH_BIT) == 0) {
                    i6--;
                    j6 <<= 1;
                }
                j6 &= IEEEDouble.FRAC_MASK;
            }
        }
        if (i6 != 1024) {
            Dfp dfpMultiply = new Dfp(dfpField, j6).divide(new Dfp(dfpField, IEEEDouble.FRAC_ASSUMED_HIGH_BIT)).add(dfpField.getOne()).multiply(DfpMath.pow(dfpField.getTwo(), i6));
            dfpMultiply = (jDoubleToLongBits & Long.MIN_VALUE) != 0 ? dfpMultiply.negate() : dfpMultiply;
            int[] iArr = dfpMultiply.mant;
            int[] iArr2 = this.mant;
            System.arraycopy(iArr, 0, iArr2, 0, iArr2.length);
            this.sign = dfpMultiply.sign;
            this.exp = dfpMultiply.exp;
            this.nans = dfpMultiply.nans;
            return;
        }
        if (d != d) {
            this.sign = (byte) 1;
            this.nans = (byte) 3;
        } else if (d < 0.0d) {
            this.sign = (byte) -1;
            this.nans = (byte) 1;
        } else {
            this.sign = (byte) 1;
            this.nans = (byte) 1;
        }
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public Dfp linearCombination(Dfp dfp, Dfp dfp2, Dfp dfp3, Dfp dfp4, Dfp dfp5, Dfp dfp6, Dfp dfp7, Dfp dfp8) {
        return dfp.multiply(dfp2).add(dfp3.multiply(dfp4)).add(dfp5.multiply(dfp6)).add(dfp7.multiply(dfp8));
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public Dfp linearCombination(double d, Dfp dfp, double d6, Dfp dfp2, double d7, Dfp dfp3, double d8, Dfp dfp4) {
        return dfp.multiply(d).add(dfp2.multiply(d6)).add(dfp3.multiply(d7)).add(dfp4.multiply(d8));
    }

    public Dfp(Dfp dfp) {
        this.mant = (int[]) dfp.mant.clone();
        this.sign = dfp.sign;
        this.exp = dfp.exp;
        this.nans = dfp.nans;
        this.field = dfp.field;
    }

    @Override // org.apache.commons.math3.FieldElement
    public Dfp multiply(int i5) {
        if (i5 >= 0 && i5 < 10000) {
            return multiplyFast(i5);
        }
        return multiply(newInstance(i5));
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public Dfp multiply(double d) {
        return multiply(newInstance(d));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r16v0 */
    /* JADX WARN: Type inference failed for: r16v1 */
    /* JADX WARN: Type inference failed for: r16v2 */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v13 */
    /* JADX WARN: Type inference failed for: r7v14 */
    /* JADX WARN: Type inference failed for: r7v25 */
    /* JADX WARN: Type inference failed for: r7v26 */
    /* JADX WARN: Type inference failed for: r7v33 */
    /* JADX WARN: Type inference failed for: r7v34 */
    /* JADX WARN: Type inference failed for: r7v9 */
    public Dfp(DfpField dfpField, String str) {
        ?? r16;
        int iCharAt;
        int i5;
        int[] iArr;
        String str2 = str;
        this.mant = new int[dfpField.getRadixDigits()];
        boolean z6 = true;
        this.sign = (byte) 1;
        int i6 = 0;
        this.exp = 0;
        this.nans = (byte) 0;
        this.field = dfpField;
        int radixDigits = (getRadixDigits() * 4) + 8;
        char[] cArr = new char[radixDigits];
        if (str2.equals(POS_INFINITY_STRING)) {
            this.sign = (byte) 1;
            this.nans = (byte) 1;
            return;
        }
        if (str2.equals(NEG_INFINITY_STRING)) {
            this.sign = (byte) -1;
            this.nans = (byte) 1;
            return;
        }
        if (str2.equals(NAN_STRING)) {
            this.sign = (byte) 1;
            this.nans = (byte) 3;
            return;
        }
        int iIndexOf = str2.indexOf("e");
        iIndexOf = iIndexOf == -1 ? str2.indexOf(ExifInterface.LONGITUDE_EAST) : iIndexOf;
        if (iIndexOf != -1) {
            String strSubstring = str2.substring(0, iIndexOf);
            String strSubstring2 = str2.substring(iIndexOf + 1);
            int i7 = 0;
            boolean z7 = false;
            iCharAt = 0;
            while (i7 < strSubstring2.length()) {
                boolean z8 = z6;
                if (strSubstring2.charAt(i7) == '-') {
                    z7 = z8;
                } else if (strSubstring2.charAt(i7) >= '0' && strSubstring2.charAt(i7) <= '9') {
                    iCharAt = (strSubstring2.charAt(i7) + (iCharAt * 10)) - 48;
                }
                i7++;
                z6 = z8;
            }
            r16 = z6;
            iCharAt = z7 ? -iCharAt : iCharAt;
            str2 = strSubstring;
        } else {
            r16 = 1;
            iCharAt = 0;
        }
        if (str2.indexOf(ProcessIdUtil.DEFAULT_PROCESSID) != -1) {
            this.sign = (byte) -1;
        }
        int i8 = 0;
        ?? r7 = 0;
        int i9 = 0;
        while (true) {
            i5 = i6;
            if (str2.charAt(i8) >= '1' && str2.charAt(i8) <= '9') {
                break;
            }
            if (r7 != 0 && str2.charAt(i8) == '0') {
                i9--;
            }
            r7 = str2.charAt(i8) == '.' ? r16 : r7;
            i8++;
            if (i8 == str2.length()) {
                break;
            }
            i6 = i5;
            r7 = r7;
        }
        cArr[i5] = '0';
        cArr[r16] = '0';
        cArr[2] = '0';
        cArr[3] = '0';
        int i10 = 4;
        int i11 = i9;
        int i12 = i5;
        while (i8 != str2.length() && i10 != (this.mant.length * 4) + 5) {
            if (str2.charAt(i8) == '.') {
                i8++;
                i11 = i12;
                r7 = r16;
            } else if (str2.charAt(i8) < '0' || str2.charAt(i8) > '9') {
                i8++;
            } else {
                cArr[i10] = str2.charAt(i8);
                i10++;
                i8++;
                i12++;
            }
        }
        if (r7 != 0 && i10 != 4) {
            while (true) {
                i10--;
                if (i10 == 4 || cArr[i10] != '0') {
                    break;
                } else {
                    i12--;
                }
            }
        }
        if (r7 != 0 && i12 == 0) {
            i11 = i5;
        }
        i11 = r7 == 0 ? i10 - 4 : i11;
        int i13 = i12 + 3;
        while (i13 > 4 && cArr[i13] == '0') {
            i13--;
        }
        int i14 = ((400 - i11) - (iCharAt % 4)) % 4;
        int i15 = 4 - i14;
        int i16 = i11 + i14;
        while (true) {
            int i17 = i13 - i15;
            iArr = this.mant;
            if (i17 >= iArr.length * 4) {
                break;
            }
            for (int i18 = i5; i18 < 4; i18++) {
                i13++;
                cArr[i13] = '0';
            }
        }
        for (int length = iArr.length - 1; length >= 0; length--) {
            this.mant[length] = (cArr[i15 + 3] - '0') + ((cArr[i15 + 2] - '0') * 10) + ((cArr[i15 + 1] - '0') * 100) + ((cArr[i15] - '0') * 1000);
            i15 += 4;
        }
        this.exp = (i16 + iCharAt) / 4;
        if (i15 < radixDigits) {
            round((cArr[i15] - '0') * 1000);
        }
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public Dfp add(double d) {
        return add(newInstance(d));
    }

    public Dfp divide(int i5) {
        if (this.nans != 0) {
            if (isNaN()) {
                return this;
            }
            if (this.nans == 1) {
                return newInstance(this);
            }
        }
        if (i5 == 0) {
            this.field.setIEEEFlagsBits(2);
            Dfp dfpNewInstance = newInstance(getZero());
            dfpNewInstance.sign = this.sign;
            dfpNewInstance.nans = (byte) 1;
            return dotrap(2, DIVIDE_TRAP, getZero(), dfpNewInstance);
        }
        if (i5 >= 0 && i5 < 10000) {
            Dfp dfpNewInstance2 = newInstance(this);
            int i6 = 0;
            for (int length = this.mant.length - 1; length >= 0; length--) {
                int[] iArr = dfpNewInstance2.mant;
                int i7 = (i6 * 10000) + iArr[length];
                int i8 = i7 / i5;
                i6 = i7 - (i8 * i5);
                iArr[length] = i8;
            }
            if (dfpNewInstance2.mant[this.mant.length - 1] == 0) {
                dfpNewInstance2.shiftLeft();
                int i9 = i6 * 10000;
                int i10 = i9 / i5;
                i6 = i9 - (i10 * i5);
                dfpNewInstance2.mant[0] = i10;
            }
            int iRound = dfpNewInstance2.round((i6 * 10000) / i5);
            return iRound != 0 ? dotrap(iRound, DIVIDE_TRAP, dfpNewInstance2, dfpNewInstance2) : dfpNewInstance2;
        }
        this.field.setIEEEFlagsBits(1);
        Dfp dfpNewInstance3 = newInstance(getZero());
        dfpNewInstance3.nans = (byte) 3;
        return dotrap(1, DIVIDE_TRAP, dfpNewInstance3, dfpNewInstance3);
    }

    public Dfp(DfpField dfpField, byte b, byte b6) {
        this.field = dfpField;
        this.mant = new int[dfpField.getRadixDigits()];
        this.sign = b;
        this.exp = 0;
        this.nans = b6;
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public Dfp divide(double d) {
        return divide(newInstance(d));
    }

    public Dfp trap(int i5, String str, Dfp dfp, Dfp dfp2, Dfp dfp3) {
        return dfp2;
    }
}
