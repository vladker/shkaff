package com.microsoft.schemas.office.office;

import com.microsoft.schemas.vml.STExt;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public interface CTShapeLayout extends XmlObject {
    public static final DocumentFactory<CTShapeLayout> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTShapeLayout> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctshapelayoutbda4type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTIdMap addNewIdmap();

    CTRegroupTable addNewRegrouptable();

    CTRules addNewRules();

    STExt.Enum getExt();

    CTIdMap getIdmap();

    CTRegroupTable getRegrouptable();

    CTRules getRules();

    boolean isSetExt();

    boolean isSetIdmap();

    boolean isSetRegrouptable();

    boolean isSetRules();

    void setExt(STExt.Enum r6);

    void setIdmap(CTIdMap cTIdMap);

    void setRegrouptable(CTRegroupTable cTRegroupTable);

    void setRules(CTRules cTRules);

    void unsetExt();

    void unsetIdmap();

    void unsetRegrouptable();

    void unsetRules();

    STExt xgetExt();

    void xsetExt(STExt sTExt);
}
