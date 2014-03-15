package warrior.ftp;

import success.Ftp;

public class WFtp extends Thread {

    public WFtp() {
    }

    public WFtp(ThreadGroup arg0, Ftp arg1) {
        super(arg0, "warriorFtp");

    }

}
