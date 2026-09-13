package org.apache.commons.math3.exception;

import org.apache.commons.math3.exception.util.Localizable;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class NotStrictlyPositiveException extends NumberIsTooSmallException {
    private static final long serialVersionUID = -7824848630829852237L;

    public NotStrictlyPositiveException(Number number) {
        super(number, MathIllegalNumberException.INTEGER_ZERO, false);
    }

    public NotStrictlyPositiveException(Localizable localizable, Number number) {
        super(localizable, number, MathIllegalNumberException.INTEGER_ZERO, false);
    }
}
