package p056k0;

import androidx.collection.a;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class c {
    private String name;
    private String value;

    public c(String name, String value) {
        E.f(name, "name");
        E.f(value, "value");
        this.name = name;
        this.value = value;
    }

    public final String component1() {
        return this.name;
    }

    public final String component2() {
        return this.value;
    }

    public final c copy(String name, String value) {
        E.f(name, "name");
        E.f(value, "value");
        return new c(name, value);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return E.a(this.name, cVar.name) && E.a(this.value, cVar.value);
    }

    public final String getName() {
        return this.name;
    }

    public final String getValue() {
        return this.value;
    }

    public final int hashCode() {
        return this.value.hashCode() + (this.name.hashCode() * 31);
    }

    public final void setName(String str) {
        E.f(str, "<set-?>");
        this.name = str;
    }

    public final void setValue(String str) {
        E.f(str, "<set-?>");
        this.value = str;
    }

    public String toString() {
        return a.p("CellInfo(name=", this.name, ", value=", this.value, ")");
    }
}
