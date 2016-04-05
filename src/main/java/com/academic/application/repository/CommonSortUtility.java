/**
 * 
 */
package com.academic.application.repository;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.util.StringUtils;

/**
 * @author Vishnu Awasthi
 * @since 2016-03-12
 * 
 *
 */
public class CommonSortUtility {

	public static Pageable createPageRequest(int page, int size, Sort sort) {
		return new PageRequest(page, size, sort);
	}

	/**
	 * This method returns Sort object based on the parameters given, If any of
	 * the parameter is NULL, default sort will be returned,i.e by id as ASC.
	 * 
	 * @param order
	 *            , Sort order either ASC or DESC
	 * @param columnName
	 *            , is the name of column in which sort will be done.
	 * @return
	 */
	public static Sort sort(String order, String columnName) {
		if (!StringUtils.isEmpty(order) && !StringUtils.isEmpty(columnName)) {
			return new Sort(Sort.Direction.valueOf(order.toUpperCase()), columnName);
		}
		return new Sort(Sort.Direction.ASC, "id");

	}

}
