package Favorites;

import jakarta.persistence.*;
import java.util.Date;
import Users.User;
import Videos.Video;

@Entity
@Table(name = "Favorites") // <-- ĐÃ SỬA: Đổi từ "Favorite" thành "Favorites" để khớp 100% với SQL Server
public class Favorite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "UserId")
    private User user;

    @ManyToOne
    @JoinColumn(name = "VideoId")
    private Video video;

    @Temporal(TemporalType.DATE)
    @Column(name = "LikeDate")
    private Date likeDate = new Date();

    // --- GETTERS AND SETTERS ---
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    public Video getVideo() {
        return video;
    }
    public void setVideo(Video video) {
        this.video = video;
    }

    public Date getLikeDate() {
        return likeDate;
    }
    public void setLikeDate(Date likeDate) {
        this.likeDate = likeDate;
    }
}