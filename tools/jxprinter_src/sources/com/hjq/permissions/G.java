package com.hjq.permissions;

import android.app.Activity;
import androidx.annotation.NonNull;
import com.android.billingclient.api.v1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class G implements InterfaceC0558k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Activity f3529a;
    public final /* synthetic */ ArrayList b;
    public final /* synthetic */ List c;
    public final /* synthetic */ int d;
    public final /* synthetic */ H e;

    public G(H h6, Activity activity, ArrayList arrayList, List list, int i5) {
        this.e = h6;
        this.f3529a = activity;
        this.b = arrayList;
        this.c = list;
        this.d = i5;
    }

    @Override // com.hjq.permissions.InterfaceC0558k
    public void onDenied(@NonNull List<String> list, boolean z6) {
        H h6 = this.e;
        if (h6.isAdded()) {
            List list2 = this.c;
            int[] iArr = new int[list2.size()];
            Arrays.fill(iArr, -1);
            h6.onRequestPermissionsResult(this.d, (String[]) list2.toArray(new String[0]), iArr);
        }
    }

    @Override // com.hjq.permissions.InterfaceC0558k
    public void onGranted(@NonNull List<String> list, boolean z6) {
        if (z6 && this.e.isAdded()) {
            K.postDelayed(new com.appdev.standard.page.scene.g(this, this.f3529a, this.b, this.c, this.d), v1.e() ? 150L : 0L);
        }
    }
}
