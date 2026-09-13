package com.bumptech.glide.load.resource.bitmap;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.bumptech.glide.load.ImageHeaderParser$ImageType;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

/* JADX INFO: renamed from: com.bumptech.glide.load.resource.bitmap.p, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class C0521p implements p126w0.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte[] f3114a = "Exif\u0000\u0000".getBytes(Charset.forName("UTF-8"));
    public static final int[] b = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8};

    private int moveToExifSegmentAndGetLength(InterfaceC0519n interfaceC0519n) {
        short uInt8;
        int uInt16;
        long j6;
        long jSkip;
        do {
            short uInt9 = interfaceC0519n.getUInt8();
            if (uInt9 != 255) {
                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    androidx.exifinterface.media.a.v(uInt9, "Unknown segmentId=", "DfltImageHeaderParser");
                }
                return -1;
            }
            uInt8 = interfaceC0519n.getUInt8();
            if (uInt8 == 218) {
                return -1;
            }
            if (uInt8 == 217) {
                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Log.d("DfltImageHeaderParser", "Found MARKER_EOI in exif segment");
                }
                return -1;
            }
            uInt16 = interfaceC0519n.getUInt16() - 2;
            if (uInt8 == 225) {
                return uInt16;
            }
            j6 = uInt16;
            jSkip = interfaceC0519n.skip(j6);
        } while (jSkip == j6);
        if (Log.isLoggable("DfltImageHeaderParser", 3)) {
            StringBuilder sbS = androidx.collection.a.s("Unable to skip enough data, type: ", uInt8, uInt16, ", wanted to skip: ", ", but actually skipped: ");
            sbS.append(jSkip);
            Log.d("DfltImageHeaderParser", sbS.toString());
        }
        return -1;
    }

    private int parseExifSegment(InterfaceC0519n interfaceC0519n, byte[] bArr, int i5) {
        ByteOrder byteOrder;
        int i6 = interfaceC0519n.read(bArr, i5);
        short s6 = -1;
        if (i6 == i5) {
            int i7 = 0;
            byte[] bArr2 = f3114a;
            boolean z6 = bArr != null && i5 > bArr2.length;
            if (z6) {
                for (int i8 = 0; i8 < bArr2.length; i8++) {
                    if (bArr[i8] != bArr2[i8]) {
                        z6 = false;
                        break;
                    }
                }
            }
            if (!z6) {
                if (!Log.isLoggable("DfltImageHeaderParser", 3)) {
                    return -1;
                }
                Log.d("DfltImageHeaderParser", "Missing jpeg exif preamble");
                return -1;
            }
            ByteBuffer byteBuffer = (ByteBuffer) ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN).limit(i5);
            short s7 = byteBuffer.remaining() - 6 >= 2 ? byteBuffer.getShort(6) : (short) -1;
            if (s7 != 18761) {
                if (s7 != 19789 && Log.isLoggable("DfltImageHeaderParser", 3)) {
                    androidx.exifinterface.media.a.v(s7, "Unknown endianness = ", "DfltImageHeaderParser");
                }
                byteOrder = ByteOrder.BIG_ENDIAN;
            } else {
                byteOrder = ByteOrder.LITTLE_ENDIAN;
            }
            byteBuffer.order(byteOrder);
            int i9 = byteBuffer.remaining() - 10 >= 4 ? byteBuffer.getInt(10) : -1;
            int i10 = i9 + 6;
            short s8 = byteBuffer.remaining() - i10 >= 2 ? byteBuffer.getShort(i10) : (short) -1;
            while (i7 < s8) {
                int i11 = (i7 * 12) + i9 + 8;
                short s9 = byteBuffer.remaining() - i11 >= 2 ? byteBuffer.getShort(i11) : s6;
                if (s9 != 274) {
                    s6 = s6;
                } else {
                    int i12 = i11 + 2;
                    short s10 = byteBuffer.remaining() - i12 >= 2 ? byteBuffer.getShort(i12) : s6;
                    if (s10 < 1 || s10 > 12) {
                        s6 = s6;
                        if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                            androidx.exifinterface.media.a.v(s10, "Got invalid format code = ", "DfltImageHeaderParser");
                        }
                    } else {
                        int i13 = i11 + 4;
                        int i14 = byteBuffer.remaining() - i13 >= 4 ? byteBuffer.getInt(i13) : s6;
                        if (i14 < 0) {
                            if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                Log.d("DfltImageHeaderParser", "Negative tiff component count");
                            }
                            s6 = s6;
                        } else {
                            if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                StringBuilder sbS = androidx.collection.a.s("Got tagIndex=", i7, s9, " tagType=", " formatCode=");
                                sbS.append((int) s10);
                                sbS.append(" componentCount=");
                                sbS.append(i14);
                                Log.d("DfltImageHeaderParser", sbS.toString());
                            }
                            int i15 = i14 + b[s10];
                            if (i15 <= 4) {
                                int i16 = i11 + 8;
                                if (i16 >= 0 && i16 <= byteBuffer.remaining()) {
                                    if (i15 >= 0 && i15 + i16 <= byteBuffer.remaining()) {
                                        return byteBuffer.remaining() - i16 >= 2 ? byteBuffer.getShort(i16) : s6;
                                    }
                                    if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                        androidx.exifinterface.media.a.v(s9, "Illegal number of bytes for TI tag data tagType=", "DfltImageHeaderParser");
                                    }
                                } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                    Log.d("DfltImageHeaderParser", "Illegal tagValueOffset=" + i16 + " tagType=" + ((int) s9));
                                }
                            } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                androidx.exifinterface.media.a.v(s10, "Got byte count > 4, not orientation, continuing, formatCode=", "DfltImageHeaderParser");
                            }
                        }
                    }
                }
                i7++;
                s6 = s6;
            }
        } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
            Log.d("DfltImageHeaderParser", "Unable to read exif segment data, length: " + i5 + ", actually read: " + i6);
            return -1;
        }
        return s6;
    }

    private ImageHeaderParser$ImageType sniffAvif(InterfaceC0519n interfaceC0519n, int i5) {
        if (((interfaceC0519n.getUInt16() << 16) | interfaceC0519n.getUInt16()) != 1718909296) {
            return ImageHeaderParser$ImageType.UNKNOWN;
        }
        int uInt16 = (interfaceC0519n.getUInt16() << 16) | interfaceC0519n.getUInt16();
        if (uInt16 == 1635150195) {
            return ImageHeaderParser$ImageType.ANIMATED_AVIF;
        }
        int i6 = 0;
        boolean z6 = uInt16 == 1635150182;
        interfaceC0519n.skip(4L);
        int i7 = i5 - 16;
        if (i7 % 4 == 0) {
            while (i6 < 5 && i7 > 0) {
                int uInt17 = (interfaceC0519n.getUInt16() << 16) | interfaceC0519n.getUInt16();
                if (uInt17 == 1635150195) {
                    return ImageHeaderParser$ImageType.ANIMATED_AVIF;
                }
                if (uInt17 == 1635150182) {
                    z6 = true;
                }
                i6++;
                i7 -= 4;
            }
        }
        return z6 ? ImageHeaderParser$ImageType.AVIF : ImageHeaderParser$ImageType.UNKNOWN;
    }

    @Override // p126w0.g
    public int getOrientation(@NonNull InputStream inputStream, @NonNull com.bumptech.glide.load.engine.bitmap_recycle.a aVar) {
        return getOrientation(new C0520o((InputStream) L0.q.checkNotNull(inputStream)), (com.bumptech.glide.load.engine.bitmap_recycle.a) L0.q.checkNotNull(aVar));
    }

    @Override // p126w0.g
    @NonNull
    public ImageHeaderParser$ImageType getType(@NonNull InputStream inputStream) {
        return getType(new C0520o((InputStream) L0.q.checkNotNull(inputStream)));
    }

    @Override // p126w0.g
    @NonNull
    public ImageHeaderParser$ImageType getType(@NonNull ByteBuffer byteBuffer) {
        return getType(new C0517l((ByteBuffer) L0.q.checkNotNull(byteBuffer)));
    }

    @NonNull
    private ImageHeaderParser$ImageType getType(InterfaceC0519n interfaceC0519n) {
        try {
            int uInt16 = interfaceC0519n.getUInt16();
            if (uInt16 == 65496) {
                return ImageHeaderParser$ImageType.JPEG;
            }
            int uInt8 = (uInt16 << 8) | interfaceC0519n.getUInt8();
            if (uInt8 == 4671814) {
                return ImageHeaderParser$ImageType.GIF;
            }
            int uInt9 = (uInt8 << 8) | interfaceC0519n.getUInt8();
            if (uInt9 == -1991225785) {
                interfaceC0519n.skip(21L);
                try {
                    return interfaceC0519n.getUInt8() >= 3 ? ImageHeaderParser$ImageType.PNG_A : ImageHeaderParser$ImageType.PNG;
                } catch (C0518m unused) {
                    return ImageHeaderParser$ImageType.PNG;
                }
            }
            if (uInt9 != 1380533830) {
                return sniffAvif(interfaceC0519n, uInt9);
            }
            interfaceC0519n.skip(4L);
            if (((interfaceC0519n.getUInt16() << 16) | interfaceC0519n.getUInt16()) != 1464156752) {
                return ImageHeaderParser$ImageType.UNKNOWN;
            }
            int uInt17 = (interfaceC0519n.getUInt16() << 16) | interfaceC0519n.getUInt16();
            if ((uInt17 & InputDeviceCompat.SOURCE_ANY) != 1448097792) {
                return ImageHeaderParser$ImageType.UNKNOWN;
            }
            int i5 = uInt17 & 255;
            if (i5 != 88) {
                if (i5 == 76) {
                    interfaceC0519n.skip(4L);
                    return (interfaceC0519n.getUInt8() & 8) != 0 ? ImageHeaderParser$ImageType.WEBP_A : ImageHeaderParser$ImageType.WEBP;
                }
                return ImageHeaderParser$ImageType.WEBP;
            }
            interfaceC0519n.skip(4L);
            short uInt10 = interfaceC0519n.getUInt8();
            if ((uInt10 & 2) != 0) {
                return ImageHeaderParser$ImageType.ANIMATED_WEBP;
            }
            if ((uInt10 & 16) != 0) {
                return ImageHeaderParser$ImageType.WEBP_A;
            }
            return ImageHeaderParser$ImageType.WEBP;
        } catch (C0518m unused2) {
            return ImageHeaderParser$ImageType.UNKNOWN;
        }
    }

    @Override // p126w0.g
    public int getOrientation(@NonNull ByteBuffer byteBuffer, @NonNull com.bumptech.glide.load.engine.bitmap_recycle.a aVar) {
        return getOrientation(new C0517l((ByteBuffer) L0.q.checkNotNull(byteBuffer)), (com.bumptech.glide.load.engine.bitmap_recycle.a) L0.q.checkNotNull(aVar));
    }

    private int getOrientation(InterfaceC0519n interfaceC0519n, com.bumptech.glide.load.engine.bitmap_recycle.a aVar) {
        try {
            int uInt16 = interfaceC0519n.getUInt16();
            if ((uInt16 & 65496) != 65496 && uInt16 != 19789 && uInt16 != 18761) {
                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Log.d("DfltImageHeaderParser", "Parser doesn't handle magic number: " + uInt16);
                    return -1;
                }
            } else {
                int iMoveToExifSegmentAndGetLength = moveToExifSegmentAndGetLength(interfaceC0519n);
                if (iMoveToExifSegmentAndGetLength == -1) {
                    if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                        Log.d("DfltImageHeaderParser", "Failed to parse exif segment length, or exif segment not found");
                        return -1;
                    }
                } else {
                    com.bumptech.glide.load.engine.bitmap_recycle.j jVar = (com.bumptech.glide.load.engine.bitmap_recycle.j) aVar;
                    byte[] bArr = (byte[]) jVar.c(iMoveToExifSegmentAndGetLength, byte[].class);
                    try {
                        return parseExifSegment(interfaceC0519n, bArr, iMoveToExifSegmentAndGetLength);
                    } finally {
                        jVar.g(bArr);
                    }
                }
            }
        } catch (C0518m unused) {
        }
        return -1;
    }
}
