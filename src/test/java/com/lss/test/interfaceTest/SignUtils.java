package com.lss.test.interfaceTest;


import com.bluestone.commons.common.Constants;
import com.bluestone.commons.crypto.SHA1Coding;
import com.bluestone.commons.util.SoftHashMap;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * 参数签名工具类
 */
public final class SignUtils {
	private static final Logger logger = LoggerFactory.getLogger(SignUtils.class);

	private SignUtils() {
		super();
	}

	private static SoftHashMap<String, String> lru = new SoftHashMap<String, String>(500);

	/**
	 * 生成签名
	 *
	 * @param paramValues
	 *            参数列表
	 * @param secret
	 * @return
	 */
	public static String sign(Map<String, String> paramValues, String secret) {
		return sign(paramValues, null, secret);
	}

	@SuppressWarnings("unchecked")
	public static String sign(Object paramValues, String secret) {
		if(paramValues instanceof Map) {
			return sign((Map<String, String>)paramValues, null, secret);
		}
		Map<String, String> map;
		try {
			map = BeanUtils.describe(paramValues);
		} catch (Exception e) {
			return null;
		}
		return sign(map, null, secret);
	}
	
	/**
	 * 生成签名，其中ignoreParamNames这些参数不参与签名
	 *
	 * @param paramValues
	 * @param ignoreParamNames
	 * @param secret
	 * @return
	 */
	public static String sign(Map<String, String> paramValues, List<String> ignoreParamNames, String secret) {
		try {
			StringBuilder sb = new StringBuilder();
			List<String> paramNames = new ArrayList<String>(paramValues.size());
			paramNames.addAll(paramValues.keySet());
			if (ignoreParamNames != null && ignoreParamNames.size() > 0) {
				for (String ignoreParamName : ignoreParamNames) {
					paramNames.remove(ignoreParamName);
				}
			}
			Collections.sort(paramNames);

			sb.append(secret);
			for (String paramName : paramNames) {
				sb.append(paramName).append(paramValues.get(paramName));
			}
			sb.append(secret);

			String key = sb.toString();
			String value = lru.get(key);
			if (value != null) {
				return value;
			}
			value = SHA1Coding.encode2HexStr(key, Constants.UTF8);
			lru.put(key, value);

			return value;
		} catch (Exception e) {
			logger.error("签名生成失败.", e);
			return "";
		}
	}
}
