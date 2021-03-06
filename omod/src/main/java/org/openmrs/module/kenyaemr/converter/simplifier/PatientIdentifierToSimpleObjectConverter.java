/**
 * The contents of this file are subject to the OpenMRS Public License
 * Version 1.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://license.openmrs.org
 *
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific language governing rights and limitations
 * under the License.
 *
 * Copyright (C) OpenMRS, LLC.  All Rights Reserved.
 */

package org.openmrs.module.kenyaemr.converter.simplifier;

import org.openmrs.PatientIdentifier;
import org.openmrs.ui.framework.SimpleObject;
import org.openmrs.ui.framework.UiUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * Converts a patient identifier to a simple object
 */
@Component
public class PatientIdentifierToSimpleObjectConverter implements Converter<PatientIdentifier, SimpleObject> {
	
	@Autowired
	private UiUtils ui;
	
	@Override
	public SimpleObject convert(PatientIdentifier pid) {
		SimpleObject ret = new SimpleObject();
		ret.put("id", pid.getId());
		ret.put("identifierType", pid.getIdentifierType().getName());
		ret.put("identifier", pid.getIdentifier());
		ret.put("preferred", pid.isPreferred());
		return ret;
	}
}