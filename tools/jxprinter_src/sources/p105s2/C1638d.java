package p105s2;

import com.microsoft.schemas.office.visio.x2012.main.impl.MastersTypeImpl;
import java.util.function.Function;

/* JADX INFO: renamed from: s2.d, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C1638d implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8208a;
    public final /* synthetic */ MastersTypeImpl b;

    public /* synthetic */ C1638d(MastersTypeImpl mastersTypeImpl, int i5) {
        this.f8208a = i5;
        this.b = mastersTypeImpl;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i5 = this.f8208a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                return this.b.getMasterArray(iIntValue);
            case 1:
                return this.b.insertNewMaster(iIntValue);
            case 2:
                return this.b.getMasterShortcutArray(iIntValue);
            default:
                return this.b.insertNewMasterShortcut(iIntValue);
        }
    }
}
