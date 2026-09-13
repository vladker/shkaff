package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface CTFill extends XmlObject {
    public static final DocumentFactory<CTFill> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTFill> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctfill550ctype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTGradientFill addNewGradientFill();

    CTPatternFill addNewPatternFill();

    CTGradientFill getGradientFill();

    CTPatternFill getPatternFill();

    boolean isSetGradientFill();

    boolean isSetPatternFill();

    void setGradientFill(CTGradientFill cTGradientFill);

    void setPatternFill(CTPatternFill cTPatternFill);

    void unsetGradientFill();

    void unsetPatternFill();
}
