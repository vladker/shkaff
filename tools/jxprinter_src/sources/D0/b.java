package D0;

import android.graphics.ImageDecoder;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.engine.O;
import java.nio.ByteBuffer;
import p126w0.v;
import p126w0.x;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class b implements x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f157a;

    public b(d dVar) {
        this.f157a = dVar;
    }

    @Override // p126w0.x
    public O decode(@NonNull ByteBuffer byteBuffer, int i5, int i6, @NonNull v vVar) {
        return this.f157a.decode(ImageDecoder.createSource(byteBuffer), i5, i6, vVar);
    }

    @Override // p126w0.x
    public boolean handles(@NonNull ByteBuffer byteBuffer, @NonNull v vVar) {
        return this.f157a.handles(byteBuffer);
    }
}
