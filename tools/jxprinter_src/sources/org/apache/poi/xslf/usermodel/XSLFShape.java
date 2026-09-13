package org.apache.poi.xslf.usermodel;

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamReader;
import org.apache.poi.ooxml.util.XPathHelper;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.sl.draw.DrawFactory;
import org.apache.poi.sl.draw.DrawPaint;
import org.apache.poi.sl.usermodel.PaintStyle;
import org.apache.poi.sl.usermodel.PlaceableShape;
import org.apache.poi.sl.usermodel.Placeholder;
import org.apache.poi.sl.usermodel.Shape;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.util.Internal;
import org.apache.poi.xslf.model.PropertyFetcher;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlTokenSource;
import org.openxmlformats.schemas.drawingml.x2006.main.CTBlipFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGradientFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGroupShapeProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps;
import org.openxmlformats.schemas.drawingml.x2006.main.CTSchemeColor;
import org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTShapeStyle;
import org.openxmlformats.schemas.drawingml.x2006.main.CTSolidColorFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTStyleMatrix;
import org.openxmlformats.schemas.drawingml.x2006.main.CTStyleMatrixReference;
import org.openxmlformats.schemas.drawingml.x2006.main.STSchemeColorVal;
import org.openxmlformats.schemas.presentationml.x2006.main.CTBackgroundProperties;
import org.openxmlformats.schemas.presentationml.x2006.main.CTPicture;
import org.openxmlformats.schemas.presentationml.x2006.main.CTPlaceholder;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class XSLFShape implements Shape<XSLFShape, XSLFTextParagraph> {
    static final String DML_NS = "http://schemas.openxmlformats.org/drawingml/2006/main";
    static final String PML_NS = "http://schemas.openxmlformats.org/presentationml/2006/main";
    private CTNonVisualDrawingProps _nvPr;
    private XSLFShapeContainer _parent;
    private final XmlObject _shape;
    private final XSLFSheet _sheet;
    private CTShapeStyle _spStyle;
    private static final QName[] NV_CONTAINER = {new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "nvSpPr"), new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "nvCxnSpPr"), new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "nvGrpSpPr"), new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "nvPicPr"), new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "nvGraphicFramePr")};
    private static final QName[] CNV_PROPS = {new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "cNvPr")};

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    @Internal
    public interface ReparseFactory<T extends XmlObject> {
        T parse(XMLStreamReader xMLStreamReader);
    }

    public XSLFShape(XmlObject xmlObject, XSLFSheet xSLFSheet) {
        this._shape = xmlObject;
        this._sheet = xSLFSheet;
    }

    private static int getPlaceholderType(CTPlaceholder cTPlaceholder) {
        if (!cTPlaceholder.isSetType()) {
            return 2;
        }
        int iIntValue = cTPlaceholder.getType().intValue();
        if (iIntValue == 1 || iIntValue == 3) {
            return 1;
        }
        if (iIntValue == 5 || iIntValue == 6 || iIntValue == 7) {
            return cTPlaceholder.getType().intValue();
        }
        return 2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Internal
    public void copy(XSLFShape xSLFShape) {
        if (!getClass().isInstance(xSLFShape)) {
            throw new IllegalArgumentException("Can't copy " + xSLFShape.getClass().getSimpleName() + " into " + getClass().getSimpleName());
        }
        if (this instanceof PlaceableShape) {
            PlaceableShape placeableShape = (PlaceableShape) this;
            Rectangle2D anchor = xSLFShape.getAnchor();
            if (anchor != null) {
                placeableShape.setAnchor(anchor);
            }
        }
    }

    @Override // org.apache.poi.sl.usermodel.Shape
    public void draw(Graphics2D graphics2D, Rectangle2D rectangle2D) {
        DrawFactory.getInstance(graphics2D).drawShape(graphics2D, this, rectangle2D);
    }

    @Internal
    public boolean fetchShapeProperty(PropertyFetcher<?> propertyFetcher) {
        XSLFSimpleShape placeholderByType;
        if (propertyFetcher.fetch(this)) {
            return true;
        }
        CTPlaceholder cTPlaceholder = getPlaceholderDetails().getCTPlaceholder(false);
        if (cTPlaceholder != null) {
            Sheet masterSheet = getSheet().getMasterSheet();
            if (masterSheet instanceof XSLFSlideLayout) {
                XSLFSlideLayout xSLFSlideLayout = (XSLFSlideLayout) masterSheet;
                XSLFSimpleShape placeholder = xSLFSlideLayout.getPlaceholder(cTPlaceholder);
                if (placeholder != null && propertyFetcher.fetch(placeholder)) {
                    return true;
                }
                masterSheet = xSLFSlideLayout.getMasterSheet();
            }
            if ((masterSheet instanceof XSLFSlideMaster) && (placeholderByType = ((XSLFSlideMaster) masterSheet).getPlaceholderByType(getPlaceholderType(cTPlaceholder))) != null && propertyFetcher.fetch(placeholderByType)) {
                return true;
            }
        }
        return false;
    }

    public CTBackgroundProperties getBgPr() {
        return (CTBackgroundProperties) getChild(CTBackgroundProperties.class, "http://schemas.openxmlformats.org/presentationml/2006/main", "bgPr");
    }

    public CTStyleMatrixReference getBgRef() {
        return (CTStyleMatrixReference) getChild(CTStyleMatrixReference.class, "http://schemas.openxmlformats.org/presentationml/2006/main", "bgRef");
    }

    public CTNonVisualDrawingProps getCNvPr() {
        try {
            if (this._nvPr == null) {
                this._nvPr = (CTNonVisualDrawingProps) XPathHelper.selectProperty(getXmlObject(), CTNonVisualDrawingProps.class, null, NV_CONTAINER, CNV_PROPS);
            }
            return this._nvPr;
        } catch (XmlException unused) {
            return null;
        }
    }

    public <T extends XmlObject> T getChild(Class<T> cls, String str, String str2) {
        XmlCursor xmlCursorNewCursor = getXmlObject().newCursor();
        try {
            T t6 = xmlCursorNewCursor.toChild(str, str2) ? (T) xmlCursorNewCursor.getObject() : null;
            if (xmlCursorNewCursor.toChild("http://schemas.openxmlformats.org/drawingml/2006/main", str2)) {
                t6 = (T) xmlCursorNewCursor.getObject();
            }
            xmlCursorNewCursor.close();
            return t6;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (xmlCursorNewCursor != null) {
                    try {
                        xmlCursorNewCursor.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    public PaintStyle getFillPaint() {
        final XSLFTheme theme = getSheet().getTheme();
        final boolean z6 = getPlaceholder() != null;
        PropertyFetcher<PaintStyle> propertyFetcher = new PropertyFetcher<PaintStyle>() { // from class: org.apache.poi.xslf.usermodel.XSLFShape.1
            @Override // org.apache.poi.xslf.model.PropertyFetcher
            public boolean fetch(XSLFShape xSLFShape) {
                PackagePart packagePart = xSLFShape.getSheet().getPackagePart();
                if (xSLFShape instanceof XSLFPictureShape) {
                    CTPicture cTPicture = (CTPicture) xSLFShape.getXmlObject();
                    if (cTPicture.getBlipFill() != null) {
                        setValue(XSLFShape.this.selectPaint(cTPicture.getBlipFill(), packagePart, (CTSchemeColor) null, theme));
                        return true;
                    }
                }
                XSLFPropertiesDelegate.XSLFFillProperties fillDelegate = XSLFPropertiesDelegate.getFillDelegate(xSLFShape.getShapeProperties());
                if (fillDelegate == null) {
                    return false;
                }
                if (fillDelegate.isSetNoFill()) {
                    setValue(null);
                    return true;
                }
                PaintStyle paintStyleSelectPaint = XSLFShape.this.selectPaint(fillDelegate, null, packagePart, theme, z6);
                if (paintStyleSelectPaint != null) {
                    setValue(paintStyleSelectPaint);
                    return true;
                }
                CTShapeStyle spStyle = xSLFShape.getSpStyle();
                if (spStyle != null) {
                    paintStyleSelectPaint = XSLFShape.this.selectPaint(XSLFPropertiesDelegate.getFillDelegate(spStyle.getFillRef()), null, packagePart, theme, z6);
                }
                if (paintStyleSelectPaint == null) {
                    return false;
                }
                setValue(paintStyleSelectPaint);
                return true;
            }
        };
        fetchShapeProperty(propertyFetcher);
        return propertyFetcher.getValue();
    }

    public CTGroupShapeProperties getGrpSpPr() {
        return (CTGroupShapeProperties) getChild(CTGroupShapeProperties.class, "http://schemas.openxmlformats.org/presentationml/2006/main", "grpSpPr");
    }

    public Placeholder getPlaceholder() {
        return getPlaceholderDetails().getPlaceholder();
    }

    public XSLFPlaceholderDetails getPlaceholderDetails() {
        return new XSLFPlaceholderDetails(this);
    }

    @Override // org.apache.poi.sl.usermodel.Shape
    public int getShapeId() {
        CTNonVisualDrawingProps cNvPr = getCNvPr();
        if (cNvPr != null) {
            return Math.toIntExact(cNvPr.getId());
        }
        throw new IllegalStateException("no underlying shape exists");
    }

    @Override // org.apache.poi.sl.usermodel.Shape
    public String getShapeName() {
        CTNonVisualDrawingProps cNvPr = getCNvPr();
        if (cNvPr == null) {
            return null;
        }
        return cNvPr.getName();
    }

    public XmlObject getShapeProperties() {
        return getChild(CTShapeProperties.class, "http://schemas.openxmlformats.org/presentationml/2006/main", "spPr");
    }

    public CTShapeStyle getSpStyle() {
        if (this._spStyle == null) {
            this._spStyle = (CTShapeStyle) getChild(CTShapeStyle.class, "http://schemas.openxmlformats.org/presentationml/2006/main", "style");
        }
        return this._spStyle;
    }

    public final XmlObject getXmlObject() {
        return this._shape;
    }

    public boolean isPlaceholder() {
        return getPlaceholderDetails().getCTPlaceholder(false) != null;
    }

    public PaintStyle selectPaint(XSLFPropertiesDelegate.XSLFFillProperties xSLFFillProperties, CTSchemeColor cTSchemeColor, PackagePart packagePart, XSLFTheme xSLFTheme, boolean z6) {
        if (xSLFFillProperties != null && !xSLFFillProperties.isSetNoFill()) {
            if (xSLFFillProperties.isSetSolidFill()) {
                return selectPaint(xSLFFillProperties.getSolidFill(), cTSchemeColor, xSLFTheme);
            }
            if (xSLFFillProperties.isSetBlipFill()) {
                return selectPaint(xSLFFillProperties.getBlipFill(), packagePart, cTSchemeColor, xSLFTheme);
            }
            if (xSLFFillProperties.isSetGradFill()) {
                return selectPaint(xSLFFillProperties.getGradFill(), cTSchemeColor, xSLFTheme);
            }
            if (xSLFFillProperties.isSetMatrixStyle()) {
                return selectPaint(xSLFFillProperties.getMatrixStyle(), xSLFTheme, xSLFFillProperties.isLineStyle(), z6);
            }
            if (cTSchemeColor != null) {
                return selectPaint(cTSchemeColor, xSLFTheme);
            }
        }
        return null;
    }

    public <T extends XmlObject> T selectProperty(Class<T> cls, String str) {
        XmlObject[] xmlObjectArrSelectPath = getXmlObject().selectPath(str);
        if (xmlObjectArrSelectPath.length != 0 && cls.isInstance(xmlObjectArrSelectPath[0])) {
            return (T) xmlObjectArrSelectPath[0];
        }
        return null;
    }

    public void setParent(XSLFShapeContainer xSLFShapeContainer) {
        this._parent = xSLFShapeContainer;
    }

    public void setPlaceholder(Placeholder placeholder) {
        getPlaceholderDetails().setPlaceholder(placeholder);
    }

    @Override // org.apache.poi.sl.usermodel.Shape
    public XSLFShapeContainer getParent() {
        return this._parent;
    }

    @Override // org.apache.poi.sl.usermodel.Shape
    public XSLFSheet getSheet() {
        return this._sheet;
    }

    public PaintStyle selectPaint(CTSchemeColor cTSchemeColor, XSLFTheme xSLFTheme) {
        return DrawPaint.createSolidPaint(new XSLFColor(null, xSLFTheme, cTSchemeColor, this._sheet).getColorStyle());
    }

    public PaintStyle selectPaint(CTSolidColorFillProperties cTSolidColorFillProperties, CTSchemeColor cTSchemeColor, XSLFTheme xSLFTheme) {
        CTSchemeColor schemeClr = cTSolidColorFillProperties.getSchemeClr();
        if ((schemeClr == null || schemeClr.getVal() == null || STSchemeColorVal.PH_CLR.equals(schemeClr.getVal())) ? false : true) {
            cTSchemeColor = schemeClr;
        }
        return DrawPaint.createSolidPaint(new XSLFColor(cTSolidColorFillProperties, xSLFTheme, cTSchemeColor, this._sheet).getColorStyle());
    }

    public PaintStyle selectPaint(CTBlipFillProperties cTBlipFillProperties, PackagePart packagePart, CTSchemeColor cTSchemeColor, XSLFTheme xSLFTheme) {
        return new XSLFTexturePaint(this, cTBlipFillProperties, packagePart, cTSchemeColor, xSLFTheme, this._sheet);
    }

    public PaintStyle selectPaint(CTGradientFillProperties cTGradientFillProperties, CTSchemeColor cTSchemeColor, XSLFTheme xSLFTheme) {
        return new XSLFGradientPaint(cTGradientFillProperties, cTSchemeColor, xSLFTheme, this._sheet);
    }

    public PaintStyle selectPaint(CTStyleMatrixReference cTStyleMatrixReference, XSLFTheme xSLFTheme, boolean z6, boolean z7) {
        long j6;
        XmlTokenSource bgFillStyleLst;
        Throwable th;
        XSLFPropertiesDelegate.XSLFFillProperties fillDelegate = null;
        if (cTStyleMatrixReference == null) {
            return null;
        }
        long idx = cTStyleMatrixReference.getIdx();
        CTStyleMatrix fmtScheme = xSLFTheme.getXmlObject().getThemeElements().getFmtScheme();
        if (idx >= 1 && idx <= 999) {
            j6 = idx - 1;
            bgFillStyleLst = z6 ? fmtScheme.getLnStyleLst() : fmtScheme.getFillStyleLst();
        } else {
            if (idx < 1001) {
                return null;
            }
            j6 = idx - 1001;
            bgFillStyleLst = fmtScheme.getBgFillStyleLst();
        }
        XmlCursor xmlCursorNewCursor = bgFillStyleLst.newCursor();
        try {
            if (xmlCursorNewCursor.toChild(Math.toIntExact(j6))) {
                try {
                    fillDelegate = XSLFPropertiesDelegate.getFillDelegate(xmlCursorNewCursor.getObject());
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        throw th;
                    } catch (Throwable th3) {
                        if (xmlCursorNewCursor == null) {
                            throw th3;
                        }
                        try {
                            xmlCursorNewCursor.close();
                            throw th3;
                        } catch (Throwable th4) {
                            th.addSuppressed(th4);
                            throw th3;
                        }
                    }
                }
            }
            XSLFPropertiesDelegate.XSLFFillProperties xSLFFillProperties = fillDelegate;
            xmlCursorNewCursor.close();
            CTSchemeColor schemeClr = cTStyleMatrixReference.getSchemeClr();
            PaintStyle paintStyleSelectPaint = selectPaint(xSLFFillProperties, schemeClr, xSLFTheme.getPackagePart(), xSLFTheme, z7);
            return (paintStyleSelectPaint != null || z7) ? paintStyleSelectPaint : DrawPaint.createSolidPaint(new XSLFColor(cTStyleMatrixReference, xSLFTheme, schemeClr, this._sheet).getColorStyle());
        } catch (Throwable th5) {
            th = th5;
        }
    }
}
