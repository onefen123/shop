package net.fen.shop.admin.entity;

import lombok.Data;

@Data
public class Brand {
    private int id;
    private String name;
    private String url;
    private String logo;
    private String description;
    private int sort;
    private int status;
}
