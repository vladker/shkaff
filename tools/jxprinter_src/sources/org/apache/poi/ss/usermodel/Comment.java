package org.apache.poi.ss.usermodel;

import org.apache.poi.ss.util.CellAddress;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public interface Comment {
    CellAddress getAddress();

    String getAuthor();

    ClientAnchor getClientAnchor();

    int getColumn();

    int getRow();

    RichTextString getString();

    boolean isVisible();

    void setAddress(int i5, int i6);

    void setAddress(CellAddress cellAddress);

    void setAuthor(String str);

    void setColumn(int i5);

    void setRow(int i5);

    void setString(RichTextString richTextString);

    void setVisible(boolean z6);
}
