package androidx.profileinstaller;

import android.content.Context;
import android.content.pm.PackageManager;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1061a;
    public final /* synthetic */ Context b;

    public /* synthetic */ c(Context context, int i5) {
        this.f1061a = i5;
        this.b = context;
    }

    @Override // java.lang.Runnable
    public final void run() throws PackageManager.NameNotFoundException {
        switch (this.f1061a) {
            case 0:
                ProfileInstallerInitializer.writeInBackground(this.b);
                break;
            default:
                ProfileInstaller.writeProfile(this.b);
                break;
        }
    }
}
