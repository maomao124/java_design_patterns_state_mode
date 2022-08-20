package mao.after;

/**
 * Project name(项目名称)：java设计模式_状态模式
 * Package(包名): mao.after
 * Class(类名): Context
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/8/20
 * Time(创建时间)： 20:35
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class Context
{
    //定义出所有的电梯状态
    public final static OpenningState openningState;
    public final static ClosingState closingState;
    public final static RunningState runningState;
    public final static StoppingState stoppingState;

    public String stateString = "未知状态";

    static
    {
        openningState = new OpenningState();//开门状态，这时候电梯只能关闭
        closingState = new ClosingState();//关闭状态，这时候电梯可以运行和开门
        runningState = new RunningState();//运行状态，这时候电梯只能停止
        stoppingState = new StoppingState();//停止状态，这时候电梯可以开门、运行
    }

    //定义一个当前电梯状态
    private LiftState liftState;

    public LiftState getLiftState()
    {
        return this.liftState;
    }

    public void setLiftState(LiftState liftState)
    {
        //当前环境改变
        this.liftState = liftState;
        //把当前的环境通知到各个实现类中
        this.liftState.setContext(this);
    }

    public void open()
    {
        this.liftState.open();
    }

    public void close()
    {
        this.liftState.close();
    }

    public void run()
    {
        this.liftState.run();
    }

    public void stop()
    {
        this.liftState.stop();
    }
}
