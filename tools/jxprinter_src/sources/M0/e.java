package M0;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.util.Pools;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class e implements Pools.Pool {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f465a;
    public final g b;
    public final Pools.Pool c;

    public e(@NonNull Pools.Pool<Object> pool, @NonNull d dVar, @NonNull g gVar) {
        this.c = pool;
        this.f465a = dVar;
        this.b = gVar;
    }

    @Override // androidx.core.util.Pools.Pool
    public final Object acquire() {
        Object objAcquire = this.c.acquire();
        if (objAcquire == null) {
            objAcquire = this.f465a.create();
            if (Log.isLoggable("FactoryPools", 2)) {
                Log.v("FactoryPools", "Created new " + objAcquire.getClass());
            }
        }
        if (objAcquire instanceof f) {
            ((i) ((f) objAcquire).getVerifier()).f467a = false;
        }
        return objAcquire;
    }

    @Override // androidx.core.util.Pools.Pool
    public boolean release(@NonNull Object obj) {
        if (obj instanceof f) {
            ((i) ((f) obj).getVerifier()).f467a = true;
        }
        this.b.reset(obj);
        return this.c.release(obj);
    }
}
