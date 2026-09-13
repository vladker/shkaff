package p056k0;

import android.net.Uri;
import androidx.activity.result.ActivityResultCallback;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class h implements ActivityResultCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5467a;
    public final /* synthetic */ i b;

    public /* synthetic */ h(i iVar, int i5) {
        this.f5467a = i5;
        this.b = iVar;
    }

    @Override // androidx.activity.result.ActivityResultCallback
    public final void onActivityResult(Object obj) {
        switch (this.f5467a) {
            case 0:
                i.a(this.b, (Uri) obj);
                break;
            case 1:
                i.b(this.b, (Uri) obj);
                break;
            default:
                i.c(this.b, (Uri) obj);
                break;
        }
    }
}
