package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class I implements Appendable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Appendable f2959a;
    public boolean b = true;

    public I(Appendable appendable) {
        this.f2959a = appendable;
    }

    @NonNull
    private CharSequence safeSequence(@Nullable CharSequence charSequence) {
        return charSequence == null ? "" : charSequence;
    }

    @Override // java.lang.Appendable
    public Appendable append(char c) throws IOException {
        boolean z6 = this.b;
        Appendable appendable = this.f2959a;
        if (z6) {
            this.b = false;
            appendable.append("  ");
        }
        this.b = c == '\n';
        appendable.append(c);
        return this;
    }

    @Override // java.lang.Appendable
    public Appendable append(@Nullable CharSequence charSequence) {
        CharSequence charSequenceSafeSequence = safeSequence(charSequence);
        return append(charSequenceSafeSequence, 0, charSequenceSafeSequence.length());
    }

    @Override // java.lang.Appendable
    public Appendable append(@Nullable CharSequence charSequence, int i5, int i6) throws IOException {
        CharSequence charSequenceSafeSequence = safeSequence(charSequence);
        boolean z6 = this.b;
        Appendable appendable = this.f2959a;
        boolean z7 = false;
        if (z6) {
            this.b = false;
            appendable.append("  ");
        }
        if (charSequenceSafeSequence.length() > 0 && charSequenceSafeSequence.charAt(i6 - 1) == '\n') {
            z7 = true;
        }
        this.b = z7;
        appendable.append(charSequenceSafeSequence, i5, i6);
        return this;
    }
}
