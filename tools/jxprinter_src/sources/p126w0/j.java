package p126w0;

import com.bumptech.glide.load.ImageHeaderParser$ImageType;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import com.bumptech.glide.load.engine.bitmap_recycle.a;
import com.bumptech.glide.load.resource.bitmap.K;
import java.io.FileInputStream;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class j implements o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ParcelFileDescriptorRewinder f8808a;
    public final /* synthetic */ a b;

    public j(ParcelFileDescriptorRewinder parcelFileDescriptorRewinder, a aVar) {
        this.f8808a = parcelFileDescriptorRewinder;
        this.b = aVar;
    }

    @Override // p126w0.o
    public ImageHeaderParser$ImageType getTypeAndRewind(g gVar) throws Throwable {
        ParcelFileDescriptorRewinder parcelFileDescriptorRewinder = this.f8808a;
        K k6 = null;
        try {
            K k7 = new K(new FileInputStream(parcelFileDescriptorRewinder.rewindAndGet().getFileDescriptor()), this.b);
            try {
                ImageHeaderParser$ImageType type = gVar.getType(k7);
                k7.release();
                parcelFileDescriptorRewinder.rewindAndGet();
                return type;
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
