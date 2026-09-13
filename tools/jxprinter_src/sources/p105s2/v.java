package p105s2;

import com.microsoft.schemas.office.visio.x2012.main.impl.SheetTypeImpl;
import java.util.function.Consumer;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class v implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8226a;
    public final /* synthetic */ SheetTypeImpl b;

    public /* synthetic */ v(SheetTypeImpl sheetTypeImpl, int i5) {
        this.f8226a = i5;
        this.b = sheetTypeImpl;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        int i5 = this.f8226a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                this.b.removeCell(iIntValue);
                break;
            case 1:
                this.b.removeSection(iIntValue);
                break;
            default:
                this.b.removeTrigger(iIntValue);
                break;
        }
    }
}
