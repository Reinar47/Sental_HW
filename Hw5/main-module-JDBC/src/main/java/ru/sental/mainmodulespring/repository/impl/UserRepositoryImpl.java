package ru.sental.mainmodulespring.repository.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.sental.mainmodulespring.constant.UserRole;
import ru.sental.mainmodulespring.entity.UserAccount;
import ru.sental.mainmodulespring.jdbc.ConnectionHolder;
import ru.sental.mainmodulespring.repository.UserRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private final ConnectionHolder connectionHolder;

    @Override
    public UserAccount save(UserAccount user) {
        if (user.getUserId() == null) {

            return insert(user);
        }

        return update(user);
    }

    private UserAccount insert(UserAccount user) {
        String sql = """
                INSERT INTO user_account (first_name, last_name, nick_name, password, user_role, email, user_deleted)
                VALUES (?, ?, ?, ?, ?, ?, ?) RETURNING user_id
                """;
        try {
            Connection connection = connectionHolder.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getNickName());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setString(5, user.getUserRole().name());
            preparedStatement.setString(6, user.getEmail());
            preparedStatement.setBoolean(7, user.isUserDeleted());

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                user.setUserId(resultSet.getLong("user_id"));
            }

            return user;
        } catch (SQLException e) {
            throw new RuntimeException("insert failed", e);
        }
    }

    private UserAccount update(UserAccount user) {

        String sql = """
                UPDATE user_account SET first_name=?, last_name=?, nick_name=?, password=?,
                user_role=?, email=?, user_deleted=? WHERE user_account.user_id=?
                """;

        try {

            Connection connection = connectionHolder.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getNickName());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setString(5, user.getUserRole().name());
            preparedStatement.setString(6, user.getEmail());
            preparedStatement.setBoolean(7, user.isUserDeleted());
            preparedStatement.setLong(8, user.getUserId());
            preparedStatement.executeUpdate();

            return user;
        } catch (SQLException e) {
            throw new RuntimeException("update failed", e);
        }
    }

    @Override
    public Optional<UserAccount> findById(long id) {

        String sql = "SELECT * FROM user_account WHERE user_account.user_id = ?";

        try {
            Connection connection = connectionHolder.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            return resultSet.next() ? Optional.of(mappingRow(resultSet)) : Optional.empty();

        } catch (SQLException e) {
            throw new RuntimeException("findById failed", e);
        }
    }

    @Override
    public Optional<UserAccount> findByEmail(String email) {

        String sql = "SELECT * FROM user_account WHERE user_account.email = ?";

        try {
            Connection connection = connectionHolder.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, email);

            ResultSet resultSet = preparedStatement.executeQuery();

            return resultSet.next() ? Optional.of(mappingRow(resultSet)) : Optional.empty();

        } catch (SQLException e) {
            throw new RuntimeException("findByEmail failed", e);
        }
    }

    @Override
    public List<UserAccount> findAll() {

        String sql = "SELECT * FROM user_account";

        List<UserAccount> result = new ArrayList<>();
        try {
            Connection conn = connectionHolder.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) result.add(mappingRow(rs));

            return result;
        } catch (SQLException e) {
            throw new RuntimeException("findAll failed", e);
        }
    }

    @Override
    public void delete(long id) {

        String sql = "DELETE FROM user_account WHERE user_account.user_id = ?";

        try {
            Connection conn = connectionHolder.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setLong(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("delete failed", e);
        }
    }

    @Override
    public boolean existsById(long id) {
        return findById(id).isPresent();
    }

    private UserAccount mappingRow(ResultSet resultSet) throws SQLException {
        return UserAccount.builder()
                .userId(resultSet.getLong("user_id"))
                .firstName(resultSet.getString("first_name"))
                .lastName(resultSet.getString("last_name"))
                .nickName(resultSet.getString("nick_name"))
                .password(resultSet.getString("password"))
                .userRole(UserRole.valueOf(resultSet.getString("user_role")))
                .email(resultSet.getString("email"))
                .userDeleted(resultSet.getBoolean("user_deleted"))
                .build();
    }

}
