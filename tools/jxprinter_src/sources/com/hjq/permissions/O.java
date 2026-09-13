package com.hjq.permissions;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class O implements M {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f3543a;

    public /* synthetic */ O(Context context, int i5) {
        this(context);
    }

    @Override // com.hjq.permissions.M
    public void startActivity(@NonNull Intent intent) {
        this.f3543a.startActivity(intent);
    }

    @Override // com.hjq.permissions.M
    public void startActivityForResult(@NonNull Intent intent, int i5) {
        Activity activityFindActivity = K.findActivity(this.f3543a);
        if (activityFindActivity != null) {
            activityFindActivity.startActivityForResult(intent, i5);
        } else {
            startActivity(intent);
        }
    }

    private O(@NonNull Context context) {
        this.f3543a = context;
    }
}
