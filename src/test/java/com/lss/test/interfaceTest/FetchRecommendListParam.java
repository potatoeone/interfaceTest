package com.lss.test.interfaceTest;

import java.util.List;

/**
 * FetchRecommendList接口的返回值
 * 返回的结果中，{}则定义为一个类，[]则代表内容是数组，则定义成一个list
 *  双引号的就是字符串（如果是日期格式，就用Date类型），没双引号的就是int或者float。
 */

public class FetchRecommendListParam {
	public int errno;
	public String message;
	public Body body;

	
	public static class Body{
		
		public List<RecommendList> recommendList;
		
	}
	
	public static class RecommendList{
		public RecommendInfo recommendInfo;
		public List<FundList> fundlist;
		
	}
	
	public static class FundList{
		public String currency;
		public int displayMode;
		public String goPageUrl;
		public double expectYield;
		public String expect_yield_desc;
		public String fundChShortName;
		public String fundIconUrl;
		public String rcmdIconUrl;
		public int fundId;
		public int minSubAmount;
		public String sellPoint;
		public String tag;
		public String termType;
		public int termValue;
		public String tradeDesc;
		
	}
	
	public static class RecommendInfo{
		public String id;
		public String name;
		public String describe;
	}
	
	
	

}
