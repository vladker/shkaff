package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface CTSdtEndPr extends XmlObject {
    public static final DocumentFactory<CTSdtEndPr> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTSdtEndPr> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctsdtendprbc6etype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTRPr addNewRPr();

    CTRPr getRPrArray(int i5);

    CTRPr[] getRPrArray();

    List<CTRPr> getRPrList();

    CTRPr insertNewRPr(int i5);

    void removeRPr(int i5);

    void setRPrArray(int i5, CTRPr cTRPr);

    void setRPrArray(CTRPr[] cTRPrArr);

    int sizeOfRPrArray();
}
