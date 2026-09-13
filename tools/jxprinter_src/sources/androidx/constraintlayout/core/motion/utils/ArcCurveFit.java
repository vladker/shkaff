package androidx.constraintlayout.core.motion.utils;

import androidx.collection.a;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class ArcCurveFit extends CurveFit {
    public static final int ARC_ABOVE = 5;
    public static final int ARC_BELOW = 4;
    public static final int ARC_START_FLIP = 3;
    public static final int ARC_START_HORIZONTAL = 2;
    public static final int ARC_START_LINEAR = 0;
    public static final int ARC_START_VERTICAL = 1;
    private static final int DOWN_ARC = 4;
    private static final int START_HORIZONTAL = 2;
    private static final int START_LINEAR = 3;
    private static final int START_VERTICAL = 1;
    private static final int UP_ARC = 5;
    Arc[] mArcs;
    private boolean mExtrapolate = true;
    private final double[] mTime;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class Arc {
        private static final double EPSILON = 0.001d;
        private static final String TAG = "Arc";
        private static double[] sOurPercent = new double[91];
        double mArcDistance;
        double mArcVelocity;
        double mEllipseA;
        double mEllipseB;
        double mEllipseCenterX;
        double mEllipseCenterY;
        boolean mLinear;
        double[] mLut;
        double mOneOverDeltaTime;
        double mTime1;
        double mTime2;
        double mTmpCosAngle;
        double mTmpSinAngle;
        boolean mVertical;
        double mX1;
        double mX2;
        double mY1;
        double mY2;

        public Arc(int i5, double d, double d6, double d7, double d8, double d9, double d10) {
            this.mLinear = false;
            double d11 = d9 - d7;
            double d12 = d10 - d8;
            if (i5 == 1) {
                this.mVertical = true;
            } else if (i5 == 4) {
                this.mVertical = d12 > 0.0d;
            } else if (i5 != 5) {
                this.mVertical = false;
            } else {
                this.mVertical = d12 < 0.0d;
            }
            this.mTime1 = d;
            this.mTime2 = d6;
            this.mOneOverDeltaTime = 1.0d / (d6 - d);
            if (3 == i5) {
                this.mLinear = true;
            }
            if (!this.mLinear && Math.abs(d11) >= 0.001d && Math.abs(d12) >= 0.001d) {
                this.mLut = new double[101];
                boolean z6 = this.mVertical;
                this.mEllipseA = d11 * ((double) (z6 ? -1 : 1));
                this.mEllipseB = d12 * ((double) (z6 ? 1 : -1));
                this.mEllipseCenterX = z6 ? d9 : d7;
                this.mEllipseCenterY = z6 ? d8 : d10;
                buildTable(d7, d8, d9, d10);
                this.mArcVelocity = this.mArcDistance * this.mOneOverDeltaTime;
                return;
            }
            this.mLinear = true;
            this.mX1 = d7;
            this.mX2 = d9;
            this.mY1 = d8;
            this.mY2 = d10;
            double dHypot = Math.hypot(d12, d11);
            this.mArcDistance = dHypot;
            this.mArcVelocity = dHypot * this.mOneOverDeltaTime;
            double d13 = this.mTime2;
            double d14 = this.mTime1;
            this.mEllipseCenterX = d11 / (d13 - d14);
            this.mEllipseCenterY = d12 / (d13 - d14);
        }

        private void buildTable(double d, double d6, double d7, double d8) {
            double d9 = d7 - d;
            double d10 = d6 - d8;
            int i5 = 0;
            double dHypot = 0.0d;
            double d11 = 0.0d;
            double d12 = 0.0d;
            while (true) {
                double[] dArr = sOurPercent;
                if (i5 >= dArr.length) {
                    break;
                }
                int i6 = i5;
                double radians = Math.toRadians((((double) i5) * 90.0d) / ((double) (dArr.length - 1)));
                double dSin = Math.sin(radians) * d9;
                double dCos = Math.cos(radians) * d10;
                if (i6 > 0) {
                    dHypot += Math.hypot(dSin - d11, dCos - d12);
                    sOurPercent[i6] = dHypot;
                }
                i5 = i6 + 1;
                d11 = dSin;
                d12 = dCos;
            }
            this.mArcDistance = dHypot;
            int i7 = 0;
            while (true) {
                double[] dArr2 = sOurPercent;
                if (i7 >= dArr2.length) {
                    break;
                }
                dArr2[i7] = dArr2[i7] / dHypot;
                i7++;
            }
            int i8 = 0;
            while (true) {
                double[] dArr3 = this.mLut;
                if (i8 >= dArr3.length) {
                    return;
                }
                double length = ((double) i8) / ((double) (dArr3.length - 1));
                int iBinarySearch = Arrays.binarySearch(sOurPercent, length);
                if (iBinarySearch >= 0) {
                    this.mLut[i8] = ((double) iBinarySearch) / ((double) (sOurPercent.length - 1));
                } else if (iBinarySearch == -1) {
                    this.mLut[i8] = 0.0d;
                } else {
                    int i9 = -iBinarySearch;
                    int i10 = i9 - 2;
                    double[] dArr4 = sOurPercent;
                    double d13 = dArr4[i10];
                    this.mLut[i8] = (((length - d13) / (dArr4[i9 - 1] - d13)) + ((double) i10)) / ((double) (dArr4.length - 1));
                }
                i8++;
            }
        }

        public double getDX() {
            double d = this.mEllipseA * this.mTmpCosAngle;
            double dHypot = this.mArcVelocity / Math.hypot(d, (-this.mEllipseB) * this.mTmpSinAngle);
            return this.mVertical ? (-d) * dHypot : d * dHypot;
        }

        public double getDY() {
            double d = this.mEllipseA * this.mTmpCosAngle;
            double d6 = (-this.mEllipseB) * this.mTmpSinAngle;
            double dHypot = this.mArcVelocity / Math.hypot(d, d6);
            return this.mVertical ? (-d6) * dHypot : d6 * dHypot;
        }

        public double getLinearDX(double d) {
            return this.mEllipseCenterX;
        }

        public double getLinearDY(double d) {
            return this.mEllipseCenterY;
        }

        public double getLinearX(double d) {
            double d6 = (d - this.mTime1) * this.mOneOverDeltaTime;
            double d7 = this.mX1;
            return a.a(this.mX2, d7, d6, d7);
        }

        public double getLinearY(double d) {
            double d6 = (d - this.mTime1) * this.mOneOverDeltaTime;
            double d7 = this.mY1;
            return a.a(this.mY2, d7, d6, d7);
        }

        public double getX() {
            return (this.mEllipseA * this.mTmpSinAngle) + this.mEllipseCenterX;
        }

        public double getY() {
            return (this.mEllipseB * this.mTmpCosAngle) + this.mEllipseCenterY;
        }

        public double lookup(double d) {
            if (d <= 0.0d) {
                return 0.0d;
            }
            if (d >= 1.0d) {
                return 1.0d;
            }
            double[] dArr = this.mLut;
            double length = d * ((double) (dArr.length - 1));
            int i5 = (int) length;
            double d6 = length - ((double) i5);
            double d7 = dArr[i5];
            return a.a(dArr[i5 + 1], d7, d6, d7);
        }

        public void setPoint(double d) {
            double dLookup = lookup((this.mVertical ? this.mTime2 - d : d - this.mTime1) * this.mOneOverDeltaTime) * 1.5707963267948966d;
            this.mTmpSinAngle = Math.sin(dLookup);
            this.mTmpCosAngle = Math.cos(dLookup);
        }
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0036  */
    public ArcCurveFit(int[] iArr, double[] dArr, double[][] dArr2) {
        this.mTime = dArr;
        this.mArcs = new Arc[dArr.length - 1];
        int i5 = 1;
        int i6 = 1;
        int i7 = 0;
        while (true) {
            Arc[] arcArr = this.mArcs;
            if (i7 >= arcArr.length) {
                return;
            }
            int i8 = iArr[i7];
            int i9 = 3;
            if (i8 != 0) {
                if (i8 == 1) {
                    i5 = 1;
                    i9 = i5;
                } else {
                    if (i8 != 2) {
                        if (i8 != 3) {
                            i9 = 4;
                            if (i8 != 4) {
                                i9 = 5;
                                if (i8 != 5) {
                                    i9 = i6;
                                }
                            }
                        } else {
                            if (i5 != 1) {
                                i5 = 1;
                            }
                            i9 = i5;
                        }
                    }
                    i5 = 2;
                    i9 = i5;
                }
            }
            double d = dArr[i7];
            int i10 = i7 + 1;
            double d6 = dArr[i10];
            double[] dArr3 = dArr2[i7];
            double d7 = dArr3[0];
            double d8 = dArr3[1];
            double[] dArr4 = dArr2[i10];
            arcArr[i7] = new Arc(i9, d, d6, d7, d8, dArr4[0], dArr4[1]);
            i7 = i10;
            i6 = i9;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public void getPos(double d, double[] dArr) {
        if (this.mExtrapolate) {
            Arc[] arcArr = this.mArcs;
            Arc arc = arcArr[0];
            double d6 = arc.mTime1;
            if (d < d6) {
                double d7 = d - d6;
                if (arc.mLinear) {
                    dArr[0] = (this.mArcs[0].getLinearDX(d6) * d7) + arc.getLinearX(d6);
                    dArr[1] = (d7 * this.mArcs[0].getLinearDY(d6)) + this.mArcs[0].getLinearY(d6);
                    return;
                }
                arc.setPoint(d6);
                dArr[0] = (this.mArcs[0].getDX() * d7) + this.mArcs[0].getX();
                dArr[1] = (d7 * this.mArcs[0].getDY()) + this.mArcs[0].getY();
                return;
            }
            if (d > arcArr[arcArr.length - 1].mTime2) {
                double d8 = arcArr[arcArr.length - 1].mTime2;
                double d9 = d - d8;
                int length = arcArr.length - 1;
                Arc arc2 = arcArr[length];
                if (arc2.mLinear) {
                    dArr[0] = (this.mArcs[length].getLinearDX(d8) * d9) + arc2.getLinearX(d8);
                    dArr[1] = (d9 * this.mArcs[length].getLinearDY(d8)) + this.mArcs[length].getLinearY(d8);
                    return;
                }
                arc2.setPoint(d);
                dArr[0] = (this.mArcs[length].getDX() * d9) + this.mArcs[length].getX();
                dArr[1] = (d9 * this.mArcs[length].getDY()) + this.mArcs[length].getY();
                return;
            }
        } else {
            Arc[] arcArr2 = this.mArcs;
            double d10 = arcArr2[0].mTime1;
            if (d < d10) {
                d = d10;
            }
            if (d > arcArr2[arcArr2.length - 1].mTime2) {
                d = arcArr2[arcArr2.length - 1].mTime2;
            }
        }
        int i5 = 0;
        while (true) {
            Arc[] arcArr3 = this.mArcs;
            if (i5 >= arcArr3.length) {
                return;
            }
            Arc arc3 = arcArr3[i5];
            if (d <= arc3.mTime2) {
                if (arc3.mLinear) {
                    dArr[0] = arc3.getLinearX(d);
                    dArr[1] = this.mArcs[i5].getLinearY(d);
                    return;
                } else {
                    arc3.setPoint(d);
                    dArr[0] = this.mArcs[i5].getX();
                    dArr[1] = this.mArcs[i5].getY();
                    return;
                }
            }
            i5++;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public void getSlope(double d, double[] dArr) {
        Arc[] arcArr = this.mArcs;
        double d6 = arcArr[0].mTime1;
        if (d < d6) {
            d = d6;
        } else if (d > arcArr[arcArr.length - 1].mTime2) {
            d = arcArr[arcArr.length - 1].mTime2;
        }
        int i5 = 0;
        while (true) {
            Arc[] arcArr2 = this.mArcs;
            if (i5 >= arcArr2.length) {
                return;
            }
            Arc arc = arcArr2[i5];
            if (d <= arc.mTime2) {
                if (arc.mLinear) {
                    dArr[0] = arc.getLinearDX(d);
                    dArr[1] = this.mArcs[i5].getLinearDY(d);
                    return;
                } else {
                    arc.setPoint(d);
                    dArr[0] = this.mArcs[i5].getDX();
                    dArr[1] = this.mArcs[i5].getDY();
                    return;
                }
            }
            i5++;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public double[] getTimePoints() {
        return this.mTime;
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public double getSlope(double d, int i5) {
        Arc[] arcArr = this.mArcs;
        int i6 = 0;
        double d6 = arcArr[0].mTime1;
        if (d < d6) {
            d = d6;
        }
        if (d > arcArr[arcArr.length - 1].mTime2) {
            d = arcArr[arcArr.length - 1].mTime2;
        }
        while (true) {
            Arc[] arcArr2 = this.mArcs;
            if (i6 >= arcArr2.length) {
                return Double.NaN;
            }
            Arc arc = arcArr2[i6];
            if (d <= arc.mTime2) {
                if (arc.mLinear) {
                    if (i5 == 0) {
                        return arc.getLinearDX(d);
                    }
                    return arc.getLinearDY(d);
                }
                arc.setPoint(d);
                if (i5 == 0) {
                    return this.mArcs[i6].getDX();
                }
                return this.mArcs[i6].getDY();
            }
            i6++;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public void getPos(double d, float[] fArr) {
        if (this.mExtrapolate) {
            Arc[] arcArr = this.mArcs;
            Arc arc = arcArr[0];
            double d6 = arc.mTime1;
            if (d < d6) {
                double d7 = d - d6;
                if (arc.mLinear) {
                    fArr[0] = (float) ((this.mArcs[0].getLinearDX(d6) * d7) + arc.getLinearX(d6));
                    fArr[1] = (float) ((d7 * this.mArcs[0].getLinearDY(d6)) + this.mArcs[0].getLinearY(d6));
                    return;
                }
                arc.setPoint(d6);
                fArr[0] = (float) ((this.mArcs[0].getDX() * d7) + this.mArcs[0].getX());
                fArr[1] = (float) ((d7 * this.mArcs[0].getDY()) + this.mArcs[0].getY());
                return;
            }
            if (d > arcArr[arcArr.length - 1].mTime2) {
                double d8 = arcArr[arcArr.length - 1].mTime2;
                double d9 = d - d8;
                int length = arcArr.length - 1;
                Arc arc2 = arcArr[length];
                if (arc2.mLinear) {
                    fArr[0] = (float) ((this.mArcs[length].getLinearDX(d8) * d9) + arc2.getLinearX(d8));
                    fArr[1] = (float) ((d9 * this.mArcs[length].getLinearDY(d8)) + this.mArcs[length].getLinearY(d8));
                    return;
                }
                arc2.setPoint(d);
                fArr[0] = (float) this.mArcs[length].getX();
                fArr[1] = (float) this.mArcs[length].getY();
                return;
            }
        } else {
            Arc[] arcArr2 = this.mArcs;
            double d10 = arcArr2[0].mTime1;
            if (d < d10) {
                d = d10;
            } else if (d > arcArr2[arcArr2.length - 1].mTime2) {
                d = arcArr2[arcArr2.length - 1].mTime2;
            }
        }
        int i5 = 0;
        while (true) {
            Arc[] arcArr3 = this.mArcs;
            if (i5 >= arcArr3.length) {
                return;
            }
            Arc arc3 = arcArr3[i5];
            if (d <= arc3.mTime2) {
                if (arc3.mLinear) {
                    fArr[0] = (float) arc3.getLinearX(d);
                    fArr[1] = (float) this.mArcs[i5].getLinearY(d);
                    return;
                } else {
                    arc3.setPoint(d);
                    fArr[0] = (float) this.mArcs[i5].getX();
                    fArr[1] = (float) this.mArcs[i5].getY();
                    return;
                }
            }
            i5++;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public double getPos(double d, int i5) {
        int i6 = 0;
        if (this.mExtrapolate) {
            Arc[] arcArr = this.mArcs;
            Arc arc = arcArr[0];
            double d6 = arc.mTime1;
            if (d < d6) {
                double d7 = d - d6;
                if (arc.mLinear) {
                    if (i5 == 0) {
                        return (d7 * this.mArcs[0].getLinearDX(d6)) + arc.getLinearX(d6);
                    }
                    return (d7 * this.mArcs[0].getLinearDY(d6)) + arc.getLinearY(d6);
                }
                arc.setPoint(d6);
                if (i5 == 0) {
                    return (d7 * this.mArcs[0].getDX()) + this.mArcs[0].getX();
                }
                return (d7 * this.mArcs[0].getDY()) + this.mArcs[0].getY();
            }
            if (d > arcArr[arcArr.length - 1].mTime2) {
                double d8 = arcArr[arcArr.length - 1].mTime2;
                double d9 = d - d8;
                int length = arcArr.length - 1;
                if (i5 == 0) {
                    return (d9 * this.mArcs[length].getLinearDX(d8)) + arcArr[length].getLinearX(d8);
                }
                return (d9 * this.mArcs[length].getLinearDY(d8)) + arcArr[length].getLinearY(d8);
            }
        } else {
            Arc[] arcArr2 = this.mArcs;
            double d10 = arcArr2[0].mTime1;
            if (d < d10) {
                d = d10;
            } else if (d > arcArr2[arcArr2.length - 1].mTime2) {
                d = arcArr2[arcArr2.length - 1].mTime2;
            }
        }
        while (true) {
            Arc[] arcArr3 = this.mArcs;
            if (i6 >= arcArr3.length) {
                return Double.NaN;
            }
            Arc arc2 = arcArr3[i6];
            if (d <= arc2.mTime2) {
                if (arc2.mLinear) {
                    if (i5 == 0) {
                        return arc2.getLinearX(d);
                    }
                    return arc2.getLinearY(d);
                }
                arc2.setPoint(d);
                if (i5 == 0) {
                    return this.mArcs[i6].getX();
                }
                return this.mArcs[i6].getY();
            }
            i6++;
        }
    }
}
