package org.apache.xmlbeans;

import java.math.BigDecimal;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface GDurationSpecification {
    int compareToGDuration(GDurationSpecification gDurationSpecification);

    int getDay();

    BigDecimal getFraction();

    int getHour();

    int getMinute();

    int getMonth();

    int getSecond();

    int getSign();

    int getYear();

    boolean isImmutable();

    boolean isValid();
}
