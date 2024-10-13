package group.chatting.application;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author WuHao
 * @create 2023-06-03-12:43
 */
public class ButtonAction implements ActionListener {
    public int count = 0;
    public JTextField nameJtf;
    public JFrame jf1;

    /*监听方法*/
    public void actionPerformed(ActionEvent e){
        String nameText = nameJtf.getText();

        JFrame jf = new JFrame();
        jf.setTitle("登陆响应");
        jf.setSize(500,200);
        jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        java.awt.FlowLayout f1 = new java.awt.FlowLayout();
        jf.setLayout(f1);
        JLabel jla = new JLabel("登陆成功！");
        jf.add(jla);
        jf.setVisible(true);
        jf.setLocationRelativeTo(null);
    }

}
