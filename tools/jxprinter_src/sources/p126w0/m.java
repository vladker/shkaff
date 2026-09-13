package p126w0;

import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import com.bumptech.glide.load.engine.bitmap_recycle.a;
import com.bumptech.glide.load.resource.bitmap.K;
import java.io.FileInputStream;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class m implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ParcelFileDescriptorRewinder f8811a;
    public final /* synthetic */ a b;

    public m(ParcelFileDescriptorRewinder parcelFileDescriptorRewinder, a aVar) {
        this.f8811a = parcelFileDescriptorRewinder;
        this.b = aVar;
    }

    @Override // p126w0.n
    public int getOrientationAndRewind(g gVar) throws Throwable {
        a aVar = this.b;
        ParcelFileDescriptorRewinder parcelFileDescriptorRewinder = this.f8811a;
        K k6 = null;
        try {
            K k7 = new K(new FileInputStream(parcelFileDescriptorRewinder.rewindAndGet().getFileDescriptor()), aVar);
            try {
                int orientation = gVar.getOrientation(k7, aVar);
                k7.release();
                parcelFileDescriptorRewinder.rewindAndGet();
                return orientation;
            } catch (Throwable th) {
                th = th;
                k6 = k7;
                if (k6 != null) {
                    k6.release();
                }
                parcelFileDescriptorRewinder.rewindAndGet();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
