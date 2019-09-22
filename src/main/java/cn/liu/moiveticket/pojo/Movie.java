package cn.liu.moiveticket.pojo;

public class Movie {
    private String title; // 标题
    private String mainland_pubdata; // 上映时间_
    private String images; // 图片
    private String durations; // 总时长

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", mainland_pubdata='" + mainland_pubdata + '\'' +
                ", images='" + images + '\'' +
                ", durations='" + durations + '\'' +
                '}';
    }
}
