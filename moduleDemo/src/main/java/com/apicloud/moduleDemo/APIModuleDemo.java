package com.apicloud.moduleDemo;

import android.app.Activity;
import android.content.Intent;

import com.apicloud.moduleDemo.utlis.JsParamsUtil;
import com.apicloud.moduleDemo.zxing.CaptureActivity;
import com.uzmap.pkg.uzcore.UZWebView;
import com.uzmap.pkg.uzcore.uzmodule.UZModule;
import com.uzmap.pkg.uzcore.uzmodule.UZModuleContext;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * 该类映射至Javascript中moduleDemo对象<br><br>
 * <strong>Js Example:</strong><br>
 * var module = api.require('moduleDemo');<br>
 * module.xxx();
 * @author APICloud
 *
 */
public class APIModuleDemo extends UZModule{

	public static UZModuleContext mModuleContext;
	public final int OPEN_CODE = 100;
	private JsParamsUtil mJsParamsUtil;

	public APIModuleDemo(UZWebView webView) {
		super(webView);
	}

	public void jsmethod_open(UZModuleContext moduleContext) {
		mModuleContext = moduleContext;
		mJsParamsUtil = JsParamsUtil.getInstance();
		Intent intent = new Intent(getContext(), CaptureActivity.class);
		startActivityForResult(this, intent, OPEN_CODE);
	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (resultCode == Activity.RESULT_OK) {
			switch (requestCode) {
				case OPEN_CODE:
					String result = "";
					if(null != data){
						result = data.getStringExtra("result");
						openCallback(result);
					} else {
					}

					break;
			}
		}
	}

	private void openCallback(String result) {
		JSONObject object = new JSONObject();
		try {
			object.put("content", result);
			mModuleContext.success(object, false);
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
}
