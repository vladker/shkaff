package org.apache.commons.math3.exception;

import org.apache.commons.math3.exception.util.Localizable;
import org.apache.commons.math3.exception.util.LocalizedFormats;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class DimensionMismatchException extends MathIllegalNumberException {
    private static final long serialVersionUID = -8415396756375798143L;
    private final int dimension;

    public DimensionMismatchException(Localizable localizable, int i5, int i6) {
        super(localizable, Integer.valueOf(i5), Integer.valueOf(i6));
        this.dimension = i6;
    }

    public int getDimension() {
        return this.dimension;
    }

    public DimensionMismatchException(int i5, int i6) {
        this(LocalizedFormats.DIMENSIONS_MISMATCH_SIMPLE, i5, i6);
    }
}
