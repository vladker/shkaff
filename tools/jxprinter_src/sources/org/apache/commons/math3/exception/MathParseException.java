package org.apache.commons.math3.exception;

import org.apache.commons.math3.exception.util.ExceptionContextProvider;
import org.apache.commons.math3.exception.util.LocalizedFormats;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class MathParseException extends MathIllegalStateException implements ExceptionContextProvider {
    private static final long serialVersionUID = -6024911025449780478L;

    public MathParseException(String str, int i5, Class<?> cls) {
        getContext().addMessage(LocalizedFormats.CANNOT_PARSE_AS_TYPE, str, Integer.valueOf(i5), cls.getName());
    }

    public MathParseException(String str, int i5) {
        getContext().addMessage(LocalizedFormats.CANNOT_PARSE, str, Integer.valueOf(i5));
    }
}
