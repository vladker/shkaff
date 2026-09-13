package J1;

import P2.d;
import android.content.Context;
import android.os.ParcelFileDescriptor;
import com.shockwave.pdfium.PdfiumCore;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f350a;

    public a(String str) {
        this.f350a = str;
    }

    @Override // J1.b
    public d createDocument(Context context, PdfiumCore pdfiumCore, String str) {
        return pdfiumCore.newDocument(ParcelFileDescriptor.open(K1.a.fileFromAsset(context, this.f350a), 268435456), str);
    }
}
