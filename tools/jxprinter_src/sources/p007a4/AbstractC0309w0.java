package p007a4;

import S2.l;
import java.io.Closeable;
import java.util.concurrent.Executor;

/* JADX INFO: renamed from: a4.w0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC0309w0 extends F implements Closeable, AutoCloseable {
    public static final C0307v0 Key = new C0307v0(F.Key, new l(11));

    public abstract Executor getExecutor();
}
