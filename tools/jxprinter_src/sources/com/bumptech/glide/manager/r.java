package com.bumptech.glide.manager;

import androidx.annotation.NonNull;
import java.util.HashSet;
import java.util.Set;
import org.apache.commons.math3.geometry.VectorFormat;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class r implements w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ s f3174a;

    public r(s sVar) {
        this.f3174a = sVar;
    }

    @Override // com.bumptech.glide.manager.w
    @NonNull
    public Set<com.bumptech.glide.A> getDescendants() {
        Set<s> descendantRequestManagerFragments = this.f3174a.getDescendantRequestManagerFragments();
        HashSet hashSet = new HashSet(descendantRequestManagerFragments.size());
        for (s sVar : descendantRequestManagerFragments) {
            if (sVar.getRequestManager() != null) {
                hashSet.add(sVar.getRequestManager());
            }
        }
        return hashSet;
    }

    public final String toString() {
        return super.toString() + "{fragment=" + this.f3174a + VectorFormat.DEFAULT_SUFFIX;
    }
}
