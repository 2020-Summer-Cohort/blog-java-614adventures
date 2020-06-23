package org.wcci.blog;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Activity {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    @OneToMany (mappedBy = "activity")
    private Collection<Post> posts;

    protected Activity () {}

    public Activity (String name) {
        this.name=name;
        this.posts=posts;
    }

    public Collection<Post> getPosts() {
        return posts;
    }

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Activity activity = (Activity) o;
        return id == activity.id &&
                Objects.equals(name, activity.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
