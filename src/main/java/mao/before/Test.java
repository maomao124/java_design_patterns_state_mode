package mao.before;

/**
 * Project name(项目名称)：java设计模式_状态模式
 * Package(包名): mao.before
 * Class(类名): Test
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/8/20
 * Time(创建时间)： 19:52
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class Test
{
    public static void main(String[] args)
    {
        ILift lift = new Lift();

        lift.setState(ILift.RUNNING_STATE);

        lift.run();
        lift.close();
        lift.open();
        lift.stop();
        lift.open();
        lift.run();
        lift.stop();
        lift.close();
    }
}
