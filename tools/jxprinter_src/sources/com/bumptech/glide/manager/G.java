package com.bumptech.glide.manager;

import androidx.annotation.NonNull;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class G implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set f3168a = Collections.newSetFromMap(new WeakHashMap());

    @NonNull
    public List<com.bumptech.glide.request.target.k> getAll() {
        return L0.s.getSnapshot(this.f3168a);
    }

    @Override // com.bumptech.glide.manager.m
    public final void onDestroy() {
        Iterator it = L0.s.getSnapshot(this.f3168a).iterator();
        while (it.hasNext()) {
            ((com.bumptech.glide.request.target.k) it.next()).onDestroy();
        }
    }

    @Override // com.bumptech.glide.manager.m
    public final void onStart() {
        Iterator it = L0.s.getSnapshot(this.f3168a).iterator();
        while (it.hasNext()) {
            ((com.bumptech.glide.request.target.k) it.next()).onStart();
        }
    }

    @Override // com.bumptech.glide.manager.m
    public final void onStop() {
        Iterator it = L0.s.getSnapshot(this.f3168a).iterator();
        while (it.hasNext()) {
            ((com.bumptech.glide.request.target.k) it.next()).onStop();
        }
    }

    public void track(@NonNull com.bumptech.glide.request.target.k kVar) {
        this.f3168a.add(kVar);
    }

    public void untrack(@NonNull com.bumptech.glide.request.target.k kVar) {
        this.f3168a.remove(kVar);
    }
}
