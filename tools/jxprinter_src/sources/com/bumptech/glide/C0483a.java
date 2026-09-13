package com.bumptech.glide;

import androidx.annotation.NonNull;

/* JADX INFO: renamed from: com.bumptech.glide.a, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class C0483a extends B {
    public C0483a() {
        this.f2864a = J0.b.c;
    }

    @NonNull
    public static <TranscodeType> C0483a with(int i5) {
        return (C0483a) new C0483a().transition(i5);
    }

    @NonNull
    public static <TranscodeType> C0483a withNoTransition() {
        return (C0483a) new C0483a().dontTransition();
    }

    @Override // com.bumptech.glide.B
    public final boolean equals(Object obj) {
        return (obj instanceof C0483a) && super.equals(obj);
    }

    @NonNull
    public static <TranscodeType> C0483a with(@NonNull J0.i iVar) {
        return (C0483a) new C0483a().transition(iVar);
    }

    @NonNull
    public static <TranscodeType> C0483a with(@NonNull J0.e eVar) {
        return (C0483a) new C0483a().transition(eVar);
    }
}
