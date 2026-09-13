package org.openxmlformats.schemas.drawingml.x2006.chart;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.STXstring;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface CTSerTx extends XmlObject {
    public static final DocumentFactory<CTSerTx> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTSerTx> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctsertxd722type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTStrRef addNewStrRef();

    CTStrRef getStrRef();

    String getV();

    boolean isSetStrRef();

    boolean isSetV();

    void setStrRef(CTStrRef cTStrRef);

    void setV(String str);

    void unsetStrRef();

    void unsetV();

    STXstring xgetV();

    void xsetV(STXstring sTXstring);
}
