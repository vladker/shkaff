package org.apache.commons.math3.exception;

import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.MathArrays;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class NonMonotonicSequenceException extends MathIllegalNumberException {
    private static final long serialVersionUID = 3596849179428944575L;
    private final MathArrays.OrderDirection direction;
    private final int index;
    private final Number previous;
    private final boolean strict;

    public NonMonotonicSequenceException(Number number, Number number2, int i5) {
        this(number, number2, i5, MathArrays.OrderDirection.INCREASING, true);
    }

    public MathArrays.OrderDirection getDirection() {
        return this.direction;
    }

    public int getIndex() {
        return this.index;
    }

    public Number getPrevious() {
        return this.previous;
    }

    public boolean getStrict() {
        return this.strict;
    }

    public NonMonotonicSequenceException(Number number, Number number2, int i5, MathArrays.OrderDirection orderDirection, boolean z6) {
        super(orderDirection == MathArrays.OrderDirection.INCREASING ? z6 ? LocalizedFormats.NOT_STRICTLY_INCREASING_SEQUENCE : LocalizedFormats.NOT_INCREASING_SEQUENCE : z6 ? LocalizedFormats.NOT_STRICTLY_DECREASING_SEQUENCE : LocalizedFormats.NOT_DECREASING_SEQUENCE, number, number2, Integer.valueOf(i5), Integer.valueOf(i5 - 1));
        this.direction = orderDirection;
        this.strict = z6;
        this.index = i5;
        this.previous = number2;
    }
}
