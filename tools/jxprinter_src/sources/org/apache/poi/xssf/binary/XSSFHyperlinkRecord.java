package org.apache.poi.xssf.binary;

import A3.AbstractC0157z;
import java.util.Objects;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.util.Internal;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Internal
public class XSSFHyperlinkRecord {
    private final CellRangeAddress cellRangeAddress;
    private String display;
    private String location;
    private final String relId;
    private String toolTip;

    public XSSFHyperlinkRecord(CellRangeAddress cellRangeAddress, String str, String str2, String str3, String str4) {
        this.cellRangeAddress = cellRangeAddress;
        this.relId = str;
        this.location = str2;
        this.toolTip = str3;
        this.display = str4;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            XSSFHyperlinkRecord xSSFHyperlinkRecord = (XSSFHyperlinkRecord) obj;
            if (Objects.equals(this.cellRangeAddress, xSSFHyperlinkRecord.cellRangeAddress) && Objects.equals(this.relId, xSSFHyperlinkRecord.relId) && Objects.equals(this.location, xSSFHyperlinkRecord.location) && Objects.equals(this.toolTip, xSSFHyperlinkRecord.toolTip) && Objects.equals(this.display, xSSFHyperlinkRecord.display)) {
                return true;
            }
        }
        return false;
    }

    public CellRangeAddress getCellRangeAddress() {
        return this.cellRangeAddress;
    }

    public String getDisplay() {
        return this.display;
    }

    public String getLocation() {
        return this.location;
    }

    public String getRelId() {
        return this.relId;
    }

    public String getToolTip() {
        return this.toolTip;
    }

    public int hashCode() {
        return Objects.hash(this.cellRangeAddress, this.relId, this.location, this.toolTip, this.display);
    }

    public void setDisplay(String str) {
        this.display = str;
    }

    public void setLocation(String str) {
        this.location = str;
    }

    public void setToolTip(String str) {
        this.toolTip = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XSSFHyperlinkRecord{cellRangeAddress=");
        sb.append(this.cellRangeAddress);
        sb.append(", relId='");
        sb.append(this.relId);
        sb.append("', location='");
        sb.append(this.location);
        sb.append("', toolTip='");
        sb.append(this.toolTip);
        sb.append("', display='");
        return AbstractC0157z.s(sb, this.display, "'}");
    }
}
