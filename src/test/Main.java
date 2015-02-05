package test;

import db_objects.SprModelObject;
import db_utils.DBUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(new FileInputStream("sql.txt"),"UTF-8");
            String dbPath = sc.nextLine();

            System.out.println("Database file: "+dbPath);

            DBUtils.openConnection(dbPath);

                StringBuilder builder = new StringBuilder();
            //
            //

            //
            //

            try {
                while (sc.hasNextLine())
                {
                    builder.append(sc.nextLine());
                }
            } finally {
                sc.close();
            }

            String[] sql = builder.toString().split(";");

            StringBuilder resBuilder = new StringBuilder();

            for (String sqlst : sql)
            {
                resBuilder.append("Query: "+sqlst+"\n");
                resBuilder.append("Result: "+"\n");

                ArrayList<SprModelObject> list = DBUtils.getResultsList(sqlst);

                for (SprModelObject obj : list)
                {
                    resBuilder.append(obj.getId()+" , "+obj.getName_ru()+" , "+obj.getName_en()+"\n");
                }

                resBuilder.append("\n");
            }

            System.out.println(resBuilder.toString());

        } catch ( FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
