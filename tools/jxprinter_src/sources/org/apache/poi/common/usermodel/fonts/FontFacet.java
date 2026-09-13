package org.apache.poi.common.usermodel.fonts;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public interface FontFacet {
    default Object getFontData() {
        return null;
    }

    default int getWeight() {
        return 400;
    }

    default boolean isItalic() {
        return false;
    }

    default void setItalic(boolean z6) {
        throw new UnsupportedOperationException("FontFacet is read-only.");
    }

    default void setWeight(int i5) {
        throw new UnsupportedOperationException("FontFacet is read-only.");
    }
}
