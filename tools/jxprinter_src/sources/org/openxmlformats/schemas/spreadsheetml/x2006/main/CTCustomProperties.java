package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface CTCustomProperties extends XmlObject {
    public static final DocumentFactory<CTCustomProperties> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTCustomProperties> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctcustomproperties584dtype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTCustomProperty addNewCustomPr();

    CTCustomProperty getCustomPrArray(int i5);

    CTCustomProperty[] getCustomPrArray();

    List<CTCustomProperty> getCustomPrList();

    CTCustomProperty insertNewCustomPr(int i5);

    void removeCustomPr(int i5);

    void setCustomPrArray(int i5, CTCustomProperty cTCustomProperty);

    void setCustomPrArray(CTCustomProperty[] cTCustomPropertyArr);

    int sizeOfCustomPrArray();
}
