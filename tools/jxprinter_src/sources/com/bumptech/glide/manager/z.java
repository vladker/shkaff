package com.bumptech.glide.manager;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class z implements InterfaceC0533c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ D f3183a;

    public z(D d) {
        this.f3183a = d;
    }

    @Override // com.bumptech.glide.manager.InterfaceC0533c
    public final void a(boolean z6) {
        ArrayList arrayList;
        L0.s.a();
        synchronized (this.f3183a) {
            arrayList = new ArrayList(this.f3183a.listeners);
        }
        int size = arrayList.size();
        int i5 = 0;
        while (i5 < size) {
            Object obj = arrayList.get(i5);
            i5++;
            ((InterfaceC0533c) obj).a(z6);
        }
    }
}
