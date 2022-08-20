package mao.before;

/**
 * Project name(项目名称)：java设计模式_状态模式
 * Package(包名): mao.before
 * Class(类名): Lift
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/8/20
 * Time(创建时间)： 19:24
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class Lift implements ILift
{

    private int state;

    @Override
    public void setState(int state)
    {
        String beforeState = getStateString(this.state);
        String afterState = getStateString(state);
        this.state = state;
        System.out.println("电梯由" + beforeState + "更改为" + afterState);
    }

    /**
     * 获得对应的状态字符串
     *
     * @param state 状态数字
     * @return 字符串
     */
    public String getStateString(int state)
    {
        if (state == OPENING_STATE)
        {
            return "打开状态";
        }
        else if (state == CLOSING_STATE)
        {
            return "关闭状态";
        }
        else if (state == RUNNING_STATE)
        {
            return "运行状态";
        }
        else if (state == STOPPING_STATE)
        {
            return "停止状态";
        }
        else
        {
            return "未知状态";
        }
    }

    @Override
    public void open()
    {
        if (this.state == OPENING_STATE)
        {
            //当前为打开电梯状态
        }
        else if (this.state == CLOSING_STATE)
        {
            //当前为关闭电梯状态
            this.setState(OPENING_STATE);
        }
        else if (this.state == RUNNING_STATE)
        {
            //当前为运行电梯状态
            //运行状态禁止开门
        }
        else if (this.state == STOPPING_STATE)
        {
            //当前为电梯停止状态
            this.setState(OPENING_STATE);
        }
        else
        {
            throw new RuntimeException("电梯程序运行异常");
        }
    }

    @Override
    public void close()
    {
        if (this.state == OPENING_STATE)
        {
            //当前为打开电梯状态
            this.setState(CLOSING_STATE);
        }
        else if (this.state == CLOSING_STATE)
        {
            //当前为关闭电梯状态
        }
        else if (this.state == RUNNING_STATE)
        {
            //当前为运行电梯状态
        }
        else if (this.state == STOPPING_STATE)
        {
            //当前为电梯停止状态
            this.setState(CLOSING_STATE);
        }
        else
        {
            throw new RuntimeException("电梯程序运行异常");
        }
    }

    @Override
    public void run()
    {
        if (this.state == OPENING_STATE)
        {
            //当前为打开电梯状态
        }
        else if (this.state == CLOSING_STATE)
        {
            //当前为关闭电梯状态
            this.setState(RUNNING_STATE);
        }
        else if (this.state == RUNNING_STATE)
        {
            //当前为运行电梯状态
        }
        else if (this.state == STOPPING_STATE)
        {
            //当前为电梯停止状态
            this.setState(RUNNING_STATE);
        }
        else
        {
            throw new RuntimeException("电梯程序运行异常");
        }
    }

    @Override
    public void stop()
    {
        if (this.state == OPENING_STATE)
        {
            //当前为打开电梯状态
        }
        else if (this.state == CLOSING_STATE)
        {
            //当前为关闭电梯状态
        }
        else if (this.state == RUNNING_STATE)
        {
            //当前为运行电梯状态
            this.setState(STOPPING_STATE);
        }
        else if (this.state == STOPPING_STATE)
        {
            //当前为电梯停止状态
        }
        else
        {
            throw new RuntimeException("电梯程序运行异常");
        }
    }
}
