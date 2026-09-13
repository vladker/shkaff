package com.hjq.permissions;

import android.app.Activity;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.List;

/* JADX INFO: renamed from: com.hjq.permissions.l, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public interface InterfaceC0559l {
    default void deniedPermissionRequest(@NonNull Activity activity, @NonNull List<String> list, @NonNull List<String> list2, boolean z6, @Nullable InterfaceC0558k interfaceC0558k) {
        if (interfaceC0558k == null) {
            return;
        }
        interfaceC0558k.onDenied(list2, z6);
    }

    default void grantedPermissionRequest(@NonNull Activity activity, @NonNull List<String> list, @NonNull List<String> list2, boolean z6, @Nullable InterfaceC0558k interfaceC0558k) {
        if (interfaceC0558k == null) {
            return;
        }
        interfaceC0558k.onGranted(list2, z6);
    }

    default void launchPermissionRequest(@NonNull Activity activity, @NonNull List<String> list, @Nullable InterfaceC0558k interfaceC0558k) {
        H.launch(activity, list, this, interfaceC0558k);
    }

    default void finishPermissionRequest(@NonNull Activity activity, @NonNull List<String> list, boolean z6, @Nullable InterfaceC0558k interfaceC0558k) {
    }
}
