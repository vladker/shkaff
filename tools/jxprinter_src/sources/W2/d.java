package W2;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class d extends ConnectivityManager.NetworkCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f788a;

    public d(e eVar) {
        this.f788a = eVar;
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onAvailable(Network network) {
        e eVar = this.f788a;
        eVar.c.post(new b(eVar, eVar.f789a.getCapabilitiesFromNetwork(network), 0));
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
        e eVar = this.f788a;
        eVar.c.post(new b(eVar, eVar.f789a.getCapabilitiesList(networkCapabilities), 0));
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onLost(Network network) {
        e eVar = this.f788a;
        eVar.c.postDelayed(new c(eVar, 0), 500L);
    }
}
