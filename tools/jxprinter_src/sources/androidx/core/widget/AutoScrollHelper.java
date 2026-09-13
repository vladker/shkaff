package androidx.core.widget;

import android.content.res.Resources;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import androidx.core.view.ViewCompat;
import org.opencv.videoio.Videoio;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AutoScrollHelper implements View.OnTouchListener {
    private static final int DEFAULT_ACTIVATION_DELAY = ViewConfiguration.getTapTimeout();
    private static final int DEFAULT_EDGE_TYPE = 1;
    private static final float DEFAULT_MAXIMUM_EDGE = Float.MAX_VALUE;
    private static final int DEFAULT_MAXIMUM_VELOCITY_DIPS = 1575;
    private static final int DEFAULT_MINIMUM_VELOCITY_DIPS = 315;
    private static final int DEFAULT_RAMP_DOWN_DURATION = 500;
    private static final int DEFAULT_RAMP_UP_DURATION = 500;
    private static final float DEFAULT_RELATIVE_EDGE = 0.2f;
    private static final float DEFAULT_RELATIVE_VELOCITY = 1.0f;
    public static final int EDGE_TYPE_INSIDE = 0;
    public static final int EDGE_TYPE_INSIDE_EXTEND = 1;
    public static final int EDGE_TYPE_OUTSIDE = 2;
    private static final int HORIZONTAL = 0;
    public static final float NO_MAX = Float.MAX_VALUE;
    public static final float NO_MIN = 0.0f;
    public static final float RELATIVE_UNSPECIFIED = 0.0f;
    private static final int VERTICAL = 1;
    private int mActivationDelay;
    private boolean mAlreadyDelayed;
    boolean mAnimating;
    private int mEdgeType;
    private boolean mEnabled;
    private boolean mExclusive;
    boolean mNeedsCancel;
    boolean mNeedsReset;
    private Runnable mRunnable;
    final View mTarget;
    final ClampedScroller mScroller = new ClampedScroller();
    private final Interpolator mEdgeInterpolator = new AccelerateInterpolator();
    private float[] mRelativeEdges = {0.0f, 0.0f};
    private float[] mMaximumEdges = {Float.MAX_VALUE, Float.MAX_VALUE};
    private float[] mRelativeVelocity = {0.0f, 0.0f};
    private float[] mMinimumVelocity = {0.0f, 0.0f};
    private float[] mMaximumVelocity = {Float.MAX_VALUE, Float.MAX_VALUE};

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class ClampedScroller {
        private int mEffectiveRampDown;
        private int mRampDownDuration;
        private int mRampUpDuration;
        private float mStopValue;
        private float mTargetVelocityX;
        private float mTargetVelocityY;
        private long mStartTime = Long.MIN_VALUE;
        private long mStopTime = -1;
        private long mDeltaTime = 0;
        private int mDeltaX = 0;
        private int mDeltaY = 0;

        private float getValueAt(long j6) {
            long j7 = this.mStartTime;
            if (j6 < j7) {
                return 0.0f;
            }
            long j8 = this.mStopTime;
            if (j8 < 0 || j6 < j8) {
                return AutoScrollHelper.constrain((j6 - j7) / this.mRampUpDuration, 0.0f, 1.0f) * 0.5f;
            }
            float f6 = this.mStopValue;
            return (AutoScrollHelper.constrain((j6 - j8) / this.mEffectiveRampDown, 0.0f, 1.0f) * f6) + (1.0f - f6);
        }

        private float interpolateValue(float f6) {
            return (f6 * 4.0f) + ((-4.0f) * f6 * f6);
        }

        public void computeScrollDelta() {
            if (this.mDeltaTime == 0) {
                throw new RuntimeException("Cannot compute scroll delta before calling start()");
            }
            long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            float fInterpolateValue = interpolateValue(getValueAt(jCurrentAnimationTimeMillis));
            long j6 = jCurrentAnimationTimeMillis - this.mDeltaTime;
            this.mDeltaTime = jCurrentAnimationTimeMillis;
            float f6 = j6 * fInterpolateValue;
            this.mDeltaX = (int) (this.mTargetVelocityX * f6);
            this.mDeltaY = (int) (f6 * this.mTargetVelocityY);
        }

        public int getDeltaX() {
            return this.mDeltaX;
        }

        public int getDeltaY() {
            return this.mDeltaY;
        }

        public int getHorizontalDirection() {
            float f6 = this.mTargetVelocityX;
            return (int) (f6 / Math.abs(f6));
        }

        public int getVerticalDirection() {
            float f6 = this.mTargetVelocityY;
            return (int) (f6 / Math.abs(f6));
        }

        public boolean isFinished() {
            return this.mStopTime > 0 && AnimationUtils.currentAnimationTimeMillis() > this.mStopTime + ((long) this.mEffectiveRampDown);
        }

        public void requestStop() {
            long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.mEffectiveRampDown = AutoScrollHelper.constrain((int) (jCurrentAnimationTimeMillis - this.mStartTime), 0, this.mRampDownDuration);
            this.mStopValue = getValueAt(jCurrentAnimationTimeMillis);
            this.mStopTime = jCurrentAnimationTimeMillis;
        }

        public void setRampDownDuration(int i5) {
            this.mRampDownDuration = i5;
        }

        public void setRampUpDuration(int i5) {
            this.mRampUpDuration = i5;
        }

        public void setTargetVelocity(float f6, float f7) {
            this.mTargetVelocityX = f6;
            this.mTargetVelocityY = f7;
        }

        public void start() {
            long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.mStartTime = jCurrentAnimationTimeMillis;
            this.mStopTime = -1L;
            this.mDeltaTime = jCurrentAnimationTimeMillis;
            this.mStopValue = 0.5f;
            this.mDeltaX = 0;
            this.mDeltaY = 0;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class ScrollAnimationRunnable implements Runnable {
        public ScrollAnimationRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AutoScrollHelper autoScrollHelper = AutoScrollHelper.this;
            if (autoScrollHelper.mAnimating) {
                if (autoScrollHelper.mNeedsReset) {
                    autoScrollHelper.mNeedsReset = false;
                    autoScrollHelper.mScroller.start();
                }
                ClampedScroller clampedScroller = AutoScrollHelper.this.mScroller;
                if (clampedScroller.isFinished() || !AutoScrollHelper.this.shouldAnimate()) {
                    AutoScrollHelper.this.mAnimating = false;
                    return;
                }
                AutoScrollHelper autoScrollHelper2 = AutoScrollHelper.this;
                if (autoScrollHelper2.mNeedsCancel) {
                    autoScrollHelper2.mNeedsCancel = false;
                    autoScrollHelper2.cancelTargetTouch();
                }
                clampedScroller.computeScrollDelta();
                AutoScrollHelper.this.scrollTargetBy(clampedScroller.getDeltaX(), clampedScroller.getDeltaY());
                ViewCompat.postOnAnimation(AutoScrollHelper.this.mTarget, this);
            }
        }
    }

    public AutoScrollHelper(View view) {
        this.mTarget = view;
        float f6 = Resources.getSystem().getDisplayMetrics().density;
        float f7 = (int) ((1575.0f * f6) + 0.5f);
        setMaximumVelocity(f7, f7);
        float f8 = (int) ((f6 * 315.0f) + 0.5f);
        setMinimumVelocity(f8, f8);
        setEdgeType(1);
        setMaximumEdges(Float.MAX_VALUE, Float.MAX_VALUE);
        setRelativeEdges(0.2f, 0.2f);
        setRelativeVelocity(1.0f, 1.0f);
        setActivationDelay(DEFAULT_ACTIVATION_DELAY);
        setRampUpDuration(Videoio.CAP_QT);
        setRampDownDuration(Videoio.CAP_QT);
    }

    private float computeTargetVelocity(int i5, float f6, float f7, float f8) {
        float edgeValue = getEdgeValue(this.mRelativeEdges[i5], f7, this.mMaximumEdges[i5], f6);
        if (edgeValue == 0.0f) {
            return 0.0f;
        }
        float f9 = this.mRelativeVelocity[i5];
        float f10 = this.mMinimumVelocity[i5];
        float f11 = this.mMaximumVelocity[i5];
        float f12 = f9 * f8;
        return edgeValue > 0.0f ? constrain(edgeValue * f12, f10, f11) : -constrain((-edgeValue) * f12, f10, f11);
    }

    public static float constrain(float f6, float f7, float f8) {
        if (f6 > f8) {
            return f8;
        }
        return f6 < f7 ? f7 : f6;
    }

    private float constrainEdgeValue(float f6, float f7) {
        if (f7 == 0.0f) {
            return 0.0f;
        }
        int i5 = this.mEdgeType;
        if (i5 == 0 || i5 == 1) {
            if (f6 < f7) {
                if (f6 >= 0.0f) {
                    return 1.0f - (f6 / f7);
                }
                if (this.mAnimating && i5 == 1) {
                    return 1.0f;
                }
            }
        } else if (i5 == 2 && f6 < 0.0f) {
            return f6 / (-f7);
        }
        return 0.0f;
    }

    private float getEdgeValue(float f6, float f7, float f8, float f9) {
        float interpolation;
        float fConstrain = constrain(f6 * f7, 0.0f, f8);
        float fConstrainEdgeValue = constrainEdgeValue(f7 - f9, fConstrain) - constrainEdgeValue(f9, fConstrain);
        if (fConstrainEdgeValue < 0.0f) {
            interpolation = -this.mEdgeInterpolator.getInterpolation(-fConstrainEdgeValue);
        } else {
            if (fConstrainEdgeValue <= 0.0f) {
                return 0.0f;
            }
            interpolation = this.mEdgeInterpolator.getInterpolation(fConstrainEdgeValue);
        }
        return constrain(interpolation, -1.0f, 1.0f);
    }

    private void requestStop() {
        if (this.mNeedsReset) {
            this.mAnimating = false;
        } else {
            this.mScroller.requestStop();
        }
    }

    private void startAnimating() {
        int i5;
        if (this.mRunnable == null) {
            this.mRunnable = new ScrollAnimationRunnable();
        }
        this.mAnimating = true;
        this.mNeedsReset = true;
        if (this.mAlreadyDelayed || (i5 = this.mActivationDelay) <= 0) {
            this.mRunnable.run();
        } else {
            ViewCompat.postOnAnimationDelayed(this.mTarget, this.mRunnable, i5);
        }
        this.mAlreadyDelayed = true;
    }

    public abstract boolean canTargetScrollHorizontally(int i5);

    public abstract boolean canTargetScrollVertically(int i5);

    public void cancelTargetTouch() {
        long jUptimeMillis = SystemClock.uptimeMillis();
        MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
        this.mTarget.onTouchEvent(motionEventObtain);
        motionEventObtain.recycle();
    }

    public boolean isEnabled() {
        return this.mEnabled;
    }

    public boolean isExclusive() {
        return this.mExclusive;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0016  */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (!this.mEnabled) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked == 1) {
                requestStop();
            } else if (actionMasked != 2) {
                if (actionMasked == 3) {
                    requestStop();
                }
            }
            return !this.mExclusive && this.mAnimating;
        }
        this.mNeedsCancel = true;
        this.mAlreadyDelayed = false;
        this.mScroller.setTargetVelocity(computeTargetVelocity(0, motionEvent.getX(), view.getWidth(), this.mTarget.getWidth()), computeTargetVelocity(1, motionEvent.getY(), view.getHeight(), this.mTarget.getHeight()));
        if (!this.mAnimating && shouldAnimate()) {
            startAnimating();
        }
        if (this.mExclusive) {
        }
    }

    public abstract void scrollTargetBy(int i5, int i6);

    public AutoScrollHelper setActivationDelay(int i5) {
        this.mActivationDelay = i5;
        return this;
    }

    public AutoScrollHelper setEdgeType(int i5) {
        this.mEdgeType = i5;
        return this;
    }

    public AutoScrollHelper setEnabled(boolean z6) {
        if (this.mEnabled && !z6) {
            requestStop();
        }
        this.mEnabled = z6;
        return this;
    }

    public AutoScrollHelper setExclusive(boolean z6) {
        this.mExclusive = z6;
        return this;
    }

    public AutoScrollHelper setMaximumEdges(float f6, float f7) {
        float[] fArr = this.mMaximumEdges;
        fArr[0] = f6;
        fArr[1] = f7;
        return this;
    }

    public AutoScrollHelper setMaximumVelocity(float f6, float f7) {
        float[] fArr = this.mMaximumVelocity;
        fArr[0] = f6 / 1000.0f;
        fArr[1] = f7 / 1000.0f;
        return this;
    }

    public AutoScrollHelper setMinimumVelocity(float f6, float f7) {
        float[] fArr = this.mMinimumVelocity;
        fArr[0] = f6 / 1000.0f;
        fArr[1] = f7 / 1000.0f;
        return this;
    }

    public AutoScrollHelper setRampDownDuration(int i5) {
        this.mScroller.setRampDownDuration(i5);
        return this;
    }

    public AutoScrollHelper setRampUpDuration(int i5) {
        this.mScroller.setRampUpDuration(i5);
        return this;
    }

    public AutoScrollHelper setRelativeEdges(float f6, float f7) {
        float[] fArr = this.mRelativeEdges;
        fArr[0] = f6;
        fArr[1] = f7;
        return this;
    }

    public AutoScrollHelper setRelativeVelocity(float f6, float f7) {
        float[] fArr = this.mRelativeVelocity;
        fArr[0] = f6 / 1000.0f;
        fArr[1] = f7 / 1000.0f;
        return this;
    }

    public boolean shouldAnimate() {
        ClampedScroller clampedScroller = this.mScroller;
        int verticalDirection = clampedScroller.getVerticalDirection();
        int horizontalDirection = clampedScroller.getHorizontalDirection();
        if (verticalDirection == 0 || !canTargetScrollVertically(verticalDirection)) {
            return horizontalDirection != 0 && canTargetScrollHorizontally(horizontalDirection);
        }
        return true;
    }

    public static int constrain(int i5, int i6, int i7) {
        if (i5 > i7) {
            return i7;
        }
        return i5 < i6 ? i6 : i5;
    }
}
