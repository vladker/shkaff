package W2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import io.flutter.plugin.common.EventChannel;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class e extends BroadcastReceiver implements EventChannel.StreamHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f789a;
    public EventChannel.EventSink b;
    public final Handler c = new Handler(Looper.getMainLooper());
    public d d;

    public e(Context context, a aVar) {
        this.f789a = aVar;
    }

    @Override // io.flutter.plugin.common.EventChannel.StreamHandler
    public final void onCancel(Object obj) {
        d dVar = this.d;
        if (dVar != null) {
            this.f789a.f785a.unregisterNetworkCallback(dVar);
            this.d = null;
        }
    }

    @Override // io.flutter.plugin.common.EventChannel.StreamHandler
    public final void onListen(Object obj, EventChannel.EventSink eventSink) {
        this.b = eventSink;
        d dVar = new d(this);
        this.d = dVar;
        a aVar = this.f789a;
        aVar.f785a.registerDefaultNetworkCallback(dVar);
        this.c.post(new b(this, aVar.getCapabilitiesFromNetwork(aVar.f785a.getActiveNetwork()), 0));
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        EventChannel.EventSink eventSink = this.b;
        if (eventSink != null) {
            a aVar = this.f789a;
            eventSink.success(aVar.getCapabilitiesFromNetwork(aVar.f785a.getActiveNetwork()));
        }
    }
}
