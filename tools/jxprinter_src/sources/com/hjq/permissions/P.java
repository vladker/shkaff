package com.hjq.permissions;

import android.app.Fragment;
import android.content.Intent;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class P implements M {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Fragment f3544a;

    public /* synthetic */ P(Fragment fragment, int i5) {
        this(fragment);
    }

    @Override // com.hjq.permissions.M
    public void startActivity(@NonNull Intent intent) {
        this.f3544a.startActivity(intent);
    }

    @Override // com.hjq.permissions.M
    public void startActivityForResult(@NonNull Intent intent, int i5) {
        this.f3544a.startActivityForResult(intent, i5);
    }

    private P(@NonNull Fragment fragment) {
        this.f3544a = fragment;
    }
}
