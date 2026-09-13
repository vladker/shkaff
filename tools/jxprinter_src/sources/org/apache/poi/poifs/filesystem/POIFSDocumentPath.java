package org.apache.poi.poifs.filesystem;

import java.io.File;
import java.util.Arrays;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Stream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class POIFSDocumentPath {
    private static final Logger LOGGER = LogManager.getLogger((Class<?>) POIFSDocumentPath.class);
    private final String[] components;
    private int hashcode;

    public POIFSDocumentPath() {
        this.components = new String[0];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$new$0(String str) {
        return str == null || str.isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String[] lambda$new$1(int i5) {
        return new String[i5];
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        return Arrays.equals(this.components, ((POIFSDocumentPath) obj).components);
    }

    public String getComponent(int i5) {
        return this.components[i5];
    }

    public String getName() {
        String[] strArr = this.components;
        return strArr.length == 0 ? "" : strArr[strArr.length - 1];
    }

    public POIFSDocumentPath getParent() {
        String[] strArr = this.components;
        if (strArr.length == 0) {
            return null;
        }
        return new POIFSDocumentPath((String[]) Arrays.copyOf(strArr, strArr.length - 1));
    }

    public int hashCode() {
        int i5 = this.hashcode;
        if (i5 != 0) {
            return i5;
        }
        int iHashCode = Arrays.hashCode(this.components);
        this.hashcode = iHashCode;
        return iHashCode;
    }

    public int length() {
        return this.components.length;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        char c = File.separatorChar;
        sb.append(c);
        sb.append(String.join(String.valueOf(c), this.components));
        return sb.toString();
    }

    public POIFSDocumentPath(String[] strArr) {
        this(null, strArr);
    }

    public POIFSDocumentPath(POIFSDocumentPath pOIFSDocumentPath, String[] strArr) {
        Predicate predicate;
        String[] strArr2 = pOIFSDocumentPath == null ? new String[0] : pOIFSDocumentPath.components;
        strArr = strArr == null ? new String[0] : strArr;
        if (pOIFSDocumentPath != null) {
            final int i5 = 0;
            predicate = new Predicate() { // from class: org.apache.poi.poifs.filesystem.b
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    String str = (String) obj;
                    switch (i5) {
                        case 0:
                            return Objects.isNull(str);
                        default:
                            return POIFSDocumentPath.lambda$new$0(str);
                    }
                }
            };
        } else {
            final int i6 = 1;
            predicate = new Predicate() { // from class: org.apache.poi.poifs.filesystem.b
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    String str = (String) obj;
                    switch (i6) {
                        case 0:
                            return Objects.isNull(str);
                        default:
                            return POIFSDocumentPath.lambda$new$0(str);
                    }
                }
            };
        }
        if (!Stream.of((Object[]) strArr).anyMatch(predicate)) {
            this.components = (String[]) Stream.concat(Stream.of((Object[]) strArr2), Stream.of((Object[]) strArr)).toArray(new c());
            return;
        }
        throw new IllegalArgumentException("components cannot contain null or empty strings");
    }
}
