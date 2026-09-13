package X3;

import java.util.List;

/* JADX INFO: renamed from: X3.y, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0258y {
    private final InterfaceC0259z match;

    public C0258y(InterfaceC0259z match) {
        kotlin.jvm.internal.E.f(match, "match");
        this.match = match;
    }

    private final String component1() {
        return getMatch().getGroupValues().get(1);
    }

    private final String component10() {
        return getMatch().getGroupValues().get(10);
    }

    private final String component2() {
        return getMatch().getGroupValues().get(2);
    }

    private final String component3() {
        return getMatch().getGroupValues().get(3);
    }

    private final String component4() {
        return getMatch().getGroupValues().get(4);
    }

    private final String component5() {
        return getMatch().getGroupValues().get(5);
    }

    private final String component6() {
        return getMatch().getGroupValues().get(6);
    }

    private final String component7() {
        return getMatch().getGroupValues().get(7);
    }

    private final String component8() {
        return getMatch().getGroupValues().get(8);
    }

    private final String component9() {
        return getMatch().getGroupValues().get(9);
    }

    public final InterfaceC0259z getMatch() {
        return this.match;
    }

    public final List<String> toList() {
        return this.match.getGroupValues().subList(1, this.match.getGroupValues().size());
    }
}
