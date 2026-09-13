package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface CTMapInfo extends XmlObject {
    public static final DocumentFactory<CTMapInfo> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTMapInfo> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctmapinfo1a09type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTMap addNewMap();

    CTSchema addNewSchema();

    CTMap getMapArray(int i5);

    CTMap[] getMapArray();

    List<CTMap> getMapList();

    CTSchema getSchemaArray(int i5);

    CTSchema[] getSchemaArray();

    List<CTSchema> getSchemaList();

    String getSelectionNamespaces();

    CTMap insertNewMap(int i5);

    CTSchema insertNewSchema(int i5);

    void removeMap(int i5);

    void removeSchema(int i5);

    void setMapArray(int i5, CTMap cTMap);

    void setMapArray(CTMap[] cTMapArr);

    void setSchemaArray(int i5, CTSchema cTSchema);

    void setSchemaArray(CTSchema[] cTSchemaArr);

    void setSelectionNamespaces(String str);

    int sizeOfMapArray();

    int sizeOfSchemaArray();

    XmlString xgetSelectionNamespaces();

    void xsetSelectionNamespaces(XmlString xmlString);
}
