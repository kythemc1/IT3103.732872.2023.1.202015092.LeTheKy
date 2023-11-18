package Main;

import Main.model.Book;
import Main.model.CompactDisc;
import Main.model.DVD;
import Main.model.Media;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class TestPassingParameter {
    public static void main(String []args){
//        DVD jungleDVD =new DVD("jungle");
//        DVD cinderellaDVD =new DVD("cinderellaDVD");
//        swap(jungleDVD,cinderellaDVD);
//
//        System.out.println("jungle title : "+ jungleDVD.getTitle());
//        System.out.println("cinderella title : "+ cinderellaDVD.getTitle());
//
//        changeTitle(jungleDVD,cinderellaDVD.getTitle());
//        System.out.println("jungle title : "+ jungleDVD.getTitle());
        List<Media> mediaList =new ArrayList<>();
        DVD dvd1 = new DVD(1, "đá", "Action", "Director 1", 120.5, 15,1);
        CompactDisc cd =new CompactDisc(1, "đá", "Action", 12, "as", 15,"as");

        Book book =new Book(1, "đá", "Action", 12);
        mediaList.add(cd);
        mediaList.add(dvd1);

        mediaList.add(book);

        for(Media media : mediaList){
            System.out.println(media);
        }
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
