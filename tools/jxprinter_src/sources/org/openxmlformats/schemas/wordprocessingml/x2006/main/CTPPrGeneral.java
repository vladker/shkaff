package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface CTPPrGeneral extends CTPPrBase {
    public static final DocumentFactory<CTPPrGeneral> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTPPrGeneral> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctpprgenerald6f2type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTPPrChange addNewPPrChange();

    CTPPrChange getPPrChange();

    boolean isSetPPrChange();

    void setPPrChange(CTPPrChange cTPPrChange);

    void unsetPPrChange();
}
