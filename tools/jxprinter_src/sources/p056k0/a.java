package p056k0;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class a implements ActivityResultCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5464a;
    public final /* synthetic */ b b;

    public /* synthetic */ a(b bVar, int i5) {
        this.f5464a = i5;
        this.b = bVar;
    }

    @Override // androidx.activity.result.ActivityResultCallback
    public final void onActivityResult(Object obj) {
        switch (this.f5464a) {
            case 0:
                b.a(this.b, (ActivityResult) obj);
                break;
            default:
                b.b(this.b, (ActivityResult) obj);
                break;
        }
    }
}
