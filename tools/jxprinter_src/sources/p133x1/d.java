package p133x1;

import A1.c;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.text.StaticLayout;
import android.text.TextPaint;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.E;
import p145z1.a;
import p145z1.b;
import p145z1.e;
import p145z1.f;
import p145z1.j;
import p145z1.k;
import p145z1.l;
import p145z1.m;
import p145z1.n;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class d {
    private Bitmap bitmap;

    public d(Bitmap bitmap) {
        E.f(bitmap, "bitmap");
        this.bitmap = bitmap;
    }

    public final void a(OutputStream outputStream, f fVar) throws IllegalAccessException, IOException, InvocationTargetException {
        try {
            int i5 = fVar.f9106a;
            int i6 = fVar.b;
            if (i5 == 0) {
                this.bitmap.compress(Bitmap.CompressFormat.PNG, i6, outputStream);
            } else {
                this.bitmap.compress(Bitmap.CompressFormat.JPEG, i6, outputStream);
            }
            L3.d.closeFinally(outputStream, null);
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                L3.d.closeFinally(outputStream, th);
                throw th2;
            }
        }
    }

    public final void handle(List<? extends k> options) {
        Number numberValueOf;
        E.f(options, "options");
        Iterator<? extends k> it = options.iterator();
        while (it.hasNext()) {
            k next = it.next();
            if (next instanceof p145z1.d) {
                Bitmap bitmap = this.bitmap;
                Bitmap bitmapCreateNewBitmap = b.createNewBitmap(bitmap, bitmap.getWidth(), this.bitmap.getHeight());
                Canvas canvas = new Canvas(bitmapCreateNewBitmap);
                Paint paint = new Paint();
                paint.setColorFilter(new ColorMatrixColorFilter(((p145z1.d) next).getMatrix()));
                canvas.drawBitmap(this.bitmap, 0.0f, 0.0f, paint);
                this.bitmap = bitmapCreateNewBitmap;
            } else if (next instanceof m) {
                m mVar = (m) next;
                int i5 = mVar.f9111a;
                int i6 = mVar.b;
                if (mVar.c) {
                    float width = this.bitmap.getWidth() / this.bitmap.getHeight();
                    if (mVar.d) {
                        i6 = (int) (i5 / width);
                    } else {
                        i5 = (int) (width * i6);
                    }
                }
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i5, i6, Bitmap.Config.ARGB_8888);
                E.e(bitmapCreateBitmap, "createBitmap(...)");
                Canvas canvas2 = new Canvas(bitmapCreateBitmap);
                Paint paint2 = new Paint();
                Matrix matrix = new Matrix();
                int width2 = this.bitmap.getWidth();
                int height = this.bitmap.getHeight();
                if (width2 != i5 || height != i6) {
                    matrix.setScale(i5 / width2, i6 / height);
                }
                canvas2.drawBitmap(this.bitmap, matrix, paint2);
                this.bitmap = bitmapCreateBitmap;
            } else if (next instanceof e) {
                e eVar = (e) next;
                Matrix matrix2 = new Matrix();
                matrix2.postScale(eVar.f9105a ? -1.0f : 1.0f, eVar.b ? -1.0f : 1.0f);
                Bitmap bitmap2 = this.bitmap;
                Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(bitmap2, 0, 0, bitmap2.getWidth(), this.bitmap.getHeight(), matrix2, true);
                E.e(bitmapCreateBitmap2, "createBitmap(...)");
                new Canvas().drawBitmap(bitmapCreateBitmap2, matrix2, null);
                this.bitmap = bitmapCreateBitmap2;
            } else if (next instanceof b) {
                b bVar = (b) next;
                Bitmap bitmapCreateBitmap3 = Bitmap.createBitmap(this.bitmap, bVar.f9104a, bVar.b, bVar.c, bVar.d, (Matrix) null, false);
                E.e(bitmapCreateBitmap3, "createBitmap(...)");
                this.bitmap = bitmapCreateBitmap3;
            } else if (next instanceof l) {
                Matrix matrix3 = new Matrix();
                matrix3.postRotate(((l) next).f9110a);
                Bitmap bitmap3 = this.bitmap;
                Bitmap bitmapCreateBitmap4 = Bitmap.createBitmap(bitmap3, 0, 0, bitmap3.getWidth(), this.bitmap.getHeight(), matrix3, true);
                E.e(bitmapCreateBitmap4, "createBitmap(...)");
                new Canvas().drawBitmap(bitmapCreateBitmap4, matrix3, null);
                this.bitmap = bitmapCreateBitmap4;
            } else {
                int i7 = 0;
                if (next instanceof a) {
                    Bitmap bitmap4 = this.bitmap;
                    Bitmap bitmapCreateNewBitmap2 = b.createNewBitmap(bitmap4, bitmap4.getWidth(), this.bitmap.getHeight());
                    Canvas canvas3 = new Canvas(bitmapCreateNewBitmap2);
                    canvas3.drawBitmap(this.bitmap, 0.0f, 0.0f, new Paint());
                    Iterator<n> it2 = ((a) next).getTexts().iterator();
                    E.e(it2, "iterator(...)");
                    while (it2.hasNext()) {
                        n next2 = it2.next();
                        E.e(next2, "next(...)");
                        n nVar = next2;
                        TextPaint textPaint = new TextPaint(1);
                        int i8 = nVar.f9114g;
                        int i9 = nVar.b;
                        int i10 = nVar.f9112a;
                        textPaint.setColor(Color.argb(i8, nVar.d, nVar.e, nVar.f9113f));
                        int i11 = nVar.c;
                        textPaint.setTextSize(i11);
                        if (nVar.getFontName().length() > 0) {
                            try {
                                textPaint.setTypeface(p127w1.a.getFont(nVar.getFontName()));
                            } catch (Exception unused) {
                            }
                        }
                        StaticLayout staticLayoutBuild = StaticLayout.Builder.obtain(nVar.getText(), i7, nVar.getText().length(), textPaint, canvas3.getWidth() - i10).build();
                        E.c(staticLayoutBuild);
                        canvas3.translate(i10, i9);
                        int lineCount = staticLayoutBuild.getLineCount();
                        int i12 = i7;
                        while (i12 < lineCount) {
                            String string = staticLayoutBuild.getText().subSequence(staticLayoutBuild.getLineStart(i12), staticLayoutBuild.getLineEnd(i12)).toString();
                            float fMeasureText = textPaint.measureText(string);
                            i12++;
                            int i13 = (i12 * i11) + i9;
                            Iterator<? extends k> it3 = it;
                            int i14 = c.f8842a[nVar.getTextAlign().ordinal()];
                            Iterator<n> it4 = it2;
                            n nVar2 = nVar;
                            if (i14 != 1) {
                                numberValueOf = i14 != 2 ? Integer.valueOf(i10) : Float.valueOf(staticLayoutBuild.getWidth() - fMeasureText);
                            } else {
                                numberValueOf = Float.valueOf((staticLayoutBuild.getWidth() - fMeasureText) / 2);
                            }
                            canvas3.drawText(string, numberValueOf.floatValue(), i13, textPaint);
                            it2 = it4;
                            nVar = nVar2;
                            it = it3;
                        }
                        canvas3.translate(-i10, -i9);
                        it2 = it2;
                        it = it;
                        i7 = 0;
                    }
                    this.bitmap = bitmapCreateNewBitmap2;
                } else {
                    Iterator<? extends k> it5 = it;
                    if (next instanceof j) {
                        j jVar = (j) next;
                        Bitmap bitmap5 = this.bitmap;
                        Bitmap bitmapCreateNewBitmap3 = b.createNewBitmap(bitmap5, bitmap5.getWidth(), this.bitmap.getHeight());
                        Canvas canvas4 = new Canvas(bitmapCreateNewBitmap3);
                        canvas4.drawBitmap(this.bitmap, 0.0f, 0.0f, (Paint) null);
                        Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(jVar.getImg(), 0, jVar.getImg().length);
                        Paint paint3 = new Paint();
                        paint3.setXfermode(new PorterDuffXfermode(jVar.getPorterDuffMode()));
                        int i15 = jVar.f9109a;
                        int i16 = jVar.b;
                        canvas4.drawBitmap(bitmapDecodeByteArray, (Rect) null, new Rect(i15, i16, jVar.c + i15, jVar.d + i16), paint3);
                        this.bitmap = bitmapCreateNewBitmap3;
                    } else if (next instanceof c) {
                        this.bitmap = b.draw(this.bitmap, (c) next);
                    }
                    it = it5;
                }
            }
        }
    }

    public final byte[] outputByteArray(f formatOption) throws IllegalAccessException, IOException, InvocationTargetException {
        E.f(formatOption, "formatOption");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        a(byteArrayOutputStream, formatOption);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        E.e(byteArray, "toByteArray(...)");
        return byteArray;
    }

    public final void outputToFile(String dstPath, f formatOption) throws IllegalAccessException, IOException, InvocationTargetException {
        E.f(dstPath, "dstPath");
        E.f(formatOption, "formatOption");
        a(new FileOutputStream(dstPath), formatOption);
    }
}
