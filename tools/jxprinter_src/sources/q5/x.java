package q5;

import java.util.function.BiConsumer;
import org.openxmlformats.schemas.presentationml.x2006.main.CTTLMediaNodeVideo;
import org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeNodeParallel;
import org.openxmlformats.schemas.presentationml.x2006.main.impl.CTTimeNodeListImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class x implements BiConsumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7878a;
    public final /* synthetic */ CTTimeNodeListImpl b;

    public /* synthetic */ x(CTTimeNodeListImpl cTTimeNodeListImpl, int i5) {
        this.f7878a = i5;
        this.b = cTTimeNodeListImpl;
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        int i5 = this.f7878a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                this.b.setParArray(iIntValue, (CTTLTimeNodeParallel) obj2);
                break;
            default:
                this.b.setVideoArray(iIntValue, (CTTLMediaNodeVideo) obj2);
                break;
        }
    }
}
