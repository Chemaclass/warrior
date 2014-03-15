package warrior.core;

import home.Str;

import java.io.File;

public class Create {

	private int nDir=0;
    private int nFil=0;
	private String search;
	private String remove="";
    
    //private static Create create=null;
	public Create(String search) {
		this.search=search;
	}
	public Create(String search,String remove) {
		this.search=search;
		this.remove=remove;
	}
	
	/*public static Create getInstance(){
		if(create==null)create=new Create();
		return create;
	}*/

	/**
	 * 
	 * @param who = write or see
	 * @param dir = current dir
	 * @param type = current-files or all-files
	 */
	@SuppressWarnings("unchecked")
	void coreCreate(String who,Directory dir,String type) {
		boolean isSee = (who.equals(Str.see)); //for see
		boolean isFilesOrAll = type.equals(Str.files)||type.equals(Str.all);//for files or all
		
		try{
	    	File file = (File) dir.getFile();
	        for(File f : file.listFiles()){
	            if(f.isDirectory()){
	            	nDir++;
	            	if(isSee && isFilesOrAll) //see only files or see all files
	            		System.out.println("Dir: "+nDir+". Files: "+nFil+". Path: "+f);
	            	
            		Directory m = new Directory(f);
	                dir.getList().add(m);//add folder to current folder
	                
		            //if(type.equals(Str.all) || remove.equals(Str.all)) //see all sub folders
		            if(type.equals(Str.all) || who.equals(Str.remove)) //see all sub folders
		            	coreCreate(who,m,Str.all);
	            	
	            } else {
	            	if(!f.getName().contains(search))
	            		continue;
	            	nFil++;
	            	
	            	dir.getList().add(f);
	            	
	            	if(isSee && isFilesOrAll){
	            		long size=(Math.round(f.length()/1024.0)>0)?Math.round(f.length()/1024.0):1;
	                	System.out.println("Dir: "+nDir+". Files: "+nFil+". Path: "+f+". Size: "+size+"KB");           	
	            	}
	            	//for remove all files minus folders
	            	if(remove.equals(Str.files) || remove.equals(Str.all)){
	            		delFile(f);
	            		//remove all files and folders
		                if(remove.equals(Str.all) && f.getParentFile().list().length==0){		                	
		                	delFile(f.getParentFile());
		                }
		            }
	            }
	        }
	        if(remove.equals(Str.all))	                	
	            if(file.isDirectory() && file.list().length==0){
	            	delFile(file);
	            }
		}catch(NullPointerException ex){
			System.out.println("Exception: Directory not found for "+who+"!");
		}
    }
	
	private void delFile(File file){
    	if(!file.delete())
    		file.deleteOnExit();
    }
	
}
