package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.math.IntMath;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.j2objc.annotations.Weak;
import java.util.AbstractQueue;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Queue;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
@Beta
@GwtCompatible
@ElementTypesAreNonnullByDefault
public final class MinMaxPriorityQueue<E> extends AbstractQueue<E> {
    private static final int DEFAULT_CAPACITY = 11;
    private static final int EVEN_POWERS_OF_TWO = 1431655765;
    private static final int ODD_POWERS_OF_TWO = -1431655766;
    private final MinMaxPriorityQueue<E>.Heap maxHeap;

    @VisibleForTesting
    final int maximumSize;
    private final MinMaxPriorityQueue<E>.Heap minHeap;
    private int modCount;
    private Object[] queue;
    private int size;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    @Beta
    public static final class Builder<B> {
        private static final int UNSET_EXPECTED_SIZE = -1;
        private final Comparator<B> comparator;
        private int expectedSize;
        private int maximumSize;

        /* JADX INFO: Access modifiers changed from: private */
        public <T extends B> Ordering<T> ordering() {
            return Ordering.from(this.comparator);
        }

        public <T extends B> MinMaxPriorityQueue<T> create() {
            return create(Collections.EMPTY_SET);
        }

        @CanIgnoreReturnValue
        public Builder<B> expectedSize(int i5) {
            Preconditions.checkArgument(i5 >= 0);
            this.expectedSize = i5;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<B> maximumSize(int i5) {
            Preconditions.checkArgument(i5 > 0);
            this.maximumSize = i5;
            return this;
        }

        private Builder(Comparator<B> comparator) {
            this.expectedSize = -1;
            this.maximumSize = Integer.MAX_VALUE;
            this.comparator = (Comparator) Preconditions.checkNotNull(comparator);
        }

        public <T extends B> MinMaxPriorityQueue<T> create(Iterable<? extends T> iterable) {
            MinMaxPriorityQueue<T> minMaxPriorityQueue = new MinMaxPriorityQueue<>(this, MinMaxPriorityQueue.initialQueueSize(this.expectedSize, this.maximumSize, iterable));
            Iterator<? extends T> it = iterable.iterator();
            while (it.hasNext()) {
                minMaxPriorityQueue.offer(it.next());
            }
            return minMaxPriorityQueue;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class Heap {
        final Ordering<E> ordering;

        @Weak
        MinMaxPriorityQueue<E>.Heap otherHeap;

        public Heap(Ordering<E> ordering) {
            this.ordering = ordering;
        }

        private int getGrandparentIndex(int i5) {
            return getParentIndex(getParentIndex(i5));
        }

        private int getLeftChildIndex(int i5) {
            return (i5 * 2) + 1;
        }

        private int getParentIndex(int i5) {
            return (i5 - 1) / 2;
        }

        private int getRightChildIndex(int i5) {
            return (i5 * 2) + 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean verifyIndex(int i5) {
            if (getLeftChildIndex(i5) < MinMaxPriorityQueue.this.size && compareElements(i5, getLeftChildIndex(i5)) > 0) {
                return false;
            }
            if (getRightChildIndex(i5) < MinMaxPriorityQueue.this.size && compareElements(i5, getRightChildIndex(i5)) > 0) {
                return false;
            }
            if (i5 <= 0 || compareElements(i5, getParentIndex(i5)) <= 0) {
                return i5 <= 2 || compareElements(getGrandparentIndex(i5), i5) <= 0;
            }
            return false;
        }

        public void bubbleUp(int i5, E e) {
            Heap heap;
            int iCrossOverUp = crossOverUp(i5, e);
            if (iCrossOverUp == i5) {
                iCrossOverUp = i5;
                heap = this;
            } else {
                heap = this.otherHeap;
            }
            heap.bubbleUpAlternatingLevels(iCrossOverUp, e);
        }

        @CanIgnoreReturnValue
        public int bubbleUpAlternatingLevels(int i5, E e) {
            while (i5 > 2) {
                int grandparentIndex = getGrandparentIndex(i5);
                Object objElementData = MinMaxPriorityQueue.this.elementData(grandparentIndex);
                if (this.ordering.compare((E) objElementData, e) <= 0) {
                    break;
                }
                MinMaxPriorityQueue.this.queue[i5] = objElementData;
                i5 = grandparentIndex;
            }
            MinMaxPriorityQueue.this.queue[i5] = e;
            return i5;
        }

        public int compareElements(int i5, int i6) {
            return this.ordering.compare((E) MinMaxPriorityQueue.this.elementData(i5), (E) MinMaxPriorityQueue.this.elementData(i6));
        }

        public int crossOver(int i5, E e) {
            int iFindMinChild = findMinChild(i5);
            if (iFindMinChild <= 0 || this.ordering.compare((E) MinMaxPriorityQueue.this.elementData(iFindMinChild), e) >= 0) {
                return crossOverUp(i5, e);
            }
            MinMaxPriorityQueue.this.queue[i5] = MinMaxPriorityQueue.this.elementData(iFindMinChild);
            MinMaxPriorityQueue.this.queue[iFindMinChild] = e;
            return iFindMinChild;
        }

        public int crossOverUp(int i5, E e) {
            int rightChildIndex;
            if (i5 == 0) {
                MinMaxPriorityQueue.this.queue[0] = e;
                return 0;
            }
            int parentIndex = getParentIndex(i5);
            Object objElementData = MinMaxPriorityQueue.this.elementData(parentIndex);
            if (parentIndex != 0 && (rightChildIndex = getRightChildIndex(getParentIndex(parentIndex))) != parentIndex && getLeftChildIndex(rightChildIndex) >= MinMaxPriorityQueue.this.size) {
                Object objElementData2 = MinMaxPriorityQueue.this.elementData(rightChildIndex);
                if (this.ordering.compare((E) objElementData2, (E) objElementData) < 0) {
                    parentIndex = rightChildIndex;
                    objElementData = objElementData2;
                }
            }
            if (this.ordering.compare((E) objElementData, e) >= 0) {
                MinMaxPriorityQueue.this.queue[i5] = e;
                return i5;
            }
            MinMaxPriorityQueue.this.queue[i5] = objElementData;
            MinMaxPriorityQueue.this.queue[parentIndex] = e;
            return parentIndex;
        }

        public int fillHoleAt(int i5) {
            while (true) {
                int iFindMinGrandChild = findMinGrandChild(i5);
                if (iFindMinGrandChild <= 0) {
                    return i5;
                }
                MinMaxPriorityQueue.this.queue[i5] = MinMaxPriorityQueue.this.elementData(iFindMinGrandChild);
                i5 = iFindMinGrandChild;
            }
        }

        public int findMin(int i5, int i6) {
            if (i5 >= MinMaxPriorityQueue.this.size) {
                return -1;
            }
            Preconditions.checkState(i5 > 0);
            int iMin = Math.min(i5, MinMaxPriorityQueue.this.size - i6) + i6;
            for (int i7 = i5 + 1; i7 < iMin; i7++) {
                if (compareElements(i7, i5) < 0) {
                    i5 = i7;
                }
            }
            return i5;
        }

        public int findMinChild(int i5) {
            return findMin(getLeftChildIndex(i5), 2);
        }

        public int findMinGrandChild(int i5) {
            int leftChildIndex = getLeftChildIndex(i5);
            if (leftChildIndex < 0) {
                return -1;
            }
            return findMin(getLeftChildIndex(leftChildIndex), 4);
        }

        public int swapWithConceptuallyLastElement(E e) {
            int rightChildIndex;
            int parentIndex = getParentIndex(MinMaxPriorityQueue.this.size);
            if (parentIndex != 0 && (rightChildIndex = getRightChildIndex(getParentIndex(parentIndex))) != parentIndex && getLeftChildIndex(rightChildIndex) >= MinMaxPriorityQueue.this.size) {
                Object objElementData = MinMaxPriorityQueue.this.elementData(rightChildIndex);
                if (this.ordering.compare((E) objElementData, e) < 0) {
                    MinMaxPriorityQueue.this.queue[rightChildIndex] = e;
                    MinMaxPriorityQueue.this.queue[MinMaxPriorityQueue.this.size] = objElementData;
                    return rightChildIndex;
                }
            }
            return MinMaxPriorityQueue.this.size;
        }

        public MoveDesc<E> tryCrossOverAndBubbleUp(int i5, int i6, E e) {
            int iCrossOver = crossOver(i6, e);
            if (iCrossOver == i6) {
                return null;
            }
            Object objElementData = iCrossOver < i5 ? MinMaxPriorityQueue.this.elementData(i5) : MinMaxPriorityQueue.this.elementData(getParentIndex(i5));
            if (this.otherHeap.bubbleUpAlternatingLevels(iCrossOver, e) < i5) {
                return new MoveDesc<>(e, objElementData);
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class MoveDesc<E> {
        final E replaced;
        final E toTrickle;

        public MoveDesc(E e, E e6) {
            this.toTrickle = e;
            this.replaced = e6;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class QueueIterator implements Iterator<E> {
        private boolean canRemove;
        private int cursor;
        private int expectedModCount;
        private Queue<E> forgetMeNot;
        private E lastFromForgetMeNot;
        private int nextCursor;
        private List<E> skipMe;

        private QueueIterator() {
            this.cursor = -1;
            this.nextCursor = -1;
            this.expectedModCount = MinMaxPriorityQueue.this.modCount;
        }

        private void checkModCount() {
            if (MinMaxPriorityQueue.this.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
        }

        private boolean foundAndRemovedExactReference(Iterable<E> iterable, E e) {
            Iterator<E> it = iterable.iterator();
            while (it.hasNext()) {
                if (it.next() == e) {
                    it.remove();
                    return true;
                }
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private void nextNotInSkipMe(int i5) {
            if (this.nextCursor < i5) {
                if (this.skipMe != null) {
                    while (i5 < MinMaxPriorityQueue.this.size() && foundAndRemovedExactReference(this.skipMe, MinMaxPriorityQueue.this.elementData(i5))) {
                        i5++;
                    }
                }
                this.nextCursor = i5;
            }
        }

        private boolean removeExact(Object obj) {
            for (int i5 = 0; i5 < MinMaxPriorityQueue.this.size; i5++) {
                if (MinMaxPriorityQueue.this.queue[i5] == obj) {
                    MinMaxPriorityQueue.this.removeAt(i5);
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            Queue<E> queue;
            checkModCount();
            nextNotInSkipMe(this.cursor + 1);
            return this.nextCursor < MinMaxPriorityQueue.this.size() || !((queue = this.forgetMeNot) == null || queue.isEmpty());
        }

        @Override // java.util.Iterator
        public E next() {
            checkModCount();
            nextNotInSkipMe(this.cursor + 1);
            if (this.nextCursor < MinMaxPriorityQueue.this.size()) {
                int i5 = this.nextCursor;
                this.cursor = i5;
                this.canRemove = true;
                return (E) MinMaxPriorityQueue.this.elementData(i5);
            }
            if (this.forgetMeNot != null) {
                this.cursor = MinMaxPriorityQueue.this.size();
                E ePoll = this.forgetMeNot.poll();
                this.lastFromForgetMeNot = ePoll;
                if (ePoll != null) {
                    this.canRemove = true;
                    return ePoll;
                }
            }
            throw new NoSuchElementException("iterator moved past last element in queue.");
        }

        @Override // java.util.Iterator
        public void remove() {
            CollectPreconditions.checkRemove(this.canRemove);
            checkModCount();
            this.canRemove = false;
            this.expectedModCount++;
            if (this.cursor >= MinMaxPriorityQueue.this.size()) {
                E e = this.lastFromForgetMeNot;
                Objects.requireNonNull(e);
                Preconditions.checkState(removeExact(e));
                this.lastFromForgetMeNot = null;
                return;
            }
            MoveDesc<E> moveDescRemoveAt = MinMaxPriorityQueue.this.removeAt(this.cursor);
            if (moveDescRemoveAt != null) {
                if (this.forgetMeNot == null || this.skipMe == null) {
                    this.forgetMeNot = new ArrayDeque();
                    this.skipMe = new ArrayList(3);
                }
                if (!foundAndRemovedExactReference(this.skipMe, moveDescRemoveAt.toTrickle)) {
                    this.forgetMeNot.add(moveDescRemoveAt.toTrickle);
                }
                if (!foundAndRemovedExactReference(this.forgetMeNot, moveDescRemoveAt.replaced)) {
                    this.skipMe.add(moveDescRemoveAt.replaced);
                }
            }
            this.cursor--;
            this.nextCursor--;
        }
    }

    private int calculateNewCapacity() {
        int length = this.queue.length;
        return capAtMaximumSize(length < 64 ? (length + 1) * 2 : IntMath.checkedMultiply(length / 2, 3), this.maximumSize);
    }

    private static int capAtMaximumSize(int i5, int i6) {
        return Math.min(i5 - 1, i6) + 1;
    }

    public static <E extends Comparable<E>> MinMaxPriorityQueue<E> create() {
        return new Builder(Ordering.natural()).create();
    }

    public static Builder<Comparable> expectedSize(int i5) {
        return new Builder(Ordering.natural()).expectedSize(i5);
    }

    private MoveDesc<E> fillHole(int i5, E e) {
        MinMaxPriorityQueue<E>.Heap heapHeapForIndex = heapForIndex(i5);
        int iFillHoleAt = heapHeapForIndex.fillHoleAt(i5);
        int iBubbleUpAlternatingLevels = heapHeapForIndex.bubbleUpAlternatingLevels(iFillHoleAt, e);
        if (iBubbleUpAlternatingLevels == iFillHoleAt) {
            return heapHeapForIndex.tryCrossOverAndBubbleUp(i5, iFillHoleAt, e);
        }
        if (iBubbleUpAlternatingLevels < i5) {
            return new MoveDesc<>(e, elementData(i5));
        }
        return null;
    }

    private int getMaxElementIndex() {
        int i5 = this.size;
        if (i5 != 1) {
            return (i5 == 2 || this.maxHeap.compareElements(1, 2) <= 0) ? 1 : 2;
        }
        return 0;
    }

    private void growIfNeeded() {
        if (this.size > this.queue.length) {
            Object[] objArr = new Object[calculateNewCapacity()];
            Object[] objArr2 = this.queue;
            System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
            this.queue = objArr;
        }
    }

    private MinMaxPriorityQueue<E>.Heap heapForIndex(int i5) {
        return isEvenLevel(i5) ? this.minHeap : this.maxHeap;
    }

    @VisibleForTesting
    public static int initialQueueSize(int i5, int i6, Iterable<?> iterable) {
        if (i5 == -1) {
            i5 = 11;
        }
        if (iterable instanceof Collection) {
            i5 = Math.max(i5, ((Collection) iterable).size());
        }
        return capAtMaximumSize(i5, i6);
    }

    @VisibleForTesting
    public static boolean isEvenLevel(int i5) {
        int i6 = ~(~(i5 + 1));
        Preconditions.checkState(i6 > 0, "negative index");
        return (EVEN_POWERS_OF_TWO & i6) > (i6 & ODD_POWERS_OF_TWO);
    }

    public static Builder<Comparable> maximumSize(int i5) {
        return new Builder(Ordering.natural()).maximumSize(i5);
    }

    public static <B> Builder<B> orderedBy(Comparator<B> comparator) {
        return new Builder<>(comparator);
    }

    private E removeAndGet(int i5) {
        E eElementData = elementData(i5);
        removeAt(i5);
        return eElementData;
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection, java.util.Queue
    @CanIgnoreReturnValue
    public boolean add(E e) {
        offer(e);
        return true;
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    @CanIgnoreReturnValue
    public boolean addAll(Collection<? extends E> collection) {
        Iterator<? extends E> it = collection.iterator();
        boolean z6 = false;
        while (it.hasNext()) {
            offer(it.next());
            z6 = true;
        }
        return z6;
    }

    @VisibleForTesting
    public int capacity() {
        return this.queue.length;
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        for (int i5 = 0; i5 < this.size; i5++) {
            this.queue[i5] = null;
        }
        this.size = 0;
    }

    public Comparator<? super E> comparator() {
        return this.minHeap.ordering;
    }

    public E elementData(int i5) {
        E e = (E) this.queue[i5];
        Objects.requireNonNull(e);
        return e;
    }

    @VisibleForTesting
    public boolean isIntact() {
        for (int i5 = 1; i5 < this.size; i5++) {
            if (!heapForIndex(i5).verifyIndex(i5)) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        return new QueueIterator();
    }

    @Override // java.util.Queue
    @CanIgnoreReturnValue
    public boolean offer(E e) {
        Preconditions.checkNotNull(e);
        this.modCount++;
        int i5 = this.size;
        this.size = i5 + 1;
        growIfNeeded();
        heapForIndex(i5).bubbleUp(i5, e);
        return this.size <= this.maximumSize || pollLast() != e;
    }

    @Override // java.util.Queue
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return elementData(0);
    }

    public E peekFirst() {
        return peek();
    }

    public E peekLast() {
        if (isEmpty()) {
            return null;
        }
        return elementData(getMaxElementIndex());
    }

    @Override // java.util.Queue
    @CanIgnoreReturnValue
    public E poll() {
        if (isEmpty()) {
            return null;
        }
        return removeAndGet(0);
    }

    @CanIgnoreReturnValue
    public E pollFirst() {
        return poll();
    }

    @CanIgnoreReturnValue
    public E pollLast() {
        if (isEmpty()) {
            return null;
        }
        return removeAndGet(getMaxElementIndex());
    }

    @VisibleForTesting
    @CanIgnoreReturnValue
    public MoveDesc<E> removeAt(int i5) {
        Preconditions.checkPositionIndex(i5, this.size);
        this.modCount++;
        int i6 = this.size - 1;
        this.size = i6;
        if (i6 == i5) {
            this.queue[i6] = null;
            return null;
        }
        E eElementData = elementData(i6);
        int iSwapWithConceptuallyLastElement = heapForIndex(this.size).swapWithConceptuallyLastElement(eElementData);
        if (iSwapWithConceptuallyLastElement == i5) {
            this.queue[this.size] = null;
            return null;
        }
        E eElementData2 = elementData(this.size);
        this.queue[this.size] = null;
        MoveDesc<E> moveDescFillHole = fillHole(i5, eElementData2);
        if (iSwapWithConceptuallyLastElement < i5) {
            return moveDescFillHole == null ? new MoveDesc<>(eElementData, eElementData2) : new MoveDesc<>(eElementData, moveDescFillHole.replaced);
        }
        return moveDescFillHole;
    }

    @CanIgnoreReturnValue
    public E removeFirst() {
        return remove();
    }

    @CanIgnoreReturnValue
    public E removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return removeAndGet(getMaxElementIndex());
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        return this.size;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public Object[] toArray() {
        int i5 = this.size;
        Object[] objArr = new Object[i5];
        System.arraycopy(this.queue, 0, objArr, 0, i5);
        return objArr;
    }

    private MinMaxPriorityQueue(Builder<? super E> builder, int i5) {
        Ordering ordering = builder.ordering();
        MinMaxPriorityQueue<E>.Heap heap = new Heap(ordering);
        this.minHeap = heap;
        MinMaxPriorityQueue<E>.Heap heap2 = new Heap(ordering.reverse());
        this.maxHeap = heap2;
        heap.otherHeap = heap2;
        heap2.otherHeap = heap;
        this.maximumSize = ((Builder) builder).maximumSize;
        this.queue = new Object[i5];
    }

    public static <E extends Comparable<E>> MinMaxPriorityQueue<E> create(Iterable<? extends E> iterable) {
        return new Builder(Ordering.natural()).create(iterable);
    }
}
