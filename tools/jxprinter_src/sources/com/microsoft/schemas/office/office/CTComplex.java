package com.microsoft.schemas.office.office;

import com.microsoft.schemas.vml.STExt;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public interface CTComplex extends XmlObject {
    public static final DocumentFactory<CTComplex> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTComplex> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctcomplexd4a9type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    STExt.Enum getExt();

    boolean isSetExt();

    void setExt(STExt.Enum r6);

    void unsetExt();

    STExt xgetExt();

    void xsetExt(STExt sTExt);
}
