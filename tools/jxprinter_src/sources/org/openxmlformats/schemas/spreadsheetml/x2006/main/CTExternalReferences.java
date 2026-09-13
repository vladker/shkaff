package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface CTExternalReferences extends XmlObject {
    public static final DocumentFactory<CTExternalReferences> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTExternalReferences> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctexternalreferencesd77ctype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTExternalReference addNewExternalReference();

    CTExternalReference getExternalReferenceArray(int i5);

    CTExternalReference[] getExternalReferenceArray();

    List<CTExternalReference> getExternalReferenceList();

    CTExternalReference insertNewExternalReference(int i5);

    void removeExternalReference(int i5);

    void setExternalReferenceArray(int i5, CTExternalReference cTExternalReference);

    void setExternalReferenceArray(CTExternalReference[] cTExternalReferenceArr);

    int sizeOfExternalReferenceArray();
}
