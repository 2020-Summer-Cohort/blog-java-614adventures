package org.wcci.blog;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

@Entity
public class Post {
    @Id
    @GeneratedValue
    private long id;
    private String title;
    @Column(length = 1000)
    private String body;
    private static LocalDate date;
    private static LocalTime time;
    @ManyToOne
    private Activity activity;
    @ManyToOne
    private Author author;
    @ManyToMany
    private Collection<Hashtag> hashtags;

    protected Post() {}

    public Post(String title, String body, LocalDate date, LocalTime time,
                Author author, Activity activity, Hashtag... hashtags) {
        this.title = title;
        this.body = body;
        this.date = date;
        this.time = time;
        this.author = author;
        this.activity = activity;
        this.hashtags = new ArrayList<>(Arrays.asList(hashtags));
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public static LocalDate getDate() {
        return date;
    }

    public static LocalTime getTime() {
        return time;
    }

    public Activity getActivity() {
        return activity;
    }

    public Author getAuthors() {
        return author;
    }

    public Collection<Hashtag> getHashtags() {
        return hashtags;
    }

    public void addHashtags(Hashtag hashtagToAdd) {
        hashtags.add(hashtagToAdd);
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", activity=" + activity +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return id == post.id &&
                Objects.equals(title, post.title) &&
                Objects.equals(body, post.body) &&
                Objects.equals(activity, post.activity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, body, activity);
    }


}

