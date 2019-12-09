package xuanke;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;


public class Student extends JFrame {

    // 定义组件
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField tfName,tfNum,allInfo;
    private JRadioButton rb1,rb2;
    private JCheckBox cb1,cb2,cb3;
    private JComboBox<String> t1,t2,t3;

    public static void main(String[] args) {
    	
     new Student();
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try{
                	Student frame=new Student();     // 创建一个窗口
                    frame.setVisible(true);                                    // 让该窗口实例可见
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }

    
    public Student(){
        setTitle("选课系统");                           // 标题
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);     
        setSize(600,500);                                   // 设置窗口大小
        setLocationRelativeTo(null);                        // 设置窗体居中
        contentPane=new JPanel();                           // 内容面板
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));      // 设置布局
        setContentPane(contentPane);
        JPanel panel=new JPanel(new GridLayout(5, 1,5,10));  // 5行1列的表格布局
        panel.setBorder(new TitledBorder(null,"",TitledBorder.LEADING ,TitledBorder.TOP,null,null));
        contentPane.add(panel,BorderLayout.CENTER);          // 给panel添加边框
        
        JPanel panel_1=new JPanel();
        panel.add(panel_1);
        JButton w=new JButton("选课");
        panel_1.add(w);
        JButton wy=new JButton("退课");
        panel_1.add(wy);
      
        JPanel panel_2=new JPanel();
        panel.add(panel_2);
        cb1=new JCheckBox("java");
        panel_2.add(cb1);
        t1=new JComboBox<String >();
        t1.setModel(new DefaultComboBoxModel<String>(new String[]{"杨老师","赵老师","王老师"}));
        panel_2.add(t1);
     
        JPanel panel_3=new JPanel();
        panel.add(panel_3);
        cb2=new JCheckBox("C语言");
        panel_3.add(cb2);
        t2=new JComboBox<String >();
        t2.setModel(new DefaultComboBoxModel<String >(new String[]{"谢老师","郑老师","赵老师"}));
        panel_3.add(t2);
        
        JPanel panel_4=new JPanel();
        panel.add(panel_4);
        cb3=new JCheckBox("高数");
        panel_4.add(cb3);
        t3=new JComboBox<String >();
        t3.setModel(new DefaultComboBoxModel<String>(new String[]{"周老师","杨老师"}));
        panel_4.add(t3);
      
        JPanel panel_5=new JPanel();
        panel.add(panel_5);
        JButton w1=new JButton("确定");
        panel_5.add(w1);
        JButton wy1=new JButton("重填");
        panel_5.add(wy1);
        JButton wyw1=new JButton("打印选课信息");
        panel_5.add(wyw1);
        
        //添加标题
        JPanel panelNorth=new JPanel();
        contentPane.add(panelNorth,BorderLayout.NORTH);
        JLabel labelTitle=new JLabel("学生选课系统");
        labelTitle.setForeground(Color.DARK_GRAY);
        labelTitle.setFont(new Font("宋体", Font.BOLD, 20));
        panelNorth.add(labelTitle);


        w1.addActionListener(new ActionListener() {                  
           public void actionPerformed(ActionEvent e) {
        	   
           }
      });
        wy1.addActionListener(new ActionListener() {                  
            public void actionPerformed(ActionEvent e) {
         	   
            }
       });

        wyw1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
       		
        		ArrayList<Course> courseSelect = new ArrayList<Course>();
        		
        		Course java = new Course("java",t1.getSelectedItem().toString());
        		Course c = new Course("C语言",t2.getSelectedItem().toString());
        		Course math = new Course("高数",t3.getSelectedItem().toString());
        		
        		if(cb1.isSelected()){
        			courseSelect.add(java);
        		}
        		if (cb2.isSelected()) {
        			courseSelect.add(c);
				}
        		if (cb3.isSelected()) {
        			courseSelect.add(math);
				}
        		
        		
        		
        		//
                File f = new File("e:" + File.separator + "StuSC.txt");// 声明File 对象    
                // 第2步：通过子类实例化父类对象    
                Writer out = null;                 
        // 准备好一个输出的对象    
                try {
					out = new FileWriter(f);
			        // 通过对象多态性进行实例化    
	                // 第3步：进行写操作    
	                String str = "";  
	                
	                for (Course course : courseSelect) {
						str+= course.getCourseName() + ":" + course.getSelected()+"\n";
					}
	        // 准备一个字符串    
	                out.write(str);                    
	        // 将内容输出    
	                out.flush();          
	                // 第4步：关闭输出流    
	                 out.close();  
				} catch (IOException e1) {
					
					e1.printStackTrace();
				}            
			}
        });
    }

}
