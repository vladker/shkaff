package org.apache.commons.math3.exception;

import org.apache.commons.math3.exception.util.Localizable;
import org.apache.commons.math3.exception.util.LocalizedFormats;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class NoBracketingException extends MathIllegalArgumentException {
    private static final long serialVersionUID = -3629324471511904459L;
    private final double fHi;
    private final double fLo;
    private final double hi;
    private final double lo;

    public NoBracketingException(double d, double d6, double d7, double d8) {
        this(LocalizedFormats.SAME_SIGN_AT_ENDPOINTS, d, d6, d7, d8, new Object[0]);
    }

    public double getFHi() {
        return this.fHi;
    }

    public double getFLo() {
        return this.fLo;
    }

    public double getHi() {
        return this.hi;
    }

    public double getLo() {
        return this.lo;
    }

    public NoBracketingException(Localizable localizable, double d, double d6, double d7, double d8, Object... objArr) {
        super(localizable, Double.valueOf(d), Double.valueOf(d6), Double.valueOf(d7), Double.valueOf(d8), objArr);
        this.lo = d;
        this.hi = d6;
        this.fLo = d7;
        this.fHi = d8;
    }
}
