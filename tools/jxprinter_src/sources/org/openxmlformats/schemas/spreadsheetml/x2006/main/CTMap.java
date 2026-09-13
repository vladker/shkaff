package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface CTMap extends XmlObject {
    public static final DocumentFactory<CTMap> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTMap> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctmap023btype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTDataBinding addNewDataBinding();

    boolean getAppend();

    boolean getAutoFit();

    CTDataBinding getDataBinding();

    long getID();

    String getName();

    boolean getPreserveFormat();

    boolean getPreserveSortAFLayout();

    String getRootElement();

    String getSchemaID();

    boolean getShowImportExportValidationErrors();

    boolean isSetDataBinding();

    void setAppend(boolean z6);

    void setAutoFit(boolean z6);

    void setDataBinding(CTDataBinding cTDataBinding);

    void setID(long j6);

    void setName(String str);

    void setPreserveFormat(boolean z6);

    void setPreserveSortAFLayout(boolean z6);

    void setRootElement(String str);

    void setSchemaID(String str);

    void setShowImportExportValidationErrors(boolean z6);

    void unsetDataBinding();

    XmlBoolean xgetAppend();

    XmlBoolean xgetAutoFit();

    XmlUnsignedInt xgetID();

    XmlString xgetName();

    XmlBoolean xgetPreserveFormat();

    XmlBoolean xgetPreserveSortAFLayout();

    XmlString xgetRootElement();

    XmlString xgetSchemaID();

    XmlBoolean xgetShowImportExportValidationErrors();

    void xsetAppend(XmlBoolean xmlBoolean);

    void xsetAutoFit(XmlBoolean xmlBoolean);

    void xsetID(XmlUnsignedInt xmlUnsignedInt);

    void xsetName(XmlString xmlString);

    void xsetPreserveFormat(XmlBoolean xmlBoolean);

    void xsetPreserveSortAFLayout(XmlBoolean xmlBoolean);

    void xsetRootElement(XmlString xmlString);

    void xsetSchemaID(XmlString xmlString);

    void xsetShowImportExportValidationErrors(XmlBoolean xmlBoolean);
}
