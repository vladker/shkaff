package com.microsoft.schemas.office.visio.x2012.main.impl;

import com.microsoft.schemas.office.visio.x2012.main.PageType;
import com.microsoft.schemas.office.visio.x2012.main.PagesType;
import com.microsoft.schemas.office.visio.x2012.main.impl.PagesTypeImpl;
import java.util.List;
import java.util.function.Function;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.JavaListXmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import p105s2.i;
import p105s2.j;
import r5.B0;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class PagesTypeImpl extends XmlComplexContentImpl implements PagesType {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.microsoft.com/office/visio/2012/main", "Page")};
    private static final long serialVersionUID = 1;

    public PagesTypeImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.PagesType
    public PageType addNewPage() {
        PageType pageType;
        synchronized (monitor()) {
            check_orphaned();
            pageType = (PageType) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return pageType;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.PagesType
    public PageType[] getPageArray() {
        return (PageType[]) getXmlObjectArray(PROPERTY_QNAME[0], new PageType[0]);
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.PagesType
    public List<PageType> getPageList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            final int i5 = 0;
            final int i6 = 1;
            javaListXmlObject = new JavaListXmlObject(new Function(this) { // from class: s2.h
                public final /* synthetic */ PagesTypeImpl b;

                {
                    this.b = this;
                }

                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    int i7 = i5;
                    int iIntValue = ((Integer) obj).intValue();
                    switch (i7) {
                        case 0:
                            return this.b.getPageArray(iIntValue);
                        default:
                            return this.b.insertNewPage(iIntValue);
                    }
                }
            }, new B0(this, 16), new Function(this) { // from class: s2.h
                public final /* synthetic */ PagesTypeImpl b;

                {
                    this.b = this;
                }

                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    int i7 = i6;
                    int iIntValue = ((Integer) obj).intValue();
                    switch (i7) {
                        case 0:
                            return this.b.getPageArray(iIntValue);
                        default:
                            return this.b.insertNewPage(iIntValue);
                    }
                }
            }, new i(this, 0), new j(this, 0));
        }
        return javaListXmlObject;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.PagesType
    public PageType insertNewPage(int i5) {
        PageType pageType;
        synchronized (monitor()) {
            check_orphaned();
            pageType = (PageType) get_store().insert_element_user(PROPERTY_QNAME[0], i5);
        }
        return pageType;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.PagesType
    public void removePage(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], i5);
        }
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.PagesType
    public void setPageArray(PageType[] pageTypeArr) {
        check_orphaned();
        arraySetterHelper(pageTypeArr, PROPERTY_QNAME[0]);
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.PagesType
    public int sizeOfPageArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[0]);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.PagesType
    public PageType getPageArray(int i5) {
        PageType pageType;
        synchronized (monitor()) {
            try {
                check_orphaned();
                pageType = (PageType) get_store().find_element_user(PROPERTY_QNAME[0], i5);
                if (pageType == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return pageType;
    }

    @Override // com.microsoft.schemas.office.visio.x2012.main.PagesType
    public void setPageArray(int i5, PageType pageType) {
        generatedSetterHelperImpl(pageType, PROPERTY_QNAME[0], i5, (short) 2);
    }
}
