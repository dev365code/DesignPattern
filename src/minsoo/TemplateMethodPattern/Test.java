package minsoo.TemplateMethodPattern;

import minsoo.TemplateMethodPattern.Daehwa;
import minsoo.TemplateMethodPattern.Student;
public class Test {
    public static void main(String[] args) {
        Student daehwa = new Daehwa("Daehwa");
        System.out.println("==========" + daehwa.getName() + "===========");
        daehwa.doHomework();
        System.out.println("=====================");
        System.out.println();

        Student taehyun = new Taehyun("Taehyun");
        System.out.println("==========" + taehyun.getName() + "===========");
        taehyun.doHomework();
        System.out.println("=====================");
        System.out.println();

        Student wooyong = new Wooyong("Wooyong");
        System.out.println("==========" + wooyong.getName() + "===========");
        wooyong.doHomework();
        System.out.println("=====================");
        System.out.println();

        Student minsoo = new Minsoo("Minsoo");
        System.out.println("==========" + minsoo.getName() + "===========");
        minsoo.doHomework();
        System.out.println("=====================");
    }
}
