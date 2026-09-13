package org.apache.commons.math3.optimization.univariate;

import androidx.collection.a;
import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.TooManyEvaluationsException;
import org.apache.commons.math3.optimization.GoalType;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.Incrementor;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public class BracketFinder {
    private static final double EPS_MIN = 1.0E-21d;
    private static final double GOLD = 1.618034d;
    private final Incrementor evaluations;
    private double fHi;
    private double fLo;
    private double fMid;
    private final double growLimit;
    private double hi;
    private double lo;
    private double mid;

    public BracketFinder() {
        this(100.0d, 50);
    }

    private double eval(UnivariateFunction univariateFunction, double d) {
        try {
            this.evaluations.incrementCount();
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

    /* JADX WARN: Code duplicated, block: B:24:0x0052  */
    /* JADX WARN: Code duplicated, block: B:26:0x006d  */
    /* JADX WARN: Code duplicated, block: B:27:0x0073  */
    /* JADX WARN: Code duplicated, block: B:30:0x009a  */
    /* JADX WARN: Code duplicated, block: B:32:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:35:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:39:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:42:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:49:0x00d7  */
    /* JADX WARN: Code duplicated, block: B:51:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:52:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:54:0x00f2  */
    /* JADX WARN: Code duplicated, block: B:62:0x0115  */
    /* JADX WARN: Code duplicated, block: B:71:0x00a9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:72:0x00a9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:73:0x00be A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:74:0x00be A[SYNTHETIC] */
    public void search(UnivariateFunction univariateFunction, GoalType goalType, double d, double d6) {
        double d7;
        double d8;
        double d9;
        double d10;
        double d11;
        double d12;
        double d13;
        boolean z6;
        double d14;
        double d15;
        double d16;
        double d17;
        double d18;
        double d19;
        double d20;
        double dEval;
        double dEval2;
        this.evaluations.resetCount();
        boolean z7 = goalType == GoalType.MINIMIZE;
        double dEval3 = eval(univariateFunction, d);
        dEval3 = eval(univariateFunction, d6);
        if (!z7 ? dEval3 > dEval3 : dEval3 < dEval3) {
            d8 = d;
            d7 = d6;
        } else {
            dEval3 = dEval3;
            dEval3 = dEval3;
            d7 = d;
            d8 = d6;
        }
        double dA = a.a(d7, d8, GOLD, d7);
        double dEval4 = eval(univariateFunction, dA);
        while (true) {
            if (z7) {
                if (dEval4 < dEval3) {
                    double d21 = d7 - d8;
                    double d22 = (dEval3 - dEval4) * d21;
                    double d23 = d7 - dA;
                    double d24 = (dEval3 - dEval3) * d23;
                    d12 = d24 - d22;
                    if (FastMath.abs(d12) < EPS_MIN) {
                        d13 = 2.0E-21d;
                    } else {
                        d13 = d12 * 2.0d;
                    }
                    z6 = z7;
                    d14 = dA;
                    d15 = d7 - (((d23 * d24) - (d21 * d22)) / d13);
                    d16 = dEval3;
                    d17 = d14 - d7;
                    d18 = (this.growLimit * d17) + d7;
                    d19 = d15 - d14;
                    if ((d7 - d15) * d19 > 0.0d) {
                        dEval2 = eval(univariateFunction, d15);
                        if (z6) {
                            if (dEval2 < dEval4) {
                                double d25 = dEval3;
                                dEval3 = dEval2;
                                d10 = d25;
                                d11 = d15;
                                d9 = d14;
                            }
                            if (z6) {
                                if (dEval2 > dEval3) {
                                    dEval4 = dEval2;
                                    d10 = d16;
                                    d9 = d15;
                                    d11 = d7;
                                    d7 = d8;
                                }
                                d15 = (d17 * GOLD) + d14;
                                dEval = eval(univariateFunction, d15);
                            } else {
                                if (dEval2 < dEval3) {
                                    dEval4 = dEval2;
                                    d10 = d16;
                                    d9 = d15;
                                    d11 = d7;
                                    d7 = d8;
                                }
                                d15 = (d17 * GOLD) + d14;
                                dEval = eval(univariateFunction, d15);
                            }
                        } else {
                            if (dEval2 > dEval4) {
                                double d26 = dEval3;
                                dEval3 = dEval2;
                                d10 = d26;
                                d11 = d15;
                                d9 = d14;
                            }
                            if (z6) {
                                if (dEval2 > dEval3) {
                                    dEval4 = dEval2;
                                    d10 = d16;
                                    d9 = d15;
                                    d11 = d7;
                                    d7 = d8;
                                }
                                d15 = (d17 * GOLD) + d14;
                                dEval = eval(univariateFunction, d15);
                            } else {
                                if (dEval2 < dEval3) {
                                    dEval4 = dEval2;
                                    d10 = d16;
                                    d9 = d15;
                                    d11 = d7;
                                    d7 = d8;
                                }
                                d15 = (d17 * GOLD) + d14;
                                dEval = eval(univariateFunction, d15);
                            }
                        }
                        z7 = z6;
                    } else {
                        d20 = d15 - d18;
                        if ((d18 - d14) * d20 >= 0.0d) {
                            double d27 = dEval4;
                            dEval4 = eval(univariateFunction, d18);
                            dA = d18;
                            dEval3 = d27;
                            d8 = d7;
                            d7 = d14;
                        } else if ((d14 - d15) * d20 > 0.0d) {
                            dEval = eval(univariateFunction, d15);
                            if (z6 ? dEval > dEval4 : dEval < dEval4) {
                                double d28 = (d19 * GOLD) + d15;
                                double dEval5 = eval(univariateFunction, d28);
                                d7 = d15;
                                dEval3 = dEval;
                                dEval3 = dEval4;
                                dA = d28;
                                dEval4 = dEval5;
                                d8 = d14;
                            }
                        } else {
                            d15 = (d17 * GOLD) + d14;
                            dEval = eval(univariateFunction, d15);
                        }
                        z7 = z6;
                    }
                    double d29 = dEval4;
                    dEval4 = dEval;
                    dEval3 = d29;
                    dA = d15;
                    d8 = d7;
                    d7 = d14;
                    z7 = z6;
                } else {
                    d9 = dA;
                    d10 = dEval3;
                    d11 = d7;
                    d7 = d8;
                }
            } else if (dEval4 > dEval3) {
                double d210 = d7 - d8;
                double d211 = (dEval3 - dEval4) * d210;
                double d212 = d7 - dA;
                double d213 = (dEval3 - dEval3) * d212;
                d12 = d213 - d211;
                if (FastMath.abs(d12) < EPS_MIN) {
                    d13 = 2.0E-21d;
                } else {
                    d13 = d12 * 2.0d;
                }
                z6 = z7;
                d14 = dA;
                d15 = d7 - (((d212 * d213) - (d210 * d211)) / d13);
                d16 = dEval3;
                d17 = d14 - d7;
                d18 = (this.growLimit * d17) + d7;
                d19 = d15 - d14;
                if ((d7 - d15) * d19 > 0.0d) {
                    dEval2 = eval(univariateFunction, d15);
                    if (z6) {
                        if (dEval2 < dEval4) {
                            double d214 = dEval3;
                            dEval3 = dEval2;
                            d10 = d214;
                            d11 = d15;
                            d9 = d14;
                        }
                        if (z6) {
                            if (dEval2 > dEval3) {
                                dEval4 = dEval2;
                                d10 = d16;
                                d9 = d15;
                                d11 = d7;
                                d7 = d8;
                            }
                            d15 = (d17 * GOLD) + d14;
                            dEval = eval(univariateFunction, d15);
                        } else {
                            if (dEval2 < dEval3) {
                                dEval4 = dEval2;
                                d10 = d16;
                                d9 = d15;
                                d11 = d7;
                                d7 = d8;
                            }
                            d15 = (d17 * GOLD) + d14;
                            dEval = eval(univariateFunction, d15);
                        }
                    } else {
                        if (dEval2 > dEval4) {
                            double d215 = dEval3;
                            dEval3 = dEval2;
                            d10 = d215;
                            d11 = d15;
                            d9 = d14;
                        }
                        if (z6) {
                            if (dEval2 > dEval3) {
                                dEval4 = dEval2;
                                d10 = d16;
                                d9 = d15;
                                d11 = d7;
                                d7 = d8;
                            }
                            d15 = (d17 * GOLD) + d14;
                            dEval = eval(univariateFunction, d15);
                        } else {
                            if (dEval2 < dEval3) {
                                dEval4 = dEval2;
                                d10 = d16;
                                d9 = d15;
                                d11 = d7;
                                d7 = d8;
                            }
                            d15 = (d17 * GOLD) + d14;
                            dEval = eval(univariateFunction, d15);
                        }
                    }
                    z7 = z6;
                } else {
                    d20 = d15 - d18;
                    if ((d18 - d14) * d20 >= 0.0d) {
                        double d216 = dEval4;
                        dEval4 = eval(univariateFunction, d18);
                        dA = d18;
                        dEval3 = d216;
                        d8 = d7;
                        d7 = d14;
                    } else if ((d14 - d15) * d20 > 0.0d) {
                        dEval = eval(univariateFunction, d15);
                        if (z6) {
                        }
                    } else {
                        d15 = (d17 * GOLD) + d14;
                        dEval = eval(univariateFunction, d15);
                    }
                    z7 = z6;
                }
                double d217 = dEval4;
                dEval4 = dEval;
                dEval3 = d217;
                dA = d15;
                d8 = d7;
                d7 = d14;
                z7 = z6;
            } else {
                d9 = dA;
                d10 = dEval3;
                d11 = d7;
                d7 = d8;
            }
            this.lo = d7;
            this.fLo = d10;
            this.mid = d11;
            this.fMid = dEval3;
            this.hi = d9;
            this.fHi = dEval4;
            if (d7 > d9) {
                this.lo = d9;
                this.hi = d7;
                this.fLo = dEval4;
                this.fHi = d10;
                return;
            }
            return;
        }
    }

    public BracketFinder(double d, int i5) {
        Incrementor incrementor = new Incrementor();
        this.evaluations = incrementor;
        if (d <= 0.0d) {
            throw new NotStrictlyPositiveException(Double.valueOf(d));
        }
        if (i5 <= 0) {
            throw new NotStrictlyPositiveException(Integer.valueOf(i5));
        }
        this.growLimit = d;
        incrementor.setMaximalCount(i5);
    }
}
