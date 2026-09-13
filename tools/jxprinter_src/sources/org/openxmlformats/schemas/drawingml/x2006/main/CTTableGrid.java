package org.openxmlformats.schemas.drawingml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface CTTableGrid extends XmlObject {
    public static final DocumentFactory<CTTableGrid> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTTableGrid> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "cttablegrid69a5type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTTableCol addNewGridCol();

    CTTableCol getGridColArray(int i5);

    CTTableCol[] getGridColArray();

    List<CTTableCol> getGridColList();

    CTTableCol insertNewGridCol(int i5);

    void removeGridCol(int i5);

    void setGridColArray(int i5, CTTableCol cTTableCol);

    void setGridColArray(CTTableCol[] cTTableColArr);

    int sizeOfGridColArray();
}
