package com.bumptech.glide.manager;

import androidx.annotation.NonNull;
import java.util.HashSet;
import java.util.Set;
import org.apache.commons.math3.geometry.VectorFormat;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class E implements w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ F f3166a;

    public E(F f6) {
        this.f3166a = f6;
    }

    @Override // com.bumptech.glide.manager.w
    @NonNull
    public Set<com.bumptech.glide.A> getDescendants() {
        Set<F> descendantRequestManagerFragments = this.f3166a.getDescendantRequestManagerFragments();
        HashSet hashSet = new HashSet(descendantRequestManagerFragments.size());
        for (F f6 : descendantRequestManagerFragments) {
            if (f6.getRequestManager() != null) {
                hashSet.add(f6.getRequestManager());
            }
        }
        return hashSet;
    }

    public final String toString() {
        return super.toString() + "{fragment=" + this.f3166a + VectorFormat.DEFAULT_SUFFIX;
    }
}
