package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
@GwtCompatible
@ElementTypesAreNonnullByDefault
final class Count implements Serializable {
    private int value;

    public Count(int i5) {
        this.value = i5;
    }

    public void add(int i5) {
        this.value += i5;
    }

    public int addAndGet(int i5) {
        int i6 = this.value + i5;
        this.value = i6;
        return i6;
    }

    public boolean equals(Object obj) {
        return (obj instanceof Count) && ((Count) obj).value == this.value;
    }

    public int get() {
        return this.value;
    }

    public int getAndSet(int i5) {
        int i6 = this.value;
        this.value = i5;
        return i6;
    }

    public int hashCode() {
        return this.value;
    }

    public void set(int i5) {
        this.value = i5;
    }

    public String toString() {
        return Integer.toString(this.value);
    }
}
