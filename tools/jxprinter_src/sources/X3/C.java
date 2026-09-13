package X3;

import java.util.List;
import java.util.regex.Matcher;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C implements InterfaceC0259z {
    private List<String> groupValues_;
    private final InterfaceC0255v groups;
    private final CharSequence input;
    private final Matcher matcher;

    public C(Matcher matcher, CharSequence input) {
        kotlin.jvm.internal.E.f(matcher, "matcher");
        kotlin.jvm.internal.E.f(input, "input");
        this.matcher = matcher;
        this.input = input;
        this.groups = new B(this);
    }

    public static final Matcher a(C c) {
        return c.matcher;
    }

    @Override // X3.InterfaceC0259z
    public C0258y getDestructured() {
        return AbstractC0257x.getDestructured(this);
    }

    @Override // X3.InterfaceC0259z
    public List<String> getGroupValues() {
        if (this.groupValues_ == null) {
            this.groupValues_ = new A(this);
        }
        List<String> list = this.groupValues_;
        kotlin.jvm.internal.E.c(list);
        return list;
    }

    @Override // X3.InterfaceC0259z
    public InterfaceC0255v getGroups() {
        return this.groups;
    }

    @Override // X3.InterfaceC0259z
    public U3.q getRange() {
        Matcher matcher = this.matcher;
        return U3.B.until(matcher.start(), matcher.end());
    }

    @Override // X3.InterfaceC0259z
    public String getValue() {
        String strGroup = this.matcher.group();
        kotlin.jvm.internal.E.e(strGroup, "group(...)");
        return strGroup;
    }

    @Override // X3.InterfaceC0259z
    public InterfaceC0259z next() {
        int iEnd = this.matcher.end() + (this.matcher.end() == this.matcher.start() ? 1 : 0);
        if (iEnd > this.input.length()) {
            return null;
        }
        Matcher matcher = this.matcher.pattern().matcher(this.input);
        kotlin.jvm.internal.E.e(matcher, "matcher(...)");
        CharSequence charSequence = this.input;
        if (matcher.find(iEnd)) {
            return new C(matcher, charSequence);
        }
        return null;
    }
}
