package cn.fly.tools.utils;

import cn.fly.tools.FlyLog;
import cn.fly.tools.proguard.PublicMemberKeeper;

/* JADX INFO: loaded from: classes.dex */
public class FlyPools implements PublicMemberKeeper {

    public interface Pool<T> extends PublicMemberKeeper {
        T acquire();

        boolean release(T t6);
    }

    public static class SimplePool<T> implements Pool<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Object[] f1927a;
        private int b;

        public SimplePool(int i5) {
            if (i5 <= 0) {
                throw new IllegalArgumentException("The max pool size must be > 0");
            }
            this.f1927a = new Object[i5];
        }

        private boolean a(T t6) {
            for (int i5 = 0; i5 < this.b; i5++) {
                if (this.f1927a[i5] == t6) {
                    return true;
                }
            }
            return false;
        }

        @Override // cn.fly.tools.utils.FlyPools.Pool
        public T acquire() {
            int i5 = this.b;
            if (i5 > 0) {
                int i6 = i5 - 1;
                try {
                    Object[] objArr = this.f1927a;
                    T t6 = (T) objArr[i6];
                    objArr[i6] = null;
                    this.b = i5 - 1;
                    return t6;
                } catch (Throwable th) {
                    FlyLog.getInstance().d(th);
                }
            }
            return null;
        }

        @Override // cn.fly.tools.utils.FlyPools.Pool
        public boolean release(T t6) {
            if (a(t6)) {
                throw new IllegalStateException("Already in the pool!");
            }
            int i5 = this.b;
            Object[] objArr = this.f1927a;
            if (i5 >= objArr.length) {
                return false;
            }
            objArr[i5] = t6;
            this.b = i5 + 1;
            return true;
        }
    }

    public static class SynchronizedPool<T> extends SimplePool<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Object f1928a;

        public SynchronizedPool(int i5, Object obj) {
            super(i5);
            this.f1928a = obj;
        }

        @Override // cn.fly.tools.utils.FlyPools.SimplePool, cn.fly.tools.utils.FlyPools.Pool
        public T acquire() {
            T t6;
            synchronized (this.f1928a) {
                t6 = (T) super.acquire();
            }
            return t6;
        }

        @Override // cn.fly.tools.utils.FlyPools.SimplePool, cn.fly.tools.utils.FlyPools.Pool
        public boolean release(T t6) {
            boolean zRelease;
            synchronized (this.f1928a) {
                zRelease = super.release(t6);
            }
            return zRelease;
        }

        public SynchronizedPool(int i5) {
            this(i5, new Object());
        }
    }
}
