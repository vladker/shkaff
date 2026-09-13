package com.microsoft.schemas.office.visio.x2012.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public interface PagesType extends XmlObject {
    public static final DocumentFactory<PagesType> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<PagesType> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "pagestypef2e7type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    PageType addNewPage();

    PageType getPageArray(int i5);

    PageType[] getPageArray();

    List<PageType> getPageList();

    PageType insertNewPage(int i5);

    void removePage(int i5);

    void setPageArray(int i5, PageType pageType);

    void setPageArray(PageType[] pageTypeArr);

    int sizeOfPageArray();
}
