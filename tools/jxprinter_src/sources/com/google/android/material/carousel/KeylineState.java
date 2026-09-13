package com.google.android.material.carousel;

import A3.AbstractC0157z;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.color.utilities.Contrast;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
final class KeylineState {
    private final int firstFocalKeylineIndex;
    private final float itemSize;
    private final List<Keyline> keylines;
    private final int lastFocalKeylineIndex;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class Builder {
        private static final int NO_INDEX = -1;
        private static final float UNKNOWN_LOC = Float.MIN_VALUE;
        private final float availableSpace;
        private final float itemSize;
        private Keyline tmpFirstFocalKeyline;
        private Keyline tmpLastFocalKeyline;
        private final List<Keyline> tmpKeylines = new ArrayList();
        private int firstFocalKeylineIndex = -1;
        private int lastFocalKeylineIndex = -1;
        private float lastKeylineMaskedSize = 0.0f;
        private int latestAnchorKeylineIndex = -1;

        public Builder(float f6, float f7) {
            this.itemSize = f6;
            this.availableSpace = f7;
        }

        private static float calculateKeylineLocationForItemPosition(float f6, float f7, int i5, int i6) {
            return (i6 * f7) + (f6 - (i5 * f7));
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder addAnchorKeyline(float f6, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float f7, float f8) {
            return addKeyline(f6, f7, f8, false, true);
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder addKeyline(float f6, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float f7, float f8, boolean z6) {
            return addKeyline(f6, f7, f8, z6, false);
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder addKeylineRange(float f6, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float f7, float f8, int i5) {
            return addKeylineRange(f6, f7, f8, i5, false);
        }

        @NonNull
        public KeylineState build() {
            if (this.tmpFirstFocalKeyline == null) {
                throw new IllegalStateException("There must be a keyline marked as focal.");
            }
            ArrayList arrayList = new ArrayList();
            for (int i5 = 0; i5 < this.tmpKeylines.size(); i5++) {
                Keyline keyline = this.tmpKeylines.get(i5);
                arrayList.add(new Keyline(calculateKeylineLocationForItemPosition(this.tmpFirstFocalKeyline.locOffset, this.itemSize, this.firstFocalKeylineIndex, i5), keyline.locOffset, keyline.mask, keyline.maskedItemSize, keyline.isAnchor, keyline.cutoff, keyline.leftOrTopPaddingShift, keyline.rightOrBottomPaddingShift));
            }
            return new KeylineState(this.itemSize, arrayList, this.firstFocalKeylineIndex, this.lastFocalKeylineIndex);
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder addKeyline(float f6, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float f7, float f8) {
            return addKeyline(f6, f7, f8, false);
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder addKeylineRange(float f6, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float f7, float f8, int i5, boolean z6) {
            if (i5 > 0 && f8 > 0.0f) {
                for (int i6 = 0; i6 < i5; i6++) {
                    addKeyline((i6 * f8) + f6, f7, f8, z6);
                }
            }
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder addKeyline(float f6, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float f7, float f8, boolean z6, boolean z7, float f9, float f10, float f11) {
            if (f8 <= 0.0f) {
                return this;
            }
            if (z7) {
                if (!z6) {
                    int i5 = this.latestAnchorKeylineIndex;
                    if (i5 != -1 && i5 != 0) {
                        throw new IllegalArgumentException("Anchor keylines must be either the first or last keyline.");
                    }
                    this.latestAnchorKeylineIndex = this.tmpKeylines.size();
                } else {
                    throw new IllegalArgumentException("Anchor keylines cannot be focal.");
                }
            }
            Keyline keyline = new Keyline(UNKNOWN_LOC, f6, f7, f8, z7, f9, f10, f11);
            if (z6) {
                if (this.tmpFirstFocalKeyline == null) {
                    this.tmpFirstFocalKeyline = keyline;
                    this.firstFocalKeylineIndex = this.tmpKeylines.size();
                }
                if (this.lastFocalKeylineIndex != -1 && this.tmpKeylines.size() - this.lastFocalKeylineIndex > 1) {
                    throw new IllegalArgumentException("Keylines marked as focal must be placed next to each other. There cannot be non-focal keylines between focal keylines.");
                }
                if (f8 == this.tmpFirstFocalKeyline.maskedItemSize) {
                    this.tmpLastFocalKeyline = keyline;
                    this.lastFocalKeylineIndex = this.tmpKeylines.size();
                } else {
                    throw new IllegalArgumentException("Keylines that are marked as focal must all have the same masked item size.");
                }
            } else {
                if (this.tmpFirstFocalKeyline == null && keyline.maskedItemSize < this.lastKeylineMaskedSize) {
                    throw new IllegalArgumentException("Keylines before the first focal keyline must be ordered by incrementing masked item size.");
                }
                if (this.tmpLastFocalKeyline != null && keyline.maskedItemSize > this.lastKeylineMaskedSize) {
                    throw new IllegalArgumentException("Keylines after the last focal keyline must be ordered by decreasing masked item size.");
                }
            }
            this.lastKeylineMaskedSize = keyline.maskedItemSize;
            this.tmpKeylines.add(keyline);
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder addKeyline(float f6, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float f7, float f8, boolean z6, boolean z7, float f9) {
            return addKeyline(f6, f7, f8, z6, z7, f9, 0.0f, 0.0f);
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder addKeyline(float f6, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float f7, float f8, boolean z6, boolean z7) {
            float fAbs;
            float f9 = f8 / 2.0f;
            float f10 = f6 - f9;
            float f11 = f9 + f6;
            float f12 = this.availableSpace;
            if (f11 > f12) {
                fAbs = Math.abs(f11 - Math.max(f11 - f8, f12));
            } else {
                fAbs = 0.0f;
                if (f10 < 0.0f) {
                    fAbs = Math.abs(f10 - Math.min(f10 + f8, 0.0f));
                }
            }
            return addKeyline(f6, f7, f8, z6, z7, fAbs);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class Keyline {
        final float cutoff;
        final boolean isAnchor;
        final float leftOrTopPaddingShift;
        final float loc;
        final float locOffset;
        final float mask;
        final float maskedItemSize;
        final float rightOrBottomPaddingShift;

        public Keyline(float f6, float f7, float f8, float f9) {
            this(f6, f7, f8, f9, false, 0.0f, 0.0f, 0.0f);
        }

        public static Keyline lerp(Keyline keyline, Keyline keyline2, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float f6) {
            return new Keyline(AnimationUtils.lerp(keyline.loc, keyline2.loc, f6), AnimationUtils.lerp(keyline.locOffset, keyline2.locOffset, f6), AnimationUtils.lerp(keyline.mask, keyline2.mask, f6), AnimationUtils.lerp(keyline.maskedItemSize, keyline2.maskedItemSize, f6));
        }

        public Keyline(float f6, float f7, float f8, float f9, boolean z6, float f10, float f11, float f12) {
            this.loc = f6;
            this.locOffset = f7;
            this.mask = f8;
            this.maskedItemSize = f9;
            this.isAnchor = z6;
            this.cutoff = f10;
            this.leftOrTopPaddingShift = f11;
            this.rightOrBottomPaddingShift = f12;
        }
    }

    public static KeylineState lerp(KeylineState keylineState, KeylineState keylineState2, float f6) {
        if (keylineState.getItemSize() != keylineState2.getItemSize()) {
            throw new IllegalArgumentException("Keylines being linearly interpolated must have the same item size.");
        }
        List<Keyline> keylines = keylineState.getKeylines();
        List<Keyline> keylines2 = keylineState2.getKeylines();
        if (keylines.size() != keylines2.size()) {
            throw new IllegalArgumentException("Keylines being linearly interpolated must have the same number of keylines.");
        }
        ArrayList arrayList = new ArrayList();
        for (int i5 = 0; i5 < keylineState.getKeylines().size(); i5++) {
            arrayList.add(Keyline.lerp(keylines.get(i5), keylines2.get(i5), f6));
        }
        return new KeylineState(keylineState.getItemSize(), arrayList, AnimationUtils.lerp(keylineState.getFirstFocalKeylineIndex(), keylineState2.getFirstFocalKeylineIndex(), f6), AnimationUtils.lerp(keylineState.getLastFocalKeylineIndex(), keylineState2.getLastFocalKeylineIndex(), f6));
    }

    public static KeylineState reverse(KeylineState keylineState, float f6) {
        Builder builder = new Builder(keylineState.getItemSize(), f6);
        float f7 = (f6 - keylineState.getLastKeyline().locOffset) - (keylineState.getLastKeyline().maskedItemSize / 2.0f);
        int size = keylineState.getKeylines().size() - 1;
        while (size >= 0) {
            Keyline keyline = keylineState.getKeylines().get(size);
            builder.addKeyline((keyline.maskedItemSize / 2.0f) + f7, keyline.mask, keyline.maskedItemSize, size >= keylineState.getFirstFocalKeylineIndex() && size <= keylineState.getLastFocalKeylineIndex(), keyline.isAnchor);
            f7 += keyline.maskedItemSize;
            size--;
        }
        return builder.build();
    }

    public Keyline getFirstFocalKeyline() {
        return this.keylines.get(this.firstFocalKeylineIndex);
    }

    public int getFirstFocalKeylineIndex() {
        return this.firstFocalKeylineIndex;
    }

    public Keyline getFirstKeyline() {
        return this.keylines.get(0);
    }

    @Nullable
    public Keyline getFirstNonAnchorKeyline() {
        for (int i5 = 0; i5 < this.keylines.size(); i5++) {
            Keyline keyline = this.keylines.get(i5);
            if (!keyline.isAnchor) {
                return keyline;
            }
        }
        return null;
    }

    public List<Keyline> getFocalKeylines() {
        return this.keylines.subList(this.firstFocalKeylineIndex, this.lastFocalKeylineIndex + 1);
    }

    public float getItemSize() {
        return this.itemSize;
    }

    public List<Keyline> getKeylines() {
        return this.keylines;
    }

    public Keyline getLastFocalKeyline() {
        return this.keylines.get(this.lastFocalKeylineIndex);
    }

    public int getLastFocalKeylineIndex() {
        return this.lastFocalKeylineIndex;
    }

    public Keyline getLastKeyline() {
        return (Keyline) AbstractC0157z.f(1, this.keylines);
    }

    @Nullable
    public Keyline getLastNonAnchorKeyline() {
        for (int size = this.keylines.size() - 1; size >= 0; size--) {
            Keyline keyline = this.keylines.get(size);
            if (!keyline.isAnchor) {
                return keyline;
            }
        }
        return null;
    }

    public int getNumberOfNonAnchorKeylines() {
        Iterator<Keyline> it = this.keylines.iterator();
        int i5 = 0;
        while (it.hasNext()) {
            if (it.next().isAnchor) {
                i5++;
            }
        }
        return this.keylines.size() - i5;
    }

    private KeylineState(float f6, List<Keyline> list, int i5, int i6) {
        this.itemSize = f6;
        this.keylines = Collections.unmodifiableList(list);
        this.firstFocalKeylineIndex = i5;
        this.lastFocalKeylineIndex = i6;
    }
}
