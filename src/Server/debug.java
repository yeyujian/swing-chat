package Server;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import Dao.user;
import info.info;
public class debug {
	public  info someone;
	public static user userDao=new user();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	 debug d=new debug();
	 d.someone=new info();
	 d.someone.name="root";
	 d.someone.password="root";
	 try {
		if(d.login(serializeToString(d.someone))) {
			 System.out.println("hahahhahahha");
		 }
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
	}

    //序列化
    public static String serializeToString(Object obj) throws Exception{
        ByteArrayOutputStream byteOut = new ByteArrayOutputStream();  
        ObjectOutputStream objOut = new ObjectOutputStream(byteOut);  
        objOut.writeObject(obj);  
        String str = byteOut.toString("ISO-8859-1");
        return str;
    }
    //反序列化
    public static Object deserializeToObject(String str) throws Exception{
         ByteArrayInputStream byteIn = new ByteArrayInputStream(str.getBytes("ISO-8859-1"));  
         ObjectInputStream objIn = new ObjectInputStream(byteIn);  
         Object obj =objIn.readObject();  
         return obj;  
    }
    
	private boolean login(String msg) throws IOException,Exception{
		
		info s=(info)deserializeToObject(msg);
		System.out.println(s.name);
		System.out.println(s.password);
		if(userDao.query(s.name, s.password)) {
			return true;
		}
		else	return false;
	}
	
}
