package org.openxmlformats.schemas.officeDocument.x2006.math;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface CTMR extends XmlObject {
    public static final DocumentFactory<CTMR> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTMR> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctmr7ccdtype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTOMathArg addNewE();

    CTOMathArg getEArray(int i5);

    CTOMathArg[] getEArray();

    List<CTOMathArg> getEList();

    CTOMathArg insertNewE(int i5);

    void removeE(int i5);

    void setEArray(int i5, CTOMathArg cTOMathArg);

    void setEArray(CTOMathArg[] cTOMathArgArr);

    int sizeOfEArray();
}
