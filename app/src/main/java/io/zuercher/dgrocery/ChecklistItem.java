package io.zuercher.dgrocery;

public class ChecklistItem {
    String name;
    String date;
    String message;

    ChecklistItem(String name,
             String date,
             String message)
    {
        this.name = name;
        this.date = date;
        this.message = message;
    }
}
