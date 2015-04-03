package com.library;
import com.library.slayer.model.LMSBook;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;

public class LibraryPermission {
	public static void check(
			PermissionChecker permissionChecker, LMSBook book,
			String actionId)
		throws PortalException, SystemException {

		if (!contains(permissionChecker, book, actionId)) {
			throw new PrincipalException();
		}
	}

	
	public static boolean contains(
			PermissionChecker permissionChecker, LMSBook book,
			String actionId)
		throws PortalException, SystemException {

		
		if (permissionChecker.hasOwnerPermission(
				book.getCompanyId(), LMSBook.class.getName(),book.getBookId(), book.getUserId(), actionId)) {

			return true;
		}

		return permissionChecker.hasPermission(
				book.getGroupId(), LMSBook.class.getName(),book.getBookId(), actionId);
	}
	public static boolean actionContains(
			PermissionChecker permissionChecker, LMSBook book,
			String actionId)
		throws PortalException, SystemException {

		return permissionChecker.hasPermission(
				book.getGroupId(), LMSBook.class.getName(),book.getBookId(), actionId);
	}
}


