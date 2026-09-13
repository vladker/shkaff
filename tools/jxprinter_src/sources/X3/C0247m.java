package X3;

import org.apache.logging.log4j.util.Chars;

/* JADX INFO: renamed from: X3.m, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0247m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f865a;
    public final int b;
    private String bytePrefix;
    private String byteSeparator;
    private String byteSuffix;
    private String groupSeparator;

    public C0247m() {
        C0248n c0248n = C0246l.b.Companion;
        this.f865a = c0248n.getDefault$kotlin_stdlib().f863a;
        this.b = c0248n.getDefault$kotlin_stdlib().b;
        this.groupSeparator = c0248n.getDefault$kotlin_stdlib().getGroupSeparator();
        this.byteSeparator = c0248n.getDefault$kotlin_stdlib().getByteSeparator();
        this.bytePrefix = c0248n.getDefault$kotlin_stdlib().getBytePrefix();
        this.byteSuffix = c0248n.getDefault$kotlin_stdlib().getByteSuffix();
    }

    public final C0246l.b build$kotlin_stdlib() {
        return new C0246l.b(this.f865a, this.b, this.groupSeparator, this.byteSeparator, this.bytePrefix, this.byteSuffix);
    }

    public final String getBytePrefix() {
        return this.bytePrefix;
    }

    public final String getByteSeparator() {
        return this.byteSeparator;
    }

    public final String getByteSuffix() {
        return this.byteSuffix;
    }

    public final String getGroupSeparator() {
        return this.groupSeparator;
    }

    public final void setBytePrefix(String value) {
        kotlin.jvm.internal.E.f(value, "value");
        if (b0.contains((CharSequence) value, '\n', false) || b0.contains((CharSequence) value, Chars.CR, false)) {
            throw new IllegalArgumentException("LF and CR characters are prohibited in bytePrefix, but was ".concat(value));
        }
        this.bytePrefix = value;
    }

    public final void setByteSeparator(String value) {
        kotlin.jvm.internal.E.f(value, "value");
        if (b0.contains((CharSequence) value, '\n', false) || b0.contains((CharSequence) value, Chars.CR, false)) {
            throw new IllegalArgumentException("LF and CR characters are prohibited in byteSeparator, but was ".concat(value));
        }
        this.byteSeparator = value;
    }

    public final void setByteSuffix(String value) {
        kotlin.jvm.internal.E.f(value, "value");
        if (b0.contains((CharSequence) value, '\n', false) || b0.contains((CharSequence) value, Chars.CR, false)) {
            throw new IllegalArgumentException("LF and CR characters are prohibited in byteSuffix, but was ".concat(value));
        }
        this.byteSuffix = value;
    }

    public final void setGroupSeparator(String str) {
        kotlin.jvm.internal.E.f(str, "<set-?>");
        this.groupSeparator = str;
    }
}
