package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface CTTableFormula extends STFormula {
    public static final DocumentFactory<CTTableFormula> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTTableFormula> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "cttableformulaf801type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    boolean getArray();

    boolean isSetArray();

    void setArray(boolean z6);

    void unsetArray();

    XmlBoolean xgetArray();

    void xsetArray(XmlBoolean xmlBoolean);
}
