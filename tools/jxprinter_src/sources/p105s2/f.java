package p105s2;

import com.microsoft.schemas.office.visio.x2012.main.impl.MastersTypeImpl;
import java.util.function.Supplier;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class f implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8210a;
    public final /* synthetic */ MastersTypeImpl b;

    public /* synthetic */ f(MastersTypeImpl mastersTypeImpl, int i5) {
        this.f8210a = i5;
        this.b = mastersTypeImpl;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int iSizeOfMasterArray;
        switch (this.f8210a) {
            case 0:
                iSizeOfMasterArray = this.b.sizeOfMasterArray();
                break;
            default:
                iSizeOfMasterArray = this.b.sizeOfMasterShortcutArray();
                break;
        }
        return Integer.valueOf(iSizeOfMasterArray);
    }
}
