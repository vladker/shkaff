package X3;

import A3.AbstractC0157z;
import W3.InterfaceC0233q;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class G implements Serializable {
    public static final E Companion = new E();
    private Set<? extends K> _options;
    private final Pattern nativePattern;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class a implements Serializable {
        public static final F Companion = new F();
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f843a;
        private final String pattern;

        public a(String pattern, int i5) {
            kotlin.jvm.internal.E.f(pattern, "pattern");
            this.pattern = pattern;
            this.f843a = i5;
        }

        private final Object readResolve() {
            Pattern patternCompile = Pattern.compile(this.pattern, this.f843a);
            kotlin.jvm.internal.E.e(patternCompile, "compile(...)");
            return new G(patternCompile);
        }

        public final String getPattern() {
            return this.pattern;
        }
    }

    public G(Pattern nativePattern) {
        kotlin.jvm.internal.E.f(nativePattern, "nativePattern");
        this.nativePattern = nativePattern;
    }

    private final Object writeReplace() {
        String strPattern = this.nativePattern.pattern();
        kotlin.jvm.internal.E.e(strPattern, "pattern(...)");
        return new a(strPattern, this.nativePattern.flags());
    }

    public final boolean containsMatchIn(CharSequence input) {
        kotlin.jvm.internal.E.f(input, "input");
        return this.nativePattern.matcher(input).find();
    }

    public final InterfaceC0259z find(CharSequence input, int i5) {
        kotlin.jvm.internal.E.f(input, "input");
        Matcher matcher = this.nativePattern.matcher(input);
        kotlin.jvm.internal.E.e(matcher, "matcher(...)");
        if (matcher.find(i5)) {
            return new C(matcher, input);
        }
        return null;
    }

    public final InterfaceC0233q findAll(CharSequence input, int i5) {
        kotlin.jvm.internal.E.f(input, "input");
        if (i5 >= 0 && i5 <= input.length()) {
            return W3.z.generateSequence((O3.a) new D(input, this, i5), (O3.l) H.f844a);
        }
        StringBuilder sbT = AbstractC0157z.t(i5, "Start index out of bounds: ", ", input length: ");
        sbT.append(input.length());
        throw new IndexOutOfBoundsException(sbT.toString());
    }

    public final Set<K> getOptions() {
        Set set = this._options;
        if (set != null) {
            return set;
        }
        int iFlags = this.nativePattern.flags();
        EnumSet enumSetAllOf = EnumSet.allOf(K.class);
        kotlin.jvm.internal.E.c(enumSetAllOf);
        A3.O.retainAll(enumSetAllOf, new I(iFlags));
        Set<K> setUnmodifiableSet = Collections.unmodifiableSet(enumSetAllOf);
        kotlin.jvm.internal.E.e(setUnmodifiableSet, "unmodifiableSet(...)");
        this._options = setUnmodifiableSet;
        return setUnmodifiableSet;
    }

    public final String getPattern() {
        String strPattern = this.nativePattern.pattern();
        kotlin.jvm.internal.E.e(strPattern, "pattern(...)");
        return strPattern;
    }

    public final InterfaceC0259z matchAt(CharSequence input, int i5) {
        kotlin.jvm.internal.E.f(input, "input");
        Matcher matcherRegion = this.nativePattern.matcher(input).useAnchoringBounds(false).useTransparentBounds(true).region(i5, input.length());
        if (matcherRegion.lookingAt()) {
            return new C(matcherRegion, input);
        }
        return null;
    }

    public final InterfaceC0259z matchEntire(CharSequence input) {
        kotlin.jvm.internal.E.f(input, "input");
        Matcher matcher = this.nativePattern.matcher(input);
        kotlin.jvm.internal.E.e(matcher, "matcher(...)");
        if (matcher.matches()) {
            return new C(matcher, input);
        }
        return null;
    }

    public final boolean matches(CharSequence input) {
        kotlin.jvm.internal.E.f(input, "input");
        return this.nativePattern.matcher(input).matches();
    }

    public final boolean matchesAt(CharSequence input, int i5) {
        kotlin.jvm.internal.E.f(input, "input");
        return this.nativePattern.matcher(input).useAnchoringBounds(false).useTransparentBounds(true).region(i5, input.length()).lookingAt();
    }

    public final String replace(CharSequence input, O3.l transform) {
        kotlin.jvm.internal.E.f(input, "input");
        kotlin.jvm.internal.E.f(transform, "transform");
        int iIntValue = 0;
        InterfaceC0259z interfaceC0259zFind = find(input, 0);
        if (interfaceC0259zFind == null) {
            return input.toString();
        }
        int length = input.length();
        StringBuilder sb = new StringBuilder(length);
        do {
            sb.append(input, iIntValue, interfaceC0259zFind.getRange().getStart().intValue());
            sb.append((CharSequence) transform.invoke(interfaceC0259zFind));
            iIntValue = interfaceC0259zFind.getRange().getEndInclusive().intValue() + 1;
            interfaceC0259zFind = interfaceC0259zFind.next();
            if (iIntValue >= length) {
                break;
            }
        } while (interfaceC0259zFind != null);
        if (iIntValue < length) {
            sb.append(input, iIntValue, length);
        }
        String string = sb.toString();
        kotlin.jvm.internal.E.e(string, "toString(...)");
        return string;
    }

    public final String replaceFirst(CharSequence input, String replacement) {
        kotlin.jvm.internal.E.f(input, "input");
        kotlin.jvm.internal.E.f(replacement, "replacement");
        String strReplaceFirst = this.nativePattern.matcher(input).replaceFirst(replacement);
        kotlin.jvm.internal.E.e(strReplaceFirst, "replaceFirst(...)");
        return strReplaceFirst;
    }

    public final List<String> split(CharSequence input, int i5) {
        kotlin.jvm.internal.E.f(input, "input");
        b0.j(i5);
        Matcher matcher = this.nativePattern.matcher(input);
        if (i5 == 1 || !matcher.find()) {
            return A3.G.listOf(input.toString());
        }
        int i6 = 10;
        if (i5 > 0 && i5 <= 10) {
            i6 = i5;
        }
        ArrayList arrayList = new ArrayList(i6);
        int i7 = i5 - 1;
        int iEnd = 0;
        do {
            arrayList.add(input.subSequence(iEnd, matcher.start()).toString());
            iEnd = matcher.end();
            if (i7 >= 0 && arrayList.size() == i7) {
                break;
            }
        } while (matcher.find());
        arrayList.add(input.subSequence(iEnd, input.length()).toString());
        return arrayList;
    }

    public final InterfaceC0233q splitToSequence(CharSequence input, int i5) {
        kotlin.jvm.internal.E.f(input, "input");
        b0.j(i5);
        return W3.t.sequence(new J(this, input, i5, null));
    }

    public final Pattern toPattern() {
        return this.nativePattern;
    }

    public String toString() {
        String string = this.nativePattern.toString();
        kotlin.jvm.internal.E.e(string, "toString(...)");
        return string;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public G(String pattern) {
        kotlin.jvm.internal.E.f(pattern, "pattern");
        Pattern patternCompile = Pattern.compile(pattern);
        kotlin.jvm.internal.E.e(patternCompile, "compile(...)");
        this(patternCompile);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public G(String pattern, K option) {
        kotlin.jvm.internal.E.f(pattern, "pattern");
        kotlin.jvm.internal.E.f(option, "option");
        E e = Companion;
        int i5 = option.f849a;
        e.getClass();
        Pattern patternCompile = Pattern.compile(pattern, (i5 & 2) != 0 ? i5 | 64 : i5);
        kotlin.jvm.internal.E.e(patternCompile, "compile(...)");
        this(patternCompile);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public G(String pattern, Set<? extends K> options) {
        kotlin.jvm.internal.E.f(pattern, "pattern");
        kotlin.jvm.internal.E.f(options, "options");
        E e = Companion;
        Iterator<T> it = options.iterator();
        int i5 = 0;
        while (it.hasNext()) {
            i5 |= ((K) ((InterfaceC0244j) it.next())).f849a;
        }
        e.getClass();
        Pattern patternCompile = Pattern.compile(pattern, (i5 & 2) != 0 ? i5 | 64 : i5);
        kotlin.jvm.internal.E.e(patternCompile, "compile(...)");
        this(patternCompile);
    }

    public final String replace(CharSequence input, String replacement) {
        kotlin.jvm.internal.E.f(input, "input");
        kotlin.jvm.internal.E.f(replacement, "replacement");
        String strReplaceAll = this.nativePattern.matcher(input).replaceAll(replacement);
        kotlin.jvm.internal.E.e(strReplaceAll, "replaceAll(...)");
        return strReplaceAll;
    }
}
