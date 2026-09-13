package C4;

import java.security.PrivilegedAction;
import org.apache.commons.compress.archivers.ArchiveStreamFactory;
import org.apache.commons.compress.compressors.CompressorStreamFactory;
import org.apache.poi.poifs.nio.CleanerUtil;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class a implements PrivilegedAction {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f138a;

    public /* synthetic */ a(int i5) {
        this.f138a = i5;
    }

    @Override // java.security.PrivilegedAction
    public final Object run() {
        switch (this.f138a) {
            case 0:
                return CompressorStreamFactory.lambda$findAvailableCompressorOutputStreamProviders$1();
            case 1:
                return CompressorStreamFactory.lambda$findAvailableCompressorInputStreamProviders$0();
            case 2:
                return ArchiveStreamFactory.lambda$findAvailableArchiveOutputStreamProviders$1();
            case 3:
                return ArchiveStreamFactory.lambda$findAvailableArchiveInputStreamProviders$0();
            default:
                return CleanerUtil.unmapHackImpl();
        }
    }
}
