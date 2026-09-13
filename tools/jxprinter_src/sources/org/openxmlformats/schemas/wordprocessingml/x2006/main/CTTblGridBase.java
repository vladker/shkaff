package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface CTTblGridBase extends XmlObject {
    public static final DocumentFactory<CTTblGridBase> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTTblGridBase> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "cttblgridbasea11dtype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTTblGridCol addNewGridCol();

    CTTblGridCol getGridColArray(int i5);

    CTTblGridCol[] getGridColArray();

    List<CTTblGridCol> getGridColList();

    CTTblGridCol insertNewGridCol(int i5);

    void removeGridCol(int i5);

    void setGridColArray(int i5, CTTblGridCol cTTblGridCol);

    void setGridColArray(CTTblGridCol[] cTTblGridColArr);

    int sizeOfGridColArray();
}
