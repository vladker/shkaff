package org.apache.commons.math3.exception.util;

import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class DummyLocalizable implements Localizable {
    private static final long serialVersionUID = 8843275624471387299L;
    private final String source;

    public DummyLocalizable(String str) {
        this.source = str;
    }

    @Override // org.apache.commons.math3.exception.util.Localizable
    public String getLocalizedString(Locale locale) {
        return this.source;
    }

    @Override // org.apache.commons.math3.exception.util.Localizable
    public String getSourceString() {
        return this.source;
    }

    public String toString() {
        return this.source;
    }
}
