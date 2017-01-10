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
package org.verapdf.model.impl.pb.containers;

import org.apache.pdfbox.cos.COSObjectKey;
import org.verapdf.model.impl.pb.pd.colors.PBoxPDSeparation;
import org.verapdf.model.pdlayer.PDColorSpace;

import java.util.*;

/**
 * @author Timur Kamalov
 */
public class StaticContainers {

	//PBoxPDSeparation
	public static Map<String, List<PBoxPDSeparation>> separations = new HashMap<>();
	public static List<String> inconsistentSeparations = new ArrayList<>();

	//ColorSpaceFactory
	//TODO : change key from object reference to something else
	public static Map<org.apache.pdfbox.pdmodel.graphics.color.PDColorSpace, PDColorSpace> cachedColorSpaces = new HashMap<>();

	public static Set<COSObjectKey> fileSpecificationKeys = new HashSet<>();

	public static void clearAllContainers() {
		separations.clear();
		inconsistentSeparations.clear();
		cachedColorSpaces.clear();
		fileSpecificationKeys.clear();
	}

}
