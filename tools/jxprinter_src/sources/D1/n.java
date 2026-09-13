package D1;

import com.github.barteksc.pdfviewer.PDFView;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class n implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ H1.a f196a;
    public final /* synthetic */ q b;

    public n(q qVar, H1.a aVar) {
        this.b = qVar;
        this.f196a = aVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i5;
        PDFView pDFView = this.b.f202a;
        H1.a aVar = this.f196a;
        if (pDFView.f3275m == PDFView.c.LOADED) {
            pDFView.f3275m = PDFView.c.SHOWN;
            p075n1.a aVar2 = pDFView.f3280r;
            int i6 = pDFView.f3269g.c;
            aVar2.getClass();
        }
        if (aVar.d) {
            f fVar = pDFView.d;
            synchronized (fVar.c) {
                while (true) {
                    try {
                        i5 = 0;
                        if (fVar.c.size() < 8) {
                            break;
                        } else {
                            ((H1.a) fVar.c.remove(0)).b.recycle();
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                ArrayList arrayList = fVar.c;
                int size = arrayList.size();
                while (true) {
                    if (i5 >= size) {
                        arrayList.add(aVar);
                        break;
                    }
                    Object obj = arrayList.get(i5);
                    i5++;
                    if (((H1.a) obj).equals(aVar)) {
                        aVar.b.recycle();
                        break;
                    }
                }
            }
        } else {
            f fVar2 = pDFView.d;
            synchronized (fVar2.d) {
                fVar2.a();
                fVar2.b.offer(aVar);
            }
        }
        pDFView.invalidate();
    }
}
