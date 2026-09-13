package p099r2;

import com.microsoft.schemas.office.excel.impl.CTClientDataImpl;
import java.util.function.Consumer;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class w implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7955a;
    public final /* synthetic */ CTClientDataImpl b;

    public /* synthetic */ w(CTClientDataImpl cTClientDataImpl, int i5) {
        this.f7955a = i5;
        this.b = cTClientDataImpl;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        int i5 = this.f7955a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                this.b.removeLocked(iIntValue);
                break;
            case 1:
                this.b.removeVScroll(iIntValue);
                break;
            case 2:
                this.b.removeRecalcAlways(iIntValue);
                break;
            case 3:
                this.b.removeScriptLocation(iIntValue);
                break;
            case 4:
                this.b.removeDefault(iIntValue);
                break;
            case 5:
                this.b.removeCancel(iIntValue);
                break;
            default:
                this.b.removeDDE(iIntValue);
                break;
        }
    }
}
