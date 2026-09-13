package com.appdev.standard.page.printerlabel.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.Looper;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.ViewCompat;
import com.appdev.standard.page.printerlabel.util.BarcodeUtil;
import com.appdev.standard.page.printerlabel.util.FontDataManager;
import com.appdev.standard.util.fileDownload.h;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import java.io.File;
import java.util.HashMap;
import java.util.Random;
import p042h2.d;
import p050j.w;
import p113u.g;
import p134x2.C1849c;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class BaseBarcodeView extends View {
    private final String TAG;
    private int barcodeColor;
    private Paint bitmapPaint;
    private boolean bold;
    private int colorType;
    private String content;
    private float defaultHeight;
    private float defaultWidth;
    private String encodeRef;
    private float fontSize;
    private String fontType;
    private int hAlignment;
    private boolean italic;
    private boolean strikethrough;
    private TextPaint textPaint;
    private int textPosition;
    private boolean underline;

    public BaseBarcodeView(Context context) {
        this(context, null);
    }

    private void calEAN13Position(BitMatrix bitMatrix, Rect rect, Rect rect2) {
        int i5;
        int width = bitMatrix.getWidth();
        boolean[] zArr = new boolean[width];
        int width2 = bitMatrix.getWidth();
        int i6 = 0;
        for (int i7 = 0; i7 < width2; i7++) {
            zArr[i7] = bitMatrix.get(i7, 0);
        }
        int i8 = width / 2;
        int i9 = 1;
        int i10 = 0;
        while (true) {
            i5 = width - 1;
            if (i9 > i5) {
                break;
            }
            if (zArr[i9 - 1] && !zArr[i9]) {
                i10++;
            }
            if (i10 == 2) {
                rect.left = i9;
                break;
            }
            i9++;
        }
        for (int i11 = i8; i11 >= 1; i11--) {
            if (!zArr[i11] && zArr[i11 + 1] && i11 != i8) {
                rect.right = i11;
                break;
            }
        }
        for (int i12 = i8; i12 <= i5; i12++) {
            if (zArr[i12 - 1] && !zArr[i12] && i12 != i8) {
                rect2.left = i12;
                break;
            }
        }
        for (int i13 = width - 2; i13 >= 1; i13--) {
            if (!zArr[i13] && zArr[i13 + 1]) {
                i6++;
            }
            if (i6 == 2) {
                rect2.right = i13;
                return;
            }
        }
    }

    private void calEAN8Position(BitMatrix bitMatrix, Rect rect, Rect rect2) {
        int i5;
        int width = bitMatrix.getWidth();
        boolean[] zArr = new boolean[width];
        int width2 = bitMatrix.getWidth();
        int i6 = 0;
        for (int i7 = 0; i7 < width2; i7++) {
            zArr[i7] = bitMatrix.get(i7, 0);
        }
        int i8 = width / 2;
        int i9 = 1;
        int i10 = 0;
        while (true) {
            i5 = width - 1;
            if (i9 > i5) {
                break;
            }
            if (zArr[i9 - 1] && !zArr[i9]) {
                i10++;
            }
            if (i10 == 2) {
                rect.left = i9;
                break;
            }
            i9++;
        }
        for (int i11 = i8; i11 >= 1; i11--) {
            if (!zArr[i11] && zArr[i11 + 1] && i11 != i8) {
                rect.right = i11;
                break;
            }
        }
        for (int i12 = i8; i12 <= i5; i12++) {
            if (zArr[i12 - 1] && !zArr[i12] && i12 != i8) {
                rect2.left = i12;
                break;
            }
        }
        for (int i13 = width - 2; i13 >= 1; i13--) {
            if (!zArr[i13] && zArr[i13 + 1]) {
                i6++;
            }
            if (i6 == 2) {
                rect2.right = i13;
                return;
            }
        }
    }

    private void calUPCAPosition(BitMatrix bitMatrix, Rect rect, Rect rect2) {
        int i5;
        int width = bitMatrix.getWidth();
        boolean[] zArr = new boolean[width];
        int width2 = bitMatrix.getWidth();
        int i6 = 0;
        for (int i7 = 0; i7 < width2; i7++) {
            zArr[i7] = bitMatrix.get(i7, 0);
        }
        int i8 = width / 2;
        int i9 = 1;
        int i10 = 0;
        while (true) {
            i5 = width - 1;
            if (i9 > i5) {
                break;
            }
            if (zArr[i9 - 1] && !zArr[i9]) {
                i10++;
            }
            if (i10 == 4) {
                rect.left = i9;
                break;
            }
            i9++;
        }
        for (int i11 = i8; i11 >= 1; i11--) {
            if (!zArr[i11] && zArr[i11 + 1] && i11 != i8) {
                rect.right = i11;
                break;
            }
        }
        for (int i12 = i8; i12 <= i5; i12++) {
            if (zArr[i12 - 1] && !zArr[i12] && i12 != i8) {
                rect2.left = i12;
                break;
            }
        }
        for (int i13 = width - 2; i13 >= 1; i13--) {
            if (!zArr[i13] && zArr[i13 + 1]) {
                i6++;
            }
            if (i6 == 4) {
                rect2.right = i13;
                return;
            }
        }
    }

    private void calUPCEPosition(BitMatrix bitMatrix, Rect rect) {
        int width = bitMatrix.getWidth();
        boolean[] zArr = new boolean[width];
        int width2 = bitMatrix.getWidth();
        int i5 = 0;
        for (int i6 = 0; i6 < width2; i6++) {
            zArr[i6] = bitMatrix.get(i6, 0);
        }
        int i7 = 0;
        for (int i8 = 1; i8 <= width - 1; i8++) {
            if (zArr[i8 - 1] && !zArr[i8]) {
                i7++;
            }
            if (i7 == 2) {
                rect.left = i8;
                break;
            }
        }
        for (int i9 = width - 2; i9 >= 1; i9--) {
            if (!zArr[i9] && zArr[i9 + 1]) {
                i5++;
            }
            if (i5 == 3) {
                rect.right = i9;
                return;
            }
        }
    }

    private BitMatrix deleteWhite(BitMatrix bitMatrix) {
        int[] enclosingRectangle = bitMatrix.getEnclosingRectangle();
        int i5 = enclosingRectangle[2];
        int i6 = enclosingRectangle[3];
        BitMatrix bitMatrix2 = new BitMatrix(i5, i6);
        bitMatrix2.clear();
        for (int i7 = 0; i7 < i5; i7++) {
            for (int i8 = 0; i8 < i6; i8++) {
                if (bitMatrix.get(enclosingRectangle[0] + i7, enclosingRectangle[1] + i8)) {
                    bitMatrix2.set(i7, i8);
                }
            }
        }
        return bitMatrix2;
    }

    private void drawEAN13(Canvas canvas, String str) {
        int i5;
        int i6;
        float f6;
        float f7;
        int i7;
        int i8;
        int width = getWidth();
        int height = getHeight();
        float f8 = height;
        this.textPaint.setTextSize((((this.fontSize * f8) * 33.95f) / 194.0f) / 14.0f);
        float textSize = this.textPaint.getTextSize();
        String strSubstring = str.substring(0, 1);
        String strSubstring2 = str.substring(1, 7);
        String strSubstring3 = str.substring(7, 13);
        float fMeasureText = this.textPaint.measureText(strSubstring);
        if (this.textPosition != 2) {
            i5 = height - ((int) (textSize / 2.0f));
            width -= (int) fMeasureText;
            i6 = height;
            f6 = fMeasureText;
        } else {
            i5 = height;
            i6 = i5;
            f6 = 0.0f;
        }
        try {
            BitMatrix bitMatrixEncodeAsBitMatrix = encodeAsBitMatrix(str, BarcodeFormat.EAN_13, width, i5);
            if (bitMatrixEncodeAsBitMatrix == null) {
                int i9 = width;
                int i10 = i5;
                try {
                    drawPlaceholder(canvas, f6, 0.0f, i9, i10);
                    return;
                } catch (Exception e) {
                    e = e;
                    i8 = i9;
                    i7 = i10;
                }
            } else {
                i7 = i5;
                i8 = width;
                try {
                    canvas.drawBitmap(encodeAsBitmap(bitMatrixEncodeAsBitMatrix), f6, 0.0f, this.bitmapPaint);
                    if (this.textPosition == 2) {
                        return;
                    }
                    int i11 = (int) (f8 - textSize);
                    Rect rect = new Rect(0, i11, 0, i6);
                    Rect rect2 = new Rect(0, i11, 0, i6);
                    calEAN13Position(bitMatrixEncodeAsBitMatrix, rect, rect2);
                    rect.left = (int) (rect.left + f6);
                    rect.right = (int) (rect.right + f6);
                    rect2.left = (int) (rect2.left + f6);
                    rect2.right = (int) (rect2.right + f6);
                    drawRectTransparent(canvas, rect);
                    drawRectTransparent(canvas, rect2);
                    float f9 = f8 - this.textPaint.getFontMetrics().bottom;
                    float f10 = f6;
                    try {
                        f7 = f10;
                        try {
                            drawTextAuto(canvas, 6, f9, strSubstring, (int) fMeasureText, false, this.hAlignment);
                            drawTextAuto(canvas, rect.left + 6, f9, strSubstring2, rect.width() - 12, true, this.hAlignment);
                            drawTextAuto(canvas, rect2.left + 6, f9, strSubstring3, rect2.width() - 12, true, this.hAlignment);
                            return;
                        } catch (Exception e6) {
                            e = e6;
                        }
                    } catch (Exception e7) {
                        e = e7;
                        f7 = f10;
                    }
                } catch (Exception e8) {
                    e = e8;
                    f7 = f6;
                }
            }
            f7 = f6;
        } catch (Exception e9) {
            e = e9;
            f7 = f6;
            i7 = i5;
            i8 = width;
        }
        p051j0.a.d("t", e.toString());
        drawPlaceholder(canvas, f7, 0.0f, i8, i7);
    }

    private void drawEAN8(Canvas canvas, String str) {
        int width = getWidth();
        int height = getHeight();
        String strSubstring = str.substring(0, 4);
        String strSubstring2 = str.substring(4, 8);
        float f6 = height;
        this.textPaint.setTextSize((((this.fontSize * f6) * 33.95f) / 194.0f) / 14.0f);
        float textSize = this.textPaint.getTextSize();
        int i5 = this.textPosition != 2 ? height - ((int) (textSize / 2.0f)) : height;
        try {
            BitMatrix bitMatrixEncodeAsBitMatrix = encodeAsBitMatrix(str, BarcodeFormat.EAN_8, width, i5);
            if (bitMatrixEncodeAsBitMatrix == null) {
                try {
                    drawPlaceholder(canvas, 0.0f, 0.0f, width, i5);
                    return;
                } catch (Exception e) {
                    e = e;
                }
            } else {
                try {
                    canvas.drawBitmap(encodeAsBitmap(bitMatrixEncodeAsBitMatrix), 0.0f, 0.0f, this.bitmapPaint);
                    if (this.textPosition != 2) {
                        int i6 = (int) (f6 - textSize);
                        Rect rect = new Rect(0, i6, 0, height);
                        Rect rect2 = new Rect(0, i6, 0, height);
                        calEAN8Position(bitMatrixEncodeAsBitMatrix, rect, rect2);
                        float f7 = f6 - this.textPaint.getFontMetrics().bottom;
                        drawRectTransparent(canvas, rect);
                        drawRectTransparent(canvas, rect2);
                        drawTextAuto(canvas, rect.left + 6, f7, strSubstring, rect.width() - 12, true, this.hAlignment);
                        drawTextAuto(canvas, rect2.left + 6, f7, strSubstring2, rect2.width() - 12, true, this.hAlignment);
                        return;
                    }
                    return;
                } catch (Exception e6) {
                    e = e6;
                }
            }
        } catch (Exception e7) {
            e = e7;
        }
        p051j0.a.d("t", e.toString());
        drawPlaceholder(canvas, 0.0f, 0.0f, width, i5);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0030 A[PHI: r2
  0x0030: PHI (r2v15 float) = (r2v3 float), (r2v4 float) binds: [B:6:0x002e, B:9:0x0035] A[DONT_GENERATE, DONT_INLINE]] */
    private void drawGeneralBarCode(Canvas canvas, BarcodeFormat barcodeFormat, String str) {
        float f6;
        float f7;
        float f8;
        float f9;
        int i5;
        int width = getWidth();
        int height = getHeight();
        float f10 = height;
        this.textPaint.setTextSize((((this.fontSize * f10) * 33.95f) / 194.0f) / 14.0f);
        float textSize = this.textPaint.getTextSize() + 8.0f;
        int i6 = this.textPosition;
        if (i6 != 2) {
            height -= (int) textSize;
        }
        int i7 = height;
        if (i6 == 0) {
            f6 = textSize;
            f7 = f6;
        } else {
            textSize = 0.0f;
            if (i6 == 1) {
                f6 = f10;
                f7 = 0.0f;
            } else {
                f6 = textSize;
                f7 = f6;
            }
        }
        try {
            BitMatrix bitMatrixEncodeAsBitMatrix = encodeAsBitMatrix(str, barcodeFormat, width, i7);
            if (bitMatrixEncodeAsBitMatrix == null) {
                drawPlaceholder(canvas, 0.0f, f7, width, i7);
                return;
            }
            f8 = 0.0f;
            f9 = f7;
            i5 = i7;
            try {
                Bitmap bitmapEncodeAsBitmap = encodeAsBitmap(bitMatrixEncodeAsBitMatrix);
                Matrix matrix = new Matrix();
                matrix.postScale(width / bitMatrixEncodeAsBitMatrix.getWidth(), 1.0f);
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmapEncodeAsBitmap, 0, 0, bitmapEncodeAsBitmap.getWidth(), bitmapEncodeAsBitmap.getHeight(), matrix, false);
                bitmapEncodeAsBitmap.recycle();
                canvas.drawBitmap(bitmapCreateBitmap, 0.0f, f9, this.bitmapPaint);
                if (this.textPosition == 2) {
                    return;
                }
                try {
                    drawTextAuto(canvas, 0.0f, f6 - this.textPaint.getFontMetrics().bottom, str, width, false, this.hAlignment);
                    return;
                } catch (Exception e) {
                    e = e;
                    width = width;
                }
            } catch (Exception e6) {
                e = e6;
            }
        } catch (Exception e7) {
            e = e7;
            f8 = 0.0f;
            f9 = f7;
            i5 = i7;
        }
        p051j0.a.d("t", e.toString());
        drawPlaceholder(canvas, f8, f9, width, i5);
    }

    private void drawPlaceholder(Canvas canvas, float f6, float f7, int i5, int i6) {
        Paint paint = new Paint();
        paint.setColor(-3355444);
        paint.setStyle(Paint.Style.FILL);
        float f8 = i5;
        float f9 = f6 + f8;
        float f10 = i6;
        float f11 = f7 + f10;
        canvas.drawRect(f6, f7, f9, f11, paint);
        Paint paint2 = new Paint();
        paint2.setColor(-7829368);
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setStrokeWidth(2.0f);
        canvas.drawRect(f6, f7, f9, f11, paint2);
        String string = getContext().getString(g.barcode_invalid_placeholder);
        Paint.FontMetrics fontMetrics = this.textPaint.getFontMetrics();
        float fMeasureText = this.textPaint.measureText(string);
        float f12 = fontMetrics.descent;
        canvas.drawText(string, ((f8 - fMeasureText) / 2.0f) + f6, (((f10 + (f12 - fontMetrics.ascent)) / 2.0f) + f7) - f12, this.textPaint);
    }

    private void drawRectTransparent(Canvas canvas, Rect rect) {
        canvas.save();
        canvas.clipRect(rect);
        canvas.drawColor(-1);
        canvas.restore();
    }

    private void drawTextAuto(Canvas canvas, float f6, float f7, String str, int i5, boolean z6, int i6) {
        float fMeasureText = this.textPaint.measureText(str);
        float f8 = i5;
        if (f8 <= fMeasureText) {
            float f9 = f8 / fMeasureText;
            canvas.save();
            canvas.scale(f9, 1.0f);
            canvas.drawText(str, f6 / f9, f7, this.textPaint);
            canvas.restore();
            return;
        }
        int i7 = 0;
        if (z6) {
            float fMeasureText2 = this.textPaint.measureText(str.substring(0, 1));
            float length = (f8 - fMeasureText) / (str.length() - 1);
            while (i7 <= str.length() - 1) {
                int i8 = i7 + 1;
                String strSubstring = str.substring(i7, i8);
                float f10 = i7;
                canvas.drawText(strSubstring, (f10 * length) + (fMeasureText2 * f10) + f6, f7, this.textPaint);
                i7 = i8;
            }
            return;
        }
        if (i6 == 0) {
            canvas.drawText(str, f6, f7, this.textPaint);
            return;
        }
        if (i6 == 1) {
            canvas.drawText(str, ((f8 - fMeasureText) / 2.0f) + f6, f7, this.textPaint);
            return;
        }
        if (i6 == 2) {
            canvas.drawText(str, f8 - fMeasureText, f7, this.textPaint);
            return;
        }
        if (i6 != 4) {
            return;
        }
        float length2 = (f8 - fMeasureText) / (str.length() - 1);
        while (i7 < str.length()) {
            int i9 = i7 + 1;
            canvas.drawText(str.substring(i7, i9), ((this.textPaint.measureText(str.substring(i7, i9)) + length2) * i7) + f6, f7, this.textPaint);
            i7 = i9;
        }
    }

    private void drawUPCA(Canvas canvas, String str) {
        int i5;
        int i6;
        float f6;
        float f7;
        int i7;
        int i8;
        int width = getWidth();
        int height = getHeight();
        float f8 = height;
        this.textPaint.setTextSize((((this.fontSize * f8) * 33.95f) / 194.0f) / 14.0f);
        float textSize = this.textPaint.getTextSize();
        String strSubstring = str.substring(0, 1);
        String strSubstring2 = str.substring(1, 6);
        String strSubstring3 = str.substring(6, 11);
        String strSubstring4 = str.substring(11, 12);
        float fMeasureText = this.textPaint.measureText(strSubstring);
        if (this.textPosition != 2) {
            i5 = height - ((int) (textSize / 2.0f));
            width -= (int) (2.0f * fMeasureText);
            i6 = height;
            f6 = fMeasureText;
        } else {
            i5 = height;
            i6 = i5;
            f6 = 0.0f;
        }
        try {
            BitMatrix bitMatrixEncodeAsBitMatrix = encodeAsBitMatrix(str, BarcodeFormat.UPC_A, width, i5);
            if (bitMatrixEncodeAsBitMatrix == null) {
                int i9 = width;
                int i10 = i5;
                try {
                    drawPlaceholder(canvas, f6, 0.0f, i9, i10);
                    return;
                } catch (Exception e) {
                    e = e;
                    i8 = i9;
                    i7 = i10;
                }
            } else {
                i7 = i5;
                i8 = width;
                try {
                    canvas.drawBitmap(encodeAsBitmap(bitMatrixEncodeAsBitMatrix), f6, 0.0f, this.bitmapPaint);
                    if (this.textPosition == 2) {
                        return;
                    }
                    int i11 = (int) (f8 - textSize);
                    Rect rect = new Rect(0, i11, 0, i6);
                    Rect rect2 = new Rect(0, i11, 0, i6);
                    calUPCAPosition(bitMatrixEncodeAsBitMatrix, rect, rect2);
                    rect.left = (int) (rect.left + f6);
                    rect.right = (int) (rect.right + f6);
                    rect2.left = (int) (rect2.left + f6);
                    rect2.right = (int) (rect2.right + f6);
                    drawRectTransparent(canvas, rect);
                    drawRectTransparent(canvas, rect2);
                    float f9 = f8 - this.textPaint.getFontMetrics().bottom;
                    int i12 = (int) fMeasureText;
                    f7 = f6;
                    try {
                        drawTextAuto(canvas, 0.0f, f9, strSubstring, i12, false, this.hAlignment);
                        drawTextAuto(canvas, rect.left + 6, f9, strSubstring2, rect.width() - 12, true, this.hAlignment);
                        drawTextAuto(canvas, rect2.left + 6, f9, strSubstring3, rect2.width() - 12, true, this.hAlignment);
                        drawTextAuto(canvas, f7 + i8, f9, strSubstring4, i12, false, this.hAlignment);
                        return;
                    } catch (Exception e6) {
                        e = e6;
                    }
                } catch (Exception e7) {
                    e = e7;
                    f7 = f6;
                }
            }
            f7 = f6;
        } catch (Exception e8) {
            e = e8;
            f7 = f6;
            i7 = i5;
            i8 = width;
        }
        p051j0.a.d("t", e.toString());
        drawPlaceholder(canvas, f7, 0.0f, i8, i7);
    }

    private void drawUPCE(Canvas canvas, String str) {
        int i5;
        int i6;
        float f6;
        float f7;
        int i7;
        int i8;
        int width = getWidth();
        int height = getHeight();
        float f8 = height;
        this.textPaint.setTextSize((((this.fontSize * f8) * 33.95f) / 194.0f) / 14.0f);
        float textSize = this.textPaint.getTextSize();
        String strSubstring = str.substring(0, 1);
        String strSubstring2 = str.substring(1, 7);
        String strSubstring3 = str.substring(7, 8);
        float fMeasureText = this.textPaint.measureText(strSubstring);
        if (this.textPosition != 2) {
            i6 = height - ((int) (textSize / 2.0f));
            width -= (int) (2.0f * fMeasureText);
            i5 = height;
            f6 = fMeasureText;
        } else {
            i5 = height;
            i6 = i5;
            f6 = 0.0f;
        }
        try {
            BitMatrix bitMatrixEncodeAsBitMatrix = encodeAsBitMatrix(str, BarcodeFormat.UPC_E, width, i6);
            if (bitMatrixEncodeAsBitMatrix == null) {
                int i9 = width;
                int i10 = i6;
                try {
                    drawPlaceholder(canvas, f6, 0.0f, i9, i10);
                    return;
                } catch (Exception e) {
                    e = e;
                    i8 = i9;
                    i7 = i10;
                }
            } else {
                i7 = i6;
                i8 = width;
                try {
                    canvas.drawBitmap(encodeAsBitmap(bitMatrixEncodeAsBitMatrix), f6, 0.0f, this.bitmapPaint);
                    if (this.textPosition == 2) {
                        return;
                    }
                    Rect rect = new Rect(0, (int) (f8 - textSize), 0, i5);
                    calUPCEPosition(bitMatrixEncodeAsBitMatrix, rect);
                    rect.left = (int) (rect.left + f6);
                    rect.right = (int) (rect.right + f6);
                    drawRectTransparent(canvas, rect);
                    float f9 = f8 - this.textPaint.getFontMetrics().bottom;
                    int i11 = (int) fMeasureText;
                    f7 = f6;
                    try {
                        drawTextAuto(canvas, 0.0f, f9, strSubstring, i11, false, this.hAlignment);
                        drawTextAuto(canvas, rect.left + 6, f9, strSubstring2, rect.width() - 12, true, this.hAlignment);
                        drawTextAuto(canvas, f7 + i8, f9, strSubstring3, i11, false, this.hAlignment);
                        return;
                    } catch (Exception e6) {
                        e = e6;
                    }
                } catch (Exception e7) {
                    e = e7;
                    f7 = f6;
                }
            }
            f7 = f6;
        } catch (Exception e8) {
            e = e8;
            f7 = f6;
            i7 = i6;
            i8 = width;
        }
        p051j0.a.d("t", e.toString());
        drawPlaceholder(canvas, f7, 0.0f, i8, i7);
    }

    private BitMatrix encodeAsBitMatrix(String str, BarcodeFormat barcodeFormat, int i5, int i6) {
        MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
        HashMap map = new HashMap();
        map.put(EncodeHintType.CHARACTER_SET, "utf-8");
        map.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
        map.put(EncodeHintType.MARGIN, 0);
        try {
            return deleteWhite(multiFormatWriter.encode(str, barcodeFormat, i5, i6, map));
        } catch (WriterException e) {
            e.printStackTrace();
            return null;
        }
    }

    private void updateColors() {
        int i5 = this.colorType == 1 ? SupportMenu.CATEGORY_MASK : ViewCompat.MEASURED_STATE_MASK;
        this.textPaint.setColor(i5);
        this.barcodeColor = i5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTextPaint() {
        int i5;
        Typeface typefaceCreateFromFile;
        boolean z6 = this.bold;
        if (z6 && this.italic) {
            i5 = 3;
        } else if (z6) {
            i5 = 1;
        } else {
            i5 = this.italic ? 2 : 0;
        }
        if (" 0".equals(this.fontType)) {
            typefaceCreateFromFile = Typeface.createFromFile("/system/fonts/Roboto-Regular.ttf");
        } else if ("-10001".equals(this.fontType)) {
            typefaceCreateFromFile = Typeface.createFromAsset(getContext().getAssets(), "zt_aLiJianKangTi.ttf");
        } else if ("-10002".equals(this.fontType)) {
            typefaceCreateFromFile = Typeface.createFromAsset(getContext().getAssets(), "zt_cangErYuYangTi.ttf");
        } else if ("-10003".equals(this.fontType)) {
            typefaceCreateFromFile = Typeface.createFromAsset(getContext().getAssets(), "zt_douYuZhuiGuangTi.ttf");
        } else if ("-10004".equals(this.fontType)) {
            typefaceCreateFromFile = Typeface.createFromAsset(getContext().getAssets(), "zt_fangZhengHeiTi.ttf");
        } else if ("-10005".equals(this.fontType)) {
            typefaceCreateFromFile = Typeface.createFromAsset(getContext().getAssets(), "zt_maoKenZhuYuanTi.ttf");
        } else if ("-10006".equals(this.fontType)) {
            typefaceCreateFromFile = Typeface.createFromAsset(getContext().getAssets(), "zt_mengYuanFangSong.ttf");
        } else {
            File fontLocalFile = FontDataManager.getInstance().getFontLocalFile(this.fontType);
            typefaceCreateFromFile = (fontLocalFile == null || !fontLocalFile.exists()) ? Typeface.createFromFile("/system/fonts/Roboto-Regular.ttf") : Typeface.createFromFile(fontLocalFile);
        }
        this.textPaint.setTypeface(Typeface.create(typefaceCreateFromFile, i5));
        int i6 = this.underline ? 9 : 1;
        if (this.strikethrough) {
            i6 |= 16;
        }
        this.textPaint.setFlags(i6);
        this.textPaint.setTextSize(C1849c.mm2pxWithScale(this.fontSize / 10.0f));
        invalidate();
    }

    public Bitmap encodeAsBitmap(BitMatrix bitMatrix) {
        int width = bitMatrix.getWidth();
        int height = bitMatrix.getHeight();
        int[] iArr = new int[width * height];
        for (int i5 = 0; i5 < height; i5++) {
            int i6 = i5 * width;
            for (int i7 = 0; i7 < width; i7++) {
                iArr[i6 + i7] = bitMatrix.get(i7, i5) ? this.barcodeColor : 16777215;
            }
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        bitmapCreateBitmap.setPixels(iArr, 0, width, 0, 0, width, height);
        return bitmapCreateBitmap;
    }

    public int getBarcodeColor() {
        return this.barcodeColor;
    }

    public String getBarcodeType() {
        return this.encodeRef;
    }

    public int getColorType() {
        return this.colorType;
    }

    public String getContent() {
        return this.content;
    }

    public String getFontType() {
        return this.fontType;
    }

    public int getShowText() {
        return this.textPosition;
    }

    public float getTextSize() {
        return this.fontSize;
    }

    public int gethAlignment() {
        return this.hAlignment;
    }

    public boolean isBold() {
        return this.bold;
    }

    public boolean isItalic() {
        return this.italic;
    }

    public boolean isStrikethrough() {
        return this.strikethrough;
    }

    public boolean isUnderline() {
        return this.underline;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        p051j0.a.d("TAG", "showContent=" + this.content);
        String str = this.encodeRef;
        str.getClass();
        switch (str) {
            case "CODE_128":
                drawGeneralBarCode(canvas, BarcodeFormat.CODE_128, this.content);
                break;
            case "ITF":
                drawGeneralBarCode(canvas, BarcodeFormat.ITF, this.content);
                break;
            case "EAN_8":
                drawEAN8(canvas, BarcodeUtil.getEAN8Content(this.content));
                break;
            case "UPC_A":
                drawUPCA(canvas, BarcodeUtil.getUPCAContent(this.content));
                break;
            case "UPC_E":
                drawUPCE(canvas, BarcodeUtil.getUPCEContent(this.content));
                break;
            case "CODABAR":
                drawGeneralBarCode(canvas, BarcodeFormat.CODABAR, this.content);
                break;
            case "CODE_39":
                drawGeneralBarCode(canvas, BarcodeFormat.CODE_39, this.content);
                break;
            case "CODE_93":
                drawGeneralBarCode(canvas, BarcodeFormat.CODE_93, this.content);
                break;
            case "EAN_13":
                drawEAN13(canvas, BarcodeUtil.getEAN13Content(this.content));
                break;
        }
    }

    public void setBarcodeColor(int i5) {
        if (this.barcodeColor != i5) {
            this.barcodeColor = i5;
            this.colorType = i5 == -65536 ? 1 : 0;
            invalidate();
        }
    }

    public void setBarcodeType(String str) {
        this.encodeRef = str;
        this.textPosition = 1;
        invalidate();
    }

    public void setBold(boolean z6) {
        this.bold = z6;
        updateTextPaint();
    }

    public void setColorType(int i5) {
        if (this.colorType != i5) {
            this.colorType = i5;
            updateColors();
            invalidate();
        }
    }

    public void setContent(String str) {
        this.content = str;
        requestLayout();
        invalidate();
    }

    public void setDefaultHeight(float f6) {
        this.defaultHeight = f6;
    }

    public void setDefaultWidth(float f6) {
        this.defaultWidth = f6;
    }

    public void setFontType(String str) {
        if (this.fontType.equals(str)) {
            return;
        }
        this.fontType = str;
        if (Integer.parseInt(str) <= 0) {
            updateTextPaint();
        } else {
            final Handler handler = new Handler(Looper.getMainLooper());
            FontDataManager.getInstance().getFontLocalFile(str, String.valueOf(new Random().nextInt()), new h() { // from class: com.appdev.standard.page.printerlabel.widget.BaseBarcodeView.1
                @Override // com.appdev.standard.util.fileDownload.h
                public void onError(String str2, Throwable th) {
                    handler.post(new Runnable() { // from class: com.appdev.standard.page.printerlabel.widget.BaseBarcodeView.1.4
                        @Override // java.lang.Runnable
                        public void run() {
                            p051j0.a.d("BaseBarcodeView", "字体下载失败->" + BaseBarcodeView.this.fontType);
                            w.c();
                            d.show(g.toast_61);
                            BaseBarcodeView.this.updateTextPaint();
                        }
                    });
                }

                @Override // com.appdev.standard.util.fileDownload.h
                public void onExists() {
                    super.onExists();
                    handler.post(new Runnable() { // from class: com.appdev.standard.page.printerlabel.widget.BaseBarcodeView.1.2
                        @Override // java.lang.Runnable
                        public void run() {
                            p051j0.a.d("BaseBarcodeView", "字体已存在");
                            BaseBarcodeView.this.updateTextPaint();
                        }
                    });
                }

                @Override // com.appdev.standard.util.fileDownload.h
                public void onStartShowLoading() {
                    super.onStartShowLoading();
                    handler.post(new Runnable() { // from class: com.appdev.standard.page.printerlabel.widget.BaseBarcodeView.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            p051j0.a.d("BaseBarcodeView", "字体下载开始");
                            w.e();
                            d.show(g.toast_59);
                            BaseBarcodeView.this.updateTextPaint();
                        }
                    });
                }

                @Override // com.appdev.standard.util.fileDownload.h
                public void onSuccess(String str2) {
                    handler.post(new Runnable() { // from class: com.appdev.standard.page.printerlabel.widget.BaseBarcodeView.1.3
                        @Override // java.lang.Runnable
                        public void run() {
                            p051j0.a.d("BaseBarcodeView", "字体下载完成");
                            w.c();
                            d.show(g.toast_60);
                            BaseBarcodeView.this.updateTextPaint();
                        }
                    });
                }
            });
        }
    }

    public void setItalic(boolean z6) {
        this.italic = z6;
        updateTextPaint();
    }

    public void setShowText(int i5) {
        this.textPosition = i5;
        invalidate();
    }

    public void setStrikethrough(boolean z6) {
        this.strikethrough = z6;
        updateTextPaint();
    }

    public void setTextColor(int i5) {
        this.textPaint.setColor(i5);
        this.barcodeColor = i5;
        this.colorType = i5 == -65536 ? 1 : 0;
        invalidate();
    }

    public void setTextSize(float f6) {
        this.fontSize = f6;
        updateTextPaint();
    }

    public void setUnderline(boolean z6) {
        this.underline = z6;
        updateTextPaint();
    }

    public void sethAlignment(int i5) {
        this.hAlignment = i5;
        updateTextPaint();
    }

    public BaseBarcodeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BaseBarcodeView(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        this.TAG = "BaseBarcodeView";
        this.textPaint = null;
        this.textPosition = 1;
        this.content = "12345678";
        this.fontType = "0";
        this.hAlignment = 1;
        this.bold = false;
        this.italic = false;
        this.underline = false;
        this.strikethrough = false;
        this.fontSize = 14.0f;
        this.colorType = 0;
        this.barcodeColor = ViewCompat.MEASURED_STATE_MASK;
        this.defaultWidth = 1.0f;
        this.defaultHeight = 1.0f;
        this.encodeRef = "CODE_128";
        Paint paint = new Paint();
        this.bitmapPaint = paint;
        paint.setAntiAlias(true);
        this.bitmapPaint.setDither(true);
        this.bitmapPaint.setFilterBitmap(true);
        TextPaint textPaint = new TextPaint();
        this.textPaint = textPaint;
        textPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.textPaint.setStyle(Paint.Style.FILL);
        this.textPaint.setFlags(1);
        updateTextPaint();
    }
}
