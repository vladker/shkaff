package androidx.activity;

import android.content.IntentSender;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.profileinstaller.DeviceProfileWriter;
import com.appdev.standard.page.LocalFlutterBoostActivity$activityResultRegistry$1;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f966a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ int c;
    public final /* synthetic */ Object d;

    public /* synthetic */ f(Object obj, int i5, Object obj2, int i6) {
        this.f966a = i6;
        this.b = obj;
        this.c = i5;
        this.d = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f966a) {
            case 0:
                ComponentActivity$activityResultRegistry$1.onLaunch$lambda$0((ComponentActivity$activityResultRegistry$1) this.b, this.c, (ActivityResultContract.SynchronousResult) this.d);
                break;
            case 1:
                ComponentActivity$activityResultRegistry$1.onLaunch$lambda$1((ComponentActivity$activityResultRegistry$1) this.b, this.c, (IntentSender.SendIntentException) this.d);
                break;
            case 2:
                ((DeviceProfileWriter) this.b).lambda$result$0(this.c, this.d);
                break;
            case 3:
                LocalFlutterBoostActivity$activityResultRegistry$1.onLaunch$lambda$0((LocalFlutterBoostActivity$activityResultRegistry$1) this.b, this.c, (ActivityResultContract.SynchronousResult) this.d);
                break;
            default:
                LocalFlutterBoostActivity$activityResultRegistry$1.onLaunch$lambda$1((LocalFlutterBoostActivity$activityResultRegistry$1) this.b, this.c, (IntentSender.SendIntentException) this.d);
                break;
        }
    }
}
