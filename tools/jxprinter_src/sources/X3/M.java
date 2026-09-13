package X3;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class M {
    public static final <T extends Appendable> T append(T t6, CharSequence... value) throws IOException {
        kotlin.jvm.internal.E.f(t6, "<this>");
        kotlin.jvm.internal.E.f(value, "value");
        for (CharSequence charSequence : value) {
            t6.append(charSequence);
        }
        return t6;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> void appendElement(Appendable appendable, T t6, O3.l lVar) {
        kotlin.jvm.internal.E.f(appendable, "<this>");
        if (lVar != null) {
            appendable.append((CharSequence) lVar.invoke(t6));
            return;
        }
        if (t6 == 0 ? true : t6 instanceof CharSequence) {
            appendable.append((CharSequence) t6);
        } else if (t6 instanceof Character) {
            appendable.append(((Character) t6).charValue());
        } else {
            appendable.append(t6.toString());
        }
    }

    private static final Appendable appendLine(Appendable appendable) {
        kotlin.jvm.internal.E.f(appendable, "<this>");
        return appendable.append('\n');
    }

    public static final <T extends Appendable> T appendRange(T t6, CharSequence value, int i5, int i6) {
        kotlin.jvm.internal.E.f(t6, "<this>");
        kotlin.jvm.internal.E.f(value, "value");
        T t7 = (T) t6.append(value, i5, i6);
        kotlin.jvm.internal.E.d(t7, "null cannot be cast to non-null type T of kotlin.text.StringsKt__AppendableKt.appendRange");
        return t7;
    }

    private static final Appendable appendLine(Appendable appendable, CharSequence charSequence) {
        kotlin.jvm.internal.E.f(appendable, "<this>");
        return appendable.append(charSequence).append('\n');
    }

    private static final Appendable appendLine(Appendable appendable, char c) {
        kotlin.jvm.internal.E.f(appendable, "<this>");
        return appendable.append(c).append('\n');
    }
}
