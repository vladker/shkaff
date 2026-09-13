package org.apache.poi.xwpf.usermodel;

import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLatentStyles;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLsdException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XWPFLatentStyles {
    private CTLatentStyles latentStyles;
    protected XWPFStyles styles;

    public XWPFLatentStyles() {
    }

    public int getNumberOfStyles() {
        return this.latentStyles.sizeOfLsdExceptionArray();
    }

    public boolean isLatentStyle(String str) {
        for (CTLsdException cTLsdException : this.latentStyles.getLsdExceptionArray()) {
            if (cTLsdException.getName().equals(str)) {
                return true;
            }
        }
        return false;
    }

    public XWPFLatentStyles(CTLatentStyles cTLatentStyles) {
        this(cTLatentStyles, null);
    }

    public XWPFLatentStyles(CTLatentStyles cTLatentStyles, XWPFStyles xWPFStyles) {
        this.latentStyles = cTLatentStyles;
        this.styles = xWPFStyles;
    }
}
