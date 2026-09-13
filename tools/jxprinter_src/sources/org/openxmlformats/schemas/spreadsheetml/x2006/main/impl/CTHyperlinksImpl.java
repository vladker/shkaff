package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import java.util.List;
import java.util.function.Function;
import javax.xml.namespace.QName;
import org.apache.poi.xssf.usermodel.XSSFRelation;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.JavaListXmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTHyperlink;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTHyperlinks;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.CTHyperlinksImpl;
import r5.B;
import r5.C1551a0;
import r5.C1553b0;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public class CTHyperlinksImpl extends XmlComplexContentImpl implements CTHyperlinks {
    private static final QName[] PROPERTY_QNAME = {new QName(XSSFRelation.NS_SPREADSHEETML, "hyperlink")};
    private static final long serialVersionUID = 1;

    public CTHyperlinksImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTHyperlinks
    public CTHyperlink addNewHyperlink() {
        CTHyperlink cTHyperlink;
        synchronized (monitor()) {
            check_orphaned();
            cTHyperlink = (CTHyperlink) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTHyperlink;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTHyperlinks
    public CTHyperlink[] getHyperlinkArray() {
        return (CTHyperlink[]) getXmlObjectArray(PROPERTY_QNAME[0], new CTHyperlink[0]);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTHyperlinks
    public List<CTHyperlink> getHyperlinkList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            final int i5 = 0;
            final int i6 = 1;
            javaListXmlObject = new JavaListXmlObject(new Function(this) { // from class: r5.Z
                public final /* synthetic */ CTHyperlinksImpl b;

                {
                    this.b = this;
                }

                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    int i7 = i5;
                    int iIntValue = ((Integer) obj).intValue();
                    switch (i7) {
                        case 0:
                            return this.b.getHyperlinkArray(iIntValue);
                        default:
                            return this.b.insertNewHyperlink(iIntValue);
                    }
                }
            }, new B(this, 17), new Function(this) { // from class: r5.Z
                public final /* synthetic */ CTHyperlinksImpl b;

                {
                    this.b = this;
                }

                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    int i7 = i6;
                    int iIntValue = ((Integer) obj).intValue();
                    switch (i7) {
                        case 0:
                            return this.b.getHyperlinkArray(iIntValue);
                        default:
                            return this.b.insertNewHyperlink(iIntValue);
                    }
                }
            }, new C1551a0(this, 0), new C1553b0(this, 0));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTHyperlinks
    public CTHyperlink insertNewHyperlink(int i5) {
        CTHyperlink cTHyperlink;
        synchronized (monitor()) {
            check_orphaned();
            cTHyperlink = (CTHyperlink) get_store().insert_element_user(PROPERTY_QNAME[0], i5);
        }
        return cTHyperlink;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTHyperlinks
    public void removeHyperlink(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], i5);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTHyperlinks
    public void setHyperlinkArray(CTHyperlink[] cTHyperlinkArr) {
        check_orphaned();
        arraySetterHelper(cTHyperlinkArr, PROPERTY_QNAME[0]);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTHyperlinks
    public int sizeOfHyperlinkArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[0]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTHyperlinks
    public CTHyperlink getHyperlinkArray(int i5) {
        CTHyperlink cTHyperlink;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTHyperlink = (CTHyperlink) get_store().find_element_user(PROPERTY_QNAME[0], i5);
                if (cTHyperlink == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTHyperlink;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTHyperlinks
    public void setHyperlinkArray(int i5, CTHyperlink cTHyperlink) {
        generatedSetterHelperImpl(cTHyperlink, PROPERTY_QNAME[0], i5, (short) 2);
    }
}
