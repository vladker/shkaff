package M4;

import java.util.function.BiConsumer;
import org.apache.xmlbeans.XmlAnyURI;
import org.apache.xmlbeans.impl.xb.xsdownload.impl.DownloadedSchemaEntryImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class b implements BiConsumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f494a;
    public final /* synthetic */ DownloadedSchemaEntryImpl b;

    public /* synthetic */ b(DownloadedSchemaEntryImpl downloadedSchemaEntryImpl, int i5) {
        this.f494a = i5;
        this.b = downloadedSchemaEntryImpl;
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        int i5 = this.f494a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                this.b.xsetSchemaLocationArray(iIntValue, (XmlAnyURI) obj2);
                break;
            case 1:
                this.b.setSchemaLocationArray(iIntValue, (String) obj2);
                break;
            default:
                this.b.insertSchemaLocation(iIntValue, (String) obj2);
                break;
        }
    }
}
