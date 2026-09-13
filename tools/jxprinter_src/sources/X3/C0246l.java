package X3;

/* JADX INFO: renamed from: X3.l, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0246l {
    public static final C0249o Companion = new C0249o();
    private static final C0246l Default;
    private static final C0246l UpperCase;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f861a;
    private final b bytes;
    private final c number;

    /* JADX INFO: renamed from: X3.l$a */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class a {
        private C0247m _bytes;
        private C0250p _number;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f862a = C0246l.Companion.getDefault().f861a;

        private final void bytes(O3.l builderAction) {
            kotlin.jvm.internal.E.f(builderAction, "builderAction");
            builderAction.invoke(getBytes());
        }

        private final void number(O3.l builderAction) {
            kotlin.jvm.internal.E.f(builderAction, "builderAction");
            builderAction.invoke(getNumber());
        }

        public final C0246l build() {
            b default$kotlin_stdlib;
            c default$kotlin_stdlib2;
            C0247m c0247m = this._bytes;
            if (c0247m == null || (default$kotlin_stdlib = c0247m.build$kotlin_stdlib()) == null) {
                default$kotlin_stdlib = b.Companion.getDefault$kotlin_stdlib();
            }
            C0250p c0250p = this._number;
            if (c0250p == null || (default$kotlin_stdlib2 = c0250p.build$kotlin_stdlib()) == null) {
                default$kotlin_stdlib2 = c.Companion.getDefault$kotlin_stdlib();
            }
            return new C0246l(this.f862a, default$kotlin_stdlib, default$kotlin_stdlib2);
        }

        public final C0247m getBytes() {
            if (this._bytes == null) {
                this._bytes = new C0247m();
            }
            C0247m c0247m = this._bytes;
            kotlin.jvm.internal.E.c(c0247m);
            return c0247m;
        }

        public final C0250p getNumber() {
            if (this._number == null) {
                this._number = new C0250p();
            }
            C0250p c0250p = this._number;
            kotlin.jvm.internal.E.c(c0250p);
            return c0250p;
        }
    }

    /* JADX INFO: renamed from: X3.l$b */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class b {
        public static final C0248n Companion = new C0248n();
        private static final b Default = new b(Integer.MAX_VALUE, Integer.MAX_VALUE, "  ", "", "", "");

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f863a;
        public final int b;
        private final String bytePrefix;
        private final String byteSeparator;
        private final String byteSuffix;
        public final boolean c;
        public final boolean d;
        public final boolean e;
        private final String groupSeparator;

        public b(int i5, int i6, String groupSeparator, String byteSeparator, String bytePrefix, String byteSuffix) {
            kotlin.jvm.internal.E.f(groupSeparator, "groupSeparator");
            kotlin.jvm.internal.E.f(byteSeparator, "byteSeparator");
            kotlin.jvm.internal.E.f(bytePrefix, "bytePrefix");
            kotlin.jvm.internal.E.f(byteSuffix, "byteSuffix");
            this.f863a = i5;
            this.b = i6;
            this.groupSeparator = groupSeparator;
            this.byteSeparator = byteSeparator;
            this.bytePrefix = bytePrefix;
            this.byteSuffix = byteSuffix;
            this.c = i5 == Integer.MAX_VALUE && i6 == Integer.MAX_VALUE;
            this.d = bytePrefix.length() == 0 && byteSuffix.length() == 0 && byteSeparator.length() <= 1;
            this.e = r.a(groupSeparator) || r.a(byteSeparator) || r.a(bytePrefix) || r.a(byteSuffix);
        }

        public final StringBuilder appendOptionsTo$kotlin_stdlib(StringBuilder sb, String indent) {
            kotlin.jvm.internal.E.f(sb, "sb");
            kotlin.jvm.internal.E.f(indent, "indent");
            sb.append(indent);
            sb.append("bytesPerLine = ");
            sb.append(this.f863a);
            sb.append(",");
            sb.append('\n');
            sb.append(indent);
            sb.append("bytesPerGroup = ");
            sb.append(this.b);
            sb.append(",");
            sb.append('\n');
            sb.append(indent);
            sb.append("groupSeparator = \"");
            sb.append(this.groupSeparator);
            sb.append("\",");
            sb.append('\n');
            sb.append(indent);
            sb.append("byteSeparator = \"");
            sb.append(this.byteSeparator);
            sb.append("\",");
            sb.append('\n');
            sb.append(indent);
            sb.append("bytePrefix = \"");
            sb.append(this.bytePrefix);
            sb.append("\",");
            sb.append('\n');
            sb.append(indent);
            sb.append("byteSuffix = \"");
            sb.append(this.byteSuffix);
            sb.append("\"");
            return sb;
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

        public String toString() {
            StringBuilder sbR = androidx.collection.a.r("BytesHexFormat(\n");
            appendOptionsTo$kotlin_stdlib(sbR, "    ").append('\n');
            sbR.append(")");
            return sbR.toString();
        }
    }

    static {
        C0248n c0248n = b.Companion;
        b default$kotlin_stdlib = c0248n.getDefault$kotlin_stdlib();
        C0251q c0251q = c.Companion;
        Default = new C0246l(false, default$kotlin_stdlib, c0251q.getDefault$kotlin_stdlib());
        UpperCase = new C0246l(true, c0248n.getDefault$kotlin_stdlib(), c0251q.getDefault$kotlin_stdlib());
    }

    public C0246l(boolean z6, b bytes, c number) {
        kotlin.jvm.internal.E.f(bytes, "bytes");
        kotlin.jvm.internal.E.f(number, "number");
        this.f861a = z6;
        this.bytes = bytes;
        this.number = number;
    }

    public final b getBytes() {
        return this.bytes;
    }

    public final c getNumber() {
        return this.number;
    }

    public String toString() {
        StringBuilder sbR = androidx.collection.a.r("HexFormat(\n    upperCase = ");
        sbR.append(this.f861a);
        sbR.append(",\n    bytes = BytesHexFormat(\n");
        this.bytes.appendOptionsTo$kotlin_stdlib(sbR, "        ").append('\n');
        sbR.append("    ),");
        sbR.append('\n');
        sbR.append("    number = NumberHexFormat(");
        sbR.append('\n');
        this.number.appendOptionsTo$kotlin_stdlib(sbR, "        ").append('\n');
        sbR.append("    )");
        sbR.append('\n');
        sbR.append(")");
        return sbR.toString();
    }

    /* JADX INFO: renamed from: X3.l$c */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class c {
        public static final C0251q Companion = new C0251q();
        private static final c Default = new c("", "", false, 1);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f864a;
        public final int b;
        public final boolean c;
        public final boolean d;
        public final boolean e;
        private final String prefix;
        private final String suffix;

        public c(String prefix, String suffix, boolean z6, int i5) {
            kotlin.jvm.internal.E.f(prefix, "prefix");
            kotlin.jvm.internal.E.f(suffix, "suffix");
            this.prefix = prefix;
            this.suffix = suffix;
            this.f864a = z6;
            this.b = i5;
            boolean z7 = prefix.length() == 0 && suffix.length() == 0;
            this.c = z7;
            this.d = z7 && i5 == 1;
            this.e = r.a(prefix) || r.a(suffix);
        }

        public final StringBuilder appendOptionsTo$kotlin_stdlib(StringBuilder sb, String indent) {
            kotlin.jvm.internal.E.f(sb, "sb");
            kotlin.jvm.internal.E.f(indent, "indent");
            sb.append(indent);
            sb.append("prefix = \"");
            sb.append(this.prefix);
            sb.append("\",");
            sb.append('\n');
            sb.append(indent);
            sb.append("suffix = \"");
            sb.append(this.suffix);
            sb.append("\",");
            sb.append('\n');
            sb.append(indent);
            sb.append("removeLeadingZeros = ");
            sb.append(this.f864a);
            sb.append(',');
            sb.append('\n');
            sb.append(indent);
            sb.append("minLength = ");
            sb.append(this.b);
            return sb;
        }

        public final String getPrefix() {
            return this.prefix;
        }

        public final String getSuffix() {
            return this.suffix;
        }

        public String toString() {
            StringBuilder sbR = androidx.collection.a.r("NumberHexFormat(\n");
            appendOptionsTo$kotlin_stdlib(sbR, "    ").append('\n');
            sbR.append(")");
            return sbR.toString();
        }

        public static /* synthetic */ void getMinLength$annotations() {
        }
    }
}
