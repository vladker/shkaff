package C0;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.data.f;
import com.bumptech.glide.load.data.g;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class a implements f {
    @Override // com.bumptech.glide.load.data.f
    @NonNull
    public Class<ByteBuffer> getDataClass() {
        return ByteBuffer.class;
    }

    @Override // com.bumptech.glide.load.data.f
    @NonNull
    public g build(ByteBuffer byteBuffer) {
        return new b(byteBuffer);
    }
}
