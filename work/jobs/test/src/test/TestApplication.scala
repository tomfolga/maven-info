package test;

import org.apache.http.HttpVersion;
import org.apache.http.client.methods._
import org.apache.http.client.ResponseHandler 
import org.apache.http.impl.client.BasicResponseHandler
import org.apache.http.impl.client.DefaultHttpClient

object TestApplication {
  def main(args : Array[String]) : Unit = {
     getPage
  }
 
 
  def getPage = { 
	  val httpclient = new DefaultHttpClient

	  val httpget = new HttpGet("http://twitter.com/tomfolga");
	  val reponseHandler : ResponseHandler[String] = new BasicResponseHandler
	  val httpresponse : String = httpclient.execute[String](httpget, reponseHandler );
 
	  httpclient.getConnectionManager().shutdown()
	  Console.println(httpresponse)
  }
}
