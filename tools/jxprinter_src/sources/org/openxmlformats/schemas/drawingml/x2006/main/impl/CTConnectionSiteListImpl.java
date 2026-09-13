package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import H4.d;
import J4.b;
import J4.c;
import java.util.List;
import java.util.function.Function;
import javax.xml.namespace.QName;
import org.apache.poi.xssf.usermodel.XSSFRelation;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.JavaListXmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTConnectionSite;
import org.openxmlformats.schemas.drawingml.x2006.main.CTConnectionSiteList;
import org.openxmlformats.schemas.drawingml.x2006.main.impl.CTConnectionSiteListImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class CTConnectionSiteListImpl extends XmlComplexContentImpl implements CTConnectionSiteList {
    private static final QName[] PROPERTY_QNAME = {new QName(XSSFRelation.NS_DRAWINGML, "cxn")};
    private static final long serialVersionUID = 1;

    public CTConnectionSiteListImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTConnectionSiteList
    public CTConnectionSite addNewCxn() {
        CTConnectionSite cTConnectionSite;
        synchronized (monitor()) {
            check_orphaned();
            cTConnectionSite = (CTConnectionSite) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTConnectionSite;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTConnectionSiteList
    public CTConnectionSite[] getCxnArray() {
        return (CTConnectionSite[]) getXmlObjectArray(PROPERTY_QNAME[0], new CTConnectionSite[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTConnectionSiteList
    public List<CTConnectionSite> getCxnList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            final int i5 = 0;
            final int i6 = 1;
            javaListXmlObject = new JavaListXmlObject(new Function(this) { // from class: l5.C
                public final /* synthetic */ CTConnectionSiteListImpl b;

                {
                    this.b = this;
                }

                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    int i7 = i5;
                    int iIntValue = ((Integer) obj).intValue();
                    switch (i7) {
                        case 0:
                            return this.b.getCxnArray(iIntValue);
                        default:
                            return this.b.insertNewCxn(iIntValue);
                    }
                }
            }, new b(this, 17), new Function(this) { // from class: l5.C
                public final /* synthetic */ CTConnectionSiteListImpl b;

                {
                    this.b = this;
                }

                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    int i7 = i6;
                    int iIntValue = ((Integer) obj).intValue();
                    switch (i7) {
                        case 0:
                            return this.b.getCxnArray(iIntValue);
                        default:
                            return this.b.insertNewCxn(iIntValue);
                    }
                }
            }, new c(this, 18), new d(this, 19));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTConnectionSiteList
    public CTConnectionSite insertNewCxn(int i5) {
        CTConnectionSite cTConnectionSite;
        synchronized (monitor()) {
            check_orphaned();
            cTConnectionSite = (CTConnectionSite) get_store().insert_element_user(PROPERTY_QNAME[0], i5);
        }
        return cTConnectionSite;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTConnectionSiteList
    public void removeCxn(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], i5);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTConnectionSiteList
    public void setCxnArray(CTConnectionSite[] cTConnectionSiteArr) {
        check_orphaned();
        arraySetterHelper(cTConnectionSiteArr, PROPERTY_QNAME[0]);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTConnectionSiteList
    public int sizeOfCxnArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[0]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTConnectionSiteList
    public CTConnectionSite getCxnArray(int i5) {
        CTConnectionSite cTConnectionSite;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTConnectionSite = (CTConnectionSite) get_store().find_element_user(PROPERTY_QNAME[0], i5);
                if (cTConnectionSite == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTConnectionSite;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTConnectionSiteList
    public void setCxnArray(int i5, CTConnectionSite cTConnectionSite) {
        generatedSetterHelperImpl(cTConnectionSite, PROPERTY_QNAME[0], i5, (short) 2);
    }
}
