package okhttp3;

import androidx.core.app.NotificationCompat;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class J extends p107s4.b {
    public final xyz.doikki.videoplayer.player.k b;
    public volatile AtomicInteger c;
    public final /* synthetic */ K d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public J(K k6, xyz.doikki.videoplayer.player.k kVar) {
        super("OkHttp %s", k6.c.f6539a.j());
        this.d = k6;
        this.c = new AtomicInteger(0);
        this.b = kVar;
    }

    @Override // p107s4.b
    public final void a() {
        xyz.doikki.videoplayer.player.k kVar = this.b;
        K k6 = this.d;
        H h6 = k6.f6537a;
        k6.b.e.j();
        boolean z6 = false;
        try {
            try {
                try {
                    kVar.onResponse(k6, k6.getResponseWithInterceptorChain());
                } catch (IOException e) {
                    e = e;
                    z6 = true;
                    if (z6) {
                        p130w4.i iVar = p130w4.i.f8835a;
                        StringBuilder sb = new StringBuilder("Callback failure for ");
                        StringBuilder sb2 = new StringBuilder();
                        androidx.collection.a.x(sb2, k6.b.f() ? "canceled " : "", NotificationCompat.CATEGORY_CALL, " to ");
                        sb2.append(k6.c.f6539a.j());
                        sb.append(sb2.toString());
                        iVar.log(4, sb.toString(), e);
                    } else {
                        kVar.f(e);
                    }
                } catch (Throwable th) {
                    th = th;
                    z6 = true;
                    k6.b.c();
                    if (!z6) {
                        IOException iOException = new IOException("canceled due to " + th);
                        iOException.addSuppressed(th);
                        kVar.f(iOException);
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                h6.f6512a.c(this);
                throw th2;
            }
        } catch (IOException e6) {
            e = e6;
        } catch (Throwable th3) {
            th = th3;
        }
        h6.f6512a.c(this);
    }
}
