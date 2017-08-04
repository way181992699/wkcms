package andorid.test;
//

//                       _oo0oo_
//                      o8888888o
//                      88" . "88
//                      (| -_- |)
//                      0\  =  /0
//                    ___/`---'\___
//                  .' \\|     |// '.
//                 / \\|||  :  |||// \
//                / _||||| -:- |||||- \
//               |   | \\\  -  /// |   |
//               | \_|  ''\---/''  |_/ |
//               \  .-\__  '-'  ___/-. /
//             ___'. .'  /--.--\  `. .'___
//          ."" '<  `.___\_<|>_/___.' >' "".
//         | | :  `- \`.;`\ _ /`;.`/ - ` : | |
//         \  \ `_.   \_ __\ /__ _/   .-` /  /
//     =====`-.____`.___ \_____/___.-`___.-'=====
//                       `=---='
//
//
//     ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//
//               佛祖保佑         永无BUG
//
//
//

import okhttp3.*;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Description
 * <p>
 * Created by zcm on 2017/7/28. version 1.0
 */

public class AndroidTest {

	public void connet(String url, Map<String, Object> params, int type) {

		OkHttpClient okHttpClient = new OkHttpClient();
		Request.Builder builder = new Request.Builder();
		builder.addHeader("User-Agent", "app_android");
		builder.addHeader("Accent-Token", "FD4524DBB77DD8D377E7F64BEB37281E");
		builder.url(url);
		switch (type) {
		case 0: {
			builder.get();
			break;
		}
		case 1: {
			FormBody.Builder form = new FormBody.Builder();
			for (String key : params.keySet()) {
				form.add(key, params.get(key).toString());
			}
			builder.post(form.build());
			break;
		}
		}
		Call call = okHttpClient.newCall(builder.build());
		try {
			Response response = call.execute();
			System.out.println(response.body().string());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void post(String url, Map<String, Object> params) {
		connet(url, params, 1);
	}

	public void get(String url) {
		connet(url, null, 0);
	}

	@Test
	public void login() {
		String url = "http://localhost:8080/wkcms-web/user/login?userName=admin&password=123456";
		get(url);
	}

	@Test
	public void index() {
		String url = "http://localhost:8080/wkcms-web/";
		get(url);
	}

	@Test
	public void createArticle() {
		String url = "http://localhost:8080/wkcms-web/article/add";
		Map<String, Object> params = new HashMap<>();
		params.put("title", "哈哈哈哈");
		params.put("subtitle", "呵呵呵呵呵呵");
		params.put("document", "阿斯达数量达到拉对啦对啦大时代");
		post(url, params);
	}

}
