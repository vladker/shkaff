package p108t;

import A3.AbstractC0157z;
import A3.I;
import androidx.exifinterface.media.a;
import java.util.List;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class d0 {
    public static final c0 Companion = new c0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f8527a;
    private final String ip;
    private final String name;

    public d0(String name, String ip, long j6) {
        E.f(name, "name");
        E.f(ip, "ip");
        this.name = name;
        this.ip = ip;
        this.f8527a = j6;
    }

    public final String component1() {
        return this.name;
    }

    public final String component2() {
        return this.ip;
    }

    public final d0 copy(String name, String ip, long j6) {
        E.f(name, "name");
        E.f(ip, "ip");
        return new d0(name, ip, j6);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d0)) {
            return false;
        }
        d0 d0Var = (d0) obj;
        return E.a(this.name, d0Var.name) && E.a(this.ip, d0Var.ip) && this.f8527a == d0Var.f8527a;
    }

    public final String getIp() {
        return this.ip;
    }

    public final String getName() {
        return this.name;
    }

    public final int hashCode() {
        return Long.hashCode(this.f8527a) + a.a(this.name.hashCode() * 31, 31, this.ip);
    }

    public final List<Object> toList() {
        return I.listOf(this.name, this.ip, Long.valueOf(this.f8527a));
    }

    public String toString() {
        return AbstractC0157z.r(androidx.collection.a.u("WifiDevice(name=", this.name, ", ip=", this.ip, ", port="), this.f8527a, ")");
    }
}
