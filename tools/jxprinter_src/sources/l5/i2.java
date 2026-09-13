package l5;

import java.util.function.BiConsumer;
import org.openxmlformats.schemas.drawingml.x2006.main.CTRegularTextRun;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextField;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextLineBreak;
import org.openxmlformats.schemas.drawingml.x2006.main.impl.CTTextParagraphImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class i2 implements BiConsumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6009a;
    public final /* synthetic */ CTTextParagraphImpl b;

    public /* synthetic */ i2(CTTextParagraphImpl cTTextParagraphImpl, int i5) {
        this.f6009a = i5;
        this.b = cTTextParagraphImpl;
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        int i5 = this.f6009a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                this.b.setRArray(iIntValue, (CTRegularTextRun) obj2);
                break;
            case 1:
                this.b.setFldArray(iIntValue, (CTTextField) obj2);
                break;
            default:
                this.b.setBrArray(iIntValue, (CTTextLineBreak) obj2);
                break;
        }
    }
}
