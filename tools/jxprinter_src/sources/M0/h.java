package M0;

import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f466a = new a();

    @NonNull
    private static <T extends f> Pools.Pool<T> build(@NonNull Pools.Pool<T> pool, @NonNull d dVar) {
        return build(pool, dVar, emptyResetter());
    }

    @NonNull
    private static <T> g emptyResetter() {
        return f466a;
    }

    @NonNull
    public static <T extends f> Pools.Pool<T> simple(int i5, @NonNull d dVar) {
        return build(new Pools.SimplePool(i5), dVar);
    }

    @NonNull
    public static <T extends f> Pools.Pool<T> threadSafe(int i5, @NonNull d dVar) {
        return build(new Pools.SynchronizedPool(i5), dVar);
    }

    @NonNull
    public static <T> Pools.Pool<List<T>> threadSafeList() {
        return threadSafeList(20);
    }

    @NonNull
    private static <T> Pools.Pool<T> build(@NonNull Pools.Pool<T> pool, @NonNull d dVar, @NonNull g gVar) {
        return new e(pool, dVar, gVar);
    }

    @NonNull
    public static <T> Pools.Pool<List<T>> threadSafeList(int i5) {
        return build(new Pools.SynchronizedPool(i5), new b(), new c());
    }
}
