package com.appdev.standard.page.printerlabel.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.Looper;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.ViewCompat;
import com.appdev.standard.model.TextFontModel;
import com.appdev.standard.page.printerlabel.util.FontDataManager;
import com.appdev.standard.util.fileDownload.h;
import com.orhanobut.hawk.Hawk;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import kotlin.jvm.internal.Y;
import p042h2.d;
import p050j.w;
import p113u.g;
import p134x2.C1849c;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class BaseTextView extends View {
    private final String TAG;
    private int aligment;
    private int baseHeight;
    private int baseWidth;
    private Bitmap bitmap;
    private int colorType;
    private String content;
    private int curDataType;
    private String defaultContent;
    private int direction;
    private String fontId;
    private float fontSize;
    private boolean isBold;
    private boolean isDarkMode;
    private boolean isDeleteLine;
    private boolean isItalic;
    private boolean isTableText;
    private boolean isUnderLine;
    private Layout.Alignment layoutAlignment;
    private boolean lineWrap;
    private float linesSpace;
    private boolean needRecaculate;
    private boolean needRefresh;
    private float realHeight;
    private float realWidth;
    private int scaleHeight;
    private int scaleWidth;
    private String seqContent;
    private String showContent;
    private StaticLayout staticLayout;
    private int staticLayoutOffset;
    private int staticLayoutWidth;
    private TextPaint textPaint;
    private Typeface tf;
    private int typeface;
    private int vAlignment;
    private float wordSpace;
    private float wordWidth;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class ArcData {
        int height;
        Path path;

        public ArcData(Path path, int i5) {
            this.path = path;
            this.height = i5;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class TextLayoutInfo {
        List<TextLayoutLineInfo> line_infos;

        public TextLayoutInfo(List<TextLayoutLineInfo> list) {
            this.line_infos = list;
        }

        public int compareTo(TextLayoutInfo textLayoutInfo) {
            if (this.line_infos.size() > textLayoutInfo.line_infos.size()) {
                return 1;
            }
            if (this.line_infos.size() < textLayoutInfo.line_infos.size()) {
                return -1;
            }
            for (int i5 = 0; i5 < this.line_infos.size(); i5++) {
                if (this.line_infos.get(i5).fontCount < textLayoutInfo.line_infos.get(i5).fontCount) {
                    return 1;
                }
                if (this.line_infos.get(i5).fontCount > textLayoutInfo.line_infos.get(i5).fontCount) {
                    return -1;
                }
            }
            return 0;
        }

        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof TextLayoutInfo)) {
                return false;
            }
            TextLayoutInfo textLayoutInfo = (TextLayoutInfo) obj;
            if (this.line_infos.size() != textLayoutInfo.line_infos.size()) {
                return false;
            }
            for (int i5 = 0; i5 < this.line_infos.size(); i5++) {
                if (this.line_infos.get(i5).fontCount != textLayoutInfo.line_infos.get(i5).fontCount) {
                    return false;
                }
            }
            return true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class TextLayoutLineInfo {
        int fontCount;

        public TextLayoutLineInfo(int i5) {
            this.fontCount = i5;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    @FunctionalInterface
    public interface TextLengthCalculator {
        float calculate(String str);
    }

    public BaseTextView(Context context) {
        this(context, (AttributeSet) null);
    }

    private ArcData createSafeArchPath(int i5, float f6, float f7) {
        Path path = new Path();
        float f8 = i5;
        float f9 = f8 / 3.1415927f;
        float f10 = f8 / 2.0f;
        float f11 = f7 + f9;
        RectF rectF = new RectF(f10 - f9, f11 - f9, f10 + f9, f11 + f9);
        float fSin = 0.0f;
        if (f6 > 0.0f && f6 < f8) {
            fSin = ((float) Math.sin(Math.toRadians((((f8 - f6) / f8) / 2.0f) * 180.0f))) * f9;
        }
        path.addArc(rectF, 180.0f, 180.0f);
        return new ArcData(path, (int) (f11 - fSin));
    }

    private void drawArchCurve(Canvas canvas) {
        String str = this.showContent;
        Paint.Align textAlign = this.textPaint.getTextAlign();
        try {
            Path path = createSafeArchPath(canvas.getWidth(), -1.0f, Math.abs(this.textPaint.getFontMetrics().ascent)).path;
            this.textPaint.setTextAlign(Paint.Align.CENTER);
            canvas.drawTextOnPath(str, path, 0.0f, 0.0f, this.textPaint);
        } finally {
            this.textPaint.setTextAlign(textAlign);
        }
    }

    private void drawHorizontal(Canvas canvas) {
        int i5 = this.aligment;
        if (i5 == 0) {
            this.layoutAlignment = Layout.Alignment.ALIGN_NORMAL;
        } else if (i5 == 1) {
            this.layoutAlignment = Layout.Alignment.ALIGN_CENTER;
        } else if (i5 != 2) {
            this.layoutAlignment = Layout.Alignment.ALIGN_NORMAL;
        } else {
            this.layoutAlignment = Layout.Alignment.ALIGN_OPPOSITE;
        }
        this.staticLayoutWidth = (getWidth() - getPaddingLeft()) - getPaddingRight();
        this.staticLayout = new StaticLayout(this.showContent, this.textPaint, this.staticLayoutWidth, this.layoutAlignment, (C1849c.mm2pxWithScale(this.linesSpace) / this.textPaint.getTextSize()) + 1.0f, 0.0f, false);
        canvas.translate(0.0f, this.staticLayoutOffset);
        int i6 = this.aligment;
        if (i6 == 0) {
            canvas.translate(0.0f, 0.0f);
        } else if (i6 != 1) {
            if (i6 == 2) {
                float textSize = this.isItalic ? this.textPaint.getTextSize() * 0.2126f : 0.0f;
                if (getWidth() > this.staticLayout.getWidth()) {
                    canvas.translate((getWidth() - this.staticLayout.getWidth()) - textSize, 0.0f);
                } else {
                    canvas.translate(-textSize, 0.0f);
                }
            } else if (i6 == 4) {
                if (getWidth() < this.staticLayout.getWidth()) {
                    canvas.scale(getWidth() / this.staticLayout.getWidth(), 1.0f);
                }
                if (getWidth() > this.staticLayout.getWidth()) {
                    canvas.scale(getWidth() / this.staticLayout.getWidth(), 1.0f);
                }
            }
        } else if (getWidth() > this.staticLayout.getWidth()) {
            canvas.translate((getWidth() - this.staticLayout.getWidth()) / 2, 0.0f);
        }
        int i7 = this.vAlignment;
        if (i7 == 1) {
            canvas.translate(0.0f, 0.0f);
        } else if (i7 != 2) {
            if (i7 != 3) {
                if (i7 == 4 && getHeight() > this.staticLayout.getHeight()) {
                    canvas.scale(1.0f, getHeight() / this.staticLayout.getHeight());
                }
            } else if (getHeight() > this.staticLayout.getHeight()) {
                canvas.translate(0.0f, getHeight() - this.staticLayout.getHeight());
            }
        } else if (getHeight() > this.staticLayout.getHeight()) {
            canvas.translate(0.0f, (getHeight() - this.staticLayout.getHeight()) / 2);
        }
        this.staticLayout.draw(canvas);
    }

    private void drawScrollPair(Canvas canvas) {
        String str = this.showContent;
        Paint.FontMetrics fontMetrics = this.textPaint.getFontMetrics();
        float fMm2pxWithScale = (C1849c.mm2pxWithScale(this.linesSpace) / this.textPaint.getTextSize()) + 1.0f + (fontMetrics.descent - fontMetrics.ascent) + fontMetrics.leading;
        float f6 = fontMetrics.descent - fontMetrics.ascent;
        int i5 = this.aligment;
        int paddingLeft = (i5 == 1 || i5 != 2) ? getPaddingLeft() : getPaddingLeft();
        float f7 = paddingLeft;
        float paddingTop = getPaddingTop();
        String[] strArrSplit = str.split("[\n]");
        for (int i6 = 0; i6 < strArrSplit.length; i6++) {
            String str2 = strArrSplit[i6];
            float f8 = f7;
            for (int i7 = 0; i7 < str2.length(); i7++) {
                String strValueOf = String.valueOf(str2.charAt(i7));
                float fMeasureText = this.textPaint.measureText(strValueOf);
                canvas.save();
                float f9 = f6 / 2.0f;
                canvas.translate(f8 + f9, (fMm2pxWithScale / 2.0f) + (i6 * fMm2pxWithScale) + paddingTop);
                canvas.rotate(-90.0f);
                canvas.drawText(strValueOf, (-fMeasureText) / 2.0f, f9, this.textPaint);
                canvas.restore();
                f8 += f6;
            }
        }
    }

    private void drawTextOnPathWithSpacing(Canvas canvas, String str, Path path, float f6, float f7) {
        char c;
        float f8;
        if (str.isEmpty()) {
            return;
        }
        char c6 = 0;
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float length = pathMeasure.getLength();
        int length2 = str.length();
        float[] fArr = new float[length2];
        this.textPaint.getTextWidths(str, fArr);
        float f9 = 0.0f;
        for (int i5 = 0; i5 < length2; i5++) {
            float f10 = fArr[i5];
            f9 += (f10 * f7) + f10;
        }
        float f11 = 2.0f;
        float f12 = (length - f9) / 2.0f;
        int i6 = 0;
        while (i6 < str.length()) {
            int i7 = i6 + 1;
            String strSubstring = str.substring(i6, i7);
            float f13 = fArr[i6];
            float[] fArr2 = new float[2];
            float[] fArr3 = new float[2];
            if (pathMeasure.getPosTan((f13 / f11) + f12, fArr2, fArr3)) {
                c = c6;
                float degrees = (float) Math.toDegrees(Math.atan2(fArr3[1], fArr3[c]));
                canvas.save();
                canvas.translate(fArr2[c], fArr2[1]);
                canvas.rotate(degrees);
                canvas.drawText(strSubstring, 0.0f, f6, this.textPaint);
                canvas.restore();
                f8 = (f13 * f7) + f13 + f12;
            } else {
                c = c6;
                f8 = f12;
            }
            f12 = f8;
            i6 = i7;
            fArr = fArr;
            c6 = c;
            f11 = 2.0f;
        }
    }

    private void drawVerticalPair(Canvas canvas) {
        float width = getWidth() - getPaddingRight();
        float paddingTop = getPaddingTop();
        Paint.FontMetrics fontMetrics = this.textPaint.getFontMetrics();
        float fMm2pxWithScale = (C1849c.mm2pxWithScale(this.linesSpace) / this.textPaint.getTextSize()) + 1.0f + (fontMetrics.descent - fontMetrics.ascent) + fontMetrics.leading;
        float f6 = fontMetrics.descent - fontMetrics.ascent;
        String[] strArrSplit = this.showContent.split("[\n]");
        for (int i5 = 0; i5 < strArrSplit.length; i5++) {
            String str = strArrSplit[i5];
            float f7 = paddingTop;
            for (int i6 = 0; i6 < str.length(); i6++) {
                String strValueOf = String.valueOf(str.charAt(i6));
                float fMeasureText = this.textPaint.measureText(strValueOf);
                canvas.save();
                canvas.translate((width - (i5 * fMm2pxWithScale)) - (fMm2pxWithScale / 2.0f), f7);
                canvas.drawText(strValueOf, (-fMeasureText) / 2.0f, -fontMetrics.ascent, this.textPaint);
                canvas.restore();
                f7 += f6;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ float lambda$measureHorizontal$0(String str) {
        return this.textPaint.measureText(str);
    }

    private void measureArchCurve(int i5, int i6, int i7, int i8) {
        int iMax;
        int iMin;
        String str = Y.f(this.content) ? this.defaultContent : this.content;
        if (this.curDataType == 1) {
            str = Y.f(this.seqContent) ? this.defaultContent : this.seqContent;
        }
        float fMeasureText = this.textPaint.measureText(str);
        float fAbs = Math.abs(this.textPaint.getFontMetrics().ascent);
        if (i5 != 1073741824 || i6 <= 0) {
            int i9 = (int) fMeasureText;
            int paddingRight = getPaddingRight() + getPaddingLeft() + i9;
            if (i5 != Integer.MIN_VALUE || i6 <= 0) {
                iMax = i9;
                iMin = paddingRight;
            } else {
                iMin = Math.min(paddingRight, getPaddingRight() + getPaddingLeft() + i6);
                iMax = i9;
            }
        } else {
            iMax = Math.max(i6, (int) fMeasureText);
            iMin = getPaddingRight() + getPaddingLeft() + iMax;
        }
        ArcData arcDataCreateSafeArchPath = createSafeArchPath(iMax, fMeasureText, fAbs);
        this.showContent = str;
        int paddingBottom = getPaddingBottom() + getPaddingTop() + arcDataCreateSafeArchPath.height;
        this.baseWidth = iMin;
        this.baseHeight = paddingBottom;
        setMeasuredDimension(iMin, paddingBottom);
    }

    private void measureHorizontal(int i5, int i6) {
        int paddingRight;
        int i7;
        boolean z6;
        int mode = View.MeasureSpec.getMode(i5);
        int size = View.MeasureSpec.getSize(i5);
        float f6 = 0.0f;
        if (mode == 1073741824 && ((i7 = this.curDataType) == 0 || i7 == 2)) {
            paddingRight = getPaddingRight() + getPaddingLeft() + size;
            float f7 = this.realWidth;
            if (f7 != 0.0f && this.needRecaculate) {
                float textSize = this.textPaint.getTextSize();
                this.textPaint.setTextSize((this.fontSize / 10.0f) * 8.0f);
                String formatedContent = getFormatedContent(((int) (f7 * 8.0f)) + 3, new a(this, 0));
                String[] strArrSplit = formatedContent.split("[\n]");
                for (int i8 = 0; i8 < 50; i8++) {
                    this.textPaint.setTextSize(textSize);
                    int length = strArrSplit.length;
                    int i9 = 0;
                    while (true) {
                        if (i9 >= length) {
                            z6 = true;
                            break;
                        }
                        String str = strArrSplit[i9];
                        float fMeasureText = this.textPaint.measureText(str);
                        if (str.length() != 1) {
                            if (fMeasureText >= size) {
                                textSize -= 0.1f;
                                z6 = false;
                                break;
                            }
                        } else if (fMeasureText >= this.wordWidth) {
                            this.wordWidth = fMeasureText;
                        }
                        i9++;
                    }
                    if (z6) {
                        break;
                    }
                }
                this.showContent = formatedContent;
                this.needRecaculate = false;
            }
            if (this.wordWidth > size) {
                paddingRight = getPaddingRight() + getPaddingLeft() + ((int) this.wordWidth);
            }
        } else {
            String str2 = Y.f(this.content) ? this.defaultContent : this.content;
            if (this.curDataType == 1) {
                str2 = Y.f(this.seqContent) ? this.defaultContent : this.seqContent;
            }
            for (String str3 : str2.split("[\n]")) {
                float fMeasureText2 = this.textPaint.measureText(str3);
                if (fMeasureText2 > f6) {
                    f6 = fMeasureText2;
                }
            }
            this.showContent = str2;
            paddingRight = (int) (getPaddingRight() + getPaddingLeft() + f6);
        }
        int paddingLeft = (paddingRight - getPaddingLeft()) - getPaddingRight();
        this.layoutAlignment = Layout.Alignment.ALIGN_NORMAL;
        this.staticLayoutWidth = paddingLeft;
        this.staticLayout = new StaticLayout(this.showContent, this.textPaint, this.staticLayoutWidth, this.layoutAlignment, (C1849c.mm2pxWithScale(this.linesSpace) / this.textPaint.getTextSize()) + 1.0f, 0.0f, false);
        if (this.isTableText || this.isBold) {
            this.staticLayoutOffset = 0;
        } else {
            this.staticLayoutOffset = Math.round(this.textPaint.getTextSize() * 0.13f);
        }
        int mode2 = View.MeasureSpec.getMode(i6);
        int size2 = View.MeasureSpec.getSize(i6);
        int paddingBottom = (mode2 == 1073741824 && size2 != 0 && this.curDataType == 0) ? getPaddingBottom() + getPaddingTop() + size2 : (int) (getPaddingBottom() + getPaddingTop() + (this.staticLayoutOffset * 2) + this.staticLayout.getHeight());
        this.baseWidth = paddingRight;
        this.baseHeight = paddingBottom;
        setMeasuredDimension(paddingRight, paddingBottom);
    }

    private void measureScrollPair(int i5, int i6) {
        int paddingRight;
        int i7;
        boolean z6;
        int mode = View.MeasureSpec.getMode(i5);
        int size = View.MeasureSpec.getSize(i5);
        float f6 = 0.0f;
        if (mode == 1073741824 && ((i7 = this.curDataType) == 0 || i7 == 2)) {
            paddingRight = getPaddingRight() + getPaddingLeft() + size;
            float f7 = this.realWidth;
            if (f7 != 0.0f && this.needRecaculate) {
                float textSize = this.textPaint.getTextSize();
                this.textPaint.setTextSize((this.fontSize / 10.0f) * 8.0f);
                String formatedContent = getFormatedContent(((int) (f7 * 8.0f)) + 3, new a(this, 2));
                String[] strArrSplit = formatedContent.split("[\n]");
                for (int i8 = 0; i8 < 50; i8++) {
                    this.textPaint.setTextSize(textSize);
                    int length = strArrSplit.length;
                    int i9 = 0;
                    while (true) {
                        if (i9 >= length) {
                            z6 = true;
                            break;
                        }
                        String str = strArrSplit[i9];
                        float fLambda$measureScrollPair$1 = lambda$measureScrollPair$1(str);
                        if (str.length() != 1) {
                            if (fLambda$measureScrollPair$1 >= size) {
                                textSize -= 0.1f;
                                z6 = false;
                                break;
                            }
                        } else if (fLambda$measureScrollPair$1 >= this.wordWidth) {
                            this.wordWidth = fLambda$measureScrollPair$1;
                        }
                        i9++;
                    }
                    if (z6) {
                        break;
                    }
                }
                this.showContent = formatedContent;
                this.needRecaculate = false;
            }
            if (this.wordWidth > size) {
                paddingRight = getPaddingRight() + getPaddingLeft() + ((int) this.wordWidth);
            }
        } else {
            String str2 = Y.f(this.content) ? this.defaultContent : this.content;
            if (this.curDataType == 1) {
                str2 = Y.f(this.seqContent) ? this.defaultContent : this.seqContent;
            }
            for (String str3 : str2.split("[\n]")) {
                float fLambda$measureScrollPair$2 = lambda$measureScrollPair$1(str3);
                if (fLambda$measureScrollPair$2 > f6) {
                    f6 = fLambda$measureScrollPair$2;
                }
            }
            this.showContent = str2;
            paddingRight = (int) (getPaddingRight() + getPaddingLeft() + f6);
        }
        int paddingLeft = (paddingRight - getPaddingLeft()) - getPaddingRight();
        this.layoutAlignment = Layout.Alignment.ALIGN_NORMAL;
        this.staticLayoutWidth = paddingLeft;
        int length2 = this.showContent.split("[\n]").length;
        Paint.FontMetrics fontMetrics = this.textPaint.getFontMetrics();
        float fMm2pxWithScale = (C1849c.mm2pxWithScale(this.linesSpace) / this.textPaint.getTextSize()) + 1.0f + (fontMetrics.descent - fontMetrics.ascent) + fontMetrics.leading;
        if (this.isTableText || this.isBold) {
            this.staticLayoutOffset = 0;
        } else {
            this.staticLayoutOffset = Math.round(this.textPaint.getTextSize() * 0.13f);
        }
        int mode2 = View.MeasureSpec.getMode(i6);
        int size2 = View.MeasureSpec.getSize(i6);
        int paddingBottom = (mode2 == 1073741824 && size2 != 0 && this.curDataType == 0) ? getPaddingBottom() + getPaddingTop() + size2 : (int) (getPaddingBottom() + getPaddingTop() + ((((fMm2pxWithScale * length2) + (this.staticLayoutOffset * 2)) - fontMetrics.leading) - ((C1849c.mm2pxWithScale(this.linesSpace) / this.textPaint.getTextSize()) + 1.0f)));
        this.baseWidth = paddingRight;
        this.baseHeight = paddingBottom;
        setMeasuredDimension(paddingRight, paddingBottom);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: measureScrollText, reason: merged with bridge method [inline-methods] */
    public float lambda$measureScrollPair$1(String str) {
        Paint.FontMetrics fontMetrics = this.textPaint.getFontMetrics();
        return (fontMetrics.descent - fontMetrics.ascent) * str.length();
    }

    private void measureVerticalPair(int i5, int i6) {
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        boolean z6;
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        int mode = View.MeasureSpec.getMode(i5);
        int size = View.MeasureSpec.getSize(i5);
        int mode2 = View.MeasureSpec.getMode(i6);
        int size2 = View.MeasureSpec.getSize(i6);
        float textSize = this.textPaint.getTextSize();
        float fMax = 0.0f;
        if (mode2 == 1073741824 && ((i11 = this.curDataType) == 0 || i11 == 2)) {
            i9 = paddingBottom + size2;
            float f6 = this.realHeight;
            if (f6 == 0.0f || !this.needRecaculate || size2 == 0) {
                i7 = size;
                i8 = 0;
            } else {
                this.textPaint.setTextSize((this.fontSize / 10.0f) * 8.0f);
                String formatedContent = getFormatedContent(((int) (f6 * 8.0f)) + 3, new a(this, 1));
                String[] strArrSplit = formatedContent.split("\n");
                int i12 = 0;
                while (true) {
                    if (i12 >= 50) {
                        i7 = size;
                        break;
                    }
                    this.textPaint.setTextSize(textSize);
                    int length = strArrSplit.length;
                    int i13 = 0;
                    while (true) {
                        if (i13 >= length) {
                            i7 = size;
                            z6 = true;
                            break;
                        }
                        String str = strArrSplit[i13];
                        i7 = size;
                        float fLambda$measureScrollPair$1 = lambda$measureScrollPair$1(str);
                        if (str.length() != 1) {
                            if (fLambda$measureScrollPair$1 >= size2) {
                                textSize -= 0.1f;
                                z6 = false;
                                break;
                            }
                        } else {
                            this.wordWidth = Math.max(this.wordWidth, fLambda$measureScrollPair$1);
                        }
                        i13++;
                        size = i7;
                    }
                    if (z6) {
                        break;
                    }
                    i12++;
                    size = i7;
                }
                this.showContent = formatedContent;
                i8 = 0;
                this.needRecaculate = false;
            }
            float f7 = this.wordWidth;
            if (f7 > size2) {
                i9 = ((int) f7) + paddingBottom;
            }
        } else {
            i7 = size;
            i8 = 0;
            String str2 = this.curDataType == 1 ? Y.f(this.seqContent) ? this.defaultContent : this.seqContent : Y.f(this.content) ? this.defaultContent : this.content;
            for (String str3 : str2.split("\n")) {
                fMax = Math.max(fMax, lambda$measureScrollPair$1(str3));
            }
            this.showContent = str2;
            i9 = (int) (paddingBottom + fMax);
        }
        if (mode == 1073741824 && i7 != 0 && this.curDataType == 0) {
            i10 = paddingRight + i7;
        } else {
            Paint.FontMetrics fontMetrics = this.textPaint.getFontMetrics();
            float fMm2pxWithScale = (C1849c.mm2pxWithScale(this.linesSpace) / textSize) + 1.0f;
            float f8 = (fontMetrics.descent - fontMetrics.ascent) + fontMetrics.leading + fMm2pxWithScale;
            int length2 = this.showContent.split("\n").length;
            this.layoutAlignment = Layout.Alignment.ALIGN_NORMAL;
            int iRound = (this.isTableText || this.isBold) ? i8 : Math.round(textSize * 0.13f);
            this.staticLayoutOffset = iRound;
            i10 = (int) (paddingRight + ((((f8 * length2) + (iRound * 2)) - fontMetrics.leading) - fMm2pxWithScale));
        }
        this.baseWidth = i10;
        this.baseHeight = i9;
        setMeasuredDimension(i10, i9);
    }

    private void updateTextColor() {
        this.textPaint.setColor(this.colorType == 1 ? SupportMenu.CATEGORY_MASK : ViewCompat.MEASURED_STATE_MASK);
    }

    private void updateTextPaint(float f6) {
        updateTextPaint(f6, false);
    }

    public int getColorType() {
        return this.colorType;
    }

    public String getContent() {
        return this.content;
    }

    public int getCurDataType() {
        return this.curDataType;
    }

    public int getDirection() {
        return this.direction;
    }

    public String getFontType() {
        return this.fontId;
    }

    public String getFormatedContent(int i5, TextLengthCalculator textLengthCalculator) {
        String str = Y.f(this.content) ? this.defaultContent : this.content;
        if (this.curDataType == 1) {
            str = Y.f(this.seqContent) ? this.defaultContent : this.seqContent;
        }
        if (i5 < 0) {
            i5 = getWidth();
        }
        StringBuilder sb = new StringBuilder();
        String[] strArrSplit = str.split("[\n]");
        new ArrayList();
        int length = strArrSplit.length;
        for (int i6 = 0; i6 < length; i6++) {
            String strSubstring = strArrSplit[i6];
            if (strSubstring.isEmpty()) {
                if (sb.length() > 0) {
                    sb.append("\n");
                }
                sb.append("\n");
            } else if (strSubstring.length() == 1) {
                if (sb.length() > 0) {
                    sb.append("\n");
                }
                sb.append(strSubstring);
            } else {
                float fCalculate = textLengthCalculator.calculate(strSubstring);
                float f6 = i5;
                if (fCalculate < f6) {
                    if (sb.length() > 0) {
                        sb.append("\n");
                    }
                    sb.append(strSubstring);
                } else {
                    while (!strSubstring.isEmpty()) {
                        String strG = strSubstring;
                        while (fCalculate > f6 && strG.length() > 1) {
                            strG = androidx.collection.a.g(1, 0, strG);
                            fCalculate = textLengthCalculator.calculate(strG);
                        }
                        if (sb.length() > 0) {
                            sb.append("\n");
                        }
                        sb.append(strG);
                        strSubstring = strSubstring.substring(strG.length());
                        fCalculate = textLengthCalculator.calculate(strSubstring);
                    }
                }
            }
        }
        return sb.toString();
    }

    public float getLinesSpace() {
        return this.linesSpace;
    }

    public String getSaveContent() {
        if (this.curDataType == 0) {
            return Y.f(this.content) ? this.defaultContent : this.content;
        }
        return Y.f(this.seqContent) ? this.defaultContent : this.seqContent;
    }

    public String getSeqContent() {
        return this.seqContent;
    }

    public StaticLayout getStaticLayout() {
        return this.staticLayout;
    }

    public TextLayoutInfo getTextLayoutInfo(int i5) {
        String str = Y.f(this.content) ? this.defaultContent : this.content;
        if (this.curDataType == 1) {
            str = Y.f(this.seqContent) ? this.defaultContent : this.seqContent;
        }
        if (i5 < 0) {
            i5 = getWidth();
        }
        String[] strArrSplit = str.split("[\n]");
        ArrayList arrayList = new ArrayList();
        int length = strArrSplit.length;
        for (int i6 = 0; i6 < length; i6++) {
            String strSubstring = strArrSplit[i6];
            if (!strSubstring.isEmpty()) {
                if (strSubstring.length() == 1) {
                    arrayList.add(new TextLayoutLineInfo(1));
                } else {
                    float fMeasureText = this.textPaint.measureText(strSubstring);
                    float f6 = i5;
                    if (fMeasureText < f6) {
                        arrayList.add(new TextLayoutLineInfo(strSubstring.length()));
                    } else {
                        while (!strSubstring.isEmpty()) {
                            String strG = strSubstring;
                            while (fMeasureText > f6 && strG.length() > 1) {
                                strG = androidx.collection.a.g(1, 0, strG);
                                fMeasureText = this.textPaint.measureText(strG);
                            }
                            arrayList.add(new TextLayoutLineInfo(strG.length()));
                            strSubstring = strSubstring.substring(strG.length());
                            fMeasureText = this.textPaint.measureText(strSubstring);
                        }
                    }
                }
            }
        }
        return new TextLayoutInfo(arrayList);
    }

    public float getTextSize() {
        return this.fontSize;
    }

    public float getWordSpace() {
        return this.wordSpace;
    }

    public int gethAlignment() {
        return this.aligment;
    }

    public int getvAlignment() {
        return this.vAlignment;
    }

    public boolean isBold() {
        return this.isBold;
    }

    public boolean isDarkMode() {
        return this.isDarkMode;
    }

    public boolean isItalic() {
        return this.isItalic;
    }

    public boolean isLineWrap() {
        return this.lineWrap;
    }

    public boolean isStrikethrough() {
        return this.isDeleteLine;
    }

    public boolean isUnderline() {
        return this.isUnderLine;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.bitmap == null) {
            this.bitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas2 = new Canvas(this.bitmap);
            if (this.isDarkMode) {
                Paint paint = new Paint();
                paint.setColor(ViewCompat.MEASURED_STATE_MASK);
                paint.setStyle(Paint.Style.FILL);
                canvas2.drawRect(0.0f, 0.0f, getWidth(), getHeight(), paint);
                this.textPaint.setColor(-1);
            } else {
                updateTextColor();
            }
            int i5 = this.direction;
            if (i5 == 1) {
                drawScrollPair(canvas2);
            } else if (i5 == 2) {
                drawVerticalPair(canvas2);
            } else if (i5 != 3) {
                drawHorizontal(canvas2);
            } else {
                drawArchCurve(canvas2);
            }
        }
        try {
            canvas.drawBitmap(this.bitmap, new Rect(0, 0, this.bitmap.getWidth(), this.bitmap.getHeight()), new Rect(0, 0, this.baseWidth, this.baseHeight), (Paint) null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.view.View
    public void onMeasure(int i5, int i6) {
        Bitmap bitmap;
        if (!this.needRefresh && (bitmap = this.bitmap) != null && ((double) bitmap.getHeight()) * 2.5d >= this.scaleHeight) {
            double width = ((double) this.bitmap.getWidth()) * 2.5d;
            int i7 = this.scaleWidth;
            if (width >= i7) {
                this.baseWidth = i7;
                int i8 = this.scaleHeight;
                this.baseHeight = i8;
                setMeasuredDimension(i7, i8);
                return;
            }
        }
        this.bitmap = null;
        int mode = View.MeasureSpec.getMode(i5);
        int size = View.MeasureSpec.getSize(i5);
        int mode2 = View.MeasureSpec.getMode(i6);
        int size2 = View.MeasureSpec.getSize(i6);
        int i9 = this.direction;
        if (i9 == 1) {
            measureScrollPair(i5, i6);
            return;
        }
        if (i9 == 2) {
            measureVerticalPair(i5, i6);
        } else if (i9 != 3) {
            measureHorizontal(i5, i6);
        } else {
            measureArchCurve(mode, size, mode2, size2);
        }
    }

    public void scale(int i5, int i6) {
        this.needRefresh = false;
        this.scaleWidth = i5;
        this.scaleHeight = i6;
        this.textPaint.setTextSize(C1849c.getScale() * (this.fontSize / 10.0f) * C1849c.getRatio());
        this.needRecaculate = true;
    }

    public void setBold(boolean z6) {
        if (this.isBold != z6) {
            this.isBold = z6;
            this.needRecaculate = true;
            updateTextPaint(0.0f);
        }
    }

    public void setColorType(int i5) {
        if (this.colorType != i5) {
            this.colorType = i5;
            updateTextColor();
            invalidate();
        }
    }

    public void setContent(String str) {
        if (this.content.equals(str)) {
            return;
        }
        this.content = str;
        this.seqContent = str;
        this.showContent = str;
        requestLayout();
        invalidate();
        this.needRefresh = true;
        this.needRecaculate = true;
    }

    public void setCurDataType(int i5) {
        this.curDataType = i5;
        this.needRefresh = true;
    }

    public void setDarkMode(boolean z6) {
        if (this.isDarkMode != z6) {
            this.isDarkMode = z6;
            updateTextPaint(0.0f);
            invalidate();
        }
    }

    public void setDefaultContent(String str) {
        this.defaultContent = str;
        this.showContent = str;
    }

    public void setDirection(int i5) {
        if (this.direction != i5) {
            this.direction = i5;
            requestLayout();
            invalidate();
            this.needRefresh = true;
            this.needRecaculate = true;
        }
    }

    public void setFontType(String str) {
        if (this.fontId.equals(str)) {
            return;
        }
        this.needRefresh = true;
        this.needRecaculate = true;
        this.fontId = str;
        if (!str.startsWith("custom_")) {
            try {
                if (Integer.parseInt(str) <= 0) {
                    updateTextPaint(0.0f, true);
                    return;
                } else {
                    final Handler handler = new Handler(Looper.getMainLooper());
                    FontDataManager.getInstance().getFontLocalFile(str, String.valueOf(new Random().nextInt()), new h() { // from class: com.appdev.standard.page.printerlabel.widget.BaseTextView.1
                        @Override // com.appdev.standard.util.fileDownload.h
                        public void onError(String str2, Throwable th) {
                            handler.post(new Runnable() { // from class: com.appdev.standard.page.printerlabel.widget.BaseTextView.1.4
                                @Override // java.lang.Runnable
                                public void run() {
                                    p051j0.a.d("BaseTextView", "字体下载失败->" + BaseTextView.this.fontId);
                                    w.c();
                                    d.show(g.toast_61);
                                    BaseTextView.this.updateTextPaint(0.0f, true);
                                }
                            });
                        }

                        @Override // com.appdev.standard.util.fileDownload.h
                        public void onExists() {
                            super.onExists();
                            handler.post(new Runnable() { // from class: com.appdev.standard.page.printerlabel.widget.BaseTextView.1.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    p051j0.a.d("BaseTextView", "字体已存在");
                                    BaseTextView.this.updateTextPaint(0.0f, true);
                                }
                            });
                        }

                        @Override // com.appdev.standard.util.fileDownload.h
                        public void onStartShowLoading() {
                            super.onStartShowLoading();
                            handler.post(new Runnable() { // from class: com.appdev.standard.page.printerlabel.widget.BaseTextView.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    p051j0.a.d("BaseTextView", "字体下载开始");
                                    w.e();
                                    d.show(g.toast_59);
                                    BaseTextView.this.updateTextPaint(0.0f, true);
                                }
                            });
                        }

                        @Override // com.appdev.standard.util.fileDownload.h
                        public void onSuccess(String str2) {
                            handler.post(new Runnable() { // from class: com.appdev.standard.page.printerlabel.widget.BaseTextView.1.3
                                @Override // java.lang.Runnable
                                public void run() {
                                    p051j0.a.d("BaseTextView", "字体下载完成");
                                    w.c();
                                    d.show(g.toast_60);
                                    BaseTextView.this.updateTextPaint(0.0f, true);
                                }
                            });
                        }
                    });
                    return;
                }
            } catch (NumberFormatException unused) {
                p051j0.a.d("BaseTextView", "字体ID格式错误: ".concat(str));
                updateTextPaint(0.0f, true);
                return;
            }
        }
        List<TextFontModel> list = (List) Hawk.get("imported_fonts", null);
        if (list != null) {
            for (TextFontModel textFontModel : list) {
                if (textFontModel.getFontlibId().equals(str) && textFontModel.getLocalFilePath() != null) {
                    try {
                        File file = new File(textFontModel.getLocalFilePath());
                        if (file.exists()) {
                            this.tf = Typeface.createFromFile(file);
                            updateTextPaint(0.0f, false);
                            return;
                        }
                        continue;
                    } catch (Exception e) {
                        p051j0.a.d("BaseTextView", "加载自定义字体失败: " + e.getMessage());
                    }
                }
            }
        }
        this.tf = Typeface.createFromFile("/system/fonts/Roboto-Regular.ttf");
        updateTextPaint(0.0f, false);
    }

    public void setItalic(boolean z6) {
        if (this.isItalic != z6) {
            this.isItalic = z6;
            this.needRecaculate = true;
            updateTextPaint(0.0f);
        }
    }

    public void setLineWrap(boolean z6) {
        if (this.lineWrap != z6) {
            this.lineWrap = z6;
            invalidate();
        }
    }

    public void setLinesSpace(float f6) {
        if (this.linesSpace != f6) {
            this.linesSpace = f6;
            requestLayout();
            invalidate();
            this.needRefresh = true;
            this.needRecaculate = true;
        }
    }

    public void setNeedRefresh() {
        this.needRefresh = true;
    }

    public void setRealHeight(float f6) {
        if (this.realHeight == f6) {
            return;
        }
        this.needRecaculate = true;
        this.realHeight = f6;
    }

    public void setRealWidth(float f6) {
        if (this.realWidth == f6) {
            return;
        }
        this.needRecaculate = true;
        this.realWidth = f6;
    }

    public void setSeqContent(String str) {
        if (this.seqContent.equals(str)) {
            return;
        }
        this.content = str;
        this.seqContent = str;
        this.showContent = str;
        requestLayout();
        invalidate();
        this.needRefresh = true;
        this.needRecaculate = true;
    }

    public void setStrikethrough(boolean z6) {
        if (this.isDeleteLine != z6) {
            this.isDeleteLine = z6;
            this.needRecaculate = true;
            updateTextPaint(0.0f);
        }
    }

    public void setTextColor(int i5) {
        this.textPaint.setColor(i5);
        if (i5 == -65536) {
            this.colorType = 1;
        } else {
            this.colorType = 0;
        }
        invalidate();
    }

    public void setTextInfo(String str, float f6, float f7, float f8, boolean z6, boolean z7, boolean z8, boolean z9, int i5, String str2, int i6) {
        boolean z10;
        if (this.content.equals(str)) {
            z10 = false;
        } else {
            this.content = str;
            z10 = true;
        }
        if (this.fontSize != f6) {
            this.fontSize = f6;
            z10 = true;
        }
        if (this.wordSpace != f7) {
            this.wordSpace = f7;
            z10 = true;
        }
        if (this.linesSpace != f8) {
            this.linesSpace = f8;
            z10 = true;
        }
        if (this.isBold != z6) {
            this.isBold = z6;
            z10 = true;
        }
        if (this.isItalic != z7) {
            this.isItalic = z7;
            z10 = true;
        }
        if (this.isUnderLine != z8) {
            this.isUnderLine = z8;
            z10 = true;
        }
        if (this.isDeleteLine != z9) {
            this.isDeleteLine = z9;
            z10 = true;
        }
        if (this.aligment != i5) {
            this.aligment = i5;
            z10 = true;
        }
        if (!this.fontId.equals(str2)) {
            setFontType(str2);
            z10 = true;
        }
        if (this.direction != i6) {
            this.direction = i6;
            z10 = true;
        }
        this.needRefresh = true;
        this.needRecaculate = true;
        requestLayout();
        invalidate();
        if (z10 && this.fontId.equals(str2)) {
            updateTextPaint(0.0f);
        }
    }

    public void setTextSize(float f6) {
        if (this.fontSize != f6) {
            this.fontSize = f6;
            this.needRecaculate = true;
            updateTextPaint(0.0f);
        }
    }

    public void setUnderline(boolean z6) {
        if (this.isUnderLine != z6) {
            this.isUnderLine = z6;
            this.needRecaculate = true;
            updateTextPaint(0.0f);
        }
    }

    public void setWordSpace(float f6) {
        if (this.wordSpace != f6) {
            this.wordSpace = f6;
            updateTextPaint(0.0f);
            this.needRecaculate = true;
        }
    }

    public void sethAlignment(int i5) {
        if (this.aligment != i5) {
            this.aligment = i5;
            requestLayout();
            invalidate();
            this.needRefresh = true;
            this.needRecaculate = true;
        }
    }

    public void setvAlignment(int i5) {
        this.vAlignment = i5;
        requestLayout();
        invalidate();
        this.needRefresh = true;
        this.needRecaculate = true;
    }

    public BaseTextView(Context context, boolean z6) {
        this(context, (AttributeSet) null);
        this.isTableText = z6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTextPaint(float f6, boolean z6) {
        this.typeface = 0;
        boolean z7 = this.isBold;
        if (z7 && this.isItalic) {
            this.typeface = 3;
        } else if (z7) {
            this.typeface = 1;
        } else if (this.isItalic) {
            this.typeface = 2;
        }
        this.textPaint.setTextSize((C1849c.getScale() * ((this.fontSize / 10.0f) * C1849c.getRatio())) - f6);
        if (z6) {
            if ("0".equals(this.fontId)) {
                this.tf = Typeface.createFromFile("/system/fonts/Roboto-Regular.ttf");
            } else if ("-10001".equals(this.fontId)) {
                this.tf = Typeface.createFromAsset(getContext().getAssets(), "zt_aLiJianKangTi.ttf");
            } else if ("-10002".equals(this.fontId)) {
                this.tf = Typeface.createFromAsset(getContext().getAssets(), "zt_cangErYuYangTi.ttf");
            } else if ("-10003".equals(this.fontId)) {
                this.tf = Typeface.createFromAsset(getContext().getAssets(), "zt_douYuZhuiGuangTi.ttf");
            } else if ("-10004".equals(this.fontId)) {
                this.tf = Typeface.createFromAsset(getContext().getAssets(), "zt_fangZhengHeiTi.ttf");
            } else if ("-10005".equals(this.fontId)) {
                this.tf = Typeface.createFromAsset(getContext().getAssets(), "zt_maoKenZhuYuanTi.ttf");
            } else if ("-10006".equals(this.fontId)) {
                this.tf = Typeface.createFromAsset(getContext().getAssets(), "zt_mengYuanFangSong.ttf");
            } else {
                File fontLocalFile = FontDataManager.getInstance().getFontLocalFile(this.fontId);
                if (fontLocalFile == null || !fontLocalFile.exists()) {
                    this.tf = Typeface.createFromFile("/system/fonts/Roboto-Regular.ttf");
                } else {
                    String lowerCase = fontLocalFile.getName().toLowerCase();
                    if (lowerCase.endsWith(".ttf") || lowerCase.endsWith(".otf")) {
                        try {
                            this.tf = Typeface.createFromFile(fontLocalFile);
                        } catch (Exception e) {
                            p051j0.a.e("BaseTextView", "加载字体失败: " + fontLocalFile.getAbsolutePath(), e);
                            this.tf = Typeface.createFromFile("/system/fonts/Roboto-Regular.ttf");
                        }
                    } else {
                        p051j0.a.d("BaseTextView", "不支持的字体文件格式: ".concat(lowerCase));
                        this.tf = Typeface.createFromFile("/system/fonts/Roboto-Regular.ttf");
                    }
                }
            }
        }
        this.textPaint.setTypeface(Typeface.create(this.tf, this.typeface));
        int i5 = this.isUnderLine ? 9 : 1;
        if (this.isDeleteLine) {
            i5 |= 16;
        }
        this.textPaint.setFlags(i5);
        this.textPaint.setLetterSpacing(C1849c.mm2pxWithScale(this.wordSpace) / this.textPaint.getTextSize());
        this.needRefresh = true;
    }

    public BaseTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BaseTextView(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        this.TAG = "BaseTextView";
        this.textPaint = null;
        this.content = "";
        this.seqContent = "";
        this.curDataType = 0;
        this.defaultContent = "";
        this.wordSpace = 0.0f;
        this.linesSpace = 0.0f;
        this.lineWrap = true;
        this.fontId = "0";
        this.isBold = false;
        this.isItalic = false;
        this.isUnderLine = false;
        this.isDeleteLine = false;
        this.fontSize = 40.0f;
        this.realWidth = 0.0f;
        this.realHeight = 0.0f;
        this.needRefresh = true;
        this.needRecaculate = true;
        this.baseWidth = 0;
        this.baseHeight = 0;
        this.scaleWidth = -1;
        this.scaleHeight = -1;
        this.bitmap = null;
        this.showContent = "";
        this.wordWidth = 0.0f;
        this.aligment = 0;
        this.vAlignment = 2;
        this.direction = 0;
        this.colorType = 0;
        this.isTableText = false;
        this.isDarkMode = false;
        this.staticLayout = null;
        this.staticLayoutOffset = 0;
        this.staticLayoutWidth = 0;
        this.layoutAlignment = null;
        this.typeface = 0;
        this.tf = Typeface.createFromFile("/system/fonts/Roboto-Regular.ttf");
        TextPaint textPaint = new TextPaint();
        this.textPaint = textPaint;
        textPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.textPaint.setStyle(Paint.Style.FILL);
        this.textPaint.setFlags(1);
        String string = getResources().getString(g.hint_20);
        this.defaultContent = string;
        this.showContent = string;
        updateTextPaint(0.0f);
    }

    @Override // android.view.View
    public void onLayout(boolean z6, int i5, int i6, int i7, int i8) {
    }
}
