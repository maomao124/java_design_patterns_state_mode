package mao.after;

/**
 * Project name(项目名称)：java设计模式_状态模式
 * Package(包名): mao.after
 * Class(类名): StoppingState
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/8/20
 * Time(创建时间)： 20:35
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class StoppingState extends LiftState
{

    @Override
    public void open()
    {
        context.setLiftState(Context.openningState);
        System.out.println("电梯门打开");
        context.stateString = "打开状态";
    }

    @Override
    public void close()
    {
        context.setLiftState(Context.closingState);
        System.out.println("电梯门关闭");
        context.stateString = "关闭状态";
    }

    @Override
    public void run()
    {
        context.setLiftState(Context.runningState);
        System.out.println("电梯运行");
        context.stateString = "运行状态";
    }

    @Override
    public void stop()
    {

    }
}
