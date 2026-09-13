package org.apache.commons.math3.util;

import A3.AbstractC0157z;
import java.util.Iterator;
import org.apache.commons.math3.exception.MathUnsupportedOperationException;
import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.ZeroException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class IntegerSequence {

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class Incrementor implements Iterator<Integer> {
        private static final MaxCountExceededCallback CALLBACK = new MaxCountExceededCallback() { // from class: org.apache.commons.math3.util.IntegerSequence.Incrementor.1
            @Override // org.apache.commons.math3.util.IntegerSequence.Incrementor.MaxCountExceededCallback
            public void trigger(int i5) {
                throw new MaxCountExceededException(Integer.valueOf(i5));
            }
        };
        private int count;
        private final int increment;
        private final int init;
        private final MaxCountExceededCallback maxCountCallback;
        private final int maximalCount;

        /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
        public interface MaxCountExceededCallback {
            void trigger(int i5);
        }

        private Incrementor(int i5, int i6, int i7, MaxCountExceededCallback maxCountExceededCallback) {
            this.count = 0;
            if (maxCountExceededCallback == null) {
                throw new NullArgumentException();
            }
            this.init = i5;
            this.maximalCount = i6;
            this.increment = i7;
            this.maxCountCallback = maxCountExceededCallback;
            this.count = i5;
        }

        public static Incrementor create() {
            return new Incrementor(0, 0, 1, CALLBACK);
        }

        public boolean canIncrement() {
            return canIncrement(1);
        }

        public int getCount() {
            return this.count;
        }

        public int getMaximalCount() {
            return this.maximalCount;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return canIncrement(0);
        }

        public void increment(int i5) {
            if (i5 <= 0) {
                throw new NotStrictlyPositiveException(Integer.valueOf(i5));
            }
            if (!canIncrement(0)) {
                this.maxCountCallback.trigger(this.maximalCount);
            }
            this.count = (i5 * this.increment) + this.count;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new MathUnsupportedOperationException();
        }

        public Incrementor withCallback(MaxCountExceededCallback maxCountExceededCallback) {
            return new Incrementor(this.init, this.maximalCount, this.increment, maxCountExceededCallback);
        }

        public Incrementor withIncrement(int i5) {
            if (i5 != 0) {
                return new Incrementor(this.init, this.maximalCount, i5, this.maxCountCallback);
            }
            throw new ZeroException();
        }

        public Incrementor withMaximalCount(int i5) {
            return new Incrementor(this.init, i5, this.increment, this.maxCountCallback);
        }

        public Incrementor withStart(int i5) {
            return new Incrementor(i5, this.maximalCount, this.increment, this.maxCountCallback);
        }

        public boolean canIncrement(int i5) {
            int i6 = this.count;
            int i7 = this.increment;
            int i8 = (i5 * i7) + i6;
            if (i7 < 0) {
                return i8 > this.maximalCount;
            }
            return i8 < this.maximalCount;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public Integer next() {
            int i5 = this.count;
            increment();
            return Integer.valueOf(i5);
        }

        public void increment() {
            increment(1);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class Range implements Iterable<Integer> {
        private final int max;
        private final int size;
        private final int start;
        private final int step;

        public Range(int i5, int i6, int i7) {
            this.start = i5;
            this.max = i6;
            this.step = i7;
            int iB = AbstractC0157z.b(i6, i5, i7, 1);
            this.size = iB < 0 ? 0 : iB;
        }

        @Override // java.lang.Iterable
        public Iterator<Integer> iterator() {
            return Incrementor.create().withStart(this.start).withMaximalCount(this.max + (this.step > 0 ? 1 : -1)).withIncrement(this.step);
        }

        public int size() {
            return this.size;
        }
    }

    private IntegerSequence() {
    }

    public static Range range(int i5, int i6) {
        return range(i5, i6, 1);
    }

    public static Range range(int i5, int i6, int i7) {
        return new Range(i5, i6, i7);
    }
}
