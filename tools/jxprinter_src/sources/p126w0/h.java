package p126w0;

import com.bumptech.glide.load.ImageHeaderParser$ImageType;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class h implements o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ InputStream f8806a;

    public h(InputStream inputStream) {
        this.f8806a = inputStream;
    }

    @Override // p126w0.o
    public ImageHeaderParser$ImageType getTypeAndRewind(g gVar) throws IOException {
        InputStream inputStream = this.f8806a;
        try {
            return gVar.getType(inputStream);
        } finally {
            inputStream.reset();
        }
    }
}
