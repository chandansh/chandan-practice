package com.mpower.portal.service.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.Organization;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.impl.OrganizationLocalServiceImpl;

public class CustomOrganizationLocalServiceImpl extends
		OrganizationLocalServiceImpl {

	@Override
	public Organization addOrganization(long userId, long parentOrganizationId,
			String name, String type, boolean recursable, long regionId,
			long countryId, int statusId, String comments,
			ServiceContext serviceContext) throws PortalException,
			SystemException {
		System.out.println("In custom Add organization Impl----------");
		return super.addOrganization(userId, parentOrganizationId, name, type,
				recursable, regionId, countryId, statusId, comments,
				serviceContext);
	}
	@Override
	public Organization createOrganization(long organizationId) {
System.out.println("create organization----------");
		return super.createOrganization(organizationId);
	}

}
