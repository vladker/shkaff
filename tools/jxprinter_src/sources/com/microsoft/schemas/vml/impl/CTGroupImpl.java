package com.microsoft.schemas.vml.impl;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.microsoft.schemas.office.excel.CTClientData;
import com.microsoft.schemas.office.office.CTCallout;
import com.microsoft.schemas.office.office.CTClipPath;
import com.microsoft.schemas.office.office.CTDiagram;
import com.microsoft.schemas.office.office.CTExtrusion;
import com.microsoft.schemas.office.office.CTLock;
import com.microsoft.schemas.office.office.CTSignatureLine;
import com.microsoft.schemas.office.office.CTSkew;
import com.microsoft.schemas.office.office.STDiagramLayout;
import com.microsoft.schemas.office.office.STHrAlign;
import com.microsoft.schemas.office.office.STInsetMode;
import com.microsoft.schemas.office.powerpoint.CTRel;
import com.microsoft.schemas.office.word.CTAnchorLock;
import com.microsoft.schemas.office.word.CTBorder;
import com.microsoft.schemas.office.word.CTWrap;
import com.microsoft.schemas.vml.CTArc;
import com.microsoft.schemas.vml.CTCurve;
import com.microsoft.schemas.vml.CTFill;
import com.microsoft.schemas.vml.CTFormulas;
import com.microsoft.schemas.vml.CTGroup;
import com.microsoft.schemas.vml.CTHandles;
import com.microsoft.schemas.vml.CTImage;
import com.microsoft.schemas.vml.CTImageData;
import com.microsoft.schemas.vml.CTLine;
import com.microsoft.schemas.vml.CTOval;
import com.microsoft.schemas.vml.CTPath;
import com.microsoft.schemas.vml.CTPolyLine;
import com.microsoft.schemas.vml.CTRect;
import com.microsoft.schemas.vml.CTRoundRect;
import com.microsoft.schemas.vml.CTShadow;
import com.microsoft.schemas.vml.CTShape;
import com.microsoft.schemas.vml.CTShapetype;
import com.microsoft.schemas.vml.CTStroke;
import com.microsoft.schemas.vml.CTTextPath;
import com.microsoft.schemas.vml.CTTextbox;
import com.microsoft.schemas.vml.STEditAs;
import io.flutter.plugins.firebase.crashlytics.Constants;
import java.math.BigInteger;
import java.util.List;
import java.util.function.BiConsumer;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlFloat;
import org.apache.xmlbeans.XmlInteger;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.values.JavaListXmlObject;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.STColorType;
import org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.STTrueFalse;
import p111t2.C1796b;
import p111t2.C1798c;
import p111t2.C1800d;
import p111t2.C1802e;
import p111t2.C1814k;
import p111t2.C1829s;
import p111t2.C1833u;
import p111t2.C1835v;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class CTGroupImpl extends XmlComplexContentImpl implements CTGroup {
    private static final QName[] PROPERTY_QNAME = {new QName("urn:schemas-microsoft-com:vml", "path"), new QName("urn:schemas-microsoft-com:vml", "formulas"), new QName("urn:schemas-microsoft-com:vml", "handles"), new QName("urn:schemas-microsoft-com:vml", "fill"), new QName("urn:schemas-microsoft-com:vml", "stroke"), new QName("urn:schemas-microsoft-com:vml", "shadow"), new QName("urn:schemas-microsoft-com:vml", "textbox"), new QName("urn:schemas-microsoft-com:vml", "textpath"), new QName("urn:schemas-microsoft-com:vml", "imagedata"), new QName("urn:schemas-microsoft-com:office:office", "skew"), new QName("urn:schemas-microsoft-com:office:office", "extrusion"), new QName("urn:schemas-microsoft-com:office:office", "callout"), new QName("urn:schemas-microsoft-com:office:office", "lock"), new QName("urn:schemas-microsoft-com:office:office", "clippath"), new QName("urn:schemas-microsoft-com:office:office", "signatureline"), new QName("urn:schemas-microsoft-com:office:word", "wrap"), new QName("urn:schemas-microsoft-com:office:word", "anchorlock"), new QName("urn:schemas-microsoft-com:office:word", "bordertop"), new QName("urn:schemas-microsoft-com:office:word", "borderbottom"), new QName("urn:schemas-microsoft-com:office:word", "borderleft"), new QName("urn:schemas-microsoft-com:office:word", "borderright"), new QName("urn:schemas-microsoft-com:office:excel", "ClientData"), new QName("urn:schemas-microsoft-com:office:powerpoint", "textdata"), new QName("urn:schemas-microsoft-com:vml", "group"), new QName("urn:schemas-microsoft-com:vml", "shape"), new QName("urn:schemas-microsoft-com:vml", "shapetype"), new QName("urn:schemas-microsoft-com:vml", "arc"), new QName("urn:schemas-microsoft-com:vml", "curve"), new QName("urn:schemas-microsoft-com:vml", "image"), new QName("urn:schemas-microsoft-com:vml", Constants.LINE), new QName("urn:schemas-microsoft-com:vml", "oval"), new QName("urn:schemas-microsoft-com:vml", "polyline"), new QName("urn:schemas-microsoft-com:vml", "rect"), new QName("urn:schemas-microsoft-com:vml", "roundrect"), new QName("urn:schemas-microsoft-com:office:office", "diagram"), new QName("", "id"), new QName("", "style"), new QName("", "href"), new QName("", TypedValues.AttributesType.S_TARGET), new QName("", Constants.CLASS), new QName("", "title"), new QName("", "alt"), new QName("", "coordsize"), new QName("", "coordorigin"), new QName("", "wrapcoords"), new QName("", "print"), new QName("urn:schemas-microsoft-com:office:office", "spid"), new QName("urn:schemas-microsoft-com:office:office", "oned"), new QName("urn:schemas-microsoft-com:office:office", "regroupid"), new QName("urn:schemas-microsoft-com:office:office", "doubleclicknotify"), new QName("urn:schemas-microsoft-com:office:office", "button"), new QName("urn:schemas-microsoft-com:office:office", "userhidden"), new QName("urn:schemas-microsoft-com:office:office", "bullet"), new QName("urn:schemas-microsoft-com:office:office", "hr"), new QName("urn:schemas-microsoft-com:office:office", "hrstd"), new QName("urn:schemas-microsoft-com:office:office", "hrnoshade"), new QName("urn:schemas-microsoft-com:office:office", "hrpct"), new QName("urn:schemas-microsoft-com:office:office", "hralign"), new QName("urn:schemas-microsoft-com:office:office", "allowincell"), new QName("urn:schemas-microsoft-com:office:office", "allowoverlap"), new QName("urn:schemas-microsoft-com:office:office", "userdrawn"), new QName("urn:schemas-microsoft-com:office:office", "bordertopcolor"), new QName("urn:schemas-microsoft-com:office:office", "borderleftcolor"), new QName("urn:schemas-microsoft-com:office:office", "borderbottomcolor"), new QName("urn:schemas-microsoft-com:office:office", "borderrightcolor"), new QName("urn:schemas-microsoft-com:office:office", "dgmlayout"), new QName("urn:schemas-microsoft-com:office:office", "dgmnodekind"), new QName("urn:schemas-microsoft-com:office:office", "dgmlayoutmru"), new QName("urn:schemas-microsoft-com:office:office", "insetmode"), new QName("", "filled"), new QName("", "fillcolor"), new QName("", "editas"), new QName("urn:schemas-microsoft-com:office:office", "tableproperties"), new QName("urn:schemas-microsoft-com:office:office", "tablelimits")};
    private static final long serialVersionUID = 1;

    public CTGroupImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTAnchorLock addNewAnchorlock() {
        CTAnchorLock cTAnchorLock;
        synchronized (monitor()) {
            check_orphaned();
            cTAnchorLock = (CTAnchorLock) get_store().add_element_user(PROPERTY_QNAME[16]);
        }
        return cTAnchorLock;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTArc addNewArc() {
        CTArc cTArcAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTArcAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[26]);
        }
        return cTArcAdd_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTBorder addNewBorderbottom() {
        CTBorder cTBorderAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBorderAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[18]);
        }
        return cTBorderAdd_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTBorder addNewBorderleft() {
        CTBorder cTBorderAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBorderAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[19]);
        }
        return cTBorderAdd_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTBorder addNewBorderright() {
        CTBorder cTBorderAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBorderAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[20]);
        }
        return cTBorderAdd_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTBorder addNewBordertop() {
        CTBorder cTBorderAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBorderAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[17]);
        }
        return cTBorderAdd_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTCallout addNewCallout() {
        CTCallout cTCalloutAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTCalloutAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[11]);
        }
        return cTCalloutAdd_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTClientData addNewClientData() {
        CTClientData cTClientData;
        synchronized (monitor()) {
            check_orphaned();
            cTClientData = (CTClientData) get_store().add_element_user(PROPERTY_QNAME[21]);
        }
        return cTClientData;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTClipPath addNewClippath() {
        CTClipPath cTClipPathAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTClipPathAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[13]);
        }
        return cTClipPathAdd_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTCurve addNewCurve() {
        CTCurve cTCurveAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTCurveAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[27]);
        }
        return cTCurveAdd_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTDiagram addNewDiagram() {
        CTDiagram cTDiagramAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTDiagramAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[34]);
        }
        return cTDiagramAdd_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTExtrusion addNewExtrusion() {
        CTExtrusion cTExtrusionAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTExtrusionAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[10]);
        }
        return cTExtrusionAdd_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTFill addNewFill() {
        CTFill cTFill;
        synchronized (monitor()) {
            check_orphaned();
            cTFill = (CTFill) get_store().add_element_user(PROPERTY_QNAME[3]);
        }
        return cTFill;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTFormulas addNewFormulas() {
        CTFormulas cTFormulas;
        synchronized (monitor()) {
            check_orphaned();
            cTFormulas = (CTFormulas) get_store().add_element_user(PROPERTY_QNAME[1]);
        }
        return cTFormulas;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTGroup addNewGroup() {
        CTGroup cTGroup;
        synchronized (monitor()) {
            check_orphaned();
            cTGroup = (CTGroup) get_store().add_element_user(PROPERTY_QNAME[23]);
        }
        return cTGroup;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTHandles addNewHandles() {
        CTHandles cTHandles;
        synchronized (monitor()) {
            check_orphaned();
            cTHandles = (CTHandles) get_store().add_element_user(PROPERTY_QNAME[2]);
        }
        return cTHandles;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTImage addNewImage() {
        CTImage cTImageAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTImageAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[28]);
        }
        return cTImageAdd_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTImageData addNewImagedata() {
        CTImageData cTImageData;
        synchronized (monitor()) {
            check_orphaned();
            cTImageData = (CTImageData) get_store().add_element_user(PROPERTY_QNAME[8]);
        }
        return cTImageData;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTLine addNewLine() {
        CTLine cTLine;
        synchronized (monitor()) {
            check_orphaned();
            cTLine = (CTLine) get_store().add_element_user(PROPERTY_QNAME[29]);
        }
        return cTLine;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTLock addNewLock() {
        CTLock cTLock;
        synchronized (monitor()) {
            check_orphaned();
            cTLock = (CTLock) get_store().add_element_user(PROPERTY_QNAME[12]);
        }
        return cTLock;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTOval addNewOval() {
        CTOval cTOval;
        synchronized (monitor()) {
            check_orphaned();
            cTOval = (CTOval) get_store().add_element_user(PROPERTY_QNAME[30]);
        }
        return cTOval;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTPath addNewPath() {
        CTPath cTPath;
        synchronized (monitor()) {
            check_orphaned();
            cTPath = (CTPath) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTPath;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTPolyLine addNewPolyline() {
        CTPolyLine cTPolyLineAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTPolyLineAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[31]);
        }
        return cTPolyLineAdd_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTRect addNewRect() {
        CTRect cTRect;
        synchronized (monitor()) {
            check_orphaned();
            cTRect = (CTRect) get_store().add_element_user(PROPERTY_QNAME[32]);
        }
        return cTRect;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTRoundRect addNewRoundrect() {
        CTRoundRect cTRoundRect;
        synchronized (monitor()) {
            check_orphaned();
            cTRoundRect = (CTRoundRect) get_store().add_element_user(PROPERTY_QNAME[33]);
        }
        return cTRoundRect;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTShadow addNewShadow() {
        CTShadow cTShadow;
        synchronized (monitor()) {
            check_orphaned();
            cTShadow = (CTShadow) get_store().add_element_user(PROPERTY_QNAME[5]);
        }
        return cTShadow;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTShape addNewShape() {
        CTShape cTShape;
        synchronized (monitor()) {
            check_orphaned();
            cTShape = (CTShape) get_store().add_element_user(PROPERTY_QNAME[24]);
        }
        return cTShape;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTShapetype addNewShapetype() {
        CTShapetype cTShapetype;
        synchronized (monitor()) {
            check_orphaned();
            cTShapetype = (CTShapetype) get_store().add_element_user(PROPERTY_QNAME[25]);
        }
        return cTShapetype;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTSignatureLine addNewSignatureline() {
        CTSignatureLine cTSignatureLine;
        synchronized (monitor()) {
            check_orphaned();
            cTSignatureLine = (CTSignatureLine) get_store().add_element_user(PROPERTY_QNAME[14]);
        }
        return cTSignatureLine;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTSkew addNewSkew() {
        CTSkew cTSkewAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSkewAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[9]);
        }
        return cTSkewAdd_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTStroke addNewStroke() {
        CTStroke cTStroke;
        synchronized (monitor()) {
            check_orphaned();
            cTStroke = (CTStroke) get_store().add_element_user(PROPERTY_QNAME[4]);
        }
        return cTStroke;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTTextbox addNewTextbox() {
        CTTextbox cTTextbox;
        synchronized (monitor()) {
            check_orphaned();
            cTTextbox = (CTTextbox) get_store().add_element_user(PROPERTY_QNAME[6]);
        }
        return cTTextbox;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTRel addNewTextdata() {
        CTRel cTRelAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTRelAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[22]);
        }
        return cTRelAdd_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTTextPath addNewTextpath() {
        CTTextPath cTTextPath;
        synchronized (monitor()) {
            check_orphaned();
            cTTextPath = (CTTextPath) get_store().add_element_user(PROPERTY_QNAME[7]);
        }
        return cTTextPath;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTWrap addNewWrap() {
        CTWrap cTWrap;
        synchronized (monitor()) {
            check_orphaned();
            cTWrap = (CTWrap) get_store().add_element_user(PROPERTY_QNAME[15]);
        }
        return cTWrap;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public STTrueFalse.Enum getAllowincell() {
        STTrueFalse.Enum r6;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[58]);
            r6 = simpleValue == null ? null : (STTrueFalse.Enum) simpleValue.getEnumValue();
        }
        return r6;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public STTrueFalse.Enum getAllowoverlap() {
        STTrueFalse.Enum r6;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[59]);
            r6 = simpleValue == null ? null : (STTrueFalse.Enum) simpleValue.getEnumValue();
        }
        return r6;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public String getAlt() {
        String stringValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[41]);
            stringValue = simpleValue == null ? null : simpleValue.getStringValue();
        }
        return stringValue;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTAnchorLock[] getAnchorlockArray() {
        return (CTAnchorLock[]) getXmlObjectArray(PROPERTY_QNAME[16], new CTAnchorLock[0]);
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public List<CTAnchorLock> getAnchorlockList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new C1814k(this, 18), new C1798c(this, 14), new C1814k(this, 19), new C1800d(this, 24), new C1802e(this, 24));
        }
        return javaListXmlObject;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTArc[] getArcArray() {
        return getXmlObjectArray(PROPERTY_QNAME[26], (XmlObject[]) new CTArc[0]);
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public List<CTArc> getArcList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new C1796b(this, 8), new BiConsumer() { // from class: t2.g
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    this.f8616a.setArcArray(((Integer) obj).intValue(), (CTArc) obj2);
                }
            }, new C1796b(this, 9), new C1800d(this, 3), new C1802e(this, 3));
        }
        return javaListXmlObject;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTBorder[] getBorderbottomArray() {
        return getXmlObjectArray(PROPERTY_QNAME[18], (XmlObject[]) new CTBorder[0]);
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public List<CTBorder> getBorderbottomList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new C1796b(this, 27), new BiConsumer() { // from class: t2.l
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    this.f8628a.setBorderbottomArray(((Integer) obj).intValue(), (CTBorder) obj2);
                }
            }, new C1814k(this, 4), new C1800d(this, 16), new C1802e(this, 16));
        }
        return javaListXmlObject;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public String getBorderbottomcolor() {
        String stringValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[63]);
            stringValue = simpleValue == null ? null : simpleValue.getStringValue();
        }
        return stringValue;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTBorder[] getBorderleftArray() {
        return getXmlObjectArray(PROPERTY_QNAME[19], (XmlObject[]) new CTBorder[0]);
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public List<CTBorder> getBorderleftList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new C1814k(this, 10), new BiConsumer() { // from class: t2.n
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    this.f8632a.setBorderleftArray(((Integer) obj).intValue(), (CTBorder) obj2);
                }
            }, new C1814k(this, 11), new C1800d(this, 19), new C1802e(this, 19));
        }
        return javaListXmlObject;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public String getBorderleftcolor() {
        String stringValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[62]);
            stringValue = simpleValue == null ? null : simpleValue.getStringValue();
        }
        return stringValue;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTBorder[] getBorderrightArray() {
        return getXmlObjectArray(PROPERTY_QNAME[20], (XmlObject[]) new CTBorder[0]);
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public List<CTBorder> getBorderrightList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new C1814k(this, 27), new BiConsumer() { // from class: t2.r
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    this.f8640a.setBorderrightArray(((Integer) obj).intValue(), (CTBorder) obj2);
                }
            }, new C1814k(this, 28), new C1800d(this, 28), new C1802e(this, 28));
        }
        return javaListXmlObject;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public String getBorderrightcolor() {
        String stringValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[64]);
            stringValue = simpleValue == null ? null : simpleValue.getStringValue();
        }
        return stringValue;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTBorder[] getBordertopArray() {
        return getXmlObjectArray(PROPERTY_QNAME[17], (XmlObject[]) new CTBorder[0]);
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public List<CTBorder> getBordertopList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new C1814k(this, 22), new BiConsumer() { // from class: t2.q
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    this.f8638a.setBordertopArray(((Integer) obj).intValue(), (CTBorder) obj2);
                }
            }, new C1829s(this, 1), new C1833u(this, 2), new C1835v(this, 4));
        }
        return javaListXmlObject;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public String getBordertopcolor() {
        String stringValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[61]);
            stringValue = simpleValue == null ? null : simpleValue.getStringValue();
        }
        return stringValue;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public STTrueFalse.Enum getBullet() {
        STTrueFalse.Enum r6;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[52]);
            r6 = simpleValue == null ? null : (STTrueFalse.Enum) simpleValue.getEnumValue();
        }
        return r6;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public STTrueFalse.Enum getButton() {
        STTrueFalse.Enum r6;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[50]);
            r6 = simpleValue == null ? null : (STTrueFalse.Enum) simpleValue.getEnumValue();
        }
        return r6;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTCallout[] getCalloutArray() {
        return getXmlObjectArray(PROPERTY_QNAME[11], (XmlObject[]) new CTCallout[0]);
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public List<CTCallout> getCalloutList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new C1796b(this, 6), new BiConsumer() { // from class: t2.f
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    this.f8613a.setCalloutArray(((Integer) obj).intValue(), (CTCallout) obj2);
                }
            }, new C1796b(this, 7), new C1800d(this, 2), new C1802e(this, 2));
        }
        return javaListXmlObject;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public String getClass1() {
        String stringValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[39]);
            stringValue = simpleValue == null ? null : simpleValue.getStringValue();
        }
        return stringValue;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTClientData[] getClientDataArray() {
        return (CTClientData[]) getXmlObjectArray(PROPERTY_QNAME[21], new CTClientData[0]);
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public List<CTClientData> getClientDataList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new C1814k(this, 12), new C1798c(this, 13), new C1814k(this, 13), new C1800d(this, 20), new C1802e(this, 20));
        }
        return javaListXmlObject;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTClipPath[] getClippathArray() {
        return getXmlObjectArray(PROPERTY_QNAME[13], (XmlObject[]) new CTClipPath[0]);
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public List<CTClipPath> getClippathList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new C1796b(this, 10), new BiConsumer() { // from class: t2.h
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    this.f8619a.setClippathArray(((Integer) obj).intValue(), (CTClipPath) obj2);
                }
            }, new C1796b(this, 11), new C1800d(this, 4), new C1802e(this, 4));
        }
        return javaListXmlObject;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public String getCoordorigin() {
        String stringValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[43]);
            stringValue = simpleValue == null ? null : simpleValue.getStringValue();
        }
        return stringValue;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public String getCoordsize() {
        String stringValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[42]);
            stringValue = simpleValue == null ? null : simpleValue.getStringValue();
        }
        return stringValue;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTCurve[] getCurveArray() {
        return getXmlObjectArray(PROPERTY_QNAME[27], (XmlObject[]) new CTCurve[0]);
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public List<CTCurve> getCurveList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new C1796b(this, 23), new BiConsumer() { // from class: t2.j
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    this.f8624a.setCurveArray(((Integer) obj).intValue(), (CTCurve) obj2);
                }
            }, new C1796b(this, 24), new C1800d(this, 11), new C1802e(this, 11));
        }
        return javaListXmlObject;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public BigInteger getDgmlayout() {
        BigInteger bigIntegerValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[65]);
            bigIntegerValue = simpleValue == null ? null : simpleValue.getBigIntegerValue();
        }
        return bigIntegerValue;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public BigInteger getDgmlayoutmru() {
        BigInteger bigIntegerValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[67]);
            bigIntegerValue = simpleValue == null ? null : simpleValue.getBigIntegerValue();
        }
        return bigIntegerValue;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public BigInteger getDgmnodekind() {
        BigInteger bigIntegerValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[66]);
            bigIntegerValue = simpleValue == null ? null : simpleValue.getBigIntegerValue();
        }
        return bigIntegerValue;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTDiagram[] getDiagramArray() {
        return getXmlObjectArray(PROPERTY_QNAME[34], (XmlObject[]) new CTDiagram[0]);
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public List<CTDiagram> getDiagramList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new C1814k(this, 16), new BiConsumer() { // from class: t2.p
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    this.f8636a.setDiagramArray(((Integer) obj).intValue(), (CTDiagram) obj2);
                }
            }, new C1814k(this, 17), new C1800d(this, 23), new C1802e(this, 22));
        }
        return javaListXmlObject;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public STTrueFalse.Enum getDoubleclicknotify() {
        STTrueFalse.Enum r6;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[49]);
            r6 = simpleValue == null ? null : (STTrueFalse.Enum) simpleValue.getEnumValue();
        }
        return r6;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public STEditAs.Enum getEditas() {
        STEditAs.Enum r6;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[71]);
            r6 = simpleValue == null ? null : (STEditAs.Enum) simpleValue.getEnumValue();
        }
        return r6;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTExtrusion[] getExtrusionArray() {
        return getXmlObjectArray(PROPERTY_QNAME[10], (XmlObject[]) new CTExtrusion[0]);
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public List<CTExtrusion> getExtrusionList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new C1796b(this, 0), new BiConsumer() { // from class: t2.m
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    this.f8630a.setExtrusionArray(((Integer) obj).intValue(), (CTExtrusion) obj2);
                }
            }, new C1814k(this, 9), new C1800d(this, 21), new C1802e(this, 23));
        }
        return javaListXmlObject;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTFill[] getFillArray() {
        return (CTFill[]) getXmlObjectArray(PROPERTY_QNAME[3], new CTFill[0]);
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public List<CTFill> getFillList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new C1814k(this, 23), new C1798c(this, 16), new C1814k(this, 24), new C1800d(this, 26), new C1802e(this, 26));
        }
        return javaListXmlObject;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public String getFillcolor() {
        String stringValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[70]);
            stringValue = simpleValue == null ? null : simpleValue.getStringValue();
        }
        return stringValue;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public STTrueFalse.Enum getFilled() {
        STTrueFalse.Enum r6;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[69]);
            r6 = simpleValue == null ? null : (STTrueFalse.Enum) simpleValue.getEnumValue();
        }
        return r6;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTFormulas[] getFormulasArray() {
        return (CTFormulas[]) getXmlObjectArray(PROPERTY_QNAME[1], new CTFormulas[0]);
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public List<CTFormulas> getFormulasList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new C1814k(this, 7), new C1798c(this, 12), new C1814k(this, 8), new C1800d(this, 18), new C1802e(this, 18));
        }
        return javaListXmlObject;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTGroup[] getGroupArray() {
        return (CTGroup[]) getXmlObjectArray(PROPERTY_QNAME[23], new CTGroup[0]);
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public List<CTGroup> getGroupList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new C1814k(this, 2), new C1798c(this, 10), new C1814k(this, 3), new C1800d(this, 15), new C1802e(this, 15));
        }
        return javaListXmlObject;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTHandles[] getHandlesArray() {
        return (CTHandles[]) getXmlObjectArray(PROPERTY_QNAME[2], new CTHandles[0]);
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public List<CTHandles> getHandlesList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new C1796b(this, 5), new C1798c(this, 2), new C1796b(this, 14), new C1800d(this, 8), new C1802e(this, 10));
        }
        return javaListXmlObject;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public STTrueFalse.Enum getHr() {
        STTrueFalse.Enum r6;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[53]);
            r6 = simpleValue == null ? null : (STTrueFalse.Enum) simpleValue.getEnumValue();
        }
        return r6;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public STHrAlign.Enum getHralign() {
        STHrAlign.Enum r6;
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[57]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_default_attribute_value(qNameArr[57]);
                }
                r6 = simpleValue == null ? null : (STHrAlign.Enum) simpleValue.getEnumValue();
            } catch (Throwable th) {
                throw th;
            }
        }
        return r6;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public String getHref() {
        String stringValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[37]);
            stringValue = simpleValue == null ? null : simpleValue.getStringValue();
        }
        return stringValue;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public STTrueFalse.Enum getHrnoshade() {
        STTrueFalse.Enum r6;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[55]);
            r6 = simpleValue == null ? null : (STTrueFalse.Enum) simpleValue.getEnumValue();
        }
        return r6;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public float getHrpct() {
        float floatValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[56]);
            floatValue = simpleValue == null ? 0.0f : simpleValue.getFloatValue();
        }
        return floatValue;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public STTrueFalse.Enum getHrstd() {
        STTrueFalse.Enum r6;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[54]);
            r6 = simpleValue == null ? null : (STTrueFalse.Enum) simpleValue.getEnumValue();
        }
        return r6;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public String getId() {
        String stringValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[35]);
            stringValue = simpleValue == null ? null : simpleValue.getStringValue();
        }
        return stringValue;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTImage[] getImageArray() {
        return getXmlObjectArray(PROPERTY_QNAME[28], (XmlObject[]) new CTImage[0]);
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public List<CTImage> getImageList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new C1814k(this, 14), new BiConsumer() { // from class: t2.o
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    this.f8634a.setImageArray(((Integer) obj).intValue(), (CTImage) obj2);
                }
            }, new C1814k(this, 15), new C1800d(this, 22), new C1802e(this, 21));
        }
        return javaListXmlObject;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTImageData[] getImagedataArray() {
        return (CTImageData[]) getXmlObjectArray(PROPERTY_QNAME[8], new CTImageData[0]);
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public List<CTImageData> getImagedataList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new C1814k(this, 29), new C1798c(this, 18), new C1829s(this, 0), new C1800d(this, 29), new C1802e(this, 29));
        }
        return javaListXmlObject;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public STInsetMode.Enum getInsetmode() {
        STInsetMode.Enum r6;
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[68]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_default_attribute_value(qNameArr[68]);
                }
                r6 = simpleValue == null ? null : (STInsetMode.Enum) simpleValue.getEnumValue();
            } catch (Throwable th) {
                throw th;
            }
        }
        return r6;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTLine[] getLineArray() {
        return (CTLine[]) getXmlObjectArray(PROPERTY_QNAME[29], new CTLine[0]);
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public List<CTLine> getLineList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new C1796b(this, 21), new C1798c(this, 6), new C1796b(this, 22), new C1800d(this, 10), new C1802e(this, 9));
        }
        return javaListXmlObject;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTLock[] getLockArray() {
        return (CTLock[]) getXmlObjectArray(PROPERTY_QNAME[12], new CTLock[0]);
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public List<CTLock> getLockList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new C1814k(this, 0), new C1798c(this, 9), new C1814k(this, 1), new C1800d(this, 14), new C1802e(this, 14));
        }
        return javaListXmlObject;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public STTrueFalse.Enum getOned() {
        STTrueFalse.Enum r6;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[47]);
            r6 = simpleValue == null ? null : (STTrueFalse.Enum) simpleValue.getEnumValue();
        }
        return r6;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTOval[] getOvalArray() {
        return (CTOval[]) getXmlObjectArray(PROPERTY_QNAME[30], new CTOval[0]);
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public List<CTOval> getOvalList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new C1814k(this, 25), new C1798c(this, 17), new C1814k(this, 26), new C1800d(this, 27), new C1802e(this, 27));
        }
        return javaListXmlObject;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTPath[] getPathArray() {
        return (CTPath[]) getXmlObjectArray(PROPERTY_QNAME[0], new CTPath[0]);
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public List<CTPath> getPathList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new C1796b(this, 28), new C1798c(this, 8), new C1796b(this, 29), new C1800d(this, 13), new C1802e(this, 13));
        }
        return javaListXmlObject;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTPolyLine[] getPolylineArray() {
        return getXmlObjectArray(PROPERTY_QNAME[31], (XmlObject[]) new CTPolyLine[0]);
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public List<CTPolyLine> getPolylineList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new C1829s(this, 4), new BiConsumer() { // from class: t2.w
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    this.f8650a.setPolylineArray(((Integer) obj).intValue(), (CTPolyLine) obj2);
                }
            }, new C1829s(this, 5), new C1833u(this, 1), new C1835v(this, 1));
        }
        return javaListXmlObject;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public STTrueFalse.Enum getPrint() {
        STTrueFalse.Enum r6;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[45]);
            r6 = simpleValue == null ? null : (STTrueFalse.Enum) simpleValue.getEnumValue();
        }
        return r6;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTRect[] getRectArray() {
        return (CTRect[]) getXmlObjectArray(PROPERTY_QNAME[32], new CTRect[0]);
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public List<CTRect> getRectList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new C1796b(this, 3), new C1798c(this, 1), new C1796b(this, 4), new C1800d(this, 1), new C1802e(this, 1));
        }
        return javaListXmlObject;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public BigInteger getRegroupid() {
        BigInteger bigIntegerValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[48]);
            bigIntegerValue = simpleValue == null ? null : simpleValue.getBigIntegerValue();
        }
        return bigIntegerValue;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTRoundRect[] getRoundrectArray() {
        return (CTRoundRect[]) getXmlObjectArray(PROPERTY_QNAME[33], new CTRoundRect[0]);
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public List<CTRoundRect> getRoundrectList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new C1796b(this, 15), new C1798c(this, 3), new C1796b(this, 16), new C1800d(this, 6), new C1802e(this, 6));
        }
        return javaListXmlObject;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTShadow[] getShadowArray() {
        return (CTShadow[]) getXmlObjectArray(PROPERTY_QNAME[5], new CTShadow[0]);
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public List<CTShadow> getShadowList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new C1796b(this, 25), new C1798c(this, 7), new C1796b(this, 26), new C1800d(this, 12), new C1802e(this, 12));
        }
        return javaListXmlObject;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTShape[] getShapeArray() {
        return (CTShape[]) getXmlObjectArray(PROPERTY_QNAME[24], new CTShape[0]);
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public List<CTShape> getShapeList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new C1829s(this, 8), new C1798c(this, 20), new C1829s(this, 9), new C1833u(this, 4), new C1835v(this, 3));
        }
        return javaListXmlObject;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTShapetype[] getShapetypeArray() {
        return (CTShapetype[]) getXmlObjectArray(PROPERTY_QNAME[25], new CTShapetype[0]);
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public List<CTShapetype> getShapetypeList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new C1829s(this, 6), new C1798c(this, 19), new C1829s(this, 7), new C1833u(this, 3), new C1835v(this, 2));
        }
        return javaListXmlObject;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTSignatureLine[] getSignaturelineArray() {
        return (CTSignatureLine[]) getXmlObjectArray(PROPERTY_QNAME[14], new CTSignatureLine[0]);
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public List<CTSignatureLine> getSignaturelineList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new C1796b(this, 1), new C1798c(this, 0), new C1796b(this, 2), new C1800d(this, 0), new C1802e(this, 0));
        }
        return javaListXmlObject;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTSkew[] getSkewArray() {
        return getXmlObjectArray(PROPERTY_QNAME[9], (XmlObject[]) new CTSkew[0]);
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public List<CTSkew> getSkewList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new C1829s(this, 2), new BiConsumer() { // from class: t2.t
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    this.f8644a.setSkewArray(((Integer) obj).intValue(), (CTSkew) obj2);
                }
            }, new C1829s(this, 3), new C1833u(this, 0), new C1835v(this, 0));
        }
        return javaListXmlObject;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public String getSpid() {
        String stringValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[46]);
            stringValue = simpleValue == null ? null : simpleValue.getStringValue();
        }
        return stringValue;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTStroke[] getStrokeArray() {
        return (CTStroke[]) getXmlObjectArray(PROPERTY_QNAME[4], new CTStroke[0]);
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public List<CTStroke> getStrokeList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new C1814k(this, 20), new C1798c(this, 15), new C1814k(this, 21), new C1800d(this, 25), new C1802e(this, 25));
        }
        return javaListXmlObject;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public String getStyle() {
        String stringValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[36]);
            stringValue = simpleValue == null ? null : simpleValue.getStringValue();
        }
        return stringValue;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public String getTablelimits() {
        String stringValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[73]);
            stringValue = simpleValue == null ? null : simpleValue.getStringValue();
        }
        return stringValue;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public String getTableproperties() {
        String stringValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[72]);
            stringValue = simpleValue == null ? null : simpleValue.getStringValue();
        }
        return stringValue;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public String getTarget() {
        String stringValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[38]);
            stringValue = simpleValue == null ? null : simpleValue.getStringValue();
        }
        return stringValue;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTTextbox[] getTextboxArray() {
        return (CTTextbox[]) getXmlObjectArray(PROPERTY_QNAME[6], new CTTextbox[0]);
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public List<CTTextbox> getTextboxList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new C1796b(this, 19), new C1798c(this, 5), new C1796b(this, 20), new C1800d(this, 9), new C1802e(this, 8));
        }
        return javaListXmlObject;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTRel[] getTextdataArray() {
        return getXmlObjectArray(PROPERTY_QNAME[22], (XmlObject[]) new CTRel[0]);
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public List<CTRel> getTextdataList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new C1796b(this, 12), new BiConsumer() { // from class: t2.i
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    this.f8622a.setTextdataArray(((Integer) obj).intValue(), (CTRel) obj2);
                }
            }, new C1796b(this, 13), new C1800d(this, 5), new C1802e(this, 5));
        }
        return javaListXmlObject;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTTextPath[] getTextpathArray() {
        return (CTTextPath[]) getXmlObjectArray(PROPERTY_QNAME[7], new CTTextPath[0]);
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public List<CTTextPath> getTextpathList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new C1796b(this, 17), new C1798c(this, 4), new C1796b(this, 18), new C1800d(this, 7), new C1802e(this, 7));
        }
        return javaListXmlObject;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public String getTitle() {
        String stringValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[40]);
            stringValue = simpleValue == null ? null : simpleValue.getStringValue();
        }
        return stringValue;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public STTrueFalse.Enum getUserdrawn() {
        STTrueFalse.Enum r6;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[60]);
            r6 = simpleValue == null ? null : (STTrueFalse.Enum) simpleValue.getEnumValue();
        }
        return r6;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public STTrueFalse.Enum getUserhidden() {
        STTrueFalse.Enum r6;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[51]);
            r6 = simpleValue == null ? null : (STTrueFalse.Enum) simpleValue.getEnumValue();
        }
        return r6;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTWrap[] getWrapArray() {
        return (CTWrap[]) getXmlObjectArray(PROPERTY_QNAME[15], new CTWrap[0]);
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public List<CTWrap> getWrapList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new C1814k(this, 5), new C1798c(this, 11), new C1814k(this, 6), new C1800d(this, 17), new C1802e(this, 17));
        }
        return javaListXmlObject;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public String getWrapcoords() {
        String stringValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[44]);
            stringValue = simpleValue == null ? null : simpleValue.getStringValue();
        }
        return stringValue;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTAnchorLock insertNewAnchorlock(int i5) {
        CTAnchorLock cTAnchorLock;
        synchronized (monitor()) {
            check_orphaned();
            cTAnchorLock = (CTAnchorLock) get_store().insert_element_user(PROPERTY_QNAME[16], i5);
        }
        return cTAnchorLock;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTArc insertNewArc(int i5) {
        CTArc cTArcInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTArcInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[26], i5);
        }
        return cTArcInsert_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTBorder insertNewBorderbottom(int i5) {
        CTBorder cTBorderInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBorderInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[18], i5);
        }
        return cTBorderInsert_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTBorder insertNewBorderleft(int i5) {
        CTBorder cTBorderInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBorderInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[19], i5);
        }
        return cTBorderInsert_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTBorder insertNewBorderright(int i5) {
        CTBorder cTBorderInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBorderInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[20], i5);
        }
        return cTBorderInsert_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTBorder insertNewBordertop(int i5) {
        CTBorder cTBorderInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBorderInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[17], i5);
        }
        return cTBorderInsert_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTCallout insertNewCallout(int i5) {
        CTCallout cTCalloutInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTCalloutInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[11], i5);
        }
        return cTCalloutInsert_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTClientData insertNewClientData(int i5) {
        CTClientData cTClientData;
        synchronized (monitor()) {
            check_orphaned();
            cTClientData = (CTClientData) get_store().insert_element_user(PROPERTY_QNAME[21], i5);
        }
        return cTClientData;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTClipPath insertNewClippath(int i5) {
        CTClipPath cTClipPathInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTClipPathInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[13], i5);
        }
        return cTClipPathInsert_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTCurve insertNewCurve(int i5) {
        CTCurve cTCurveInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTCurveInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[27], i5);
        }
        return cTCurveInsert_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTDiagram insertNewDiagram(int i5) {
        CTDiagram cTDiagramInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTDiagramInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[34], i5);
        }
        return cTDiagramInsert_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTExtrusion insertNewExtrusion(int i5) {
        CTExtrusion cTExtrusionInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTExtrusionInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[10], i5);
        }
        return cTExtrusionInsert_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTFill insertNewFill(int i5) {
        CTFill cTFill;
        synchronized (monitor()) {
            check_orphaned();
            cTFill = (CTFill) get_store().insert_element_user(PROPERTY_QNAME[3], i5);
        }
        return cTFill;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTFormulas insertNewFormulas(int i5) {
        CTFormulas cTFormulas;
        synchronized (monitor()) {
            check_orphaned();
            cTFormulas = (CTFormulas) get_store().insert_element_user(PROPERTY_QNAME[1], i5);
        }
        return cTFormulas;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTGroup insertNewGroup(int i5) {
        CTGroup cTGroup;
        synchronized (monitor()) {
            check_orphaned();
            cTGroup = (CTGroup) get_store().insert_element_user(PROPERTY_QNAME[23], i5);
        }
        return cTGroup;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTHandles insertNewHandles(int i5) {
        CTHandles cTHandles;
        synchronized (monitor()) {
            check_orphaned();
            cTHandles = (CTHandles) get_store().insert_element_user(PROPERTY_QNAME[2], i5);
        }
        return cTHandles;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTImage insertNewImage(int i5) {
        CTImage cTImageInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTImageInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[28], i5);
        }
        return cTImageInsert_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTImageData insertNewImagedata(int i5) {
        CTImageData cTImageData;
        synchronized (monitor()) {
            check_orphaned();
            cTImageData = (CTImageData) get_store().insert_element_user(PROPERTY_QNAME[8], i5);
        }
        return cTImageData;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTLine insertNewLine(int i5) {
        CTLine cTLine;
        synchronized (monitor()) {
            check_orphaned();
            cTLine = (CTLine) get_store().insert_element_user(PROPERTY_QNAME[29], i5);
        }
        return cTLine;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTLock insertNewLock(int i5) {
        CTLock cTLock;
        synchronized (monitor()) {
            check_orphaned();
            cTLock = (CTLock) get_store().insert_element_user(PROPERTY_QNAME[12], i5);
        }
        return cTLock;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTOval insertNewOval(int i5) {
        CTOval cTOval;
        synchronized (monitor()) {
            check_orphaned();
            cTOval = (CTOval) get_store().insert_element_user(PROPERTY_QNAME[30], i5);
        }
        return cTOval;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTPath insertNewPath(int i5) {
        CTPath cTPath;
        synchronized (monitor()) {
            check_orphaned();
            cTPath = (CTPath) get_store().insert_element_user(PROPERTY_QNAME[0], i5);
        }
        return cTPath;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTPolyLine insertNewPolyline(int i5) {
        CTPolyLine cTPolyLineInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTPolyLineInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[31], i5);
        }
        return cTPolyLineInsert_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTRect insertNewRect(int i5) {
        CTRect cTRect;
        synchronized (monitor()) {
            check_orphaned();
            cTRect = (CTRect) get_store().insert_element_user(PROPERTY_QNAME[32], i5);
        }
        return cTRect;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTRoundRect insertNewRoundrect(int i5) {
        CTRoundRect cTRoundRect;
        synchronized (monitor()) {
            check_orphaned();
            cTRoundRect = (CTRoundRect) get_store().insert_element_user(PROPERTY_QNAME[33], i5);
        }
        return cTRoundRect;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTShadow insertNewShadow(int i5) {
        CTShadow cTShadow;
        synchronized (monitor()) {
            check_orphaned();
            cTShadow = (CTShadow) get_store().insert_element_user(PROPERTY_QNAME[5], i5);
        }
        return cTShadow;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTShape insertNewShape(int i5) {
        CTShape cTShape;
        synchronized (monitor()) {
            check_orphaned();
            cTShape = (CTShape) get_store().insert_element_user(PROPERTY_QNAME[24], i5);
        }
        return cTShape;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTShapetype insertNewShapetype(int i5) {
        CTShapetype cTShapetype;
        synchronized (monitor()) {
            check_orphaned();
            cTShapetype = (CTShapetype) get_store().insert_element_user(PROPERTY_QNAME[25], i5);
        }
        return cTShapetype;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTSignatureLine insertNewSignatureline(int i5) {
        CTSignatureLine cTSignatureLine;
        synchronized (monitor()) {
            check_orphaned();
            cTSignatureLine = (CTSignatureLine) get_store().insert_element_user(PROPERTY_QNAME[14], i5);
        }
        return cTSignatureLine;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTSkew insertNewSkew(int i5) {
        CTSkew cTSkewInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSkewInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[9], i5);
        }
        return cTSkewInsert_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTStroke insertNewStroke(int i5) {
        CTStroke cTStroke;
        synchronized (monitor()) {
            check_orphaned();
            cTStroke = (CTStroke) get_store().insert_element_user(PROPERTY_QNAME[4], i5);
        }
        return cTStroke;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTTextbox insertNewTextbox(int i5) {
        CTTextbox cTTextbox;
        synchronized (monitor()) {
            check_orphaned();
            cTTextbox = (CTTextbox) get_store().insert_element_user(PROPERTY_QNAME[6], i5);
        }
        return cTTextbox;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTRel insertNewTextdata(int i5) {
        CTRel cTRelInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTRelInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[22], i5);
        }
        return cTRelInsert_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTTextPath insertNewTextpath(int i5) {
        CTTextPath cTTextPath;
        synchronized (monitor()) {
            check_orphaned();
            cTTextPath = (CTTextPath) get_store().insert_element_user(PROPERTY_QNAME[7], i5);
        }
        return cTTextPath;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTWrap insertNewWrap(int i5) {
        CTWrap cTWrap;
        synchronized (monitor()) {
            check_orphaned();
            cTWrap = (CTWrap) get_store().insert_element_user(PROPERTY_QNAME[15], i5);
        }
        return cTWrap;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public boolean isSetAllowincell() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().find_attribute_user(PROPERTY_QNAME[58]) != null;
        }
        return z6;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public boolean isSetAllowoverlap() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().find_attribute_user(PROPERTY_QNAME[59]) != null;
        }
        return z6;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public boolean isSetAlt() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().find_attribute_user(PROPERTY_QNAME[41]) != null;
        }
        return z6;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public boolean isSetBorderbottomcolor() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().find_attribute_user(PROPERTY_QNAME[63]) != null;
        }
        return z6;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public boolean isSetBorderleftcolor() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().find_attribute_user(PROPERTY_QNAME[62]) != null;
        }
        return z6;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public boolean isSetBorderrightcolor() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().find_attribute_user(PROPERTY_QNAME[64]) != null;
        }
        return z6;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public boolean isSetBordertopcolor() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().find_attribute_user(PROPERTY_QNAME[61]) != null;
        }
        return z6;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public boolean isSetBullet() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().find_attribute_user(PROPERTY_QNAME[52]) != null;
        }
        return z6;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public boolean isSetButton() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().find_attribute_user(PROPERTY_QNAME[50]) != null;
        }
        return z6;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public boolean isSetClass1() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().find_attribute_user(PROPERTY_QNAME[39]) != null;
        }
        return z6;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public boolean isSetCoordorigin() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().find_attribute_user(PROPERTY_QNAME[43]) != null;
        }
        return z6;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public boolean isSetCoordsize() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().find_attribute_user(PROPERTY_QNAME[42]) != null;
        }
        return z6;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public boolean isSetDgmlayout() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().find_attribute_user(PROPERTY_QNAME[65]) != null;
        }
        return z6;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public boolean isSetDgmlayoutmru() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().find_attribute_user(PROPERTY_QNAME[67]) != null;
        }
        return z6;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public boolean isSetDgmnodekind() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().find_attribute_user(PROPERTY_QNAME[66]) != null;
        }
        return z6;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public boolean isSetDoubleclicknotify() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().find_attribute_user(PROPERTY_QNAME[49]) != null;
        }
        return z6;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public boolean isSetEditas() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().find_attribute_user(PROPERTY_QNAME[71]) != null;
        }
        return z6;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public boolean isSetFillcolor() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().find_attribute_user(PROPERTY_QNAME[70]) != null;
        }
        return z6;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public boolean isSetFilled() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().find_attribute_user(PROPERTY_QNAME[69]) != null;
        }
        return z6;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public boolean isSetHr() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().find_attribute_user(PROPERTY_QNAME[53]) != null;
        }
        return z6;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public boolean isSetHralign() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().find_attribute_user(PROPERTY_QNAME[57]) != null;
        }
        return z6;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public boolean isSetHref() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().find_attribute_user(PROPERTY_QNAME[37]) != null;
        }
        return z6;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public boolean isSetHrnoshade() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().find_attribute_user(PROPERTY_QNAME[55]) != null;
        }
        return z6;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public boolean isSetHrpct() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().find_attribute_user(PROPERTY_QNAME[56]) != null;
        }
        return z6;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public boolean isSetHrstd() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().find_attribute_user(PROPERTY_QNAME[54]) != null;
        }
        return z6;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public boolean isSetId() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().find_attribute_user(PROPERTY_QNAME[35]) != null;
        }
        return z6;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public boolean isSetInsetmode() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().find_attribute_user(PROPERTY_QNAME[68]) != null;
        }
        return z6;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public boolean isSetOned() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().find_attribute_user(PROPERTY_QNAME[47]) != null;
        }
        return z6;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public boolean isSetPrint() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().find_attribute_user(PROPERTY_QNAME[45]) != null;
        }
        return z6;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public boolean isSetRegroupid() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().find_attribute_user(PROPERTY_QNAME[48]) != null;
        }
        return z6;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public boolean isSetSpid() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().find_attribute_user(PROPERTY_QNAME[46]) != null;
        }
        return z6;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public boolean isSetStyle() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().find_attribute_user(PROPERTY_QNAME[36]) != null;
        }
        return z6;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public boolean isSetTablelimits() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().find_attribute_user(PROPERTY_QNAME[73]) != null;
        }
        return z6;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public boolean isSetTableproperties() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().find_attribute_user(PROPERTY_QNAME[72]) != null;
        }
        return z6;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public boolean isSetTarget() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().find_attribute_user(PROPERTY_QNAME[38]) != null;
        }
        return z6;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public boolean isSetTitle() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().find_attribute_user(PROPERTY_QNAME[40]) != null;
        }
        return z6;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public boolean isSetUserdrawn() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().find_attribute_user(PROPERTY_QNAME[60]) != null;
        }
        return z6;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public boolean isSetUserhidden() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().find_attribute_user(PROPERTY_QNAME[51]) != null;
        }
        return z6;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public boolean isSetWrapcoords() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().find_attribute_user(PROPERTY_QNAME[44]) != null;
        }
        return z6;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void removeAnchorlock(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[16], i5);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void removeArc(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[26], i5);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void removeBorderbottom(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[18], i5);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void removeBorderleft(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[19], i5);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void removeBorderright(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[20], i5);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void removeBordertop(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[17], i5);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void removeCallout(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[11], i5);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void removeClientData(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[21], i5);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void removeClippath(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[13], i5);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void removeCurve(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[27], i5);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void removeDiagram(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[34], i5);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void removeExtrusion(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[10], i5);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void removeFill(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[3], i5);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void removeFormulas(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[1], i5);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void removeGroup(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[23], i5);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void removeHandles(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[2], i5);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void removeImage(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[28], i5);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void removeImagedata(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[8], i5);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void removeLine(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[29], i5);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void removeLock(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[12], i5);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void removeOval(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[30], i5);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void removePath(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], i5);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void removePolyline(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[31], i5);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void removeRect(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[32], i5);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void removeRoundrect(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[33], i5);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void removeShadow(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[5], i5);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void removeShape(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[24], i5);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void removeShapetype(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[25], i5);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void removeSignatureline(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[14], i5);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void removeSkew(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[9], i5);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void removeStroke(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[4], i5);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void removeTextbox(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[6], i5);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void removeTextdata(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[22], i5);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void removeTextpath(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[7], i5);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void removeWrap(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[15], i5);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setAllowincell(STTrueFalse.Enum r6) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[58]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[58]);
                }
                simpleValue.setEnumValue(r6);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setAllowoverlap(STTrueFalse.Enum r6) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[59]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[59]);
                }
                simpleValue.setEnumValue(r6);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setAlt(String str) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[41]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[41]);
                }
                simpleValue.setStringValue(str);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setAnchorlockArray(CTAnchorLock[] cTAnchorLockArr) {
        check_orphaned();
        arraySetterHelper(cTAnchorLockArr, PROPERTY_QNAME[16]);
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setArcArray(CTArc[] cTArcArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTArcArr, PROPERTY_QNAME[26]);
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setBorderbottomArray(CTBorder[] cTBorderArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTBorderArr, PROPERTY_QNAME[18]);
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setBorderbottomcolor(String str) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[63]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[63]);
                }
                simpleValue.setStringValue(str);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setBorderleftArray(CTBorder[] cTBorderArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTBorderArr, PROPERTY_QNAME[19]);
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setBorderleftcolor(String str) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[62]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[62]);
                }
                simpleValue.setStringValue(str);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setBorderrightArray(CTBorder[] cTBorderArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTBorderArr, PROPERTY_QNAME[20]);
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setBorderrightcolor(String str) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[64]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[64]);
                }
                simpleValue.setStringValue(str);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setBordertopArray(CTBorder[] cTBorderArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTBorderArr, PROPERTY_QNAME[17]);
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setBordertopcolor(String str) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[61]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[61]);
                }
                simpleValue.setStringValue(str);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setBullet(STTrueFalse.Enum r6) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[52]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[52]);
                }
                simpleValue.setEnumValue(r6);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setButton(STTrueFalse.Enum r6) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[50]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[50]);
                }
                simpleValue.setEnumValue(r6);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setCalloutArray(CTCallout[] cTCalloutArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTCalloutArr, PROPERTY_QNAME[11]);
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setClass1(String str) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[39]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[39]);
                }
                simpleValue.setStringValue(str);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setClientDataArray(CTClientData[] cTClientDataArr) {
        check_orphaned();
        arraySetterHelper(cTClientDataArr, PROPERTY_QNAME[21]);
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setClippathArray(CTClipPath[] cTClipPathArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTClipPathArr, PROPERTY_QNAME[13]);
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setCoordorigin(String str) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[43]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[43]);
                }
                simpleValue.setStringValue(str);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setCoordsize(String str) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[42]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[42]);
                }
                simpleValue.setStringValue(str);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setCurveArray(CTCurve[] cTCurveArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTCurveArr, PROPERTY_QNAME[27]);
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setDgmlayout(BigInteger bigInteger) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[65]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[65]);
                }
                simpleValue.setBigIntegerValue(bigInteger);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setDgmlayoutmru(BigInteger bigInteger) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[67]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[67]);
                }
                simpleValue.setBigIntegerValue(bigInteger);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setDgmnodekind(BigInteger bigInteger) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[66]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[66]);
                }
                simpleValue.setBigIntegerValue(bigInteger);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setDiagramArray(CTDiagram[] cTDiagramArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTDiagramArr, PROPERTY_QNAME[34]);
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setDoubleclicknotify(STTrueFalse.Enum r6) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[49]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[49]);
                }
                simpleValue.setEnumValue(r6);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setEditas(STEditAs.Enum r6) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[71]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[71]);
                }
                simpleValue.setEnumValue(r6);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setExtrusionArray(CTExtrusion[] cTExtrusionArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTExtrusionArr, PROPERTY_QNAME[10]);
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setFillArray(CTFill[] cTFillArr) {
        check_orphaned();
        arraySetterHelper(cTFillArr, PROPERTY_QNAME[3]);
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setFillcolor(String str) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[70]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[70]);
                }
                simpleValue.setStringValue(str);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setFilled(STTrueFalse.Enum r6) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[69]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[69]);
                }
                simpleValue.setEnumValue(r6);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setFormulasArray(CTFormulas[] cTFormulasArr) {
        check_orphaned();
        arraySetterHelper(cTFormulasArr, PROPERTY_QNAME[1]);
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setGroupArray(CTGroup[] cTGroupArr) {
        check_orphaned();
        arraySetterHelper(cTGroupArr, PROPERTY_QNAME[23]);
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setHandlesArray(CTHandles[] cTHandlesArr) {
        check_orphaned();
        arraySetterHelper(cTHandlesArr, PROPERTY_QNAME[2]);
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setHr(STTrueFalse.Enum r6) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[53]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[53]);
                }
                simpleValue.setEnumValue(r6);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setHralign(STHrAlign.Enum r6) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[57]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[57]);
                }
                simpleValue.setEnumValue(r6);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setHref(String str) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[37]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[37]);
                }
                simpleValue.setStringValue(str);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setHrnoshade(STTrueFalse.Enum r6) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[55]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[55]);
                }
                simpleValue.setEnumValue(r6);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setHrpct(float f6) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[56]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[56]);
                }
                simpleValue.setFloatValue(f6);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setHrstd(STTrueFalse.Enum r6) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[54]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[54]);
                }
                simpleValue.setEnumValue(r6);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setId(String str) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[35]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[35]);
                }
                simpleValue.setStringValue(str);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setImageArray(CTImage[] cTImageArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTImageArr, PROPERTY_QNAME[28]);
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setImagedataArray(CTImageData[] cTImageDataArr) {
        check_orphaned();
        arraySetterHelper(cTImageDataArr, PROPERTY_QNAME[8]);
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setInsetmode(STInsetMode.Enum r6) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[68]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[68]);
                }
                simpleValue.setEnumValue(r6);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setLineArray(CTLine[] cTLineArr) {
        check_orphaned();
        arraySetterHelper(cTLineArr, PROPERTY_QNAME[29]);
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setLockArray(CTLock[] cTLockArr) {
        check_orphaned();
        arraySetterHelper(cTLockArr, PROPERTY_QNAME[12]);
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setOned(STTrueFalse.Enum r6) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[47]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[47]);
                }
                simpleValue.setEnumValue(r6);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setOvalArray(CTOval[] cTOvalArr) {
        check_orphaned();
        arraySetterHelper(cTOvalArr, PROPERTY_QNAME[30]);
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setPathArray(CTPath[] cTPathArr) {
        check_orphaned();
        arraySetterHelper(cTPathArr, PROPERTY_QNAME[0]);
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setPolylineArray(CTPolyLine[] cTPolyLineArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTPolyLineArr, PROPERTY_QNAME[31]);
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setPrint(STTrueFalse.Enum r6) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[45]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[45]);
                }
                simpleValue.setEnumValue(r6);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setRectArray(CTRect[] cTRectArr) {
        check_orphaned();
        arraySetterHelper(cTRectArr, PROPERTY_QNAME[32]);
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setRegroupid(BigInteger bigInteger) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[48]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[48]);
                }
                simpleValue.setBigIntegerValue(bigInteger);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setRoundrectArray(CTRoundRect[] cTRoundRectArr) {
        check_orphaned();
        arraySetterHelper(cTRoundRectArr, PROPERTY_QNAME[33]);
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setShadowArray(CTShadow[] cTShadowArr) {
        check_orphaned();
        arraySetterHelper(cTShadowArr, PROPERTY_QNAME[5]);
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setShapeArray(CTShape[] cTShapeArr) {
        check_orphaned();
        arraySetterHelper(cTShapeArr, PROPERTY_QNAME[24]);
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setShapetypeArray(CTShapetype[] cTShapetypeArr) {
        check_orphaned();
        arraySetterHelper(cTShapetypeArr, PROPERTY_QNAME[25]);
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setSignaturelineArray(CTSignatureLine[] cTSignatureLineArr) {
        check_orphaned();
        arraySetterHelper(cTSignatureLineArr, PROPERTY_QNAME[14]);
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setSkewArray(CTSkew[] cTSkewArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTSkewArr, PROPERTY_QNAME[9]);
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setSpid(String str) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[46]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[46]);
                }
                simpleValue.setStringValue(str);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setStrokeArray(CTStroke[] cTStrokeArr) {
        check_orphaned();
        arraySetterHelper(cTStrokeArr, PROPERTY_QNAME[4]);
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setStyle(String str) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[36]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[36]);
                }
                simpleValue.setStringValue(str);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setTablelimits(String str) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[73]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[73]);
                }
                simpleValue.setStringValue(str);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setTableproperties(String str) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[72]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[72]);
                }
                simpleValue.setStringValue(str);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setTarget(String str) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[38]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[38]);
                }
                simpleValue.setStringValue(str);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setTextboxArray(CTTextbox[] cTTextboxArr) {
        check_orphaned();
        arraySetterHelper(cTTextboxArr, PROPERTY_QNAME[6]);
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setTextdataArray(CTRel[] cTRelArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTRelArr, PROPERTY_QNAME[22]);
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setTextpathArray(CTTextPath[] cTTextPathArr) {
        check_orphaned();
        arraySetterHelper(cTTextPathArr, PROPERTY_QNAME[7]);
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setTitle(String str) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[40]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[40]);
                }
                simpleValue.setStringValue(str);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setUserdrawn(STTrueFalse.Enum r6) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[60]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[60]);
                }
                simpleValue.setEnumValue(r6);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setUserhidden(STTrueFalse.Enum r6) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[51]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[51]);
                }
                simpleValue.setEnumValue(r6);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setWrapArray(CTWrap[] cTWrapArr) {
        check_orphaned();
        arraySetterHelper(cTWrapArr, PROPERTY_QNAME[15]);
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setWrapcoords(String str) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[44]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[44]);
                }
                simpleValue.setStringValue(str);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public int sizeOfAnchorlockArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[16]);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public int sizeOfArcArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[26]);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public int sizeOfBorderbottomArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[18]);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public int sizeOfBorderleftArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[19]);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public int sizeOfBorderrightArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[20]);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public int sizeOfBordertopArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[17]);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public int sizeOfCalloutArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[11]);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public int sizeOfClientDataArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[21]);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public int sizeOfClippathArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[13]);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public int sizeOfCurveArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[27]);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public int sizeOfDiagramArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[34]);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public int sizeOfExtrusionArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[10]);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public int sizeOfFillArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[3]);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public int sizeOfFormulasArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[1]);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public int sizeOfGroupArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[23]);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public int sizeOfHandlesArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[2]);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public int sizeOfImageArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[28]);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public int sizeOfImagedataArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[8]);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public int sizeOfLineArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[29]);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public int sizeOfLockArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[12]);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public int sizeOfOvalArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[30]);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public int sizeOfPathArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[0]);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public int sizeOfPolylineArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[31]);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public int sizeOfRectArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[32]);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public int sizeOfRoundrectArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[33]);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public int sizeOfShadowArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[5]);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public int sizeOfShapeArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[24]);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public int sizeOfShapetypeArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[25]);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public int sizeOfSignaturelineArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[14]);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public int sizeOfSkewArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[9]);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public int sizeOfStrokeArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[4]);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public int sizeOfTextboxArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[6]);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public int sizeOfTextdataArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[22]);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public int sizeOfTextpathArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[7]);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public int sizeOfWrapArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[15]);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void unsetAllowincell() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[58]);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void unsetAllowoverlap() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[59]);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void unsetAlt() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[41]);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void unsetBorderbottomcolor() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[63]);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void unsetBorderleftcolor() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[62]);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void unsetBorderrightcolor() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[64]);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void unsetBordertopcolor() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[61]);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void unsetBullet() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[52]);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void unsetButton() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[50]);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void unsetClass1() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[39]);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void unsetCoordorigin() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[43]);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void unsetCoordsize() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[42]);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void unsetDgmlayout() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[65]);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void unsetDgmlayoutmru() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[67]);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void unsetDgmnodekind() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[66]);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void unsetDoubleclicknotify() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[49]);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void unsetEditas() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[71]);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void unsetFillcolor() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[70]);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void unsetFilled() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[69]);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void unsetHr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[53]);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void unsetHralign() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[57]);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void unsetHref() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[37]);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void unsetHrnoshade() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[55]);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void unsetHrpct() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[56]);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void unsetHrstd() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[54]);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void unsetId() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[35]);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void unsetInsetmode() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[68]);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void unsetOned() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[47]);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void unsetPrint() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[45]);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void unsetRegroupid() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[48]);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void unsetSpid() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[46]);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void unsetStyle() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[36]);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void unsetTablelimits() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[73]);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void unsetTableproperties() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[72]);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void unsetTarget() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[38]);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void unsetTitle() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[40]);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void unsetUserdrawn() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[60]);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void unsetUserhidden() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[51]);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void unsetWrapcoords() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[44]);
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public STTrueFalse xgetAllowincell() {
        STTrueFalse sTTrueFalse;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalse = (STTrueFalse) get_store().find_attribute_user(PROPERTY_QNAME[58]);
        }
        return sTTrueFalse;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public STTrueFalse xgetAllowoverlap() {
        STTrueFalse sTTrueFalse;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalse = (STTrueFalse) get_store().find_attribute_user(PROPERTY_QNAME[59]);
        }
        return sTTrueFalse;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public XmlString xgetAlt() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_attribute_user(PROPERTY_QNAME[41]);
        }
        return xmlString;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public XmlString xgetBorderbottomcolor() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_attribute_user(PROPERTY_QNAME[63]);
        }
        return xmlString;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public XmlString xgetBorderleftcolor() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_attribute_user(PROPERTY_QNAME[62]);
        }
        return xmlString;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public XmlString xgetBorderrightcolor() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_attribute_user(PROPERTY_QNAME[64]);
        }
        return xmlString;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public XmlString xgetBordertopcolor() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_attribute_user(PROPERTY_QNAME[61]);
        }
        return xmlString;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public STTrueFalse xgetBullet() {
        STTrueFalse sTTrueFalse;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalse = (STTrueFalse) get_store().find_attribute_user(PROPERTY_QNAME[52]);
        }
        return sTTrueFalse;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public STTrueFalse xgetButton() {
        STTrueFalse sTTrueFalse;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalse = (STTrueFalse) get_store().find_attribute_user(PROPERTY_QNAME[50]);
        }
        return sTTrueFalse;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public XmlString xgetClass1() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_attribute_user(PROPERTY_QNAME[39]);
        }
        return xmlString;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public XmlString xgetCoordorigin() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_attribute_user(PROPERTY_QNAME[43]);
        }
        return xmlString;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public XmlString xgetCoordsize() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_attribute_user(PROPERTY_QNAME[42]);
        }
        return xmlString;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public STDiagramLayout xgetDgmlayout() {
        STDiagramLayout sTDiagramLayoutFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTDiagramLayoutFind_attribute_user = get_store().find_attribute_user(PROPERTY_QNAME[65]);
        }
        return sTDiagramLayoutFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public STDiagramLayout xgetDgmlayoutmru() {
        STDiagramLayout sTDiagramLayoutFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTDiagramLayoutFind_attribute_user = get_store().find_attribute_user(PROPERTY_QNAME[67]);
        }
        return sTDiagramLayoutFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public XmlInteger xgetDgmnodekind() {
        XmlInteger xmlInteger;
        synchronized (monitor()) {
            check_orphaned();
            xmlInteger = (XmlInteger) get_store().find_attribute_user(PROPERTY_QNAME[66]);
        }
        return xmlInteger;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public STTrueFalse xgetDoubleclicknotify() {
        STTrueFalse sTTrueFalse;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalse = (STTrueFalse) get_store().find_attribute_user(PROPERTY_QNAME[49]);
        }
        return sTTrueFalse;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public STEditAs xgetEditas() {
        STEditAs sTEditAs;
        synchronized (monitor()) {
            check_orphaned();
            sTEditAs = (STEditAs) get_store().find_attribute_user(PROPERTY_QNAME[71]);
        }
        return sTEditAs;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public STColorType xgetFillcolor() {
        STColorType sTColorType;
        synchronized (monitor()) {
            check_orphaned();
            sTColorType = (STColorType) get_store().find_attribute_user(PROPERTY_QNAME[70]);
        }
        return sTColorType;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public STTrueFalse xgetFilled() {
        STTrueFalse sTTrueFalse;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalse = (STTrueFalse) get_store().find_attribute_user(PROPERTY_QNAME[69]);
        }
        return sTTrueFalse;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public STTrueFalse xgetHr() {
        STTrueFalse sTTrueFalse;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalse = (STTrueFalse) get_store().find_attribute_user(PROPERTY_QNAME[53]);
        }
        return sTTrueFalse;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public STHrAlign xgetHralign() {
        STHrAlign sTHrAlign;
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                sTHrAlign = (STHrAlign) typeStore.find_attribute_user(qNameArr[57]);
                if (sTHrAlign == null) {
                    sTHrAlign = (STHrAlign) get_default_attribute_value(qNameArr[57]);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return sTHrAlign;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public XmlString xgetHref() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_attribute_user(PROPERTY_QNAME[37]);
        }
        return xmlString;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public STTrueFalse xgetHrnoshade() {
        STTrueFalse sTTrueFalse;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalse = (STTrueFalse) get_store().find_attribute_user(PROPERTY_QNAME[55]);
        }
        return sTTrueFalse;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public XmlFloat xgetHrpct() {
        XmlFloat xmlFloat;
        synchronized (monitor()) {
            check_orphaned();
            xmlFloat = (XmlFloat) get_store().find_attribute_user(PROPERTY_QNAME[56]);
        }
        return xmlFloat;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public STTrueFalse xgetHrstd() {
        STTrueFalse sTTrueFalse;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalse = (STTrueFalse) get_store().find_attribute_user(PROPERTY_QNAME[54]);
        }
        return sTTrueFalse;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public XmlString xgetId() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_attribute_user(PROPERTY_QNAME[35]);
        }
        return xmlString;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public STInsetMode xgetInsetmode() {
        STInsetMode sTInsetMode;
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                sTInsetMode = (STInsetMode) typeStore.find_attribute_user(qNameArr[68]);
                if (sTInsetMode == null) {
                    sTInsetMode = (STInsetMode) get_default_attribute_value(qNameArr[68]);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return sTInsetMode;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public STTrueFalse xgetOned() {
        STTrueFalse sTTrueFalse;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalse = (STTrueFalse) get_store().find_attribute_user(PROPERTY_QNAME[47]);
        }
        return sTTrueFalse;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public STTrueFalse xgetPrint() {
        STTrueFalse sTTrueFalse;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalse = (STTrueFalse) get_store().find_attribute_user(PROPERTY_QNAME[45]);
        }
        return sTTrueFalse;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public XmlInteger xgetRegroupid() {
        XmlInteger xmlInteger;
        synchronized (monitor()) {
            check_orphaned();
            xmlInteger = (XmlInteger) get_store().find_attribute_user(PROPERTY_QNAME[48]);
        }
        return xmlInteger;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public XmlString xgetSpid() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_attribute_user(PROPERTY_QNAME[46]);
        }
        return xmlString;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public XmlString xgetStyle() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_attribute_user(PROPERTY_QNAME[36]);
        }
        return xmlString;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public XmlString xgetTablelimits() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_attribute_user(PROPERTY_QNAME[73]);
        }
        return xmlString;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public XmlString xgetTableproperties() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_attribute_user(PROPERTY_QNAME[72]);
        }
        return xmlString;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public XmlString xgetTarget() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_attribute_user(PROPERTY_QNAME[38]);
        }
        return xmlString;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public XmlString xgetTitle() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_attribute_user(PROPERTY_QNAME[40]);
        }
        return xmlString;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public STTrueFalse xgetUserdrawn() {
        STTrueFalse sTTrueFalse;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalse = (STTrueFalse) get_store().find_attribute_user(PROPERTY_QNAME[60]);
        }
        return sTTrueFalse;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public STTrueFalse xgetUserhidden() {
        STTrueFalse sTTrueFalse;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalse = (STTrueFalse) get_store().find_attribute_user(PROPERTY_QNAME[51]);
        }
        return sTTrueFalse;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public XmlString xgetWrapcoords() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_attribute_user(PROPERTY_QNAME[44]);
        }
        return xmlString;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void xsetAllowincell(STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                STTrueFalse sTTrueFalse2 = (STTrueFalse) typeStore.find_attribute_user(qNameArr[58]);
                if (sTTrueFalse2 == null) {
                    sTTrueFalse2 = (STTrueFalse) get_store().add_attribute_user(qNameArr[58]);
                }
                sTTrueFalse2.set(sTTrueFalse);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void xsetAllowoverlap(STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                STTrueFalse sTTrueFalse2 = (STTrueFalse) typeStore.find_attribute_user(qNameArr[59]);
                if (sTTrueFalse2 == null) {
                    sTTrueFalse2 = (STTrueFalse) get_store().add_attribute_user(qNameArr[59]);
                }
                sTTrueFalse2.set(sTTrueFalse);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void xsetAlt(XmlString xmlString) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qNameArr[41]);
                if (xmlString2 == null) {
                    xmlString2 = (XmlString) get_store().add_attribute_user(qNameArr[41]);
                }
                xmlString2.set(xmlString);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void xsetBorderbottomcolor(XmlString xmlString) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qNameArr[63]);
                if (xmlString2 == null) {
                    xmlString2 = (XmlString) get_store().add_attribute_user(qNameArr[63]);
                }
                xmlString2.set(xmlString);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void xsetBorderleftcolor(XmlString xmlString) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qNameArr[62]);
                if (xmlString2 == null) {
                    xmlString2 = (XmlString) get_store().add_attribute_user(qNameArr[62]);
                }
                xmlString2.set(xmlString);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void xsetBorderrightcolor(XmlString xmlString) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qNameArr[64]);
                if (xmlString2 == null) {
                    xmlString2 = (XmlString) get_store().add_attribute_user(qNameArr[64]);
                }
                xmlString2.set(xmlString);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void xsetBordertopcolor(XmlString xmlString) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qNameArr[61]);
                if (xmlString2 == null) {
                    xmlString2 = (XmlString) get_store().add_attribute_user(qNameArr[61]);
                }
                xmlString2.set(xmlString);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void xsetBullet(STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                STTrueFalse sTTrueFalse2 = (STTrueFalse) typeStore.find_attribute_user(qNameArr[52]);
                if (sTTrueFalse2 == null) {
                    sTTrueFalse2 = (STTrueFalse) get_store().add_attribute_user(qNameArr[52]);
                }
                sTTrueFalse2.set(sTTrueFalse);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void xsetButton(STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                STTrueFalse sTTrueFalse2 = (STTrueFalse) typeStore.find_attribute_user(qNameArr[50]);
                if (sTTrueFalse2 == null) {
                    sTTrueFalse2 = (STTrueFalse) get_store().add_attribute_user(qNameArr[50]);
                }
                sTTrueFalse2.set(sTTrueFalse);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void xsetClass1(XmlString xmlString) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qNameArr[39]);
                if (xmlString2 == null) {
                    xmlString2 = (XmlString) get_store().add_attribute_user(qNameArr[39]);
                }
                xmlString2.set(xmlString);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void xsetCoordorigin(XmlString xmlString) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qNameArr[43]);
                if (xmlString2 == null) {
                    xmlString2 = (XmlString) get_store().add_attribute_user(qNameArr[43]);
                }
                xmlString2.set(xmlString);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void xsetCoordsize(XmlString xmlString) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qNameArr[42]);
                if (xmlString2 == null) {
                    xmlString2 = (XmlString) get_store().add_attribute_user(qNameArr[42]);
                }
                xmlString2.set(xmlString);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void xsetDgmlayout(STDiagramLayout sTDiagramLayout) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                STDiagramLayout sTDiagramLayoutFind_attribute_user = typeStore.find_attribute_user(qNameArr[65]);
                if (sTDiagramLayoutFind_attribute_user == null) {
                    sTDiagramLayoutFind_attribute_user = (STDiagramLayout) get_store().add_attribute_user(qNameArr[65]);
                }
                sTDiagramLayoutFind_attribute_user.set(sTDiagramLayout);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void xsetDgmlayoutmru(STDiagramLayout sTDiagramLayout) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                STDiagramLayout sTDiagramLayoutFind_attribute_user = typeStore.find_attribute_user(qNameArr[67]);
                if (sTDiagramLayoutFind_attribute_user == null) {
                    sTDiagramLayoutFind_attribute_user = (STDiagramLayout) get_store().add_attribute_user(qNameArr[67]);
                }
                sTDiagramLayoutFind_attribute_user.set(sTDiagramLayout);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void xsetDgmnodekind(XmlInteger xmlInteger) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                XmlInteger xmlInteger2 = (XmlInteger) typeStore.find_attribute_user(qNameArr[66]);
                if (xmlInteger2 == null) {
                    xmlInteger2 = (XmlInteger) get_store().add_attribute_user(qNameArr[66]);
                }
                xmlInteger2.set(xmlInteger);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void xsetDoubleclicknotify(STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                STTrueFalse sTTrueFalse2 = (STTrueFalse) typeStore.find_attribute_user(qNameArr[49]);
                if (sTTrueFalse2 == null) {
                    sTTrueFalse2 = (STTrueFalse) get_store().add_attribute_user(qNameArr[49]);
                }
                sTTrueFalse2.set(sTTrueFalse);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void xsetEditas(STEditAs sTEditAs) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                STEditAs sTEditAs2 = (STEditAs) typeStore.find_attribute_user(qNameArr[71]);
                if (sTEditAs2 == null) {
                    sTEditAs2 = (STEditAs) get_store().add_attribute_user(qNameArr[71]);
                }
                sTEditAs2.set(sTEditAs);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void xsetFillcolor(STColorType sTColorType) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                STColorType sTColorType2 = (STColorType) typeStore.find_attribute_user(qNameArr[70]);
                if (sTColorType2 == null) {
                    sTColorType2 = (STColorType) get_store().add_attribute_user(qNameArr[70]);
                }
                sTColorType2.set(sTColorType);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void xsetFilled(STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                STTrueFalse sTTrueFalse2 = (STTrueFalse) typeStore.find_attribute_user(qNameArr[69]);
                if (sTTrueFalse2 == null) {
                    sTTrueFalse2 = (STTrueFalse) get_store().add_attribute_user(qNameArr[69]);
                }
                sTTrueFalse2.set(sTTrueFalse);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void xsetHr(STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                STTrueFalse sTTrueFalse2 = (STTrueFalse) typeStore.find_attribute_user(qNameArr[53]);
                if (sTTrueFalse2 == null) {
                    sTTrueFalse2 = (STTrueFalse) get_store().add_attribute_user(qNameArr[53]);
                }
                sTTrueFalse2.set(sTTrueFalse);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void xsetHralign(STHrAlign sTHrAlign) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                STHrAlign sTHrAlign2 = (STHrAlign) typeStore.find_attribute_user(qNameArr[57]);
                if (sTHrAlign2 == null) {
                    sTHrAlign2 = (STHrAlign) get_store().add_attribute_user(qNameArr[57]);
                }
                sTHrAlign2.set(sTHrAlign);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void xsetHref(XmlString xmlString) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qNameArr[37]);
                if (xmlString2 == null) {
                    xmlString2 = (XmlString) get_store().add_attribute_user(qNameArr[37]);
                }
                xmlString2.set(xmlString);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void xsetHrnoshade(STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                STTrueFalse sTTrueFalse2 = (STTrueFalse) typeStore.find_attribute_user(qNameArr[55]);
                if (sTTrueFalse2 == null) {
                    sTTrueFalse2 = (STTrueFalse) get_store().add_attribute_user(qNameArr[55]);
                }
                sTTrueFalse2.set(sTTrueFalse);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void xsetHrpct(XmlFloat xmlFloat) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                XmlFloat xmlFloat2 = (XmlFloat) typeStore.find_attribute_user(qNameArr[56]);
                if (xmlFloat2 == null) {
                    xmlFloat2 = (XmlFloat) get_store().add_attribute_user(qNameArr[56]);
                }
                xmlFloat2.set(xmlFloat);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void xsetHrstd(STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                STTrueFalse sTTrueFalse2 = (STTrueFalse) typeStore.find_attribute_user(qNameArr[54]);
                if (sTTrueFalse2 == null) {
                    sTTrueFalse2 = (STTrueFalse) get_store().add_attribute_user(qNameArr[54]);
                }
                sTTrueFalse2.set(sTTrueFalse);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void xsetId(XmlString xmlString) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qNameArr[35]);
                if (xmlString2 == null) {
                    xmlString2 = (XmlString) get_store().add_attribute_user(qNameArr[35]);
                }
                xmlString2.set(xmlString);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void xsetInsetmode(STInsetMode sTInsetMode) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                STInsetMode sTInsetMode2 = (STInsetMode) typeStore.find_attribute_user(qNameArr[68]);
                if (sTInsetMode2 == null) {
                    sTInsetMode2 = (STInsetMode) get_store().add_attribute_user(qNameArr[68]);
                }
                sTInsetMode2.set(sTInsetMode);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void xsetOned(STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                STTrueFalse sTTrueFalse2 = (STTrueFalse) typeStore.find_attribute_user(qNameArr[47]);
                if (sTTrueFalse2 == null) {
                    sTTrueFalse2 = (STTrueFalse) get_store().add_attribute_user(qNameArr[47]);
                }
                sTTrueFalse2.set(sTTrueFalse);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void xsetPrint(STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                STTrueFalse sTTrueFalse2 = (STTrueFalse) typeStore.find_attribute_user(qNameArr[45]);
                if (sTTrueFalse2 == null) {
                    sTTrueFalse2 = (STTrueFalse) get_store().add_attribute_user(qNameArr[45]);
                }
                sTTrueFalse2.set(sTTrueFalse);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void xsetRegroupid(XmlInteger xmlInteger) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                XmlInteger xmlInteger2 = (XmlInteger) typeStore.find_attribute_user(qNameArr[48]);
                if (xmlInteger2 == null) {
                    xmlInteger2 = (XmlInteger) get_store().add_attribute_user(qNameArr[48]);
                }
                xmlInteger2.set(xmlInteger);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void xsetSpid(XmlString xmlString) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qNameArr[46]);
                if (xmlString2 == null) {
                    xmlString2 = (XmlString) get_store().add_attribute_user(qNameArr[46]);
                }
                xmlString2.set(xmlString);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void xsetStyle(XmlString xmlString) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qNameArr[36]);
                if (xmlString2 == null) {
                    xmlString2 = (XmlString) get_store().add_attribute_user(qNameArr[36]);
                }
                xmlString2.set(xmlString);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void xsetTablelimits(XmlString xmlString) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qNameArr[73]);
                if (xmlString2 == null) {
                    xmlString2 = (XmlString) get_store().add_attribute_user(qNameArr[73]);
                }
                xmlString2.set(xmlString);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void xsetTableproperties(XmlString xmlString) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qNameArr[72]);
                if (xmlString2 == null) {
                    xmlString2 = (XmlString) get_store().add_attribute_user(qNameArr[72]);
                }
                xmlString2.set(xmlString);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void xsetTarget(XmlString xmlString) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qNameArr[38]);
                if (xmlString2 == null) {
                    xmlString2 = (XmlString) get_store().add_attribute_user(qNameArr[38]);
                }
                xmlString2.set(xmlString);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void xsetTitle(XmlString xmlString) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qNameArr[40]);
                if (xmlString2 == null) {
                    xmlString2 = (XmlString) get_store().add_attribute_user(qNameArr[40]);
                }
                xmlString2.set(xmlString);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void xsetUserdrawn(STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                STTrueFalse sTTrueFalse2 = (STTrueFalse) typeStore.find_attribute_user(qNameArr[60]);
                if (sTTrueFalse2 == null) {
                    sTTrueFalse2 = (STTrueFalse) get_store().add_attribute_user(qNameArr[60]);
                }
                sTTrueFalse2.set(sTTrueFalse);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void xsetUserhidden(STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                STTrueFalse sTTrueFalse2 = (STTrueFalse) typeStore.find_attribute_user(qNameArr[51]);
                if (sTTrueFalse2 == null) {
                    sTTrueFalse2 = (STTrueFalse) get_store().add_attribute_user(qNameArr[51]);
                }
                sTTrueFalse2.set(sTTrueFalse);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void xsetWrapcoords(XmlString xmlString) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qNameArr[44]);
                if (xmlString2 == null) {
                    xmlString2 = (XmlString) get_store().add_attribute_user(qNameArr[44]);
                }
                xmlString2.set(xmlString);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTAnchorLock getAnchorlockArray(int i5) {
        CTAnchorLock cTAnchorLock;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTAnchorLock = (CTAnchorLock) get_store().find_element_user(PROPERTY_QNAME[16], i5);
                if (cTAnchorLock == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTAnchorLock;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTArc getArcArray(int i5) {
        CTArc cTArcFind_element_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTArcFind_element_user = get_store().find_element_user(PROPERTY_QNAME[26], i5);
                if (cTArcFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTArcFind_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTBorder getBorderbottomArray(int i5) {
        CTBorder cTBorderFind_element_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTBorderFind_element_user = get_store().find_element_user(PROPERTY_QNAME[18], i5);
                if (cTBorderFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTBorderFind_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTBorder getBorderleftArray(int i5) {
        CTBorder cTBorderFind_element_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTBorderFind_element_user = get_store().find_element_user(PROPERTY_QNAME[19], i5);
                if (cTBorderFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTBorderFind_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTBorder getBorderrightArray(int i5) {
        CTBorder cTBorderFind_element_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTBorderFind_element_user = get_store().find_element_user(PROPERTY_QNAME[20], i5);
                if (cTBorderFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTBorderFind_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTBorder getBordertopArray(int i5) {
        CTBorder cTBorderFind_element_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTBorderFind_element_user = get_store().find_element_user(PROPERTY_QNAME[17], i5);
                if (cTBorderFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTBorderFind_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTCallout getCalloutArray(int i5) {
        CTCallout cTCalloutFind_element_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTCalloutFind_element_user = get_store().find_element_user(PROPERTY_QNAME[11], i5);
                if (cTCalloutFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTCalloutFind_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTClientData getClientDataArray(int i5) {
        CTClientData cTClientData;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTClientData = (CTClientData) get_store().find_element_user(PROPERTY_QNAME[21], i5);
                if (cTClientData == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTClientData;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTClipPath getClippathArray(int i5) {
        CTClipPath cTClipPathFind_element_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTClipPathFind_element_user = get_store().find_element_user(PROPERTY_QNAME[13], i5);
                if (cTClipPathFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTClipPathFind_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTCurve getCurveArray(int i5) {
        CTCurve cTCurveFind_element_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTCurveFind_element_user = get_store().find_element_user(PROPERTY_QNAME[27], i5);
                if (cTCurveFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTCurveFind_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTDiagram getDiagramArray(int i5) {
        CTDiagram cTDiagramFind_element_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTDiagramFind_element_user = get_store().find_element_user(PROPERTY_QNAME[34], i5);
                if (cTDiagramFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTDiagramFind_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTExtrusion getExtrusionArray(int i5) {
        CTExtrusion cTExtrusionFind_element_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTExtrusionFind_element_user = get_store().find_element_user(PROPERTY_QNAME[10], i5);
                if (cTExtrusionFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTExtrusionFind_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTFill getFillArray(int i5) {
        CTFill cTFill;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTFill = (CTFill) get_store().find_element_user(PROPERTY_QNAME[3], i5);
                if (cTFill == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTFill;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTFormulas getFormulasArray(int i5) {
        CTFormulas cTFormulas;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTFormulas = (CTFormulas) get_store().find_element_user(PROPERTY_QNAME[1], i5);
                if (cTFormulas == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTFormulas;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTGroup getGroupArray(int i5) {
        CTGroup cTGroup;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTGroup = (CTGroup) get_store().find_element_user(PROPERTY_QNAME[23], i5);
                if (cTGroup == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTGroup;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTHandles getHandlesArray(int i5) {
        CTHandles cTHandles;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTHandles = (CTHandles) get_store().find_element_user(PROPERTY_QNAME[2], i5);
                if (cTHandles == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTHandles;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTImage getImageArray(int i5) {
        CTImage cTImageFind_element_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTImageFind_element_user = get_store().find_element_user(PROPERTY_QNAME[28], i5);
                if (cTImageFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTImageFind_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTImageData getImagedataArray(int i5) {
        CTImageData cTImageData;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTImageData = (CTImageData) get_store().find_element_user(PROPERTY_QNAME[8], i5);
                if (cTImageData == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTImageData;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTLine getLineArray(int i5) {
        CTLine cTLine;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTLine = (CTLine) get_store().find_element_user(PROPERTY_QNAME[29], i5);
                if (cTLine == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTLine;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTLock getLockArray(int i5) {
        CTLock cTLock;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTLock = (CTLock) get_store().find_element_user(PROPERTY_QNAME[12], i5);
                if (cTLock == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTLock;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTOval getOvalArray(int i5) {
        CTOval cTOval;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTOval = (CTOval) get_store().find_element_user(PROPERTY_QNAME[30], i5);
                if (cTOval == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTOval;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTPath getPathArray(int i5) {
        CTPath cTPath;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTPath = (CTPath) get_store().find_element_user(PROPERTY_QNAME[0], i5);
                if (cTPath == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTPath;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTPolyLine getPolylineArray(int i5) {
        CTPolyLine cTPolyLineFind_element_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTPolyLineFind_element_user = get_store().find_element_user(PROPERTY_QNAME[31], i5);
                if (cTPolyLineFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTPolyLineFind_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTRect getRectArray(int i5) {
        CTRect cTRect;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTRect = (CTRect) get_store().find_element_user(PROPERTY_QNAME[32], i5);
                if (cTRect == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTRect;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTRoundRect getRoundrectArray(int i5) {
        CTRoundRect cTRoundRect;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTRoundRect = (CTRoundRect) get_store().find_element_user(PROPERTY_QNAME[33], i5);
                if (cTRoundRect == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTRoundRect;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTShadow getShadowArray(int i5) {
        CTShadow cTShadow;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTShadow = (CTShadow) get_store().find_element_user(PROPERTY_QNAME[5], i5);
                if (cTShadow == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTShadow;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTShape getShapeArray(int i5) {
        CTShape cTShape;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTShape = (CTShape) get_store().find_element_user(PROPERTY_QNAME[24], i5);
                if (cTShape == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTShape;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTShapetype getShapetypeArray(int i5) {
        CTShapetype cTShapetype;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTShapetype = (CTShapetype) get_store().find_element_user(PROPERTY_QNAME[25], i5);
                if (cTShapetype == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTShapetype;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTSignatureLine getSignaturelineArray(int i5) {
        CTSignatureLine cTSignatureLine;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTSignatureLine = (CTSignatureLine) get_store().find_element_user(PROPERTY_QNAME[14], i5);
                if (cTSignatureLine == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTSignatureLine;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTSkew getSkewArray(int i5) {
        CTSkew cTSkewFind_element_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTSkewFind_element_user = get_store().find_element_user(PROPERTY_QNAME[9], i5);
                if (cTSkewFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTSkewFind_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTStroke getStrokeArray(int i5) {
        CTStroke cTStroke;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTStroke = (CTStroke) get_store().find_element_user(PROPERTY_QNAME[4], i5);
                if (cTStroke == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTStroke;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTTextbox getTextboxArray(int i5) {
        CTTextbox cTTextbox;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTTextbox = (CTTextbox) get_store().find_element_user(PROPERTY_QNAME[6], i5);
                if (cTTextbox == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTTextbox;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTRel getTextdataArray(int i5) {
        CTRel cTRelFind_element_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTRelFind_element_user = get_store().find_element_user(PROPERTY_QNAME[22], i5);
                if (cTRelFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTRelFind_element_user;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTTextPath getTextpathArray(int i5) {
        CTTextPath cTTextPath;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTTextPath = (CTTextPath) get_store().find_element_user(PROPERTY_QNAME[7], i5);
                if (cTTextPath == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTTextPath;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public CTWrap getWrapArray(int i5) {
        CTWrap cTWrap;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTWrap = (CTWrap) get_store().find_element_user(PROPERTY_QNAME[15], i5);
                if (cTWrap == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTWrap;
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setAnchorlockArray(int i5, CTAnchorLock cTAnchorLock) {
        generatedSetterHelperImpl(cTAnchorLock, PROPERTY_QNAME[16], i5, (short) 2);
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setArcArray(int i5, CTArc cTArc) {
        generatedSetterHelperImpl(cTArc, PROPERTY_QNAME[26], i5, (short) 2);
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setBorderbottomArray(int i5, CTBorder cTBorder) {
        generatedSetterHelperImpl(cTBorder, PROPERTY_QNAME[18], i5, (short) 2);
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setBorderleftArray(int i5, CTBorder cTBorder) {
        generatedSetterHelperImpl(cTBorder, PROPERTY_QNAME[19], i5, (short) 2);
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setBorderrightArray(int i5, CTBorder cTBorder) {
        generatedSetterHelperImpl(cTBorder, PROPERTY_QNAME[20], i5, (short) 2);
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setBordertopArray(int i5, CTBorder cTBorder) {
        generatedSetterHelperImpl(cTBorder, PROPERTY_QNAME[17], i5, (short) 2);
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setCalloutArray(int i5, CTCallout cTCallout) {
        generatedSetterHelperImpl(cTCallout, PROPERTY_QNAME[11], i5, (short) 2);
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setClientDataArray(int i5, CTClientData cTClientData) {
        generatedSetterHelperImpl(cTClientData, PROPERTY_QNAME[21], i5, (short) 2);
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setClippathArray(int i5, CTClipPath cTClipPath) {
        generatedSetterHelperImpl(cTClipPath, PROPERTY_QNAME[13], i5, (short) 2);
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setCurveArray(int i5, CTCurve cTCurve) {
        generatedSetterHelperImpl(cTCurve, PROPERTY_QNAME[27], i5, (short) 2);
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setDiagramArray(int i5, CTDiagram cTDiagram) {
        generatedSetterHelperImpl(cTDiagram, PROPERTY_QNAME[34], i5, (short) 2);
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setExtrusionArray(int i5, CTExtrusion cTExtrusion) {
        generatedSetterHelperImpl(cTExtrusion, PROPERTY_QNAME[10], i5, (short) 2);
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setFillArray(int i5, CTFill cTFill) {
        generatedSetterHelperImpl(cTFill, PROPERTY_QNAME[3], i5, (short) 2);
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setFormulasArray(int i5, CTFormulas cTFormulas) {
        generatedSetterHelperImpl(cTFormulas, PROPERTY_QNAME[1], i5, (short) 2);
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setGroupArray(int i5, CTGroup cTGroup) {
        generatedSetterHelperImpl(cTGroup, PROPERTY_QNAME[23], i5, (short) 2);
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setHandlesArray(int i5, CTHandles cTHandles) {
        generatedSetterHelperImpl(cTHandles, PROPERTY_QNAME[2], i5, (short) 2);
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setImageArray(int i5, CTImage cTImage) {
        generatedSetterHelperImpl(cTImage, PROPERTY_QNAME[28], i5, (short) 2);
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setImagedataArray(int i5, CTImageData cTImageData) {
        generatedSetterHelperImpl(cTImageData, PROPERTY_QNAME[8], i5, (short) 2);
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setLineArray(int i5, CTLine cTLine) {
        generatedSetterHelperImpl(cTLine, PROPERTY_QNAME[29], i5, (short) 2);
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setLockArray(int i5, CTLock cTLock) {
        generatedSetterHelperImpl(cTLock, PROPERTY_QNAME[12], i5, (short) 2);
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setOvalArray(int i5, CTOval cTOval) {
        generatedSetterHelperImpl(cTOval, PROPERTY_QNAME[30], i5, (short) 2);
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setPathArray(int i5, CTPath cTPath) {
        generatedSetterHelperImpl(cTPath, PROPERTY_QNAME[0], i5, (short) 2);
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setPolylineArray(int i5, CTPolyLine cTPolyLine) {
        generatedSetterHelperImpl(cTPolyLine, PROPERTY_QNAME[31], i5, (short) 2);
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setRectArray(int i5, CTRect cTRect) {
        generatedSetterHelperImpl(cTRect, PROPERTY_QNAME[32], i5, (short) 2);
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setRoundrectArray(int i5, CTRoundRect cTRoundRect) {
        generatedSetterHelperImpl(cTRoundRect, PROPERTY_QNAME[33], i5, (short) 2);
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setShadowArray(int i5, CTShadow cTShadow) {
        generatedSetterHelperImpl(cTShadow, PROPERTY_QNAME[5], i5, (short) 2);
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setShapeArray(int i5, CTShape cTShape) {
        generatedSetterHelperImpl(cTShape, PROPERTY_QNAME[24], i5, (short) 2);
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setShapetypeArray(int i5, CTShapetype cTShapetype) {
        generatedSetterHelperImpl(cTShapetype, PROPERTY_QNAME[25], i5, (short) 2);
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setSignaturelineArray(int i5, CTSignatureLine cTSignatureLine) {
        generatedSetterHelperImpl(cTSignatureLine, PROPERTY_QNAME[14], i5, (short) 2);
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setSkewArray(int i5, CTSkew cTSkew) {
        generatedSetterHelperImpl(cTSkew, PROPERTY_QNAME[9], i5, (short) 2);
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setStrokeArray(int i5, CTStroke cTStroke) {
        generatedSetterHelperImpl(cTStroke, PROPERTY_QNAME[4], i5, (short) 2);
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setTextboxArray(int i5, CTTextbox cTTextbox) {
        generatedSetterHelperImpl(cTTextbox, PROPERTY_QNAME[6], i5, (short) 2);
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setTextdataArray(int i5, CTRel cTRel) {
        generatedSetterHelperImpl(cTRel, PROPERTY_QNAME[22], i5, (short) 2);
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setTextpathArray(int i5, CTTextPath cTTextPath) {
        generatedSetterHelperImpl(cTTextPath, PROPERTY_QNAME[7], i5, (short) 2);
    }

    @Override // com.microsoft.schemas.vml.CTGroup
    public void setWrapArray(int i5, CTWrap cTWrap) {
        generatedSetterHelperImpl(cTWrap, PROPERTY_QNAME[15], i5, (short) 2);
    }
}
