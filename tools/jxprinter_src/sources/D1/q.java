package D1;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.github.barteksc.pdfviewer.PDFView;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class q extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public PDFView f202a;
    public RectF b;
    public Rect c;
    public Matrix d;
    public boolean e;

    private H1.a proceed(p pVar) {
        Rect rect = this.c;
        m mVar = this.f202a.f3269g;
        int i5 = pVar.d;
        mVar.openPage(i5);
        int iRound = Math.round(pVar.f198a);
        int iRound2 = Math.round(pVar.b);
        if (iRound != 0 && iRound2 != 0) {
            if (mVar.f183f.get(mVar.a(i5), false)) {
                try {
                    Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iRound, iRound2, pVar.f200g ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
                    RectF rectF = pVar.c;
                    Matrix matrix = this.d;
                    matrix.reset();
                    float f6 = iRound;
                    float f7 = iRound2;
                    matrix.postTranslate((-rectF.left) * f6, (-rectF.top) * f7);
                    matrix.postScale(1.0f / rectF.width(), 1.0f / rectF.height());
                    RectF rectF2 = this.b;
                    rectF2.set(0.0f, 0.0f, f6, f7);
                    matrix.mapRect(rectF2);
                    rectF2.round(rect);
                    mVar.b.j(mVar.f182a, bitmapCreateBitmap, mVar.a(i5), rect.left, rect.top, rect.width(), rect.height(), pVar.f201h);
                    return new H1.a(pVar.d, bitmapCreateBitmap, pVar.c, pVar.e, pVar.f199f);
                } catch (IllegalArgumentException e) {
                    Log.e("D1.q", "Cannot create bitmap", e);
                }
            }
        }
        return null;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        PDFView pDFView = this.f202a;
        try {
            H1.a aVarProceed = proceed((p) message.obj);
            if (aVarProceed != null) {
                if (this.e) {
                    pDFView.post(new n(this, aVarProceed));
                } else {
                    aVarProceed.b.recycle();
                }
            }
        } catch (E1.a e) {
            pDFView.post(new o(this, e));
        }
    }
}
