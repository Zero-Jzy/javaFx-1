package model;

import sample.Member;

import java.sql.*;
import java.util.ArrayList;

public class MemberModel {

    private static Connection connection;

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager
                    .getConnection("jdbc:mysql://localhost/javafx?user=root&password=");
        } catch (SQLException e) {
            System.out.println("SQLException " + e.getMessage());

        } catch (ClassNotFoundException e) {
            System.err.println("Errors: " + e.getMessage());
        }
    }

    public boolean add(Member nember) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "insert into Member (username, password, fullname, avatar, remainTime,id) values (?,?,?,?,?,?)");
            preparedStatement.setString(1, nember.getUsername());
            preparedStatement.setString(2, nember.getPassword());
            preparedStatement.setString(3, nember.getFullname());
            preparedStatement.setString(4, nember.getAvatar());
            preparedStatement.setString(6, String.valueOf(System.currentTimeMillis()));
            preparedStatement.setLong(5, nember.getRemainTime());
//            preparedStatement.setString(6, nember.getId());
            preparedStatement.execute();
            System.out.println("Đăng kí tài khoản thành công!");
            return true;
        } catch (SQLException e) {
            System.err.println("Đăng kí tài khoản không thành công!");
            System.err.println("Errors: " + e.getMessage());
            return false;
        }
    }

    public ArrayList<Member> getMember() {

        ArrayList<Member> memberArrayList = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Member");

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String userName = rs.getString(1);
                String password = rs.getString(2);
                String fullname = rs.getString(3);
                String avatar = rs.getString(4);
                Long remainTime = Long.parseLong(rs.getString(5));
                String id = rs.getString(7);
                Member member = new Member(userName, password, fullname, avatar, remainTime, id);
                memberArrayList.add(member);
            }
            rs.close();

        } catch (SQLException e) {
            System.err.println("Errors: " + e.getMessage());
            return null;
        }
        return memberArrayList;
    }

    public boolean delete(String id) {
        try {
            PreparedStatement st = connection.prepareStatement("DELETE FROM Member WHERE id = ?");
            st.setString(1, id);
            st.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("Errors: " + e.getMessage());
        }
        return false;
    }

    public boolean update(String id, Member member) {
        try {
            PreparedStatement st = connection.prepareStatement("update employee set fullname = ? and username = ? and password = ? and avatar = ?   where id=?");
            st.setString(5, id);
            st.setString(1, member.getFullname());
            st.setString(2, member.getUsername());
            st.setString(3, member.getPassword());
            st.setString(4, member.getAvatar());
            st.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("Errors: " + e.getMessage());
        }
        return false;
    }


}
