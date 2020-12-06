package console;
import java.util.Enumeration;
public class Administrator extends User {
    public Administrator(String name, String password, String role) {
        super(name, password, role);
    }
    String name,password,role;
    @Override
    public void showMenu() {
        String tip_system1="系统管理员菜单";
        String tip_menu1="请选择菜单:";
        String tip_exit1="退出，谢谢你的使用";
        String infos="\n****欢迎进入"+tip_system1+"****\n"+"   1.新增用户\n"+"   2.删除用户\n"+
                "   3.修改用户\n"+"   4.用户列表\n"+"   5.下载档案\n"+"   6.档案列表\n"
                +"   7.修改个人密码\n"+"   8.退出\n"+"***************************";
        String input=null;
        int k=0;
        do {
            System.out.println(infos);
            System.out.println(tip_menu1);
            input=Main.in.nextLine().trim();
            if(!(input).matches("1|2|3|4|5|6|7|8"))
                System.err.println("输入格式错误");
            else {
                int i = Integer.parseInt(input);
                switch (i) {
                    case 1:
                        adduser();
                        break;
                    case 2:
                        deluser();
                        break;
                    case 3:
                        changuserinfo();
                        break;
                    case 4:
                        System.out.println("***************用户列表如下**************");
                        showlist();
                        System.out.println("****************************************");
                        break;
                    case 5:
                        download();
                        break;
                    case 6:
                        showlist2();
                        break;
                    case 7:
                        chang();

                        break;
                    case 8:
                        System.out.println(tip_exit1);
                        k = 1;
                        break;

                    default:
                        System.out.println("输入错误，请按照规定输入！！！\n");
                }
            }

        }while(k==0);

    }


    private void adduser() //新增用户
    {
        System.out.println("请输入新用户的姓名：");
        String name=Main.in.nextLine();
        System.out.println("请输入新用户的密码：");
        String password=Main.in.nextLine();
        System.out.println("请输入新用户的类型(输入administrator、operator或browser)：");
        String role=Main.in.nextLine();
        if(role.equals("administrator")||role.equals("operator")||role.equals("browser"))
        {
            if(DataProcessing.insert(name, password, role))
                System.out.println("新用户添加成功！");
            else
                System.out.println("新用户添加失败！");
        }
        else
            System.out.println("新用户添加失败！请按照规定输入！");

    }
    private void deluser()//删除用户
    {
        System.out.println("请输入待删除用户的姓名：");
        String name=Main.in.nextLine();
        if (DataProcessing.delete(name))
            System.out.println("该用户删除成功！");
        else
            System.out.println("该用户删除失败！");
    }

    private void changuserinfo()//修改用户
    {
        System.out.println("请输入要修改用户的姓名：");
        String name=Main.in.nextLine();
        System.out.println("请输入要修改用户的密码：");
        String password=Main.in.nextLine();
        System.out.println("请输入要修改用户的类型(输入administrator、operator或browser)：");
        String role=Main.in.nextLine();
        if(role.equals("administrator")||role.equals("operator")||role.equals("browser"))
        {
            if(DataProcessing.update(name,password, role))
                System.out.println("用户修改成功！");
            else
                System.out.println("用户修改失败！");
        }
        else
            System.out.println("用户修改失败！请按照规定输入！");

    }

    private void showlist()//用户列表
    {
//        User user= (Administrator) DataProcessing.getAllUser();
//       while(user!=null)
//       {
//           System.out.println("姓名："+user.getName()+"密码："+user.getPassword()+"角色："+user.getRole());
//       }   自己写的有bug

//csdn上查到了一个解决办法  通过 Enumeration 的对象（比如对象名为：e）调用此类中的 nextElement() 获得 User 的对象
        Enumeration<User> e=DataProcessing.getAllUser();
        User user;
        while(e.hasMoreElements()) {
            user=e.nextElement();
            System.out.println("姓名："+user.getName()+"\t密码："+user.getPassword()+"\t角色："+user.getRole());
        }

    }
    private void download()//下载文件
    {
        System.out.println("请输入你要下载文件的编号:");
        String ID=Main.in.nextLine();
        if(downloadFile(ID))
        {
            System.out.println("下载成功！");
        }
        else
            System.out.println("下载失败！");
    }
    private void showlist2()//档案列表
    {
        System.out.println("档案列表如下");
        showFileList();
    }
    private void chang()
    {
        System.out.println("请输入你的新密码:");
        String password=Main.in.nextLine();
        if(password.equals(DataProcessing.users.get("kate").getPassword()))
            System.out.println("你输入的新密码与原密码相同，更改密码失败！");
        else
            changeSelfInfo(password);
    }

}
