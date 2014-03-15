package home;

public class Str {

	//Strings 		
	public final static String 
			_a 		= "-a", //remove all members
			_f 		= "-f",
			_n 		= "-n", //name
			_p 		= "-p", //path
			_c 		= "-c", //search
			_r 		= "-r", //remove
			_s 		= "-s", //see
			_d 		= "-d", //send
			_w 		= "-w", //write
			_null 	= "null",
			_break 	= "break",
			_continue = "continue",
			
			
			_ntab 	= "\n\t",
			_tab1 	= "  ",
			_tab2 	= "    ",
			
			all		= "all",
			clean 	= "clean",					
			chars	= "chars",
			core 	= "core",
			empty	="(empty)",
			capture = "capture",
			help 	= "help",
			exit 	= "exit",
			files 	= "files",
			loop	= "loop", 
			path	= "path", 
			send	= "send", 
			name	= "name",
			number	= "number",
			ftp 	= "ftp",
			user	= "user", 
			server	= "server", 
			pass	= "pass",			
			search	= "search",
			show	= "show",
			see	= "see",
			remove	= "remove",
			write	= "write",find="find",
			sleep 	= "sleep",
			type 	= "type",
			other	= "other",
			fan 	= "files|all|null",
			dpath	= "destination path",
			spath	= "source path",			
			help_to = "Help to ",
			type_to = "Type to ",
			tf 	= "true|false",
			
			success	= "-> success: ",
			out 	= Str._tab1 + ">> ",
			in  	= "/> ",
			
			
			//helps
			//h_find 	= _f + "String to find into files",
			_qr = "quickly removed:",
			_qr_name = _qr + _n ,
			_qr_path =  _qr + _p,
			_qr_remove =  _qr + _r ,
			_qr_search =  _qr + _c ,
			_qr_see = _qr + _s ,
			_qr_send =  _qr + _d ,
			_qr_write =  _qr + _w ,
			
			_separator = " / ",
			
			h_name 	=  "Destination path and name" 
					+ _ntab + "("+ dpath + ")"	+_separator+_qr_name,
			h_path 	=  "Source path"
					+ _ntab + "("+ chars + ")"	+_separator+_qr_path,
			h_remove = "Remove all files"
					+ _ntab + "("+ fan + ")"	+_separator+_qr_remove,
			h_search = "String to find into files name"
					+ _ntab + "("+ chars + ")"	+_separator+_qr_search,
			h_see 	=  "See files in cmd"
					+ _ntab + "("+ fan + ")"	+_separator+_qr_see,
			h_send 	=  "Send the written via ftp"
					+ _ntab + "("+ tf + ")"		+_separator+_qr_send,
			h_write =  "Write the file structure in xml"
					+ _ntab + "("+ fan + ")"	+_separator+_qr_write,
			
			h_ftp 	= "FTP Connection",
			h_core 	= "",
			
			
			h_server=	"Server/Host/IP"  + "("+ chars + ")",
			h_user 	= 	"User ftp server" + "("+ chars + ")",
			h_pass 	= 	"Pass ftp server" + "("+ chars + ")",
			
			h_clean	= "Clean all members",
			h_show 	= "Show all members",
			h_help 	= "To help"
			
	;
	

}
