package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface CTCustomXmlPr extends XmlObject {
    public static final DocumentFactory<CTCustomXmlPr> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTCustomXmlPr> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctcustomxmlpr4b8atype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTAttr addNewAttr();

    CTString addNewPlaceholder();

    CTAttr getAttrArray(int i5);

    CTAttr[] getAttrArray();

    List<CTAttr> getAttrList();

    CTString getPlaceholder();

    CTAttr insertNewAttr(int i5);

    boolean isSetPlaceholder();

    void removeAttr(int i5);

    void setAttrArray(int i5, CTAttr cTAttr);

    void setAttrArray(CTAttr[] cTAttrArr);

    void setPlaceholder(CTString cTString);

    int sizeOfAttrArray();

    void unsetPlaceholder();
}
