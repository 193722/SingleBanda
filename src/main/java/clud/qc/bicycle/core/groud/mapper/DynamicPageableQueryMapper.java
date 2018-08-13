/*
 * www.yiji.com Inc.
 * Copyright (c) 2016 All Rights Reserved.
 */

/*
 * 修订记录：
 * woniu@yiji.com 2017年06月01日 12:00:48 创建
 */
package clud.qc.bicycle.core.groud.mapper;

import java.util.List;

import org.apache.ibatis.annotations.SelectProvider;
import clud.qc.bicycle.core.groud.param.BasePageableQueryParam;


public interface DynamicPageableQueryMapper<T,P extends BasePageableQueryParam>  {

	@SelectProvider(type = DynamicPageableQueryProvider.class, method = "dynamicSQL")
	List<T> dynamicPageableQuery(BasePageableQueryParam param);

	@SelectProvider(type = DynamicPageableQueryProvider.class, method = "dynamicSQL")
	Long dynamicPageableCountQuery(BasePageableQueryParam param);

}