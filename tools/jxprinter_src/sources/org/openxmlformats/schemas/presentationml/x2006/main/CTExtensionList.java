package org.openxmlformats.schemas.presentationml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface CTExtensionList extends XmlObject {
    public static final DocumentFactory<CTExtensionList> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTExtensionList> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctextensionlist4772type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTExtension addNewExt();

    CTExtension getExtArray(int i5);

    CTExtension[] getExtArray();

    List<CTExtension> getExtList();

    CTExtension insertNewExt(int i5);

    void removeExt(int i5);

    void setExtArray(int i5, CTExtension cTExtension);

    void setExtArray(CTExtension[] cTExtensionArr);

    int sizeOfExtArray();
}
