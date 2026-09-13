package com.google.mlkit.vision.text;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public interface TextRecognizerOptionsInterface {

    @KeepForSdk
    public static final int CREDIT_CARD = 6;

    @KeepForSdk
    public static final int DOCUMENT = 7;
    public static final int LATIN = 1;
    public static final int LATIN_AND_CHINESE = 2;
    public static final int LATIN_AND_DEVANAGARI = 3;
    public static final int LATIN_AND_JAPANESE = 4;
    public static final int LATIN_AND_KOREAN = 5;

    @KeepForSdk
    public static final int PIXEL_AI = 8;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    @Retention(RetentionPolicy.CLASS)
    public @interface LanguageOption {
    }

    @NonNull
    @KeepForSdk
    String getConfigLabel();

    @Nullable
    @KeepForSdk
    Executor getExecutor();

    @KeepForSdk
    boolean getIsThickClient();

    @NonNull
    @KeepForSdk
    String getLanguageHint();

    @KeepForSdk
    int getLoggingEventId();

    @LanguageOption
    @KeepForSdk
    int getLoggingLanguageOption();

    @NonNull
    @KeepForSdk
    String getLoggingLibraryName();

    @NonNull
    @KeepForSdk
    String getLoggingLibraryNameForOptionalModule();

    @NonNull
    @KeepForSdk
    String getModuleId();
}
