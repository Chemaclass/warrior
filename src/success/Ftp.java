package success;

import home.Str;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;


public class Ftp{

	public final static String NAME = Str.ftp;
	public final static String HELP = Str.h_ftp;
	
	private static Ftp ftp=null;
	private static String user;
	private static String pass;
	private static String server;
	
	public static Map<String,String> help = new HashMap<String,String>();
	static{
		help.put(Str.user,	 	Str.h_user);
		help.put(Str.pass, 		Str.h_pass);
		help.put(Str.server, 	Str.h_server);
	}
	
	
	public static String getHelp(String key){
		return help.get(key);
	}
	
	public Ftp(){}
	
	public static Ftp getInstance(){
		if(ftp==null)ftp=new Ftp();
		return ftp;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		Ftp.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		Ftp.pass = pass;
	}

	public String getServer() {
		return server;
	}

	public void setServer(String server) {
		Ftp.server = server;
	}

	@Override
	public String toString() {
		return "Ftp [getUser()=" + getUser() + ", getPass()=" + getPass()
				+ ", getServer()=" + getServer() + "]";
	}

	public String getNotNull() {
		String s ="\n"+Str.ftp+":";
			if(server!=null)s+="\t"+Str.ftp+":"+server+"\n";
			if(user!=null)s+="\t"+Str.user+":"+user+"\n";
			if(pass!=null)s+="\t"+Str.pass+":"+pass+"\n";
		return s;
	}


	/**
	 * 
	 * @return all help of members
	 */
	public static String getHelps() {
		String s = "Help to Ftp:\n";
		Iterator<Entry<String, String>> it = help.entrySet().iterator();
		while(it.hasNext())
			s += Str.out + it.next()+"\n";
		return s;
	}


	
	
}
