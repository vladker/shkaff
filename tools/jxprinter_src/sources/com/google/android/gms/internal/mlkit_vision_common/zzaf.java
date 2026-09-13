package com.google.android.gms.internal.mlkit_vision_common;

import androidx.annotation.NonNull;
import java.io.OutputStream;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
final class zzaf extends OutputStream {
    private long zza = 0;

    @Override // java.io.OutputStream
    public final void write(int i5) {
        this.zza++;
    }

    public final long zza() {
        return this.zza;
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr) {
        this.zza += (long) bArr.length;
    }

    @Override // java.io.OutputStream
    public final void write(@NonNull byte[] bArr, int i5, int i6) {
        int length;
        int i7;
        if (i5 >= 0 && i5 <= (length = bArr.length) && i6 >= 0 && (i7 = i5 + i6) <= length && i7 >= 0) {
            this.zza += (long) i6;
            return;
        }
        throw new IndexOutOfBoundsException();
    }
}
