package com.lss.test.interfaceTest;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.testng.annotations.Test;

public class RegisterTest {
	
	List<String> phones = Arrays.asList("15800000012","15800000013","15800000014","15800000015","15800000016","15800000017","15800000018","15800000019","15800000020","15800000021");
	
	@Test
	public void register() throws InterruptedException {
		
		//10个线程
		for (int i = 0; i < phones.size(); i++) {
			final int temp = i; 
			new Thread(){
				
				public void run() {
					RegisterParam registerParam = new RegisterParam();
					registerParam.user_name =  phones.get(temp);
					String md5Pwd = DigestUtils.md5Hex(registerParam.password);
					registerParam.password = md5Pwd;
					GetUserRcaptcha.getcaptcha(registerParam.user_name);
					
					given()
						.log().all()
						//.header("Content-type"," application/json")
						//.header("Accept","application/json")//返回的结果的content-type设置为json
						.param("region_code", registerParam.region_code)
						.param("user_name", registerParam.user_name)
						.param("password", registerParam.password)
						.param("captcha",registerParam.captcha)
						.param("channel_id", registerParam.channel_id)
					.when()
						.post("http://shitouji.bluestonehk.com/api/user/register")
					.then()
					.log().all()
					.statusCode(200);
					
				}
			}.start();
			Thread.sleep(1000 * 10);
		}
		
		
			
	}

}
