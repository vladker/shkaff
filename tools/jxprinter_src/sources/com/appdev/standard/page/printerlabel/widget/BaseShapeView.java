package com.appdev.standard.page.printerlabel.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.ViewCompat;
import p134x2.C1849c;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class BaseShapeView extends View {
    private int colorType;
    private boolean isFill;
    private int itemSubType;
    private float lineSize;
    private int lineStyleIndex;
    private Paint paint;
    private int rectCorner;

    public BaseShapeView(Context context) {
        this(context, null);
    }

    private void updateColors() {
        this.paint.setColor(this.colorType == 1 ? SupportMenu.CATEGORY_MASK : ViewCompat.MEASURED_STATE_MASK);
    }

    public int getColorType() {
        return this.colorType;
    }

    public int getItemSubType() {
        return this.itemSubType;
    }

    public float getLineBoldSize() {
        return this.lineSize;
    }

    public int getLineStyleIndex() {
        return this.lineStyleIndex;
    }

    public int getRectCorner() {
        return this.rectCorner;
    }

    public boolean isFill() {
        return this.isFill;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float strokeWidth = this.paint.getStrokeWidth() / 2.0f;
        int i5 = this.itemSubType;
        if (i5 == 5) {
            canvas.drawRoundRect(strokeWidth, strokeWidth, getWidth() - strokeWidth, getHeight() - strokeWidth, p035f5.b.d(this.rectCorner), p035f5.b.d(this.rectCorner), this.paint);
            if (this.isFill) {
                this.paint.setStyle(Paint.Style.FILL);
                int i6 = this.lineStyleIndex;
                if (i6 == 1) {
                    this.paint.setPathEffect(null);
                } else if (i6 == 2) {
                    this.paint.setPathEffect(new DashPathEffect(new float[]{40.0f, 10.0f}, 0.0f));
                } else if (i6 == 3) {
                    this.paint.setPathEffect(new DashPathEffect(new float[]{70.0f, 10.0f, 20.0f, 10.0f}, 0.0f));
                } else if (i6 == 4) {
                    this.paint.setPathEffect(new DashPathEffect(new float[]{10.0f, 10.0f}, 0.0f));
                }
                this.paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER));
                float f6 = strokeWidth * 2.0f;
                canvas.drawRoundRect(f6, f6, getWidth() - f6, getHeight() - f6, p035f5.b.d(this.rectCorner), p035f5.b.d(this.rectCorner), this.paint);
                return;
            }
            return;
        }
        if (i5 != 7) {
            if (i5 == 6) {
                int width = getWidth() / 2;
                int height = getHeight() / 2;
                int i7 = (int) strokeWidth;
                int i8 = (width > height ? height : width) - i7;
                float f7 = width;
                float f8 = height;
                canvas.drawCircle(f7, f8, i8, this.paint);
                if (this.isFill) {
                    this.paint.setStyle(Paint.Style.FILL);
                    int i9 = this.lineStyleIndex;
                    if (i9 == 1) {
                        this.paint.setPathEffect(null);
                    } else if (i9 == 2) {
                        this.paint.setPathEffect(new DashPathEffect(new float[]{40.0f, 10.0f}, 0.0f));
                    } else if (i9 == 3) {
                        this.paint.setPathEffect(new DashPathEffect(new float[]{70.0f, 10.0f, 20.0f, 10.0f}, 0.0f));
                    } else if (i9 == 4) {
                        this.paint.setPathEffect(new DashPathEffect(new float[]{10.0f, 10.0f}, 0.0f));
                    }
                    this.paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER));
                    canvas.drawCircle(f7, f8, i8 - i7, this.paint);
                    return;
                }
                return;
            }
            return;
        }
        Path path = new Path();
        float f9 = strokeWidth * 2.0f;
        path.moveTo(getWidth() / 2, f9);
        float f10 = f9 + 0.0f;
        path.lineTo(f10, getHeight() - strokeWidth);
        path.lineTo(getWidth() - f9, getHeight() - strokeWidth);
        path.close();
        canvas.drawPath(path, this.paint);
        if (this.isFill) {
            this.paint.setStyle(Paint.Style.FILL);
            int i10 = this.lineStyleIndex;
            if (i10 == 1) {
                this.paint.setPathEffect(null);
            } else if (i10 == 2) {
                this.paint.setPathEffect(new DashPathEffect(new float[]{40.0f, 10.0f}, 0.0f));
            } else if (i10 == 3) {
                this.paint.setPathEffect(new DashPathEffect(new float[]{70.0f, 10.0f, 20.0f, 10.0f}, 0.0f));
            } else if (i10 == 4) {
                this.paint.setPathEffect(new DashPathEffect(new float[]{10.0f, 10.0f}, 0.0f));
            }
            this.paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER));
            Path path2 = new Path();
            path2.moveTo(getWidth() / 2, strokeWidth);
            path2.lineTo(f10, getHeight() - f9);
            path2.lineTo(getWidth() - f9, getHeight() - f9);
            path2.close();
            canvas.drawPath(path2, this.paint);
        }
    }

    public void setColorType(int i5) {
        if (this.colorType != i5) {
            this.colorType = i5;
            updateColors();
            invalidate();
        }
    }

    public void setFill(boolean z6) {
        this.isFill = z6;
        updatePaint();
    }

    public void setItemSubType(int i5) {
        this.itemSubType = i5;
        updatePaint();
    }

    public void setLineBoldSize(float f6) {
        this.lineSize = f6;
        updatePaint();
    }

    public void setLineStyleIndex(int i5) {
        this.lineStyleIndex = i5;
        updatePaint();
    }

    public void setRectCorner(int i5) {
        this.rectCorner = i5;
        updatePaint();
    }

    public void updatePaint() {
        this.paint.setStrokeWidth(C1849c.mm2pxWithScale(this.lineSize));
        if (this.isFill) {
            this.paint.setStyle(Paint.Style.FILL_AND_STROKE);
        } else {
            this.paint.setStyle(Paint.Style.STROKE);
        }
        int i5 = this.lineStyleIndex;
        if (i5 == 1) {
            this.paint.setPathEffect(null);
        } else if (i5 == 2) {
            this.paint.setPathEffect(new DashPathEffect(new float[]{40.0f, 10.0f}, 0.0f));
        } else if (i5 == 3) {
            this.paint.setPathEffect(new DashPathEffect(new float[]{70.0f, 10.0f, 20.0f, 10.0f}, 0.0f));
        } else if (i5 == 4) {
            this.paint.setPathEffect(new DashPathEffect(new float[]{10.0f, 10.0f}, 0.0f));
        }
        invalidate();
    }

    public BaseShapeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BaseShapeView(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        this.itemSubType = 5;
        this.isFill = false;
        this.lineStyleIndex = 1;
        this.lineSize = 0.5f;
        this.rectCorner = 0;
        this.colorType = 0;
        Paint paint = new Paint();
        this.paint = paint;
        paint.setColor(ViewCompat.MEASURED_STATE_MASK);
        updatePaint();
    }
}
