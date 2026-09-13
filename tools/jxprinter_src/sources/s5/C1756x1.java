package s5;

import java.util.function.Consumer;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTRImpl;

/* JADX INFO: renamed from: s5.x1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C1756x1 implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8497a;
    public final /* synthetic */ CTRImpl b;

    public /* synthetic */ C1756x1(CTRImpl cTRImpl, int i5) {
        this.f8497a = i5;
        this.b = cTRImpl;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        int i5 = this.f8497a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                this.b.removeDelText(iIntValue);
                break;
            case 1:
                this.b.removeCommentReference(iIntValue);
                break;
            default:
                this.b.removeLastRenderedPageBreak(iIntValue);
                break;
        }
    }
}
