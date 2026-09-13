package com.android.billingclient.api;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public abstract class k1 {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public static final H f2500A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public static final H f2501B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public static final H f2502C;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public static final H f2503D;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    public static final H f2504E;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    public static final H f2505F;

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    public static final H f2506G;

    /* JADX INFO: renamed from: H, reason: collision with root package name */
    public static final H f2507H;

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    public static final H f2508I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public static final H f2509J;

    /* JADX INFO: renamed from: K, reason: collision with root package name */
    public static final H f2510K;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final H f2511a;
    public static final H b;
    public static final H c;
    public static final H d;
    public static final H e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final H f2512f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final H f2513g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final H f2514h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final H f2515i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final H f2516j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final H f2517k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final H f2518l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final H f2519m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final H f2520n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final H f2521o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final H f2522p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final H f2523q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final H f2524r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final H f2525s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final H f2526t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final H f2527u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final H f2528v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final H f2529w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final H f2530x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final H f2531y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final H f2532z;

    static {
        G gNewBuilder = H.newBuilder();
        gNewBuilder.setResponseCode(3);
        gNewBuilder.setDebugMessage("Google Play In-app Billing API version is less than 3");
        gNewBuilder.build();
        G gNewBuilder2 = H.newBuilder();
        gNewBuilder2.setResponseCode(3);
        gNewBuilder2.setDebugMessage("Google Play In-app Billing API version is less than 9");
        f2511a = gNewBuilder2.build();
        b = androidx.exifinterface.media.a.c(3, "Billing service unavailable on device.");
        c = androidx.exifinterface.media.a.c(2, "Billing service unavailable on device.");
        d = androidx.exifinterface.media.a.c(5, "Client is already in the process of connecting to billing service.");
        G gNewBuilder3 = H.newBuilder();
        gNewBuilder3.setResponseCode(5);
        gNewBuilder3.setDebugMessage("The list of SKUs can't be empty.");
        gNewBuilder3.build();
        G gNewBuilder4 = H.newBuilder();
        gNewBuilder4.setResponseCode(5);
        gNewBuilder4.setDebugMessage("SKU type can't be empty.");
        gNewBuilder4.build();
        G gNewBuilder5 = H.newBuilder();
        gNewBuilder5.setResponseCode(5);
        gNewBuilder5.setDebugMessage("Product type can't be empty.");
        e = gNewBuilder5.build();
        f2512f = androidx.exifinterface.media.a.c(-2, "Client does not support extra params.");
        f2513g = androidx.exifinterface.media.a.c(5, "Invalid purchase token.");
        f2514h = androidx.exifinterface.media.a.c(6, "An internal error occurred.");
        G gNewBuilder6 = H.newBuilder();
        gNewBuilder6.setResponseCode(5);
        gNewBuilder6.setDebugMessage("SKU can't be null.");
        gNewBuilder6.build();
        G gNewBuilder7 = H.newBuilder();
        gNewBuilder7.setResponseCode(0);
        f2515i = gNewBuilder7.build();
        f2516j = androidx.exifinterface.media.a.c(-1, "Service connection is disconnected.");
        f2517k = androidx.exifinterface.media.a.c(2, "Timeout communicating with service.");
        f2518l = androidx.exifinterface.media.a.c(-2, "Client does not support subscriptions.");
        f2519m = androidx.exifinterface.media.a.c(-2, "Client does not support subscriptions update.");
        G gNewBuilder8 = H.newBuilder();
        gNewBuilder8.setResponseCode(-2);
        gNewBuilder8.setDebugMessage("Client does not support get purchase history.");
        gNewBuilder8.build();
        G gNewBuilder9 = H.newBuilder();
        gNewBuilder9.setResponseCode(-2);
        gNewBuilder9.setDebugMessage("Client does not support price change confirmation.");
        f2520n = gNewBuilder9.build();
        f2521o = androidx.exifinterface.media.a.c(-2, "Play Store version installed does not support cross selling products.");
        f2522p = androidx.exifinterface.media.a.c(-2, "Client does not support multi-item purchases.");
        f2523q = androidx.exifinterface.media.a.c(-2, "Client does not support offer_id_token.");
        f2524r = androidx.exifinterface.media.a.c(-2, "Play Store version installed does not support gift code purchase.");
        f2525s = androidx.exifinterface.media.a.c(-2, "Client does not support ProductDetails.");
        G gNewBuilder10 = H.newBuilder();
        gNewBuilder10.setResponseCode(-2);
        gNewBuilder10.setDebugMessage("Client does not support launching subscription management action flow.");
        gNewBuilder10.build();
        G gNewBuilder11 = H.newBuilder();
        gNewBuilder11.setResponseCode(-2);
        gNewBuilder11.setDebugMessage("Client does not support in-app messages.");
        f2526t = gNewBuilder11.build();
        G gNewBuilder12 = H.newBuilder();
        gNewBuilder12.setResponseCode(-2);
        gNewBuilder12.setDebugMessage("Client does not support user choice billing.");
        gNewBuilder12.build();
        G gNewBuilder13 = H.newBuilder();
        gNewBuilder13.setResponseCode(-2);
        gNewBuilder13.setDebugMessage("Play Store version installed does not support external offer.");
        f2527u = gNewBuilder13.build();
        f2528v = androidx.exifinterface.media.a.c(-2, "Play Store version installed does not support multi-item purchases with season pass in one cart.");
        f2529w = androidx.exifinterface.media.a.c(-2, "Play Store version installed does not support querying AutoPay plan purchase.");
        f2530x = androidx.exifinterface.media.a.c(-2, "Play Store version installed does not support including suspended subscriptions.");
        f2531y = androidx.exifinterface.media.a.c(5, "Unknown feature");
        f2532z = androidx.exifinterface.media.a.c(-2, "Play Store version installed does not support get billing config.");
        f2500A = androidx.exifinterface.media.a.c(-2, "Query product details with serialized docid is not supported.");
        G gNewBuilder14 = H.newBuilder();
        gNewBuilder14.setResponseCode(-2);
        gNewBuilder14.setDebugMessage("Play Store version installed does not support launching external offer flow.");
        gNewBuilder14.build();
        G gNewBuilder15 = H.newBuilder();
        gNewBuilder15.setResponseCode(4);
        gNewBuilder15.setDebugMessage("Item is unavailable for purchase.");
        f2501B = gNewBuilder15.build();
        f2502C = androidx.exifinterface.media.a.c(-2, "Query product details with developer specified account is not supported.");
        f2503D = androidx.exifinterface.media.a.c(-2, "Play Store version installed does not support alternative billing only.");
        f2504E = androidx.exifinterface.media.a.c(5, "To use this API you must specify a PurchasesUpdateListener when initializing a BillingClient.");
        f2505F = androidx.exifinterface.media.a.c(6, "An error occurred while retrieving billing override.");
        f2506G = androidx.exifinterface.media.a.c(-2, "Play Store version installed does not support the provided billing program.");
        f2507H = androidx.exifinterface.media.a.c(-2, "Play Store version installed does not support launching external links.");
        f2508I = androidx.exifinterface.media.a.c(5, "A DeveloperProvidedBillingListener must be provided when initializing the BillingClient in order to use multiple payment options for this billing program.");
        G gNewBuilder16 = H.newBuilder();
        gNewBuilder16.setResponseCode(5);
        gNewBuilder16.setDebugMessage("A listener must be provided calling this method.");
        gNewBuilder16.build();
        G gNewBuilder17 = H.newBuilder();
        gNewBuilder17.setResponseCode(-2);
        gNewBuilder17.setDebugMessage("Play Store version installed does not support show billing program information dialog.");
        f2509J = gNewBuilder17.build();
        f2510K = androidx.exifinterface.media.a.c(-2, "Play Store version installed does not support get billing choice info.");
    }

    public static H a(int i5, String str) {
        return androidx.exifinterface.media.a.c(i5, str);
    }
}
