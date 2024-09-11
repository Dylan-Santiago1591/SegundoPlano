import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class emailService {
    
    @Autowired
    private JavaMailSender javaMailSender;

    public String notificacionRegistro(usuario usuario){
        try{
            String asunto = "";
            String  cuerpo = "";
            var retorno = enviarCorreo(usuair.getCorreo(),asunto,cuerpo);
            if (retorno) {
                return "SE ENVIO CORRECTAMENTE";
            }else {
                return "NO SE PUDO ENVIAR";
            }
        }catch (Exception e){
            return "ERROR AL ENVIAR" +e.getMessage();
        }
    }

}
