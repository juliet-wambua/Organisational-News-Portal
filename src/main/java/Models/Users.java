package Models;

public class Users {
    private String userName;
    private String userAddress;
    private int userMobileNo;
    private String userEmail;
    private String position;
    private int departmentId;

    public Users(String userName, String userAddress, int userMobIleNo,String userEmail, String position, int departmentId){
       this.userName = userName;
       this.userAddress = userAddress;
       this.userMobileNo = userMobileNo;
       this.userEmail = userEmail;
       this.position = position;
       this.departmentId = departmentId;
    }

}
