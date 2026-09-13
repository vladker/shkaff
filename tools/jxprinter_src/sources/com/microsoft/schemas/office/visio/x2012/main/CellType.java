package com.microsoft.schemas.office.visio.x2012.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public interface CellType extends XmlObject {
    public static final DocumentFactory<CellType> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CellType> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "celltyped857type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    RefByType addNewRefBy();

    String getE();

    String getF();

    String getN();

    RefByType getRefByArray(int i5);

    RefByType[] getRefByArray();

    List<RefByType> getRefByList();

    String getU();

    String getV();

    RefByType insertNewRefBy(int i5);

    boolean isSetE();

    boolean isSetF();

    boolean isSetU();

    boolean isSetV();

    void removeRefBy(int i5);

    void setE(String str);

    void setF(String str);

    void setN(String str);

    void setRefByArray(int i5, RefByType refByType);

    void setRefByArray(RefByType[] refByTypeArr);

    void setU(String str);

    void setV(String str);

    int sizeOfRefByArray();

    void unsetE();

    void unsetF();

    void unsetU();

    void unsetV();

    XmlString xgetE();

    XmlString xgetF();

    XmlString xgetN();

    XmlString xgetU();

    XmlString xgetV();

    void xsetE(XmlString xmlString);

    void xsetF(XmlString xmlString);

    void xsetN(XmlString xmlString);

    void xsetU(XmlString xmlString);

    void xsetV(XmlString xmlString);
}
