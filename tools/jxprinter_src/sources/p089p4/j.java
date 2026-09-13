package p089p4;

import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f7758a;
    public final boolean b;
    public final boolean c;
    private final String classDiscriminator;
    private EnumC1516a classDiscriminatorMode;
    public final boolean d;
    public final boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f7759f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f7760g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f7761h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f7762i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f7763j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f7764k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f7765l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f7766m;
    private final w namingStrategy;
    private final String prettyPrintIndent;

    public j(boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, boolean z11, String prettyPrintIndent, boolean z12, boolean z13, String classDiscriminator, boolean z14, boolean z15, w wVar, boolean z16, boolean z17, boolean z18, EnumC1516a classDiscriminatorMode) {
        E.f(prettyPrintIndent, "prettyPrintIndent");
        E.f(classDiscriminator, "classDiscriminator");
        E.f(classDiscriminatorMode, "classDiscriminatorMode");
        this.f7758a = z6;
        this.b = z7;
        this.c = z8;
        this.d = z9;
        this.e = z10;
        this.f7759f = z11;
        this.prettyPrintIndent = prettyPrintIndent;
        this.f7760g = z12;
        this.f7761h = z13;
        this.classDiscriminator = classDiscriminator;
        this.f7762i = z14;
        this.f7763j = z15;
        this.namingStrategy = wVar;
        this.f7764k = z16;
        this.f7765l = z17;
        this.f7766m = z18;
        this.classDiscriminatorMode = classDiscriminatorMode;
    }

    public final String getClassDiscriminator() {
        return this.classDiscriminator;
    }

    public final EnumC1516a getClassDiscriminatorMode() {
        return this.classDiscriminatorMode;
    }

    public final w getNamingStrategy() {
        return this.namingStrategy;
    }

    public final String getPrettyPrintIndent() {
        return this.prettyPrintIndent;
    }

    public final void setClassDiscriminatorMode(EnumC1516a enumC1516a) {
        E.f(enumC1516a, "<set-?>");
        this.classDiscriminatorMode = enumC1516a;
    }

    public String toString() {
        return "JsonConfiguration(encodeDefaults=" + this.f7758a + ", ignoreUnknownKeys=" + this.b + ", isLenient=" + this.c + ", allowStructuredMapKeys=" + this.d + ", prettyPrint=" + this.e + ", explicitNulls=" + this.f7759f + ", prettyPrintIndent='" + this.prettyPrintIndent + "', coerceInputValues=" + this.f7760g + ", useArrayPolymorphism=" + this.f7761h + ", classDiscriminator='" + this.classDiscriminator + "', allowSpecialFloatingPointValues=" + this.f7762i + ", useAlternativeNames=" + this.f7763j + ", namingStrategy=" + this.namingStrategy + ", decodeEnumsCaseInsensitive=" + this.f7764k + ", allowTrailingComma=" + this.f7765l + ", allowComments=" + this.f7766m + ", classDiscriminatorMode=" + this.classDiscriminatorMode + ')';
    }

    public static /* synthetic */ void getAllowComments$annotations() {
    }

    public static /* synthetic */ void getAllowTrailingComma$annotations() {
    }

    public static /* synthetic */ void getClassDiscriminatorMode$annotations() {
    }

    public static /* synthetic */ void getDecodeEnumsCaseInsensitive$annotations() {
    }

    public static /* synthetic */ void getNamingStrategy$annotations() {
    }

    public static /* synthetic */ void getPrettyPrintIndent$annotations() {
    }
}
