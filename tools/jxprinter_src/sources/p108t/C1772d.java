package p108t;

import A3.I;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.E;

/* JADX INFO: renamed from: t.d, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class C1772d {
    public static final C1771c Companion = new C1771c();
    private final String action;
    private final Map<String, Object> data;

    public C1772d(String action, Map<String, ? extends Object> map) {
        E.f(action, "action");
        this.action = action;
        this.data = map;
    }

    public final String component1() {
        return this.action;
    }

    public final Map<String, Object> component2() {
        return this.data;
    }

    public final C1772d copy(String action, Map<String, ? extends Object> map) {
        E.f(action, "action");
        return new C1772d(action, map);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1772d)) {
            return false;
        }
        C1772d c1772d = (C1772d) obj;
        return E.a(this.action, c1772d.action) && E.a(this.data, c1772d.data);
    }

    public final String getAction() {
        return this.action;
    }

    public final Map<String, Object> getData() {
        return this.data;
    }

    public final int hashCode() {
        int iHashCode = this.action.hashCode() * 31;
        Map<String, Object> map = this.data;
        return iHashCode + (map == null ? 0 : map.hashCode());
    }

    public final List<Object> toList() {
        return I.listOf(this.action, this.data);
    }

    public String toString() {
        return "DialogResponse(action=" + this.action + ", data=" + this.data + ")";
    }
}
