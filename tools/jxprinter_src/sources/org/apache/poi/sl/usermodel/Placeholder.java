package org.apache.poi.sl.usermodel;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public enum Placeholder {
    NONE(0, 0, 0, 0, 0),
    TITLE(13, 1, 1, 1, 1),
    BODY(14, 2, 12, 6, 2),
    CENTERED_TITLE(15, 3, 3, 3, 3),
    SUBTITLE(16, 4, 4, 4, 4),
    DATETIME(7, 7, 7, 7, 5),
    SLIDE_NUMBER(8, 8, 8, 8, 6),
    FOOTER(9, 9, 9, 9, 7),
    HEADER(10, 10, 10, 10, 8),
    CONTENT(19, 19, 19, 19, 9),
    CHART(20, 20, 20, 20, 10),
    TABLE(21, 21, 21, 21, 11),
    CLIP_ART(22, 22, 22, 22, 12),
    DGM(23, 23, 23, 23, 13),
    MEDIA(24, 24, 24, 24, 14),
    SLIDE_IMAGE(11, 11, 11, 5, 15),
    PICTURE(26, 26, 26, 26, 16),
    VERTICAL_OBJECT(25, 25, 25, 25, -2),
    VERTICAL_TEXT_TITLE(17, 17, 17, 17, -2),
    VERTICAL_TEXT_BODY(18, 18, 18, 18, -2);

    public final int nativeNotesId;
    public final int nativeNotesMasterId;
    public final int nativeSlideId;
    public final int nativeSlideMasterId;
    public final int ooxmlId;

    Placeholder(int i5, int i6, int i7, int i8, int i9) {
        this.nativeSlideId = i5;
        this.nativeSlideMasterId = i6;
        this.nativeNotesId = i7;
        this.nativeNotesMasterId = i8;
        this.ooxmlId = i9;
    }

    private static Placeholder lookupNative(int i5, int i6) {
        for (Placeholder placeholder : values()) {
            if ((i6 == 0 && placeholder.nativeSlideId == i5) || ((i6 == 1 && placeholder.nativeSlideMasterId == i5) || ((i6 == 2 && placeholder.nativeNotesId == i5) || (i6 == 3 && placeholder.nativeNotesMasterId == i5)))) {
                return placeholder;
            }
        }
        return null;
    }

    public static Placeholder lookupNativeNotes(int i5) {
        return lookupNative(i5, 2);
    }

    public static Placeholder lookupNativeNotesMaster(int i5) {
        return lookupNative(i5, 3);
    }

    public static Placeholder lookupNativeSlide(int i5) {
        return lookupNative(i5, 0);
    }

    public static Placeholder lookupNativeSlideMaster(int i5) {
        return lookupNative(i5, 1);
    }

    public static Placeholder lookupOoxml(int i5) {
        for (Placeholder placeholder : values()) {
            if (placeholder.ooxmlId == i5) {
                return placeholder;
            }
        }
        return null;
    }
}
