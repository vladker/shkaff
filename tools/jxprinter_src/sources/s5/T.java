package s5;

import java.util.function.Function;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTDrawingImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class T implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8336a;
    public final /* synthetic */ CTDrawingImpl b;

    public /* synthetic */ T(CTDrawingImpl cTDrawingImpl, int i5) {
        this.f8336a = i5;
        this.b = cTDrawingImpl;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i5 = this.f8336a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                return this.b.getInlineArray(iIntValue);
            case 1:
                return this.b.insertNewInline(iIntValue);
            case 2:
                return this.b.getAnchorArray(iIntValue);
            default:
                return this.b.insertNewAnchor(iIntValue);
        }
    }
}
