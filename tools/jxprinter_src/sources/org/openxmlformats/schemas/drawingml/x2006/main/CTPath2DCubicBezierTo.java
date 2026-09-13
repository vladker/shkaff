package org.openxmlformats.schemas.drawingml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface CTPath2DCubicBezierTo extends XmlObject {
    public static final DocumentFactory<CTPath2DCubicBezierTo> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTPath2DCubicBezierTo> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctpath2dcubicbezierto5a1etype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTAdjPoint2D addNewPt();

    CTAdjPoint2D getPtArray(int i5);

    CTAdjPoint2D[] getPtArray();

    List<CTAdjPoint2D> getPtList();

    CTAdjPoint2D insertNewPt(int i5);

    void removePt(int i5);

    void setPtArray(int i5, CTAdjPoint2D cTAdjPoint2D);

    void setPtArray(CTAdjPoint2D[] cTAdjPoint2DArr);

    int sizeOfPtArray();
}
