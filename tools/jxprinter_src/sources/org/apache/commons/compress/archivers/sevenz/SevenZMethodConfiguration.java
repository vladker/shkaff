package org.apache.commons.compress.archivers.sevenz;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class SevenZMethodConfiguration {
    private final SevenZMethod method;
    private final Object options;

    public SevenZMethodConfiguration(SevenZMethod sevenZMethod) {
        this(sevenZMethod, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            SevenZMethodConfiguration sevenZMethodConfiguration = (SevenZMethodConfiguration) obj;
            if (Objects.equals(this.method, sevenZMethodConfiguration.method) && Objects.equals(this.options, sevenZMethodConfiguration.options)) {
                return true;
            }
        }
        return false;
    }

    public SevenZMethod getMethod() {
        return this.method;
    }

    public Object getOptions() {
        return this.options;
    }

    public int hashCode() {
        SevenZMethod sevenZMethod = this.method;
        if (sevenZMethod == null) {
            return 0;
        }
        return sevenZMethod.hashCode();
    }

    public SevenZMethodConfiguration(SevenZMethod sevenZMethod, Object obj) {
        this.method = sevenZMethod;
        this.options = obj;
        if (obj == null || Coders.findByMethod(sevenZMethod).canAcceptOptions(obj)) {
            return;
        }
        throw new IllegalArgumentException("The " + sevenZMethod + " method doesn't support options of type " + obj.getClass());
    }
}
