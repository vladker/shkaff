package p125w;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.play.core.appupdate.AppUpdateInfo;
import p051j0.a;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class c implements OnSuccessListener, OnFailureListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f8799a;
    public final /* synthetic */ d b;

    public /* synthetic */ c(Context context, d dVar) {
        this.f8799a = context;
        this.b = dVar;
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    public void onFailure(Exception exc) {
        Context context = this.f8799a;
        String strE = f.e(context);
        if (TextUtils.isEmpty(strE)) {
            a.d("AppUpdateChecker", "Google Play检测失败: " + exc.getMessage());
        } else {
            d dVar = this.b;
            dVar.onStoreDetected(strE);
            f.a(context, strE, dVar);
        }
    }

    @Override // com.google.android.gms.tasks.OnSuccessListener
    public void onSuccess(Object obj) {
        int iUpdateAvailability = ((AppUpdateInfo) obj).updateAvailability();
        d dVar = this.b;
        if (iUpdateAvailability == 2) {
            dVar.onUpdateAvailable(f.g(this.f8799a), "");
        } else {
            dVar.onNoUpdateAvailable();
        }
    }

    public /* synthetic */ c(d dVar, Context context) {
        this.b = dVar;
        this.f8799a = context;
    }
}
