package home;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;

import member.Help;
import success.Core;
import success.Ftp;
import warrior.MemberSuccess;
import warrior.Warrior;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class Home {

	/**
	 * The Home to form the MemberSucces ms
	 */
	static Home home;
	
	/**
	 * This object will contain all the values ​​that our warrior
	 */
	private static MemberSuccess ms;
	
	/**
	 * To write to console
	 */
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	/**
	 * All values collections of members
	 */
	private static Collection<Entry<String, Map<String,String>>> membersList;
	
	/**
	 * Converts the collection to a list to cross it
	 */
	public Home(){
		HashMap<String,Map<String,String>> members = new HashMap<String,Map<String,String>>();
		ms = new MemberSuccess();
		
		init(members);
		Iterator<Entry<String, Map<String, String>>> membersIterator = members.entrySet().iterator();
		// membersIterator to membersList
		membersList = new ArrayList();
		while(membersIterator.hasNext()){
			Entry<String, Map<String, String>> entry = membersIterator.next();			
			membersList.add(entry);
		}
	}
	
	/**
	 * Initialize all values
	 * @param members
	 */
	private void init(Map<String,Map<String,String>> members){
		
		members.put(Str.help,new HashMap<String,String>());
		
		//
		members.get(Str.help).put(Str.clean,Str.h_clean);
		members.get(Str.help).put(Str.show,Str.h_show);
		members.get(Str.help).put(Str.help,Str.h_help);
		//
		//members.get(Str.help).put(Str._,Str.clean_all);
		
		
		//FTP 
		members.put(Str.ftp,new HashMap<String,String>());
		members.get(Str.help).put(Str.ftp,Ftp.HELP);
		//Ftp Pass
		members.get(Str.ftp).put(Str.pass,Str.empty);
		members.get(Str.help).put(Str.ftp+"."+Str.pass,Ftp.getHelp(Str.pass));
		//Ftp User
		members.get(Str.ftp).put(Str.user,Str.empty);
		members.get(Str.help).put(Str.ftp+"."+Str.user,Ftp.getHelp(Str.user));
		//Ftp Server
		members.get(Str.ftp).put(Str.server,Str.empty);
		members.get(Str.help).put(Str.ftp+"."+Str.server,Ftp.getHelp(Str.server));
		
		//CORE 
		members.put(Str.core,new HashMap<String,String>());
		members.get(Str.help).put(Str.core,Core.HELP);
		//name
		members.get(Str.core).put(Str.name,Str.empty);
		members.get(Str.help).put(Str.core +"."+Str.name,Core.getHelp(Str.name));
		//path
		members.get(Str.core).put(Str.path,Str.empty);
		members.get(Str.help).put(Str.core +"."+Str.path,Core.getHelp(Str.path));
		//Search
		members.get(Str.core).put(Str.search,Str.empty);
		members.get(Str.help).put(Str.core +"."+Str.search,Core.getHelp(Str.search));
		//send		
		members.get(Str.core).put(Str.send,Str.empty);
		members.get(Str.help).put(Str.core +"."+Str.send,Core.getHelp(Str.send));
		//see	
		members.get(Str.core).put(Str.see, Str.empty);
		members.get(Str.help).put(Str.core +"."+Str.see,Core.getHelp(Str.see));
		//remove	
		members.get(Str.core).put(Str.remove,Str.empty);
		members.get(Str.help).put(Str.core +"."+Str.remove,Core.getHelp(Str.remove));
		//Write	
		members.get(Str.core).put(Str.write, Str.empty);
		members.get(Str.help).put(Str.core +"."+Str.write,Core.getHelp(Str.write));
		
	}
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		
		System.out.println(Str.out+"Beta:W-0.5 by Author:NMChema (Type 'help' for more help)");
		home = new Home();
		
		String s = "";
		String[] buffer;
		while(!s.equals(Str.exit))
		try{			
			System.out.print(Str.in);
			s = br.readLine();
			StringTokenizer  st = new StringTokenizer(s);
			
			buffer = new String[st.countTokens()];
			for(int i =0;st.hasMoreTokens();i++){
				buffer[i] = st.nextToken();
			}
			
			//
			ms =loadBuffer(ms,buffer);
			if(ms.getFtp()!=null || ms.getCore()!=null)			
				new Warrior(ms).run();
			
		}catch(Exception ex){
		   System.out.println(Str.out+"Exception:" +ex.getMessage());
		   ex.printStackTrace();
	   }
		System.out.println(Str.out+"Bye!");
	}
	
	/**
	 * 
	 * @param ms
	 * @param buffer
	 * @return
	 */
	private static MemberSuccess loadBuffer(MemberSuccess ms,String[] buffer){
		// We decompose the buffer
		for(String kBuffer: buffer){
			int first = (kBuffer.contains(".")?kBuffer.indexOf("."):kBuffer.length());
			int second = (kBuffer.contains(":")?kBuffer.indexOf(":"):kBuffer.length());
			
			String keyBuffer = kBuffer.substring(0,first);// ej: core.
			String key2Buffer="",valueBuffer="";
			if(first!=kBuffer.length()){
				key2Buffer = kBuffer.substring(first+1,second);// ej: core.name:
				if(second!=kBuffer.length())
					valueBuffer = kBuffer.substring(second+1);// ej: core.name:nombre	
			}
			
			// Show all the help of values ​​of the members
			if(keyBuffer.equals(Str.help) && key2Buffer.length()==0){			
				System.out.println(ms.getHelps(Str.all));
				break;
			}
			
			// Check the short commands ej: 
			//-n(name) -p(path) -r(remove) -c(search) -s(see) -d(send) -w(write)
			String strCheck = checks(keyBuffer);
			
			if(strCheck.equals(Str._continue))
				continue;
			else if(strCheck.equals(Str._break))
				break;
			
			// We go through every member
			for(Entry<String, Map<String, String>> entry: membersList){
				
				String key = entry.getKey();
				
				// Compare keys
				if(key.equals(keyBuffer)){ // (help|core|ftp) ej: core == help (F), core == core (T) 
					
					// Etracts the resulting map with that key
					Map<String, String> value = entry.getValue();					
					Iterator<Entry<String, String>> membersIterator2 = value.entrySet().iterator();
					
					// and iterate among their keys
					while(membersIterator2.hasNext()){
						
						Entry<String, String> entry2 = membersIterator2.next();
					
						String key2 = entry2.getKey(); // core,ftp,name,path,see,remove,...
						// Compare keys2
						if(key2.equals(key2Buffer)){// core,ftp,name,path,see,remove,...
							//help
							if(key.equals(Str.help)){
								String value2 = entry2.getValue();
								String s="";
								if(valueBuffer==""){
									System.out.println(Str.success +key+"."+key2+":: "+value2);
									System.out.println(ms.getHelps(key2));
								}else if((s = Help.getHelp(key2,valueBuffer)) != null){
									System.out.println(Str.success + key+"."+key2+"."+valueBuffer
											+": " + s + "\n");
								}
							}
							//else
							else{
								System.out.println(Str.success + key+"."+key2+":"+valueBuffer);
								//shape=modelar/dar forma
								shapeMembers(ms,key,key2,valueBuffer);
							}
						}
					}
				}
			}
		} 
		return ms;
	}	

	/**
	 * 
	 * @param ms
	 * @param key
	 * @param key2
	 * @param value2
	 */
	private static void shapeMembers(MemberSuccess ms,String key, String key2, String value2) {
		switch(key){
		case Ftp.NAME:
			//
			if(ms.getFtp()==null)ms.setFtp(Ftp.getInstance());
			//
			switch(key2){
				case Str.user:
					ms.getFtp().setUser(value2);
					break;
				case Str.pass:
					ms.getFtp().setPass(value2);
					break;
				case Str.server:
					ms.getFtp().setServer(value2);
					break;	
			}
			break;
		case Core.NAME:
			//
			if(ms.getCore()==null)ms.setCore(Core.getInstance());
			//
			switch(key2){				
				case Str.name:
					ms.getCore().setName(value2);
					break;
				case Str.path:
					ms.getCore().setPath(value2);
					break;
				case Str.search:
					ms.getCore().setSearch(value2);
					break;
				case Str.send:
					ms.getCore().setSend(value2);
					break;
				case Str.see:
					ms.getCore().setSee(value2);
					break;
				case Str.write:
					ms.getCore().setWrite(value2);
					break;
				case Str.remove:
					ms.getCore().setRemove(value2);
					break;
				/*case Str.find:
					ms.getCore().setFind(value2);
					break;*/	
			}
			break;		
		}		
	}
	
	/**
	 * 
	 * @param keyBuffer
	 * @return
	 */
	private static String checks(String keyBuffer){		
		
		Core c = ms.getCore() != null ? ms.getCore() : null;
		boolean isCoreNull=false;
		if(c!=null){
			isCoreNull = //c.getFind()==null&& 
					c.getName()==null 
					&& c.getPath()==null	&& c.getRemove()==null
					&& c.getSearch()==null	&& c.getSee()==null
					&& c.getSend()==null  	&& c.getWrite()==null;
		}
		if(isCoreNull||c==null)ms.setCore(null);
		
		
		// Clean all values ​​of the members
		if(keyBuffer.equals(Str.clean)){	
			ms = new MemberSuccess();
			home = new Home();
			return Str._break;
		}
		// Show all the values ​​of the members
		else if(keyBuffer.equals(Str.show)){
			System.out.println((ms!=null)?ms.toString():Str.empty);
			//return Str._continue;
		}
		
		// Check the short commands		
		// -a = all
		// -n = name
		if(keyBuffer.equals(Str._n) || keyBuffer.equals(Str._a)){
			// To not accidentally name
			if(ms.getCore()!=null && ms.getCore().getName()!=null)
				ms.getCore().setName(null);
			if(isCoreNull)ms.setCore(null);
		
			if(!keyBuffer.equals(Str._a))return Str._continue;
		}
		// -p = path
		if(keyBuffer.equals(Str._p) || keyBuffer.equals(Str._a)){
			// To not accidentally path
			if(ms.getCore()!=null && ms.getCore().getPath()!=null) 
				ms.getCore().setPath(null); 
			
			if(isCoreNull)ms.setCore(null);			
			if(!keyBuffer.equals(Str._a))return Str._continue;
		}
		// -r = remove
		if(keyBuffer.equals(Str._r) || keyBuffer.equals(Str._a)){
			// To not accidentally remove
			if(ms.getCore()!=null && ms.getCore().getRemove()!= null)
				ms.getCore().setRemove(null); 
			
			if(isCoreNull)ms.setCore(null);			
			if(!keyBuffer.equals(Str._a))return Str._continue;
		}
		// -c = search
		if(keyBuffer.equals(Str._c) || keyBuffer.equals(Str._a)){
			// To not accidentally see
			if(ms.getCore()!=null && ms.getCore().getSearch()!=null)					
				ms.getCore().setSearch(null);
			
			if(isCoreNull)ms.setCore(null);			
			if(!keyBuffer.equals(Str._a))return Str._continue;
		}
		// -s = see
		if(keyBuffer.equals(Str._s) || keyBuffer.equals(Str._a)){
			// To not accidentally see
			if(ms.getCore()!=null && ms.getCore().getSee()!=null)
				ms.getCore().setSee(null);
			
			if(isCoreNull)ms.setCore(null);
			if(!keyBuffer.equals(Str._a))return Str._continue;
		}
		// -d = send
		if(keyBuffer.equals(Str._d) || keyBuffer.equals(Str._a)){
			// To not accidentally send
			if(ms.getCore()!=null && ms.getCore().getSend()!=null)				
				ms.getCore().setSend(null);
			
			if(isCoreNull)ms.setCore(null);
			
			if(!keyBuffer.equals(Str._a))return Str._continue;
		}	
		// -w = write
		if(keyBuffer.equals(Str._w) || keyBuffer.equals(Str._a)){
			// To not accidentally write
			if(ms.getCore()!=null && ms.getCore().getWrite()!=null)
				ms.getCore().setWrite(null);
			
			if(isCoreNull)ms.setCore(null);
			
			return Str._continue;
		}		
		return Str._null;			
	}		
	
}

