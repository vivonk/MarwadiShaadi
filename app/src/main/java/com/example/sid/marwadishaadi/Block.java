package com.example.sid.marwadishaadi;

/**
 * Created by Sid on 31-May-17.
 */

public class Block {


    private String Id,name;

    public Block(String Id, String name)
    {
        this.Id=Id;
        this.name=name;
    }

    public String getId() {
        return Id;
    }

    public String getName() {
        return name;
    }

    public void setId(String id) {
        this.Id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
