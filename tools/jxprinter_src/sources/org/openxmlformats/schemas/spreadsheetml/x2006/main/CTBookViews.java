package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface CTBookViews extends XmlObject {
    public static final DocumentFactory<CTBookViews> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTBookViews> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctbookviewsb864type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTBookView addNewWorkbookView();

    CTBookView getWorkbookViewArray(int i5);

    CTBookView[] getWorkbookViewArray();

    List<CTBookView> getWorkbookViewList();

    CTBookView insertNewWorkbookView(int i5);

    void removeWorkbookView(int i5);

    void setWorkbookViewArray(int i5, CTBookView cTBookView);

    void setWorkbookViewArray(CTBookView[] cTBookViewArr);

    int sizeOfWorkbookViewArray();
}
