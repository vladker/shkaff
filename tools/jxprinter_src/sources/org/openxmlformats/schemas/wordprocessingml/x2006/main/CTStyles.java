package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface CTStyles extends XmlObject {
    public static final DocumentFactory<CTStyles> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTStyles> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctstyles8506type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTDocDefaults addNewDocDefaults();

    CTLatentStyles addNewLatentStyles();

    CTStyle addNewStyle();

    CTDocDefaults getDocDefaults();

    CTLatentStyles getLatentStyles();

    CTStyle getStyleArray(int i5);

    CTStyle[] getStyleArray();

    List<CTStyle> getStyleList();

    CTStyle insertNewStyle(int i5);

    boolean isSetDocDefaults();

    boolean isSetLatentStyles();

    void removeStyle(int i5);

    void setDocDefaults(CTDocDefaults cTDocDefaults);

    void setLatentStyles(CTLatentStyles cTLatentStyles);

    void setStyleArray(int i5, CTStyle cTStyle);

    void setStyleArray(CTStyle[] cTStyleArr);

    int sizeOfStyleArray();

    void unsetDocDefaults();

    void unsetLatentStyles();
}
