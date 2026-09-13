package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface CTTblPrEx extends CTTblPrExBase {
    public static final DocumentFactory<CTTblPrEx> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTTblPrEx> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "cttblprex863ftype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTTblPrExChange addNewTblPrExChange();

    CTTblPrExChange getTblPrExChange();

    boolean isSetTblPrExChange();

    void setTblPrExChange(CTTblPrExChange cTTblPrExChange);

    void unsetTblPrExChange();
}
