package androidx.appcompat.app;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f981a;
    public final /* synthetic */ Context b;

    public /* synthetic */ a(Context context, int i5) {
        this.f981a = i5;
        this.b = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f981a) {
            case 0:
                AppCompatDelegate.lambda$syncRequestedAndStoredLocales$1(this.b);
                break;
            default:
                AppCompatDelegate.syncRequestedAndStoredLocales(this.b);
                break;
        }
    }
}
