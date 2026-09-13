package s5;

import java.util.function.Consumer;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTDrawingImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class V implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8346a;
    public final /* synthetic */ CTDrawingImpl b;

    public /* synthetic */ V(CTDrawingImpl cTDrawingImpl, int i5) {
        this.f8346a = i5;
        this.b = cTDrawingImpl;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        int i5 = this.f8346a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                this.b.removeInline(iIntValue);
                break;
            default:
                this.b.removeAnchor(iIntValue);
                break;
        }
    }
}
