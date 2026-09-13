package androidx.core.location;

import android.location.Location;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class i implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1013a;
    public final /* synthetic */ LocationManagerCompat.LocationListenerTransport b;
    public final /* synthetic */ Object c;

    public /* synthetic */ i(LocationManagerCompat.LocationListenerTransport locationListenerTransport, Object obj, int i5) {
        this.f1013a = i5;
        this.b = locationListenerTransport;
        this.c = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1013a) {
            case 0:
                this.b.lambda$onLocationChanged$1((List) this.c);
                break;
            default:
                this.b.lambda$onLocationChanged$0((Location) this.c);
                break;
        }
    }
}
