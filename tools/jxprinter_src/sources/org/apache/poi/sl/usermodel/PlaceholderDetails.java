package org.apache.poi.sl.usermodel;

import java.time.format.DateTimeFormatter;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public interface PlaceholderDetails {

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public enum PlaceholderSize {
        quarter,
        half,
        full
    }

    default DateTimeFormatter getDateFormat() {
        return DateTimeFormatter.ISO_LOCAL_DATE;
    }

    Placeholder getPlaceholder();

    PlaceholderSize getSize();

    String getText();

    default String getUserDate() {
        return null;
    }

    boolean isVisible();

    void setPlaceholder(Placeholder placeholder);

    void setSize(PlaceholderSize placeholderSize);

    void setText(String str);

    void setVisible(boolean z6);
}
