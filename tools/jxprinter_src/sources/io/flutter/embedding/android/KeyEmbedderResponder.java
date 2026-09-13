package io.flutter.embedding.android;

import android.view.KeyEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import io.flutter.Log;
import io.flutter.plugin.common.BinaryMessenger;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class KeyEmbedderResponder implements KeyboardManager.Responder {
    private static final String TAG = "KeyEmbedderResponder";

    @NonNull
    private final BinaryMessenger messenger;

    @NonNull
    private final HashMap<Long, Long> pressingRecords = new HashMap<>();

    @NonNull
    private final HashMap<Long, KeyboardMap.TogglingGoal> togglingGoals = new HashMap<>();

    @NonNull
    private final KeyboardManager.CharacterCombiner characterCombiner = new KeyboardManager.CharacterCombiner();

    /* JADX INFO: renamed from: io.flutter.embedding.android.KeyEmbedderResponder$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$flutter$embedding$android$KeyData$Type;

        static {
            int[] iArr = new int[KeyData.Type.values().length];
            $SwitchMap$io$flutter$embedding$android$KeyData$Type = iArr;
            try {
                iArr[KeyData.Type.kDown.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$flutter$embedding$android$KeyData$Type[KeyData.Type.kUp.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$flutter$embedding$android$KeyData$Type[KeyData.Type.kRepeat.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public KeyEmbedderResponder(BinaryMessenger binaryMessenger) {
        this.messenger = binaryMessenger;
        for (KeyboardMap.TogglingGoal togglingGoal : KeyboardMap.getTogglingGoals()) {
            this.togglingGoals.put(Long.valueOf(togglingGoal.logicalKey), togglingGoal);
        }
    }

    private static KeyData.Type getEventType(KeyEvent keyEvent) {
        boolean z6 = keyEvent.getRepeatCount() > 0;
        int action = keyEvent.getAction();
        if (action == 0) {
            return z6 ? KeyData.Type.kRepeat : KeyData.Type.kDown;
        }
        if (action == 1) {
            return KeyData.Type.kUp;
        }
        throw new AssertionError("Unexpected event type");
    }

    private Long getLogicalKey(@NonNull KeyEvent keyEvent) {
        Long l6 = KeyboardMap.keyCodeToLogical.get(Long.valueOf(keyEvent.getKeyCode()));
        return l6 != null ? l6 : Long.valueOf(keyOfPlane(keyEvent.getKeyCode(), KeyboardMap.kAndroidPlane));
    }

    private Long getPhysicalKey(@NonNull KeyEvent keyEvent) {
        long scanCode = keyEvent.getScanCode();
        if (scanCode == 0) {
            return Long.valueOf(keyOfPlane(keyEvent.getKeyCode(), KeyboardMap.kAndroidPlane));
        }
        Long l6 = KeyboardMap.scanCodeToPhysical.get(Long.valueOf(scanCode));
        return l6 != null ? l6 : Long.valueOf(keyOfPlane(keyEvent.getScanCode(), KeyboardMap.kAndroidPlane));
    }

    /* JADX WARN: Code duplicated, block: B:40:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:48:0x00c3 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:49:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:53:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:58:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:60:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:62:0x00f2  */
    /* JADX WARN: Code duplicated, block: B:64:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:65:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:66:0x0101  */
    /* JADX WARN: Code duplicated, block: B:67:0x0106  */
    /* JADX WARN: Code duplicated, block: B:68:0x010b  */
    /* JADX WARN: Code duplicated, block: B:71:0x0132 A[LOOP:2: B:70:0x0130->B:71:0x0132, LOOP_END] */
    private boolean handleEventImpl(@NonNull KeyEvent keyEvent, @NonNull KeyboardManager.Responder.OnKeyEventHandledCallback onKeyEventHandledCallback) {
        boolean z6;
        Long l6;
        KeyData.Type type;
        KeyData keyData;
        int source;
        int size;
        KeyboardMap.TogglingGoal togglingGoal;
        int i5 = 0;
        if (keyEvent.getScanCode() == 0 && keyEvent.getKeyCode() == 0) {
            return false;
        }
        Long physicalKey = getPhysicalKey(keyEvent);
        Long logicalKey = getLogicalKey(keyEvent);
        ArrayList<Runnable> arrayList = new ArrayList<>();
        for (KeyboardMap.PressingGoal pressingGoal : KeyboardMap.pressingGoals) {
            synchronizePressingKey(pressingGoal, (keyEvent.getMetaState() & pressingGoal.mask) != 0, logicalKey.longValue(), physicalKey.longValue(), keyEvent, arrayList);
        }
        for (KeyboardMap.TogglingGoal togglingGoal2 : this.togglingGoals.values()) {
            synchronizeTogglingKey(togglingGoal2, (keyEvent.getMetaState() & togglingGoal2.mask) != 0, logicalKey.longValue(), keyEvent);
        }
        int action = keyEvent.getAction();
        if (action == 0) {
            z6 = true;
        } else {
            if (action != 1) {
                return false;
            }
            z6 = false;
        }
        Long l7 = this.pressingRecords.get(physicalKey);
        if (z6) {
            if (l7 != null) {
                if (keyEvent.getRepeatCount() > 0) {
                    type = KeyData.Type.kRepeat;
                } else {
                    l6 = physicalKey;
                    synthesizeEvent(false, l7, l6, keyEvent.getEventTime());
                    type = KeyData.Type.kDown;
                }
                char cCharValue = this.characterCombiner.applyCombiningCharacterToBaseCharacter(keyEvent.getUnicodeChar()).charValue();
                String strH = cCharValue != 0 ? androidx.exifinterface.media.a.h("", cCharValue) : null;
                if (type != KeyData.Type.kRepeat) {
                    updatePressingState(l6, z6 ? logicalKey : null);
                }
                if (type == KeyData.Type.kDown && (togglingGoal = this.togglingGoals.get(logicalKey)) != null) {
                    togglingGoal.enabled = !togglingGoal.enabled;
                }
                keyData = new KeyData();
                source = keyEvent.getSource();
                if (source == 513) {
                    keyData.deviceType = KeyData.DeviceType.kDirectionalPad;
                } else if (source == 1025) {
                    keyData.deviceType = KeyData.DeviceType.kGamepad;
                } else if (source == 16777232) {
                    keyData.deviceType = KeyData.DeviceType.kJoystick;
                } else if (source != 33554433) {
                    keyData.deviceType = KeyData.DeviceType.kKeyboard;
                } else {
                    keyData.deviceType = KeyData.DeviceType.kHdmi;
                }
                keyData.timestamp = keyEvent.getEventTime();
                keyData.type = type;
                keyData.logicalKey = logicalKey.longValue();
                keyData.physicalKey = l6.longValue();
                keyData.character = strH;
                keyData.synthesized = false;
                sendKeyEvent(keyData, onKeyEventHandledCallback);
                size = arrayList.size();
                while (i5 < size) {
                    Runnable runnable = arrayList.get(i5);
                    i5++;
                    runnable.run();
                }
                return true;
            }
            type = KeyData.Type.kDown;
            l6 = physicalKey;
            char cCharValue2 = this.characterCombiner.applyCombiningCharacterToBaseCharacter(keyEvent.getUnicodeChar()).charValue();
            if (cCharValue2 != 0) {
            }
            if (type != KeyData.Type.kRepeat) {
                updatePressingState(l6, z6 ? logicalKey : null);
            }
            if (type == KeyData.Type.kDown) {
                togglingGoal.enabled = !togglingGoal.enabled;
            }
            keyData = new KeyData();
            source = keyEvent.getSource();
            if (source == 513) {
                keyData.deviceType = KeyData.DeviceType.kDirectionalPad;
            } else if (source == 1025) {
                keyData.deviceType = KeyData.DeviceType.kGamepad;
            } else if (source == 16777232) {
                keyData.deviceType = KeyData.DeviceType.kJoystick;
            } else if (source != 33554433) {
                keyData.deviceType = KeyData.DeviceType.kKeyboard;
            } else {
                keyData.deviceType = KeyData.DeviceType.kHdmi;
            }
            keyData.timestamp = keyEvent.getEventTime();
            keyData.type = type;
            keyData.logicalKey = logicalKey.longValue();
            keyData.physicalKey = l6.longValue();
            keyData.character = strH;
            keyData.synthesized = false;
            sendKeyEvent(keyData, onKeyEventHandledCallback);
            size = arrayList.size();
            while (i5 < size) {
                Runnable runnable2 = arrayList.get(i5);
                i5++;
                runnable2.run();
            }
            return true;
        }
        l6 = physicalKey;
        if (l7 == null) {
            return false;
        }
        type = KeyData.Type.kUp;
        if (type != KeyData.Type.kRepeat) {
            updatePressingState(l6, z6 ? logicalKey : null);
        }
        if (type == KeyData.Type.kDown) {
            togglingGoal.enabled = !togglingGoal.enabled;
        }
        keyData = new KeyData();
        source = keyEvent.getSource();
        if (source == 513) {
            keyData.deviceType = KeyData.DeviceType.kDirectionalPad;
        } else if (source == 1025) {
            keyData.deviceType = KeyData.DeviceType.kGamepad;
        } else if (source == 16777232) {
            keyData.deviceType = KeyData.DeviceType.kJoystick;
        } else if (source != 33554433) {
            keyData.deviceType = KeyData.DeviceType.kKeyboard;
        } else {
            keyData.deviceType = KeyData.DeviceType.kHdmi;
        }
        keyData.timestamp = keyEvent.getEventTime();
        keyData.type = type;
        keyData.logicalKey = logicalKey.longValue();
        keyData.physicalKey = l6.longValue();
        keyData.character = strH;
        keyData.synthesized = false;
        sendKeyEvent(keyData, onKeyEventHandledCallback);
        size = arrayList.size();
        while (i5 < size) {
            Runnable runnable3 = arrayList.get(i5);
            i5++;
            runnable3.run();
        }
        return true;
    }

    private static long keyOfPlane(long j6, long j7) {
        return (j6 & KeyboardMap.kValueMask) | j7;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$sendKeyEvent$2(KeyboardManager.Responder.OnKeyEventHandledCallback onKeyEventHandledCallback, ByteBuffer byteBuffer) {
        Boolean boolValueOf = Boolean.FALSE;
        if (byteBuffer != null) {
            byteBuffer.rewind();
            if (byteBuffer.capacity() != 0) {
                boolValueOf = Boolean.valueOf(byteBuffer.get() != 0);
            }
        } else {
            Log.w(TAG, "A null reply was received when sending a key event to the framework.");
        }
        onKeyEventHandledCallback.onKeyEventHandled(boolValueOf.booleanValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$synchronizePressingKey$0(KeyboardMap.KeyPair keyPair, long j6, KeyEvent keyEvent) {
        synthesizeEvent(false, Long.valueOf(keyPair.logicalKey), Long.valueOf(j6), keyEvent.getEventTime());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$synchronizePressingKey$1(KeyboardMap.KeyPair keyPair, long j6, KeyEvent keyEvent) {
        synthesizeEvent(false, Long.valueOf(keyPair.logicalKey), Long.valueOf(j6), keyEvent.getEventTime());
    }

    private void sendKeyEvent(KeyData keyData, final KeyboardManager.Responder.OnKeyEventHandledCallback onKeyEventHandledCallback) {
        this.messenger.send(KeyData.CHANNEL, keyData.toBytes(), onKeyEventHandledCallback == null ? null : new BinaryMessenger.BinaryReply() { // from class: io.flutter.embedding.android.b
            @Override // io.flutter.plugin.common.BinaryMessenger.BinaryReply
            public final void reply(ByteBuffer byteBuffer) {
                KeyEmbedderResponder.lambda$sendKeyEvent$2(onKeyEventHandledCallback, byteBuffer);
            }
        });
    }

    private void synthesizeEvent(boolean z6, Long l6, Long l7, long j6) {
        KeyData keyData = new KeyData();
        keyData.timestamp = j6;
        keyData.type = z6 ? KeyData.Type.kDown : KeyData.Type.kUp;
        keyData.logicalKey = l6.longValue();
        keyData.physicalKey = l7.longValue();
        keyData.character = null;
        keyData.synthesized = true;
        keyData.deviceType = KeyData.DeviceType.kKeyboard;
        if (l7.longValue() != 0 && l6.longValue() != 0) {
            if (!z6) {
                l6 = null;
            }
            updatePressingState(l7, l6);
        }
        sendKeyEvent(keyData, null);
    }

    public Map<Long, Long> getPressedState() {
        return Collections.unmodifiableMap(this.pressingRecords);
    }

    @Override // io.flutter.embedding.android.KeyboardManager.Responder
    public void handleEvent(@NonNull KeyEvent keyEvent, @NonNull KeyboardManager.Responder.OnKeyEventHandledCallback onKeyEventHandledCallback) {
        if (handleEventImpl(keyEvent, onKeyEventHandledCallback)) {
            return;
        }
        synthesizeEvent(true, 0L, 0L, 0L);
        onKeyEventHandledCallback.onKeyEventHandled(true);
    }

    public void synchronizePressingKey(KeyboardMap.PressingGoal pressingGoal, boolean z6, long j6, final long j7, final KeyEvent keyEvent, ArrayList<Runnable> arrayList) {
        KeyboardMap.KeyPair[] keyPairArr = pressingGoal.keys;
        boolean[] zArr = new boolean[keyPairArr.length];
        Boolean[] boolArr = new Boolean[keyPairArr.length];
        int i5 = 0;
        boolean z7 = false;
        while (true) {
            KeyboardMap.KeyPair[] keyPairArr2 = pressingGoal.keys;
            boolean z8 = true;
            if (i5 >= keyPairArr2.length) {
                break;
            }
            final KeyboardMap.KeyPair keyPair = keyPairArr2[i5];
            boolean zContainsKey = this.pressingRecords.containsKey(Long.valueOf(keyPair.physicalKey));
            zArr[i5] = zContainsKey;
            if (keyPair.logicalKey == j6) {
                int i6 = AnonymousClass1.$SwitchMap$io$flutter$embedding$android$KeyData$Type[getEventType(keyEvent).ordinal()];
                if (i6 != 1) {
                    if (i6 == 2) {
                        boolArr[i5] = Boolean.valueOf(zArr[i5]);
                    } else if (i6 == 3) {
                        if (!z6) {
                            final int i7 = 1;
                            arrayList.add(new Runnable(this) { // from class: io.flutter.embedding.android.c
                                public final /* synthetic */ KeyEmbedderResponder b;

                                {
                                    this.b = this;
                                }

                                @Override // java.lang.Runnable
                                public final void run() {
                                    switch (i7) {
                                        case 0:
                                            this.b.lambda$synchronizePressingKey$0(keyPair, j7, keyEvent);
                                            break;
                                        default:
                                            this.b.lambda$synchronizePressingKey$1(keyPair, j7, keyEvent);
                                            break;
                                    }
                                }
                            });
                        }
                        boolArr[i5] = Boolean.valueOf(zArr[i5]);
                    }
                    i5++;
                } else {
                    boolArr[i5] = Boolean.FALSE;
                    if (!z6) {
                        final int i8 = 0;
                        arrayList.add(new Runnable(this) { // from class: io.flutter.embedding.android.c
                            public final /* synthetic */ KeyEmbedderResponder b;

                            {
                                this.b = this;
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                switch (i8) {
                                    case 0:
                                        this.b.lambda$synchronizePressingKey$0(keyPair, j7, keyEvent);
                                        break;
                                    default:
                                        this.b.lambda$synchronizePressingKey$1(keyPair, j7, keyEvent);
                                        break;
                                }
                            }
                        });
                    }
                }
            } else if (!z7 && !zContainsKey) {
                z8 = false;
            }
            z7 = z8;
            i5++;
        }
        if (z6) {
            for (int i9 = 0; i9 < pressingGoal.keys.length; i9++) {
                if (boolArr[i9] == null) {
                    if (z7) {
                        boolArr[i9] = Boolean.valueOf(zArr[i9]);
                    } else {
                        boolArr[i9] = Boolean.TRUE;
                        z7 = true;
                    }
                }
            }
            if (!z7) {
                boolArr[0] = Boolean.TRUE;
            }
        } else {
            for (int i10 = 0; i10 < pressingGoal.keys.length; i10++) {
                if (boolArr[i10] == null) {
                    boolArr[i10] = Boolean.FALSE;
                }
            }
        }
        for (int i11 = 0; i11 < pressingGoal.keys.length; i11++) {
            if (zArr[i11] != boolArr[i11].booleanValue()) {
                KeyboardMap.KeyPair keyPair2 = pressingGoal.keys[i11];
                synthesizeEvent(boolArr[i11].booleanValue(), Long.valueOf(keyPair2.logicalKey), Long.valueOf(keyPair2.physicalKey), keyEvent.getEventTime());
            }
        }
    }

    public void synchronizeTogglingKey(KeyboardMap.TogglingGoal togglingGoal, boolean z6, long j6, KeyEvent keyEvent) {
        if (togglingGoal.logicalKey == j6 || togglingGoal.enabled == z6) {
            return;
        }
        boolean zContainsKey = this.pressingRecords.containsKey(Long.valueOf(togglingGoal.physicalKey));
        boolean z7 = !zContainsKey;
        if (!zContainsKey) {
            togglingGoal.enabled = !togglingGoal.enabled;
        }
        synthesizeEvent(z7, Long.valueOf(togglingGoal.logicalKey), Long.valueOf(togglingGoal.physicalKey), keyEvent.getEventTime());
        if (zContainsKey) {
            togglingGoal.enabled = !togglingGoal.enabled;
        }
        synthesizeEvent(zContainsKey, Long.valueOf(togglingGoal.logicalKey), Long.valueOf(togglingGoal.physicalKey), keyEvent.getEventTime());
    }

    public void updatePressingState(@NonNull Long l6, @Nullable Long l7) {
        if (l7 != null) {
            if (this.pressingRecords.put(l6, l7) != null) {
                throw new AssertionError("The key was not empty");
            }
        } else if (this.pressingRecords.remove(l6) == null) {
            throw new AssertionError("The key was empty");
        }
    }
}
