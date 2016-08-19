package com.adobe.dao.jdbc;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class ConfigReader {
	private static final String BUNDLE_NAME = "database"; //$NON-NLS-1$

	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);

	private ConfigReader() {
	}

	public static String getString(String key) {
		try {
			return RESOURCE_BUNDLE.getString(key);
		} catch (MissingResourceException e) {
			return '!' + key + '!';
		}
	}
}
