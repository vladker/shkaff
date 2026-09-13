package com.google.android.material.carousel;

import androidx.annotation.NonNull;
import androidx.core.math.MathUtils;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
final class Arrangement {
    private static final float MEDIUM_ITEM_FLEX_PERCENTAGE = 0.1f;
    final float cost;
    final int largeCount;
    float largeSize;
    int mediumCount;
    float mediumSize;
    final int priority;
    int smallCount;
    float smallSize;

    public Arrangement(int i5, float f6, float f7, float f8, int i6, float f9, int i7, float f10, int i8, float f11) {
        this.priority = i5;
        this.smallSize = MathUtils.clamp(f6, f7, f8);
        this.smallCount = i6;
        this.mediumSize = f9;
        this.mediumCount = i7;
        this.largeSize = f10;
        this.largeCount = i8;
        fit(f11, f7, f8, f10);
        this.cost = cost(f10);
    }

    private float calculateLargeSize(float f6, int i5, float f7, int i6, int i7) {
        if (i5 <= 0) {
            f7 = 0.0f;
        }
        float f8 = i6 / 2.0f;
        return (f6 - ((i5 + f8) * f7)) / (i7 + f8);
    }

    private float cost(float f6) {
        if (isValid()) {
            return Math.abs(f6 - this.largeSize) * this.priority;
        }
        return Float.MAX_VALUE;
    }

    public static Arrangement findLowestCostArrangement(float f6, float f7, float f8, float f9, int[] iArr, float f10, int[] iArr2, float f11, int[] iArr3) {
        Arrangement arrangement = null;
        int i5 = 1;
        for (int i6 : iArr3) {
            int length = iArr2.length;
            int i7 = 0;
            while (i7 < length) {
                int i8 = iArr2[i7];
                int length2 = iArr.length;
                int i9 = 0;
                while (i9 < length2) {
                    int i10 = length;
                    int i11 = i7;
                    int i12 = i5;
                    int i13 = length2;
                    int i14 = i9;
                    Arrangement arrangement2 = new Arrangement(i12, f7, f8, f9, iArr[i9], f10, i8, f11, i6, f6);
                    if (arrangement == null || arrangement2.cost < arrangement.cost) {
                        if (arrangement2.cost == 0.0f) {
                            return arrangement2;
                        }
                        arrangement = arrangement2;
                    }
                    int i15 = i12 + 1;
                    i9 = i14 + 1;
                    i7 = i11;
                    i5 = i15;
                    length = i10;
                    length2 = i13;
                }
                i7++;
                i5 = i5;
                length = length;
            }
        }
        return arrangement;
    }

    private void fit(float f6, float f7, float f8, float f9) {
        float space = f6 - getSpace();
        int i5 = this.smallCount;
        if (i5 > 0 && space > 0.0f) {
            float f10 = this.smallSize;
            this.smallSize = Math.min(space / i5, f8 - f10) + f10;
        } else if (i5 > 0 && space < 0.0f) {
            float f11 = this.smallSize;
            this.smallSize = Math.max(space / i5, f7 - f11) + f11;
        }
        int i6 = this.smallCount;
        float f12 = i6 > 0 ? this.smallSize : 0.0f;
        this.smallSize = f12;
        float fCalculateLargeSize = calculateLargeSize(f6, i6, f12, this.mediumCount, this.largeCount);
        this.largeSize = fCalculateLargeSize;
        float f13 = (this.smallSize + fCalculateLargeSize) / 2.0f;
        this.mediumSize = f13;
        int i7 = this.mediumCount;
        if (i7 <= 0 || fCalculateLargeSize == f9) {
            return;
        }
        float f14 = (f9 - fCalculateLargeSize) * this.largeCount;
        float fMin = Math.min(Math.abs(f14), f13 * 0.1f * i7);
        if (f14 > 0.0f) {
            this.mediumSize -= fMin / this.mediumCount;
            this.largeSize = (fMin / this.largeCount) + this.largeSize;
        } else {
            this.mediumSize = (fMin / this.mediumCount) + this.mediumSize;
            this.largeSize -= fMin / this.largeCount;
        }
    }

    private float getSpace() {
        return (this.smallSize * this.smallCount) + (this.mediumSize * this.mediumCount) + (this.largeSize * this.largeCount);
    }

    private boolean isValid() {
        int i5 = this.largeCount;
        if (i5 <= 0 || this.smallCount <= 0 || this.mediumCount <= 0) {
            return i5 <= 0 || this.smallCount <= 0 || this.largeSize > this.smallSize;
        }
        float f6 = this.largeSize;
        float f7 = this.mediumSize;
        return f6 > f7 && f7 > this.smallSize;
    }

    public int getItemCount() {
        return this.smallCount + this.mediumCount + this.largeCount;
    }

    @NonNull
    public String toString() {
        StringBuilder sb = new StringBuilder("Arrangement [priority=");
        sb.append(this.priority);
        sb.append(", smallCount=");
        sb.append(this.smallCount);
        sb.append(", smallSize=");
        sb.append(this.smallSize);
        sb.append(", mediumCount=");
        sb.append(this.mediumCount);
        sb.append(", mediumSize=");
        sb.append(this.mediumSize);
        sb.append(", largeCount=");
        sb.append(this.largeCount);
        sb.append(", largeSize=");
        sb.append(this.largeSize);
        sb.append(", cost=");
        return androidx.collection.a.q(sb, "]", this.cost);
    }
}
