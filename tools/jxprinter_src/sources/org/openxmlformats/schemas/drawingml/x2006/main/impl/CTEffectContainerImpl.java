package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import java.util.List;
import java.util.function.BiConsumer;
import javax.xml.namespace.QName;
import l5.C1165b0;
import l5.C1183h0;
import l5.I;
import l5.K;
import l5.L;
import org.apache.poi.xssf.usermodel.XSSFRelation;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlToken;
import org.apache.xmlbeans.impl.values.JavaListXmlObject;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTAlphaBiLevelEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTAlphaCeilingEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTAlphaFloorEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTAlphaInverseEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTAlphaModulateEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTAlphaModulateFixedEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTAlphaOutsetEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTAlphaReplaceEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTBiLevelEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTBlendEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTBlurEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTColorChangeEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTColorReplaceEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTDuotoneEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer;
import org.openxmlformats.schemas.drawingml.x2006.main.CTEffectReference;
import org.openxmlformats.schemas.drawingml.x2006.main.CTFillEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTFillOverlayEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGlowEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGrayscaleEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTHSLEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTInnerShadowEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTLuminanceEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTOuterShadowEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPresetShadowEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTReflectionEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTRelativeOffsetEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTSoftEdgesEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTintEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTransformEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.STEffectContainerType;
import org.openxmlformats.schemas.drawingml.x2006.main.STEffectContainerType$Enum;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class CTEffectContainerImpl extends XmlComplexContentImpl implements CTEffectContainer {
    private static final QName[] PROPERTY_QNAME = {new QName(XSSFRelation.NS_DRAWINGML, "cont"), new QName(XSSFRelation.NS_DRAWINGML, "effect"), new QName(XSSFRelation.NS_DRAWINGML, "alphaBiLevel"), new QName(XSSFRelation.NS_DRAWINGML, "alphaCeiling"), new QName(XSSFRelation.NS_DRAWINGML, "alphaFloor"), new QName(XSSFRelation.NS_DRAWINGML, "alphaInv"), new QName(XSSFRelation.NS_DRAWINGML, "alphaMod"), new QName(XSSFRelation.NS_DRAWINGML, "alphaModFix"), new QName(XSSFRelation.NS_DRAWINGML, "alphaOutset"), new QName(XSSFRelation.NS_DRAWINGML, "alphaRepl"), new QName(XSSFRelation.NS_DRAWINGML, "biLevel"), new QName(XSSFRelation.NS_DRAWINGML, "blend"), new QName(XSSFRelation.NS_DRAWINGML, "blur"), new QName(XSSFRelation.NS_DRAWINGML, "clrChange"), new QName(XSSFRelation.NS_DRAWINGML, "clrRepl"), new QName(XSSFRelation.NS_DRAWINGML, "duotone"), new QName(XSSFRelation.NS_DRAWINGML, "fill"), new QName(XSSFRelation.NS_DRAWINGML, "fillOverlay"), new QName(XSSFRelation.NS_DRAWINGML, "glow"), new QName(XSSFRelation.NS_DRAWINGML, "grayscl"), new QName(XSSFRelation.NS_DRAWINGML, "hsl"), new QName(XSSFRelation.NS_DRAWINGML, "innerShdw"), new QName(XSSFRelation.NS_DRAWINGML, "lum"), new QName(XSSFRelation.NS_DRAWINGML, "outerShdw"), new QName(XSSFRelation.NS_DRAWINGML, "prstShdw"), new QName(XSSFRelation.NS_DRAWINGML, "reflection"), new QName(XSSFRelation.NS_DRAWINGML, "relOff"), new QName(XSSFRelation.NS_DRAWINGML, "softEdge"), new QName(XSSFRelation.NS_DRAWINGML, "tint"), new QName(XSSFRelation.NS_DRAWINGML, "xfrm"), new QName("", "type"), new QName("", "name")};
    private static final long serialVersionUID = 1;

    public CTEffectContainerImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTAlphaBiLevelEffect addNewAlphaBiLevel() {
        CTAlphaBiLevelEffect cTAlphaBiLevelEffectAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTAlphaBiLevelEffectAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[2]);
        }
        return cTAlphaBiLevelEffectAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTAlphaCeilingEffect addNewAlphaCeiling() {
        CTAlphaCeilingEffect cTAlphaCeilingEffectAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTAlphaCeilingEffectAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[3]);
        }
        return cTAlphaCeilingEffectAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTAlphaFloorEffect addNewAlphaFloor() {
        CTAlphaFloorEffect cTAlphaFloorEffectAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTAlphaFloorEffectAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[4]);
        }
        return cTAlphaFloorEffectAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTAlphaInverseEffect addNewAlphaInv() {
        CTAlphaInverseEffect cTAlphaInverseEffectAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTAlphaInverseEffectAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[5]);
        }
        return cTAlphaInverseEffectAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTAlphaModulateEffect addNewAlphaMod() {
        CTAlphaModulateEffect cTAlphaModulateEffectAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTAlphaModulateEffectAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[6]);
        }
        return cTAlphaModulateEffectAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTAlphaModulateFixedEffect addNewAlphaModFix() {
        CTAlphaModulateFixedEffect cTAlphaModulateFixedEffect;
        synchronized (monitor()) {
            check_orphaned();
            cTAlphaModulateFixedEffect = (CTAlphaModulateFixedEffect) get_store().add_element_user(PROPERTY_QNAME[7]);
        }
        return cTAlphaModulateFixedEffect;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTAlphaOutsetEffect addNewAlphaOutset() {
        CTAlphaOutsetEffect cTAlphaOutsetEffectAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTAlphaOutsetEffectAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[8]);
        }
        return cTAlphaOutsetEffectAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTAlphaReplaceEffect addNewAlphaRepl() {
        CTAlphaReplaceEffect cTAlphaReplaceEffectAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTAlphaReplaceEffectAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[9]);
        }
        return cTAlphaReplaceEffectAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTBiLevelEffect addNewBiLevel() {
        CTBiLevelEffect cTBiLevelEffectAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBiLevelEffectAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[10]);
        }
        return cTBiLevelEffectAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTBlendEffect addNewBlend() {
        CTBlendEffect cTBlendEffectAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBlendEffectAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[11]);
        }
        return cTBlendEffectAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTBlurEffect addNewBlur() {
        CTBlurEffect cTBlurEffectAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBlurEffectAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[12]);
        }
        return cTBlurEffectAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTColorChangeEffect addNewClrChange() {
        CTColorChangeEffect cTColorChangeEffectAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTColorChangeEffectAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[13]);
        }
        return cTColorChangeEffectAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTColorReplaceEffect addNewClrRepl() {
        CTColorReplaceEffect cTColorReplaceEffectAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTColorReplaceEffectAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[14]);
        }
        return cTColorReplaceEffectAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTEffectContainer addNewCont() {
        CTEffectContainer cTEffectContainer;
        synchronized (monitor()) {
            check_orphaned();
            cTEffectContainer = (CTEffectContainer) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTEffectContainer;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTDuotoneEffect addNewDuotone() {
        CTDuotoneEffect cTDuotoneEffect;
        synchronized (monitor()) {
            check_orphaned();
            cTDuotoneEffect = (CTDuotoneEffect) get_store().add_element_user(PROPERTY_QNAME[15]);
        }
        return cTDuotoneEffect;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTEffectReference addNewEffect() {
        CTEffectReference cTEffectReferenceAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTEffectReferenceAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[1]);
        }
        return cTEffectReferenceAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTFillEffect addNewFill() {
        CTFillEffect cTFillEffectAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTFillEffectAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[16]);
        }
        return cTFillEffectAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTFillOverlayEffect addNewFillOverlay() {
        CTFillOverlayEffect cTFillOverlayEffectAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTFillOverlayEffectAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[17]);
        }
        return cTFillOverlayEffectAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTGlowEffect addNewGlow() {
        CTGlowEffect cTGlowEffectAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTGlowEffectAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[18]);
        }
        return cTGlowEffectAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTGrayscaleEffect addNewGrayscl() {
        CTGrayscaleEffect cTGrayscaleEffectAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTGrayscaleEffectAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[19]);
        }
        return cTGrayscaleEffectAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTHSLEffect addNewHsl() {
        CTHSLEffect cTHSLEffectAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTHSLEffectAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[20]);
        }
        return cTHSLEffectAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTInnerShadowEffect addNewInnerShdw() {
        CTInnerShadowEffect cTInnerShadowEffectAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTInnerShadowEffectAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[21]);
        }
        return cTInnerShadowEffectAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTLuminanceEffect addNewLum() {
        CTLuminanceEffect cTLuminanceEffectAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTLuminanceEffectAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[22]);
        }
        return cTLuminanceEffectAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTOuterShadowEffect addNewOuterShdw() {
        CTOuterShadowEffect cTOuterShadowEffect;
        synchronized (monitor()) {
            check_orphaned();
            cTOuterShadowEffect = (CTOuterShadowEffect) get_store().add_element_user(PROPERTY_QNAME[23]);
        }
        return cTOuterShadowEffect;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTPresetShadowEffect addNewPrstShdw() {
        CTPresetShadowEffect cTPresetShadowEffectAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTPresetShadowEffectAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[24]);
        }
        return cTPresetShadowEffectAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTReflectionEffect addNewReflection() {
        CTReflectionEffect cTReflectionEffectAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTReflectionEffectAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[25]);
        }
        return cTReflectionEffectAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTRelativeOffsetEffect addNewRelOff() {
        CTRelativeOffsetEffect cTRelativeOffsetEffectAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTRelativeOffsetEffectAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[26]);
        }
        return cTRelativeOffsetEffectAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTSoftEdgesEffect addNewSoftEdge() {
        CTSoftEdgesEffect cTSoftEdgesEffectAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSoftEdgesEffectAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[27]);
        }
        return cTSoftEdgesEffectAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTTintEffect addNewTint() {
        CTTintEffect cTTintEffectAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTintEffectAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[28]);
        }
        return cTTintEffectAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTTransformEffect addNewXfrm() {
        CTTransformEffect cTTransformEffectAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTransformEffectAdd_element_user = get_store().add_element_user(PROPERTY_QNAME[29]);
        }
        return cTTransformEffectAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTAlphaBiLevelEffect[] getAlphaBiLevelArray() {
        return getXmlObjectArray(PROPERTY_QNAME[2], (XmlObject[]) new CTAlphaBiLevelEffect[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public List<CTAlphaBiLevelEffect> getAlphaBiLevelList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new C1165b0(this, 0), new BiConsumer() { // from class: l5.c0
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    this.f5983a.setAlphaBiLevelArray(((Integer) obj).intValue(), (CTAlphaBiLevelEffect) obj2);
                }
            }, new C1165b0(this, 1), new K(this, 14), new L(this, 14));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTAlphaCeilingEffect[] getAlphaCeilingArray() {
        return getXmlObjectArray(PROPERTY_QNAME[3], (XmlObject[]) new CTAlphaCeilingEffect[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public List<CTAlphaCeilingEffect> getAlphaCeilingList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new I(this, 15), new BiConsumer() { // from class: l5.T
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    this.f5953a.setAlphaCeilingArray(((Integer) obj).intValue(), (CTAlphaCeilingEffect) obj2);
                }
            }, new I(this, 16), new K(this, 6), new L(this, 6));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTAlphaFloorEffect[] getAlphaFloorArray() {
        return getXmlObjectArray(PROPERTY_QNAME[4], (XmlObject[]) new CTAlphaFloorEffect[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public List<CTAlphaFloorEffect> getAlphaFloorList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new I(this, 27), new BiConsumer() { // from class: l5.a0
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    this.f5975a.setAlphaFloorArray(((Integer) obj).intValue(), (CTAlphaFloorEffect) obj2);
                }
            }, new I(this, 28), new K(this, 13), new L(this, 13));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTAlphaInverseEffect[] getAlphaInvArray() {
        return getXmlObjectArray(PROPERTY_QNAME[5], (XmlObject[]) new CTAlphaInverseEffect[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public List<CTAlphaInverseEffect> getAlphaInvList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new I(this, 8), new BiConsumer() { // from class: l5.O
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    this.f5939a.setAlphaInvArray(((Integer) obj).intValue(), (CTAlphaInverseEffect) obj2);
                }
            }, new I(this, 9), new K(this, 3), new L(this, 3));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTAlphaModulateEffect[] getAlphaModArray() {
        return getXmlObjectArray(PROPERTY_QNAME[6], (XmlObject[]) new CTAlphaModulateEffect[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTAlphaModulateFixedEffect[] getAlphaModFixArray() {
        return (CTAlphaModulateFixedEffect[]) getXmlObjectArray(PROPERTY_QNAME[7], new CTAlphaModulateFixedEffect[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public List<CTAlphaModulateFixedEffect> getAlphaModFixList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new C1165b0(this, 12), new C1183h0(this, 2), new C1165b0(this, 21), new K(this, 27), new L(this, 29));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public List<CTAlphaModulateEffect> getAlphaModList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new C1165b0(this, 22), new BiConsumer() { // from class: l5.l0
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    this.f6019a.setAlphaModArray(((Integer) obj).intValue(), (CTAlphaModulateEffect) obj2);
                }
            }, new C1165b0(this, 23), new K(this, 25), new L(this, 25));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTAlphaOutsetEffect[] getAlphaOutsetArray() {
        return getXmlObjectArray(PROPERTY_QNAME[8], (XmlObject[]) new CTAlphaOutsetEffect[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public List<CTAlphaOutsetEffect> getAlphaOutsetList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new I(this, 3), new BiConsumer() { // from class: l5.M
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    this.f5933a.setAlphaOutsetArray(((Integer) obj).intValue(), (CTAlphaOutsetEffect) obj2);
                }
            }, new I(this, 4), new K(this, 1), new L(this, 1));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTAlphaReplaceEffect[] getAlphaReplArray() {
        return getXmlObjectArray(PROPERTY_QNAME[9], (XmlObject[]) new CTAlphaReplaceEffect[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public List<CTAlphaReplaceEffect> getAlphaReplList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new C1165b0(this, 2), new BiConsumer() { // from class: l5.d0
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    this.f5987a.setAlphaReplArray(((Integer) obj).intValue(), (CTAlphaReplaceEffect) obj2);
                }
            }, new C1165b0(this, 3), new K(this, 15), new L(this, 15));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTBiLevelEffect[] getBiLevelArray() {
        return getXmlObjectArray(PROPERTY_QNAME[10], (XmlObject[]) new CTBiLevelEffect[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public List<CTBiLevelEffect> getBiLevelList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new I(this, 17), new BiConsumer() { // from class: l5.U
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    this.f5956a.setBiLevelArray(((Integer) obj).intValue(), (CTBiLevelEffect) obj2);
                }
            }, new I(this, 18), new K(this, 7), new L(this, 7));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTBlendEffect[] getBlendArray() {
        return getXmlObjectArray(PROPERTY_QNAME[11], (XmlObject[]) new CTBlendEffect[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public List<CTBlendEffect> getBlendList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new I(this, 21), new BiConsumer() { // from class: l5.W
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    this.f5962a.setBlendArray(((Integer) obj).intValue(), (CTBlendEffect) obj2);
                }
            }, new I(this, 22), new K(this, 10), new L(this, 9));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTBlurEffect[] getBlurArray() {
        return getXmlObjectArray(PROPERTY_QNAME[12], (XmlObject[]) new CTBlurEffect[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public List<CTBlurEffect> getBlurList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new C1165b0(this, 4), new BiConsumer() { // from class: l5.e0
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    this.f5991a.setBlurArray(((Integer) obj).intValue(), (CTBlurEffect) obj2);
                }
            }, new C1165b0(this, 5), new K(this, 17), new L(this, 16));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTColorChangeEffect[] getClrChangeArray() {
        return getXmlObjectArray(PROPERTY_QNAME[13], (XmlObject[]) new CTColorChangeEffect[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public List<CTColorChangeEffect> getClrChangeList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new I(this, 12), new BiConsumer() { // from class: l5.S
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    this.f5950a.setClrChangeArray(((Integer) obj).intValue(), (CTColorChangeEffect) obj2);
                }
            }, new I(this, 13), new K(this, 5), new L(this, 5));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTColorReplaceEffect[] getClrReplArray() {
        return getXmlObjectArray(PROPERTY_QNAME[14], (XmlObject[]) new CTColorReplaceEffect[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public List<CTColorReplaceEffect> getClrReplList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new C1165b0(this, 8), new BiConsumer() { // from class: l5.g0
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    this.f5999a.setClrReplArray(((Integer) obj).intValue(), (CTColorReplaceEffect) obj2);
                }
            }, new C1165b0(this, 9), new K(this, 19), new L(this, 19));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTEffectContainer[] getContArray() {
        return (CTEffectContainer[]) getXmlObjectArray(PROPERTY_QNAME[0], new CTEffectContainer[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public List<CTEffectContainer> getContList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new C1165b0(this, 10), new C1183h0(this, 0), new C1165b0(this, 11), new K(this, 20), new L(this, 20));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTDuotoneEffect[] getDuotoneArray() {
        return (CTDuotoneEffect[]) getXmlObjectArray(PROPERTY_QNAME[15], new CTDuotoneEffect[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public List<CTDuotoneEffect> getDuotoneList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new C1165b0(this, 15), new C1183h0(this, 1), new C1165b0(this, 16), new K(this, 22), new L(this, 22));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTEffectReference[] getEffectArray() {
        return getXmlObjectArray(PROPERTY_QNAME[1], (XmlObject[]) new CTEffectReference[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public List<CTEffectReference> getEffectList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new I(this, 19), new BiConsumer() { // from class: l5.V
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    this.f5959a.setEffectArray(((Integer) obj).intValue(), (CTEffectReference) obj2);
                }
            }, new I(this, 20), new K(this, 9), new L(this, 8));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTFillEffect[] getFillArray() {
        return getXmlObjectArray(PROPERTY_QNAME[16], (XmlObject[]) new CTFillEffect[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public List<CTFillEffect> getFillList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new C1165b0(this, 28), new BiConsumer() { // from class: l5.n0
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    this.f6026a.setFillArray(((Integer) obj).intValue(), (CTFillEffect) obj2);
                }
            }, new C1165b0(this, 29), new K(this, 29), new L(this, 28));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTFillOverlayEffect[] getFillOverlayArray() {
        return getXmlObjectArray(PROPERTY_QNAME[17], (XmlObject[]) new CTFillOverlayEffect[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public List<CTFillOverlayEffect> getFillOverlayList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new I(this, 6), new BiConsumer() { // from class: l5.N
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    this.f5936a.setFillOverlayArray(((Integer) obj).intValue(), (CTFillOverlayEffect) obj2);
                }
            }, new I(this, 7), new K(this, 2), new L(this, 2));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTGlowEffect[] getGlowArray() {
        return getXmlObjectArray(PROPERTY_QNAME[18], (XmlObject[]) new CTGlowEffect[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public List<CTGlowEffect> getGlowList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new C1165b0(this, 24), new BiConsumer() { // from class: l5.m0
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    this.f6023a.setGlowArray(((Integer) obj).intValue(), (CTGlowEffect) obj2);
                }
            }, new C1165b0(this, 25), new K(this, 26), new L(this, 26));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTGrayscaleEffect[] getGraysclArray() {
        return getXmlObjectArray(PROPERTY_QNAME[19], (XmlObject[]) new CTGrayscaleEffect[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public List<CTGrayscaleEffect> getGraysclList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new I(this, 5), new BiConsumer() { // from class: l5.P
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    this.f5942a.setGraysclArray(((Integer) obj).intValue(), (CTGrayscaleEffect) obj2);
                }
            }, new I(this, 14), new K(this, 8), new L(this, 10));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTHSLEffect[] getHslArray() {
        return getXmlObjectArray(PROPERTY_QNAME[20], (XmlObject[]) new CTHSLEffect[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public List<CTHSLEffect> getHslList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new C1165b0(this, 17), new BiConsumer() { // from class: l5.j0
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    this.f6011a.setHslArray(((Integer) obj).intValue(), (CTHSLEffect) obj2);
                }
            }, new C1165b0(this, 18), new K(this, 23), new L(this, 23));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTInnerShadowEffect[] getInnerShdwArray() {
        return getXmlObjectArray(PROPERTY_QNAME[21], (XmlObject[]) new CTInnerShadowEffect[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public List<CTInnerShadowEffect> getInnerShdwList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new I(this, 0), new BiConsumer() { // from class: l5.Y
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    this.f5968a.setInnerShdwArray(((Integer) obj).intValue(), (CTInnerShadowEffect) obj2);
                }
            }, new I(this, 29), new K(this, 16), new L(this, 18));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTLuminanceEffect[] getLumArray() {
        return getXmlObjectArray(PROPERTY_QNAME[22], (XmlObject[]) new CTLuminanceEffect[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public List<CTLuminanceEffect> getLumList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new C1165b0(this, 19), new BiConsumer() { // from class: l5.k0
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    this.f6015a.setLumArray(((Integer) obj).intValue(), (CTLuminanceEffect) obj2);
                }
            }, new C1165b0(this, 20), new K(this, 24), new L(this, 24));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public String getName() {
        String stringValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[31]);
            stringValue = simpleValue == null ? null : simpleValue.getStringValue();
        }
        return stringValue;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTOuterShadowEffect[] getOuterShdwArray() {
        return (CTOuterShadowEffect[]) getXmlObjectArray(PROPERTY_QNAME[23], new CTOuterShadowEffect[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public List<CTOuterShadowEffect> getOuterShdwList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new C1165b0(this, 26), new C1183h0(this, 3), new C1165b0(this, 27), new K(this, 28), new L(this, 27));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTPresetShadowEffect[] getPrstShdwArray() {
        return getXmlObjectArray(PROPERTY_QNAME[24], (XmlObject[]) new CTPresetShadowEffect[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public List<CTPresetShadowEffect> getPrstShdwList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new I(this, 25), new BiConsumer() { // from class: l5.Z
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    this.f5971a.setPrstShdwArray(((Integer) obj).intValue(), (CTPresetShadowEffect) obj2);
                }
            }, new I(this, 26), new K(this, 12), new L(this, 12));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTReflectionEffect[] getReflectionArray() {
        return getXmlObjectArray(PROPERTY_QNAME[25], (XmlObject[]) new CTReflectionEffect[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public List<CTReflectionEffect> getReflectionList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new I(this, 23), new BiConsumer() { // from class: l5.X
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    this.f5965a.setReflectionArray(((Integer) obj).intValue(), (CTReflectionEffect) obj2);
                }
            }, new I(this, 24), new K(this, 11), new L(this, 11));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTRelativeOffsetEffect[] getRelOffArray() {
        return getXmlObjectArray(PROPERTY_QNAME[26], (XmlObject[]) new CTRelativeOffsetEffect[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public List<CTRelativeOffsetEffect> getRelOffList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new I(this, 1), new BiConsumer() { // from class: l5.J
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    this.f5924a.setRelOffArray(((Integer) obj).intValue(), (CTRelativeOffsetEffect) obj2);
                }
            }, new I(this, 2), new K(this, 0), new L(this, 0));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTSoftEdgesEffect[] getSoftEdgeArray() {
        return getXmlObjectArray(PROPERTY_QNAME[27], (XmlObject[]) new CTSoftEdgesEffect[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public List<CTSoftEdgesEffect> getSoftEdgeList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new C1165b0(this, 13), new BiConsumer() { // from class: l5.i0
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    this.f6007a.setSoftEdgeArray(((Integer) obj).intValue(), (CTSoftEdgesEffect) obj2);
                }
            }, new C1165b0(this, 14), new K(this, 21), new L(this, 21));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTTintEffect[] getTintArray() {
        return getXmlObjectArray(PROPERTY_QNAME[28], (XmlObject[]) new CTTintEffect[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public List<CTTintEffect> getTintList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new I(this, 10), new BiConsumer() { // from class: l5.Q
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    this.f5945a.setTintArray(((Integer) obj).intValue(), (CTTintEffect) obj2);
                }
            }, new I(this, 11), new K(this, 4), new L(this, 4));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public STEffectContainerType$Enum getType() {
        STEffectContainerType$Enum sTEffectContainerType$Enum;
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[30]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_default_attribute_value(qNameArr[30]);
                }
                sTEffectContainerType$Enum = simpleValue == null ? null : (STEffectContainerType$Enum) simpleValue.getEnumValue();
            } catch (Throwable th) {
                throw th;
            }
        }
        return sTEffectContainerType$Enum;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTTransformEffect[] getXfrmArray() {
        return getXmlObjectArray(PROPERTY_QNAME[29], (XmlObject[]) new CTTransformEffect[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public List<CTTransformEffect> getXfrmList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            javaListXmlObject = new JavaListXmlObject(new C1165b0(this, 6), new BiConsumer() { // from class: l5.f0
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    this.f5995a.setXfrmArray(((Integer) obj).intValue(), (CTTransformEffect) obj2);
                }
            }, new C1165b0(this, 7), new K(this, 18), new L(this, 17));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTAlphaBiLevelEffect insertNewAlphaBiLevel(int i5) {
        CTAlphaBiLevelEffect cTAlphaBiLevelEffectInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTAlphaBiLevelEffectInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[2], i5);
        }
        return cTAlphaBiLevelEffectInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTAlphaCeilingEffect insertNewAlphaCeiling(int i5) {
        CTAlphaCeilingEffect cTAlphaCeilingEffectInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTAlphaCeilingEffectInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[3], i5);
        }
        return cTAlphaCeilingEffectInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTAlphaFloorEffect insertNewAlphaFloor(int i5) {
        CTAlphaFloorEffect cTAlphaFloorEffectInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTAlphaFloorEffectInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[4], i5);
        }
        return cTAlphaFloorEffectInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTAlphaInverseEffect insertNewAlphaInv(int i5) {
        CTAlphaInverseEffect cTAlphaInverseEffectInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTAlphaInverseEffectInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[5], i5);
        }
        return cTAlphaInverseEffectInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTAlphaModulateEffect insertNewAlphaMod(int i5) {
        CTAlphaModulateEffect cTAlphaModulateEffectInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTAlphaModulateEffectInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[6], i5);
        }
        return cTAlphaModulateEffectInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTAlphaModulateFixedEffect insertNewAlphaModFix(int i5) {
        CTAlphaModulateFixedEffect cTAlphaModulateFixedEffect;
        synchronized (monitor()) {
            check_orphaned();
            cTAlphaModulateFixedEffect = (CTAlphaModulateFixedEffect) get_store().insert_element_user(PROPERTY_QNAME[7], i5);
        }
        return cTAlphaModulateFixedEffect;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTAlphaOutsetEffect insertNewAlphaOutset(int i5) {
        CTAlphaOutsetEffect cTAlphaOutsetEffectInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTAlphaOutsetEffectInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[8], i5);
        }
        return cTAlphaOutsetEffectInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTAlphaReplaceEffect insertNewAlphaRepl(int i5) {
        CTAlphaReplaceEffect cTAlphaReplaceEffectInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTAlphaReplaceEffectInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[9], i5);
        }
        return cTAlphaReplaceEffectInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTBiLevelEffect insertNewBiLevel(int i5) {
        CTBiLevelEffect cTBiLevelEffectInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBiLevelEffectInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[10], i5);
        }
        return cTBiLevelEffectInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTBlendEffect insertNewBlend(int i5) {
        CTBlendEffect cTBlendEffectInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBlendEffectInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[11], i5);
        }
        return cTBlendEffectInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTBlurEffect insertNewBlur(int i5) {
        CTBlurEffect cTBlurEffectInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBlurEffectInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[12], i5);
        }
        return cTBlurEffectInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTColorChangeEffect insertNewClrChange(int i5) {
        CTColorChangeEffect cTColorChangeEffectInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTColorChangeEffectInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[13], i5);
        }
        return cTColorChangeEffectInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTColorReplaceEffect insertNewClrRepl(int i5) {
        CTColorReplaceEffect cTColorReplaceEffectInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTColorReplaceEffectInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[14], i5);
        }
        return cTColorReplaceEffectInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTEffectContainer insertNewCont(int i5) {
        CTEffectContainer cTEffectContainer;
        synchronized (monitor()) {
            check_orphaned();
            cTEffectContainer = (CTEffectContainer) get_store().insert_element_user(PROPERTY_QNAME[0], i5);
        }
        return cTEffectContainer;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTDuotoneEffect insertNewDuotone(int i5) {
        CTDuotoneEffect cTDuotoneEffect;
        synchronized (monitor()) {
            check_orphaned();
            cTDuotoneEffect = (CTDuotoneEffect) get_store().insert_element_user(PROPERTY_QNAME[15], i5);
        }
        return cTDuotoneEffect;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTEffectReference insertNewEffect(int i5) {
        CTEffectReference cTEffectReferenceInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTEffectReferenceInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[1], i5);
        }
        return cTEffectReferenceInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTFillEffect insertNewFill(int i5) {
        CTFillEffect cTFillEffectInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTFillEffectInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[16], i5);
        }
        return cTFillEffectInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTFillOverlayEffect insertNewFillOverlay(int i5) {
        CTFillOverlayEffect cTFillOverlayEffectInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTFillOverlayEffectInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[17], i5);
        }
        return cTFillOverlayEffectInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTGlowEffect insertNewGlow(int i5) {
        CTGlowEffect cTGlowEffectInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTGlowEffectInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[18], i5);
        }
        return cTGlowEffectInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTGrayscaleEffect insertNewGrayscl(int i5) {
        CTGrayscaleEffect cTGrayscaleEffectInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTGrayscaleEffectInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[19], i5);
        }
        return cTGrayscaleEffectInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTHSLEffect insertNewHsl(int i5) {
        CTHSLEffect cTHSLEffectInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTHSLEffectInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[20], i5);
        }
        return cTHSLEffectInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTInnerShadowEffect insertNewInnerShdw(int i5) {
        CTInnerShadowEffect cTInnerShadowEffectInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTInnerShadowEffectInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[21], i5);
        }
        return cTInnerShadowEffectInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTLuminanceEffect insertNewLum(int i5) {
        CTLuminanceEffect cTLuminanceEffectInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTLuminanceEffectInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[22], i5);
        }
        return cTLuminanceEffectInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTOuterShadowEffect insertNewOuterShdw(int i5) {
        CTOuterShadowEffect cTOuterShadowEffect;
        synchronized (monitor()) {
            check_orphaned();
            cTOuterShadowEffect = (CTOuterShadowEffect) get_store().insert_element_user(PROPERTY_QNAME[23], i5);
        }
        return cTOuterShadowEffect;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTPresetShadowEffect insertNewPrstShdw(int i5) {
        CTPresetShadowEffect cTPresetShadowEffectInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTPresetShadowEffectInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[24], i5);
        }
        return cTPresetShadowEffectInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTReflectionEffect insertNewReflection(int i5) {
        CTReflectionEffect cTReflectionEffectInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTReflectionEffectInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[25], i5);
        }
        return cTReflectionEffectInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTRelativeOffsetEffect insertNewRelOff(int i5) {
        CTRelativeOffsetEffect cTRelativeOffsetEffectInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTRelativeOffsetEffectInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[26], i5);
        }
        return cTRelativeOffsetEffectInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTSoftEdgesEffect insertNewSoftEdge(int i5) {
        CTSoftEdgesEffect cTSoftEdgesEffectInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSoftEdgesEffectInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[27], i5);
        }
        return cTSoftEdgesEffectInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTTintEffect insertNewTint(int i5) {
        CTTintEffect cTTintEffectInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTintEffectInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[28], i5);
        }
        return cTTintEffectInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTTransformEffect insertNewXfrm(int i5) {
        CTTransformEffect cTTransformEffectInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTransformEffectInsert_element_user = get_store().insert_element_user(PROPERTY_QNAME[29], i5);
        }
        return cTTransformEffectInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public boolean isSetName() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().find_attribute_user(PROPERTY_QNAME[31]) != null;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public boolean isSetType() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().find_attribute_user(PROPERTY_QNAME[30]) != null;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void removeAlphaBiLevel(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[2], i5);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void removeAlphaCeiling(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[3], i5);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void removeAlphaFloor(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[4], i5);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void removeAlphaInv(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[5], i5);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void removeAlphaMod(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[6], i5);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void removeAlphaModFix(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[7], i5);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void removeAlphaOutset(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[8], i5);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void removeAlphaRepl(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[9], i5);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void removeBiLevel(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[10], i5);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void removeBlend(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[11], i5);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void removeBlur(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[12], i5);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void removeClrChange(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[13], i5);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void removeClrRepl(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[14], i5);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void removeCont(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], i5);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void removeDuotone(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[15], i5);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void removeEffect(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[1], i5);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void removeFill(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[16], i5);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void removeFillOverlay(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[17], i5);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void removeGlow(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[18], i5);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void removeGrayscl(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[19], i5);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void removeHsl(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[20], i5);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void removeInnerShdw(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[21], i5);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void removeLum(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[22], i5);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void removeOuterShdw(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[23], i5);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void removePrstShdw(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[24], i5);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void removeReflection(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[25], i5);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void removeRelOff(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[26], i5);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void removeSoftEdge(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[27], i5);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void removeTint(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[28], i5);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void removeXfrm(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[29], i5);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void setAlphaBiLevelArray(CTAlphaBiLevelEffect[] cTAlphaBiLevelEffectArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTAlphaBiLevelEffectArr, PROPERTY_QNAME[2]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void setAlphaCeilingArray(CTAlphaCeilingEffect[] cTAlphaCeilingEffectArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTAlphaCeilingEffectArr, PROPERTY_QNAME[3]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void setAlphaFloorArray(CTAlphaFloorEffect[] cTAlphaFloorEffectArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTAlphaFloorEffectArr, PROPERTY_QNAME[4]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void setAlphaInvArray(CTAlphaInverseEffect[] cTAlphaInverseEffectArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTAlphaInverseEffectArr, PROPERTY_QNAME[5]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void setAlphaModArray(CTAlphaModulateEffect[] cTAlphaModulateEffectArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTAlphaModulateEffectArr, PROPERTY_QNAME[6]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void setAlphaModFixArray(CTAlphaModulateFixedEffect[] cTAlphaModulateFixedEffectArr) {
        check_orphaned();
        arraySetterHelper(cTAlphaModulateFixedEffectArr, PROPERTY_QNAME[7]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void setAlphaOutsetArray(CTAlphaOutsetEffect[] cTAlphaOutsetEffectArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTAlphaOutsetEffectArr, PROPERTY_QNAME[8]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void setAlphaReplArray(CTAlphaReplaceEffect[] cTAlphaReplaceEffectArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTAlphaReplaceEffectArr, PROPERTY_QNAME[9]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void setBiLevelArray(CTBiLevelEffect[] cTBiLevelEffectArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTBiLevelEffectArr, PROPERTY_QNAME[10]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void setBlendArray(CTBlendEffect[] cTBlendEffectArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTBlendEffectArr, PROPERTY_QNAME[11]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void setBlurArray(CTBlurEffect[] cTBlurEffectArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTBlurEffectArr, PROPERTY_QNAME[12]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void setClrChangeArray(CTColorChangeEffect[] cTColorChangeEffectArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTColorChangeEffectArr, PROPERTY_QNAME[13]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void setClrReplArray(CTColorReplaceEffect[] cTColorReplaceEffectArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTColorReplaceEffectArr, PROPERTY_QNAME[14]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void setContArray(CTEffectContainer[] cTEffectContainerArr) {
        check_orphaned();
        arraySetterHelper(cTEffectContainerArr, PROPERTY_QNAME[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void setDuotoneArray(CTDuotoneEffect[] cTDuotoneEffectArr) {
        check_orphaned();
        arraySetterHelper(cTDuotoneEffectArr, PROPERTY_QNAME[15]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void setEffectArray(CTEffectReference[] cTEffectReferenceArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTEffectReferenceArr, PROPERTY_QNAME[1]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void setFillArray(CTFillEffect[] cTFillEffectArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTFillEffectArr, PROPERTY_QNAME[16]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void setFillOverlayArray(CTFillOverlayEffect[] cTFillOverlayEffectArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTFillOverlayEffectArr, PROPERTY_QNAME[17]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void setGlowArray(CTGlowEffect[] cTGlowEffectArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTGlowEffectArr, PROPERTY_QNAME[18]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void setGraysclArray(CTGrayscaleEffect[] cTGrayscaleEffectArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTGrayscaleEffectArr, PROPERTY_QNAME[19]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void setHslArray(CTHSLEffect[] cTHSLEffectArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTHSLEffectArr, PROPERTY_QNAME[20]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void setInnerShdwArray(CTInnerShadowEffect[] cTInnerShadowEffectArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTInnerShadowEffectArr, PROPERTY_QNAME[21]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void setLumArray(CTLuminanceEffect[] cTLuminanceEffectArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTLuminanceEffectArr, PROPERTY_QNAME[22]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void setName(String str) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[31]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[31]);
                }
                simpleValue.setStringValue(str);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void setOuterShdwArray(CTOuterShadowEffect[] cTOuterShadowEffectArr) {
        check_orphaned();
        arraySetterHelper(cTOuterShadowEffectArr, PROPERTY_QNAME[23]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void setPrstShdwArray(CTPresetShadowEffect[] cTPresetShadowEffectArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTPresetShadowEffectArr, PROPERTY_QNAME[24]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void setReflectionArray(CTReflectionEffect[] cTReflectionEffectArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTReflectionEffectArr, PROPERTY_QNAME[25]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void setRelOffArray(CTRelativeOffsetEffect[] cTRelativeOffsetEffectArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTRelativeOffsetEffectArr, PROPERTY_QNAME[26]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void setSoftEdgeArray(CTSoftEdgesEffect[] cTSoftEdgesEffectArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTSoftEdgesEffectArr, PROPERTY_QNAME[27]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void setTintArray(CTTintEffect[] cTTintEffectArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTTintEffectArr, PROPERTY_QNAME[28]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void setType(STEffectContainerType$Enum sTEffectContainerType$Enum) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[30]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[30]);
                }
                simpleValue.setEnumValue(sTEffectContainerType$Enum);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void setXfrmArray(CTTransformEffect[] cTTransformEffectArr) {
        check_orphaned();
        arraySetterHelper((XmlObject[]) cTTransformEffectArr, PROPERTY_QNAME[29]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public int sizeOfAlphaBiLevelArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[2]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public int sizeOfAlphaCeilingArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[3]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public int sizeOfAlphaFloorArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[4]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public int sizeOfAlphaInvArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[5]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public int sizeOfAlphaModArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[6]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public int sizeOfAlphaModFixArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[7]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public int sizeOfAlphaOutsetArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[8]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public int sizeOfAlphaReplArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[9]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public int sizeOfBiLevelArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[10]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public int sizeOfBlendArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[11]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public int sizeOfBlurArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[12]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public int sizeOfClrChangeArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[13]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public int sizeOfClrReplArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[14]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public int sizeOfContArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[0]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public int sizeOfDuotoneArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[15]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public int sizeOfEffectArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[1]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public int sizeOfFillArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[16]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public int sizeOfFillOverlayArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[17]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public int sizeOfGlowArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[18]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public int sizeOfGraysclArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[19]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public int sizeOfHslArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[20]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public int sizeOfInnerShdwArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[21]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public int sizeOfLumArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[22]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public int sizeOfOuterShdwArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[23]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public int sizeOfPrstShdwArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[24]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public int sizeOfReflectionArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[25]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public int sizeOfRelOffArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[26]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public int sizeOfSoftEdgeArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[27]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public int sizeOfTintArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[28]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public int sizeOfXfrmArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[29]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void unsetName() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[31]);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void unsetType() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[30]);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public XmlToken xgetName() {
        XmlToken xmlToken;
        synchronized (monitor()) {
            check_orphaned();
            xmlToken = (XmlToken) get_store().find_attribute_user(PROPERTY_QNAME[31]);
        }
        return xmlToken;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public STEffectContainerType xgetType() {
        STEffectContainerType sTEffectContainerTypeFind_attribute_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                sTEffectContainerTypeFind_attribute_user = typeStore.find_attribute_user(qNameArr[30]);
                if (sTEffectContainerTypeFind_attribute_user == null) {
                    sTEffectContainerTypeFind_attribute_user = (STEffectContainerType) get_default_attribute_value(qNameArr[30]);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return sTEffectContainerTypeFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void xsetName(XmlToken xmlToken) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                XmlToken xmlToken2 = (XmlToken) typeStore.find_attribute_user(qNameArr[31]);
                if (xmlToken2 == null) {
                    xmlToken2 = (XmlToken) get_store().add_attribute_user(qNameArr[31]);
                }
                xmlToken2.set(xmlToken);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void xsetType(STEffectContainerType sTEffectContainerType) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                STEffectContainerType sTEffectContainerTypeFind_attribute_user = typeStore.find_attribute_user(qNameArr[30]);
                if (sTEffectContainerTypeFind_attribute_user == null) {
                    sTEffectContainerTypeFind_attribute_user = (STEffectContainerType) get_store().add_attribute_user(qNameArr[30]);
                }
                sTEffectContainerTypeFind_attribute_user.set(sTEffectContainerType);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTAlphaBiLevelEffect getAlphaBiLevelArray(int i5) {
        CTAlphaBiLevelEffect cTAlphaBiLevelEffectFind_element_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTAlphaBiLevelEffectFind_element_user = get_store().find_element_user(PROPERTY_QNAME[2], i5);
                if (cTAlphaBiLevelEffectFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTAlphaBiLevelEffectFind_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTAlphaCeilingEffect getAlphaCeilingArray(int i5) {
        CTAlphaCeilingEffect cTAlphaCeilingEffectFind_element_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTAlphaCeilingEffectFind_element_user = get_store().find_element_user(PROPERTY_QNAME[3], i5);
                if (cTAlphaCeilingEffectFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTAlphaCeilingEffectFind_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTAlphaFloorEffect getAlphaFloorArray(int i5) {
        CTAlphaFloorEffect cTAlphaFloorEffectFind_element_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTAlphaFloorEffectFind_element_user = get_store().find_element_user(PROPERTY_QNAME[4], i5);
                if (cTAlphaFloorEffectFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTAlphaFloorEffectFind_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTAlphaInverseEffect getAlphaInvArray(int i5) {
        CTAlphaInverseEffect cTAlphaInverseEffectFind_element_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTAlphaInverseEffectFind_element_user = get_store().find_element_user(PROPERTY_QNAME[5], i5);
                if (cTAlphaInverseEffectFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTAlphaInverseEffectFind_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTAlphaModulateEffect getAlphaModArray(int i5) {
        CTAlphaModulateEffect cTAlphaModulateEffectFind_element_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTAlphaModulateEffectFind_element_user = get_store().find_element_user(PROPERTY_QNAME[6], i5);
                if (cTAlphaModulateEffectFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTAlphaModulateEffectFind_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTAlphaModulateFixedEffect getAlphaModFixArray(int i5) {
        CTAlphaModulateFixedEffect cTAlphaModulateFixedEffect;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTAlphaModulateFixedEffect = (CTAlphaModulateFixedEffect) get_store().find_element_user(PROPERTY_QNAME[7], i5);
                if (cTAlphaModulateFixedEffect == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTAlphaModulateFixedEffect;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTAlphaOutsetEffect getAlphaOutsetArray(int i5) {
        CTAlphaOutsetEffect cTAlphaOutsetEffectFind_element_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTAlphaOutsetEffectFind_element_user = get_store().find_element_user(PROPERTY_QNAME[8], i5);
                if (cTAlphaOutsetEffectFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTAlphaOutsetEffectFind_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTAlphaReplaceEffect getAlphaReplArray(int i5) {
        CTAlphaReplaceEffect cTAlphaReplaceEffectFind_element_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTAlphaReplaceEffectFind_element_user = get_store().find_element_user(PROPERTY_QNAME[9], i5);
                if (cTAlphaReplaceEffectFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTAlphaReplaceEffectFind_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTBiLevelEffect getBiLevelArray(int i5) {
        CTBiLevelEffect cTBiLevelEffectFind_element_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTBiLevelEffectFind_element_user = get_store().find_element_user(PROPERTY_QNAME[10], i5);
                if (cTBiLevelEffectFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTBiLevelEffectFind_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTBlendEffect getBlendArray(int i5) {
        CTBlendEffect cTBlendEffectFind_element_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTBlendEffectFind_element_user = get_store().find_element_user(PROPERTY_QNAME[11], i5);
                if (cTBlendEffectFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTBlendEffectFind_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTBlurEffect getBlurArray(int i5) {
        CTBlurEffect cTBlurEffectFind_element_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTBlurEffectFind_element_user = get_store().find_element_user(PROPERTY_QNAME[12], i5);
                if (cTBlurEffectFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTBlurEffectFind_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTColorChangeEffect getClrChangeArray(int i5) {
        CTColorChangeEffect cTColorChangeEffectFind_element_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTColorChangeEffectFind_element_user = get_store().find_element_user(PROPERTY_QNAME[13], i5);
                if (cTColorChangeEffectFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTColorChangeEffectFind_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTColorReplaceEffect getClrReplArray(int i5) {
        CTColorReplaceEffect cTColorReplaceEffectFind_element_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTColorReplaceEffectFind_element_user = get_store().find_element_user(PROPERTY_QNAME[14], i5);
                if (cTColorReplaceEffectFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTColorReplaceEffectFind_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTEffectContainer getContArray(int i5) {
        CTEffectContainer cTEffectContainer;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTEffectContainer = (CTEffectContainer) get_store().find_element_user(PROPERTY_QNAME[0], i5);
                if (cTEffectContainer == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTEffectContainer;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTDuotoneEffect getDuotoneArray(int i5) {
        CTDuotoneEffect cTDuotoneEffect;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTDuotoneEffect = (CTDuotoneEffect) get_store().find_element_user(PROPERTY_QNAME[15], i5);
                if (cTDuotoneEffect == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTDuotoneEffect;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTEffectReference getEffectArray(int i5) {
        CTEffectReference cTEffectReferenceFind_element_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTEffectReferenceFind_element_user = get_store().find_element_user(PROPERTY_QNAME[1], i5);
                if (cTEffectReferenceFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTEffectReferenceFind_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTFillEffect getFillArray(int i5) {
        CTFillEffect cTFillEffectFind_element_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTFillEffectFind_element_user = get_store().find_element_user(PROPERTY_QNAME[16], i5);
                if (cTFillEffectFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTFillEffectFind_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTFillOverlayEffect getFillOverlayArray(int i5) {
        CTFillOverlayEffect cTFillOverlayEffectFind_element_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTFillOverlayEffectFind_element_user = get_store().find_element_user(PROPERTY_QNAME[17], i5);
                if (cTFillOverlayEffectFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTFillOverlayEffectFind_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTGlowEffect getGlowArray(int i5) {
        CTGlowEffect cTGlowEffectFind_element_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTGlowEffectFind_element_user = get_store().find_element_user(PROPERTY_QNAME[18], i5);
                if (cTGlowEffectFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTGlowEffectFind_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTGrayscaleEffect getGraysclArray(int i5) {
        CTGrayscaleEffect cTGrayscaleEffectFind_element_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTGrayscaleEffectFind_element_user = get_store().find_element_user(PROPERTY_QNAME[19], i5);
                if (cTGrayscaleEffectFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTGrayscaleEffectFind_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTHSLEffect getHslArray(int i5) {
        CTHSLEffect cTHSLEffectFind_element_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTHSLEffectFind_element_user = get_store().find_element_user(PROPERTY_QNAME[20], i5);
                if (cTHSLEffectFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTHSLEffectFind_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTInnerShadowEffect getInnerShdwArray(int i5) {
        CTInnerShadowEffect cTInnerShadowEffectFind_element_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTInnerShadowEffectFind_element_user = get_store().find_element_user(PROPERTY_QNAME[21], i5);
                if (cTInnerShadowEffectFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTInnerShadowEffectFind_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTLuminanceEffect getLumArray(int i5) {
        CTLuminanceEffect cTLuminanceEffectFind_element_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTLuminanceEffectFind_element_user = get_store().find_element_user(PROPERTY_QNAME[22], i5);
                if (cTLuminanceEffectFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTLuminanceEffectFind_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTOuterShadowEffect getOuterShdwArray(int i5) {
        CTOuterShadowEffect cTOuterShadowEffect;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTOuterShadowEffect = (CTOuterShadowEffect) get_store().find_element_user(PROPERTY_QNAME[23], i5);
                if (cTOuterShadowEffect == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTOuterShadowEffect;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTPresetShadowEffect getPrstShdwArray(int i5) {
        CTPresetShadowEffect cTPresetShadowEffectFind_element_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTPresetShadowEffectFind_element_user = get_store().find_element_user(PROPERTY_QNAME[24], i5);
                if (cTPresetShadowEffectFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTPresetShadowEffectFind_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTReflectionEffect getReflectionArray(int i5) {
        CTReflectionEffect cTReflectionEffectFind_element_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTReflectionEffectFind_element_user = get_store().find_element_user(PROPERTY_QNAME[25], i5);
                if (cTReflectionEffectFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTReflectionEffectFind_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTRelativeOffsetEffect getRelOffArray(int i5) {
        CTRelativeOffsetEffect cTRelativeOffsetEffectFind_element_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTRelativeOffsetEffectFind_element_user = get_store().find_element_user(PROPERTY_QNAME[26], i5);
                if (cTRelativeOffsetEffectFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTRelativeOffsetEffectFind_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTSoftEdgesEffect getSoftEdgeArray(int i5) {
        CTSoftEdgesEffect cTSoftEdgesEffectFind_element_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTSoftEdgesEffectFind_element_user = get_store().find_element_user(PROPERTY_QNAME[27], i5);
                if (cTSoftEdgesEffectFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTSoftEdgesEffectFind_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTTintEffect getTintArray(int i5) {
        CTTintEffect cTTintEffectFind_element_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTTintEffectFind_element_user = get_store().find_element_user(PROPERTY_QNAME[28], i5);
                if (cTTintEffectFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTTintEffectFind_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public CTTransformEffect getXfrmArray(int i5) {
        CTTransformEffect cTTransformEffectFind_element_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTTransformEffectFind_element_user = get_store().find_element_user(PROPERTY_QNAME[29], i5);
                if (cTTransformEffectFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTTransformEffectFind_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void setAlphaBiLevelArray(int i5, CTAlphaBiLevelEffect cTAlphaBiLevelEffect) {
        generatedSetterHelperImpl(cTAlphaBiLevelEffect, PROPERTY_QNAME[2], i5, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void setAlphaCeilingArray(int i5, CTAlphaCeilingEffect cTAlphaCeilingEffect) {
        generatedSetterHelperImpl(cTAlphaCeilingEffect, PROPERTY_QNAME[3], i5, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void setAlphaFloorArray(int i5, CTAlphaFloorEffect cTAlphaFloorEffect) {
        generatedSetterHelperImpl(cTAlphaFloorEffect, PROPERTY_QNAME[4], i5, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void setAlphaInvArray(int i5, CTAlphaInverseEffect cTAlphaInverseEffect) {
        generatedSetterHelperImpl(cTAlphaInverseEffect, PROPERTY_QNAME[5], i5, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void setAlphaModArray(int i5, CTAlphaModulateEffect cTAlphaModulateEffect) {
        generatedSetterHelperImpl(cTAlphaModulateEffect, PROPERTY_QNAME[6], i5, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void setAlphaModFixArray(int i5, CTAlphaModulateFixedEffect cTAlphaModulateFixedEffect) {
        generatedSetterHelperImpl(cTAlphaModulateFixedEffect, PROPERTY_QNAME[7], i5, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void setAlphaOutsetArray(int i5, CTAlphaOutsetEffect cTAlphaOutsetEffect) {
        generatedSetterHelperImpl(cTAlphaOutsetEffect, PROPERTY_QNAME[8], i5, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void setAlphaReplArray(int i5, CTAlphaReplaceEffect cTAlphaReplaceEffect) {
        generatedSetterHelperImpl(cTAlphaReplaceEffect, PROPERTY_QNAME[9], i5, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void setBiLevelArray(int i5, CTBiLevelEffect cTBiLevelEffect) {
        generatedSetterHelperImpl(cTBiLevelEffect, PROPERTY_QNAME[10], i5, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void setBlendArray(int i5, CTBlendEffect cTBlendEffect) {
        generatedSetterHelperImpl(cTBlendEffect, PROPERTY_QNAME[11], i5, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void setBlurArray(int i5, CTBlurEffect cTBlurEffect) {
        generatedSetterHelperImpl(cTBlurEffect, PROPERTY_QNAME[12], i5, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void setClrChangeArray(int i5, CTColorChangeEffect cTColorChangeEffect) {
        generatedSetterHelperImpl(cTColorChangeEffect, PROPERTY_QNAME[13], i5, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void setClrReplArray(int i5, CTColorReplaceEffect cTColorReplaceEffect) {
        generatedSetterHelperImpl(cTColorReplaceEffect, PROPERTY_QNAME[14], i5, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void setContArray(int i5, CTEffectContainer cTEffectContainer) {
        generatedSetterHelperImpl(cTEffectContainer, PROPERTY_QNAME[0], i5, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void setDuotoneArray(int i5, CTDuotoneEffect cTDuotoneEffect) {
        generatedSetterHelperImpl(cTDuotoneEffect, PROPERTY_QNAME[15], i5, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void setEffectArray(int i5, CTEffectReference cTEffectReference) {
        generatedSetterHelperImpl(cTEffectReference, PROPERTY_QNAME[1], i5, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void setFillArray(int i5, CTFillEffect cTFillEffect) {
        generatedSetterHelperImpl(cTFillEffect, PROPERTY_QNAME[16], i5, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void setFillOverlayArray(int i5, CTFillOverlayEffect cTFillOverlayEffect) {
        generatedSetterHelperImpl(cTFillOverlayEffect, PROPERTY_QNAME[17], i5, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void setGlowArray(int i5, CTGlowEffect cTGlowEffect) {
        generatedSetterHelperImpl(cTGlowEffect, PROPERTY_QNAME[18], i5, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void setGraysclArray(int i5, CTGrayscaleEffect cTGrayscaleEffect) {
        generatedSetterHelperImpl(cTGrayscaleEffect, PROPERTY_QNAME[19], i5, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void setHslArray(int i5, CTHSLEffect cTHSLEffect) {
        generatedSetterHelperImpl(cTHSLEffect, PROPERTY_QNAME[20], i5, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void setInnerShdwArray(int i5, CTInnerShadowEffect cTInnerShadowEffect) {
        generatedSetterHelperImpl(cTInnerShadowEffect, PROPERTY_QNAME[21], i5, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void setLumArray(int i5, CTLuminanceEffect cTLuminanceEffect) {
        generatedSetterHelperImpl(cTLuminanceEffect, PROPERTY_QNAME[22], i5, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void setOuterShdwArray(int i5, CTOuterShadowEffect cTOuterShadowEffect) {
        generatedSetterHelperImpl(cTOuterShadowEffect, PROPERTY_QNAME[23], i5, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void setPrstShdwArray(int i5, CTPresetShadowEffect cTPresetShadowEffect) {
        generatedSetterHelperImpl(cTPresetShadowEffect, PROPERTY_QNAME[24], i5, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void setReflectionArray(int i5, CTReflectionEffect cTReflectionEffect) {
        generatedSetterHelperImpl(cTReflectionEffect, PROPERTY_QNAME[25], i5, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void setRelOffArray(int i5, CTRelativeOffsetEffect cTRelativeOffsetEffect) {
        generatedSetterHelperImpl(cTRelativeOffsetEffect, PROPERTY_QNAME[26], i5, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void setSoftEdgeArray(int i5, CTSoftEdgesEffect cTSoftEdgesEffect) {
        generatedSetterHelperImpl(cTSoftEdgesEffect, PROPERTY_QNAME[27], i5, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void setTintArray(int i5, CTTintEffect cTTintEffect) {
        generatedSetterHelperImpl(cTTintEffect, PROPERTY_QNAME[28], i5, (short) 2);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer
    public void setXfrmArray(int i5, CTTransformEffect cTTransformEffect) {
        generatedSetterHelperImpl(cTTransformEffect, PROPERTY_QNAME[29], i5, (short) 2);
    }
}
