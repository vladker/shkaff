package com.mob.tools.gui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ImageView;
import com.mob.tools.MobLog;
import com.mob.tools.utils.BitmapHelper;

/* JADX INFO: loaded from: classes3.dex */
public class ScaledImageView extends ImageView implements View.OnTouchListener {
    private static final int DRAG_1 = 1;
    private static final int DRAG_2 = 2;
    private static final int NONE = 0;
    private static final int ZOOM = 3;
    private Bitmap bitmap;
    private float distSquare;
    private float[] downPoint;
    private int dragScrollMinDistSquare;
    private OnMatrixChangedListener listener;
    private Matrix matrix;
    private int mode;
    private Matrix savedMatrix;

    public interface OnMatrixChangedListener {
        void onMactrixChage(Matrix matrix);
    }

    public ScaledImageView(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        int scaledTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.dragScrollMinDistSquare = scaledTouchSlop * scaledTouchSlop;
        setOnTouchListener(this);
    }

    public Bitmap getCropedBitmap(Rect rect) {
        try {
            Bitmap bitmapCaptureView = BitmapHelper.captureView(this, getWidth(), getHeight());
            if (bitmapCaptureView == null) {
                MobLog.getInstance().w("ivPhoto.getDrawingCache() returns null");
                return null;
            }
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmapCaptureView, rect.left, rect.top, rect.width(), rect.height());
            bitmapCaptureView.recycle();
            return bitmapCreateBitmap;
        } catch (Throwable th) {
            MobLog.getInstance().w(th);
            return null;
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        try {
            int action = motionEvent.getAction();
            if (action == 0) {
                Matrix matrix = new Matrix();
                this.matrix = matrix;
                matrix.set(getImageMatrix());
                Matrix matrix2 = new Matrix();
                this.savedMatrix = matrix2;
                matrix2.set(this.matrix);
                this.downPoint = new float[]{motionEvent.getX(0), motionEvent.getY(0)};
                this.mode = 1;
            } else if (action == 1) {
                OnMatrixChangedListener onMatrixChangedListener = this.listener;
                if (onMatrixChangedListener != null) {
                    onMatrixChangedListener.onMactrixChage(this.matrix);
                }
                float x6 = motionEvent.getX(0) - this.downPoint[0];
                float y6 = motionEvent.getY(0) - this.downPoint[1];
                if (this.mode == 1 && (y6 * y6) + (x6 * x6) <= this.dragScrollMinDistSquare) {
                    performClick();
                }
                this.mode = 0;
            } else if (action == 2) {
                int i5 = this.mode;
                if (i5 == 1) {
                    float[] fArr = {motionEvent.getX(0), motionEvent.getY(0)};
                    this.matrix.set(this.savedMatrix);
                    Matrix matrix3 = this.matrix;
                    float f6 = fArr[0];
                    float[] fArr2 = this.downPoint;
                    matrix3.postTranslate(f6 - fArr2[0], fArr[1] - fArr2[1]);
                } else if (i5 == 2) {
                    float[] fArr3 = {motionEvent.getX(1), motionEvent.getY(1)};
                    this.matrix.set(this.savedMatrix);
                    Matrix matrix4 = this.matrix;
                    float f7 = fArr3[0];
                    float[] fArr4 = this.downPoint;
                    matrix4.postTranslate(f7 - fArr4[0], fArr3[1] - fArr4[1]);
                } else if (i5 == 3) {
                    float[] fArr5 = {motionEvent.getX(0), motionEvent.getY(0)};
                    float[] fArr6 = {motionEvent.getX(1), motionEvent.getY(1)};
                    float f8 = fArr5[0] - fArr6[0];
                    float f9 = fArr5[1] - fArr6[1];
                    this.matrix.set(this.savedMatrix);
                    float fSqrt = (float) Math.sqrt(((f9 * f9) + (f8 * f8)) / this.distSquare);
                    float[] fArr7 = {(fArr5[0] + fArr6[0]) / 2.0f, (fArr5[1] + fArr6[1]) / 2.0f};
                    this.matrix.postScale(fSqrt, fSqrt, fArr7[0], fArr7[1]);
                }
            } else if (action == 5) {
                float[] fArr8 = {motionEvent.getX(0), motionEvent.getY(0)};
                float[] fArr9 = {motionEvent.getX(1), motionEvent.getY(1)};
                float f10 = fArr8[0] - fArr9[0];
                float f11 = fArr8[1] - fArr9[1];
                this.distSquare = (f11 * f11) + (f10 * f10);
                this.mode = 3;
            } else if (action == 6) {
                this.downPoint = new float[]{motionEvent.getX(1), motionEvent.getY(1)};
                this.savedMatrix.set(this.matrix);
                this.mode = 2;
            } else if (action == 261) {
                float[] fArr10 = {motionEvent.getX(0), motionEvent.getY(0)};
                float[] fArr11 = {motionEvent.getX(1), motionEvent.getY(1)};
                float f12 = fArr10[0] - fArr11[0];
                float f13 = fArr10[1] - fArr11[1];
                this.distSquare = (f13 * f13) + (f12 * f12);
                this.mode = 3;
            } else {
                if (action != 262) {
                    return false;
                }
                this.downPoint = new float[]{motionEvent.getX(0), motionEvent.getY(0)};
                this.savedMatrix.set(this.matrix);
                this.mode = 1;
            }
            setImageMatrix(this.matrix);
        } catch (Throwable th) {
            MobLog.getInstance().w(th);
        }
        return true;
    }

