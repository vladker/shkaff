package s5;

import java.util.function.Supplier;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTFFDataImpl;

/* JADX INFO: renamed from: s5.b0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C1646b0 implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8378a;
    public final /* synthetic */ CTFFDataImpl b;

    public /* synthetic */ C1646b0(CTFFDataImpl cTFFDataImpl, int i5) {
        this.f8378a = i5;
        this.b = cTFFDataImpl;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int iSizeOfTabIndexArray;
        switch (this.f8378a) {
            case 0:
                iSizeOfTabIndexArray = this.b.sizeOfTabIndexArray();
                break;
            case 1:
                iSizeOfTabIndexArray = this.b.sizeOfLabelArray();
                break;
            case 2:
                iSizeOfTabIndexArray = this.b.sizeOfEnabledArray();
                break;
            case 3:
                iSizeOfTabIndexArray = this.b.sizeOfCheckBoxArray();
                break;
            case 4:
                iSizeOfTabIndexArray = this.b.sizeOfDdListArray();
                break;
            case 5:
                iSizeOfTabIndexArray = this.b.sizeOfStatusTextArray();
                break;
            case 6:
                iSizeOfTabIndexArray = this.b.sizeOfExitMacroArray();
                break;
            case 7:
                iSizeOfTabIndexArray = this.b.sizeOfTextInputArray();
                break;
            case 8:
                iSizeOfTabIndexArray = this.b.sizeOfNameArray();
                break;
            case 9:
                iSizeOfTabIndexArray = this.b.sizeOfEntryMacroArray();
                break;
            case 10:
                iSizeOfTabIndexArray = this.b.sizeOfHelpTextArray();
                break;
            default:
                iSizeOfTabIndexArray = this.b.sizeOfCalcOnExitArray();
                break;
        }
        return Integer.valueOf(iSizeOfTabIndexArray);
    }
}
