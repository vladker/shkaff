package org.apache.commons.math3.fraction;

import org.apache.commons.math3.exception.ConvergenceException;
import org.apache.commons.math3.exception.util.LocalizedFormats;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class FractionConversionException extends ConvergenceException {
    private static final long serialVersionUID = -4661812640132576263L;

    public FractionConversionException(double d, int i5) {
        super(LocalizedFormats.FAILED_FRACTION_CONVERSION, Double.valueOf(d), Integer.valueOf(i5));
    }

    public FractionConversionException(double d, long j6, long j7) {
        super(LocalizedFormats.FRACTION_CONVERSION_OVERFLOW, Double.valueOf(d), Long.valueOf(j6), Long.valueOf(j7));
    }
}
