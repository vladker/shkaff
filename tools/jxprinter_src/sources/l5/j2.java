package l5;

import java.util.function.Consumer;
import org.openxmlformats.schemas.drawingml.x2006.main.impl.CTTextParagraphImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class j2 implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6013a;
    public final /* synthetic */ CTTextParagraphImpl b;

    public /* synthetic */ j2(CTTextParagraphImpl cTTextParagraphImpl, int i5) {
        this.f6013a = i5;
        this.b = cTTextParagraphImpl;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        int i5 = this.f6013a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                this.b.removeR(iIntValue);
                break;
            case 1:
                this.b.removeFld(iIntValue);
                break;
            default:
                this.b.removeBr(iIntValue);
                break;
        }
    }
}
