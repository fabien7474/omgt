package com.hsbcpb.omgt.domain.service;

import java.util.Collection;

import com.hsbcpb.omgt.domain.model.DispatchCode;

/**
 * Interface that represents repository of {@link DispatchCode}
 *
 */
public interface DispatchCodesRepository {

	Collection<DispatchCode> listAllAutomaticDispatchCodes();

}
