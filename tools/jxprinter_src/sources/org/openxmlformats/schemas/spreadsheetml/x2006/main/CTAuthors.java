package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.STXstring;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface CTAuthors extends XmlObject {
    public static final DocumentFactory<CTAuthors> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTAuthors> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctauthorsb8a7type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    void addAuthor(String str);

    STXstring addNewAuthor();

    String getAuthorArray(int i5);

    String[] getAuthorArray();

    List<String> getAuthorList();

    void insertAuthor(int i5, String str);

    STXstring insertNewAuthor(int i5);

    void removeAuthor(int i5);

    void setAuthorArray(int i5, String str);

    void setAuthorArray(String[] strArr);

    int sizeOfAuthorArray();

    STXstring xgetAuthorArray(int i5);

    STXstring[] xgetAuthorArray();

    List<STXstring> xgetAuthorList();

    void xsetAuthorArray(int i5, STXstring sTXstring);

    void xsetAuthorArray(STXstring[] sTXstringArr);
}
