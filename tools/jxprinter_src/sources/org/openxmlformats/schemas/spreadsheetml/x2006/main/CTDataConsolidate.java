package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface CTDataConsolidate extends XmlObject {
    public static final DocumentFactory<CTDataConsolidate> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTDataConsolidate> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctdataconsolidate941etype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTDataRefs addNewDataRefs();

    CTDataRefs getDataRefs();

    STDataConsolidateFunction.Enum getFunction();

    boolean getLeftLabels();

    boolean getLink();

    boolean getStartLabels();

    boolean getTopLabels();

    boolean isSetDataRefs();

    boolean isSetFunction();

    boolean isSetLeftLabels();

    boolean isSetLink();

    boolean isSetStartLabels();

    boolean isSetTopLabels();

    void setDataRefs(CTDataRefs cTDataRefs);

    void setFunction(STDataConsolidateFunction.Enum r6);

    void setLeftLabels(boolean z6);

    void setLink(boolean z6);

    void setStartLabels(boolean z6);

    void setTopLabels(boolean z6);

    void unsetDataRefs();

    void unsetFunction();

    void unsetLeftLabels();

    void unsetLink();

    void unsetStartLabels();

    void unsetTopLabels();

    STDataConsolidateFunction xgetFunction();

    XmlBoolean xgetLeftLabels();

    XmlBoolean xgetLink();

    XmlBoolean xgetStartLabels();

    XmlBoolean xgetTopLabels();

    void xsetFunction(STDataConsolidateFunction sTDataConsolidateFunction);

    void xsetLeftLabels(XmlBoolean xmlBoolean);

    void xsetLink(XmlBoolean xmlBoolean);

    void xsetStartLabels(XmlBoolean xmlBoolean);

    void xsetTopLabels(XmlBoolean xmlBoolean);
}
