package jp.co.a328w.kubox.learningjson;

/**
 * Created by kubox on 2016/10/17.
 */

public class Item {
    public String id;
    public String body;
    public String created_at;
    public String updated_at;

    public Item(String id, String body, String created_at, String updated_at){
        this.id = id;
        this.body = body;
        this.created_at = created_at;
        this.updated_at = updated_at;

    }
}
