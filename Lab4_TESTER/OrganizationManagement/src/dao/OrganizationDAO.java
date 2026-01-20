package dao;

import model.Organization;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class OrganizationDAO {

    public boolean isOrgNameExists(String orgName) {
        String sql = "SELECT COUNT(*) FROM ORGANIZATION WHERE UPPER(OrgName) = UPPER(?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, orgName.trim());
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            System.err.println("Error checking organization name: " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    public Organization save(Organization org) throws SQLException {
        String sql = "INSERT INTO ORGANIZATION (OrgName, Address, Phone, Email, CreatedDate) " +
                "VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setString(1, org.getOrgName().trim());
            pstmt.setString(2, org.getAddress() != null && !org.getAddress().trim().isEmpty()
                    ? org.getAddress().trim() : null);
            pstmt.setString(3, org.getPhone() != null && !org.getPhone().trim().isEmpty()
                    ? org.getPhone().trim() : null);
            pstmt.setString(4, org.getEmail() != null && !org.getEmail().trim().isEmpty()
                    ? org.getEmail().trim() : null);
            pstmt.setTimestamp(5, Timestamp.valueOf(LocalDateTime.now()));

            int affectedRows = pstmt.executeUpdate();

            if (affectedRows > 0) {
                ResultSet generatedKeys = pstmt.getGeneratedKeys();
                if (generatedKeys.next()) {
                    org.setOrgID(generatedKeys.getInt(1));
                    System.out.println("✓ Organization saved with ID: " + org.getOrgID());
                }
            }

            return org;
        }
    }

    public Organization findById(int orgID) {
        String sql = "SELECT * FROM ORGANIZATION WHERE OrgID = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, orgID);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                Organization org = new Organization();
                org.setOrgID(rs.getInt("OrgID"));
                org.setOrgName(rs.getString("OrgName"));
                org.setAddress(rs.getString("Address"));
                org.setPhone(rs.getString("Phone"));
                org.setEmail(rs.getString("Email"));

                Timestamp ts = rs.getTimestamp("CreatedDate");
                if (ts != null) {
                    org.setCreatedDate(ts.toLocalDateTime());
                }

                return org;
            }
        } catch (SQLException e) {
            System.err.println("Error finding organization: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    public List<Organization> findAll() {
        List<Organization> list = new ArrayList<>();
        String sql = "SELECT * FROM ORGANIZATION ORDER BY CreatedDate DESC";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Organization org = new Organization();
                org.setOrgID(rs.getInt("OrgID"));
                org.setOrgName(rs.getString("OrgName"));
                org.setAddress(rs.getString("Address"));
                org.setPhone(rs.getString("Phone"));
                org.setEmail(rs.getString("Email"));

                Timestamp ts = rs.getTimestamp("CreatedDate");
                if (ts != null) {
                    org.setCreatedDate(ts.toLocalDateTime());
                }

                list.add(org);
            }
        } catch (SQLException e) {
            System.err.println("Error finding all organizations: " + e.getMessage());
            e.printStackTrace();
        }
        return list;
    }

    public boolean delete(int orgID) {
        String sql = "DELETE FROM ORGANIZATION WHERE OrgID = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, orgID);
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;

        } catch (SQLException e) {
            System.err.println("Error deleting organization: " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }
}