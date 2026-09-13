package kotlinx.serialization.json.internal;

import p147z3.C1929i;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class E {
    public static final C1149z InvalidFloatingPointDecoded(Number value, String key, String output) {
        kotlin.jvm.internal.E.f(value, "value");
        kotlin.jvm.internal.E.f(key, "key");
        kotlin.jvm.internal.E.f(output, "output");
        return JsonDecodingException(-1, b(value, key, output));
    }

    public static final C InvalidFloatingPointEncoded(Number value, String output) {
        kotlin.jvm.internal.E.f(value, "value");
        kotlin.jvm.internal.E.f(output, "output");
        return new C("Unexpected special floating-point value " + value + ". By default, non-finite floating point values are prohibited because they do not conform JSON specification. It is possible to deserialize them using 'JsonBuilder.allowSpecialFloatingPointValues = true'\nCurrent output: " + ((Object) minify(output, -1)));
    }

    public static final C InvalidKeyKindException(p072m4.r keyDescriptor) {
        kotlin.jvm.internal.E.f(keyDescriptor, "keyDescriptor");
        return new C("Value of type '" + keyDescriptor.getSerialName() + "' can't be used in JSON as a key in the map. It should have either primitive or enum kind, but its kind is '" + keyDescriptor.getKind() + "'.\nUse 'allowStructuredMapKeys = true' in 'Json {}' builder to convert such maps to [key1, value1, key2, value2,...] arrays.");
    }

    public static final C1149z JsonDecodingException(int i5, String message) {
        kotlin.jvm.internal.E.f(message, "message");
        if (i5 >= 0) {
            message = "Unexpected JSON token at offset " + i5 + ": " + message;
        }
        return new C1149z(message);
    }

    public static final C1149z UnknownKeyException(String key, String input) {
        kotlin.jvm.internal.E.f(key, "key");
        kotlin.jvm.internal.E.f(input, "input");
        return JsonDecodingException(-1, "Encountered an unknown key '" + key + "'.\nUse 'ignoreUnknownKeys = true' in 'Json {}' builder to ignore unknown keys.\nCurrent input: " + ((Object) minify(input, -1)));
    }

    public static final String b(Number number, String str, String str2) {
        return "Unexpected special floating-point value " + number + " with key " + str + ". By default, non-finite floating point values are prohibited because they do not conform JSON specification. It is possible to deserialize them using 'JsonBuilder.allowSpecialFloatingPointValues = true'\nCurrent output: " + ((Object) minify(str2, -1));
    }

    public static final Void invalidTrailingComma(AbstractC1126b abstractC1126b, String entity) {
        kotlin.jvm.internal.E.f(abstractC1126b, "<this>");
        kotlin.jvm.internal.E.f(entity, "entity");
        abstractC1126b.fail("Trailing comma before the end of JSON ".concat(entity), abstractC1126b.currentPosition - 1, "Trailing commas are non-complaint JSON and not allowed by default. Use 'allowTrailingCommas = true' in 'Json {}' builder to support them.");
        throw new C1929i();
    }

    public static final CharSequence minify(CharSequence charSequence, int i5) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        if (charSequence.length() >= 200) {
            if (i5 != -1) {
                int i6 = i5 - 30;
                int i7 = i5 + 30;
                String str = i6 <= 0 ? "" : ".....";
                String str2 = i7 >= charSequence.length() ? "" : ".....";
                StringBuilder sbR = androidx.collection.a.r(str);
                if (i6 < 0) {
                    i6 = 0;
                }
                int length = charSequence.length();
                if (i7 > length) {
                    i7 = length;
                }
                sbR.append(charSequence.subSequence(i6, i7).toString());
                sbR.append(str2);
                return sbR.toString();
            }
            int length2 = charSequence.length() - 60;
            if (length2 > 0) {
                return "....." + charSequence.subSequence(length2, charSequence.length()).toString();
            }
        }
        return charSequence;
    }

    public static final Void throwInvalidFloatingPointDecoded(AbstractC1126b abstractC1126b, Number result) {
        kotlin.jvm.internal.E.f(abstractC1126b, "<this>");
        kotlin.jvm.internal.E.f(result, "result");
        throw AbstractC1125a.k(abstractC1126b, "Unexpected special floating-point value " + result + ". By default, non-finite floating point values are prohibited because they do not conform JSON specification", 0, AbstractC1127c.specialFlowingValuesHint, 2);
    }

    public static final C1149z JsonDecodingException(int i5, String message, CharSequence input) {
        kotlin.jvm.internal.E.f(message, "message");
        kotlin.jvm.internal.E.f(input, "input");
        return JsonDecodingException(i5, message + "\nJSON input: " + ((Object) minify(input, i5)));
    }

    public static final C InvalidFloatingPointEncoded(Number value, String key, String output) {
        kotlin.jvm.internal.E.f(value, "value");
        kotlin.jvm.internal.E.f(key, "key");
        kotlin.jvm.internal.E.f(output, "output");
        return new C(b(value, key, output));
    }
}
