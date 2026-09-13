package s5;

import java.util.function.Consumer;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTHyperlinkImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C0 implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8253a;
    public final /* synthetic */ CTHyperlinkImpl b;

    public /* synthetic */ C0(CTHyperlinkImpl cTHyperlinkImpl, int i5) {
        this.f8253a = i5;
        this.b = cTHyperlinkImpl;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        int i5 = this.f8253a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                this.b.removeFldSimple(iIntValue);
                break;
            case 1:
                this.b.removeCustomXml(iIntValue);
                break;
            case 2:
                this.b.removeMoveTo(iIntValue);
                break;
            default:
                this.b.removeOMathPara(iIntValue);
                break;
        }
    }
}
