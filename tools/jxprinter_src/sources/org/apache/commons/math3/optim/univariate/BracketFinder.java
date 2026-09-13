package org.apache.commons.math3.optim.univariate;

import androidx.collection.a;
import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.TooManyEvaluationsException;
import org.apache.commons.math3.optim.nonlinear.scalar.GoalType;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.IntegerSequence;
import org.opencv.videoio.Videoio;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class BracketFinder {
    private static final double EPS_MIN = 1.0E-21d;
    private static final double GOLD = 1.618034d;
    private IntegerSequence.Incrementor evaluations;
    private double fHi;
    private double fLo;
    private double fMid;
    private final double growLimit;
    private double hi;
    private double lo;
    private double mid;

    public BracketFinder() {
        this(100.0d, Videoio.CAP_QT);
    }

    private double eval(UnivariateFunction univariateFunction, double d) {
        try {
            this.evaluations.increment();
            return univariateFunction.value(d);
        } catch (MaxCountExceededException e) {
            throw new TooManyEvaluationsException(e.getMax());
        }
    }

    public int getEvaluations() {
        return this.evaluations.getCount();
    }

    public double getFHi() {
        return this.fHi;
    }

    public double getFLo() {
        return this.fLo;
    }

    public double getFMid() {
        return this.fMid;
    }

    public double getHi() {
        return this.hi;
    }

    public double getLo() {
        return this.lo;
    }

    public int getMaxEvaluations() {
        return this.evaluations.getMaximalCount();
    }

    public double getMid() {
        return this.mid;
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0051  */
    /* JADX WARN: Code duplicated, block: B:24:0x006c  */
    /* JADX WARN: Code duplicated, block: B:25:0x0072  */
    /* JADX WARN: Code duplicated, block: B:28:0x0097  */
    /* JADX WARN: Code duplicated, block: B:30:0x009d  */
    /* JADX WARN: Code duplicated, block: B:33:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:37:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:40:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:46:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:48:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:49:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:51:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:59:0x0108  */
    /* JADX WARN: Code duplicated, block: B:68:0x00a6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:69:0x00a6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:70:0x00b7 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:71:0x00b7 A[SYNTHETIC] */
    public void search(UnivariateFunction univariateFunction, GoalType goalType, double d, double d6) {
        double d7;
        double d8;
        double d9;
        double d10;
        double d11;
        double d12;
        boolean z6;
        double d13;
        double d14;
        double d15;
        double d16;
        double dEval;
        double dEval2;
        this.evaluations = this.evaluations.withStart(0);
        boolean z7 = goalType == GoalType.MINIMIZE;
        double dEval3 = eval(univariateFunction, d);
        double dEval4 = eval(univariateFunction, d6);
        if (!z7 ? dEval3 > dEval4 : dEval3 < dEval4) {
            d8 = d;
            d7 = d6;
        } else {
            dEval4 = dEval3;
            dEval3 = dEval4;
            d7 = d;
            d8 = d6;
        }
        double dA = a.a(d7, d8, GOLD, d7);
        double dEval5 = eval(univariateFunction, dA);
        while (true) {
            if (z7) {
                if (dEval5 < dEval4) {
                    double d17 = d7 - d8;
                    double d18 = (dEval4 - dEval5) * d17;
                    double d19 = d7 - dA;
                    double d20 = (dEval4 - dEval3) * d19;
                    d11 = d20 - d18;
                    if (FastMath.abs(d11) < EPS_MIN) {
                        d12 = 2.0E-21d;
                    } else {
                        d12 = d11 * 2.0d;
                    }
                    z6 = z7;
                    d10 = d7 - (((d19 * d20) - (d17 * d18)) / d12);
                    d13 = dA;
                    d14 = d13 - d7;
                    dA = (this.growLimit * d14) + d7;
                    d15 = d10 - d13;
                    if ((d7 - d10) * d15 > 0.0d) {
                        dEval2 = eval(univariateFunction, d10);
                        if (z6) {
                            if (dEval2 < dEval5) {
                                dEval3 = dEval4;
                                dEval4 = dEval2;
                                d9 = d13;
                            }
                            if (z6) {
                                if (dEval2 > dEval4) {
                                    dEval5 = dEval2;
                                    d9 = d10;
                                    d10 = d7;
                                    d7 = d8;
                                }
                                d10 = (d14 * GOLD) + d13;
                                dEval = eval(univariateFunction, d10);
                            } else {
                                if (dEval2 < dEval4) {
                                    dEval5 = dEval2;
                                    d9 = d10;
                                    d10 = d7;
                                    d7 = d8;
                                }
                                d10 = (d14 * GOLD) + d13;
                                dEval = eval(univariateFunction, d10);
                            }
                        } else {
                            if (dEval2 > dEval5) {
                                dEval3 = dEval4;
                                dEval4 = dEval2;
                                d9 = d13;
                            }
                            if (z6) {
                                if (dEval2 > dEval4) {
                                    dEval5 = dEval2;
                                    d9 = d10;
                                    d10 = d7;
                                    d7 = d8;
                                }
                                d10 = (d14 * GOLD) + d13;
                                dEval = eval(univariateFunction, d10);
                            } else {
                                if (dEval2 < dEval4) {
                                    dEval5 = dEval2;
                                    d9 = d10;
                                    d10 = d7;
                                    d7 = d8;
                                }
                                d10 = (d14 * GOLD) + d13;
                                dEval = eval(univariateFunction, d10);
                            }
                        }
                    } else {
                        d16 = d10 - dA;
                        if ((dA - d13) * d16 >= 0.0d) {
                            dEval3 = dEval4;
                            d8 = d7;
                            d7 = d13;
                            dEval4 = dEval5;
                            dEval5 = eval(univariateFunction, dA);
                        } else if ((d13 - d10) * d16 > 0.0d) {
                            dEval = eval(univariateFunction, d10);
                            if (z6 ? dEval > dEval5 : dEval < dEval5) {
                                double d21 = (d15 * GOLD) + d10;
                                double dEval6 = eval(univariateFunction, d21);
                                dEval4 = dEval;
                                dA = d21;
                                dEval3 = dEval5;
                                dEval5 = dEval6;
                                d8 = d13;
                                d7 = d10;
                            }
                        } else {
                            d10 = (d14 * GOLD) + d13;
                            dEval = eval(univariateFunction, d10);
                        }
                        z7 = z6;
                    }
                    dEval3 = dEval4;
                    d8 = d7;
                    d7 = d13;
                    dEval4 = dEval5;
                    dEval5 = dEval;
                    dA = d10;
                    z7 = z6;
                } else {
                    d9 = dA;
                    d10 = d7;
                    d7 = d8;
                }
            } else if (dEval5 > dEval4) {
                double d110 = d7 - d8;
                double d111 = (dEval4 - dEval5) * d110;
                double d112 = d7 - dA;
                double d22 = (dEval4 - dEval3) * d112;
                d11 = d22 - d111;
                if (FastMath.abs(d11) < EPS_MIN) {
                    d12 = 2.0E-21d;
                } else {
                    d12 = d11 * 2.0d;
                }
                z6 = z7;
                d10 = d7 - (((d112 * d22) - (d110 * d111)) / d12);
                d13 = dA;
                d14 = d13 - d7;
                dA = (this.growLimit * d14) + d7;
                d15 = d10 - d13;
                if ((d7 - d10) * d15 > 0.0d) {
                    dEval2 = eval(univariateFunction, d10);
                    if (z6) {
                        if (dEval2 < dEval5) {
                            dEval3 = dEval4;
                            dEval4 = dEval2;
                            d9 = d13;
                        }
                        if (z6) {
                            if (dEval2 > dEval4) {
                                dEval5 = dEval2;
                                d9 = d10;
                                d10 = d7;
                                d7 = d8;
                            }
                            d10 = (d14 * GOLD) + d13;
                            dEval = eval(univariateFunction, d10);
                        } else {
                            if (dEval2 < dEval4) {
                                dEval5 = dEval2;
                                d9 = d10;
                                d10 = d7;
                                d7 = d8;
                            }
                            d10 = (d14 * GOLD) + d13;
                            dEval = eval(univariateFunction, d10);
                        }
                    } else {
                        if (dEval2 > dEval5) {
                            dEval3 = dEval4;
                            dEval4 = dEval2;
                            d9 = d13;
                        }
                        if (z6) {
                            if (dEval2 > dEval4) {
                                dEval5 = dEval2;
                                d9 = d10;
                                d10 = d7;
                                d7 = d8;
                            }
                            d10 = (d14 * GOLD) + d13;
                            dEval = eval(univariateFunction, d10);
                        } else {
                            if (dEval2 < dEval4) {
                                dEval5 = dEval2;
                                d9 = d10;
                                d10 = d7;
                                d7 = d8;
                            }
                            d10 = (d14 * GOLD) + d13;
                            dEval = eval(univariateFunction, d10);
                        }
                    }
                } else {
                    d16 = d10 - dA;
                    if ((dA - d13) * d16 >= 0.0d) {
                        dEval3 = dEval4;
                        d8 = d7;
                        d7 = d13;
                        dEval4 = dEval5;
                        dEval5 = eval(univariateFunction, dA);
                    } else if ((d13 - d10) * d16 > 0.0d) {
                        dEval = eval(univariateFunction, d10);
                        if (z6) {
                        }
                    } else {
                        d10 = (d14 * GOLD) + d13;
                        dEval = eval(univariateFunction, d10);
                    }
                    z7 = z6;
                }
                dEval3 = dEval4;
                d8 = d7;
                d7 = d13;
                dEval4 = dEval5;
                dEval5 = dEval;
                dA = d10;
                z7 = z6;
            } else {
                d9 = dA;
                d10 = d7;
                d7 = d8;
            }
            this.lo = d7;
            this.fLo = dEval3;
            this.mid = d10;
            this.fMid = dEval4;
            this.hi = d9;
            this.fHi = dEval5;
            if (d7 > d9) {
                this.lo = d9;
                this.hi = d7;
                this.fLo = dEval5;
                this.fHi = dEval3;
                return;
            }
            return;
        }
    }

    public BracketFinder(double d, int i5) {
        if (d <= 0.0d) {
            throw new NotStrictlyPositiveException(Double.valueOf(d));
        }
        if (i5 <= 0) {
            throw new NotStrictlyPositiveException(Integer.valueOf(i5));
        }
        this.growLimit = d;
        this.evaluations = IntegerSequence.Incrementor.create().withMaximalCount(i5);
    }
}
