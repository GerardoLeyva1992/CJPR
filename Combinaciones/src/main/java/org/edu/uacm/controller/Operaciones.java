package org.edu.uacm.controller;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import javax.ws.rs.core.MultivaluedMap;
import javax.xml.rpc.ServiceException;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;

import process.RestaServiceLocator;
import process.RestaSoapBindingStub;

public class Operaciones {
	
	  public static void main(String[] args){
		  Operaciones a=new Operaciones();
		  //int x=3,y=3;
		  //System.out.println("Hola soy Java y estoy en mi casa y hago una resta "+"con x: "+x+" y con y: "+y +" Resultado: "+a.restaJava(x, y));
		  //System.out.println("Hola soy R y soy invitado en java y hago una multiplicacion " + "con x: "+x+" y con y: "+y +" Resultado: "+a.multiplicacionR(x, y));
		  //System.out.println("Hola soy Python y soy invitado en java y hago una division "+  "con x: "+x+" y con y: "+y +" Resultado: "+a.divisionPython(x, y));
		  a.divisionCplus();
		  
	  }

	   
	   public  void divisionCplus(){
		   Client client = Client.create();
		   WebResource webResource = client.resource("http://localhost:5003/suma/suma?a=1&b=2");
		   //MultivaluedMap<String, String> queryParams = new MultivaluedMapImpl();
		   //queryParams.add("a", numberone);
		   //queryParams.add("b", numbertwo);
		   String s = webResource.get(String.class);	
		   System.out.println(s);		 
	   }	
	
	   
	   public int multiplicacionR(int numberone,int numbertwo){
		   Client client = Client.create();		  
		   WebResource webResource = client.resource("http://localhost:8000/mul");
		   MultivaluedMap<String, String> queryParams = new MultivaluedMapImpl();
		   queryParams.add("a", Integer.toString(numberone));
		   queryParams.add("b", Integer.toString(numbertwo));
		   String s = webResource.queryParams(queryParams).get(String.class);	
		   int x = Character.getNumericValue(s.charAt(1));
		   return x;
	   }

	   
	   public int divisionPython(int numberone,int numbertwo){
		   Client client = Client.create();
		   WebResource webResource = client.resource("http://localhost:5000/div"+"/"+Integer.toString(numberone)+"/"+Integer.toString(numbertwo));
		   String s = webResource.get(String.class);	
		 //  System.out.println(s);
		   int x = Character.getNumericValue(s.charAt(0));
		   return x;
	   }
	   
	   public int restaJava(int x,int y){
		   RestaSoapBindingStub a=null;
		   int z=0;
			try {
				a=(RestaSoapBindingStub) new RestaServiceLocator().getResta(new URL("http://localhost:8080/servico/services/Resta"));
			} catch (MalformedURLException | ServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
					//Suma en java
				z=a.opeResta(x, y);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			return z;
	   }
}
