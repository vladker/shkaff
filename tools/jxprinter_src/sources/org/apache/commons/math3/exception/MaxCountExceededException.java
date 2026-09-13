package org.apache.commons.math3.exception;

import org.apache.commons.math3.exception.util.Localizable;
import org.apache.commons.math3.exception.util.LocalizedFormats;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class MaxCountExceededException extends MathIllegalStateException {
    private static final long serialVersionUID = 4330003017885151975L;
    private final Number max;

    public MaxCountExceededException(Number number) {
        this(LocalizedFormats.MAX_COUNT_EXCEEDED, number, new Object[0]);
    }

    public Number getMax() {
        return this.max;
    }

    public MaxCountExceededException(Localizable localizable, Number number, Object... objArr) {
        getContext().addMessage(localizable, number, objArr);
        this.max = number;
    }
}
