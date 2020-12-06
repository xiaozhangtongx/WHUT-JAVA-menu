package console;

public class Operator extends User {
    Operator(String name, String password, String role) {
        super(name, password, role);
    }


    @Override
    public void showMenu() {
        String tip_system1="档案录入员菜单";
        String tip_menu1="请选择菜单:";
        String tip_exit1="退出，谢谢你的使用";
        String infos="\n****欢迎进入"+tip_system1+"****\n"+"   1.上传档案\n"+"   2.下载档案\n"+
                "   3.档案列表\n"+"   4.修改密码\n"+"   5.退出\n"+"***************************";
        int k=0;
        String input=null;
        do {
            System.out.println(infos);
            System.out.println(tip_menu1);
            input=Main.in.nextLine().trim();
            if(!(input).matches("1|2|3|4|5"))
                System.err.println("输入格式错误");
            else {
                int i = Integer.parseInt(input);
                switch (i) {
                    case 1:
                        upload();
                        break;
                    case 2:
                       download();
                        break;
                    case 3:
                        showlist();
                        break;
                    case 4:
                        chang();
                        break;
                    case 5:
                        System.out.println(tip_exit1);
                        k = 1;
                        break;
                    default:
                        System.out.println("输入错误，请按照规定输入！！！");
                }
            }

        }while(k==0);

    }

    private void upload()//上传档案
    {
        System.out.println("请输入源文件名:");
        String name=Main.in.nextLine();
        System.out.println("请输入档案号:");
        String number=Main.in.nextLine();
        System.out.println("请输入档案描述:");
        String s=Main.in.nextLine();
        System.out.println("文件正在上传... ...");
        System.out.println("上传成功!");
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
    private void showlist()//档案列表
    {
        System.out.println("档案列表如下");
        showFileList();
    }
    private void chang()
    {
        System.out.println("请输入你的新密码:");
        String password=Main.in.nextLine();
        if(password.equals(DataProcessing.users.get("jack").getPassword()))
            System.out.println("你输入的新密码与原密码相同，更改密码失败！");
        else
            changeSelfInfo(password);
    }

}

