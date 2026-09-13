package org.openxmlformats.schemas.drawingml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface CTOfficeArtExtensionList extends XmlObject {
    public static final DocumentFactory<CTOfficeArtExtensionList> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTOfficeArtExtensionList> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctofficeartextensionlista211type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTOfficeArtExtension addNewExt();

    CTOfficeArtExtension getExtArray(int i5);

    CTOfficeArtExtension[] getExtArray();

    List<CTOfficeArtExtension> getExtList();

    CTOfficeArtExtension insertNewExt(int i5);

    void removeExt(int i5);

    void setExtArray(int i5, CTOfficeArtExtension cTOfficeArtExtension);

    void setExtArray(CTOfficeArtExtension[] cTOfficeArtExtensionArr);

    int sizeOfExtArray();
}
