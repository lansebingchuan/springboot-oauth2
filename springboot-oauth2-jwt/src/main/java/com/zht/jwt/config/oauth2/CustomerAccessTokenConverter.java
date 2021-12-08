package com.zht.jwt.config.oauth2;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.DefaultUserAuthenticationConverter;
import org.springframework.util.StringUtils;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 自定义CustomerAccessTokenConverter 这个类的作用主要用于AccessToken的转换，
 * 默认使用DefaultAccessTokenConverter 这个装换器
 * DefaultAccessTokenConverter有个UserAuthenticationConverter，这个转换器作用是把用户的信息放入token中，
 * 默认只是放入username
 * <p>
 * 自定义了下这个方法，加入了额外的信息
 * <p>
 * Created by xw on 2017/3/20.
 * 2017-03-20 9:54
 */
public class CustomerAccessTokenConverter extends DefaultAccessTokenConverter {


	public CustomerAccessTokenConverter() {
		super.setUserTokenConverter(new CustomerUserAuthenticationConverter());
	}


	private class CustomerUserAuthenticationConverter extends DefaultUserAuthenticationConverter {


		public Authentication extractAuthentication(Map<String, ?> map) {
			Collection authorities = this.getAuthorities(map);
			return new UsernamePasswordAuthenticationToken(map, "N/A", authorities);
		}

		private Collection<? extends GrantedAuthority> getAuthorities(Map<String, ?> map) {
			if (!map.containsKey("authorities")) {
				return AuthorityUtils.commaSeparatedStringToAuthorityList(StringUtils.arrayToCommaDelimitedString(new String[]{"USER"}));
			} else {
				Object authorities = map.get("authorities");
				if (authorities instanceof String) {
					return AuthorityUtils.commaSeparatedStringToAuthorityList((String) authorities);
				} else if (authorities instanceof Collection) {
					return AuthorityUtils.commaSeparatedStringToAuthorityList(StringUtils.collectionToCommaDelimitedString((Collection) authorities));
				} else {
					throw new IllegalArgumentException("Authorities must be either a String or a Collection");
				}
			}
		}

		/**
		 * 附加的属性到 token 信息当中
		 *
		 * @param authentication
		 * @return
		 */
		@Override
		public Map<String, ?> convertUserAuthentication(Authentication authentication) {
			Map<String, Object> response = new LinkedHashMap<String, Object>();
			response.put(USERNAME, authentication.getName());
			response.put("公司", "张海涛");
			return response;
		}

	}

	/**
	 * 测试token 转 MD5
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		// token信息转MD5值
		testTokenToMd5();
	}

	private static void testTokenToMd5() {
		MessageDigest digest;
		try {
			digest = MessageDigest.getInstance("MD5");
		}
		catch (NoSuchAlgorithmException e) {
			throw new IllegalStateException("MD5 algorithm not available.  Fatal (should be in the JDK).");
		}

		String enStr = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE2Mzg5NzgzMDAsInVzZXJfbmFtZSI6ImFkbWluIiwi5YWs5Y-4Ijoi5byg5rW35rabIiwianRpIjoiNTY2MDQyYjktODFlMC00MGEwLThhNDQtZmU2NmU3NmUyZGQ0IiwiY2xpZW50X2lkIjoiZm9vQ2xpZW50SWRQYXNzd29yZCIsInNjb3BlIjpbImZvbyIsInJlYWQiLCJ3cml0ZSJdfQ.A7madYf1pTzZUfQe68yS346aKesjXfhql9zHEl1jyrg";
		byte[] bytes = digest.digest(enStr.getBytes(StandardCharsets.UTF_8));
		String id = String.format("%032x", new BigInteger(1, bytes));
		System.out.println(id);;
	}

}