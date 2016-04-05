package com.academic.application.utils;

import java.util.Collections;

public class CollectionUtility {

	public static <T> Iterable<T> emptyIfNull(Iterable<T> iterable) {
		return iterable == null ? Collections.<T> emptyList() : iterable;
	}

}
