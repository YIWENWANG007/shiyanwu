package xuanke;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Login extends JFrame{
	JLabel label,name,pass;
	JButton login;
	JTextField Name;
	JPasswordField password;
	JPanel panel,jp1,jp2;

	public Login(){
		this.setSize( 300, 200);
		this.setTitle("学生选课系统登录");
		this.setLayout(new BorderLayout());
		label = new JLabel("登录",SwingConstants.CENTER);
		label.setFont(new Font("楷体",Font.BOLD,30));
		name = new JLabel("账 号");
		pass = new JLabel("密 码");
		Name = new JTextField(12);
		Name.setText("");
		Name.setHorizontalAlignment(SwingConstants.CENTER);
		password = new JPasswordField(12);
		password.setHorizontalAlignment(SwingConstants.CENTER);
		password.setEchoChar('*');		//设置回显字符

		panel = new JPanel();
		jp1 = new JPanel();
		jp2 = new JPanel();
		panel.setLayout(new BorderLayout());
		jp1.add(Name);
		jp1.add(name);
		jp1.add(password);
		jp1.add(pass);
		panel.add(jp1);
		login = new JButton("登录");
		jp2.add(login);
		panel.add(jp2,BorderLayout.SOUTH);
		this.add(label,BorderLayout.NORTH);
		this.add(panel);		
		MyEvent();
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void MyEvent(){
		login.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				String name="abc";
				String word = "123456";	// 正确密码
				String str = new String(password.getPassword());
				if(str.equals(word)){
					new Login().setVisible(true);
				}
				else{
					String str1 = "你输入的密码不正确，原因可能是：\n" 
				+  "1、忘记密码；\n" + "2、未开启小键盘；\n" 
							+ "3、大小写未区分。";//密码错误提示
					JOptionPane.showMessageDialog(null, str1);
             	
				}
				Login.this.dispose();
				new Student().show();//跳转学生选课界面
			}
		});
	}
	public static void main(String[] args){
		new Login();
	}

}