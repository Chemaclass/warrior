package warrior;

import member.Help;
import home.Str;
import success.Core;
import success.Ftp;

public class MemberSuccess {

    private Ftp ftp;
    private Core core;

    public MemberSuccess() {
    }

    public MemberSuccess(Ftp ftp, Core war) {
        super();
        this.ftp = ftp;
        this.core = war;
    }

    public Ftp getFtp() {
        return ftp;
    }

    public void setFtp(Ftp ftp) {
        this.ftp = ftp;
    }

    public Core getCore() {
        return core;
    }

    public void setCore(Core log) {
        this.core = log;
    }

    @Override
    public String toString() {
        String s = "";
        if (ftp != null) {
            s += ftp.getNotNull();
        }
        if (core != null) {
            s += core.getNotNull();
        }
        return (s.length() == 0) ? Str.empty : s;
    }

    public String getHelps(String key2) {
        switch (key2) {
            case Str.ftp:
                return Ftp.getHelps();
            case Str.core:
                return Core.getHelps();
            case Str.all:
                return Core.getHelps() + "\n" + Ftp.getHelps() + "\n" + Help.getOthersHelps();
        }
        return "";
    }

}
