package p105s2;

import com.microsoft.schemas.office.visio.x2012.main.CellType;
import com.microsoft.schemas.office.visio.x2012.main.SectionType;
import com.microsoft.schemas.office.visio.x2012.main.TriggerType;
import com.microsoft.schemas.office.visio.x2012.main.impl.SheetTypeImpl;
import java.util.function.BiConsumer;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class u implements BiConsumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8225a;
    public final /* synthetic */ SheetTypeImpl b;

    public /* synthetic */ u(SheetTypeImpl sheetTypeImpl, int i5) {
        this.f8225a = i5;
        this.b = sheetTypeImpl;
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        int i5 = this.f8225a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                this.b.setCellArray(iIntValue, (CellType) obj2);
                break;
            case 1:
                this.b.setSectionArray(iIntValue, (SectionType) obj2);
                break;
            default:
                this.b.setTriggerArray(iIntValue, (TriggerType) obj2);
                break;
        }
    }
}
