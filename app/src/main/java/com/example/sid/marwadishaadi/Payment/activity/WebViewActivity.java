package com.example.sid.marwadishaadi.Payment.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.example.sid.marwadishaadi.Payment.utility.AvenuesParams;
import com.example.sid.marwadishaadi.Payment.utility.Constants;
import com.example.sid.marwadishaadi.Payment.utility.RSAUtility;
import com.example.sid.marwadishaadi.Payment.utility.ServiceHandler;
import com.example.sid.marwadishaadi.Payment.utility.ServiceUtility;
import com.example.sid.marwadishaadi.R;


import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EncodingUtils;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

public class WebViewActivity extends Activity {
	private ProgressDialog dialog;
	Intent mainIntent;
	static  String html, encVal="";
	protected ServiceHandler sh;
	
	@Override
	public void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		setContentView(R.layout.activity_webview);
		mainIntent = getIntent();
		
		// Calling async task to get display content
		 sh = new ServiceHandler();
		new RenderView().execute();
	}
	
	/**
	 * Async task class to get json by making HTTP call
	 * */
	private class RenderView extends AsyncTask<Void, Void, Void> {
		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			// Showing progress dialog
			dialog = new ProgressDialog(WebViewActivity.this);
			dialog.setMessage("Please wait...");
			dialog.setCancelable(false);
			dialog.show();
		}

		@Override
		protected Void doInBackground(Void... arg0) {
			// Creating service handler class instance


			// Making a request to url and getting response
			List<NameValuePair> params = new ArrayList<NameValuePair>();
			params.add(new BasicNameValuePair(AvenuesParams.ACCESS_CODE, mainIntent.getStringExtra(AvenuesParams.ACCESS_CODE)));
			params.add(new BasicNameValuePair(AvenuesParams.ORDER_ID, mainIntent.getStringExtra(AvenuesParams.ORDER_ID)));
	
			String vResponse = sh.makeServiceCall(mainIntent.getStringExtra(AvenuesParams.RSA_KEY_URL), ServiceHandler.POST, params);
			System.out.println("-----------------------------------------------------Ye kya hai----------------params--"+params.toString());
			if(!ServiceUtility.chkNull(vResponse).equals("") 
					&& ServiceUtility.chkNull(vResponse).toString().indexOf("ERROR")==-1){
				StringBuffer vEncVal = new StringBuffer("");
				vEncVal.append(ServiceUtility.addToPostParams(AvenuesParams.AMOUNT, mainIntent.getStringExtra(AvenuesParams.AMOUNT)));
				vEncVal.append(ServiceUtility.addToPostParams(AvenuesParams.CURRENCY, mainIntent.getStringExtra(AvenuesParams.CURRENCY)));
				encVal = RSAUtility.encrypt(vEncVal.substring(0,vEncVal.length()-1), vResponse);
				Log.e(TAG, "doInBackground: -------------me----------"+vEncVal.substring(0,vEncVal.length()-1)+"---------------------------------------------------------------------------"+vResponse);
			}
			
			return null;
		}

		@Override
		protected void onPostExecute(Void result) {
			super.onPostExecute(result);
			// Dismiss the progress dialog
			if (dialog.isShowing())
				dialog.dismiss();
			
			@SuppressWarnings("unused")
			class MyJavaScriptInterface
			{
				@JavascriptInterface
			    public void processHTML(String html)
			    {
			        // process the html as needed by the app
					Log.e(TAG, "processHTML: -------------------"+html.toString());
					String status = null;
			    	if(html.indexOf("Failure")!=-1){
			    		status = "Transaction Declined!";
			    	}else if(html.indexOf("Success")!=-1){
			    		status = "Transaction Successful!";
			    	}else if(html.indexOf("Aborted")!=-1){
			    		status = "Transaction Cancelled!";
			    	}else{
			    		status = "Status Not Known!";
			    	}
			    	//Toast.makeText(getApplicationContext(), status, Toast.LENGTH_SHORT).show();
			    	Intent intent = new Intent(getApplicationContext(),StatusActivity.class);
					intent.putExtra("transStatus", status);
					startActivity(intent);
			    }
			}
			
			final WebView webview = (WebView) findViewById(R.id.webview);
			webview.getSettings().setJavaScriptEnabled(true);
			webview.addJavascriptInterface(new MyJavaScriptInterface(), "HTMLOUT");
			webview.setClickable(true);

			webview.setWebViewClient(new WebViewClient(){
				@Override  
	    	    public void onPageFinished(WebView view, String url) {
	    	        super.onPageFinished(webview, url);
                    Log.i(TAG, "onPageFinished: -----------------------------------"+  url);
                    if(url.indexOf("/ccavResponseHandler.php")!=-1){

						webview.loadUrl("javascript:window.HTMLOUT.processHTML('<head>'+document.getElementsByTagName('html')[0].innerHTML+'</head>');");

	    	        }
	    	    }
	    	    @Override
	    	    public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
	    	        Toast.makeText(getApplicationContext(), "Oh no! " + description, Toast.LENGTH_SHORT).show();
	    	    }

				@Override
				public void onPageStarted(WebView view, String url, Bitmap favicon) {
					super.onPageStarted(view, url, favicon);
					Log.e(TAG, "onPageStarted: --------- url is ----------"+url);
				}
			});
			
			/* An instance of this class will be registered as a JavaScript interface */
			StringBuffer params = new StringBuffer();
			params.append(ServiceUtility.addToPostParams(AvenuesParams.ACCESS_CODE,mainIntent.getStringExtra(AvenuesParams.ACCESS_CODE)));
			params.append(ServiceUtility.addToPostParams(AvenuesParams.MERCHANT_ID,mainIntent.getStringExtra(AvenuesParams.MERCHANT_ID)));
			params.append(ServiceUtility.addToPostParams(AvenuesParams.ORDER_ID,mainIntent.getStringExtra(AvenuesParams.ORDER_ID)));

			params.append(ServiceUtility.addToPostParams(AvenuesParams.REDIRECT_URL,mainIntent.getStringExtra(AvenuesParams.REDIRECT_URL)));
			params.append(ServiceUtility.addToPostParams(AvenuesParams.CANCEL_URL,mainIntent.getStringExtra(AvenuesParams.CANCEL_URL)));

			params.append(ServiceUtility.addToPostParams(AvenuesParams.ENC_VAL,URLEncoder.encode(encVal)));
			params.append(ServiceUtility.addToPostParams(AvenuesParams.BILLING_CUST_NAME,"Nirmal"));
			params.append(ServiceUtility.addToPostParams(AvenuesParams.BILLING_CUST_EMAIL,"nirmalsarswat400@gmail.com"));
			params.append(ServiceUtility.addToPostParams(AvenuesParams.BILLING_CUST_ADDRESS,"IIT Roorkee"));
			params.append(ServiceUtility.addToPostParams(AvenuesParams.BILLING_ZIP,"247667"));
			params.append(ServiceUtility.addToPostParams(AvenuesParams.BILLING_CUST_CITY,"Roorkee"));
			params.append(ServiceUtility.addToPostParams(AvenuesParams.BILLING_CUST_STATE,"UK"));
			params.append(ServiceUtility.addToPostParams(AvenuesParams.BILLING_CUST_COUNTRY,"India"));
			params.append(ServiceUtility.addToPostParams(AvenuesParams.BILLING_CUST_MOBILE,"8006467951"));

			String vPostParams = params.substring(0,params.length()-1);
			try {
				Log.e(TAG, "onPostExecute: ----------- encoded url is ----"+Constants.TRANS_URL+" ------------------ post codes are --------"+ vPostParams);

                params.setLength(0);
                Log.e(TAG, "onPostExecute: ------------- length is"+params.length()+"----"+params.toString() );
                webview.postUrl(Constants.TRANS_URL, EncodingUtils.getBytes(vPostParams, "UTF-8"));
			} catch (Exception e) {
				showToast("Exception occured while opening webview.");
			}
		}
	}
	
	public void showToast(String msg) {
		Toast.makeText(this, "Toast: " + msg, Toast.LENGTH_LONG).show();
	}
} 