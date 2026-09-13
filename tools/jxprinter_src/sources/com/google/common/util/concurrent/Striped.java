package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.MapMaker;
import com.google.common.math.IntMath;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
@Beta
@ElementTypesAreNonnullByDefault
@GwtIncompatible
public abstract class Striped<L> {
    private static final int ALL_SET = -1;
    private static final int LARGE_LAZY_CUTOFF = 1024;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class CompactStriped<L> extends PowerOfTwoStriped<L> {
        private final Object[] array;

        @Override // com.google.common.util.concurrent.Striped
        public L getAt(int i5) {
            return (L) this.array[i5];
        }

        @Override // com.google.common.util.concurrent.Striped
        public int size() {
            return this.array.length;
        }

        private CompactStriped(int i5, Supplier<L> supplier) {
            super(i5);
            int i6 = 0;
            Preconditions.checkArgument(i5 <= 1073741824, "Stripes must be <= 2^30)");
            this.array = new Object[this.mask + 1];
            while (true) {
                Object[] objArr = this.array;
                if (i6 >= objArr.length) {
                    return;
                }
                objArr[i6] = supplier.get();
                i6++;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    @VisibleForTesting
    public static class LargeLazyStriped<L> extends PowerOfTwoStriped<L> {
        final ConcurrentMap<Integer, L> locks;
        final int size;
        final Supplier<L> supplier;

        public LargeLazyStriped(int i5, Supplier<L> supplier) {
            super(i5);
            int i6 = this.mask;
            this.size = i6 == -1 ? Integer.MAX_VALUE : i6 + 1;
            this.supplier = supplier;
            this.locks = new MapMaker().weakValues().makeMap();
        }

        @Override // com.google.common.util.concurrent.Striped
        public L getAt(int i5) {
            if (this.size != Integer.MAX_VALUE) {
                Preconditions.checkElementIndex(i5, size());
            }
            L l6 = this.locks.get(Integer.valueOf(i5));
            if (l6 != null) {
                return l6;
            }
            L l7 = this.supplier.get();
            return (L) MoreObjects.firstNonNull(this.locks.putIfAbsent(Integer.valueOf(i5), l7), l7);
        }

        @Override // com.google.common.util.concurrent.Striped
        public int size() {
            return this.size;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class PaddedLock extends ReentrantLock {
        long unused1;
        long unused2;
        long unused3;

        public PaddedLock() {
            super(false);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class PaddedSemaphore extends Semaphore {
        long unused1;
        long unused2;
        long unused3;

        public PaddedSemaphore(int i5) {
            super(i5, false);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static abstract class PowerOfTwoStriped<L> extends Striped<L> {
        final int mask;

        public PowerOfTwoStriped(int i5) {
            super();
            Preconditions.checkArgument(i5 > 0, "Stripes must be positive");
            this.mask = i5 > 1073741824 ? -1 : Striped.ceilToPowerOfTwo(i5) - 1;
        }

        @Override // com.google.common.util.concurrent.Striped
        public final L get(Object obj) {
            return getAt(indexFor(obj));
        }

        @Override // com.google.common.util.concurrent.Striped
        public final int indexFor(Object obj) {
            return Striped.smear(obj.hashCode()) & this.mask;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    @VisibleForTesting
    public static class SmallLazyStriped<L> extends PowerOfTwoStriped<L> {
        final AtomicReferenceArray<ArrayReference<? extends L>> locks;
        final ReferenceQueue<L> queue;
        final int size;
        final Supplier<L> supplier;

        /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
        public static final class ArrayReference<L> extends WeakReference<L> {
            final int index;

            public ArrayReference(L l6, int i5, ReferenceQueue<L> referenceQueue) {
                super(l6, referenceQueue);
                this.index = i5;
            }
        }

        public SmallLazyStriped(int i5, Supplier<L> supplier) {
            super(i5);
            this.queue = new ReferenceQueue<>();
            int i6 = this.mask;
            int i7 = i6 == -1 ? Integer.MAX_VALUE : i6 + 1;
            this.size = i7;
            this.locks = new AtomicReferenceArray<>(i7);
            this.supplier = supplier;
        }

        private void drainQueue() {
            while (true) {
                Reference<? extends L> referencePoll = this.queue.poll();
                if (referencePoll == null) {
                    return;
                }
                ArrayReference<? extends L> arrayReference = (ArrayReference) referencePoll;
                AtomicReferenceArray<ArrayReference<? extends L>> atomicReferenceArray = this.locks;
                int i5 = arrayReference.index;
                while (!atomicReferenceArray.compareAndSet(i5, arrayReference, null) && atomicReferenceArray.get(i5) == arrayReference) {
                }
            }
        }

        @Override // com.google.common.util.concurrent.Striped
        public L getAt(int i5) {
            L l6;
            if (this.size != Integer.MAX_VALUE) {
                Preconditions.checkElementIndex(i5, size());
            }
            ArrayReference<? extends L> arrayReference = this.locks.get(i5);
            L l7 = arrayReference == null ? null : arrayReference.get();
            if (l7 != null) {
                return l7;
            }
            L l8 = this.supplier.get();
            ArrayReference<? extends L> arrayReference2 = new ArrayReference<>(l8, i5, this.queue);
            do {
                AtomicReferenceArray<ArrayReference<? extends L>> atomicReferenceArray = this.locks;
                do {
                    if (atomicReferenceArray.compareAndSet(i5, arrayReference, arrayReference2)) {
                        drainQueue();
                        return l8;
                    }
                } while (atomicReferenceArray.get(i5) == arrayReference);
                arrayReference = this.locks.get(i5);
                l6 = arrayReference == null ? null : arrayReference.get();
            } while (l6 == null);
            return l6;
        }

        @Override // com.google.common.util.concurrent.Striped
        public int size() {
            return this.size;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class WeakSafeCondition extends ForwardingCondition {
        private final Condition delegate;
        private final WeakSafeReadWriteLock strongReference;

        public WeakSafeCondition(Condition condition, WeakSafeReadWriteLock weakSafeReadWriteLock) {
            this.delegate = condition;
            this.strongReference = weakSafeReadWriteLock;
        }

        @Override // com.google.common.util.concurrent.ForwardingCondition
        public Condition delegate() {
            return this.delegate;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class WeakSafeLock extends ForwardingLock {
        private final Lock delegate;
        private final WeakSafeReadWriteLock strongReference;

        public WeakSafeLock(Lock lock, WeakSafeReadWriteLock weakSafeReadWriteLock) {
            this.delegate = lock;
            this.strongReference = weakSafeReadWriteLock;
        }

        @Override // com.google.common.util.concurrent.ForwardingLock
        public Lock delegate() {
            return this.delegate;
        }

        @Override // com.google.common.util.concurrent.ForwardingLock, java.util.concurrent.locks.Lock
        public Condition newCondition() {
            return new WeakSafeCondition(this.delegate.newCondition(), this.strongReference);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class WeakSafeReadWriteLock implements ReadWriteLock {
        private final ReadWriteLock delegate = new ReentrantReadWriteLock();

        @Override // java.util.concurrent.locks.ReadWriteLock
        public Lock readLock() {
            return new WeakSafeLock(this.delegate.readLock(), this);
        }

        @Override // java.util.concurrent.locks.ReadWriteLock
        public Lock writeLock() {
            return new WeakSafeLock(this.delegate.writeLock(), this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int ceilToPowerOfTwo(int i5) {
        return 1 << IntMath.log2(i5, RoundingMode.CEILING);
    }

    public static <L> Striped<L> custom(int i5, Supplier<L> supplier) {
        return new CompactStriped(i5, supplier);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Lock lambda$lazyWeakLock$0() {
        return new ReentrantLock(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Semaphore lambda$lazyWeakSemaphore$2(int i5) {
        return new Semaphore(i5, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Semaphore lambda$semaphore$1(int i5) {
        return new PaddedSemaphore(i5);
    }

    private static <L> Striped<L> lazy(int i5, Supplier<L> supplier) {
        return i5 < 1024 ? new SmallLazyStriped(i5, supplier) : new LargeLazyStriped(i5, supplier);
    }

    public static Striped<Lock> lazyWeakLock(int i5) {
        return lazy(i5, new j(2));
    }

    public static Striped<ReadWriteLock> lazyWeakReadWriteLock(int i5) {
        return lazy(i5, new j(0));
    }

    public static Striped<Semaphore> lazyWeakSemaphore(int i5, int i6) {
        return lazy(i5, new k(i6, 1));
    }

    public static Striped<Lock> lock(int i5) {
        return custom(i5, new j(1));
    }

    public static Striped<ReadWriteLock> readWriteLock(int i5) {
        return custom(i5, new j(3));
    }

    public static Striped<Semaphore> semaphore(int i5, int i6) {
        return custom(i5, new k(i6, 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int smear(int i5) {
        int i6 = i5 ^ ((i5 >>> 20) ^ (i5 >>> 12));
        return (i6 >>> 4) ^ ((i6 >>> 7) ^ i6);
    }

    public Iterable<L> bulkGet(Iterable<? extends Object> iterable) {
        ArrayList arrayListNewArrayList = Lists.newArrayList(iterable);
        if (arrayListNewArrayList.isEmpty()) {
            return ImmutableList.of();
        }
        int[] iArr = new int[arrayListNewArrayList.size()];
        for (int i5 = 0; i5 < arrayListNewArrayList.size(); i5++) {
            iArr[i5] = indexFor(arrayListNewArrayList.get(i5));
        }
        Arrays.sort(iArr);
        int i6 = iArr[0];
        arrayListNewArrayList.set(0, getAt(i6));
        for (int i7 = 1; i7 < arrayListNewArrayList.size(); i7++) {
            int i8 = iArr[i7];
            if (i8 == i6) {
                arrayListNewArrayList.set(i7, arrayListNewArrayList.get(i7 - 1));
            } else {
                arrayListNewArrayList.set(i7, getAt(i8));
                i6 = i8;
            }
        }
        return Collections.unmodifiableList(arrayListNewArrayList);
    }

    public abstract L get(Object obj);

    public abstract L getAt(int i5);

    public abstract int indexFor(Object obj);

    public abstract int size();

    private Striped() {
    }
}
