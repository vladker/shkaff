package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface CTSmartTagPr extends XmlObject {
    public static final DocumentFactory<CTSmartTagPr> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTSmartTagPr> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctsmarttagprf715type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTAttr addNewAttr();

    CTAttr getAttrArray(int i5);

    CTAttr[] getAttrArray();

    List<CTAttr> getAttrList();

    CTAttr insertNewAttr(int i5);

    void removeAttr(int i5);

    void setAttrArray(int i5, CTAttr cTAttr);

    void setAttrArray(CTAttr[] cTAttrArr);

    int sizeOfAttrArray();
}
