package com.hjq.permissions;

import android.app.Activity;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class D implements InterfaceC0559l {
    @Override // com.hjq.permissions.InterfaceC0559l
    public /* bridge */ /* synthetic */ void deniedPermissionRequest(@NonNull Activity activity, @NonNull List list, @NonNull List list2, boolean z6, @Nullable InterfaceC0558k interfaceC0558k) {
        super.deniedPermissionRequest(activity, list, list2, z6, interfaceC0558k);
    }

    @Override // com.hjq.permissions.InterfaceC0559l
    public /* bridge */ /* synthetic */ void finishPermissionRequest(@NonNull Activity activity, @NonNull List list, boolean z6, @Nullable InterfaceC0558k interfaceC0558k) {
        super.finishPermissionRequest(activity, list, z6, interfaceC0558k);
    }

    @Override // com.hjq.permissions.InterfaceC0559l
    public /* bridge */ /* synthetic */ void grantedPermissionRequest(@NonNull Activity activity, @NonNull List list, @NonNull List list2, boolean z6, @Nullable InterfaceC0558k interfaceC0558k) {
        super.grantedPermissionRequest(activity, list, list2, z6, interfaceC0558k);
    }

    @Override // com.hjq.permissions.InterfaceC0559l
    public /* bridge */ /* synthetic */ void launchPermissionRequest(@NonNull Activity activity, @NonNull List list, @Nullable InterfaceC0558k interfaceC0558k) {
        super.launchPermissionRequest(activity, list, interfaceC0558k);
    }
}
