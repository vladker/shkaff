package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface CTParaRPrChange extends CTTrackChange {
    public static final DocumentFactory<CTParaRPrChange> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTParaRPrChange> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctpararprchange986etype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTParaRPrOriginal addNewRPr();

    CTParaRPrOriginal getRPr();

    void setRPr(CTParaRPrOriginal cTParaRPrOriginal);
}
