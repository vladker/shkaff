package p105s2;

import com.microsoft.schemas.office.visio.x2012.main.impl.TextTypeImpl;
import java.util.function.Supplier;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class B implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8201a;
    public final /* synthetic */ TextTypeImpl b;

    public /* synthetic */ B(TextTypeImpl textTypeImpl, int i5) {
        this.f8201a = i5;
        this.b = textTypeImpl;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int iSizeOfFldArray;
        switch (this.f8201a) {
            case 0:
                iSizeOfFldArray = this.b.sizeOfFldArray();
                break;
            case 1:
                iSizeOfFldArray = this.b.sizeOfCpArray();
                break;
            case 2:
                iSizeOfFldArray = this.b.sizeOfPpArray();
                break;
            default:
                iSizeOfFldArray = this.b.sizeOfTpArray();
                break;
        }
        return Integer.valueOf(iSizeOfFldArray);
    }
}
