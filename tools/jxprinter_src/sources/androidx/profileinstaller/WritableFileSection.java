package androidx.profileinstaller;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
class WritableFileSection {
    final byte[] mContents;
    final int mExpectedInflateSize;
    final boolean mNeedsCompression;
    final FileSectionType mType;

    public WritableFileSection(@NonNull FileSectionType fileSectionType, int i5, @NonNull byte[] bArr, boolean z6) {
        this.mType = fileSectionType;
        this.mExpectedInflateSize = i5;
        this.mContents = bArr;
        this.mNeedsCompression = z6;
    }
}
