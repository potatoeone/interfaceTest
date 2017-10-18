package com.lss.test.interfaceTest;

import static io.restassured.RestAssured.*;


import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;


import org.testng.annotations.*;

import com.lss.test.interfaceTest.Result.Topic;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TestTwo {

	@BeforeClass
	public void beforeClass() {
		RestAssured.useRelaxedHTTPSValidation();
		RestAssured.baseURI="https://testerhome.com";
		
		}
	
	@Test
	public void getTesterHomeDemo() {
		
		//发起get请求，返回Response对象（对请求响应结果对封装，以及提供一些对响应结果对处理方法）
		Response response = get("/api/v3/topics.json");
		//response对象，会将响应body（Json格式字符串），转为result对象
		Result result = response.as(Result.class);
		//通过对象.字段名来取值
		List<Topic> topic = result.topics;
		//定一个空数组，用来存放精华帖子
		List<Topic> excellents = new ArrayList<Topic>();
		//for循环，第一个;表示定义一个变量i，第二个;表示循环对条件，不满足则结束循环，第三个;表示一次循环后对操作，对i加1（i = i + 1）
		for(int i=0;i<topic.size();i++) {
			//取值，存到topic对象内，获取数组中下标为i的元素(帖子
			Topic topics = topic.get(i);
			
			if(topics.excellent == 1) {//如果帖子是精华贴
				excellents.add(topics);//将精华帖放入excellents数组中
			}
		}
		
		//断言excellents元素数大于4，即：精华帖数量大于4
		assertTrue(excellents.size()>4);
		  
	}
	
}
