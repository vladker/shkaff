package com.google.firebase;

import android.content.Context;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import java.lang.annotation.Annotation;
import kotlin.jvm.internal.E;
import p007a4.F;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class FirebaseKt {

    /* JADX INFO: renamed from: com.google.firebase.FirebaseKt$coroutineDispatcher$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class AnonymousClass1<T> implements ComponentFactory {
        public static final AnonymousClass1<T> INSTANCE = new AnonymousClass1<>();

        @Override // com.google.firebase.components.ComponentFactory
        public final F create(ComponentContainer componentContainer) {
            E.l();
            throw null;
        }
    }

    public static final FirebaseApp app(Firebase firebase, String name) {
        E.f(firebase, "<this>");
        E.f(name, "name");
        FirebaseApp firebaseApp = FirebaseApp.getInstance(name);
        E.e(firebaseApp, "getInstance(...)");
        return firebaseApp;
    }

    private static final <T extends Annotation> Component<F> coroutineDispatcher() {
        E.l();
        throw null;
    }

    public static final FirebaseApp getApp(Firebase firebase) {
        E.f(firebase, "<this>");
        FirebaseApp firebaseApp = FirebaseApp.getInstance();
        E.e(firebaseApp, "getInstance(...)");
        return firebaseApp;
    }

    public static final FirebaseOptions getOptions(Firebase firebase) {
        E.f(firebase, "<this>");
        FirebaseOptions options = getApp(Firebase.INSTANCE).getOptions();
        E.e(options, "getOptions(...)");
        return options;
    }

    public static final FirebaseApp initialize(Firebase firebase, Context context) {
        E.f(firebase, "<this>");
        E.f(context, "context");
        return FirebaseApp.initializeApp(context);
    }

    public static final FirebaseApp initialize(Firebase firebase, Context context, FirebaseOptions options) {
        E.f(firebase, "<this>");
        E.f(context, "context");
        E.f(options, "options");
        FirebaseApp firebaseAppInitializeApp = FirebaseApp.initializeApp(context, options);
        E.e(firebaseAppInitializeApp, "initializeApp(...)");
        return firebaseAppInitializeApp;
    }

    public static final FirebaseApp initialize(Firebase firebase, Context context, FirebaseOptions options, String name) {
        E.f(firebase, "<this>");
        E.f(context, "context");
        E.f(options, "options");
        E.f(name, "name");
        FirebaseApp firebaseAppInitializeApp = FirebaseApp.initializeApp(context, options, name);
        E.e(firebaseAppInitializeApp, "initializeApp(...)");
        return firebaseAppInitializeApp;
    }
}
