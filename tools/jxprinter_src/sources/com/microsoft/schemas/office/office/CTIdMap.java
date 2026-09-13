package com.microsoft.schemas.office.office;

import com.microsoft.schemas.vml.STExt;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public interface CTIdMap extends XmlObject {
    public static final DocumentFactory<CTIdMap> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTIdMap> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctidmap63fatype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    String getData();

    STExt.Enum getExt();

    boolean isSetData();

    boolean isSetExt();

    void setData(String str);

    void setExt(STExt.Enum r6);

    void unsetData();

    void unsetExt();

    XmlString xgetData();

    STExt xgetExt();

    void xsetData(XmlString xmlString);

    void xsetExt(STExt sTExt);
}
