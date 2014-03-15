package warrior.core;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Directory {

    private File file;
    private List<Directory> list;

    public Directory(File file) {
        this.file = file;
        this.list = new ArrayList<Directory>();
    }

    public Directory(File file, List<Directory> list) {
        this.file = file;
        this.list = list;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    @SuppressWarnings("rawtypes")
    public List getList() {
        return list;
    }

    public void setList(List<Directory> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        String s = "path:\t" + file;
        for (File f : file.listFiles()) {
            s += "\n\t" + f;
        }
        if (list.size() > 0) {
            for (Object o : list) {
                s += "\t\n" + o;
            }
        }
        return s;
    }

}
