package o5;

import java.util.function.Consumer;
import org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.CTVectorImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class d implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6477a;
    public final /* synthetic */ CTVectorImpl b;

    public /* synthetic */ d(CTVectorImpl cTVectorImpl, int i5) {
        this.f6477a = i5;
        this.b = cTVectorImpl;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        int i5 = this.f6477a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                this.b.removeUi2(iIntValue);
                break;
            case 1:
                this.b.removeDate(iIntValue);
                break;
            case 2:
                this.b.removeClsid(iIntValue);
                break;
            case 3:
                this.b.removeI2(iIntValue);
                break;
            case 4:
                this.b.removeR4(iIntValue);
                break;
            case 5:
                this.b.removeBool(iIntValue);
                break;
            case 6:
                this.b.removeI1(iIntValue);
                break;
            case 7:
                this.b.removeFiletime(iIntValue);
                break;
            case 8:
                this.b.removeLpstr(iIntValue);
                break;
            case 9:
                this.b.removeR8(iIntValue);
                break;
            case 10:
                this.b.removeLpwstr(iIntValue);
                break;
            case 11:
                this.b.removeI4(iIntValue);
                break;
            case 12:
                this.b.removeUi8(iIntValue);
                break;
            case 13:
                this.b.removeError(iIntValue);
                break;
            case 14:
                this.b.removeVariant(iIntValue);
                break;
            case 15:
                this.b.removeI8(iIntValue);
                break;
            case 16:
                this.b.removeCy(iIntValue);
                break;
            case 17:
                this.b.removeUi1(iIntValue);
                break;
            case 18:
                this.b.removeBstr(iIntValue);
                break;
            default:
                this.b.removeUi4(iIntValue);
                break;
        }
    }
}
