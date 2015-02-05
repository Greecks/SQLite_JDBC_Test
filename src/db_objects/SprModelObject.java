package db_objects;

/**
 * Created by velenteenko on 04.02.15.
 */
public class SprModelObject {

    private int id;
    private String name_ru;
    private String name_en;

    public SprModelObject(){}

    public SprModelObject(int id, String nameru, String nameen )
    {
        this.id = id;
        this.name_ru = nameru;
        this.name_en = nameen;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName_ru() {
        return name_ru;
    }

    public void setName_ru(String name_ru) {
        this.name_ru = name_ru;
    }

    public String getName_en() {
        return name_en;
    }

    public void setName_en(String name_en) {
        this.name_en = name_en;
    }
}
