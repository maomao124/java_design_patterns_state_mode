package mao.after;

/**
 * Project name(项目名称)：java设计模式_状态模式
 * Package(包名): mao.after
 * Class(类名): ClosingState
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/8/20
 * Time(创建时间)： 20:34
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class ClosingState extends LiftState
{

    @Override
    public void open()
    {
        context.setLiftState(Context.openningState);
        context.getLiftState().open();
    }

    @Override
    public void close()
    {
        System.out.println("电梯门关闭");
        context.stateString = "关闭状态";
    }

    @Override
    public void run()
    {
        context.setLiftState(Context.runningState);
        context.getLiftState().run();
    }

    @Override
    public void stop()
    {

    }
}
