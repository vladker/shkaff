package X3;

import org.apache.logging.log4j.util.Chars;

/* JADX INFO: renamed from: X3.p, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0250p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f866a;
    public final int b;
    private String prefix;
    private String suffix;

    public C0250p() {
        C0251q c0251q = C0246l.c.Companion;
        this.prefix = c0251q.getDefault$kotlin_stdlib().getPrefix();
        this.suffix = c0251q.getDefault$kotlin_stdlib().getSuffix();
        this.f866a = c0251q.getDefault$kotlin_stdlib().f864a;
        this.b = c0251q.getDefault$kotlin_stdlib().b;
    }

    public final C0246l.c build$kotlin_stdlib() {
        return new C0246l.c(this.prefix, this.suffix, this.f866a, this.b);
    }

    public final String getPrefix() {
        return this.prefix;
    }

    public final String getSuffix() {
        return this.suffix;
    }

    public final void setPrefix(String value) {
        kotlin.jvm.internal.E.f(value, "value");
        if (b0.contains((CharSequence) value, '\n', false) || b0.contains((CharSequence) value, Chars.CR, false)) {
            throw new IllegalArgumentException("LF and CR characters are prohibited in prefix, but was ".concat(value));
        }
        this.prefix = value;
    }

    public final void setSuffix(String value) {
        kotlin.jvm.internal.E.f(value, "value");
        if (b0.contains((CharSequence) value, '\n', false) || b0.contains((CharSequence) value, Chars.CR, false)) {
            throw new IllegalArgumentException("LF and CR characters are prohibited in suffix, but was ".concat(value));
        }
        this.suffix = value;
    }

    public static /* synthetic */ void getMinLength$annotations() {
    }
}
