package com.bumptech.glide.manager;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap f3173a = new HashMap();

    @NonNull
    private final u factory;

    public p(@NonNull u uVar) {
        this.factory = uVar;
    }

    public final com.bumptech.glide.A a(Context context, com.bumptech.glide.c cVar, Lifecycle lifecycle, FragmentManager fragmentManager, boolean z6) {
        L0.s.a();
        L0.s.a();
        HashMap map = this.f3173a;
        com.bumptech.glide.A a6 = (com.bumptech.glide.A) map.get(lifecycle);
        if (a6 != null) {
            return a6;
        }
        l lVar = new l(lifecycle);
        com.bumptech.glide.A aBuild = ((t) this.factory).build(cVar, lVar, new o(this, fragmentManager), context);
        map.put(lifecycle, aBuild);
        lVar.addListener(new n(this, lifecycle));
        if (z6) {
            aBuild.onStart();
        }
        return aBuild;
    }
}
