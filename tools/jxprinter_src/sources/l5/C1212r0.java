package l5;

import java.util.function.Consumer;
import org.openxmlformats.schemas.drawingml.x2006.main.impl.CTFillStyleListImpl;

/* JADX INFO: renamed from: l5.r0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class C1212r0 implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6038a;
    public final /* synthetic */ CTFillStyleListImpl b;

    public /* synthetic */ C1212r0(CTFillStyleListImpl cTFillStyleListImpl, int i5) {
        this.f6038a = i5;
        this.b = cTFillStyleListImpl;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        int i5 = this.f6038a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                this.b.removeSolidFill(iIntValue);
                break;
            case 1:
                this.b.removeBlipFill(iIntValue);
                break;
            case 2:
                this.b.removeGradFill(iIntValue);
                break;
            case 3:
                this.b.removeNoFill(iIntValue);
                break;
            case 4:
                this.b.removeGrpFill(iIntValue);
                break;
            default:
                this.b.removePattFill(iIntValue);
                break;
        }
    }
}
