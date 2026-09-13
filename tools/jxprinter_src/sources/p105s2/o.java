package p105s2;

import com.microsoft.schemas.office.visio.x2012.main.impl.SectionTypeImpl;
import java.util.function.Function;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class o implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8219a;
    public final /* synthetic */ SectionTypeImpl b;

    public /* synthetic */ o(SectionTypeImpl sectionTypeImpl, int i5) {
        this.f8219a = i5;
        this.b = sectionTypeImpl;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i5 = this.f8219a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                return this.b.getTriggerArray(iIntValue);
            case 1:
                return this.b.getRowArray(iIntValue);
            case 2:
                return this.b.insertNewRow(iIntValue);
            case 3:
                return this.b.insertNewTrigger(iIntValue);
            case 4:
                return this.b.getCellArray(iIntValue);
            default:
                return this.b.insertNewCell(iIntValue);
        }
    }
}
