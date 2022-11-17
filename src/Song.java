public class Song {
    private String title;
    private double Duration;

    public Song(String title, double duration) {
        this.title = title;
        Duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getDuration() {
        return Duration;
    }

    public void setDuration(double duration) {
        Duration = duration;
    }

    @Override
    public String toString() {
        return "Song{" +
                "title='" + title + '\'' +
                ", Duration=" + Duration +
                '}';
    }
}
