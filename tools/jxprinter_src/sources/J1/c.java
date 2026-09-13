package J1;

import K1.f;
import P2.d;
import android.content.Context;
import com.shockwave.pdfium.PdfiumCore;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class c implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public InputStream f351a;

    @Override // J1.b
    public d createDocument(Context context, PdfiumCore pdfiumCore, String str) {
        return pdfiumCore.newDocument(f.toByteArray(this.f351a), str);
    }
}
