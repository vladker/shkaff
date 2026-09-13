package org.apache.poi.ooxml.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import org.apache.poi.ooxml.POIXMLException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.PackageProperties;
import org.apache.poi.openxml4j.opc.PackageRelationship;
import org.apache.poi.openxml4j.opc.PackageRelationshipCollection;
import org.apache.poi.openxml4j.opc.PackageRelationshipTypes;
import org.apache.poi.openxml4j.opc.PackagingURIHelper;
import org.apache.poi.openxml4j.opc.TargetMode;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.Removal;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class PackageHelper {
    @Removal(version = "6.0.0")
    @Deprecated
    public static OPCPackage clone(OPCPackage oPCPackage, File file) throws IOException {
        String absolutePath = file.getAbsolutePath();
        OPCPackage oPCPackageCreate = OPCPackage.create(absolutePath);
        try {
            for (PackageRelationship packageRelationship : oPCPackage.getRelationships()) {
                PackagePart part = oPCPackage.getPart(packageRelationship);
                if (packageRelationship.getRelationshipType().equals(PackageRelationshipTypes.CORE_PROPERTIES)) {
                    copyProperties(oPCPackage.getPackageProperties(), oPCPackageCreate.getPackageProperties());
                } else {
                    oPCPackageCreate.addRelationship(part.getPartName(), packageRelationship.getTargetMode(), packageRelationship.getRelationshipType());
                    PackagePart packagePartCreatePart = oPCPackageCreate.createPart(part.getPartName(), part.getContentType());
                    InputStream inputStream = part.getInputStream();
                    try {
                        OutputStream outputStream = packagePartCreatePart.getOutputStream();
                        try {
                            IOUtils.copy(inputStream, outputStream);
                            if (outputStream != null) {
                                outputStream.close();
                            }
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            if (part.hasRelationships()) {
                                copy(oPCPackage, part, oPCPackageCreate, packagePartCreatePart);
                            }
                        } catch (Throwable th) {
                            try {
                                throw th;
                            } catch (Throwable th2) {
                                if (outputStream != null) {
                                    try {
                                        outputStream.close();
                                    } catch (Throwable th3) {
                                        th.addSuppressed(th3);
                                    }
                                }
                                throw th2;
                            }
                        }
                    } catch (Throwable th4) {
                        try {
                            throw th4;
                        } catch (Throwable th5) {
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Throwable th6) {
                                    th4.addSuppressed(th6);
                                }
                            }
                            throw th5;
                        }
                    }
                }
            }
            if (oPCPackageCreate != null) {
                oPCPackageCreate.close();
            }
            new File(absolutePath).deleteOnExit();
            return OPCPackage.open(absolutePath);
        } catch (Throwable th7) {
            try {
                throw th7;
            } catch (Throwable th8) {
                if (oPCPackageCreate != null) {
                    try {
                        oPCPackageCreate.close();
                    } catch (Throwable th9) {
                        th7.addSuppressed(th9);
                    }
                }
                throw th8;
            }
        }
    }

    private static void copy(OPCPackage oPCPackage, PackagePart packagePart, OPCPackage oPCPackage2, PackagePart packagePart2) throws IOException {
        PackageRelationshipCollection relationships = packagePart.getRelationships();
        if (relationships != null) {
            for (PackageRelationship packageRelationship : relationships) {
                if (packageRelationship.getTargetMode() == TargetMode.EXTERNAL) {
                    packagePart2.addExternalRelationship(packageRelationship.getTargetURI().toString(), packageRelationship.getRelationshipType(), packageRelationship.getId());
                } else {
                    URI targetURI = packageRelationship.getTargetURI();
                    if (targetURI.getRawFragment() != null) {
                        packagePart2.addRelationship(targetURI, packageRelationship.getTargetMode(), packageRelationship.getRelationshipType(), packageRelationship.getId());
                    } else {
                        PackagePart part = oPCPackage.getPart(PackagingURIHelper.createPartName(packageRelationship.getTargetURI()));
                        packagePart2.addRelationship(part.getPartName(), packageRelationship.getTargetMode(), packageRelationship.getRelationshipType(), packageRelationship.getId());
                        if (oPCPackage2.containPart(part.getPartName())) {
                            continue;
                        } else {
                            PackagePart packagePartCreatePart = oPCPackage2.createPart(part.getPartName(), part.getContentType());
                            InputStream inputStream = part.getInputStream();
                            try {
                                OutputStream outputStream = packagePartCreatePart.getOutputStream();
                                try {
                                    IOUtils.copy(inputStream, outputStream);
                                    if (outputStream != null) {
                                        outputStream.close();
                                    }
                                    if (inputStream != null) {
                                        inputStream.close();
                                    }
                                    copy(oPCPackage, part, oPCPackage2, packagePartCreatePart);
                                } catch (Throwable th) {
                                    try {
                                        throw th;
                                    } catch (Throwable th2) {
                                        if (outputStream != null) {
                                            try {
                                                outputStream.close();
                                            } catch (Throwable th3) {
                                                th.addSuppressed(th3);
                                            }
                                        }
                                        throw th2;
                                    }
                                }
                            } catch (Throwable th4) {
                                try {
                                    throw th4;
                                } catch (Throwable th5) {
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (Throwable th6) {
                                            th4.addSuppressed(th6);
                                        }
                                    }
                                    throw th5;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private static void copyProperties(PackageProperties packageProperties, PackageProperties packageProperties2) {
        packageProperties2.setCategoryProperty(packageProperties.getCategoryProperty());
        packageProperties2.setContentStatusProperty(packageProperties.getContentStatusProperty());
        packageProperties2.setContentTypeProperty(packageProperties.getContentTypeProperty());
        packageProperties2.setCreatorProperty(packageProperties.getCreatorProperty());
        packageProperties2.setDescriptionProperty(packageProperties.getDescriptionProperty());
        packageProperties2.setIdentifierProperty(packageProperties.getIdentifierProperty());
        packageProperties2.setKeywordsProperty(packageProperties.getKeywordsProperty());
        packageProperties2.setLanguageProperty(packageProperties.getLanguageProperty());
        packageProperties2.setRevisionProperty(packageProperties.getRevisionProperty());
        packageProperties2.setSubjectProperty(packageProperties.getSubjectProperty());
        packageProperties2.setTitleProperty(packageProperties.getTitleProperty());
        packageProperties2.setVersionProperty(packageProperties.getVersionProperty());
    }

    public static OPCPackage open(InputStream inputStream) {
        return open(inputStream, false);
    }

    public static OPCPackage open(InputStream inputStream, boolean z6) throws IOException {
        try {
            try {
                OPCPackage oPCPackageOpen = OPCPackage.open(inputStream);
                if (z6) {
                    inputStream.close();
                }
                return oPCPackageOpen;
            } catch (InvalidFormatException e) {
                throw new POIXMLException(e);
            }
        } catch (Throwable th) {
            if (z6) {
                inputStream.close();
            }
            throw th;
        }
    }
}
