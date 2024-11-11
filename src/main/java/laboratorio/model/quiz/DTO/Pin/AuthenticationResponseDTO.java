package laboratorio.model.quiz.DTO.Pin;

public class AuthenticationResponseDTO {
    private String jwt;

    public AuthenticationResponseDTO(String jwt) {
        this.jwt = jwt;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }
}