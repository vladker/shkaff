package com.bumptech.glide.manager;

import android.content.Context;
import androidx.annotation.NonNull;

/* JADX INFO: renamed from: com.bumptech.glide.manager.f, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class C0536f implements InterfaceC0534d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f3170a;
    public final InterfaceC0533c b;

    public C0536f(@NonNull Context context, @NonNull InterfaceC0533c interfaceC0533c) {
        this.f3170a = context.getApplicationContext();
        this.b = interfaceC0533c;
    }

    @Override // com.bumptech.glide.manager.m
    public final void onStart() {
        D.get(this.f3170a).a(this.b);
    }

    @Override // com.bumptech.glide.manager.m
    public final void onStop() {
        D.get(this.f3170a).b(this.b);
    }

    @Override // com.bumptech.glide.manager.m
    public final void onDestroy() {
    }
}
