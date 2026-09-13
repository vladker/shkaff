package X3;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class S extends Q {
    private static final StringBuilder append(StringBuilder sb, byte b) {
        kotlin.jvm.internal.E.f(sb, "<this>");
        sb.append((int) b);
        return sb;
    }

    private static final StringBuilder appendLine(StringBuilder sb, StringBuffer stringBuffer) {
        kotlin.jvm.internal.E.f(sb, "<this>");
        sb.append(stringBuffer);
        sb.append('\n');
        return sb;
    }

    private static final StringBuilder appendRange(StringBuilder sb, char[] value, int i5, int i6) {
        kotlin.jvm.internal.E.f(sb, "<this>");
        kotlin.jvm.internal.E.f(value, "value");
        sb.append(value, i5, i6 - i5);
        return sb;
    }

    public static final Appendable appendln(Appendable appendable) throws IOException {
        kotlin.jvm.internal.E.f(appendable, "<this>");
        Appendable appendableAppend = appendable.append(f0.LINE_SEPARATOR);
        kotlin.jvm.internal.E.e(appendableAppend, "append(...)");
        return appendableAppend;
    }

    public static final StringBuilder clear(StringBuilder sb) {
        kotlin.jvm.internal.E.f(sb, "<this>");
        sb.setLength(0);
        return sb;
    }

    private static final StringBuilder deleteAt(StringBuilder sb, int i5) {
        kotlin.jvm.internal.E.f(sb, "<this>");
        StringBuilder sbDeleteCharAt = sb.deleteCharAt(i5);
        kotlin.jvm.internal.E.e(sbDeleteCharAt, "deleteCharAt(...)");
        return sbDeleteCharAt;
    }

    private static final StringBuilder deleteRange(StringBuilder sb, int i5, int i6) {
        kotlin.jvm.internal.E.f(sb, "<this>");
        StringBuilder sbDelete = sb.delete(i5, i6);
        kotlin.jvm.internal.E.e(sbDelete, "delete(...)");
        return sbDelete;
    }

    private static final StringBuilder insert(StringBuilder sb, int i5, byte b) {
        kotlin.jvm.internal.E.f(sb, "<this>");
        StringBuilder sbInsert = sb.insert(i5, (int) b);
        kotlin.jvm.internal.E.e(sbInsert, "insert(...)");
        return sbInsert;
    }

    private static final StringBuilder insertRange(StringBuilder sb, int i5, char[] value, int i6, int i7) {
        kotlin.jvm.internal.E.f(sb, "<this>");
        kotlin.jvm.internal.E.f(value, "value");
        StringBuilder sbInsert = sb.insert(i5, value, i6, i7 - i6);
        kotlin.jvm.internal.E.e(sbInsert, "insert(...)");
        return sbInsert;
    }

    private static final void set(StringBuilder sb, int i5, char c) {
        kotlin.jvm.internal.E.f(sb, "<this>");
        sb.setCharAt(i5, c);
    }

    private static final StringBuilder setRange(StringBuilder sb, int i5, int i6, String value) {
        kotlin.jvm.internal.E.f(sb, "<this>");
        kotlin.jvm.internal.E.f(value, "value");
        StringBuilder sbReplace = sb.replace(i5, i6, value);
        kotlin.jvm.internal.E.e(sbReplace, "replace(...)");
        return sbReplace;
    }

    private static final void toCharArray(StringBuilder sb, char[] destination, int i5, int i6, int i7) {
        kotlin.jvm.internal.E.f(sb, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        sb.getChars(i6, i7, destination, i5);
    }

    private static final StringBuilder append(StringBuilder sb, short s6) {
        kotlin.jvm.internal.E.f(sb, "<this>");
        sb.append((int) s6);
        return sb;
    }

    private static final StringBuilder appendLine(StringBuilder sb, StringBuilder sb2) {
        kotlin.jvm.internal.E.f(sb, "<this>");
        sb.append((CharSequence) sb2);
        sb.append('\n');
        return sb;
    }

    private static final StringBuilder appendRange(StringBuilder sb, CharSequence value, int i5, int i6) {
        kotlin.jvm.internal.E.f(sb, "<this>");
        kotlin.jvm.internal.E.f(value, "value");
        sb.append(value, i5, i6);
        return sb;
    }

    private static final Appendable appendln(Appendable appendable, CharSequence charSequence) throws IOException {
        kotlin.jvm.internal.E.f(appendable, "<this>");
        Appendable appendableAppend = appendable.append(charSequence);
        kotlin.jvm.internal.E.e(appendableAppend, "append(...)");
        return appendln(appendableAppend);
    }

    private static final StringBuilder insert(StringBuilder sb, int i5, short s6) {
        kotlin.jvm.internal.E.f(sb, "<this>");
        StringBuilder sbInsert = sb.insert(i5, (int) s6);
        kotlin.jvm.internal.E.e(sbInsert, "insert(...)");
        return sbInsert;
    }

    private static final StringBuilder insertRange(StringBuilder sb, int i5, CharSequence value, int i6, int i7) {
        kotlin.jvm.internal.E.f(sb, "<this>");
        kotlin.jvm.internal.E.f(value, "value");
        StringBuilder sbInsert = sb.insert(i5, value, i6, i7);
        kotlin.jvm.internal.E.e(sbInsert, "insert(...)");
        return sbInsert;
    }

    private static final StringBuilder appendLine(StringBuilder sb, int i5) {
        kotlin.jvm.internal.E.f(sb, "<this>");
        sb.append(i5);
        sb.append('\n');
        return sb;
    }

    private static final Appendable appendln(Appendable appendable, char c) throws IOException {
        kotlin.jvm.internal.E.f(appendable, "<this>");
        Appendable appendableAppend = appendable.append(c);
        kotlin.jvm.internal.E.e(appendableAppend, "append(...)");
        return appendln(appendableAppend);
    }

    private static final StringBuilder appendLine(StringBuilder sb, short s6) {
        kotlin.jvm.internal.E.f(sb, "<this>");
        sb.append((int) s6);
        sb.append('\n');
        return sb;
    }

    public static final StringBuilder appendln(StringBuilder sb) {
        kotlin.jvm.internal.E.f(sb, "<this>");
        sb.append(f0.LINE_SEPARATOR);
        return sb;
    }

    private static final StringBuilder appendLine(StringBuilder sb, byte b) {
        kotlin.jvm.internal.E.f(sb, "<this>");
        sb.append((int) b);
        sb.append('\n');
        return sb;
    }

    private static final StringBuilder appendln(StringBuilder sb, StringBuffer stringBuffer) {
        kotlin.jvm.internal.E.f(sb, "<this>");
        sb.append(stringBuffer);
        return appendln(sb);
    }

    private static final StringBuilder appendLine(StringBuilder sb, long j6) {
        kotlin.jvm.internal.E.f(sb, "<this>");
        sb.append(j6);
        sb.append('\n');
        return sb;
    }

    private static final StringBuilder appendln(StringBuilder sb, CharSequence charSequence) {
        kotlin.jvm.internal.E.f(sb, "<this>");
        sb.append(charSequence);
        return appendln(sb);
    }

    private static final StringBuilder appendLine(StringBuilder sb, float f6) {
        kotlin.jvm.internal.E.f(sb, "<this>");
        sb.append(f6);
        sb.append('\n');
        return sb;
    }

    private static final StringBuilder appendln(StringBuilder sb, String str) {
        kotlin.jvm.internal.E.f(sb, "<this>");
        sb.append(str);
        return appendln(sb);
    }

    private static final StringBuilder appendLine(StringBuilder sb, double d) {
        kotlin.jvm.internal.E.f(sb, "<this>");
        sb.append(d);
        sb.append('\n');
        return sb;
    }

    private static final StringBuilder appendln(StringBuilder sb, Object obj) {
        kotlin.jvm.internal.E.f(sb, "<this>");
        sb.append(obj);
        return appendln(sb);
    }

    private static final StringBuilder appendln(StringBuilder sb, StringBuilder sb2) {
        kotlin.jvm.internal.E.f(sb, "<this>");
        sb.append((CharSequence) sb2);
        return appendln(sb);
    }

    private static final StringBuilder appendln(StringBuilder sb, char[] value) {
        kotlin.jvm.internal.E.f(sb, "<this>");
        kotlin.jvm.internal.E.f(value, "value");
        sb.append(value);
        return appendln(sb);
    }

    private static final StringBuilder appendln(StringBuilder sb, char c) {
        kotlin.jvm.internal.E.f(sb, "<this>");
        sb.append(c);
        return appendln(sb);
    }

    private static final StringBuilder appendln(StringBuilder sb, boolean z6) {
        kotlin.jvm.internal.E.f(sb, "<this>");
        sb.append(z6);
        return appendln(sb);
    }

    private static final StringBuilder appendln(StringBuilder sb, int i5) {
        kotlin.jvm.internal.E.f(sb, "<this>");
        sb.append(i5);
        return appendln(sb);
    }

    private static final StringBuilder appendln(StringBuilder sb, short s6) {
        kotlin.jvm.internal.E.f(sb, "<this>");
        sb.append((int) s6);
        return appendln(sb);
    }

    private static final StringBuilder appendln(StringBuilder sb, byte b) {
        kotlin.jvm.internal.E.f(sb, "<this>");
        sb.append((int) b);
        return appendln(sb);
    }

    private static final StringBuilder appendln(StringBuilder sb, long j6) {
        kotlin.jvm.internal.E.f(sb, "<this>");
        sb.append(j6);
        return appendln(sb);
    }

    private static final StringBuilder appendln(StringBuilder sb, float f6) {
        kotlin.jvm.internal.E.f(sb, "<this>");
        sb.append(f6);
        return appendln(sb);
    }

    private static final StringBuilder appendln(StringBuilder sb, double d) {
        kotlin.jvm.internal.E.f(sb, "<this>");
        sb.append(d);
        return appendln(sb);
    }
}
