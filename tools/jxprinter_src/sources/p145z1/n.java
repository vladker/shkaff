package p145z1;

import android.graphics.Paint;
import androidx.exifinterface.media.a;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f9112a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f9113f;
    private final String fontName;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f9114g;
    private final String text;
    private final Paint.Align textAlign;

    public n(String text, int i5, int i6, int i7, int i8, int i9, int i10, int i11, String fontName, Paint.Align textAlign) {
        E.f(text, "text");
        E.f(fontName, "fontName");
        E.f(textAlign, "textAlign");
        this.text = text;
        this.f9112a = i5;
        this.b = i6;
        this.c = i7;
        this.d = i8;
        this.e = i9;
        this.f9113f = i10;
        this.f9114g = i11;
        this.fontName = fontName;
        this.textAlign = textAlign;
    }

    public final String component1() {
        return this.text;
    }

    public final Paint.Align component10() {
        return this.textAlign;
    }

    public final String component9() {
        return this.fontName;
    }

    public final n copy(String text, int i5, int i6, int i7, int i8, int i9, int i10, int i11, String fontName, Paint.Align textAlign) {
        E.f(text, "text");
        E.f(fontName, "fontName");
        E.f(textAlign, "textAlign");
        return new n(text, i5, i6, i7, i8, i9, i10, i11, fontName, textAlign);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        return E.a(this.text, nVar.text) && this.f9112a == nVar.f9112a && this.b == nVar.b && this.c == nVar.c && this.d == nVar.d && this.e == nVar.e && this.f9113f == nVar.f9113f && this.f9114g == nVar.f9114g && E.a(this.fontName, nVar.fontName) && this.textAlign == nVar.textAlign;
    }

    public final String getFontName() {
        return this.fontName;
    }

    public final String getText() {
        return this.text;
    }

    public final Paint.Align getTextAlign() {
        return this.textAlign;
    }

    public final int hashCode() {
        return this.textAlign.hashCode() + a.a((Integer.hashCode(this.f9114g) + ((Integer.hashCode(this.f9113f) + ((Integer.hashCode(this.e) + ((Integer.hashCode(this.d) + ((Integer.hashCode(this.c) + ((Integer.hashCode(this.b) + ((Integer.hashCode(this.f9112a) + (this.text.hashCode() * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31, 31, this.fontName);
    }

    public String toString() {
        return "Text(text=" + this.text + ", x=" + this.f9112a + ", y=" + this.b + ", fontSizePx=" + this.c + ", r=" + this.d + ", g=" + this.e + ", b=" + this.f9113f + ", a=" + this.f9114g + ", fontName=" + this.fontName + ", textAlign=" + this.textAlign + ')';
    }
}
