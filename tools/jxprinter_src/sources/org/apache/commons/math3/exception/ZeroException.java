package org.apache.commons.math3.exception;

import org.apache.commons.math3.exception.util.Localizable;
import org.apache.commons.math3.exception.util.LocalizedFormats;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class ZeroException extends MathIllegalNumberException {
    private static final long serialVersionUID = -1960874856936000015L;

    public ZeroException() {
        this(LocalizedFormats.ZERO_NOT_ALLOWED, new Object[0]);
    }

    public ZeroException(Localizable localizable, Object... objArr) {
        super(localizable, MathIllegalNumberException.INTEGER_ZERO, objArr);
    }
}
