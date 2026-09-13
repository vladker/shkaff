package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.poi.xssf.usermodel.XSSFRelation;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTColor;
import org.openxmlformats.schemas.drawingml.x2006.main.CTOfficeArtExtensionList;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextAutonumberBullet;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextBlipBullet;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextBulletColorFollowText;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextBulletSizeFollowText;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextBulletSizePercent;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextBulletSizePoint;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextBulletTypefaceFollowText;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextCharBullet;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextCharacterProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextFont;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextNoBullet;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextSpacing;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextTabStopList;
import org.openxmlformats.schemas.drawingml.x2006.main.STCoordinate32;
import org.openxmlformats.schemas.drawingml.x2006.main.STTextAlignType;
import org.openxmlformats.schemas.drawingml.x2006.main.STTextFontAlignType;
import org.openxmlformats.schemas.drawingml.x2006.main.STTextIndent;
import org.openxmlformats.schemas.drawingml.x2006.main.STTextIndentLevelType;
import org.openxmlformats.schemas.drawingml.x2006.main.STTextMargin;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class CTTextParagraphPropertiesImpl extends XmlComplexContentImpl implements CTTextParagraphProperties {
    private static final QName[] PROPERTY_QNAME = {new QName(XSSFRelation.NS_DRAWINGML, "lnSpc"), new QName(XSSFRelation.NS_DRAWINGML, "spcBef"), new QName(XSSFRelation.NS_DRAWINGML, "spcAft"), new QName(XSSFRelation.NS_DRAWINGML, "buClrTx"), new QName(XSSFRelation.NS_DRAWINGML, "buClr"), new QName(XSSFRelation.NS_DRAWINGML, "buSzTx"), new QName(XSSFRelation.NS_DRAWINGML, "buSzPct"), new QName(XSSFRelation.NS_DRAWINGML, "buSzPts"), new QName(XSSFRelation.NS_DRAWINGML, "buFontTx"), new QName(XSSFRelation.NS_DRAWINGML, "buFont"), new QName(XSSFRelation.NS_DRAWINGML, "buNone"), new QName(XSSFRelation.NS_DRAWINGML, "buAutoNum"), new QName(XSSFRelation.NS_DRAWINGML, "buChar"), new QName(XSSFRelation.NS_DRAWINGML, "buBlip"), new QName(XSSFRelation.NS_DRAWINGML, "tabLst"), new QName(XSSFRelation.NS_DRAWINGML, "defRPr"), new QName(XSSFRelation.NS_DRAWINGML, "extLst"), new QName("", "marL"), new QName("", "marR"), new QName("", "lvl"), new QName("", "indent"), new QName("", "algn"), new QName("", "defTabSz"), new QName("", "rtl"), new QName("", "eaLnBrk"), new QName("", "fontAlgn"), new QName("", "latinLnBrk"), new QName("", "hangingPunct")};
    private static final long serialVersionUID = 1;

    public CTTextParagraphPropertiesImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public CTTextAutonumberBullet addNewBuAutoNum() {
        CTTextAutonumberBullet cTTextAutonumberBullet;
        synchronized (monitor()) {
            check_orphaned();
            cTTextAutonumberBullet = (CTTextAutonumberBullet) get_store().add_element_user(PROPERTY_QNAME[11]);
        }
        return cTTextAutonumberBullet;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public CTTextBlipBullet addNewBuBlip() {
        CTTextBlipBullet cTTextBlipBullet;
        synchronized (monitor()) {
            check_orphaned();
            cTTextBlipBullet = (CTTextBlipBullet) get_store().add_element_user(PROPERTY_QNAME[13]);
        }
        return cTTextBlipBullet;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public CTTextCharBullet addNewBuChar() {
        CTTextCharBullet cTTextCharBullet;
        synchronized (monitor()) {
            check_orphaned();
            cTTextCharBullet = (CTTextCharBullet) get_store().add_element_user(PROPERTY_QNAME[12]);
        }
        return cTTextCharBullet;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public CTColor addNewBuClr() {
        CTColor cTColor;
        synchronized (monitor()) {
            check_orphaned();
            cTColor = (CTColor) get_store().add_element_user(PROPERTY_QNAME[4]);
        }
        return cTColor;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public CTTextBulletColorFollowText addNewBuClrTx() {
        CTTextBulletColorFollowText cTTextBulletColorFollowText;
        synchronized (monitor()) {
            check_orphaned();
            cTTextBulletColorFollowText = (CTTextBulletColorFollowText) get_store().add_element_user(PROPERTY_QNAME[3]);
        }
        return cTTextBulletColorFollowText;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public CTTextFont addNewBuFont() {
        CTTextFont cTTextFont;
        synchronized (monitor()) {
            check_orphaned();
            cTTextFont = (CTTextFont) get_store().add_element_user(PROPERTY_QNAME[9]);
        }
        return cTTextFont;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public CTTextBulletTypefaceFollowText addNewBuFontTx() {
        CTTextBulletTypefaceFollowText cTTextBulletTypefaceFollowText;
        synchronized (monitor()) {
            check_orphaned();
            cTTextBulletTypefaceFollowText = (CTTextBulletTypefaceFollowText) get_store().add_element_user(PROPERTY_QNAME[8]);
        }
        return cTTextBulletTypefaceFollowText;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public CTTextNoBullet addNewBuNone() {
        CTTextNoBullet cTTextNoBullet;
        synchronized (monitor()) {
            check_orphaned();
            cTTextNoBullet = (CTTextNoBullet) get_store().add_element_user(PROPERTY_QNAME[10]);
        }
        return cTTextNoBullet;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public CTTextBulletSizePercent addNewBuSzPct() {
        CTTextBulletSizePercent cTTextBulletSizePercent;
        synchronized (monitor()) {
            check_orphaned();
            cTTextBulletSizePercent = (CTTextBulletSizePercent) get_store().add_element_user(PROPERTY_QNAME[6]);
        }
        return cTTextBulletSizePercent;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public CTTextBulletSizePoint addNewBuSzPts() {
        CTTextBulletSizePoint cTTextBulletSizePoint;
        synchronized (monitor()) {
            check_orphaned();
            cTTextBulletSizePoint = (CTTextBulletSizePoint) get_store().add_element_user(PROPERTY_QNAME[7]);
        }
        return cTTextBulletSizePoint;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public CTTextBulletSizeFollowText addNewBuSzTx() {
        CTTextBulletSizeFollowText cTTextBulletSizeFollowText;
        synchronized (monitor()) {
            check_orphaned();
            cTTextBulletSizeFollowText = (CTTextBulletSizeFollowText) get_store().add_element_user(PROPERTY_QNAME[5]);
        }
        return cTTextBulletSizeFollowText;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public CTTextCharacterProperties addNewDefRPr() {
        CTTextCharacterProperties cTTextCharacterProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTTextCharacterProperties = (CTTextCharacterProperties) get_store().add_element_user(PROPERTY_QNAME[15]);
        }
        return cTTextCharacterProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public CTOfficeArtExtensionList addNewExtLst() {
        CTOfficeArtExtensionList cTOfficeArtExtensionList;
        synchronized (monitor()) {
            check_orphaned();
            cTOfficeArtExtensionList = (CTOfficeArtExtensionList) get_store().add_element_user(PROPERTY_QNAME[16]);
        }
        return cTOfficeArtExtensionList;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public CTTextSpacing addNewLnSpc() {
        CTTextSpacing cTTextSpacing;
        synchronized (monitor()) {
            check_orphaned();
            cTTextSpacing = (CTTextSpacing) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTTextSpacing;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public CTTextSpacing addNewSpcAft() {
        CTTextSpacing cTTextSpacing;
        synchronized (monitor()) {
            check_orphaned();
            cTTextSpacing = (CTTextSpacing) get_store().add_element_user(PROPERTY_QNAME[2]);
        }
        return cTTextSpacing;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public CTTextSpacing addNewSpcBef() {
        CTTextSpacing cTTextSpacing;
        synchronized (monitor()) {
            check_orphaned();
            cTTextSpacing = (CTTextSpacing) get_store().add_element_user(PROPERTY_QNAME[1]);
        }
        return cTTextSpacing;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public CTTextTabStopList addNewTabLst() {
        CTTextTabStopList cTTextTabStopList;
        synchronized (monitor()) {
            check_orphaned();
            cTTextTabStopList = (CTTextTabStopList) get_store().add_element_user(PROPERTY_QNAME[14]);
        }
        return cTTextTabStopList;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public STTextAlignType.Enum getAlgn() {
        STTextAlignType.Enum r6;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[21]);
            r6 = simpleValue == null ? null : (STTextAlignType.Enum) simpleValue.getEnumValue();
        }
        return r6;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public CTTextAutonumberBullet getBuAutoNum() {
        CTTextAutonumberBullet cTTextAutonumberBullet;
        synchronized (monitor()) {
            check_orphaned();
            cTTextAutonumberBullet = (CTTextAutonumberBullet) get_store().find_element_user(PROPERTY_QNAME[11], 0);
            if (cTTextAutonumberBullet == null) {
                cTTextAutonumberBullet = null;
            }
        }
        return cTTextAutonumberBullet;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public CTTextBlipBullet getBuBlip() {
        CTTextBlipBullet cTTextBlipBullet;
        synchronized (monitor()) {
            check_orphaned();
            cTTextBlipBullet = (CTTextBlipBullet) get_store().find_element_user(PROPERTY_QNAME[13], 0);
            if (cTTextBlipBullet == null) {
                cTTextBlipBullet = null;
            }
        }
        return cTTextBlipBullet;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public CTTextCharBullet getBuChar() {
        CTTextCharBullet cTTextCharBullet;
        synchronized (monitor()) {
            check_orphaned();
            cTTextCharBullet = (CTTextCharBullet) get_store().find_element_user(PROPERTY_QNAME[12], 0);
            if (cTTextCharBullet == null) {
                cTTextCharBullet = null;
            }
        }
        return cTTextCharBullet;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public CTColor getBuClr() {
        CTColor cTColor;
        synchronized (monitor()) {
            check_orphaned();
            cTColor = (CTColor) get_store().find_element_user(PROPERTY_QNAME[4], 0);
            if (cTColor == null) {
                cTColor = null;
            }
        }
        return cTColor;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public CTTextBulletColorFollowText getBuClrTx() {
        CTTextBulletColorFollowText cTTextBulletColorFollowText;
        synchronized (monitor()) {
            check_orphaned();
            cTTextBulletColorFollowText = (CTTextBulletColorFollowText) get_store().find_element_user(PROPERTY_QNAME[3], 0);
            if (cTTextBulletColorFollowText == null) {
                cTTextBulletColorFollowText = null;
            }
        }
        return cTTextBulletColorFollowText;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public CTTextFont getBuFont() {
        CTTextFont cTTextFont;
        synchronized (monitor()) {
            check_orphaned();
            cTTextFont = (CTTextFont) get_store().find_element_user(PROPERTY_QNAME[9], 0);
            if (cTTextFont == null) {
                cTTextFont = null;
            }
        }
        return cTTextFont;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public CTTextBulletTypefaceFollowText getBuFontTx() {
        CTTextBulletTypefaceFollowText cTTextBulletTypefaceFollowText;
        synchronized (monitor()) {
            check_orphaned();
            cTTextBulletTypefaceFollowText = (CTTextBulletTypefaceFollowText) get_store().find_element_user(PROPERTY_QNAME[8], 0);
            if (cTTextBulletTypefaceFollowText == null) {
                cTTextBulletTypefaceFollowText = null;
            }
        }
        return cTTextBulletTypefaceFollowText;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public CTTextNoBullet getBuNone() {
        CTTextNoBullet cTTextNoBullet;
        synchronized (monitor()) {
            check_orphaned();
            cTTextNoBullet = (CTTextNoBullet) get_store().find_element_user(PROPERTY_QNAME[10], 0);
            if (cTTextNoBullet == null) {
                cTTextNoBullet = null;
            }
        }
        return cTTextNoBullet;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public CTTextBulletSizePercent getBuSzPct() {
        CTTextBulletSizePercent cTTextBulletSizePercent;
        synchronized (monitor()) {
            check_orphaned();
            cTTextBulletSizePercent = (CTTextBulletSizePercent) get_store().find_element_user(PROPERTY_QNAME[6], 0);
            if (cTTextBulletSizePercent == null) {
                cTTextBulletSizePercent = null;
            }
        }
        return cTTextBulletSizePercent;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public CTTextBulletSizePoint getBuSzPts() {
        CTTextBulletSizePoint cTTextBulletSizePoint;
        synchronized (monitor()) {
            check_orphaned();
            cTTextBulletSizePoint = (CTTextBulletSizePoint) get_store().find_element_user(PROPERTY_QNAME[7], 0);
            if (cTTextBulletSizePoint == null) {
                cTTextBulletSizePoint = null;
            }
        }
        return cTTextBulletSizePoint;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public CTTextBulletSizeFollowText getBuSzTx() {
        CTTextBulletSizeFollowText cTTextBulletSizeFollowText;
        synchronized (monitor()) {
            check_orphaned();
            cTTextBulletSizeFollowText = (CTTextBulletSizeFollowText) get_store().find_element_user(PROPERTY_QNAME[5], 0);
            if (cTTextBulletSizeFollowText == null) {
                cTTextBulletSizeFollowText = null;
            }
        }
        return cTTextBulletSizeFollowText;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public CTTextCharacterProperties getDefRPr() {
        CTTextCharacterProperties cTTextCharacterProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTTextCharacterProperties = (CTTextCharacterProperties) get_store().find_element_user(PROPERTY_QNAME[15], 0);
            if (cTTextCharacterProperties == null) {
                cTTextCharacterProperties = null;
            }
        }
        return cTTextCharacterProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public Object getDefTabSz() {
        Object objectValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[22]);
            objectValue = simpleValue == null ? null : simpleValue.getObjectValue();
        }
        return objectValue;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public boolean getEaLnBrk() {
        boolean booleanValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[24]);
            booleanValue = simpleValue == null ? false : simpleValue.getBooleanValue();
        }
        return booleanValue;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public CTOfficeArtExtensionList getExtLst() {
        CTOfficeArtExtensionList cTOfficeArtExtensionList;
        synchronized (monitor()) {
            check_orphaned();
            cTOfficeArtExtensionList = (CTOfficeArtExtensionList) get_store().find_element_user(PROPERTY_QNAME[16], 0);
            if (cTOfficeArtExtensionList == null) {
                cTOfficeArtExtensionList = null;
            }
        }
        return cTOfficeArtExtensionList;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public STTextFontAlignType.Enum getFontAlgn() {
        STTextFontAlignType.Enum r6;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[25]);
            r6 = simpleValue == null ? null : (STTextFontAlignType.Enum) simpleValue.getEnumValue();
        }
        return r6;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public boolean getHangingPunct() {
        boolean booleanValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[27]);
            booleanValue = simpleValue == null ? false : simpleValue.getBooleanValue();
        }
        return booleanValue;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public int getIndent() {
        int intValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[20]);
            intValue = simpleValue == null ? 0 : simpleValue.getIntValue();
        }
        return intValue;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public boolean getLatinLnBrk() {
        boolean booleanValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[26]);
            booleanValue = simpleValue == null ? false : simpleValue.getBooleanValue();
        }
        return booleanValue;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public CTTextSpacing getLnSpc() {
        CTTextSpacing cTTextSpacing;
        synchronized (monitor()) {
            check_orphaned();
            cTTextSpacing = (CTTextSpacing) get_store().find_element_user(PROPERTY_QNAME[0], 0);
            if (cTTextSpacing == null) {
                cTTextSpacing = null;
            }
        }
        return cTTextSpacing;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public int getLvl() {
        int intValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[19]);
            intValue = simpleValue == null ? 0 : simpleValue.getIntValue();
        }
        return intValue;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public int getMarL() {
        int intValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[17]);
            intValue = simpleValue == null ? 0 : simpleValue.getIntValue();
        }
        return intValue;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public int getMarR() {
        int intValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[18]);
            intValue = simpleValue == null ? 0 : simpleValue.getIntValue();
        }
        return intValue;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public boolean getRtl() {
        boolean booleanValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[23]);
            booleanValue = simpleValue == null ? false : simpleValue.getBooleanValue();
        }
        return booleanValue;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public CTTextSpacing getSpcAft() {
        CTTextSpacing cTTextSpacing;
        synchronized (monitor()) {
            check_orphaned();
            cTTextSpacing = (CTTextSpacing) get_store().find_element_user(PROPERTY_QNAME[2], 0);
            if (cTTextSpacing == null) {
                cTTextSpacing = null;
            }
        }
        return cTTextSpacing;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public CTTextSpacing getSpcBef() {
        CTTextSpacing cTTextSpacing;
        synchronized (monitor()) {
            check_orphaned();
            cTTextSpacing = (CTTextSpacing) get_store().find_element_user(PROPERTY_QNAME[1], 0);
            if (cTTextSpacing == null) {
                cTTextSpacing = null;
            }
        }
        return cTTextSpacing;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public CTTextTabStopList getTabLst() {
        CTTextTabStopList cTTextTabStopList;
        synchronized (monitor()) {
            check_orphaned();
            cTTextTabStopList = (CTTextTabStopList) get_store().find_element_user(PROPERTY_QNAME[14], 0);
            if (cTTextTabStopList == null) {
                cTTextTabStopList = null;
            }
        }
        return cTTextTabStopList;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public boolean isSetAlgn() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().find_attribute_user(PROPERTY_QNAME[21]) != null;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public boolean isSetBuAutoNum() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[11]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public boolean isSetBuBlip() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[13]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public boolean isSetBuChar() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[12]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public boolean isSetBuClr() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[4]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public boolean isSetBuClrTx() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[3]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public boolean isSetBuFont() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[9]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public boolean isSetBuFontTx() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[8]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public boolean isSetBuNone() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[10]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public boolean isSetBuSzPct() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[6]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public boolean isSetBuSzPts() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[7]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public boolean isSetBuSzTx() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[5]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public boolean isSetDefRPr() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[15]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public boolean isSetDefTabSz() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().find_attribute_user(PROPERTY_QNAME[22]) != null;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public boolean isSetEaLnBrk() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().find_attribute_user(PROPERTY_QNAME[24]) != null;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public boolean isSetExtLst() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[16]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public boolean isSetFontAlgn() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().find_attribute_user(PROPERTY_QNAME[25]) != null;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public boolean isSetHangingPunct() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().find_attribute_user(PROPERTY_QNAME[27]) != null;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public boolean isSetIndent() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().find_attribute_user(PROPERTY_QNAME[20]) != null;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public boolean isSetLatinLnBrk() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().find_attribute_user(PROPERTY_QNAME[26]) != null;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public boolean isSetLnSpc() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[0]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public boolean isSetLvl() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().find_attribute_user(PROPERTY_QNAME[19]) != null;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public boolean isSetMarL() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().find_attribute_user(PROPERTY_QNAME[17]) != null;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public boolean isSetMarR() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().find_attribute_user(PROPERTY_QNAME[18]) != null;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public boolean isSetRtl() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().find_attribute_user(PROPERTY_QNAME[23]) != null;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public boolean isSetSpcAft() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[2]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public boolean isSetSpcBef() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = true;
            if (get_store().count_elements(PROPERTY_QNAME[1]) == 0) {
                z6 = false;
            }
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public boolean isSetTabLst() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[14]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public void setAlgn(STTextAlignType.Enum r6) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[21]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[21]);
                }
                simpleValue.setEnumValue(r6);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public void setBuAutoNum(CTTextAutonumberBullet cTTextAutonumberBullet) {
        generatedSetterHelperImpl(cTTextAutonumberBullet, PROPERTY_QNAME[11], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public void setBuBlip(CTTextBlipBullet cTTextBlipBullet) {
        generatedSetterHelperImpl(cTTextBlipBullet, PROPERTY_QNAME[13], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public void setBuChar(CTTextCharBullet cTTextCharBullet) {
        generatedSetterHelperImpl(cTTextCharBullet, PROPERTY_QNAME[12], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public void setBuClr(CTColor cTColor) {
        generatedSetterHelperImpl(cTColor, PROPERTY_QNAME[4], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public void setBuClrTx(CTTextBulletColorFollowText cTTextBulletColorFollowText) {
        generatedSetterHelperImpl(cTTextBulletColorFollowText, PROPERTY_QNAME[3], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public void setBuFont(CTTextFont cTTextFont) {
        generatedSetterHelperImpl(cTTextFont, PROPERTY_QNAME[9], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public void setBuFontTx(CTTextBulletTypefaceFollowText cTTextBulletTypefaceFollowText) {
        generatedSetterHelperImpl(cTTextBulletTypefaceFollowText, PROPERTY_QNAME[8], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public void setBuNone(CTTextNoBullet cTTextNoBullet) {
        generatedSetterHelperImpl(cTTextNoBullet, PROPERTY_QNAME[10], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public void setBuSzPct(CTTextBulletSizePercent cTTextBulletSizePercent) {
        generatedSetterHelperImpl(cTTextBulletSizePercent, PROPERTY_QNAME[6], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public void setBuSzPts(CTTextBulletSizePoint cTTextBulletSizePoint) {
        generatedSetterHelperImpl(cTTextBulletSizePoint, PROPERTY_QNAME[7], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public void setBuSzTx(CTTextBulletSizeFollowText cTTextBulletSizeFollowText) {
        generatedSetterHelperImpl(cTTextBulletSizeFollowText, PROPERTY_QNAME[5], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public void setDefRPr(CTTextCharacterProperties cTTextCharacterProperties) {
        generatedSetterHelperImpl(cTTextCharacterProperties, PROPERTY_QNAME[15], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public void setDefTabSz(Object obj) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[22]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[22]);
                }
                simpleValue.setObjectValue(obj);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public void setEaLnBrk(boolean z6) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[24]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[24]);
                }
                simpleValue.setBooleanValue(z6);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public void setExtLst(CTOfficeArtExtensionList cTOfficeArtExtensionList) {
        generatedSetterHelperImpl(cTOfficeArtExtensionList, PROPERTY_QNAME[16], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public void setFontAlgn(STTextFontAlignType.Enum r6) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[25]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[25]);
                }
                simpleValue.setEnumValue(r6);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public void setHangingPunct(boolean z6) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[27]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[27]);
                }
                simpleValue.setBooleanValue(z6);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public void setIndent(int i5) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[20]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[20]);
                }
                simpleValue.setIntValue(i5);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public void setLatinLnBrk(boolean z6) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[26]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[26]);
                }
                simpleValue.setBooleanValue(z6);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public void setLnSpc(CTTextSpacing cTTextSpacing) {
        generatedSetterHelperImpl(cTTextSpacing, PROPERTY_QNAME[0], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public void setLvl(int i5) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[19]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[19]);
                }
                simpleValue.setIntValue(i5);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public void setMarL(int i5) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[17]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[17]);
                }
                simpleValue.setIntValue(i5);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public void setMarR(int i5) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[18]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[18]);
                }
                simpleValue.setIntValue(i5);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public void setRtl(boolean z6) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[23]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[23]);
                }
                simpleValue.setBooleanValue(z6);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public void setSpcAft(CTTextSpacing cTTextSpacing) {
        generatedSetterHelperImpl(cTTextSpacing, PROPERTY_QNAME[2], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public void setSpcBef(CTTextSpacing cTTextSpacing) {
        generatedSetterHelperImpl(cTTextSpacing, PROPERTY_QNAME[1], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public void setTabLst(CTTextTabStopList cTTextTabStopList) {
        generatedSetterHelperImpl(cTTextTabStopList, PROPERTY_QNAME[14], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public void unsetAlgn() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[21]);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public void unsetBuAutoNum() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[11], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public void unsetBuBlip() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[13], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public void unsetBuChar() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[12], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public void unsetBuClr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[4], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public void unsetBuClrTx() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[3], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public void unsetBuFont() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[9], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public void unsetBuFontTx() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[8], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public void unsetBuNone() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[10], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public void unsetBuSzPct() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[6], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public void unsetBuSzPts() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[7], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public void unsetBuSzTx() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[5], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public void unsetDefRPr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[15], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public void unsetDefTabSz() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[22]);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public void unsetEaLnBrk() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[24]);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public void unsetExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[16], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public void unsetFontAlgn() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[25]);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public void unsetHangingPunct() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[27]);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public void unsetIndent() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[20]);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public void unsetLatinLnBrk() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[26]);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public void unsetLnSpc() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public void unsetLvl() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[19]);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public void unsetMarL() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[17]);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public void unsetMarR() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[18]);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public void unsetRtl() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[23]);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public void unsetSpcAft() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[2], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public void unsetSpcBef() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[1], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public void unsetTabLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[14], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public STTextAlignType xgetAlgn() {
        STTextAlignType sTTextAlignType;
        synchronized (monitor()) {
            check_orphaned();
            sTTextAlignType = (STTextAlignType) get_store().find_attribute_user(PROPERTY_QNAME[21]);
        }
        return sTTextAlignType;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public STCoordinate32 xgetDefTabSz() {
        STCoordinate32 sTCoordinate32;
        synchronized (monitor()) {
            check_orphaned();
            sTCoordinate32 = (STCoordinate32) get_store().find_attribute_user(PROPERTY_QNAME[22]);
        }
        return sTCoordinate32;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public XmlBoolean xgetEaLnBrk() {
        XmlBoolean xmlBoolean;
        synchronized (monitor()) {
            check_orphaned();
            xmlBoolean = (XmlBoolean) get_store().find_attribute_user(PROPERTY_QNAME[24]);
        }
        return xmlBoolean;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public STTextFontAlignType xgetFontAlgn() {
        STTextFontAlignType sTTextFontAlignType;
        synchronized (monitor()) {
            check_orphaned();
            sTTextFontAlignType = (STTextFontAlignType) get_store().find_attribute_user(PROPERTY_QNAME[25]);
        }
        return sTTextFontAlignType;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public XmlBoolean xgetHangingPunct() {
        XmlBoolean xmlBoolean;
        synchronized (monitor()) {
            check_orphaned();
            xmlBoolean = (XmlBoolean) get_store().find_attribute_user(PROPERTY_QNAME[27]);
        }
        return xmlBoolean;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public STTextIndent xgetIndent() {
        STTextIndent sTTextIndent;
        synchronized (monitor()) {
            check_orphaned();
            sTTextIndent = (STTextIndent) get_store().find_attribute_user(PROPERTY_QNAME[20]);
        }
        return sTTextIndent;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public XmlBoolean xgetLatinLnBrk() {
        XmlBoolean xmlBoolean;
        synchronized (monitor()) {
            check_orphaned();
            xmlBoolean = (XmlBoolean) get_store().find_attribute_user(PROPERTY_QNAME[26]);
        }
        return xmlBoolean;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public STTextIndentLevelType xgetLvl() {
        STTextIndentLevelType sTTextIndentLevelType;
        synchronized (monitor()) {
            check_orphaned();
            sTTextIndentLevelType = (STTextIndentLevelType) get_store().find_attribute_user(PROPERTY_QNAME[19]);
        }
        return sTTextIndentLevelType;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public STTextMargin xgetMarL() {
        STTextMargin sTTextMargin;
        synchronized (monitor()) {
            check_orphaned();
            sTTextMargin = (STTextMargin) get_store().find_attribute_user(PROPERTY_QNAME[17]);
        }
        return sTTextMargin;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public STTextMargin xgetMarR() {
        STTextMargin sTTextMargin;
        synchronized (monitor()) {
            check_orphaned();
            sTTextMargin = (STTextMargin) get_store().find_attribute_user(PROPERTY_QNAME[18]);
        }
        return sTTextMargin;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public XmlBoolean xgetRtl() {
        XmlBoolean xmlBoolean;
        synchronized (monitor()) {
            check_orphaned();
            xmlBoolean = (XmlBoolean) get_store().find_attribute_user(PROPERTY_QNAME[23]);
        }
        return xmlBoolean;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public void xsetAlgn(STTextAlignType sTTextAlignType) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                STTextAlignType sTTextAlignType2 = (STTextAlignType) typeStore.find_attribute_user(qNameArr[21]);
                if (sTTextAlignType2 == null) {
                    sTTextAlignType2 = (STTextAlignType) get_store().add_attribute_user(qNameArr[21]);
                }
                sTTextAlignType2.set(sTTextAlignType);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public void xsetDefTabSz(STCoordinate32 sTCoordinate32) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                STCoordinate32 sTCoordinate33 = (STCoordinate32) typeStore.find_attribute_user(qNameArr[22]);
                if (sTCoordinate33 == null) {
                    sTCoordinate33 = (STCoordinate32) get_store().add_attribute_user(qNameArr[22]);
                }
                sTCoordinate33.set(sTCoordinate32);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public void xsetEaLnBrk(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                XmlBoolean xmlBoolean2 = (XmlBoolean) typeStore.find_attribute_user(qNameArr[24]);
                if (xmlBoolean2 == null) {
                    xmlBoolean2 = (XmlBoolean) get_store().add_attribute_user(qNameArr[24]);
                }
                xmlBoolean2.set(xmlBoolean);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public void xsetFontAlgn(STTextFontAlignType sTTextFontAlignType) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                STTextFontAlignType sTTextFontAlignType2 = (STTextFontAlignType) typeStore.find_attribute_user(qNameArr[25]);
                if (sTTextFontAlignType2 == null) {
                    sTTextFontAlignType2 = (STTextFontAlignType) get_store().add_attribute_user(qNameArr[25]);
                }
                sTTextFontAlignType2.set(sTTextFontAlignType);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public void xsetHangingPunct(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                XmlBoolean xmlBoolean2 = (XmlBoolean) typeStore.find_attribute_user(qNameArr[27]);
                if (xmlBoolean2 == null) {
                    xmlBoolean2 = (XmlBoolean) get_store().add_attribute_user(qNameArr[27]);
                }
                xmlBoolean2.set(xmlBoolean);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public void xsetIndent(STTextIndent sTTextIndent) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                STTextIndent sTTextIndent2 = (STTextIndent) typeStore.find_attribute_user(qNameArr[20]);
                if (sTTextIndent2 == null) {
                    sTTextIndent2 = (STTextIndent) get_store().add_attribute_user(qNameArr[20]);
                }
                sTTextIndent2.set(sTTextIndent);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public void xsetLatinLnBrk(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                XmlBoolean xmlBoolean2 = (XmlBoolean) typeStore.find_attribute_user(qNameArr[26]);
                if (xmlBoolean2 == null) {
                    xmlBoolean2 = (XmlBoolean) get_store().add_attribute_user(qNameArr[26]);
                }
                xmlBoolean2.set(xmlBoolean);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public void xsetLvl(STTextIndentLevelType sTTextIndentLevelType) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                STTextIndentLevelType sTTextIndentLevelType2 = (STTextIndentLevelType) typeStore.find_attribute_user(qNameArr[19]);
                if (sTTextIndentLevelType2 == null) {
                    sTTextIndentLevelType2 = (STTextIndentLevelType) get_store().add_attribute_user(qNameArr[19]);
                }
                sTTextIndentLevelType2.set(sTTextIndentLevelType);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public void xsetMarL(STTextMargin sTTextMargin) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                STTextMargin sTTextMargin2 = (STTextMargin) typeStore.find_attribute_user(qNameArr[17]);
                if (sTTextMargin2 == null) {
                    sTTextMargin2 = (STTextMargin) get_store().add_attribute_user(qNameArr[17]);
                }
                sTTextMargin2.set(sTTextMargin);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public void xsetMarR(STTextMargin sTTextMargin) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                STTextMargin sTTextMargin2 = (STTextMargin) typeStore.find_attribute_user(qNameArr[18]);
                if (sTTextMargin2 == null) {
                    sTTextMargin2 = (STTextMargin) get_store().add_attribute_user(qNameArr[18]);
                }
                sTTextMargin2.set(sTTextMargin);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties
    public void xsetRtl(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                XmlBoolean xmlBoolean2 = (XmlBoolean) typeStore.find_attribute_user(qNameArr[23]);
                if (xmlBoolean2 == null) {
                    xmlBoolean2 = (XmlBoolean) get_store().add_attribute_user(qNameArr[23]);
                }
                xmlBoolean2.set(xmlBoolean);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
