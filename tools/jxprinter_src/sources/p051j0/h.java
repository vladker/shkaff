package p051j0;

import H2.c;
import android.app.Activity;
import com.appdev.standard.dialog.E;
import com.bumptech.glide.f;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class h extends f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Activity f5399a;

    public h(Activity activity) {
        this.f5399a = activity;
    }

    @Override // com.library.base.frame.d
    public final void onConfirm() {
        E.c();
        E.b(0);
        new Thread(new c(this, 18)).start();
    }

    @Override // com.library.base.frame.d
    public final void onCancel() {
    }
}
