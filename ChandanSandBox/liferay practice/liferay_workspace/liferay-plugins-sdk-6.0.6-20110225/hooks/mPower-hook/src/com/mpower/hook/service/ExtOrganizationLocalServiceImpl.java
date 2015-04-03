package com.mpower.hook.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.Organization;
import com.liferay.portal.service.OrganizationLocalService;
import com.liferay.portal.service.OrganizationLocalServiceWrapper;
import com.liferay.portal.service.ServiceContext;

public class ExtOrganizationLocalServiceImpl extends OrganizationLocalServiceWrapper{

	public ExtOrganizationLocalServiceImpl(
			OrganizationLocalService organizationLocalService) {
		super(organizationLocalService);
		// TODO Auto-generated constructor stub
	}
	@Override
	public Organization addOrganization(long userId, long parentOrganizationId,
			String name, String type, boolean recursable, long regionId,
			long countryId, int statusId, String comments,
			ServiceContext serviceContext) throws PortalException,
			SystemException {
		System.out.println("Inside ExtOrganizationLocalServiceImpl--------");
		return super.addOrganization(userId, parentOrganizationId, name, type,
				recursable, regionId, countryId, statusId, comments, serviceContext);
	}
	
	@Override
	public Organization addOrganization(Organization organization)
			throws SystemException {
		// TODO Auto-generated method stub
		
		return super.addOrganization(organization);
	}
	
	@Override
	public Organization updateOrganization(long companyId, long organizationId,
			long parentOrganizationId, String name, String type,
			boolean recursable, long regionId, long countryId, int statusId,
			String comments, ServiceContext serviceContext)
			throws PortalException, SystemException {
		System.out.println("Modify----Org");
		return super.updateOrganization(companyId, organizationId,
				parentOrganizationId, name, type, recursable, regionId, countryId,
				statusId, comments, serviceContext);
	}

}
