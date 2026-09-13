package p144z0;

import android.os.ParcelFileDescriptor;
import java.io.File;
import java.io.IOException;

/* JADX INFO: renamed from: z0.y, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class C1919y implements B {
    @Override // p144z0.B
    public final Class getDataClass() {
        return ParcelFileDescriptor.class;
    }

    @Override // p144z0.B
    public void close(ParcelFileDescriptor parcelFileDescriptor) throws IOException {
        parcelFileDescriptor.close();
    }

    @Override // p144z0.B
    public ParcelFileDescriptor open(File file) {
        return ParcelFileDescriptor.open(file, 268435456);
    }
}
