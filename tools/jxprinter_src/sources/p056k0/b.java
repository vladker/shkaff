package p056k0;

import android.content.Intent;
import androidx.activity.ComponentActivity;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class b {
    private s callback;
    private ActivityResultLauncher<Intent> takePhoto;

    public static void a(b bVar, ActivityResult result) {
        E.f(result, "result");
        s sVar = bVar.callback;
        if (sVar != null) {
            sVar.onResult(result);
        }
    }

    public static void b(b bVar, ActivityResult result) {
        E.f(result, "result");
        s sVar = bVar.callback;
        if (sVar != null) {
            sVar.onResult(result);
        }
    }

    public final void attachToActivity(ComponentActivity activity) {
        E.f(activity, "activity");
        this.takePhoto = activity.registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new a(this, 0));
    }

    public final void startActivityForResult(Intent intent, s callback) {
        E.f(intent, "intent");
        E.f(callback, "callback");
        ActivityResultLauncher<Intent> activityResultLauncher = this.takePhoto;
        if (activityResultLauncher != null) {
            this.callback = callback;
            activityResultLauncher.launch(intent);
        }
    }

    public final void attachToActivity(Fragment activity) {
        E.f(activity, "activity");
        this.takePhoto = activity.registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new a(this, 1));
    }
}
