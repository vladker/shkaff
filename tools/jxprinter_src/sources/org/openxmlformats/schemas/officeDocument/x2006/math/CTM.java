package org.openxmlformats.schemas.officeDocument.x2006.math;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface CTM extends XmlObject {
    public static final DocumentFactory<CTM> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTM> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctm3f8ftype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTMPr addNewMPr();

    CTMR addNewMr();

    CTMPr getMPr();

    CTMR getMrArray(int i5);

    CTMR[] getMrArray();

    List<CTMR> getMrList();

    CTMR insertNewMr(int i5);

    boolean isSetMPr();

    void removeMr(int i5);

    void setMPr(CTMPr cTMPr);

    void setMrArray(int i5, CTMR ctmr);

    void setMrArray(CTMR[] ctmrArr);

    int sizeOfMrArray();

    void unsetMPr();
}
