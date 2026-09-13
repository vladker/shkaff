package cn.bertsir.zbar.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.SeekBar;
import cn.bertsir.zbar.R;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class VerticalSeekBar extends SeekBar {
    public static final int ROTATION_ANGLE_CW_270 = 270;
    public static final int ROTATION_ANGLE_CW_90 = 90;
    private static final String TAG = "VerticalSeekBar";
    private int mRotationAngle;

    public VerticalSeekBar(Context context) {
        super(context);
        this.mRotationAngle = 90;
        initialize(context, null, 0, 0);
    }

    private void initialize(Context context, AttributeSet attributeSet, int i5, int i6) {
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.VerticalSeekBar, i5, i6);
            int integer = typedArrayObtainStyledAttributes.getInteger(R.styleable.VerticalSeekBar_seekBarRotation, 0);
            if (isValidRotationAngle(integer)) {
                this.mRotationAngle = integer;
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    private static boolean isValidRotationAngle(int i5) {
        return i5 == 90 || i5 == 270;
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public void onDraw(Canvas canvas) {
        int i5 = this.mRotationAngle;
        if (i5 == 270) {
            canvas.rotate(270.0f);
            canvas.translate(-getHeight(), 0.0f);
        } else if (i5 == 90) {
            canvas.rotate(90.0f);
            canvas.translate(0.0f, -getWidth());
        }
        super.onDraw(canvas);
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public synchronized void onMeasure(int i5, int i6) {
        super.onMeasure(i6, i5);
        setMeasuredDimension(getMeasuredHeight(), getMeasuredWidth());
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public void onSizeChanged(int i5, int i6, int i7, int i8) {
        super.onSizeChanged(i6, i5, i8, i7);
    }

    @Override // android.widget.AbsSeekBar, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 0 || action == 1 || action == 2) {
            int i5 = this.mRotationAngle;
            if (i5 == 270) {
                setProgress(getMax() - ((int) ((motionEvent.getY() * getMax()) / getHeight())));
            } else if (i5 == 90) {
                setProgress((int) ((motionEvent.getY() * getMax()) / getHeight()));
            }
            onSizeChanged(getWidth(), getHeight(), 0, 0);
        }
        return true;
    }

    public VerticalSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRotationAngle = 90;
        initialize(context, attributeSet, 0, 0);
    }

    public VerticalSeekBar(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        this.mRotationAngle = 90;
        initialize(context, attributeSet, i5, 0);
    }
}
