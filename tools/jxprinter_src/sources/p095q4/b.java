package p095q4;

import O3.l;
import java.util.List;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class b extends c {
    private final l provider;

    public b(l provider) {
        E.f(provider, "provider");
        this.provider = provider;
    }

    public final l getProvider() {
        return this.provider;
    }

    @Override // p095q4.c
    public p060k4.b invoke(List<? extends p060k4.b> typeArgumentsSerializers) {
        E.f(typeArgumentsSerializers, "typeArgumentsSerializers");
        return (p060k4.b) this.provider.invoke(typeArgumentsSerializers);
    }
}
