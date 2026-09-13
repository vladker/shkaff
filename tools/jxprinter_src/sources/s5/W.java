package s5;

import java.util.function.Supplier;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTDrawingImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class W implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8351a;
    public final /* synthetic */ CTDrawingImpl b;

    public /* synthetic */ W(CTDrawingImpl cTDrawingImpl, int i5) {
        this.f8351a = i5;
        this.b = cTDrawingImpl;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int iSizeOfInlineArray;
        switch (this.f8351a) {
            case 0:
                iSizeOfInlineArray = this.b.sizeOfInlineArray();
                break;
            default:
                iSizeOfInlineArray = this.b.sizeOfAnchorArray();
                break;
        }
        return Integer.valueOf(iSizeOfInlineArray);
    }
}
