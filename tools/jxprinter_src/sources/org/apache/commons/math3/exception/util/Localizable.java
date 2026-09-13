package org.apache.commons.math3.exception.util;

import java.io.Serializable;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public interface Localizable extends Serializable {
    String getLocalizedString(Locale locale);

    String getSourceString();
}
