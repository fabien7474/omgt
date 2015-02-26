package com.hsbcpb.omgt.persistence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import com.hsbcpb.omgt.domain.model.DispatchCode;
import com.hsbcpb.omgt.domain.service.DispatchCodesRepository;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

/**
 * Implements the {@link DispatchCodesRepository} using Configuration files as
 * persistence infrastructure
 *
 */
public class DispatchCodesConfiguration implements DispatchCodesRepository {

	@Override
	public Collection<DispatchCode> listAllAutomaticDispatchCodes() {
		String dispatchCodesStr = OMgtPropertyValues.getInstance().getValue(
				"omgt.automatic-dispatch-codes");
		String[] dispatchCodesArray = dispatchCodesStr.split(",");
		Collection<DispatchCode> dispatchCodes = new ArrayList<DispatchCode>();
		for (String dispatchCodeStr : dispatchCodesArray) {
			dispatchCodes.add(new DispatchCode(dispatchCodeStr));
		}
		return dispatchCodes;
	}

}
