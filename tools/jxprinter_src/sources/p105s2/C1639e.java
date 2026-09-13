package p105s2;

import com.microsoft.schemas.office.visio.x2012.main.impl.MastersTypeImpl;
import java.util.function.Consumer;

/* JADX INFO: renamed from: s2.e, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C1639e implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8209a;
    public final /* synthetic */ MastersTypeImpl b;

    public /* synthetic */ C1639e(MastersTypeImpl mastersTypeImpl, int i5) {
        this.f8209a = i5;
        this.b = mastersTypeImpl;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        int i5 = this.f8209a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                this.b.removeMaster(iIntValue);
                break;
            default:
                this.b.removeMasterShortcut(iIntValue);
                break;
        }
    }
}
