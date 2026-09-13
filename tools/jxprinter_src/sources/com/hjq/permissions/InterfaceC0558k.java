package com.hjq.permissions;

import androidx.annotation.NonNull;
import java.util.List;

/* JADX INFO: renamed from: com.hjq.permissions.k, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public interface InterfaceC0558k {
    void onGranted(@NonNull List<String> list, boolean z6);

    default void onDenied(@NonNull List<String> list, boolean z6) {
    }
}
