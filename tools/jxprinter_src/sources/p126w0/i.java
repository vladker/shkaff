package p126w0;

import L0.c;
import com.bumptech.glide.load.ImageHeaderParser$ImageType;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class i implements o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ByteBuffer f8807a;

    public i(ByteBuffer byteBuffer) {
        this.f8807a = byteBuffer;
    }

    @Override // p126w0.o
    public ImageHeaderParser$ImageType getTypeAndRewind(g gVar) {
        ByteBuffer byteBuffer = this.f8807a;
        try {
            return gVar.getType(byteBuffer);
        } finally {
            c.a(byteBuffer);
        }
    }
}