    public void rotateLeft() {
        try {
            Matrix matrix = new Matrix();
            this.matrix = matrix;
            float[] fArr = {0.0f, 1.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
            matrix.setValues(fArr);
            Bitmap bitmap = this.bitmap;
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), this.bitmap.getHeight(), this.matrix, true);
            if (bitmapCreateBitmap != null && !bitmapCreateBitmap.isRecycled()) {
                this.bitmap.recycle();
                this.bitmap = bitmapCreateBitmap;
            }
            setImageBitmap(this.bitmap);
            Matrix matrix2 = new Matrix();
            this.matrix = matrix2;
            matrix2.set(getImageMatrix());
            this.matrix.getValues(fArr);
            int[] iArr = {getWidth(), getHeight()};
            float[] fArr2 = {fArr[0] * this.bitmap.getWidth(), fArr[4] * this.bitmap.getHeight()};
            float[] fArr3 = {(iArr[0] - fArr2[0]) / 2.0f, (iArr[1] - fArr2[1]) / 2.0f};
            fArr[2] = fArr3[0];
            fArr[5] = fArr3[1];
            this.matrix.setValues(fArr);
            OnMatrixChangedListener onMatrixChangedListener = this.listener;
            if (onMatrixChangedListener != null) {
                onMatrixChangedListener.onMactrixChage(this.matrix);
            }
            setImageMatrix(this.matrix);
        } catch (Throwable th) {
            MobLog.getInstance().w(th);
        }
    }

    public void rotateRight() {
        try {
            Matrix matrix = new Matrix();
            this.matrix = matrix;
            float[] fArr = {0.0f, -1.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
            matrix.setValues(fArr);
            Bitmap bitmap = this.bitmap;
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), this.bitmap.getHeight(), this.matrix, true);
            if (bitmapCreateBitmap != null && !bitmapCreateBitmap.isRecycled()) {
                this.bitmap.recycle();
                this.bitmap = bitmapCreateBitmap;
            }
            setImageBitmap(this.bitmap);
            Matrix matrix2 = new Matrix();
            this.matrix = matrix2;
            matrix2.set(getImageMatrix());
            this.matrix.getValues(fArr);
            int[] iArr = {getWidth(), getHeight()};
            float[] fArr2 = {fArr[0] * this.bitmap.getWidth(), fArr[4] * this.bitmap.getHeight()};
            float[] fArr3 = {(iArr[0] - fArr2[0]) / 2.0f, (iArr[1] - fArr2[1]) / 2.0f};
            fArr[2] = fArr3[0];
            fArr[5] = fArr3[1];
            this.matrix.setValues(fArr);
            OnMatrixChangedListener onMatrixChangedListener = this.listener;
            if (onMatrixChangedListener != null) {
                onMatrixChangedListener.onMactrixChage(this.matrix);
            }
            setImageMatrix(this.matrix);
        } catch (Throwable th) {
            MobLog.getInstance().w(th);
        }
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
        setImageBitmap(bitmap);
        int[] iArr = {getWidth(), getHeight()};
        int[] iArr2 = {this.bitmap.getWidth(), this.bitmap.getHeight()};
        int[] iArrFixRect = BitmapHelper.fixRect(iArr2, iArr);
        int i5 = iArr[0];
        int i6 = iArrFixRect[0];
        int i7 = iArr[1];
        int i8 = iArrFixRect[1];
        int[] iArr3 = {(i5 - i6) / 2, (i7 - i8) / 2};
        float[] fArr = {i6 / iArr2[0], i8 / iArr2[1]};
        Matrix matrix = new Matrix();
        this.matrix = matrix;
        matrix.set(getImageMatrix());
        this.matrix.postScale(fArr[0], fArr[1]);
        this.matrix.postTranslate(iArr3[0], iArr3[1]);
        OnMatrixChangedListener onMatrixChangedListener = this.listener;
        if (onMatrixChangedListener != null) {
            onMatrixChangedListener.onMactrixChage(this.matrix);
        }
        setImageMatrix(this.matrix);
    }

    public void setOnMatrixChangedListener(OnMatrixChangedListener onMatrixChangedListener) {
        this.listener = onMatrixChangedListener;
        Matrix matrix = this.matrix;
        if (matrix != null) {
            if (onMatrixChangedListener != null) {
                onMatrixChangedListener.onMactrixChage(matrix);
            }
            setImageMatrix(this.matrix);
        }
    }

    public void zoomIn() {
        Matrix matrix = new Matrix();
        this.matrix = matrix;
        matrix.set(getImageMatrix());
        this.matrix.postScale(1.072f, 1.072f);
        OnMatrixChangedListener onMatrixChangedListener = this.listener;
        if (onMatrixChangedListener != null) {
            onMatrixChangedListener.onMactrixChage(this.matrix);
        }
        setImageMatrix(this.matrix);
    }

    public void zoomOut() {
        Matrix matrix = new Matrix();
        this.matrix = matrix;
        matrix.set(getImageMatrix());
        this.matrix.postScale(0.933f, 0.933f);
        OnMatrixChangedListener onMatrixChangedListener = this.listener;
        if (onMatrixChangedListener != null) {
            onMatrixChangedListener.onMactrixChage(this.matrix);
        }
        setImageMatrix(this.matrix);
    }

    public ScaledImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public ScaledImageView(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        init(context);
    }
}
