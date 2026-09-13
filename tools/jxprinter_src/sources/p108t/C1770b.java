package p108t;

import A3.I;
import androidx.collection.a;
import java.util.List;
import kotlin.jvm.internal.E;

/* JADX INFO: renamed from: t.b, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class C1770b {
    public static final C1769a Companion = new C1769a();
    private final String address;
    private final String name;

    public C1770b(String name, String address) {
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

    public final C1770b copy(String name, String address) {
        E.f(name, "name");
        E.f(address, "address");
        return new C1770b(name, address);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1770b)) {
            return false;
        }
        C1770b c1770b = (C1770b) obj;
        return E.a(this.name, c1770b.name) && E.a(this.address, c1770b.address);
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
        return a.p("BluetoothDevice(name=", this.name, ", address=", this.address, ")");
    }
}
