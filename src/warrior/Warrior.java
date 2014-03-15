package warrior;

import java.util.Calendar;

import warrior.core.WCore;
import warrior.ftp.WFtp;

public class Warrior extends Thread {

    private MemberSuccess member;

    public Warrior(MemberSuccess member) {
        this.member = member;
    }

    public void run() {
        ThreadGroup tg = new ThreadGroup("warrior");

        System.out.println("-----WarriorBegin----");
        if (member.getFtp() != null) {
            //System.out.println(member.getFtp());
            WFtp wf = new WFtp(tg, member.getFtp());
            wf.start();
            try {
                wf.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (member.getCore() != null) {
            //System.out.println(member.getCore());
            WCore wl = new WCore(tg, member.getCore());
            wl.start();
            try {
                wl.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("-----WarriorEnd------");
    }

    public static String getFileName() {
        Calendar c = Calendar.getInstance();//YYYY-mm-dd_hh.mm.ss+ssss
        return String.valueOf(c.get(Calendar.YEAR) + "-" + c.get(Calendar.MONTH)
                + "-" + c.get(Calendar.DATE) + "_" + c.get(Calendar.HOUR) + "." + c.get(Calendar.MINUTE)
                + "." + c.get(Calendar.SECOND) + "+" + c.get(Calendar.MILLISECOND));
    }

    @Override
    public String toString() {
        String s = member.getFtp() + "\n";
        s += member.getCore() + "\n";
        return s;
    }

}
