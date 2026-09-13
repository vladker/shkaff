package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class B implements Iterable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f2928a;

    public B(ArrayList arrayList) {
        this.f2928a = arrayList;
    }

    @Override // java.lang.Iterable
    @NonNull
    public Iterator<A> iterator() {
        return this.f2928a.iterator();
    }
}
