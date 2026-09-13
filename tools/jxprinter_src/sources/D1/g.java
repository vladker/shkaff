package D1;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.AsyncTask;
import android.os.HandlerThread;
import android.util.Log;
import com.github.barteksc.pdfviewer.PDFView;
import com.shockwave.pdfium.PdfiumCore;
import com.shockwave.pdfium.util.Size;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class g extends AsyncTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f168a;
    public WeakReference b;
    public PdfiumCore c;
    public J1.b d;
    public m e;

    @Override // android.os.AsyncTask
    public Object doInBackground(Object[] objArr) {
        try {
            PDFView pDFView = (PDFView) this.b.get();
            if (pDFView == null) {
                return new NullPointerException("pdfView == null");
            }
            this.e = new m(this.c, this.d.createDocument(pDFView.getContext(), this.c, null), pDFView.getPageFitPolicy(), new Size(pDFView.getWidth(), pDFView.getHeight()), pDFView.f3285w, pDFView.getSpacingPx(), pDFView.f3262I, pDFView.f3283u);
            return null;
        } catch (Throwable th) {
            return th;
        }
    }

    @Override // android.os.AsyncTask
    public final void onCancelled() {
        this.f168a = true;
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(Object obj) {
        Throwable th = (Throwable) obj;
        PDFView pDFView = (PDFView) this.b.get();
        if (pDFView != null) {
            if (th != null) {
                pDFView.f3275m = PDFView.c.ERROR;
                pDFView.f3280r.getClass();
                pDFView.q();
                pDFView.invalidate();
                Log.e("PDFView", "load pdf error", th);
                return;
            }
            if (this.f168a) {
                return;
            }
            m mVar = this.e;
            pDFView.f3275m = PDFView.c.LOADED;
            pDFView.f3269g = mVar;
            HandlerThread handlerThread = pDFView.f3277o;
            if (handlerThread == null) {
                return;
            }
            if (!handlerThread.isAlive()) {
                pDFView.f3277o.start();
            }
            q qVar = new q(pDFView.f3277o.getLooper());
            qVar.b = new RectF();
            qVar.c = new Rect();
            qVar.d = new Matrix();
            qVar.f202a = pDFView;
            pDFView.f3278p = qVar;
            qVar.e = true;
            pDFView.f3268f.f171g = true;
            p075n1.a aVar = pDFView.f3280r;
            int i5 = mVar.c;
            aVar.getClass();
            pDFView.l(pDFView.f3284v);
        }
    }
}
