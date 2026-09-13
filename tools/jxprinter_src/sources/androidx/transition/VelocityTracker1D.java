package androidx.transition;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
class VelocityTracker1D {
    private static final int ASSUME_POINTER_MOVE_STOPPED_MILLIS = 40;
    private static final int HISTORY_SIZE = 20;
    private static final int HORIZON_MILLIS = 100;
    private float[] mDataSamples = new float[20];
    private int mIndex = 0;
    private long[] mTimeSamples;

    public VelocityTracker1D() {
        long[] jArr = new long[20];
        this.mTimeSamples = jArr;
        Arrays.fill(jArr, Long.MIN_VALUE);
    }

    private float kineticEnergyToVelocity(float f6) {
        return (float) (Math.sqrt(Math.abs(f6) * 2.0f) * ((double) Math.signum(f6)));
    }

    public void addDataPoint(long j6, float f6) {
        int i5 = (this.mIndex + 1) % 20;
        this.mIndex = i5;
        this.mTimeSamples[i5] = j6;
        this.mDataSamples[i5] = f6;
    }

    public float calculateVelocity() {
        float fKineticEnergyToVelocity;
        int i5 = this.mIndex;
        if (i5 == 0 && this.mTimeSamples[i5] == Long.MIN_VALUE) {
            return 0.0f;
        }
        long j6 = this.mTimeSamples[i5];
        int i6 = 0;
        long j7 = j6;
        while (true) {
            long j8 = this.mTimeSamples[i5];
            if (j8 == Long.MIN_VALUE) {
                break;
            }
            float f6 = j6 - j8;
            float fAbs = Math.abs(j8 - j7);
            if (f6 > 100.0f || fAbs > 40.0f) {
                break;
            }
            if (i5 == 0) {
                i5 = 20;
            }
            i5--;
            i6++;
            if (i6 >= 20) {
                break;
            }
            j7 = j8;
        }
        if (i6 < 2) {
            return 0.0f;
        }
        if (i6 == 2) {
            int i7 = this.mIndex;
            int i8 = i7 == 0 ? 19 : i7 - 1;
            long[] jArr = this.mTimeSamples;
            float f7 = jArr[i7] - jArr[i8];
            if (f7 == 0.0f) {
                return 0.0f;
            }
            float[] fArr = this.mDataSamples;
            fKineticEnergyToVelocity = (fArr[i7] - fArr[i8]) / f7;
        } else {
            int i9 = this.mIndex;
            int i10 = ((i9 - i6) + 21) % 20;
            int i11 = (i9 + 21) % 20;
            long j9 = this.mTimeSamples[i10];
            float f8 = this.mDataSamples[i10];
            int i12 = i10 + 1;
            float f9 = 0.0f;
            for (int i13 = i12 % 20; i13 != i11; i13 = (i13 + 1) % 20) {
                long j10 = this.mTimeSamples[i13];
                float f10 = j10 - j9;
                if (f10 != 0.0f) {
                    float f11 = this.mDataSamples[i13];
                    float f12 = (f11 - f8) / f10;
                    float fAbs2 = (Math.abs(f12) * (f12 - kineticEnergyToVelocity(f9))) + f9;
                    if (i13 == i12) {
                        fAbs2 *= 0.5f;
                    }
                    f9 = fAbs2;
                    f8 = f11;
                    j9 = j10;
                }
            }
            fKineticEnergyToVelocity = kineticEnergyToVelocity(f9);
        }
        return fKineticEnergyToVelocity * 1000.0f;
    }

    public void resetTracking() {
        this.mIndex = 0;
        Arrays.fill(this.mTimeSamples, Long.MIN_VALUE);
        Arrays.fill(this.mDataSamples, 0.0f);
    }
}
