package org.apache.poi.ss.usermodel;

import org.apache.poi.ss.util.CellRangeAddressList;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public interface DataValidation {

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class ErrorStyle {
        public static final int INFO = 2;
        public static final int STOP = 0;
        public static final int WARNING = 1;
    }

    void createErrorBox(String str, String str2);

    void createPromptBox(String str, String str2);

    boolean getEmptyCellAllowed();

    String getErrorBoxText();

    String getErrorBoxTitle();

    int getErrorStyle();

    String getPromptBoxText();

    String getPromptBoxTitle();

    CellRangeAddressList getRegions();

    boolean getShowErrorBox();

    boolean getShowPromptBox();

    boolean getSuppressDropDownArrow();

    DataValidationConstraint getValidationConstraint();

    void setEmptyCellAllowed(boolean z6);

    void setErrorStyle(int i5);

    void setShowErrorBox(boolean z6);

    void setShowPromptBox(boolean z6);

    void setSuppressDropDownArrow(boolean z6);
}
