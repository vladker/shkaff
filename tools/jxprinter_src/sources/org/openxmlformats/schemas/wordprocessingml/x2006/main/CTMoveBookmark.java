package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import java.util.Calendar;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.STString;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface CTMoveBookmark extends CTBookmark {
    public static final DocumentFactory<CTMoveBookmark> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTMoveBookmark> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctmovebookmarkf7a1type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    String getAuthor();

    Calendar getDate();

    void setAuthor(String str);

    void setDate(Calendar calendar);

    STString xgetAuthor();

    STDateTime xgetDate();

    void xsetAuthor(STString sTString);

    void xsetDate(STDateTime sTDateTime);
}
