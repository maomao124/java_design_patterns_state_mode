package mao.after;

/**
 * Project name(项目名称)：java设计模式_状态模式
 * Package(包名): mao.after
 * Class(类名): LiftState
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/8/20
 * Time(创建时间)： 20:32
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public abstract class LiftState
{
    protected Context context;

    public void setContext(Context context)
    {
        this.context = context;
    }


    /**
     * 电梯开门动作
     */
    public abstract void open();


    /**
     * 电梯关门动作
     */
    public abstract void close();


    /**
     * 电梯运行动作
     */
    public abstract void run();


    /**
     * 电梯停止动作
     */
    public abstract void stop();
}
