package p121v1;

import H2.c;
import java.util.concurrent.ExecutorService;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class a {
    public final ExecutorService getThreadPool() {
        return b.threadPool;
    }

    public final void runOnBackground(O3.a block) {
        E.f(block, "block");
        getThreadPool().execute(new c(block, 21));
    }
}
