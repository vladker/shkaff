package p099r2;

import com.microsoft.schemas.office.excel.impl.CTClientDataImpl;
import java.math.BigInteger;
import java.util.function.BiConsumer;
import org.apache.xmlbeans.XmlInteger;
import org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.STTrueFalseBlank;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class h implements BiConsumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7940a;
    public final /* synthetic */ CTClientDataImpl b;

    public /* synthetic */ h(CTClientDataImpl cTClientDataImpl, int i5) {
        this.f7940a = i5;
        this.b = cTClientDataImpl;
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        int i5 = this.f7940a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                this.b.insertSel(iIntValue, (BigInteger) obj2);
                break;
            case 1:
                this.b.setScriptLanguageArray(iIntValue, (BigInteger) obj2);
                break;
            case 2:
                this.b.insertScriptLanguage(iIntValue, (BigInteger) obj2);
                break;
            case 3:
                this.b.setUIObjArray(iIntValue, (STTrueFalseBlank.Enum) obj2);
                break;
            case 4:
                this.b.insertUIObj(iIntValue, (STTrueFalseBlank.Enum) obj2);
                break;
            case 5:
                this.b.insertMoveWithCells(iIntValue, (STTrueFalseBlank.Enum) obj2);
                break;
            case 6:
                this.b.setTextVAlignArray(iIntValue, (String) obj2);
                break;
            case 7:
                this.b.insertTextVAlign(iIntValue, (String) obj2);
                break;
            case 8:
                this.b.setFmlaGroupArray(iIntValue, (String) obj2);
                break;
            case 9:
                this.b.insertFmlaGroup(iIntValue, (String) obj2);
                break;
            case 10:
                this.b.setDefaultSizeArray(iIntValue, (STTrueFalseBlank.Enum) obj2);
                break;
            case 11:
                this.b.insertDefaultSize(iIntValue, (STTrueFalseBlank.Enum) obj2);
                break;
            case 12:
                this.b.setDropStyleArray(iIntValue, (String) obj2);
                break;
            case 13:
                this.b.insertDropStyle(iIntValue, (String) obj2);
                break;
            case 14:
                this.b.setSizeWithCellsArray(iIntValue, (STTrueFalseBlank.Enum) obj2);
                break;
            case 15:
                this.b.insertSizeWithCells(iIntValue, (STTrueFalseBlank.Enum) obj2);
                break;
            case 16:
                this.b.setCheckedArray(iIntValue, (BigInteger) obj2);
                break;
            case 17:
                this.b.insertChecked(iIntValue, (BigInteger) obj2);
                break;
            case 18:
                this.b.xsetHorizArray(iIntValue, (STTrueFalseBlank) obj2);
                break;
            case 19:
                this.b.setNoThreeDArray(iIntValue, (STTrueFalseBlank.Enum) obj2);
                break;
            case 20:
                this.b.insertNoThreeD(iIntValue, (STTrueFalseBlank.Enum) obj2);
                break;
            case 21:
                this.b.setColHiddenArray(iIntValue, (STTrueFalseBlank.Enum) obj2);
                break;
            case 22:
                this.b.xsetRowHiddenArray(iIntValue, (STTrueFalseBlank) obj2);
                break;
            case 23:
                this.b.xsetHelpArray(iIntValue, (STTrueFalseBlank) obj2);
                break;
            case 24:
                this.b.insertColHidden(iIntValue, (STTrueFalseBlank.Enum) obj2);
                break;
            case 25:
                this.b.setMultiLineArray(iIntValue, (STTrueFalseBlank.Enum) obj2);
                break;
            case 26:
                this.b.insertMultiLine(iIntValue, (STTrueFalseBlank.Enum) obj2);
                break;
            case 27:
                this.b.xsetIncArray(iIntValue, (XmlInteger) obj2);
                break;
            case 28:
                this.b.xsetJustLastXArray(iIntValue, (STTrueFalseBlank) obj2);
                break;
            default:
                this.b.xsetVTEditArray(iIntValue, (XmlInteger) obj2);
                break;
        }
    }
}
