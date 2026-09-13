package s5;

import java.util.function.BiConsumer;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDecimalNumber;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFCheckBox;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFName;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFFTextInput;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTOnOff;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTFFDataImpl;

/* JADX INFO: renamed from: s5.c0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C1651c0 implements BiConsumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8384a;
    public final /* synthetic */ CTFFDataImpl b;

    public /* synthetic */ C1651c0(CTFFDataImpl cTFFDataImpl, int i5) {
        this.f8384a = i5;
        this.b = cTFFDataImpl;
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        int i5 = this.f8384a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                this.b.setLabelArray(iIntValue, (CTDecimalNumber) obj2);
                break;
            case 1:
                this.b.setNameArray(iIntValue, (CTFFName) obj2);
                break;
            case 2:
                this.b.setEnabledArray(iIntValue, (CTOnOff) obj2);
                break;
            case 3:
                this.b.setCheckBoxArray(iIntValue, (CTFFCheckBox) obj2);
                break;
            case 4:
                this.b.setTextInputArray(iIntValue, (CTFFTextInput) obj2);
                break;
            default:
                this.b.setCalcOnExitArray(iIntValue, (CTOnOff) obj2);
                break;
        }
    }
}
