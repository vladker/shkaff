package org.apache.poi.xdgf.usermodel;

import com.microsoft.schemas.office.visio.x2012.main.PageType;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import org.apache.poi.ooxml.POIXMLException;
import org.apache.poi.util.Dimension2DDouble;
import org.apache.poi.util.Internal;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XDGFPage {
    protected XDGFPageContents _content;
    private PageType _page;
    protected XDGFSheet _pageSheet;
    protected XDGFPages _pages;

    public XDGFPage(PageType pageType, XDGFPageContents xDGFPageContents, XDGFDocument xDGFDocument, XDGFPages xDGFPages) {
        this._page = pageType;
        this._content = xDGFPageContents;
        this._pages = xDGFPages;
        xDGFPageContents.setPage(this);
        if (pageType.isSetPageSheet()) {
            this._pageSheet = new XDGFPageSheet(pageType.getPageSheet(), xDGFDocument);
        }
    }

    public Rectangle2D getBoundingBox() {
        Dimension2DDouble pageSize = getPageSize();
        Point2D.Double pageOffset = getPageOffset();
        return new Rectangle2D.Double(-pageOffset.getX(), -pageOffset.getY(), pageSize.getWidth(), pageSize.getHeight());
    }

    public XDGFPageContents getContent() {
        return this._content;
    }

    public long getID() {
        return this._page.getID();
    }

    public String getName() {
        return this._page.getName();
    }

    public long getPageNumber() {
        return ((long) this._pages.getPageList().indexOf(this)) + 1;
    }

    public Point2D.Double getPageOffset() {
        XDGFCell cell = this._pageSheet.getCell("XRulerOrigin");
        XDGFCell cell2 = this._pageSheet.getCell("YRulerOrigin");
        return new Point2D.Double(cell != null ? Double.parseDouble(cell.getValue()) : 0.0d, cell2 != null ? Double.parseDouble(cell2.getValue()) : 0.0d);
    }

    public XDGFSheet getPageSheet() {
        return this._pageSheet;
    }

    public Dimension2DDouble getPageSize() {
        XDGFCell cell = this._pageSheet.getCell("PageWidth");
        XDGFCell cell2 = this._pageSheet.getCell("PageHeight");
        if (cell == null || cell2 == null) {
            throw new POIXMLException("Cannot determine page size");
        }
        return new Dimension2DDouble(Double.parseDouble(cell.getValue()), Double.parseDouble(cell2.getValue()));
    }

    @Internal
    public PageType getXmlObject() {
        return this._page;
    }
}
