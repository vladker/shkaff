package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface CTDocDefaults extends XmlObject {
    public static final DocumentFactory<CTDocDefaults> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTDocDefaults> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctdocdefaults2ea8type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTPPrDefault addNewPPrDefault();

    CTRPrDefault addNewRPrDefault();

    CTPPrDefault getPPrDefault();

    CTRPrDefault getRPrDefault();

    boolean isSetPPrDefault();

    boolean isSetRPrDefault();

    void setPPrDefault(CTPPrDefault cTPPrDefault);

    void setRPrDefault(CTRPrDefault cTRPrDefault);

    void unsetPPrDefault();

    void unsetRPrDefault();
}
