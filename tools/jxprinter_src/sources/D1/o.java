package D1;

import android.util.Log;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class o implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ E1.a f197a;
    public final /* synthetic */ q b;

    public o(q qVar, E1.a aVar) {
        this.b = qVar;
        this.f197a = aVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        p075n1.a aVar = this.b.f202a.f3280r;
        E1.a aVar2 = this.f197a;
        aVar2.getClass();
        aVar2.getCause();
        aVar.getClass();
        Log.e("PDFView", "Cannot open page " + aVar2.f226a, aVar2.getCause());
    }
}
