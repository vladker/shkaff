package s5;

import java.util.function.Function;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTFFDataImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class Y implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8361a;
    public final /* synthetic */ CTFFDataImpl b;

    public /* synthetic */ Y(CTFFDataImpl cTFFDataImpl, int i5) {
        this.f8361a = i5;
        this.b = cTFFDataImpl;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i5 = this.f8361a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                return this.b.getNameArray(iIntValue);
            case 1:
                return this.b.getTabIndexArray(iIntValue);
            case 2:
                return this.b.insertNewTabIndex(iIntValue);
            case 3:
                return this.b.getLabelArray(iIntValue);
            case 4:
                return this.b.insertNewLabel(iIntValue);
            case 5:
                return this.b.getEnabledArray(iIntValue);
            case 6:
                return this.b.insertNewEnabled(iIntValue);
            case 7:
                return this.b.getCheckBoxArray(iIntValue);
            case 8:
                return this.b.insertNewCheckBox(iIntValue);
            case 9:
                return this.b.insertNewName(iIntValue);
            case 10:
                return this.b.getDdListArray(iIntValue);
            case 11:
                return this.b.insertNewDdList(iIntValue);
            case 12:
                return this.b.getStatusTextArray(iIntValue);
            case 13:
                return this.b.insertNewStatusText(iIntValue);
            case 14:
                return this.b.getExitMacroArray(iIntValue);
            case 15:
                return this.b.insertNewExitMacro(iIntValue);
            case 16:
                return this.b.getTextInputArray(iIntValue);
            case 17:
                return this.b.insertNewTextInput(iIntValue);
            case 18:
                return this.b.getEntryMacroArray(iIntValue);
            case 19:
                return this.b.insertNewEntryMacro(iIntValue);
            case 20:
                return this.b.getHelpTextArray(iIntValue);
            case 21:
                return this.b.insertNewHelpText(iIntValue);
            case 22:
                return this.b.getCalcOnExitArray(iIntValue);
            default:
                return this.b.insertNewCalcOnExit(iIntValue);
        }
    }
}
