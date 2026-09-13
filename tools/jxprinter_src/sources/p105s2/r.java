package p105s2;

import com.microsoft.schemas.office.visio.x2012.main.impl.SectionTypeImpl;
import java.util.function.Supplier;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class r implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8222a;
    public final /* synthetic */ SectionTypeImpl b;

    public /* synthetic */ r(SectionTypeImpl sectionTypeImpl, int i5) {
        this.f8222a = i5;
        this.b = sectionTypeImpl;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int iSizeOfRowArray;
        switch (this.f8222a) {
            case 0:
                iSizeOfRowArray = this.b.sizeOfRowArray();
                break;
            case 1:
                iSizeOfRowArray = this.b.sizeOfTriggerArray();
                break;
            default:
                iSizeOfRowArray = this.b.sizeOfCellArray();
                break;
        }
        return Integer.valueOf(iSizeOfRowArray);
    }
}
