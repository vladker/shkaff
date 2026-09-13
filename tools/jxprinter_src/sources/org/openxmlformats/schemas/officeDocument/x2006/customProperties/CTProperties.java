package org.openxmlformats.schemas.officeDocument.x2006.customProperties;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface CTProperties extends XmlObject {
    public static final DocumentFactory<CTProperties> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTProperties> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctproperties2c18type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTProperty addNewProperty();

    CTProperty getPropertyArray(int i5);

    CTProperty[] getPropertyArray();

    List<CTProperty> getPropertyList();

    CTProperty insertNewProperty(int i5);

    void removeProperty(int i5);

    void setPropertyArray(int i5, CTProperty cTProperty);

    void setPropertyArray(CTProperty[] cTPropertyArr);

    int sizeOfPropertyArray();
}
