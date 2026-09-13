package p056k0;

import android.net.Uri;
import androidx.activity.ComponentActivity;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.PickVisualMediaRequest;
import androidx.activity.result.PickVisualMediaRequestKt;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;
import com.appdev.standard.page.LocalFlutterBoostActivity;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class i {
    private j callback;
    private ActivityResultLauncher<PickVisualMediaRequest> pickMedia;

    public static void a(i iVar, Uri uri) {
        j jVar = iVar.callback;
        if (jVar != null) {
            jVar.onImagePicked(uri);
            iVar.callback = null;
        }
    }

    public static void b(i iVar, Uri uri) {
        j jVar = iVar.callback;
        if (jVar != null) {
            jVar.onImagePicked(uri);
            iVar.callback = null;
        }
    }

    public static void c(i iVar, Uri uri) {
        j jVar = iVar.callback;
        if (jVar != null) {
            jVar.onImagePicked(uri);
            iVar.callback = null;
        }
    }

    public final void attachToActivity(ComponentActivity activity) {
        E.f(activity, "activity");
        this.pickMedia = activity.registerForActivityResult(new ActivityResultContracts.PickVisualMedia(), new h(this, 0));
    }

    public final void pick(j callback) {
        E.f(callback, "callback");
        ActivityResultLauncher<PickVisualMediaRequest> activityResultLauncher = this.pickMedia;
        if (activityResultLauncher != null) {
            this.callback = callback;
            activityResultLauncher.launch(PickVisualMediaRequestKt.PickVisualMediaRequest$default(ActivityResultContracts.PickVisualMedia.ImageOnly.INSTANCE, 0, false, null, 14, null));
        }
    }

    public final void attachToActivity(Fragment activity) {
        E.f(activity, "activity");
        this.pickMedia = activity.registerForActivityResult(new ActivityResultContracts.PickVisualMedia(), new h(this, 2));
    }

    public final void attachToActivity(LocalFlutterBoostActivity activity) {
        E.f(activity, "activity");
        this.pickMedia = activity.registerForActivityResult(new ActivityResultContracts.PickVisualMedia(), new h(this, 1));
    }
}
