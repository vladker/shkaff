package W3;

import java.util.Iterator;

/* JADX INFO: renamed from: W3.m, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0229m implements InterfaceC0233q {
    private final O3.a getInitialValue;
    private final O3.l getNextValue;

    public C0229m(O3.a getInitialValue, O3.l getNextValue) {
        kotlin.jvm.internal.E.f(getInitialValue, "getInitialValue");
        kotlin.jvm.internal.E.f(getNextValue, "getNextValue");
        this.getInitialValue = getInitialValue;
        this.getNextValue = getNextValue;
    }

    @Override // W3.InterfaceC0233q
    public Iterator<Object> iterator() {
        return new C0228l(this);
    }
}
