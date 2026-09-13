package C0;

import L0.q;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.engine.O;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class c implements O {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f122a;

    public c(byte[] bArr) {
        this.f122a = (byte[]) q.checkNotNull(bArr);
    }

    @Override // com.bumptech.glide.load.engine.O
    @NonNull
    public Class<byte[]> getResourceClass() {
        return byte[].class;
    }

    @Override // com.bumptech.glide.load.engine.O
    public final int getSize() {
        return this.f122a.length;
    }

    @Override // com.bumptech.glide.load.engine.O
    @NonNull
    public byte[] get() {
        return this.f122a;
    }

    @Override // com.bumptech.glide.load.engine.O
    public final void recycle() {
    }
}
