package p099r2;

import com.microsoft.schemas.office.excel.impl.CTClientDataImpl;
import java.math.BigInteger;
import java.util.function.BiConsumer;
import org.apache.xmlbeans.XmlString;
import org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.STTrueFalseBlank;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class g implements BiConsumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7939a;
    public final /* synthetic */ CTClientDataImpl b;

    public /* synthetic */ g(CTClientDataImpl cTClientDataImpl, int i5) {
        this.f7939a = i5;
        this.b = cTClientDataImpl;
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        int i5 = this.f7939a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                this.b.setPrintObjectArray(iIntValue, (STTrueFalseBlank.Enum) obj2);
                break;
            case 1:
                this.b.insertPrintObject(iIntValue, (STTrueFalseBlank.Enum) obj2);
                break;
            case 2:
                this.b.insertAutoFill(iIntValue, (STTrueFalseBlank.Enum) obj2);
                break;
            case 3:
                this.b.setWidthMinArray(iIntValue, (BigInteger) obj2);
                break;
            case 4:
                this.b.insertWidthMin(iIntValue, (BigInteger) obj2);
                break;
            case 5:
                this.b.setLockedArray(iIntValue, (STTrueFalseBlank.Enum) obj2);
                break;
            case 6:
                this.b.insertLocked(iIntValue, (STTrueFalseBlank.Enum) obj2);
                break;
            case 7:
                this.b.xsetScriptExtendedArray(iIntValue, (XmlString) obj2);
                break;
            case 8:
                this.b.setNoThreeD2Array(iIntValue, (STTrueFalseBlank.Enum) obj2);
                break;
            case 9:
                this.b.insertNoThreeD2(iIntValue, (STTrueFalseBlank.Enum) obj2);
                break;
            case 10:
                this.b.setVisibleArray(iIntValue, (STTrueFalseBlank.Enum) obj2);
                break;
            case 11:
                this.b.insertVisible(iIntValue, (STTrueFalseBlank.Enum) obj2);
                break;
            case 12:
                this.b.setScriptExtendedArray(iIntValue, (String) obj2);
                break;
            case 13:
                this.b.insertScriptExtended(iIntValue, (String) obj2);
                break;
            case 14:
                this.b.setMinArray(iIntValue, (BigInteger) obj2);
                break;
            case 15:
                this.b.insertMin(iIntValue, (BigInteger) obj2);
                break;
            case 16:
                this.b.setCFArray(iIntValue, (String) obj2);
                break;
            case 17:
                this.b.insertCF(iIntValue, (String) obj2);
                break;
            case 18:
                this.b.setMaxArray(iIntValue, (BigInteger) obj2);
                break;
            case 19:
                this.b.insertMax(iIntValue, (BigInteger) obj2);
                break;
            case 20:
                this.b.setColoredArray(iIntValue, (STTrueFalseBlank.Enum) obj2);
                break;
            case 21:
                this.b.insertColored(iIntValue, (STTrueFalseBlank.Enum) obj2);
                break;
            case 22:
                this.b.xsetFmlaGroupArray(iIntValue, (XmlString) obj2);
                break;
            case 23:
                this.b.setIncArray(iIntValue, (BigInteger) obj2);
                break;
            case 24:
                this.b.insertInc(iIntValue, (BigInteger) obj2);
                break;
            case 25:
                this.b.setMultiSelArray(iIntValue, (String) obj2);
                break;
            case 26:
                this.b.insertMultiSel(iIntValue, (String) obj2);
                break;
            case 27:
                this.b.setLCTArray(iIntValue, (String) obj2);
                break;
            case 28:
                this.b.insertLCT(iIntValue, (String) obj2);
                break;
            default:
                this.b.setMoveWithCellsArray(iIntValue, (STTrueFalseBlank.Enum) obj2);
                break;
        }
    }
}
