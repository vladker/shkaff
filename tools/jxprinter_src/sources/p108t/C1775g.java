package p108t;

import A3.I;
import androidx.collection.a;
import java.util.List;
import kotlin.jvm.internal.E;

/* JADX INFO: renamed from: t.g, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class C1775g {
    public static final C1774f Companion = new C1774f();
    private final String firstValue;
    private final String name;

    public C1775g(String name, String firstValue) {
        E.f(name, "name");
        E.f(firstValue, "firstValue");
        this.name = name;
        this.firstValue = firstValue;
    }

    public final String component1() {
        return this.name;
    }

    public final String component2() {
        return this.firstValue;
    }

    public final C1775g copy(String name, String firstValue) {
        E.f(name, "name");
        E.f(firstValue, "firstValue");
        return new C1775g(name, firstValue);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1775g)) {
            return false;
        }
        C1775g c1775g = (C1775g) obj;
        return E.a(this.name, c1775g.name) && E.a(this.firstValue, c1775g.firstValue);
    }

    public final String getFirstValue() {
        return this.firstValue;
    }

    public final String getName() {
        return this.name;
    }

    public final int hashCode() {
        return this.firstValue.hashCode() + (this.name.hashCode() * 31);
    }

    public final List<Object> toList() {
        return I.listOf((Object[]) new String[]{this.name, this.firstValue});
    }

    public String toString() {
        return a.p("ExcelColumnInfo(name=", this.name, ", firstValue=", this.firstValue, ")");
    }
}
