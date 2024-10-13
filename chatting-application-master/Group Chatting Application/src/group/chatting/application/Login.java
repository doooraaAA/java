package group.chatting.application;

import javax.swing.*;
import java.awt.*;

/**
 * @author WuHao
 * @create 2023-06-03-12:21
 */
public class Login extends JFrame{
    boolean aBoolean = false;
    /* 登录界面方法 */
    public void loginInit(){
        /*窗体对象*/
        JFrame jf = new JFrame();

        /*窗体属性*/
        jf.setTitle("登录界面");
        jf.setSize(1000,1000);
        jf.setResizable(false);
       // jf.setLocation(1000,400);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);

        /*结构布局*/
        FlowLayout f1 = new FlowLayout();
        jf.setLayout(f1);

        /*组件对象*/
        JButton btn = new JButton("登录");
        JLabel nameLabel = new JLabel("用户名：");
        JTextField nameText = new JTextField();
        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icons/bk1.png"));
        JLabel imgLabel = new JLabel(imageIcon);
        ((JComponent)this.getContentPane()).setOpaque(false);
        Dimension dimSize = new Dimension(420,50);
        nameText.setPreferredSize(dimSize);

        /*界面窗体添加*/
        jf.add(imgLabel);
        jf.add(nameLabel);
        jf.add(nameText);
        jf.add(btn);

        jf.setVisible(true);

        /*按钮添加监听器*/
        ButtonAction btnAction = new ButtonAction();
        btn.addActionListener(btnAction);
        btnAction.count = 100;
        btnAction.nameJtf = nameText;

        /*TODO:
        *  解决流型界面登陆界面文本框和背景不在一起*/
    }
}
