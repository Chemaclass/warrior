package member;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import home.Str;
import success.Core;
import success.Ftp;

public class Help {

	public final static String NAME = Str.help;
	public final static String HELP = Str.help_to+NAME;
	
	public Help() {}

	/**
	 * 
	 * @param key help
	 * @param key2 
	 * @param valueBuffer
	 * @return
	 */
	public static String getHelp(String key2, String valueBuffer) {
		
		switch(key2){					
		case Ftp.NAME:
			switch(valueBuffer){
				case Str.user:return Ftp.getHelp(Str.user);		
				case Str.pass:return Ftp.getHelp(Str.pass);
				case Str.server:return Ftp.getHelp(Str.server);
			}
			break;
		case Core.NAME:
			switch(valueBuffer){
				case Str.all:return Core.getHelp(Str.all);
				case Str.name:return Core.getHelp(Str.name);
				case Str.path:return Core.getHelp(Str.path);
				case Str.search:return Core.getHelp(Str.search);
				case Str.send:return Core.getHelp(Str.send);
				case Str.see:return Core.getHelp(Str.see);
				case Str.write:return Core.getHelp(Str.write);
			}
			break;
		}
			
		return null;
	}

	public static Map<String,String> help = new HashMap<String,String>();
	static{
		help.put(Str.clean,	 Str.h_clean);
		help.put(Str.show,	 Str.h_show);
		help.put(Str.help,	 Str.h_help);
	}
	
	public static String getOthersHelps() {		
			String s = "Other help:\n";
			Iterator<Entry<String, String>> it = help.entrySet().iterator();
			while(it.hasNext())
				s += Str.out + it.next()+"\n";
			return s;
		}
	
}
