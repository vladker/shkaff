package com.library.base.frame;

import android.app.Activity;
import androidx.annotation.NonNull;
import com.hjq.permissions.InterfaceC0558k;
import com.hjq.permissions.V;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class a implements InterfaceC0558k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BaseActivity.a f3561a;

    public a(BaseActivity.a aVar) {
        this.f3561a = aVar;
    }

    @Override // com.hjq.permissions.InterfaceC0558k
    public void onDenied(@NonNull List<String> list, boolean z6) {
        BaseActivity.a aVar = this.f3561a;
        if (!z6) {
            BaseActivity.this.doRequestPermissionFail(aVar.b);
            return;
        }
        V.startPermissionActivity((Activity) BaseActivity.this, list);
        if (BaseActivity.this.requestPermissionMap.get(Integer.valueOf(aVar.b)) != null) {
            BaseActivity.this.requestPermissionMap.remove(Integer.valueOf(aVar.b));
        }
    }

    @Override // com.hjq.permissions.InterfaceC0558k
    public void onGranted(@NonNull List<String> list, boolean z6) {
        BaseActivity.a aVar = this.f3561a;
        if (z6) {
            BaseActivity.this.doRequestPermissionSuccess(aVar.b);
        } else {
            BaseActivity.this.doRequestPermissionFail(aVar.b);
        }
    }
}
