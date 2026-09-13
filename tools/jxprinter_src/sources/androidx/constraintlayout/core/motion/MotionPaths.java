package androidx.constraintlayout.core.motion;

import A3.AbstractC0157z;
import androidx.constraintlayout.core.motion.key.MotionKeyPosition;
import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.core.state.WidgetFrame;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.util.Arrays;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class MotionPaths implements Comparable<MotionPaths> {
    public static final int CARTESIAN = 0;
    public static final boolean DEBUG = false;
    static final int OFF_HEIGHT = 4;
    static final int OFF_PATH_ROTATE = 5;
    static final int OFF_POSITION = 0;
    static final int OFF_WIDTH = 3;
    static final int OFF_X = 1;
    static final int OFF_Y = 2;
    public static final boolean OLD_WAY = false;
    public static final int PERPENDICULAR = 1;
    public static final int SCREEN = 2;
    public static final String TAG = "MotionPaths";
    static String[] sNames = {"position", "x", "y", "width", "height", "pathRotate"};
    int mAnimateCircleAngleTo;
    String mAnimateRelativeTo;
    HashMap<String, CustomVariable> mCustomAttributes;
    int mDrawPath;
    float mHeight;
    public String mId;
    Easing mKeyFrameEasing;
    int mMode;
    int mPathMotionArc;
    float mPathRotate;
    float mPosition;
    float mProgress;
    float mRelativeAngle;
    Motion mRelativeToController;
    double[] mTempDelta;
    double[] mTempValue;
    float mTime;
    float mWidth;
    float mX;
    float mY;

    public MotionPaths() {
        this.mDrawPath = 0;
        this.mPathRotate = Float.NaN;
        this.mProgress = Float.NaN;
        this.mPathMotionArc = -1;
        this.mAnimateRelativeTo = null;
        this.mRelativeAngle = Float.NaN;
        this.mRelativeToController = null;
        this.mCustomAttributes = new HashMap<>();
        this.mMode = 0;
        this.mTempValue = new double[18];
        this.mTempDelta = new double[18];
    }

    private boolean diff(float f6, float f7) {
        if (Float.isNaN(f6) || Float.isNaN(f7)) {
            return Float.isNaN(f6) != Float.isNaN(f7);
        }
        return Math.abs(f6 - f7) > 1.0E-6f;
    }

    private static float xRotate(float f6, float f7, float f8, float f9, float f10, float f11) {
        return (((f10 - f8) * f7) - ((f11 - f9) * f6)) + f8;
    }

    private static float yRotate(float f6, float f7, float f8, float f9, float f10, float f11) {
        return ((f11 - f9) * f7) + ((f10 - f8) * f6) + f9;
    }

    public void applyParameters(MotionWidget motionWidget) {
        ConstraintWidget constraintWidget;
        this.mKeyFrameEasing = Easing.getInterpolator(motionWidget.mMotion.mTransitionEasing);
        MotionWidget.Motion motion = motionWidget.mMotion;
        this.mPathMotionArc = motion.mPathMotionArc;
        this.mAnimateRelativeTo = motion.mAnimateRelativeTo;
        this.mPathRotate = motion.mPathRotate;
        this.mDrawPath = motion.mDrawPath;
        this.mAnimateCircleAngleTo = motion.mAnimateCircleAngleTo;
        this.mProgress = motionWidget.mPropertySet.mProgress;
        WidgetFrame widgetFrame = motionWidget.mWidgetFrame;
        if (widgetFrame != null && (constraintWidget = widgetFrame.widget) != null) {
            this.mRelativeAngle = constraintWidget.mCircleConstraintAngle;
        }
        for (String str : motionWidget.getCustomAttributeNames()) {
            CustomVariable customAttribute = motionWidget.getCustomAttribute(str);
            if (customAttribute != null && customAttribute.isContinuous()) {
                this.mCustomAttributes.put(str, customAttribute);
            }
        }
    }

    public void configureRelativeTo(Motion motion) {
        motion.getPos(this.mProgress);
    }

    public void different(MotionPaths motionPaths, boolean[] zArr, String[] strArr, boolean z6) {
        boolean zDiff = diff(this.mX, motionPaths.mX);
        boolean zDiff2 = diff(this.mY, motionPaths.mY);
        zArr[0] = zArr[0] | diff(this.mPosition, motionPaths.mPosition);
        zArr[1] = zArr[1] | (zDiff || zDiff2 || z6);
        zArr[2] = zArr[2] | (zDiff || zDiff2 || z6);
        zArr[3] = zArr[3] | diff(this.mWidth, motionPaths.mWidth);
        zArr[4] = diff(this.mHeight, motionPaths.mHeight) | zArr[4];
    }

    public void fillStandard(double[] dArr, int[] iArr) {
        float[] fArr = {this.mPosition, this.mX, this.mY, this.mWidth, this.mHeight, this.mPathRotate};
        int i5 = 0;
        for (int i6 : iArr) {
            if (i6 < 6) {
                dArr[i5] = fArr[i6];
                i5++;
            }
        }
    }

    public void getBounds(int[] iArr, double[] dArr, float[] fArr, int i5) {
        float f6 = this.mWidth;
        float f7 = this.mHeight;
        for (int i6 = 0; i6 < iArr.length; i6++) {
            float f8 = (float) dArr[i6];
            int i7 = iArr[i6];
            if (i7 == 3) {
                f6 = f8;
            } else if (i7 == 4) {
                f7 = f8;
            }
        }
        fArr[i5] = f6;
        fArr[i5 + 1] = f7;
    }

    public void getCenter(double d, int[] iArr, double[] dArr, float[] fArr, int i5) {
        float fSin = this.mX;
        float fCos = this.mY;
        float f6 = this.mWidth;
        float f7 = this.mHeight;
        for (int i6 = 0; i6 < iArr.length; i6++) {
            float f8 = (float) dArr[i6];
            int i7 = iArr[i6];
            if (i7 == 1) {
                fSin = f8;
            } else if (i7 == 2) {
                fCos = f8;
            } else if (i7 == 3) {
                f6 = f8;
            } else if (i7 == 4) {
                f7 = f8;
            }
        }
        Motion motion = this.mRelativeToController;
        if (motion != null) {
            float[] fArr2 = new float[2];
            motion.getCenter(d, fArr2, new float[2]);
            float f9 = fArr2[0];
            float f10 = fArr2[1];
            double d6 = f9;
            double d7 = fSin;
            double d8 = fCos;
            fSin = (float) (((Math.sin(d8) * d7) + d6) - ((double) (f6 / 2.0f)));
            fCos = (float) ((((double) f10) - (Math.cos(d8) * d7)) - ((double) (f7 / 2.0f)));
        }
        fArr[i5] = (f6 / 2.0f) + fSin + 0.0f;
        fArr[i5 + 1] = (f7 / 2.0f) + fCos + 0.0f;
    }

    public void getCenterVelocity(double d, int[] iArr, double[] dArr, float[] fArr, int i5) {
        float fSin = this.mX;
        float fCos = this.mY;
        float f6 = this.mWidth;
        float f7 = this.mHeight;
        for (int i6 = 0; i6 < iArr.length; i6++) {
            float f8 = (float) dArr[i6];
            int i7 = iArr[i6];
            if (i7 == 1) {
                fSin = f8;
            } else if (i7 == 2) {
                fCos = f8;
            } else if (i7 == 3) {
                f6 = f8;
            } else if (i7 == 4) {
                f7 = f8;
            }
        }
        Motion motion = this.mRelativeToController;
        if (motion != null) {
            float[] fArr2 = new float[2];
            motion.getCenter(d, fArr2, new float[2]);
            float f9 = fArr2[0];
            float f10 = fArr2[1];
            double d6 = f9;
            double d7 = fSin;
            double d8 = fCos;
            fSin = (float) (((Math.sin(d8) * d7) + d6) - ((double) (f6 / 2.0f)));
            fCos = (float) ((((double) f10) - (Math.cos(d8) * d7)) - ((double) (f7 / 2.0f)));
        }
        fArr[i5] = (f6 / 2.0f) + fSin + 0.0f;
        fArr[i5 + 1] = (f7 / 2.0f) + fCos + 0.0f;
    }

    public int getCustomData(String str, double[] dArr, int i5) {
        CustomVariable customVariable = this.mCustomAttributes.get(str);
        int i6 = 0;
        if (customVariable == null) {
            return 0;
        }
        if (customVariable.numberOfInterpolatedValues() == 1) {
            dArr[i5] = customVariable.getValueToInterpolate();
            return 1;
        }
        int iNumberOfInterpolatedValues = customVariable.numberOfInterpolatedValues();
        float[] fArr = new float[iNumberOfInterpolatedValues];
        customVariable.getValuesToInterpolate(fArr);
        while (i6 < iNumberOfInterpolatedValues) {
            dArr[i5] = fArr[i6];
            i6++;
            i5++;
        }
        return iNumberOfInterpolatedValues;
    }

    public int getCustomDataCount(String str) {
        CustomVariable customVariable = this.mCustomAttributes.get(str);
        if (customVariable == null) {
            return 0;
        }
        return customVariable.numberOfInterpolatedValues();
    }

    public void getRect(int[] iArr, double[] dArr, float[] fArr, int i5) {
        float f6 = this.mX;
        float fCos = this.mY;
        float f7 = this.mWidth;
        float f8 = this.mHeight;
        for (int i6 = 0; i6 < iArr.length; i6++) {
            float f9 = (float) dArr[i6];
            int i7 = iArr[i6];
            if (i7 == 1) {
                f6 = f9;
            } else if (i7 == 2) {
                fCos = f9;
            } else if (i7 == 3) {
                f7 = f9;
            } else if (i7 == 4) {
                f8 = f9;
            }
        }
        Motion motion = this.mRelativeToController;
        if (motion != null) {
            float centerX = motion.getCenterX();
            float centerY = this.mRelativeToController.getCenterY();
            double d = f6;
            double d6 = fCos;
            float fSin = (float) (((Math.sin(d6) * d) + ((double) centerX)) - ((double) (f7 / 2.0f)));
            fCos = (float) ((((double) centerY) - (Math.cos(d6) * d)) - ((double) (f8 / 2.0f)));
            f6 = fSin;
        }
        float f10 = f7 + f6;
        float f11 = f8 + fCos;
        Float.isNaN(Float.NaN);
        Float.isNaN(Float.NaN);
        fArr[i5] = f6 + 0.0f;
        fArr[i5 + 1] = fCos + 0.0f;
        fArr[i5 + 2] = f10 + 0.0f;
        fArr[i5 + 3] = fCos + 0.0f;
        fArr[i5 + 4] = f10 + 0.0f;
        fArr[i5 + 5] = f11 + 0.0f;
        fArr[i5 + 6] = f6 + 0.0f;
        fArr[i5 + 7] = f11 + 0.0f;
    }

    public boolean hasCustomData(String str) {
        return this.mCustomAttributes.containsKey(str);
    }

    public void initCartesian(MotionKeyPosition motionKeyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        float f6 = motionKeyPosition.mFramePosition / 100.0f;
        this.mTime = f6;
        this.mDrawPath = motionKeyPosition.mDrawPath;
        float f7 = Float.isNaN(motionKeyPosition.mPercentWidth) ? f6 : motionKeyPosition.mPercentWidth;
        float f8 = Float.isNaN(motionKeyPosition.mPercentHeight) ? f6 : motionKeyPosition.mPercentHeight;
        float f9 = motionPaths2.mWidth;
        float f10 = motionPaths.mWidth;
        float f11 = f9 - f10;
        float f12 = motionPaths2.mHeight;
        float f13 = motionPaths.mHeight;
        float f14 = f12 - f13;
        this.mPosition = this.mTime;
        float f15 = motionPaths.mX;
        float f16 = motionPaths.mY;
        float f17 = f6;
        float f18 = ((f9 / 2.0f) + motionPaths2.mX) - ((f10 / 2.0f) + f15);
        float f19 = ((f12 / 2.0f) + motionPaths2.mY) - ((f13 / 2.0f) + f16);
        float f20 = f11 * f7;
        float f21 = f20 / 2.0f;
        this.mX = (int) (((f18 * f17) + f15) - f21);
        float f22 = f14 * f8;
        float f23 = f22 / 2.0f;
        this.mY = (int) (((f19 * f17) + f16) - f23);
        this.mWidth = (int) (f10 + f20);
        this.mHeight = (int) (f13 + f22);
        float f24 = Float.isNaN(motionKeyPosition.mPercentX) ? f17 : motionKeyPosition.mPercentX;
        float f25 = Float.isNaN(motionKeyPosition.mAltPercentY) ? 0.0f : motionKeyPosition.mAltPercentY;
        if (!Float.isNaN(motionKeyPosition.mPercentY)) {
            f17 = motionKeyPosition.mPercentY;
        }
        float f26 = Float.isNaN(motionKeyPosition.mAltPercentX) ? 0.0f : motionKeyPosition.mAltPercentX;
        this.mMode = 0;
        this.mX = (int) (((f26 * f19) + ((f24 * f18) + motionPaths.mX)) - f21);
        this.mY = (int) (((f19 * f17) + ((f18 * f25) + motionPaths.mY)) - f23);
        this.mKeyFrameEasing = Easing.getInterpolator(motionKeyPosition.mTransitionEasing);
        this.mPathMotionArc = motionKeyPosition.mPathMotionArc;
    }

    public void initPath(MotionKeyPosition motionKeyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        float f6 = motionKeyPosition.mFramePosition / 100.0f;
        this.mTime = f6;
        this.mDrawPath = motionKeyPosition.mDrawPath;
        float f7 = Float.isNaN(motionKeyPosition.mPercentWidth) ? f6 : motionKeyPosition.mPercentWidth;
        float f8 = Float.isNaN(motionKeyPosition.mPercentHeight) ? f6 : motionKeyPosition.mPercentHeight;
        float f9 = motionPaths2.mWidth - motionPaths.mWidth;
        float f10 = motionPaths2.mHeight - motionPaths.mHeight;
        this.mPosition = this.mTime;
        if (!Float.isNaN(motionKeyPosition.mPercentX)) {
            f6 = motionKeyPosition.mPercentX;
        }
        float f11 = motionPaths.mX;
        float f12 = motionPaths.mWidth;
        float f13 = motionPaths.mY;
        float f14 = motionPaths.mHeight;
        float f15 = f6;
        float f16 = ((motionPaths2.mWidth / 2.0f) + motionPaths2.mX) - ((f12 / 2.0f) + f11);
        float f17 = ((motionPaths2.mHeight / 2.0f) + motionPaths2.mY) - ((f14 / 2.0f) + f13);
        float f18 = f16 * f15;
        float f19 = f9 * f7;
        float f20 = f19 / 2.0f;
        this.mX = (int) ((f11 + f18) - f20);
        float f21 = f17 * f15;
        float f22 = f10 * f8;
        float f23 = f22 / 2.0f;
        this.mY = (int) ((f13 + f21) - f23);
        this.mWidth = (int) (f12 + f19);
        this.mHeight = (int) (f14 + f22);
        float f24 = Float.isNaN(motionKeyPosition.mPercentY) ? 0.0f : motionKeyPosition.mPercentY;
        this.mMode = 1;
        float f25 = (int) ((motionPaths.mX + f18) - f20);
        float f26 = (int) ((motionPaths.mY + f21) - f23);
        this.mX = f25 + ((-f17) * f24);
        this.mY = f26 + (f16 * f24);
        this.mAnimateRelativeTo = this.mAnimateRelativeTo;
        this.mKeyFrameEasing = Easing.getInterpolator(motionKeyPosition.mTransitionEasing);
        this.mPathMotionArc = motionKeyPosition.mPathMotionArc;
    }

    public void initPolar(int i5, int i6, MotionKeyPosition motionKeyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        float fMin;
        float fA;
        float f6 = motionKeyPosition.mFramePosition / 100.0f;
        this.mTime = f6;
        this.mDrawPath = motionKeyPosition.mDrawPath;
        this.mMode = motionKeyPosition.mPositionType;
        float f7 = Float.isNaN(motionKeyPosition.mPercentWidth) ? f6 : motionKeyPosition.mPercentWidth;
        float f8 = Float.isNaN(motionKeyPosition.mPercentHeight) ? f6 : motionKeyPosition.mPercentHeight;
        float f9 = motionPaths2.mWidth;
        float f10 = motionPaths.mWidth;
        float f11 = motionPaths2.mHeight;
        float f12 = motionPaths.mHeight;
        this.mPosition = this.mTime;
        this.mWidth = (int) (((f9 - f10) * f7) + f10);
        this.mHeight = (int) (((f11 - f12) * f8) + f12);
        int i7 = motionKeyPosition.mPositionType;
        if (i7 == 1) {
            float f13 = Float.isNaN(motionKeyPosition.mPercentX) ? f6 : motionKeyPosition.mPercentX;
            float f14 = motionPaths2.mX;
            float f15 = motionPaths.mX;
            this.mX = AbstractC0157z.a(f14, f15, f13, f15);
            if (!Float.isNaN(motionKeyPosition.mPercentY)) {
                f6 = motionKeyPosition.mPercentY;
            }
            float f16 = motionPaths2.mY;
            float f17 = motionPaths.mY;
            this.mY = AbstractC0157z.a(f16, f17, f6, f17);
        } else if (i7 != 2) {
            float f18 = Float.isNaN(motionKeyPosition.mPercentX) ? f6 : motionKeyPosition.mPercentX;
            float f19 = motionPaths2.mX;
            float f20 = motionPaths.mX;
            this.mX = AbstractC0157z.a(f19, f20, f18, f20);
            if (!Float.isNaN(motionKeyPosition.mPercentY)) {
                f6 = motionKeyPosition.mPercentY;
            }
            float f21 = motionPaths2.mY;
            float f22 = motionPaths.mY;
            this.mY = AbstractC0157z.a(f21, f22, f6, f22);
        } else {
            if (Float.isNaN(motionKeyPosition.mPercentX)) {
                float f23 = motionPaths2.mX;
                float f24 = motionPaths.mX;
                fMin = AbstractC0157z.a(f23, f24, f6, f24);
            } else {
                fMin = Math.min(f8, f7) * motionKeyPosition.mPercentX;
            }
            this.mX = fMin;
            if (Float.isNaN(motionKeyPosition.mPercentY)) {
                float f25 = motionPaths2.mY;
                float f26 = motionPaths.mY;
                fA = AbstractC0157z.a(f25, f26, f6, f26);
            } else {
                fA = motionKeyPosition.mPercentY;
            }
            this.mY = fA;
        }
        this.mAnimateRelativeTo = motionPaths.mAnimateRelativeTo;
        this.mKeyFrameEasing = Easing.getInterpolator(motionKeyPosition.mTransitionEasing);
        this.mPathMotionArc = motionKeyPosition.mPathMotionArc;
    }

    public void initScreen(int i5, int i6, MotionKeyPosition motionKeyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        float f6 = motionKeyPosition.mFramePosition / 100.0f;
        this.mTime = f6;
        this.mDrawPath = motionKeyPosition.mDrawPath;
        float f7 = Float.isNaN(motionKeyPosition.mPercentWidth) ? f6 : motionKeyPosition.mPercentWidth;
        float f8 = Float.isNaN(motionKeyPosition.mPercentHeight) ? f6 : motionKeyPosition.mPercentHeight;
        float f9 = motionPaths2.mWidth;
        float f10 = motionPaths.mWidth;
        float f11 = f9 - f10;
        float f12 = motionPaths2.mHeight;
        float f13 = motionPaths.mHeight;
        float f14 = f12 - f13;
        this.mPosition = this.mTime;
        float f15 = motionPaths.mX;
        float f16 = motionPaths.mY;
        float f17 = (f9 / 2.0f) + motionPaths2.mX;
        float f18 = (f12 / 2.0f) + motionPaths2.mY;
        float f19 = f11 * f7;
        this.mX = (int) ((((f17 - ((f10 / 2.0f) + f15)) * f6) + f15) - (f19 / 2.0f));
        float f20 = f14 * f8;
        this.mY = (int) ((((f18 - ((f13 / 2.0f) + f16)) * f6) + f16) - (f20 / 2.0f));
        this.mWidth = (int) (f10 + f19);
        this.mHeight = (int) (f13 + f20);
        this.mMode = 2;
        if (!Float.isNaN(motionKeyPosition.mPercentX)) {
            this.mX = (int) (motionKeyPosition.mPercentX * (i5 - ((int) this.mWidth)));
        }
        if (!Float.isNaN(motionKeyPosition.mPercentY)) {
            this.mY = (int) (motionKeyPosition.mPercentY * (i6 - ((int) this.mHeight)));
        }
        this.mAnimateRelativeTo = this.mAnimateRelativeTo;
        this.mKeyFrameEasing = Easing.getInterpolator(motionKeyPosition.mTransitionEasing);
        this.mPathMotionArc = motionKeyPosition.mPathMotionArc;
    }

    public void setBounds(float f6, float f7, float f8, float f9) {
        this.mX = f6;
        this.mY = f7;
        this.mWidth = f8;
        this.mHeight = f9;
    }

    public void setDpDt(float f6, float f7, float[] fArr, int[] iArr, double[] dArr, double[] dArr2) {
        float f8 = 0.0f;
        float f9 = 0.0f;
        float f10 = 0.0f;
        float f11 = 0.0f;
        for (int i5 = 0; i5 < iArr.length; i5++) {
            float f12 = (float) dArr[i5];
            int i6 = iArr[i5];
            if (i6 == 1) {
                f8 = f12;
            } else if (i6 == 2) {
                f10 = f12;
            } else if (i6 == 3) {
                f9 = f12;
            } else if (i6 == 4) {
                f11 = f12;
            }
        }
        float f13 = f8 - ((0.0f * f9) / 2.0f);
        float f14 = f10 - ((0.0f * f11) / 2.0f);
        fArr[0] = (((f9 * 1.0f) + f13) * f6) + ((1.0f - f6) * f13) + 0.0f;
        fArr[1] = (((f11 * 1.0f) + f14) * f7) + ((1.0f - f7) * f14) + 0.0f;
    }

    public void setView(float f6, MotionWidget motionWidget, int[] iArr, double[] dArr, double[] dArr2, double[] dArr3) {
        float f7;
        float fSin = this.mX;
        float fCos = this.mY;
        float f8 = this.mWidth;
        float f9 = this.mHeight;
        if (iArr.length != 0 && this.mTempValue.length <= iArr[iArr.length - 1]) {
            int i5 = iArr[iArr.length - 1] + 1;
            this.mTempValue = new double[i5];
            this.mTempDelta = new double[i5];
        }
        Arrays.fill(this.mTempValue, Double.NaN);
        for (int i6 = 0; i6 < iArr.length; i6++) {
            double[] dArr4 = this.mTempValue;
            int i7 = iArr[i6];
            dArr4[i7] = dArr[i6];
            this.mTempDelta[i7] = dArr2[i6];
        }
        float f10 = Float.NaN;
        int i8 = 0;
        float f11 = 0.0f;
        float f12 = 0.0f;
        float f13 = 0.0f;
        float f14 = 0.0f;
        while (true) {
            double[] dArr5 = this.mTempValue;
            if (i8 >= dArr5.length) {
                break;
            }
            if (Double.isNaN(dArr5[i8]) && (dArr3 == null || dArr3[i8] == 0.0d)) {
                f7 = f10;
            } else {
                double d = dArr3 != null ? dArr3[i8] : 0.0d;
                if (!Double.isNaN(this.mTempValue[i8])) {
                    d = this.mTempValue[i8] + d;
                }
                f7 = f10;
                float f15 = (float) d;
                float f16 = (float) this.mTempDelta[i8];
                if (i8 == 1) {
                    f10 = f7;
                    f11 = f16;
                    fSin = f15;
                } else if (i8 == 2) {
                    f10 = f7;
                    f12 = f16;
                    fCos = f15;
                } else if (i8 == 3) {
                    f10 = f7;
                    f13 = f16;
                    f8 = f15;
                } else if (i8 == 4) {
                    f10 = f7;
                    f14 = f16;
                    f9 = f15;
                } else if (i8 == 5) {
                    f10 = f15;
                }
                i8++;
            }
            f10 = f7;
            i8++;
        }
        float f17 = f10;
        Motion motion = this.mRelativeToController;
        if (motion != null) {
            float[] fArr = new float[2];
            float[] fArr2 = new float[2];
            motion.getCenter(f6, fArr, fArr2);
            float f18 = fArr[0];
            float f19 = fArr[1];
            float f20 = fArr2[0];
            float f21 = fArr2[1];
            double d6 = f18;
            double d7 = fSin;
            double d8 = fCos;
            fSin = (float) (((Math.sin(d8) * d7) + d6) - ((double) (f8 / 2.0f)));
            fCos = (float) ((((double) f19) - (Math.cos(d8) * d7)) - ((double) (f9 / 2.0f)));
            double d9 = f20;
            double d10 = f11;
            double dSin = (Math.sin(d8) * d10) + d9;
            double dCos = Math.cos(d8) * d7;
            double d11 = f12;
            float f22 = (float) ((dCos * d11) + dSin);
            float fSin2 = (float) ((Math.sin(d8) * d7 * d11) + (((double) f21) - (Math.cos(d8) * d10)));
            if (dArr2.length >= 2) {
                dArr2[0] = f22;
                dArr2[1] = fSin2;
            }
            if (!Float.isNaN(f17)) {
                motionWidget.setRotationZ((float) (Math.toDegrees(Math.atan2(fSin2, f22)) + ((double) f17)));
            }
        } else if (!Float.isNaN(f17)) {
            motionWidget.setRotationZ(((float) (Math.toDegrees(Math.atan2((f14 / 2.0f) + f12, (f13 / 2.0f) + f11)) + ((double) f17))) + 0.0f);
        }
        float f23 = fSin + 0.5f;
        float f24 = fCos + 0.5f;
        motionWidget.layout((int) f23, (int) f24, (int) (f23 + f8), (int) (f24 + f9));
    }

    public void setupRelative(Motion motion, MotionPaths motionPaths) {
        double d = (((this.mWidth / 2.0f) + this.mX) - motionPaths.mX) - (motionPaths.mWidth / 2.0f);
        double d6 = (((this.mHeight / 2.0f) + this.mY) - motionPaths.mY) - (motionPaths.mHeight / 2.0f);
        this.mRelativeToController = motion;
        this.mX = (float) Math.hypot(d6, d);
        if (Float.isNaN(this.mRelativeAngle)) {
            this.mY = (float) (Math.atan2(d6, d) + 1.5707963267948966d);
        } else {
            this.mY = (float) Math.toRadians(this.mRelativeAngle);
        }
    }

    @Override // java.lang.Comparable
    public int compareTo(MotionPaths motionPaths) {
        return Float.compare(this.mPosition, motionPaths.mPosition);
    }

    public MotionPaths(int i5, int i6, MotionKeyPosition motionKeyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        this.mDrawPath = 0;
        this.mPathRotate = Float.NaN;
        this.mProgress = Float.NaN;
        this.mPathMotionArc = -1;
        this.mAnimateRelativeTo = null;
        this.mRelativeAngle = Float.NaN;
        this.mRelativeToController = null;
        this.mCustomAttributes = new HashMap<>();
        this.mMode = 0;
        this.mTempValue = new double[18];
        this.mTempDelta = new double[18];
        if (motionPaths.mAnimateRelativeTo != null) {
            initPolar(i5, i6, motionKeyPosition, motionPaths, motionPaths2);
            return;
        }
        int i7 = motionKeyPosition.mPositionType;
        if (i7 == 1) {
            initPath(motionKeyPosition, motionPaths, motionPaths2);
        } else if (i7 != 2) {
            initCartesian(motionKeyPosition, motionPaths, motionPaths2);
        } else {
            initScreen(i5, i6, motionKeyPosition, motionPaths, motionPaths2);
        }
    }

    public void getCenter(double d, int[] iArr, double[] dArr, float[] fArr, double[] dArr2, float[] fArr2) {
        float f6;
        float fSin = this.mX;
        float fCos = this.mY;
        float f7 = this.mWidth;
        float f8 = this.mHeight;
        float f9 = 0.0f;
        float f10 = 0.0f;
        float f11 = 0.0f;
        float f12 = 0.0f;
        for (int i5 = 0; i5 < iArr.length; i5++) {
            float f13 = (float) dArr[i5];
            float f14 = (float) dArr2[i5];
            int i6 = iArr[i5];
            if (i6 == 1) {
                fSin = f13;
                f9 = f14;
            } else if (i6 == 2) {
                fCos = f13;
                f11 = f14;
            } else if (i6 == 3) {
                f7 = f13;
                f10 = f14;
            } else if (i6 == 4) {
                f8 = f13;
                f12 = f14;
            }
        }
        float f15 = (f10 / 2.0f) + f9;
        float fSin2 = (f12 / 2.0f) + f11;
        Motion motion = this.mRelativeToController;
        if (motion != null) {
            float[] fArr3 = new float[2];
            float[] fArr4 = new float[2];
            motion.getCenter(d, fArr3, fArr4);
            float f16 = fArr3[0];
            float f17 = fArr3[1];
            float f18 = fArr4[0];
            float f19 = fArr4[1];
            f6 = 2.0f;
            double d6 = fSin;
            double d7 = fCos;
            fSin = (float) (((Math.sin(d7) * d6) + ((double) f16)) - ((double) (f7 / 2.0f)));
            fCos = (float) ((((double) f17) - (Math.cos(d7) * d6)) - ((double) (f8 / 2.0f)));
            double d8 = f9;
            double dSin = (Math.sin(d7) * d8) + ((double) f18);
            double d9 = f11;
            float fCos2 = (float) ((Math.cos(d7) * d9) + dSin);
            fSin2 = (float) ((Math.sin(d7) * d9) + (((double) f19) - (Math.cos(d7) * d8)));
            f15 = fCos2;
        } else {
            f6 = 2.0f;
        }
        fArr[0] = (f7 / f6) + fSin + 0.0f;
        fArr[1] = (f8 / f6) + fCos + 0.0f;
        fArr2[0] = f15;
        fArr2[1] = fSin2;
    }
}
