package p088p3;

import io.reactivex.InterfaceC0984q;
import p094q3.c;
import t5.d;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class f extends c implements InterfaceC0984q {
    private static final long serialVersionUID = 2984505488220891551L;
    public d c;

    @Override // p094q3.c, t5.d
    public void cancel() {
        super.cancel();
        this.c.cancel();
    }
}
