package p126w0;

import L0.c;
import com.bumptech.glide.load.engine.bitmap_recycle.a;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class k implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ByteBuffer f8809a;
    public final /* synthetic */ a b;

    public k(ByteBuffer byteBuffer, a aVar) {
        this.f8809a = byteBuffer;
        this.b = aVar;
    }

    @Override // p126w0.n
    public int getOrientationAndRewind(g gVar) {
        ByteBuffer byteBuffer = this.f8809a;
        try {
            return gVar.getOrientation(byteBuffer, this.b);
        } finally {
            c.a(byteBuffer);
        }
    }
}
