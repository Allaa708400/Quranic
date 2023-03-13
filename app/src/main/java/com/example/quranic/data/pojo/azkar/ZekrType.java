package com.example.quranic.data.pojo.azkar;

public class ZekrType {

 private String zekrName;
 private int zekrImageId;

  public ZekrType(String zekrName, int zekrImageId) {
    this.zekrName = zekrName;
    this.zekrImageId = zekrImageId;
  }

    public String getZekrName() {
        return zekrName;
    }

    public void setZekrName(String zekrName) {
        this.zekrName = zekrName;
    }

    public int getZekrImageId() {
        return zekrImageId;
    }

    public void setZekrImageId(int zekrImageId) {
        this.zekrImageId = zekrImageId;
    }

    // public String[] azkarTypes = {"اذكار الصباح","اذكار المساء", "اذكار النوم"};

}