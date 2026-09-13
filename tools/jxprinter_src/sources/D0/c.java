package D0;

import android.graphics.ImageDecoder;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.engine.O;
import java.io.InputStream;
import p126w0.v;
import p126w0.x;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class c implements x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f158a;

    public c(d dVar) {
        this.f158a = dVar;
    }

    @Override // p126w0.x
    public O decode(@NonNull InputStream inputStream, int i5, int i6, @NonNull v vVar) {
        return this.f158a.decode(ImageDecoder.createSource(L0.c.fromStream(inputStream)), i5, i6, vVar);
    }

    @Override // p126w0.x
    public boolean handles(@NonNull InputStream inputStream, @NonNull v vVar) {
        return this.f158a.handles(inputStream);
    }
}
