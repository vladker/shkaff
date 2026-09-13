package s5;

import java.util.function.Consumer;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTFFDataImpl;

/* JADX INFO: renamed from: s5.a0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C1641a0 implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8372a;
    public final /* synthetic */ CTFFDataImpl b;

    public /* synthetic */ C1641a0(CTFFDataImpl cTFFDataImpl, int i5) {
        this.f8372a = i5;
        this.b = cTFFDataImpl;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        int i5 = this.f8372a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                this.b.removeTabIndex(iIntValue);
                break;
            case 1:
                this.b.removeLabel(iIntValue);
                break;
            case 2:
                this.b.removeEnabled(iIntValue);
                break;
            case 3:
                this.b.removeCheckBox(iIntValue);
                break;
            case 4:
                this.b.removeDdList(iIntValue);
                break;
            case 5:
                this.b.removeStatusText(iIntValue);
                break;
            case 6:
                this.b.removeName(iIntValue);
                break;
            case 7:
                this.b.removeExitMacro(iIntValue);
                break;
            case 8:
                this.b.removeTextInput(iIntValue);
                break;
            case 9:
                this.b.removeEntryMacro(iIntValue);
                break;
            case 10:
                this.b.removeHelpText(iIntValue);
                break;
            default:
                this.b.removeCalcOnExit(iIntValue);
                break;
        }
    }
}
