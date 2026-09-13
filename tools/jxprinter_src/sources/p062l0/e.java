package p062l0;

import F4.f;
import H2.c;
import W2.b;
import android.os.Handler;
import android.os.Looper;
import com.android.billingclient.api.A0;
import com.android.billingclient.api.AbstractC0419l;
import p051j0.a;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class e {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static e f5780f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AbstractC0419l f5781a;
    public c b;
    public b c;
    public int d;
    public Handler e;

    public static void a(e eVar) {
        int i5 = eVar.d;
        if (i5 >= 3) {
            a.d("GoogleBillingManager", "已达到最大重连次数 (3)，停止重连");
            eVar.c = null;
            return;
        }
        eVar.d = i5 + 1;
        long jMin = Math.min(((long) Math.pow(2.0d, i5)) * 1000, 60000L);
        a.d("GoogleBillingManager", "计划第 " + eVar.d + " 次重连，延迟 " + jMin + "ms");
        eVar.e.postDelayed(new c(eVar, 19), jMin);
    }

    public static e b() {
        if (f5780f == null) {
            synchronized (e.class) {
                try {
                    if (f5780f == null) {
                        e eVar = new e();
                        eVar.c = null;
                        eVar.d = 0;
                        eVar.e = new Handler(Looper.getMainLooper());
                        f5780f = eVar;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f5780f;
    }

    public final boolean c() {
        AbstractC0419l abstractC0419l = this.f5781a;
        return abstractC0419l != null && abstractC0419l.isReady();
    }

    public final void d(c cVar) {
        if (!c()) {
            a.d("GoogleBillingManager", "BillingClient未准备好，等待连接完成后查询");
            this.c = new b(this, cVar, 25);
        } else {
            a.d("GoogleBillingManager", "开始查询未完成的购买...");
            this.f5781a.queryPurchasesAsync(A0.newBuilder().setProductType("inapp").build(), new f(this, cVar, 11));
        }
    }

    public final void e() {
        if (!c()) {
            this.f5781a.startConnection(new p075n1.a(this, 12));
            return;
        }
        this.d = 0;
        b bVar = this.c;
        if (bVar != null) {
            bVar.run();
            this.c = null;
        }
    }
}
