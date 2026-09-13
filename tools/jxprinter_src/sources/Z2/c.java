package Z2;

import android.widget.Toast$Callback;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class c extends Toast$Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f898a;

    public c(d dVar) {
        this.f898a = dVar;
    }

    public final void onToastHidden() {
        super.onToastHidden();
        this.f898a.mToast = null;
    }
}
