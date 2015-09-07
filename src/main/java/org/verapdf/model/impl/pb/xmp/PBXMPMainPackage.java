package org.verapdf.model.impl.pb.xmp;

import org.apache.xmpbox.XMPMetadata;
import org.verapdf.model.xmplayer.XMPMainPackage;

/**
 * Current class is representation of XMPPackage interface from abstract model based on xmpbox from pdfbox.
 *
 * @author Maksim Bezrukov
 */
public class PBXMPMainPackage extends PBXMPPackage implements XMPMainPackage {

	public static final String XMP_MAIN_PACKAGE_TYPE = "XMPMainPackage";

	/**
	 * Constructs new object
	 *
	 * @param xmpMetadata     object from xmpbox represented this package
	 * @param isMetadataValid true if metadata is valid
	 */
	public PBXMPMainPackage(XMPMetadata xmpMetadata, boolean isMetadataValid) {
		super(xmpMetadata, isMetadataValid, XMP_MAIN_PACKAGE_TYPE);
	}

	/**
	 * @return true if pdfaid schema is present
	 */
	@Override
	public Boolean getispdfaidNSPresent() {
		return getXmpMetadata() == null ? Boolean.FALSE : Boolean
				.valueOf(getXmpMetadata().getPDFIdentificationSchema() != null);
	}
}
