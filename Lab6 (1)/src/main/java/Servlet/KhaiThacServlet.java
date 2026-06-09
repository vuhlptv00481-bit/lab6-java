package Servlet;

import jakarta.persistence.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;

// Import chính xác các class Entity từ các package viết hoa của bạn
import Favorites.Favorite;
import Users.User;
import Videos.Video;
import Reports.Report;

@WebServlet({
        "/bai2/cau1",
        "/bai2/cau2",
        "/bai2/cau3",
        "/bai2/cau4",
        "/bai2/cau5"
})
public class KhaiThacServlet extends HttpServlet {
    private EntityManager em;

    @Override
    public void init() throws ServletException {
        // Khởi tạo EntityManager từ EntityManagerFactory
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PolyOE");
        this.em = emf.createEntityManager();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String path = req.getServletPath();

        if (path.equals("/bai2/cau1")) {
            // 1. Tìm các video yêu thích theo người sử dụng
            String username = req.getParameter("username");

            // SỬA: Chặn điều kiện username trống hoặc null để không bị sập lỗi 500
            if (username != null && !username.trim().isEmpty()) {
                User user = em.find(User.class, username.trim());
                List<Favorite> favorites = (user != null) ? user.getFavorites() : null;

                req.setAttribute("user", user);
                req.setAttribute("favorites", favorites);
            } else {
                req.setAttribute("message", "Vui lòng nhập hoặc truyền tham số ?username=...");
            }
            req.getRequestDispatcher("/views/cau1.jsp").forward(req, resp);

        } else if (path.equals("/bai2/cau2")) {
            // 2. Tìm các video được yêu thích chứa từ khóa
            String keyword = req.getParameter("keyword");
            if (keyword == null) keyword = "";

            String jpql = "SELECT DISTINCT o.video FROM Favorite o WHERE o.video.title LIKE :keyword";
            TypedQuery<Video> query = em.createQuery(jpql, Video.class);
            query.setParameter("keyword", "%" + keyword.trim() + "%");
            List<Video> list = query.getResultList();

            req.setAttribute("videos", list);
            req.getRequestDispatcher("/views/cau2.jsp").forward(req, resp);

        } else if (path.equals("/bai2/cau3")) {
            // 3. Tìm những người sử dụng thích video (nhập video id)
            String videoId = req.getParameter("videoId");

            // SỬA: Chặn điều kiện videoId trống để câu lệnh SQL không quét thừa dữ liệu
            if (videoId != null && !videoId.trim().isEmpty()) {
                String jpql = "SELECT o.user FROM Favorite o WHERE o.video.id = :vid";
                TypedQuery<User> query = em.createQuery(jpql, User.class);
                query.setParameter("vid", videoId.trim());
                List<User> list = query.getResultList();
                req.setAttribute("users", list);
            } else {
                req.setAttribute("message", "Vui lòng nhập hoặc truyền tham số ?videoId=...");
            }
            req.getRequestDispatcher("/views/cau3.jsp").forward(req, resp);

        } else if (path.equals("/bai2/cau4")) {
            // 4. Hiển thị tất cả các video không có hoặc có yêu thích
            String favParam = req.getParameter("favorite");
            boolean favorite = (favParam != null) && Boolean.parseBoolean(favParam);

            String jpql = favorite
                    ? "SELECT o FROM Video o WHERE o.favorites IS NOT EMPTY"
                    : "SELECT o FROM Video o WHERE o.favorites IS EMPTY";

            TypedQuery<Video> query = em.createQuery(jpql, Video.class);
            List<Video> list = query.getResultList();

            req.setAttribute("videos", list);
            req.getRequestDispatcher("/views/cau4.jsp").forward(req, resp);

        } else if (path.equals("/bai2/cau5")) {
            // 5. Tổng hợp số lượt thích từng video (Tối ưu hóa gom nhóm theo ID)
            String jpql = "SELECT new Reports.Report(o.video.title, count(o), max(o.likeDate), min(o.likeDate)) "
                    + " FROM Favorite o GROUP BY o.video.id, o.video.title";

            TypedQuery<Report> query = em.createQuery(jpql, Report.class);
            List<Report> list = query.getResultList();

            req.setAttribute("reports", list);
            req.getRequestDispatcher("/views/cau5.jsp").forward(req, resp);
        }
    }

    @Override
    public void destroy() {
        if (em != null && em.isOpen()) {
            em.close();
        }
    }
}