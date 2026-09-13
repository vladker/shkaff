package p099r2;

import com.microsoft.schemas.office.excel.STCF;
import com.microsoft.schemas.office.excel.impl.CTClientDataImpl;
import java.math.BigInteger;
import java.util.function.BiConsumer;
import org.apache.xmlbeans.XmlInteger;
import org.apache.xmlbeans.XmlString;
import org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.STTrueFalseBlank;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class r implements BiConsumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7950a;
    public final /* synthetic */ CTClientDataImpl b;

    public /* synthetic */ r(CTClientDataImpl cTClientDataImpl, int i5) {
        this.f7950a = i5;
        this.b = cTClientDataImpl;
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        int i5 = this.f7950a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                this.b.insertDefault(iIntValue, (STTrueFalseBlank.Enum) obj2);
                break;
            case 1:
                this.b.xsetDxArray(iIntValue, (XmlInteger) obj2);
                break;
            case 2:
                this.b.setDxArray(iIntValue, (BigInteger) obj2);
                break;
            case 3:
                this.b.insertDx(iIntValue, (BigInteger) obj2);
                break;
            case 4:
                this.b.xsetAutoFillArray(iIntValue, (STTrueFalseBlank) obj2);
                break;
            case 5:
                this.b.setPageArray(iIntValue, (BigInteger) obj2);
                break;
            case 6:
                this.b.insertPage(iIntValue, (BigInteger) obj2);
                break;
            case 7:
                this.b.xsetLockTextArray(iIntValue, (STTrueFalseBlank) obj2);
                break;
            case 8:
                this.b.setScriptTextArray(iIntValue, (String) obj2);
                break;
            case 9:
                this.b.insertScriptText(iIntValue, (String) obj2);
                break;
            case 10:
                this.b.xsetCheckedArray(iIntValue, (XmlInteger) obj2);
                break;
            case 11:
                this.b.xsetDropStyleArray(iIntValue, (XmlString) obj2);
                break;
            case 12:
                this.b.setFmlaTxbxArray(iIntValue, (String) obj2);
                break;
            case 13:
                this.b.insertFmlaTxbx(iIntValue, (String) obj2);
                break;
            case 14:
                this.b.setFmlaRangeArray(iIntValue, (String) obj2);
                break;
            case 15:
                this.b.insertFmlaRange(iIntValue, (String) obj2);
                break;
            case 16:
                this.b.setDropLinesArray(iIntValue, (BigInteger) obj2);
                break;
            case 17:
                this.b.insertDropLines(iIntValue, (BigInteger) obj2);
                break;
            case 18:
                this.b.setVScrollArray(iIntValue, (STTrueFalseBlank.Enum) obj2);
                break;
            case 19:
                this.b.insertVScroll(iIntValue, (STTrueFalseBlank.Enum) obj2);
                break;
            case 20:
                this.b.xsetCFArray(iIntValue, (STCF) obj2);
                break;
            case 21:
                this.b.setRowHiddenArray(iIntValue, (STTrueFalseBlank.Enum) obj2);
                break;
            case 22:
                this.b.insertRowHidden(iIntValue, (STTrueFalseBlank.Enum) obj2);
                break;
            case 23:
                this.b.xsetMaxArray(iIntValue, (XmlInteger) obj2);
                break;
            case 24:
                this.b.xsetMoveWithCellsArray(iIntValue, (STTrueFalseBlank) obj2);
                break;
            case 25:
                this.b.xsetTextHAlignArray(iIntValue, (XmlString) obj2);
                break;
            case 26:
                this.b.setDismissArray(iIntValue, (STTrueFalseBlank.Enum) obj2);
                break;
            case 27:
                this.b.insertDismiss(iIntValue, (STTrueFalseBlank.Enum) obj2);
                break;
            case 28:
                this.b.xsetFmlaPictArray(iIntValue, (XmlString) obj2);
                break;
            default:
                this.b.xsetFmlaRangeArray(iIntValue, (XmlString) obj2);
                break;
        }
    }
}
