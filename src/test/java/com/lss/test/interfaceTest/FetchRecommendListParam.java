package com.lss.test.interfaceTest;

public class FetchRecommendListParam {
	public int errno;
	public String message;
	public Body body;

	
	public static class Body{
		public FundList fundlist;
		public RecommendList recommendList;
		
	}
	
	public static class RecommendList{
		public RecommendInfo recommendInfo;
		
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
