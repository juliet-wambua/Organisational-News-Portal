package Models;

public class Users {
    private String userName;
    private String userAddress;
    private String userMobleNo;
    private String userEmail;
    private String position;
    private int departmentId;

    public Users(String userName, String userAddress, String userMobleNo,String userEmail, String position, int departmentId){
       this.userName = userName;
       this.userAddress = userAddress;
       this.userMobleNo = userMobleNo;
       this.userEmail = userEmail;
       this.position = position;
       this.departmentId = departmentId;
    }

}
