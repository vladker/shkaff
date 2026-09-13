package X3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class E {
    public final String escape(String literal) {
        kotlin.jvm.internal.E.f(literal, "literal");
        String strQuote = Pattern.quote(literal);
        kotlin.jvm.internal.E.e(strQuote, "quote(...)");
        return strQuote;
    }

    public final String escapeReplacement(String literal) {
        kotlin.jvm.internal.E.f(literal, "literal");
        String strQuoteReplacement = Matcher.quoteReplacement(literal);
        kotlin.jvm.internal.E.e(strQuoteReplacement, "quoteReplacement(...)");
        return strQuoteReplacement;
    }

    public final G fromLiteral(String literal) {
        kotlin.jvm.internal.E.f(literal, "literal");
        return new G(literal, K.LITERAL);
    }
}
