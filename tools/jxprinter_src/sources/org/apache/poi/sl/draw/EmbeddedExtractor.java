package org.apache.poi.sl.draw;

import java.util.Collections;
import java.util.function.Supplier;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public interface EmbeddedExtractor {

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class EmbeddedPart {
        private Supplier<byte[]> data;
        private String name;

        public Supplier<byte[]> getData() {
            return this.data;
        }

        public String getName() {
            return this.name;
        }

        public void setData(Supplier<byte[]> supplier) {
            this.data = supplier;
        }

        public void setName(String str) {
            this.name = str;
        }
    }

    default Iterable<EmbeddedPart> getEmbeddings() {
        return Collections.EMPTY_LIST;
    }
}
