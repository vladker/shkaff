package androidx.core.view;

import android.view.MotionEvent;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
class VelocityTrackerFallback {
    private static final long ASSUME_POINTER_STOPPED_MS = 40;
    private static final int HISTORY_SIZE = 20;
    private static final long RANGE_MS = 100;
    private final float[] mMovements = new float[20];
    private final long[] mEventTimes = new long[20];
    private float mLastComputedVelocity = 0.0f;
    private int mDataPointsBufferSize = 0;
    private int mDataPointsBufferLastUsedIndex = 0;

    private void clear() {
        this.mDataPointsBufferSize = 0;
        this.mLastComputedVelocity = 0.0f;
    }

    private float getCurrentVelocity() {
        long[] jArr;
        long j6;
        int i5 = this.mDataPointsBufferSize;
        if (i5 < 2) {
            return 0.0f;
        }
        int i6 = this.mDataPointsBufferLastUsedIndex;
        int i7 = ((i6 + 20) - (i5 - 1)) % 20;
        long j7 = this.mEventTimes[i6];
        while (true) {
            jArr = this.mEventTimes;
            j6 = jArr[i7];
            if (j7 - j6 <= RANGE_MS) {
                break;
            }
            this.mDataPointsBufferSize--;
            i7 = (i7 + 1) % 20;
        }
        int i8 = this.mDataPointsBufferSize;
        if (i8 < 2) {
            return 0.0f;
        }
        if (i8 == 2) {
            int i9 = (i7 + 1) % 20;
            long j8 = jArr[i9];
            if (j6 == j8) {
                return 0.0f;
            }
            return this.mMovements[i9] / (j8 - j6);
        }
        float f6 = 0.0f;
        int i10 = 0;
        for (int i11 = 0; i11 < this.mDataPointsBufferSize - 1; i11++) {
            int i12 = i11 + i7;
            long[] jArr2 = this.mEventTimes;
            long j9 = jArr2[i12 % 20];
            int i13 = (i12 + 1) % 20;
            if (jArr2[i13] != j9) {
                i10++;
                float fKineticEnergyToVelocity = kineticEnergyToVelocity(f6);
                float f7 = this.mMovements[i13] / (this.mEventTimes[i13] - j9);
                float fAbs = (Math.abs(f7) * (f7 - fKineticEnergyToVelocity)) + f6;
                if (i10 == 1) {
                    fAbs *= 0.5f;
                }
                f6 = fAbs;
            }
        }
        return kineticEnergyToVelocity(f6);
    }

    private static float kineticEnergyToVelocity(float f6) {
        return (f6 < 0.0f ? -1.0f : 1.0f) * ((float) Math.sqrt(Math.abs(f6) * 2.0f));
    }

    public void addMovement(MotionEvent motionEvent) {
        long eventTime = motionEvent.getEventTime();
        if (this.mDataPointsBufferSize != 0 && eventTime - this.mEventTimes[this.mDataPointsBufferLastUsedIndex] > ASSUME_POINTER_STOPPED_MS) {
            clear();
        }
        int i5 = (this.mDataPointsBufferLastUsedIndex + 1) % 20;
        this.mDataPointsBufferLastUsedIndex = i5;
        int i6 = this.mDataPointsBufferSize;
        if (i6 != 20) {
            this.mDataPointsBufferSize = i6 + 1;
        }
        this.mMovements[i5] = motionEvent.getAxisValue(26);
        this.mEventTimes[this.mDataPointsBufferLastUsedIndex] = eventTime;
    }

    public void computeCurrentVelocity(int i5) {
        computeCurrentVelocity(i5, Float.MAX_VALUE);
    }

    public float getAxisVelocity(int i5) {
        if (i5 != 26) {
            return 0.0f;
        }
        return this.mLastComputedVelocity;
    }

    public void computeCurrentVelocity(int i5, float f6) {
        float currentVelocity = getCurrentVelocity() * i5;
        this.mLastComputedVelocity = currentVelocity;
        if (currentVelocity < (-Math.abs(f6))) {
            this.mLastComputedVelocity = -Math.abs(f6);
        } else if (this.mLastComputedVelocity > Math.abs(f6)) {
            this.mLastComputedVelocity = Math.abs(f6);
        }
    }
}
