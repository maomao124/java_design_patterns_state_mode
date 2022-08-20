package mao.after;

/**
 * Project name(项目名称)：java设计模式_状态模式
 * Package(包名): mao.after
 * Class(类名): RunningState
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/8/20
 * Time(创建时间)： 20:35
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class RunningState extends LiftState
{

    @Override
    public void open()
    {

    }

    @Override
    public void close()
    {

    }

    @Override
    public void run()
    {

    }

    @Override
    public void stop()
    {
        context.setLiftState(Context.stoppingState);
        System.out.println("电梯停止");
        context.stateString = "停止状态";
    }
}
