package androidx.constraintlayout.core;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
final class Pools {
    private static final boolean DEBUG = false;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public interface Pool<T> {
        T acquire();

        boolean release(T t6);

        void releaseAll(T[] tArr, int i5);
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class SimplePool<T> implements Pool<T> {
        private final Object[] mPool;
        private int mPoolSize;

        public SimplePool(int i5) {
            if (i5 <= 0) {
                throw new IllegalArgumentException("The max pool size must be > 0");
            }
            this.mPool = new Object[i5];
        }

        private boolean isInPool(T t6) {
            for (int i5 = 0; i5 < this.mPoolSize; i5++) {
                if (this.mPool[i5] == t6) {
                    return true;
                }
            }
            return false;
        }

        @Override // androidx.constraintlayout.core.Pools.Pool
        public T acquire() {
            int i5 = this.mPoolSize;
            if (i5 <= 0) {
                return null;
            }
            int i6 = i5 - 1;
            Object[] objArr = this.mPool;
            T t6 = (T) objArr[i6];
            objArr[i6] = null;
            this.mPoolSize = i5 - 1;
            return t6;
        }

        @Override // androidx.constraintlayout.core.Pools.Pool
        public boolean release(T t6) {
            int i5 = this.mPoolSize;
            Object[] objArr = this.mPool;
            if (i5 >= objArr.length) {
                return false;
            }
            objArr[i5] = t6;
            this.mPoolSize = i5 + 1;
            return true;
        }

        @Override // androidx.constraintlayout.core.Pools.Pool
        public void releaseAll(T[] tArr, int i5) {
            if (i5 > tArr.length) {
                i5 = tArr.length;
            }
            for (int i6 = 0; i6 < i5; i6++) {
                T t6 = tArr[i6];
                int i7 = this.mPoolSize;
                Object[] objArr = this.mPool;
                if (i7 < objArr.length) {
                    objArr[i7] = t6;
                    this.mPoolSize = i7 + 1;
                }
            }
        }
    }

    private Pools() {
    }
}
