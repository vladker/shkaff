package com.appdev.standard.page.printerlabel.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class PrinterDottedLineView extends View {
    private int height;
    private Paint mPaint;
    private float screenHeight;
    private float screenWidth;
    private int startX;
    private int startY;
    private int width;
    private int windowX;
    private int windowY;

    /* JADX INFO: renamed from: x1, reason: collision with root package name */
    private int f2810x1;

    /* JADX INFO: renamed from: y1, reason: collision with root package name */
    private int f2811y1;

    public PrinterDottedLineView(Context context) {
        this(context, null);
    }

    private void init() {
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setColor(getContext().getColor(p113u.a.color_FFAE00));
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStrokeWidth(3.0f);
        this.mPaint.setPathEffect(new DashPathEffect(new float[]{10.0f, 10.0f}, 0.0f));
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        this.screenWidth = displayMetrics.widthPixels;
        this.screenHeight = displayMetrics.heightPixels;
    }

    public void hidden() {
        setVisibility(8);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int i5 = this.f2810x1;
        int i6 = this.windowX;
        int i7 = this.f2811y1;
        canvas.drawLine(i5 - i6, i7, (i5 - i6) + this.screenWidth, i7, this.mPaint);
        int i8 = this.f2810x1;
        int i9 = this.windowX;
        int i10 = this.f2811y1;
        int i11 = this.height;
        canvas.drawLine(i8 - i9, i10 + i11, (i8 - i9) + this.screenWidth, i10 + i11, this.mPaint);
        int i12 = this.f2810x1;
        int i13 = this.f2811y1;
        int i14 = this.windowY;
        canvas.drawLine(i12, i13 - i14, i12, (i13 - i14) + this.screenHeight, this.mPaint);
        int i15 = this.f2810x1;
        int i16 = this.width;
        int i17 = this.f2811y1;
        int i18 = this.windowY;
        canvas.drawLine(i15 + i16, i17 - i18, i15 + i16, (i17 - i18) + this.screenHeight, this.mPaint);
    }

    public void setStart(int i5, int i6) {
        this.startX = i5;
        this.startY = i6;
    }

    public void show(BaseControlView baseControlView) {
        this.f2810x1 = baseControlView.getViewLocation().x;
        this.f2811y1 = baseControlView.getViewLocation().y;
        this.width = baseControlView.getViewWidth();
        this.height = baseControlView.getViewHeight();
        int[] iArr = new int[2];
        baseControlView.getLocationInWindow(iArr);
        this.windowX = iArr[0];
        this.windowY = iArr[1];
        p051j0.a.k("PrinterDottedLineView", "screenWidth: " + this.screenWidth + " screenHeight: " + this.screenHeight + " windowX: " + this.windowX + " windowY: " + this.windowY);
        postInvalidate();
        setVisibility(0);
    }

    public PrinterDottedLineView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PrinterDottedLineView(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        this.startY = 0;
        this.f2810x1 = 0;
        this.f2811y1 = 0;
        this.width = 0;
        this.height = 0;
        this.screenWidth = 0.0f;
        this.screenHeight = 0.0f;
        this.windowX = 0;
        this.windowY = 0;
        init();
    }
}
