package com.appdev.standard.util.fileDownload;

import android.util.Log;
import io.reactivex.B;
import io.reactivex.N;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import okhttp3.G;
import okhttp3.H;
import okhttp3.W;
import p050j.n;
import retrofit2.t0;
import retrofit2.u0;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class g {
    public static g c;
    public static u0 d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f2845a = new ArrayList();
    public final HashSet b = new HashSet();

    public g() {
        G g6 = new G();
        g6.f6506t = p107s4.d.b(8L, TimeUnit.SECONDS);
        S4.h hVar = new S4.h(this, 6);
        i iVar = new i();
        iVar.f2846a = hVar;
        g6.a(iVar);
        H h6 = new H(g6);
        t0 t0Var = new t0();
        t0Var.d(h6);
        t0Var.b.add(y5.i.a());
        t0Var.a("https://yourbaseurl.com");
        d = t0Var.b();
    }

    public static g b() {
        if (c == null) {
            synchronized (g.class) {
                try {
                    if (c == null) {
                        c = new g();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return c;
    }

    public final void a(File file, String str) {
        a bVar;
        ArrayList arrayList = this.f2845a;
        int size = arrayList.size();
        int i5 = 0;
        do {
            if (i5 >= size) {
                bVar = null;
                break;
            } else {
                Object obj = arrayList.get(i5);
                i5++;
                bVar = (a) obj;
            }
        } while (!bVar.c.equals(str));
        if (bVar == null) {
            bVar = new b(this, str, file);
            arrayList.add(bVar);
        }
        if (n.a(2, bVar.d)) {
            Log.d("rustAppDownloadCenter", "downloading this task.");
            return;
        }
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            ((h) it.next()).onStart(bVar);
        }
        B<W> bDoOnError = ((f) d.a(f.class)).download(str).subscribeOn(io.reactivex.schedulers.j.io()).observeOn(io.reactivex.schedulers.j.io()).doOnNext(new e(bVar)).doOnError(new d(str));
        N n6 = p006a3.c.f936a;
        if (n6 == null) {
            throw new NullPointerException("scheduler == null");
        }
        bDoOnError.observeOn(n6).subscribe(new c(this, bVar, str));
    }
}
