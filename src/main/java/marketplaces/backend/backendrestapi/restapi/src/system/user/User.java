package marketplaces.backend.backendrestapi.restapi.src.system.user;

import marketplaces.backend.backendrestapi.config.global.GlobalConstants;

import marketplaces.backend.backendrestapi.config.global.auditing.Auditable;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Document(collection = "users")
public class User extends Auditable<String> {

    static public String DOC_TEXT = "USER";

    static public String USERNAME_TEXT = "username";
    static public String MAIL_TEXT = "mail";
    static public String PASSWORD_TEXT = "password";
    static public String PHONE_TEXT = "phone";
    static public String STATUS_TEXT = "status";
    static public String IS_ARCHIVED_TEXT = "isArchived";
    static public String ROLES_TEXT = "roles";
    static public String AUTHORITIES_TEXT = "authorities";


    @Id
    @Pattern(message = "Id not valid", regexp = GlobalConstants.REGEXP_OBJECTID)
    private String id;
    @NotNull(message = "username must be not null !!")
    @Indexed(direction = IndexDirection.ASCENDING, unique = true)
    @Size(min = 4)
    private String username;
    @NotNull(message = "mail must be not null !!")
    @Indexed(unique = true)
    @Pattern(message = "mail is incorrect !!", regexp = GlobalConstants.REGEXP_FOR_MAIL_VALDATION)
    private String mail;
    @NotNull(message = "phone must be not null !!")
    @Indexed(unique = true)
    @Pattern(message = "phone is incorrect !!", regexp = GlobalConstants.REGEXP_FOR_PHONE_NATIONAL_FORMAT)
    private String phone;
    @Size(min = 8)
    private String password;
    @Indexed(direction = IndexDirection.ASCENDING)
    private int status = 1;
    @Indexed(direction = IndexDirection.DESCENDING)
    private int isArchived = 0;
    @Indexed(direction = IndexDirection.ASCENDING)
    private String roles;
    @Indexed(direction = IndexDirection.ASCENDING)
    private String authorities;


    public  User(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public String getMail() {
        return mail;
    }

    public String getPhone() {
        return phone;
    }

    public String getPassword() {
        return password;
    }

    public int getStatus() {
        return status;
    }

    public int getIsArchived() {
        return isArchived;
    }

    public void setIsArchived(int isArchived) {
        this.isArchived = isArchived;
    }

    public String getRoles() {
        return roles;
    }

    public String getAuthorities() {
        return authorities;
    }

    public List<String> getRoleList(){

        if(this.roles != null && this.roles.length() > 0){
            return Arrays.asList(this.roles.split(","));
        }
        return new ArrayList<String>();
    }

    public List<String> getAuthoritieList(){

        if(this.authorities != null && this.authorities.length() > 0){
            return Arrays.asList(this.authorities.split(","));
        }
        return new ArrayList<String>();
    }


    public void setUsername(String username) {
        this.username = username;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setStatus(int status) {
        this.status = status;
    }
 /*
    public void setRoles(String roles) {
        this.roles = roles;
    }

    public void setAuthorities(String authorities) {
        this.authorities = authorities;
    }


  */
}
