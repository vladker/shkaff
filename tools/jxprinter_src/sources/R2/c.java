package R2;

import android.app.ProgressDialog;
import android.os.Handler;
import com.soundcloud.android.crop.CropImageActivity;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class c implements Runnable, h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CropImageActivity f589a;
    public final ProgressDialog b;
    public final Runnable c;
    public final Handler d;
    public final H2.c e = new H2.c(this, 3);

    public c(CropImageActivity cropImageActivity, Runnable runnable, ProgressDialog progressDialog, Handler handler) {
        this.f589a = cropImageActivity;
        this.b = progressDialog;
        this.c = runnable;
        cropImageActivity.addLifeCycleListener(this);
        this.d = handler;
    }

    @Override // java.lang.Runnable
    public final void run() {
        H2.c cVar = this.e;
        Handler handler = this.d;
        try {
            this.c.run();
        } finally {
            handler.post(cVar);
        }
    }
}
