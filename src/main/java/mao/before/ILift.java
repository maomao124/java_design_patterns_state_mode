package mao.before;

/**
 * Project name(项目名称)：java设计模式_状态模式
 * Package(包名): mao.before
 * Interface(接口名): ILift
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/8/20
 * Time(创建时间)： 19:22
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public interface ILift
{
    //开门状态
    public final static int OPENING_STATE = 1;
    //关门状态
    public final static int CLOSING_STATE = 2;
    //运行状态
    public final static int RUNNING_STATE = 3;
    //停止状态
    public final static int STOPPING_STATE = 4;

    /**
     * 设置电梯的状态
     *
     * @param state 状态数字
     */
    void setState(int state);

    /**
     * 获取状态
     *
     * @return 状态数字
     */
    int getState();

    /**
     * 获得对应的状态字符串
     *
     * @param state 状态数字
     * @return 字符串
     */
    String getStateString(int state);

    /**
     * 开门
     */
    void open();

    /**
     * 关门
     */
    void close();

    /**
     * 电梯运行
     */
    void run();

    /**
     * 电梯停止
     */
    void stop();
}
