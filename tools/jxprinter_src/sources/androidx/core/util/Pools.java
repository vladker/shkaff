package androidx.core.util;

import androidx.annotation.IntRange;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class Pools {

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public interface Pool<T> {
        T acquire();

        boolean release(T t6);
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class SimplePool<T> implements Pool<T> {
        private final Object[] pool;
        private int poolSize;

        public SimplePool(@IntRange(from = 1) int i5) {
            if (i5 <= 0) {
                throw new IllegalArgumentException("The max pool size must be > 0");
            }
            this.pool = new Object[i5];
        }

        private final boolean isInPool(T t6) {
            int i5 = this.poolSize;
            for (int i6 = 0; i6 < i5; i6++) {
                if (this.pool[i6] == t6) {
                    return true;
                }
            }
            return false;
        }

        @Override // androidx.core.util.Pools.Pool
        public T acquire() {
            int i5 = this.poolSize;
            if (i5 <= 0) {
                return null;
            }
            int i6 = i5 - 1;
            T t6 = (T) this.pool[i6];
            E.d(t6, "null cannot be cast to non-null type T of androidx.core.util.Pools.SimplePool");
            this.pool[i6] = null;
            this.poolSize--;
            return t6;
        }

        @Override // androidx.core.util.Pools.Pool
        public boolean release(T instance) {
            E.f(instance, "instance");
            if (isInPool(instance)) {
                throw new IllegalStateException("Already in the pool!");
            }
            int i5 = this.poolSize;
            Object[] objArr = this.pool;
            if (i5 >= objArr.length) {
                return false;
            }
            objArr[i5] = instance;
            this.poolSize = i5 + 1;
            return true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class SynchronizedPool<T> extends SimplePool<T> {
        private final Object lock;

        public SynchronizedPool(int i5) {
            super(i5);
            this.lock = new Object();
        }

        @Override // androidx.core.util.Pools.SimplePool, androidx.core.util.Pools.Pool
        public T acquire() {
            T t6;
            synchronized (this.lock) {
                t6 = (T) super.acquire();
            }
            return t6;
        }

        @Override // androidx.core.util.Pools.SimplePool, androidx.core.util.Pools.Pool
        public boolean release(T instance) {
            boolean zRelease;
            E.f(instance, "instance");
            synchronized (this.lock) {
                zRelease = super.release(instance);
            }
            return zRelease;
        }
    }

    private Pools() {
    }
}
