package p105s2;

import com.microsoft.schemas.office.visio.x2012.main.impl.SheetTypeImpl;
import java.util.function.Function;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class t implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8224a;
    public final /* synthetic */ SheetTypeImpl b;

    public /* synthetic */ t(SheetTypeImpl sheetTypeImpl, int i5) {
        this.f8224a = i5;
        this.b = sheetTypeImpl;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i5 = this.f8224a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                return this.b.getSectionArray(iIntValue);
            case 1:
                return this.b.getCellArray(iIntValue);
            case 2:
                return this.b.insertNewCell(iIntValue);
            case 3:
                return this.b.insertNewSection(iIntValue);
            case 4:
                return this.b.getTriggerArray(iIntValue);
            default:
                return this.b.insertNewTrigger(iIntValue);
        }
    }
}
