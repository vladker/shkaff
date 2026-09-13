package X3;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class T extends S {
    private static final StringBuilder append(StringBuilder sb, Object obj) {
        kotlin.jvm.internal.E.f(sb, "<this>");
        sb.append(obj);
        return sb;
    }

    private static final StringBuilder appendLine(StringBuilder sb) {
        kotlin.jvm.internal.E.f(sb, "<this>");
        sb.append('\n');
        return sb;
    }

    private static final String buildString(O3.l builderAction) {
        kotlin.jvm.internal.E.f(builderAction, "builderAction");
        StringBuilder sb = new StringBuilder();
        builderAction.invoke(sb);
        return sb.toString();
    }

    public static final StringBuilder append(StringBuilder sb, String... value) {
        kotlin.jvm.internal.E.f(sb, "<this>");
        kotlin.jvm.internal.E.f(value, "value");
        for (String str : value) {
            sb.append(str);
        }
        return sb;
    }

    private static final StringBuilder appendLine(StringBuilder sb, CharSequence charSequence) {
        kotlin.jvm.internal.E.f(sb, "<this>");
        sb.append(charSequence);
        sb.append('\n');
        return sb;
    }

    private static final String buildString(int i5, O3.l builderAction) {
        kotlin.jvm.internal.E.f(builderAction, "builderAction");
        StringBuilder sb = new StringBuilder(i5);
        builderAction.invoke(sb);
        return sb.toString();
    }

    private static final StringBuilder appendLine(StringBuilder sb, String str) {
        kotlin.jvm.internal.E.f(sb, "<this>");
        sb.append(str);
        sb.append('\n');
        return sb;
    }

    public static final StringBuilder append(StringBuilder sb, Object... value) {
        kotlin.jvm.internal.E.f(sb, "<this>");
        kotlin.jvm.internal.E.f(value, "value");
        for (Object obj : value) {
            sb.append(obj);
        }
        return sb;
    }

    private static final StringBuilder appendLine(StringBuilder sb, Object obj) {
        kotlin.jvm.internal.E.f(sb, "<this>");
        sb.append(obj);
        sb.append('\n');
        return sb;
    }

    private static final StringBuilder appendLine(StringBuilder sb, char[] value) {
        kotlin.jvm.internal.E.f(sb, "<this>");
        kotlin.jvm.internal.E.f(value, "value");
        sb.append(value);
        sb.append('\n');
        return sb;
    }

    private static final StringBuilder append(StringBuilder sb, char[] str, int i5, int i6) {
        kotlin.jvm.internal.E.f(sb, "<this>");
        kotlin.jvm.internal.E.f(str, "str");
        throw new p147z3.r();
    }

    private static final StringBuilder appendLine(StringBuilder sb, char c) {
        kotlin.jvm.internal.E.f(sb, "<this>");
        sb.append(c);
        sb.append('\n');
        return sb;
    }

    private static final StringBuilder appendLine(StringBuilder sb, boolean z6) {
        kotlin.jvm.internal.E.f(sb, "<this>");
        sb.append(z6);
        sb.append('\n');
        return sb;
    }
}
