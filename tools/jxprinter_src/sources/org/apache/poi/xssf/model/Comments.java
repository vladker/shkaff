package org.apache.poi.xssf.model;

import java.util.Iterator;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellAddress;
import org.apache.poi.util.Internal;
import org.apache.poi.xssf.usermodel.XSSFComment;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public interface Comments {
    void commentUpdated(XSSFComment xSSFComment);

    XSSFComment createNewComment(ClientAnchor clientAnchor);

    int findAuthor(String str);

    XSSFComment findCellComment(CellAddress cellAddress);

    String getAuthor(long j6);

    Iterator<CellAddress> getCellAddresses();

    int getNumberOfAuthors();

    int getNumberOfComments();

    void referenceUpdated(CellAddress cellAddress, XSSFComment xSSFComment);

    boolean removeComment(CellAddress cellAddress);

    @Internal
    void setSheet(Sheet sheet);
}
