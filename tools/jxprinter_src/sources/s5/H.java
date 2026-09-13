package s5;

import java.util.function.Consumer;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTCustomXmlRunImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class H implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8277a;
    public final /* synthetic */ CTCustomXmlRunImpl b;

    public /* synthetic */ H(CTCustomXmlRunImpl cTCustomXmlRunImpl, int i5) {
        this.f8277a = i5;
        this.b = cTCustomXmlRunImpl;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        int i5 = this.f8277a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                this.b.removeSubDoc(iIntValue);
                break;
            case 1:
                this.b.removeMoveFromRangeEnd(iIntValue);
                break;
            case 2:
                this.b.removeOMathPara(iIntValue);
                break;
            default:
                this.b.removeMoveToRangeStart(iIntValue);
                break;
        }
    }
}
