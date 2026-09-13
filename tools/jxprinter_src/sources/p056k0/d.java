package p056k0;

import androidx.collection.a;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class d {
    private String firstValue;
    private String name;

    public d(String name, String firstValue) {
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

    public final d copy(String name, String firstValue) {
        E.f(name, "name");
        E.f(firstValue, "firstValue");
        return new d(name, firstValue);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return E.a(this.name, dVar.name) && E.a(this.firstValue, dVar.firstValue);
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

    public final void setFirstValue(String str) {
        E.f(str, "<set-?>");
        this.firstValue = str;
    }

    public final void setName(String str) {
        E.f(str, "<set-?>");
        this.name = str;
    }

    public String toString() {
        return a.p("ColumnInfo(name=", this.name, ", firstValue=", this.firstValue, ")");
    }
}
