package main;

import WS.*;
import javax.xml.ws.*;
public class testMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Endpoint.publish("http://localhost:1248/ws/acount", new AcountWSImpl());
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

}
