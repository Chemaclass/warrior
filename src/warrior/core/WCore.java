package warrior.core;

import home.Str;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

import success.Ftp;
import success.Core;
import warrior.Warrior;

import com.thoughtworks.xstream.XStream;

public class WCore extends Thread {

    private String name; //destiny path
    private String path; //source path
    private String search;//
    //private find; //
    private boolean send; //
    private String see; // 
    private int nDir = 0;
    private int nFil = 0;
    private String remove; //files|all|null
    private String write; //files|all|null

    public WCore(ThreadGroup tg, Core log) {
        super(tg, "log");
        this.name = (log.getName() != null) ? log.getName() : Warrior.getFileName();
        this.path = (log.getPath() != null) ? log.getPath() : ".";
        this.search = (log.getSearch() != null) ? log.getSearch() : "";
        //this.find = (log.getFind()!=null)?log.getFind():"";
        this.send = (log.getSend() != null) ? (log.getSend().equals("true") ? true : false) : false;
        this.see = (log.getSee() != null) ? log.getSee() : "null";
        this.remove = (log.getRemove() != null) ? log.getRemove() : "null";
        this.write = (log.getWrite() != null) ? log.getWrite() : "null";
    }

    @Override
    public void run() {

        File file = new File(path);
        if (!see.equals("null")) {
            System.out.println("Current Directory: " + file);
        }

        Directory dir = new Directory(file);

        // See or remove
        if (see.equals(Str.all)) {
            new Create(search).coreCreate(Str.see, dir, Str.all);
        } else if (see.equals(Str.files)) {
            new Create(search).coreCreate(Str.see, dir, Str.files);
        }

        //Write
        if (write.equals(Str.all)) {
            new Create(search).coreCreate(Str.write, dir, Str.all);
        } else if (write.equals(Str.files)) {
            new Create(search).coreCreate(Str.write, dir, Str.files);
        }

        //if remove
        if (remove.equals(Str.all)) {
            new Create(search, remove).coreCreate(Str.remove, dir, Str.all);
        } else if (remove.equals(Str.files)) {
            new Create(search, remove).coreCreate(Str.remove, dir, Str.files);
        }

        //write result in external file
        if (write.equals(Str.files) || write.equals(Str.all)) // name = path
        {
            if (name.contains("\\") || name.contains("/")) {
                if (name.endsWith(".xml")) {
                    logWrite(new File(name), dir);
                } else {
                    logWrite(new File(name + ".xml"), dir);
                }
            } // name = only name
            else if (name.endsWith(".xml")) {
                logWrite(new File(path, name), dir);
            } else {
                logWrite(new File(path, name + ".xml"), dir);
            }
        }

        //send the result via a ftp server
        if (send) {
            logSend(file, Ftp.getInstance());
        }
    }

    private void logWrite(File file, Directory dir) {
        System.out.println("\t>write begin...");
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file);
            XStream xstream = new XStream();
            xstream.alias("dir", Directory.class);
            xstream.alias("file", File.class);
            xstream.aliasAttribute(Directory.class, "file", "name");
            xstream.addImplicitCollection(Directory.class, "list");
            xstream.toXML(dir, fos);
            System.out.println("\t>write endsuccess (" + Str.path + ":" + file + ")");
        } catch (FileNotFoundException ex) {
            System.out.println(">\tLogpath not found.");
            ex.printStackTrace();
        } finally {
            try {
                fos.flush();
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void logSend(File file, Ftp ftp) {
        System.out.println("> send begin...");
        OutputStream os = null;
        BufferedReader br = null;
        int b;
        try {
            URL url = new URL("ftp://" + ftp.getUser() + ":" + ftp.getPass() + "@"
                    + ftp.getServer() + "/" + file.getName() + ";type=i");
            URLConnection urlc = url.openConnection();
            os = urlc.getOutputStream();
            br = new BufferedReader(new FileReader(file));
            while ((b = br.read()) != -1) {
                os.write(b);
            }
            System.out.println(Str.out + "log send success...");
        } catch (IOException e) {
            System.out.println(Str.out + "Log send exception...\n"
                    + Str.out + "Verifies that the user name, password and server are correct");
        } finally {
            try {
                os.flush();
                os.close();
                br.close();
            } catch (NullPointerException | IOException e) {
                //e.printStackTrace();
            }
        }
    }

    @Override
    public String toString() {
        return "WLog [name=" + name + ", path=" + path
                + ", search=" + search + ", send=" + send + ", show=" + see
                + ", nDir=" + nDir + ", nFil=" + nFil + ", remove=" + remove
                + ", write=" + write + "]";
    }

}
