package com.koreait.mvc1.data;

import java.lang.reflect.Member;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MemberDAO {
    public void deleteMember(String userid){
        String sql = "delete from member where userid = ?";
        try(Connection conn = DBUtil.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)){

        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean insertMember(MemberDTO member) {
        String sql = """
    insert into member (userid, userpw, name, hp, email, gender, ssn1, ssn2, zipcode, address1, address2, address3)
    values( ?,?,?,?,?,?,?,?,?,?,?,?)
    """;
        try(Connection conn = DBUtil.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, member.getUserid());
            pstmt.setString(2, member.getUserpw());
            pstmt.setString(3, member.getName());
            pstmt.setString(4, member.getHp());
            pstmt.setString(5, member.getEmail());
            pstmt.setString(6, member.getGender());
            pstmt.setString(7, member.getSsn1());
            pstmt.setString(8, member.getSsn2());
            pstmt.setString(9, member.getZipcode());
            pstmt.setString(10, member.getAddress1());
            pstmt.setString(11, member.getAddress2());
            pstmt.setString(12, member.getAddress3());
            return pstmt.executeUpdate() == 1;
        } catch (Exception e) {
           e.printStackTrace();
           return false;
        }
    }

/*
    public boolean modify(String userid){
        String sql = """
    update member set (userid, userpw, name, hp, email, gender, ssn1, ssn2, zipcode, address1, address2, address3)
    values( ?,?,?,?,?,?,?,?,?,?,?,?) where userid = ?
    """;
        try(Connection conn = DBUtil.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, member.getUserid());
            pstmt.setString(2, member.getUserpw());
            pstmt.setString(3, member.getName());
            pstmt.setString(4, member.getHp());
            pstmt.setString(5, member.getEmail());
            pstmt.setString(6, member.getGender());
            pstmt.setString(7, member.getSsn1());
            pstmt.setString(8, member.getSsn2());
            pstmt.setString(9, member.getZipcode());
            pstmt.setString(10, member.getAddress1());
            pstmt.setString(11, member.getAddress2());
            pstmt.setString(12, member.getAddress3());
            pstmt.setString(13, userid);
            return pstmt.executeUpdate() == 1;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
*/
    public MemberDTO getMember(String userid) {
        String sql = "select * from member where userid = ?";
        try(Connection conn = DBUtil.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, userid);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()) {
                MemberDTO member = new MemberDTO();
                member.setIdx(rs.getInt("idx"));
                member.setUserid(rs.getString("userid"));
                member.setUserpw(rs.getString("userpw"));
                member.setName(rs.getString("name"));
                member.setHp(rs.getString("hp"));
                member.setEmail(rs.getString("email"));
                member.setGender(rs.getString("gender"));
                member.setSsn1(rs.getString("ssn1"));
                member.setSsn2(rs.getString("ssn2"));
                member.setZipcode(rs.getString("zipcode"));
                member.setAddress1(rs.getString("address1"));
                member.setAddress2(rs.getString("address2"));
                member.setAddress3(rs.getString("address3"));
                return member;
            }
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }

    public MemberDTO login(String userid, String userpw){
        String sql = "select * from member where userid = ? and userpw = ?";
        try(Connection conn = DBUtil.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, userid);
            pstmt.setString(2, userpw);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()) {
                MemberDTO member = new MemberDTO();
                member.setIdx(rs.getInt("idx"));
                member.setUserid(rs.getString("userid"));
                member.setName(rs.getString("name"));
                member.setHp(rs.getString("hp"));
                member.setEmail(rs.getString("email"));
                member.setPoint(Integer.parseInt(rs.getString("point")));
                return member;
            }
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }


}
