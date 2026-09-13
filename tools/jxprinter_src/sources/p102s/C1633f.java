package p102s;

import O3.l;
import android.annotation.SuppressLint;
import android.content.Context;
import com.idlefish.flutterboost.FlutterBoost;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.E;
import kotlinx.serialization.json.internal.AbstractC1125a;
import p007a4.AbstractC0272e;
import p007a4.C0276f0;
import p007a4.N;
import p108t.InterfaceC1781m;
import p140y2.m;
import p147z3.Q;
import p147z3.u;

/* JADX INFO: renamed from: s.f, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class C1633f implements InterfaceC1781m {
    private final Map<Long, m> scanner_manager = new LinkedHashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f8172a = 1;

    @Override // p108t.InterfaceC1781m
    @SuppressLint({"MissingPermission"})
    public void getDevice(long j6, l callback) {
        E.f(callback, "callback");
        AbstractC0272e.b(N.CoroutineScope(C0276f0.getDefault()), null, 3, new C1632e(this, j6, callback, null));
    }

    @Override // p108t.InterfaceC1781m
    public void startScan(l callback) {
        E.f(callback, "callback");
        Context applicationContext = FlutterBoost.instance().currentActivity().getApplicationContext();
        E.e(applicationContext, "getApplicationContext(...)");
        m mVar = new m(applicationContext);
        mVar.m1123startDiscoveryd1pmJ48();
        Map<Long, m> map = this.scanner_manager;
        long j6 = this.f8172a;
        map.put(Long.valueOf(j6), mVar);
        callback.invoke(u.a(u.m1361constructorimpl(Long.valueOf(j6))));
    }

    @Override // p108t.InterfaceC1781m
    public void stopScan(long j6, l callback) {
        E.f(callback, "callback");
        m mVar = this.scanner_manager.get(Long.valueOf(j6));
        if (mVar != null) {
            mVar.stopDiscovery();
        }
        this.scanner_manager.remove(Long.valueOf(j6));
        AbstractC1125a.q(Q.INSTANCE, callback);
    }
}
