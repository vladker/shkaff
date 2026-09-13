package com.bumptech.glide.load.resource.bitmap;

import androidx.annotation.NonNull;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class X implements p126w0.t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ByteBuffer f3100a = ByteBuffer.allocate(4);

    @Override // p126w0.t
    public void update(@NonNull byte[] bArr, @NonNull Integer num, @NonNull MessageDigest messageDigest) {
        if (num == null) {
            return;
        }
        messageDigest.update(bArr);
        synchronized (this.f3100a) {
            this.f3100a.position(0);
            messageDigest.update(this.f3100a.putInt(num.intValue()).array());
        }
    }
}
