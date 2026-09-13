package com.microsoft.schemas.office.visio.x2012.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public interface TriggerType extends XmlObject {
    public static final DocumentFactory<TriggerType> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<TriggerType> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "triggertype2933type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    RefByType addNewRefBy();

    String getN();

    RefByType getRefByArray(int i5);

    RefByType[] getRefByArray();

    List<RefByType> getRefByList();

    RefByType insertNewRefBy(int i5);

    void removeRefBy(int i5);

    void setN(String str);

    void setRefByArray(int i5, RefByType refByType);

    void setRefByArray(RefByType[] refByTypeArr);

    int sizeOfRefByArray();

    XmlString xgetN();

    void xsetN(XmlString xmlString);
}
