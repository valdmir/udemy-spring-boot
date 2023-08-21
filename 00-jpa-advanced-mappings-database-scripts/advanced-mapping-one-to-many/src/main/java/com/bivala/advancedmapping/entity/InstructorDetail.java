package com.bivala.advancedmapping.entity;

import jakarta.persistence.*;

@Entity
@Table(name="instructor_detail")

public class InstructorDetail {
//    annotate the class as an entity and map to db table

//    define the fields
//    annotate the fields with db column names
//    gcreate contructors
//    generate settergetter
//    generate to string
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    public int id;
    @Column(name="youtube_channel")
    public String youtubeChannel;
    @Column(name="hobby")
    public String hobby;
    @OneToOne(mappedBy ="instructorDetail"
            ,cascade = {CascadeType.DETACH,CascadeType.PERSIST,CascadeType.REFRESH})
//    @JoinColumn(name="instructor_detail_id")
    private Instructor instructor;
    public InstructorDetail(){}

    public InstructorDetail(String youtubeChannel, String hobby) {
        this.youtubeChannel = youtubeChannel;
        this.hobby = hobby;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getYoutubeChannel() {
        return youtubeChannel;
    }

    public void setYoutubeChannel(String youtubeChannel) {
        this.youtubeChannel = youtubeChannel;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    @Override
    public String toString() {
        return "InstructorDetail{" +
                "id=" + id +
                ", youtubeChannel='" + youtubeChannel + '\'' +
                ", hobby='" + hobby + '\'' +
                '}';
    }
}
