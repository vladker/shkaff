package com.appdev.standard.page.printerlabel.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import java.math.BigDecimal;
import java.math.RoundingMode;
import p113u.f;
import p113u.i;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class LineProgressWidget extends View {
    private Bitmap addBitmap;
    private float bigValue;
    private Bitmap bitmapBig;
    private int bitmapHeight;
    private Paint bitmapPaint;
    private int bitmapWidth;
    private float defaultValue;
    private String format;
    private int imageAddSubtractSize;
    private int imageHeight;
    private int imageWidth;
    private int inColorEnd;
    private int inColorStart;
    private boolean isDisplayValue;
    private boolean isInit;
    private boolean isUpperMoving;
    private int lineEnd;
    private int lineLength;
    private Paint linePaint;
    private int lineStart;
    private int lineWidth;
    private int lineY;
    private OnProgressChangeListener listener;
    private int max;
    private OnRangeListener onRangeListener;
    private OnRangeUpListener onRangeUpListener;
    private int outColorEnd;
    private int outColorStart;
    private int paddingBottom;
    private int paddingLeft;
    private int paddingRight;
    private int paddingTop;
    private int rangeLength;
    private boolean showRange;
    private int slideX;
    private float smallValue;
    private float stepSize;
    private Bitmap subtractBitmap;
    private int textColor;
    private float textHeight;
    private Paint textPaint;
    private int textSize;
    private int textToImg;
    private String unit;
    private boolean valueInside;
    private int verticalOffset;
    private boolean whetherIntegerType;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public interface OnProgressChangeListener {
        void onProgressChanged(float f6);
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public interface OnRangeListener {
        void onRange(float f6);
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public interface OnRangeUpListener {
        void onRangeUp(float f6);
    }

    public LineProgressWidget(Context context) {
        this(context, null);
    }

    private float computeRange(float f6) {
        if (this.whetherIntegerType) {
            float f7 = f6 - this.lineStart;
            float f8 = this.bigValue;
            float f9 = this.smallValue;
            return new BigDecimal((((f8 - f9) * f7) / this.lineLength) + f9).setScale(0, 4).floatValue();
        }
        float f10 = f6 - this.lineStart;
        float f11 = this.bigValue;
        float f12 = this.smallValue;
        return new BigDecimal((((f11 - f12) * f10) / this.lineLength) + f12).setScale(1, 4).floatValue();
    }

    private float computeSlide(float f6) {
        float f7 = this.smallValue;
        return (((f6 - f7) * this.lineLength) / (this.bigValue - f7)) + this.lineStart;
    }

    private int getMyMeasureHeight(int i5) {
        float f6;
        float fMax;
        int mode = View.MeasureSpec.getMode(i5);
        int size = View.MeasureSpec.getSize(i5);
        if (mode != 1073741824) {
            int i6 = this.textToImg;
            if (i6 >= 0) {
                int i7 = this.paddingBottom + this.paddingTop;
                int i8 = this.bitmapHeight;
                int i9 = this.imageAddSubtractSize;
                if (i8 <= i9) {
                    i8 = i9;
                }
                f6 = i7 + i8 + this.textHeight + 5.0f + i6;
            } else {
                int i10 = this.paddingBottom + this.paddingTop;
                int i11 = this.bitmapHeight;
                int i12 = this.imageAddSubtractSize;
                if (i11 <= i12) {
                    i11 = i12;
                }
                f6 = (((i10 + i11) + this.textHeight) + 5.0f) - i6;
            }
            return Math.min(size, (int) f6);
        }
        int i13 = this.textToImg;
        if (i13 >= 0) {
            float f7 = size;
            int i14 = this.paddingBottom + this.paddingTop;
            int i15 = this.bitmapHeight;
            int i16 = this.imageAddSubtractSize;
            if (i15 <= i16) {
                i15 = i16;
            }
            fMax = Math.max(f7, i14 + i15 + this.textHeight + 5.0f + i13);
        } else {
            float f8 = size;
            int i17 = this.paddingBottom + this.paddingTop;
            int i18 = this.bitmapHeight;
            int i19 = this.imageAddSubtractSize;
            if (i18 <= i19) {
                i18 = i19;
            }
            fMax = Math.max(f8, (((i17 + i18) + this.textHeight) + 5.0f) - i13);
        }
        return (int) fMax;
    }

    private int getMyMeasureWidth(int i5) {
        int iMin;
        int mode = View.MeasureSpec.getMode(i5);
        int size = View.MeasureSpec.getSize(i5);
        if (mode == 1073741824) {
            iMin = Math.max(size, (this.imageAddSubtractSize * 2) + this.paddingLeft + this.paddingRight + this.lineWidth + this.bitmapWidth + 40);
        } else {
            iMin = Math.min(size, (this.imageAddSubtractSize * 2) + this.paddingLeft + this.paddingRight + this.lineWidth + this.bitmapWidth + 40);
        }
        int i6 = this.paddingLeft;
        int i7 = (iMin - i6) - this.paddingRight;
        int i8 = this.bitmapWidth;
        int i9 = this.imageAddSubtractSize;
        int i10 = ((i7 - i8) - (i9 * 2)) - 40;
        this.lineLength = i10;
        boolean z6 = this.showRange;
        if (z6) {
            this.lineLength = i10 - (this.rangeLength * 2);
        }
        int i11 = (i8 / 2) + i6 + i9 + 5;
        this.lineStart = i11;
        if (z6) {
            this.lineStart = this.rangeLength + 20 + i11;
        }
        int i12 = (i8 / 2) + this.lineLength + i6 + i9 + 5;
        this.lineEnd = i12;
        if (z6) {
            this.lineEnd = this.rangeLength + 20 + i12;
        }
        if (!this.isInit) {
            this.slideX = (int) computeSlide(this.defaultValue);
            this.isInit = true;
        }
        return iMin;
    }

    private void init() {
        if (this.bitmapBig == null) {
            this.bitmapBig = BitmapFactory.decodeResource(getResources(), f.ic_progress_button);
        }
        this.bitmapHeight = this.bitmapBig.getHeight();
        int width = this.bitmapBig.getWidth();
        this.bitmapWidth = width;
        float f6 = this.imageWidth / width;
        float f7 = this.imageHeight / this.bitmapHeight;
        Matrix matrix = new Matrix();
        matrix.postScale(f6, f7);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(this.bitmapBig, 0, 0, this.bitmapWidth, this.bitmapHeight, matrix, true);
        this.bitmapBig = bitmapCreateBitmap;
        this.bitmapHeight = bitmapCreateBitmap.getHeight();
        this.bitmapWidth = this.bitmapBig.getWidth();
        Bitmap bitmap = this.subtractBitmap;
        if (bitmap == null || this.addBitmap == null) {
            this.imageAddSubtractSize = 0;
        } else {
            float width2 = this.imageAddSubtractSize / bitmap.getWidth();
            Matrix matrix2 = new Matrix();
            matrix2.postScale(width2, this.imageAddSubtractSize / this.subtractBitmap.getWidth());
            Bitmap bitmap2 = this.subtractBitmap;
            this.subtractBitmap = Bitmap.createBitmap(bitmap2, 0, 0, bitmap2.getWidth(), this.subtractBitmap.getHeight(), matrix2, true);
            Bitmap bitmap3 = this.addBitmap;
            this.addBitmap = Bitmap.createBitmap(bitmap3, 0, 0, bitmap3.getWidth(), this.addBitmap.getHeight(), matrix2, true);
            this.imageAddSubtractSize = this.subtractBitmap.getWidth();
        }
        this.paddingLeft = getPaddingLeft();
        this.paddingRight = getPaddingRight();
        this.paddingTop = getPaddingTop();
        this.paddingBottom = getPaddingBottom();
        if (this.textPaint == null) {
            this.textPaint = new Paint();
        }
        this.textPaint.setColor(this.textColor);
        this.textPaint.setTextSize(this.textSize);
        this.textPaint.setAntiAlias(true);
        this.textPaint.setTextAlign(Paint.Align.CENTER);
        Paint.FontMetrics fontMetrics = this.textPaint.getFontMetrics();
        this.textHeight = fontMetrics.bottom - fontMetrics.top;
        Paint paint = new Paint();
        this.linePaint = paint;
        paint.setAntiAlias(true);
        this.linePaint.setStrokeWidth(this.lineWidth);
        this.linePaint.setStrokeCap(Paint.Cap.ROUND);
    }

    private void initListener() {
        OnRangeListener onRangeListener = this.onRangeListener;
        if (onRangeListener != null) {
            onRangeListener.onRange(this.defaultValue);
        }
    }

    public int dip2px(Context context, float f6) {
        return (int) ((f6 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Canvas canvas2;
        Bitmap bitmap;
        Bitmap bitmap2;
        super.onDraw(canvas);
        int i5 = this.textToImg;
        if (i5 >= 0) {
            int i6 = this.paddingTop;
            int i7 = this.bitmapHeight;
            int i8 = i7 / 2;
            int i9 = this.imageAddSubtractSize;
            this.lineY = i6 + (i8 > i9 / 2 ? i7 / 2 : i9 / 2) + this.verticalOffset;
        } else {
            int i10 = this.paddingTop;
            int i11 = this.bitmapHeight;
            int i12 = i11 / 2;
            int i13 = this.imageAddSubtractSize;
            this.lineY = ((i10 + (i12 > i13 / 2 ? i11 / 2 : i13 / 2)) - i5) + ((int) this.textHeight) + 5 + this.verticalOffset;
        }
        float f6 = this.lineStart;
        int i14 = this.lineY;
        int i15 = this.outColorStart;
        int i16 = this.outColorEnd;
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        this.linePaint.setShader(new LinearGradient(f6, i14, this.lineEnd, i14, i15, i16, tileMode));
        float f7 = this.lineStart;
        int i17 = this.lineY;
        canvas.drawLine(f7, i17, this.lineEnd, i17, this.linePaint);
        if (this.inColorStart == 0 || this.inColorEnd == 0) {
            canvas2 = canvas;
        } else {
            float f8 = this.lineStart;
            int i18 = this.lineY;
            this.linePaint.setShader(new LinearGradient(f8, i18, this.slideX, i18, this.inColorStart, this.inColorEnd, tileMode));
            float f9 = this.lineStart;
            int i19 = this.lineY;
            canvas2 = canvas;
            canvas2.drawLine(f9, i19, this.slideX, i19, this.linePaint);
        }
        if (this.bitmapPaint == null) {
            this.bitmapPaint = new Paint();
        }
        int i20 = this.imageAddSubtractSize;
        if (i20 != 0 && (bitmap2 = this.subtractBitmap) != null) {
            canvas2.drawBitmap(bitmap2, 0.0f, this.lineY - (i20 / 2), this.bitmapPaint);
        }
        int i21 = this.imageAddSubtractSize;
        if (i21 != 0 && (bitmap = this.addBitmap) != null) {
            if (this.showRange) {
                canvas2.drawBitmap(bitmap, (this.bitmapWidth / 2) + this.lineEnd + 20 + this.rangeLength + 20, this.lineY - (i21 / 2), this.bitmapPaint);
            } else {
                canvas2.drawBitmap(bitmap, (this.bitmapWidth / 2) + this.lineEnd + 5, this.lineY - (i21 / 2), this.bitmapPaint);
            }
        }
        canvas2.drawBitmap(this.bitmapBig, this.slideX - (this.bitmapWidth / 2), this.lineY - (this.bitmapHeight / 2), this.bitmapPaint);
        if (this.showRange) {
            Paint.FontMetrics fontMetrics = this.textPaint.getFontMetrics();
            float f10 = fontMetrics.bottom;
            float f11 = ((f10 - fontMetrics.top) / 2.0f) - f10;
            canvas2.drawText(String.format(this.format, Float.valueOf(this.smallValue)), (this.lineStart - this.rangeLength) - 20, this.lineY + f11, this.textPaint);
            canvas2.drawText(String.format(this.format, Float.valueOf(this.bigValue)), (this.bitmapWidth / 2) + this.lineEnd + 20, this.lineY + f11, this.textPaint);
        }
        if (this.isDisplayValue) {
            String str = String.format(this.format, Float.valueOf(this.defaultValue)) + this.unit;
            if (this.valueInside) {
                Paint.FontMetrics fontMetrics2 = this.textPaint.getFontMetrics();
                float f12 = fontMetrics2.descent - fontMetrics2.ascent;
                Rect rect = new Rect();
                this.textPaint.getTextBounds(str, 0, str.length(), rect);
                canvas2.drawText(str, (this.slideX - (rect.width() / 2.0f)) + 20.0f, ((f12 / 2.0f) + this.lineY) - (fontMetrics2.descent - fontMetrics2.leading), this.textPaint);
            } else {
                String str2 = String.format(this.format, Float.valueOf(this.defaultValue)) + this.unit;
                int i22 = this.textToImg;
                if (i22 >= 0) {
                    canvas2.drawText(str2, this.slideX, (this.textHeight / 2.0f) + (this.bitmapHeight / 2) + this.lineY + i22, this.textPaint);
                } else {
                    canvas2.drawText(str2, this.slideX, (this.lineY - (this.bitmapHeight / 2)) + i22, this.textPaint);
                }
            }
        }
        initListener();
    }

    @Override // android.view.View
    public void onMeasure(int i5, int i6) {
        setMeasuredDimension(getMyMeasureWidth(i5), getMyMeasureHeight(i6));
    }

    /* JADX WARN: Code duplicated, block: B:36:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:38:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:40:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:42:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:54:0x00f9  */
    /* JADX WARN: Code duplicated, block: B:56:0x00fd  */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i5;
        int i6;
        int i7;
        int i8;
        this.isInit = true;
        super.onTouchEvent(motionEvent);
        float x6 = motionEvent.getX();
        float y6 = motionEvent.getY();
        int action = motionEvent.getAction();
        if (action == 0) {
            getParent().requestDisallowInterceptTouchEvent(true);
            boolean z6 = Math.abs(y6 - ((float) this.lineY)) < ((float) (this.bitmapHeight / 2));
            boolean z7 = Math.abs(x6 - ((float) this.slideX)) < ((float) (this.bitmapWidth / 2));
            if (z6 && z7) {
                this.isUpperMoving = true;
                return true;
            }
            if (x6 >= this.lineStart && x6 <= this.lineEnd && z6) {
                int i9 = (int) x6;
                this.slideX = i9;
                setPosition(computeRange(i9));
                postInvalidate();
            }
        } else if (action == 1) {
            getParent().requestDisallowInterceptTouchEvent(false);
            this.isUpperMoving = false;
            if (x6 > 0.0f) {
                int i10 = this.imageAddSubtractSize;
                if (x6 < i10) {
                    int i11 = this.paddingTop;
                    int i12 = this.verticalOffset;
                    if (y6 <= i11 + i12 || y6 >= i10 + i11 + i12) {
                        i5 = (this.bitmapWidth / 2) + this.lineEnd;
                        if (x6 > i5 + 5) {
                            i6 = this.imageAddSubtractSize;
                            if (x6 < i5 + i6 + 5) {
                                i7 = this.paddingTop;
                                i8 = this.verticalOffset;
                                if (y6 <= i7 + i8 && y6 < i6 + i7 + i8) {
                                    float f6 = this.defaultValue;
                                    if (f6 < this.bigValue) {
                                        if (this.whetherIntegerType) {
                                            setPosition(f6 + 1.0f);
                                        } else {
                                            setPosition((float) (((double) f6) + 0.1d));
                                        }
                                        if (this.onRangeUpListener != null) {
                                            System.out.println("onRangeUp    value  2");
                                            this.onRangeUpListener.onRangeUp(this.defaultValue);
                                            return true;
                                        }
                                    }
                                } else if (this.onRangeUpListener != null) {
                                    System.out.println("onRangeUp    value  3");
                                    this.onRangeUpListener.onRangeUp(this.defaultValue);
                                    return true;
                                }
                            } else if (this.onRangeUpListener != null) {
                                System.out.println("onRangeUp    value  3");
                                this.onRangeUpListener.onRangeUp(this.defaultValue);
                                return true;
                            }
                        } else if (this.onRangeUpListener != null) {
                            System.out.println("onRangeUp    value  3");
                            this.onRangeUpListener.onRangeUp(this.defaultValue);
                            return true;
                        }
                    } else {
                        float f7 = this.defaultValue;
                        if (f7 > this.smallValue) {
                            if (this.whetherIntegerType) {
                                setPosition(f7 - 1.0f);
                            } else {
                                setPosition((float) (((double) f7) - 0.1d));
                            }
                            if (this.onRangeUpListener != null) {
                                System.out.println("onRangeUp    value  1");
                                this.onRangeUpListener.onRangeUp(this.defaultValue);
                                return true;
                            }
                        }
                    }
                } else {
                    i5 = (this.bitmapWidth / 2) + this.lineEnd;
                    if (x6 > i5 + 5) {
                        i6 = this.imageAddSubtractSize;
                        if (x6 < i5 + i6 + 5) {
                            i7 = this.paddingTop;
                            i8 = this.verticalOffset;
                            if (y6 <= i7 + i8) {
                                if (this.onRangeUpListener != null) {
                                    System.out.println("onRangeUp    value  3");
                                    this.onRangeUpListener.onRangeUp(this.defaultValue);
                                    return true;
                                }
                            } else if (this.onRangeUpListener != null) {
                                System.out.println("onRangeUp    value  3");
                                this.onRangeUpListener.onRangeUp(this.defaultValue);
                                return true;
                            }
                        } else if (this.onRangeUpListener != null) {
                            System.out.println("onRangeUp    value  3");
                            this.onRangeUpListener.onRangeUp(this.defaultValue);
                            return true;
                        }
                    } else if (this.onRangeUpListener != null) {
                        System.out.println("onRangeUp    value  3");
                        this.onRangeUpListener.onRangeUp(this.defaultValue);
                        return true;
                    }
                }
            } else {
                i5 = (this.bitmapWidth / 2) + this.lineEnd;
                if (x6 > i5 + 5) {
                    i6 = this.imageAddSubtractSize;
                    if (x6 < i5 + i6 + 5) {
                        i7 = this.paddingTop;
                        i8 = this.verticalOffset;
                        if (y6 <= i7 + i8) {
                            if (this.onRangeUpListener != null) {
                                System.out.println("onRangeUp    value  3");
                                this.onRangeUpListener.onRangeUp(this.defaultValue);
                                return true;
                            }
                        } else if (this.onRangeUpListener != null) {
                            System.out.println("onRangeUp    value  3");
                            this.onRangeUpListener.onRangeUp(this.defaultValue);
                            return true;
                        }
                    } else if (this.onRangeUpListener != null) {
                        System.out.println("onRangeUp    value  3");
                        this.onRangeUpListener.onRangeUp(this.defaultValue);
                        return true;
                    }
                } else if (this.onRangeUpListener != null) {
                    System.out.println("onRangeUp    value  3");
                    this.onRangeUpListener.onRangeUp(this.defaultValue);
                    return true;
                }
            }
        } else if (action == 2) {
            getParent().requestDisallowInterceptTouchEvent(true);
            if (this.isUpperMoving && x6 >= this.lineStart) {
                int i13 = this.lineEnd;
                if (x6 <= (this.bitmapWidth / 2) + i13) {
                    int i14 = (int) x6;
                    this.slideX = i14;
                    if (i14 > i13) {
                        this.slideX = i13;
                    }
                    setPosition(computeRange(this.slideX));
                    postInvalidate();
                    return true;
                }
            }
        }
        return true;
    }

    public void resetRange(int i5) {
        float f6 = i5;
        this.defaultValue = f6;
        this.slideX = (int) computeSlide(f6);
        postInvalidate();
    }

    public void setBigValue(float f6) {
        this.bigValue = f6;
        this.bigValue = new BigDecimal(f6).setScale(1, RoundingMode.DOWN).floatValue();
        postInvalidate();
    }

    public void setMax(int i5) {
        this.max = i5;
    }

    public void setOnProgressChangeListener(OnProgressChangeListener onProgressChangeListener) {
        this.listener = onProgressChangeListener;
    }

    public void setOnRangeListener(OnRangeListener onRangeListener) {
        this.onRangeListener = onRangeListener;
    }

    public void setOnRangeUpListener(OnRangeUpListener onRangeUpListener) {
        this.onRangeUpListener = onRangeUpListener;
    }

    public void setPosition(float f6) {
        BigDecimal bigDecimal = new BigDecimal(f6);
        float fFloatValue = this.whetherIntegerType ? bigDecimal.setScale(0, 4).floatValue() : bigDecimal.setScale(1, 4).floatValue();
        if (!this.isInit) {
            float f7 = this.bigValue;
            if (fFloatValue > f7) {
                fFloatValue = f7;
            }
            float f8 = this.smallValue;
            if (fFloatValue < f8) {
                fFloatValue = f8;
            }
            this.defaultValue = fFloatValue;
            return;
        }
        float f9 = this.bigValue;
        if (fFloatValue > f9) {
            fFloatValue = f9;
        }
        float f10 = this.smallValue;
        if (fFloatValue < f10) {
            fFloatValue = f10;
        }
        if (this.defaultValue != fFloatValue) {
            this.defaultValue = fFloatValue;
            this.slideX = (int) computeSlide(fFloatValue);
            OnProgressChangeListener onProgressChangeListener = this.listener;
            if (onProgressChangeListener != null) {
                onProgressChangeListener.onProgressChanged(this.defaultValue);
            }
            postInvalidate();
        }
    }

    public void setSmallValue(float f6) {
        this.smallValue = f6;
        this.smallValue = new BigDecimal(f6).setScale(1, RoundingMode.DOWN).floatValue();
        postInvalidate();
    }

    public void setStepSize(float f6) {
        if (f6 <= 0.0f) {
            throw new IllegalArgumentException("stepSize must be positive");
        }
        this.stepSize = f6;
        postInvalidate();
    }

    public LineProgressWidget(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LineProgressWidget(Context context, @Nullable AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        this.lineLength = 400;
        this.textToImg = 20;
        this.textSize = 65;
        this.inColorStart = 0;
        this.inColorEnd = 0;
        this.outColorStart = -16776961;
        this.outColorEnd = -16776961;
        this.isDisplayValue = true;
        this.paddingLeft = 25;
        this.paddingRight = 25;
        this.paddingTop = 20;
        this.paddingBottom = 20;
        this.lineStart = 25;
        this.lineEnd = 400 + 25;
        this.bigValue = 100.0f;
        this.smallValue = 0.0f;
        this.format = "%.1f";
        this.showRange = false;
        this.rangeLength = 50;
        this.unit = "";
        this.isInit = false;
        this.defaultValue = 0.0f;
        this.whetherIntegerType = true;
        this.stepSize = 0.1f;
        this.max = 100;
        this.valueInside = false;
        this.verticalOffset = 0;
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, i.LineProgressWidgetStyle, i5, 0);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i6 = 0; i6 < indexCount; i6++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i6);
            int i7 = i.LineProgressWidgetStyle_inColorStart;
            if (i7 != 0 && index == i7) {
                this.inColorStart = typedArrayObtainStyledAttributes.getColor(index, 0);
            } else if (i7 != 0 && index == i.LineProgressWidgetStyle_inColorEnd) {
                this.inColorEnd = typedArrayObtainStyledAttributes.getColor(index, 0);
            } else if (index == i.LineProgressWidgetStyle_lineWidth) {
                this.lineWidth = (int) typedArrayObtainStyledAttributes.getDimension(index, dip2px(getContext(), 10.0f));
            } else if (index == i.LineProgressWidgetStyle_outColorStart) {
                this.outColorStart = typedArrayObtainStyledAttributes.getColor(index, InputDeviceCompat.SOURCE_ANY);
            } else if (index == i.LineProgressWidgetStyle_outColorEnd) {
                this.outColorEnd = typedArrayObtainStyledAttributes.getColor(index, InputDeviceCompat.SOURCE_ANY);
            } else if (index == i.LineProgressWidgetStyle_textColor) {
                this.textColor = typedArrayObtainStyledAttributes.getColor(index, -16776961);
            } else if (index == i.LineProgressWidgetStyle_textSize) {
                this.textSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, (int) TypedValue.applyDimension(2, 16.0f, getResources().getDisplayMetrics()));
            } else if (index == i.LineProgressWidgetStyle_isDisplayValue) {
                this.isDisplayValue = typedArrayObtainStyledAttributes.getBoolean(index, true);
            } else if (index == i.LineProgressWidgetStyle_imageBig) {
                this.bitmapBig = BitmapFactory.decodeResource(getResources(), typedArrayObtainStyledAttributes.getResourceId(index, 0));
            } else if (index == i.LineProgressWidgetStyle_imageheight) {
                this.imageHeight = (int) typedArrayObtainStyledAttributes.getDimension(index, dip2px(getContext(), 20.0f));
            } else if (index == i.LineProgressWidgetStyle_imagewidth) {
                this.imageWidth = (int) typedArrayObtainStyledAttributes.getDimension(index, dip2px(getContext(), 20.0f));
            } else if (index == i.LineProgressWidgetStyle_imageSubtract) {
                this.subtractBitmap = BitmapFactory.decodeResource(getResources(), typedArrayObtainStyledAttributes.getResourceId(index, 0));
            } else if (index == i.LineProgressWidgetStyle_imageAdd) {
                this.addBitmap = BitmapFactory.decodeResource(getResources(), typedArrayObtainStyledAttributes.getResourceId(index, 0));
            } else if (index == i.LineProgressWidgetStyle_imageAddSubtractSize) {
                this.imageAddSubtractSize = (int) typedArrayObtainStyledAttributes.getDimension(index, dip2px(getContext(), 20.0f));
            } else if (index == i.LineProgressWidgetStyle_unit) {
                this.unit = typedArrayObtainStyledAttributes.getString(index);
            } else if (index == i.LineProgressWidgetStyle_bigValue) {
                this.bigValue = typedArrayObtainStyledAttributes.getFloat(index, this.bigValue);
                this.bigValue = new BigDecimal(this.bigValue).setScale(1, RoundingMode.DOWN).floatValue();
            } else if (index == i.LineProgressWidgetStyle_smallValue) {
                this.smallValue = typedArrayObtainStyledAttributes.getFloat(index, this.smallValue);
                this.smallValue = new BigDecimal(this.smallValue).setScale(1, RoundingMode.DOWN).floatValue();
            } else if (index == i.LineProgressWidgetStyle_defaultValue) {
                this.defaultValue = typedArrayObtainStyledAttributes.getFloat(index, this.smallValue);
                this.defaultValue = new BigDecimal(this.defaultValue).setScale(1, RoundingMode.DOWN).floatValue();
            } else if (index == i.LineProgressWidgetStyle_whetherIntegerType) {
                this.whetherIntegerType = typedArrayObtainStyledAttributes.getBoolean(index, true);
            } else if (index == i.LineProgressWidgetStyle_textToImg) {
                this.textToImg = (int) typedArrayObtainStyledAttributes.getDimension(index, 20.0f);
            } else if (index == i.LineProgressWidgetStyle_showRange) {
                this.showRange = typedArrayObtainStyledAttributes.getBoolean(index, false);
            } else if (index == i.LineProgressWidgetStyle_rangeShowLength) {
                this.rangeLength = (int) typedArrayObtainStyledAttributes.getDimension(index, dip2px(getContext(), 50.0f));
            } else if (index == i.LineProgressWidgetStyle_format) {
                this.format = typedArrayObtainStyledAttributes.getString(index);
            } else if (index == i.LineProgressWidgetStyle_valueInside) {
                this.valueInside = typedArrayObtainStyledAttributes.getBoolean(index, false);
            }
            if (index == i.LineProgressWidgetStyle_verticalOffset) {
                this.verticalOffset = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0);
            }
        }
        typedArrayObtainStyledAttributes.recycle();
        init();
    }
}
