package com.hjq.permissions;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class F implements InterfaceC0558k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ List f3528a;
    public final /* synthetic */ int b;
    public final /* synthetic */ ArrayList c;
    public final /* synthetic */ G d;

    public F(G g6, List list, int i5, ArrayList arrayList) {
        this.d = g6;
        this.f3528a = list;
        this.b = i5;
        this.c = arrayList;
    }

    @Override // com.hjq.permissions.InterfaceC0558k
    public void onDenied(@NonNull List<String> list, boolean z6) {
        G g6 = this.d;
        if (g6.e.isAdded()) {
            List list2 = this.f3528a;
            int[] iArr = new int[list2.size()];
            for (int i5 = 0; i5 < list2.size(); i5++) {
                iArr[i5] = K.containsPermission(this.c, (String) list2.get(i5)) ? -1 : 0;
            }
            g6.e.onRequestPermissionsResult(this.b, (String[]) list2.toArray(new String[0]), iArr);
        }
    }

    @Override // com.hjq.permissions.InterfaceC0558k
    public void onGranted(@NonNull List<String> list, boolean z6) {
        if (z6) {
            G g6 = this.d;
            if (g6.e.isAdded()) {
                List list2 = this.f3528a;
                int[] iArr = new int[list2.size()];
                Arrays.fill(iArr, 0);
                g6.e.onRequestPermissionsResult(this.b, (String[]) list2.toArray(new String[0]), iArr);
            }
        }
    }
}
