package p108t;

import A3.I;
import androidx.collection.a;
import java.util.List;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class b0 {
    public static final a0 Companion = new a0();
    private final String address;
    private final String name;

    public b0(String name, String address) {
        E.f(name, "name");
        E.f(address, "address");
        this.name = name;
        this.address = address;
    }

    public final String component1() {
        return this.name;
    }

    public final String component2() {
        return this.address;
    }

    public final b0 copy(String name, String address) {
        E.f(name, "name");
        E.f(address, "address");
        return new b0(name, address);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b0)) {
            return false;
        }
        b0 b0Var = (b0) obj;
        return E.a(this.name, b0Var.name) && E.a(this.address, b0Var.address);
    }

    public final String getAddress() {
        return this.address;
    }

    public final String getName() {
        return this.name;
    }

    public final int hashCode() {
        return this.address.hashCode() + (this.name.hashCode() * 31);
    }

    public final List<Object> toList() {
        return I.listOf((Object[]) new String[]{this.name, this.address});
    }

    public String toString() {
        return a.p("UsbDevice(name=", this.name, ", address=", this.address, ")");
    }
}
