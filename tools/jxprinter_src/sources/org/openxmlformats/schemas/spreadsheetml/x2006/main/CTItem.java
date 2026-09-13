package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.STXstring;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface CTItem extends XmlObject {
    public static final DocumentFactory<CTItem> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTItem> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctitemc69ctype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    boolean getC();

    boolean getD();

    boolean getE();

    boolean getF();

    boolean getH();

    boolean getM();

    String getN();

    boolean getS();

    boolean getSd();

    STItemType.Enum getT();

    long getX();

    boolean isSetC();

    boolean isSetD();

    boolean isSetE();

    boolean isSetF();

    boolean isSetH();

    boolean isSetM();

    boolean isSetN();

    boolean isSetS();

    boolean isSetSd();

    boolean isSetT();

    boolean isSetX();

    void setC(boolean z6);

    void setD(boolean z6);

    void setE(boolean z6);

    void setF(boolean z6);

    void setH(boolean z6);

    void setM(boolean z6);

    void setN(String str);

    void setS(boolean z6);

    void setSd(boolean z6);

    void setT(STItemType.Enum r6);

    void setX(long j6);

    void unsetC();

    void unsetD();

    void unsetE();

    void unsetF();

    void unsetH();

    void unsetM();

    void unsetN();

    void unsetS();

    void unsetSd();

    void unsetT();

    void unsetX();

    XmlBoolean xgetC();

    XmlBoolean xgetD();

    XmlBoolean xgetE();

    XmlBoolean xgetF();

    XmlBoolean xgetH();

    XmlBoolean xgetM();

    STXstring xgetN();

    XmlBoolean xgetS();

    XmlBoolean xgetSd();

    STItemType xgetT();

    XmlUnsignedInt xgetX();

    void xsetC(XmlBoolean xmlBoolean);

    void xsetD(XmlBoolean xmlBoolean);

    void xsetE(XmlBoolean xmlBoolean);

    void xsetF(XmlBoolean xmlBoolean);

    void xsetH(XmlBoolean xmlBoolean);

    void xsetM(XmlBoolean xmlBoolean);

    void xsetN(STXstring sTXstring);

    void xsetS(XmlBoolean xmlBoolean);

    void xsetSd(XmlBoolean xmlBoolean);

    void xsetT(STItemType sTItemType);

    void xsetX(XmlUnsignedInt xmlUnsignedInt);
}
