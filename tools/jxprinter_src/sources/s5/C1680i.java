package s5;

import java.util.function.Consumer;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTBdoContentRunImpl;

/* JADX INFO: renamed from: s5.i, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C1680i implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8419a;
    public final /* synthetic */ CTBdoContentRunImpl b;

    public /* synthetic */ C1680i(CTBdoContentRunImpl cTBdoContentRunImpl, int i5) {
        this.f8419a = i5;
        this.b = cTBdoContentRunImpl;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        int i5 = this.f8419a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                this.b.removeCustomXmlInsRangeEnd(iIntValue);
                break;
            case 1:
                this.b.removeOMath(iIntValue);
                break;
            case 2:
                this.b.removeMoveFromRangeEnd(iIntValue);
                break;
            default:
                this.b.removeR(iIntValue);
                break;
        }
    }
}
