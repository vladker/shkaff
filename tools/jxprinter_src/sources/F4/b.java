package F4;

import org.apache.commons.io.IOUtils;
import org.apache.commons.io.function.IOConsumer;
import org.apache.commons.io.output.ThresholdingOutputStream;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class b implements IOConsumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f271a;

    public /* synthetic */ b(int i5) {
        this.f271a = i5;
    }

    @Override // org.apache.commons.io.function.IOConsumer
    public final void accept(Object obj) {
        switch (this.f271a) {
            case 0:
                IOConsumer.lambda$static$0(obj);
                break;
            default:
                IOUtils.lambda$toByteArray$0((ThresholdingOutputStream) obj);
                break;
        }
    }
}
