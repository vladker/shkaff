package o5;

import java.util.function.Supplier;
import org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.CTVectorImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class b implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6475a;
    public final /* synthetic */ CTVectorImpl b;

    public /* synthetic */ b(CTVectorImpl cTVectorImpl, int i5) {
        this.f6475a = i5;
        this.b = cTVectorImpl;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int iSizeOfBstrArray;
        switch (this.f6475a) {
            case 0:
                iSizeOfBstrArray = this.b.sizeOfBstrArray();
                break;
            case 1:
                iSizeOfBstrArray = this.b.sizeOfUi2Array();
                break;
            case 2:
                iSizeOfBstrArray = this.b.sizeOfUi4Array();
                break;
            case 3:
                iSizeOfBstrArray = this.b.sizeOfDateArray();
                break;
            case 4:
                iSizeOfBstrArray = this.b.sizeOfClsidArray();
                break;
            case 5:
                iSizeOfBstrArray = this.b.sizeOfI2Array();
                break;
            case 6:
                iSizeOfBstrArray = this.b.sizeOfBoolArray();
                break;
            case 7:
                iSizeOfBstrArray = this.b.sizeOfR4Array();
                break;
            case 8:
                iSizeOfBstrArray = this.b.sizeOfI1Array();
                break;
            case 9:
                iSizeOfBstrArray = this.b.sizeOfFiletimeArray();
                break;
            case 10:
                iSizeOfBstrArray = this.b.sizeOfLpstrArray();
                break;
            case 11:
                iSizeOfBstrArray = this.b.sizeOfR8Array();
                break;
            case 12:
                iSizeOfBstrArray = this.b.sizeOfI4Array();
                break;
            case 13:
                iSizeOfBstrArray = this.b.sizeOfUi8Array();
                break;
            case 14:
                iSizeOfBstrArray = this.b.sizeOfLpwstrArray();
                break;
            case 15:
                iSizeOfBstrArray = this.b.sizeOfErrorArray();
                break;
            case 16:
                iSizeOfBstrArray = this.b.sizeOfVariantArray();
                break;
            case 17:
                iSizeOfBstrArray = this.b.sizeOfI8Array();
                break;
            case 18:
                iSizeOfBstrArray = this.b.sizeOfCyArray();
                break;
            default:
                iSizeOfBstrArray = this.b.sizeOfUi1Array();
                break;
        }
        return Integer.valueOf(iSizeOfBstrArray);
    }
}
