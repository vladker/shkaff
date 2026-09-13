package io.flutter.plugin.editing;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.LocaleList;
import android.text.Editable;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewStructure;
import android.view.autofill.AutofillId;
import android.view.autofill.AutofillManager;
import android.view.autofill.AutofillValue;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.inputmethod.EditorInfoCompat;
import io.flutter.Log;
import io.flutter.embedding.android.KeyboardManager;
import io.flutter.embedding.engine.systemchannels.ScribeChannel;
import io.flutter.embedding.engine.systemchannels.TextInputChannel;
import io.flutter.plugin.platform.PlatformViewsController;
import io.flutter.plugin.platform.PlatformViewsController2;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class TextInputPlugin implements ListenableEditingState.EditingStateWatcher {
    private static final String TAG = "TextInputPlugin";

    @NonNull
    private final AutofillManager afm;

    @Nullable
    private SparseArray<TextInputChannel.Configuration> autofillConfiguration;

    @Nullable
    private TextInputChannel.Configuration configuration;
    private ImeSyncDeferringInsetsCallback imeSyncCallback;

    @NonNull
    private InputTarget inputTarget = new InputTarget(InputTarget.Type.NO_TARGET, 0);
    private boolean isInputConnectionLocked;

    @Nullable
    private Rect lastClientRect;

    @Nullable
    private InputConnection lastInputConnection;

    @NonNull
    private ListenableEditingState mEditable;

    @NonNull
    private final InputMethodManager mImm;
    private TextInputChannel.TextEditState mLastKnownFrameworkTextEditingState;
    private boolean mRestartInputPending;

    @NonNull
    private final View mView;

    @NonNull
    private PlatformViewsController platformViewsController;

    @NonNull
    private PlatformViewsController2 platformViewsController2;

    @NonNull
    private final ScribeChannel scribeChannel;

    @NonNull
    private final TextInputChannel textInputChannel;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class InputTarget {
        int id;

        @NonNull
        Type type;

        /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
        public enum Type {
            NO_TARGET,
            FRAMEWORK_CLIENT,
            VIRTUAL_DISPLAY_PLATFORM_VIEW,
            PHYSICAL_DISPLAY_PLATFORM_VIEW
        }

        public InputTarget(@NonNull Type type, int i5) {
            this.type = type;
            this.id = i5;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public interface MinMax {
        void inspect(double d, double d6);
    }

    @SuppressLint({"NewApi"})
    public TextInputPlugin(@NonNull View view, @NonNull TextInputChannel textInputChannel, @NonNull ScribeChannel scribeChannel, @NonNull PlatformViewsController platformViewsController, @NonNull PlatformViewsController2 platformViewsController2) {
        this.mView = view;
        this.mEditable = new ListenableEditingState(null, view);
        this.mImm = (InputMethodManager) view.getContext().getSystemService("input_method");
        int i5 = Build.VERSION.SDK_INT;
        this.afm = (AutofillManager) view.getContext().getSystemService(AutofillManager.class);
        if (i5 >= 30) {
            ImeSyncDeferringInsetsCallback imeSyncDeferringInsetsCallback = new ImeSyncDeferringInsetsCallback(view);
            this.imeSyncCallback = imeSyncDeferringInsetsCallback;
            imeSyncDeferringInsetsCallback.install();
            this.imeSyncCallback.setImeVisibilityListener(new ImeSyncDeferringInsetsCallback.ImeVisibilityListener() { // from class: io.flutter.plugin.editing.TextInputPlugin.1
                @Override // io.flutter.plugin.editing.ImeSyncDeferringInsetsCallback.ImeVisibilityListener
                public void onImeVisibilityChanged(boolean z6) {
                    if (z6) {
                        return;
                    }
                    TextInputPlugin.this.mImm.restartInput(TextInputPlugin.this.mView);
                }
            });
        }
        this.textInputChannel = textInputChannel;
        textInputChannel.setTextInputMethodHandler(new TextInputChannel.TextInputMethodHandler() { // from class: io.flutter.plugin.editing.TextInputPlugin.2
            @Override // io.flutter.embedding.engine.systemchannels.TextInputChannel.TextInputMethodHandler
            public void clearClient() {
                TextInputPlugin.this.clearTextInputClient();
            }

            @Override // io.flutter.embedding.engine.systemchannels.TextInputChannel.TextInputMethodHandler
            public void finishAutofillContext(boolean z6) {
                if (TextInputPlugin.this.afm == null) {
                    return;
                }
                if (z6) {
                    TextInputPlugin.this.afm.commit();
                } else {
                    TextInputPlugin.this.afm.cancel();
                }
            }

            @Override // io.flutter.embedding.engine.systemchannels.TextInputChannel.TextInputMethodHandler
            public void hide() {
                if (TextInputPlugin.this.inputTarget.type == InputTarget.Type.PHYSICAL_DISPLAY_PLATFORM_VIEW) {
                    TextInputPlugin.this.notifyViewExited();
                } else {
                    TextInputPlugin textInputPlugin = TextInputPlugin.this;
                    textInputPlugin.hideTextInput(textInputPlugin.mView);
                }
            }

            @Override // io.flutter.embedding.engine.systemchannels.TextInputChannel.TextInputMethodHandler
            public void requestAutofill() {
                TextInputPlugin.this.notifyViewEntered();
            }

            @Override // io.flutter.embedding.engine.systemchannels.TextInputChannel.TextInputMethodHandler
            public void sendAppPrivateCommand(String str, Bundle bundle) {
                TextInputPlugin.this.sendTextInputAppPrivateCommand(str, bundle);
            }

            @Override // io.flutter.embedding.engine.systemchannels.TextInputChannel.TextInputMethodHandler
            public void setClient(int i6, TextInputChannel.Configuration configuration) {
                TextInputPlugin.this.setTextInputClient(i6, configuration);
            }

            @Override // io.flutter.embedding.engine.systemchannels.TextInputChannel.TextInputMethodHandler
            public void setEditableSizeAndTransform(double d, double d6, double[] dArr) {
                TextInputPlugin.this.saveEditableSizeAndTransform(d, d6, dArr);
            }

            @Override // io.flutter.embedding.engine.systemchannels.TextInputChannel.TextInputMethodHandler
            public void setEditingState(TextInputChannel.TextEditState textEditState) {
                TextInputPlugin textInputPlugin = TextInputPlugin.this;
                textInputPlugin.setTextInputEditingState(textInputPlugin.mView, textEditState);
            }

            @Override // io.flutter.embedding.engine.systemchannels.TextInputChannel.TextInputMethodHandler
            public void setPlatformViewClient(int i6, boolean z6) {
                TextInputPlugin.this.setPlatformViewTextInputClient(i6, z6);
            }

            @Override // io.flutter.embedding.engine.systemchannels.TextInputChannel.TextInputMethodHandler
            public void show() {
                TextInputPlugin textInputPlugin = TextInputPlugin.this;
                textInputPlugin.showTextInput(textInputPlugin.mView);
            }
        });
        textInputChannel.requestExistingInputState();
        this.scribeChannel = scribeChannel;
        this.platformViewsController = platformViewsController;
        platformViewsController.attachTextInputPlugin(this);
        this.platformViewsController2 = platformViewsController2;
        platformViewsController2.attachTextInputPlugin(this);
    }

    private static boolean composingChanged(TextInputChannel.TextEditState textEditState, TextInputChannel.TextEditState textEditState2) {
        int i5 = textEditState.composingEnd - textEditState.composingStart;
        if (i5 != textEditState2.composingEnd - textEditState2.composingStart) {
            return true;
        }
        for (int i6 = 0; i6 < i5; i6++) {
            if (textEditState.text.charAt(textEditState.composingStart + i6) != textEditState2.text.charAt(textEditState2.composingStart + i6)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideTextInput(View view) {
        notifyViewExited();
        this.mImm.hideSoftInputFromWindow(view.getApplicationWindowToken(), 0);
    }

    /* JADX WARN: Code duplicated, block: B:59:0x0075  */
    /* JADX WARN: Code duplicated, block: B:61:0x0078  */
    /* JADX WARN: Code duplicated, block: B:63:0x007c  */
    /* JADX WARN: Code duplicated, block: B:65:0x007f  */
    /* JADX WARN: Code duplicated, block: B:67:0x0083  */
    /* JADX WARN: Code duplicated, block: B:69:? A[RETURN, SYNTHETIC] */
    private static int inputTypeFromTextInputType(TextInputChannel.InputType inputType, boolean z6, boolean z7, boolean z8, boolean z9, TextInputChannel.TextCapitalization textCapitalization) {
        int i5;
        int i6;
        TextInputChannel.TextInputType textInputType = inputType.type;
        if (textInputType == TextInputChannel.TextInputType.DATETIME) {
            return 4;
        }
        if (textInputType == TextInputChannel.TextInputType.NUMBER) {
            int i7 = inputType.isSigned ? InputDeviceCompat.SOURCE_TOUCHSCREEN : 2;
            return inputType.isDecimal ? i7 | 8192 : i7;
        }
        if (textInputType == TextInputChannel.TextInputType.PHONE) {
            return 3;
        }
        if (textInputType == TextInputChannel.TextInputType.NONE) {
            return 0;
        }
        if (textInputType == TextInputChannel.TextInputType.MULTILINE) {
            i5 = 131073;
        } else if (textInputType == TextInputChannel.TextInputType.EMAIL_ADDRESS || textInputType == TextInputChannel.TextInputType.TWITTER) {
            i5 = 33;
        } else if (textInputType == TextInputChannel.TextInputType.URL || textInputType == TextInputChannel.TextInputType.WEB_SEARCH) {
            i5 = 17;
        } else if (textInputType == TextInputChannel.TextInputType.VISIBLE_PASSWORD) {
            i5 = 145;
        } else if (textInputType == TextInputChannel.TextInputType.NAME) {
            i5 = 97;
        } else {
            i5 = textInputType == TextInputChannel.TextInputType.POSTAL_ADDRESS ? 113 : 1;
        }
        if (!z6) {
            if (z7) {
                i5 |= 32768;
            }
            i6 = z8 ? 524416 : 524432;
            if (textCapitalization == TextInputChannel.TextCapitalization.CHARACTERS) {
                return i5 | 4096;
            }
            if (textCapitalization == TextInputChannel.TextCapitalization.WORDS) {
                return i5 | 8192;
            }
            if (textCapitalization == TextInputChannel.TextCapitalization.SENTENCES) {
                return i5 | 16384;
            }
            return i5;
        }
        i5 |= i6;
        if (textCapitalization == TextInputChannel.TextCapitalization.CHARACTERS) {
            return i5 | 4096;
        }
        if (textCapitalization == TextInputChannel.TextCapitalization.WORDS) {
            return i5 | 8192;
        }
        if (textCapitalization == TextInputChannel.TextCapitalization.SENTENCES) {
            return i5 | 16384;
        }
        return i5;
    }

    private boolean needsAutofill() {
        return this.autofillConfiguration != null;
    }

    private void notifyValueChanged(String str) {
        if (this.afm == null || !needsAutofill()) {
            return;
        }
        this.afm.notifyValueChanged(this.mView, this.configuration.autofill.uniqueIdentifier.hashCode(), AutofillValue.forText(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyViewEntered() {
        if (this.afm == null || !needsAutofill()) {
            return;
        }
        String str = this.configuration.autofill.uniqueIdentifier;
        int[] iArr = new int[2];
        this.mView.getLocationOnScreen(iArr);
        Rect rect = new Rect(this.lastClientRect);
        rect.offset(iArr[0], iArr[1]);
        this.afm.notifyViewEntered(this.mView, str.hashCode(), rect);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyViewExited() {
        TextInputChannel.Configuration configuration;
        if (this.afm == null || (configuration = this.configuration) == null || configuration.autofill == null || !needsAutofill()) {
            return;
        }
        this.afm.notifyViewExited(this.mView, this.configuration.autofill.uniqueIdentifier.hashCode());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveEditableSizeAndTransform(double d, double d6, final double[] dArr) {
        final double[] dArr2 = new double[4];
        final boolean z6 = dArr[3] == 0.0d && dArr[7] == 0.0d && dArr[15] == 1.0d;
        double d7 = dArr[12];
        double d8 = dArr[15];
        double d9 = d7 / d8;
        dArr2[1] = d9;
        dArr2[0] = d9;
        double d10 = dArr[13] / d8;
        dArr2[3] = d10;
        dArr2[2] = d10;
        MinMax minMax = new MinMax() { // from class: io.flutter.plugin.editing.TextInputPlugin.3
            @Override // io.flutter.plugin.editing.TextInputPlugin.MinMax
            public void inspect(double d11, double d12) {
                double d13 = 1.0d;
                if (!z6) {
                    double[] dArr3 = dArr;
                    d13 = 1.0d / (((dArr3[7] * d12) + (dArr3[3] * d11)) + dArr3[15]);
                }
                double[] dArr4 = dArr;
                double d14 = ((dArr4[4] * d12) + (dArr4[0] * d11) + dArr4[12]) * d13;
                double d15 = ((dArr4[5] * d12) + (dArr4[1] * d11) + dArr4[13]) * d13;
                double[] dArr5 = dArr2;
                if (d14 < dArr5[0]) {
                    dArr5[0] = d14;
                } else if (d14 > dArr5[1]) {
                    dArr5[1] = d14;
                }
                if (d15 < dArr5[2]) {
                    dArr5[2] = d15;
                } else if (d15 > dArr5[3]) {
                    dArr5[3] = d15;
                }
            }
        };
        minMax.inspect(d, 0.0d);
        minMax.inspect(d, d6);
        minMax.inspect(0.0d, d6);
        double d11 = this.mView.getContext().getResources().getDisplayMetrics().density;
        this.lastClientRect = new Rect((int) (dArr2[0] * d11), (int) (dArr2[2] * d11), (int) Math.ceil(dArr2[1] * d11), (int) Math.ceil(dArr2[3] * d11));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPlatformViewTextInputClient(int i5, boolean z6) {
        if (!z6) {
            this.inputTarget = new InputTarget(InputTarget.Type.PHYSICAL_DISPLAY_PLATFORM_VIEW, i5);
            this.lastInputConnection = null;
        } else {
            this.mView.requestFocus();
            this.inputTarget = new InputTarget(InputTarget.Type.VIRTUAL_DISPLAY_PLATFORM_VIEW, i5);
            this.mImm.restartInput(this.mView);
            this.mRestartInputPending = false;
        }
    }

    private void updateAutofillConfigurationIfNeeded(TextInputChannel.Configuration configuration) {
        if (configuration == null || configuration.autofill == null) {
            this.autofillConfiguration = null;
            return;
        }
        TextInputChannel.Configuration[] configurationArr = configuration.fields;
        SparseArray<TextInputChannel.Configuration> sparseArray = new SparseArray<>();
        this.autofillConfiguration = sparseArray;
        if (configurationArr == null) {
            sparseArray.put(configuration.autofill.uniqueIdentifier.hashCode(), configuration);
            return;
        }
        for (TextInputChannel.Configuration configuration2 : configurationArr) {
            TextInputChannel.Configuration.Autofill autofill = configuration2.autofill;
            if (autofill != null) {
                this.autofillConfiguration.put(autofill.uniqueIdentifier.hashCode(), configuration2);
                this.afm.notifyValueChanged(this.mView, autofill.uniqueIdentifier.hashCode(), AutofillValue.forText(autofill.editState.text));
            }
        }
    }

    public void autofill(@NonNull SparseArray<AutofillValue> sparseArray) {
        TextInputChannel.Configuration.Autofill autofill;
        TextInputChannel.Configuration.Autofill autofill2;
        TextInputChannel.Configuration configuration = this.configuration;
        if (configuration == null || this.autofillConfiguration == null || (autofill = configuration.autofill) == null) {
            return;
        }
        HashMap<String, TextInputChannel.TextEditState> map = new HashMap<>();
        for (int i5 = 0; i5 < sparseArray.size(); i5++) {
            TextInputChannel.Configuration configuration2 = this.autofillConfiguration.get(sparseArray.keyAt(i5));
            if (configuration2 != null && (autofill2 = configuration2.autofill) != null) {
                String string = sparseArray.valueAt(i5).getTextValue().toString();
                TextInputChannel.TextEditState textEditState = new TextInputChannel.TextEditState(string, string.length(), string.length(), -1, -1);
                if (autofill2.uniqueIdentifier.equals(autofill.uniqueIdentifier)) {
                    this.mEditable.setEditingState(textEditState);
                } else {
                    map.put(autofill2.uniqueIdentifier, textEditState);
                }
            }
        }
        this.textInputChannel.updateEditingStateWithTag(this.inputTarget.id, map);
    }

    public void clearPlatformViewClient(int i5) {
        InputTarget inputTarget = this.inputTarget;
        InputTarget.Type type = inputTarget.type;
        if ((type == InputTarget.Type.VIRTUAL_DISPLAY_PLATFORM_VIEW || type == InputTarget.Type.PHYSICAL_DISPLAY_PLATFORM_VIEW) && inputTarget.id == i5) {
            this.inputTarget = new InputTarget(InputTarget.Type.NO_TARGET, 0);
            notifyViewExited();
            this.mImm.hideSoftInputFromWindow(this.mView.getApplicationWindowToken(), 0);
            this.mImm.restartInput(this.mView);
            this.mRestartInputPending = false;
        }
    }

    @VisibleForTesting
    public void clearTextInputClient() {
        if (this.inputTarget.type == InputTarget.Type.VIRTUAL_DISPLAY_PLATFORM_VIEW) {
            return;
        }
        this.mEditable.removeEditingStateListener(this);
        notifyViewExited();
        this.configuration = null;
        updateAutofillConfigurationIfNeeded(null);
        this.inputTarget = new InputTarget(InputTarget.Type.NO_TARGET, 0);
        unlockPlatformViewInputConnection();
        this.lastClientRect = null;
        WindowInsetsCompat rootWindowInsets = ViewCompat.getRootWindowInsets(this.mView);
        if (rootWindowInsets == null || rootWindowInsets.isVisible(WindowInsetsCompat.Type.ime())) {
            return;
        }
        this.mImm.restartInput(this.mView);
    }

    @Nullable
    public InputConnection createInputConnection(@NonNull View view, @NonNull KeyboardManager keyboardManager, @NonNull EditorInfo editorInfo) {
        int iIntValue;
        InputTarget inputTarget = this.inputTarget;
        InputTarget.Type type = inputTarget.type;
        if (type == InputTarget.Type.NO_TARGET) {
            this.lastInputConnection = null;
            return null;
        }
        if (type == InputTarget.Type.PHYSICAL_DISPLAY_PLATFORM_VIEW) {
            return null;
        }
        if (type == InputTarget.Type.VIRTUAL_DISPLAY_PLATFORM_VIEW) {
            if (this.isInputConnectionLocked) {
                return this.lastInputConnection;
            }
            InputConnection inputConnectionOnCreateInputConnection = this.platformViewsController.getPlatformViewById(inputTarget.id).onCreateInputConnection(editorInfo);
            this.lastInputConnection = inputConnectionOnCreateInputConnection;
            return inputConnectionOnCreateInputConnection;
        }
        TextInputChannel.Configuration configuration = this.configuration;
        int iInputTypeFromTextInputType = inputTypeFromTextInputType(configuration.inputType, configuration.obscureText, configuration.autocorrect, configuration.enableSuggestions, configuration.enableIMEPersonalizedLearning, configuration.textCapitalization);
        editorInfo.inputType = iInputTypeFromTextInputType;
        editorInfo.imeOptions = 33554432;
        int i5 = Build.VERSION.SDK_INT;
        TextInputChannel.Configuration configuration2 = this.configuration;
        if (!configuration2.enableIMEPersonalizedLearning) {
            editorInfo.imeOptions = 33554432 | 16777216;
        }
        Integer num = configuration2.inputAction;
        if (num == null) {
            iIntValue = (iInputTypeFromTextInputType & 131072) != 0 ? 1 : 6;
        } else {
            iIntValue = num.intValue();
        }
        TextInputChannel.Configuration configuration3 = this.configuration;
        String str = configuration3.actionLabel;
        if (str != null) {
            editorInfo.actionLabel = str;
            editorInfo.actionId = iIntValue;
        }
        editorInfo.imeOptions = iIntValue | editorInfo.imeOptions;
        if (configuration3.hintLocales != null) {
            editorInfo.hintLocales = new LocaleList(this.configuration.hintLocales);
        }
        String[] strArr = this.configuration.contentCommitMimeTypes;
        if (strArr != null) {
            EditorInfoCompat.setContentMimeTypes(editorInfo, strArr);
        }
        if (i5 >= 34) {
            EditorInfoCompat.setStylusHandwritingEnabled(editorInfo, true);
        }
        InputConnectionAdaptor inputConnectionAdaptor = new InputConnectionAdaptor(view, this.inputTarget.id, this.textInputChannel, this.scribeChannel, keyboardManager, this.mEditable, editorInfo);
        editorInfo.initialSelStart = this.mEditable.getSelectionStart();
        editorInfo.initialSelEnd = this.mEditable.getSelectionEnd();
        this.lastInputConnection = inputConnectionAdaptor;
        return inputConnectionAdaptor;
    }

    @SuppressLint({"NewApi"})
    public void destroy() {
        this.platformViewsController.detachTextInputPlugin();
        this.platformViewsController2.detachTextInputPlugin();
        this.textInputChannel.setTextInputMethodHandler(null);
        notifyViewExited();
        this.mEditable.removeEditingStateListener(this);
        ImeSyncDeferringInsetsCallback imeSyncDeferringInsetsCallback = this.imeSyncCallback;
        if (imeSyncDeferringInsetsCallback != null) {
            imeSyncDeferringInsetsCallback.remove();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x004d, code lost:
    
        if (r5 == r9.composingEnd) goto L23;
     */
    @Override // io.flutter.plugin.editing.ListenableEditingState.EditingStateWatcher
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void didChangeEditingState(boolean r8, boolean r9, boolean r10) {
        /*
            r7 = this;
            if (r8 == 0) goto Lb
            io.flutter.plugin.editing.ListenableEditingState r8 = r7.mEditable
            java.lang.String r8 = r8.toString()
            r7.notifyValueChanged(r8)
        Lb:
            io.flutter.plugin.editing.ListenableEditingState r8 = r7.mEditable
            int r2 = r8.getSelectionStart()
            io.flutter.plugin.editing.ListenableEditingState r8 = r7.mEditable
            int r3 = r8.getSelectionEnd()
            io.flutter.plugin.editing.ListenableEditingState r8 = r7.mEditable
            int r4 = r8.getComposingStart()
            io.flutter.plugin.editing.ListenableEditingState r8 = r7.mEditable
            int r5 = r8.getComposingEnd()
            io.flutter.plugin.editing.ListenableEditingState r8 = r7.mEditable
            java.util.ArrayList r8 = r8.extractBatchTextEditingDeltas()
            io.flutter.embedding.engine.systemchannels.TextInputChannel$TextEditState r9 = r7.mLastKnownFrameworkTextEditingState
            if (r9 == 0) goto La4
            io.flutter.plugin.editing.ListenableEditingState r9 = r7.mEditable
            java.lang.String r9 = r9.toString()
            io.flutter.embedding.engine.systemchannels.TextInputChannel$TextEditState r10 = r7.mLastKnownFrameworkTextEditingState
            java.lang.String r10 = r10.text
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L50
            io.flutter.embedding.engine.systemchannels.TextInputChannel$TextEditState r9 = r7.mLastKnownFrameworkTextEditingState
            int r10 = r9.selectionStart
            if (r2 != r10) goto L50
            int r10 = r9.selectionEnd
            if (r3 != r10) goto L50
            int r10 = r9.composingStart
            if (r4 != r10) goto L50
            int r9 = r9.composingEnd
            if (r5 != r9) goto L50
            goto La4
        L50:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r10 = "send EditingState to flutter: "
            r9.<init>(r10)
            io.flutter.plugin.editing.ListenableEditingState r10 = r7.mEditable
            java.lang.String r10 = r10.toString()
            r9.append(r10)
            java.lang.String r9 = r9.toString()
            java.lang.String r10 = "TextInputPlugin"
            io.flutter.Log.v(r10, r9)
            io.flutter.embedding.engine.systemchannels.TextInputChannel$Configuration r9 = r7.configuration
            boolean r9 = r9.enableDeltaModel
            if (r9 == 0) goto L7e
            io.flutter.embedding.engine.systemchannels.TextInputChannel r9 = r7.textInputChannel
            io.flutter.plugin.editing.TextInputPlugin$InputTarget r10 = r7.inputTarget
            int r10 = r10.id
            r9.updateEditingStateWithDeltas(r10, r8)
            io.flutter.plugin.editing.ListenableEditingState r8 = r7.mEditable
            r8.clearBatchDeltas()
            goto L96
        L7e:
            io.flutter.embedding.engine.systemchannels.TextInputChannel r0 = r7.textInputChannel
            io.flutter.plugin.editing.TextInputPlugin$InputTarget r8 = r7.inputTarget
            int r1 = r8.id
            io.flutter.plugin.editing.ListenableEditingState r8 = r7.mEditable
            java.lang.String r8 = r8.toString()
            r6 = r5
            r5 = r4
            r4 = r3
            r3 = r2
            r2 = r8
            r0.updateEditingState(r1, r2, r3, r4, r5, r6)
            r2 = r3
            r3 = r4
            r4 = r5
            r5 = r6
        L96:
            io.flutter.embedding.engine.systemchannels.TextInputChannel$TextEditState r0 = new io.flutter.embedding.engine.systemchannels.TextInputChannel$TextEditState
            io.flutter.plugin.editing.ListenableEditingState r8 = r7.mEditable
            java.lang.String r1 = r8.toString()
            r0.<init>(r1, r2, r3, r4, r5)
            r7.mLastKnownFrameworkTextEditingState = r0
            return
        La4:
            io.flutter.plugin.editing.ListenableEditingState r8 = r7.mEditable
            r8.clearBatchDeltas()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.plugin.editing.TextInputPlugin.didChangeEditingState(boolean, boolean, boolean):void");
    }

    @VisibleForTesting
    public Editable getEditable() {
        return this.mEditable;
    }

    @VisibleForTesting
    public ImeSyncDeferringInsetsCallback getImeSyncCallback() {
        return this.imeSyncCallback;
    }

    @NonNull
    public InputMethodManager getInputMethodManager() {
        return this.mImm;
    }

    @Nullable
    public InputConnection getLastInputConnection() {
        return this.lastInputConnection;
    }

    public boolean handleKeyEvent(@NonNull KeyEvent keyEvent) {
        InputConnection inputConnection;
        if (!getInputMethodManager().isAcceptingText() || (inputConnection = this.lastInputConnection) == null) {
            return false;
        }
        return inputConnection instanceof InputConnectionAdaptor ? ((InputConnectionAdaptor) inputConnection).handleKeyEvent(keyEvent) : inputConnection.sendKeyEvent(keyEvent);
    }

    public void lockPlatformViewInputConnection() {
        if (this.inputTarget.type == InputTarget.Type.VIRTUAL_DISPLAY_PLATFORM_VIEW) {
            this.isInputConnectionLocked = true;
        }
    }

    public void onProvideAutofillVirtualStructure(@NonNull ViewStructure viewStructure, int i5) {
        Rect rect;
        if (needsAutofill()) {
            String str = this.configuration.autofill.uniqueIdentifier;
            AutofillId autofillId = viewStructure.getAutofillId();
            for (int i6 = 0; i6 < this.autofillConfiguration.size(); i6++) {
                int iKeyAt = this.autofillConfiguration.keyAt(i6);
                TextInputChannel.Configuration.Autofill autofill = this.autofillConfiguration.valueAt(i6).autofill;
                if (autofill != null) {
                    viewStructure.addChildCount(1);
                    ViewStructure viewStructureNewChild = viewStructure.newChild(i6);
                    viewStructureNewChild.setAutofillId(autofillId, iKeyAt);
                    String[] strArr = autofill.hints;
                    if (strArr.length > 0) {
                        viewStructureNewChild.setAutofillHints(strArr);
                    }
                    viewStructureNewChild.setAutofillType(1);
                    viewStructureNewChild.setVisibility(0);
                    String str2 = autofill.hintText;
                    if (str2 != null) {
                        viewStructureNewChild.setHint(str2);
                    }
                    if (str.hashCode() != iKeyAt || (rect = this.lastClientRect) == null) {
                        viewStructureNewChild.setDimens(0, 0, 0, 0, 1, 1);
                        viewStructureNewChild.setAutofillValue(AutofillValue.forText(autofill.editState.text));
                    } else {
                        viewStructureNewChild.setDimens(rect.left, rect.top, 0, 0, rect.width(), this.lastClientRect.height());
                        viewStructureNewChild.setAutofillValue(AutofillValue.forText(this.mEditable));
                    }
                }
            }
        }
    }

    public void sendTextInputAppPrivateCommand(@NonNull String str, @NonNull Bundle bundle) {
        this.mImm.sendAppPrivateCommand(this.mView, str, bundle);
    }

    @VisibleForTesting
    public void setTextInputClient(int i5, TextInputChannel.Configuration configuration) {
        notifyViewExited();
        this.configuration = configuration;
        this.inputTarget = new InputTarget(InputTarget.Type.FRAMEWORK_CLIENT, i5);
        this.mEditable.removeEditingStateListener(this);
        TextInputChannel.Configuration.Autofill autofill = configuration.autofill;
        this.mEditable = new ListenableEditingState(autofill != null ? autofill.editState : null, this.mView);
        updateAutofillConfigurationIfNeeded(configuration);
        this.mRestartInputPending = true;
        unlockPlatformViewInputConnection();
        this.lastClientRect = null;
        this.mEditable.addEditingStateListener(this);
    }

    @VisibleForTesting
    public void setTextInputEditingState(View view, TextInputChannel.TextEditState textEditState) {
        TextInputChannel.TextEditState textEditState2;
        if (!this.mRestartInputPending && (textEditState2 = this.mLastKnownFrameworkTextEditingState) != null && textEditState2.hasComposing()) {
            boolean zComposingChanged = composingChanged(this.mLastKnownFrameworkTextEditingState, textEditState);
            this.mRestartInputPending = zComposingChanged;
            if (zComposingChanged) {
                Log.i(TAG, "Composing region changed by the framework. Restarting the input method.");
            }
        }
        this.mLastKnownFrameworkTextEditingState = textEditState;
        this.mEditable.setEditingState(textEditState);
        if (this.mRestartInputPending) {
            this.mImm.restartInput(view);
            this.mRestartInputPending = false;
        }
    }

    @VisibleForTesting
    public void showTextInput(View view) {
        TextInputChannel.InputType inputType;
        TextInputChannel.Configuration configuration = this.configuration;
        if (configuration != null && (inputType = configuration.inputType) != null && inputType.type == TextInputChannel.TextInputType.NONE) {
            hideTextInput(view);
        } else {
            view.requestFocus();
            this.mImm.showSoftInput(view, 0);
        }
    }

    public void unlockPlatformViewInputConnection() {
        if (this.inputTarget.type == InputTarget.Type.VIRTUAL_DISPLAY_PLATFORM_VIEW) {
            this.isInputConnectionLocked = false;
        }
    }
}
