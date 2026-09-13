package org.apache.poi.xslf.usermodel;

import java.awt.geom.Point2D;
import java.util.Calendar;
import java.util.Date;
import org.apache.poi.ooxml.util.POIXMLUnits;
import org.apache.poi.sl.usermodel.Comment;
import org.apache.poi.util.LocaleUtil;
import org.apache.poi.util.Units;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPoint2D;
import org.openxmlformats.schemas.presentationml.x2006.main.CTComment;
import org.openxmlformats.schemas.presentationml.x2006.main.CTCommentAuthor;
import org.openxmlformats.schemas.presentationml.x2006.main.CTCommentAuthorList;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XSLFComment implements Comment {
    final XSLFCommentAuthors authors;
    final CTComment comment;

    public XSLFComment(CTComment cTComment, XSLFCommentAuthors xSLFCommentAuthors) {
        this.comment = cTComment;
        this.authors = xSLFCommentAuthors;
    }

    @Override // org.apache.poi.sl.usermodel.Comment
    public String getAuthor() {
        return this.authors.getAuthorById(this.comment.getAuthorId()).getName();
    }

    @Override // org.apache.poi.sl.usermodel.Comment
    public String getAuthorInitials() {
        CTCommentAuthor authorById = this.authors.getAuthorById(this.comment.getAuthorId());
        if (authorById == null) {
            return null;
        }
        return authorById.getInitials();
    }

    @Override // org.apache.poi.sl.usermodel.Comment
    public Date getDate() {
        Calendar dt = this.comment.getDt();
        if (dt == null) {
            return null;
        }
        return dt.getTime();
    }

    @Override // org.apache.poi.sl.usermodel.Comment
    public Point2D getOffset() {
        CTPoint2D pos = this.comment.getPos();
        return new Point2D.Double(Units.toPoints(POIXMLUnits.parseLength(pos.xgetX())), Units.toPoints(POIXMLUnits.parseLength(pos.xgetY())));
    }

    @Override // org.apache.poi.sl.usermodel.Comment
    public String getText() {
        return this.comment.getText();
    }

    @Override // org.apache.poi.sl.usermodel.Comment
    public void setAuthor(String str) {
        if (str == null) {
            throw new IllegalArgumentException("author must not be null");
        }
        CTCommentAuthorList cTCommentAuthorsList = this.authors.getCTCommentAuthorsList();
        long jMax = -1;
        for (CTCommentAuthor cTCommentAuthor : cTCommentAuthorsList.getCmAuthorArray()) {
            jMax = Math.max(cTCommentAuthor.getId(), jMax);
            if (str.equals(cTCommentAuthor.getName())) {
                this.comment.setAuthorId(cTCommentAuthor.getId());
                return;
            }
        }
        CTCommentAuthor cTCommentAuthorAddNewCmAuthor = cTCommentAuthorsList.addNewCmAuthor();
        cTCommentAuthorAddNewCmAuthor.setName(str);
        long j6 = jMax + 1;
        cTCommentAuthorAddNewCmAuthor.setId(j6);
        cTCommentAuthorAddNewCmAuthor.setInitials(str.replaceAll("\\s*(\\w)\\S*", "$1").toUpperCase(LocaleUtil.getUserLocale()));
        this.comment.setAuthorId(j6);
    }

    @Override // org.apache.poi.sl.usermodel.Comment
    public void setAuthorInitials(String str) {
        CTCommentAuthor authorById = this.authors.getAuthorById(this.comment.getAuthorId());
        if (authorById != null) {
            authorById.setInitials(str);
        }
    }

    @Override // org.apache.poi.sl.usermodel.Comment
    public void setDate(Date date) {
        Calendar localeCalendar = LocaleUtil.getLocaleCalendar();
        localeCalendar.setTime(date);
        this.comment.setDt(localeCalendar);
    }

    @Override // org.apache.poi.sl.usermodel.Comment
    public void setOffset(Point2D point2D) {
        CTPoint2D pos = this.comment.getPos();
        if (pos == null) {
            pos = this.comment.addNewPos();
        }
        pos.setX(Integer.valueOf(Units.toEMU(point2D.getX())));
        pos.setY(Integer.valueOf(Units.toEMU(point2D.getY())));
    }

    @Override // org.apache.poi.sl.usermodel.Comment
    public void setText(String str) {
        this.comment.setText(str);
    }
}
