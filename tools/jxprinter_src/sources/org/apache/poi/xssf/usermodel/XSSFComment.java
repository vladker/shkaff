package org.apache.poi.xssf.usermodel;

import com.microsoft.schemas.office.excel.CTClientData;
import com.microsoft.schemas.vml.CTShape;
import java.math.BigInteger;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.Comment;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.util.CellAddress;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.model.Comments;
import org.apache.poi.xssf.model.CommentsTable;
import org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.STTrueFalseBlank;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTComment;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XSSFComment implements Comment {
    private final CTComment _comment;
    private final Comments _comments;
    private XSSFRichTextString _str;
    private final CTShape _vmlShape;

    public XSSFComment(CommentsTable commentsTable, CTComment cTComment, CTShape cTShape) {
        this((Comments) commentsTable, cTComment, cTShape);
    }

    private static void avoidXmlbeansCorruptPointer(CTShape cTShape) {
        cTShape.getClientDataList().toString();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof XSSFComment)) {
            return false;
        }
        XSSFComment xSSFComment = (XSSFComment) obj;
        return getCTComment() == xSSFComment.getCTComment() && getCTShape() == xSSFComment.getCTShape();
    }

    @Override // org.apache.poi.ss.usermodel.Comment
    public CellAddress getAddress() {
        return new CellAddress(this._comment.getRef());
    }

    @Override // org.apache.poi.ss.usermodel.Comment
    public String getAuthor() {
        return this._comments.getAuthor(this._comment.getAuthorId());
    }

    public CTComment getCTComment() {
        return this._comment;
    }

    public CTShape getCTShape() {
        return this._vmlShape;
    }

    @Override // org.apache.poi.ss.usermodel.Comment
    public ClientAnchor getClientAnchor() {
        CTShape cTShape = this._vmlShape;
        if (cTShape == null) {
            return null;
        }
        int[] iArr = new int[8];
        String[] strArrSplit = cTShape.getClientDataArray(0).getAnchorArray(0).split(",");
        int length = strArrSplit.length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            iArr[i6] = Integer.parseInt(strArrSplit[i5].trim());
            i5++;
            i6++;
        }
        return new XSSFClientAnchor(iArr[1] * 9525, iArr[3] * 9525, iArr[5] * 9525, iArr[7] * 9525, iArr[0], iArr[2], iArr[4], iArr[6]);
    }

    @Override // org.apache.poi.ss.usermodel.Comment
    public int getColumn() {
        return getAddress().getColumn();
    }

    @Override // org.apache.poi.ss.usermodel.Comment
    public int getRow() {
        return getAddress().getRow();
    }

    public int hashCode() {
        return (getColumn() + (getRow() * 17)) * 31;
    }

    @Override // org.apache.poi.ss.usermodel.Comment
    public boolean isVisible() {
        CTShape cTShape = this._vmlShape;
        if (cTShape != null) {
            if (cTShape.sizeOfClientDataArray() > 0) {
                CTClientData clientDataArray = this._vmlShape.getClientDataArray(0);
                return clientDataArray != null && clientDataArray.sizeOfVisibleArray() > 0;
            }
            String style = this._vmlShape.getStyle();
            if (style != null && style.contains("visibility:visible")) {
                return true;
            }
        }
        return false;
    }

    @Override // org.apache.poi.ss.usermodel.Comment
    public void setAddress(int i5, int i6) {
        setAddress(new CellAddress(i5, i6));
    }

    @Override // org.apache.poi.ss.usermodel.Comment
    public void setAuthor(String str) {
        this._comment.setAuthorId(this._comments.findAuthor(str));
        this._comments.commentUpdated(this);
    }

    @Override // org.apache.poi.ss.usermodel.Comment
    public void setColumn(int i5) {
        setAddress(getRow(), i5);
    }

    @Override // org.apache.poi.ss.usermodel.Comment
    public void setRow(int i5) {
        setAddress(i5, getColumn());
    }

    @Override // org.apache.poi.ss.usermodel.Comment
    public void setString(RichTextString richTextString) {
        if (!(richTextString instanceof XSSFRichTextString)) {
            throw new IllegalArgumentException("Only XSSFRichTextString argument is supported");
        }
        XSSFRichTextString xSSFRichTextString = (XSSFRichTextString) richTextString;
        this._str = xSSFRichTextString;
        this._comment.setText(xSSFRichTextString.getCTRst());
        this._comments.commentUpdated(this);
    }

    @Override // org.apache.poi.ss.usermodel.Comment
    public void setVisible(boolean z6) {
        CTShape cTShape = this._vmlShape;
        if (cTShape != null) {
            if (z6) {
                cTShape.setStyle("position:absolute");
                CTClientData clientDataArray = this._vmlShape.getClientDataArray(0);
                if (clientDataArray != null && clientDataArray.sizeOfVisibleArray() == 0) {
                    clientDataArray.addVisible(STTrueFalseBlank.f7727X);
                }
            } else {
                cTShape.setStyle("position:absolute;visibility:hidden");
                CTClientData clientDataArray2 = this._vmlShape.getClientDataArray(0);
                if (clientDataArray2 != null && clientDataArray2.sizeOfVisibleArray() > 0) {
                    clientDataArray2.removeVisible(0);
                }
            }
        }
        this._comments.commentUpdated(this);
    }

    public XSSFComment(Comments comments, CTComment cTComment, CTShape cTShape) {
        this._comment = cTComment;
        this._comments = comments;
        this._vmlShape = cTShape;
        if (cTComment == null || cTShape == null || cTShape.sizeOfClientDataArray() <= 0) {
            return;
        }
        CellReference cellReference = new CellReference(cTComment.getRef());
        CTClientData clientDataArray = cTShape.getClientDataArray(0);
        clientDataArray.setRowArray(0, new BigInteger(String.valueOf(cellReference.getRow())));
        clientDataArray.setColumnArray(0, new BigInteger(String.valueOf((int) cellReference.getCol())));
        avoidXmlbeansCorruptPointer(cTShape);
    }

    @Override // org.apache.poi.ss.usermodel.Comment
    public XSSFRichTextString getString() {
        if (this._str == null && this._comment.getText() != null) {
            this._str = new XSSFRichTextString(this._comment.getText());
        }
        return this._str;
    }

    @Override // org.apache.poi.ss.usermodel.Comment
    public void setAddress(CellAddress cellAddress) {
        CellAddress cellAddress2 = new CellAddress(this._comment.getRef());
        if (cellAddress.equals(cellAddress2)) {
            return;
        }
        this._comment.setRef(cellAddress.formatAsString());
        this._comments.referenceUpdated(cellAddress2, this);
        CTShape cTShape = this._vmlShape;
        if (cTShape != null) {
            CTClientData clientDataArray = cTShape.getClientDataArray(0);
            clientDataArray.setRowArray(0, new BigInteger(String.valueOf(cellAddress.getRow())));
            clientDataArray.setColumnArray(0, new BigInteger(String.valueOf(cellAddress.getColumn())));
            avoidXmlbeansCorruptPointer(this._vmlShape);
        }
        this._comments.commentUpdated(this);
    }

    public void setString(String str) {
        setString(new XSSFRichTextString(str));
    }
}
