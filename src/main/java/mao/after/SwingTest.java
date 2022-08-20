package mao.after;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Project name(项目名称)：java设计模式_状态模式
 * Package(包名): mao.after
 * Class(类名): SwingTest
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/8/20
 * Time(创建时间)： 21:08
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class SwingTest
{
    private JButton openButton;
    private JButton closeButton;

    private JButton runButton;
    private JButton stopButton;

    private JTextField state;

    private Context context;

    public SwingTest()
    {
        //初始化顶层面板
        JFrame jFrame = new JFrame("电梯系统");
        jFrame.setSize(540, 720);
        //获取屏幕宽度
        int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
        //获取屏幕高度
        int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
        //位于屏幕中央
        jFrame.setLocation(screenWidth / 2 - jFrame.getWidth() / 2, screenHeight / 2 - jFrame.getHeight() / 2);
        jFrame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

        //注册虚拟机关闭挂钩
        addShutdownHook();

        //初始化按钮
        initButton();

        //个性化
        setPersonalise();

        //初始化电梯对象
        initContext();

        //设置布局
        setLayout(jFrame);

        //设置关闭的监听器
        setCloseListener(jFrame);

        //给按钮添加监听器
        setButtonListener();


        jFrame.setVisible(true);

    }

    /**
     * 给按钮添加监听器
     */
    private void setButtonListener()
    {
        openButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                context.open();
                state.setText(context.stateString);
            }
        });

        closeButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                context.close();
                state.setText(context.stateString);
            }
        });

        runButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                context.run();
                state.setText(context.stateString);
            }
        });

        stopButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                context.stop();
                state.setText(context.stateString);
            }
        });
    }

    /**
     * 初始化对象
     */
    private void initContext()
    {
        this.context = new Context();
        context.setLiftState(Context.stoppingState);
    }

    /**
     * 设个性化
     */
    private void setPersonalise()
    {
        Font font = new Font("宋体", Font.BOLD, 32);
        //字体设置
        openButton.setFont(font);
        closeButton.setFont(font);
        runButton.setFont(font);
        stopButton.setFont(font);

        //颜色设置
        openButton.setForeground(Color.green);
        closeButton.setForeground(new Color(50, 200, 0));
        runButton.setForeground(Color.green);
        stopButton.setForeground(new Color(50, 200, 0));

        //设置背景
        openButton.setBackground(new Color(20, 50, 130));
        closeButton.setBackground(new Color(20, 50, 130));
        runButton.setBackground(new Color(20, 50, 130));
        stopButton.setBackground(new Color(20, 50, 130));

        state.setFont(new Font("宋体", Font.BOLD, 48));
        state.setForeground(Color.cyan);
        state.setBackground(new Color(20, 30, 100));
        state.setHorizontalAlignment(JTextField.CENTER);
        state.setEditable(false);
    }

    /**
     * 设置布局
     *
     * @param jFrame JFrame
     */
    private void setLayout(JFrame jFrame)
    {
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new GridLayout(3, 1));
        jPanel.add(state);
        {
            JPanel jPanel1 = new JPanel();
            jPanel1.setLayout(new GridLayout(1, 2));
            jPanel1.add(openButton);
            jPanel1.add(closeButton);
            jPanel.add(jPanel1);
        }

        {
            JPanel jPanel1 = new JPanel();
            jPanel1.setLayout(new GridLayout(1, 2));
            jPanel1.add(runButton);
            jPanel1.add(stopButton);
            jPanel.add(jPanel1);
        }


        jFrame.add(jPanel);
    }

    /**
     * 初始化按钮
     */
    private void initButton()
    {
        openButton = new JButton("打开电梯门");
        closeButton = new JButton("关闭电梯门");
        runButton = new JButton("运行");
        stopButton = new JButton("停止");
        state = new JTextField("停止状态");
    }

    /**
     * 设置关闭的监听器
     *
     * @param jFrame JFrame
     */
    private void setCloseListener(JFrame jFrame)
    {
        jFrame.addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent e)
            {
                Toolkit.getDefaultToolkit().beep();
                int result = JOptionPane.showConfirmDialog(null, "是否退出？", "退出提示", JOptionPane.OK_CANCEL_OPTION);
                if (result == 0)
                {
                    System.exit(0);
                }
            }
        });
    }

    /**
     * 注册虚拟机关闭挂钩
     */
    private void addShutdownHook()
    {
        Runtime runtime = Runtime.getRuntime();
        runtime.addShutdownHook(new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                System.out.println("程序退出");
            }
        }));
    }


    public static void main(String[] args)
    {
        new SwingTest();
    }
}
