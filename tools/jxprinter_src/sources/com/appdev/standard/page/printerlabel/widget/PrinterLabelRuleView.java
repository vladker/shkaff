package com.appdev.standard.page.printerlabel.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import android.widget.RelativeLayout;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class PrinterLabelRuleView extends View {
    public static final int RULE_LANDSCAPE = 1;
    public static final int RULE_LONGITUDINAL = 2;
    private Paint paint;
    private float ruleStart;
    private int ruleType;
    private float ruleUnit;
    private int startMargin;
    private Paint textPaint;

    public PrinterLabelRuleView(Context context, int i5, int i6, int i7, int i8, float f6, int i9, int i10) {
        super(context);
        this.paint = null;
        this.textPaint = null;
        this.ruleUnit = 0.0f;
        this.ruleStart = 0.0f;
        this.ruleType = 1;
        this.startMargin = 0;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i7, i8);
        layoutParams.leftMargin = i5;
        layoutParams.topMargin = i6;
        setLayoutParams(layoutParams);
        Paint paint = new Paint();
        this.paint = paint;
        Resources resources = getResources();
        int i11 = p113u.a.color_999999;
        paint.setColor(resources.getColor(i11));
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeWidth(3.0f);
        Paint paint2 = new Paint();
        this.textPaint = paint2;
        paint2.setColor(getResources().getColor(i11));
        this.textPaint.setTextSize(30.0f);
        this.textPaint.setAntiAlias(true);
        this.textPaint.setTextAlign(Paint.Align.LEFT);
        this.ruleStart = f6;
        this.ruleUnit = i9;
        this.ruleType = i10;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int i5;
        float width;
        float width2;
        float width3;
        float height;
        float height2;
        float height3;
        int i6;
        super.onDraw(canvas);
        canvas.clipRect(0, 0, getWidth(), getHeight());
        canvas.drawColor(getResources().getColor(p113u.a.color_EEEEEE));
        float f6 = getResources().getDisplayMetrics().densityDpi / 25.4f;
        float f7 = this.ruleUnit;
        if (f7 / f6 < 0.5d) {
            if (f7 / f6 > 0.4d) {
                i6 = 5;
            } else if (f7 / f6 > 0.4d || f7 / f6 <= 0.3d) {
                int i7 = 20;
                while ((this.ruleUnit * i7) / f6 < 3.0f) {
                    i7 += 10;
                }
                i5 = i7;
            } else {
                i6 = 10;
            }
            i5 = i6;
        } else {
            i5 = 1;
        }
        int i8 = this.ruleType;
        if (i8 == 1) {
            int iCeil = (int) Math.ceil(this.ruleStart);
            int i9 = iCeil;
            float f8 = ((iCeil - this.ruleStart) * this.ruleUnit) + this.startMargin;
            while (f8 < getWidth()) {
                if (i9 % i5 == 0) {
                    if (i9 % 10 == 0) {
                        height3 = getHeight() / 2;
                        canvas.drawText(String.valueOf(i9), f8 - (this.textPaint.measureText(String.valueOf(i9)) / 2.0f), height3 - 2.0f, this.textPaint);
                    } else {
                        if (i9 % 5 == 0) {
                            height = getHeight() / 2;
                            height2 = (getHeight() / 2) * 0.33333334f;
                        } else {
                            height = getHeight() / 2;
                            height2 = (getHeight() / 2) * 0.6666667f;
                        }
                        height3 = height + height2;
                    }
                    canvas.drawLine(f8, height3, f8, getHeight(), this.paint);
                }
                f8 += this.ruleUnit;
                i9++;
            }
            return;
        }
        if (i8 == 2) {
            int iCeil2 = (int) Math.ceil(this.ruleStart);
            float f9 = ((iCeil2 - this.ruleStart) * this.ruleUnit) + this.startMargin;
            int i10 = iCeil2;
            while (f9 < getHeight()) {
                if (i10 % i5 == 0) {
                    if (i10 % 10 == 0) {
                        width3 = getWidth() / 2;
                        Paint.FontMetrics fontMetrics = this.textPaint.getFontMetrics();
                        float f10 = fontMetrics.bottom - fontMetrics.top;
                        canvas.rotate(90.0f);
                        canvas.drawText(String.valueOf(i10), f9 - (f10 / 2.0f), 0.0f, this.textPaint);
                        canvas.rotate(-90.0f);
                    } else {
                        if (i10 % 5 == 0) {
                            width = getWidth() / 2;
                            width2 = (getWidth() / 2) * 0.33333334f;
                        } else {
                            width = getWidth() / 2;
                            width2 = (getWidth() / 2) * 0.6666667f;
                        }
                        width3 = width + width2;
                    }
                    canvas.drawLine(width3, f9, getWidth(), f9, this.paint);
                }
                f9 += this.ruleUnit;
                i10++;
            }
        }
    }

    public void setStartMargin(int i5) {
        this.startMargin = i5;
    }

    public void updateRule(float f6, float f7) {
        this.ruleStart = f6;
        this.ruleUnit = f7;
        invalidate();
    }
}
