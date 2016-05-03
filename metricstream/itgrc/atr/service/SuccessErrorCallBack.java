package com.metricstream.itgrc.atr.service;

import com.metricstream.appstudio.cif.Response;
import com.metricstream.appstudio.cif.handlers.ErrorCallBack;
import com.metricstream.appstudio.cif.handlers.SuccessCallBack;
import com.metricstream.log.Logger;

public class SuccessErrorCallBack implements SuccessCallBack,ErrorCallBack{

	public void onError(Throwable arg0, String arg1) {
		Logger.error("onError", "messgae:"+arg1, arg0);
	}

	public void onSuccess(Response arg0) {
		Logger.error("onSuccess", "response::"+arg0.getStatus(), null);
		
	}

}
