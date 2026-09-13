package androidx.core.location;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1010a;
    public final /* synthetic */ Executor b;
    public final /* synthetic */ int c;
    public final /* synthetic */ Object d;

    public /* synthetic */ f(Object obj, Executor executor, int i5, int i6) {
        this.f1010a = i6;
        this.d = obj;
        this.b = executor;
        this.c = i5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1010a) {
            case 0:
                ((LocationManagerCompat.GnssMeasurementsTransport) this.d).lambda$onStatusChanged$1(this.b, this.c);
                break;
            case 1:
                ((LocationManagerCompat.GpsStatusTransport) this.d).lambda$onGpsStatusChanged$2(this.b, this.c);
                break;
            default:
                ((LocationManagerCompat.PreRGnssStatusTransport) this.d).lambda$onFirstFix$2(this.b, this.c);
                break;
        }
    }
}
