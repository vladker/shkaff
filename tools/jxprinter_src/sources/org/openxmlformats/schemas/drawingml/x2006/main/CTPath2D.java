package org.openxmlformats.schemas.drawingml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface CTPath2D extends XmlObject {
    public static final DocumentFactory<CTPath2D> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTPath2D> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctpath2d73d2type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTPath2DArcTo addNewArcTo();

    CTPath2DClose addNewClose();

    CTPath2DCubicBezierTo addNewCubicBezTo();

    CTPath2DLineTo addNewLnTo();

    CTPath2DMoveTo addNewMoveTo();

    CTPath2DQuadBezierTo addNewQuadBezTo();

    CTPath2DArcTo getArcToArray(int i5);

    CTPath2DArcTo[] getArcToArray();

    List<CTPath2DArcTo> getArcToList();

    CTPath2DClose getCloseArray(int i5);

    CTPath2DClose[] getCloseArray();

    List<CTPath2DClose> getCloseList();

    CTPath2DCubicBezierTo getCubicBezToArray(int i5);

    CTPath2DCubicBezierTo[] getCubicBezToArray();

    List<CTPath2DCubicBezierTo> getCubicBezToList();

    boolean getExtrusionOk();

    STPathFillMode.Enum getFill();

    long getH();

    CTPath2DLineTo getLnToArray(int i5);

    CTPath2DLineTo[] getLnToArray();

    List<CTPath2DLineTo> getLnToList();

    CTPath2DMoveTo getMoveToArray(int i5);

    CTPath2DMoveTo[] getMoveToArray();

    List<CTPath2DMoveTo> getMoveToList();

    CTPath2DQuadBezierTo getQuadBezToArray(int i5);

    CTPath2DQuadBezierTo[] getQuadBezToArray();

    List<CTPath2DQuadBezierTo> getQuadBezToList();

    boolean getStroke();

    long getW();

    CTPath2DArcTo insertNewArcTo(int i5);

    CTPath2DClose insertNewClose(int i5);

    CTPath2DCubicBezierTo insertNewCubicBezTo(int i5);

    CTPath2DLineTo insertNewLnTo(int i5);

    CTPath2DMoveTo insertNewMoveTo(int i5);

    CTPath2DQuadBezierTo insertNewQuadBezTo(int i5);

    boolean isSetExtrusionOk();

    boolean isSetFill();

    boolean isSetH();

    boolean isSetStroke();

    boolean isSetW();

    void removeArcTo(int i5);

    void removeClose(int i5);

    void removeCubicBezTo(int i5);

    void removeLnTo(int i5);

    void removeMoveTo(int i5);

    void removeQuadBezTo(int i5);

    void setArcToArray(int i5, CTPath2DArcTo cTPath2DArcTo);

    void setArcToArray(CTPath2DArcTo[] cTPath2DArcToArr);

    void setCloseArray(int i5, CTPath2DClose cTPath2DClose);

    void setCloseArray(CTPath2DClose[] cTPath2DCloseArr);

    void setCubicBezToArray(int i5, CTPath2DCubicBezierTo cTPath2DCubicBezierTo);

    void setCubicBezToArray(CTPath2DCubicBezierTo[] cTPath2DCubicBezierToArr);

    void setExtrusionOk(boolean z6);

    void setFill(STPathFillMode.Enum r6);

    void setH(long j6);

    void setLnToArray(int i5, CTPath2DLineTo cTPath2DLineTo);

    void setLnToArray(CTPath2DLineTo[] cTPath2DLineToArr);

    void setMoveToArray(int i5, CTPath2DMoveTo cTPath2DMoveTo);

    void setMoveToArray(CTPath2DMoveTo[] cTPath2DMoveToArr);

    void setQuadBezToArray(int i5, CTPath2DQuadBezierTo cTPath2DQuadBezierTo);

    void setQuadBezToArray(CTPath2DQuadBezierTo[] cTPath2DQuadBezierToArr);

    void setStroke(boolean z6);

    void setW(long j6);

    int sizeOfArcToArray();

    int sizeOfCloseArray();

    int sizeOfCubicBezToArray();

    int sizeOfLnToArray();

    int sizeOfMoveToArray();

    int sizeOfQuadBezToArray();

    void unsetExtrusionOk();

    void unsetFill();

    void unsetH();

    void unsetStroke();

    void unsetW();

    XmlBoolean xgetExtrusionOk();

    STPathFillMode xgetFill();

    STPositiveCoordinate xgetH();

    XmlBoolean xgetStroke();

    STPositiveCoordinate xgetW();

    void xsetExtrusionOk(XmlBoolean xmlBoolean);

    void xsetFill(STPathFillMode sTPathFillMode);

    void xsetH(STPositiveCoordinate sTPositiveCoordinate);

    void xsetStroke(XmlBoolean xmlBoolean);

    void xsetW(STPositiveCoordinate sTPositiveCoordinate);
}
