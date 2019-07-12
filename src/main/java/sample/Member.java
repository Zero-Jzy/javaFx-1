package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.TimeZone;

public class Member {
    private String id;
    private String username;
    private String password;
    private String fullname;
    private String avatar;
    private ImageView imageAvatar;
    private long remainTime;
    private String txtRemainTime;
    private int status;

    public Member() {
    }

    public Member(String username, String password, String fullname, String avatar, long remainTime, String id) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.avatar = avatar;
        this.imageAvatar = new ImageView(new Image(this.avatar, true));
        this.imageAvatar.setFitWidth(100);
        this.imageAvatar.setFitHeight(100);
        this.remainTime = remainTime;
        this.txtRemainTime = formatTime(this.remainTime);

    }

    public String formatTime(long time) {
        Long a = System.currentTimeMillis();


        Long currentTime = Instant.now().toEpochMilli();
        Long timeConLai = time - currentTime;
        int hour = (int) (timeConLai / (60 * 60 * 1000));
        int du = (int) (timeConLai%(60 * 60 * 1000));
        int miNut = du / (60 * 1000);
        Date date = new Date(time - currentTime);
        String lastTime = "0" + (hour) + " : " + (miNut);
        return lastTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTxtRemainTime() {
        return txtRemainTime;
    }

    public void setTxtRemainTime(String txtRemainTime) {
        this.txtRemainTime = txtRemainTime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public ImageView getImageAvatar() {
        return imageAvatar;
    }

    public void setImageAvatar(ImageView imageAvatar) {
        this.imageAvatar = imageAvatar;
    }

    public long getRemainTime() {
        return remainTime;
    }

    public void setRemainTime(long remainTime) {
        this.remainTime = remainTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", fullname='" + fullname + '\'' +
                ", avatar='" + avatar + '\'' +
                ", imageAvatar=" + imageAvatar +
                ", remainTime=" + remainTime +
                ", txtRemainTime='" + txtRemainTime + '\'' +
                ", status=" + status +
                '}';
    }
}
