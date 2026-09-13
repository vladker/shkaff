package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.poi.xssf.usermodel.XSSFRelation;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTablePartStyle;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyleCellStyle;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyleTextStyle;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class CTTablePartStyleImpl extends XmlComplexContentImpl implements CTTablePartStyle {
    private static final QName[] PROPERTY_QNAME = {new QName(XSSFRelation.NS_DRAWINGML, "tcTxStyle"), new QName(XSSFRelation.NS_DRAWINGML, "tcStyle")};
    private static final long serialVersionUID = 1;

    public CTTablePartStyleImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTablePartStyle
    public CTTableStyleCellStyle addNewTcStyle() {
        CTTableStyleCellStyle cTTableStyleCellStyle;
        synchronized (monitor()) {
            check_orphaned();
            cTTableStyleCellStyle = (CTTableStyleCellStyle) get_store().add_element_user(PROPERTY_QNAME[1]);
        }
        return cTTableStyleCellStyle;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTablePartStyle
    public CTTableStyleTextStyle addNewTcTxStyle() {
        CTTableStyleTextStyle cTTableStyleTextStyle;
        synchronized (monitor()) {
            check_orphaned();
            cTTableStyleTextStyle = (CTTableStyleTextStyle) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTTableStyleTextStyle;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTablePartStyle
    public CTTableStyleCellStyle getTcStyle() {
        CTTableStyleCellStyle cTTableStyleCellStyle;
        synchronized (monitor()) {
            check_orphaned();
            cTTableStyleCellStyle = (CTTableStyleCellStyle) get_store().find_element_user(PROPERTY_QNAME[1], 0);
            if (cTTableStyleCellStyle == null) {
                cTTableStyleCellStyle = null;
            }
        }
        return cTTableStyleCellStyle;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTablePartStyle
    public CTTableStyleTextStyle getTcTxStyle() {
        CTTableStyleTextStyle cTTableStyleTextStyle;
        synchronized (monitor()) {
            check_orphaned();
            cTTableStyleTextStyle = (CTTableStyleTextStyle) get_store().find_element_user(PROPERTY_QNAME[0], 0);
            if (cTTableStyleTextStyle == null) {
                cTTableStyleTextStyle = null;
            }
        }
        return cTTableStyleTextStyle;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTablePartStyle
    public boolean isSetTcStyle() {
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTablePartStyle
    public boolean isSetTcTxStyle() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[0]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTablePartStyle
    public void setTcStyle(CTTableStyleCellStyle cTTableStyleCellStyle) {
        generatedSetterHelperImpl(cTTableStyleCellStyle, PROPERTY_QNAME[1], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTablePartStyle
    public void setTcTxStyle(CTTableStyleTextStyle cTTableStyleTextStyle) {
        generatedSetterHelperImpl(cTTableStyleTextStyle, PROPERTY_QNAME[0], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTablePartStyle
    public void unsetTcStyle() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[1], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTablePartStyle
    public void unsetTcTxStyle() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], 0);
        }
    }
}
