package p126w0;

import com.bumptech.glide.load.engine.bitmap_recycle.a;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class l implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ InputStream f8810a;
    public final /* synthetic */ a b;

    public l(InputStream inputStream, a aVar) {
        this.f8810a = inputStream;
        this.b = aVar;
    }

    @Override // p126w0.n
    public int getOrientationAndRewind(g gVar) throws IOException {
        InputStream inputStream = this.f8810a;
        try {
            return gVar.getOrientation(inputStream, this.b);
        } finally {
            inputStream.reset();
        }
    }
}
