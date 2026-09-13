package com.bumptech.glide.load.engine.prefill;

import L0.n;
import L0.s;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.load.engine.cache.h;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f3066a;
    public final com.bumptech.glide.load.engine.bitmap_recycle.c b;
    public b c;

    public c(h hVar, com.bumptech.glide.load.engine.bitmap_recycle.c cVar, p126w0.b bVar) {
        this.f3066a = hVar;
        this.b = cVar;
    }

    public final void a(e... eVarArr) {
        b bVar = this.c;
        if (bVar != null) {
            bVar.f3065f = true;
        }
        f[] fVarArr = new f[eVarArr.length];
        if (eVarArr.length > 0) {
            e eVar = eVarArr[0];
            throw null;
        }
        b bVar2 = new b(this.b, this.f3066a, generateAllocationOrder(fVarArr), b.f3062g, new Handler(Looper.getMainLooper()));
        this.c = bVar2;
        s.b().post(bVar2);
    }

    @VisibleForTesting
    public d generateAllocationOrder(f... fVarArr) {
        n nVar = (n) this.f3066a;
        synchronized (nVar) {
        }
        synchronized (nVar) {
        }
        this.b.getClass();
        if (fVarArr.length > 0) {
            f fVar = fVarArr[0];
            throw null;
        }
        HashMap map = new HashMap();
        if (fVarArr.length <= 0) {
            return new d(map);
        }
        f fVar2 = fVarArr[0];
        throw null;
    }
}
