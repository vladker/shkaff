package org.apache.commons.math3.util;

import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.exception.NullArgumentException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public class Incrementor {
    private int count;
    private final MaxCountExceededCallback maxCountCallback;
    private int maximalCount;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public interface MaxCountExceededCallback {
        void trigger(int i5);
    }

    public Incrementor() {
        this(0);
    }

    public static Incrementor wrap(IntegerSequence.Incrementor incrementor) {
        return new Incrementor() { // from class: org.apache.commons.math3.util.Incrementor.2
            private IntegerSequence.Incrementor delegate;

            {
                this.delegate = this.val$incrementor;
                super.setMaximalCount(this.val$incrementor.getMaximalCount());
                super.incrementCount(this.delegate.getCount());
            }

            @Override // org.apache.commons.math3.util.Incrementor
            public void incrementCount() {
                super.incrementCount();
                this.delegate.increment();
            }

            @Override // org.apache.commons.math3.util.Incrementor
            public void resetCount() {
                super.resetCount();
                this.delegate = this.delegate.withStart(0);
            }

            @Override // org.apache.commons.math3.util.Incrementor
            public void setMaximalCount(int i5) {
                super.setMaximalCount(i5);
                this.delegate = this.delegate.withMaximalCount(i5);
            }
        };
    }

    public boolean canIncrement() {
        return this.count < this.maximalCount;
    }

    public int getCount() {
        return this.count;
    }

    public int getMaximalCount() {
        return this.maximalCount;
    }

    public void incrementCount(int i5) {
        for (int i6 = 0; i6 < i5; i6++) {
            incrementCount();
        }
    }

    public void resetCount() {
        this.count = 0;
    }

    public void setMaximalCount(int i5) {
        this.maximalCount = i5;
    }

    public Incrementor(int i5) {
        this(i5, new MaxCountExceededCallback() { // from class: org.apache.commons.math3.util.Incrementor.1
            @Override // org.apache.commons.math3.util.Incrementor.MaxCountExceededCallback
            public void trigger(int i6) {
                throw new MaxCountExceededException(Integer.valueOf(i6));
            }
        });
    }

    public void incrementCount() {
        int i5 = this.count + 1;
        this.count = i5;
        int i6 = this.maximalCount;
        if (i5 > i6) {
            this.maxCountCallback.trigger(i6);
        }
    }

    public Incrementor(int i5, MaxCountExceededCallback maxCountExceededCallback) {
        this.count = 0;
        if (maxCountExceededCallback != null) {
            this.maximalCount = i5;
            this.maxCountCallback = maxCountExceededCallback;
            return;
        }
        throw new NullArgumentException();
    }
}
