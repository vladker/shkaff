package com.bumptech.glide;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class B implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public J0.e f2864a;

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final B clone() {
        try {
            return (B) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @NonNull
    public final B dontTransition() {
        return transition(J0.b.c);
    }

    public boolean equals(Object obj) {
        if (obj instanceof B) {
            return L0.s.bothNullOrEqual(this.f2864a, ((B) obj).f2864a);
        }
        return false;
    }

    public int hashCode() {
        J0.e eVar = this.f2864a;
        if (eVar != null) {
            return eVar.hashCode();
        }
        return 0;
    }

    @NonNull
    public final B transition(int i5) {
        return transition(new J0.g(i5));
    }

    @NonNull
    public final B transition(@NonNull J0.i iVar) {
        return transition(new J0.h());
    }

    @NonNull
    public final B transition(@NonNull J0.e eVar) {
        this.f2864a = (J0.e) L0.q.checkNotNull(eVar);
        return this;
    }
}
