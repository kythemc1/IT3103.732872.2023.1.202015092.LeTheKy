
public class TestPassingParameter {
    public static void main(String []args){
        DVD jungleDVD =new DVD("jungle");
        DVD cinderellaDVD =new DVD("cinderellaDVD");
        swap(jungleDVD,cinderellaDVD);

        System.out.println("jungle title : "+ jungleDVD.getTitle());
        System.out.println("cinderella title : "+ cinderellaDVD.getTitle());

        changeTitle(jungleDVD,cinderellaDVD.getTitle());
        System.out.println("jungle title : "+ jungleDVD.getTitle());
    }

    public static void swap(DVD jungleDVD, DVD cinderellaDVD) {
        Object tmp=jungleDVD;
        jungleDVD=cinderellaDVD;
        cinderellaDVD= (DVD) tmp;
    }

    public static void changeTitle(DVD dvd,String title){
        String oldTitle = dvd.getTitle();
        dvd.setTitle(title);
        dvd = new DVD(oldTitle);
    }

}
