package xyz.doikki.videoplayer.player;

import A3.AbstractC0157z;
import Y4.q;
import android.os.Looper;
import com.android.billingclient.api.C0421m;
import com.android.billingclient.api.H;
import com.android.billingclient.api.InterfaceC0423n;
import com.android.billingclient.api.k1;
import com.google.android.gms.internal.play_billing.zzc;
import com.google.android.gms.internal.play_billing.zzp;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.Executor;
import kotlinx.serialization.json.internal.AbstractC1125a;
import okhttp3.InterfaceC1353f;
import okhttp3.InterfaceC1354g;
import okhttp3.T;
import org.jsoup.nodes.s;
import org.jsoup.parser.C1465a;
import retrofit2.B0;
import retrofit2.C1622u;
import retrofit2.InterfaceC1613k;
import retrofit2.InterfaceC1615m;
import retrofit2.InterfaceC1616n;
import retrofit2.N;
import retrofit2.r0;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final class k implements InterfaceC0423n, q, InterfaceC1615m, InterfaceC1616n, InterfaceC1354g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9008a;
    public Object b;
    public Object c;

    public /* synthetic */ k(int i5) {
        this.f9008a = i5;
    }

    @Override // retrofit2.InterfaceC1615m
    public Type a() {
        return (Type) this.b;
    }

    @Override // Y4.q
    public void b(s sVar, int i5) {
        if (sVar.r().equals("#text")) {
            return;
        }
        try {
            sVar.outerHtmlTail((Appendable) this.b, i5, (org.jsoup.nodes.h) this.c);
        } catch (IOException e) {
            throw new U4.i(e);
        }
    }

    @Override // retrofit2.InterfaceC1615m
    public Object c(InterfaceC1613k interfaceC1613k) {
        Executor executor = (Executor) this.c;
        return executor == null ? interfaceC1613k : new C1622u(executor, interfaceC1613k);
    }

    @Override // com.android.billingclient.api.InterfaceC0423n
    public void d() {
        zzc.zzm("BillingClient", "Reconnection attempt failed.");
        try {
            ((zzp) this.b).zzb(k1.f2516j);
        } catch (Throwable th) {
            zzc.zzo("BillingClient", "Exception setting completer.", th);
        }
        C0421m c0421m = (C0421m) this.c;
        if (c0421m.zzK != null) {
            H2.c cVar = new H2.c(this, 8);
            if (Looper.myLooper() == Looper.getMainLooper()) {
                cVar.run();
            } else {
                c0421m.d.post(cVar);
            }
        }
    }

    @Override // Y4.q
    public void e(s sVar, int i5) {
        try {
            sVar.outerHtmlHead((Appendable) this.b, i5, (org.jsoup.nodes.h) this.c);
        } catch (IOException e) {
            throw new U4.i(e);
        }
    }

    public void f(Throwable th) {
        try {
            ((InterfaceC1616n) this.b).onFailure((N) this.c, th);
        } catch (Throwable th2) {
            B0.k(th2);
            th2.printStackTrace();
        }
    }

    public void g(int i5, String str) {
        if (i5 < ((p004a1.b) this.b).f918a) {
            return;
        }
        if (str == null) {
            str = "";
        }
        i(i5, str);
    }

    public void h(String str, int i5, Object... objArr) {
        String string;
        if (i5 < ((p004a1.b) this.b).f918a) {
            return;
        }
        if (str != null) {
            string = String.format(str, objArr);
        } else {
            StringBuilder sb = new StringBuilder();
            int length = objArr.length;
            for (int i6 = 0; i6 < length; i6++) {
                if (i6 != 0) {
                    sb.append(", ");
                }
                sb.append(objArr[i6]);
            }
            string = sb.toString();
        }
        i(i5, string);
    }

    public void i(int i5, String str) {
        String string;
        String strS;
        int i6;
        p004a1.b bVar = (p004a1.b) this.b;
        String str2 = bVar.b;
        String strC = null;
        String strC2 = bVar.c ? bVar.f924k.c(Thread.currentThread()) : null;
        if (bVar.d) {
            V1.b bVar2 = bVar.f925l;
            StackTraceElement[] stackTraceElementArrZ = androidx.collection.a.z();
            String str3 = bVar.e;
            int i7 = bVar.f919f;
            String str4 = p063l1.a.f5782a;
            int length = stackTraceElementArrZ.length;
            int i8 = length - 1;
            while (true) {
                if (i8 < 0) {
                    i6 = 0;
                    break;
                }
                String className = stackTraceElementArrZ[i8].getClassName();
                if (className.startsWith(p063l1.a.f5782a) || (str3 != null && className.startsWith(str3))) {
                    i6 = i8 + 1;
                    break;
                }
                i8--;
            }
            int iMin = length - i6;
            StackTraceElement[] stackTraceElementArr = new StackTraceElement[iMin];
            System.arraycopy(stackTraceElementArrZ, i6, stackTraceElementArr, 0, iMin);
            if (i7 > 0) {
                iMin = Math.min(i7, iMin);
            }
            StackTraceElement[] stackTraceElementArr2 = new StackTraceElement[iMin];
            System.arraycopy(stackTraceElementArr, 0, stackTraceElementArr2, 0, iMin);
            strC = bVar2.c(stackTraceElementArr2);
        }
        ArrayList arrayList = bVar.f928o;
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            if (it.hasNext()) {
                throw AbstractC1125a.g(it);
            }
        }
        p069m1.b bVar3 = (p069m1.b) this.c;
        if (bVar.f920g) {
            strS = bVar.f926m.c(new String[]{strC2, strC, str});
        } else {
            StringBuilder sb = new StringBuilder();
            String string2 = "";
            if (strC2 != null) {
                StringBuilder sbR = androidx.collection.a.r(strC2);
                sbR.append(p057k1.c.f5473a);
                string = sbR.toString();
            } else {
                string = "";
            }
            sb.append(string);
            if (strC != null) {
                StringBuilder sbR2 = androidx.collection.a.r(strC);
                sbR2.append(p057k1.c.f5473a);
                string2 = sbR2.toString();
            }
            strS = AbstractC0157z.s(sb, string2, str);
        }
        bVar3.b(i5, str2, strS);
    }

    public void j(String str) {
        com.bumptech.glide.load.engine.cache.d dVar;
        synchronized (this) {
            try {
                dVar = (com.bumptech.glide.load.engine.cache.d) L0.q.checkNotNull(((HashMap) this.b).get(str));
                int i5 = dVar.b;
                if (i5 < 1) {
                    throw new IllegalStateException("Cannot release a lock that is not held, safeKey: " + str + ", interestedThreads: " + dVar.b);
                }
                int i6 = i5 - 1;
                dVar.b = i6;
                if (i6 == 0) {
                    com.bumptech.glide.load.engine.cache.d dVar2 = (com.bumptech.glide.load.engine.cache.d) ((HashMap) this.b).remove(str);
                    if (!dVar2.equals(dVar)) {
                        throw new IllegalStateException("Removed the wrong lock, expected to remove: " + dVar + ", but actually removed: " + dVar2 + ", safeKey: " + str);
                    }
                    S4.h hVar = (S4.h) this.c;
                    synchronized (((ArrayDeque) hVar.b)) {
                        try {
                            if (((ArrayDeque) hVar.b).size() < 10) {
                                ((ArrayDeque) hVar.b).offer(dVar2);
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        dVar.f3004a.unlock();
    }

    @Override // com.android.billingclient.api.InterfaceC0423n
    public void onBillingSetupFinished(H h6) {
        zzc.zzm("BillingClient", "Reconnection finished with result: " + h6.f2433a);
        try {
            ((zzp) this.b).zzb(h6);
        } catch (Throwable th) {
            zzc.zzo("BillingClient", "Exception setting completer.", th);
        }
        C0421m c0421m = (C0421m) this.c;
        if (c0421m.zzK != null) {
            Q0.b bVar = new Q0.b(this, h6, 9);
            if (Looper.myLooper() == Looper.getMainLooper()) {
                bVar.run();
            } else {
                c0421m.d.post(bVar);
            }
        }
    }

    @Override // retrofit2.InterfaceC1616n
    public void onFailure(InterfaceC1613k interfaceC1613k, Throwable th) {
        ((C1622u) this.c).f8162a.execute(new androidx.webkit.a(this, 12, (InterfaceC1616n) this.b, th));
    }

    @Override // retrofit2.InterfaceC1616n
    public void onResponse(InterfaceC1613k interfaceC1613k, r0 r0Var) {
        ((C1622u) this.c).f8162a.execute(new androidx.webkit.a(this, 11, (InterfaceC1616n) this.b, r0Var));
    }

    public String toString() {
        switch (this.f9008a) {
            case 6:
                return "<" + ((String) this.b) + ">: " + ((String) this.c);
            default:
                return super.toString();
        }
    }

    public /* synthetic */ k(Object obj, int i5, Object obj2, boolean z6) {
        this.f9008a = i5;
        this.b = obj;
        this.c = obj2;
    }

    @Override // okhttp3.InterfaceC1354g
    public void onResponse(InterfaceC1353f interfaceC1353f, T t6) {
        N n6 = (N) this.c;
        try {
            try {
                ((InterfaceC1616n) this.b).onResponse(n6, n6.parseResponse(t6));
            } catch (Throwable th) {
                B0.k(th);
                th.printStackTrace();
            }
        } catch (Throwable th2) {
            B0.k(th2);
            f(th2);
        }
    }

    public /* synthetic */ k(Object obj, Object obj2, int i5) {
        this.f9008a = i5;
        this.b = obj2;
        this.c = obj;
    }

    public k(C1465a c1465a, String str, Object[] objArr) {
        this.f9008a = 6;
        c1465a.getClass();
        this.b = c1465a.n();
        this.c = String.format(str, objArr);
    }

    public k() {
        this.f9008a = 3;
        this.b = new HashMap();
        this.c = new S4.h(7);
    }

    public k(j jVar) {
        this.f9008a = 0;
        this.b = new d();
        this.c = new E5.e();
    }

    public k(Appendable appendable, org.jsoup.nodes.h hVar) {
        this.f9008a = 5;
        this.b = appendable;
        this.c = hVar;
        hVar.e();
    }
}
