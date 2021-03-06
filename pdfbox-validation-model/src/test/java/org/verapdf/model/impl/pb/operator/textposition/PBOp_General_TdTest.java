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
package org.verapdf.model.impl.pb.operator.textposition;

import org.junit.Assert;
import org.junit.Test;
import org.verapdf.model.baselayer.Object;
import org.verapdf.model.coslayer.CosInteger;
import org.verapdf.model.impl.pb.cos.PBCosInteger;
import org.verapdf.model.impl.pb.operator.base.PBOperatorTest;

/**
 * @author Evgeniy Muravitskiy
 */
public abstract class PBOp_General_TdTest extends PBOperatorTest {

	protected static Long expectedVertical;
	protected static Long expectedHorizontal;

	@Test
	public void testVerticalOffset() {
		testOffset(PBOp_General_Td.VERTICAL_OFFSET, expectedVertical);
	}

	@Test
	public void testHorizontalOffset() {
		testOffset(PBOp_General_Td.HORIZONTAL_OFFSET, expectedHorizontal);
	}

	private static void testOffset(String link, Long value) {
		Object object = testObject(link, 1, PBCosInteger.COS_INTEGER_TYPE);
		Assert.assertEquals(value, ((CosInteger) object).getintValue());
	}
}
