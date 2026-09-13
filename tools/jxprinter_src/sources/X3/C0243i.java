package X3;

import W3.InterfaceC0233q;
import java.util.Iterator;

/* JADX INFO: renamed from: X3.i, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0243i implements InterfaceC0233q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f860a;
    public final int b;
    private final O3.p getNextMatch;
    private final CharSequence input;

    public C0243i(CharSequence input, int i5, int i6, O3.p getNextMatch) {
        kotlin.jvm.internal.E.f(input, "input");
        kotlin.jvm.internal.E.f(getNextMatch, "getNextMatch");
        this.input = input;
        this.f860a = i5;
        this.b = i6;
        this.getNextMatch = getNextMatch;
    }

    @Override // W3.InterfaceC0233q
    public Iterator<U3.q> iterator() {
        return new C0242h(this);
    }
}
