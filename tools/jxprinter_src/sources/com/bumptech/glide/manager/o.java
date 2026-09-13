package com.bumptech.glide.manager;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class o implements w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FragmentManager f3172a;
    public final /* synthetic */ p b;

    public o(p pVar, FragmentManager fragmentManager) {
        this.b = pVar;
        this.f3172a = fragmentManager;
    }

    public final void a(FragmentManager fragmentManager, HashSet hashSet) {
        List<Fragment> fragments = fragmentManager.getFragments();
        int size = fragments.size();
        for (int i5 = 0; i5 < size; i5++) {
            Fragment fragment = fragments.get(i5);
            a(fragment.getChildFragmentManager(), hashSet);
            Lifecycle lifecycle = fragment.getLifecycle();
            p pVar = this.b;
            pVar.getClass();
            L0.s.a();
            com.bumptech.glide.A a6 = (com.bumptech.glide.A) pVar.f3173a.get(lifecycle);
            if (a6 != null) {
                hashSet.add(a6);
            }
        }
    }

    @Override // com.bumptech.glide.manager.w
    @NonNull
    public Set<com.bumptech.glide.A> getDescendants() {
        HashSet hashSet = new HashSet();
        a(this.f3172a, hashSet);
        return hashSet;
    }
}
