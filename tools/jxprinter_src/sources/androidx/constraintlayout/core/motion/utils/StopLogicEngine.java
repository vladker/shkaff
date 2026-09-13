package androidx.constraintlayout.core.motion.utils;

import A3.AbstractC0157z;
import androidx.collection.a;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class StopLogicEngine implements StopEngine {
    private static final float EPSILON = 1.0E-5f;
    private boolean mBackwards = false;
    private boolean mDone = false;
    private float mLastPosition;
    private float mLastTime;
    private int mNumberOfStages;
    private float mStage1Duration;
    private float mStage1EndPosition;
    private float mStage1Velocity;
    private float mStage2Duration;
    private float mStage2EndPosition;
    private float mStage2Velocity;
    private float mStage3Duration;
    private float mStage3EndPosition;
    private float mStage3Velocity;
    private float mStartPosition;
    private String mType;

    private float calcY(float f6) {
        this.mDone = false;
        float f7 = this.mStage1Duration;
        if (f6 <= f7) {
            float f8 = this.mStage1Velocity;
            return ((((this.mStage2Velocity - f8) * f6) * f6) / (f7 * 2.0f)) + (f8 * f6);
        }
        int i5 = this.mNumberOfStages;
        if (i5 == 1) {
            return this.mStage1EndPosition;
        }
        float f9 = f6 - f7;
        float f10 = this.mStage2Duration;
        if (f9 < f10) {
            float f11 = this.mStage1EndPosition;
            float f12 = this.mStage2Velocity;
            return ((((this.mStage3Velocity - f12) * f9) * f9) / (f10 * 2.0f)) + (f12 * f9) + f11;
        }
        if (i5 == 2) {
            return this.mStage2EndPosition;
        }
        float f13 = f9 - f10;
        float f14 = this.mStage3Duration;
        if (f13 > f14) {
            this.mDone = true;
            return this.mStage3EndPosition;
        }
        float f15 = this.mStage2EndPosition;
        float f16 = this.mStage3Velocity;
        return ((f16 * f13) + f15) - (((f16 * f13) * f13) / (f14 * 2.0f));
    }

    private void setup(float f6, float f7, float f8, float f9, float f10) {
        this.mDone = false;
        this.mStage3EndPosition = f7;
        if (f6 == 0.0f) {
            f6 = 1.0E-4f;
        }
        float f11 = f6 / f8;
        float f12 = (f11 * f6) / 2.0f;
        if (f6 < 0.0f) {
            float fSqrt = (float) Math.sqrt((f7 - ((((-f6) / f8) * f6) / 2.0f)) * f8);
            if (fSqrt < f9) {
                this.mType = "backward accelerate, decelerate";
                this.mNumberOfStages = 2;
                this.mStage1Velocity = f6;
                this.mStage2Velocity = fSqrt;
                this.mStage3Velocity = 0.0f;
                float f13 = (fSqrt - f6) / f8;
                this.mStage1Duration = f13;
                this.mStage2Duration = fSqrt / f8;
                this.mStage1EndPosition = ((f6 + fSqrt) * f13) / 2.0f;
                this.mStage2EndPosition = f7;
                this.mStage3EndPosition = f7;
                return;
            }
            this.mType = "backward accelerate cruse decelerate";
            this.mNumberOfStages = 3;
            this.mStage1Velocity = f6;
            this.mStage2Velocity = f9;
            this.mStage3Velocity = f9;
            float f14 = (f9 - f6) / f8;
            this.mStage1Duration = f14;
            float f15 = f9 / f8;
            this.mStage3Duration = f15;
            float f16 = ((f6 + f9) * f14) / 2.0f;
            float f17 = (f15 * f9) / 2.0f;
            this.mStage2Duration = ((f7 - f16) - f17) / f9;
            this.mStage1EndPosition = f16;
            this.mStage2EndPosition = f7 - f17;
            this.mStage3EndPosition = f7;
            return;
        }
        if (f12 >= f7) {
            this.mType = "hard stop";
            this.mNumberOfStages = 1;
            this.mStage1Velocity = f6;
            this.mStage2Velocity = 0.0f;
            this.mStage1EndPosition = f7;
            this.mStage1Duration = (2.0f * f7) / f6;
            return;
        }
        float f18 = f7 - f12;
        float f19 = f18 / f6;
        if (f19 + f11 < f10) {
            this.mType = "cruse decelerate";
            this.mNumberOfStages = 2;
            this.mStage1Velocity = f6;
            this.mStage2Velocity = f6;
            this.mStage3Velocity = 0.0f;
            this.mStage1EndPosition = f18;
            this.mStage2EndPosition = f7;
            this.mStage1Duration = f19;
            this.mStage2Duration = f11;
            return;
        }
        float fSqrt2 = (float) Math.sqrt(((f6 * f6) / 2.0f) + (f8 * f7));
        float f20 = (fSqrt2 - f6) / f8;
        this.mStage1Duration = f20;
        float f21 = fSqrt2 / f8;
        this.mStage2Duration = f21;
        if (fSqrt2 < f9) {
            this.mType = "accelerate decelerate";
            this.mNumberOfStages = 2;
            this.mStage1Velocity = f6;
            this.mStage2Velocity = fSqrt2;
            this.mStage3Velocity = 0.0f;
            this.mStage1Duration = f20;
            this.mStage2Duration = f21;
            this.mStage1EndPosition = ((f6 + fSqrt2) * f20) / 2.0f;
            this.mStage2EndPosition = f7;
            return;
        }
        this.mType = "accelerate cruse decelerate";
        this.mNumberOfStages = 3;
        this.mStage1Velocity = f6;
        this.mStage2Velocity = f9;
        this.mStage3Velocity = f9;
        float f22 = (f9 - f6) / f8;
        this.mStage1Duration = f22;
        float f23 = f9 / f8;
        this.mStage3Duration = f23;
        float f24 = ((f6 + f9) * f22) / 2.0f;
        float f25 = (f23 * f9) / 2.0f;
        this.mStage2Duration = ((f7 - f24) - f25) / f9;
        this.mStage1EndPosition = f24;
        this.mStage2EndPosition = f7 - f25;
        this.mStage3EndPosition = f7;
    }

    public void config(float f6, float f7, float f8, float f9, float f10, float f11) {
        this.mDone = false;
        this.mStartPosition = f6;
        boolean z6 = f6 > f7;
        this.mBackwards = z6;
        if (z6) {
            setup(-f8, f6 - f7, f10, f11, f9);
        } else {
            setup(f8, f7 - f6, f10, f11, f9);
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public String debug(String str, float f6) {
        StringBuilder sbX = AbstractC0157z.x(AbstractC0157z.s(AbstractC0157z.x(str, " ===== "), this.mType, "\n"), str);
        sbX.append(this.mBackwards ? "backwards" : "forward ");
        sbX.append(" time = ");
        sbX.append(f6);
        sbX.append("  stages ");
        String strL = AbstractC0157z.l("\n", this.mNumberOfStages, sbX);
        StringBuilder sb = new StringBuilder();
        sb.append(strL);
        sb.append(str);
        sb.append(" dur ");
        sb.append(this.mStage1Duration);
        sb.append(" vel ");
        sb.append(this.mStage1Velocity);
        sb.append(" pos ");
        String strQ = a.q(sb, "\n", this.mStage1EndPosition);
        if (this.mNumberOfStages > 1) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(strQ);
            sb2.append(str);
            sb2.append(" dur ");
            sb2.append(this.mStage2Duration);
            sb2.append(" vel ");
            sb2.append(this.mStage2Velocity);
            sb2.append(" pos ");
            strQ = a.q(sb2, "\n", this.mStage2EndPosition);
        }
        if (this.mNumberOfStages > 2) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(strQ);
            sb3.append(str);
            sb3.append(" dur ");
            sb3.append(this.mStage3Duration);
            sb3.append(" vel ");
            sb3.append(this.mStage3Velocity);
            sb3.append(" pos ");
            strQ = a.q(sb3, "\n", this.mStage3EndPosition);
        }
        float f7 = this.mStage1Duration;
        if (f6 <= f7) {
            return a.o(strQ, str, "stage 0\n");
        }
        int i5 = this.mNumberOfStages;
        if (i5 == 1) {
            return a.o(strQ, str, "end stage 0\n");
        }
        float f8 = f6 - f7;
        float f9 = this.mStage2Duration;
        if (f8 < f9) {
            return a.o(strQ, str, " stage 1\n");
        }
        if (i5 == 2) {
            return a.o(strQ, str, "end stage 1\n");
        }
        return f8 - f9 < this.mStage3Duration ? a.o(strQ, str, " stage 2\n") : a.o(strQ, str, " end stage 2\n");
    }

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public float getInterpolation(float f6) {
        float fCalcY = calcY(f6);
        this.mLastPosition = fCalcY;
        this.mLastTime = f6;
        return this.mBackwards ? this.mStartPosition - fCalcY : this.mStartPosition + fCalcY;
    }

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public float getVelocity(float f6) {
        float f7;
        float f8;
        float f9 = this.mStage1Duration;
        if (f6 <= f9) {
            f7 = this.mStage1Velocity;
            f8 = this.mStage2Velocity;
        } else {
            int i5 = this.mNumberOfStages;
            if (i5 == 1) {
                return 0.0f;
            }
            f6 -= f9;
            f9 = this.mStage2Duration;
            if (f6 >= f9) {
                if (i5 == 2) {
                    return 0.0f;
                }
                float f10 = f6 - f9;
                float f11 = this.mStage3Duration;
                if (f10 >= f11) {
                    return 0.0f;
                }
                float f12 = this.mStage3Velocity;
                return f12 - ((f10 * f12) / f11);
            }
            f7 = this.mStage2Velocity;
            f8 = this.mStage3Velocity;
        }
        return (((f8 - f7) * f6) / f9) + f7;
    }

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public boolean isStopped() {
        return getVelocity() < EPSILON && Math.abs(this.mStage3EndPosition - this.mLastPosition) < EPSILON;
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class Decelerate implements StopEngine {
        private float mAcceleration;
        private float mDestination;
        private boolean mDone = false;
        private float mDuration;
        private float mInitialPos;
        private float mInitialVelocity;
        private float mLastVelocity;

        public void config(float f6, float f7, float f8) {
            this.mDone = false;
            this.mDestination = f7;
            this.mInitialVelocity = f8;
            this.mInitialPos = f6;
            float f9 = (f7 - f6) / (f8 / 2.0f);
            this.mDuration = f9;
            this.mAcceleration = (-f8) / f9;
        }

        @Override // androidx.constraintlayout.core.motion.utils.StopEngine
        public String debug(String str, float f6) {
            return this.mDuration + " " + this.mLastVelocity;
        }

        @Override // androidx.constraintlayout.core.motion.utils.StopEngine
        public float getInterpolation(float f6) {
            if (f6 > this.mDuration) {
                this.mDone = true;
                return this.mDestination;
            }
            getVelocity(f6);
            return ((((this.mAcceleration * f6) / 2.0f) + this.mInitialVelocity) * f6) + this.mInitialPos;
        }

        @Override // androidx.constraintlayout.core.motion.utils.StopEngine
        public float getVelocity(float f6) {
            if (f6 > this.mDuration) {
                return 0.0f;
            }
            float f7 = (this.mAcceleration * f6) + this.mInitialVelocity;
            this.mLastVelocity = f7;
            return f7;
        }

        @Override // androidx.constraintlayout.core.motion.utils.StopEngine
        public boolean isStopped() {
            return this.mDone;
        }

        @Override // androidx.constraintlayout.core.motion.utils.StopEngine
        public float getVelocity() {
            return this.mLastVelocity;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public float getVelocity() {
        return this.mBackwards ? -getVelocity(this.mLastTime) : getVelocity(this.mLastTime);
    }
}
