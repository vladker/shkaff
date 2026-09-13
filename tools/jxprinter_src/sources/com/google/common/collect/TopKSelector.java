package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.math.IntMath;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
@GwtCompatible
@ElementTypesAreNonnullByDefault
final class TopKSelector<T> {
    private final T[] buffer;
    private int bufferSize;
    private final Comparator<? super T> comparator;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final int f3407k;
    private T threshold;

    private TopKSelector(Comparator<? super T> comparator, int i5) {
        this.comparator = (Comparator) Preconditions.checkNotNull(comparator, "comparator");
        this.f3407k = i5;
        Preconditions.checkArgument(i5 >= 0, "k (%s) must be >= 0", i5);
        Preconditions.checkArgument(i5 <= 1073741823, "k (%s) must be <= Integer.MAX_VALUE / 2", i5);
        this.buffer = (T[]) new Object[IntMath.checkedMultiply(i5, 2)];
        this.bufferSize = 0;
        this.threshold = null;
    }

    public static <T extends Comparable<? super T>> TopKSelector<T> greatest(int i5) {
        return greatest(i5, Ordering.natural());
    }

    public static <T extends Comparable<? super T>> TopKSelector<T> least(int i5) {
        return least(i5, Ordering.natural());
    }

    private int partition(int i5, int i6, int i7) {
        Object objUncheckedCastNullableTToT = NullnessCasts.uncheckedCastNullableTToT(this.buffer[i7]);
        T[] tArr = this.buffer;
        tArr[i7] = tArr[i6];
        int i8 = i5;
        while (i5 < i6) {
            if (this.comparator.compare((Object) NullnessCasts.uncheckedCastNullableTToT(this.buffer[i5]), objUncheckedCastNullableTToT) < 0) {
                swap(i8, i5);
                i8++;
            }
            i5++;
        }
        T[] tArr2 = this.buffer;
        tArr2[i6] = tArr2[i8];
        tArr2[i8] = objUncheckedCastNullableTToT;
        return i8;
    }

    private void swap(int i5, int i6) {
        T[] tArr = this.buffer;
        T t6 = tArr[i5];
        tArr[i5] = tArr[i6];
        tArr[i6] = t6;
    }

    private void trim() {
        int i5 = (this.f3407k * 2) - 1;
        int iLog2 = IntMath.log2(i5, RoundingMode.CEILING) * 3;
        int iMax = 0;
        int i6 = 0;
        int i7 = 0;
        while (iMax < i5) {
            int iPartition = partition(iMax, i5, ((iMax + i5) + 1) >>> 1);
            int i8 = this.f3407k;
            if (iPartition <= i8) {
                if (iPartition >= i8) {
                    break;
                }
                iMax = Math.max(iPartition, iMax + 1);
                i7 = iPartition;
            } else {
                i5 = iPartition - 1;
            }
            i6++;
            if (i6 >= iLog2) {
                Arrays.sort(this.buffer, iMax, i5 + 1, this.comparator);
                break;
            }
        }
        this.bufferSize = this.f3407k;
        this.threshold = (T) NullnessCasts.uncheckedCastNullableTToT(this.buffer[i7]);
        while (true) {
            i7++;
            if (i7 >= this.f3407k) {
                return;
            }
            if (this.comparator.compare((Object) NullnessCasts.uncheckedCastNullableTToT(this.buffer[i7]), (Object) NullnessCasts.uncheckedCastNullableTToT(this.threshold)) > 0) {
                this.threshold = this.buffer[i7];
            }
        }
    }

    public void offer(@ParametricNullness T t6) {
        int i5 = this.f3407k;
        if (i5 == 0) {
            return;
        }
        int i6 = this.bufferSize;
        if (i6 == 0) {
            this.buffer[0] = t6;
            this.threshold = t6;
            this.bufferSize = 1;
            return;
        }
        if (i6 < i5) {
            T[] tArr = this.buffer;
            this.bufferSize = i6 + 1;
            tArr[i6] = t6;
            if (this.comparator.compare(t6, (Object) NullnessCasts.uncheckedCastNullableTToT(this.threshold)) > 0) {
                this.threshold = t6;
                return;
            }
            return;
        }
        if (this.comparator.compare(t6, (Object) NullnessCasts.uncheckedCastNullableTToT(this.threshold)) < 0) {
            T[] tArr2 = this.buffer;
            int i7 = this.bufferSize;
            int i8 = i7 + 1;
            this.bufferSize = i8;
            tArr2[i7] = t6;
            if (i8 == this.f3407k * 2) {
                trim();
            }
        }
    }

    public void offerAll(Iterable<? extends T> iterable) {
        offerAll(iterable.iterator());
    }

    public List<T> topK() {
        Arrays.sort(this.buffer, 0, this.bufferSize, this.comparator);
        int i5 = this.bufferSize;
        int i6 = this.f3407k;
        if (i5 > i6) {
            T[] tArr = this.buffer;
            Arrays.fill(tArr, i6, tArr.length, (Object) null);
            int i7 = this.f3407k;
            this.bufferSize = i7;
            this.threshold = this.buffer[i7 - 1];
        }
        return Collections.unmodifiableList(Arrays.asList(Arrays.copyOf(this.buffer, this.bufferSize)));
    }

    public static <T> TopKSelector<T> greatest(int i5, Comparator<? super T> comparator) {
        return new TopKSelector<>(Ordering.from(comparator).reverse(), i5);
    }

    public static <T> TopKSelector<T> least(int i5, Comparator<? super T> comparator) {
        return new TopKSelector<>(comparator, i5);
    }

    public void offerAll(Iterator<? extends T> it) {
        while (it.hasNext()) {
            offer(it.next());
        }
    }
}
