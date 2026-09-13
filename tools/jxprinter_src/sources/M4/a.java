package M4;

import java.util.function.Function;
import org.apache.xmlbeans.impl.xb.xsdownload.impl.DownloadedSchemaEntryImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class a implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f493a;
    public final /* synthetic */ DownloadedSchemaEntryImpl b;

    public /* synthetic */ a(DownloadedSchemaEntryImpl downloadedSchemaEntryImpl, int i5) {
        this.f493a = i5;
        this.b = downloadedSchemaEntryImpl;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i5 = this.f493a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                return this.b.xgetSchemaLocationArray(iIntValue);
            case 1:
                return this.b.insertNewSchemaLocation(iIntValue);
            default:
                return this.b.getSchemaLocationArray(iIntValue);
        }
    }
}
