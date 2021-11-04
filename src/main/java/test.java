import java.awt.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Project name(项目名称)：Pattern类和Matcher类
 * Package(包名): PACKAGE_NAME
 * Class(类名): test
 * Author(作者）: mao
 * Author QQ：1296193245
 * Date(创建日期)： 2021/11/4
 * Time(创建时间)： 19:52
 * Version(版本): 1.0
 * Description(描述)： java.util.regex 是一个用正则表达式所订制的模式来对字符串进行匹配工作的类库包。它包括两个类：Pattern 和 Matcher。
 * Pattern 对象是正则表达式编译后在内存中的表示形式，因此，正则表达式字符串必须先被编译为 Pattern 对象，
 * 然后再利用该 Pattern 对象创建对应的 Matcher 对象。执行匹配所涉及的状态保留在 Matcher 对象中，多个 Matcher 对象可共享同一个 Pattern 对象。
 * 因此，典型的调用顺序如下：
 * // 将一个字符串编译成 Pattern 对象
 * Pattern p = Pattern.compile("a*b");
 * // 使用 Pattern 对象创建 Matcher 对象
 * Matcher m = p.matcher("aaaaab");
 * boolean b = m.matches(); // 返回 true
 * 上面定义的 Pattern 对象可以多次重复使用。如果某个正则表达式仅需一次使用，则可直接使用 Pattern 类的静态 matches() 方法，
 * 此方法自动把指定字符串编译成匿名的 Pattern 对象，并执行匹配，如下所示。
 * boolean b = Pattern.matches ("a*b","aaaaab");    // 返回 true
 * Matcher 类的几个常用方法
 * 名称	说明
 * find()	返回目标字符串中是否包含与 Pattern 匹配的子串
 * group()	返回上一次与 Pattern 匹配的子串
 * start()	返回上一次与 Pattern 匹配的子串在目标字符串中的开始位置
 * end()	返回上一次与 Pattern 匹配的子串在目标字符串中的结束位置加 1
 * lookingAt()	返回目标字符串前面部分与 Pattern 是否匹配
 * matches()	返回整个目标字符串与 Pattern 是否匹配
 * reset()	将现有的 Matcher 对象应用于一个新的字符序列。
 */

public class test
{
    public static void main(String[] args)
    {
        //------------------------------------------------------
        long startTime = System.nanoTime();   //获取开始时间
        //------------------------------------------------------
        Toolkit.getDefaultToolkit().beep();
        Pattern p = Pattern.compile("a.c");
        Matcher m1 = p.matcher("a2c");
        boolean b1 = m1.matches();
        System.out.println(b1);
        Matcher m2 = p.matcher("abc");
        System.out.println(m2.matches());
        Matcher m3 = p.matcher("abb");
        System.out.println(m3.matches());
        Matcher m4 = p.matcher("abbc");
        System.out.println(m4.matches());
        Pattern p2 = Pattern.compile("\\d+@[a-zA-Z]+.com");
        Matcher m5 = p2.matcher("4544576@qq.com");
        System.out.println("邮箱:" + m5.matches());
        Matcher m6 = p2.matcher("15487@.com");
        System.out.println(m6.matches());
        boolean b2 = Pattern.matches("[^a-z]+", "4564a");
        System.out.println(b2);
        System.out.println(Pattern.matches("1.+2", "111452"));

        String str = "返回目标字符串前面部分与 Pattern 是否匹配，尽快联系我13500006666" +
                "交朋友，电话号码是13611145545" + "联系方式15899903412";
        // 创建一个Pattern对象，并用它建立一个Matcher对象
        // 该正则表达式只抓取13X和15X段的手机号
        // 实际要抓取哪些电话号码，只要修改正则表达式即可
        Matcher m = Pattern.compile("((13\\d)|(15\\d))\\d{8}").matcher(str);
        // 将所有符合正则表达式的子串（电话号码）全部输出
        System.out.println(m.matches());
        while (m.find())
        {
            System.out.println(m.group());
        }

        String str2 = "ertewjavaweretJavadtsetjAvAsfaJAVAksrijaVarjavsjavAeretdyawrjjavaet";
        Pattern p3 = Pattern.compile("[jJ][aA][vV][aA]");
        Matcher mm1 = p3.matcher(str2);
        while (mm1.find())
        {
            System.out.println(mm1.group() + "\t开始位置：" + mm1.start() + "\t结束位置：" + mm1.end());
        }

        String[] mails = {"kongyeeku@163.com", "kongyeeku@gmail.com", "ligang@crazyit.org", "wawa@abc.xx", "wf@qq.com"};
        String mailRegEx = "\\w{3,20}@\\w+\\.(com|org|cn|net|gov)";
        Pattern mailPattern = Pattern.compile(mailRegEx);
        Matcher matcher = null;
        for (String mail : mails)
        {
            if (matcher == null)
            {
                matcher = mailPattern.matcher(mail);
            }
            else
            {
                matcher.reset(mail);
            }
            String result = mail + (matcher.matches() ? "是" : "不是") + "一个有效的邮件地址！";
            System.out.println(result);
        }
        System.out.println("长度在3-5区间内的数字：");
        String[] ss1 = {"145", "6984", "6871562", "12", "59874", "245i9", "54789"};
        Pattern pp1 = Pattern.compile("\\d{3,5}");
        Matcher ma1 = pp1.matcher(ss1[0]);
        for (String s : ss1)
        {
            ma1.reset(s);
            System.out.println(s + ":" + ma1.matches());
        }
        //替换
        System.out.println("替换re开头的单词：");
        String[] msgs = {"Java has regular expressions in 1.4", "regular expressions now expressing in Java",
                "Java represses oracular expressions"};
        Pattern pp = Pattern.compile(" re\\w*");
        Matcher matcher1 = null;
        for (int i = 0; i < msgs.length; i++)
        {
            if (matcher1 == null)
            {
                matcher1 = pp.matcher(msgs[i]);
            }
            else
            {
                matcher1.reset(msgs[i]);
            }
            System.out.println(matcher1.replaceAll(" 替换"));
        }
        System.out.println();
        //------------------------------------------------------
        long endTime = System.nanoTime(); //获取结束时间
        if ((endTime - startTime) < 1000000)
        {
            double final_runtime;
            final_runtime = (endTime - startTime);
            final_runtime = final_runtime / 1000;
            System.out.println("算法运行时间： " + final_runtime + "微秒");
        }
        else if ((endTime - startTime) >= 1000000 && (endTime - startTime) < 10000000000L)
        {
            double final_runtime;
            final_runtime = (endTime - startTime) / 1000;
            final_runtime = final_runtime / 1000;
            System.out.println("算法运行时间： " + final_runtime + "毫秒");
        }
        else
        {
            double final_runtime;
            final_runtime = (endTime - startTime) / 10000;
            final_runtime = final_runtime / 100000;
            System.out.println("算法运行时间： " + final_runtime + "秒");
        }
        Runtime r = Runtime.getRuntime();
        float memory;
        memory = r.totalMemory();
        memory = memory / 1024 / 1024;
        System.out.printf("JVM总内存：%.3fMB\n", memory);
        memory = r.freeMemory();
        memory = memory / 1024 / 1024;
        System.out.printf(" 空闲内存：%.3fMB\n", memory);
        memory = r.totalMemory() - r.freeMemory();
        memory = memory / 1024 / 1024;
        System.out.printf("已使用的内存：%.4fMB\n", memory);
        //------------------------------------------------------
    }
}


