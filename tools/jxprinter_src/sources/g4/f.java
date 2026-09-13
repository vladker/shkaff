package g4;

import p007a4.F;
import p028e4.AbstractC0659m;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class f extends i {
    public static final f INSTANCE = new f(m.CORE_POOL_SIZE, m.MAX_POOL_SIZE, m.IDLE_WORKER_KEEP_ALIVE_NS, m.DEFAULT_SCHEDULER_NAME);

    public final void a() {
        super.close();
    }

    @Override // g4.i, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        throw new UnsupportedOperationException("Dispatchers.Default cannot be closed");
    }

    @Override // p007a4.F
    public F limitedParallelism(int i5, String str) {
        AbstractC0659m.a(i5);
        return i5 >= m.CORE_POOL_SIZE ? AbstractC0659m.namedOrThis(this, str) : super.limitedParallelism(i5, str);
    }

    @Override // p007a4.F
    public String toString() {
        return "Dispatchers.Default";
    }
}
