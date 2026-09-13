package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface CTSingleXmlCells extends XmlObject {
    public static final DocumentFactory<CTSingleXmlCells> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTSingleXmlCells> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctsinglexmlcells5a6btype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTSingleXmlCell addNewSingleXmlCell();

    CTSingleXmlCell getSingleXmlCellArray(int i5);

    CTSingleXmlCell[] getSingleXmlCellArray();

    List<CTSingleXmlCell> getSingleXmlCellList();

    CTSingleXmlCell insertNewSingleXmlCell(int i5);

    void removeSingleXmlCell(int i5);

    void setSingleXmlCellArray(int i5, CTSingleXmlCell cTSingleXmlCell);

    void setSingleXmlCellArray(CTSingleXmlCell[] cTSingleXmlCellArr);

    int sizeOfSingleXmlCellArray();
}
