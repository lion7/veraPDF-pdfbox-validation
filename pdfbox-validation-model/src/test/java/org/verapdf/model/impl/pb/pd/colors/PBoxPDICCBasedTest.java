/**
 * This file is part of veraPDF PDF Box PDF/A Validation Model Implementation, a module of the veraPDF project.
 * Copyright (c) 2015, veraPDF Consortium <info@verapdf.org>
 * All rights reserved.
 *
 * veraPDF PDF Box PDF/A Validation Model Implementation is free software: you can redistribute it and/or modify
 * it under the terms of either:
 *
 * The GNU General public license GPLv3+.
 * You should have received a copy of the GNU General Public License
 * along with veraPDF PDF Box PDF/A Validation Model Implementation as the LICENSE.GPL file in the root of the source
 * tree.  If not, see http://www.gnu.org/licenses/ or
 * https://www.gnu.org/licenses/gpl-3.0.en.html.
 *
 * The Mozilla Public License MPLv2+.
 * You should have received a copy of the Mozilla Public License along with
 * veraPDF PDF Box PDF/A Validation Model Implementation as the LICENSE.MPL file in the root of the source tree.
 * If a copy of the MPL was not distributed with this file, you can obtain one at
 * http://mozilla.org/MPL/2.0/.
 */
package org.verapdf.model.impl.pb.pd.colors;

import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.graphics.color.PDColorSpace;
import org.apache.pdfbox.pdmodel.graphics.color.PDICCBased;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.impl.pb.external.PBoxICCInputProfile;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

/**
 * @author Evgeniy Muravitskiy
 */
public class PBoxPDICCBasedTest extends PBoxPDColorSpaceTest {

	private static final String COLOR_SPACE_NAME = "ICCBasedCS";
	private static final int EXPECTED_COMPONENTS_NUMBER = 3;

	@BeforeClass
	public static void setUp() throws IOException, URISyntaxException {
		expectedType = TYPES.contains(PBoxPDICCBased.ICC_BASED_TYPE) ? PBoxPDICCBased.ICC_BASED_TYPE : null;
		expectedID = null;

		setUp(FILE_RELATIVE_PATH);
		final PDResources resources = document.getPage(0).getResources();
		final COSName pdfName = COSName.getPDFName(COLOR_SPACE_NAME);
		PDColorSpace iccBased = resources.getColorSpace(pdfName);
		actual = new PBoxPDICCBased((PDICCBased) iccBased);
	}

	@Test
	public void testNumberOfComponentsMethod() {
		super.testNumberOfComponentsMethod(EXPECTED_COMPONENTS_NUMBER);
	}

	@Test
	public void testICCProfileLink() {
		List<? extends Object> profile = actual.getLinkedObjects(PBoxPDICCBased.ICC_PROFILE);
		Assert.assertEquals(1, profile.size());
		for (Object object : profile) {
			Assert.assertEquals(PBoxICCInputProfile.ICC_INPUT_PROFILE_TYPE, object.getObjectType());
		}
	}

}
