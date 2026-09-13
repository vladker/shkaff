package o5;

import java.util.Calendar;
import java.util.function.BiConsumer;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlByte;
import org.apache.xmlbeans.XmlDateTime;
import org.apache.xmlbeans.XmlLong;
import org.apache.xmlbeans.XmlShort;
import org.apache.xmlbeans.XmlUnsignedByte;
import org.apache.xmlbeans.XmlUnsignedShort;
import org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.CTVectorImpl;
import org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.STGuid;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class c implements BiConsumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6476a;
    public final /* synthetic */ CTVectorImpl b;

    public /* synthetic */ c(CTVectorImpl cTVectorImpl, int i5) {
        this.f6476a = i5;
        this.b = cTVectorImpl;
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        int i5 = this.f6476a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                this.b.xsetUi2Array(iIntValue, (XmlUnsignedShort) obj2);
                break;
            case 1:
                this.b.setLpwstrArray(iIntValue, (String) obj2);
                break;
            case 2:
                this.b.insertLpwstr(iIntValue, (String) obj2);
                break;
            case 3:
                this.b.setFiletimeArray(iIntValue, (Calendar) obj2);
                break;
            case 4:
                this.b.insertFiletime(iIntValue, (Calendar) obj2);
                break;
            case 5:
                this.b.xsetDateArray(iIntValue, (XmlDateTime) obj2);
                break;
            case 6:
                this.b.setClsidArray(iIntValue, (String) obj2);
                break;
            case 7:
                this.b.insertClsid(iIntValue, (String) obj2);
                break;
            case 8:
                this.b.xsetClsidArray(iIntValue, (STGuid) obj2);
                break;
            case 9:
                this.b.setR4Array(iIntValue, ((Float) obj2).floatValue());
                break;
            case 10:
                this.b.xsetI2Array(iIntValue, (XmlShort) obj2);
                break;
            case 11:
                this.b.setI2Array(iIntValue, ((Short) obj2).shortValue());
                break;
            case 12:
                this.b.insertI2(iIntValue, ((Short) obj2).shortValue());
                break;
            case 13:
                this.b.insertR4(iIntValue, ((Float) obj2).floatValue());
                break;
            case 14:
                this.b.setBstrArray(iIntValue, (String) obj2);
                break;
            case 15:
                this.b.insertBstr(iIntValue, (String) obj2);
                break;
            case 16:
                this.b.xsetUi1Array(iIntValue, (XmlUnsignedByte) obj2);
                break;
            case 17:
                this.b.setBoolArray(iIntValue, ((Boolean) obj2).booleanValue());
                break;
            case 18:
                this.b.insertBool(iIntValue, ((Boolean) obj2).booleanValue());
                break;
            case 19:
                this.b.xsetI8Array(iIntValue, (XmlLong) obj2);
                break;
            case 20:
                this.b.setErrorArray(iIntValue, (String) obj2);
                break;
            case 21:
                this.b.insertError(iIntValue, (String) obj2);
                break;
            case 22:
                this.b.setDateArray(iIntValue, (Calendar) obj2);
                break;
            case 23:
                this.b.insertDate(iIntValue, (Calendar) obj2);
                break;
            case 24:
                this.b.xsetBoolArray(iIntValue, (XmlBoolean) obj2);
                break;
            case 25:
                this.b.setLpstrArray(iIntValue, (String) obj2);
                break;
            case 26:
                this.b.insertLpstr(iIntValue, (String) obj2);
                break;
            case 27:
                this.b.setUi2Array(iIntValue, ((Integer) obj2).intValue());
                break;
            case 28:
                this.b.insertUi2(iIntValue, ((Integer) obj2).intValue());
                break;
            default:
                this.b.xsetI1Array(iIntValue, (XmlByte) obj2);
                break;
        }
    }
}
