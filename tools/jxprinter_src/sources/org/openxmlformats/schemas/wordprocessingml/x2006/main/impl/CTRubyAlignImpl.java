package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.poi.xssf.usermodel.XSSFRelation;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyAlign;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STRubyAlign;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public class CTRubyAlignImpl extends XmlComplexContentImpl implements CTRubyAlign {
    private static final QName[] PROPERTY_QNAME = {new QName(XSSFRelation.NS_WORDPROCESSINGML, "val")};
    private static final long serialVersionUID = 1;

    public CTRubyAlignImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyAlign
    public STRubyAlign.Enum getVal() {
        STRubyAlign.Enum r6;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[0]);
            r6 = simpleValue == null ? null : (STRubyAlign.Enum) simpleValue.getEnumValue();
        }
        return r6;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyAlign
    public void setVal(STRubyAlign.Enum r6) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[0]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[0]);
                }
                simpleValue.setEnumValue(r6);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyAlign
    public STRubyAlign xgetVal() {
        STRubyAlign sTRubyAlign;
        synchronized (monitor()) {
            check_orphaned();
            sTRubyAlign = (STRubyAlign) get_store().find_attribute_user(PROPERTY_QNAME[0]);
        }
        return sTRubyAlign;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRubyAlign
    public void xsetVal(STRubyAlign sTRubyAlign) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                STRubyAlign sTRubyAlign2 = (STRubyAlign) typeStore.find_attribute_user(qNameArr[0]);
                if (sTRubyAlign2 == null) {
                    sTRubyAlign2 = (STRubyAlign) get_store().add_attribute_user(qNameArr[0]);
                }
                sTRubyAlign2.set(sTRubyAlign);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
