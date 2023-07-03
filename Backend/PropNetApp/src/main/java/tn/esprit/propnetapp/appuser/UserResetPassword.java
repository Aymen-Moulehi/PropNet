package tn.esprit.propnetapp.appuser;

import lombok.Getter;
import lombok.Setter;
import org.aspectj.apache.bcel.classfile.Code;
import tn.esprit.propnetapp.Jwt.Token;



@Getter
@Setter
public class UserResetPassword {


    private String email;
    private String code;
    private String newPassword;
}
