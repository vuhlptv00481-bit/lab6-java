package Videos;

import java.util.List;
import jakarta.persistence.*;
import Favorites.Favorite; // BỔ SUNG: Import để nhận diện lớp Favorite

@Entity
@Table(name = "Videos")
@NamedQueries({
        @NamedQuery(name = "Video.findByKeyword",
                query = "SELECT DISTINCT o.video FROM Favorite o WHERE o.video.title LIKE :keyword"),
        @NamedQuery(name = "Video.findByUser",
                query = "SELECT o.video FROM Favorite o WHERE o.user.id = :id"),
        @NamedQuery(name = "Video.findInRange",
                query = "SELECT DISTINCT o.video FROM Favorite o WHERE o.likeDate BETWEEN :min AND :max"),
        @NamedQuery(name = "Video.findInMonths",
                query = "SELECT DISTINCT o.video FROM Favorite o WHERE month(o.likeDate) IN (:months)")
})
@NamedNativeQueries({
        @NamedNativeQuery(
                name = "Video.random10",
                query = "SELECT TOP 10 * FROM Videos ORDER BY newid()",
                resultClass = Video.class
        )
})
public class Video {
    @Id
    @Column(name = "Id")
    private String id;

    @Column(name = "Title")
    private String title;

    @Column(name = "Poster")
    private String poster;

    @Column(name = "Description", columnDefinition = "nvarchar(MAX)")
    private String description;

    @Column(name = "Views")
    private Integer views = 0;

    @Column(name = "Active")
    private Boolean active = true;

    @OneToMany(mappedBy = "video")
    private List<Favorite> favorites;

    // --- GETTERS AND SETTERS ---
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getPoster() { return poster; }
    public void setPoster(String poster) { this.poster = poster; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Integer getViews() { return views; }
    public void setViews(Integer views) { this.views = views; }

    public Boolean getActive() { return active; }
    public void setActive(Boolean active) { this.active = active; }

    public List<Favorite> getFavorites() { return favorites; }
    public void setFavorites(List<Favorite> favorites) { this.favorites = favorites; }
}