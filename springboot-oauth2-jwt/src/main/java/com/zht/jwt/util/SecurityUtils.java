package com.zht.jwt.util;

import com.zht.jwt.business.entity.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityUtils {

	/**
	 * 获取Authentication
	 */
	public static Authentication getAuthentication() {
		return SecurityContextHolder.getContext().getAuthentication();
	}

	/**
	 * 获取用户信息
	 *
	 * @return
	 */
    public static User getUser() {
        Object principal = getAuthentication().getPrincipal();
        if (principal instanceof User) {
			return (User) principal;
        }
        return null;
    }



}
