package cn.bertsir.zbar.view;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import cn.bertsir.zbar.R;
import org.opencv.videoio.Videoio;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class ScanLineView extends View {
    private static final String TAG = "ScanView";
    public static final int style_gridding = 0;
    public static final int style_hybrid = 2;
    public static final int style_line = 3;
    public static final int style_radar = 1;
    private float animatedValue;
    private Path mBoundaryLinePath;
    private float mCornerLineLen;
    private Rect mFrame;
    private int mGriddingDensity;
    private float mGriddingLineWidth;
    private Path mGriddingPath;
    private LinearGradient mLinearGradient_Gridding;
    private LinearGradient mLinearGradient_Radar;
    private LinearGradient mLinearGradient_line;
    private int mScanAnimatorDuration;
    private Matrix mScanMatrix;
    private Paint mScanPaint_Gridding;
    private Paint mScanPaint_Line;
    private Paint mScanPaint_Radio;
    private int mScanStyle;
    private int mScancolor;
    private ValueAnimator mValueAnimator;

    public ScanLineView(Context context) {
        this(context, null);
    }

    private void init() {
        Paint paint = new Paint(1);
        this.mScanPaint_Gridding = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.mScanPaint_Gridding.setStrokeWidth(this.mGriddingLineWidth);
        Paint paint2 = new Paint(1);
        this.mScanPaint_Radio = paint2;
        Paint.Style style = Paint.Style.FILL;
        paint2.setStyle(style);
        this.mScancolor = getResources().getColor(R.color.common_color);
        Paint paint3 = new Paint();
        this.mScanPaint_Line = paint3;
        paint3.setStyle(style);
        this.mScanPaint_Line.setStrokeWidth(10.0f);
        this.mScanPaint_Line.setAntiAlias(true);
        Matrix matrix = new Matrix();
        this.mScanMatrix = matrix;
        matrix.setTranslate(0.0f, 30.0f);
    }

    private void initBoundaryAndAnimator() {
        if (this.mBoundaryLinePath == null) {
            Path path = new Path();
            this.mBoundaryLinePath = path;
            Rect rect = this.mFrame;
            path.moveTo(rect.left, rect.top + this.mCornerLineLen);
            Path path2 = this.mBoundaryLinePath;
            Rect rect2 = this.mFrame;
            path2.lineTo(rect2.left, rect2.top);
            Path path3 = this.mBoundaryLinePath;
            Rect rect3 = this.mFrame;
            path3.lineTo(rect3.left + this.mCornerLineLen, rect3.top);
            Path path4 = this.mBoundaryLinePath;
            Rect rect4 = this.mFrame;
            path4.moveTo(rect4.right - this.mCornerLineLen, rect4.top);
            Path path5 = this.mBoundaryLinePath;
            Rect rect5 = this.mFrame;
            path5.lineTo(rect5.right, rect5.top);
            Path path6 = this.mBoundaryLinePath;
            Rect rect6 = this.mFrame;
            path6.lineTo(rect6.right, rect6.top + this.mCornerLineLen);
            Path path7 = this.mBoundaryLinePath;
            Rect rect7 = this.mFrame;
            path7.moveTo(rect7.right, rect7.bottom - this.mCornerLineLen);
            Path path8 = this.mBoundaryLinePath;
            Rect rect8 = this.mFrame;
            path8.lineTo(rect8.right, rect8.bottom);
            Path path9 = this.mBoundaryLinePath;
            Rect rect9 = this.mFrame;
            path9.lineTo(rect9.right - this.mCornerLineLen, rect9.bottom);
            Path path10 = this.mBoundaryLinePath;
            Rect rect10 = this.mFrame;
            path10.moveTo(rect10.left + this.mCornerLineLen, rect10.bottom);
            Path path11 = this.mBoundaryLinePath;
            Rect rect11 = this.mFrame;
            path11.lineTo(rect11.left, rect11.bottom);
            Path path12 = this.mBoundaryLinePath;
            Rect rect12 = this.mFrame;
            path12.lineTo(rect12.left, rect12.bottom - this.mCornerLineLen);
        }
        if (this.mValueAnimator == null) {
            initScanValueAnim(this.mFrame.height());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initGriddingPathAndStyle() {
        if (this.mGriddingPath == null) {
            this.mGriddingPath = new Path();
            float fWidth = this.mFrame.width() / (this.mGriddingDensity + 0.0f);
            float fHeight = this.mFrame.height() / (this.mGriddingDensity + 0.0f);
            for (int i5 = 0; i5 <= this.mGriddingDensity; i5++) {
                Path path = this.mGriddingPath;
                Rect rect = this.mFrame;
                float f6 = i5 * fWidth;
                path.moveTo(rect.left + f6, rect.top);
                Path path2 = this.mGriddingPath;
                Rect rect2 = this.mFrame;
                path2.lineTo(rect2.left + f6, rect2.bottom);
            }
            for (int i6 = 0; i6 <= this.mGriddingDensity; i6++) {
                Path path3 = this.mGriddingPath;
                Rect rect3 = this.mFrame;
                float f7 = i6 * fHeight;
                path3.moveTo(rect3.left, rect3.top + f7);
                Path path4 = this.mGriddingPath;
                Rect rect4 = this.mFrame;
                path4.lineTo(rect4.right, rect4.top + f7);
            }
        }
        if (this.mLinearGradient_Gridding == null) {
            Rect rect5 = this.mFrame;
            LinearGradient linearGradient = new LinearGradient(0.0f, rect5.top, 0.0f, (rect5.height() * 0.01f) + rect5.bottom, new int[]{0, 0, this.mScancolor, 0}, new float[]{0.0f, 0.5f, 0.99f, 1.0f}, Shader.TileMode.CLAMP);
            this.mLinearGradient_Gridding = linearGradient;
            linearGradient.setLocalMatrix(this.mScanMatrix);
            this.mScanPaint_Gridding.setShader(this.mLinearGradient_Gridding);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initLineStyle() {
        if (this.mLinearGradient_line == null) {
            String strValueOf = String.valueOf(Integer.toHexString(this.mScancolor));
            String strSubstring = strValueOf.substring(strValueOf.length() - 6, strValueOf.length());
            LinearGradient linearGradient = new LinearGradient(0.0f, 0.0f, getMeasuredWidth(), 0.0f, new int[]{Color.parseColor("#00" + strSubstring), this.mScancolor, Color.parseColor("#00" + strSubstring)}, (float[]) null, Shader.TileMode.CLAMP);
            this.mLinearGradient_line = linearGradient;
            linearGradient.setLocalMatrix(this.mScanMatrix);
            this.mScanPaint_Line.setShader(this.mLinearGradient_line);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initRadarStyle() {
        if (this.mLinearGradient_Radar == null) {
            Rect rect = this.mFrame;
            LinearGradient linearGradient = new LinearGradient(0.0f, rect.top, 0.0f, (rect.height() * 0.01f) + rect.bottom, new int[]{0, 0, this.mScancolor, 0}, new float[]{0.0f, 0.85f, 0.99f, 1.0f}, Shader.TileMode.CLAMP);
            this.mLinearGradient_Radar = linearGradient;
            linearGradient.setLocalMatrix(this.mScanMatrix);
            this.mScanPaint_Radio.setShader(this.mLinearGradient_Radar);
        }
    }

    public void initScanValueAnim(int i5) {
        ValueAnimator valueAnimator = new ValueAnimator();
        this.mValueAnimator = valueAnimator;
        valueAnimator.setDuration(this.mScanAnimatorDuration);
        this.mValueAnimator.setFloatValues(-i5, 0.0f);
        this.mValueAnimator.setRepeatMode(1);
        this.mValueAnimator.setInterpolator(new DecelerateInterpolator());
        this.mValueAnimator.setRepeatCount(-1);
        this.mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: cn.bertsir.zbar.view.ScanLineView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                if (ScanLineView.this.mLinearGradient_Gridding == null) {
                    ScanLineView.this.initGriddingPathAndStyle();
                }
                if (ScanLineView.this.mLinearGradient_Radar == null) {
                    ScanLineView.this.initRadarStyle();
                }
                if (ScanLineView.this.mLinearGradient_line == null) {
                    ScanLineView.this.initLineStyle();
                }
                if (ScanLineView.this.mScanMatrix != null) {
                    ScanLineView.this.animatedValue = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                    ScanLineView.this.mScanMatrix.setTranslate(0.0f, ScanLineView.this.animatedValue);
                    ScanLineView.this.mLinearGradient_Gridding.setLocalMatrix(ScanLineView.this.mScanMatrix);
                    ScanLineView.this.mLinearGradient_Radar.setLocalMatrix(ScanLineView.this.mScanMatrix);
                    ScanLineView.this.mLinearGradient_line.setLocalMatrix(ScanLineView.this.mScanMatrix);
                    ScanLineView.this.invalidate();
                }
            }
        });
        this.mValueAnimator.start();
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        ValueAnimator valueAnimator = this.mValueAnimator;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.mValueAnimator.cancel();
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    @SuppressLint({"DrawAllocation"})
    public void onDraw(Canvas canvas) {
        if (this.mFrame == null || this.mBoundaryLinePath == null) {
            return;
        }
        int i5 = this.mScanStyle;
        if (i5 == 0) {
            initGriddingPathAndStyle();
            canvas.drawPath(this.mGriddingPath, this.mScanPaint_Gridding);
            return;
        }
        if (i5 == 1) {
            initRadarStyle();
            canvas.drawRect(this.mFrame, this.mScanPaint_Radio);
        } else if (i5 == 3) {
            initLineStyle();
            canvas.drawLine(0.0f, this.mFrame.height() - Math.abs(this.animatedValue), getMeasuredWidth(), this.mFrame.height() - Math.abs(this.animatedValue), this.mScanPaint_Line);
        } else {
            initGriddingPathAndStyle();
            initRadarStyle();
            canvas.drawPath(this.mGriddingPath, this.mScanPaint_Gridding);
            canvas.drawRect(this.mFrame, this.mScanPaint_Radio);
        }
    }

    @Override // android.view.View
    public void onLayout(boolean z6, int i5, int i6, int i7, int i8) {
        super.onLayout(z6, i5, i6, i7, i8);
        this.mFrame = new Rect(i5, i6, i7, i8);
        initBoundaryAndAnimator();
    }

    @Override // android.view.View
    public void onMeasure(int i5, int i6) {
        super.onMeasure(i5, i6);
    }

    public void setScanAnimatorDuration(int i5) {
        this.mScanAnimatorDuration = i5;
    }

    public void setScanGriddingStyle(float f6, int i5) {
        this.mGriddingLineWidth = f6;
        this.mGriddingDensity = i5;
    }

    public void setScanStyle(int i5) {
        this.mScanStyle = i5;
    }

    public void setScancolor(int i5) {
        this.mScancolor = i5;
    }

    public ScanLineView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScanLineView(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        this.mGriddingLineWidth = 2.0f;
        this.mGriddingDensity = 40;
        this.mCornerLineLen = 50.0f;
        this.mScanAnimatorDuration = Videoio.CAP_GSTREAMER;
        this.mScanStyle = 0;
        init();
    }
}
