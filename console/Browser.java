package console;

import java.util.Scanner;

public class Browser extends User {
    Browser(String name, String password, String role) {
        super(name, password, role);
    }

    @Override
    public void showMenu() {
        String input=null;
        String tip_system1="档案浏览员菜单";
        String tip_menu1="请选择菜单:";
        String tip_exit1="退出，谢谢你的使用";
        String infos="\n****欢迎进入"+tip_system1+"****\n"+"   1.下载档案\n"+
                "   2.档案列表\n"+"   3.修改密码\n"+"   4.退出\n"+"***************************";
        int k=0;
        do {
            System.out.println(infos);
            System.out.println(tip_menu1);
            input=Main.in.nextLine().trim();
            if(!(input).matches("1|2|3|4"))
                System.err.println("输入格式错误");
            else {
                int i = Integer.parseInt(input);
                switch (i) {
                    case 1:
                        dowloada();
                        break;
                    case 2:
                        showlist();
                        break;
                    case 3:
                        chang();
                        break;
                    case 4:
                        System.out.println(tip_exit1);
                        k = 1;
                        break;
                    default:
                        System.out.println("输入错误，请按照规定输入！！！\n");
                }
            }

        }while(k==0);


    }
    private void dowloada()
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
    private void showlist()
    {
        System.out.println("档案列表如下");
        showFileList();
    }
    private void chang()
    {
        System.out.println("请输入你的新密码:");
        String password=Main.in.nextLine();
        if(password.equals(DataProcessing.users.get("rose").getPassword()))
            System.out.println("你输入的新密码与原密码相同，更改密码失败！");
        else
            changeSelfInfo(password);
    }


}
