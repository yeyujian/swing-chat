package Dao;

public class debug {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		user a=new user();
		if(a.add("root","root")) {
			System.out.println("add OK");
		}else {
			System.out.println("add fail");
		}
		if(a.query("root","root")) {
			System.out.println("query OK");
		}		
		else {
			System.out.println("query fail");
		}
	}

}
