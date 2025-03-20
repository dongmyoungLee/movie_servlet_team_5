package dao;

import config.JdbcConnection;
import dto.UserDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    private static UserDao userdao;
    public static UserDao getUserRepository() {
        if(userdao == null) userdao = new UserDao();
        return userdao;
    }
    public boolean signUp(UserDto dto) {
        Connection conn = new JdbcConnection().getJdbc();
        boolean isSuccess = false;
        String sql = "INSERT INTO user (user_id, user_name, user_email, user_pwd, user_birthdate, user_phonenumber) " +
                "VALUES (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement psmt = conn.prepareStatement(sql);
            psmt.setString(1, dto.getUser_id());
            psmt.setString(2, dto.getUser_name());
            psmt.setString(3, dto.getUser_email());
            psmt.setString(4, dto.getUser_pwd());
            psmt.setString(5, dto.getUser_birthdate());
            psmt.setString(6, dto.getUser_phone_number());
            int rowsAffected = psmt.executeUpdate();
            if (rowsAffected > 0) {
                isSuccess = true;
            }
        } catch (SQLException e) {
            return false;
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                return isSuccess;
            }
        }
        return isSuccess;
    }

    public UserDto loginById(String user_id, String user_pwd){
        Connection conn = new JdbcConnection().getJdbc();
        UserDto loginUser = new UserDto();
        String sql = "select *\n" +
                "from user\n" +
                "where user_id = ? \n" +
                "and user_pwd = ?;";

        try {
            PreparedStatement psmt = conn.prepareStatement(sql);
            psmt.setString(1, user_id);
            psmt.setString(2, user_pwd);
            ResultSet resultSet = psmt.executeQuery();


//          while을 써줘야 함->왜? 만약 resultSet에 값이 없을 경우, 실행하지 않아야 하기 때문에,
//          while을 하지 않으면 resultSet.getInt("user_seq")에 값이 없는데 들어가서 에러뜸.

            while(resultSet.next()){
                // setter를 쓰는 것보다 method를 활용해서 세팅하는게 좋음
                loginUser.createUser(
                        resultSet.getInt("user_seq"),
                        resultSet.getString("user_id"),
                        resultSet.getString("user_name"),
                        resultSet.getString("user_email"),
                        resultSet.getString("user_pwd"),
                        resultSet.getString("user_birthdate"),
                        resultSet.getString("user_phonenumber")
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        if(loginUser.getUser_id()==null){
            return null;
        }

        return loginUser;
    }


    public UserDto loginByEmail(String user_email, String user_pwd){
        Connection conn = new JdbcConnection().getJdbc();
        UserDto loginUser = new UserDto();
        String sql = "select *\n" +
                "from user\n" +
                "where user_email = ? \n" +
                "and user_pwd = ?;";

        try {
            PreparedStatement psmt = conn.prepareStatement(sql);
            psmt.setString(1, user_email);
            psmt.setString(2, user_pwd);
            ResultSet resultSet = psmt.executeQuery();



            // setter를 쓰는 것보다 method를 활용해서 세팅하는게 좋음
            while(resultSet.next()){
                loginUser.createUser(
                        resultSet.getInt("user_seq"),
                        resultSet.getString("user_id"),
                        resultSet.getString("user_name"),
                        resultSet.getString("user_email"),
                        resultSet.getString("user_pwd"),
                        resultSet.getString("user_birthdate"),
                        resultSet.getString("user_phonenumber")
                );
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        if(loginUser.getUser_id()==null){
            return null;
        }

        return loginUser;
    }


    /**
     * 회원 정보를 수정하는 로직
     * @param userDto
     * @return Boolean
     */
    public Boolean updateUser (UserDto userDto){
        Connection conn = new JdbcConnection().getJdbc();

        boolean isUpdate = false;

        String sql = "update user set user_name=?,\n" +
                "user_email=?,\n" +
                "user_pwd=?,\n" +
                "user_birthdate=?,\n" +
                "user_phonenumber=?\n" +
                "where user_seq =?";

        try {
            PreparedStatement psmt = conn.prepareStatement(sql);
            psmt.setString(1,userDto.getUser_name());
            psmt.setString(2,userDto.getUser_email());
            psmt.setString(3,userDto.getUser_pwd());
            psmt.setString(4,userDto.getUser_birthdate());
            psmt.setString(5,userDto.user_phone_number());
            psmt.setInt(6,userDto.getUser_seq());

            int i = psmt.executeUpdate();

            if(i>0) isUpdate =true;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return isUpdate;
    }

    /**
     *
     * @param user_seq
     * @return
     */
    public UserDto getUserBySeq(int user_seq){
        Connection conn = new JdbcConnection().getJdbc();

        String sql="select * from user where user_seq=?";

        UserDto userDto = new UserDto();

        try {
            PreparedStatement psmt = conn.prepareStatement(sql);
            psmt.setInt(1,user_seq);

            ResultSet resultSet = psmt.executeQuery();
            // 회원 하나만 나옴 이거
            while(resultSet.next()){
                userDto.createUser(
                        resultSet.getInt("user_seq"),
                        resultSet.getString("user_id"),
                        resultSet.getString("user_name"),
                        resultSet.getString("user_email"),
                        resultSet.getString("user_pwd"),
                        resultSet.getString("user_birthdate"),
                        resultSet.getString("user_phonenumber")
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return userDto;
    }

    public UserDto findId(String name, String phoneNumber) {

        Connection conn = new JdbcConnection().getJdbc();
        String sql = "SELECT user_id FROM user WHERE user_name = ? AND user_phonenumber = ?";
        UserDto userDto = new UserDto();

        try {
            PreparedStatement psmt = conn.prepareStatement(sql);
            psmt.setString(1, name);
            psmt.setString(2, phoneNumber);

            ResultSet resultSet = psmt.executeQuery();

            while(resultSet.next()){
                userDto.setUser_id(resultSet.getString("user_id"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return userDto;
    }

    public static UserDto findPassword(String id, String name, String phoneNumber) {
        Connection conn = new JdbcConnection().getJdbc();
        String sql = "SELECT user_id FROM user WHERE user_id = ? AND user_name = ? AND user_phonenumber = ?";
        UserDto userDto = new UserDto();

        try {
            PreparedStatement psmt = conn.prepareStatement(sql);
            psmt.setString(1, id);
            psmt.setString(2, name);
            psmt.setString(3, phoneNumber);

            ResultSet rs = psmt.executeQuery();

            while(rs.next()){
                userDto.setUser_id(rs.getString("user_id"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return userDto;
    }

    public static void updatePassword(String userId, String newPassword) {
        Connection conn = new JdbcConnection().getJdbc();
        String sql = "UPDATE user SET user_pwd = ? WHERE user_id = ?";
        try {
            PreparedStatement psmt = conn.prepareStatement(sql);
            psmt.setString(1, newPassword);
            psmt.setString(2, userId);
            psmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

