package com.lss.test.interfaceTest;

import java.util.Date;
import java.util.List;

public class FetchUserPositionListResponParam {
	
		public	int	errno;
		public 	String message;
		public	Body body;
		
		
		public class Body{
			public List<PositionList> positionList;
		}
		
		public class PositionList{
			   public int balanceId;
			   public String currency;
			   public String fundId;
			   public String fundChShortName;
			   public String mktVal;
			   public Date lastedProfitDate;
			   public double lastedProfit;
			   public double accumulateProfit;
		}
}




