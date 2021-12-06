package com.staravoyt.spring.core;

import com.staravoyt.spring.core.model.Book;
import com.staravoyt.spring.core.model.Magazine;
import com.staravoyt.spring.core.model.Newspaper;
import com.staravoyt.spring.core.model.Shop;

import java.util.List;
import java.util.Map;

public class Runner {
    public static void main(String[] args) {

        Book humorBook =new Book(1,"Comedy Club","humor of book",100,"hard");
        Book romansBook =new Book(2,"Romeo and Julia","romans of book",150,"soft");
        Book detectiveBook =new Book(3,"James Bond","detective of book",200,"hard");

        Magazine gqMagazine = new Magazine(4,"GQ","Fashion of industry",20, List.of("Sandals with socks","New Coats"));
        Magazine elisMagazine = new Magazine(5,"Elis","Magazine for women ",25, List.of("Sandals with socks","New Coats"));

        //newspapers
        Newspaper newYorkTimes =new Newspaper(6,"The New York Times","This is most populate newspaper in World",4,
                Map.of("John Bar", 25,
                        "Jessy Lingard", 3,
                        "Nikolay Fedorov", 12));
        Newspaper dailyNews=new Newspaper(7,"The Daily News","This is daily news",2,
                Map.of("Sara Cortny", 5,
                        "Justin Ibragimovich",1 ,
                        "Olga Ivanova", 12));

        //shops
        Shop shopIrish = new Shop(1,"Irish bookstore",
                List.of(humorBook,romansBook),
                List.of(gqMagazine,elisMagazine),
                List.of(dailyNews));
        Shop shopRussian = new Shop(1,"Russian bookstore",
                List.of(detectiveBook),
                List.of(gqMagazine,elisMagazine),
                List.of(newYorkTimes,dailyNews));


        shopIrish.printInfo();

    }
}
