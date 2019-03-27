package WS;

import entity.*;
import java.util.*;
import javax.jws.*;

@WebService
public interface AcountWS {
	
@WebMethod	
 public List<Acount> findAll();

@WebMethod	
public void create(Acount act);

@WebMethod
public void delete(Acount act);

@WebMethod
public void update(Acount act);


}
