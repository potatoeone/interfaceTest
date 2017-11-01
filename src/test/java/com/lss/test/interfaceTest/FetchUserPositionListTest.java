package com.lss.test.interfaceTest;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matcher.*;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertTrue;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import com.lss.test.interfaceTest.FetchUserPositionListResponParam.PositionList;

import io.restassured.response.Response;

public class FetchUserPositionListTest extends GlobalSessionTest {
	public PositionList positionLists;

	@Test
	public void fetchUserPositionList() {

		Response response = 
				given()
					.log().all()
					.header("QUARTZ-SESSION", session).header("SIGN", sign())
					.header("Content-type", " application/json")
					.header("Accept", "application/json")// 返回的结果的content-type设置为json

				.when()
					.post("http://shitouji.bluestonehk.com:6064/fund/position/fetchUserPositionList")

				.then()
					.log().all()
					.statusCode(200)
					.body("errno", equalTo(0)).extract()
					.response();

		FetchUserPositionListResponParam result = response.as(FetchUserPositionListResponParam.class);
		List<PositionList> positionList = result.body.positionList;
		HashMap balance = new HashMap();
		if (result.body != null) {
			for (int i = 0; i < positionList.size(); i++) {
				positionLists = positionList.get(i);

				if (balance.containsKey(positionLists.balanceId)) {
				
					System.out.println("有重复持仓记录；");
				} else {
					balance.put(positionLists.balanceId, positionLists);

				}
			}
		}
		System.out.println("=====>" + balance);
		assertTrue(!balance.containsKey(positionLists.balanceId));
		

	}

}
