package com.hjq.permissions;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: com.hjq.permissions.f, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0553f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f3551a;

    @Nullable
    C0549b applicationInfo;

    @Nullable
    C0552e usesSdkInfo;

    @NonNull
    final List<C0550c> permissionInfoList = new ArrayList();

    @NonNull
    final List<C0548a> activityInfoList = new ArrayList();

    @NonNull
    final List<C0551d> serviceInfoList = new ArrayList();
}
