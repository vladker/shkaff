package org.apache.commons.math3.dfp;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class DfpDec extends Dfp {

    /* JADX INFO: renamed from: org.apache.commons.math3.dfp.DfpDec$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$commons$math3$dfp$DfpField$RoundingMode;

        static {
            int[] iArr = new int[DfpField.RoundingMode.values().length];
            $SwitchMap$org$apache$commons$math3$dfp$DfpField$RoundingMode = iArr;
            try {
                iArr[DfpField.RoundingMode.ROUND_DOWN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$commons$math3$dfp$DfpField$RoundingMode[DfpField.RoundingMode.ROUND_UP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$commons$math3$dfp$DfpField$RoundingMode[DfpField.RoundingMode.ROUND_HALF_UP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$apache$commons$math3$dfp$DfpField$RoundingMode[DfpField.RoundingMode.ROUND_HALF_DOWN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$apache$commons$math3$dfp$DfpField$RoundingMode[DfpField.RoundingMode.ROUND_HALF_EVEN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$org$apache$commons$math3$dfp$DfpField$RoundingMode[DfpField.RoundingMode.ROUND_HALF_ODD.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$org$apache$commons$math3$dfp$DfpField$RoundingMode[DfpField.RoundingMode.ROUND_CEIL.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$org$apache$commons$math3$dfp$DfpField$RoundingMode[DfpField.RoundingMode.ROUND_FLOOR.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    public DfpDec(DfpField dfpField) {
        super(dfpField);
    }

    public int getDecimalDigits() {
        return (getRadixDigits() * 4) - 3;
    }

    @Override // org.apache.commons.math3.dfp.Dfp
    public Dfp newInstance() {
        return new DfpDec(getField());
    }

    @Override // org.apache.commons.math3.dfp.Dfp
    public Dfp nextAfter(Dfp dfp) {
        Dfp dfpCopysign;
        if (getField().getRadixDigits() != dfp.getField().getRadixDigits()) {
            getField().setIEEEFlagsBits(1);
            Dfp dfpNewInstance = newInstance(getZero());
            dfpNewInstance.nans = (byte) 3;
            return dotrap(1, "nextAfter", dfp, dfpNewInstance);
        }
        boolean zLessThan = lessThan(dfp);
        if (equals(dfp)) {
            return newInstance(dfp);
        }
        if (lessThan(getZero())) {
            zLessThan = !zLessThan;
        }
        if (zLessThan) {
            Dfp dfpCopysign2 = Dfp.copysign(power10((intLog10() - getDecimalDigits()) + 1), this);
            if (equals(getZero())) {
                dfpCopysign2 = power10K((-32768) - this.mant.length);
            }
            dfpCopysign = dfpCopysign2.equals(getZero()) ? Dfp.copysign(newInstance(getZero()), this) : add(dfpCopysign2);
        } else {
            Dfp dfpCopysign3 = Dfp.copysign(power10(intLog10()), this);
            Dfp dfpDivide = equals(dfpCopysign3) ? dfpCopysign3.divide(power10(getDecimalDigits())) : dfpCopysign3.divide(power10(getDecimalDigits() - 1));
            if (equals(getZero())) {
                dfpDivide = power10K((-32768) - this.mant.length);
            }
            dfpCopysign = dfpDivide.equals(getZero()) ? Dfp.copysign(newInstance(getZero()), this) : subtract(dfpDivide);
        }
        if (dfpCopysign.classify() == 1 && classify() != 1) {
            getField().setIEEEFlagsBits(16);
            dfpCopysign = dotrap(16, "nextAfter", dfp, dfpCopysign);
        }
        if (!dfpCopysign.equals(getZero()) || equals(getZero())) {
            return dfpCopysign;
        }
        getField().setIEEEFlagsBits(16);
        return dotrap(16, "nextAfter", dfp, dfpCopysign);
    }

    /* JADX WARN: Code duplicated, block: B:60:0x00bc A[LOOP:3: B:58:0x00b7->B:60:0x00bc, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:62:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:80:0x00c8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:81:? A[SYNTHETIC] */
    @Override // org.apache.commons.math3.dfp.Dfp
    public int round(int i5) {
        int i6;
        int i7;
        int[] iArr;
        int[] iArr2 = this.mant;
        int i8 = iArr2[iArr2.length - 1];
        if (i8 == 0) {
            return 0;
        }
        int length = iArr2.length * 4;
        int i9 = 1000;
        while (i9 > i8) {
            i9 /= 10;
            length--;
        }
        int decimalDigits = getDecimalDigits();
        int i10 = length - decimalDigits;
        int i11 = i10 / 4;
        int i12 = 1;
        for (int i13 = 0; i13 < i10 % 4; i13++) {
            i12 *= 10;
        }
        int[] iArr3 = this.mant;
        int i14 = iArr3[i11];
        if (i12 <= 1 && decimalDigits == (iArr3.length * 4) - 3) {
            return super.round(i5);
        }
        if (i12 == 1) {
            int i15 = i11 - 1;
            int i16 = iArr3[i15];
            i6 = (i16 / 1000) % 10;
            int i17 = i16 % 1000;
            iArr3[i15] = i17;
            i7 = i5 | i17;
        } else {
            i6 = ((i14 * 10) / i12) % 10;
            i7 = i5 | (i14 % (i12 / 10));
        }
        for (int i18 = 0; i18 < i11; i18++) {
            int[] iArr4 = this.mant;
            i7 |= iArr4[i18];
            iArr4[i18] = 0;
        }
        int i19 = i14 / i12;
        this.mant[i11] = i19 * i12;
        switch (AnonymousClass1.$SwitchMap$org$apache$commons$math3$dfp$DfpField$RoundingMode[getField().getRoundingMode().ordinal()]) {
            case 1:
                break;
            case 2:
                if (i6 != 0 || i7 != 0) {
                    while (true) {
                        iArr = this.mant;
                        if (i11 < iArr.length) {
                            int i20 = iArr[i11] + i12;
                            i12 = i20 / 10000;
                            iArr[i11] = i20 % 10000;
                            i11++;
                        } else if (i12 != 0) {
                            shiftRight();
                            int[] iArr5 = this.mant;
                            iArr5[iArr5.length - 1] = i12;
                        }
                    }
                }
                break;
            case 3:
                if (i6 >= 5) {
                    while (true) {
                        iArr = this.mant;
                        if (i11 < iArr.length) {
                            int i21 = iArr[i11] + i12;
                            i12 = i21 / 10000;
                            iArr[i11] = i21 % 10000;
                            i11++;
                        } else if (i12 != 0) {
                            shiftRight();
                            int[] iArr6 = this.mant;
                            iArr6[iArr6.length - 1] = i12;
                        }
                    }
                }
                break;
            case 4:
                if (i6 > 5) {
                    while (true) {
                        iArr = this.mant;
                        if (i11 < iArr.length) {
                            int i22 = iArr[i11] + i12;
                            i12 = i22 / 10000;
                            iArr[i11] = i22 % 10000;
                            i11++;
                        } else if (i12 != 0) {
                            shiftRight();
                            int[] iArr7 = this.mant;
                            iArr7[iArr7.length - 1] = i12;
                        }
                    }
                }
                break;
            case 5:
                if (i6 > 5 || ((i6 == 5 && i7 != 0) || (i6 == 5 && i7 == 0 && (i19 & 1) == 1))) {
                    while (true) {
                        iArr = this.mant;
                        if (i11 < iArr.length) {
                            int i23 = iArr[i11] + i12;
                            i12 = i23 / 10000;
                            iArr[i11] = i23 % 10000;
                            i11++;
                        } else if (i12 != 0) {
                            shiftRight();
                            int[] iArr8 = this.mant;
                            iArr8[iArr8.length - 1] = i12;
                        }
                    }
                }
                break;
            case 6:
                if (i6 > 5 || ((i6 == 5 && i7 != 0) || (i6 == 5 && i7 == 0 && (i19 & 1) == 0))) {
                    while (true) {
                        iArr = this.mant;
                        if (i11 < iArr.length) {
                            int i24 = iArr[i11] + i12;
                            i12 = i24 / 10000;
                            iArr[i11] = i24 % 10000;
                            i11++;
                        } else if (i12 != 0) {
                            shiftRight();
                            int[] iArr9 = this.mant;
                            iArr9[iArr9.length - 1] = i12;
                        }
                    }
                }
                break;
            case 7:
                if (this.sign == 1 && (i6 != 0 || i7 != 0)) {
                    while (true) {
                        iArr = this.mant;
                        if (i11 < iArr.length) {
                            int i25 = iArr[i11] + i12;
                            i12 = i25 / 10000;
                            iArr[i11] = i25 % 10000;
                            i11++;
                        } else if (i12 != 0) {
                            shiftRight();
                            int[] iArr10 = this.mant;
                            iArr10[iArr10.length - 1] = i12;
                        }
                    }
                }
                break;
            default:
                if (this.sign == -1 && (i6 != 0 || i7 != 0)) {
                    while (true) {
                        iArr = this.mant;
                        if (i11 < iArr.length) {
                            int i26 = iArr[i11] + i12;
                            i12 = i26 / 10000;
                            iArr[i11] = i26 % 10000;
                            i11++;
                        } else if (i12 != 0) {
                            shiftRight();
                            int[] iArr11 = this.mant;
                            iArr11[iArr11.length - 1] = i12;
                        }
                    }
                }
                break;
        }
        int i27 = this.exp;
        if (i27 < -32767) {
            getField().setIEEEFlagsBits(8);
            return 8;
        }
        if (i27 > 32768) {
            getField().setIEEEFlagsBits(4);
            return 4;
        }
        if (i6 == 0 && i7 == 0) {
            return 0;
        }
        getField().setIEEEFlagsBits(16);
        return 16;
    }

    public DfpDec(DfpField dfpField, byte b) {
        super(dfpField, b);
    }

    @Override // org.apache.commons.math3.dfp.Dfp
    public Dfp newInstance(byte b) {
        return new DfpDec(getField(), b);
    }

    public DfpDec(DfpField dfpField, int i5) {
        super(dfpField, i5);
    }

    @Override // org.apache.commons.math3.dfp.Dfp
    public Dfp newInstance(int i5) {
        return new DfpDec(getField(), i5);
    }

    public DfpDec(DfpField dfpField, long j6) {
        super(dfpField, j6);
    }

    @Override // org.apache.commons.math3.dfp.Dfp
    public Dfp newInstance(long j6) {
        return new DfpDec(getField(), j6);
    }

    public DfpDec(DfpField dfpField, double d) {
        super(dfpField, d);
        round(0);
    }

    @Override // org.apache.commons.math3.dfp.Dfp
    public Dfp newInstance(double d) {
        return new DfpDec(getField(), d);
    }

    @Override // org.apache.commons.math3.dfp.Dfp
    public Dfp newInstance(Dfp dfp) {
        if (getField().getRadixDigits() != dfp.getField().getRadixDigits()) {
            getField().setIEEEFlagsBits(1);
            Dfp dfpNewInstance = newInstance(getZero());
            dfpNewInstance.nans = (byte) 3;
            return dotrap(1, "newInstance", dfp, dfpNewInstance);
        }
        return new DfpDec(dfp);
    }

    public DfpDec(Dfp dfp) {
        super(dfp);
        round(0);
    }

    public DfpDec(DfpField dfpField, String str) {
        super(dfpField, str);
        round(0);
    }

    public DfpDec(DfpField dfpField, byte b, byte b6) {
        super(dfpField, b, b6);
    }

    @Override // org.apache.commons.math3.dfp.Dfp
    public Dfp newInstance(String str) {
        return new DfpDec(getField(), str);
    }

    @Override // org.apache.commons.math3.dfp.Dfp
    public Dfp newInstance(byte b, byte b6) {
        return new DfpDec(getField(), b, b6);
    }
}
