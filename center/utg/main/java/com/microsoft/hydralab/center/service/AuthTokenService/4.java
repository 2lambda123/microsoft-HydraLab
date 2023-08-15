import com.microsoft.hydralab.center.repository.AuthTokenRepository;
import com.microsoft.hydralab.common.entity.center.AuthToken;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Service
public class AuthTokenServiceTest {
@Mock
private AuthTokenRepository authTokenRepository;
@Mock
private SecurityUserService securityUserService;
@Mock
private HttpSession session;
private AuthTokenService authTokenService;
@Before
public void setup() {
 MockitoAnnotations.initMocks(this); authTokenService = new AuthTokenService(); authTokenService.authTokenRepository = authTokenRepository; authTokenService.securityUserService = securityUserService; 
}

@Test
public void testLoadDefaultUser() {
 AuthToken authToken = new AuthToken(); Mockito.when(authTokenRepository.save(Mockito.any(AuthToken.class))).thenReturn(authToken); authTokenService.loadDefaultUser(session); Mockito.verify(securityUserService).addDefaultUserSession(session); 
}

}
