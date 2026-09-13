package com.appdev.standard.page.printerlabel.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.ViewCompat;
import p134x2.C1849c;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class BaseLineView extends View {
    private int colorType;
    private float lineSize;
    private int lineStyleIndex;
    private Paint paint;
    private Path path;

    public BaseLineView(Context context) {
        this(context, null);
    }

    private void updateColors() {
        this.paint.setColor(this.colorType == 1 ? SupportMenu.CATEGORY_MASK : ViewCompat.MEASURED_STATE_MASK);
    }

    public int getColorType() {
        return this.colorType;
    }

    public float getLineSize() {
        return this.lineSize;
    }

    public int getLineStyleIndex() {
        return this.lineStyleIndex;
    }

    public int getLineViewHeight() {
        return C1849c.mm2pxWithScale(this.lineSize + 2.0f);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int iMm2pxWithScale = C1849c.mm2pxWithScale(this.lineSize) / 2;
        this.paint.setStrokeWidth(C1849c.mm2pxWithScale(this.lineSize));
        this.path.reset();
        this.path.moveTo(0.0f, C1849c.mm2pxWithScale(1.0f) + iMm2pxWithScale);
        this.path.lineTo(getWidth(), C1849c.mm2pxWithScale(1.0f) + iMm2pxWithScale);
        int i5 = this.lineStyleIndex;
        if (i5 == 1) {
            this.paint.setPathEffect(null);
        } else if (i5 == 2) {
            this.paint.setPathEffect(new DashPathEffect(new float[]{20.0f, 20.0f}, 0.0f));
        } else if (i5 == 3) {
            this.paint.setPathEffect(new DashPathEffect(new float[]{70.0f, 10.0f, 20.0f, 10.0f}, 0.0f));
        } else if (i5 == 4) {
            this.paint.setPathEffect(new DashPathEffect(new float[]{10.0f, 10.0f}, 0.0f));
        }
        canvas.drawPath(this.path, this.paint);
    }

    @Override // android.view.View
    public void onMeasure(int i5, int i6) {
        setMeasuredDimension(i5, C1849c.mm2pxWithScale(this.lineSize + 2.0f));
    }

    public void setColorType(int i5) {
        if (this.colorType != i5) {
            this.colorType = i5;
            updateColors();
            invalidate();
        }
    }

    public void setLineSize(float f6) {
        this.lineSize = f6;
        updatePaint();
    }

    public void setLineStyleIndex(int i5) {
        this.lineStyleIndex = i5;
        updatePaint();
    }

    public void updatePaint() {
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeWidth(C1849c.mm2pxWithScale(this.lineSize));
        requestLayout();
        invalidate();
    }

    public BaseLineView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BaseLineView(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        this.colorType = 0;
        this.lineStyleIndex = 1;
        this.lineSize = 0.5f;
        Paint paint = new Paint(1);
        this.paint = paint;
        paint.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.path = new Path();
        updatePaint();
    }
}
