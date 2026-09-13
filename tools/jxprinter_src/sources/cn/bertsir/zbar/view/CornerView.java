package cn.bertsir.zbar.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import cn.bertsir.zbar.R;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class CornerView extends View {
    private static final int LEFT_BOTTOM = 1;
    private static final int LEFT_TOP = 0;
    private static final int RIGHT_BOTTOM = 3;
    private static final int RIGHT_TOP = 2;
    private static final String TAG = "CornerView";
    private Canvas canvas;
    private int cornerColor;
    private int cornerGravity;
    private int cornerWidth;
    private int height;
    private Paint paint;
    private int width;

    public CornerView(Context context) {
        super(context, null);
        this.width = 0;
        this.height = 0;
    }

    public int dip2px(int i5) {
        return (int) (((double) (i5 * getContext().getResources().getDisplayMetrics().density)) + 0.5d);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int i5 = this.cornerGravity;
        if (i5 == 0) {
            canvas.drawLine(0.0f, 0.0f, this.width, 0.0f, this.paint);
            canvas.drawLine(0.0f, 0.0f, 0.0f, this.height, this.paint);
            return;
        }
        if (i5 == 1) {
            canvas.drawLine(0.0f, 0.0f, 0.0f, this.height, this.paint);
            int i6 = this.height;
            canvas.drawLine(0.0f, i6, this.width, i6, this.paint);
        } else if (i5 == 2) {
            canvas.drawLine(0.0f, 0.0f, this.width, 0.0f, this.paint);
            int i7 = this.width;
            canvas.drawLine(i7, 0.0f, i7, this.height, this.paint);
        } else {
            if (i5 != 3) {
                return;
            }
            int i8 = this.width;
            canvas.drawLine(i8, 0.0f, i8, this.height, this.paint);
            int i9 = this.height;
            canvas.drawLine(0.0f, i9, this.width, i9, this.paint);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i5, int i6) {
        super.onMeasure(i5, i6);
        this.width = getMeasuredWidth();
        this.height = getMeasuredHeight();
    }

    public void setColor(int i5) {
        this.cornerColor = i5;
        this.paint.setColor(i5);
        invalidate();
    }

    public void setLineWidth(int i5) {
        int iDip2px = dip2px(i5);
        this.cornerWidth = iDip2px;
        this.paint.setStrokeWidth(iDip2px);
        invalidate();
    }

    public CornerView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.width = 0;
        this.height = 0;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CornerView);
        this.cornerColor = typedArrayObtainStyledAttributes.getColor(R.styleable.CornerView_corner_color, getResources().getColor(R.color.common_color));
        this.cornerWidth = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.CornerView_corner_width, 10.0f);
        this.cornerGravity = typedArrayObtainStyledAttributes.getInt(R.styleable.CornerView_corner_gravity, 1);
        typedArrayObtainStyledAttributes.recycle();
        this.paint = new Paint();
        this.canvas = new Canvas();
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setStrokeWidth(this.cornerWidth);
        this.paint.setColor(this.cornerColor);
        this.paint.setAntiAlias(true);
    }
}
