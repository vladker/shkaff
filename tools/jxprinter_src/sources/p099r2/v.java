package p099r2;

import com.microsoft.schemas.office.excel.impl.CTClientDataImpl;
import java.util.function.Function;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class v implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7954a;
    public final /* synthetic */ CTClientDataImpl b;

    public /* synthetic */ v(CTClientDataImpl cTClientDataImpl, int i5) {
        this.f7954a = i5;
        this.b = cTClientDataImpl;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i5 = this.f7954a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                return this.b.xgetCancelArray(iIntValue);
            case 1:
                return this.b.insertNewCancel(iIntValue);
            case 2:
                return this.b.xgetScriptLocationArray(iIntValue);
            case 3:
                return this.b.insertNewScriptLocation(iIntValue);
            case 4:
                return this.b.getRowArray(iIntValue);
            case 5:
                return this.b.xgetVisibleArray(iIntValue);
            case 6:
                return this.b.insertNewVisible(iIntValue);
            case 7:
                return this.b.getSelTypeArray(iIntValue);
            case 8:
                return this.b.getAutoPictArray(iIntValue);
            case 9:
                return this.b.xgetFmlaTxbxArray(iIntValue);
            case 10:
                return this.b.insertNewFmlaTxbx(iIntValue);
            case 11:
                return this.b.xgetLockedArray(iIntValue);
            case 12:
                return this.b.insertNewLocked(iIntValue);
            case 13:
                return this.b.xgetVScrollArray(iIntValue);
            case 14:
                return this.b.insertNewVScroll(iIntValue);
            case 15:
                return this.b.getRecalcAlwaysArray(iIntValue);
            case 16:
                return this.b.insertNewDefault(iIntValue);
            case 17:
                return this.b.getScriptLocationArray(iIntValue);
            case 18:
                return this.b.getCancelArray(iIntValue);
            case 19:
                return this.b.xgetDDEArray(iIntValue);
            default:
                return this.b.insertNewDDE(iIntValue);
        }
    }
}
