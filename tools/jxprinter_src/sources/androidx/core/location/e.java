package androidx.core.location;

import android.location.GnssMeasurementsEvent;
import android.location.GnssStatus;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1009a;
    public final /* synthetic */ Executor b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ Object d;

    public /* synthetic */ e(Object obj, Executor executor, Object obj2, int i5) {
        this.f1009a = i5;
        this.c = obj;
        this.b = executor;
        this.d = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1009a) {
            case 0:
                ((LocationManagerCompat.GnssMeasurementsTransport) this.c).lambda$onGnssMeasurementsReceived$0(this.b, (GnssMeasurementsEvent) this.d);
                break;
            case 1:
                ((LocationManagerCompat.GpsStatusTransport) this.c).lambda$onGpsStatusChanged$3(this.b, (GnssStatusCompat) this.d);
                break;
            default:
                ((LocationManagerCompat.PreRGnssStatusTransport) this.c).lambda$onSatelliteStatusChanged$3(this.b, (GnssStatus) this.d);
                break;
        }
    }
}
