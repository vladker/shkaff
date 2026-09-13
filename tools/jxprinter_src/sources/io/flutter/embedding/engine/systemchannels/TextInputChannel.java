package io.flutter.embedding.engine.systemchannels;

import A3.AbstractC0157z;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.common.base.Ascii;
import io.flutter.Log;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.common.JSONMethodCodec;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.editing.TextEditingDelta;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.apache.xmlbeans.XmlErrorCodes;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class TextInputChannel {
    private static final String TAG = "TextInputChannel";

    @NonNull
    public final MethodChannel channel;

    @NonNull
    @VisibleForTesting
    final MethodChannel.MethodCallHandler parsingMethodHandler;

    @Nullable
    private TextInputMethodHandler textInputMethodHandler;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class Configuration {

        @Nullable
        public final String actionLabel;
        public final boolean autocorrect;

        @Nullable
        public final Autofill autofill;

        @Nullable
        public final String[] contentCommitMimeTypes;
        public final boolean enableDeltaModel;
        public final boolean enableIMEPersonalizedLearning;
        public final boolean enableSuggestions;

        @Nullable
        public final Configuration[] fields;

        @Nullable
        public final Locale[] hintLocales;

        @Nullable
        public final Integer inputAction;

        @NonNull
        public final InputType inputType;
        public final boolean obscureText;

        @NonNull
        public final TextCapitalization textCapitalization;

        /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
        public static class Autofill {
            public final TextEditState editState;
            public final String hintText;
            public final String[] hints;
            public final String uniqueIdentifier;

            public Autofill(@NonNull String str, @NonNull String[] strArr, @Nullable String str2, @NonNull TextEditState textEditState) {
                this.uniqueIdentifier = str;
                this.hints = strArr;
                this.hintText = str2;
                this.editState = textEditState;
            }

            @NonNull
            public static Autofill fromJson(@NonNull JSONObject jSONObject) throws JSONException {
                String string = jSONObject.getString("uniqueIdentifier");
                JSONArray jSONArray = jSONObject.getJSONArray("hints");
                String string2 = jSONObject.isNull("hintText") ? null : jSONObject.getString("hintText");
                JSONObject jSONObject2 = jSONObject.getJSONObject("editingValue");
                String[] strArr = new String[jSONArray.length()];
                for (int i5 = 0; i5 < jSONArray.length(); i5++) {
                    strArr[i5] = translateAutofillHint(jSONArray.getString(i5));
                }
                return new Autofill(string, strArr, string2, TextEditState.fromJson(jSONObject2));
            }

            /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
            @NonNull
            private static String translateAutofillHint(@NonNull String str) {
                str.getClass();
                byte b = -1;
                switch (str.hashCode()) {
                    case -2058889126:
                        if (str.equals("birthdayYear")) {
                            b = 0;
                        }
                        break;
                    case -1917283616:
                        if (str.equals("oneTimeCode")) {
                            b = 1;
                        }
                        break;
                    case -1844815832:
                        if (str.equals("creditCardExpirationMonth")) {
                            b = 2;
                        }
                        break;
                    case -1825589953:
                        if (str.equals("telephoneNumberNational")) {
                            b = 3;
                        }
                        break;
                    case -1821235109:
                        if (str.equals("newPassword")) {
                            b = 4;
                        }
                        break;
                    case -1757573738:
                        if (str.equals("creditCardSecurityCode")) {
                            b = 5;
                        }
                        break;
                    case -1682373820:
                        if (str.equals("creditCardExpirationDay")) {
                            b = 6;
                        }
                        break;
                    case -1658955742:
                        if (str.equals("fullStreetAddress")) {
                            b = 7;
                        }
                        break;
                    case -1567118045:
                        if (str.equals("telephoneNumberDevice")) {
                            b = 8;
                        }
                        break;
                    case -1476752575:
                        if (str.equals("countryName")) {
                            b = 9;
                        }
                        break;
                    case -1413737489:
                        if (str.equals("middleInitial")) {
                            b = 10;
                        }
                        break;
                    case -1377792129:
                        if (str.equals("addressCity")) {
                            b = 11;
                        }
                        break;
                    case -1249512767:
                        if (str.equals("gender")) {
                            b = 12;
                        }
                        break;
                    case -1186060294:
                        if (str.equals("postalAddressExtendedPostalCode")) {
                            b = 13;
                        }
                        break;
                    case -1151034798:
                        if (str.equals("creditCardNumber")) {
                            b = 14;
                        }
                        break;
                    case -835992323:
                        if (str.equals("namePrefix")) {
                            b = 15;
                        }
                        break;
                    case -818219584:
                        if (str.equals("middleName")) {
                            b = 16;
                        }
                        break;
                    case -747304516:
                        if (str.equals("nameSuffix")) {
                            b = 17;
                        }
                        break;
                    case -613980922:
                        if (str.equals("creditCardExpirationDate")) {
                            b = 18;
                        }
                        break;
                    case -613352043:
                        if (str.equals("creditCardExpirationYear")) {
                            b = 19;
                        }
                        break;
                    case -549230602:
                        if (str.equals("telephoneNumberCountryCode")) {
                            b = 20;
                        }
                        break;
                    case -265713450:
                        if (str.equals("username")) {
                            b = 21;
                        }
                        break;
                    case 3373707:
                        if (str.equals("name")) {
                            b = 22;
                        }
                        break;
                    case 96619420:
                        if (str.equals("email")) {
                            b = 23;
                        }
                        break;
                    case 253202685:
                        if (str.equals("addressState")) {
                            b = Ascii.CAN;
                        }
                        break;
                    case 588174851:
                        if (str.equals("birthdayMonth")) {
                            b = 25;
                        }
                        break;
                    case 798554127:
                        if (str.equals("familyName")) {
                            b = Ascii.SUB;
                        }
                        break;
                    case 892233837:
                        if (str.equals("telephoneNumber")) {
                            b = Ascii.ESC;
                        }
                        break;
                    case 991032982:
                        if (str.equals("newUsername")) {
                            b = Ascii.FS;
                        }
                        break;
                    case 1069376125:
                        if (str.equals("birthday")) {
                            b = 29;
                        }
                        break;
                    case 1216985755:
                        if (str.equals("password")) {
                            b = 30;
                        }
                        break;
                    case 1469046696:
                        if (str.equals("givenName")) {
                            b = 31;
                        }
                        break;
                    case 1662667945:
                        if (str.equals("postalAddress")) {
                            b = 32;
                        }
                        break;
                    case 1921869058:
                        if (str.equals("postalAddressExtended")) {
                            b = 33;
                        }
                        break;
                    case 2011152728:
                        if (str.equals("postalCode")) {
                            b = 34;
                        }
                        break;
                    case 2011773919:
                        if (str.equals("birthdayDay")) {
                            b = 35;
                        }
                        break;
                }
                switch (b) {
                    case 0:
                        return "birthDateYear";
                    case 1:
                        return "smsOTPCode";
                    case 2:
                        return "creditCardExpirationMonth";
                    case 3:
                        return "phoneNational";
                    case 4:
                        return "newPassword";
                    case 5:
                        return "creditCardSecurityCode";
                    case 6:
                        return "creditCardExpirationDay";
                    case 7:
                        return "streetAddress";
                    case 8:
                        return "phoneNumberDevice";
                    case 9:
                        return "addressCountry";
                    case 10:
                        return "personMiddleInitial";
                    case 11:
                        return "addressLocality";
                    case 12:
                        return "gender";
                    case 13:
                        return "extendedPostalCode";
                    case 14:
                        return "creditCardNumber";
                    case 15:
                        return "personNamePrefix";
                    case 16:
                        return "personMiddleName";
                    case 17:
                        return "personNameSuffix";
                    case 18:
                        return "creditCardExpirationDate";
                    case 19:
                        return "creditCardExpirationYear";
                    case 20:
                        return "phoneCountryCode";
                    case 21:
                        return "username";
                    case 22:
                        return "personName";
                    case 23:
                        return "emailAddress";
                    case 24:
                        return "addressRegion";
                    case 25:
                        return "birthDateMonth";
                    case 26:
                        return "personFamilyName";
                    case 27:
                        return "phoneNumber";
                    case 28:
                        return "newUsername";
                    case 29:
                        return "birthDateFull";
                    case 30:
                        return "password";
                    case 31:
                        return "personGivenName";
                    case 32:
                        return "postalAddress";
                    case 33:
                        return "extendedAddress";
                    case 34:
                        return "postalCode";
                    case 35:
                        return "birthDateDay";
                    default:
                        return str;
                }
            }
        }

        public Configuration(boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, @NonNull TextCapitalization textCapitalization, @NonNull InputType inputType, @Nullable Integer num, @Nullable String str, @Nullable Autofill autofill, @Nullable String[] strArr, @Nullable Configuration[] configurationArr, @Nullable Locale[] localeArr) {
            this.obscureText = z6;
            this.autocorrect = z7;
            this.enableSuggestions = z8;
            this.enableIMEPersonalizedLearning = z9;
            this.enableDeltaModel = z10;
            this.textCapitalization = textCapitalization;
            this.inputType = inputType;
            this.inputAction = num;
            this.actionLabel = str;
            this.autofill = autofill;
            this.contentCommitMimeTypes = strArr;
            this.fields = configurationArr;
            this.hintLocales = localeArr;
        }

        @NonNull
        public static Configuration fromJson(@NonNull JSONObject jSONObject) throws JSONException {
            Configuration[] configurationArr;
            Locale[] localeArr;
            String string = jSONObject.getString("inputAction");
            if (string == null) {
                throw new JSONException("Configuration JSON missing 'inputAction' property.");
            }
            if (jSONObject.isNull("fields")) {
                configurationArr = null;
            } else {
                JSONArray jSONArray = jSONObject.getJSONArray("fields");
                int length = jSONArray.length();
                Configuration[] configurationArr2 = new Configuration[length];
                for (int i5 = 0; i5 < length; i5++) {
                    configurationArr2[i5] = fromJson(jSONArray.getJSONObject(i5));
                }
                configurationArr = configurationArr2;
            }
            Integer numInputActionFromTextInputAction = inputActionFromTextInputAction(string);
            ArrayList arrayList = new ArrayList();
            JSONArray jSONArray2 = jSONObject.isNull("contentCommitMimeTypes") ? null : jSONObject.getJSONArray("contentCommitMimeTypes");
            if (jSONArray2 != null) {
                for (int i6 = 0; i6 < jSONArray2.length(); i6++) {
                    arrayList.add(jSONArray2.optString(i6));
                }
            }
            if (jSONObject.isNull("hintLocales")) {
                localeArr = null;
            } else {
                JSONArray jSONArray3 = jSONObject.getJSONArray("hintLocales");
                Locale[] localeArr2 = new Locale[jSONArray3.length()];
                for (int i7 = 0; i7 < jSONArray3.length(); i7++) {
                    localeArr2[i7] = Locale.forLanguageTag(jSONArray3.optString(i7));
                }
                localeArr = localeArr2;
            }
            return new Configuration(jSONObject.optBoolean("obscureText"), jSONObject.optBoolean("autocorrect", true), jSONObject.optBoolean("enableSuggestions"), jSONObject.optBoolean("enableIMEPersonalizedLearning"), jSONObject.optBoolean("enableDeltaModel"), TextCapitalization.fromValue(jSONObject.getString("textCapitalization")), InputType.fromJson(jSONObject.getJSONObject("inputType")), numInputActionFromTextInputAction, jSONObject.isNull("actionLabel") ? null : jSONObject.getString("actionLabel"), jSONObject.isNull("autofill") ? null : Autofill.fromJson(jSONObject.getJSONObject("autofill")), (String[]) arrayList.toArray(new String[arrayList.size()]), configurationArr, localeArr);
        }

        @NonNull
        private static Integer inputActionFromTextInputAction(@NonNull String str) {
            byte b = 1;
            str.getClass();
            switch (str.hashCode()) {
                case -810971940:
                    b = !str.equals("TextInputAction.unspecified") ? (byte) -1 : (byte) 0;
                    break;
                case -737377923:
                    if (!str.equals("TextInputAction.done")) {
                        b = -1;
                    }
                    break;
                case -737089298:
                    b = !str.equals("TextInputAction.next") ? (byte) -1 : (byte) 2;
                    break;
                case -737080013:
                    b = !str.equals("TextInputAction.none") ? (byte) -1 : (byte) 3;
                    break;
                case -736940669:
                    b = !str.equals("TextInputAction.send") ? (byte) -1 : (byte) 4;
                    break;
                case 469250275:
                    b = !str.equals("TextInputAction.search") ? (byte) -1 : (byte) 5;
                    break;
                case 1241689507:
                    b = !str.equals("TextInputAction.go") ? (byte) -1 : (byte) 6;
                    break;
                case 1539450297:
                    b = !str.equals("TextInputAction.newline") ? (byte) -1 : (byte) 7;
                    break;
                case 2110497650:
                    b = !str.equals("TextInputAction.previous") ? (byte) -1 : (byte) 8;
                    break;
                default:
                    b = -1;
                    break;
            }
            switch (b) {
                case 0:
                    return 0;
                case 1:
                    return 6;
                case 2:
                    return 5;
                case 3:
                    return 1;
                case 4:
                    return 4;
                case 5:
                    return 3;
                case 6:
                    return 2;
                case 7:
                    return 1;
                case 8:
                    return 7;
                default:
                    return 0;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class InputType {
        public final boolean isDecimal;
        public final boolean isSigned;

        @NonNull
        public final TextInputType type;

        public InputType(@NonNull TextInputType textInputType, boolean z6, boolean z7) {
            this.type = textInputType;
            this.isSigned = z6;
            this.isDecimal = z7;
        }

        @NonNull
        public static InputType fromJson(@NonNull JSONObject jSONObject) {
            return new InputType(TextInputType.fromValue(jSONObject.getString("name")), jSONObject.optBoolean("signed", false), jSONObject.optBoolean(XmlErrorCodes.DECIMAL, false));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public enum TextCapitalization {
        CHARACTERS("TextCapitalization.characters"),
        WORDS("TextCapitalization.words"),
        SENTENCES("TextCapitalization.sentences"),
        NONE("TextCapitalization.none");


        @NonNull
        private final String encodedName;

        TextCapitalization(String str) {
            this.encodedName = str;
        }

        public static TextCapitalization fromValue(@NonNull String str) throws NoSuchFieldException {
            for (TextCapitalization textCapitalization : values()) {
                if (textCapitalization.encodedName.equals(str)) {
                    return textCapitalization;
                }
            }
            throw new NoSuchFieldException(AbstractC0157z.n("No such TextCapitalization: ", str));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class TextEditState {
        public final int composingEnd;
        public final int composingStart;
        public final int selectionEnd;
        public final int selectionStart;

        @NonNull
        public final String text;

        public TextEditState(@NonNull String str, int i5, int i6, int i7, int i8) {
            if (!(i5 == -1 && i6 == -1) && (i5 < 0 || i6 < 0)) {
                throw new IndexOutOfBoundsException("invalid selection: (" + String.valueOf(i5) + ", " + String.valueOf(i6) + ")");
            }
            if (!(i7 == -1 && i8 == -1) && (i7 < 0 || i7 > i8)) {
                throw new IndexOutOfBoundsException("invalid composing range: (" + String.valueOf(i7) + ", " + String.valueOf(i8) + ")");
            }
            if (i8 > str.length()) {
                throw new IndexOutOfBoundsException("invalid composing start: " + String.valueOf(i7));
            }
            if (i5 > str.length()) {
                throw new IndexOutOfBoundsException("invalid selection start: " + String.valueOf(i5));
            }
            if (i6 > str.length()) {
                throw new IndexOutOfBoundsException("invalid selection end: " + String.valueOf(i6));
            }
            this.text = str;
            this.selectionStart = i5;
            this.selectionEnd = i6;
            this.composingStart = i7;
            this.composingEnd = i8;
        }

        @NonNull
        public static TextEditState fromJson(@NonNull JSONObject jSONObject) {
            return new TextEditState(jSONObject.getString("text"), jSONObject.getInt("selectionBase"), jSONObject.getInt("selectionExtent"), jSONObject.getInt("composingBase"), jSONObject.getInt("composingExtent"));
        }

        public boolean hasComposing() {
            int i5 = this.composingStart;
            return i5 >= 0 && this.composingEnd > i5;
        }

        public boolean hasSelection() {
            return this.selectionStart >= 0;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public interface TextInputMethodHandler {
        void clearClient();

        void finishAutofillContext(boolean z6);

        void hide();

        void requestAutofill();

        void sendAppPrivateCommand(@NonNull String str, @NonNull Bundle bundle);

        void setClient(int i5, @NonNull Configuration configuration);

        void setEditableSizeAndTransform(double d, double d6, @NonNull double[] dArr);

        void setEditingState(@NonNull TextEditState textEditState);

        void setPlatformViewClient(int i5, boolean z6);

        void show();
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public enum TextInputType {
        TEXT("TextInputType.text"),
        DATETIME("TextInputType.datetime"),
        NAME("TextInputType.name"),
        POSTAL_ADDRESS("TextInputType.address"),
        NUMBER("TextInputType.number"),
        PHONE("TextInputType.phone"),
        MULTILINE("TextInputType.multiline"),
        EMAIL_ADDRESS("TextInputType.emailAddress"),
        URL("TextInputType.url"),
        VISIBLE_PASSWORD("TextInputType.visiblePassword"),
        NONE("TextInputType.none"),
        WEB_SEARCH("TextInputType.webSearch"),
        TWITTER("TextInputType.twitter");


        @NonNull
        private final String encodedName;

        TextInputType(String str) {
            this.encodedName = str;
        }

        public static TextInputType fromValue(@NonNull String str) throws NoSuchFieldException {
            for (TextInputType textInputType : values()) {
                if (textInputType.encodedName.equals(str)) {
                    return textInputType;
                }
            }
            throw new NoSuchFieldException(AbstractC0157z.n("No such TextInputType: ", str));
        }
    }

    public TextInputChannel(@NonNull DartExecutor dartExecutor) {
        MethodChannel.MethodCallHandler methodCallHandler = new MethodChannel.MethodCallHandler() { // from class: io.flutter.embedding.engine.systemchannels.TextInputChannel.1
            @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
            public void onMethodCall(@NonNull MethodCall methodCall, @NonNull MethodChannel.Result result) {
                Bundle bundle;
                if (TextInputChannel.this.textInputMethodHandler == null) {
                    return;
                }
                String str = methodCall.method;
                Object obj = methodCall.arguments;
                Log.v(TextInputChannel.TAG, "Received '" + str + "' message.");
                str.getClass();
                switch (str) {
                    case "TextInput.setPlatformViewClient":
                        try {
                            JSONObject jSONObject = (JSONObject) obj;
                            TextInputChannel.this.textInputMethodHandler.setPlatformViewClient(jSONObject.getInt("platformViewId"), jSONObject.optBoolean("usesVirtualDisplay", false));
                            result.success(null);
                            break;
                        } catch (JSONException e) {
                            result.error("error", e.getMessage(), null);
                            return;
                        }
                        break;
                    case "TextInput.setEditingState":
                        try {
                            TextInputChannel.this.textInputMethodHandler.setEditingState(TextEditState.fromJson((JSONObject) obj));
                            result.success(null);
                            break;
                        } catch (JSONException e6) {
                            result.error("error", e6.getMessage(), null);
                            return;
                        }
                        break;
                    case "TextInput.setClient":
                        try {
                            JSONArray jSONArray = (JSONArray) obj;
                            TextInputChannel.this.textInputMethodHandler.setClient(jSONArray.getInt(0), Configuration.fromJson(jSONArray.getJSONObject(1)));
                            result.success(null);
                            break;
                        } catch (NoSuchFieldException | JSONException e7) {
                            result.error("error", e7.getMessage(), null);
                            return;
                        }
                        break;
                    case "TextInput.hide":
                        TextInputChannel.this.textInputMethodHandler.hide();
                        result.success(null);
                        break;
                    case "TextInput.show":
                        TextInputChannel.this.textInputMethodHandler.show();
                        result.success(null);
                        break;
                    case "TextInput.sendAppPrivateCommand":
                        try {
                            JSONObject jSONObject2 = (JSONObject) obj;
                            String string = jSONObject2.getString("action");
                            String string2 = jSONObject2.getString("data");
                            if (string2 == null || string2.isEmpty()) {
                                bundle = null;
                            } else {
                                bundle = new Bundle();
                                bundle.putString("data", string2);
                            }
                            TextInputChannel.this.textInputMethodHandler.sendAppPrivateCommand(string, bundle);
                            result.success(null);
                            break;
                        } catch (JSONException e8) {
                            result.error("error", e8.getMessage(), null);
                            return;
                        }
                        break;
                    case "TextInput.setEditableSizeAndTransform":
                        try {
                            JSONObject jSONObject3 = (JSONObject) obj;
                            double d = jSONObject3.getDouble("width");
                            double d6 = jSONObject3.getDouble("height");
                            JSONArray jSONArray2 = jSONObject3.getJSONArray("transform");
                            double[] dArr = new double[16];
                            for (int i5 = 0; i5 < 16; i5++) {
                                dArr[i5] = jSONArray2.getDouble(i5);
                            }
                            TextInputChannel.this.textInputMethodHandler.setEditableSizeAndTransform(d, d6, dArr);
                            result.success(null);
                            break;
                        } catch (JSONException e9) {
                            result.error("error", e9.getMessage(), null);
                            return;
                        }
                        break;
                    case "TextInput.finishAutofillContext":
                        TextInputChannel.this.textInputMethodHandler.finishAutofillContext(((Boolean) obj).booleanValue());
                        result.success(null);
                        break;
                    case "TextInput.clearClient":
                        TextInputChannel.this.textInputMethodHandler.clearClient();
                        result.success(null);
                        break;
                    case "TextInput.requestAutofill":
                        TextInputChannel.this.textInputMethodHandler.requestAutofill();
                        result.success(null);
                        break;
                    default:
                        result.notImplemented();
                        break;
                }
            }
        };
        this.parsingMethodHandler = methodCallHandler;
        MethodChannel methodChannel = new MethodChannel(dartExecutor, "flutter/textinput", JSONMethodCodec.INSTANCE);
        this.channel = methodChannel;
        methodChannel.setMethodCallHandler(methodCallHandler);
    }

    private static HashMap<Object, Object> createEditingDeltaJSON(ArrayList<TextEditingDelta> arrayList) {
        HashMap<Object, Object> map = new HashMap<>();
        JSONArray jSONArray = new JSONArray();
        int size = arrayList.size();
        int i5 = 0;
        while (i5 < size) {
            TextEditingDelta textEditingDelta = arrayList.get(i5);
            i5++;
            jSONArray.put(textEditingDelta.toJSON());
        }
        map.put("deltas", jSONArray);
        return map;
    }

    private static HashMap<Object, Object> createEditingStateJSON(String str, int i5, int i6, int i7, int i8) {
        HashMap<Object, Object> map = new HashMap<>();
        map.put("text", str);
        map.put("selectionBase", Integer.valueOf(i5));
        map.put("selectionExtent", Integer.valueOf(i6));
        map.put("composingBase", Integer.valueOf(i7));
        map.put("composingExtent", Integer.valueOf(i8));
        return map;
    }

    public void commitContent(int i5, Map<String, Object> map) {
        Log.v(TAG, "Sending 'commitContent' message.");
        this.channel.invokeMethod("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i5), "TextInputAction.commitContent", map));
    }

    public void done(int i5) {
        Log.v(TAG, "Sending 'done' message.");
        this.channel.invokeMethod("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i5), "TextInputAction.done"));
    }

    public void go(int i5) {
        Log.v(TAG, "Sending 'go' message.");
        this.channel.invokeMethod("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i5), "TextInputAction.go"));
    }

    public void newline(int i5) {
        Log.v(TAG, "Sending 'newline' message.");
        this.channel.invokeMethod("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i5), "TextInputAction.newline"));
    }

    public void next(int i5) {
        Log.v(TAG, "Sending 'next' message.");
        this.channel.invokeMethod("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i5), "TextInputAction.next"));
    }

    public void performPrivateCommand(int i5, @NonNull String str, @NonNull Bundle bundle) {
        HashMap map = new HashMap();
        map.put("action", str);
        if (bundle != null) {
            HashMap map2 = new HashMap();
            for (String str2 : bundle.keySet()) {
                Object obj = bundle.get(str2);
                if (obj instanceof byte[]) {
                    map2.put(str2, bundle.getByteArray(str2));
                } else if (obj instanceof Byte) {
                    map2.put(str2, Byte.valueOf(bundle.getByte(str2)));
                } else if (obj instanceof char[]) {
                    map2.put(str2, bundle.getCharArray(str2));
                } else if (obj instanceof Character) {
                    map2.put(str2, Character.valueOf(bundle.getChar(str2)));
                } else if (obj instanceof CharSequence[]) {
                    map2.put(str2, bundle.getCharSequenceArray(str2));
                } else if (obj instanceof CharSequence) {
                    map2.put(str2, bundle.getCharSequence(str2));
                } else if (obj instanceof float[]) {
                    map2.put(str2, bundle.getFloatArray(str2));
                } else if (obj instanceof Float) {
                    map2.put(str2, Float.valueOf(bundle.getFloat(str2)));
                }
            }
            map.put("data", map2);
        }
        this.channel.invokeMethod("TextInputClient.performPrivateCommand", Arrays.asList(Integer.valueOf(i5), map));
    }

    public void previous(int i5) {
        Log.v(TAG, "Sending 'previous' message.");
        this.channel.invokeMethod("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i5), "TextInputAction.previous"));
    }

    public void requestExistingInputState() {
        this.channel.invokeMethod("TextInputClient.requestExistingInputState", null);
    }

    public void search(int i5) {
        Log.v(TAG, "Sending 'search' message.");
        this.channel.invokeMethod("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i5), "TextInputAction.search"));
    }

    public void send(int i5) {
        Log.v(TAG, "Sending 'send' message.");
        this.channel.invokeMethod("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i5), "TextInputAction.send"));
    }

    public void setTextInputMethodHandler(@Nullable TextInputMethodHandler textInputMethodHandler) {
        this.textInputMethodHandler = textInputMethodHandler;
    }

    public void unspecifiedAction(int i5) {
        Log.v(TAG, "Sending 'unspecified' message.");
        this.channel.invokeMethod("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i5), "TextInputAction.unspecified"));
    }

    public void updateEditingState(int i5, @NonNull String str, int i6, int i7, int i8, int i9) {
        StringBuilder sb = new StringBuilder("Sending message to update editing state: \nText: ");
        sb.append(str);
        sb.append("\nSelection start: ");
        sb.append(i6);
        sb.append("\nSelection end: ");
        androidx.exifinterface.media.a.y(sb, i7, "\nComposing start: ", i8, "\nComposing end: ");
        sb.append(i9);
        Log.v(TAG, sb.toString());
        this.channel.invokeMethod("TextInputClient.updateEditingState", Arrays.asList(Integer.valueOf(i5), createEditingStateJSON(str, i6, i7, i8, i9)));
    }

    public void updateEditingStateWithDeltas(int i5, @NonNull ArrayList<TextEditingDelta> arrayList) {
        Log.v(TAG, "Sending message to update editing state with deltas: \nNumber of deltas: " + arrayList.size());
        this.channel.invokeMethod("TextInputClient.updateEditingStateWithDeltas", Arrays.asList(Integer.valueOf(i5), createEditingDeltaJSON(arrayList)));
    }

    public void updateEditingStateWithTag(int i5, @NonNull HashMap<String, TextEditState> map) {
        Log.v(TAG, "Sending message to update editing state for " + String.valueOf(map.size()) + " field(s).");
        HashMap map2 = new HashMap();
        for (Map.Entry<String, TextEditState> entry : map.entrySet()) {
            TextEditState value = entry.getValue();
            map2.put(entry.getKey(), createEditingStateJSON(value.text, value.selectionStart, value.selectionEnd, -1, -1));
        }
        this.channel.invokeMethod("TextInputClient.updateEditingStateWithTag", Arrays.asList(Integer.valueOf(i5), map2));
    }
}
