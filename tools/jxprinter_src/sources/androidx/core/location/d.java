package androidx.core.location;

import android.location.Location;
import androidx.core.util.Consumer;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1008a;
    public final /* synthetic */ Consumer b;
    public final /* synthetic */ Location c;

    public /* synthetic */ d(Consumer consumer, Location location, int i5) {
        this.f1008a = i5;
        this.b = consumer;
        this.c = location;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1008a) {
            case 0:
                this.b.accept(this.c);
                break;
            default:
                this.b.accept(this.c);
                break;
        }
    }
}
