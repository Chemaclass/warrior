package success;

import home.Str;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class Core {

    public final static String NAME = Str.core;
    public final static String HELP = Str.h_core;

    private static Core core;

    //private String find;
    private String name;
    private String path;
    private String search;
    private String send;
    private String see;
    private String remove;
    private String write;

    /**
     *
     * @return all help of members
     */
    public static String getHelps() {
        String s = "Help to Core:\n";
        Iterator<Entry<String, String>> it = help.entrySet().iterator();
        while (it.hasNext()) {
            s += Str.out + it.next() + "\n";
        }
        return s;
    }

    public String getNotNull() {
        String s = "\n" + Str.core + ":";
        //if(find!=null)s+=	Str._tab+Str.find+":"+find+"\n";
        if (name != null) {
            s += Str._tab1 + Str.name + ":" + name + "\n";
        }
        if (path != null) {
            s += Str._tab1 + Str.path + ":" + path + "\n";
        }
        if (search != null) {
            s += Str._tab1 + Str.search + ":" + search + "\n";
        }
        if (send != null) {
            s += Str._tab1 + Str.send + ":" + send + "\n";
        }
        if (see != null) {
            s += Str._tab1 + Str.see + ":" + see + "\n";
        }
        if (remove != null) {
            s += Str._tab1 + Str.remove + ":" + remove + "\n";
        }
        if (write != null) {
            s += Str._tab1 + Str.write + ":" + write + "\n";
        }
        return s;
    }

    private static Map<String, String> help = new HashMap<String, String>();

    static {
        //help.put(Str.find,"("+Str.chars+")" 	+  Str.h_find);
        help.put(Str.name, Str.h_name);
        help.put(Str.path, Str.h_path);
        help.put(Str.search, Str.h_search);
        help.put(Str.send, Str.h_send);
        help.put(Str.see, Str.h_see);
        help.put(Str.remove, Str.h_remove);
        help.put(Str.write, Str.h_write);
    }

    public static String getHelp(String key) {
        return help.get(key);
    }

    private Core() {
    }

    public static Core getInstance() {
        if (core == null) {
            core = new Core();
        }
        return core;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public String getSend() {
        return send;
    }

    public void setSend(String send) {
        this.send = send;
    }

    public String getSee() {
        return see;
    }

    public void setSee(String show) {
        this.see = show;
    }

    public String getRemove() {
        return remove;
    }

    public void setRemove(String remove) {
        this.remove = remove;
    }

    public String getWrite() {
        return write;
    }

    public void setWrite(String write) {
        this.write = write;
    }

    /*public String getFind() {
     return find;
     }
     public void setFind(String find) {
     this.find = find;
     }*/
    @Override
    public String toString() {
        return "Core [name=" + name + ", path=" + path
                + ", search=" + search + ", send=" + send + ", show=" + see
                + ", remove=" + remove + ", write=" + write + "]";
    }

}
