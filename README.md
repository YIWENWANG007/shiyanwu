# 综合性实验五  学生选课系统设计 
## 一、实验目的
 分析学生选课系统
 使用GUI窗体及其组件设计窗体界面
 完成学生选课过程业务逻辑编程
 基于文件保存并读取数据
 处理异常
## 二、实验要求
1、设计GUI窗体，支持学生注册、课程新加、学生选课、学生退课、打印学生选课列表等操作。
2、基于事件模型对业务逻辑编程，实现再界面上支持上述操作。
3、针对操作中可能出现的各种异常，做异常处理。
4、基于输入/输出编程，支持学生、课程、教师等数据的读写操作。
## 三、实验过程
学生登录界面，用JOptionPane.showMessageDialog(null, str1);实现一个窗口框，还运用了addActionListener点击事件、用if 、else判断密码是否正确，密码错误出现新的窗口：String str1 = "你输入的密码不正确，原因可能是：\n" +  "1、忘记密码；\n" + "2、未开启小键盘；\n" + "3、大小写未区分。";再用	new StudentFrame().show();跳转下一界面。学生登录成功后，弹出选课、退课、打印课程界面。把信息输出需要out.write(str);、 out.flush()；、 关闭输出流out.close();  
this.setLayout(new BorderLayout());运用边界布局。用try...catch结构对异常进行捕获和处理，e.printStackTrace();存放异常。
```javascript
//登录
public void MyEvent(){
		login.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				String name="abc";
				String word = "123456";	// 正确密码
				String str = new String(password.getPassword());
				if(str.equals(word))
					new Login().setVisible(true);
				
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
	
```
```javascript
//学生选课
 public static void main(String[] args) {
     new Student();
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try{
                	Student frame=new Student();     // 创建一个窗口
                    frame.setVisible(true);                                 // 让该窗口实例可见
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
        }
	 JPanel panel_2=new JPanel();
        panel.add(panel_2);
        cb1=new JCheckBox("java");
        panel_2.add(cb1);
        t1=new JComboBox<String >();
        t1.setModel(new DefaultComboBoxModel<String>(new String[]{"杨老师","赵老师","王老师"}));
        panel_2.add(t1);
	JPanel panel_5=new JPanel();
        panel.add(panel_5);
        JButton w1=new JButton("确定");
        panel_5.add(w1);
        JButton wy1=new JButton("重填");
        panel_5.add(wy1);
        JButton wyw1=new JButton("打印选课信息");
        panel_5.add(wyw1);
	//学生所选课程打印输出
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

```

```javascript
//course
public class Course {
	
	private String courseName;
	private String selected;
	
	public Course(String courseName, String selected){
		this.courseName = courseName;
		this.selected = selected;
	}
	
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getSelected() {
		return selected;
	}
	public void setSelected(String selected) {
		this.selected = selected;
	}
```
## 五、实验结果
![Image text](https://raw.githubusercontent.com/YIWENWANG007/shiyanwu/master/img/1.png)


## 六、实验感想
通过本次java编程实验,我有了一点自己的见解。在学生选课系统代码中，我加入了异常处理和信息输入输出。从最开始的有思绪，慢慢学习到最后的代码实现，遇到各种各样的问题， 所以只能一边学习一边做，要实现一个完美的选课管理系统还差很多，这还需要在以后的学习中慢慢积累开发经验。
