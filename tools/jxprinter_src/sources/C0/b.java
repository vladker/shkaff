package C0;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.data.g;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class b implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ByteBuffer f121a;

    public b(ByteBuffer byteBuffer) {
        this.f121a = byteBuffer;
    }

    @Override // com.bumptech.glide.load.data.g
    @NonNull
    public ByteBuffer rewindAndGet() {
        ByteBuffer byteBuffer = this.f121a;
        byteBuffer.position(0);
        return byteBuffer;
    }

    @Override // com.bumptech.glide.load.data.g
    public final void a() {
    }
}
