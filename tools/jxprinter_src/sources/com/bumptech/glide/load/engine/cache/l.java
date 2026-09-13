package com.bumptech.glide.load.engine.cache;

import androidx.annotation.NonNull;
import java.security.MessageDigest;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class l implements M0.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MessageDigest f3009a;
    public final M0.j b = M0.j.newInstance();

    public l(MessageDigest messageDigest) {
        this.f3009a = messageDigest;
    }

    @Override // M0.f
    @NonNull
    public M0.j getVerifier() {
        return this.b;
    }
}
