package com.lss.test.interfaceTest;

import java.util.Date;
import java.util.List;

public  class  FetchUserPositionListResponParam {
	
		public	int	errno;
		public 	String message;
		public	Body body;
		
		
		public static class Body{
			public List<PositionList> positionList;
		}
		
		public static class PositionList{
			   public int balanceId;	//余额id
			   public String currency; 	// 币种（HKD - 港币（默认），USD - 美元）
			   public String fundId;   	//基金id
			   public String fundChShortName;  //基金名称
			   public String mktVal;	//	持仓市值
			   public String lastedProfitDate;	//最新收益日期
			   public double lastedProfit;		//最新收益
			   public double accumulateProfit;	//累计收益
			   public String availableUnits;
			   public int costAmount;
			   public double divAmount;
			   public String frozenUnits;
			   public double holdUnits;
			   public String navDate;
			   public  double sellAmount;
			   public double unconfirmedAmount;
			   public double unitNav;
			   
			   
		}
}




