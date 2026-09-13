package org.openxmlformats.schemas.officeDocument.x2006.math;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface CTSSub extends XmlObject {
    public static final DocumentFactory<CTSSub> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTSSub> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctssubfdc5type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTOMathArg addNewE();

    CTSSubPr addNewSSubPr();

    CTOMathArg addNewSub();

    CTOMathArg getE();

    CTSSubPr getSSubPr();

    CTOMathArg getSub();

    boolean isSetSSubPr();

    void setE(CTOMathArg cTOMathArg);

    void setSSubPr(CTSSubPr cTSSubPr);

    void setSub(CTOMathArg cTOMathArg);

    void unsetSSubPr();
}
