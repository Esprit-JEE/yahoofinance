package tn.esprit;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

/**
 * @author Walid-YAICH
 * 
 * URL de yahoo :
 * https://developer.yahoo.com/yql/console/?q=show%20tables&env=store://datatables.org/alltableswithkeys#h=select+*+from+yahoo.finance.xchange+where+pair+in+(%22USD%22%2C+%22EUR%22)
 * 
 * http://theoryapp.com/parse-json-in-java/
 * https://jsonformatter.curiousconcept.com/
 * 
 * 
 * Sans Maven:
 * utiliser un IDE
 * Ajouter manuellement httpclient-4.1.1.jar et json-20160810.jar et leur dépendances si nécessaire -- bonne chance :)
 *
 * 
 * Avec Maven
 * mvn clean compile exec:java
 *
 */

public class YahooFinance {

	public static void main(String[] args) {
		String restYahooQuery = "https://query.yahooapis.com/v1/public/yql?"
				+ "q=select%20*%20from%20yahoo.finance.xchange%20"
				+ "where%20pair%20in%20(%22USD%22%2C%20%22EUR%22)&"
				+ "format=json&diagnostics=true"
				+ "&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys&callback=";

		HttpClient client = new DefaultHttpClient();
		HttpGet request = new HttpGet(restYahooQuery);
		try {
			HttpResponse response = client.execute(request);
			String jsonResponse = EntityUtils.toString(response.getEntity());
			JSONObject responseObj = new JSONObject(jsonResponse);
			
			JSONObject rate = responseObj.getJSONObject("query").getJSONObject("results")
					.getJSONArray("rate").getJSONObject(1);
					
			System.out.println("/*****************************************/");
			System.out.println(rate.getString("Name"));
			System.out.println("ask : " + rate.getString("Ask"));
			System.out.println("bid : " + rate.getString("Bid"));
			System.out.println(rate.getString("Date") + "  " + rate.getString("Time"));
			System.out.println("/*****************************************/");


		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
