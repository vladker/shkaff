package retrofit2;

import java.util.Optional;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final class O implements InterfaceC1621t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC1621t f8105a;

    public O(InterfaceC1621t interfaceC1621t) {
        this.f8105a = interfaceC1621t;
    }

    @Override // retrofit2.InterfaceC1621t
    public Optional<Object> convert(okhttp3.W w6) {
        return Optional.ofNullable(this.f8105a.convert(w6));
    }
}
