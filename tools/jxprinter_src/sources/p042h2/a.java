package p042h2;

import Y1.e;
import android.os.Looper;
import android.widget.Toast;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class a extends Thread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f4027a;

    public a(b bVar) {
        this.f4027a = bVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        Looper.prepare();
        Toast.makeText(this.f4027a.b, e.base_text_5, 0).show();
        Looper.loop();
    }
}
