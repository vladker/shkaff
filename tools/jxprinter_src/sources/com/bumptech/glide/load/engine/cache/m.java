package com.bumptech.glide.load.engine.cache;

import L0.n;
import L0.s;
import androidx.core.util.Pools;
import p126w0.q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n f3010a = new n(1000);
    public final Pools.Pool b = M0.h.threadSafe(10, new V1.b(12));

    public final String a(q qVar) {
        String str;
        synchronized (this.f3010a) {
            str = (String) this.f3010a.get(qVar);
        }
        if (str == null) {
            Pools.Pool pool = this.b;
            l lVar = (l) L0.q.checkNotNull(pool.acquire());
            try {
                qVar.updateDiskCacheKey(lVar.f3009a);
                String strSha256BytesToHex = s.sha256BytesToHex(lVar.f3009a.digest());
                pool.release(lVar);
                str = strSha256BytesToHex;
            } catch (Throwable th) {
                pool.release(lVar);
                throw th;
            }
        }
        synchronized (this.f3010a) {
            this.f3010a.put(qVar, str);
        }
        return str;
    }
}
