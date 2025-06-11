package com.koreait.mvc1.data;

public class MemberDTO {
    private int idx;
    private String userid;
    private String userpw;
    private String name;
    private String hp;
    private String email;
    private String gender;
    private String ssn1;
    private String ssn2;
    private String zipcode;
    private String address1;
    private String address2;
    private String address3;
    private String regdate;
    private int point;


    public MemberDTO() {
    }

    public MemberDTO(int idx, String userid, String userpw, String name, String hp, String email, String gender, String ssn1, String ssn2, String zipcode, String address1, String address2, String address3, String regdate, int point) {
        this.idx = idx;
        this.userid = userid;
        this.userpw = userpw;
        this.name = name;
        this.hp = hp;
        this.email = email;
        this.gender = gender;
        this.ssn1 = ssn1;
        this.ssn2 = ssn2;
        this.zipcode = zipcode;
        this.address1 = address1;
        this.address2 = address2;
        this.address3 = address3;
        this.regdate = regdate;
        this.point = point;
    }

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUserpw() {
        return userpw;
    }

    public void setUserpw(String userpw) {
        this.userpw = userpw;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHp() {
        return hp;
    }

    public void setHp(String hp) {
        this.hp = hp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getSsn1() {
        return ssn1;
    }

    public void setSsn1(String ssn1) {
        this.ssn1 = ssn1;
    }

    public String getSsn2() {
        return ssn2;
    }

    public void setSsn2(String ssn2) {
        this.ssn2 = ssn2;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getAddress3() {
        return address3;
    }

    public void setAddress3(String address3) {
        this.address3 = address3;
    }

    public String getRegdate() {
        return regdate;
    }

    public void setRegdate(String regdate) {
        this.regdate = regdate;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }
}
