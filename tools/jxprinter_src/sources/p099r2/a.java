package p099r2;

import com.microsoft.schemas.office.excel.impl.CTClientDataImpl;
import java.util.function.Function;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class a implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7933a;
    public final /* synthetic */ CTClientDataImpl b;

    public /* synthetic */ a(CTClientDataImpl cTClientDataImpl, int i5) {
        this.f7933a = i5;
        this.b = cTClientDataImpl;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i5 = this.f7933a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                return this.b.getSelArray(iIntValue);
            case 1:
                return this.b.xgetTextVAlignArray(iIntValue);
            case 2:
                return this.b.insertNewTextVAlign(iIntValue);
            case 3:
                return this.b.xgetFmlaLinkArray(iIntValue);
            case 4:
                return this.b.insertNewFmlaLink(iIntValue);
            case 5:
                return this.b.xgetDisabledArray(iIntValue);
            case 6:
                return this.b.xgetPrintObjectArray(iIntValue);
            case 7:
                return this.b.insertNewPrintObject(iIntValue);
            case 8:
                return this.b.getListItemArray(iIntValue);
            case 9:
                return this.b.xgetScriptTextArray(iIntValue);
            case 10:
                return this.b.insertNewScriptText(iIntValue);
            case 11:
                return this.b.insertNewDisabled(iIntValue);
            case 12:
                return this.b.xgetAutoLineArray(iIntValue);
            case 13:
                return this.b.insertNewAutoLine(iIntValue);
            case 14:
                return this.b.xgetNoThreeDArray(iIntValue);
            case 15:
                return this.b.insertNewNoThreeD(iIntValue);
            case 16:
                return this.b.xgetListItemArray(iIntValue);
            case 17:
                return this.b.insertNewListItem(iIntValue);
            case 18:
                return this.b.xgetMinArray(iIntValue);
            case 19:
                return this.b.insertNewMin(iIntValue);
            case 20:
                return this.b.xgetAutoPictArray(iIntValue);
            case 21:
                return this.b.insertNewAutoPict(iIntValue);
            case 22:
                return this.b.getLockTextArray(iIntValue);
            case 23:
                return this.b.xgetFmlaMacroArray(iIntValue);
            case 24:
                return this.b.insertNewFmlaMacro(iIntValue);
            case 25:
                return this.b.xgetMultiSelArray(iIntValue);
            case 26:
                return this.b.insertNewMultiSel(iIntValue);
            case 27:
                return this.b.getMapOCXArray(iIntValue);
            case 28:
                return this.b.getAccelArray(iIntValue);
            default:
                return this.b.xgetAnchorArray(iIntValue);
        }
    }
}
