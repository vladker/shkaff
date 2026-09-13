package org.openxmlformats.schemas.drawingml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface CTGradientStopList extends XmlObject {
    public static final DocumentFactory<CTGradientStopList> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTGradientStopList> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctgradientstoplist7eabtype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTGradientStop addNewGs();

    CTGradientStop getGsArray(int i5);

    CTGradientStop[] getGsArray();

    List<CTGradientStop> getGsList();

    CTGradientStop insertNewGs(int i5);

    void removeGs(int i5);

    void setGsArray(int i5, CTGradientStop cTGradientStop);

    void setGsArray(CTGradientStop[] cTGradientStopArr);

    int sizeOfGsArray();
}
