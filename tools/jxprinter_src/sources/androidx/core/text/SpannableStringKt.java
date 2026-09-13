package androidx.core.text;

import U3.q;
import android.text.Spannable;
import android.text.SpannableString;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class SpannableStringKt {
    public static final void clearSpans(Spannable spannable) {
        for (Object obj : spannable.getSpans(0, spannable.length(), Object.class)) {
            spannable.removeSpan(obj);
        }
    }

    public static final void set(Spannable spannable, int i5, int i6, Object obj) {
        spannable.setSpan(obj, i5, i6, 17);
    }

    public static final Spannable toSpannable(CharSequence charSequence) {
        return SpannableString.valueOf(charSequence);
    }

    public static final void set(Spannable spannable, q qVar, Object obj) {
        spannable.setSpan(obj, qVar.getStart().intValue(), qVar.getEndInclusive().intValue(), 17);
    }
}
