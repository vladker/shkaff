package androidx.constraintlayout.core.motion.utils;

import A3.AbstractC0157z;
import androidx.constraintlayout.core.motion.MotionWidget;
import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public abstract class KeyCycleOscillator {
    private static final String TAG = "KeyCycleOscillator";
    private CurveFit mCurveFit;
    private CycleOscillator mCycleOscillator;
    private String mType;
    private int mWaveShape = 0;
    private String mWaveString = null;
    public int mVariesBy = 0;
    ArrayList<WavePoint> mWavePoints = new ArrayList<>();

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class CoreSpline extends KeyCycleOscillator {
        String mType;
        int mTypeId;

        public CoreSpline(String str) {
            this.mType = str;
            this.mTypeId = TypedValues.CycleType.getId(str);
        }

        @Override // androidx.constraintlayout.core.motion.utils.KeyCycleOscillator
        public void setProperty(MotionWidget motionWidget, float f6) {
            motionWidget.setValue(this.mTypeId, get(f6));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class CycleOscillator {
        private static final String TAG = "CycleOscillator";
        static final int UNSET = -1;
        CurveFit mCurveFit;
        float[] mOffsetArr;
        private final int mOffst;
        Oscillator mOscillator;
        float mPathLength;
        float[] mPeriod;
        private final int mPhase;
        float[] mPhaseArr;
        double[] mPosition;
        float[] mScale;
        double[] mSplineSlopeCache;
        double[] mSplineValueCache;
        private final int mValue;
        float[] mValues;
        private final int mVariesBy;
        int mWaveShape;

        public CycleOscillator(int i5, String str, int i6, int i7) {
            Oscillator oscillator = new Oscillator();
            this.mOscillator = oscillator;
            this.mOffst = 0;
            this.mPhase = 1;
            this.mValue = 2;
            this.mWaveShape = i5;
            this.mVariesBy = i6;
            oscillator.setType(i5, str);
            this.mValues = new float[i7];
            this.mPosition = new double[i7];
            this.mPeriod = new float[i7];
            this.mOffsetArr = new float[i7];
            this.mPhaseArr = new float[i7];
            this.mScale = new float[i7];
        }

        public double getLastPhase() {
            return this.mSplineValueCache[1];
        }

        public double getSlope(float f6) {
            CurveFit curveFit = this.mCurveFit;
            if (curveFit != null) {
                double d = f6;
                curveFit.getSlope(d, this.mSplineSlopeCache);
                this.mCurveFit.getPos(d, this.mSplineValueCache);
            } else {
                double[] dArr = this.mSplineSlopeCache;
                dArr[0] = 0.0d;
                dArr[1] = 0.0d;
                dArr[2] = 0.0d;
            }
            double d6 = f6;
            double value = this.mOscillator.getValue(d6, this.mSplineValueCache[1]);
            double slope = this.mOscillator.getSlope(d6, this.mSplineValueCache[1], this.mSplineSlopeCache[1]);
            double[] dArr2 = this.mSplineSlopeCache;
            return (slope * this.mSplineValueCache[2]) + (value * dArr2[2]) + dArr2[0];
        }

        public double getValues(float f6) {
            CurveFit curveFit = this.mCurveFit;
            if (curveFit != null) {
                curveFit.getPos(f6, this.mSplineValueCache);
            } else {
                double[] dArr = this.mSplineValueCache;
                dArr[0] = this.mOffsetArr[0];
                dArr[1] = this.mPhaseArr[0];
                dArr[2] = this.mValues[0];
            }
            double[] dArr2 = this.mSplineValueCache;
            return (this.mOscillator.getValue(f6, dArr2[1]) * this.mSplineValueCache[2]) + dArr2[0];
        }

        public void setPoint(int i5, int i6, float f6, float f7, float f8, float f9) {
            this.mPosition[i5] = ((double) i6) / 100.0d;
            this.mPeriod[i5] = f6;
            this.mOffsetArr[i5] = f7;
            this.mPhaseArr[i5] = f8;
            this.mValues[i5] = f9;
        }

        public void setup(float f6) {
            this.mPathLength = f6;
            double[][] dArr = (double[][]) Array.newInstance((Class<?>) Double.TYPE, this.mPosition.length, 3);
            float[] fArr = this.mValues;
            this.mSplineValueCache = new double[fArr.length + 2];
            this.mSplineSlopeCache = new double[fArr.length + 2];
            if (this.mPosition[0] > 0.0d) {
                this.mOscillator.addPoint(0.0d, this.mPeriod[0]);
            }
            double[] dArr2 = this.mPosition;
            int length = dArr2.length - 1;
            if (dArr2[length] < 1.0d) {
                this.mOscillator.addPoint(1.0d, this.mPeriod[length]);
            }
            for (int i5 = 0; i5 < dArr.length; i5++) {
                double[] dArr3 = dArr[i5];
                dArr3[0] = this.mOffsetArr[i5];
                dArr3[1] = this.mPhaseArr[i5];
                dArr3[2] = this.mValues[i5];
                this.mOscillator.addPoint(this.mPosition[i5], this.mPeriod[i5]);
            }
            this.mOscillator.normalize();
            double[] dArr4 = this.mPosition;
            if (dArr4.length > 1) {
                this.mCurveFit = CurveFit.get(0, dArr4, dArr);
            } else {
                this.mCurveFit = null;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class PathRotateSet extends KeyCycleOscillator {
        String mType;
        int mTypeId;

        public PathRotateSet(String str) {
            this.mType = str;
            this.mTypeId = TypedValues.CycleType.getId(str);
        }

        public void setPathRotate(MotionWidget motionWidget, float f6, double d, double d6) {
            motionWidget.setRotationZ(get(f6) + ((float) Math.toDegrees(Math.atan2(d6, d))));
        }

        @Override // androidx.constraintlayout.core.motion.utils.KeyCycleOscillator
        public void setProperty(MotionWidget motionWidget, float f6) {
            motionWidget.setValue(this.mTypeId, get(f6));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class WavePoint {
        float mOffset;
        float mPeriod;
        float mPhase;
        int mPosition;
        float mValue;

        public WavePoint(int i5, float f6, float f7, float f8, float f9) {
            this.mPosition = i5;
            this.mValue = f9;
            this.mOffset = f7;
            this.mPeriod = f6;
            this.mPhase = f8;
        }
    }

    public static KeyCycleOscillator makeWidgetCycle(String str) {
        return str.equals("pathRotate") ? new PathRotateSet(str) : new CoreSpline(str);
    }

    public float get(float f6) {
        return (float) this.mCycleOscillator.getValues(f6);
    }

    public CurveFit getCurveFit() {
        return this.mCurveFit;
    }

    public float getSlope(float f6) {
        return (float) this.mCycleOscillator.getSlope(f6);
    }

    public void setPoint(int i5, int i6, String str, int i7, float f6, float f7, float f8, float f9, Object obj) {
        this.mWavePoints.add(new WavePoint(i5, f6, f7, f8, f9));
        if (i7 != -1) {
            this.mVariesBy = i7;
        }
        this.mWaveShape = i6;
        setCustom(obj);
        this.mWaveString = str;
    }

    public void setType(String str) {
        this.mType = str;
    }

    public void setup(float f6) {
        int size = this.mWavePoints.size();
        if (size == 0) {
            return;
        }
        Collections.sort(this.mWavePoints, new Comparator<WavePoint>() { // from class: androidx.constraintlayout.core.motion.utils.KeyCycleOscillator.1
            @Override // java.util.Comparator
            public int compare(WavePoint wavePoint, WavePoint wavePoint2) {
                return Integer.compare(wavePoint.mPosition, wavePoint2.mPosition);
            }
        });
        double[] dArr = new double[size];
        char c = 2;
        double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, size, 3);
        this.mCycleOscillator = new CycleOscillator(this.mWaveShape, this.mWaveString, this.mVariesBy, size);
        ArrayList<WavePoint> arrayList = this.mWavePoints;
        int size2 = arrayList.size();
        int i5 = 0;
        int i6 = 0;
        while (i5 < size2) {
            int i7 = i5 + 1;
            WavePoint wavePoint = arrayList.get(i5);
            float f7 = wavePoint.mPeriod;
            dArr[i6] = ((double) f7) * 0.01d;
            double[] dArr3 = dArr2[i6];
            float f8 = wavePoint.mValue;
            dArr3[0] = f8;
            float f9 = wavePoint.mOffset;
            char c6 = c;
            dArr3[1] = f9;
            float f10 = wavePoint.mPhase;
            dArr3[c6] = f10;
            this.mCycleOscillator.setPoint(i6, wavePoint.mPosition, f7, f9, f10, f8);
            i6++;
            i5 = i7;
            c = c6;
            dArr2 = dArr2;
        }
        this.mCycleOscillator.setup(f6);
        this.mCurveFit = CurveFit.get(0, dArr, dArr2);
    }

    public String toString() {
        String string = this.mType;
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        ArrayList<WavePoint> arrayList = this.mWavePoints;
        int size = arrayList.size();
        int i5 = 0;
        while (i5 < size) {
            WavePoint wavePoint = arrayList.get(i5);
            i5++;
            WavePoint wavePoint2 = wavePoint;
            StringBuilder sbX = AbstractC0157z.x(string, "[");
            sbX.append(wavePoint2.mPosition);
            sbX.append(" , ");
            sbX.append(decimalFormat.format(wavePoint2.mValue));
            sbX.append("] ");
            string = sbX.toString();
        }
        return string;
    }

    public boolean variesByPath() {
        return this.mVariesBy == 1;
    }

    public void setPoint(int i5, int i6, String str, int i7, float f6, float f7, float f8, float f9) {
        this.mWavePoints.add(new WavePoint(i5, f6, f7, f8, f9));
        if (i7 != -1) {
            this.mVariesBy = i7;
        }
        this.mWaveShape = i6;
        this.mWaveString = str;
    }

    public void setCustom(Object obj) {
    }

    public void setProperty(MotionWidget motionWidget, float f6) {
    }
}
