package s5;

import java.util.function.Consumer;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTNumberingImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class I0 implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8283a;
    public final /* synthetic */ CTNumberingImpl b;

    public /* synthetic */ I0(CTNumberingImpl cTNumberingImpl, int i5) {
        this.f8283a = i5;
        this.b = cTNumberingImpl;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        int i5 = this.f8283a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                this.b.removeAbstractNum(iIntValue);
                break;
            case 1:
                this.b.removeNumPicBullet(iIntValue);
                break;
            default:
                this.b.removeNum(iIntValue);
                break;
        }
    }
}
