package s5;

import java.util.function.BiConsumer;
import org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTAnchor;
import org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTInline;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTDrawingImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class U implements BiConsumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8341a;
    public final /* synthetic */ CTDrawingImpl b;

    public /* synthetic */ U(CTDrawingImpl cTDrawingImpl, int i5) {
        this.f8341a = i5;
        this.b = cTDrawingImpl;
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        int i5 = this.f8341a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                this.b.setInlineArray(iIntValue, (CTInline) obj2);
                break;
            default:
                this.b.setAnchorArray(iIntValue, (CTAnchor) obj2);
                break;
        }
    }
}
