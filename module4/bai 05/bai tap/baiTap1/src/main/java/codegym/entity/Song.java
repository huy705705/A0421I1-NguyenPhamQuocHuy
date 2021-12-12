package codegym.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.*;

@Entity
@Table(name = "song")
public class Song {
    @Id
    @Column(name = "song_id")
    private int id;

    @Column(name = "song_name")
    private String name;

    @Column(name = "song_singer")
    private String singer;

    @Column(name = "song_type")
    private String type;

    @Column(name = "song_link")
    private String link;

    public Song() {
    }

    public Song(String name, String singer, String type, String link) {
        this.name = name;
        this.singer = singer;
        this.type = type;
        this.link = link;
    }

    public Song(int id, String name, String singer, String type, String link) {
        this.id = id;
        this.name = name;
        this.singer = singer;
        this.type = type;
        this.link = link;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
