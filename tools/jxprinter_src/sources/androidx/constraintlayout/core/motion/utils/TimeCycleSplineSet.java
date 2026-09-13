package androidx.constraintlayout.core.motion.utils;

import A3.AbstractC0157z;
import androidx.constraintlayout.core.motion.CustomAttribute;
import androidx.constraintlayout.core.motion.CustomVariable;
import androidx.constraintlayout.core.motion.MotionWidget;
import java.lang.reflect.Array;
import java.text.DecimalFormat;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public abstract class TimeCycleSplineSet {
    protected static final int CURVE_OFFSET = 2;
    protected static final int CURVE_PERIOD = 1;
    protected static final int CURVE_VALUE = 0;
    private static final String TAG = "SplineSet";
    protected static float sVal2PI = 6.2831855f;
    protected int mCount;
    protected CurveFit mCurveFit;
    protected long mLastTime;
    protected String mType;
    protected int mWaveShape = 0;
    protected int[] mTimePoints = new int[10];
    protected float[][] mValues = (float[][]) Array.newInstance((Class<?>) Float.TYPE, 10, 3);
    protected float[] mCache = new float[3];
    protected boolean mContinue = false;
    protected float mLastCycle = Float.NaN;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class CustomSet extends TimeCycleSplineSet {
        String mAttributeName;
        KeyFrameArray.CustomArray mConstraintAttributeList;
        float[] mCustomCache;
        float[] mTempValues;
        KeyFrameArray.FloatArray mWaveProperties = new KeyFrameArray.FloatArray();

        public CustomSet(String str, KeyFrameArray.CustomArray customArray) {
            this.mAttributeName = str.split(",")[1];
            this.mConstraintAttributeList = customArray;
        }

        @Override // androidx.constraintlayout.core.motion.utils.TimeCycleSplineSet
        public void setPoint(int i5, float f6, float f7, int i6, float f8) {
            throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute,...)");
        }

        public boolean setProperty(MotionWidget motionWidget, float f6, long j6, KeyCache keyCache) {
            this.mCurveFit.getPos(f6, this.mTempValues);
            float[] fArr = this.mTempValues;
            float f7 = fArr[fArr.length - 2];
            float f8 = fArr[fArr.length - 1];
            long j7 = j6 - this.mLastTime;
            if (Float.isNaN(this.mLastCycle)) {
                float floatValue = keyCache.getFloatValue(motionWidget, this.mAttributeName, 0);
                this.mLastCycle = floatValue;
                if (Float.isNaN(floatValue)) {
                    this.mLastCycle = 0.0f;
                }
            }
            float f9 = (float) ((((j7 * 1.0E-9d) * ((double) f7)) + ((double) this.mLastCycle)) % 1.0d);
            this.mLastCycle = f9;
            this.mLastTime = j6;
            float fCalcWave = calcWave(f9);
            this.mContinue = false;
            int i5 = 0;
            while (true) {
                float[] fArr2 = this.mCustomCache;
                if (i5 >= fArr2.length) {
                    break;
                }
                boolean z6 = this.mContinue;
                float f10 = this.mTempValues[i5];
                this.mContinue = z6 | (((double) f10) != 0.0d);
                fArr2[i5] = (f10 * fCalcWave) + f8;
                i5++;
            }
            motionWidget.setInterpolatedValue(this.mConstraintAttributeList.valueAt(0), this.mCustomCache);
            if (f7 != 0.0f) {
                this.mContinue = true;
            }
            return this.mContinue;
        }

        @Override // androidx.constraintlayout.core.motion.utils.TimeCycleSplineSet
        public void setup(int i5) {
            int size = this.mConstraintAttributeList.size();
            int iNumberOfInterpolatedValues = this.mConstraintAttributeList.valueAt(0).numberOfInterpolatedValues();
            double[] dArr = new double[size];
            int i6 = iNumberOfInterpolatedValues + 2;
            this.mTempValues = new float[i6];
            this.mCustomCache = new float[iNumberOfInterpolatedValues];
            double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, size, i6);
            for (int i7 = 0; i7 < size; i7++) {
                int iKeyAt = this.mConstraintAttributeList.keyAt(i7);
                CustomAttribute customAttributeValueAt = this.mConstraintAttributeList.valueAt(i7);
                float[] fArrValueAt = this.mWaveProperties.valueAt(i7);
                dArr[i7] = ((double) iKeyAt) * 0.01d;
                customAttributeValueAt.getValuesToInterpolate(this.mTempValues);
                int i8 = 0;
                while (true) {
                    float[] fArr = this.mTempValues;
                    if (i8 < fArr.length) {
                        dArr2[i7][i8] = fArr[i8];
                        i8++;
                    }
                }
                double[] dArr3 = dArr2[i7];
                dArr3[iNumberOfInterpolatedValues] = fArrValueAt[0];
                dArr3[iNumberOfInterpolatedValues + 1] = fArrValueAt[1];
            }
            this.mCurveFit = CurveFit.get(i5, dArr, dArr2);
        }

        public void setPoint(int i5, CustomAttribute customAttribute, float f6, int i6, float f7) {
            this.mConstraintAttributeList.append(i5, customAttribute);
            this.mWaveProperties.append(i5, new float[]{f6, f7});
            this.mWaveShape = Math.max(this.mWaveShape, i6);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class CustomVarSet extends TimeCycleSplineSet {
        String mAttributeName;
        KeyFrameArray.CustomVar mConstraintAttributeList;
        float[] mCustomCache;
        float[] mTempValues;
        KeyFrameArray.FloatArray mWaveProperties = new KeyFrameArray.FloatArray();

        public CustomVarSet(String str, KeyFrameArray.CustomVar customVar) {
            this.mAttributeName = str.split(",")[1];
            this.mConstraintAttributeList = customVar;
        }

        @Override // androidx.constraintlayout.core.motion.utils.TimeCycleSplineSet
        public void setPoint(int i5, float f6, float f7, int i6, float f8) {
            throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute,...)");
        }

        public boolean setProperty(MotionWidget motionWidget, float f6, long j6, KeyCache keyCache) {
            this.mCurveFit.getPos(f6, this.mTempValues);
            float[] fArr = this.mTempValues;
            float f7 = fArr[fArr.length - 2];
            float f8 = fArr[fArr.length - 1];
            long j7 = j6 - this.mLastTime;
            if (Float.isNaN(this.mLastCycle)) {
                float floatValue = keyCache.getFloatValue(motionWidget, this.mAttributeName, 0);
                this.mLastCycle = floatValue;
                if (Float.isNaN(floatValue)) {
                    this.mLastCycle = 0.0f;
                }
            }
            float f9 = (float) ((((j7 * 1.0E-9d) * ((double) f7)) + ((double) this.mLastCycle)) % 1.0d);
            this.mLastCycle = f9;
            this.mLastTime = j6;
            float fCalcWave = calcWave(f9);
            this.mContinue = false;
            int i5 = 0;
            while (true) {
                float[] fArr2 = this.mCustomCache;
                if (i5 >= fArr2.length) {
                    break;
                }
                boolean z6 = this.mContinue;
                float f10 = this.mTempValues[i5];
                this.mContinue = z6 | (((double) f10) != 0.0d);
                fArr2[i5] = (f10 * fCalcWave) + f8;
                i5++;
            }
            this.mConstraintAttributeList.valueAt(0).setInterpolatedValue(motionWidget, this.mCustomCache);
            if (f7 != 0.0f) {
                this.mContinue = true;
            }
            return this.mContinue;
        }

        @Override // androidx.constraintlayout.core.motion.utils.TimeCycleSplineSet
        public void setup(int i5) {
            int size = this.mConstraintAttributeList.size();
            int iNumberOfInterpolatedValues = this.mConstraintAttributeList.valueAt(0).numberOfInterpolatedValues();
            double[] dArr = new double[size];
            int i6 = iNumberOfInterpolatedValues + 2;
            this.mTempValues = new float[i6];
            this.mCustomCache = new float[iNumberOfInterpolatedValues];
            double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, size, i6);
            for (int i7 = 0; i7 < size; i7++) {
                int iKeyAt = this.mConstraintAttributeList.keyAt(i7);
                CustomVariable customVariableValueAt = this.mConstraintAttributeList.valueAt(i7);
                float[] fArrValueAt = this.mWaveProperties.valueAt(i7);
                dArr[i7] = ((double) iKeyAt) * 0.01d;
                customVariableValueAt.getValuesToInterpolate(this.mTempValues);
                int i8 = 0;
                while (true) {
                    float[] fArr = this.mTempValues;
                    if (i8 < fArr.length) {
                        dArr2[i7][i8] = fArr[i8];
                        i8++;
                    }
                }
                double[] dArr3 = dArr2[i7];
                dArr3[iNumberOfInterpolatedValues] = fArrValueAt[0];
                dArr3[iNumberOfInterpolatedValues + 1] = fArrValueAt[1];
            }
            this.mCurveFit = CurveFit.get(i5, dArr, dArr2);
        }

        public void setPoint(int i5, CustomVariable customVariable, float f6, int i6, float f7) {
            this.mConstraintAttributeList.append(i5, customVariable);
            this.mWaveProperties.append(i5, new float[]{f6, f7});
            this.mWaveShape = Math.max(this.mWaveShape, i6);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class Sort {
        public static void doubleQuickSort(int[] iArr, float[][] fArr, int i5, int i6) {
            int[] iArr2 = new int[iArr.length + 10];
            iArr2[0] = i6;
            iArr2[1] = i5;
            int i7 = 2;
            while (i7 > 0) {
                int i8 = iArr2[i7 - 1];
                int i9 = i7 - 2;
                int i10 = iArr2[i9];
                if (i8 < i10) {
                    int iPartition = partition(iArr, fArr, i8, i10);
                    iArr2[i9] = iPartition - 1;
                    iArr2[i7 - 1] = i8;
                    int i11 = i7 + 1;
                    iArr2[i7] = i10;
                    i7 += 2;
                    iArr2[i11] = iPartition + 1;
                } else {
                    i7 = i9;
                }
            }
        }

        private static int partition(int[] iArr, float[][] fArr, int i5, int i6) {
            int i7 = iArr[i6];
            int i8 = i5;
            while (i5 < i6) {
                if (iArr[i5] <= i7) {
                    swap(iArr, fArr, i8, i5);
                    i8++;
                }
                i5++;
            }
            swap(iArr, fArr, i8, i6);
            return i8;
        }

        private static void swap(int[] iArr, float[][] fArr, int i5, int i6) {
            int i7 = iArr[i5];
            iArr[i5] = iArr[i6];
            iArr[i6] = i7;
            float[] fArr2 = fArr[i5];
            fArr[i5] = fArr[i6];
            fArr[i6] = fArr2;
        }
    }

    public float calcWave(float f6) {
        float fAbs;
        switch (this.mWaveShape) {
            case 1:
                return Math.signum(f6 * sVal2PI);
            case 2:
                fAbs = Math.abs(f6);
                break;
            case 3:
                return (((f6 * 2.0f) + 1.0f) % 2.0f) - 1.0f;
            case 4:
                fAbs = ((f6 * 2.0f) + 1.0f) % 2.0f;
                break;
            case 5:
                return (float) Math.cos(f6 * sVal2PI);
            case 6:
                float fAbs2 = 1.0f - Math.abs(((f6 * 4.0f) % 4.0f) - 2.0f);
                fAbs = fAbs2 * fAbs2;
                break;
            default:
                return (float) Math.sin(f6 * sVal2PI);
        }
        return 1.0f - fAbs;
    }

    public CurveFit getCurveFit() {
        return this.mCurveFit;
    }

    public void setPoint(int i5, float f6, float f7, int i6, float f8) {
        int[] iArr = this.mTimePoints;
        int i7 = this.mCount;
        iArr[i7] = i5;
        float[] fArr = this.mValues[i7];
        fArr[0] = f6;
        fArr[1] = f7;
        fArr[2] = f8;
        this.mWaveShape = Math.max(this.mWaveShape, i6);
        this.mCount++;
    }

    public void setStartTime(long j6) {
        this.mLastTime = j6;
    }

    public void setType(String str) {
        this.mType = str;
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0060  */
    public void setup(int i5) {
        int i6 = this.mCount;
        if (i6 == 0) {
            System.err.println("Error no points added to " + this.mType);
            return;
        }
        Sort.doubleQuickSort(this.mTimePoints, this.mValues, 0, i6 - 1);
        int i7 = 1;
        int i8 = 0;
        while (true) {
            int[] iArr = this.mTimePoints;
            if (i7 >= iArr.length) {
                break;
            }
            if (iArr[i7] != iArr[i7 - 1]) {
                i8++;
            }
            i7++;
        }
        if (i8 == 0) {
            i8 = 1;
        }
        double[] dArr = new double[i8];
        double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, i8, 3);
        int i9 = 0;
        for (int i10 = 0; i10 < this.mCount; i10++) {
            if (i10 > 0) {
                int[] iArr2 = this.mTimePoints;
                if (iArr2[i10] != iArr2[i10 - 1]) {
                    dArr[i9] = ((double) this.mTimePoints[i10]) * 0.01d;
                    double[] dArr3 = dArr2[i9];
                    float[] fArr = this.mValues[i10];
                    dArr3[0] = fArr[0];
                    dArr3[1] = fArr[1];
                    dArr3[2] = fArr[2];
                    i9++;
                }
            } else {
                dArr[i9] = ((double) this.mTimePoints[i10]) * 0.01d;
                double[] dArr4 = dArr2[i9];
                float[] fArr2 = this.mValues[i10];
                dArr4[0] = fArr2[0];
                dArr4[1] = fArr2[1];
                dArr4[2] = fArr2[2];
                i9++;
            }
        }
        this.mCurveFit = CurveFit.get(i5, dArr, dArr2);
    }

    public String toString() {
        String string = this.mType;
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        for (int i5 = 0; i5 < this.mCount; i5++) {
            StringBuilder sbX = AbstractC0157z.x(string, "[");
            sbX.append(this.mTimePoints[i5]);
            sbX.append(" , ");
            sbX.append(decimalFormat.format(this.mValues[i5]));
            sbX.append("] ");
            string = sbX.toString();
        }
        return string;
    }
}
