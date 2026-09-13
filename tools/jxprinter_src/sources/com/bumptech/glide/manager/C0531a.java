package com.bumptech.glide.manager;

import androidx.annotation.NonNull;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: renamed from: com.bumptech.glide.manager.a, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class C0531a implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set f3169a = Collections.newSetFromMap(new WeakHashMap());
    public boolean b;
    public boolean c;

    public final void a() {
        this.c = true;
        Iterator it = L0.s.getSnapshot(this.f3169a).iterator();
        while (it.hasNext()) {
            ((m) it.next()).onDestroy();
        }
    }

    @Override // com.bumptech.glide.manager.k
    public void addListener(@NonNull m mVar) {
        this.f3169a.add(mVar);
        if (this.c) {
            mVar.onDestroy();
        } else if (this.b) {
            mVar.onStart();
        } else {
            mVar.onStop();
        }
    }

    @Override // com.bumptech.glide.manager.k
    public void removeListener(@NonNull m mVar) {
        this.f3169a.remove(mVar);
    }
}
