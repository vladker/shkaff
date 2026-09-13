package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import java.util.Calendar;
import javax.xml.namespace.QName;
import org.apache.poi.xssf.usermodel.XSSFRelation;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTCalendarType;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLang;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtDate;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtDateMappingType;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTString;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STDateTime;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public class CTSdtDateImpl extends XmlComplexContentImpl implements CTSdtDate {
    private static final QName[] PROPERTY_QNAME = {new QName(XSSFRelation.NS_WORDPROCESSINGML, "dateFormat"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "lid"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "storeMappedDataAs"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "calendar"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "fullDate")};
    private static final long serialVersionUID = 1;

    public CTSdtDateImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtDate
    public CTCalendarType addNewCalendar() {
        CTCalendarType cTCalendarType;
        synchronized (monitor()) {
            check_orphaned();
            cTCalendarType = (CTCalendarType) get_store().add_element_user(PROPERTY_QNAME[3]);
        }
        return cTCalendarType;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtDate
    public CTString addNewDateFormat() {
        CTString cTString;
        synchronized (monitor()) {
            check_orphaned();
            cTString = (CTString) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTString;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtDate
    public CTLang addNewLid() {
        CTLang cTLang;
        synchronized (monitor()) {
            check_orphaned();
            cTLang = (CTLang) get_store().add_element_user(PROPERTY_QNAME[1]);
        }
        return cTLang;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtDate
    public CTSdtDateMappingType addNewStoreMappedDataAs() {
        CTSdtDateMappingType cTSdtDateMappingType;
        synchronized (monitor()) {
            check_orphaned();
            cTSdtDateMappingType = (CTSdtDateMappingType) get_store().add_element_user(PROPERTY_QNAME[2]);
        }
        return cTSdtDateMappingType;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtDate
    public CTCalendarType getCalendar() {
        CTCalendarType cTCalendarType;
        synchronized (monitor()) {
            check_orphaned();
            cTCalendarType = (CTCalendarType) get_store().find_element_user(PROPERTY_QNAME[3], 0);
            if (cTCalendarType == null) {
                cTCalendarType = null;
            }
        }
        return cTCalendarType;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtDate
    public CTString getDateFormat() {
        CTString cTString;
        synchronized (monitor()) {
            check_orphaned();
            cTString = (CTString) get_store().find_element_user(PROPERTY_QNAME[0], 0);
            if (cTString == null) {
                cTString = null;
            }
        }
        return cTString;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtDate
    public Calendar getFullDate() {
        Calendar calendarValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[4]);
            calendarValue = simpleValue == null ? null : simpleValue.getCalendarValue();
        }
        return calendarValue;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtDate
    public CTLang getLid() {
        CTLang cTLang;
        synchronized (monitor()) {
            check_orphaned();
            cTLang = (CTLang) get_store().find_element_user(PROPERTY_QNAME[1], 0);
            if (cTLang == null) {
                cTLang = null;
            }
        }
        return cTLang;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtDate
    public CTSdtDateMappingType getStoreMappedDataAs() {
        CTSdtDateMappingType cTSdtDateMappingType;
        synchronized (monitor()) {
            check_orphaned();
            cTSdtDateMappingType = (CTSdtDateMappingType) get_store().find_element_user(PROPERTY_QNAME[2], 0);
            if (cTSdtDateMappingType == null) {
                cTSdtDateMappingType = null;
            }
        }
        return cTSdtDateMappingType;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtDate
    public boolean isSetCalendar() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[3]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtDate
    public boolean isSetDateFormat() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[0]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtDate
    public boolean isSetFullDate() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().find_attribute_user(PROPERTY_QNAME[4]) != null;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtDate
    public boolean isSetLid() {
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtDate
    public boolean isSetStoreMappedDataAs() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[2]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtDate
    public void setCalendar(CTCalendarType cTCalendarType) {
        generatedSetterHelperImpl(cTCalendarType, PROPERTY_QNAME[3], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtDate
    public void setDateFormat(CTString cTString) {
        generatedSetterHelperImpl(cTString, PROPERTY_QNAME[0], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtDate
    public void setFullDate(Calendar calendar) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[4]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[4]);
                }
                simpleValue.setCalendarValue(calendar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtDate
    public void setLid(CTLang cTLang) {
        generatedSetterHelperImpl(cTLang, PROPERTY_QNAME[1], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtDate
    public void setStoreMappedDataAs(CTSdtDateMappingType cTSdtDateMappingType) {
        generatedSetterHelperImpl(cTSdtDateMappingType, PROPERTY_QNAME[2], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtDate
    public void unsetCalendar() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[3], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtDate
    public void unsetDateFormat() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtDate
    public void unsetFullDate() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[4]);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtDate
    public void unsetLid() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[1], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtDate
    public void unsetStoreMappedDataAs() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[2], 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtDate
    public STDateTime xgetFullDate() {
        STDateTime sTDateTime;
        synchronized (monitor()) {
            check_orphaned();
            sTDateTime = (STDateTime) get_store().find_attribute_user(PROPERTY_QNAME[4]);
        }
        return sTDateTime;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtDate
    public void xsetFullDate(STDateTime sTDateTime) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                STDateTime sTDateTime2 = (STDateTime) typeStore.find_attribute_user(qNameArr[4]);
                if (sTDateTime2 == null) {
                    sTDateTime2 = (STDateTime) get_store().add_attribute_user(qNameArr[4]);
                }
                sTDateTime2.set(sTDateTime);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
