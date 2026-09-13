package org.apache.poi.xslf.usermodel;

import A3.AbstractC0157z;
import java.awt.geom.AffineTransform;
import java.awt.geom.Path2D;
import java.awt.geom.PathIterator;
import java.awt.geom.Rectangle2D;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ooxml.util.POIXMLUnits;
import org.apache.poi.sl.draw.geom.CustomGeometry;
import org.apache.poi.sl.usermodel.FreeformShape;
import org.apache.poi.util.Units;
import org.apache.poi.xslf.draw.geom.XSLFCustomGeometry;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlObject;
import org.openxmlformats.schemas.drawingml.x2006.main.CTAdjPoint2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTCustomGeometry2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGeomRect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DClose;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DCubicBezierTo;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DLineTo;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DMoveTo;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DQuadBezierTo;
import org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTransform2D;
import org.openxmlformats.schemas.presentationml.x2006.main.CTShape;
import org.openxmlformats.schemas.presentationml.x2006.main.CTShapeNonVisual;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XSLFFreeformShape extends XSLFAutoShape implements FreeformShape<XSLFShape, XSLFTextParagraph> {
    private static final Logger LOG = LogManager.getLogger((Class<?>) XSLFFreeformShape.class);

    public XSLFFreeformShape(CTShape cTShape, XSLFSheet xSLFSheet) {
        super(cTShape, xSLFSheet);
    }

    private static CTAdjPoint2D[] addClosePath(CTPath2D cTPath2D) {
        cTPath2D.addNewClose();
        return new CTAdjPoint2D[0];
    }

    private static CTAdjPoint2D[] addCubicBezierTo(CTPath2D cTPath2D) {
        CTPath2DCubicBezierTo cTPath2DCubicBezierToAddNewCubicBezTo = cTPath2D.addNewCubicBezTo();
        return new CTAdjPoint2D[]{cTPath2DCubicBezierToAddNewCubicBezTo.addNewPt(), cTPath2DCubicBezierToAddNewCubicBezTo.addNewPt(), cTPath2DCubicBezierToAddNewCubicBezTo.addNewPt()};
    }

    private static CTAdjPoint2D[] addLineTo(CTPath2D cTPath2D) {
        return new CTAdjPoint2D[]{cTPath2D.addNewLnTo().addNewPt()};
    }

    private static CTAdjPoint2D[] addMoveTo(CTPath2D cTPath2D) {
        return new CTAdjPoint2D[]{cTPath2D.addNewMoveTo().addNewPt()};
    }

    private static CTAdjPoint2D[] addQuadBezierTo(CTPath2D cTPath2D) {
        CTPath2DQuadBezierTo cTPath2DQuadBezierToAddNewQuadBezTo = cTPath2D.addNewQuadBezTo();
        return new CTAdjPoint2D[]{cTPath2DQuadBezierToAddNewQuadBezTo.addNewPt(), cTPath2DQuadBezierToAddNewQuadBezTo.addNewPt()};
    }

    public static CTShape prototype(int i5) {
        CTShape cTShapeNewInstance = CTShape.Factory.newInstance();
        CTShapeNonVisual cTShapeNonVisualAddNewNvSpPr = cTShapeNewInstance.addNewNvSpPr();
        CTNonVisualDrawingProps cTNonVisualDrawingPropsAddNewCNvPr = cTShapeNonVisualAddNewNvSpPr.addNewCNvPr();
        cTNonVisualDrawingPropsAddNewCNvPr.setName("Freeform " + i5);
        cTNonVisualDrawingPropsAddNewCNvPr.setId((long) i5);
        cTShapeNonVisualAddNewNvSpPr.addNewCNvSpPr();
        cTShapeNonVisualAddNewNvSpPr.addNewNvPr();
        CTCustomGeometry2D cTCustomGeometry2DAddNewCustGeom = cTShapeNewInstance.addNewSpPr().addNewCustGeom();
        cTCustomGeometry2DAddNewCustGeom.addNewAvLst();
        cTCustomGeometry2DAddNewCustGeom.addNewGdLst();
        cTCustomGeometry2DAddNewCustGeom.addNewAhLst();
        cTCustomGeometry2DAddNewCustGeom.addNewCxnLst();
        CTGeomRect cTGeomRectAddNewRect = cTCustomGeometry2DAddNewCustGeom.addNewRect();
        cTGeomRectAddNewRect.setR("r");
        cTGeomRectAddNewRect.setB("b");
        cTGeomRectAddNewRect.setT("t");
        cTGeomRectAddNewRect.setL("l");
        cTCustomGeometry2DAddNewCustGeom.addNewPathLst();
        return cTShapeNewInstance;
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFSimpleShape, org.apache.poi.sl.usermodel.SimpleShape
    public CustomGeometry getGeometry() {
        XmlObject shapeProperties = getShapeProperties();
        if (shapeProperties instanceof CTShapeProperties) {
            return XSLFCustomGeometry.convertCustomGeometry(((CTShapeProperties) shapeProperties).getCustGeom());
        }
        return null;
    }

    @Override // org.apache.poi.sl.usermodel.FreeformShape
    public int setPath(Path2D path2D) {
        CTAdjPoint2D[] cTAdjPoint2DArrAddMoveTo;
        CTPath2D cTPath2DNewInstance = CTPath2D.Factory.newInstance();
        Rectangle2D bounds2D = path2D.getBounds2D();
        int emu = Units.toEMU(bounds2D.getX());
        int emu2 = Units.toEMU(bounds2D.getY());
        PathIterator pathIterator = path2D.getPathIterator(new AffineTransform());
        cTPath2DNewInstance.setH(Units.toEMU(bounds2D.getHeight()));
        cTPath2DNewInstance.setW(Units.toEMU(bounds2D.getWidth()));
        double[] dArr = new double[6];
        int iMax = 0;
        while (!pathIterator.isDone()) {
            int iCurrentSegment = pathIterator.currentSegment(dArr);
            if (iCurrentSegment == 0) {
                cTAdjPoint2DArrAddMoveTo = addMoveTo(cTPath2DNewInstance);
            } else if (iCurrentSegment == 1) {
                cTAdjPoint2DArrAddMoveTo = addLineTo(cTPath2DNewInstance);
            } else if (iCurrentSegment == 2) {
                cTAdjPoint2DArrAddMoveTo = addQuadBezierTo(cTPath2DNewInstance);
            } else if (iCurrentSegment == 3) {
                cTAdjPoint2DArrAddMoveTo = addCubicBezierTo(cTPath2DNewInstance);
            } else {
                if (iCurrentSegment != 4) {
                    throw new IllegalStateException(AbstractC0157z.k(iCurrentSegment, "Unrecognized path segment type: "));
                }
                cTAdjPoint2DArrAddMoveTo = addClosePath(cTPath2DNewInstance);
            }
            int i5 = 0;
            for (CTAdjPoint2D cTAdjPoint2D : cTAdjPoint2DArrAddMoveTo) {
                int i6 = i5 + 1;
                cTAdjPoint2D.setX(Integer.valueOf(Units.toEMU(dArr[i5]) - emu));
                i5 += 2;
                cTAdjPoint2D.setY(Integer.valueOf(Units.toEMU(dArr[i6]) - emu2));
            }
            iMax += Math.max(cTAdjPoint2DArrAddMoveTo.length, 1);
            pathIterator.next();
        }
        XmlObject shapeProperties = getShapeProperties();
        if (!(shapeProperties instanceof CTShapeProperties)) {
            return -1;
        }
        ((CTShapeProperties) shapeProperties).getCustGeom().getPathLst().setPathArray(new CTPath2D[]{cTPath2DNewInstance});
        setAnchor(bounds2D);
        return iMax;
    }

    private static void addLineTo(Path2D path2D, CTPath2DLineTo cTPath2DLineTo) {
        CTAdjPoint2D pt = cTPath2DLineTo.getPt();
        path2D.lineTo(((Long) pt.getX()).longValue(), ((Long) pt.getY()).longValue());
    }

    private static void addMoveTo(Path2D path2D, CTPath2DMoveTo cTPath2DMoveTo) {
        CTAdjPoint2D pt = cTPath2DMoveTo.getPt();
        path2D.moveTo(((Long) pt.getX()).longValue(), ((Long) pt.getY()).longValue());
    }

    @Override // org.apache.poi.sl.usermodel.FreeformShape
    /* JADX INFO: renamed from: getPath, reason: merged with bridge method [inline-methods] */
    public Path2D.Double mo1078getPath() {
        Path2D.Double r6 = new Path2D.Double();
        XmlObject shapeProperties = getShapeProperties();
        if (!(shapeProperties instanceof CTShapeProperties)) {
            return null;
        }
        for (CTPath2D cTPath2D : ((CTShapeProperties) shapeProperties).getCustGeom().getPathLst().getPathArray()) {
            XmlCursor xmlCursorNewCursor = cTPath2D.newCursor();
            try {
                if (xmlCursorNewCursor.toFirstChild()) {
                    do {
                        XmlObject object = xmlCursorNewCursor.getObject();
                        if (object instanceof CTPath2DMoveTo) {
                            addMoveTo(r6, (CTPath2DMoveTo) object);
                        } else if (object instanceof CTPath2DLineTo) {
                            addLineTo(r6, (CTPath2DLineTo) object);
                        } else if (object instanceof CTPath2DQuadBezierTo) {
                            addQuadBezierTo(r6, (CTPath2DQuadBezierTo) object);
                        } else if (object instanceof CTPath2DCubicBezierTo) {
                            addCubicBezierTo(r6, (CTPath2DCubicBezierTo) object);
                        } else if (object instanceof CTPath2DClose) {
                            addClosePath((Path2D) r6);
                        } else {
                            LOG.atWarn().log("can't handle path of type {}", shapeProperties.getClass());
                        }
                    } while (xmlCursorNewCursor.toNextSibling());
                }
                xmlCursorNewCursor.close();
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    if (xmlCursorNewCursor == null) {
                        throw th2;
                    }
                    try {
                        xmlCursorNewCursor.close();
                        throw th2;
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                        throw th2;
                    }
                }
            }
        }
        AffineTransform affineTransform = new AffineTransform();
        CTTransform2D xfrm = getXfrm(false);
        Rectangle2D.Double r7 = new Rectangle2D.Double(POIXMLUnits.parseLength(xfrm.getOff().xgetX()), POIXMLUnits.parseLength(xfrm.getOff().xgetY()), xfrm.getExt().getCx(), xfrm.getExt().getCy());
        Rectangle2D anchor = getAnchor();
        affineTransform.translate(anchor.getX() + anchor.getCenterX(), anchor.getY() + anchor.getCenterY());
        affineTransform.scale(7.874015748031496E-5d, 7.874015748031496E-5d);
        affineTransform.translate(-r7.getCenterX(), -r7.getCenterY());
        return new Path2D.Double(affineTransform.createTransformedShape(r6));
    }

    private static void addClosePath(Path2D path2D) {
        path2D.closePath();
    }

    private static void addCubicBezierTo(Path2D path2D, CTPath2DCubicBezierTo cTPath2DCubicBezierTo) {
        CTAdjPoint2D ptArray = cTPath2DCubicBezierTo.getPtArray(0);
        CTAdjPoint2D ptArray2 = cTPath2DCubicBezierTo.getPtArray(1);
        CTAdjPoint2D ptArray3 = cTPath2DCubicBezierTo.getPtArray(2);
        path2D.curveTo(((Long) ptArray.getX()).longValue(), ((Long) ptArray.getY()).longValue(), ((Long) ptArray2.getX()).longValue(), ((Long) ptArray2.getY()).longValue(), ((Long) ptArray3.getX()).longValue(), ((Long) ptArray3.getY()).longValue());
    }

    private static void addQuadBezierTo(Path2D path2D, CTPath2DQuadBezierTo cTPath2DQuadBezierTo) {
        CTAdjPoint2D ptArray = cTPath2DQuadBezierTo.getPtArray(0);
        CTAdjPoint2D ptArray2 = cTPath2DQuadBezierTo.getPtArray(1);
        path2D.quadTo(((Long) ptArray.getX()).longValue(), ((Long) ptArray.getY()).longValue(), ((Long) ptArray2.getX()).longValue(), ((Long) ptArray2.getY()).longValue());
    }
}
