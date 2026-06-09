package Reports;

import java.io.Serializable;
import java.util.Date;
import jakarta.persistence.*;

@Entity
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(
                name = "Report.favoriteByYear",
                procedureName = "spFavoriteByYear",
                parameters = {
                        @StoredProcedureParameter(name = "Year", type = Integer.class, mode = ParameterMode.IN)
                },
                resultClasses = {Report.class}
        )
})
public class Report {
    @Id
    private Serializable group;
    private Long likes;
    private Date newest;
    private Date oldest;

    // BẮT BUỘC: Phải có constructor đầy đủ tham số này để JPQL new Report() hoạt động tốt
    public Report(Serializable group, Long likes, Date newest, Date oldest) {
        this.group = group;
        this.likes = likes;
        this.newest = newest;
        this.oldest = oldest;
    }

    public Report() {} // Constructor rỗng mặc định

    // --- GETTERS AND SETTERS ---
    public Serializable getGroup() { return group; }
    public void setGroup(Serializable group) { this.group = group; }

    public Long getLikes() { return likes; }
    public void setLikes(Long likes) { this.likes = likes; }

    public Date getNewest() { return newest; }
    public void setNewest(Date newest) { this.newest = newest; }

    public Date getOldest() { return oldest; }
    public void setOldest(Date oldest) { this.oldest = oldest; }
}